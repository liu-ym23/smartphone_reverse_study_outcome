package com.ss.android.ugc.aweme.discover.commodity.api;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;", "Ljava/io/Serializable;", "()V", "chunkName", "", "getChunkName", "()Ljava/lang/String;", "setChunkName", "(Ljava/lang/String;)V", "extra", "", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "statusCode", "", "getStatusCode", "()I", "setStatusCode", "(I)V", a.KEY_STATUS_MSG, "getStatusMsg", "setStatusMsg", "timeCost", "", "getTimeCost", "()J", "setTimeCost", "(J)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChunkInfo implements Serializable {

    @SerializedName("chunk_name")
    private String chunkName;

    @SerializedName("extra")
    private Object extra;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMsg;

    @SerializedName("time_cost")
    private long timeCost;

    public ChunkInfo() {
    }

    public final String getChunkName() {
        return this.chunkName;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final long getTimeCost() {
        return this.timeCost;
    }

    public final void setChunkName(String r100) {
        this.chunkName = r100;
    }

    public final void setExtra(Object r100) {
        this.extra = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }

    public final void setTimeCost(long r100) {
        this.timeCost = r100;
    }
}
