package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class ClientMixedStreamConfig {
    public boolean useAudioMixer;
    public MixedStreamClientMixVideoFormat videoFormat;

    public int getClientMixedStreamConfigVideoFormat() {
        return this.videoFormat.getValue();
    }

    public ClientMixedStreamConfig() {
        this.useAudioMixer = true;
        this.videoFormat = MixedStreamClientMixVideoFormat.MIXED_STREAM_CLIENT_MIX_VIDEO_FORMAT_YUV_I420;
    }

    public boolean getClientMixedStreamConfigUseAudioMixer() {
        return this.useAudioMixer;
    }
}
