package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiExtJsonStruct;", "Ljava/io/Serializable;", "poiItemExtStruct", "Lcom/bytedance/locallife/model/poi/resp/PoiItemExtStruct;", NsdHelper.serviceTypeKey, "", "productType", "productBizline", "distanceMeter", "(Lcom/bytedance/locallife/model/poi/resp/PoiItemExtStruct;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDistanceMeter", "()Ljava/lang/String;", "getPoiItemExtStruct", "()Lcom/bytedance/locallife/model/poi/resp/PoiItemExtStruct;", "getProductBizline", "getProductType", "getServiceType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiExtJsonStruct implements Serializable {

    @SerializedName("distance_meters_bury")
    private final String distanceMeter;

    @SerializedName("item_ext")
    private final PoiItemExtStruct poiItemExtStruct;

    @SerializedName("product_bizline_bury")
    private final String productBizline;

    @SerializedName("product_type_bury")
    private final String productType;

    @SerializedName("service_type_bury")
    private final String serviceType;

    public PoiExtJsonStruct() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PoiExtJsonStruct copy$default(PoiExtJsonStruct r100, PoiItemExtStruct r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.poiItemExtStruct;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.serviceType;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.productType;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.productBizline;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.distanceMeter;
    L17:
        PoiItemExtStruct r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final PoiItemExtStruct component1() {
        return this.poiItemExtStruct;
    }

    public final String component2() {
        return this.serviceType;
    }

    public final String component3() {
        return this.productType;
    }

    public final String component4() {
        return this.productBizline;
    }

    public final String component5() {
        return this.distanceMeter;
    }

    public final PoiExtJsonStruct copy(PoiItemExtStruct r100, String r101, String r110, String r111, String r112) {
        return new PoiExtJsonStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiExtJsonStruct) == true) goto L8;
        return false;
    L8:
        PoiExtJsonStruct r101 = (PoiExtJsonStruct) r100;
        if (Intrinsics.areEqual(this.poiItemExtStruct, r101.poiItemExtStruct) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serviceType, r101.serviceType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productType, r101.productType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productBizline, r101.productBizline) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.distanceMeter, r101.distanceMeter) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        PoiItemExtStruct r100 = this.poiItemExtStruct;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.serviceType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.productType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.productBizline;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.distanceMeter;
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

    public String toString() {
        return "PoiExtJsonStruct(poiItemExtStruct=" + this.poiItemExtStruct + ", serviceType=" + this.serviceType + ", productType=" + this.productType + ", productBizline=" + this.productBizline + ", distanceMeter=" + this.distanceMeter + ')';
    }

    public final String getDistanceMeter() {
        return this.distanceMeter;
    }

    public final PoiItemExtStruct getPoiItemExtStruct() {
        return this.poiItemExtStruct;
    }

    public final String getProductBizline() {
        return this.productBizline;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getServiceType() {
        return this.serviceType;
    }

    public PoiExtJsonStruct(PoiItemExtStruct r100, String r101, String r102, String r103, String r104) {
        this.poiItemExtStruct = r100;
        this.serviceType = r101;
        this.productType = r102;
        this.productBizline = r103;
        this.distanceMeter = r104;
    }

    public /* synthetic */ PoiExtJsonStruct(PoiItemExtStruct r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        PoiItemExtStruct r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
