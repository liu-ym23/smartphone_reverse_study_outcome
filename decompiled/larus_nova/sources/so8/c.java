package so8;

import android.graphics.Rect;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f542739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f542740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ZoomInAnimationEnqueueStrategy f542741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ZoomInAnimationEndStrategy f542742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f542743e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f542739a == r101.f542739a) goto L12;
        return false;
    L12:
        if (this.f542740b == r101.f542740b) goto L15;
        return false;
    L15:
        if (this.f542741c == r101.f542741c) goto L18;
        return false;
    L18:
        if (this.f542742d == r101.f542742d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f542743e, r101.f542743e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f542739a * 31;
        long r101 = this.f542740b;
        return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f542741c.hashCode()) * 31) + this.f542742d.hashCode()) * 31) + this.f542743e.hashCode();
    }

    public final String toString() {
        return "ZoomInAnimationConfig(height=" + this.f542739a + ", duration=" + this.f542740b + ", enqueueStrategy=" + this.f542741c + ", animationEndStrategy=" + this.f542742d + ", marginRect=" + this.f542743e + ')';
    }

    public c(int r100, ZoomInAnimationEnqueueStrategy r101, ZoomInAnimationEndStrategy r102, Rect r103) {
        Intrinsics.checkNotNullParameter(r101, "enqueueStrategy");
        Intrinsics.checkNotNullParameter(r102, "animationEndStrategy");
        Intrinsics.checkNotNullParameter(r103, "marginRect");
        this.f542739a = r100;
        this.f542740b = 1000;
        this.f542741c = r101;
        this.f542742d = r102;
        this.f542743e = r103;
    }
}
