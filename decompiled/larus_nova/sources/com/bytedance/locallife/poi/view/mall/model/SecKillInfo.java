package com.bytedance.locallife.poi.view.mall.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011Jb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011¨\u0006*"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/SecKillInfo;", "Ljava/io/Serializable;", "activityId", "", "endTime", "", DyPayConstant.KEY_START_TIME, "endTimeCountDown", "status", "", "needWarmUp", "", "warmUpCountDown", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getActivityId", "()Ljava/lang/String;", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTimeCountDown", "getNeedWarmUp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStartTime", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWarmUpCountDown", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/bytedance/locallife/poi/view/mall/model/SecKillInfo;", "equals", "other", "", "hashCode", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SecKillInfo implements Serializable {

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("end_time_count_down")
    private final Long endTimeCountDown;

    @SerializedName("need_warm_up")
    private final Boolean needWarmUp;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("warm_up_count_down")
    private final Long warmUpCountDown;

    public SecKillInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ SecKillInfo copy$default(SecKillInfo r100, String r101, Long r102, Long r103, Long r104, Integer r110, Boolean r111, Long r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.activityId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.endTime;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.startTime;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.endTimeCountDown;
    L14:
        Long r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.status;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.needWarmUp;
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.warmUpCountDown;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.activityId;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final Long component3() {
        return this.startTime;
    }

    public final Long component4() {
        return this.endTimeCountDown;
    }

    public final Integer component5() {
        return this.status;
    }

    public final Boolean component6() {
        return this.needWarmUp;
    }

    public final Long component7() {
        return this.warmUpCountDown;
    }

    public final SecKillInfo copy(String r110, Long r111, Long r112, Long r113, Integer r114, Boolean r115, Long r116) {
        return new SecKillInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecKillInfo) == true) goto L8;
        return false;
    L8:
        SecKillInfo r101 = (SecKillInfo) r100;
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endTimeCountDown, r101.endTimeCountDown) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.needWarmUp, r101.needWarmUp) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.warmUpCountDown, r101.warmUpCountDown) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.activityId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.endTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.startTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.endTimeCountDown;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.status;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.needWarmUp;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.warmUpCountDown;
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

    public String toString() {
        return "SecKillInfo(activityId=" + this.activityId + ", endTime=" + this.endTime + ", startTime=" + this.startTime + ", endTimeCountDown=" + this.endTimeCountDown + ", status=" + this.status + ", needWarmUp=" + this.needWarmUp + ", warmUpCountDown=" + this.warmUpCountDown + ')';
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getEndTimeCountDown() {
        return this.endTimeCountDown;
    }

    public final Boolean getNeedWarmUp() {
        return this.needWarmUp;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getWarmUpCountDown() {
        return this.warmUpCountDown;
    }

    public SecKillInfo(String r100, Long r101, Long r102, Long r103, Integer r104, Boolean r105, Long r106) {
        this.activityId = r100;
        this.endTime = r101;
        this.startTime = r102;
        this.endTimeCountDown = r103;
        this.status = r104;
        this.needWarmUp = r105;
        this.warmUpCountDown = r106;
    }

    public /* synthetic */ SecKillInfo(String r100, Long r101, Long r102, Long r103, Integer r110, Boolean r111, Long r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = "";
    L5:
        Long r104 = null;
        if ((r113 & 2) == 0) goto L8;
        Long r115 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        Long r105 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        Long r106 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        Integer r107 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        Boolean r108 = null;
    L26:
        if ((r113 & 64) != 0) goto L29;
        r104 = r112;
    L29:
        this(r100, r115, r105, r106, r107, r108, r104);
        return;
    L24:
        r108 = r111;
        goto L26
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
