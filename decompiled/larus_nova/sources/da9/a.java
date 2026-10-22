package da9;

import android.opengl.EGLContext;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f467711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f467712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EGLContext f467713c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f467711a == r101.f467711a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467712b, r101.f467712b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f467713c, r101.f467713c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f467711a * 31;
        float[] r101 = this.f467712b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        EGLContext r105 = this.f467713c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = Arrays.hashCode(r101);
        goto L6
    }

    public final String toString() {
        return "FrameBuffer(textureId=" + this.f467711a + ", textureMatrix=" + Arrays.toString(this.f467712b) + ", eglContext=" + this.f467713c + ')';
    }

    public a(int r100, float[] r101, EGLContext r102) {
        this.f467711a = r100;
        this.f467712b = r101;
        this.f467713c = r102;
    }
}
