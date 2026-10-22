package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.IVideoProcessor;

/* JADX INFO: loaded from: classes40.dex */
public class RTCVideoProcessor {
    private IVideoProcessor mProc;

    public void dispose() {
    }

    public RTCVideoProcessor() {
        this.mProc = null;
    }

    public int registerLocalVideoProcessor(IVideoProcessor r100) {
        monitor-enter(this);
        this.mProc = r100;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return 0;
    L7:
        th = move-exception;
        throw th;
    }

    public IVideoFrame processVideoFrame(int r100, IVideoFrame r101) {
        monitor-enter(this);
        IVideoProcessor r102 = this.mProc;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        IVideoFrame r103 = r102.processVideoFrame(StreamIndex.fromId(r100), r101);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r103;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }
}
