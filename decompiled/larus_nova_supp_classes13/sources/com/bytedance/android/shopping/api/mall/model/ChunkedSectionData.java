package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/ChunkedSectionData;", "", "chunkSectionId", "", "chunkInfo", "", "Lcom/bytedance/android/shopping/api/mall/model/ChunkedTrackAndRec;", "(Ljava/lang/String;Ljava/util/List;)V", "getChunkInfo", "()Ljava/util/List;", "getChunkSectionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChunkedSectionData {

    @SerializedName("section_infos")
    private final List<ChunkedTrackAndRec> chunkInfo;

    @SerializedName("section_id")
    private final String chunkSectionId;

    /* JADX WARN: Multi-variable type inference failed */
    public ChunkedSectionData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChunkedSectionData copy$default(ChunkedSectionData r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.chunkSectionId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.chunkInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.chunkSectionId;
    }

    public final List<ChunkedTrackAndRec> component2() {
        return this.chunkInfo;
    }

    public final ChunkedSectionData copy(String r2, List<ChunkedTrackAndRec> r3) {
        return new ChunkedSectionData(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ChunkedSectionData) == false) goto L10;
        ChunkedSectionData r4 = (ChunkedSectionData) r3;
        if (Intrinsics.areEqual(this.chunkSectionId, r4.chunkSectionId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.chunkInfo, r4.chunkInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.chunkSectionId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ChunkedTrackAndRec> r4 = this.chunkInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ChunkedSectionData(chunkSectionId=" + this.chunkSectionId + ", chunkInfo=" + this.chunkInfo + ")";
    }

    public final List<ChunkedTrackAndRec> getChunkInfo() {
        return this.chunkInfo;
    }

    public final String getChunkSectionId() {
        return this.chunkSectionId;
    }

    public ChunkedSectionData(String r1, List<ChunkedTrackAndRec> r2) {
        this.chunkSectionId = r1;
        this.chunkInfo = r2;
    }

    public /* synthetic */ ChunkedSectionData(String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
