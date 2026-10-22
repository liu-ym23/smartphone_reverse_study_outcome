package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public abstract enum FieldNamingPolicy extends Enum<FieldNamingPolicy> implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES = null;
    public static final FieldNamingPolicy IDENTITY = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES = null;
    public static final FieldNamingPolicy UPPER_CASE_WITH_UNDERSCORES = null;

    static {
        final String r100 = "IDENTITY";
        final int r101 = 0;
        FieldNamingPolicy r102 = new AnonymousClass1(r100, r101);
        IDENTITY = r102;
        final String r103 = "UPPER_CAMEL_CASE";
        final int r104 = 1;
        FieldNamingPolicy r105 = new AnonymousClass2(r103, r104);
        UPPER_CAMEL_CASE = r105;
        final String r106 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int r107 = 2;
        FieldNamingPolicy r108 = new AnonymousClass3(r106, r107);
        UPPER_CAMEL_CASE_WITH_SPACES = r108;
        final String r109 = "UPPER_CASE_WITH_UNDERSCORES";
        final int r110 = 3;
        FieldNamingPolicy r111 = new AnonymousClass4(r109, r110);
        UPPER_CASE_WITH_UNDERSCORES = r111;
        final String r112 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r113 = 4;
        FieldNamingPolicy r114 = new AnonymousClass5(r112, r113);
        LOWER_CASE_WITH_UNDERSCORES = r114;
        final String r115 = "LOWER_CASE_WITH_DASHES";
        final int r116 = 5;
        FieldNamingPolicy r117 = new AnonymousClass6(r115, r116);
        LOWER_CASE_WITH_DASHES = r117;
        final String r118 = "LOWER_CASE_WITH_DOTS";
        final int r119 = 6;
        FieldNamingPolicy r120 = new AnonymousClass7(r118, r119);
        LOWER_CASE_WITH_DOTS = r120;
        $VALUES = new FieldNamingPolicy[]{r102, r105, r108, r111, r114, r117, r120};
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    public static String upperCaseFirstLetter(String r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L16;
        char r103 = r100.charAt(r102);
        if (Character.isLetter(r103) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        if (Character.isUpperCase(r103) == false) goto L9;
        return r100;
    L9:
        char r104 = Character.toUpperCase(r103);
        if (r102 != 0) goto L14;
        return r104 + r100.substring(1);
    L14:
        return r100.substring(0, r102) + r104 + r100.substring(r102 + 1);
    L16:
        return r100;
    }

    public static FieldNamingPolicy valueOf(String r100) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, r100);
    }

    private FieldNamingPolicy(String r100, int r101) {
        super(r100, r101);
    }

    public static String separateCamelCase(String r100, char r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = r100.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        char r105 = r100.charAt(r104);
        if (Character.isUpperCase(r105) == false) goto L9;
        if (r102.length() == 0) goto L9;
        r102.append(r101);
    L9:
        r102.append(r105);
        r104 = r104 + 1;
        goto L3
    L11:
        return r102.toString();
    }

    public /* synthetic */ FieldNamingPolicy(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
