package eka;

import androidx.camera.video.AudioStats;
import androidx.core.util.Pools;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pools.SynchronizedPool<b> f472955n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f472956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f472957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f472958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f472959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f472960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f472961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f472962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f472963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f472964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f472965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f472966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f472967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f472968m;

    public static final class a {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(Double.valueOf(this.f472956a), Double.valueOf(r101.f472956a)) == true) goto L12;
        return false;
    L12:
        if (this.f472957b == r101.f472957b) goto L15;
        return false;
    L15:
        if (this.f472958c == r101.f472958c) goto L18;
        return false;
    L18:
        if (this.f472959d == r101.f472959d) goto L21;
        return false;
    L21:
        if (this.f472960e == r101.f472960e) goto L24;
        return false;
    L24:
        if (this.f472961f == r101.f472961f) goto L27;
        return false;
    L27:
        if (this.f472962g == r101.f472962g) goto L30;
        return false;
    L30:
        if (this.f472963h == r101.f472963h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(Double.valueOf(this.f472964i), Double.valueOf(r101.f472964i)) == true) goto L36;
        return false;
    L36:
        if (this.f472965j == r101.f472965j) goto L39;
        return false;
    L39:
        if (this.f472966k == r101.f472966k) goto L42;
        return false;
    L42:
        if (this.f472967l == r101.f472967l) goto L45;
        return false;
    L45:
        if (this.f472968m == r101.f472968m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f472956a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f472957b;
        int r103 = (((((((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f472958c) * 31) + this.f472959d) * 31) + this.f472960e) * 31) + this.f472961f) * 31) + this.f472962g) * 31) + this.f472963h) * 31;
        long r104 = Double.doubleToLongBits(this.f472964i);
        return ((((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f472965j) * 31) + this.f472966k) * 31) + this.f472967l) * 31) + this.f472968m;
    }

    static {
        f472955n = new Pools.SynchronizedPool(5);
    }

    public final String toString() {
        return "FpsBean(fps=" + this.f472956a + ", duration=" + this.f472957b + ", startX=" + this.f472958c + ", startY=" + this.f472959d + ", endX=" + this.f472960e + ", endY=" + this.f472961f + ", distantX=" + this.f472962g + ", distantY=" + this.f472963h + ", dropRate=" + this.f472964i + ", frameCount=" + this.f472965j + ", drop3=" + this.f472966k + ", drop7=" + this.f472967l + ", drop25=" + this.f472968m + ')';
    }

    public b(int r100) {
        this.f472956a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f472957b = 0;
        this.f472958c = 0;
        this.f472959d = 0;
        this.f472960e = 0;
        this.f472961f = 0;
        this.f472962g = 0;
        this.f472963h = 0;
        this.f472964i = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f472965j = 0;
        this.f472966k = 0;
        this.f472967l = 0;
        this.f472968m = 0;
    }
}
