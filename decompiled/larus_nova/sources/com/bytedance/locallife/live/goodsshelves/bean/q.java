package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/q;", "", "", "hasLottery", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", DyPayConstant.KEY_START_TIME, "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "drawTime", "b", "", "candidateStatus", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "taskPageSchema", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "hintText", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "d", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "", "trackingParams", "Ljava/util/Map;", "getTrackingParams", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("candidate_status")
    private final Integer candidateStatus;

    @SerializedName("draw_time")
    private final Long drawTime;

    @SerializedName("has_lottery")
    private final Boolean hasLottery;

    @SerializedName("hint_text")
    private final x hintText;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    @SerializedName("task_page_schema")
    private final String taskPageSchema;

    @SerializedName("tracking_params")
    private final Map<String, String> trackingParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.hasLottery, r101.hasLottery) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.drawTime, r101.drawTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.candidateStatus, r101.candidateStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskPageSchema, r101.taskPageSchema) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hintText, r101.hintText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.hasLottery;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.startTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.drawTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.candidateStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.taskPageSchema;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        x r116 = this.hintText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.trackingParams;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "LiveLifeBFFCardLotteryInfo(hasLottery=" + this.hasLottery + ", startTime=" + this.startTime + ", drawTime=" + this.drawTime + ", candidateStatus=" + this.candidateStatus + ", taskPageSchema=" + this.taskPageSchema + ", hintText=" + this.hintText + ", trackingParams=" + this.trackingParams + ')';
    }

    public final Integer a() {
        return this.candidateStatus;
    }

    public final Long b() {
        return this.drawTime;
    }

    public final Boolean c() {
        return this.hasLottery;
    }

    public final x d() {
        return this.hintText;
    }

    public final String e() {
        return this.taskPageSchema;
    }
}
