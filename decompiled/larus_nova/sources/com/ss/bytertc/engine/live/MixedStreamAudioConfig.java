package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamAudioConfig {
    public MixedStreamAudioCodecType audioCodec;
    public MixedStreamAudioProfile audioProfile;
    public int bitrate;
    public int channels;
    public int sampleRate;

    public String toString() {
        return "MixedStreamAudioConfig{audioProfile='" + this.audioProfile + "', channels=" + this.channels + ", sampleRate=" + this.sampleRate + ", bitrate=" + this.bitrate + ", audioCodec=" + this.audioCodec + '}';
    }

    public MixedStreamAudioConfig() {
        this.audioCodec = MixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
        this.bitrate = 64;
        this.sampleRate = 48000;
        this.channels = 2;
        this.audioProfile = MixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
    }
}
