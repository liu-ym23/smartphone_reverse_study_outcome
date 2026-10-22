package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.medialib.util.VEPlatformUtils;
import com.ss.android.vesdk.runtime.VERuntime;
import com.ss.android.vesdk.settings.VEVideoCompileEncodeSettings;
import com.ss.android.vesdk.settings.VEVideoEncodeProfile;
import com.ss.android.vesdk.settings.VEVideoHWEncodeSettings;
import com.ss.android.vesdk.settings.VEVideoSWEncodeSettings;
import com.ss.android.vesdk.settings.VideoInvisibleWatermarkSettings;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoEncodeSettings implements Parcelable {
    public static final Parcelable.Creator<VEVideoEncodeSettings> CREATOR = null;
    private static final String TAG = "VEVideoEncodeSettings";
    public static final int USAGE_COMPILE = 2;
    public static final int USAGE_IMPORT = 3;
    public static final int USAGE_RECORD = 1;
    private int HwBps;
    boolean banExtraDataLoop;
    private ENCODE_BITRATE_MODE bitrateMode;
    private int bps;
    public COMPILE_TYPE compileType;
    private boolean enableAvInterLeave;
    private boolean enableByteVCRemuxVideo;
    private boolean enableCopyWithMetadata;
    private boolean enableHdr10BitEncode;
    private boolean enableHwBufferEncode;
    private boolean enableInterLeave;
    private boolean enableRemuxVideo;
    private int enableRemuxVideoBitrate;
    private int enableRemuxVideoFPS;
    private boolean enableRemuxVideoForRotation;
    private boolean enableRemuxVideoForShoot;
    private int enableRemuxVideoRes;
    private boolean enableUploadDirectly;
    private int encodeProfile;
    int encodeRotate;
    private int encodeStandard;
    private String externalSettingsJsonStr;
    private int fps;
    private int frameRate;
    private int gopSize;
    private boolean hasBFrame;
    private int iFrameInterval;
    private boolean ignoreJsonBitrate;
    float image_compile_quality;
    private boolean isSupportHWEncoder;
    private int keyFrameDuration;
    private String mComment;
    private boolean mCompileSoftInfo;
    private String mDescription;
    private boolean mEnableInvisibleWatermark;
    private VEVideoEncodeFitMode mFitMode;
    public int[] mKeyFramePoints;
    private VEVideoEncodeMirrorMode mMirrorMode;
    private boolean mOptRemuxWithCopy;
    private boolean mReEncodeOpt;
    private boolean mRecordingMp4;
    private int mResolutionAlign;
    private int mTransitionFrameCount;
    private int mTransitionKeyFrameMode;
    private int mTransitionKeyFrameVersion;
    private boolean mTransitionKeyframeEnable;
    private VEVideoCompileEncodeSettings mVideoCompileEncodeSetting;
    private VideoInvisibleWatermarkSettings mVideoInvisibleWatermarkSettings;
    private int mVideoTrc;
    private VEVideoCompileEncodeSettings mVideoWatermarkCompileEncodeSetting;
    private VEWatermarkParam mWatermarkParam;
    private int maxCacheDuration;
    private int mvStillFramesPublishFps;
    private int mvStillFramesWatermarkFps;
    private VESize outputSize;
    private int publishFps;
    private String qualityScoreSequenceId;
    private VEQualityScoreType qualityScoreType;
    private int resizeMode;
    private float resizeX;
    private float resizeY;
    private int rotate;
    private float speed;
    private int swByteVC1Crf;
    private int swCRF;
    private double swFHDCrfRatio;
    private double swHFpsOffset;
    private long swMaxrate;
    private int swPreset;
    private int swQP;
    private double swQPOffset;
    private double swSDCrfRatio;
    private boolean uploadingWithSynthesisCancelWritefile;
    private boolean useSoftwareDecode;
    private VESize watermarkSize;

    public static class Builder {
        private VEVideoEncodeSettings exportVideoEncodeSettings;
        private int mUsage;
        private Map<ENCODE_STANDARD, Integer> supportEncodeMaxPixels;

        public Builder overrideWithCloudConfig() {
            return this;
        }

        private void initBuilderFromVEConfigCenter() {
            VEVideoEncodeSettings.access$102(this.exportVideoEncodeSettings, VEConfigCenter.getInstance().getValue("ve_compile_codec_type", 0));
            if (VEConfigCenter.getInstance().getValue("veabtest_aboffline_performance", false).booleanValue() == true) goto L5;
            this.supportEncodeMaxPixels.put(ENCODE_STANDARD.ENCODE_STANDARD_ByteVC1, Integer.valueOf(VEConfigCenter.getInstance().getValue("ve_compile_hw_bytevc1_max_pixel_count", 8294400)));
        L5:
            VEVideoEncodeSettings.access$202(this.exportVideoEncodeSettings, VEConfigCenter.getInstance().getValue("vesdk_use_bytevcremux_in_publish", false).booleanValue());
        }

        private void overrideWithUserConfig() {
            VEVideoCompileEncodeSettings r100 = new VEVideoCompileEncodeSettings();
            r100.isSupportHWEncoder = VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings);
            r100.useHWEncoder = VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings);
            r100.enableHwBufferEncode = VEVideoEncodeSettings.access$2800(this.exportVideoEncodeSettings);
            if (r100.useHWEncoder == false) goto L5;
            r100.mHWEncodeSetting.mBitrate = VEVideoEncodeSettings.access$1800(this.exportVideoEncodeSettings);
            r100.mHWEncodeSetting.mProfile = VEVideoEncodeSettings.access$3100(this.exportVideoEncodeSettings);
            r100.mHWEncodeSetting.mGop = VEVideoEncodeSettings.access$2900(this.exportVideoEncodeSettings);
            r100.mHWEncodeSetting.mCodecType = VEVideoEncodeSettings.access$100(this.exportVideoEncodeSettings);
        L6:
            VEVideoEncodeSettings.access$5802(this.exportVideoEncodeSettings, r100);
            VEVideoEncodeSettings.access$5902(this.exportVideoEncodeSettings, r100);
            return;
        L5:
            r100.mSWEncodeSetting.mBitrateMode = VEVideoEncodeSettings.access$1700(this.exportVideoEncodeSettings).ordinal();
            r100.mSWEncodeSetting.mBps = VEVideoEncodeSettings.access$1800(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mCrf = VEVideoEncodeSettings.access$1900(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mQPOffset = VEVideoEncodeSettings.access$5300(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mHFpsOffset = VEVideoEncodeSettings.access$5400(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mByteVC1Crf = VEVideoEncodeSettings.access$5500(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mSDCrfRatio = VEVideoEncodeSettings.access$5600(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mFHDCrfRatio = VEVideoEncodeSettings.access$5700(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mMaxRate = VEVideoEncodeSettings.access$3200(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mPreset = VEVideoEncodeSettings.access$3000(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mProfile = VEVideoEncodeSettings.access$3100(this.exportVideoEncodeSettings);
            r100.mSWEncodeSetting.mGop = VEVideoEncodeSettings.access$2900(this.exportVideoEncodeSettings);
            goto L6
        }

        public VEVideoEncodeSettings build() {
            adjustEncodeStandard(this.exportVideoEncodeSettings);
            if (TextUtils.isEmpty(VEVideoEncodeSettings.access$4200(this.exportVideoEncodeSettings)) == true) goto L5;
            parseExternalSettingsJsonStr(VEVideoEncodeSettings.access$4200(this.exportVideoEncodeSettings));
        L6:
            int r100 = VEConfigCenter.getInstance().getValue("ve_recorder_encode_gop_size", 0);
            if (this.mUsage != 1) goto L10;
            if (r100 <= 0) goto L10;
            VEVideoEncodeSettings.access$2902(this.exportVideoEncodeSettings, r100);
        L10:
            VELogUtil.i(VEVideoEncodeSettings.TAG, "exportVideoEncodeSettings = " + this.exportVideoEncodeSettings);
            return this.exportVideoEncodeSettings;
        L5:
            overrideWithUserConfig();
            goto L6
        }

        public Builder(int r100) {
            this.supportEncodeMaxPixels = new HashMap();
            this.mUsage = r100;
            this.exportVideoEncodeSettings = new VEVideoEncodeSettings(null);
            initBuilderFromVEConfigCenter();
        }

        private void adjustEncodeStandard(VEVideoEncodeSettings r100) {
            Map<ENCODE_STANDARD, Integer> r101 = this.supportEncodeMaxPixels;
            ENCODE_STANDARD r102 = ENCODE_STANDARD.ENCODE_STANDARD_ByteVC1;
            if (r101.containsKey(r102) == false) goto L11;
            Integer r103 = this.supportEncodeMaxPixels.get(r102);
            VELogUtil.i(VEVideoEncodeSettings.TAG, "hw_bytevc1 objMaxPixelCount= " + r103 + " settings.encodeStandard= " + VEVideoEncodeSettings.access$100(r100));
            if (VEVideoEncodeSettings.access$100(r100) != r102.ordinal()) goto L12;
            if (r103 != null) goto L8;
            return;
        L8:
            if ((VEVideoEncodeSettings.access$2100(this.exportVideoEncodeSettings).width * VEVideoEncodeSettings.access$2100(this.exportVideoEncodeSettings).height) <= r103.intValue()) goto L14;
            VELogUtil.i(VEVideoEncodeSettings.TAG, "hw_bytevc1 change encode standard outputsize= " + VEVideoEncodeSettings.access$2100(this.exportVideoEncodeSettings).width + " x " + VEVideoEncodeSettings.access$2100(this.exportVideoEncodeSettings).height);
            VEVideoEncodeSettings.access$102(r100, ENCODE_STANDARD.ENCODE_STANDARD_H264.ordinal());
            return;
        L14:
            return;
        L12:
            return;
        }

        private void parseExternalSettingsJsonStr(String r110) {
            VELogUtil.i(VEVideoEncodeSettings.TAG, "ServerExternalSettingsJsonStr = " + r110);     // Catch: JSONException -> L12
            JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L12
            JSONObject r111 = JSONObjectProtectorUtils.getJSONObject(r100, "compile");     // Catch: JSONException -> L12
            boolean r101 = r100.optBoolean("bytevc_remux_enable", false);     // Catch: JSONException -> L12
            VEVideoEncodeSettings r102 = this.exportVideoEncodeSettings;     // Catch: JSONException -> L12
            if (r101 == false) goto L6;
        L9:
            boolean r112 = true;
        L10:
            VEVideoEncodeSettings.access$202(r102, r112);     // Catch: JSONException -> L12
            VELogUtil.i(VEVideoEncodeSettings.TAG, "parseExternalSettingsJsonStr enableByteVCRemuxVideo= " + VEVideoEncodeSettings.access$200(this.exportVideoEncodeSettings) + " bytevcRemuxEnable= " + r101 + " VEConfig_Enable= " + VEConfigCenter.getInstance().getValue("vesdk_use_bytevcremux_in_publish", false));     // Catch: JSONException -> L12
            VEVideoEncodeSettings.access$6002(this.exportVideoEncodeSettings, r100.optBoolean("transition_keyframe_enable", false));     // Catch: JSONException -> L12
            StringBuilder r103 = new StringBuilder("parseExternalSettingsJsonStr keyframe mTransitionKeyframeEnable=");     // Catch: JSONException -> L12
            r103.append(VEVideoEncodeSettings.access$6000(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VELogUtil.i(VEVideoEncodeSettings.TAG, r103.toString());     // Catch: JSONException -> L12
            VERuntime.getInstance().enableTransitionKeyframe(VEVideoEncodeSettings.access$6000(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VEVideoEncodeSettings.access$6102(this.exportVideoEncodeSettings, r100.optInt("transition_keyframe_version", -1));     // Catch: JSONException -> L12
            VELogUtil.i(VEVideoEncodeSettings.TAG, "parseExternalSettingsJsonStr keyframe mTransitionKeyFrameVersion=" + VEVideoEncodeSettings.access$6100(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VERuntime.getInstance().setTransitionKeyFrameVersion(VEVideoEncodeSettings.access$6100(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VEVideoEncodeSettings.access$6202(this.exportVideoEncodeSettings, r100.optInt("transition_keyframe_mode", 0));     // Catch: JSONException -> L12
            VELogUtil.i(VEVideoEncodeSettings.TAG, "parseExternalSettingsJsonStr keyframe mTransitionKeyframeMode=" + VEVideoEncodeSettings.access$6200(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VERuntime.getInstance().setTransitionKeyFrameMode(VEVideoEncodeSettings.access$6200(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VEVideoEncodeSettings.access$6302(this.exportVideoEncodeSettings, r100.optInt("transition_frame_count", 1));     // Catch: JSONException -> L12
            VELogUtil.i(VEVideoEncodeSettings.TAG, "parseExternalSettingsJsonStr mTransitionFrameCount=" + VEVideoEncodeSettings.access$6300(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VERuntime.getInstance().setTransitionFrameCount(VEVideoEncodeSettings.access$6300(this.exportVideoEncodeSettings));     // Catch: JSONException -> L12
            VEVideoEncodeSettings.access$5802(this.exportVideoEncodeSettings, parseJsonToSetting(r111));     // Catch: JSONException -> L12
            VEVideoEncodeSettings.access$5902(this.exportVideoEncodeSettings, parseJsonToSetting(JSONObjectProtectorUtils.getJSONObject(r100, "watermark_compile")));     // Catch: JSONException -> L12
            return;
        L6:
            if (VEVideoEncodeSettings.access$200(r102) == true) goto L9;
            r112 = false;
        L12:
            e = move-exception;
            e.printStackTrace();
            VELogUtil.e(VEVideoEncodeSettings.TAG, "external json str parse error : " + e.getLocalizedMessage());
        }

        private VEVideoHWEncodeSettings parseJsonToHwCompileSetting(JSONObject r210) {
            String r100 = "sd_bitrate_ratio";
            String r101 = "hevc_bitrate_ratio";
            VEVideoHWEncodeSettings r110 = new VEVideoHWEncodeSettings();
        L163:
            e = move-exception;
            e.printStackTrace();
            VELogUtil.e(VEVideoEncodeSettings.TAG, "parseJsonToHwCompileSetting : external json str parse error : " + e.getLocalizedMessage());
        L165:
            return r110;
        L5:
            if (this.mUsage == 2) goto L7;
        L13:
            int r102 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "bitrate");     // Catch: JSONException -> L163
        L11:
            long r103 = r102;
        L14:
            r110.mBitrate = r103;     // Catch: JSONException -> L163
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("platform") == true) goto L71;
            int r104 = b.f455729b[VEPlatformUtils.a().ordinal()];     // Catch: JSONException -> L163
            if (r104 == 1) goto L59;
            if (r104 == 2) goto L48;
            if (r104 == 3) goto L37;
            if (r104 != 4) goto L71;
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform").isNull("exynos") == true) goto L71;
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "exynos").isNull("bitrate") == true) goto L71;
            if (this.mUsage == 2) goto L32;
        L34:
            long r105 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "exynos"), "bitrate");     // Catch: JSONException -> L163
        L35:
            r110.mBitrate = r105;     // Catch: JSONException -> L163
            goto L71
        L32:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "exynos"), "bitrate") != (-1)) goto L34;
            r105 = r110.mBitrate;     // Catch: JSONException -> L163
            goto L35
        L37:
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform").isNull("hisi") == true) goto L71;
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "hisi").isNull("bitrate") == true) goto L71;
            if (this.mUsage == 2) goto L43;
        L45:
            long r106 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "hisi"), "bitrate");     // Catch: JSONException -> L163
        L46:
            r110.mBitrate = r106;     // Catch: JSONException -> L163
            goto L71
        L43:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "hisi"), "bitrate") != (-1)) goto L45;
            r106 = r110.mBitrate;     // Catch: JSONException -> L163
            goto L46
        L48:
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform").isNull("mtk") == true) goto L71;
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "mtk").isNull("bitrate") == true) goto L71;
            if (this.mUsage == 2) goto L54;
        L56:
            long r107 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "mtk"), "bitrate");     // Catch: JSONException -> L163
        L57:
            r110.mBitrate = r107;     // Catch: JSONException -> L163
            goto L71
        L54:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "mtk"), "bitrate") != (-1)) goto L56;
            r107 = r110.mBitrate;     // Catch: JSONException -> L163
            goto L57
        L59:
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform").isNull("qcom") == true) goto L71;
            if (JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "qcom").isNull("bitrate") == true) goto L71;
            if (this.mUsage == 2) goto L65;
        L67:
            long r108 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "qcom"), "bitrate");     // Catch: JSONException -> L163
        L68:
            r110.mBitrate = r108;     // Catch: JSONException -> L163
            goto L71
        L65:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "platform"), "qcom"), "bitrate") != (-1)) goto L67;
            r108 = r110.mBitrate;     // Catch: JSONException -> L163
        L71:
            if (this.mUsage == 2) goto L73;
        L78:
            int r109 = VEVideoEncodeProfile.valueOfString(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "profile")).ordinal();     // Catch: JSONException -> L163
        L79:
            r110.mProfile = r109;     // Catch: JSONException -> L163
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("hp_bitrate_ratio") == true) goto L89;
            if (this.mUsage == 2) goto L84;
        L86:
            double r111 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "hp_bitrate_ratio");     // Catch: JSONException -> L163
        L87:
            r110.mHp_bitrate_ratio = r111;     // Catch: JSONException -> L163
            goto L89
        L84:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "hp_bitrate_ratio") != (-1.0d)) goto L86;
            r111 = r110.mHp_bitrate_ratio;     // Catch: JSONException -> L163
        L89:
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("full_hd_bitrate_ratio") == false) goto L91;
        L97:
            String r112 = r101;
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull(r112) == true) goto L107;
            if (this.mUsage == 2) goto L102;
        L104:
            double r113 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), r112);     // Catch: JSONException -> L163
        L105:
            r110.mHevc_bitrate_ratio = r113;     // Catch: JSONException -> L163
            goto L107
        L102:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), r112) != (-1.0d)) goto L104;
            r113 = r110.mHevc_bitrate_ratio;     // Catch: JSONException -> L163
        L107:
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull(r100) == true) goto L116;
            if (this.mUsage == 2) goto L111;
        L113:
            double r114 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), r100);     // Catch: JSONException -> L163
        L114:
            r110.mSd_bitrate_ratio = r114;     // Catch: JSONException -> L163
            goto L116
        L111:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), r100) != (-1.0d)) goto L113;
            r114 = r110.mSd_bitrate_ratio;     // Catch: JSONException -> L163
        L116:
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("h_fps_bitrate_ratio") == true) goto L125;
            if (this.mUsage == 2) goto L120;
        L122:
            double r115 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "h_fps_bitrate_ratio");     // Catch: JSONException -> L163
        L123:
            r110.mH_fps_bitrate_ratio = r115;     // Catch: JSONException -> L163
            goto L125
        L120:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "h_fps_bitrate_ratio") != (-1.0d)) goto L122;
            r115 = r110.mH_fps_bitrate_ratio;     // Catch: JSONException -> L163
        L125:
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("transition_bitrate_ratio") == true) goto L134;
            if (this.mUsage == 2) goto L129;
        L131:
            double r116 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "transition_bitrate_ratio");     // Catch: JSONException -> L163
        L132:
            r110.transition_bitrate_ratio = r116;     // Catch: JSONException -> L163
            goto L134
        L129:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "transition_bitrate_ratio") != (-1.0d)) goto L131;
            r116 = r110.transition_bitrate_ratio;     // Catch: JSONException -> L163
        L134:
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("2k_bitrate_ratio") == true) goto L143;
            if (this.mUsage == 2) goto L138;
        L140:
            double r117 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "2k_bitrate_ratio");     // Catch: JSONException -> L163
        L141:
            r110.m2K_bitrate_ratio = r117;     // Catch: JSONException -> L163
            goto L143
        L138:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "2k_bitrate_ratio") != (-1.0d)) goto L140;
            r117 = r110.m2K_bitrate_ratio;     // Catch: JSONException -> L163
        L143:
            if (JSONObjectProtectorUtils.getJSONObject(r210, "hw").isNull("4k_bitrate_ratio") == true) goto L153;
            if (this.mUsage == 2) goto L147;
        L149:
            double r118 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "4k_bitrate_ratio");     // Catch: JSONException -> L163
        L150:
            r110.m4K_bitrate_ratio = r118;     // Catch: JSONException -> L163
            goto L153
        L147:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "4k_bitrate_ratio") != (-1.0d)) goto L149;
            r118 = r110.m4K_bitrate_ratio;     // Catch: JSONException -> L163
        L153:
            if (this.mUsage == 2) goto L155;
        L160:
            int r119 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "gop");     // Catch: JSONException -> L163
        L161:
            r110.mGop = r119;     // Catch: JSONException -> L163
            goto L165
        L155:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "gop") != (-1)) goto L160;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L159;
            r119 = VEVideoEncodeSettings.access$2900(this.exportVideoEncodeSettings);     // Catch: JSONException -> L163
            goto L161
        L159:
            r119 = r110.mGop;     // Catch: JSONException -> L163
            goto L161
        L91:
            if (this.mUsage == 2) goto L93;
        L95:
            double r120 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "full_hd_bitrate_ratio");     // Catch: JSONException -> L163
        L96:
            r110.mFullHd_bitrate_ratio = r120;     // Catch: JSONException -> L163
            goto L97
        L93:
            if (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "full_hd_bitrate_ratio") != (-1.0d)) goto L95;
            r120 = r110.mFullHd_bitrate_ratio;     // Catch: JSONException -> L163
            goto L96
        L73:
            if ("unknown".equals(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "profile")) == false) goto L78;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L77;
            r109 = VEVideoEncodeSettings.access$3100(this.exportVideoEncodeSettings);     // Catch: JSONException -> L163
            goto L79
        L77:
            r109 = r110.mProfile;     // Catch: JSONException -> L163
            goto L79
        L7:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r210, "hw"), "bitrate") != (-1)) goto L13;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L12;
            r102 = VEVideoEncodeSettings.access$1800(this.exportVideoEncodeSettings);     // Catch: JSONException -> L163
            goto L11
        L12:
            r100 = "sd_bitrate_ratio";
            r101 = "hevc_bitrate_ratio";
            r103 = r110.mBitrate;     // Catch: JSONException -> L163
            goto L14
        }

        private VEVideoCompileEncodeSettings parseJsonToSetting(JSONObject r110) {
            VEVideoCompileEncodeSettings r100 = new VEVideoCompileEncodeSettings();
            r100.isSupportHWEncoder = VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            r100.enableHwBufferEncode = VEVideoEncodeSettings.access$2800(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            String r101 = JSONObjectProtectorUtils.getString(r110, "encode_mode");     // Catch: JSONException -> L77
            if ("unknown".equals(r101) == true) goto L6;
        L8:
            r100.useHWEncoder = "hw".equals(r101);     // Catch: JSONException -> L77
        L9:
            VEVideoHWEncodeSettings r102 = parseJsonToHwCompileSetting(r110);     // Catch: JSONException -> L77
            r100.mHWEncodeSetting = r102;     // Catch: JSONException -> L77
            r102.mCodecType = VEVideoEncodeSettings.access$100(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            r100.mSWEncodeSetting.mBitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_CRF.ordinal();     // Catch: JSONException -> L77
            VEVideoSWEncodeSettings r103 = r100.mSWEncodeSetting;     // Catch: JSONException -> L77
            if (this.mUsage == 2) goto L13;
        L18:
            int r111 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "crf");     // Catch: JSONException -> L77
        L19:
            r103.mCrf = r111;     // Catch: JSONException -> L77
            r100.mSWEncodeSetting.mQPOffset = AudioStats.AUDIO_AMPLITUDE_NONE;     // Catch: JSONException -> L77
            if (JSONObjectProtectorUtils.getJSONObject(r110, "sw").isNull("qpoffset") == true) goto L23;
            r100.mSWEncodeSetting.mQPOffset = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "qpoffset");     // Catch: JSONException -> L77
        L23:
            r100.mSWEncodeSetting.mHFpsOffset = AudioStats.AUDIO_AMPLITUDE_NONE;     // Catch: JSONException -> L77
            if (JSONObjectProtectorUtils.getJSONObject(r110, "sw").isNull("hfpsoffset") == true) goto L27;
            r100.mSWEncodeSetting.mHFpsOffset = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "hfpsoffset");     // Catch: JSONException -> L77
        L27:
            if (JSONObjectProtectorUtils.getJSONObject(r110, "sw").isNull("bytevc1_crf") == true) goto L29;
            r100.mSWEncodeSetting.mByteVC1Crf = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "bytevc1_crf");     // Catch: JSONException -> L77
        L29:
            r100.mSWEncodeSetting.mSDCrfRatio = 1.0d;     // Catch: JSONException -> L77
            if (JSONObjectProtectorUtils.getJSONObject(r110, "sw").isNull("sd_crf_ratio") == true) goto L32;
            r100.mSWEncodeSetting.mSDCrfRatio = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "sd_crf_ratio");     // Catch: JSONException -> L77
        L32:
            r100.mSWEncodeSetting.mFHDCrfRatio = 1.0d;     // Catch: JSONException -> L77
            if (JSONObjectProtectorUtils.getJSONObject(r110, "sw").isNull("fhd_crf_ratio") == true) goto L35;
            r100.mSWEncodeSetting.mFHDCrfRatio = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "fhd_crf_ratio");     // Catch: JSONException -> L77
        L35:
            VEVideoSWEncodeSettings r104 = r100.mSWEncodeSetting;     // Catch: JSONException -> L77
            if (this.mUsage == 2) goto L39;
        L44:
            long r105 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "maxrate");     // Catch: JSONException -> L77
        L45:
            r104.mMaxRate = r105;     // Catch: JSONException -> L77
            VEVideoSWEncodeSettings r106 = r100.mSWEncodeSetting;     // Catch: JSONException -> L77
            if (this.mUsage == 2) goto L49;
        L54:
            int r107 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "preset");     // Catch: JSONException -> L77
        L55:
            r106.mPreset = r107;     // Catch: JSONException -> L77
            VEVideoSWEncodeSettings r108 = r100.mSWEncodeSetting;     // Catch: JSONException -> L77
            if (this.mUsage == 2) goto L59;
        L64:
            int r109 = VEVideoEncodeProfile.valueOfString(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "profile")).ordinal();     // Catch: JSONException -> L77
        L65:
            r108.mProfile = r109;     // Catch: JSONException -> L77
            VEVideoSWEncodeSettings r112 = r100.mSWEncodeSetting;     // Catch: JSONException -> L77
            if (this.mUsage == 2) goto L69;
        L74:
            int r113 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "gop");     // Catch: JSONException -> L77
        L75:
            r112.mGop = r113;     // Catch: JSONException -> L77
        L79:
            return r100;
        L69:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "gop") != (-1)) goto L74;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L73;
            r113 = r100.mSWEncodeSetting.mGop;     // Catch: JSONException -> L77
            goto L75
        L73:
            r113 = VEVideoEncodeSettings.access$2900(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            goto L75
        L59:
            if ("unknown".equals(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "profile")) == false) goto L64;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L63;
            r109 = r100.mSWEncodeSetting.mProfile;     // Catch: JSONException -> L77
            goto L65
        L63:
            r109 = VEVideoEncodeSettings.access$3100(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            goto L65
        L49:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "preset") != (-1)) goto L54;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L53;
            r107 = r100.mSWEncodeSetting.mPreset;     // Catch: JSONException -> L77
            goto L55
        L53:
            r107 = VEVideoEncodeSettings.access$3000(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            goto L55
        L39:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "maxrate") != (-1)) goto L44;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L43;
            r105 = r100.mSWEncodeSetting.mMaxRate;     // Catch: JSONException -> L77
            goto L45
        L43:
            r105 = VEVideoEncodeSettings.access$3200(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            goto L45
        L13:
            if (JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r110, "sw"), "crf") != (-1)) goto L18;
            if (VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings) == false) goto L17;
            r111 = r100.mSWEncodeSetting.mCrf;     // Catch: JSONException -> L77
            goto L19
        L17:
            r111 = VEVideoEncodeSettings.access$1900(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
            goto L19
        L6:
            if (this.mUsage != 2) goto L8;
            r100.useHWEncoder = VEVideoEncodeSettings.access$2700(this.exportVideoEncodeSettings);     // Catch: JSONException -> L77
        L77:
            e = move-exception;
            e.printStackTrace();
            VELogUtil.e(VEVideoEncodeSettings.TAG, "parseJsonToSetting : external json str parse error : " + e.getLocalizedMessage());
            goto L79
        }

        public Builder enableHdr10BitEncode(boolean r100) {
            VEVideoEncodeSettings.access$5102(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder enableReEncodeOpt(boolean r100) {
            VEVideoEncodeSettings.access$4802(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder enableRecordingMp4(boolean r100) {
            VEVideoEncodeSettings.access$4702(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder opRemuxWithCopying(boolean r100) {
            VEVideoEncodeSettings.access$4302(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setBanExtraDataLoop(boolean r100) {
            this.exportVideoEncodeSettings.banExtraDataLoop = r100;
            return this;
        }

        public Builder setBps(int r100) {
            VEVideoEncodeSettings.access$1702(this.exportVideoEncodeSettings, ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR);
            VEVideoEncodeSettings.access$1802(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setCompileSoftInfo(boolean r100) {
            VEVideoEncodeSettings.access$4602(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setCompileType(COMPILE_TYPE r100) {
            this.exportVideoEncodeSettings.compileType = r100;
            return this;
        }

        public Builder setEnableAvInterLeave(boolean r100) {
            VEVideoEncodeSettings.access$5002(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEnableRemuxVideo(boolean r100) {
            VEVideoEncodeSettings.access$302(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEnableRemuxVideoBitrate(int r100) {
            VEVideoEncodeSettings.access$702(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEnableRemuxVideoForByteVC(boolean r100) {
            VEVideoEncodeSettings.access$202(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEnableRemuxVideoForRotation(boolean r100) {
            VEVideoEncodeSettings.access$402(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEnableRemuxVideoForShoot(boolean r100) {
            VEVideoEncodeSettings.access$502(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEnableRemuxVideoRes(int r100) {
            VEVideoEncodeSettings.access$602(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setEncodePreset(ENCODE_PRESET r100) {
            VEVideoEncodeSettings.access$3002(this.exportVideoEncodeSettings, r100.ordinal());
            return this;
        }

        public Builder setEncodeProfile(ENCODE_PROFILE r100) {
            VEVideoEncodeSettings.access$3102(this.exportVideoEncodeSettings, r100.ordinal());
            return this;
        }

        public Builder setEncodeRotate(int r100) {
            this.exportVideoEncodeSettings.encodeRotate = r100;
            return this;
        }

        public Builder setEncodeStandard(ENCODE_STANDARD r100) {
            VEVideoEncodeSettings.access$102(this.exportVideoEncodeSettings, r100.ordinal());
            return this;
        }

        public Builder setExternalSettings(String r100) {
            VEVideoEncodeSettings.access$4202(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setFitMode(VEVideoEncodeFitMode r100) {
            VEVideoEncodeSettings.access$3802(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setFps(int r100) {
            VEVideoEncodeSettings.access$802(this.exportVideoEncodeSettings, r100);
            VEVideoEncodeSettings.access$902(this.exportVideoEncodeSettings, -1);
            return this;
        }

        public Builder setFrameRate(int r100) {
            VEVideoEncodeSettings.access$1502(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setGopSize(int r100) {
            VEVideoEncodeSettings.access$2902(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setHasBFrame(boolean r100) {
            VEVideoEncodeSettings.access$3402(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setHwBps(int r100) {
            VEVideoEncodeSettings.access$1002(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setHwBufferEnc(boolean r100) {
            VEVideoEncodeSettings.access$2802(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setHwEnc(boolean r100) {
            return setSupportHwEnc(r100);
        }

        public Builder setIFrameInterval(int r100) {
            VEVideoEncodeSettings.access$1602(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setIgnoreJsonBitrate(boolean r100) {
            VEVideoEncodeSettings.access$1202(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setKeyFrameDuration(int r100) {
            VEVideoEncodeSettings.access$3902(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setKeyFramePoints(int[] r100) {
            this.exportVideoEncodeSettings.mKeyFramePoints = r100;
            return this;
        }

        public Builder setMVStillFramesPublishFps(int r100) {
            VEVideoEncodeSettings.access$1302(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setMVStillFramesWatermarkFps(int r100) {
            VEVideoEncodeSettings.access$1402(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setMaxCacheDuration(int r100) {
            VEVideoEncodeSettings.access$4002(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setMetaComment(String r100) {
            VEVideoEncodeSettings.access$4502(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setMetaDescription(String r100) {
            VEVideoEncodeSettings.access$4402(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setMirrorMode(VEVideoEncodeMirrorMode r100) {
            VEVideoEncodeSettings.access$4102(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setQP(int r100) {
            VEVideoEncodeSettings.access$1702(this.exportVideoEncodeSettings, ENCODE_BITRATE_MODE.ENCODE_BITRATE_QP);
            VEVideoEncodeSettings.access$2002(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setResizeMode(int r100) {
            VEVideoEncodeSettings.access$2402(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setResizeX(float r100) {
            VEVideoEncodeSettings.access$2502(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setResizeY(float r100) {
            VEVideoEncodeSettings.access$2602(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setResolutionAlignment(int r100) {
            VEVideoEncodeSettings.access$4902(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setRotate(int r100) {
            VEVideoEncodeSettings.access$2302(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setSWCRF(int r100) {
            VEVideoEncodeSettings.access$1702(this.exportVideoEncodeSettings, ENCODE_BITRATE_MODE.ENCODE_BITRATE_CRF);
            VEVideoEncodeSettings.access$1902(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setSpeed(float r100) {
            VEVideoEncodeSettings.access$3302(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setSupportHwEnc(boolean r100) {
            VEVideoEncodeSettings.access$2702(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setSwMaxrate(long r100) {
            VEVideoEncodeSettings.access$3202(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setUseSoftwareDecode(boolean r100) {
            VEVideoEncodeSettings.access$1102(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setVideoBitrateMode(ENCODE_BITRATE_MODE r100) {
            VEVideoEncodeSettings.access$1702(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setVideoInvisibleWatermarkSettings(VideoInvisibleWatermarkSettings r100) {
            VEVideoEncodeSettings.access$3602(this.exportVideoEncodeSettings, r100);
            VEVideoEncodeSettings r101 = this.exportVideoEncodeSettings;
            if (VEVideoEncodeSettings.access$3600(r101) == null) goto L5;
            boolean r102 = true;
        L6:
            VEVideoEncodeSettings.access$3702(r101, r102);
            return this;
        L5:
            r102 = false;
            goto L6
        }

        public Builder setVideoTrc(int r100) {
            VEVideoEncodeSettings.access$5202(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder setWatermarkParam(VEWatermarkParam r100) {
            VEVideoEncodeSettings.access$3502(this.exportVideoEncodeSettings, r100);
            return this;
        }

        public Builder(VEVideoEncodeSettings r100) {
            this.supportEncodeMaxPixels = new HashMap();
            this.exportVideoEncodeSettings = r100;
        }

        public Builder(int r100, VEVideoEncodeSettings r101) {
            this.supportEncodeMaxPixels = new HashMap();
            this.mUsage = r100;
            this.exportVideoEncodeSettings = r101;
            initBuilderFromVEConfigCenter();
        }

        public Builder setEnableRemuxVideo(boolean r100, boolean r101) {
            VEVideoEncodeSettings.access$302(this.exportVideoEncodeSettings, r100);
            VEVideoEncodeSettings.access$402(this.exportVideoEncodeSettings, r101);
            return this;
        }

        public Builder setEncodeStandardMaxPixelCount(ENCODE_STANDARD r100, int r101) {
            this.supportEncodeMaxPixels.put(r100, Integer.valueOf(r101));
            return this;
        }

        public Builder setFps(int r100, int r101) {
            if (r101 <= 0) goto L5;
            if (r101 >= r100) goto L5;
            VEVideoEncodeSettings.access$802(this.exportVideoEncodeSettings, r100);
            VEVideoEncodeSettings.access$902(this.exportVideoEncodeSettings, r101);
        L6:
            return this;
        L5:
            VEVideoEncodeSettings.access$802(this.exportVideoEncodeSettings, r100);
            VEVideoEncodeSettings.access$902(this.exportVideoEncodeSettings, -1);
            goto L6
        }

        public Builder setVideoBitrate(ENCODE_BITRATE_MODE r100, int r101) {
            VEVideoEncodeSettings.access$1702(this.exportVideoEncodeSettings, r100);
            int r102 = b.f455728a[r100.ordinal()];
            if (r102 != 1) goto L5;
            VEVideoEncodeSettings.access$1802(this.exportVideoEncodeSettings, r101);
        L16:
            return this;
        L5:
            if (r102 != 2) goto L7;
            VEVideoEncodeSettings.access$1902(this.exportVideoEncodeSettings, r101);
            goto L16
        L7:
            if (r102 != 3) goto L9;
            VEVideoEncodeSettings.access$2002(this.exportVideoEncodeSettings, r101);
            goto L16
        L9:
            if (r102 != 4) goto L12;
            VEVideoEncodeSettings.access$1802(this.exportVideoEncodeSettings, r101);
            goto L16
        L12:
            throw new IllegalStateException("CompileTime BUG. Unhandled enum value " + r100.toString());
        }

        public Builder setVideoRes(int r100, int r101) {
            VEVideoEncodeSettings.access$2100(this.exportVideoEncodeSettings).width = r100;
            VEVideoEncodeSettings.access$2100(this.exportVideoEncodeSettings).height = r101;
            return this;
        }

        public Builder setWatermarkVideoRes(int r100, int r101) {
            VEVideoEncodeSettings.access$2200(this.exportVideoEncodeSettings).width = r100;
            VEVideoEncodeSettings.access$2200(this.exportVideoEncodeSettings).height = r101;
            return this;
        }
    }

    public static final enum COMPILE_TYPE extends Enum<COMPILE_TYPE> implements Parcelable {
        private static final /* synthetic */ COMPILE_TYPE[] $VALUES = null;
        public static final COMPILE_TYPE COMPILE_TYPE_GIF = null;
        public static final COMPILE_TYPE COMPILE_TYPE_HEIF = null;
        public static final COMPILE_TYPE COMPILE_TYPE_HIGH_GIF = null;
        public static final COMPILE_TYPE COMPILE_TYPE_JPEG = null;
        public static final COMPILE_TYPE COMPILE_TYPE_MP4 = null;
        public static final COMPILE_TYPE COMPILE_TYPE_PNG = null;
        public static final COMPILE_TYPE COMPILE_TYPE_TRANSPARENT_GIF = null;
        public static final COMPILE_TYPE COMPILE_TYPE_WEBP = null;
        public static final Parcelable.Creator<COMPILE_TYPE> CREATOR = null;

        public class a implements Parcelable.Creator<COMPILE_TYPE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final COMPILE_TYPE createFromParcel(Parcel r100) {
                return COMPILE_TYPE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final COMPILE_TYPE[] newArray(int r100) {
                return new COMPILE_TYPE[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private static /* synthetic */ COMPILE_TYPE[] $values() {
            return new COMPILE_TYPE[]{COMPILE_TYPE_MP4, COMPILE_TYPE_GIF, COMPILE_TYPE_HIGH_GIF, COMPILE_TYPE_TRANSPARENT_GIF, COMPILE_TYPE_JPEG, COMPILE_TYPE_PNG, COMPILE_TYPE_WEBP, COMPILE_TYPE_HEIF};
        }

        static {
            COMPILE_TYPE_MP4 = new COMPILE_TYPE("COMPILE_TYPE_MP4", 0);
            COMPILE_TYPE_GIF = new COMPILE_TYPE("COMPILE_TYPE_GIF", 1);
            COMPILE_TYPE_HIGH_GIF = new COMPILE_TYPE("COMPILE_TYPE_HIGH_GIF", 2);
            COMPILE_TYPE_TRANSPARENT_GIF = new COMPILE_TYPE("COMPILE_TYPE_TRANSPARENT_GIF", 3);
            COMPILE_TYPE_JPEG = new COMPILE_TYPE("COMPILE_TYPE_JPEG", 4);
            COMPILE_TYPE_PNG = new COMPILE_TYPE("COMPILE_TYPE_PNG", 5);
            COMPILE_TYPE_WEBP = new COMPILE_TYPE("COMPILE_TYPE_WEBP", 6);
            COMPILE_TYPE_HEIF = new COMPILE_TYPE("COMPILE_TYPE_HEIF", 7);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static COMPILE_TYPE[] values() {
            return (COMPILE_TYPE[]) $VALUES.clone();
        }

        public static COMPILE_TYPE valueOf(String r100) {
            return (COMPILE_TYPE) r27.a.a(COMPILE_TYPE.class, r100);
        }

        private COMPILE_TYPE(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum ENCODE_BITRATE_MODE extends Enum<ENCODE_BITRATE_MODE> implements Parcelable {
        private static final /* synthetic */ ENCODE_BITRATE_MODE[] $VALUES = null;
        public static final Parcelable.Creator<ENCODE_BITRATE_MODE> CREATOR = null;
        public static final ENCODE_BITRATE_MODE ENCODE_BITRATE_ABR = null;
        public static final ENCODE_BITRATE_MODE ENCODE_BITRATE_CRF = null;
        public static final ENCODE_BITRATE_MODE ENCODE_BITRATE_QP = null;
        public static final ENCODE_BITRATE_MODE ENCODE_BITRATE_VBR = null;
        private static final ENCODE_BITRATE_MODE[] values = null;

        public class a implements Parcelable.Creator<ENCODE_BITRATE_MODE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_BITRATE_MODE createFromParcel(Parcel r100) {
                return ENCODE_BITRATE_MODE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_BITRATE_MODE[] newArray(int r100) {
                return new ENCODE_BITRATE_MODE[r100];
            }
        }

        private static /* synthetic */ ENCODE_BITRATE_MODE[] $values() {
            return new ENCODE_BITRATE_MODE[]{ENCODE_BITRATE_ABR, ENCODE_BITRATE_CRF, ENCODE_BITRATE_QP, ENCODE_BITRATE_VBR};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            ENCODE_BITRATE_ABR = new ENCODE_BITRATE_MODE("ENCODE_BITRATE_ABR", 0);
            ENCODE_BITRATE_CRF = new ENCODE_BITRATE_MODE("ENCODE_BITRATE_CRF", 1);
            ENCODE_BITRATE_QP = new ENCODE_BITRATE_MODE("ENCODE_BITRATE_QP", 2);
            ENCODE_BITRATE_VBR = new ENCODE_BITRATE_MODE("ENCODE_BITRATE_VBR", 3);
            $VALUES = $values();
            values = values();
            CREATOR = new a();
        }

        public static ENCODE_BITRATE_MODE[] values() {
            return (ENCODE_BITRATE_MODE[]) $VALUES.clone();
        }

        public static ENCODE_BITRATE_MODE fromInteger(int r100) {
            return values[r100];
        }

        public static ENCODE_BITRATE_MODE valueOf(String r100) {
            return (ENCODE_BITRATE_MODE) r27.a.a(ENCODE_BITRATE_MODE.class, r100);
        }

        private ENCODE_BITRATE_MODE(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum ENCODE_PRESET extends Enum<ENCODE_PRESET> implements Parcelable {
        private static final /* synthetic */ ENCODE_PRESET[] $VALUES = null;
        public static final Parcelable.Creator<ENCODE_PRESET> CREATOR = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_FAST = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_FASTER = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_MEDIUM = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_PLACEBO = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_SLOW = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_SLOWER = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_SUPERFAST = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_ULTRAFAST = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_VERYFAST = null;
        public static final ENCODE_PRESET ENCODE_LEVEL_VERYSLOW = null;

        public class a implements Parcelable.Creator<ENCODE_PRESET> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_PRESET createFromParcel(Parcel r100) {
                return ENCODE_PRESET.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_PRESET[] newArray(int r100) {
                return new ENCODE_PRESET[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private static /* synthetic */ ENCODE_PRESET[] $values() {
            return new ENCODE_PRESET[]{ENCODE_LEVEL_ULTRAFAST, ENCODE_LEVEL_SUPERFAST, ENCODE_LEVEL_VERYFAST, ENCODE_LEVEL_FASTER, ENCODE_LEVEL_FAST, ENCODE_LEVEL_MEDIUM, ENCODE_LEVEL_SLOW, ENCODE_LEVEL_SLOWER, ENCODE_LEVEL_VERYSLOW, ENCODE_LEVEL_PLACEBO};
        }

        static {
            ENCODE_LEVEL_ULTRAFAST = new ENCODE_PRESET("ENCODE_LEVEL_ULTRAFAST", 0);
            ENCODE_LEVEL_SUPERFAST = new ENCODE_PRESET("ENCODE_LEVEL_SUPERFAST", 1);
            ENCODE_LEVEL_VERYFAST = new ENCODE_PRESET("ENCODE_LEVEL_VERYFAST", 2);
            ENCODE_LEVEL_FASTER = new ENCODE_PRESET("ENCODE_LEVEL_FASTER", 3);
            ENCODE_LEVEL_FAST = new ENCODE_PRESET("ENCODE_LEVEL_FAST", 4);
            ENCODE_LEVEL_MEDIUM = new ENCODE_PRESET("ENCODE_LEVEL_MEDIUM", 5);
            ENCODE_LEVEL_SLOW = new ENCODE_PRESET("ENCODE_LEVEL_SLOW", 6);
            ENCODE_LEVEL_SLOWER = new ENCODE_PRESET("ENCODE_LEVEL_SLOWER", 7);
            ENCODE_LEVEL_VERYSLOW = new ENCODE_PRESET("ENCODE_LEVEL_VERYSLOW", 8);
            ENCODE_LEVEL_PLACEBO = new ENCODE_PRESET("ENCODE_LEVEL_PLACEBO", 9);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static ENCODE_PRESET[] values() {
            return (ENCODE_PRESET[]) $VALUES.clone();
        }

        public static ENCODE_PRESET valueOf(String r100) {
            return (ENCODE_PRESET) r27.a.a(ENCODE_PRESET.class, r100);
        }

        private ENCODE_PRESET(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum ENCODE_PROFILE extends Enum<ENCODE_PROFILE> implements Parcelable {
        private static final /* synthetic */ ENCODE_PROFILE[] $VALUES = null;
        public static final Parcelable.Creator<ENCODE_PROFILE> CREATOR = null;
        public static final ENCODE_PROFILE ENCODE_PROFILE_BASELINE = null;
        public static final ENCODE_PROFILE ENCODE_PROFILE_HIGH = null;
        public static final ENCODE_PROFILE ENCODE_PROFILE_MAIN = null;
        public static final ENCODE_PROFILE ENCODE_PROFILE_UNKNOWN = null;

        public class a implements Parcelable.Creator<ENCODE_PROFILE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_PROFILE createFromParcel(Parcel r100) {
                return ENCODE_PROFILE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_PROFILE[] newArray(int r100) {
                return new ENCODE_PROFILE[r100];
            }
        }

        private static /* synthetic */ ENCODE_PROFILE[] $values() {
            return new ENCODE_PROFILE[]{ENCODE_PROFILE_UNKNOWN, ENCODE_PROFILE_BASELINE, ENCODE_PROFILE_MAIN, ENCODE_PROFILE_HIGH};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            ENCODE_PROFILE_UNKNOWN = new ENCODE_PROFILE("ENCODE_PROFILE_UNKNOWN", 0);
            ENCODE_PROFILE_BASELINE = new ENCODE_PROFILE("ENCODE_PROFILE_BASELINE", 1);
            ENCODE_PROFILE_MAIN = new ENCODE_PROFILE("ENCODE_PROFILE_MAIN", 2);
            ENCODE_PROFILE_HIGH = new ENCODE_PROFILE("ENCODE_PROFILE_HIGH", 3);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static ENCODE_PROFILE[] values() {
            return (ENCODE_PROFILE[]) $VALUES.clone();
        }

        public static ENCODE_PROFILE valueOf(String r100) {
            return (ENCODE_PROFILE) r27.a.a(ENCODE_PROFILE.class, r100);
        }

        private ENCODE_PROFILE(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum ENCODE_STANDARD extends Enum<ENCODE_STANDARD> implements Parcelable {
        private static final /* synthetic */ ENCODE_STANDARD[] $VALUES = null;
        public static final Parcelable.Creator<ENCODE_STANDARD> CREATOR = null;
        public static final ENCODE_STANDARD ENCODE_STANDARD_ByteVC1 = null;
        public static final ENCODE_STANDARD ENCODE_STANDARD_H264 = null;
        public static final ENCODE_STANDARD ENCODE_STANDARD_MPEG4 = null;

        public class a implements Parcelable.Creator<ENCODE_STANDARD> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_STANDARD createFromParcel(Parcel r100) {
                return ENCODE_STANDARD.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_STANDARD[] newArray(int r100) {
                return new ENCODE_STANDARD[r100];
            }
        }

        private static /* synthetic */ ENCODE_STANDARD[] $values() {
            return new ENCODE_STANDARD[]{ENCODE_STANDARD_H264, ENCODE_STANDARD_ByteVC1, ENCODE_STANDARD_MPEG4};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            ENCODE_STANDARD_H264 = new ENCODE_STANDARD("ENCODE_STANDARD_H264", 0);
            ENCODE_STANDARD_ByteVC1 = new ENCODE_STANDARD("ENCODE_STANDARD_ByteVC1", 1);
            ENCODE_STANDARD_MPEG4 = new ENCODE_STANDARD("ENCODE_STANDARD_MPEG4", 2);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static ENCODE_STANDARD[] values() {
            return (ENCODE_STANDARD[]) $VALUES.clone();
        }

        public static ENCODE_STANDARD valueOf(String r100) {
            return (ENCODE_STANDARD) r27.a.a(ENCODE_STANDARD.class, r100);
        }

        private ENCODE_STANDARD(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum VEVideoEncodeFitMode extends Enum<VEVideoEncodeFitMode> implements Parcelable {
        public static final VEVideoEncodeFitMode CENTER_CROP = null;
        public static final VEVideoEncodeFitMode CENTER_INSIDE = null;
        public static final Parcelable.Creator<VEVideoEncodeFitMode> CREATOR = null;
        public static final VEVideoEncodeFitMode NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEVideoEncodeFitMode[] f455726a = null;

        public class a implements Parcelable.Creator<VEVideoEncodeFitMode> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VEVideoEncodeFitMode createFromParcel(Parcel r100) {
                return VEVideoEncodeFitMode.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final VEVideoEncodeFitMode[] newArray(int r100) {
                return new VEVideoEncodeFitMode[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            VEVideoEncodeFitMode r100 = new VEVideoEncodeFitMode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            VEVideoEncodeFitMode r101 = new VEVideoEncodeFitMode("CENTER_INSIDE", 1);
            CENTER_INSIDE = r101;
            VEVideoEncodeFitMode r102 = new VEVideoEncodeFitMode("CENTER_CROP", 2);
            CENTER_CROP = r102;
            f455726a = new VEVideoEncodeFitMode[]{r100, r101, r102};
            CREATOR = new a();
        }

        public static VEVideoEncodeFitMode[] values() {
            return (VEVideoEncodeFitMode[]) f455726a.clone();
        }

        public static VEVideoEncodeFitMode valueOf(String r100) {
            return (VEVideoEncodeFitMode) r27.a.a(VEVideoEncodeFitMode.class, r100);
        }

        public VEVideoEncodeFitMode(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum VEVideoEncodeMirrorMode extends Enum<VEVideoEncodeMirrorMode> implements Parcelable {
        public static final Parcelable.Creator<VEVideoEncodeMirrorMode> CREATOR = null;
        public static final VEVideoEncodeMirrorMode NO_MIRROR = null;
        public static final VEVideoEncodeMirrorMode X_MIRROR = null;
        public static final VEVideoEncodeMirrorMode Y_MIRROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEVideoEncodeMirrorMode[] f455727a = null;

        public class a implements Parcelable.Creator<VEVideoEncodeMirrorMode> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VEVideoEncodeMirrorMode createFromParcel(Parcel r100) {
                return VEVideoEncodeMirrorMode.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final VEVideoEncodeMirrorMode[] newArray(int r100) {
                return new VEVideoEncodeMirrorMode[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            VEVideoEncodeMirrorMode r100 = new VEVideoEncodeMirrorMode("NO_MIRROR", 0);
            NO_MIRROR = r100;
            VEVideoEncodeMirrorMode r101 = new VEVideoEncodeMirrorMode("X_MIRROR", 1);
            X_MIRROR = r101;
            VEVideoEncodeMirrorMode r102 = new VEVideoEncodeMirrorMode("Y_MIRROR", 2);
            Y_MIRROR = r102;
            f455727a = new VEVideoEncodeMirrorMode[]{r100, r101, r102};
            CREATOR = new a();
        }

        public static VEVideoEncodeMirrorMode[] values() {
            return (VEVideoEncodeMirrorMode[]) f455727a.clone();
        }

        public static VEVideoEncodeMirrorMode valueOf(String r100) {
            return (VEVideoEncodeMirrorMode) r27.a.a(VEVideoEncodeMirrorMode.class, r100);
        }

        public VEVideoEncodeMirrorMode(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public class a implements Parcelable.Creator<VEVideoEncodeSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoEncodeSettings createFromParcel(Parcel r100) {
            return new VEVideoEncodeSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoEncodeSettings[] newArray(int r100) {
            return new VEVideoEncodeSettings[r100];
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f455728a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f455729b = null;

        static {
            int[] r100 = new int[VEPlatformUtils.VEPlatform.values().length];
            f455729b = r100;
            r100[VEPlatformUtils.VEPlatform.PLATFORM_QCOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L24:
            f455729b[VEPlatformUtils.VEPlatform.PLATFORM_MTK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L30:
            f455729b[VEPlatformUtils.VEPlatform.PLATFORM_HISI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L38:
            f455729b[VEPlatformUtils.VEPlatform.PLATFORM_EXYNOS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r101 = new int[ENCODE_BITRATE_MODE.values().length];
            f455728a = r101;
            r101[ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L26:
            f455728a[ENCODE_BITRATE_MODE.ENCODE_BITRATE_CRF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L28:
            f455728a[ENCODE_BITRATE_MODE.ENCODE_BITRATE_QP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L34:
            f455728a[ENCODE_BITRATE_MODE.ENCODE_BITRATE_VBR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    private void initFromVEConfigCenter() {
        if (this.enableHwBufferEncode == true) goto L6;
        boolean r100 = false;
        if (VEConfigCenter.getInstance().getValue("ve_enable_compile_buffer_hw_encode", false).booleanValue() == true) goto L6;
    L7:
        this.enableHwBufferEncode = r100;
        VELogUtil.i(TAG, "KEY_ENABLE_BUFFER_HW_COMPILE: " + this.enableHwBufferEncode);
        this.banExtraDataLoop = true;
        VELogUtil.i(TAG, "AB isBanExtraDataLoop: " + this.banExtraDataLoop);
        VEConfigCenter.ValuePkt r101 = VEConfigCenter.getInstance().getValue("remux_video_res");
        if (r101 != null) goto L10;
    L14:
        VELogUtil.i(TAG, "No remux video resolution config");
    L15:
        VELogUtil.i(TAG, "KEY_ENABLE_BUFFER_HW_COMPILE: " + this.enableHwBufferEncode);
        return;
    L10:
        if (r101.getValue() == null) goto L14;
        if ((r101.getValue() instanceof Integer) == false) goto L14;
        int r102 = ((Integer) r101.getValue()).intValue();
        this.enableRemuxVideoRes = r102;
        VELogUtil.i(TAG, "remuxVideoRes = " + r102);
    L6:
        r100 = true;
        goto L7
    }

    public int getBitrateValue() {
        int r100 = b.f455728a[this.bitrateMode.ordinal()];
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 != 4) goto L13;
        return getBps();
    L13:
        throw new IllegalStateException("CompileTime BUG by SDK. Unhandled ENCODE_BITRATE_MODE enum value.");
    L15:
        return getSwQP();
    L17:
        return getSwCRF();
    L19:
        return getBps();
    }

    public Float getImageCompileQuality() {
        return Float.valueOf(this.image_compile_quality);
    }

    public String toString() {
        return "VEVideoEncodeSettings{compileType=" + this.compileType + ", rotate=" + this.rotate + ", resizeMode=" + this.resizeMode + ", resizeX=" + this.resizeX + ", resizeY=" + this.resizeY + ", speed=" + this.speed + ", outputSize=" + this.outputSize + ", watermarkSize=" + this.watermarkSize + ", bitrateMode=" + this.bitrateMode + ", bps=" + this.bps + ", swCRF=" + this.swCRF + ", swQPOffset=" + this.swQPOffset + ", swHFpsOffset=" + this.swHFpsOffset + ", swByteVC1Crf=" + this.swByteVC1Crf + ", swSDCrfRatio=" + this.swSDCrfRatio + ", swFHDCrfRatio=" + this.swFHDCrfRatio + ", swQP=" + this.swQP + ", fps=" + this.fps + ", publishFps=" + this.publishFps + ", mvStillFramesPublishFps=" + this.mvStillFramesPublishFps + ", mvStillFramesWatermarkFps=" + this.mvStillFramesWatermarkFps + ", gopSize=" + this.gopSize + ", swPreset=" + this.swPreset + ", encodeStandard=" + this.encodeStandard + ", encodeProfile=" + this.encodeProfile + ", swMaxrate=" + this.swMaxrate + ", isSupportHWEncoder=" + this.isSupportHWEncoder + ", enableHwBufferEncode=" + this.enableHwBufferEncode + ", enableRemuxVideo=" + this.enableRemuxVideo + ", enableRemuxVideoForRotation=" + this.enableRemuxVideoForRotation + ", enableRemuxVideoForShoot=" + this.enableRemuxVideoForShoot + ", enableByteVCRemuxVideo=" + this.enableByteVCRemuxVideo + ", enableInterLeave=" + this.enableInterLeave + ", enableAvInterLeave=" + this.enableAvInterLeave + ", enableHdr10BitEncode=" + this.enableHdr10BitEncode + ", hasBFrame=" + this.hasBFrame + ", mWatermarkParam=" + this.mWatermarkParam + ", mVideoWatermarkCompileEncodeSetting=" + this.mVideoWatermarkCompileEncodeSetting + ", mEnableInvisibleWatermark=" + this.mEnableInvisibleWatermark + ", mVideoInvisibleWatermarkSettings=" + this.mVideoInvisibleWatermarkSettings + ", mVideoCompileEncodeSetting=" + this.mVideoCompileEncodeSetting + ", mOptRemuxWithCopy=" + this.mOptRemuxWithCopy + ", mReEncodeOpt=" + this.mReEncodeOpt + ", mDescripiton=" + this.mDescription + ", mComment=" + this.mComment + ", mFitMode=" + this.mFitMode + ", videoTrc=" + this.mVideoTrc + ", encodeRotate=" + this.encodeRotate + '}';
    }

    private VEVideoEncodeSettings() {
        this.mFitMode = VEVideoEncodeFitMode.CENTER_CROP;
        this.mMirrorMode = VEVideoEncodeMirrorMode.NO_MIRROR;
        this.rotate = 0;
        this.resizeMode = 2;
        this.resizeX = 0.0f;
        this.resizeY = 0.0f;
        this.speed = 1.0f;
        this.outputSize = new VESize(576, 1024);
        this.watermarkSize = new VESize(-1, -1);
        this.externalSettingsJsonStr = null;
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR;
        this.bps = 4194304;
        this.ignoreJsonBitrate = false;
        this.HwBps = -1;
        this.useSoftwareDecode = false;
        this.frameRate = 30;
        this.iFrameInterval = 1;
        this.swCRF = 19;
        this.swQPOffset = -1.0d;
        this.swHFpsOffset = 1.0d;
        this.swByteVC1Crf = 22;
        this.swSDCrfRatio = 1.0d;
        this.swFHDCrfRatio = 1.0d;
        this.swQP = 15;
        this.fps = -1;
        this.publishFps = -1;
        this.mvStillFramesPublishFps = -1;
        this.mvStillFramesWatermarkFps = -1;
        this.gopSize = 60;
        this.keyFrameDuration = -1;
        this.maxCacheDuration = -1;
        this.swPreset = ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.encodeStandard = ENCODE_STANDARD.ENCODE_STANDARD_H264.ordinal();
        this.encodeProfile = ENCODE_PROFILE.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.swMaxrate = 15000000;
        this.enableRemuxVideoRes = -1;
        this.enableRemuxVideoFPS = -1;
        this.enableRemuxVideoBitrate = -1;
        this.uploadingWithSynthesisCancelWritefile = false;
        this.enableUploadDirectly = false;
        this.enableCopyWithMetadata = false;
        this.hasBFrame = false;
        this.mEnableInvisibleWatermark = false;
        this.mVideoInvisibleWatermarkSettings = null;
        this.mRecordingMp4 = false;
        this.mTransitionKeyframeEnable = false;
        this.mTransitionKeyFrameVersion = -1;
        this.mTransitionFrameCount = 1;
        this.mTransitionKeyFrameMode = 0;
        this.mReEncodeOpt = false;
        this.mResolutionAlign = 16;
        this.mKeyFramePoints = null;
        this.banExtraDataLoop = false;
        this.image_compile_quality = 100.0f;
        this.encodeRotate = 0;
        this.qualityScoreType = VEQualityScoreType.VQScoreNone;
        this.qualityScoreSequenceId = "";
        VESize r100 = this.outputSize;
        r100.width = 576;
        r100.height = 1024;
        VESize r101 = this.watermarkSize;
        r101.width = -1;
        r101.height = -1;
        this.fps = -1;
        this.bps = 4194304;
        this.isSupportHWEncoder = true;
        this.compileType = COMPILE_TYPE.COMPILE_TYPE_MP4;
        initFromVEConfigCenter();
    }

    public boolean isSupportHwEnc() {
        if (VEConfigCenter.getInstance().getValue("ve_enable_titan_sw_encode", false).booleanValue() == false) goto L6;
        return false;
    L6:
        return this.isSupportHWEncoder;
    }

    public boolean IsIgnoreJsonBitrate() {
        return this.ignoreJsonBitrate;
    }

    public ENCODE_BITRATE_MODE getBitrateMode() {
        return this.bitrateMode;
    }

    public int getBps() {
        return this.bps;
    }

    public String getComment() {
        return this.mComment;
    }

    public COMPILE_TYPE getCompileType() {
        return this.compileType;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public boolean getEnableCopyWithMetadata() {
        return this.enableCopyWithMetadata;
    }

    public boolean getEnableInvisibleWatermark() {
        return this.mEnableInvisibleWatermark;
    }

    public int getEnableRemuxVideoBitrate() {
        return this.enableRemuxVideoBitrate;
    }

    public int getEnableRemuxVideoRes() {
        return this.enableRemuxVideoRes;
    }

    public boolean getEnableUploadDirectly() {
        return this.enableUploadDirectly;
    }

    public int getEncodeProfile() {
        return this.encodeProfile;
    }

    public int getEncodeRotate() {
        return this.encodeRotate;
    }

    public int getEncodeStandard() {
        return this.encodeStandard;
    }

    public String getExternalSettingsJsonStr() {
        return this.externalSettingsJsonStr;
    }

    public VEVideoEncodeFitMode getFitMode() {
        return this.mFitMode;
    }

    public int getFps() {
        return this.fps;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getGopSize() {
        return this.gopSize;
    }

    public int getHwBps() {
        return this.HwBps;
    }

    public int getIFrameInterval() {
        return this.iFrameInterval;
    }

    public int getKeyFrameDuration() {
        return this.keyFrameDuration;
    }

    public int[] getKeyFramePoints() {
        return this.mKeyFramePoints;
    }

    public int getMVStillFramesPublishFps() {
        return this.mvStillFramesPublishFps;
    }

    public int getMVStillFramesWatermarkFps() {
        return this.mvStillFramesWatermarkFps;
    }

    public int getMVideoTrc() {
        return this.mVideoTrc;
    }

    public int getMaxCacheDuration() {
        return this.maxCacheDuration;
    }

    public VEVideoEncodeMirrorMode getMirrorMode() {
        return this.mMirrorMode;
    }

    public int getPublishFps() {
        return this.publishFps;
    }

    public String getQualityScoreSequenceId() {
        return this.qualityScoreSequenceId;
    }

    public VEQualityScoreType getQualityScoreType() {
        return this.qualityScoreType;
    }

    public int getResizeMode() {
        return this.resizeMode;
    }

    public float getResizeX() {
        return this.resizeX;
    }

    public float getResizeY() {
        return this.resizeY;
    }

    public int getResolutionAlignment() {
        return this.mResolutionAlign;
    }

    public int getRotate() {
        return this.rotate;
    }

    public float getSpeed() {
        return this.speed;
    }

    public int getSwCRF() {
        return this.swCRF;
    }

    public long getSwMaxRate() {
        return this.swMaxrate;
    }

    public int getSwPreset() {
        return this.swPreset;
    }

    public int getSwQP() {
        return this.swQP;
    }

    public boolean getUploadingWithSynthesisCancelWritefile() {
        return this.uploadingWithSynthesisCancelWritefile;
    }

    public boolean getUseSoftwareDecode() {
        return this.useSoftwareDecode;
    }

    public VEVideoCompileEncodeSettings getVideoCompileEncodeSetting() {
        return this.mVideoCompileEncodeSetting;
    }

    public VideoInvisibleWatermarkSettings getVideoInvisibleWatermarkSettings() {
        return this.mVideoInvisibleWatermarkSettings;
    }

    public VESize getVideoRes() {
        return this.outputSize;
    }

    public VEVideoCompileEncodeSettings getWatermarkCompileEncodeSetting() {
        return this.mVideoWatermarkCompileEncodeSetting;
    }

    public VEWatermarkParam getWatermarkParam() {
        return this.mWatermarkParam;
    }

    public VESize getWatermarkVideoRes() {
        return this.watermarkSize;
    }

    public boolean isBanExtraDataLoop() {
        return this.banExtraDataLoop;
    }

    public boolean isCompileSoftInfo() {
        return this.mCompileSoftInfo;
    }

    public boolean isEnableAvInterLeave() {
        return this.enableAvInterLeave;
    }

    public boolean isEnableByteVCRemuxVideo() {
        return this.enableByteVCRemuxVideo;
    }

    public boolean isEnableHdr10BitEncode() {
        return this.enableHdr10BitEncode;
    }

    public boolean isEnableHwBufferEncode() {
        return this.enableHwBufferEncode;
    }

    public boolean isEnableInterLeave() {
        return this.enableInterLeave;
    }

    public boolean isEnableRemuxVideo() {
        return this.enableRemuxVideo;
    }

    public boolean isEnableRemuxVideoForRotation() {
        return this.enableRemuxVideoForRotation;
    }

    public boolean isEnableRemuxVideoForShoot() {
        return this.enableRemuxVideoForShoot;
    }

    public int isEnableRemuxVideoRes() {
        return this.enableRemuxVideoRes;
    }

    public boolean isHasBFrame() {
        return this.hasBFrame;
    }

    public boolean isOptRemuxWithCopy() {
        return this.mOptRemuxWithCopy;
    }

    public boolean isReEncodeOpt() {
        return this.mReEncodeOpt;
    }

    public boolean isRecordingMp4() {
        return this.mRecordingMp4;
    }

    public VEVideoEncodeSettings(Parcel r100) {
        this.mFitMode = VEVideoEncodeFitMode.CENTER_CROP;
        this.mMirrorMode = VEVideoEncodeMirrorMode.NO_MIRROR;
        boolean r101 = false;
        this.rotate = 0;
        this.resizeMode = 2;
        this.resizeX = 0.0f;
        this.resizeY = 0.0f;
        this.speed = 1.0f;
        this.outputSize = new VESize(576, 1024);
        this.watermarkSize = new VESize(-1, -1);
        this.externalSettingsJsonStr = null;
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR;
        this.bps = 4194304;
        this.ignoreJsonBitrate = false;
        this.HwBps = -1;
        this.useSoftwareDecode = false;
        this.frameRate = 30;
        this.iFrameInterval = 1;
        this.swCRF = 19;
        this.swQPOffset = -1.0d;
        this.swHFpsOffset = 1.0d;
        this.swByteVC1Crf = 22;
        this.swSDCrfRatio = 1.0d;
        this.swFHDCrfRatio = 1.0d;
        this.swQP = 15;
        this.fps = -1;
        this.publishFps = -1;
        this.mvStillFramesPublishFps = -1;
        this.mvStillFramesWatermarkFps = -1;
        this.gopSize = 60;
        this.keyFrameDuration = -1;
        this.maxCacheDuration = -1;
        this.swPreset = ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.encodeStandard = ENCODE_STANDARD.ENCODE_STANDARD_H264.ordinal();
        this.encodeProfile = ENCODE_PROFILE.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.swMaxrate = 15000000;
        this.enableRemuxVideoRes = -1;
        this.enableRemuxVideoFPS = -1;
        this.enableRemuxVideoBitrate = -1;
        this.uploadingWithSynthesisCancelWritefile = false;
        this.enableUploadDirectly = false;
        this.enableCopyWithMetadata = false;
        this.hasBFrame = false;
        this.mEnableInvisibleWatermark = false;
        this.mVideoInvisibleWatermarkSettings = null;
        this.mRecordingMp4 = false;
        this.mTransitionKeyframeEnable = false;
        this.mTransitionKeyFrameVersion = -1;
        this.mTransitionFrameCount = 1;
        this.mTransitionKeyFrameMode = 0;
        this.mReEncodeOpt = false;
        this.mResolutionAlign = 16;
        this.mKeyFramePoints = null;
        this.banExtraDataLoop = false;
        this.image_compile_quality = 100.0f;
        this.encodeRotate = 0;
        this.qualityScoreType = VEQualityScoreType.VQScoreNone;
        this.qualityScoreSequenceId = "";
        this.compileType = (COMPILE_TYPE) r100.readParcelable(COMPILE_TYPE.class.getClassLoader());
        this.rotate = r100.readInt();
        this.resizeMode = r100.readInt();
        this.resizeX = r100.readFloat();
        this.resizeY = r100.readFloat();
        this.speed = r100.readFloat();
        this.outputSize = (VESize) r100.readParcelable(VESize.class.getClassLoader());
        this.watermarkSize = (VESize) r100.readParcelable(VESize.class.getClassLoader());
        this.bitrateMode = (ENCODE_BITRATE_MODE) r100.readParcelable(ENCODE_BITRATE_MODE.class.getClassLoader());
        this.bps = r100.readInt();
        this.fps = r100.readInt();
        this.publishFps = r100.readInt();
        this.mvStillFramesPublishFps = r100.readInt();
        this.mvStillFramesWatermarkFps = r100.readInt();
        this.swCRF = r100.readInt();
        this.swQPOffset = r100.readDouble();
        this.swHFpsOffset = r100.readDouble();
        this.swByteVC1Crf = r100.readInt();
        this.swSDCrfRatio = r100.readDouble();
        this.swFHDCrfRatio = r100.readDouble();
        this.swQP = r100.readInt();
        this.gopSize = r100.readInt();
        this.swPreset = r100.readInt();
        this.encodeStandard = r100.readInt();
        this.encodeProfile = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isSupportHWEncoder = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.enableRemuxVideo = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.enableRemuxVideoForRotation = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.enableRemuxVideoForShoot = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.enableInterLeave = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.enableAvInterLeave = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.enableHdr10BitEncode = r108;
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.hasBFrame = r109;
        this.swMaxrate = r100.readLong();
        this.mWatermarkParam = (VEWatermarkParam) r100.readParcelable(VEWatermarkParam.class.getClassLoader());
        this.mVideoWatermarkCompileEncodeSetting = (VEVideoCompileEncodeSettings) r100.readParcelable(VEVideoCompileEncodeSettings.class.getClassLoader());
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.mEnableInvisibleWatermark = r110;
        this.mVideoInvisibleWatermarkSettings = (VideoInvisibleWatermarkSettings) r100.readParcelable(VideoInvisibleWatermarkSettings.class.getClassLoader());
        this.mVideoCompileEncodeSetting = (VEVideoCompileEncodeSettings) r100.readParcelable(VEVideoCompileEncodeSettings.class.getClassLoader());
        this.externalSettingsJsonStr = r100.readString();
        if (r100.readByte() == 0) goto L41;
        boolean r111 = true;
    L42:
        this.mOptRemuxWithCopy = r111;
        this.mDescription = r100.readString();
        this.mComment = r100.readString();
        if (r100.readByte() == 0) goto L45;
        boolean r112 = true;
    L46:
        this.mCompileSoftInfo = r112;
        if (r100.readByte() == 0) goto L49;
        boolean r113 = true;
    L50:
        this.mRecordingMp4 = r113;
        if (r100.readByte() == 0) goto L53;
        boolean r114 = true;
    L54:
        this.enableHwBufferEncode = r114;
        if (r100.readByte() == 0) goto L57;
        boolean r115 = true;
    L58:
        this.mReEncodeOpt = r115;
        this.mResolutionAlign = r100.readInt();
        if (r100.readByte() == 0) goto L61;
        r101 = true;
    L61:
        this.banExtraDataLoop = r101;
        this.mFitMode = (VEVideoEncodeFitMode) r100.readParcelable(VEVideoEncodeFitMode.class.getClassLoader());
        this.mMirrorMode = (VEVideoEncodeMirrorMode) r100.readParcelable(VEVideoEncodeMirrorMode.class.getClassLoader());
        this.frameRate = r100.readInt();
        this.iFrameInterval = r100.readInt();
        this.mVideoTrc = r100.readInt();
        this.encodeRotate = r100.readInt();
        return;
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r113 = false;
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public static /* synthetic */ int access$100(VEVideoEncodeSettings r100) {
        return r100.encodeStandard;
    }

    public static /* synthetic */ ENCODE_BITRATE_MODE access$1700(VEVideoEncodeSettings r100) {
        return r100.bitrateMode;
    }

    public static /* synthetic */ int access$1800(VEVideoEncodeSettings r100) {
        return r100.bps;
    }

    public static /* synthetic */ int access$1900(VEVideoEncodeSettings r100) {
        return r100.swCRF;
    }

    public static /* synthetic */ boolean access$200(VEVideoEncodeSettings r100) {
        return r100.enableByteVCRemuxVideo;
    }

    public static /* synthetic */ VESize access$2100(VEVideoEncodeSettings r100) {
        return r100.outputSize;
    }

    public static /* synthetic */ VESize access$2200(VEVideoEncodeSettings r100) {
        return r100.watermarkSize;
    }

    public static /* synthetic */ boolean access$2700(VEVideoEncodeSettings r100) {
        return r100.isSupportHWEncoder;
    }

    public static /* synthetic */ boolean access$2800(VEVideoEncodeSettings r100) {
        return r100.enableHwBufferEncode;
    }

    public static /* synthetic */ int access$2900(VEVideoEncodeSettings r100) {
        return r100.gopSize;
    }

    public static /* synthetic */ int access$3000(VEVideoEncodeSettings r100) {
        return r100.swPreset;
    }

    public static /* synthetic */ int access$3100(VEVideoEncodeSettings r100) {
        return r100.encodeProfile;
    }

    public static /* synthetic */ long access$3200(VEVideoEncodeSettings r100) {
        return r100.swMaxrate;
    }

    public static /* synthetic */ VideoInvisibleWatermarkSettings access$3600(VEVideoEncodeSettings r100) {
        return r100.mVideoInvisibleWatermarkSettings;
    }

    public static /* synthetic */ String access$4200(VEVideoEncodeSettings r100) {
        return r100.externalSettingsJsonStr;
    }

    public static /* synthetic */ double access$5300(VEVideoEncodeSettings r100) {
        return r100.swQPOffset;
    }

    public static /* synthetic */ double access$5400(VEVideoEncodeSettings r100) {
        return r100.swHFpsOffset;
    }

    public static /* synthetic */ int access$5500(VEVideoEncodeSettings r100) {
        return r100.swByteVC1Crf;
    }

    public static /* synthetic */ double access$5600(VEVideoEncodeSettings r100) {
        return r100.swSDCrfRatio;
    }

    public static /* synthetic */ double access$5700(VEVideoEncodeSettings r100) {
        return r100.swFHDCrfRatio;
    }

    public static /* synthetic */ boolean access$6000(VEVideoEncodeSettings r100) {
        return r100.mTransitionKeyframeEnable;
    }

    public static /* synthetic */ int access$6100(VEVideoEncodeSettings r100) {
        return r100.mTransitionKeyFrameVersion;
    }

    public static /* synthetic */ int access$6200(VEVideoEncodeSettings r100) {
        return r100.mTransitionKeyFrameMode;
    }

    public static /* synthetic */ int access$6300(VEVideoEncodeSettings r100) {
        return r100.mTransitionFrameCount;
    }

    public void adjustVideoCompileEncodeSetting(int r100) {
        if (r100 != 1) goto L5;
        VEVideoCompileEncodeSettings r101 = this.mVideoWatermarkCompileEncodeSetting;
        if (r101 == null) goto L17;
        this.mVideoCompileEncodeSetting = r101;
    L17:
        if (this.watermarkSize.isValid() == false) goto L22;
        VESize r102 = this.outputSize;
        VESize r103 = this.watermarkSize;
        r102.width = r103.width;
        r102.height = r103.height;
        return;
    L22:
        return;
    L5:
        if (r100 != 2) goto L23;
        VEVideoCompileEncodeSettings r104 = this.mVideoCompileEncodeSetting;
        if (r104 == null) goto L11;
        this.mVideoWatermarkCompileEncodeSetting = r104;
    L11:
        if (this.outputSize.isValid() == false) goto L20;
        VESize r105 = this.watermarkSize;
        VESize r106 = this.outputSize;
        r105.width = r106.width;
        r105.height = r106.height;
        return;
    L20:
        return;
    }

    public void setBps(int r100) {
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_VBR;
        this.bps = r100;
    }

    public void setCompileType(COMPILE_TYPE r100) {
        this.compileType = r100;
    }

    public void setEnableAvInterLeave(boolean r100) {
        this.enableAvInterLeave = r100;
    }

    public void setEnableCopyWithMetadata(boolean r100) {
        this.enableCopyWithMetadata = r100;
    }

    public void setEnableHdr10BitEncode(boolean r100) {
        this.enableHdr10BitEncode = r100;
    }

    public void setEnableInterLeave(boolean r100) {
        this.enableInterLeave = r100;
    }

    public void setEnableRemuxVideo(boolean r100) {
        this.enableRemuxVideo = r100;
    }

    public void setEnableRemuxVideoBitrate(int r100) {
        this.enableRemuxVideoBitrate = r100;
    }

    public void setEnableRemuxVideoFPS(int r100) {
        this.enableRemuxVideoFPS = r100;
    }

    public void setEnableRemuxVideoForRotation(boolean r100) {
        this.enableRemuxVideoForRotation = r100;
    }

    public void setEnableRemuxVideoForShoot(boolean r100) {
        this.enableRemuxVideoForShoot = r100;
    }

    public void setEnableRemuxVideoRes(int r100) {
        this.enableRemuxVideoRes = r100;
    }

    public void setEnableUploadDirectly(boolean r100) {
        this.enableUploadDirectly = r100;
    }

    public void setEncodeProfile(ENCODE_PROFILE r100) {
        this.encodeProfile = r100.ordinal();
    }

    public void setEncodeRotate(int r100) {
        this.encodeRotate = r100;
    }

    public void setFitMode(VEVideoEncodeFitMode r100) {
        this.mFitMode = r100;
    }

    public void setFps(int r100) {
        this.fps = r100;
        this.publishFps = -1;
    }

    public void setGopSize(int r100) {
        this.gopSize = r100;
    }

    public void setHwBps(int r100) {
        this.HwBps = r100;
    }

    public void setIgnoreJsonBitrate(boolean r100) {
        this.ignoreJsonBitrate = r100;
    }

    public void setImageCompileQuality(float r100) {
        this.image_compile_quality = r100;
    }

    public void setMVStillFramesPublishFps(int r100) {
        this.mvStillFramesPublishFps = r100;
    }

    public void setMVStillFramesWatermarkFps(int r100) {
        this.mvStillFramesWatermarkFps = r100;
    }

    public void setQP(int r100) {
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_QP;
        this.swQP = r100;
    }

    public void setQualityScoreSequenceId(String r100) {
        this.qualityScoreSequenceId = r100;
    }

    public void setQualityScoreType(VEQualityScoreType r100) {
        this.qualityScoreType = r100;
    }

    public void setResizeMode(int r100) {
        this.resizeMode = r100;
    }

    public void setResizeX(float r100) {
        this.resizeX = r100;
    }

    public void setResizeY(float r100) {
        this.resizeY = r100;
    }

    public void setRotate(int r100) {
        this.rotate = r100;
    }

    public void setSWCRF(int r100) {
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_CRF;
        this.swCRF = r100;
    }

    public void setSpeed(float r100) {
        this.speed = r100;
    }

    public void setSupportHwEnc(boolean r100) {
        this.isSupportHWEncoder = r100;
    }

    public void setSwPreset(ENCODE_PRESET r100) {
        this.swPreset = r100.ordinal();
    }

    public void setUploadingWithSynthesisCancelWritefile(boolean r100) {
        this.uploadingWithSynthesisCancelWritefile = r100;
    }

    public void setUseSoftwareDecode(boolean r100) {
        this.useSoftwareDecode = r100;
    }

    public boolean setVideoHwEnc(boolean r100) {
        VEVideoCompileEncodeSettings r101 = this.mVideoCompileEncodeSetting;
        if (r101.isSupportHWEncoder == false) goto L5;
        r101.useHWEncoder = r100;
    L7:
        return r101.useHWEncoder;
    L5:
        r101.useHWEncoder = false;
        goto L7
    }

    public boolean setVideoInvisibleWatermarkSettings(VideoInvisibleWatermarkSettings r100) {
        this.mVideoInvisibleWatermarkSettings = r100;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.mEnableInvisibleWatermark = r101;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public void setVideoSWOptCrf(int r100) {
        this.mVideoCompileEncodeSetting.mSWEncodeSetting.mCrf = r100;
    }

    public void setVideoTrc(int r100) {
        this.mVideoTrc = r100;
    }

    public boolean setWatermark(VEWatermarkParam r100) {
        if (r100 != null) goto L4;
        this.mWatermarkParam = null;
        return true;
    L4:
        if (r100.getEntities() == null) goto L6;
        this.mWatermarkParam = r100;
        return true;
    L6:
        return false;
    }

    public /* synthetic */ VEVideoEncodeSettings(a r100) {
        this();
    }

    public VEVideoEncodeSettings(VESize r100, boolean r101) {
        this.mFitMode = VEVideoEncodeFitMode.CENTER_CROP;
        this.mMirrorMode = VEVideoEncodeMirrorMode.NO_MIRROR;
        this.rotate = 0;
        this.resizeMode = 2;
        this.resizeX = 0.0f;
        this.resizeY = 0.0f;
        this.speed = 1.0f;
        this.outputSize = new VESize(576, 1024);
        this.watermarkSize = new VESize(-1, -1);
        this.externalSettingsJsonStr = null;
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR;
        this.bps = 4194304;
        this.ignoreJsonBitrate = false;
        this.HwBps = -1;
        this.useSoftwareDecode = false;
        this.frameRate = 30;
        this.iFrameInterval = 1;
        this.swCRF = 19;
        this.swQPOffset = -1.0d;
        this.swHFpsOffset = 1.0d;
        this.swByteVC1Crf = 22;
        this.swSDCrfRatio = 1.0d;
        this.swFHDCrfRatio = 1.0d;
        this.swQP = 15;
        this.fps = -1;
        this.publishFps = -1;
        this.mvStillFramesPublishFps = -1;
        this.mvStillFramesWatermarkFps = -1;
        this.gopSize = 60;
        this.keyFrameDuration = -1;
        this.maxCacheDuration = -1;
        this.swPreset = ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.encodeStandard = ENCODE_STANDARD.ENCODE_STANDARD_H264.ordinal();
        this.encodeProfile = ENCODE_PROFILE.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.swMaxrate = 15000000;
        this.enableRemuxVideoRes = -1;
        this.enableRemuxVideoFPS = -1;
        this.enableRemuxVideoBitrate = -1;
        this.uploadingWithSynthesisCancelWritefile = false;
        this.enableUploadDirectly = false;
        this.enableCopyWithMetadata = false;
        this.hasBFrame = false;
        this.mEnableInvisibleWatermark = false;
        this.mVideoInvisibleWatermarkSettings = null;
        this.mRecordingMp4 = false;
        this.mTransitionKeyframeEnable = false;
        this.mTransitionKeyFrameVersion = -1;
        this.mTransitionFrameCount = 1;
        this.mTransitionKeyFrameMode = 0;
        this.mReEncodeOpt = false;
        this.mResolutionAlign = 16;
        this.mKeyFramePoints = null;
        this.banExtraDataLoop = false;
        this.image_compile_quality = 100.0f;
        this.encodeRotate = 0;
        this.qualityScoreType = VEQualityScoreType.VQScoreNone;
        this.qualityScoreSequenceId = "";
        this.outputSize = r100;
        this.isSupportHWEncoder = r101;
        this.compileType = COMPILE_TYPE.COMPILE_TYPE_MP4;
        initFromVEConfigCenter();
    }

    public static /* synthetic */ int access$1002(VEVideoEncodeSettings r100, int r101) {
        r100.HwBps = r101;
        return r101;
    }

    public static /* synthetic */ int access$102(VEVideoEncodeSettings r100, int r101) {
        r100.encodeStandard = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1102(VEVideoEncodeSettings r100, boolean r101) {
        r100.useSoftwareDecode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1202(VEVideoEncodeSettings r100, boolean r101) {
        r100.ignoreJsonBitrate = r101;
        return r101;
    }

    public static /* synthetic */ int access$1302(VEVideoEncodeSettings r100, int r101) {
        r100.mvStillFramesPublishFps = r101;
        return r101;
    }

    public static /* synthetic */ int access$1402(VEVideoEncodeSettings r100, int r101) {
        r100.mvStillFramesWatermarkFps = r101;
        return r101;
    }

    public static /* synthetic */ int access$1502(VEVideoEncodeSettings r100, int r101) {
        r100.frameRate = r101;
        return r101;
    }

    public static /* synthetic */ int access$1602(VEVideoEncodeSettings r100, int r101) {
        r100.iFrameInterval = r101;
        return r101;
    }

    public static /* synthetic */ ENCODE_BITRATE_MODE access$1702(VEVideoEncodeSettings r100, ENCODE_BITRATE_MODE r101) {
        r100.bitrateMode = r101;
        return r101;
    }

    public static /* synthetic */ int access$1802(VEVideoEncodeSettings r100, int r101) {
        r100.bps = r101;
        return r101;
    }

    public static /* synthetic */ int access$1902(VEVideoEncodeSettings r100, int r101) {
        r100.swCRF = r101;
        return r101;
    }

    public static /* synthetic */ int access$2002(VEVideoEncodeSettings r100, int r101) {
        r100.swQP = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableByteVCRemuxVideo = r101;
        return r101;
    }

    public static /* synthetic */ int access$2302(VEVideoEncodeSettings r100, int r101) {
        r100.rotate = r101;
        return r101;
    }

    public static /* synthetic */ int access$2402(VEVideoEncodeSettings r100, int r101) {
        r100.resizeMode = r101;
        return r101;
    }

    public static /* synthetic */ float access$2502(VEVideoEncodeSettings r100, float r101) {
        r100.resizeX = r101;
        return r101;
    }

    public static /* synthetic */ float access$2602(VEVideoEncodeSettings r100, float r101) {
        r100.resizeY = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2702(VEVideoEncodeSettings r100, boolean r101) {
        r100.isSupportHWEncoder = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2802(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableHwBufferEncode = r101;
        return r101;
    }

    public static /* synthetic */ int access$2902(VEVideoEncodeSettings r100, int r101) {
        r100.gopSize = r101;
        return r101;
    }

    public static /* synthetic */ int access$3002(VEVideoEncodeSettings r100, int r101) {
        r100.swPreset = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableRemuxVideo = r101;
        return r101;
    }

    public static /* synthetic */ int access$3102(VEVideoEncodeSettings r100, int r101) {
        r100.encodeProfile = r101;
        return r101;
    }

    public static /* synthetic */ long access$3202(VEVideoEncodeSettings r100, long r101) {
        r100.swMaxrate = r101;
        return r101;
    }

    public static /* synthetic */ float access$3302(VEVideoEncodeSettings r100, float r101) {
        r100.speed = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3402(VEVideoEncodeSettings r100, boolean r101) {
        r100.hasBFrame = r101;
        return r101;
    }

    public static /* synthetic */ VEWatermarkParam access$3502(VEVideoEncodeSettings r100, VEWatermarkParam r101) {
        r100.mWatermarkParam = r101;
        return r101;
    }

    public static /* synthetic */ VideoInvisibleWatermarkSettings access$3602(VEVideoEncodeSettings r100, VideoInvisibleWatermarkSettings r101) {
        r100.mVideoInvisibleWatermarkSettings = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3702(VEVideoEncodeSettings r100, boolean r101) {
        r100.mEnableInvisibleWatermark = r101;
        return r101;
    }

    public static /* synthetic */ VEVideoEncodeFitMode access$3802(VEVideoEncodeSettings r100, VEVideoEncodeFitMode r101) {
        r100.mFitMode = r101;
        return r101;
    }

    public static /* synthetic */ int access$3902(VEVideoEncodeSettings r100, int r101) {
        r100.keyFrameDuration = r101;
        return r101;
    }

    public static /* synthetic */ int access$4002(VEVideoEncodeSettings r100, int r101) {
        r100.maxCacheDuration = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableRemuxVideoForRotation = r101;
        return r101;
    }

    public static /* synthetic */ VEVideoEncodeMirrorMode access$4102(VEVideoEncodeSettings r100, VEVideoEncodeMirrorMode r101) {
        r100.mMirrorMode = r101;
        return r101;
    }

    public static /* synthetic */ String access$4202(VEVideoEncodeSettings r100, String r101) {
        r100.externalSettingsJsonStr = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4302(VEVideoEncodeSettings r100, boolean r101) {
        r100.mOptRemuxWithCopy = r101;
        return r101;
    }

    public static /* synthetic */ String access$4402(VEVideoEncodeSettings r100, String r101) {
        r100.mDescription = r101;
        return r101;
    }

    public static /* synthetic */ String access$4502(VEVideoEncodeSettings r100, String r101) {
        r100.mComment = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4602(VEVideoEncodeSettings r100, boolean r101) {
        r100.mCompileSoftInfo = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4702(VEVideoEncodeSettings r100, boolean r101) {
        r100.mRecordingMp4 = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4802(VEVideoEncodeSettings r100, boolean r101) {
        r100.mReEncodeOpt = r101;
        return r101;
    }

    public static /* synthetic */ int access$4902(VEVideoEncodeSettings r100, int r101) {
        r100.mResolutionAlign = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5002(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableAvInterLeave = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableRemuxVideoForShoot = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5102(VEVideoEncodeSettings r100, boolean r101) {
        r100.enableHdr10BitEncode = r101;
        return r101;
    }

    public static /* synthetic */ int access$5202(VEVideoEncodeSettings r100, int r101) {
        r100.mVideoTrc = r101;
        return r101;
    }

    public static /* synthetic */ VEVideoCompileEncodeSettings access$5802(VEVideoEncodeSettings r100, VEVideoCompileEncodeSettings r101) {
        r100.mVideoCompileEncodeSetting = r101;
        return r101;
    }

    public static /* synthetic */ VEVideoCompileEncodeSettings access$5902(VEVideoEncodeSettings r100, VEVideoCompileEncodeSettings r101) {
        r100.mVideoWatermarkCompileEncodeSetting = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$6002(VEVideoEncodeSettings r100, boolean r101) {
        r100.mTransitionKeyframeEnable = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(VEVideoEncodeSettings r100, int r101) {
        r100.enableRemuxVideoRes = r101;
        return r101;
    }

    public static /* synthetic */ int access$6102(VEVideoEncodeSettings r100, int r101) {
        r100.mTransitionKeyFrameVersion = r101;
        return r101;
    }

    public static /* synthetic */ int access$6202(VEVideoEncodeSettings r100, int r101) {
        r100.mTransitionKeyFrameMode = r101;
        return r101;
    }

    public static /* synthetic */ int access$6302(VEVideoEncodeSettings r100, int r101) {
        r100.mTransitionFrameCount = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(VEVideoEncodeSettings r100, int r101) {
        r100.enableRemuxVideoBitrate = r101;
        return r101;
    }

    public static /* synthetic */ int access$802(VEVideoEncodeSettings r100, int r101) {
        r100.fps = r101;
        return r101;
    }

    public static /* synthetic */ int access$902(VEVideoEncodeSettings r100, int r101) {
        r100.publishFps = r101;
        return r101;
    }

    public void setEnableRemuxVideo(boolean r100, boolean r101) {
        this.enableRemuxVideo = r100;
        this.enableRemuxVideoForRotation = r101;
    }

    public void setFps(int r100, int r101) {
        if (r101 <= 0) goto L5;
        if (r101 >= r100) goto L5;
        this.fps = r100;
        this.publishFps = r101;
        return;
    L5:
        this.fps = r100;
        this.publishFps = -1;
    }

    public void setVideoBitrate(ENCODE_BITRATE_MODE r100, int r101) {
        this.bitrateMode = r100;
        int r102 = b.f455728a[r100.ordinal()];
        if (r102 != 1) goto L5;
        this.bps = r101;
        return;
    L5:
        if (r102 != 2) goto L7;
        this.swCRF = r101;
        return;
    L7:
        if (r102 != 3) goto L9;
        this.swQP = r101;
        return;
    L9:
        if (r102 != 4) goto L12;
        this.bps = r101;
        return;
    L12:
        throw new IllegalStateException("CompileTime BUG by sdk. Unhandled bitrateMode");
    }

    public void setVideoRes(int r100, int r101) {
        VESize r102 = this.outputSize;
        r102.width = r100;
        r102.height = r101;
    }

    public void setWatermarkVideoRes(int r100, int r101) {
        VESize r102 = this.watermarkSize;
        r102.width = r100;
        r102.height = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.compileType, r101);
        r100.writeInt(this.rotate);
        r100.writeInt(this.resizeMode);
        r100.writeFloat(this.resizeX);
        r100.writeFloat(this.resizeY);
        r100.writeFloat(this.speed);
        r100.writeParcelable(this.outputSize, r101);
        r100.writeParcelable(this.watermarkSize, r101);
        r100.writeParcelable(this.bitrateMode, r101);
        r100.writeInt(this.bps);
        r100.writeInt(this.fps);
        r100.writeInt(this.publishFps);
        r100.writeInt(this.mvStillFramesPublishFps);
        r100.writeInt(this.mvStillFramesWatermarkFps);
        r100.writeInt(this.swCRF);
        r100.writeDouble(this.swQPOffset);
        r100.writeDouble(this.swHFpsOffset);
        r100.writeInt(this.swByteVC1Crf);
        r100.writeDouble(this.swSDCrfRatio);
        r100.writeDouble(this.swFHDCrfRatio);
        r100.writeInt(this.swQP);
        r100.writeInt(this.gopSize);
        r100.writeInt(this.swPreset);
        r100.writeInt(this.encodeStandard);
        r100.writeInt(this.encodeProfile);
        r100.writeByte(this.isSupportHWEncoder ? 1 : 0);
        r100.writeByte(this.enableRemuxVideo ? 1 : 0);
        r100.writeByte(this.enableRemuxVideoForRotation ? 1 : 0);
        r100.writeByte(this.enableRemuxVideoForShoot ? 1 : 0);
        r100.writeByte(this.enableInterLeave ? 1 : 0);
        r100.writeByte(this.enableAvInterLeave ? 1 : 0);
        r100.writeByte(this.enableHdr10BitEncode ? 1 : 0);
        r100.writeByte(this.hasBFrame ? 1 : 0);
        r100.writeLong(this.swMaxrate);
        r100.writeParcelable(this.mWatermarkParam, r101);
        r100.writeParcelable(this.mVideoWatermarkCompileEncodeSetting, r101);
        r100.writeByte(this.mEnableInvisibleWatermark ? 1 : 0);
        r100.writeParcelable(this.mVideoInvisibleWatermarkSettings, r101);
        r100.writeParcelable(this.mVideoCompileEncodeSetting, r101);
        r100.writeString(this.externalSettingsJsonStr);
        r100.writeByte(this.mOptRemuxWithCopy ? 1 : 0);
        r100.writeString(this.mDescription);
        r100.writeString(this.mComment);
        r100.writeByte(this.mCompileSoftInfo ? 1 : 0);
        r100.writeByte(this.mRecordingMp4 ? 1 : 0);
        r100.writeByte(this.enableHwBufferEncode ? 1 : 0);
        r100.writeByte(this.mReEncodeOpt ? 1 : 0);
        r100.writeInt(this.mResolutionAlign);
        r100.writeByte(this.banExtraDataLoop ? 1 : 0);
        r100.writeParcelable(this.mFitMode, r101);
        r100.writeParcelable(this.mMirrorMode, r101);
        r100.writeInt(this.frameRate);
        r100.writeInt(this.iFrameInterval);
        r100.writeInt(this.mVideoTrc);
        r100.writeInt(this.encodeRotate);
    }

    public float setVideoHWoptBitrate(int r110, float r111, boolean r112) {
        float r100 = 0.0f;
        if (r111 >= 0.0f) goto L6;
        VELogUtil.e(TAG, "compileProbe HW setVideoHWoptBitrate optBitrate error");
        return -1.0f;
    L6:
        VESize r101 = this.outputSize;
        int r102 = Math.min(r101.width, r101.height);
        int r103 = Math.abs(r110 - r102);
        if (r110 <= 572) goto L9;
        if (r110 >= 580) goto L9;
    L11:
        if (r103 <= 8) goto L15;
        VELogUtil.e(TAG, "compileProbe 576P || 720P: output resolution is not as expected");
        return -1.0f;
    L15:
        if (r110 <= 1076) goto L26;
        if (r110 >= 1089) goto L26;
        if (r112 != true) goto L22;
        if (r103 <= 8) goto L26;
        VELogUtil.e(TAG, "compileProbe 1080P_HD: output resolution is not as expected");
        return -1.0f;
    L22:
        if (r103 >= 8) goto L26;
        VELogUtil.e(TAG, "compileProbe 1080P: output resolution is not as expected");
        return -1.0f;
    L26:
        if (r102 <= 716) goto L30;
        if (r102 >= 724) goto L30;
        float r113 = this.mVideoCompileEncodeSetting.mHWEncodeSetting.mBitrate / 1000;
    L29:
        r100 = r111 - r113;
    L39:
        this.mVideoCompileEncodeSetting.mHWEncodeSetting.mBitrate = (long) (r111 * 1000.0f);
        return r100;
    L30:
        if (r102 <= 572) goto L35;
        if (r102 >= 580) goto L35;
        if (r112 == true) goto L34;
        VEVideoHWEncodeSettings r104 = this.mVideoCompileEncodeSetting.mHWEncodeSetting;
        r111 = (float) (((double) r111) / r104.mSd_bitrate_ratio);
        long r105 = r104.mBitrate;
    L38:
        r113 = r105 / 1000.0f;
        goto L29
    L34:
        r111 = this.mVideoCompileEncodeSetting.mHWEncodeSetting.mBitrate / 1000.0f;
    L35:
        if (r102 <= 1076) goto L41;
        if (r102 >= 1089) goto L41;
        VEVideoHWEncodeSettings r106 = this.mVideoCompileEncodeSetting.mHWEncodeSetting;
        r111 = (float) (((double) r111) / r106.mFullHd_bitrate_ratio);
        r105 = r106.mBitrate;
    L41:
        VELogUtil.e(TAG, "compileProbe output resolution error");
        return -1.0f;
    L9:
        if (r110 <= 716) goto L15;
        if (r110 >= 724) goto L15;
        goto L11
    }

    public s setVideoHWoptBitrate(VESize r100, z r101, String r102) {
        VESize r103 = this.outputSize;
        int r104 = r103.width;
        int r105 = r103.height;
        new VESize(r104, r105);
        Math.min(r104, r105);
        int r106 = Math.min(r100.width, r100.height);
        if (r106 > 572) goto L5;
    L7:
        long r107 = this.mVideoCompileEncodeSetting.mHWEncodeSetting.mBitrate / 1000;
        throw null;
    L5:
        if (r106 >= 580) goto L7;
        throw null;
    }

    public VEVideoEncodeSettings(VESize r100, boolean r101, int r110, int r111) {
        this.mFitMode = VEVideoEncodeFitMode.CENTER_CROP;
        this.mMirrorMode = VEVideoEncodeMirrorMode.NO_MIRROR;
        this.rotate = 0;
        this.resizeMode = 2;
        this.resizeX = 0.0f;
        this.resizeY = 0.0f;
        this.speed = 1.0f;
        this.outputSize = new VESize(576, 1024);
        this.watermarkSize = new VESize(-1, -1);
        this.externalSettingsJsonStr = null;
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR;
        this.bps = 4194304;
        this.ignoreJsonBitrate = false;
        this.HwBps = -1;
        this.useSoftwareDecode = false;
        this.frameRate = 30;
        this.iFrameInterval = 1;
        this.swCRF = 19;
        this.swQPOffset = -1.0d;
        this.swHFpsOffset = 1.0d;
        this.swByteVC1Crf = 22;
        this.swSDCrfRatio = 1.0d;
        this.swFHDCrfRatio = 1.0d;
        this.swQP = 15;
        this.fps = -1;
        this.publishFps = -1;
        this.mvStillFramesPublishFps = -1;
        this.mvStillFramesWatermarkFps = -1;
        this.gopSize = 60;
        this.keyFrameDuration = -1;
        this.maxCacheDuration = -1;
        this.swPreset = ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.encodeStandard = ENCODE_STANDARD.ENCODE_STANDARD_H264.ordinal();
        this.encodeProfile = ENCODE_PROFILE.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.swMaxrate = 15000000;
        this.enableRemuxVideoRes = -1;
        this.enableRemuxVideoFPS = -1;
        this.enableRemuxVideoBitrate = -1;
        this.uploadingWithSynthesisCancelWritefile = false;
        this.enableUploadDirectly = false;
        this.enableCopyWithMetadata = false;
        this.hasBFrame = false;
        this.mEnableInvisibleWatermark = false;
        this.mVideoInvisibleWatermarkSettings = null;
        this.mRecordingMp4 = false;
        this.mTransitionKeyframeEnable = false;
        this.mTransitionKeyFrameVersion = -1;
        this.mTransitionFrameCount = 1;
        this.mTransitionKeyFrameMode = 0;
        this.mReEncodeOpt = false;
        this.mResolutionAlign = 16;
        this.mKeyFramePoints = null;
        this.banExtraDataLoop = false;
        this.image_compile_quality = 100.0f;
        this.encodeRotate = 0;
        this.qualityScoreType = VEQualityScoreType.VQScoreNone;
        this.qualityScoreSequenceId = "";
        this.outputSize = r100;
        this.isSupportHWEncoder = r101;
        this.fps = r110;
        this.gopSize = r111;
        this.compileType = COMPILE_TYPE.COMPILE_TYPE_MP4;
        initFromVEConfigCenter();
    }

    private float[] bitrateRangeSettingsJsonStr(String r100, boolean r101, float r102, int r103) {
        float[] r104 = {0.0f, 0.0f, 0.0f, 0.0f};
        JSONObject r105 = new JSONObject(r100);     // Catch: JSONException -> L34
        JSONArray r106 = new JSONArray();     // Catch: JSONException -> L34
        if (716 >= r103) goto L14;
        if (r103 >= 724) goto L14;
        if (r101 == false) goto L10;
        r106 = r105.optJSONArray("720P_HD");     // Catch: JSONException -> L34
    L26:
        if (r106 != null) goto L29;
        VELogUtil.e(TAG, "bitrateRange json parse failed");     // Catch: JSONException -> L34
        return null;
    L29:
        int r107 = 0;
    L31:
        if (r107 >= r106.length()) goto L36;
        r104[r107] = (float) JSONArrayProtectorUtils.getDouble(r106, r107);     // Catch: JSONException -> L34
        r107 = r107 + 1;
    L36:
        return r104;
    L10:
        if (r102 != 7000.0f) goto L12;
        r106 = r105.optJSONArray("720P_Base_7Mb");     // Catch: JSONException -> L34
        goto L26
    L12:
        r106 = r105.optJSONArray("720P");     // Catch: JSONException -> L34
    L14:
        if (1076 >= r103) goto L19;
        if (r103 >= 1089) goto L19;
        r106 = r105.optJSONArray("1080P");     // Catch: JSONException -> L34
    L19:
        if (572 >= r103) goto L26;
        if (r103 >= 580) goto L26;
        if (r102 != 7000.0f) goto L25;
        r106 = r105.optJSONArray("576P_Base_7Mb");     // Catch: JSONException -> L34
        goto L26
    L25:
        r106 = r105.optJSONArray("576P");     // Catch: JSONException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        VELogUtil.e(TAG, "bitrateRange json str parse error : " + e.getLocalizedMessage());
        goto L36
    }

    public p0 getHwAdaptiveBitrate(int r100, z r110, float r111, String r112, String r113) throws JSONException {
        p0 r114 = new p0();
        if (r111 >= 5000.0f) goto L7;
        VELogUtil.e(TAG, "compileProbe  bitrate_base is not support!");
        return r114;
    L7:
        if (r113 == null) goto L24;
        JSONObject r115 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r113), "compile");
        int r101 = JSONObjectProtectorUtils.getJSONObject(r115, "hw").optInt("bitrate");
        double r102 = JSONObjectProtectorUtils.getJSONObject(r115, "hw").optDouble("full_hd_bitrate_ratio");
        JSONObjectProtectorUtils.getJSONObject(r115, "hw").optDouble("sd_bitrate_ratio");
        int r103 = r101 / 1000;
        if (r100 <= 572) goto L12;
        if (r100 < 580) goto L24;
    L12:
        if (r100 <= 1076) goto L17;
        if (r100 >= 1084) goto L17;
        float r116 = (float) (((double) r103) * r102);
    L22:
        bitrateRangeSettingsJsonStr(r112, true, r116, r100);
        throw null;
    L17:
        if (r100 > 716) goto L19;
    L21:
        r116 = 0.0f;
        goto L22
    L19:
        if (r100 >= 724) goto L21;
        r116 = r103;
    L24:
        if (r100 <= 1076) goto L27;
        if (r100 >= 1084) goto L27;
        int r117 = 720;
    L29:
        if (r100 <= 572) goto L38;
        if (r100 >= 580) goto L38;
        if (r111 != 6300.0f) goto L34;
    L37:
        bitrateRangeSettingsJsonStr(r112, false, 7000.0f, r117);
        throw null;
    L34:
        if (r111 == 5600.0f) goto L37;
        bitrateRangeSettingsJsonStr(r112, false, r111, r117);
        throw null;
    L38:
        bitrateRangeSettingsJsonStr(r112, false, r111, r117);
        throw null;
    L27:
        r117 = r100;
        goto L29
    }

    public VEVideoEncodeSettings(VESize r100, boolean r101, int r110, int r111, int r112, int r113, boolean r114) {
        this.mFitMode = VEVideoEncodeFitMode.CENTER_CROP;
        this.mMirrorMode = VEVideoEncodeMirrorMode.NO_MIRROR;
        this.rotate = 0;
        this.resizeMode = 2;
        this.resizeX = 0.0f;
        this.resizeY = 0.0f;
        this.speed = 1.0f;
        this.outputSize = new VESize(576, 1024);
        this.watermarkSize = new VESize(-1, -1);
        this.externalSettingsJsonStr = null;
        this.bitrateMode = ENCODE_BITRATE_MODE.ENCODE_BITRATE_ABR;
        this.bps = 4194304;
        this.ignoreJsonBitrate = false;
        this.HwBps = -1;
        this.useSoftwareDecode = false;
        this.frameRate = 30;
        this.iFrameInterval = 1;
        this.swCRF = 19;
        this.swQPOffset = -1.0d;
        this.swHFpsOffset = 1.0d;
        this.swByteVC1Crf = 22;
        this.swSDCrfRatio = 1.0d;
        this.swFHDCrfRatio = 1.0d;
        this.swQP = 15;
        this.fps = -1;
        this.publishFps = -1;
        this.mvStillFramesPublishFps = -1;
        this.mvStillFramesWatermarkFps = -1;
        this.gopSize = 60;
        this.keyFrameDuration = -1;
        this.maxCacheDuration = -1;
        this.swPreset = ENCODE_PRESET.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.encodeStandard = ENCODE_STANDARD.ENCODE_STANDARD_H264.ordinal();
        this.encodeProfile = ENCODE_PROFILE.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.swMaxrate = 15000000;
        this.enableRemuxVideoRes = -1;
        this.enableRemuxVideoFPS = -1;
        this.enableRemuxVideoBitrate = -1;
        this.uploadingWithSynthesisCancelWritefile = false;
        this.enableUploadDirectly = false;
        this.enableCopyWithMetadata = false;
        this.hasBFrame = false;
        this.mEnableInvisibleWatermark = false;
        this.mVideoInvisibleWatermarkSettings = null;
        this.mRecordingMp4 = false;
        this.mTransitionKeyframeEnable = false;
        this.mTransitionKeyFrameVersion = -1;
        this.mTransitionFrameCount = 1;
        this.mTransitionKeyFrameMode = 0;
        this.mReEncodeOpt = false;
        this.mResolutionAlign = 16;
        this.mKeyFramePoints = null;
        this.banExtraDataLoop = false;
        this.image_compile_quality = 100.0f;
        this.encodeRotate = 0;
        this.qualityScoreType = VEQualityScoreType.VQScoreNone;
        this.qualityScoreSequenceId = "";
        this.outputSize = r100;
        this.isSupportHWEncoder = r101;
        this.fps = r110;
        this.gopSize = r111;
        this.bps = r112;
        this.swPreset = r113;
        this.hasBFrame = r114;
        this.compileType = COMPILE_TYPE.COMPILE_TYPE_MP4;
        initFromVEConfigCenter();
    }

    private float get_adaptive_encode_bitrate(int r110, int r210, int r211, int r212, int r213, float r214, float r215, float[] r216, float r217) {
        if (1076 >= r110) goto L25;
        if (r110 >= 1088) goto L25;
        double r111 = r214;
        double r100 = 1000.0f * r215;
        if (((3.25d * r111) - r100) < (-33500.0d)) goto L15;
        if (((0.1489d * r111) - r100) >= (-32700.0d)) goto L11;
    L13:
        char r101 = 2;
    L57:
        return r216[r101];
    L11:
        if (((r111 * 0.2307d) - ((double) (r215 * 100.0f))) < (-2761.0d)) goto L13;
    L47:
        r101 = 3;
        goto L57
    L15:
        if (((0.25d * r111) - ((double) (r215 * 100.0f))) <= (-4000.0d)) goto L20;
        if (((r111 * 0.6d) - ((double) (r215 * 10.0f))) < (-230.0d)) goto L20;
    L18:
        r101 = 1;
    L20:
        if (r215 < 37.5d) goto L22;
    L40:
        r101 = 0;
        goto L57
    L22:
        if (r214 >= 300.0f) goto L40;
    L25:
        if (716 >= r110) goto L42;
        if (r110 >= 724) goto L42;
        double r102 = r214;
        double r112 = r215 * 100.0f;
        if (((0.2833d * r102) - r112) < (-3520.0d)) goto L36;
        if (((0.2545d * r102) - r112) < (-2809.0d)) goto L13;
        if (((r102 * 0.11d) - r112) < (-3100.0d)) goto L13;
    L36:
        if (((0.1625d * r102) - ((double) (r215 * 10.0f))) <= (-368.0d)) goto L40;
        if (((r102 * 0.2d) - r112) < (-4000.0d)) goto L40;
    L42:
        if (572 >= r110) goto L59;
        if (r110 >= 580) goto L59;
        double r103 = r214;
        double r104 = r215 * 100.0f;
        if (((0.3913d * r103) - r104) >= (-2667.0d)) goto L47;
        if (((0.5899d * r103) - r104) >= (-3270.0d)) goto L13;
        if (((0.1575d * r103) - ((double) (r215 * 10.0f))) <= (-369.0d)) goto L40;
        if (((r103 * 0.76d) - r104) > (-3780.0d)) goto L18;
    L59:
        return -1;
    }
}
