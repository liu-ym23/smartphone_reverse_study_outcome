package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.source.VideoModelSource;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class PreloaderVideoModelItem {
    public long mAudioHeaderExtraSize;
    public long mAudioPacketExtraOffset;
    private IPreLoaderItemCallBackListener mCallBackListener;
    public int mCdnType;
    private long mDashAudioPreloadSize;
    private long mDashVideoPreloadSize;
    private PreloaderFilePathListener mFilePathListener;
    public boolean mForbidP2p;
    private String mFormatType;
    public int mGearStrategyEnabled;
    public Map<String, Object> mGearStrategyExtraParams;
    private String mGroupId;
    private String mItemHash;
    public Map<Integer, String> mParams;
    private int mPlayIndexGap;
    public float mPreloadMilliSecond;
    public long mPreloadMilliSecondOffset;
    public long mPreloadSize;
    private int mPriorityLevel;
    public Resolution mResolution;
    public long mStartTimestamp;
    public String mSubTag;
    public String mTag;
    public long mTimePreloadLowerLimitSize;
    public long mTimePreloadUpperLimitSize;
    private int mUseOriginalUrlEncode;
    public long mVideoHeaderExtraSize;
    public IVideoModel mVideoModel;
    public long mVideoPacketExtraOffset;

    public synchronized String getHash() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mItemHash != null) goto L6;
        this.mItemHash = String.valueOf(hashCode());     // Catch: Throwable -> L9
    L6:
        String r100 = this.mItemHash;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public int getCdnType() {
        throw new UnsupportedOperationException("tob only");
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public long getDashAudioPreloadSize() {
        return this.mDashAudioPreloadSize;
    }

    public long getDashVideoPreloadSize() {
        return this.mDashVideoPreloadSize;
    }

    public PreloaderFilePathListener getFilePathListener() {
        return this.mFilePathListener;
    }

    public String getFormatType() {
        return this.mFormatType;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public int getPlayIndexGap() {
        return this.mPlayIndexGap;
    }

    public int getPriorityLevel() {
        return this.mPriorityLevel;
    }

    public long getStartTimestamp() {
        return this.mStartTimestamp;
    }

    public String getSubTag() {
        return this.mSubTag;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getUseOriginalUrlEncode() {
        return this.mUseOriginalUrlEncode;
    }

    public void _notifyError(int r100) {
        if (getCallBackListener() == null) goto L6;
        PreLoaderItemCallBackInfo r101 = new PreLoaderItemCallBackInfo(3);
        r101.preloadError = new Error(Error.DataLoaderPreload, r100);
        getCallBackListener().preloadItemInfo(r101);
        return;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener r100) {
        this.mCallBackListener = r100;
    }

    public void setCdnType(int r100) {
        throw new UnsupportedOperationException("tob only");
    }

    public void setDashAudioPreloadSize(long r100) {
        this.mDashAudioPreloadSize = r100;
    }

    public void setDashVideoPreloadSize(long r100) {
        this.mDashVideoPreloadSize = r100;
    }

    public void setFilePathListener(PreloaderFilePathListener r100) {
        this.mFilePathListener = r100;
    }

    public void setFormatType(String r100) {
        this.mFormatType = r100;
    }

    public void setGroupId(String r100) {
        this.mGroupId = r100;
    }

    public void setPlayIndexGap(int r100) {
        this.mPlayIndexGap = r100;
    }

    public void setPriorityLevel(int r100) {
        this.mPriorityLevel = r100;
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

    public void setUseOriginalUrlEncode(int r100) {
        this.mUseOriginalUrlEncode = r100;
    }

    public PreloaderVideoModelItem(VideoModelSource r100, long r101) {
        this.mVideoModel = null;
        this.mResolution = Resolution.Undefine;
        this.mPreloadSize = 0;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0;
        this.mTimePreloadUpperLimitSize = 0;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        throw new UnsupportedOperationException("toB only");
    }

    public PreloaderVideoModelItem(IVideoModel r100, Resolution r101, long r102, PreloaderFilePathListener r110) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0;
        this.mTimePreloadUpperLimitSize = 0;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mFilePathListener = r110;
    }

    public PreloaderVideoModelItem(VideoModel r100, Resolution r101, long r102, PreloaderFilePathListener r110) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0;
        this.mTimePreloadUpperLimitSize = 0;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mFilePathListener = r110;
    }

    public PreloaderVideoModelItem(VideoModel r100, Resolution r101, long r102, boolean r110) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0;
        this.mTimePreloadUpperLimitSize = 0;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mForbidP2p = r110;
    }

    public PreloaderVideoModelItem(VideoModel r100, Resolution r101, long r102, long r110, boolean r111) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0;
        this.mTimePreloadUpperLimitSize = 0;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mPreloadMilliSecondOffset = r110;
        this.mForbidP2p = r111;
    }

    public PreloaderVideoModelItem(VideoModel r100, Resolution r101, float r102, long r110, long r111) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mPreloadSize = 0;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadMilliSecond = r102;
        this.mTimePreloadLowerLimitSize = r110;
        this.mTimePreloadUpperLimitSize = r111;
    }

    public PreloaderVideoModelItem(VideoModel r100, Resolution r101, long r102, long r110, long r111, boolean r112) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mTimePreloadLowerLimitSize = 0;
        this.mTimePreloadUpperLimitSize = 0;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mPreloadMilliSecondOffset = r110;
        this.mPreloadMilliSecond = r111;
        this.mForbidP2p = r112;
    }

    public PreloaderVideoModelItem(VideoModel r100, Resolution r101, long r102, float r110, long r111, long r112) {
        this.mVideoModel = null;
        Resolution r103 = Resolution.Undefine;
        this.mPreloadSize = 0;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1;
        this.mDashAudioPreloadSize = -1;
        this.mVideoModel = r100;
        this.mResolution = r101;
        this.mPreloadMilliSecondOffset = r102;
        this.mPreloadMilliSecond = r110;
        this.mTimePreloadLowerLimitSize = r111;
        this.mTimePreloadUpperLimitSize = r112;
    }
}
