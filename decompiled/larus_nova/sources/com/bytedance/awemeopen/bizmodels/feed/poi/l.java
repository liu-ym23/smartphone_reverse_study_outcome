package com.bytedance.awemeopen.bizmodels.feed.poi;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000f¨\u00063"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/l;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "poiStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "getPoiStruct", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "setPoiStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;)V", "", "bizType", "Ljava/lang/Integer;", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "spuPlatformSources", "getSpuPlatformSources", "setSpuPlatformSources", "serviceRadius", "getServiceRadius", "setServiceRadius", "serviceDesc", "getServiceDesc", "setServiceDesc", "serviceSuffixTag", "getServiceSuffixTag", "setServiceSuffixTag", "", "distance", "D", "getDistance", "()D", "setDistance", "(D)V", "", "isInServiceRadius", "Z", "()Z", "setInServiceRadius", "(Z)V", "productType", "getProductType", "setProductType", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class l {

    @SerializedName("biz_type")
    private Integer bizType;

    @SerializedName("distance")
    private double distance;

    @SerializedName("is_in_service_radius")
    private boolean isInServiceRadius;

    @SerializedName("poi_info")
    private t poiStruct;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("product_type")
    private Integer productType;

    @SerializedName("indirect_poi_service_desc")
    private String serviceDesc;

    @SerializedName("indirect_poi_service_radius")
    private String serviceRadius;

    @SerializedName("indirect_poi_service_suffix_tag")
    private String serviceSuffixTag;

    @SerializedName("spu_platform_source")
    private Integer spuPlatformSources;

    public l() {
        this.poiStruct = null;
        this.bizType = 0;
        this.productId = null;
        this.spuPlatformSources = 0;
        this.serviceRadius = null;
        this.serviceDesc = null;
        this.serviceSuffixTag = null;
        this.distance = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.isInServiceRadius = false;
        this.productType = 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.poiStruct, r101.poiStruct) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.spuPlatformSources, r101.spuPlatformSources) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.serviceRadius, r101.serviceRadius) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.serviceDesc, r101.serviceDesc) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.serviceSuffixTag, r101.serviceSuffixTag) == true) goto L30;
        return false;
    L30:
        if (Double.compare(this.distance, r101.distance) == 0) goto L33;
        return false;
    L33:
        if (this.isInServiceRadius == r101.isInServiceRadius) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.productType, r101.productType) == true) goto L38;
        return false;
    L38:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v31 */
    public final int hashCode() {
        t r100 = this.poiStruct;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bizType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.productId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.spuPlatformSources;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.serviceRadius;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.serviceDesc;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.serviceSuffixTag;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        long r122 = Double.doubleToLongBits(this.distance);
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        boolean r124 = this.isInServiceRadius;
        ?? r125 = r124;
        if (r124 == false) goto L33;
        r125 = 1;
    L33:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.productType;
        if (r127 == null) goto L38;
        r101 = r127.hashCode();
    L38:
        return r126 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "PoiGrouponIndirectPoiInfo(poiStruct=" + this.poiStruct + ", bizType=" + this.bizType + ", productId=" + this.productId + ", spuPlatformSources=" + this.spuPlatformSources + ", serviceRadius=" + this.serviceRadius + ", serviceDesc=" + this.serviceDesc + ", serviceSuffixTag=" + this.serviceSuffixTag + ", distance=" + this.distance + ", isInServiceRadius=" + this.isInServiceRadius + ", productType=" + this.productType + ')';
    }
}
