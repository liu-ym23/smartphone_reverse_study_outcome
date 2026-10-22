package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
class TTSurfaceView extends SurfaceView implements ITTRenderView {
    int mFixedSizeWidth;
    private ITTRenderView.RenderCallback mRenderCallback;
    private Surface mSurface;

    public static /* synthetic */ void a(ITTRenderView.SnapshotCallback r100, Bitmap r101, int r102) {
        lambda$snapshotBitmap$0(r100, r101, r102);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public View getView() {
        return this;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public final /* synthetic */ void reuse() {
        ITTRenderView.CC.$default$reuse(this);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reCreateSurface() {
        setVisibility(8);
        setVisibility(0);
    }

    private void init() {
        getHolder().addCallback(new AnonymousClass1(this));
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public Surface getSurface() {
        return this.mSurface;
    }

    public TTSurfaceView(Context r100) {
        super(r100);
        this.mSurface = null;
        this.mRenderCallback = null;
        this.mFixedSizeWidth = -1;
        init();
    }

    public static /* synthetic */ Surface access$000(TTSurfaceView r100) {
        return r100.mSurface;
    }

    public static /* synthetic */ ITTRenderView.RenderCallback access$100(TTSurfaceView r100) {
        return r100.mRenderCallback;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setRenderCallback(ITTRenderView.RenderCallback r100) {
        this.mRenderCallback = r100;
    }

    public static /* synthetic */ Surface access$002(TTSurfaceView r100, Surface r101) {
        r100.mSurface = r101;
        return r101;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setFixedSizeIfNeeded(int r100, int r101) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", fixed size w: " + r100 + ", h: " + r101 + ", ow: " + this.mFixedSizeWidth);
        if (r100 > 0) goto L5;
    L7:
        getHolder().setFixedSize(r100, r101);
        this.mFixedSizeWidth = r100;
        return;
    L5:
        if (r100 >= this.mFixedSizeWidth) goto L7;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void snapshotBitmap(boolean r100, final ITTRenderView.SnapshotCallback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 == false) goto L6;
        Bitmap.Config r102 = Bitmap.Config.ARGB_8888;
    L7:
        int r103 = Build.VERSION.SDK_INT;
        if (r103 != 28) goto L10;
        r102 = Bitmap.Config.ARGB_8888;
    L10:
        final Bitmap r104 = Bitmap.createBitmap(getWidth(), getHeight(), r102);
        if (r103 >= 24) goto L18;
        r101.onResult(-1, null);
        return;
    L18:
        PixelCopy.request(this, r104, new f(r101, r104), new Handler(Looper.getMainLooper()));     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.ss.vcbkit.a.b(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn surface view snapshot failed: " + e);
        r101.onResult(-1, null);
        return;
    L6:
        r102 = Bitmap.Config.RGB_565;
        goto L7
    }

    private static /* synthetic */ void lambda$snapshotBitmap$0(ITTRenderView.SnapshotCallback r100, Bitmap r101, int r102) {
        if (r102 == 0) goto L5;
        r101 = null;
    L5:
        r100.onResult(r102, r101);
    }
}
