package com.ss.bytertc.base.media;

import android.view.Choreographer;
import android.view.Surface;

/* JADX INFO: loaded from: classes40.dex */
public class ChoreographerFrameCallback implements Choreographer.FrameCallback {
    public Surface currentSurface;
    public long nativeCallbackHandle;
    public String renderTaskUUID;

    public void resetCallback() {
        this.nativeCallbackHandle = 0;
    }

    public ChoreographerFrameCallback() {
        this.nativeCallbackHandle = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r100) {
        if (this.nativeCallbackHandle == 0) goto L8;
        Choreographer.getInstance().postFrameCallback(this);
        Surface r101 = this.currentSurface;
        if (r101 == null) goto L9;
        RTCNativeFunctions.nativeNotifyChoreographerDoFrame(this.nativeCallbackHandle, r101, this.renderTaskUUID);
        return;
    L9:
        return;
    }
}
