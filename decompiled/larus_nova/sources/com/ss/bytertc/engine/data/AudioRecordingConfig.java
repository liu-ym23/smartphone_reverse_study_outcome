package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class AudioRecordingConfig {
    public String absoluteFileName;
    public AudioChannel channel;
    public AudioFrameSource frameSource;
    public AudioQuality quality;
    public AudioSampleRate sampleRate;

    public AudioRecordingConfig() {
        this.absoluteFileName = null;
        this.sampleRate = AudioSampleRate.AUDIO_SAMPLE_RATE_AUTO;
        this.channel = AudioChannel.AUDIO_CHANNEL_AUTO;
        this.frameSource = AudioFrameSource.AUDIO_FRAME_SOURCE_MIXED;
        this.quality = AudioQuality.AUDIO_QUALITY_MEDIUM;
    }

    public AudioRecordingConfig(String r100, AudioSampleRate r101, AudioChannel r102, AudioFrameSource r103, AudioQuality r104) {
        this.absoluteFileName = r100;
        this.sampleRate = r101;
        this.channel = r102;
        this.frameSource = r103;
        this.quality = r104;
    }
}
