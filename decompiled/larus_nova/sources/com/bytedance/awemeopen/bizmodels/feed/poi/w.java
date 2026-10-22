package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/w;", "", "", "poiId", "Ljava/lang/String;", "poiName", "Lt14/a;", "cover", "Lt14/a;", "longitude", "latitude", "", "rating", "D", ChameleonOpenTracker.ParamKey.COST, "businessAreaName", "optionName", "poiRankDesc", "poiVoucher", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/d;", "poiAddress", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/d;", "", "rankScore", "J", "getRankScore", "()J", "setRankScore", "(J)V", "collectCount", "collectStatus", "", "voucherReleaseAreas", "Ljava/util/List;", "getVoucherReleaseAreas", "()Ljava/util/List;", "setVoucherReleaseAreas", "(Ljava/util/List;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/g;", "poiBackendType", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/g;", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/s;", "poiServiceFlags", "", "isAdminArea", "Z", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class w {

    @SerializedName("business_area_name")
    private String businessAreaName;

    @SerializedName("collect_count")
    private long collectCount;

    @SerializedName("collect_status")
    private long collectStatus;

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    private double cost;

    @SerializedName("cover")
    private t14.a cover;

    @SerializedName("is_admin_area")
    private boolean isAdminArea;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("option_name")
    private String optionName;

    @SerializedName("address_info")
    private d poiAddress;

    @SerializedName("poi_backend_type")
    private g poiBackendType;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("poi_rank_desc")
    private String poiRankDesc;

    @SerializedName("icon_service_type_list")
    private List<s> poiServiceFlags;

    @SerializedName("poi_voucher")
    private String poiVoucher;

    @SerializedName("rank_score")
    private long rankScore;

    @SerializedName("rating")
    private double rating;

    @SerializedName("voucher_release_areas")
    private List<String> voucherReleaseAreas;

    public w() {
    }

    public final int hashCode() {
        String r100 = this.poiId;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    L7:
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.poiId, ((w) r100).poiId);
    }
}
