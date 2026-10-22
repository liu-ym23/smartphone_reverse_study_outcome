package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/q;", "", "", "lowestPrice", "Ljava/lang/String;", "getLowestPrice", "()Ljava/lang/String;", "title", "getTitle", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class q {

    @SerializedName("lowest_price")
    private final String lowestPrice;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.lowestPrice, r101.lowestPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.lowestPrice.hashCode() * 31) + this.title.hashCode();
    }

    public final String toString() {
        return "PoiProductSimpleInfo(lowestPrice=" + this.lowestPrice + ", title=" + this.title + ')';
    }

    public q() {
        Intrinsics.checkNotNullParameter("", "lowestPrice");
        Intrinsics.checkNotNullParameter("", "title");
        this.lowestPrice = "";
        this.title = "";
    }
}
