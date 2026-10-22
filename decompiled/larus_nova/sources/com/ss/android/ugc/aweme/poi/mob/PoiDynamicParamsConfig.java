package com.ss.android.ugc.aweme.poi.mob;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/PoiDynamicParamsConfig;", "", "", "disableDynamicParams", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setDisableDynamicParams", "(Z)V", "", "", "dynamicParamsNodeTags", "Ljava/util/List;", "b", "()Ljava/util/List;", "setDynamicParamsNodeTags", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/aweme/poi/mob/SingleParamsConfig;", "paramsConfigList", "c", "setParamsConfigList", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDynamicParamsConfig {

    @SerializedName("disable_dynamic_params")
    private boolean disableDynamicParams;

    @SerializedName("dynamic_params_node_tags")
    private List<String> dynamicParamsNodeTags;

    @SerializedName("params_config")
    private List<SingleParamsConfig> paramsConfigList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDynamicParamsConfig) == true) goto L8;
        return false;
    L8:
        PoiDynamicParamsConfig r101 = (PoiDynamicParamsConfig) r100;
        if (this.disableDynamicParams == r101.disableDynamicParams) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicParamsNodeTags, r101.dynamicParamsNodeTags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.paramsConfigList, r101.paramsConfigList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.disableDynamicParams == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<String> r102 = this.dynamicParamsNodeTags;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<SingleParamsConfig> r106 = this.paramsConfigList;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "PoiDynamicParamsConfig(disableDynamicParams=" + this.disableDynamicParams + ", dynamicParamsNodeTags=" + this.dynamicParamsNodeTags + ", paramsConfigList=" + this.paramsConfigList + ')';
    }

    public PoiDynamicParamsConfig() {
        this.disableDynamicParams = false;
        this.dynamicParamsNodeTags = null;
        this.paramsConfigList = null;
    }

    public final boolean a() {
        return this.disableDynamicParams;
    }

    public final List<String> b() {
        return this.dynamicParamsNodeTags;
    }

    public final List<SingleParamsConfig> c() {
        return this.paramsConfigList;
    }
}
