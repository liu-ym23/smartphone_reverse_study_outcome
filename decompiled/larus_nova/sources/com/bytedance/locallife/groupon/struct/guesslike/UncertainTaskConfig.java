package com.bytedance.locallife.groupon.struct.guesslike;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006+"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;", "", "swipeStep", "", "minSwipe", "maxSwipe", "clickStep", "minClick", "maxClick", "clickDelay", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getClickDelay", "()Ljava/lang/Integer;", "setClickDelay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickStep", "setClickStep", "getMaxClick", "setMaxClick", "getMaxSwipe", "setMaxSwipe", "getMinClick", "setMinClick", "getMinSwipe", "setMinSwipe", "getSwipeStep", "setSwipeStep", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/guesslike/UncertainTaskConfig;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class UncertainTaskConfig {

    @SerializedName("click_delay")
    private Integer clickDelay;

    @SerializedName("click_step")
    private Integer clickStep;

    @SerializedName("max_click")
    private Integer maxClick;

    @SerializedName("max_swipe")
    private Integer maxSwipe;

    @SerializedName("min_click")
    private Integer minClick;

    @SerializedName("min_swipe")
    private Integer minSwipe;

    @SerializedName("swipe_step")
    private Integer swipeStep;

    public UncertainTaskConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ UncertainTaskConfig copy$default(UncertainTaskConfig r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.swipeStep;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.minSwipe;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.maxSwipe;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.clickStep;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.minClick;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.maxClick;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.clickDelay;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.swipeStep;
    }

    public final Integer component2() {
        return this.minSwipe;
    }

    public final Integer component3() {
        return this.maxSwipe;
    }

    public final Integer component4() {
        return this.clickStep;
    }

    public final Integer component5() {
        return this.minClick;
    }

    public final Integer component6() {
        return this.maxClick;
    }

    public final Integer component7() {
        return this.clickDelay;
    }

    public final UncertainTaskConfig copy(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116) {
        return new UncertainTaskConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UncertainTaskConfig) == true) goto L8;
        return false;
    L8:
        UncertainTaskConfig r101 = (UncertainTaskConfig) r100;
        if (Intrinsics.areEqual(this.swipeStep, r101.swipeStep) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minSwipe, r101.minSwipe) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxSwipe, r101.maxSwipe) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickStep, r101.clickStep) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.minClick, r101.minClick) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxClick, r101.maxClick) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.clickDelay, r101.clickDelay) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.swipeStep;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.minSwipe;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.maxSwipe;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.clickStep;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.minClick;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.maxClick;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.clickDelay;
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
        return "UncertainTaskConfig(swipeStep=" + this.swipeStep + ", minSwipe=" + this.minSwipe + ", maxSwipe=" + this.maxSwipe + ", clickStep=" + this.clickStep + ", minClick=" + this.minClick + ", maxClick=" + this.maxClick + ", clickDelay=" + this.clickDelay + ')';
    }

    public final Integer getClickDelay() {
        return this.clickDelay;
    }

    public final Integer getClickStep() {
        return this.clickStep;
    }

    public final Integer getMaxClick() {
        return this.maxClick;
    }

    public final Integer getMaxSwipe() {
        return this.maxSwipe;
    }

    public final Integer getMinClick() {
        return this.minClick;
    }

    public final Integer getMinSwipe() {
        return this.minSwipe;
    }

    public final Integer getSwipeStep() {
        return this.swipeStep;
    }

    public final void setClickDelay(Integer r100) {
        this.clickDelay = r100;
    }

    public final void setClickStep(Integer r100) {
        this.clickStep = r100;
    }

    public final void setMaxClick(Integer r100) {
        this.maxClick = r100;
    }

    public final void setMaxSwipe(Integer r100) {
        this.maxSwipe = r100;
    }

    public final void setMinClick(Integer r100) {
        this.minClick = r100;
    }

    public final void setMinSwipe(Integer r100) {
        this.minSwipe = r100;
    }

    public final void setSwipeStep(Integer r100) {
        this.swipeStep = r100;
    }

    public UncertainTaskConfig(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106) {
        this.swipeStep = r100;
        this.minSwipe = r101;
        this.maxSwipe = r102;
        this.clickStep = r103;
        this.minClick = r104;
        this.maxClick = r105;
        this.clickDelay = r106;
    }

    public /* synthetic */ UncertainTaskConfig(Integer r100, Integer r101, Integer r102, Integer r110, Integer r111, Integer r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Integer r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Integer r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
