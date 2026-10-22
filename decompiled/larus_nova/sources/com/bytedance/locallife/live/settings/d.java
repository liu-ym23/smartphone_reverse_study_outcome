package com.bytedance.locallife.live.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/live/settings/d;", "", "", "", "factorNameList", "Ljava/util/List;", "getFactorNameList", "()Ljava/util/List;", "", "virgoEnable", "I", "getVirgoEnable", "()I", "", "lifePoiPreloadCharacters", "Ljava/util/Map;", "getLifePoiPreloadCharacters", "()Ljava/util/Map;", "strategyApiConfig", "getStrategyApiConfig", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("factor_key_list")
    private final List<String> factorNameList;

    @SerializedName("life_poi_preload_characters_android")
    private final Map<String, Object> lifePoiPreloadCharacters;

    @SerializedName("strategy_api_config")
    private final Map<String, String> strategyApiConfig;

    @SerializedName("virgo_enable")
    private final int virgoEnable;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.factorNameList, r101.factorNameList) == true) goto L12;
        return false;
    L12:
        if (this.virgoEnable == r101.virgoEnable) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lifePoiPreloadCharacters, r101.lifePoiPreloadCharacters) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.strategyApiConfig, r101.strategyApiConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.factorNameList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.virgoEnable) * 31;
        Map<String, Object> r104 = this.lifePoiPreloadCharacters;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.strategyApiConfig;
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
        return "LiveLocalLifeStrategySettingsEntity(factorNameList=" + this.factorNameList + ", virgoEnable=" + this.virgoEnable + ", lifePoiPreloadCharacters=" + this.lifePoiPreloadCharacters + ", strategyApiConfig=" + this.strategyApiConfig + ')';
    }

    public d() {
        this.factorNameList = null;
        this.virgoEnable = 1;
        this.lifePoiPreloadCharacters = null;
        this.strategyApiConfig = null;
    }
}
