package com.huawei.hms.push;

/* JADX INFO: loaded from: classes23.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f277615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f277616b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f277617c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f277618d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ k[] f277619e = null;

    static {
        k r100 = new k("STYLE_DEFAULT", 0);
        f277615a = r100;
        k r101 = new k("STYLE_BIGTEXT", 1);
        f277616b = r101;
        k r102 = new k("STYLE_BIGPICTURE", 2);
        f277617c = r102;
        k r103 = new k("STYLE_INBOX", 3);
        f277618d = r103;
        f277619e = new k[]{r100, r101, r102, r103};
    }

    public static k[] values() {
        return (k[]) f277619e.clone();
    }

    public static k valueOf(String r100) {
        return (k) r27.a.a(k.class, r100);
    }

    private k(String r100, int r101) {
        super(r100, r101);
    }
}
