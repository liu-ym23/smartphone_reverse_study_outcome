package t98;

import com.larus.avlink.gallery.power.policy.AlbumPowerLevel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AlbumPowerLevel f545106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f545107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f545108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f545109d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f545106a == r101.f545106a) goto L12;
        return false;
    L12:
        if (this.f545107b == r101.f545107b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545108c, r101.f545108c) == true) goto L18;
        return false;
    L18:
        if (this.f545109d == r101.f545109d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f545106a.hashCode() * 31) + this.f545107b) * 31) + this.f545108c.hashCode()) * 31;
        long r101 = this.f545109d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "AlbumPowerDecision(level=" + this.f545106a + ", videoThreadCount=" + this.f545107b + ", reasons=" + this.f545108c + ", decidedAtElapsedMs=" + this.f545109d + ')';
    }

    public a(AlbumPowerLevel r100, int r101, List<String> r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r102, "reasons");
        this.f545106a = r100;
        this.f545107b = r101;
        this.f545108c = r102;
        this.f545109d = r103;
    }
}
