package com.ss.android.ugc.aweme.trade.goods.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R$\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR0\u0010\u0012\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/PreCacheConfig;", "", "", "scene", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "", "", "routerKeys", "Ljava/util/List;", "c", "()Ljava/util/List;", "validTime", "e", "allowList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "cacheBlockRulesList", "b", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PreCacheConfig {

    @SerializedName("allow_components")
    private final List<String> allowList;

    @SerializedName("block_rules_list")
    private final List<Map<String, String>> cacheBlockRulesList;

    @SerializedName("router_keys")
    private final List<String> routerKeys;

    @SerializedName("scene")
    private final Integer scene;

    @SerializedName("valid_time")
    private final Integer validTime;

    public PreCacheConfig() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreCacheConfig) == true) goto L8;
        return false;
    L8:
        PreCacheConfig r101 = (PreCacheConfig) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.routerKeys, r101.routerKeys) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.validTime, r101.validTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.allowList, r101.allowList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cacheBlockRulesList, r101.cacheBlockRulesList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.routerKeys;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.validTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.allowList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<Map<String, String>> r113 = this.cacheBlockRulesList;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "PreCacheConfig(scene=" + this.scene + ", routerKeys=" + this.routerKeys + ", validTime=" + this.validTime + ", allowList=" + this.allowList + ", cacheBlockRulesList=" + this.cacheBlockRulesList + ')';
    }

    public final List<String> a() {
        return this.allowList;
    }

    public final List<Map<String, String>> b() {
        return this.cacheBlockRulesList;
    }

    public final List<String> c() {
        return this.routerKeys;
    }

    public final Integer d() {
        return this.scene;
    }

    public final Integer e() {
        return this.validTime;
    }

    public PreCacheConfig(Integer r100, List r101) {
        this.scene = r100;
        this.routerKeys = null;
        this.validTime = null;
        this.allowList = r101;
        this.cacheBlockRulesList = null;
    }
}
