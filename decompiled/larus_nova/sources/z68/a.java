package z68;

import da9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f570529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f570530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f570531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f570532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f570533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f570534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f570535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f570536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f570537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f570538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f570539k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f570529a, r101.f570529a) == true) goto L12;
        return false;
    L12:
        if (this.f570530b == r101.f570530b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570531c, r101.f570531c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f570532d, r101.f570532d) == true) goto L21;
        return false;
    L21:
        if (this.f570533e == r101.f570533e) goto L24;
        return false;
    L24:
        if (this.f570534f == r101.f570534f) goto L27;
        return false;
    L27:
        if (this.f570535g == r101.f570535g) goto L30;
        return false;
    L30:
        if (this.f570536h == r101.f570536h) goto L33;
        return false;
    L33:
        if (this.f570537i == r101.f570537i) goto L36;
        return false;
    L36:
        if (this.f570538j == r101.f570538j) goto L39;
        return false;
    L39:
        if (this.f570539k == r101.f570539k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f570529a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f570530b;
        int r103 = ((((((((((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f570531c.hashCode()) * 31) + this.f570532d.hashCode()) * 31) + this.f570533e) * 31) + this.f570534f) * 31) + this.f570535g) * 31;
        if (this.f570536h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        long r106 = this.f570537i;
        return ((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f570538j) * 31) + this.f570539k;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActiveScreenShareMetrics(sessionId=" + this.f570529a + ", startElapsedMs=" + this.f570530b + ", startSource=" + this.f570531c + ", policy=" + this.f570532d + ", width=" + this.f570533e + ", height=" + this.f570534f + ", targetFps=" + this.f570535g + ", firstFrameReported=" + this.f570536h + ", fpsWindowStartElapsedMs=" + this.f570537i + ", captureFrameCount=" + this.f570538j + ", outputFrameCount=" + this.f570539k + ')';
    }

    public a(String r100, long r101, String r102, e r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r102, "startSource");
        Intrinsics.checkNotNullParameter(r103, "policy");
        this.f570529a = r100;
        this.f570530b = r101;
        this.f570531c = r102;
        this.f570532d = r103;
        this.f570533e = r104;
        this.f570534f = r105;
        this.f570535g = r106;
        this.f570536h = false;
        this.f570537i = 0;
        this.f570538j = 0;
        this.f570539k = 0;
    }
}
