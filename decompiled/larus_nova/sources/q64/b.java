package q64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f531786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f531787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Throwable f531788f;

    public final String toString() {
        return "BdpHostResponse(code=" + this.f531783a + ", message='" + this.f531784b + "', headers=" + this.f531786d + ",body=" + this.f531787e + ", throwable=" + this.f531788f + ')';
    }

    public b(int r100, String r101, String r102, c r103, e r104, Throwable r105) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "headers");
        this.f531783a = r100;
        this.f531784b = r101;
        this.f531785c = r102;
        this.f531786d = r103;
        this.f531787e = r104;
        this.f531788f = r105;
    }
}
