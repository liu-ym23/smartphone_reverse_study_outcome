package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes34.dex */
final enum CLToken$Type extends Enum<CLToken$Type> {
    public static final CLToken$Type FALSE = null;
    public static final CLToken$Type NULL = null;
    public static final CLToken$Type TRUE = null;
    public static final CLToken$Type UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CLToken$Type[] f399679a = null;

    static {
        CLToken$Type r100 = new CLToken$Type("UNKNOWN", 0);
        UNKNOWN = r100;
        CLToken$Type r101 = new CLToken$Type("TRUE", 1);
        TRUE = r101;
        CLToken$Type r102 = new CLToken$Type("FALSE", 2);
        FALSE = r102;
        CLToken$Type r103 = new CLToken$Type("NULL", 3);
        NULL = r103;
        f399679a = new CLToken$Type[]{r100, r101, r102, r103};
    }

    public static CLToken$Type[] values() {
        return (CLToken$Type[]) f399679a.clone();
    }

    public static CLToken$Type valueOf(String r100) {
        return (CLToken$Type) r27.a.a(CLToken$Type.class, r100);
    }

    public CLToken$Type(String r100, int r101) {
        super(r100, r101);
    }
}
