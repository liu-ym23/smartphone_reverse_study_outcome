package ena;

import android.graphics.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f473241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f473242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f473244d;

    public final int hashCode() {
        return (((((this.f473241a * 31) + this.f473242b) * 31) + this.f473243c) * 31) + this.f473244d;
    }

    public final String toString() {
        return b.class.getSimpleName() + " { [" + this.f473241a + ',' + this.f473242b + ',' + this.f473243c + ',' + this.f473244d + "] }";
    }

    public b(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        int r101 = r100.left;
        int r102 = r100.top;
        int r103 = r100.right;
        int r104 = r100.bottom;
        this.f473241a = r101;
        this.f473242b = r102;
        this.f473243c = r103;
        this.f473244d = r104;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        Class<?> r101 = null;
    L10:
        if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L27;
        b r102 = (b) r100;
        if (this.f473241a == r102.f473241a) goto L17;
        return false;
    L17:
        if (this.f473242b == r102.f473242b) goto L20;
        return false;
    L20:
        if (this.f473243c == r102.f473243c) goto L23;
        return false;
    L23:
        if (this.f473244d == r102.f473244d) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.window.model.Bounds");
    L8:
        r101 = r100.getClass();
        goto L10
    }
}
