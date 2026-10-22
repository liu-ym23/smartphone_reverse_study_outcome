package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class PreLoaderItemCallBackInfo {
    public static final int KEY_IS_FETCH_END_VIDEOMODEL = 4;
    public static final int KEY_IS_PRELOAD_ADDED = 7;
    public static final int KEY_IS_PRELOAD_ALL_URL_FAILED = 9;
    public static final int KEY_IS_PRELOAD_END_CANCEL = 5;
    public static final int KEY_IS_PRELOAD_END_FAIL = 3;
    public static final int KEY_IS_PRELOAD_END_SUCCEED = 2;
    public static final int KEY_IS_PRELOAD_INFO = 6;
    public static final int KEY_IS_PRELOAD_START = 8;
    public static final int KEY_IS_USING_URLINFOS = 1;
    public static final int PRELOAD_TYPE_MILLISECOND = 1;
    public static final int PRELOAD_TYPE_SIZE = 0;
    public long audioPreloadSize;
    public String businessContext;
    public VideoModel fetchVideoModel;
    public String fileHash;
    public DataLoaderHelper.DataLoaderTaskLoadProgress loadProgress;
    private int mKey;
    public DataLoaderHelper.DataLoaderTaskProgressInfo preloadDataInfo;
    public Error preloadError;
    public int preloadType;
    public List<VideoInfo> usingUrlInfos;
    public long videoPreloadSize;

    public int getKey() {
        return this.mKey;
    }

    public PreLoaderItemCallBackInfo(int r100) {
        this.usingUrlInfos = null;
        this.preloadDataInfo = null;
        this.loadProgress = null;
        this.preloadError = null;
        this.fetchVideoModel = null;
        this.businessContext = null;
        this.fileHash = null;
        this.preloadType = 0;
        this.audioPreloadSize = 0;
        this.videoPreloadSize = 0;
        this.mKey = r100;
    }
}
