package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/r;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/k0;", "displayInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/k0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/k0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/l;", "flashSale", "Lcom/bytedance/locallife/live/goodsshelves/bean/l;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/l;", "", "prePriceText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "priceSuffix", "d", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("display_info")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final k0 displayInfo;

    @SerializedName("flash_sale")
    private final l flashSale;

    @SerializedName("pre_price_text")
    private final String prePriceText;

    @SerializedName("price_suffix")
    private final String priceSuffix;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.displayInfo, r101.displayInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.flashSale, r101.flashSale) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.prePriceText, r101.prePriceText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.priceSuffix, r101.priceSuffix) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        k0 r100 = this.displayInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        l r104 = this.flashSale;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.prePriceText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.priceSuffix;
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

    public final String toString() {
        return "LiveLifeBFFCardMarketingInfo(displayInfo=" + this.displayInfo + ", flashSale=" + this.flashSale + ", prePriceText=" + this.prePriceText + ", priceSuffix=" + this.priceSuffix + ')';
    }

    public final k0 a() {
        return this.displayInfo;
    }

    public final l b() {
        return this.flashSale;
    }

    public final String c() {
        return this.prePriceText;
    }

    public final String d() {
        return this.priceSuffix;
    }
}
