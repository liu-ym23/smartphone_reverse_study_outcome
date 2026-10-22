package com.bytedance.locallife.poi.dito.mob;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/poi/dito/mob/ChunkInfo;", "Ljava/io/Serializable;", "chunkReadEndTime", "", "chunkDitoParseEndTime", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getChunkDitoParseEndTime", "()Ljava/lang/Long;", "setChunkDitoParseEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getChunkReadEndTime", "setChunkReadEndTime", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/locallife/poi/dito/mob/ChunkInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ChunkInfo implements Serializable {

    @SerializedName("chunk_dito_parse_end_time")
    private Long chunkDitoParseEndTime;

    @SerializedName("chunk_read_end_time")
    private Long chunkReadEndTime;

    /* JADX WARN: Multi-variable type inference failed */
    public ChunkInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ChunkInfo copy$default(ChunkInfo r100, Long r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.chunkReadEndTime;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chunkDitoParseEndTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.chunkReadEndTime;
    }

    public final Long component2() {
        return this.chunkDitoParseEndTime;
    }

    public final ChunkInfo copy(Long r100, Long r101) {
        return new ChunkInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChunkInfo) == true) goto L8;
        return false;
    L8:
        ChunkInfo r101 = (ChunkInfo) r100;
        if (Intrinsics.areEqual(this.chunkReadEndTime, r101.chunkReadEndTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chunkDitoParseEndTime, r101.chunkDitoParseEndTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.chunkReadEndTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.chunkDitoParseEndTime;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChunkInfo(chunkReadEndTime=" + this.chunkReadEndTime + ", chunkDitoParseEndTime=" + this.chunkDitoParseEndTime + ')';
    }

    public final Long getChunkDitoParseEndTime() {
        return this.chunkDitoParseEndTime;
    }

    public final Long getChunkReadEndTime() {
        return this.chunkReadEndTime;
    }

    public final void setChunkDitoParseEndTime(Long r100) {
        this.chunkDitoParseEndTime = r100;
    }

    public final void setChunkReadEndTime(Long r100) {
        this.chunkReadEndTime = r100;
    }

    public ChunkInfo(Long r100, Long r101) {
        this.chunkReadEndTime = r100;
        this.chunkDitoParseEndTime = r101;
    }

    public /* synthetic */ ChunkInfo(Long r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
