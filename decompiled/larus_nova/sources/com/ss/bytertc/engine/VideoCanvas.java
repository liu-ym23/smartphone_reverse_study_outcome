package com.ss.bytertc.engine;

import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.ss.bytertc.engine.data.VideoRotation;

/* JADX INFO: loaded from: classes40.dex */
public class VideoCanvas {
    public static final int RENDER_MODE_FILL = 3;
    public static final int RENDER_MODE_FIT = 2;
    public static final int RENDER_MODE_HIDDEN = 1;
    public int backgroundColor;
    public int renderMode;
    public VideoRotation renderRotation;
    public Surface renderSurface;
    public View renderView;

    public String toString() {
        return "VideoCanvas{, textureView=" + this.renderView + ", surface=" + this.renderSurface + ", renderMode=" + this.renderMode + ", background_color=" + this.backgroundColor + ", renderRotation=" + this.renderRotation.value() + '}';
    }

    public VideoCanvas() {
        this.renderView = null;
        this.renderSurface = null;
        this.renderMode = 1;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(Surface r100, int r101) {
        this.renderSurface = r100;
        this.renderView = null;
        this.renderMode = r101;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(TextureView r100, int r101) {
        this.renderView = r100;
        this.renderSurface = null;
        this.renderMode = r101;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(SurfaceView r100, int r101) {
        this.renderView = r100;
        this.renderSurface = null;
        this.renderMode = r101;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(Surface r100, int r101, int r102) {
        this.renderSurface = r100;
        this.renderView = null;
        this.renderMode = r101;
        this.backgroundColor = r102;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(SurfaceView r100, int r101, int r102) {
        this.renderView = r100;
        this.renderSurface = null;
        this.renderMode = r101;
        this.backgroundColor = r102;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(TextureView r100, int r101, int r102) {
        this.renderView = r100;
        this.renderSurface = null;
        this.renderMode = r101;
        this.backgroundColor = r102;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }
}
