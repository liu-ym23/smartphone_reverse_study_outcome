package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiTradeGoodsLifeStruct;", "Ljava/io/Serializable;", "spuId", "", "anchorSuffix", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiTradeGoodsLifeAnchorSuffixStruct;", "minorTags", "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentStruct;", "minorExtendTime", "", "logExtra", "poiComboUrl", "(Ljava/lang/String;Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiTradeGoodsLifeAnchorSuffixStruct;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;)V", "getAnchorSuffix", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiTradeGoodsLifeAnchorSuffixStruct;", "getLogExtra", "()Ljava/lang/String;", "getMinorExtendTime", "()J", "getMinorTags", "()Ljava/util/List;", "getPoiComboUrl", "getSpuId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiTradeGoodsLifeStruct implements Serializable {

    @SerializedName("anchor_suffix")
    private final PoiTradeGoodsLifeAnchorSuffixStruct anchorSuffix;

    @SerializedName("log_extra")
    private final String logExtra;

    @SerializedName("minor_extend_time")
    private final long minorExtendTime;

    @SerializedName("minor_tags")
    private final List<PoiAnchorContentStruct> minorTags;

    @SerializedName("poi_combo_url")
    private final String poiComboUrl;

    @SerializedName("spu_id")
    private final String spuId;

    public PoiTradeGoodsLifeStruct() {
        this(null, null, null, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiTradeGoodsLifeStruct copy$default(PoiTradeGoodsLifeStruct r100, String r101, PoiTradeGoodsLifeAnchorSuffixStruct r102, List r103, long r104, String r110, String r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.spuId;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.anchorSuffix;
    L8:
        PoiTradeGoodsLifeAnchorSuffixStruct r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.minorTags;
    L11:
        List r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.minorExtendTime;
    L14:
        long r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.logExtra;
    L17:
        String r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.poiComboUrl;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.spuId;
    }

    public final PoiTradeGoodsLifeAnchorSuffixStruct component2() {
        return this.anchorSuffix;
    }

    public final List<PoiAnchorContentStruct> component3() {
        return this.minorTags;
    }

    public final long component4() {
        return this.minorExtendTime;
    }

    public final String component5() {
        return this.logExtra;
    }

    public final String component6() {
        return this.poiComboUrl;
    }

    public final PoiTradeGoodsLifeStruct copy(String r110, PoiTradeGoodsLifeAnchorSuffixStruct r111, List<PoiAnchorContentStruct> r112, long r113, String r114, String r115) {
        return new PoiTradeGoodsLifeStruct(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiTradeGoodsLifeStruct) == true) goto L8;
        return false;
    L8:
        PoiTradeGoodsLifeStruct r101 = (PoiTradeGoodsLifeStruct) r100;
        if (Intrinsics.areEqual(this.spuId, r101.spuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorSuffix, r101.anchorSuffix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.minorTags, r101.minorTags) == true) goto L18;
        return false;
    L18:
        if (this.minorExtendTime == r101.minorExtendTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.poiComboUrl, r101.poiComboUrl) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.spuId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiTradeGoodsLifeAnchorSuffixStruct r104 = this.anchorSuffix;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<PoiAnchorContentStruct> r107 = this.minorTags;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.minorExtendTime;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.logExtra;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.poiComboUrl;
        if (r115 == null) goto L23;
        r101 = r115.hashCode();
    L23:
        return r114 + r101;
    L17:
        r113 = r112.hashCode();
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
        return "PoiTradeGoodsLifeStruct(spuId=" + this.spuId + ", anchorSuffix=" + this.anchorSuffix + ", minorTags=" + this.minorTags + ", minorExtendTime=" + this.minorExtendTime + ", logExtra=" + this.logExtra + ", poiComboUrl=" + this.poiComboUrl + ')';
    }

    public final PoiTradeGoodsLifeAnchorSuffixStruct getAnchorSuffix() {
        return this.anchorSuffix;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final long getMinorExtendTime() {
        return this.minorExtendTime;
    }

    public final List<PoiAnchorContentStruct> getMinorTags() {
        return this.minorTags;
    }

    public final String getPoiComboUrl() {
        return this.poiComboUrl;
    }

    public final String getSpuId() {
        return this.spuId;
    }

    public PoiTradeGoodsLifeStruct(String r100, PoiTradeGoodsLifeAnchorSuffixStruct r101, List<PoiAnchorContentStruct> r102, long r103, String r104, String r105) {
        this.spuId = r100;
        this.anchorSuffix = r101;
        this.minorTags = r102;
        this.minorExtendTime = r103;
        this.logExtra = r104;
        this.poiComboUrl = r105;
    }

    public /* synthetic */ PoiTradeGoodsLifeStruct(String r100, PoiTradeGoodsLifeAnchorSuffixStruct r101, List r102, long r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        PoiTradeGoodsLifeAnchorSuffixStruct r103 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = CollectionsKt.emptyList();
    L13:
        List r104 = r102;
        if ((r113 & 8) == 0) goto L16;
        r110 = -1;
    L16:
        long r105 = r110;
        if ((r113 & 16) == 0) goto L19;
        String r106 = null;
    L21:
        if ((r113 & 32) == 0) goto L23;
        String r116 = null;
    L24:
        this(r115, r103, r104, r105, r106, r116);
        return;
    L23:
        r116 = r112;
        goto L24
    L19:
        r106 = r111;
        goto L21
    L9:
        r103 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
