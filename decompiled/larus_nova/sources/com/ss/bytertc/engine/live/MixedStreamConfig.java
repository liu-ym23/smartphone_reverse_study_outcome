package com.ss.bytertc.engine.live;

import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import faceverify.w;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamConfig {
    private static final String TAG = "MixedStreamConfig";
    public JSONObject advancedConfig;
    public MixedStreamAudioConfig audioConfig;
    public MixedStreamAudioEffectConfig audioEffectConfig;
    public JSONObject authInfo;
    public String backgroundColor;
    public String backgroundImageURL;
    public MixedStreamControlConfig controlConfig;
    public InterpolationMode interpolationMode;
    public StreamLayoutMode layoutMode;
    public MixedStreamLayoutRegionConfig[] regions;
    public String roomID;
    public MixedStreamSpatialAudioConfig spatialAudioConfig;
    public MixedStreamSyncControlConfig syncControlConfig;
    public String userConfigExtraInfo;
    public String userID;
    public MixedStreamVideoConfig videoConfig;

    public static MixedStreamConfig defaultMixedStreamConfig() {
        MixedStreamVideoConfig r100 = new MixedStreamVideoConfig();
        r100.videoCodec = MixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
        r100.fps = 15;
        r100.gop = 2;
        r100.enableBframe = false;
        r100.height = 640;
        r100.width = 360;
        r100.bitrate = 500;
        MixedStreamAudioConfig r101 = new MixedStreamAudioConfig();
        r101.audioCodec = MixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
        r101.channels = 2;
        r101.bitrate = 64;
        r101.sampleRate = 48000;
        r101.audioProfile = MixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
        MixedStreamControlConfig r102 = new MixedStreamControlConfig();
        r102.enableVolumeIndication = false;
        r102.seiContentMode = MixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
        r102.isAddVolumeValue = false;
        r102.talkVolume = 0;
        r102.volumeIndicationInterval = 2.0f;
        r102.seiPayloadType = 100;
        r102.seiPayloadUuid = "";
        MixedStreamSyncControlConfig r103 = new MixedStreamSyncControlConfig();
        r103.baseUserID = "";
        r103.baseRoomID = "";
        r103.syncStrategy = MixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
        r103.maxCacheTimeMs = 2000;
        r103.videoNeedSdkMix = true;
        r103.baseStreamStartDelayMs = 0;
        MixedStreamAudioEffectConfig r104 = new MixedStreamAudioEffectConfig();
        r104.mAudioEffectType = MixedStreamAudioEffectType.MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE;
        MixedStreamSpatialAudioConfig r105 = new MixedStreamSpatialAudioConfig();
        r105.enableSpatialRender = false;
        MixedStreamConfig r106 = new MixedStreamConfig();
        r106.audioConfig = r101;
        r106.videoConfig = r100;
        r106.controlConfig = r102;
        r106.syncControlConfig = r103;
        r106.audioEffectConfig = r104;
        r106.spatialAudioConfig = r105;
        r106.backgroundColor = CustomHeaderConfig.COLOR_DARK;
        r106.userConfigExtraInfo = "";
        return r106;
    }

    public String getMixedStreamAdvancedConfig() {
        JSONObject r100 = this.advancedConfig;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toString();
    }

    public String getMixedStreamAudioConfigAudioProfile() {
        MixedStreamAudioConfig r100 = this.audioConfig;
        if (r100 == null) goto L10;
        MixedStreamAudioProfile r101 = r100.audioProfile;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.getValue();
    L10:
        return "";
    }

    public int getMixedStreamAudioConfigChannels() {
        MixedStreamAudioConfig r100 = this.audioConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.channels;
    }

    public String getMixedStreamAudioConfigCodec() {
        MixedStreamAudioConfig r100 = this.audioConfig;
        if (r100 == null) goto L10;
        MixedStreamAudioCodecType r101 = r100.audioCodec;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.getValue();
    L10:
        return "";
    }

    public int getMixedStreamAudioConfigSampleRate() {
        MixedStreamAudioConfig r100 = this.audioConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.sampleRate;
    }

    public int getMixedStreamAudioEffectType() {
        MixedStreamAudioEffectConfig r100 = this.audioEffectConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.mAudioEffectType.value();
    }

    public String getMixedStreamAuthInfo() {
        JSONObject r100 = this.authInfo;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toString();
    }

    public String getMixedStreamBackgroundColor() {
        String r100 = this.backgroundColor;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getMixedStreamBackgroundImageURL() {
        String r100 = this.backgroundImageURL;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public int getMixedStreamInterpolationMode() {
        return this.interpolationMode.value();
    }

    public int getMixedStreamLayoutMode() {
        return this.layoutMode.value();
    }

    public int getMixedStreamLayoutmode() {
        return this.layoutMode.value();
    }

    public String getMixedStreamRoomID() {
        String r100 = this.roomID;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public boolean getMixedStreamServerControlConfigEnableVolumeIndication() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.enableVolumeIndication;
    }

    public boolean getMixedStreamServerControlConfigIsAddVolumeValue() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.isAddVolumeValue;
    }

    public int getMixedStreamServerControlConfigMediaType() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L5;
        MixedStreamMediaType r101 = MixedStreamMediaType.MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO;
    L7:
        return r101.getValue();
    L5:
        r101 = r100.mediaType;
        goto L7
    }

    public int getMixedStreamServerControlConfigPushStreamMode() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L5;
        MixedStreamPushMode r101 = MixedStreamPushMode.ON_STREAM;
    L7:
        return r101.getValue();
    L5:
        r101 = r100.pushStreamMode;
        goto L7
    }

    public int getMixedStreamServerControlConfigSeiContentMode() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L5;
        MixedStreamSEIContentMode r101 = MixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
    L7:
        return r101.getValue();
    L5:
        r101 = r100.seiContentMode;
        goto L7
    }

    public int getMixedStreamServerControlConfigSeiPayloadType() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.seiPayloadType;
    }

    public String getMixedStreamServerControlConfigSeiPayloadUuid() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.seiPayloadUuid;
    }

    public int getMixedStreamServerControlConfigTalkVolume() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.talkVolume;
    }

    public float getMixedStreamServerControlConfigVolumeIndicationInterval() {
        MixedStreamControlConfig r100 = this.controlConfig;
        if (r100 != null) goto L6;
        return 2.0f;
    L6:
        return r100.volumeIndicationInterval;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationForwardX() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.forward.f456199x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationForwardY() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.forward.f456200y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationForwardZ() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.forward.f456201z;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationRightX() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.right.f456199x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationRightY() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.right.f456200y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationRightZ() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.right.f456201z;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationUpX() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.f456198up.f456199x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationUpY() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.f456198up.f456200y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationUpZ() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialOrientation.f456198up.f456201z;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialPositionX() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialPosition.f456202x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialPositionY() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialPosition.f456203y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialPositionZ() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.audienceSpatialPosition.f456204z;
    }

    public boolean getMixedStreamSpatialConfigEnableSpatialRender() {
        MixedStreamSpatialAudioConfig r100 = this.spatialAudioConfig;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.enableSpatialRender;
    }

    public String getMixedStreamSyncControlConfigBaseRoom() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.baseRoomID;
    }

    public int getMixedStreamSyncControlConfigBaseStreamStartDelayMs() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.baseStreamStartDelayMs;
    }

    public int getMixedStreamSyncControlConfigBaseStreamType() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.baseStreamType.getValue();
    }

    public String getMixedStreamSyncControlConfigBaseUser() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.baseUserID;
    }

    public int getMixedStreamSyncControlConfigQueueLength() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.maxCacheTimeMs;
    }

    public int getMixedStreamSyncControlConfigSyncStrategy() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L5;
        MixedStreamSyncStrategy r101 = MixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
    L7:
        return r101.getValue();
    L5:
        r101 = r100.syncStrategy;
        goto L7
    }

    public boolean getMixedStreamSyncControlConfigVideoNeedMix() {
        MixedStreamSyncControlConfig r100 = this.syncControlConfig;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.videoNeedSdkMix;
    }

    public String getMixedStreamUserConfigExtraInfo() {
        String r100 = this.userConfigExtraInfo;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getMixedStreamUserID() {
        String r100 = this.userID;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public boolean getMixedStreamVideoConfigBFrame() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.enableBframe;
    }

    public int getMixedStreamVideoConfigBitrate() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.bitrate;
    }

    public String getMixedStreamVideoConfigCodec() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 == null) goto L10;
        MixedStreamVideoCodecType r101 = r100.videoCodec;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.getValue();
    L10:
        return "";
    }

    public int getMixedStreamVideoConfigFps() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.fps;
    }

    public int getMixedStreamVideoConfigGop() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.gop;
    }

    public int getMixedStreamVideoConfigHeight() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.height;
    }

    public int getMixedStreamVideoConfigWidth() {
        MixedStreamVideoConfig r100 = this.videoConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.width;
    }

    public int getMixedStreamaudioConfigBitrate() {
        MixedStreamAudioConfig r100 = this.audioConfig;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.bitrate;
    }

    public JSONObject getTranscodeMessage() {
        String r100 = "height";
        String r101 = "width";
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r110 = new JSONObject();
        JSONObject r111 = new JSONObject();
        JSONObject r112 = new JSONObject();
        JSONObject r113 = new JSONObject();
        new JSONObject();
        JSONArray r114 = new JSONArray();
        JSONObject r115 = new JSONObject();
        JSONObject r116 = new JSONObject();
        JSONObject r117 = new JSONObject();
        r102.put("videoCodec", this.videoConfig.videoCodec);     // Catch: Exception -> L19
        r102.put("fps", this.videoConfig.fps);     // Catch: Exception -> L19
        r102.put("gop", this.videoConfig.gop);     // Catch: Exception -> L19
        r102.put("bitrate", this.videoConfig.bitrate);     // Catch: Exception -> L19
        r102.put("width", this.videoConfig.width);     // Catch: Exception -> L19
        r102.put("height", this.videoConfig.height);     // Catch: Exception -> L19
        r102.put("enableBframe", this.videoConfig.enableBframe);     // Catch: Exception -> L19
        r103.put("audioCodec", this.audioConfig.audioCodec);     // Catch: Exception -> L19
        r103.put("bitrate", this.audioConfig.bitrate);     // Catch: Exception -> L19
        r103.put("sampleRate", this.audioConfig.sampleRate);     // Catch: Exception -> L19
        r103.put("channels", this.audioConfig.channels);     // Catch: Exception -> L19
        r103.put("audioProfile", this.audioConfig.audioProfile);     // Catch: Exception -> L19
        r104.put("enableVolumeIndication", this.controlConfig.enableVolumeIndication);     // Catch: Exception -> L19
        r104.put("talkVolume", this.controlConfig.talkVolume);     // Catch: Exception -> L19
        r104.put("isAddVolumeValue", this.controlConfig.isAddVolumeValue);     // Catch: Exception -> L19
        r104.put("volumeIndicationInterval", this.controlConfig.volumeIndicationInterval);     // Catch: Exception -> L19
        r104.put("seiContentMode", this.controlConfig.seiContentMode);     // Catch: Exception -> L19
        r104.put("seiPayloadType", this.controlConfig.seiPayloadType);     // Catch: Exception -> L19
        r104.put("seiPayloadUuid", this.controlConfig.seiPayloadUuid);     // Catch: Exception -> L19
        r104.put("mediaType", this.controlConfig.mediaType);     // Catch: Exception -> L19
        r104.put("pushStreamMode", this.controlConfig.pushStreamMode);     // Catch: Exception -> L19
        r111.put("syncStrategy", this.syncControlConfig.syncStrategy);     // Catch: Exception -> L19
        r111.put("maxCacheTimeMs", this.syncControlConfig.maxCacheTimeMs);     // Catch: Exception -> L19
        r111.put("videoNeedSdkMix", this.syncControlConfig.videoNeedSdkMix);     // Catch: Exception -> L19
        r111.put("baseuserID", this.syncControlConfig.baseUserID);     // Catch: Exception -> L19
        r111.put("baseRoomID", this.syncControlConfig.baseRoomID);     // Catch: Exception -> L19
        r111.put("baseStreamStartDelayMs", this.syncControlConfig.baseStreamStartDelayMs);     // Catch: Exception -> L19
        r112.put("type", this.audioEffectConfig.mAudioEffectType);     // Catch: Exception -> L19
        r116.put("backgroundColor", this.backgroundColor);     // Catch: Exception -> L19
        r116.put("backgroundImageURL", this.backgroundImageURL);     // Catch: Exception -> L19
        MixedStreamLayoutRegionConfig[] r105 = this.regions;     // Catch: Exception -> L19
        String r106 = "roomID";
        String r107 = "userID";
        if (r105 == null) goto L10;
        int r108 = r105.length;     // Catch: Exception -> L19
        int r118 = 0;
    L7:
        if (r118 >= r108) goto L9;
        int r210 = r108;
        MixedStreamLayoutRegionConfig r109 = r105[r118];     // Catch: Exception -> L19
        MixedStreamLayoutRegionConfig[] r211 = r105;
        JSONObject r119 = new JSONObject();     // Catch: Exception -> L19
        JSONObject r212 = r111;
        r119.put(r107, r109.userID);     // Catch: Exception -> L19
        r119.put(r106, r109.roomID);     // Catch: Exception -> L19
        r119.put("wtnStreamID", r109.wtnStreamID);     // Catch: Exception -> L19
        r119.put("locationX", r109.locationX);     // Catch: Exception -> L19
        r119.put("locationY", r109.locationY);     // Catch: Exception -> L19
        r119.put(r101, r109.width);     // Catch: Exception -> L19
        r119.put(r100, r109.height);     // Catch: Exception -> L19
        r119.put("zOrder", r109.zOrder);     // Catch: Exception -> L19
        r119.put("alpha", r109.alpha);     // Catch: Exception -> L19
        r119.put("cornerRadius", r109.cornerRadius);     // Catch: Exception -> L19
        r119.put("mediaType", r109.mediaType);     // Catch: Exception -> L19
        r119.put("renderMode", r109.renderMode);     // Catch: Exception -> L19
        r119.put("isLocalUser", r109.isLocalUser);     // Catch: Exception -> L19
        r119.put("streamType", r109.streamType);     // Catch: Exception -> L19
        r119.put("applySpatialAudio", r109.applySpatialAudio);     // Catch: Exception -> L19
        r119.put("alternateImageFillMode", r109.alternateImageFillMode);     // Catch: Exception -> L19
        r119.put("alternateImageURL", r109.alternateImageURL);     // Catch: Exception -> L19
        r119.put("sourceCropX", r109.sourceCrop.locationX);     // Catch: Exception -> L19
        r119.put("sourceCropY", r109.sourceCrop.locationY);     // Catch: Exception -> L19
        r119.put("sourceCropW", r109.sourceCrop.widthProportion);     // Catch: Exception -> L19
        r119.put("sourceCropH", r109.sourceCrop.heightProportion);     // Catch: Exception -> L19
        r119.put("videoEnhancement", r109.videoEnhancement);     // Catch: Exception -> L19
        r119.put("ignoreRtcSei", r109.ignoreRtcSei);     // Catch: Exception -> L19
        r119.put("superResolutionMode", r109.superResolutionMode);     // Catch: Exception -> L19
        r114.put(r119);     // Catch: Exception -> L19
        r118 = r118 + 1;     // Catch: Exception -> L19
        r106 = r106;
        r100 = r100;
        r108 = r210;
        r105 = r211;
        r111 = r212;
        r107 = r107;
        r101 = r101;
        goto L7
    L9:
        String r213 = r107;
        JSONObject r214 = r111;
    L11:
        String r120 = r106;
        r116.put("regions", r114);     // Catch: Exception -> L19
        r116.put("userConfigExtraInfo", this.userConfigExtraInfo);     // Catch: Exception -> L19
        r116.put("transcode", r115);     // Catch: Exception -> L19
        r116.put("video", r102);     // Catch: Exception -> L19
        r116.put("audio", r103);     // Catch: Exception -> L19
        r116.put("serverControl", r104);     // Catch: Exception -> L19
        r116.put("clientMix", r110);     // Catch: Exception -> L19
        r116.put("syncControl", r214);     // Catch: Exception -> L19
        r116.put("audioEffect", r112);     // Catch: Exception -> L19
        r116.put("layout", r113);     // Catch: Exception -> L19
        JSONObject r121 = this.advancedConfig;     // Catch: Exception -> L19
        if (r121 == null) goto L14;
        r116.put("advancedConfig", r121);     // Catch: Exception -> L19
    L14:
        JSONObject r122 = this.authInfo;     // Catch: Exception -> L19
        if (r122 == null) goto L17;
        r116.put(w.META_COLL_KEY_AUTH_INFO, r122);     // Catch: Exception -> L19
    L17:
        r117.put("type", "transcode");     // Catch: Exception -> L19
        r117.put(r120, this.roomID);     // Catch: Exception -> L19
        r117.put(r213, this.userID);     // Catch: Exception -> L19
        r117.put("transcodeMeta", r116);     // Catch: Exception -> L19
        r117.put("layoutMode", this.layoutMode);     // Catch: Exception -> L19
        r117.put("interpolationMode", this.interpolationMode);     // Catch: Exception -> L19
        return r117;
    L10:
        r213 = "userID";
        r214 = r111;
    L19:
        e = move-exception;
        LogUtil.w(TAG, "get json message happen exception", e);
        return null;
    }

    public MixedStreamConfig() {
        this.regions = null;
        this.userConfigExtraInfo = "";
        this.backgroundColor = CustomHeaderConfig.COLOR_DARK;
        this.backgroundImageURL = "";
        this.advancedConfig = null;
        this.roomID = "";
        this.userID = "";
        this.authInfo = null;
        this.interpolationMode = InterpolationMode.LAST_FRAME_FILL;
        this.layoutMode = StreamLayoutMode.AUTO;
    }

    public MixedStreamLayoutRegionConfig[] getMixedStreamLayoutRegionConfigs() {
        return this.regions;
    }

    public double getMixedStreamLayoutRegionAlpha(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r100.alpha;
    }

    public int getMixedStreamLayoutRegionAlternateImageFillMode(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return MixedStreamAlternateImageFillMode.FIT.getValue();
    L5:
        return r100.alternateImageFillMode.getValue();
    }

    public String getMixedStreamLayoutRegionAlternateImageURL(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.alternateImageURL;
    }

    public boolean getMixedStreamLayoutRegionApplySpatialAudio(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.applySpatialAudio;
    }

    public int getMixedStreamLayoutRegionContentType(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.regionContentType.getValue();
    }

    public double getMixedStreamLayoutRegionCornerRadius(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r100.cornerRadius;
    }

    public byte[] getMixedStreamLayoutRegionData(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.imageWaterMark;
    }

    public int getMixedStreamLayoutRegionDataParamImageHeight(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.imageWaterMarkConfig.imageHeight;
    }

    public int getMixedStreamLayoutRegionDataParamImageWidth(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.imageWaterMarkConfig.imageWidth;
    }

    public int getMixedStreamLayoutRegionH(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.height;
    }

    public boolean getMixedStreamLayoutRegionIgnoreRtcSei(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.ignoreRtcSei;
    }

    public boolean getMixedStreamLayoutRegionLocalUser(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isLocalUser;
    }

    public int getMixedStreamLayoutRegionMediaType(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.mediaType.getValue();
    }

    public int getMixedStreamLayoutRegionRenderMode(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.renderMode.getValue();
    }

    public String getMixedStreamLayoutRegionRoomID(MixedStreamLayoutRegionConfig r100) {
        if (r100 == null) goto L10;
        String r101 = r100.roomID;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L10:
        return "";
    }

    public int getMixedStreamLayoutRegionScreenStream(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.streamType.getValue();
    }

    public float getMixedStreamLayoutRegionSpatialPositionX(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.spatialPosition.f456202x;
    }

    public float getMixedStreamLayoutRegionSpatialPositionY(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.spatialPosition.f456203y;
    }

    public float getMixedStreamLayoutRegionSpatialPositionZ(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.spatialPosition.f456204z;
    }

    public int getMixedStreamLayoutRegionSuperResolutionMode(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.superResolutionMode;
    }

    public String getMixedStreamLayoutRegionUserID(MixedStreamLayoutRegionConfig r100) {
        if (r100 == null) goto L10;
        String r101 = r100.userID;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L10:
        return "";
    }

    public boolean getMixedStreamLayoutRegionVideoEnhancement(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.videoEnhancement;
    }

    public int getMixedStreamLayoutRegionVolume(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 100;
    L5:
        return r100.volume;
    }

    public int getMixedStreamLayoutRegionW(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.width;
    }

    public String getMixedStreamLayoutRegionWtnStreamID(MixedStreamLayoutRegionConfig r100) {
        if (r100 == null) goto L10;
        String r101 = r100.wtnStreamID;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L10:
        return "";
    }

    public int getMixedStreamLayoutRegionX(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.locationX;
    }

    public int getMixedStreamLayoutRegionY(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.locationY;
    }

    public int getMixedStreamLayoutRegionZOrder(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.zOrder;
    }

    public double getMixedStreamLayoutSourceCropH(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r100.sourceCrop.heightProportion;
    }

    public double getMixedStreamLayoutSourceCropW(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r100.sourceCrop.widthProportion;
    }

    public double getMixedStreamLayoutSourceCropX(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r100.sourceCrop.locationX;
    }

    public double getMixedStreamLayoutSourceCropY(MixedStreamLayoutRegionConfig r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r100.sourceCrop.locationY;
    }
}
