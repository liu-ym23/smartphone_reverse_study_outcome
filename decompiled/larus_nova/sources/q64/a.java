package q64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f531775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f531776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f531777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f531778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f531779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f531780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f531781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f531782j;

    /* JADX INFO: renamed from: q64.a$a, reason: collision with other inner class name */
    public static final class C7283a {
    }

    static {
    }

    public final String toString() {
        return "BdpHostRequest(url='" + this.f531773a + "', method='" + this.f531774b + "', responseStreaming=" + this.f531775c + ", addHostCommonParams=" + this.f531776d + ", addHostMd5Stub=" + this.f531777e + ", headers=" + this.f531778f + ", requestBody=" + this.f531779g + ", connectTimeOut=" + this.f531780h + ", readTimeOut=" + this.f531781i + ", writeTimeOut=" + this.f531782j + ')';
    }

    public a(String r100, String r101, boolean r102, boolean r103, boolean r104, c r105, d r106, long r107, long r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r105, "headers");
        this.f531773a = r100;
        this.f531774b = r101;
        this.f531775c = r102;
        this.f531776d = r103;
        this.f531777e = r104;
        this.f531778f = r105;
        this.f531779g = r106;
        this.f531780h = r107;
        this.f531781i = r110;
        this.f531782j = r111;
    }
}
