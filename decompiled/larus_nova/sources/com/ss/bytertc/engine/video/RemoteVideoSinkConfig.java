package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.VideoPixelFormat;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteVideoSinkConfig {
    public VideoApplyRotation applyRotation;
    public VideoSinkMirrorType mirrorType;
    public VideoPixelFormat pixelFormat;
    public RemoteVideoSinkPosition position;

    public RemoteVideoSinkConfig() {
        this.position = RemoteVideoSinkPosition.AFTER_POST_PROCESS;
        this.pixelFormat = VideoPixelFormat.UNKNOWN;
        this.applyRotation = VideoApplyRotation.DEFAULT;
        this.mirrorType = VideoSinkMirrorType.OFF;
    }
}
