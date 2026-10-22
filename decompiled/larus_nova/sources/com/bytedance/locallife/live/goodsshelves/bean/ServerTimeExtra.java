package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/ServerTimeExtra;", "Ljava/io/Serializable;", "serverStartTime", "", "serverEndTime", "(JJ)V", "getServerEndTime", "()J", "getServerStartTime", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ServerTimeExtra implements Serializable {

    @SerializedName("server_end_time")
    private final long serverEndTime;

    @SerializedName("server_start_time")
    private final long serverStartTime;

    public ServerTimeExtra() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ ServerTimeExtra copy$default(ServerTimeExtra r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.serverStartTime;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.serverEndTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.serverStartTime;
    }

    public final long component2() {
        return this.serverEndTime;
    }

    public final ServerTimeExtra copy(long r100, long r101) {
        return new ServerTimeExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ServerTimeExtra) == true) goto L8;
        return false;
    L8:
        ServerTimeExtra r101 = (ServerTimeExtra) r100;
        if (this.serverStartTime == r101.serverStartTime) goto L12;
        return false;
    L12:
        if (this.serverEndTime == r101.serverEndTime) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.serverStartTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.serverEndTime;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "ServerTimeExtra(serverStartTime=" + this.serverStartTime + ", serverEndTime=" + this.serverEndTime + ')';
    }

    public final long getServerEndTime() {
        return this.serverEndTime;
    }

    public final long getServerStartTime() {
        return this.serverStartTime;
    }

    public ServerTimeExtra(long r100, long r101) {
        this.serverStartTime = r100;
        this.serverEndTime = r101;
    }

    public /* synthetic */ ServerTimeExtra(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
