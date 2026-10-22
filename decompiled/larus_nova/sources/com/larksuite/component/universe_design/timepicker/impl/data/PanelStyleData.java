package com.larksuite.component.universe_design.timepicker.impl.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/data/PanelStyleData;", "", "visibleItemNum", "", "minuteInterval", "itemDividerVisibility", "", "showDayInfo", "<init>", "(IIZZ)V", "getVisibleItemNum", "()I", "setVisibleItemNum", "(I)V", "getMinuteInterval", "setMinuteInterval", "getItemDividerVisibility", "()Z", "setItemDividerVisibility", "(Z)V", "getShowDayInfo", "setShowDayInfo", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelStyleData {
    private boolean itemDividerVisibility;
    private int minuteInterval;
    private boolean showDayInfo;
    private int visibleItemNum;

    public PanelStyleData() {
        this(0, 0, false, false, 15, null);
    }

    public static /* synthetic */ PanelStyleData copy$default(PanelStyleData r100, int r101, int r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.visibleItemNum;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.minuteInterval;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.itemDividerVisibility;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.showDayInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.visibleItemNum;
    }

    public final int component2() {
        return this.minuteInterval;
    }

    public final boolean component3() {
        return this.itemDividerVisibility;
    }

    public final boolean component4() {
        return this.showDayInfo;
    }

    public final PanelStyleData copy(int r100, int r101, boolean r102, boolean r103) {
        return new PanelStyleData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PanelStyleData) == true) goto L8;
        return false;
    L8:
        PanelStyleData r101 = (PanelStyleData) r100;
        if (this.visibleItemNum == r101.visibleItemNum) goto L12;
        return false;
    L12:
        if (this.minuteInterval == r101.minuteInterval) goto L15;
        return false;
    L15:
        if (this.itemDividerVisibility == r101.itemDividerVisibility) goto L18;
        return false;
    L18:
        if (this.showDayInfo == r101.showDayInfo) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.visibleItemNum * 31) + this.minuteInterval) * 31;
        int r101 = 1231;
        if (this.itemDividerVisibility == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.showDayInfo == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "PanelStyleData(visibleItemNum=" + this.visibleItemNum + ", minuteInterval=" + this.minuteInterval + ", itemDividerVisibility=" + this.itemDividerVisibility + ", showDayInfo=" + this.showDayInfo + ')';
    }

    public final boolean getItemDividerVisibility() {
        return this.itemDividerVisibility;
    }

    public final int getMinuteInterval() {
        return this.minuteInterval;
    }

    public final boolean getShowDayInfo() {
        return this.showDayInfo;
    }

    public final int getVisibleItemNum() {
        return this.visibleItemNum;
    }

    public final void setItemDividerVisibility(boolean r100) {
        this.itemDividerVisibility = r100;
    }

    public final void setMinuteInterval(int r100) {
        this.minuteInterval = r100;
    }

    public final void setShowDayInfo(boolean r100) {
        this.showDayInfo = r100;
    }

    public final void setVisibleItemNum(int r100) {
        this.visibleItemNum = r100;
    }

    public PanelStyleData(int r100, int r101, boolean r102, boolean r103) {
        this.visibleItemNum = r100;
        this.minuteInterval = r101;
        this.itemDividerVisibility = r102;
        this.showDayInfo = r103;
    }

    public /* synthetic */ PanelStyleData(int r100, int r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 3;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = true;
    L14:
        this(r100, r101, r102, r103);
    }
}
