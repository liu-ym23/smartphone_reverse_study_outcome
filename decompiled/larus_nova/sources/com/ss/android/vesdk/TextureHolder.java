package com.ss.android.vesdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.SystemClock;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public final class TextureHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f455503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f455504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f455505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455506d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SurfaceTextureStatus {
        public static final int ATTACHED = 0;
        public static final int DETACHED = 1;
        public static final int UNINIT = -1;
    }

    public class a implements SurfaceTexture.OnFrameAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextureHolder f455507a;

        public a(TextureHolder r100) {
            this.f455507a = r100;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public final void onFrameAvailable(SurfaceTexture r100) {
            this.f455507a.getClass();
        }
    }

    public final void a() {
        if (1 != this.f455506d) goto L6;
        VELogUtil.i("TextureHolder", "attachToGLContext, texture id = " + this.f455503a);
        this.f455504b.attachToGLContext(this.f455503a);
        this.f455506d = 0;
        return;
    }

    public final boolean b() {
        VELogUtil.i("TextureHolder", "createOESTextureIfNeed, mSurfaceTextureStatus = " + this.f455506d + ", mSurfaceTextureID = " + this.f455503a);
        if (this.f455506d == 1) goto L5;
        return false;
    L5:
        if (this.f455503a != 0) goto L10;
        this.f455503a = cfc.a.a();
        return true;
    L10:
        return false;
    }

    public final void d() {
        if (this.f455506d != 0) goto L11;
        this.f455506d = 1;
        if (Build.VERSION.SDK_INT >= 26) goto L7;
    L9:
        this.f455504b.detachFromGLContext();
        return;
    L7:
        if (this.f455504b.isReleased() == false) goto L9;
        return;
    }

    public final double e() {
        if (this.f455504b != null) goto L6;
        return -1.0d;
    L6:
        long r100 = System.nanoTime();
        long r101 = Math.abs(r100 - this.f455504b.getTimestamp());
        long r102 = Math.abs(SystemClock.elapsedRealtimeNanos() - this.f455504b.getTimestamp());
        return (r100 - Math.min(Math.min(r101, r102), Math.abs((SystemClock.uptimeMillis() * 1000000) - this.f455504b.getTimestamp()))) / 1000000.0d;
    }

    public final void g() {
        if (this.f455505c == true) goto L27;
        if (this.f455506d == 1) goto L27;
    L18:
        SurfaceTexture r100 = this.f455504b;
        if (r100 == null) goto L30;
        r100.updateTexImage();
        return;
    L30:
        return;
    L27:
        a();     // Catch: Throwable -> L11 Exception -> L13
    L9:
        if (this.f455505c == false) goto L26;
    L17:
        this.f455505c = false;
    L26:
    L11:
        th = move-exception;
        if (this.f455505c == false) goto L25;
        this.f455505c = false;
    L25:
        throw th;
    L13:
        e = move-exception;
        this.f455506d = 0;     // Catch: Throwable -> L11
        VELogUtil.w("TextureHolder", "attachToGLContext, exception occurred.", e);     // Catch: Throwable -> L11
        if (this.f455505c == false) goto L26;
        goto L17
    }

    public TextureHolder() {
        this.f455503a = 0;
        this.f455505c = false;
        this.f455506d = -1;
    }

    public final synchronized void c(boolean r100) {
        monitor-enter(this);
        if (r100 == false) goto L11;
        this.f455503a = 0;     // Catch: Throwable -> L15
        if (Build.VERSION.SDK_INT < 26) goto L9;
        this.f455504b = new cic.a();     // Catch: Throwable -> L15
    L10:
        this.f455506d = 1;     // Catch: Throwable -> L15
    L12:
        this.f455504b.setOnFrameAvailableListener(new a(this));     // Catch: Throwable -> L15
        VELogUtil.i("TextureHolder", "createSurfaceTexture SurfaceTextureID = " + this.f455503a + ", detachSurfaceTexture = " + r100);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L9:
        cic.a r101 = new cic.a(0);     // Catch: Throwable -> L15
        this.f455504b = r101;     // Catch: Throwable -> L15
        r101.detachFromGLContext();     // Catch: Throwable -> L15
        goto L10
    L11:
        this.f455503a = cfc.a.a();     // Catch: Throwable -> L15
        this.f455504b = new cic.a(this.f455503a);     // Catch: Throwable -> L15
        this.f455506d = 0;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final void f(boolean r100) {
        VELogUtil.i("TextureHolder", "onDestroy, canRelease = " + r100);
        if (this.f455504b == null) goto L7;
        if (r100 == false) goto L6;
        VELogUtil.i("TextureHolder", "onDestroy, release SurfaceTexture, mSurfaceTexture = " + this.f455504b);
        this.f455504b.release();
    L6:
        this.f455504b = null;
        this.f455506d = -1;
    L7:
        int r101 = this.f455503a;
        if (r101 == 0) goto L11;
        GLES20.glDeleteTextures(1, new int[]{r101}, 0);
        this.f455503a = 0;
        return;
    }
}
