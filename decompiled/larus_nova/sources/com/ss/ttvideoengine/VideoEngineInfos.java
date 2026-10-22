package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.VideoInfo;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class VideoEngineInfos {
    public static final String USING_BUFFERING_END_INFOS = "bufferEndInfos";
    public static final String USING_BUFFERING_START_INFOS = "bufferStartInfos";
    public static final String USING_FIRST_FRAME_SPLIT_INFOS = "firstframe_split";
    public static final String USING_MDL_CACHE_END = "mdlcacheend";
    public static final String USING_MDL_FILEPATH_HIT_CACHE_SIZE = "mdlfilepathhitcachesize";
    public static final String USING_MDL_HIT_CACHE_SIZE = "mdlhitcachesize";
    public static final String USING_NO_RENDER_END_INFOS = "noRenderEndInfos";
    public static final String USING_NO_RENDER_START_INFOS = "noRenderStartInfos";
    public static final String USING_OUTSYNC_END_INFOS = "outsyncEndInfos";
    public static final String USING_OUTSYNC_START_INFOS = "outsyncStartInfos";
    public static final String USING_RENDER_SEEK_COMPLETE = "renderSeekComplete";
    public static final String USING_URL_INFOS = "usingUrlInfos";
    String mGroupID;
    long mHitCacheSize;
    String mKey;
    Object mObject;
    List<VideoInfo> mUrlInfos;
    String mUsingMDLPlayFilePath;
    String mUsingMDLPlayTaskKey;

    public VideoEngineInfos() {
        this.mUsingMDLPlayTaskKey = null;
        this.mUsingMDLPlayFilePath = null;
        this.mHitCacheSize = 0;
        this.mGroupID = "";
    }

    public String getGroupID() {
        return this.mGroupID;
    }

    public String getKey() {
        return this.mKey;
    }

    public Object getObject() {
        return this.mObject;
    }

    public List<VideoInfo> getUrlInfos() {
        return this.mUrlInfos;
    }

    public long getUsingMDLHitCacheSize() {
        return this.mHitCacheSize;
    }

    public String getUsingMDLPlayTaskKey() {
        return this.mUsingMDLPlayTaskKey;
    }

    public String getmUsingMDLPlayFilePath() {
        return this.mUsingMDLPlayFilePath;
    }

    public void setGroupID(String r100) {
        this.mGroupID = r100;
    }

    public void setKey(String r100) {
        this.mKey = r100;
    }

    public void setObject(Object r100) {
        this.mObject = r100;
    }

    public void setUrlInfos(List<VideoInfo> r100) {
        this.mUrlInfos = r100;
    }

    public void setUsingMDLHitCacheSize(long r100) {
        if (r100 < 0) goto L6;
        this.mHitCacheSize = r100;
        return;
    }

    public void setUsingMDLPlayTaskKey(String r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        this.mUsingMDLPlayTaskKey = r100;
    }
}
