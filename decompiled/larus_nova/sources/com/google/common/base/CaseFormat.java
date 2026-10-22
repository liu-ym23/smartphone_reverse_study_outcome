package com.google.common.base;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract enum CaseFormat extends Enum<CaseFormat> {
    public static final CaseFormat LOWER_CAMEL = null;
    public static final CaseFormat LOWER_HYPHEN = null;
    public static final CaseFormat LOWER_UNDERSCORE = null;
    public static final CaseFormat UPPER_CAMEL = null;
    public static final CaseFormat UPPER_UNDERSCORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CaseFormat[] f274690a = null;
    private final b wordBoundary;
    private final String wordSeparator;

    public static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(String r100) {
            return this.targetFormat.to(this.sourceFormat, r100);
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public String doForward2(String r100) {
            return this.sourceFormat.to(this.targetFormat, r100);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof StringConverter) == false) goto L10;
            StringConverter r101 = (StringConverter) r100;
            if (this.sourceFormat.equals(r101.sourceFormat) == true) goto L7;
            return false;
        L7:
            if (this.targetFormat.equals(r101.targetFormat) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(String r100) {
            return doBackward2(r100);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doForward(String r100) {
            return doForward2(r100);
        }

        public StringConverter(CaseFormat r100, CaseFormat r101) {
            r100.getClass();
            this.sourceFormat = r100;
            r101.getClass();
            this.targetFormat = r101;
        }
    }

    public CaseFormat() {
        throw null;
    }

    public abstract String normalizeWord(String r100);

    static {
        final b.d r100 = new b.d('-');
        final String r101 = "LOWER_HYPHEN";
        final int r102 = 0;
        final String r103 = "-";
        CaseFormat r104 = new AnonymousClass1(r101, r102, r100, r103);
        LOWER_HYPHEN = r104;
        final b.d r105 = new b.d('_');
        final String r106 = "LOWER_UNDERSCORE";
        final int r107 = 1;
        final String r108 = "_";
        CaseFormat r109 = new AnonymousClass2(r106, r107, r105, r108);
        LOWER_UNDERSCORE = r109;
        final b.c r110 = new b.c();
        final String r111 = "LOWER_CAMEL";
        final int r112 = 2;
        final String r113 = "";
        CaseFormat r114 = new AnonymousClass3(r111, r112, r110, r113);
        LOWER_CAMEL = r114;
        final b.c r115 = new b.c();
        final String r116 = "UPPER_CAMEL";
        final int r117 = 3;
        CaseFormat r118 = new AnonymousClass4(r116, r117, r115, r113);
        UPPER_CAMEL = r118;
        final b.d r119 = new b.d('_');
        final String r120 = "UPPER_UNDERSCORE";
        final int r121 = 4;
        CaseFormat r122 = new AnonymousClass5(r120, r121, r119, r108);
        UPPER_UNDERSCORE = r122;
        f274690a = new CaseFormat[]{r104, r109, r114, r118, r122};
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) f274690a.clone();
    }

    public static String access$100(String r100) {
        if (r100.isEmpty() == true) goto L14;
        StringBuilder r101 = new StringBuilder();
        boolean r102 = false;
        char r103 = r100.charAt(0);
        if (r103 >= 'a') goto L8;
    L10:
        if (r102 == false) goto L12;
        r103 = (char) (r103 ^ ' ');
    L12:
        r101.append(r103);
        r101.append(a.a(r100.substring(1)));
        return r101.toString();
    L8:
        if (r103 > 'z') goto L10;
        r102 = true;
        goto L10
    L14:
        return r100;
    }

    public static CaseFormat valueOf(String r100) {
        return (CaseFormat) r27.a.a(CaseFormat.class, r100);
    }

    public Converter<String, String> converterTo(CaseFormat r100) {
        return new StringConverter(this, r100);
    }

    public String normalizeFirstWord(String r100) {
        return normalizeWord(r100);
    }

    public String convert(CaseFormat r100, String r101) {
        StringBuilder r102 = null;
        int r103 = 0;
        int r104 = -1;
    L3:
        r104 = this.wordBoundary.b(r101, r104 + 1);
        if (r104 == (-1)) goto L9;
        if (r103 != 0) goto L7;
        r102 = new StringBuilder(r101.length() + (r100.wordSeparator.length() * 4));
        r102.append(r100.normalizeFirstWord(r101.substring(r103, r104)));
    L8:
        r102.append(r100.wordSeparator);
        r103 = this.wordSeparator.length() + r104;
        goto L3
    L7:
        Objects.requireNonNull(r102);
        r102.append(r100.normalizeWord(r101.substring(r103, r104)));
        goto L8
    L9:
        if (r103 == 0) goto L16;
        Objects.requireNonNull(r102);
        r102.append(r100.normalizeWord(r101.substring(r103)));
        return r102.toString();
    L16:
        return r100.normalizeFirstWord(r101);
    }

    public final String to(CaseFormat r100, String r101) {
        r100.getClass();
        r101.getClass();
        if (r100 != this) goto L6;
        return r101;
    L6:
        return convert(r100, r101);
    }

    public CaseFormat(String r100, int r101, b r102, String r103, AnonymousClass1 r104) {
        super(r100, r101);
        this.wordBoundary = r102;
        this.wordSeparator = r103;
    }
}
