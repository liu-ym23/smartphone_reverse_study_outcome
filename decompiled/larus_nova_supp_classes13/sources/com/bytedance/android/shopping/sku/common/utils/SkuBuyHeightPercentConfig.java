package com.bytedance.android.shopping.sku.common.utils;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/utils/SkuBuyHeightPercentConfig;", "Ljava/io/Serializable;", "subHeightPercent", "", "urlWhiteList", "", "", "(ILjava/util/List;)V", "getSubHeightPercent", "()I", "setSubHeightPercent", "(I)V", "getUrlWhiteList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBuyHeightPercentConfig implements Serializable {

    @SerializedName("sub_height_percent")
    private int subHeightPercent;

    @SerializedName("url_white_list")
    private final List<String> urlWhiteList;

    public SkuBuyHeightPercentConfig() {
        List r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuBuyHeightPercentConfig copy$default(SkuBuyHeightPercentConfig r0, int r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.subHeightPercent;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.urlWhiteList;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.subHeightPercent;
    }

    public final List<String> component2() {
        return this.urlWhiteList;
    }

    public final SkuBuyHeightPercentConfig copy(int r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "urlWhiteList");
        return new SkuBuyHeightPercentConfig(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SkuBuyHeightPercentConfig) == false) goto L10;
        SkuBuyHeightPercentConfig r4 = (SkuBuyHeightPercentConfig) r3;
        if (this.subHeightPercent == r4.subHeightPercent) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlWhiteList, r4.urlWhiteList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = this.subHeightPercent * 31;
        List<String> r1 = this.urlWhiteList;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "SkuBuyHeightPercentConfig(subHeightPercent=" + this.subHeightPercent + ", urlWhiteList=" + this.urlWhiteList + ")";
    }

    public final int getSubHeightPercent() {
        return this.subHeightPercent;
    }

    public final List<String> getUrlWhiteList() {
        return this.urlWhiteList;
    }

    public final void setSubHeightPercent(int r1) {
        this.subHeightPercent = r1;
    }

    public SkuBuyHeightPercentConfig(int r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "urlWhiteList");
        this.subHeightPercent = r2;
        this.urlWhiteList = r3;
    }

    public /* synthetic */ SkuBuyHeightPercentConfig(int r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 73;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
