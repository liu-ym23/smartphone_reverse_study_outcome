package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.VideoRotation;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteVideoRenderConfig {
    public int backgroundColor;
    public int renderMode;
    public VideoRotation renderRotation;

    public String toString() {
        return "RemoteVideoRenderConfig{, renderMode=" + this.renderMode + ", background_color=" + this.backgroundColor + ", renderRotation=" + this.renderRotation.value() + '}';
    }

    public RemoteVideoRenderConfig() {
        this.renderMode = 1;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }
}
