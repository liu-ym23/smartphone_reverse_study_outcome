package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoPixelFormat;

/* JADX INFO: loaded from: classes40.dex */
public class VideoPreprocessorConfig {
    public VideoPixelFormat requiredPixelFormat;
    public StreamIndex streamIndex;

    public VideoPreprocessorConfig() {
        this.requiredPixelFormat = VideoPixelFormat.UNKNOWN;
        this.streamIndex = StreamIndex.STREAM_INDEX_MAIN;
    }
}
