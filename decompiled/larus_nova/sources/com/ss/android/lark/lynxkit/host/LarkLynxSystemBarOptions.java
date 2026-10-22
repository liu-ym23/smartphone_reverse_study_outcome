package com.ss.android.lark.lynxkit.host;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010!\u001a\u00020\u0005HÆ\u0003Jp\u0010\"\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013¨\u0006)"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "", "statusBarColor", "", "consumeStatusBar", "", "consumeDisplayCutout", "isAppearanceLightStatusBars", "isAutoCalculateLightStatusBars", "navigationBarColor", "consumeNavigationBar", "isAppearanceLightNavigationBars", "isAutoCalculateLightNavigationBars", "<init>", "(Ljava/lang/Integer;ZZLjava/lang/Boolean;ZLjava/lang/Integer;ZLjava/lang/Boolean;Z)V", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConsumeStatusBar", "()Z", "getConsumeDisplayCutout", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNavigationBarColor", "getConsumeNavigationBar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ZZLjava/lang/Boolean;ZLjava/lang/Integer;ZLjava/lang/Boolean;Z)Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "equals", "other", "hashCode", "toString", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLynxSystemBarOptions {
    private final boolean consumeDisplayCutout;
    private final boolean consumeNavigationBar;
    private final boolean consumeStatusBar;
    private final Boolean isAppearanceLightNavigationBars;
    private final Boolean isAppearanceLightStatusBars;
    private final boolean isAutoCalculateLightNavigationBars;
    private final boolean isAutoCalculateLightStatusBars;
    private final Integer navigationBarColor;
    private final Integer statusBarColor;

    public LarkLynxSystemBarOptions() {
        this(null, false, false, null, false, null, false, null, false, 511, null);
    }

    public static /* synthetic */ LarkLynxSystemBarOptions copy$default(LarkLynxSystemBarOptions r110, Integer r111, boolean r112, boolean r113, Boolean r114, boolean r115, Integer r116, boolean r117, Boolean r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = r110.statusBarColor;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = r110.consumeStatusBar;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.consumeDisplayCutout;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Boolean r103 = r110.isAppearanceLightStatusBars;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.isAutoCalculateLightStatusBars;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Integer r105 = r110.navigationBarColor;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.consumeNavigationBar;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r107 = r110.isAppearanceLightNavigationBars;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.isAutoCalculateLightNavigationBars;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Integer component1() {
        return this.statusBarColor;
    }

    public final boolean component2() {
        return this.consumeStatusBar;
    }

    public final boolean component3() {
        return this.consumeDisplayCutout;
    }

    public final Boolean component4() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean component5() {
        return this.isAutoCalculateLightStatusBars;
    }

    public final Integer component6() {
        return this.navigationBarColor;
    }

    public final boolean component7() {
        return this.consumeNavigationBar;
    }

    public final Boolean component8() {
        return this.isAppearanceLightNavigationBars;
    }

    public final boolean component9() {
        return this.isAutoCalculateLightNavigationBars;
    }

    public final LarkLynxSystemBarOptions copy(Integer r110, boolean r111, boolean r112, Boolean r113, boolean r114, Integer r115, boolean r116, Boolean r117, boolean r210) {
        return new LarkLynxSystemBarOptions(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkLynxSystemBarOptions) == true) goto L8;
        return false;
    L8:
        LarkLynxSystemBarOptions r101 = (LarkLynxSystemBarOptions) r100;
        if (Intrinsics.areEqual(this.statusBarColor, r101.statusBarColor) == true) goto L12;
        return false;
    L12:
        if (this.consumeStatusBar == r101.consumeStatusBar) goto L15;
        return false;
    L15:
        if (this.consumeDisplayCutout == r101.consumeDisplayCutout) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isAppearanceLightStatusBars, r101.isAppearanceLightStatusBars) == true) goto L21;
        return false;
    L21:
        if (this.isAutoCalculateLightStatusBars == r101.isAutoCalculateLightStatusBars) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.navigationBarColor, r101.navigationBarColor) == true) goto L27;
        return false;
    L27:
        if (this.consumeNavigationBar == r101.consumeNavigationBar) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isAppearanceLightNavigationBars, r101.isAppearanceLightNavigationBars) == true) goto L33;
        return false;
    L33:
        if (this.isAutoCalculateLightNavigationBars == r101.isAutoCalculateLightNavigationBars) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.statusBarColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.consumeStatusBar == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.consumeDisplayCutout == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        Boolean r109 = this.isAppearanceLightStatusBars;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.isAutoCalculateLightStatusBars == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        Integer r114 = this.navigationBarColor;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        if (this.consumeNavigationBar == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        Boolean r119 = this.isAppearanceLightNavigationBars;
        if (r119 == null) goto L34;
        r101 = r119.hashCode();
    L34:
        int r120 = (r118 + r101) * 31;
        if (this.isAutoCalculateLightNavigationBars == true) goto L39;
        r104 = 1237;
    L39:
        return r120 + r104;
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkLynxSystemBarOptions(statusBarColor=" + this.statusBarColor + ", consumeStatusBar=" + this.consumeStatusBar + ", consumeDisplayCutout=" + this.consumeDisplayCutout + ", isAppearanceLightStatusBars=" + this.isAppearanceLightStatusBars + ", isAutoCalculateLightStatusBars=" + this.isAutoCalculateLightStatusBars + ", navigationBarColor=" + this.navigationBarColor + ", consumeNavigationBar=" + this.consumeNavigationBar + ", isAppearanceLightNavigationBars=" + this.isAppearanceLightNavigationBars + ", isAutoCalculateLightNavigationBars=" + this.isAutoCalculateLightNavigationBars + ')';
    }

    public final boolean getConsumeDisplayCutout() {
        return this.consumeDisplayCutout;
    }

    public final boolean getConsumeNavigationBar() {
        return this.consumeNavigationBar;
    }

    public final boolean getConsumeStatusBar() {
        return this.consumeStatusBar;
    }

    public final Integer getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    public final Boolean isAppearanceLightNavigationBars() {
        return this.isAppearanceLightNavigationBars;
    }

    public final Boolean isAppearanceLightStatusBars() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean isAutoCalculateLightNavigationBars() {
        return this.isAutoCalculateLightNavigationBars;
    }

    public final boolean isAutoCalculateLightStatusBars() {
        return this.isAutoCalculateLightStatusBars;
    }

    public LarkLynxSystemBarOptions(Integer r100, boolean r101, boolean r102, Boolean r103, boolean r104, Integer r105, boolean r106, Boolean r107, boolean r108) {
        this.statusBarColor = r100;
        this.consumeStatusBar = r101;
        this.consumeDisplayCutout = r102;
        this.isAppearanceLightStatusBars = r103;
        this.isAutoCalculateLightStatusBars = r104;
        this.navigationBarColor = r105;
        this.consumeNavigationBar = r106;
        this.isAppearanceLightNavigationBars = r107;
        this.isAutoCalculateLightNavigationBars = r108;
    }

    public /* synthetic */ LarkLynxSystemBarOptions(Integer r110, boolean r111, boolean r112, Boolean r113, boolean r114, Integer r115, boolean r116, Boolean r117, boolean r210, int r211, DefaultConstructorMarker r212) {
        Boolean r100 = null;
        if ((r211 & 1) == 0) goto L5;
        Integer r101 = null;
    L6:
        boolean r102 = true;
        if ((r211 & 2) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r211 & 4) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r211 & 16) == 0) goto L21;
        boolean r106 = true;
    L23:
        if ((r211 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r211 & 64) == 0) goto L29;
        boolean r108 = true;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r211 & 256) != 0) goto L38;
        r102 = r210;
    L38:
        this(r101, r103, r104, r105, r106, r107, r108, r100, r102);
        return;
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
