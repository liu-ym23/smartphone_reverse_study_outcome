package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.type.AudioCodecType;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class EncodedAudioFrameData {
    public AudioChannel channelNum;
    public AudioCodecType codecType;
    public ByteBuffer data;
    public ByteBuffer extraInfo;
    public int frameSizeMs;
    public AudioSampleRate sampleRate;
    public int size;
    public long timestampUs;

    public EncodedAudioFrameData(AudioCodecType r100, ByteBuffer r101, int r102, long r103, AudioSampleRate r104, AudioChannel r105, int r106) {
        this.codecType = r100;
        this.data = r101;
        this.size = r102;
        this.timestampUs = r103;
        this.sampleRate = r104;
        this.channelNum = r105;
        this.frameSizeMs = r106;
        this.extraInfo = null;
    }

    public EncodedAudioFrameData(AudioCodecType r100, ByteBuffer r101, int r102, long r103, AudioSampleRate r104, AudioChannel r105, int r106, ByteBuffer r107) {
        this.codecType = r100;
        this.data = r101;
        this.size = r102;
        this.timestampUs = r103;
        this.sampleRate = r104;
        this.channelNum = r105;
        this.frameSizeMs = r106;
        this.extraInfo = r107;
    }
}
