package com.bytedance.locallife.poi.dito.mob;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JD\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006%"}, d2 = {"Lcom/bytedance/locallife/poi/dito/mob/PoiNetworkDetailTime;", "Ljava/io/Serializable;", "requestStartTime", "", "responseBackTime", "officialWaitToReturnTime", "chunkInfoList", "", "Lcom/bytedance/locallife/poi/dito/mob/ChunkInfo;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)V", "getChunkInfoList", "()Ljava/util/List;", "setChunkInfoList", "(Ljava/util/List;)V", "getOfficialWaitToReturnTime", "()Ljava/lang/Long;", "setOfficialWaitToReturnTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRequestStartTime", "setRequestStartTime", "getResponseBackTime", "setResponseBackTime", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)Lcom/bytedance/locallife/poi/dito/mob/PoiNetworkDetailTime;", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiNetworkDetailTime implements Serializable {

    @SerializedName("chunk_info_list")
    private List<ChunkInfo> chunkInfoList;

    @SerializedName("official_wait_to_return_time")
    private Long officialWaitToReturnTime;

    @SerializedName("request_start_time")
    private Long requestStartTime;

    @SerializedName("response_back_time")
    private Long responseBackTime;

    public PoiNetworkDetailTime() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiNetworkDetailTime copy$default(PoiNetworkDetailTime r100, Long r101, Long r102, Long r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.requestStartTime;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.responseBackTime;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.officialWaitToReturnTime;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.chunkInfoList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.requestStartTime;
    }

    public final Long component2() {
        return this.responseBackTime;
    }

    public final Long component3() {
        return this.officialWaitToReturnTime;
    }

    public final List<ChunkInfo> component4() {
        return this.chunkInfoList;
    }

    public final PoiNetworkDetailTime copy(Long r100, Long r101, Long r102, List<ChunkInfo> r103) {
        return new PoiNetworkDetailTime(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiNetworkDetailTime) == true) goto L8;
        return false;
    L8:
        PoiNetworkDetailTime r101 = (PoiNetworkDetailTime) r100;
        if (Intrinsics.areEqual(this.requestStartTime, r101.requestStartTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.responseBackTime, r101.responseBackTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.officialWaitToReturnTime, r101.officialWaitToReturnTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chunkInfoList, r101.chunkInfoList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r100 = this.requestStartTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.responseBackTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.officialWaitToReturnTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<ChunkInfo> r110 = this.chunkInfoList;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiNetworkDetailTime(requestStartTime=" + this.requestStartTime + ", responseBackTime=" + this.responseBackTime + ", officialWaitToReturnTime=" + this.officialWaitToReturnTime + ", chunkInfoList=" + this.chunkInfoList + ')';
    }

    public final List<ChunkInfo> getChunkInfoList() {
        return this.chunkInfoList;
    }

    public final Long getOfficialWaitToReturnTime() {
        return this.officialWaitToReturnTime;
    }

    public final Long getRequestStartTime() {
        return this.requestStartTime;
    }

    public final Long getResponseBackTime() {
        return this.responseBackTime;
    }

    public final void setChunkInfoList(List<ChunkInfo> r100) {
        this.chunkInfoList = r100;
    }

    public final void setOfficialWaitToReturnTime(Long r100) {
        this.officialWaitToReturnTime = r100;
    }

    public final void setRequestStartTime(Long r100) {
        this.requestStartTime = r100;
    }

    public final void setResponseBackTime(Long r100) {
        this.responseBackTime = r100;
    }

    public PoiNetworkDetailTime(Long r100, Long r101, Long r102, List<ChunkInfo> r103) {
        this.requestStartTime = r100;
        this.responseBackTime = r101;
        this.officialWaitToReturnTime = r102;
        this.chunkInfoList = r103;
    }

    public /* synthetic */ PoiNetworkDetailTime(Long r100, Long r101, Long r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
