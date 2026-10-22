package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003JY\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/Tab;", "Ljava/io/Serializable;", "elementIndexId", "", "", "productList", "id", "", "trackingParams", "", "realProductCount", "(Ljava/util/List;Ljava/util/List;ILjava/util/Map;I)V", "getElementIndexId", "()Ljava/util/List;", "getId", "()I", "getProductList", "getRealProductCount", "getTrackingParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Tab implements Serializable {

    @SerializedName("element_index_id")
    private final List<String> elementIndexId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f259585id;

    @SerializedName("product_list")
    private final List<String> productList;

    @SerializedName("real_product_count")
    private final int realProductCount;

    @SerializedName("tracking_params")
    private final Map<String, String> trackingParams;

    public Tab() {
        this(null, null, 0, null, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tab copy$default(Tab r100, List r101, List r102, int r103, Map r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.elementIndexId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.productList;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.f259585id;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.trackingParams;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.realProductCount;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<String> component1() {
        return this.elementIndexId;
    }

    public final List<String> component2() {
        return this.productList;
    }

    public final int component3() {
        return this.f259585id;
    }

    public final Map<String, String> component4() {
        return this.trackingParams;
    }

    public final int component5() {
        return this.realProductCount;
    }

    public final Tab copy(List<String> r100, List<String> r101, int r110, Map<String, String> r111, int r112) {
        return new Tab(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tab) == true) goto L8;
        return false;
    L8:
        Tab r101 = (Tab) r100;
        if (Intrinsics.areEqual(this.elementIndexId, r101.elementIndexId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productList, r101.productList) == true) goto L15;
        return false;
    L15:
        if (this.f259585id == r101.f259585id) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L21;
        return false;
    L21:
        if (this.realProductCount == r101.realProductCount) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.elementIndexId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.productList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f259585id) * 31;
        Map<String, String> r107 = this.trackingParams;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.realProductCount;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Tab(elementIndexId=" + this.elementIndexId + ", productList=" + this.productList + ", id=" + this.f259585id + ", trackingParams=" + this.trackingParams + ", realProductCount=" + this.realProductCount + ')';
    }

    public final List<String> getElementIndexId() {
        return this.elementIndexId;
    }

    public final int getId() {
        return this.f259585id;
    }

    public final List<String> getProductList() {
        return this.productList;
    }

    public final int getRealProductCount() {
        return this.realProductCount;
    }

    public final Map<String, String> getTrackingParams() {
        return this.trackingParams;
    }

    public Tab(List<String> r100, List<String> r101, int r102, Map<String, String> r103, int r104) {
        this.elementIndexId = r100;
        this.productList = r101;
        this.f259585id = r102;
        this.trackingParams = r103;
        this.realProductCount = r104;
    }

    public /* synthetic */ Tab(List r100, List r101, int r102, Map r103, int r104, int r105, DefaultConstructorMarker r110) {
        Map r106 = null;
        if ((r105 & 1) == 0) goto L5;
        List r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        List r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        int r108 = 1;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 1;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
