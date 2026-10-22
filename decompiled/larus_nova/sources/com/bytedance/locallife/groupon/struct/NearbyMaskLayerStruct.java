package com.bytedance.locallife.groupon.struct;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyMaskLayerStruct;", "Ljava/io/Serializable;", "awemeId", "", "index", "", "showTime", "", "(Ljava/lang/String;IF)V", "getAwemeId", "()Ljava/lang/String;", "getIndex", "()I", "getShowTime", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyMaskLayerStruct implements Serializable {

    @SerializedName(SimilarProductParam.AWEME_ID)
    private final String awemeId;

    @SerializedName("index")
    private final int index;

    @SerializedName("show_time")
    private final float showTime;

    public NearbyMaskLayerStruct() {
        this(null, 0, 0.0f, 7, null);
    }

    public static /* synthetic */ NearbyMaskLayerStruct copy$default(NearbyMaskLayerStruct r100, String r101, int r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.awemeId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.index;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.showTime;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.awemeId;
    }

    public final int component2() {
        return this.index;
    }

    public final float component3() {
        return this.showTime;
    }

    public final NearbyMaskLayerStruct copy(String r100, int r101, float r102) {
        return new NearbyMaskLayerStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyMaskLayerStruct) == true) goto L8;
        return false;
    L8:
        NearbyMaskLayerStruct r101 = (NearbyMaskLayerStruct) r100;
        if (Intrinsics.areEqual(this.awemeId, r101.awemeId) == true) goto L12;
        return false;
    L12:
        if (this.index == r101.index) goto L15;
        return false;
    L15:
        if (Float.compare(this.showTime, r101.showTime) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.awemeId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.index) * 31) + Float.floatToIntBits(this.showTime);
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "NearbyMaskLayerStruct(awemeId=" + this.awemeId + ", index=" + this.index + ", showTime=" + this.showTime + ')';
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final int getIndex() {
        return this.index;
    }

    public final float getShowTime() {
        return this.showTime;
    }

    public NearbyMaskLayerStruct(String r100, int r101, float r102) {
        this.awemeId = r100;
        this.index = r101;
        this.showTime = r102;
    }

    public /* synthetic */ NearbyMaskLayerStruct(String r100, int r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = -1.0f;
    L11:
        this(r100, r101, r102);
    }
}
