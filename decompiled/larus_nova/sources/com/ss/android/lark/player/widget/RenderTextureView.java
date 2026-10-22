package com.ss.android.lark.player.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes37.dex */
public class RenderTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f438731a;

    public interface a {
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SurfaceTexture> f438732a;

        public c(SurfaceTexture r100) {
            this.f438732a = new WeakReference(r100);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    public a getRenderCallback() {
        return this.f438731a;
    }

    public RenderTextureView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Log.i("RenderSurfaceView", "onSurfaceTextureDestroyed");
        a r101 = this.f438731a;
        if (r101 == null) goto L7;
        new WeakReference(r100);
        ((VideoViewForVC.a) r101).f438787a.f438781j = null;
        return true;
    L7:
        return true;
    }

    public void setRenderCallback(a r100) {
        this.f438731a = r100;
    }

    public RenderTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setOpaque(true);
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Log.i("RenderSurfaceView", "onSurfaceTextureAvailable, width = " + r101 + ", height = " + r102);
        a r103 = this.f438731a;
        if (r103 == null) goto L6;
        c r104 = new c(r100);
        VideoViewForVC r105 = ((VideoViewForVC.a) r103).f438787a;
        r105.f438781j = r104;
        VideoViewForVC.b(r105, r104);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Log.i("RenderSurfaceView", "onSurfaceTextureSizeChanged, width = " + r101 + ", height " + r102);
        a r103 = this.f438731a;
        if (r103 == null) goto L6;
        new WeakReference(r100);
        r103.getClass();
        return;
    }
}
