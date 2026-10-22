package com.ss.ttvideoengine.preload;

import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.DubbedInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.strategrycenter.ISelectBitrateCallback;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PreloadModelMedia extends PreloadMedia {
    public boolean isLast;
    private long mCDNUrlExpiredTime;
    private String mContext;
    private String mCustomPath;
    private long mDubbedAudioPreloadSize;
    private List<DubbedInfo> mDubbedAudios;
    private Map<String, String> mExtraInfo;
    private String mFirstSubVid;
    public boolean mForbidP2p;
    private String mGroupId;
    private boolean mIsEnablePreloadDubbedAudio;
    private Map<Resolution, Float> mMultipleInfo;
    private int mPriorityLevel;
    public Resolution mResolution;
    private ISelectBitrateCallback mSelectCallback;
    public long mStartTimestamp;
    private int mSubListIndex;
    private String mSubTag;
    private String mTag;
    public IVideoModel mVideoModel;

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.mVideoModel});
    }

    public String toStrategyInfo() {
        JSONObject r100 = this.mVideoModel.getMediaInfo();
        if (r100 != null) goto L61;
        return "";
    L61:
        r100.put("sc_priority", this.mPriorityLevel);     // Catch: Throwable -> L58
        if (this.mExtraInfo == null) goto L8;
        r100.put("sc_extra", new JSONObject(getExtraInfo()));     // Catch: Throwable -> L58
    L8:
        String r101 = this.mCustomPath;     // Catch: Throwable -> L58
        if (r101 == null) goto L11;
        r100.put("sc_custom_path", r101);     // Catch: Throwable -> L58
    L11:
        String r102 = this.mContext;     // Catch: Throwable -> L58
        if (r102 == null) goto L14;
        r100.put("sc_context", r102);     // Catch: Throwable -> L58
    L14:
        long r103 = this.mPreloadSize;     // Catch: Throwable -> L58
        if (r103 <= 0) goto L17;
        r100.put("sc_preload_size", r103);     // Catch: Throwable -> L58
    L17:
        String r104 = this.mFirstSubVid;     // Catch: Throwable -> L58
        if (r104 == null) goto L20;
        r100.put("sc_frt_sub_vid", r104);     // Catch: Throwable -> L58
    L20:
        int r105 = this.mSubListIndex;     // Catch: Throwable -> L58
        if (r105 == (-1)) goto L23;
        r100.put("sc_sub_list_index", r105);     // Catch: Throwable -> L58
    L23:
        long r106 = this.mCDNUrlExpiredTime;     // Catch: Throwable -> L58
        if (r106 == 0) goto L27;
        r100.put("sc_url_expired_t", r106);     // Catch: Throwable -> L58
    L27:
        if (this.mTag.length() <= 0) goto L30;
        r100.put("sc_tag", this.mTag);     // Catch: Throwable -> L58
    L30:
        if (this.mSubTag.length() <= 0) goto L33;
        r100.put("sc_sub_tag", this.mSubTag);     // Catch: Throwable -> L58
    L33:
        if (this.mGroupId.length() <= 0) goto L36;
        r100.put("sc_gid", this.mGroupId);     // Catch: Throwable -> L58
    L36:
        if (this.mDubbedAudios == null) goto L47;
        if (this.mIsEnablePreloadDubbedAudio == false) goto L47;
        JSONArray r107 = new JSONArray();     // Catch: Throwable -> L58
        Iterator<DubbedInfo> r108 = this.mDubbedAudios.iterator();     // Catch: Throwable -> L58
    L41:
        if (r108.hasNext() == false) goto L45;
        DubbedInfo r109 = r108.next();     // Catch: Throwable -> L58
        if (r109.toStrategyPreloadJsonObject() == null) goto L41;
        r107.put(r109.toStrategyPreloadJsonObject());     // Catch: Throwable -> L58
        goto L41
    L45:
        r100.put("sc_dubbed_audios", r107);     // Catch: Throwable -> L58
        r100.put("sc_dubbed_preload", this.mIsEnablePreloadDubbedAudio);     // Catch: Throwable -> L58
        r100.put("sc_dubbed_size", this.mDubbedAudioPreloadSize);     // Catch: Throwable -> L58
    L47:
        if (this.mMultipleInfo == null) goto L53;
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L58
        Iterator<Map.Entry<Resolution, Float>> r111 = this.mMultipleInfo.entrySet().iterator();     // Catch: Throwable -> L58
    L50:
        if (r111.hasNext() == false) goto L52;
        Map.Entry<Resolution, Float> r112 = r111.next();     // Catch: Throwable -> L58
        r110.put(r112.getKey().toString(VideoRef.TYPE_VIDEO), r112.getValue());     // Catch: Throwable -> L58
        goto L50
    L52:
        r100.put("sc_multiple_info", r110);     // Catch: Throwable -> L58
    L53:
        long r113 = this.mStartTimestamp;     // Catch: Throwable -> L58
        if (r113 <= 0) goto L56;
        r100.put("timestamp", r113);     // Catch: Throwable -> L58
    L56:
        return r100.toString();
    L58:
        th = move-exception;
        TTVideoEngineLog.d(th);
        return "";
    }

    public boolean isNeedConvertStrategyInfo() {
        if (getExtraInfo() == null) goto L5;
    L20:
        return true;
    L5:
        if (getSubListIndex() != (-1)) goto L20;
        if (getFirstSubVid() != null) goto L20;
        if (this.mCDNUrlExpiredTime != 0) goto L20;
        if (this.mTag.length() > 0) goto L20;
        if (this.mSubTag.length() > 0) goto L20;
        if (getMultipleInfo() != null) goto L20;
        if (this.mStartTimestamp > 0) goto L20;
        return false;
    }

    public long getCDNUrlExpiredTime() {
        return this.mCDNUrlExpiredTime;
    }

    public String getContext() {
        return this.mContext;
    }

    public String getCustomPath() {
        return this.mCustomPath;
    }

    public long getDubbedAudioPreloadSize() {
        return this.mDubbedAudioPreloadSize;
    }

    public List<DubbedInfo> getDubbedAudios() {
        return this.mDubbedAudios;
    }

    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public String getFirstSubVid() {
        return this.mFirstSubVid;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public Map<Resolution, Float> getMultipleInfo() {
        return this.mMultipleInfo;
    }

    public int getPriorityLevel() {
        return this.mPriorityLevel;
    }

    public ISelectBitrateCallback getSelectCallback() {
        return this.mSelectCallback;
    }

    public long getStartTimestamp() {
        return this.mStartTimestamp;
    }

    public int getSubListIndex() {
        return this.mSubListIndex;
    }

    public String getSubTag() {
        return this.mSubTag;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isEnablePreloadDubbedAudio() {
        return this.mIsEnablePreloadDubbedAudio;
    }

    public PreloadModelMedia(IVideoModel r100) {
        this.mVideoModel = null;
        this.mResolution = Resolution.Undefine;
        this.mForbidP2p = false;
        this.mSelectCallback = null;
        this.mExtraInfo = null;
        this.mPriorityLevel = 0;
        this.mCustomPath = null;
        this.mContext = null;
        this.mFirstSubVid = null;
        this.mSubListIndex = -1;
        this.mCDNUrlExpiredTime = 0;
        this.mDubbedAudios = null;
        this.mIsEnablePreloadDubbedAudio = false;
        this.mDubbedAudioPreloadSize = 0;
        this.mMultipleInfo = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mGroupId = "";
        this.isLast = false;
        this.mStartTimestamp = 0;
        this.mVideoModel = r100;
    }

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreloadModelMedia) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L12;
        return false;
    L12:
        return Objects.equals(this.mVideoModel, ((PreloadModelMedia) r100).mVideoModel);
    }

    public void setCDNUrlExpiredTime(long r100) {
        this.mCDNUrlExpiredTime = r100;
    }

    public void setContext(String r100) {
        this.mContext = r100;
    }

    public void setCustomPath(String r100) {
        this.mCustomPath = r100;
    }

    public void setDubbedAudioPreloadSize(long r100) {
        this.mDubbedAudioPreloadSize = r100;
    }

    public void setDubbedAudios(List<DubbedInfo> r100) {
        this.mDubbedAudios = r100;
    }

    public void setEnablePreloadDubbedAudio(boolean r100) {
        this.mIsEnablePreloadDubbedAudio = r100;
    }

    public void setExtraInfo(Map<String, String> r100) {
        this.mExtraInfo = r100;
    }

    public void setFirstSubVideoId(String r100) {
        this.mFirstSubVid = r100;
    }

    public void setGroupId(String r100) {
        this.mGroupId = r100;
    }

    public void setMultipleInfo(Map<Resolution, Float> r100) {
        this.mMultipleInfo = r100;
    }

    public void setPriorityLevel(int r100) {
        this.mPriorityLevel = r100;
    }

    public void setSelectBitrateCallback(ISelectBitrateCallback r100) {
        this.mSelectCallback = r100;
    }

    public void setStartTimestamp(long r100) {
        this.mStartTimestamp = r100;
    }

    public void setSubTag(String r100) {
        this.mSubTag = r100;
    }

    public void setTag(String r100) {
        this.mTag = r100;
    }

    public PreloadModelMedia(IVideoModel r100, ISelectBitrateCallback r101) {
        this.mVideoModel = null;
        this.mResolution = Resolution.Undefine;
        this.mForbidP2p = false;
        this.mExtraInfo = null;
        this.mPriorityLevel = 0;
        this.mCustomPath = null;
        this.mContext = null;
        this.mFirstSubVid = null;
        this.mSubListIndex = -1;
        this.mCDNUrlExpiredTime = 0;
        this.mDubbedAudios = null;
        this.mIsEnablePreloadDubbedAudio = false;
        this.mDubbedAudioPreloadSize = 0;
        this.mMultipleInfo = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mGroupId = "";
        this.isLast = false;
        this.mStartTimestamp = 0;
        this.mVideoModel = r100;
        this.mSelectCallback = r101;
    }

    public void setFirstSubVideoId(String r100, int r101) {
        this.mFirstSubVid = r100;
        this.mSubListIndex = r101;
    }

    public PreloadModelMedia(IVideoModel r100, Resolution r101, long r102, boolean r103) {
        this.mVideoModel = null;
        Resolution r104 = Resolution.Undefine;
        this.mSelectCallback = null;
        this.mExtraInfo = null;
        this.mPriorityLevel = 0;
        this.mCustomPath = null;
        this.mContext = null;
        this.mFirstSubVid = null;
        this.mSubListIndex = -1;
        this.mCDNUrlExpiredTime = 0;
        this.mDubbedAudios = null;
        this.mIsEnablePreloadDubbedAudio = false;
        this.mDubbedAudioPreloadSize = 0;
        this.mMultipleInfo = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mGroupId = "";
        this.isLast = false;
        this.mStartTimestamp = 0;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mForbidP2p = r103;
    }
}
