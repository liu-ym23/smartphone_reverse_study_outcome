package com.obric.aiagent.product.feature.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/product/feature/bean/FeatureConfigWrap;", "", "enabled", "", "defaultState", "", "defaultStateList", "", "featureStateConfigList", "Lcom/obric/aiagent/product/feature/bean/FeatureStateConfigItem;", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getEnabled", "()Z", "getDefaultState", "()Ljava/lang/String;", "getDefaultStateList", "()Ljava/util/List;", "getFeatureStateConfigList", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureConfigWrap {

    @SerializedName("default_state")
    private final String defaultState;

    @SerializedName("default_state_list")
    private final List<String> defaultStateList;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("feature_state_config_list")
    private final List<FeatureStateConfigItem> featureStateConfigList;

    public FeatureConfigWrap() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureConfigWrap copy$default(FeatureConfigWrap r100, boolean r101, String r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enabled;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.defaultState;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.defaultStateList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.featureStateConfigList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.defaultState;
    }

    public final List<String> component3() {
        return this.defaultStateList;
    }

    public final List<FeatureStateConfigItem> component4() {
        return this.featureStateConfigList;
    }

    public final FeatureConfigWrap copy(boolean r100, String r101, List<String> r102, List<FeatureStateConfigItem> r103) {
        Intrinsics.checkNotNullParameter(r101, "defaultState");
        Intrinsics.checkNotNullParameter(r102, "defaultStateList");
        Intrinsics.checkNotNullParameter(r103, "featureStateConfigList");
        return new FeatureConfigWrap(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureConfigWrap) == true) goto L8;
        return false;
    L8:
        FeatureConfigWrap r101 = (FeatureConfigWrap) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultState, r101.defaultState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultStateList, r101.defaultStateList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.featureStateConfigList, r101.featureStateConfigList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.enabled == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + this.defaultState.hashCode()) * 31) + this.defaultStateList.hashCode()) * 31) + this.featureStateConfigList.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "FeatureConfigWrap(enabled=" + this.enabled + ", defaultState=" + this.defaultState + ", defaultStateList=" + this.defaultStateList + ", featureStateConfigList=" + this.featureStateConfigList + ')';
    }

    public final String getDefaultState() {
        return this.defaultState;
    }

    public final List<String> getDefaultStateList() {
        return this.defaultStateList;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<FeatureStateConfigItem> getFeatureStateConfigList() {
        return this.featureStateConfigList;
    }

    public FeatureConfigWrap(boolean r100, String r101, List<String> r102, List<FeatureStateConfigItem> r103) {
        Intrinsics.checkNotNullParameter(r101, "defaultState");
        Intrinsics.checkNotNullParameter(r102, "defaultStateList");
        Intrinsics.checkNotNullParameter(r103, "featureStateConfigList");
        this.enabled = r100;
        this.defaultState = r101;
        this.defaultStateList = r102;
        this.featureStateConfigList = r103;
    }

    public /* synthetic */ FeatureConfigWrap(boolean r100, String r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        this(r100, r101, r102, r103);
    }
}
