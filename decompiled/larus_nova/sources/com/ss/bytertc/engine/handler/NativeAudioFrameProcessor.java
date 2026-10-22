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
public class NativeAudioFrameProcessor {
    public NativeAudioFrameProcessor() {
    }

    private static RemoteStreamKey createRemoteStreamKey(String r100, String r101, int r102) {
        return new RemoteStreamKey(r100, r101, StreamIndex.fromId(r102));
    }

    private static IAudioFrame createAudioFrameImpl(ByteBuffer r110, int r111, int r112, int r113, ByteBuffer r114, long r115, long r116) {
        r110.order(ByteOrder.nativeOrder());
        if (r114 == null) goto L6;
        r114.order(ByteOrder.nativeOrder());
    L6:
        return new AudioFrameImpl(r110, r111, AudioSampleRate.fromId(r112), AudioChannel.fromId(r113), r114, r115, r116);
    }
}
