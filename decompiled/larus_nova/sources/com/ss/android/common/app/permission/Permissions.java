package com.ss.android.common.app.permission;

/* JADX INFO: loaded from: classes34.dex */
final enum Permissions extends Enum<Permissions> {
    public static final Permissions DENIED = null;
    public static final Permissions GRANTED = null;
    public static final Permissions NOT_FOUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Permissions[] f407993a = null;

    static {
        Permissions r100 = new Permissions("GRANTED", 0);
        GRANTED = r100;
        Permissions r101 = new Permissions("DENIED", 1);
        DENIED = r101;
        Permissions r102 = new Permissions("NOT_FOUND", 2);
        NOT_FOUND = r102;
        f407993a = new Permissions[]{r100, r101, r102};
    }

    public static Permissions[] values() {
        return (Permissions[]) f407993a.clone();
    }

    public static Permissions valueOf(String r100) {
        return (Permissions) r27.a.a(Permissions.class, r100);
    }

    public Permissions(String r100, int r101) {
        super(r100, r101);
    }
}
