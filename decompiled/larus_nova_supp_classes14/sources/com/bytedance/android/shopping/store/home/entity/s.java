package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/s;", "", "Lcom/bytedance/android/shopping/store/home/entity/w;", "shopScoreInfo", "Lcom/bytedance/android/shopping/store/home/entity/w;", "b", "()Lcom/bytedance/android/shopping/store/home/entity/w;", "Lcom/bytedance/android/shopping/store/home/entity/a;", "awemeFlagshipShopStyle", "Lcom/bytedance/android/shopping/store/home/entity/a;", "getAwemeFlagshipShopStyle", "()Lcom/bytedance/android/shopping/store/home/entity/a;", "Lcom/bytedance/android/shopping/store/home/entity/u;", "searchBarConfig", "Lcom/bytedance/android/shopping/store/home/entity/u;", "a", "()Lcom/bytedance/android/shopping/store/home/entity/u;", "Lcom/bytedance/android/shopping/store/home/entity/x;", "shopSellingPointStyle", "Lcom/bytedance/android/shopping/store/home/entity/x;", "c", "()Lcom/bytedance/android/shopping/store/home/entity/x;", "Lcom/bytedance/android/shopping/store/home/entity/y;", "shopLiveViewersStyle", "Lcom/bytedance/android/shopping/store/home/entity/y;", "getShopLiveViewersStyle", "()Lcom/bytedance/android/shopping/store/home/entity/y;", "shopSellingPointLivingStyle", "getShopSellingPointLivingStyle", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("flag_ship_style")
    private final a awemeFlagshipShopStyle;

    @SerializedName("search_bar_style")
    private final u searchBarConfig;

    @SerializedName("shop_living_viewers_style")
    private final y shopLiveViewersStyle;

    @SerializedName("shop_score_style")
    private final w shopScoreInfo;

    @SerializedName("shop_selling_point_living_style")
    private final x shopSellingPointLivingStyle;

    @SerializedName("shop_selling_point_style")
    private final x shopSellingPointStyle;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L18;
        s r4 = (s) r3;
        if (Intrinsics.areEqual(this.shopScoreInfo, r4.shopScoreInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.awemeFlagshipShopStyle, r4.awemeFlagshipShopStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchBarConfig, r4.searchBarConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shopSellingPointStyle, r4.shopSellingPointStyle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopLiveViewersStyle, r4.shopLiveViewersStyle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopSellingPointLivingStyle, r4.shopSellingPointLivingStyle) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        w r0 = this.shopScoreInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        a r4 = this.awemeFlagshipShopStyle;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        u r7 = this.searchBarConfig;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        x r10 = this.shopSellingPointStyle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        y r13 = this.shopLiveViewersStyle;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        x r16 = this.shopSellingPointLivingStyle;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HeaderStyleConfig(shopScoreInfo=" + this.shopScoreInfo + ", awemeFlagshipShopStyle=" + this.awemeFlagshipShopStyle + ", searchBarConfig=" + this.searchBarConfig + ", shopSellingPointStyle=" + this.shopSellingPointStyle + ", shopLiveViewersStyle=" + this.shopLiveViewersStyle + ", shopSellingPointLivingStyle=" + this.shopSellingPointLivingStyle + ")";
    }

    public s() {
        this.shopScoreInfo = null;
        this.awemeFlagshipShopStyle = null;
        this.searchBarConfig = null;
        this.shopSellingPointStyle = null;
        this.shopLiveViewersStyle = null;
        this.shopSellingPointLivingStyle = null;
    }

    public final u a() {
        return this.searchBarConfig;
    }

    public final w b() {
        return this.shopScoreInfo;
    }

    public final x c() {
        return this.shopSellingPointStyle;
    }
}
