package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.utils.AudioFrameImpl;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes40.dex */
public class RTCMediaPlayerAudioFrameObserver {
    private IMediaPlayerAudioFrameObserver mAudioFrameObserver;

    public RTCMediaPlayerAudioFrameObserver() {
    }

    public void setAudioFrameObserver(IMediaPlayerAudioFrameObserver r100) {
        this.mAudioFrameObserver = r100;
    }

    public void onFrame(int r100, IAudioFrame r101) {
        IMediaPlayerAudioFrameObserver r102 = this.mAudioFrameObserver;
        if (r102 == null) goto L6;
        r102.onFrame(r100, r101);
        return;
    }

    private static IAudioFrame createAudioFrameImpl(ByteBuffer r100, int r101, int r102, int r103) {
        r100.order(ByteOrder.nativeOrder());
        return new AudioFrameImpl(r100, r101, AudioSampleRate.fromId(r102), AudioChannel.fromId(r103));
    }
}
