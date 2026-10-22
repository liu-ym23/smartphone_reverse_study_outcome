package com.obric.aiagent.product.feature.bean;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\bHÆ\u0003JU\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/feature/bean/FeatureStateConfigItem;", XmlPullParser.NO_NAMESPACE, "state", XmlPullParser.NO_NAMESPACE, "stateList", XmlPullParser.NO_NAMESPACE, "productList", "productSpecialList", XmlPullParser.NO_NAMESPACE, "Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getState", "()Ljava/lang/String;", "getStateList", "()Ljava/util/List;", "getProductList", "getProductSpecialList", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", XmlPullParser.NO_NAMESPACE, "other", "hashCode", XmlPullParser.NO_NAMESPACE, "toString", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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
    public static /* synthetic */ FeatureStateConfigItem copy$default(FeatureStateConfigItem r0, String r1, List r2, List r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.stateList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.productList;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.productSpecialList;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final FeatureStateConfigItem copy(String r2, List<String> r3, List<String> r4, Map<String, ? extends Map<String, ProductSpecialConfig>> r5) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "stateList");
        Intrinsics.checkNotNullParameter(r4, "productList");
        Intrinsics.checkNotNullParameter(r5, "productSpecialList");
        return new FeatureStateConfigItem(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeatureStateConfigItem) == true) goto L8;
        return false;
    L8:
        FeatureStateConfigItem r6 = (FeatureStateConfigItem) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stateList, r6.stateList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productList, r6.productList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productSpecialList, r6.productSpecialList) == true) goto L20;
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
    public FeatureStateConfigItem(String r2, List<String> r3, List<String> r4, Map<String, ? extends Map<String, ProductSpecialConfig>> r5) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "stateList");
        Intrinsics.checkNotNullParameter(r4, "productList");
        Intrinsics.checkNotNullParameter(r5, "productSpecialList");
        this.state = r2;
        this.stateList = r3;
        this.productList = r4;
        this.productSpecialList = r5;
    }

    public /* synthetic */ FeatureStateConfigItem(String r1, List r2, List r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = XmlPullParser.NO_NAMESPACE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = CollectionsKt.emptyList();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = MapsKt.emptyMap();
    L14:
        this(r1, r2, r3, r4);
    }
}
