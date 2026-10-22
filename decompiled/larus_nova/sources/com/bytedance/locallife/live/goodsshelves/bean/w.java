package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/w;", "", "", "totalReviewCount", "Ljava/lang/Long;", "getTotalReviewCount", "()Ljava/lang/Long;", "goodReviewCount", "getGoodReviewCount", "repurchaseCount", "getRepurchaseCount", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("good_review_count")
    private final Long goodReviewCount;

    @SerializedName("repurchase_count")
    private final Long repurchaseCount;

    @SerializedName("total_review_count")
    private final Long totalReviewCount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.totalReviewCount, r101.totalReviewCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.goodReviewCount, r101.goodReviewCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.repurchaseCount, r101.repurchaseCount) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.totalReviewCount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.goodReviewCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.repurchaseCount;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardProductData(totalReviewCount=" + this.totalReviewCount + ", goodReviewCount=" + this.goodReviewCount + ", repurchaseCount=" + this.repurchaseCount + ')';
    }
}
