package tf9;

import android.opengl.EGLContext;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EGLContext f545777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f545778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f545779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f545780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f545781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f545782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f545783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f545784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoFrameBufferType f545785i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f545777a, r101.f545777a) == true) goto L12;
        return false;
    L12:
        if (this.f545778b == r101.f545778b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545779c, r101.f545779c) == true) goto L18;
        return false;
    L18:
        if (this.f545780d == r101.f545780d) goto L21;
        return false;
    L21:
        if (this.f545781e == r101.f545781e) goto L24;
        return false;
    L24:
        if (this.f545782f == r101.f545782f) goto L27;
        return false;
    L27:
        if (this.f545783g == r101.f545783g) goto L30;
        return false;
    L30:
        if (this.f545784h == r101.f545784h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        EGLContext r100 = this.f545777a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f545778b) * 31;
        float[] r104 = this.f545779c;
        if (r104 == null) goto L10;
        r101 = Arrays.hashCode(r104);
    L10:
        int r105 = (((((((r103 + r101) * 31) + this.f545780d) * 31) + this.f545781e) * 31) + this.f545782f) * 31;
        long r106 = this.f545783g;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        if (this.f545784h == false) goto L13;
        int r108 = 1231;
    L15:
        return r107 + r108;
    L13:
        r108 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoFrameParam(eglContext=" + this.f545777a + ", textureId=" + this.f545778b + ", textureMatrix=" + Arrays.toString(this.f545779c) + ", width=" + this.f545780d + ", height=" + this.f545781e + ", rotation=" + this.f545782f + ", timeUs=" + this.f545783g + ", isFirstFrame=" + this.f545784h + ')';
    }

    public static b a(b r110, long r111, int r112) {
        float[] r100 = null;
        if ((r112 & 1) == 0) goto L5;
        EGLContext r101 = r110.f545777a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r102 = r110.f545778b;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r100 = r110.f545779c;
    L13:
        float[] r103 = r100;
        if ((r112 & 8) == 0) goto L16;
        int r104 = r110.f545780d;
    L18:
        if ((r112 & 16) == 0) goto L20;
        int r105 = r110.f545781e;
    L22:
        if ((r112 & 32) == 0) goto L24;
        int r106 = r110.f545782f;
    L26:
        if ((r112 & 64) == 0) goto L28;
        r111 = r110.f545783g;
    L28:
        long r107 = r111;
        if ((r112 & 128) == 0) goto L31;
        boolean r113 = r110.f545784h;
    L33:
        return new b(r101, r102, r103, r104, r105, r106, r107, r113);
    L31:
        r113 = false;
        goto L33
    L24:
        r106 = 0;
        goto L26
    L20:
        r105 = 0;
        goto L22
    L16:
        r104 = 0;
        goto L18
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public b(EGLContext r100, int r101, float[] r102, int r103, int r104, int r105, long r106, boolean r107) {
        this.f545777a = r100;
        this.f545778b = r101;
        this.f545779c = r102;
        this.f545780d = r103;
        this.f545781e = r104;
        this.f545782f = r105;
        this.f545783g = r106;
        this.f545784h = r107;
        this.f545785i = VideoFrameBufferType.GL_TEXTURE;
    }
}
