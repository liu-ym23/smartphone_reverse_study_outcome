package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendReportRequestData;", "Lcom/bytedance/ee/util/io/NonProguard;", "contentSourceIds", "", "", "activityType", "", "<init>", "(Ljava/util/List;I)V", "getContentSourceIds", "()Ljava/util/List;", "getActivityType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendReportRequestData implements NonProguard {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE)
    private final int activityType;

    @SerializedName("content_source_ids")
    private final List<String> contentSourceIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BitableRecommendReportRequestData copy$default(BitableRecommendReportRequestData r100, List r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.contentSourceIds;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.activityType;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.contentSourceIds;
    }

    public final int component2() {
        return this.activityType;
    }

    public final BitableRecommendReportRequestData copy(List<String> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "contentSourceIds");
        return new BitableRecommendReportRequestData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableRecommendReportRequestData) == true) goto L8;
        return false;
    L8:
        BitableRecommendReportRequestData r101 = (BitableRecommendReportRequestData) r100;
        if (Intrinsics.areEqual(this.contentSourceIds, r101.contentSourceIds) == true) goto L12;
        return false;
    L12:
        if (this.activityType == r101.activityType) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.contentSourceIds.hashCode() * 31) + this.activityType;
    }

    public String toString() {
        return "BitableRecommendReportRequestData(contentSourceIds=" + this.contentSourceIds + ", activityType=" + this.activityType + ')';
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public final List<String> getContentSourceIds() {
        return this.contentSourceIds;
    }

    public BitableRecommendReportRequestData(List<String> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "contentSourceIds");
        this.contentSourceIds = r100;
        this.activityType = r101;
    }
}
