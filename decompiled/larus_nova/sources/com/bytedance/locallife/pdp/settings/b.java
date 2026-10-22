package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R0\u0010\u0017\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0016\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/b;", "", "", "renderCacheValidTime", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "", "", "renderCacheRouterKeys", "Ljava/util/List;", "e", "()Ljava/util/List;", "renderCacheComponentsArr", "d", "", "cacheRenderDoor", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "preRequestDoor", "c", "", "cacheBlockRulesList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("cache_block_rules_list")
    private final List<Map<String, String>> cacheBlockRulesList;

    @SerializedName("render_cache_door")
    private final Boolean cacheRenderDoor;

    @SerializedName("render_pre_request_door")
    private final Boolean preRequestDoor;

    @SerializedName("render_cache_components_arr")
    private final List<String> renderCacheComponentsArr;

    @SerializedName("render_cache_router_keys")
    private final List<String> renderCacheRouterKeys;

    @SerializedName("render_cache_valid_time")
    private final Integer renderCacheValidTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.renderCacheValidTime, r101.renderCacheValidTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.renderCacheRouterKeys, r101.renderCacheRouterKeys) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.renderCacheComponentsArr, r101.renderCacheComponentsArr) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cacheRenderDoor, r101.cacheRenderDoor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preRequestDoor, r101.preRequestDoor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cacheBlockRulesList, r101.cacheBlockRulesList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.renderCacheValidTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.renderCacheRouterKeys;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.renderCacheComponentsArr;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.cacheRenderDoor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.preRequestDoor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<Map<String, String>> r116 = this.cacheBlockRulesList;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "CacheStrategyConfig(renderCacheValidTime=" + this.renderCacheValidTime + ", renderCacheRouterKeys=" + this.renderCacheRouterKeys + ", renderCacheComponentsArr=" + this.renderCacheComponentsArr + ", cacheRenderDoor=" + this.cacheRenderDoor + ", preRequestDoor=" + this.preRequestDoor + ", cacheBlockRulesList=" + this.cacheBlockRulesList + ')';
    }

    public b() {
        Boolean r100 = Boolean.TRUE;
        this.renderCacheValidTime = 300;
        this.renderCacheRouterKeys = null;
        this.renderCacheComponentsArr = null;
        this.cacheRenderDoor = r100;
        this.preRequestDoor = r100;
        this.cacheBlockRulesList = null;
    }

    public final List<Map<String, String>> a() {
        return this.cacheBlockRulesList;
    }

    public final Boolean b() {
        return this.cacheRenderDoor;
    }

    public final Boolean c() {
        return this.preRequestDoor;
    }

    public final List<String> d() {
        return this.renderCacheComponentsArr;
    }

    public final List<String> e() {
        return this.renderCacheRouterKeys;
    }

    public final Integer f() {
        return this.renderCacheValidTime;
    }
}
