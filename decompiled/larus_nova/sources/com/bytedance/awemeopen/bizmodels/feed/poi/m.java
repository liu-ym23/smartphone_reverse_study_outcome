package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/m;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/e;", "anchorGuideStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/e;", "getAnchorGuideStruct", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/e;", "setAnchorGuideStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/e;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/f;", "anchorSuffixStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/f;", "getAnchorSuffixStruct", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/f;", "setAnchorSuffixStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/f;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorInfo;", "poiItemAnchorInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorInfo;", "setPoiItemAnchorInfo", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorInfo;)V", "", "detailExploreUrl", "Ljava/lang/String;", "getDetailExploreUrl", "()Ljava/lang/String;", "setDetailExploreUrl", "(Ljava/lang/String;)V", "subType", "getSubType", "setSubType", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class m {

    @SerializedName("anchor_guide")
    private e anchorGuideStruct;

    @SerializedName("anchor_suffix")
    private f anchorSuffixStruct;

    @SerializedName("poi_detail_explore_url")
    private String detailExploreUrl;

    @SerializedName("anchor_info")
    private PoiItemAnchorInfo poiItemAnchorInfo;

    @SerializedName("sub_type")
    private String subType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.anchorGuideStruct, r101.anchorGuideStruct) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorSuffixStruct, r101.anchorSuffixStruct) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.poiItemAnchorInfo, r101.poiItemAnchorInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detailExploreUrl, r101.detailExploreUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        e r100 = this.anchorGuideStruct;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.anchorSuffixStruct;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PoiItemAnchorInfo r107 = this.poiItemAnchorInfo;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((((r106 + r101) * 31) + this.detailExploreUrl.hashCode()) * 31) + this.subType.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiItemExtStruct(anchorGuideStruct=" + this.anchorGuideStruct + ", anchorSuffixStruct=" + this.anchorSuffixStruct + ", poiItemAnchorInfo=" + this.poiItemAnchorInfo + ", detailExploreUrl=" + this.detailExploreUrl + ", subType=" + this.subType + ')';
    }

    public m() {
        Intrinsics.checkNotNullParameter("", "detailExploreUrl");
        Intrinsics.checkNotNullParameter("", "subType");
        this.anchorGuideStruct = null;
        this.anchorSuffixStruct = null;
        this.poiItemAnchorInfo = null;
        this.detailExploreUrl = "";
        this.subType = "";
    }

    public final PoiItemAnchorInfo a() {
        return this.poiItemAnchorInfo;
    }
}
