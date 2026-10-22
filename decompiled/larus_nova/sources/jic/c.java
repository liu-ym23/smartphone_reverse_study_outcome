package jic;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends e implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SurfaceView f499267e;

    public c(SurfaceView r100) {
        super(0);
        this.f499267e = r100;
        r100.getHolder().addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        SurfaceView r101 = this.f499267e;
        if (r101 == null) goto L5;
        this.f499270a = r101.getWidth();
        this.f499271b = this.f499267e.getHeight();
    L5:
        a(r100.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        c(r100.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        b(r100.getSurface(), r101, r102, r103);
    }
}
