package so8;

import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f542758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ZoomInAnimationAction f542759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IZoomInAnimationProvider f542760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f542761e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f542757a, r101.f542757a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542758b, r101.f542758b) == true) goto L15;
        return false;
    L15:
        if (this.f542759c == r101.f542759c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f542760d, r101.f542760d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f542761e, r101.f542761e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f542757a.hashCode() * 31) + this.f542758b.hashCode()) * 31) + this.f542759c.hashCode()) * 31) + this.f542760d.hashCode()) * 31) + this.f542761e.hashCode();
    }

    public final String toString() {
        return "ZoomInAnimationItem(animationID=" + this.f542757a + ", input=" + this.f542758b + ", action=" + this.f542759c + ", zoomInAnimationProvider=" + this.f542760d + ", zoomInConfig=" + this.f542761e + ')';
    }

    public static k a(k r100, ZoomInAnimationAction r101) {
        String r102 = r100.f542757a;
        j r103 = r100.f542758b;
        IZoomInAnimationProvider r104 = r100.f542760d;
        c r105 = r100.f542761e;
        Intrinsics.checkNotNullParameter(r102, "animationID");
        Intrinsics.checkNotNullParameter(r103, "input");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r104, "zoomInAnimationProvider");
        Intrinsics.checkNotNullParameter(r105, "zoomInConfig");
        return new k(r102, r103, r101, r104, r105);
    }

    public k(String r100, j r101, ZoomInAnimationAction r102, IZoomInAnimationProvider r103, c r104) {
        Intrinsics.checkNotNullParameter(r100, "animationID");
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "zoomInAnimationProvider");
        Intrinsics.checkNotNullParameter(r104, "zoomInConfig");
        this.f542757a = r100;
        this.f542758b = r101;
        this.f542759c = r102;
        this.f542760d = r103;
        this.f542761e = r104;
    }
}
