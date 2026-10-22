package com.bytedance.locallife.biz.plugin;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/biz/plugin/d;", "", "", "enableCodeCacheWhenEnterPage", "Z", "getEnableCodeCacheWhenEnterPage", "()Z", "alwaysTryWhenEnterPage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "enableFetchFromCloudWhenOpt", "b", "enablePoiPreCodeCacheForGoodsdetail", "d", "enableGoodsdetailCodeCacheWhenPageCreated", "c", "enablePoiPreCodeCacheForGoodsdetailDynamic", "getEnablePoiPreCodeCacheForGoodsdetailDynamic", "enablePreCodeCacheForDynamicWhenPageCreated", "e", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("always_try_when_enter_page")
    private final boolean alwaysTryWhenEnterPage;

    @SerializedName("enable_code_cache_when_page_created")
    private final boolean enableCodeCacheWhenEnterPage;

    @SerializedName("enable_fetch_from_cloud")
    private final boolean enableFetchFromCloudWhenOpt;

    @SerializedName("enable_goodsdetail_code_cache_when_page_created")
    private final boolean enableGoodsdetailCodeCacheWhenPageCreated;

    @SerializedName("enable_poi_pre_code_cache_for_goodsdetail")
    private final boolean enablePoiPreCodeCacheForGoodsdetail;

    @SerializedName("enable_poi_pre_code_cache_for_goodsdetail_dynamic")
    private final boolean enablePoiPreCodeCacheForGoodsdetailDynamic;

    @SerializedName("enable_pre_code_cache_for_dynamic_when_page_created")
    private final boolean enablePreCodeCacheForDynamicWhenPageCreated;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.enableCodeCacheWhenEnterPage == r101.enableCodeCacheWhenEnterPage) goto L12;
        return false;
    L12:
        if (this.alwaysTryWhenEnterPage == r101.alwaysTryWhenEnterPage) goto L15;
        return false;
    L15:
        if (this.enableFetchFromCloudWhenOpt == r101.enableFetchFromCloudWhenOpt) goto L18;
        return false;
    L18:
        if (this.enablePoiPreCodeCacheForGoodsdetail == r101.enablePoiPreCodeCacheForGoodsdetail) goto L21;
        return false;
    L21:
        if (this.enableGoodsdetailCodeCacheWhenPageCreated == r101.enableGoodsdetailCodeCacheWhenPageCreated) goto L24;
        return false;
    L24:
        if (this.enablePoiPreCodeCacheForGoodsdetailDynamic == r101.enablePoiPreCodeCacheForGoodsdetailDynamic) goto L27;
        return false;
    L27:
        if (this.enablePreCodeCacheForDynamicWhenPageCreated == r101.enablePreCodeCacheForDynamicWhenPageCreated) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableCodeCacheWhenEnterPage == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.alwaysTryWhenEnterPage == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableFetchFromCloudWhenOpt == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enablePoiPreCodeCacheForGoodsdetail == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableGoodsdetailCodeCacheWhenPageCreated == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.enablePoiPreCodeCacheForGoodsdetailDynamic == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.enablePreCodeCacheForDynamicWhenPageCreated == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LifeLynxOptConfig(enableCodeCacheWhenEnterPage=" + this.enableCodeCacheWhenEnterPage + ", alwaysTryWhenEnterPage=" + this.alwaysTryWhenEnterPage + ", enableFetchFromCloudWhenOpt=" + this.enableFetchFromCloudWhenOpt + ", enablePoiPreCodeCacheForGoodsdetail=" + this.enablePoiPreCodeCacheForGoodsdetail + ", enableGoodsdetailCodeCacheWhenPageCreated=" + this.enableGoodsdetailCodeCacheWhenPageCreated + ", enablePoiPreCodeCacheForGoodsdetailDynamic=" + this.enablePoiPreCodeCacheForGoodsdetailDynamic + ", enablePreCodeCacheForDynamicWhenPageCreated=" + this.enablePreCodeCacheForDynamicWhenPageCreated + ')';
    }

    public final boolean a() {
        return this.alwaysTryWhenEnterPage;
    }

    public final boolean b() {
        return this.enableFetchFromCloudWhenOpt;
    }

    public final boolean c() {
        return this.enableGoodsdetailCodeCacheWhenPageCreated;
    }

    public final boolean d() {
        return this.enablePoiPreCodeCacheForGoodsdetail;
    }

    public final boolean e() {
        return this.enablePreCodeCacheForDynamicWhenPageCreated;
    }

    public d(int r100) {
        this.enableCodeCacheWhenEnterPage = false;
        this.alwaysTryWhenEnterPage = false;
        this.enableFetchFromCloudWhenOpt = false;
        this.enablePoiPreCodeCacheForGoodsdetail = false;
        this.enableGoodsdetailCodeCacheWhenPageCreated = false;
        this.enablePoiPreCodeCacheForGoodsdetailDynamic = false;
        this.enablePreCodeCacheForDynamicWhenPageCreated = false;
    }
}
