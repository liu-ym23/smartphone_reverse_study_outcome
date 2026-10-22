package tf4;

import com.baidu.mapapi.SDKInitializer;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f545733e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f545734f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f545735g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f545736h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f545737i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f545738j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f545739k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f545740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f545741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f545742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f545743d;

    static {
        f545733e = new a(0, "");
        f545734f = new a(-10001, "unexpected exception");
        f545735g = new a(-10002, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        f545736h = new a(-10004, "params is null");
        f545737i = new a(-10005, "params is illegal");
        f545738j = new a(-10006, "parse json error");
        f545739k = new a(-10007, "user cancel");
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("CJError{sdkErrCode=");
        r100.append(this.f545740a);
        r100.append(", bizFailCode=");
        String r101 = this.f545741b;
        if (r101 != null) goto L5;
        String r102 = "null";
    L6:
        r100.append(r102);
        r100.append(", msg='");
        String r103 = this.f545742c;
        if (r103 != null) goto L9;
        String r104 = "null";
    L10:
        r100.append(r104);
        r100.append("', throwable=");
        Throwable r105 = this.f545743d;
        if (r105 != null) goto L13;
        String r106 = "null";
    L14:
        r100.append(r106);
        r100.append(", extra=");
        r100.append("null");
        r100.append('}');
        return r100.toString();
    L13:
        r106 = r105.toString();
        goto L14
    L9:
        r104 = r103.toString();
        goto L10
    L5:
        r102 = r101.toString();
        goto L6
    }

    public a(int r100, String r101) {
        this(r100, "", r101);
    }

    public a(int r100, String r101, String r102) {
        this.f545743d = null;
        this.f545740a = r100;
        this.f545742c = r102;
        this.f545741b = r101;
    }
}
