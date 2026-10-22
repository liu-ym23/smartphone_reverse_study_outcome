package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoModel implements IVideoModel {
    public static final int IS_LIVE_SOURCE = 0;
    public static final int IS_VOD_SOURCE = 1;
    public static final int VIDEO_MODEL_VER1 = 1;
    public static final int VIDEO_MODEL_VER2 = 2;
    public static final int VIDEO_MODEL_VER3 = 3;
    public static final int VIDEO_MODEL_VER4 = 4;
    public LiveVideoRef liveVideoRef;
    private JSONObject mJsonInfo;
    private String mKeyseed;
    private HashMap<String, Resolution> mResolutionMap;
    private int mSourceType;
    private boolean mURLEncrypted;
    private int mVersion;
    public List<VideoAdRef> videoAdRefList;
    public VideoRef videoRef;
    private VideoRef vodVideoRef;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.model.VideoModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format = null;

        static {
            int[] r100 = new int[IVideoModel.Format.values().length];
            $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format = r100;
            r100[IVideoModel.Format.HLS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[IVideoModel.Format.MP4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[IVideoModel.Format.DASH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[IVideoModel.Format.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int fromMediaInfoJsonObject(JSONObject r100) {
        return -1;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int fromMediaInfoJsonString(String r100) {
        return -1;
    }

    public String getCodec() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 == null) goto L32;
        int r101 = 0;
        if (this.mVersion != 2) goto L20;
        String[] r102 = r100.getCodecs();
        int r103 = r102.length;
        boolean r104 = false;
    L9:
        if (r101 >= r103) goto L17;
        String r105 = r102[r101];
        if (r105.equals("bytevc2") == true) goto L12;
        if (r105.equals("bytevc1") == false) goto L16;
        r104 = true;
    L16:
        r101 = r101 + 1;
        goto L9
    L12:
        return "bytevc2";
    L17:
        if (r104 == false) goto L19;
        return "bytevc1";
    L19:
        return "h264";
    L20:
        List<VideoInfo> r106 = r100.getVideoInfoList();
        if (r106 == null) goto L32;
        if (r106.size() == 0) goto L32;
        VideoInfo r107 = (VideoInfo) ListProtector.get(r106, 0);
        if (r107 == null) goto L32;
        String r108 = r107.mCodecType;
        if (TextUtils.isEmpty(r108) == true) goto L32;
        return r108;
    L32:
        return "h264";
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] getCodecs() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 == null) goto L7;
        return r100.getCodecs();
    L7:
        return new String[0];
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public JSONObject getDnsInfo() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getDnsInfo();
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getDynamicType() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getValueStr(215);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public Set<IVideoModel.Format> getFormats() {
        HashSet r100 = new HashSet();
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
    L15:
        return r100;
    L5:
        if (r101.getValueBool(206).booleanValue() == false) goto L8;
        r100.add(IVideoModel.Format.MP4);
        goto L15
    L8:
        if (this.vodVideoRef.getValueBool(208).booleanValue() == false) goto L11;
        r100.add(IVideoModel.Format.HLS);
        goto L15
    L11:
        if (this.vodVideoRef.getValueBool(205).booleanValue() == false) goto L13;
    L14:
        r100.add(IVideoModel.Format.DASH);
        goto L15
    L13:
        if (this.vodVideoRef.getValueBool(207).booleanValue() == false) goto L15;
        goto L14
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public JSONObject getMediaInfo() {
        String r100 = getVideoRefStr(211);
        String r101 = getVideoRefStr(2);
        int r102 = getVideoRefInt(3);
        List<VideoInfo> r103 = getVideoInfoList();
        if (r103 == null) goto L25;
        HashMap r104 = new HashMap();     // Catch: Throwable -> L18
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<VideoInfo> r106 = r103.iterator();     // Catch: Throwable -> L18
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.add(r106.next().toMediaInfo());     // Catch: Throwable -> L18
        goto L6
    L8:
        VideoRef r107 = this.vodVideoRef;     // Catch: Throwable -> L18
        if (r107 == null) goto L13;
        BarrageMaskInfo r108 = r107.mMaskInfo;     // Catch: Throwable -> L18
        if (r108 == null) goto L13;
        r105.add(r108.getMediaInfo());     // Catch: Throwable -> L18
    L13:
        r104.put(SubInfo.KEY_FORMAT, r100);     // Catch: Throwable -> L18
        r104.put("vid", r101);     // Catch: Throwable -> L18
        r104.put("bid", getVideoRefStr(246));     // Catch: Throwable -> L18
        r104.put("category", Integer.valueOf(getVideoRefInt(VideoRef.VALUE_VIDEO_REF_CATEGORY)));     // Catch: Throwable -> L18
        r104.put("duration", Integer.valueOf(r102));     // Catch: Throwable -> L18
        r104.put("infos", r105);     // Catch: Throwable -> L18
        VideoRef r109 = this.vodVideoRef;     // Catch: Throwable -> L18
        if (r109 == null) goto L16;
        r104.put("pallas_vid_labels", r109.getValueStr(VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS));     // Catch: Throwable -> L18
    L16:
        return new JSONObject(r104);
    L18:
        th = move-exception;
        TTVideoEngineLog.d(th);
        return null;
    L25:
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getOriginalAudioInfo() {
        VideoRef r100 = this.vodVideoRef;
        ArrayList r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<VideoInfo> r102 = r100.getValueList(234);
        if (r102 != null) goto L8;
    L14:
        return r101;
    L8:
        if (r102.size() == 0) goto L14;
        r101 = new ArrayList();
        Iterator<VideoInfo> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        r101.add(Integer.valueOf(r103.next().getValueInt(42)));
        goto L12
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public IVideoModel.Source getSource() {
        IVideoModel.Source r100 = IVideoModel.Source.None;
        int r101 = this.mSourceType;
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L10;
        return r100;
    L10:
        return IVideoModel.Source.VOD;
    L9:
        return IVideoModel.Source.LIVE;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getSpadea() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 == null) goto L21;
        List<VideoInfo> r101 = r100.getVideoInfoList();
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.size() == 0) goto L22;
        Iterator<VideoInfo> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next().getValueStr(5);
        if (TextUtils.isEmpty(r103) == true) goto L12;
        return r103;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<SubInfo> getSubInfoList() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mSubInfoList;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] getSupportQualityInfos() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getSupportQualityInfos();
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public Resolution[] getSupportResolutions() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 == null) goto L7;
        return r100.getSupportResolutions();
    L7:
        return new Resolution[0];
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int[] getSupportSubtitleLangs() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getSupportSubtitleLangs();
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getSupportedTTSAudioInfo() {
        VideoRef r100 = this.vodVideoRef;
        ArrayList r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<VideoInfo> r102 = r100.getValueList(231);
        if (r102 != null) goto L8;
    L14:
        return r101;
    L8:
        if (r102.size() == 0) goto L14;
        r101 = new ArrayList();
        Iterator<VideoInfo> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        r101.add(Integer.valueOf(r103.next().getValueInt(42)));
        goto L12
    }

    public List<VideoThumbInfo> getThumbInfoList() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mThumbInfoList;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getVType() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return "mp4";
    L5:
        return r100.getValueStr(211);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<VideoInfo> getVideoInfoList() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r100.getVideoInfoList();
    }

    public VideoSeekTs getVideoSeekTS() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mSeekTs;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoStyle getVideoStyle() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mVideoStyle;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean hasData() {
        if (this.vodVideoRef == null) goto L5;
    L8:
        return true;
    L5:
        if (this.liveVideoRef != null) goto L8;
        return false;
    }

    public boolean isDashSource() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getValueBool(205).booleanValue() == false) goto L7;
        return true;
    }

    public boolean isHlsSource() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getValueBool(208).booleanValue() == false) goto L7;
        return true;
    }

    public boolean isMp4Source() {
        VideoRef r100 = this.vodVideoRef;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getValueBool(206).booleanValue() == false) goto L7;
        return true;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean isSupportBash() {
        if (TextUtils.isEmpty(getVideoRefStr(8)) == false) goto L6;
        return false;
    L6:
        if (hasFormat(IVideoModel.Format.DASH) == false) goto L13;
        String r100 = getDynamicType();
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L19:
        return false;
    L10:
        if (r100.equals(TTVideoEngineInterface.DYNAMIC_TYPE_SEGMENTBASE) == false) goto L19;
        return true;
    L13:
        if (hasFormat(IVideoModel.Format.MP4) == false) goto L19;
        if (getVideoRefBool(222) == false) goto L19;
        if (TextUtils.isEmpty(getSpadea()) == false) goto L19;
        return true;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean isSupportHLSSeamlessSwitch() {
        if (TextUtils.isEmpty(getVideoRefStr(8)) == false) goto L6;
        return false;
    L6:
        if (hasFormat(IVideoModel.Format.HLS) == true) goto L8;
    L11:
        return false;
    L8:
        if (getVideoRefBool(222) == false) goto L11;
        return true;
    }

    public VideoModel() {
        this.videoRef = null;
        this.videoAdRefList = null;
        this.liveVideoRef = null;
        this.vodVideoRef = null;
        this.mSourceType = 1;
        this.mVersion = 1;
        this.mResolutionMap = null;
        this.mJsonInfo = null;
        this.mURLEncrypted = false;
        this.mKeyseed = null;
    }

    public boolean isLiveSource() {
        if (getSource() != IVideoModel.Source.LIVE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String toMediaInfoJsonString() {
        JSONObject r100 = getMediaInfo();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.toString();
    }

    public JSONObject getJsonInfo() {
        return this.mJsonInfo;
    }

    public int getSourceType() {
        return this.mSourceType;
    }

    public VideoRef getVideoRef() {
        return this.vodVideoRef;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] allVideoURLs(Resolution r100) {
        return allVideoURLs(r100, null);
    }

    public void extractFields(JSONObject r100) throws Throwable {
        if (r100 != null) goto L42;
        return;
    L42:
        this.mJsonInfo = new JSONObject(r100.toString());     // Catch: Throwable -> L6
    L7:
        JSONObject r101 = r100.optJSONObject(a.KEY_VIDEO_INFO);
        if (r101 != null) goto L10;
    L12:
        JSONArray r102 = r100.optJSONArray("video_ad_list");
        if (r102 != null) goto L15;
    L21:
        JSONObject r103 = r100.optJSONObject("live_info");
        if (r103 == null) goto L24;
        this.mSourceType = 0;
        this.liveVideoRef = new LiveVideoRef();
        JSONObject r104 = r103.optJSONObject("data");
        this.liveVideoRef.extractFields(r104);
    L24:
        JSONArray r105 = r100.optJSONArray("PlayInfoList");
        if (r105 == null) goto L29;
        if (r105.length() <= 0) goto L29;
    L33:
        if (r100.optInt("Version") != 4) goto L35;
        this.mVersion = 4;
    L36:
        VideoRef r106 = new VideoRef();
        this.vodVideoRef = r106;
        r106.setVersion(this.mVersion);
        this.vodVideoRef.extractFields(r100);
    L37:
        setUpResolution(this.mResolutionMap);
        return;
    L35:
        this.mVersion = 2;
    L29:
        if (TextUtils.isEmpty(r100.optString("VideoID")) == false) goto L33;
        if (TextUtils.isEmpty(r100.optString("Vid")) == true) goto L37;
    L15:
        if (r102.length() <= 0) goto L21;
        this.videoAdRefList = new ArrayList();
        int r107 = 0;
    L18:
        if (r107 >= r102.length()) goto L21;
        VideoAdRef r108 = new VideoAdRef();     // Catch: Exception -> L39
        r108.extractFields(JSONArrayProtectorUtils.getJSONObject(r102, r107));     // Catch: Exception -> L39
        this.videoAdRefList.add(r108);     // Catch: Exception -> L39
    L20:
        r107 = r107 + 1;
        goto L18
    L10:
        if (r101.length() <= 0) goto L12;
        this.mVersion = 1;
        VideoRef r109 = new VideoRef();
        r109.setVersion(this.mVersion);
        JSONObject r110 = r101.optJSONObject("data");
        r109.setValue(219, this.mURLEncrypted);
        r109.setValueStr(218, this.mKeyseed);
        r109.extractFields(r110);
        this.videoRef = r109;
        this.vodVideoRef = r109;
    L6:
        TTVideoEngineLog.e("VideoModel", "generate mJsonInfo error");
        goto L7
    }

    public int getPreloadInterval(Resolution r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 == null) goto L11;
        VideoInfo r102 = r101.getVideoInfo(r100, null);
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.getValueInt(13);
    L11:
        return 0;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getSupportInfoId(int r100) {
        VideoRef r101 = this.vodVideoRef;
        ArrayList r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        List<VideoInfo> r103 = r101.getVideoInfoList();
        if (r103 != null) goto L8;
    L16:
        return r102;
    L8:
        if (r103.size() == 0) goto L16;
        r102 = new ArrayList();
        Iterator<VideoInfo> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        VideoInfo r105 = r104.next();
        if (r105.getMediatype() != r100) goto L12;
        r102.add(Integer.valueOf(r105.mInfoId));
        goto L12
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getVideoInfo(r100, null);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfoByInfoId(int r100) {
        if (r100 < 0) goto L18;
        VideoRef r101 = this.vodVideoRef;
        if (r101 == null) goto L18;
        List<VideoInfo> r102 = r101.getVideoInfoList();
        if (r102 == null) goto L18;
        if (r102.size() == 0) goto L18;
        Iterator<VideoInfo> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        VideoInfo r104 = r103.next();
        if (r104.mInfoId != r100) goto L14;
        return r104;
    L18:
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean getVideoRefBool(int r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.getValueBool(r100).booleanValue();
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public float getVideoRefFloat(int r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return 0.0f;
    L5:
        return r101.getValueFloat(r100);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int getVideoRefInt(int r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getValueInt(r100);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public long getVideoRefLong(int r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.getValueLong(r100);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getVideoRefStr(int r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getValueStr(r100);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean hasFormat(IVideoModel.Format r100) {
        if (this.vodVideoRef != null) goto L5;
        return false;
    L5:
        int r101 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L16;
        return false;
    L16:
        return this.vodVideoRef.getValueBool(205).booleanValue();
    L17:
        return this.vodVideoRef.getValueBool(206).booleanValue();
    L15:
        return this.vodVideoRef.getValueBool(208).booleanValue();
    }

    public void initWithJson(JSONObject r100) throws Throwable {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.put(IVideoEventLogger.FEATURE_KEY_MULTI_BITRATE_REFACTOR, true);
        extractFields(new JSONObject().put(a.KEY_VIDEO_INFO, new JSONObject().put("data", r100)));
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String resolutionToString(Resolution r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 == null) goto L7;
        return r101.resolutionToString(r100);
    L7:
        return r100.toString(VideoRef.TYPE_VIDEO);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public void setUpResolution(HashMap<String, Resolution> r100) {
        this.mResolutionMap = r100;
        VideoRef r101 = this.vodVideoRef;
        if (r101 == null) goto L6;
        r101.setUpResolution(r100);
        return;
    }

    public void setVideoRef(VideoRef r100) {
        this.vodVideoRef = r100;
        setUpResolution(this.mResolutionMap);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Map<Integer, String> r100) {
        VideoRef r101 = this.vodVideoRef;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getVideoInfo(r100);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] allVideoURLs(Resolution r100, Map<Integer, String> r101) {
        VideoRef r102 = this.vodVideoRef;
        if (r102 != null) goto L5;
        LiveVideoRef r103 = this.liveVideoRef;
        if (r103 == null) goto L13;
        LiveVideoInfo r104 = r103.getLiveVideoInfo();
        if (r104 == null) goto L13;
        return r104.mURLs;
    L13:
        return new String[0];
    L5:
        return r102.allVideoURLs(r100, r101);
    }

    public int getPreloadInterval(Resolution r100, Map<Integer, String> r101) {
        VideoRef r102 = this.vodVideoRef;
        if (r102 == null) goto L9;
        VideoInfo r103 = r102.getVideoInfo(r100, r101);
        if (r103 == null) goto L10;
        r103.getValueInt(13);
        return 0;
    L10:
        return 0;
    L9:
        return 0;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100, boolean r101) {
        VideoRef r102 = this.vodVideoRef;
        if (r102 != null) goto L5;
        return null;
    L5:
        return getVideoInfo(r100, r102.getValueInt(7), null, r101);
    }

    public void setVideoRefBool(int r100, boolean r101) {
        if (r100 != 219) goto L6;
        this.mURLEncrypted = r101;
        return;
    }

    public void setVideoRefStr(int r100, String r101) {
        VideoRef r102 = this.vodVideoRef;
        if (r102 == null) goto L6;
        r102.setValueStr(r100, r101);
    L6:
        if (r100 != 218) goto L9;
        this.mKeyseed = r101;
        return;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100, Map<Integer, String> r101) {
        VideoRef r102 = this.vodVideoRef;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.getVideoInfo(r100, r101);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100, Map<Integer, String> r101, boolean r102) {
        VideoRef r103 = this.vodVideoRef;
        if (r103 != null) goto L5;
        return null;
    L5:
        return getVideoInfo(r100, r103.getValueInt(7), r101, r102);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100, int r101, Map<Integer, String> r102) {
        VideoRef r103 = this.vodVideoRef;
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.getVideoInfo(r100, r101, r102);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100, int r101, boolean r102) {
        if (this.vodVideoRef != null) goto L5;
        return null;
    L5:
        return getVideoInfo(r100, r101, null, r102);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution r100, int r101, Map<Integer, String> r110, boolean r111) {
        VideoInfo r102 = getVideoInfo(r100, r101, r110);
        if (r111 == true) goto L5;
        return r102;
    L5:
        String[] r112 = TTVideoEngine.getAllQualityInfos();
        int r103 = 0;
        if (r112.length <= 0) goto L28;
        if (r110 == null) goto L28;
        if (r110.containsKey(32) == false) goto L28;
        int r104 = r112.length - 1;
        if (r102 != null) goto L28;
        String r105 = r110.get(32);
        if (r105 == null) goto L28;
        int r106 = 0;
    L16:
        if (r106 >= r112.length) goto L21;
        if (r112[r106].equals(r105) == true) goto L19;
        r106 = r106 + 1;
        goto L16
    L19:
        r104 = r106;
    L21:
        int r107 = r104;
    L22:
        if (r102 != null) goto L28;
        r110.put(32, r112[r107]);
        r102 = getVideoInfo(r100, r101, r110);
        if (r102 != null) goto L25;
        r107 = ((r107 + r112.length) - 1) % r112.length;
        if (r107 != r104) goto L22;
    L25:
        return r102;
    L28:
        Resolution[] r113 = Resolution.getAllResolutions();
        if (r113.length > 0) goto L31;
        return r102;
    L31:
        int r114 = r113.length - 1;
        if (r100 != null) goto L34;
    L39:
        int r108 = r114;
    L40:
        if (r102 != null) goto L46;
        r102 = getVideoInfo(r113[r108], r101, null);
        if (r102 != null) goto L46;
        r108 = ((r108 + r113.length) - 1) % r113.length;
        if (r108 != r114) goto L40;
    L46:
        return r102;
    L34:
        if (r103 >= r113.length) goto L39;
        if (r113[r103].getIndex() == r100.getIndex()) goto L37;
        r103 = r103 + 1;
        goto L34
    L37:
        r114 = r103;
        goto L39
    }
}
