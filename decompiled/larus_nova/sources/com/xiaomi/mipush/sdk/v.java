package com.xiaomi.mipush.sdk;

/* JADX INFO: loaded from: classes41.dex */
public final enum v extends Enum<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f463095a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ v[] f202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f463096b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f463097c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f463098d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f463099e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f463100f = null;

    static {
        v r100 = new v("DISABLE_PUSH", 0);
        f463095a = r100;
        v r101 = new v("ENABLE_PUSH", 1);
        f463096b = r101;
        v r102 = new v("UPLOAD_HUAWEI_TOKEN", 2);
        f463097c = r102;
        v r103 = new v("UPLOAD_FCM_TOKEN", 3);
        f463098d = r103;
        v r104 = new v("UPLOAD_COS_TOKEN", 4);
        f463099e = r104;
        v r105 = new v("UPLOAD_FTOS_TOKEN", 5);
        f463100f = r105;
        f202a = new v[]{r100, r101, r102, r103, r104, r105};
    }

    public static v[] values() {
        return (v[]) f202a.clone();
    }

    public static v valueOf(String r100) {
        return (v) r27.a.a(v.class, r100);
    }

    private v(String r100, int r101) {
        super(r100, r101);
    }
}
