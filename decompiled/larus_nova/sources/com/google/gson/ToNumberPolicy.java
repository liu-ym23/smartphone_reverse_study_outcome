package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public abstract enum ToNumberPolicy extends Enum<ToNumberPolicy> implements ToNumberStrategy {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES = null;
    public static final ToNumberPolicy BIG_DECIMAL = null;
    public static final ToNumberPolicy DOUBLE = null;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER = null;
    public static final ToNumberPolicy LONG_OR_DOUBLE = null;

    static {
        final String r100 = "DOUBLE";
        final int r101 = 0;
        ToNumberPolicy r102 = new AnonymousClass1(r100, r101);
        DOUBLE = r102;
        final String r103 = "LAZILY_PARSED_NUMBER";
        final int r104 = 1;
        ToNumberPolicy r105 = new AnonymousClass2(r103, r104);
        LAZILY_PARSED_NUMBER = r105;
        final String r106 = "LONG_OR_DOUBLE";
        final int r107 = 2;
        ToNumberPolicy r108 = new AnonymousClass3(r106, r107);
        LONG_OR_DOUBLE = r108;
        final String r109 = "BIG_DECIMAL";
        final int r110 = 3;
        ToNumberPolicy r111 = new AnonymousClass4(r109, r110);
        BIG_DECIMAL = r111;
        $VALUES = new ToNumberPolicy[]{r102, r105, r108, r111};
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    public static ToNumberPolicy valueOf(String r100) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, r100);
    }

    private ToNumberPolicy(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ ToNumberPolicy(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
