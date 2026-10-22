package com.bytedance.ee.bear.middleground.drive.export.player.view;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.ee.bear.drive.view.preview.video.player.e;
import com.bytedance.ee.bear.drive.view.preview.video.player.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ VideoSurfaceView.a a;
    public final /* synthetic */ VideoSurfaceView b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
        tt5.a.h("VideoSurfaceView", "onSurfaceTextureDestroyed");
        if (this.b.d != null) goto L5;
        return true;
    L5:
        return false;
    }

    public a(VideoSurfaceView r1, w.a r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
        tt5.a.h("VideoSurfaceView", "onSurfaceTextureAvailable");
        VideoSurfaceView r4 = this.b;
        SurfaceTexture r5 = r4.d;
        if (r5 != null) goto L5;
        r4.d = r1;
        r4.b = new Surface(this.b.d);
        w.a r6 = this.a;
        Surface r7 = this.b.b;
        w.a r8 = r6;
        w r9 = r8.a;
        r9.o = r7;
        ((e) r9).a.setSurface(r7);
        r8.a.start();
        return;
    L5:
        r4.c.setSurfaceTexture(r5);
        w.a r10 = this.a;
        Surface r11 = this.b.b;
        w.a r12 = r10;
        w r13 = r12.a;
        r13.o = r11;
        ((e) r13).a.setSurface(r11);
        r12.a.start();
    }
}
