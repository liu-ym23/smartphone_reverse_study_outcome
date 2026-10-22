package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamControlConfig {
    public boolean enableVolumeIndication;
    public boolean isAddVolumeValue;
    public MixedStreamMediaType mediaType;
    public MixedStreamPushMode pushStreamMode;
    public MixedStreamSEIContentMode seiContentMode;
    public int seiPayloadType;
    public String seiPayloadUuid;
    public int talkVolume;
    public float volumeIndicationInterval;

    public MixedStreamControlConfig() {
        this.enableVolumeIndication = false;
        this.volumeIndicationInterval = 2.0f;
        this.talkVolume = 0;
        this.isAddVolumeValue = false;
        this.seiContentMode = MixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
        this.seiPayloadType = 100;
        this.seiPayloadUuid = "";
        this.mediaType = MixedStreamMediaType.MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO;
        this.pushStreamMode = MixedStreamPushMode.ON_STREAM;
    }
}
