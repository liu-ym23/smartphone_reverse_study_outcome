package com.lynx.canvas;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonLiveModule extends KryptonModule {

    public interface IAudioSampleListener {
        void onAudioSample(ByteBuffer r100, int r101);
    }

    public interface IVideoFrameListener {
        void onVideoFrame(ByteBuffer r100, int r101, int r102);
    }

    public static String moduleName() {
        return "live";
    }

    public abstract void flushCapture(IVideoFrameListener r100, IAudioSampleListener r101);

    public abstract void setBackgroundVolume(float r100);

    public abstract void setEnableCaptureMicrophone(boolean r100);

    public abstract void setMicrophoneVolume(float r100);

    public abstract boolean startCapture(int r100, int r101, int r102, String r103, int r104, boolean r105);

    public abstract void stopCapture();

    public KryptonLiveModule() {
    }
}
