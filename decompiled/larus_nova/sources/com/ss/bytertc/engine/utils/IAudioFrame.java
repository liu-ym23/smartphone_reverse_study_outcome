package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioFrameType;
import com.ss.bytertc.engine.data.AudioSampleRate;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public interface IAudioFrame {
    long captureTimestampMs();

    AudioChannel channel();

    int data_size();

    int extraInfoSize();

    AudioFrameType frame_type();

    ByteBuffer getDataBuffer();

    ByteBuffer getExtraInfo();

    void release();

    AudioSampleRate sample_rate();

    int setExtraInfo(ByteBuffer r100);

    long timestamp_us();
}
