package com.obric.aiagent.product.feature.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\bHÆ\u0003JU\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/feature/bean/FeatureStateConfigItem;", "", "state", "", "stateList", "", "productList", "productSpecialList", "", "Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getState", "()Ljava/lang/String;", "getStateList", "()Ljava/util/List;", "getProductList", "getProductSpecialList", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureStateConfigItem {

    @SerializedName("product_list")
    private final List<String> productList;

    @SerializedName("product_special_list")
    private final Map<String, Map<String, ProductSpecialConfig>> productSpecialList;

    @SerializedName("state")
    private final String state;

    @SerializedName("state_list")
    private final List<String> stateList;

    public FeatureStateConfigItem() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureStateConfigItem copy$default(FeatureStateConfigItem r100, String r101, List r102, List r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.stateList;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.productList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.productSpecialList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.state;
    }

    public final List<String> component2() {
        return this.stateList;
    }

    public final List<String> component3() {
        return this.productList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> component4() {
        return this.productSpecialList;
    }

    public final FeatureStateConfigItem copy(String r100, List<String> r101, List<String> r102, Map<String, ? extends Map<String, ProductSpecialConfig>> r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "stateList");
        Intrinsics.checkNotNullParameter(r102, "productList");
        Intrinsics.checkNotNullParameter(r103, "productSpecialList");
        return new FeatureStateConfigItem(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureStateConfigItem) == true) goto L8;
        return false;
    L8:
        FeatureStateConfigItem r101 = (FeatureStateConfigItem) r100;
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stateList, r101.stateList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productList, r101.productList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productSpecialList, r101.productSpecialList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + this.stateList.hashCode()) * 31) + this.productList.hashCode()) * 31) + this.productSpecialList.hashCode();
    }

    public String toString() {
        return "FeatureStateConfigItem(state=" + this.state + ", stateList=" + this.stateList + ", productList=" + this.productList + ", productSpecialList=" + this.productSpecialList + ')';
    }

    public final List<String> getProductList() {
        return this.productList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> getProductSpecialList() {
        return this.productSpecialList;
    }

    public final String getState() {
        return this.state;
    }

    public final List<String> getStateList() {
        return this.stateList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureStateConfigItem(String r100, List<String> r101, List<String> r102, Map<String, ? extends Map<String, ProductSpecialConfig>> r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "stateList");
        Intrinsics.checkNotNullParameter(r102, "productList");
        Intrinsics.checkNotNullParameter(r103, "productSpecialList");
        this.state = r100;
        this.stateList = r101;
        this.productList = r102;
        this.productSpecialList = r103;
    }

    public /* synthetic */ FeatureStateConfigItem(String r100, List r101, List r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = MapsKt.emptyMap();
    L14:
        this(r100, r101, r102, r103);
    }
}
