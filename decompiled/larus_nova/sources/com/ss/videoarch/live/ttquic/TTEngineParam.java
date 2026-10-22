package com.ss.videoarch.live.ttquic;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
class TTEngineParam {
    public static final String DEFAULT_AGENT_NAME = "ttplayer-live";
    public static final int DEFAULT_CACHE_MAX_SIZE = 209715200;
    public static final String DEFAULT_CACHE_PATH = null;
    public static final int DEFAULT_LOG_LEVEL = 2;
    public String agentName;
    public int cacheMaxSize;
    public String cachePath;
    public String flvCachePath;
    public int logLevel;

    static {
        DEFAULT_CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS;
    }

    public TTEngineParam() {
        this.agentName = DEFAULT_AGENT_NAME;
        String r100 = DEFAULT_CACHE_PATH;
        this.cachePath = r100;
        this.flvCachePath = r100;
        this.cacheMaxSize = 209715200;
        this.logLevel = 2;
    }
}
