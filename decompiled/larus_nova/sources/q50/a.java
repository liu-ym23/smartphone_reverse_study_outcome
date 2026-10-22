package q50;

import android.opengl.GLSurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GLSurfaceView f531720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n50.a f531721b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f531720a, r101.f531720a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f531721b, r101.f531721b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        GLSurfaceView r100 = this.f531720a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        n50.a r104 = this.f531721b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnimationLayer(view=" + this.f531720a + ", scene=" + this.f531721b + ")";
    }

    public a(GLSurfaceView r100, n50.a r101) {
        this.f531720a = r100;
        this.f531721b = r101;
    }
}
