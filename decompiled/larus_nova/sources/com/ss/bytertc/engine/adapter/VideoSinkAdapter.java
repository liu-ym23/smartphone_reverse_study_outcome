package com.ss.bytertc.engine.adapter;

import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.IVideoSink;

/* JADX INFO: loaded from: classes40.dex */
public class VideoSinkAdapter implements IVideoSink {
    private IVideoSink mSink;

    public void release() {
    }

    @Override // com.ss.bytertc.engine.video.IVideoSink
    public int getRenderElapse() {
        IVideoSink r100 = this.mSink;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getRenderElapse();
    }

    public VideoSinkAdapter(IVideoSink r100) {
        this.mSink = r100;
    }

    @Override // com.ss.bytertc.engine.video.IVideoSink
    public void onFrame(IVideoFrame r100) {
        IVideoSink r101 = this.mSink;
        if (r101 == null) goto L6;
        r101.onFrame(r100);
        return;
    }
}
