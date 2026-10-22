package com.ss.bytertc.engine.live;

import androidx.camera.video.AudioStats;
import com.ss.bytertc.engine.data.Position;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamLayoutRegionConfig {
    public double alpha;
    public MixedStreamAlternateImageFillMode alternateImageFillMode;
    public String alternateImageURL;
    public boolean applySpatialAudio;
    public double cornerRadius;
    public int height;
    public boolean ignoreRtcSei;
    public byte[] imageWaterMark;
    public MixedStreamLayoutRegionImageWaterMarkConfig imageWaterMarkConfig;
    public boolean isLocalUser;
    public int locationX;
    public int locationY;
    public MixedStreamMediaType mediaType;
    public MixedStreamLayoutRegionType regionContentType;
    public MixedStreamRenderMode renderMode;
    public String roomID;
    public SourceCrop sourceCrop;
    public Position spatialPosition;
    public MixedStreamVideoType streamType;
    public int superResolutionMode;
    public String userID;
    public boolean videoEnhancement;
    public int volume;
    public int width;
    public String wtnStreamID;
    public int zOrder;

    public MixedStreamLayoutRegionConfig() {
        this.userID = "";
        this.roomID = "";
        this.wtnStreamID = "";
        this.locationX = 0;
        this.locationY = 0;
        this.width = 360;
        this.height = 640;
        this.zOrder = 0;
        this.alpha = 1.0d;
        this.cornerRadius = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mediaType = MixedStreamMediaType.MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO;
        this.renderMode = MixedStreamRenderMode.MIXED_STREAM_RENDER_MODE_HIDDEN;
        this.isLocalUser = false;
        this.streamType = MixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN;
        this.regionContentType = MixedStreamLayoutRegionType.MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM;
        this.imageWaterMark = null;
        this.imageWaterMarkConfig = new MixedStreamLayoutRegionImageWaterMarkConfig(0, 0);
        this.alternateImageFillMode = MixedStreamAlternateImageFillMode.FIT;
        this.alternateImageURL = "";
        this.spatialPosition = new Position();
        this.applySpatialAudio = true;
        this.sourceCrop = new SourceCrop();
        this.videoEnhancement = false;
        this.superResolutionMode = 0;
        this.ignoreRtcSei = false;
        this.volume = 100;
    }
}
