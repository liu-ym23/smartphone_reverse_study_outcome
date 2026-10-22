package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IExternalVideoEncoderEventHandler {
    public IExternalVideoEncoderEventHandler() {
    }

    public abstract void onActiveVideoLayer(StreamIndex r100, int r101, boolean r102);

    public abstract void onRateUpdate(StreamIndex r100, int r101, int r102, int r103);

    public abstract void onRequestKeyFrame(StreamIndex r100, int r101);

    public abstract void onStart(StreamIndex r100);

    public abstract void onStop(StreamIndex r100);
}
