package com.bytedance.iesgurd.sync;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncMsgModel;", "", "msgType", "", "syncTaskId", "timestamp", "", "data", "Lcom/bytedance/iesgurd/sync/SyncDataModel;", "(IIJLcom/bytedance/iesgurd/sync/SyncDataModel;)V", "getData", "()Lcom/bytedance/iesgurd/sync/SyncDataModel;", "getMsgType", "()I", "getSyncTaskId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class SyncMsgModel {

    @SerializedName("data")
    private final SyncDataModel data;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    private final int msgType;

    @SerializedName("sync_task_id")
    private final int syncTaskId;

    @SerializedName("timestamp")
    private final long timestamp;

    public static /* synthetic */ SyncMsgModel copy$default(SyncMsgModel r100, int r101, int r102, long r103, SyncDataModel r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.msgType;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.syncTaskId;
    L8:
        int r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.timestamp;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.data;
    L14:
        int r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final int component1() {
        return this.msgType;
    }

    public final int component2() {
        return this.syncTaskId;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final SyncDataModel component4() {
        return this.data;
    }

    public final SyncMsgModel copy(int r100, int r101, long r110, SyncDataModel r111) {
        return new SyncMsgModel(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SyncMsgModel) == false) goto L14;
        SyncMsgModel r101 = (SyncMsgModel) r100;
        if (this.msgType == r101.msgType) goto L8;
        return false;
    L8:
        if (this.syncTaskId == r101.syncTaskId) goto L10;
        return false;
    L10:
        if (this.timestamp == r101.timestamp) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.msgType * 31) + this.syncTaskId) * 31;
        long r101 = this.timestamp;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        SyncDataModel r103 = this.data;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L7:
        return r102 + r104;
    L5:
        r104 = 0;
        goto L7
    }

    public String toString() {
        return "SyncMsgModel(msgType=" + this.msgType + ", syncTaskId=" + this.syncTaskId + ", timestamp=" + this.timestamp + ", data=" + this.data + ")";
    }

    public final SyncDataModel getData() {
        return this.data;
    }

    public final int getMsgType() {
        return this.msgType;
    }

    public final int getSyncTaskId() {
        return this.syncTaskId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public SyncMsgModel(int r100, int r101, long r102, SyncDataModel r103) {
        this.msgType = r100;
        this.syncTaskId = r101;
        this.timestamp = r102;
        this.data = r103;
    }
}
