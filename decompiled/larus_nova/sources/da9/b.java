package da9;

import com.larus.flow.capture.model.PixelFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f467715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f467716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f467717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f467718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PixelFormat f467719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f467720g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f467714a, r101.f467714a) == true) goto L12;
        return false;
    L12:
        if (this.f467715b == r101.f467715b) goto L15;
        return false;
    L15:
        if (this.f467716c == r101.f467716c) goto L18;
        return false;
    L18:
        if (this.f467717d == r101.f467717d) goto L21;
        return false;
    L21:
        if (this.f467718e == r101.f467718e) goto L24;
        return false;
    L24:
        if (this.f467719f == r101.f467719f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f467720g, r101.f467720g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f467714a.hashCode() * 31;
        long r101 = this.f467715b;
        return ((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f467716c) * 31) + this.f467717d) * 31) + this.f467718e) * 31) + this.f467719f.hashCode()) * 31) + this.f467720g.hashCode();
    }

    public final String toString() {
        return "RawFrame(sessionId=" + this.f467714a + ", ptsMs=" + this.f467715b + ", width=" + this.f467716c + ", height=" + this.f467717d + ", rotation=" + this.f467718e + ", pixelFormat=" + this.f467719f + ", buffer=" + this.f467720g + ')';
    }

    public b(String r100, long r101, int r102, int r103, int r104, PixelFormat r105, a r106) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r105, "pixelFormat");
        Intrinsics.checkNotNullParameter(r106, "buffer");
        this.f467714a = r100;
        this.f467715b = r101;
        this.f467716c = r102;
        this.f467717d = r103;
        this.f467718e = r104;
        this.f467719f = r105;
        this.f467720g = r106;
    }
}
