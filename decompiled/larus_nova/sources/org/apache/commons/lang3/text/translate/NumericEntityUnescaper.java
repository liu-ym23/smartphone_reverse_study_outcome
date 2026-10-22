package org.apache.commons.lang3.text.translate;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class NumericEntityUnescaper extends CharSequenceTranslator {
    private final EnumSet<OPTION> options;

    public static final enum OPTION extends Enum<OPTION> {
        private static final /* synthetic */ OPTION[] $VALUES = null;
        public static final OPTION errorIfNoSemiColon = null;
        public static final OPTION semiColonOptional = null;
        public static final OPTION semiColonRequired = null;

        static {
            OPTION r100 = new OPTION("semiColonRequired", 0);
            semiColonRequired = r100;
            OPTION r101 = new OPTION("semiColonOptional", 1);
            semiColonOptional = r101;
            OPTION r102 = new OPTION("errorIfNoSemiColon", 2);
            errorIfNoSemiColon = r102;
            $VALUES = new OPTION[]{r100, r101, r102};
        }

        public static OPTION[] values() {
            return (OPTION[]) $VALUES.clone();
        }

        public static OPTION valueOf(String r100) {
            return (OPTION) a.a(OPTION.class, r100);
        }

        private OPTION(String r100, int r101) {
            super(r100, r101);
        }
    }

    public NumericEntityUnescaper(OPTION... r100) {
        if (r100.length <= 0) goto L5;
        this.options = EnumSet.copyOf(Arrays.asList(r100));
        return;
    L5:
        this.options = EnumSet.copyOf(Arrays.asList(new OPTION[]{OPTION.semiColonRequired}));
    }

    public boolean isSet(OPTION r100) {
        EnumSet<OPTION> r101 = this.options;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100) == false) goto L7;
        return true;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r110) throws IOException {
        int r102 = r100.length();
        if (r100.charAt(r101) == '&') goto L5;
    L56:
        return 0;
    L5:
        if (r101 >= (r102 - 2)) goto L56;
        if (r100.charAt(r101 + 1) != '#') goto L56;
        int r103 = r101 + 2;
        char r104 = r100.charAt(r103);
        if (r104 != 'x') goto L11;
    L14:
        r103 = r103 + 1;
        if (r103 != r102) goto L17;
        return 0;
    L17:
        int r105 = 1;
    L18:
        int r106 = r103;
    L19:
        if (r106 >= r102) goto L33;
        if (r100.charAt(r106) < '0') goto L25;
        if (r100.charAt(r106) > '9') goto L25;
    L32:
        r106 = r106 + 1;
    L25:
        if (r100.charAt(r106) < 'a') goto L29;
        if (r100.charAt(r106) <= 'f') goto L32;
    L29:
        if (r100.charAt(r106) < 'A') goto L33;
        if (r100.charAt(r106) <= 'F') goto L32;
    L33:
        if (r106 != r102) goto L35;
    L37:
        int r107 = 0;
    L38:
        if (r107 == 0) goto L40;
    L58:
        if (r105 == 0) goto L49;
        int r108 = CastIntegerProtector.parseInt(r100.subSequence(r103, r106).toString(), 16);     // Catch: NumberFormatException -> L57
    L50:
        if (r108 <= 65535) goto L53;
        char[] r109 = Character.toChars(r108);
        r110.write(r109[0]);
        r110.write(r109[1]);
    L55:
        return (((r106 + 2) - r103) + r105) + r107;
    L53:
        r110.write(r108);
        goto L55
    L49:
        r108 = CastIntegerProtector.parseInt(r100.subSequence(r103, r106).toString(), 10);     // Catch: NumberFormatException -> L57
        goto L50
    L40:
        if (isSet(OPTION.semiColonRequired) == false) goto L43;
        return 0;
    L43:
        if (isSet(OPTION.errorIfNoSemiColon) == false) goto L58;
        throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
    L35:
        if (r100.charAt(r106) != ';') goto L37;
        r107 = 1;
        goto L38
    L11:
        if (r104 == 'X') goto L14;
        r105 = 0;
        goto L18
    }
}
