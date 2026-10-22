package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemCoverInfoData;", "Lcom/bytedance/ee/util/io/NonProguard;", "width", "", "height", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemCoverInfoData;", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendItemCoverInfoData implements NonProguard {

    @SerializedName("height")
    private final Double height;

    @SerializedName("width")
    private final Double width;

    public static /* synthetic */ BitableRecommendItemCoverInfoData copy$default(BitableRecommendItemCoverInfoData r100, Double r101, Double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        return r100.copy(r101, r102);
    }

    public final Double component1() {
        return this.width;
    }

    public final Double component2() {
        return this.height;
    }

    public final BitableRecommendItemCoverInfoData copy(Double r100, Double r101) {
        return new BitableRecommendItemCoverInfoData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableRecommendItemCoverInfoData) == true) goto L8;
        return false;
    L8:
        BitableRecommendItemCoverInfoData r101 = (BitableRecommendItemCoverInfoData) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Double r100 = this.width;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.height;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BitableRecommendItemCoverInfoData(width=" + this.width + ", height=" + this.height + ')';
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getWidth() {
        return this.width;
    }

    public BitableRecommendItemCoverInfoData(Double r100, Double r101) {
        this.width = r100;
        this.height = r101;
    }
}
