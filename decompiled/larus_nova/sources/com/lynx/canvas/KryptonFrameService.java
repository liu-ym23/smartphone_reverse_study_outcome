package com.lynx.canvas;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonFrameService extends KryptonService {

    public interface FrameCallback {
        void doFrame(long r100);
    }

    public abstract void registerBeforeVSyncEndListener(FrameCallback r100);

    public abstract void requestVSync(FrameCallback r100);

    public abstract void setPreferredFramesPerSecond(long r100);

    public KryptonFrameService() {
    }
}
