package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.api.ChunkInfo;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ExtraInfo;", "Ljava/io/Serializable;", "()V", "chunkInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;", "getChunkInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;", "setChunkInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;)V", "serverTimeCost", "", "", "", "getServerTimeCost", "()Ljava/util/Map;", "setServerTimeCost", "(Ljava/util/Map;)V", "version", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtraInfo implements Serializable {

    @SerializedName("chunk_info")
    private ChunkInfo chunkInfo;

    @SerializedName("time_cost")
    private Map<String, ? extends Object> serverTimeCost;

    @SerializedName("version")
    private String version;

    public ExtraInfo() {
    }

    public final ChunkInfo getChunkInfo() {
        return this.chunkInfo;
    }

    public final Map<String, Object> getServerTimeCost() {
        return this.serverTimeCost;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setChunkInfo(ChunkInfo r100) {
        this.chunkInfo = r100;
    }

    public final void setServerTimeCost(Map<String, ? extends Object> r100) {
        this.serverTimeCost = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }
}
