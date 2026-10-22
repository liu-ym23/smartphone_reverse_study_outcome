package com.ss.android.ugc.aweme.trade.goods.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/PoiTripTradeSettingEntity;", "", "Lcom/ss/android/ugc/aweme/trade/goods/entity/TripGoodsDetailPreloadStrategy;", "tripGoodsDetailPreloadStrategy", "Lcom/ss/android/ugc/aweme/trade/goods/entity/TripGoodsDetailPreloadStrategy;", "d", "()Lcom/ss/android/ugc/aweme/trade/goods/entity/TripGoodsDetailPreloadStrategy;", "Lcom/ss/android/ugc/aweme/trade/goods/entity/PreCacheConfig;", "precache", "Lcom/ss/android/ugc/aweme/trade/goods/entity/PreCacheConfig;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/ss/android/ugc/aweme/trade/goods/entity/PreCacheConfig;", "", "", "presetSizeLynxCardAllowList", "Ljava/util/List;", "b", "()Ljava/util/List;", "presetSizeLynxCardBlackList", "c", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiTripTradeSettingEntity {

    @SerializedName("precache")
    private final PreCacheConfig precache;

    @SerializedName("preset_size_lynx_card_allow_list")
    private final List<String> presetSizeLynxCardAllowList;

    @SerializedName("preset_size_lynx_card_black_list")
    private final List<String> presetSizeLynxCardBlackList;

    @SerializedName("trip_lynx_preload")
    private final TripGoodsDetailPreloadStrategy tripGoodsDetailPreloadStrategy;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiTripTradeSettingEntity) == true) goto L8;
        return false;
    L8:
        PoiTripTradeSettingEntity r101 = (PoiTripTradeSettingEntity) r100;
        if (Intrinsics.areEqual(this.tripGoodsDetailPreloadStrategy, r101.tripGoodsDetailPreloadStrategy) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.precache, r101.precache) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.presetSizeLynxCardAllowList, r101.presetSizeLynxCardAllowList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.presetSizeLynxCardBlackList, r101.presetSizeLynxCardBlackList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        TripGoodsDetailPreloadStrategy r100 = this.tripGoodsDetailPreloadStrategy;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PreCacheConfig r104 = this.precache;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.presetSizeLynxCardAllowList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.presetSizeLynxCardBlackList;
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
        return "PoiTripTradeSettingEntity(tripGoodsDetailPreloadStrategy=" + this.tripGoodsDetailPreloadStrategy + ", precache=" + this.precache + ", presetSizeLynxCardAllowList=" + this.presetSizeLynxCardAllowList + ", presetSizeLynxCardBlackList=" + this.presetSizeLynxCardBlackList + ')';
    }

    public PoiTripTradeSettingEntity() {
        this.tripGoodsDetailPreloadStrategy = null;
        this.precache = null;
        this.presetSizeLynxCardAllowList = null;
        this.presetSizeLynxCardBlackList = null;
    }

    public final PreCacheConfig a() {
        return this.precache;
    }

    public final List<String> b() {
        return this.presetSizeLynxCardAllowList;
    }

    public final List<String> c() {
        return this.presetSizeLynxCardBlackList;
    }

    public final TripGoodsDetailPreloadStrategy d() {
        return this.tripGoodsDetailPreloadStrategy;
    }
}
