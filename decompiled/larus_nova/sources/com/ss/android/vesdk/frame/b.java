package com.ss.android.vesdk.frame;

import android.graphics.SurfaceTexture;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.provider.TECameraProvider;

/* JADX INFO: loaded from: classes40.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TECameraFrame.ETEPixelFormat f455833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TEFrameSizei f455834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f455835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f455836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SurfaceTexture f455837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f455838f;

    public interface a extends TECameraProvider.CaptureListener {
        void b(TEFrameSizei r100);
    }

    /* JADX INFO: renamed from: com.ss.android.vesdk.frame.b$b, reason: collision with other inner class name */
    public interface InterfaceC5458b extends TECameraProvider.CaptureListenerWithAR, a {
        void a(boolean r100);

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListenerWithAR
        void onNewSurfaceTexture(SurfaceTexture r100, boolean r101);
    }

    public boolean b() {
        TEFrameSizei r100 = this.f455834b;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.width <= 0) goto L11;
        if (r100.height <= 0) goto L11;
        if (this.f455835c == null) goto L11;
        return true;
    }

    public SurfaceTexture a() {
        return this.f455837e;
    }

    public void c(SurfaceTexture r100) {
        this.f455837e = r100;
    }

    public b(TECameraFrame.ETEPixelFormat r100, TEFrameSizei r101, InterfaceC5458b r102, boolean r103, SurfaceTexture r104) {
        this.f455838f = true;
        this.f455833a = r100;
        this.f455834b = r101;
        this.f455835c = r102;
        this.f455836d = r103;
        this.f455837e = r104;
    }
}
