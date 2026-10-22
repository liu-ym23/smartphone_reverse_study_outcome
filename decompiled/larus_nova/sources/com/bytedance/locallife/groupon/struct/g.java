package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/g;", "", "", "nearbyAvoidGrouponSnackbar", "I", "getNearbyAvoidGrouponSnackbar", "()I", "setNearbyAvoidGrouponSnackbar", "(I)V", "", "Lcom/bytedance/locallife/groupon/struct/e;", "countConfigList", "Ljava/util/List;", "getCountConfigList", "()Ljava/util/List;", "Lcom/bytedance/locallife/groupon/struct/f;", "durationConfigList", "getDurationConfigList", "", "makeDealEvents", "getMakeDealEvents", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("count_config_list")
    private final List<e> countConfigList;

    @SerializedName("duration_config_list")
    private final List<f> durationConfigList;

    @SerializedName("make_deal_events")
    private final List<String> makeDealEvents;

    @SerializedName("nearby_avoid_grounon_snackbar")
    private int nearbyAvoidGrouponSnackbar;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.nearbyAvoidGrouponSnackbar == r101.nearbyAvoidGrouponSnackbar) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.countConfigList, r101.countConfigList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.durationConfigList, r101.durationConfigList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.makeDealEvents, r101.makeDealEvents) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.nearbyAvoidGrouponSnackbar * 31) + this.countConfigList.hashCode()) * 31) + this.durationConfigList.hashCode()) * 31) + this.makeDealEvents.hashCode();
    }

    public final String toString() {
        return "PinTopConfig(nearbyAvoidGrouponSnackbar=" + this.nearbyAvoidGrouponSnackbar + ", countConfigList=" + this.countConfigList + ", durationConfigList=" + this.durationConfigList + ", makeDealEvents=" + this.makeDealEvents + ')';
    }

    public g() {
        List<e> r100 = CollectionsKt.emptyList();
        List<f> r101 = CollectionsKt.emptyList();
        ArrayList r102 = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "countConfigList");
        Intrinsics.checkNotNullParameter(r101, "durationConfigList");
        Intrinsics.checkNotNullParameter(r102, "makeDealEvents");
        this.nearbyAvoidGrouponSnackbar = 0;
        this.countConfigList = r100;
        this.durationConfigList = r101;
        this.makeDealEvents = r102;
    }
}
