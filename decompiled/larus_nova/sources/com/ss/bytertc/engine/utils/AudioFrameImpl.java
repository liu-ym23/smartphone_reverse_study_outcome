package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioFrameType;
import com.ss.bytertc.engine.data.AudioSampleRate;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class AudioFrameImpl implements IAudioFrame {
    private ByteBuffer byteBuffer;
    private long captureTimestampMs;
    private AudioChannel channel;
    private ByteBuffer extraBuffer;
    private AudioFrameType frameType;
    private AudioSampleRate sampleRate;
    private int samplesPerChannel;
    private long timestamp;

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public void release() {
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int data_size() {
        return (this.samplesPerChannel * this.channel.value()) * 2;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int extraInfoSize() {
        ByteBuffer r100 = this.extraBuffer;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.capacity();
    }

    public AudioFrameImpl() {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0;
        this.extraBuffer = null;
        this.captureTimestampMs = 0;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public long captureTimestampMs() {
        return this.captureTimestampMs;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioChannel channel() {
        return this.channel;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioFrameType frame_type() {
        return this.frameType;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public ByteBuffer getDataBuffer() {
        return this.byteBuffer;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public ByteBuffer getExtraInfo() {
        return this.extraBuffer;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioSampleRate sample_rate() {
        return this.sampleRate;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public long timestamp_us() {
        return this.timestamp;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int setExtraInfo(ByteBuffer r100) {
        this.extraBuffer = r100;
        return 0;
    }

    public AudioFrameImpl(ByteBuffer r100, int r101, AudioSampleRate r102, AudioChannel r103) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0;
        this.captureTimestampMs = 0;
        this.byteBuffer = r100;
        this.samplesPerChannel = r101;
        this.sampleRate = r102;
        this.channel = r103;
        this.extraBuffer = null;
    }

    public AudioFrameImpl(ByteBuffer r100, int r101, AudioSampleRate r102, AudioChannel r103, ByteBuffer r104) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0;
        this.captureTimestampMs = 0;
        this.byteBuffer = r100;
        this.samplesPerChannel = r101;
        this.sampleRate = r102;
        this.channel = r103;
        this.extraBuffer = r104;
    }

    public AudioFrameImpl(byte[] r100, int r101, AudioSampleRate r102, AudioChannel r110, byte[] r111) {
        this(ByteBuffer.wrap(r100), r101, r102, r110, ByteBuffer.wrap(r111));
    }

    public AudioFrameImpl(ByteBuffer r100, int r101, AudioSampleRate r102, AudioChannel r103, ByteBuffer r104, long r105, long r106) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.byteBuffer = r100;
        this.samplesPerChannel = r101;
        this.sampleRate = r102;
        this.channel = r103;
        this.extraBuffer = r104;
        this.timestamp = r105;
        this.captureTimestampMs = r106;
    }
}
