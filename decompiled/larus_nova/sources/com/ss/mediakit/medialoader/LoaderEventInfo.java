package com.ss.mediakit.medialoader;

import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class LoaderEventInfo {
    public long bitrate;
    public long bytesLoaded;
    public int dataType;
    public long elapsedRealtimeMs;
    public long endOff;
    public String fileHash;
    public long loadDurationMs;
    public HashMap<String, String> mHeaders;
    public long off;
    public int taskType;
    public int what;

    public LoaderEventInfo() {
        this.what = -1;
        this.fileHash = null;
        this.mHeaders = new HashMap();
        this.taskType = -1;
        this.dataType = -1;
        this.bytesLoaded = -1;
        this.bitrate = -1;
        this.elapsedRealtimeMs = -1;
        this.loadDurationMs = -1;
        this.off = -1;
        this.endOff = -1;
    }
}
