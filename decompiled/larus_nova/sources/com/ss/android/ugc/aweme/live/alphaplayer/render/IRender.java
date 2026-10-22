package com.ss.android.ugc.aweme.live.alphaplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.ss.android.ugc.aweme.live.alphaplayer.GLTextureView;

/* JADX INFO: loaded from: classes40.dex */
public interface IRender extends GLSurfaceView.Renderer, GLTextureView.Renderer, SurfaceTexture.OnFrameAvailableListener {

    public interface SurfaceListener {
        void a(Surface r100);

        int b();
    }
}
