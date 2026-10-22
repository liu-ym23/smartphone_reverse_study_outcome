package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.type.AudioCodecType;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRemoteEncodedAudioFrameObserver {
    public RTCRemoteEncodedAudioFrameObserver() {
    }

    private static RemoteStreamKey createRemoteStreamKey(String r100, String r101, int r102) {
        return new RemoteStreamKey(r100, r101, StreamIndex.fromId(r102));
    }

    private static EncodedAudioFrameData createEncodedAudioFrameImpl(int r110, ByteBuffer r111, int r112, long r113, int r114, int r115, int r116, ByteBuffer r117) {
        r111.order(ByteOrder.nativeOrder());
        if (r117 == null) goto L6;
        r117.order(ByteOrder.nativeOrder());
    L6:
        return new EncodedAudioFrameData(AudioCodecType.fromId(r110), r111, r112, r113, AudioSampleRate.fromId(r114), AudioChannel.fromId(r115), r116, r117);
    }
}
