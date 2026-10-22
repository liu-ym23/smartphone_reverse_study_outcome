package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.utils.AudioFrameImpl;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes40.dex */
public class RTCAudioFrameObserver {
    public RTCAudioFrameObserver() {
    }

    private static RemoteStreamKey createRemoteStreamKey(String r100, String r101, int r102) {
        return new RemoteStreamKey(r100, r101, StreamIndex.fromId(r102));
    }

    private static IAudioFrame createAudioFrameImpl(ByteBuffer r100, int r101, int r102, int r110, ByteBuffer r111) {
        r100.order(ByteOrder.nativeOrder());
        if (r111 == null) goto L6;
        r111.order(ByteOrder.nativeOrder());
    L6:
        return new AudioFrameImpl(r100, r101, AudioSampleRate.fromId(r102), AudioChannel.fromId(r110), r111);
    }
}
