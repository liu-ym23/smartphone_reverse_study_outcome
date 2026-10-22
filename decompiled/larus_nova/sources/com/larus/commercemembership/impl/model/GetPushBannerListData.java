package com.larus.commercemembership.impl.model;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/commercemembership/impl/model/GetPushBannerListData;", "", BaseHttpRequestInfo.KEY_HIT, "", "activityId", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getHit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActivityId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/commercemembership/impl/model/GetPushBannerListData;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPushBannerListData {

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName(BaseHttpRequestInfo.KEY_HIT)
    private final Boolean hit;

    /* JADX WARN: Multi-variable type inference failed */
    public GetPushBannerListData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GetPushBannerListData copy$default(GetPushBannerListData r100, Boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.hit;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.activityId;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.hit;
    }

    public final String component2() {
        return this.activityId;
    }

    public final GetPushBannerListData copy(Boolean r100, String r101) {
        return new GetPushBannerListData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetPushBannerListData) == true) goto L8;
        return false;
    L8:
        GetPushBannerListData r101 = (GetPushBannerListData) r100;
        if (Intrinsics.areEqual(this.hit, r101.hit) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.hit;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.activityId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetPushBannerListData(hit=" + this.hit + ", activityId=" + this.activityId + ')';
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final Boolean getHit() {
        return this.hit;
    }

    public GetPushBannerListData(Boolean r100, String r101) {
        this.hit = r100;
        this.activityId = r101;
    }

    public /* synthetic */ GetPushBannerListData(Boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
