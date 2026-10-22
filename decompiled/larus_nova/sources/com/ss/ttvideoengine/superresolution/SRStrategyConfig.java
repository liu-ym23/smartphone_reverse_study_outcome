package com.ss.ttvideoengine.superresolution;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class SRStrategyConfig {
    public static final int KEY_EFFECT = 1;
    private Integer mCurrentDuration;
    private Float mCurrentFps;
    private Integer mCurrentHeight;
    private Integer mCurrentPower;
    private Integer mCurrentScene;
    private Integer mCurrentVideoFormatType;
    private Integer mCurrentWidth;
    private Bundle mEffectBuddle;
    private Boolean mEnableHdr;
    private Boolean mEnableSR;
    private Boolean mEnableSpeed;
    private String mExtraConfig;
    private Map<String, String> mExtraInfo;
    private Boolean mIsCharging;
    private Boolean mIsHdr;
    private Boolean mIsSpeed;
    private Long mMaxDuration;
    private Float mMaxFps;
    private Integer mMaxHeight;
    private Integer mMaxWidth;
    private Long mMinDuration;
    private Integer mMinPower;
    private Boolean mResolutionChanged;
    private Integer mSRPercent;
    private Integer mScreenWidth;
    ISRStatusListener mStatusListener;
    ISRStrategyListener mStrategyListener;
    private Integer mStrategyType;
    private Integer mSupportScene;
    private Integer mVideoFormatType;

    public void resetAll() {
        this.mEnableSR = null;
        this.mVideoFormatType = null;
        this.mMinDuration = null;
        this.mMaxDuration = null;
        this.mMinPower = null;
        this.mSupportScene = null;
        this.mEnableSpeed = null;
        this.mSRPercent = null;
        this.mMaxWidth = null;
        this.mMaxHeight = null;
        this.mMaxFps = null;
        this.mEnableHdr = null;
        this.mCurrentVideoFormatType = null;
        this.mCurrentDuration = null;
        this.mCurrentPower = null;
        this.mIsCharging = null;
        this.mCurrentScene = null;
        this.mIsSpeed = null;
        this.mCurrentWidth = null;
        this.mCurrentHeight = null;
        this.mCurrentFps = null;
        this.mIsHdr = null;
        this.mExtraConfig = null;
        this.mExtraInfo.clear();
        this.mStatusListener = null;
        this.mResolutionChanged = null;
        this.mStrategyType = null;
        this.mScreenWidth = null;
        this.mStrategyListener = null;
        this.mEffectBuddle = null;
    }

    public void resetStream() {
        this.mMaxFps = null;
        this.mCurrentVideoFormatType = null;
        this.mCurrentDuration = null;
        this.mCurrentWidth = null;
        this.mCurrentHeight = null;
        this.mCurrentFps = null;
        this.mIsHdr = null;
        this.mResolutionChanged = null;
        this.mIsSpeed = null;
        this.mStrategyType = null;
    }

    public static SRStrategyConfig newConfig() {
        return new SRStrategyConfig();
    }

    public JSONObject getJson() {
        JSONObject r100 = new JSONObject();
        Boolean r101 = this.mEnableSR;     // Catch: JSONException -> L87
        int r102 = 1;
        if (r101 != null) goto L6;
    L10:
        Integer r103 = this.mStrategyType;     // Catch: JSONException -> L87
        if (r103 == null) goto L13;
        r100.put(Segment.JsonKey.START, r103);     // Catch: JSONException -> L87
    L13:
        Integer r104 = this.mMaxWidth;     // Catch: JSONException -> L87
        if (r104 == null) goto L16;
        r100.put("mw", r104);     // Catch: JSONException -> L87
    L16:
        Integer r105 = this.mMaxHeight;     // Catch: JSONException -> L87
        if (r105 == null) goto L19;
        r100.put("mh", r105);     // Catch: JSONException -> L87
    L19:
        Integer r106 = this.mScreenWidth;     // Catch: JSONException -> L87
        if (r106 == null) goto L22;
        r100.put("sw", r106);     // Catch: JSONException -> L87
    L22:
        Integer r107 = this.mCurrentWidth;     // Catch: JSONException -> L87
        if (r107 == null) goto L25;
        r100.put("cw", r107);     // Catch: JSONException -> L87
    L25:
        Integer r108 = this.mCurrentHeight;     // Catch: JSONException -> L87
        if (r108 == null) goto L28;
        r100.put("ch", r108);     // Catch: JSONException -> L87
    L28:
        Integer r109 = this.mVideoFormatType;     // Catch: JSONException -> L87
        if (r109 == null) goto L31;
        r100.put("ft", r109);     // Catch: JSONException -> L87
    L31:
        Integer r110 = this.mCurrentVideoFormatType;     // Catch: JSONException -> L87
        if (r110 == null) goto L34;
        r100.put("cft", r110);     // Catch: JSONException -> L87
    L34:
        Long r111 = this.mMinDuration;     // Catch: JSONException -> L87
        if (r111 == null) goto L37;
        r100.put("mid", r111);     // Catch: JSONException -> L87
    L37:
        Long r112 = this.mMaxDuration;     // Catch: JSONException -> L87
        if (r112 == null) goto L40;
        r100.put("mad", r112);     // Catch: JSONException -> L87
    L40:
        Integer r113 = this.mCurrentDuration;     // Catch: JSONException -> L87
        if (r113 == null) goto L43;
        r100.put("cd", r113);     // Catch: JSONException -> L87
    L43:
        Integer r114 = this.mSupportScene;     // Catch: JSONException -> L87
        if (r114 == null) goto L46;
        r100.put("ss", r114);     // Catch: JSONException -> L87
    L46:
        Integer r115 = this.mCurrentScene;     // Catch: JSONException -> L87
        if (r115 == null) goto L49;
        r100.put(SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, r115);     // Catch: JSONException -> L87
    L49:
        Boolean r116 = this.mEnableSpeed;     // Catch: JSONException -> L87
        if (r116 != null) goto L52;
    L56:
        Boolean r117 = this.mIsSpeed;     // Catch: JSONException -> L87
        if (r117 != null) goto L59;
    L63:
        Float r118 = this.mMaxFps;     // Catch: JSONException -> L87
        if (r118 == null) goto L66;
        r100.put("mf", r118);     // Catch: JSONException -> L87
    L66:
        Float r119 = this.mCurrentFps;     // Catch: JSONException -> L87
        if (r119 == null) goto L69;
        r100.put("cf", r119);     // Catch: JSONException -> L87
    L69:
        Boolean r120 = this.mEnableHdr;     // Catch: JSONException -> L87
        if (r120 != null) goto L72;
    L76:
        Boolean r121 = this.mIsHdr;     // Catch: JSONException -> L87
        if (r121 == null) goto L84;
        if (r121.booleanValue() == true) goto L82;
        r102 = 0;
    L82:
        r100.put("ih", r102);     // Catch: JSONException -> L87
    L84:
        if (this.mExtraInfo == null) goto L89;
        r100.put("ei", new JSONObject(this.mExtraInfo));     // Catch: JSONException -> L87
    L89:
        return r100;
    L72:
        if (r120.booleanValue() == false) goto L74;
        int r122 = 1;
    L75:
        r100.put("eh", r122);     // Catch: JSONException -> L87
        goto L76
    L74:
        r122 = 0;
        goto L75
    L59:
        if (r117.booleanValue() == false) goto L61;
        int r123 = 1;
    L62:
        r100.put("is", r123);     // Catch: JSONException -> L87
        goto L63
    L61:
        r123 = 0;
        goto L62
    L52:
        if (r116.booleanValue() == false) goto L54;
        int r124 = 1;
    L55:
        r100.put("es", r124);     // Catch: JSONException -> L87
        goto L56
    L54:
        r124 = 0;
        goto L55
    L6:
        if (r101.booleanValue() == false) goto L8;
        int r125 = 1;
    L9:
        r100.put("e", r125);     // Catch: JSONException -> L87
        goto L10
    L8:
        r125 = 0;
    L87:
        e = move-exception;
        e.printStackTrace();
        goto L89
    }

    public SRStrategyConfig() {
        this.mExtraInfo = new HashMap();
        resetAll();
    }

    public String toString() {
        return getJson().toString();
    }

    public Integer getCurrentDuration() {
        return this.mCurrentDuration;
    }

    public Float getCurrentFps() {
        return this.mCurrentFps;
    }

    public Integer getCurrentHeight() {
        return this.mCurrentHeight;
    }

    public Integer getCurrentPower() {
        return this.mCurrentPower;
    }

    public Integer getCurrentScene() {
        return this.mCurrentScene;
    }

    public Integer getCurrentVideoFormatType() {
        return this.mCurrentVideoFormatType;
    }

    public Integer getCurrentWidth() {
        return this.mCurrentWidth;
    }

    public Boolean getEnableHdr() {
        return this.mEnableHdr;
    }

    public Boolean getEnableSR() {
        return this.mEnableSR;
    }

    public Boolean getEnableSpeed() {
        return this.mEnableSpeed;
    }

    public String getExtraConfig() {
        return this.mExtraConfig;
    }

    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public Boolean getIsCharging() {
        return this.mIsCharging;
    }

    public Boolean getIsHdr() {
        return this.mIsHdr;
    }

    public Boolean getIsSpeed() {
        return this.mIsSpeed;
    }

    public ISRStatusListener getListener() {
        return this.mStatusListener;
    }

    public Long getMaxDuration() {
        return this.mMaxDuration;
    }

    public Float getMaxFps() {
        return this.mMaxFps;
    }

    public Integer getMaxHeight() {
        return this.mMaxHeight;
    }

    public Integer getMaxWidth() {
        return this.mMaxWidth;
    }

    public Long getMinDuration() {
        return this.mMinDuration;
    }

    public Integer getMinPower() {
        return this.mMinPower;
    }

    public Boolean getResolutionChanged() {
        return this.mResolutionChanged;
    }

    public Integer getSRPercent() {
        return this.mSRPercent;
    }

    public Integer getScreenWidth() {
        return this.mScreenWidth;
    }

    public ISRStrategyListener getStrategyListener() {
        return this.mStrategyListener;
    }

    public Integer getStrategyType() {
        return this.mStrategyType;
    }

    public Integer getSupportScene() {
        return this.mSupportScene;
    }

    public Integer getVideoFormatType() {
        return this.mVideoFormatType;
    }

    public SRStrategyConfig enableSR(boolean r100) {
        this.mEnableSR = Boolean.valueOf(r100);
        return this;
    }

    public SRStrategyConfig enableSpeed(boolean r100) {
        this.mEnableSpeed = Boolean.valueOf(r100);
        return this;
    }

    public SRStrategyConfig resolutionChanged(boolean r100) {
        this.mResolutionChanged = Boolean.valueOf(r100);
        return this;
    }

    public void setCurrentDuration(int r100) {
        this.mCurrentDuration = Integer.valueOf(r100);
    }

    public SRStrategyConfig setCurrentFps(float r100) {
        this.mCurrentFps = Float.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setCurrentHeight(int r100) {
        this.mCurrentHeight = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setCurrentPower(int r100) {
        this.mCurrentPower = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setCurrentScene(int r100) {
        this.mCurrentScene = Integer.valueOf(r100);
        return this;
    }

    public void setCurrentVideoFormatType(int r100) {
        this.mCurrentVideoFormatType = Integer.valueOf(r100);
    }

    public SRStrategyConfig setCurrentWidth(int r100) {
        this.mCurrentWidth = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setEnableHdr(boolean r100) {
        this.mEnableHdr = Boolean.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setExtraConfig(String r100) {
        this.mExtraConfig = r100;
        return this;
    }

    public SRStrategyConfig setExtraInfo(Map<String, String> r100) {
        this.mExtraInfo = r100;
        return this;
    }

    public SRStrategyConfig setIsCharging(boolean r100) {
        this.mIsCharging = Boolean.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setIsHdr(boolean r100) {
        this.mIsHdr = Boolean.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setIsSpeed(boolean r100) {
        this.mIsSpeed = Boolean.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setListener(ISRStatusListener r100) {
        this.mStatusListener = r100;
        return this;
    }

    public SRStrategyConfig setMaxFps(float r100) {
        this.mMaxFps = Float.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setMaxHeight(int r100) {
        this.mMaxHeight = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setMaxWidth(int r100) {
        this.mMaxWidth = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setMinPower(int r100) {
        this.mMinPower = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setSRPercent(int r100) {
        this.mSRPercent = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setScreenWidth(int r100) {
        this.mScreenWidth = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setStrategyListener(ISRStrategyListener r100) {
        this.mStrategyListener = r100;
        return this;
    }

    public SRStrategyConfig setStrategyType(int r100) {
        this.mStrategyType = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setSupportScene(int r100) {
        this.mSupportScene = Integer.valueOf(r100);
        return this;
    }

    public SRStrategyConfig setVideoFormatType(int r100) {
        this.mVideoFormatType = Integer.valueOf(r100);
        return this;
    }

    public void updateFrom(SRStrategyConfig r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Boolean r101 = r100.getResolutionChanged();
        if (r101 == null) goto L7;
        this.mResolutionChanged = r101;
    L7:
        Boolean r102 = r100.getEnableSR();
        if (r102 == null) goto L10;
        this.mEnableSR = r102;
    L10:
        Integer r103 = r100.getVideoFormatType();
        if (r103 == null) goto L13;
        this.mVideoFormatType = r103;
    L13:
        Long r104 = r100.getMinDuration();
        if (r104 == null) goto L16;
        this.mMinDuration = r104;
    L16:
        Long r105 = r100.getMaxDuration();
        if (r105 == null) goto L19;
        this.mMaxDuration = r105;
    L19:
        Integer r106 = r100.getMinPower();
        if (r106 == null) goto L22;
        this.mMinPower = r106;
    L22:
        Integer r107 = r100.getSupportScene();
        if (r107 == null) goto L25;
        this.mSupportScene = r107;
    L25:
        Boolean r108 = r100.getEnableSpeed();
        if (r108 == null) goto L28;
        this.mEnableSpeed = r108;
    L28:
        Integer r109 = r100.getSRPercent();
        if (r109 == null) goto L31;
        this.mSRPercent = r109;
    L31:
        Integer r110 = r100.getMaxWidth();
        if (r110 == null) goto L34;
        this.mMaxWidth = r110;
    L34:
        Integer r111 = r100.getMaxHeight();
        if (r111 == null) goto L37;
        this.mMaxHeight = r111;
    L37:
        Float r112 = r100.getMaxFps();
        if (r112 == null) goto L40;
        this.mMaxFps = r112;
    L40:
        Boolean r113 = r100.getEnableHdr();
        if (r113 == null) goto L43;
        this.mEnableHdr = r113;
    L43:
        Integer r114 = r100.getCurrentVideoFormatType();
        if (r114 == null) goto L46;
        this.mCurrentVideoFormatType = r114;
    L46:
        Integer r115 = r100.getCurrentDuration();
        if (r115 == null) goto L49;
        this.mCurrentDuration = r115;
    L49:
        Integer r116 = r100.getCurrentPower();
        if (r116 == null) goto L52;
        this.mCurrentPower = r116;
    L52:
        Boolean r117 = r100.getIsCharging();
        if (r117 == null) goto L55;
        this.mIsCharging = r117;
    L55:
        Integer r118 = r100.getCurrentScene();
        if (r118 == null) goto L58;
        this.mCurrentScene = r118;
    L58:
        Boolean r119 = r100.getIsSpeed();
        if (r119 == null) goto L61;
        this.mIsSpeed = r119;
    L61:
        Integer r120 = r100.getCurrentWidth();
        if (r120 == null) goto L64;
        this.mCurrentWidth = r120;
    L64:
        Integer r121 = r100.getCurrentHeight();
        if (r121 == null) goto L67;
        this.mCurrentHeight = r121;
    L67:
        Float r122 = r100.getCurrentFps();
        if (r122 == null) goto L70;
        this.mCurrentFps = r122;
    L70:
        Boolean r123 = r100.getIsHdr();
        if (r123 == null) goto L73;
        this.mIsHdr = r123;
    L73:
        ISRStatusListener r124 = r100.getListener();
        if (r124 == null) goto L76;
        this.mStatusListener = r124;
    L76:
        ISRStrategyListener r125 = r100.getStrategyListener();
        if (r125 == null) goto L79;
        this.mStrategyListener = r125;
    L79:
        Integer r126 = r100.getStrategyType();
        if (r126 == null) goto L82;
        this.mStrategyType = r126;
    L82:
        Integer r127 = r100.getScreenWidth();
        if (r127 == null) goto L85;
        this.mScreenWidth = r127;
    L85:
        Map<String, String> r128 = r100.getExtraInfo();
        if (r128 == null) goto L88;
        this.mExtraInfo.putAll(r128);
    L88:
        Object r129 = r100.getValue(1, null);
        if (r129 == null) goto L92;
        this.mEffectBuddle = (Bundle) r129;
        return;
    }

    public Object getValue(int r100, Object r101) {
        if (r100 == 1) goto L6;
        return r101;
    L6:
        return this.mEffectBuddle;
    }

    public SRStrategyConfig setDurationRangeSecond(long r100, long r101) {
        this.mMinDuration = Long.valueOf(r100);
        this.mMaxDuration = Long.valueOf(r101);
        return this;
    }

    public SRStrategyConfig setValue(int r100, Object r101) {
        if (r100 != 1) goto L6;
        this.mEffectBuddle = (Bundle) r101;
    L6:
        return this;
    }
}
