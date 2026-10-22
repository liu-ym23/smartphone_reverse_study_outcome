package com.larus.extension.chat_extension.impl.ltm;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/InsertBotMemoryData;", "", "_status", "", "memoryId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getMemoryId", "()Ljava/lang/String;", "getStatus", "Lcom/larus/extension/chat_extension/impl/ltm/InsertBotRespStatus;", "component1", "()Ljava/lang/Integer;", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/extension/chat_extension/impl/ltm/InsertBotMemoryData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InsertBotMemoryData {

    @SerializedName("status")
    private Integer _status;

    @SerializedName("memory_id")
    private final String memoryId;

    /* JADX WARN: Multi-variable type inference failed */
    public InsertBotMemoryData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    private final Integer component1() {
        return this._status;
    }

    public static /* synthetic */ InsertBotMemoryData copy$default(InsertBotMemoryData r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100._status;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.memoryId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component2() {
        return this.memoryId;
    }

    public final InsertBotMemoryData copy(Integer r100, String r101) {
        return new InsertBotMemoryData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InsertBotMemoryData) == true) goto L8;
        return false;
    L8:
        InsertBotMemoryData r101 = (InsertBotMemoryData) r100;
        if (Intrinsics.areEqual(this._status, r101._status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.memoryId, r101.memoryId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this._status;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.memoryId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "InsertBotMemoryData(_status=" + this._status + ", memoryId=" + this.memoryId + ')';
    }

    public final InsertBotRespStatus getStatus() {
        InsertBotRespStatus.a r100 = InsertBotRespStatus.Companion;
        Integer r101 = this._status;
        r100.getClass();
        InsertBotRespStatus[] r102 = InsertBotRespStatus.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        InsertBotRespStatus r105 = r102[r104];
        int r106 = r105.getStatus();
        if (r101 != null) goto L8;
    L10:
        boolean r107 = false;
    L11:
        if (r107 == true) goto L18;
        r104 = r104 + 1;
        goto L3
    L18:
        return r105;
    L8:
        if (r106 != r101.intValue()) goto L10;
        r107 = true;
        goto L11
    L14:
        return null;
    }

    public final String getMemoryId() {
        return this.memoryId;
    }

    public InsertBotMemoryData(Integer r100, String r101) {
        this._status = r100;
        this.memoryId = r101;
    }

    public /* synthetic */ InsertBotMemoryData(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
