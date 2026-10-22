package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.strategy.CodecStrategy;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class PreloaderURLItem {
    private static final String TAG = "PreloaderURLItem";
    public CodecStrategyAdapter mAdapter;
    private IPreLoaderItemCallBackListener mCallBackListener;
    private int mCdnType;
    private boolean mEnableHlsProxy;
    private String mFilePath;
    private String mFormatType;
    private String mGroupId;
    private HashMap<String, String> mHeaders;
    private String mItemHash;
    private String mKey;
    private int mPlayIndexGap;
    private long mPreloadFooterSize;
    private long mPreloadSize;
    private int mPriorityLevel;
    private DataLoaderResourceProvider mProvider;
    public long mStartTimestamp;
    private String mSubTag;
    private String mTag;
    private String[] mUrlExpireTimes;
    private String[] mUrls;
    private int mUseOriginalUrlEncode;
    private String mVideoId;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.PreloaderURLItem$1, reason: invalid class name */
    public class AnonymousClass1 implements CodecStrategyAdapter.PreloadSourceSetter {
        final /* synthetic */ PreloaderURLItem this$0;

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ String createTag() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$createTag(this);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ void setVideoID(String r100, String r101, Resolution r102, String r103, CodecStrategy.Dimension r104) {
            CodecStrategyAdapter.PreloadSourceSetter.CC.$default$setVideoID(this, r100, r101, r102, r103, r104);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ void setVideoModel(String r100, IVideoModel r101, Resolution r102) {
            CodecStrategyAdapter.PreloadSourceSetter.CC.$default$setVideoModel(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public final /* synthetic */ int type() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$type(this);
        }

        public AnonymousClass1(PreloaderURLItem r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setDirectUrl(String r100, DirectUrlSource.UrlItem r101, CodecStrategy.Dimension r102, boolean r103) {
            CodecStrategyAdapter.PreloadSourceSetter.CC.$default$setDirectUrl(this, r100, r101, r102, r103);
            PreloaderURLItem.access$002(this.this$0, r101.getCacheKey());
            PreloaderURLItem.access$102(this.this$0, r101.getUrls());
            PreloaderURLItem.access$202(this.this$0, r101.getUrlExpires());
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

    public int getCdnType() {
        throw new UnsupportedOperationException("tob only");
    }

    public HashMap<String, String> customHeaders() {
        return this.mHeaders;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public boolean getEnableHlsProxy() {
        return this.mEnableHlsProxy;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getFormatType() {
        return this.mFormatType;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getPlayIndexGap() {
        return this.mPlayIndexGap;
    }

    public long getPreloadFooterSize() {
        return this.mPreloadFooterSize;
    }

    public long getPreloadSize() {
        return this.mPreloadSize;
    }

    public int getPriorityLevel() {
        return this.mPriorityLevel;
    }

    public DataLoaderResourceProvider getProvider() {
        return this.mProvider;
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

    public String[] getUrlExpireTimes() {
        return this.mUrlExpireTimes;
    }

    public String[] getUrls() {
        return this.mUrls;
    }

    public int getUseOriginalUrlEncode() {
        return this.mUseOriginalUrlEncode;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener r100) {
        this.mCallBackListener = r100;
    }

    public void setCdnType(int r100) {
        throw new UnsupportedOperationException("tob only");
    }

    public void setEnableHlsProxy(boolean r100) {
        this.mEnableHlsProxy = r100;
    }

    public void setFormatType(String r100) {
        this.mFormatType = r100;
    }

    public void setGroupId(String r100) {
        this.mGroupId = r100;
    }

    public void setKey(String r100) {
        this.mKey = r100;
    }

    public void setPlayIndexGap(int r100) {
        this.mPlayIndexGap = r100;
    }

    public void setPreloadFooterSize(long r100) {
        this.mPreloadFooterSize = r100;
    }

    public void setPriorityLevel(int r100) {
        this.mPriorityLevel = r100;
    }

    public void setProvider(DataLoaderResourceProvider r100) {
        this.mProvider = r100;
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

    public PreloaderURLItem(DirectUrlSource r100, long r101) {
        this.mKey = null;
        this.mFilePath = null;
        this.mVideoId = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadSize = 0;
        this.mPreloadFooterSize = 0;
        this.mStartTimestamp = 0;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrls = null;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        throw new UnsupportedOperationException("toB only");
    }

    public static /* synthetic */ String access$002(PreloaderURLItem r100, String r101) {
        r100.mKey = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$102(PreloaderURLItem r100, String[] r101) {
        r100.mUrls = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$202(PreloaderURLItem r100, String[] r101) {
        r100.mUrlExpireTimes = r101;
        return r101;
    }

    public void setCustomHeader(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.mHeaders != null) goto L8;
        this.mHeaders = new HashMap();
    L8:
        this.mHeaders.put(r100.substring(0, 1).toUpperCase() + r100.substring(1), r101);
    }

    public PreloaderURLItem(String r100, long r101, String[] r102, String r110) {
        this.mKey = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0;
        this.mStartTimestamp = 0;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mFilePath = r110;
        this.mVideoId = r100;
        this.mPreloadSize = r101;
        this.mUrls = r102;
    }

    public PreloaderURLItem(String r100, String r101, long r102, String[] r110) {
        this.mFilePath = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0;
        this.mStartTimestamp = 0;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mKey = r100;
        this.mVideoId = r101;
        this.mPreloadSize = r102;
        this.mUrls = r110;
    }

    public PreloaderURLItem(String r100, String r101, long r102, DataLoaderResourceProvider r103, String r110) {
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0;
        this.mStartTimestamp = 0;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrls = null;
        this.mUrlExpireTimes = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mProvider = r103;
        this.mVideoId = r101;
        this.mPreloadSize = r102;
        this.mKey = r100;
        this.mFilePath = r110;
    }

    public PreloaderURLItem(String r100, String r101, long r102, String[] r103, String r110) {
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0;
        this.mStartTimestamp = 0;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mKey = r100;
        this.mVideoId = r101;
        this.mPreloadSize = r102;
        this.mUrls = r103;
        this.mFilePath = r110;
    }
}
