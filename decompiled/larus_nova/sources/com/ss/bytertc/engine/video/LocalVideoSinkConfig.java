package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.VideoPixelFormat;

/* JADX INFO: loaded from: classes40.dex */
public class LocalVideoSinkConfig {
    public VideoPixelFormat pixelFormat;
    public LocalVideoSinkPosition position;

    public LocalVideoSinkConfig() {
        this.position = LocalVideoSinkPosition.AFTER_PREPROCESS;
        this.pixelFormat = VideoPixelFormat.UNKNOWN;
    }
}
