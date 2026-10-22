package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.source.strategy.CodecStrategy;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class PreloaderVidItem {
    private static final String TAG = "PreloaderVidItem";
    public CodecStrategyAdapter mAdapter;
    public int mApiVersion;
    private String mAuthorization;
    public boolean mBoeEnable;
    private IPreLoaderItemCallBackListener mCallBackListener;
    public int mCdnType;
    public String mCodecType;
    public boolean mDashEnable;
    public boolean mEncryptEnable;
    private PreloaderVidItemFetchListener mFetchEndListener;
    private PreloaderFilePathListener mFilePathListener;
    public boolean mForbidP2p;
    private String mFormatType;
    public int mGearStrategyEnabled;
    public Map<String, Object> mGearStrategyExtraParams;
    public boolean mHlsEnable;
    public boolean mHttpsEnable;
    private String mItemHash;
    public PreloaderVidItemListener mListener;
    private TTVNetClient mNetClient;
    private boolean mOnlyFetchVideoModel;
    public Map<Integer, String> mParams;
    private int mPlayIndexGap;
    public long mPreloadSize;
    public int mPriorityLevel;
    public Resolution mResolution;
    public HashMap<String, Resolution> mResolutionMap;
    public long mStartTimestamp;
    private String mSubTag;
    private String mTag;
    public String mVideoId;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.PreloaderVidItem$1, reason: invalid class name */
    public class AnonymousClass1 implements CodecStrategyAdapter.PreloadSourceSetter {
        final /* synthetic */ PreloaderVidItem this$0;

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ String createTag() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$createTag(this);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ void setDirectUrl(String r100, DirectUrlSource.UrlItem r101, CodecStrategy.Dimension r102, boolean r103) {
            CodecStrategyAdapter.PreloadSourceSetter.CC.$default$setDirectUrl(this, r100, r101, r102, r103);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ void setVideoModel(String r100, IVideoModel r101, Resolution r102) {
            CodecStrategyAdapter.PreloadSourceSetter.CC.$default$setVideoModel(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ int type() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$type(this);
        }

        public AnonymousClass1(PreloaderVidItem r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setVideoID(String r100, String r101, Resolution r102, String r103, CodecStrategy.Dimension r104) {
            CodecStrategyAdapter.PreloadSourceSetter.CC.$default$setVideoID(this, r100, r101, r102, r103, r104);
            PreloaderVidItem r105 = this.this$0;
            r105.mVideoId = r100;
            r105.setAuthorization(r101);
            if (r104 == null) goto L5;
            PreloaderVidItem r106 = this.this$0;
            r106.mCodecType = r104.encodeType;
        L8:
            if (r102 == null) goto L11;
            this.this$0.mResolution = r102;
            return;
        L11:
            return;
        L5:
            if (r103 == null) goto L7;
            this.this$0.mCodecType = r103;
            goto L8
        L7:
            this.this$0.mCodecType = null;
            goto L8
        }
    }

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

    public void setAuthorization(String r100) {
    }

    public int getCdnType() {
        throw new UnsupportedOperationException("tob only");
    }

    public TTVNetClient getNetClient() {
        TTVNetClient r100 = this.mNetClient;
        if (r100 == null) goto L5;
        return r100;
    L5:
        TTVNetClient r101 = TTVideoEngineConfig.gNetClient;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return null;
    }

    public String getAuthorization() {
        return this.mAuthorization;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public PreloaderVidItemFetchListener getFetchEndListener() {
        return this.mFetchEndListener;
    }

    public PreloaderFilePathListener getFilePathListener() {
        return this.mFilePathListener;
    }

    public String getFormatType() {
        return this.mFormatType;
    }

    public PreloaderVidItemListener getListener() {
        return this.mListener;
    }

    public boolean getOnlyFetchVideoModel() {
        return this.mOnlyFetchVideoModel;
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

    public void setCallBackListener(IPreLoaderItemCallBackListener r100) {
        this.mCallBackListener = r100;
    }

    public void setCdnType(int r100) {
        throw new UnsupportedOperationException("tob only");
    }

    public void setFetchEndListener(PreloaderVidItemFetchListener r100) {
        this.mFetchEndListener = r100;
    }

    public void setFilePathListener(PreloaderFilePathListener r100) {
        this.mFilePathListener = r100;
    }

    public void setFormatType(String r100) {
        this.mFormatType = r100;
    }

    public void setListener(PreloaderVidItemListener r100) {
        this.mListener = r100;
    }

    public void setNetworkClient(TTVNetClient r100) {
        this.mNetClient = r100;
    }

    public void setOnlyFetchVideoModel(boolean r100) {
        this.mOnlyFetchVideoModel = r100;
    }

    public void setPlayIndexGap(int r100) {
        this.mPlayIndexGap = r100;
    }

    public void setPriorityLevel(int r100) {
        this.mPriorityLevel = r100;
    }

    public void setResolutionMap(HashMap<String, Resolution> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L9;
        this.mResolutionMap = r100;
        return;
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

    public PreloaderVidItem(VidPlayAuthTokenSource r100, long r101) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        throw new UnsupportedOperationException("toB only");
    }

    public PreloaderVidItem(String r100, String r101, boolean r102) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
    }

    public PreloaderVidItem(String r100, Resolution r101, long r102, boolean r103) {
        this.mVideoId = null;
        Resolution r104 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        if (r103 == false) goto L6;
        this.mCodecType = "bytevc1";
        return;
    }

    public PreloaderVidItem(String r100, Resolution r101, long r102, String r103) {
        this.mVideoId = null;
        Resolution r104 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mCodecType = r103;
    }

    public PreloaderVidItem(String r100, Resolution r101, long r102, boolean r103, boolean r104) {
        this.mVideoId = null;
        Resolution r105 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        if (r103 == false) goto L5;
        this.mCodecType = "bytevc1";
    L5:
        this.mForbidP2p = r104;
    }

    public PreloaderVidItem(String r100, Resolution r101, long r102, String r103, boolean r104) {
        this.mVideoId = null;
        Resolution r105 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = r100;
        this.mResolution = r101;
        this.mPreloadSize = r102;
        this.mCodecType = r103;
        this.mForbidP2p = r104;
    }

    public PreloaderVidItem(String r100, String r101, Resolution r102, long r103, String r104) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
    }

    public PreloaderVidItem(String r100, String r101, Resolution r102, long r103, boolean r104) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0;
        this.mItemHash = null;
        this.mFormatType = null;
    }
}
