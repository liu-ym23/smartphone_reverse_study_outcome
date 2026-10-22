package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public abstract class CharSequenceTranslator {
    static final char[] HEX_DIGITS = null;

    public CharSequenceTranslator() {
    }

    public abstract int translate(CharSequence r100, int r101, Writer r102) throws IOException;

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String hex(int r100) {
        return Integer.toHexString(r100).toUpperCase(Locale.ENGLISH);
    }

    public final String translate(CharSequence r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        StringWriter r101 = new StringWriter(r100.length() * 2);     // Catch: IOException -> L7
        translate(r100, r101);     // Catch: IOException -> L7
        return r101.toString();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final void translate(CharSequence r100, Writer r101) throws IOException {
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        Validate.isTrue(r102, "The Writer must not be null", new Object[0]);
        if (r100 != null) goto L9;
        return;
    L9:
        int r103 = r100.length();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L22;
        int r105 = translate(r100, r104, r101);
        if (r105 == 0) goto L13;
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L10;
        r104 = r104 + Character.charCount(Character.codePointAt(r100, r104));
        r106 = r106 + 1;
        goto L20
    L13:
        char r107 = r100.charAt(r104);
        r101.write(r107);
        r104 = r104 + 1;
        if (Character.isHighSurrogate(r107) == false) goto L10;
        if (r104 >= r103) goto L10;
        char r108 = r100.charAt(r104);
        if (Character.isLowSurrogate(r108) == false) goto L10;
        r101.write(r108);
        r104 = r104 + 1;
        goto L10
    L22:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
