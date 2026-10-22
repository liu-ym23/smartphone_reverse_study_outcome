package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.StreamIndex;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IVideoProcessor {
    public IVideoProcessor() {
    }

    public abstract IVideoFrame processVideoFrame(StreamIndex r100, IVideoFrame r101);
}
