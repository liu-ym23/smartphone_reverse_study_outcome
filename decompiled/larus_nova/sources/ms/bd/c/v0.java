package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EGLDisplay f515395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EGLContext f515396b;

    public final void b() {
        EGLDisplay r100 = this.f515395a;
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L5;
        EGL14.eglDestroyContext(r100, this.f515396b);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.f515395a);
    L5:
        this.f515395a = EGL14.EGL_NO_DISPLAY;
        this.f515396b = EGL14.EGL_NO_CONTEXT;
    }

    public final void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.f515395a == EGL14.EGL_NO_DISPLAY) goto L5;
        b();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public v0() {
        EGLDisplay r100 = EGL14.EGL_NO_DISPLAY;
        this.f515395a = r100;
        this.f515396b = EGL14.EGL_NO_CONTEXT;
        if (r100 != EGL14.EGL_NO_DISPLAY) goto L31;
        EGLContext r101 = EGL14.EGL_NO_CONTEXT;
        EGLDisplay r102 = EGL14.eglGetDisplay(0);
        this.f515395a = r102;
        if (r102 == EGL14.EGL_NO_DISPLAY) goto L29;
        int[] r103 = new int[2];
        if (EGL14.eglInitialize(r102, r103, 0, r103, 1) == false) goto L26;
        EGLConfig r104 = a(3);
        if (r104 == null) goto L14;
        EGLContext r105 = EGL14.eglCreateContext(this.f515395a, r104, r101, new int[]{12440, 3, 12344}, 0);
        if (EGL14.eglGetError() != 12288) goto L14;
        this.f515396b = r105;
    L14:
        if (this.f515396b != EGL14.EGL_NO_CONTEXT) goto L24;
        EGLConfig r106 = a(2);
        if (r106 == null) goto L23;
        EGLContext r107 = EGL14.eglCreateContext(this.f515395a, r106, r101, new int[]{12440, 2, 12344}, 0);
        String r108 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2aa14c", new byte[]{38, 100, 30, 102, 25, 113, 48, 84, 53, 66, 44, 109, 6, 64, 19, 96});
        int r109 = EGL14.eglGetError();
        if (r109 != 12288) goto L21;
        this.f515396b = r107;
        goto L24
    L21:
        throw new RuntimeException(r108 + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ea2690", new byte[]{46, 35, 100, 101, 42, 103, 99, 82, 113, 105, 102, 57, 1, 18, 30})) + Integer.toHexString(r109));
    L23:
        throw new RuntimeException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "532263", new byte[]{17, 63, 64, 68, 5, 33, 118, 6, 108, 34, 34, 56, 79, 66, 73, 37, 118, 1, 118, 107, 48, 48, 67, 74, 12, 100, 19, 53, 79, 65, 43, 63, 71, 79, 14}));
    L24:
        EGL14.eglQueryContext(this.f515395a, this.f515396b, 12440, new int[1], 0);
        return;
    L26:
        this.f515395a = null;
        throw new RuntimeException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1a01ef", new byte[]{53, 109, 66, 71, 86, 116, 114, 84, 110, 33, 41, 109, 74, 81, 83, 112, 62, 73, 123, 100, 96, 70, 100, 105, 11, 37}));
    L29:
        throw new RuntimeException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a86f90", new byte[]{101, 52, 68, 16, 10, 34, 34, HTTP.CR, 104, 118, 119, 63, 81, 82, 35, 0, 78, 72, 51, 118, 116, 51, 86, 2, 10, 38, 123}));
    L31:
        throw new RuntimeException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cdf379", new byte[]{87, 65, 57, 7, 9, 34, 114, 64, 54, 103, 107, 38, 6, 66, 28, 110, 117, 85}));
    }

    public final EGLConfig a(int r110) {
        if (r110 < 3) goto L5;
        int r111 = 68;
    L6:
        int[] r100 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r111, 12344, 0, 12344};
        EGLConfig[] r112 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f515395a, r100, 0, r112, 0, 1, new int[1], 0) == true) goto L11;
        return null;
    L11:
        return r112[0];
    L5:
        r111 = 4;
        goto L6
    }

    public final void c(EGLSurface r100) {
        if (EGL14.eglMakeCurrent(this.f515395a, r100, r100, this.f515396b) == false) goto L6;
        return;
    L6:
        throw new RuntimeException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5bafab", new byte[]{33, 103, 30, 63, 95, 126, 51, 96, 37, 36, 54, 101, 28, 6, 30, 115, 55, 74, 60, 51, 32}));
    }
}
