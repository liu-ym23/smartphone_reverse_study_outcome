package r3a;

import android.opengl.EGLContext;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f535930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f535931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f535932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f535933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f535934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EGLContext f535935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VideoFrameBufferType f535936h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f535929a == r101.f535929a) goto L12;
        return false;
    L12:
        if (this.f535930b == r101.f535930b) goto L15;
        return false;
    L15:
        if (this.f535931c == r101.f535931c) goto L18;
        return false;
    L18:
        if (this.f535932d == r101.f535932d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f535933e, r101.f535933e) == true) goto L24;
        return false;
    L24:
        if (this.f535934f == r101.f535934f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f535935g, r101.f535935g) == true) goto L30;
        return false;
    L30:
        if (this.f535936h == r101.f535936h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f535929a * 31) + this.f535930b) * 31) + this.f535931c) * 31;
        long r101 = this.f535932d;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Arrays.hashCode(this.f535933e)) * 31) + this.f535934f) * 31;
        EGLContext r103 = this.f535935g;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f535936h.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "CameraFrameWrapper(textureId=" + this.f535929a + ", width=" + this.f535930b + ", height=" + this.f535931c + ", timestamp=" + this.f535932d + ", transformMatrix=" + Arrays.toString(this.f535933e) + ", rotation=" + this.f535934f + ", glCtx=" + this.f535935g + ", bufferType=" + this.f535936h + ')';
    }

    public j(int r100, long r101, float[] r102, int r103, EGLContext r104, VideoFrameBufferType r105) {
        Intrinsics.checkNotNullParameter(r102, "transformMatrix");
        Intrinsics.checkNotNullParameter(r105, "bufferType");
        this.f535929a = r100;
        this.f535930b = 720;
        this.f535931c = 1280;
        this.f535932d = r101;
        this.f535933e = r102;
        this.f535934f = r103;
        this.f535935g = r104;
        this.f535936h = r105;
    }
}
