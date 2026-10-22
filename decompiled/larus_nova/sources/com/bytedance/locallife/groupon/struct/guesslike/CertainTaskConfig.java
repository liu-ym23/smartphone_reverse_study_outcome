package com.bytedance.locallife.groupon.struct.guesslike;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;", "", "swipeTimeNeed", "", "couponAmount", "taskDelay", "popupAvoidDelay", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCouponAmount", "()Ljava/lang/Integer;", "setCouponAmount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPopupAvoidDelay", "setPopupAvoidDelay", "getSwipeTimeNeed", "setSwipeTimeNeed", "getTaskDelay", "setTaskDelay", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/guesslike/CertainTaskConfig;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CertainTaskConfig {

    @SerializedName("coupon_amount")
    private Integer couponAmount;

    @SerializedName("popup_avoid_delay")
    private Integer popupAvoidDelay;

    @SerializedName("swipe_time_need")
    private Integer swipeTimeNeed;

    @SerializedName("task_delay")
    private Integer taskDelay;

    public CertainTaskConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CertainTaskConfig copy$default(CertainTaskConfig r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.swipeTimeNeed;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.couponAmount;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.taskDelay;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.popupAvoidDelay;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.swipeTimeNeed;
    }

    public final Integer component2() {
        return this.couponAmount;
    }

    public final Integer component3() {
        return this.taskDelay;
    }

    public final Integer component4() {
        return this.popupAvoidDelay;
    }

    public final CertainTaskConfig copy(Integer r100, Integer r101, Integer r102, Integer r103) {
        return new CertainTaskConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CertainTaskConfig) == true) goto L8;
        return false;
    L8:
        CertainTaskConfig r101 = (CertainTaskConfig) r100;
        if (Intrinsics.areEqual(this.swipeTimeNeed, r101.swipeTimeNeed) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponAmount, r101.couponAmount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskDelay, r101.taskDelay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.popupAvoidDelay, r101.popupAvoidDelay) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.swipeTimeNeed;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.couponAmount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.taskDelay;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.popupAvoidDelay;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "CertainTaskConfig(swipeTimeNeed=" + this.swipeTimeNeed + ", couponAmount=" + this.couponAmount + ", taskDelay=" + this.taskDelay + ", popupAvoidDelay=" + this.popupAvoidDelay + ')';
    }

    public final Integer getCouponAmount() {
        return this.couponAmount;
    }

    public final Integer getPopupAvoidDelay() {
        return this.popupAvoidDelay;
    }

    public final Integer getSwipeTimeNeed() {
        return this.swipeTimeNeed;
    }

    public final Integer getTaskDelay() {
        return this.taskDelay;
    }

    public final void setCouponAmount(Integer r100) {
        this.couponAmount = r100;
    }

    public final void setPopupAvoidDelay(Integer r100) {
        this.popupAvoidDelay = r100;
    }

    public final void setSwipeTimeNeed(Integer r100) {
        this.swipeTimeNeed = r100;
    }

    public final void setTaskDelay(Integer r100) {
        this.taskDelay = r100;
    }

    public CertainTaskConfig(Integer r100, Integer r101, Integer r102, Integer r103) {
        this.swipeTimeNeed = r100;
        this.couponAmount = r101;
        this.taskDelay = r102;
        this.popupAvoidDelay = r103;
    }

    public /* synthetic */ CertainTaskConfig(Integer r100, Integer r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
