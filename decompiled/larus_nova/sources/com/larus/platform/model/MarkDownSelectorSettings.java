package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/MarkDownSelectorSettings;", "", "doubleClickStrategy", "", "longPressStrategy", "tripleClickStrategy", "doubleClickShiftStrategy", "enableMarkedTextFirst", "", "<init>", "(IIIIZ)V", "getDoubleClickStrategy", "()I", "getLongPressStrategy", "getTripleClickStrategy", "getDoubleClickShiftStrategy", "getEnableMarkedTextFirst", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkDownSelectorSettings {

    @SerializedName("double_click_shift_strategy")
    private final int doubleClickShiftStrategy;

    @SerializedName("double_click_strategy")
    private final int doubleClickStrategy;

    @SerializedName("enable_marked_text_first")
    private final boolean enableMarkedTextFirst;

    @SerializedName("long_press_strategy")
    private final int longPressStrategy;

    @SerializedName("triple_click_strategy")
    private final int tripleClickStrategy;

    public MarkDownSelectorSettings() {
        this(0, 0, 0, 0, false, 31, null);
    }

    public static /* synthetic */ MarkDownSelectorSettings copy$default(MarkDownSelectorSettings r100, int r101, int r102, int r103, int r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.doubleClickStrategy;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.longPressStrategy;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.tripleClickStrategy;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.doubleClickShiftStrategy;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableMarkedTextFirst;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.doubleClickStrategy;
    }

    public final int component2() {
        return this.longPressStrategy;
    }

    public final int component3() {
        return this.tripleClickStrategy;
    }

    public final int component4() {
        return this.doubleClickShiftStrategy;
    }

    public final boolean component5() {
        return this.enableMarkedTextFirst;
    }

    public final MarkDownSelectorSettings copy(int r100, int r101, int r110, int r111, boolean r112) {
        return new MarkDownSelectorSettings(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarkDownSelectorSettings) == true) goto L8;
        return false;
    L8:
        MarkDownSelectorSettings r101 = (MarkDownSelectorSettings) r100;
        if (this.doubleClickStrategy == r101.doubleClickStrategy) goto L12;
        return false;
    L12:
        if (this.longPressStrategy == r101.longPressStrategy) goto L15;
        return false;
    L15:
        if (this.tripleClickStrategy == r101.tripleClickStrategy) goto L18;
        return false;
    L18:
        if (this.doubleClickShiftStrategy == r101.doubleClickShiftStrategy) goto L21;
        return false;
    L21:
        if (this.enableMarkedTextFirst == r101.enableMarkedTextFirst) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.doubleClickStrategy * 31) + this.longPressStrategy) * 31) + this.tripleClickStrategy) * 31) + this.doubleClickShiftStrategy) * 31;
        if (this.enableMarkedTextFirst == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "MarkDownSelectorSettings(doubleClickStrategy=" + this.doubleClickStrategy + ", longPressStrategy=" + this.longPressStrategy + ", tripleClickStrategy=" + this.tripleClickStrategy + ", doubleClickShiftStrategy=" + this.doubleClickShiftStrategy + ", enableMarkedTextFirst=" + this.enableMarkedTextFirst + ')';
    }

    public final int getDoubleClickShiftStrategy() {
        return this.doubleClickShiftStrategy;
    }

    public final int getDoubleClickStrategy() {
        return this.doubleClickStrategy;
    }

    public final boolean getEnableMarkedTextFirst() {
        return this.enableMarkedTextFirst;
    }

    public final int getLongPressStrategy() {
        return this.longPressStrategy;
    }

    public final int getTripleClickStrategy() {
        return this.tripleClickStrategy;
    }

    public MarkDownSelectorSettings(int r100, int r101, int r102, int r103, boolean r104) {
        this.doubleClickStrategy = r100;
        this.longPressStrategy = r101;
        this.tripleClickStrategy = r102;
        this.doubleClickShiftStrategy = r103;
        this.enableMarkedTextFirst = r104;
    }

    public /* synthetic */ MarkDownSelectorSettings(int r100, int r101, int r102, int r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        int r106 = 3;
        if ((r105 & 1) == 0) goto L5;
        int r111 = 3;
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        int r107 = 5;
    L15:
        if ((r105 & 8) == 0) goto L17;
        r103 = !AppHost.f326268a.isOversea() ? 1 : 0;
    L17:
        int r108 = r103;
        if ((r105 & 16) == 0) goto L20;
        r104 = !AppHost.f326268a.isOversea();
    L20:
        this(r111, r106, r107, r108, r104);
        return;
    L13:
        r107 = r102;
        goto L15
    L5:
        r111 = r100;
        goto L7
    }
}
