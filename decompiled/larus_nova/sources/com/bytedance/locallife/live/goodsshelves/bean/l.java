package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006¨\u0006&"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/l;", "", "", "initInventory", "Ljava/lang/Long;", "getInitInventory", "()Ljava/lang/Long;", "leftInventory", "c", "", DyPayConstant.KEY_START_TIME, "Ljava/lang/String;", "f", "()Ljava/lang/String;", "endTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "quantityPercentage", "Ljava/lang/Float;", "e", "()Ljava/lang/Float;", "", "needWarmUp", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "warmUpSeconds", ce.f26391f, "warmUpPrice", "getWarmUpPrice", "hasShopCart", "getHasShopCart", "flashSalePrice", "b", "flashSaleId", "getFlashSaleId", "bestPrice", "getBestPrice", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("best_price")
    private final Long bestPrice;

    @SerializedName("end_time")
    private final String endTime;

    @SerializedName("flash_sale_id")
    private final String flashSaleId;

    @SerializedName("flash_sale_price")
    private final Long flashSalePrice;

    @SerializedName("has_shop_cart")
    private final Boolean hasShopCart;

    @SerializedName("init_inventory")
    private final Long initInventory;

    @SerializedName("left_inventory")
    private final Long leftInventory;

    @SerializedName("need_warm_up")
    private final Boolean needWarmUp;

    @SerializedName("quantity_percentage")
    private final Float quantityPercentage;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final String startTime;

    @SerializedName("warm_up_price")
    private final Long warmUpPrice;

    @SerializedName("warm_up_seconds")
    private final Long warmUpSeconds;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.initInventory, r101.initInventory) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftInventory, r101.leftInventory) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.quantityPercentage, r101.quantityPercentage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.needWarmUp, r101.needWarmUp) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.warmUpSeconds, r101.warmUpSeconds) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.warmUpPrice, r101.warmUpPrice) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.hasShopCart, r101.hasShopCart) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.flashSalePrice, r101.flashSalePrice) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.flashSaleId, r101.flashSaleId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.bestPrice, r101.bestPrice) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.initInventory;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.leftInventory;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.startTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.endTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.quantityPercentage;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.needWarmUp;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.warmUpSeconds;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.warmUpPrice;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.hasShopCart;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.flashSalePrice;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.flashSaleId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.bestPrice;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "LiveLifeBFFCardFlashSaleInfo(initInventory=" + this.initInventory + ", leftInventory=" + this.leftInventory + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", quantityPercentage=" + this.quantityPercentage + ", needWarmUp=" + this.needWarmUp + ", warmUpSeconds=" + this.warmUpSeconds + ", warmUpPrice=" + this.warmUpPrice + ", hasShopCart=" + this.hasShopCart + ", flashSalePrice=" + this.flashSalePrice + ", flashSaleId=" + this.flashSaleId + ", bestPrice=" + this.bestPrice + ')';
    }

    public final String a() {
        return this.endTime;
    }

    public final Long b() {
        return this.flashSalePrice;
    }

    public final Long c() {
        return this.leftInventory;
    }

    public final Boolean d() {
        return this.needWarmUp;
    }

    public final Float e() {
        return this.quantityPercentage;
    }

    public final String f() {
        return this.startTime;
    }

    public final Long g() {
        return this.warmUpSeconds;
    }
}
