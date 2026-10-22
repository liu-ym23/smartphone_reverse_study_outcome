package qi6;

import java.util.Arrays;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EGLContext f533165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final android.opengl.EGLContext f533166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f533167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f533168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f533169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f533170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer[] f533171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer[] f533172h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L22;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f533165a, r101.f533165a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f533166b, r101.f533166b) == true) goto L10;
        return false;
    L10:
        if (this.f533167c == r101.f533167c) goto L12;
        return false;
    L12:
        if (this.f533168d == r101.f533168d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f533169e, r101.f533169e) == true) goto L16;
        return false;
    L16:
        if (this.f533170f == r101.f533170f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f533171g, r101.f533171g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f533172h, r101.f533172h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public final int hashCode() {
        EGLContext r100 = this.f533165a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        android.opengl.EGLContext r104 = this.f533166b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f533167c) * 31;
        boolean r107 = this.f533168d;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        float[] r110 = this.f533169e;
        if (r110 == null) goto L16;
        int r111 = Arrays.hashCode(r110);
    L17:
        int r112 = (((r109 + r111) * 31) + this.f533170f) * 31;
        Integer[] r113 = this.f533171g;
        if (r113 == null) goto L20;
        int r114 = Arrays.hashCode(r113);
    L21:
        int r115 = (r112 + r114) * 31;
        Integer[] r116 = this.f533172h;
        if (r116 == null) goto L25;
        r101 = Arrays.hashCode(r116);
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TexFrameData(eglContext=" + this.f533165a + ", eglContext14=" + this.f533166b + ", texId=" + this.f533167c + ", isOES=" + this.f533168d + ", texMatrix=" + Arrays.toString(this.f533169e) + ", hwContext=" + this.f533170f + ", yuvTexId=" + Arrays.toString(this.f533171g) + ", yuvTexStride=" + Arrays.toString(this.f533172h) + ")";
    }

    public d(int r100, boolean r101, float[] r102) {
        this.f533165a = null;
        this.f533166b = null;
        this.f533167c = r100;
        this.f533168d = r101;
        this.f533169e = r102;
        this.f533170f = 0;
        this.f533171g = null;
        this.f533172h = null;
    }
}
