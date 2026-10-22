package com.obric.assistant.interaction.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/api/WindowLayoutInfo;", "", "visibleY", "", "displayHeight", "windowHeight", "isNoLimitsEnabled", "", "visibleNoLimitsEnabled", "isLandscapeWindowLayout", "<init>", "(IIIZZZ)V", "getVisibleY", "()I", "getDisplayHeight", "getWindowHeight", "()Z", "getVisibleNoLimitsEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLayoutInfo {
    private final int displayHeight;
    private final boolean isLandscapeWindowLayout;
    private final boolean isNoLimitsEnabled;
    private final boolean visibleNoLimitsEnabled;
    private final int visibleY;
    private final int windowHeight;

    public static /* synthetic */ WindowLayoutInfo copy$default(WindowLayoutInfo r100, int r101, int r102, int r103, boolean r104, boolean r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.visibleY;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.displayHeight;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.windowHeight;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isNoLimitsEnabled;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.visibleNoLimitsEnabled;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isLandscapeWindowLayout;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.visibleY;
    }

    public final int component2() {
        return this.displayHeight;
    }

    public final int component3() {
        return this.windowHeight;
    }

    public final boolean component4() {
        return this.isNoLimitsEnabled;
    }

    public final boolean component5() {
        return this.visibleNoLimitsEnabled;
    }

    public final boolean component6() {
        return this.isLandscapeWindowLayout;
    }

    public final WindowLayoutInfo copy(int r100, int r110, int r111, boolean r112, boolean r113, boolean r114) {
        return new WindowLayoutInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowLayoutInfo) == true) goto L8;
        return false;
    L8:
        WindowLayoutInfo r101 = (WindowLayoutInfo) r100;
        if (this.visibleY == r101.visibleY) goto L12;
        return false;
    L12:
        if (this.displayHeight == r101.displayHeight) goto L15;
        return false;
    L15:
        if (this.windowHeight == r101.windowHeight) goto L18;
        return false;
    L18:
        if (this.isNoLimitsEnabled == r101.isNoLimitsEnabled) goto L21;
        return false;
    L21:
        if (this.visibleNoLimitsEnabled == r101.visibleNoLimitsEnabled) goto L24;
        return false;
    L24:
        if (this.isLandscapeWindowLayout == r101.isLandscapeWindowLayout) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.visibleY * 31) + this.displayHeight) * 31) + this.windowHeight) * 31;
        int r101 = 1231;
        if (this.isNoLimitsEnabled == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.visibleNoLimitsEnabled == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.isLandscapeWindowLayout == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "WindowLayoutInfo(visibleY=" + this.visibleY + ", displayHeight=" + this.displayHeight + ", windowHeight=" + this.windowHeight + ", isNoLimitsEnabled=" + this.isNoLimitsEnabled + ", visibleNoLimitsEnabled=" + this.visibleNoLimitsEnabled + ", isLandscapeWindowLayout=" + this.isLandscapeWindowLayout + ')';
    }

    public final int getDisplayHeight() {
        return this.displayHeight;
    }

    public final boolean getVisibleNoLimitsEnabled() {
        return this.visibleNoLimitsEnabled;
    }

    public final int getVisibleY() {
        return this.visibleY;
    }

    public final int getWindowHeight() {
        return this.windowHeight;
    }

    public final boolean isLandscapeWindowLayout() {
        return this.isLandscapeWindowLayout;
    }

    public final boolean isNoLimitsEnabled() {
        return this.isNoLimitsEnabled;
    }

    public WindowLayoutInfo(int r100, int r101, int r102, boolean r103, boolean r104, boolean r105) {
        this.visibleY = r100;
        this.displayHeight = r101;
        this.windowHeight = r102;
        this.isNoLimitsEnabled = r103;
        this.visibleNoLimitsEnabled = r104;
        this.isLandscapeWindowLayout = r105;
    }

    public /* synthetic */ WindowLayoutInfo(int r110, int r111, int r112, boolean r113, boolean r114, boolean r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r116 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r116 & 32) == 0) goto L13;
        boolean r102 = false;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
