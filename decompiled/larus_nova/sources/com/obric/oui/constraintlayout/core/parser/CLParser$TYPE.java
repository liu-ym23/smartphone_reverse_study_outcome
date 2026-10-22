package com.obric.oui.constraintlayout.core.parser;

import faceverify.q;

/* JADX INFO: loaded from: classes34.dex */
final enum CLParser$TYPE extends Enum<CLParser$TYPE> {
    public static final CLParser$TYPE ARRAY = null;
    public static final CLParser$TYPE KEY = null;
    public static final CLParser$TYPE NUMBER = null;
    public static final CLParser$TYPE OBJECT = null;
    public static final CLParser$TYPE STRING = null;
    public static final CLParser$TYPE TOKEN = null;
    public static final CLParser$TYPE UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CLParser$TYPE[] f399678a = null;

    static {
        CLParser$TYPE r100 = new CLParser$TYPE("UNKNOWN", 0);
        UNKNOWN = r100;
        CLParser$TYPE r101 = new CLParser$TYPE("OBJECT", 1);
        OBJECT = r101;
        CLParser$TYPE r102 = new CLParser$TYPE("ARRAY", 2);
        ARRAY = r102;
        CLParser$TYPE r103 = new CLParser$TYPE("NUMBER", 3);
        NUMBER = r103;
        CLParser$TYPE r104 = new CLParser$TYPE("STRING", 4);
        STRING = r104;
        CLParser$TYPE r105 = new CLParser$TYPE("KEY", 5);
        KEY = r105;
        CLParser$TYPE r110 = new CLParser$TYPE(q.KEY_TOKEN, 6);
        TOKEN = r110;
        f399678a = new CLParser$TYPE[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static CLParser$TYPE[] values() {
        return (CLParser$TYPE[]) f399678a.clone();
    }

    public static CLParser$TYPE valueOf(String r100) {
        return (CLParser$TYPE) r27.a.a(CLParser$TYPE.class, r100);
    }

    public CLParser$TYPE(String r100, int r101) {
        super(r100, r101);
    }
}
