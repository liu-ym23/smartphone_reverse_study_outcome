package com.relax.runtime.gen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003Jc\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\fHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u00066"}, d2 = {"Lcom/relax/runtime/gen/GlobalState;", "", "screenWidth", "", "screenHeight", "viewportWidth", "viewportHeight", "devicePixelRatio", "fontScale", "nightMode", "", "platform", "", "relaxVersion", "(DDDDDDZLjava/lang/String;Ljava/lang/String;)V", "getDevicePixelRatio", "()D", "setDevicePixelRatio", "(D)V", "getFontScale", "setFontScale", "getNightMode", "()Z", "setNightMode", "(Z)V", "getPlatform", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "getRelaxVersion", "setRelaxVersion", "getScreenHeight", "setScreenHeight", "getScreenWidth", "setScreenWidth", "getViewportHeight", "setViewportHeight", "getViewportWidth", "setViewportWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalState {
    private double devicePixelRatio;
    private double fontScale;
    private boolean nightMode;
    private String platform;
    private String relaxVersion;
    private double screenHeight;
    private double screenWidth;
    private double viewportHeight;
    private double viewportWidth;

    public static /* synthetic */ GlobalState copy$default(GlobalState r110, double r111, double r112, double r210, double r211, double r212, double r213, boolean r214, String r310, String r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        double r100 = r110.screenWidth;
    L7:
        if ((r312 & 2) == 0) goto L9;
        double r101 = r110.screenHeight;
    L11:
        if ((r312 & 4) == 0) goto L13;
        double r102 = r110.viewportWidth;
    L15:
        if ((r312 & 8) == 0) goto L17;
        double r103 = r110.viewportHeight;
    L19:
        if ((r312 & 16) == 0) goto L21;
        double r113 = r110.devicePixelRatio;
    L23:
        if ((r312 & 32) == 0) goto L25;
        double r114 = r110.fontScale;
    L27:
        if ((r312 & 64) == 0) goto L29;
        boolean r115 = r110.nightMode;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r116 = r110.platform;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r104 = r110.relaxVersion;
    L39:
        return r110.copy(r100, r101, r102, r103, r113, r114, r115, r116, r104);
    L37:
        r104 = r311;
        goto L39
    L33:
        r116 = r310;
        goto L35
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r213;
        goto L27
    L21:
        r113 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final double component1() {
        return this.screenWidth;
    }

    public final double component2() {
        return this.screenHeight;
    }

    public final double component3() {
        return this.viewportWidth;
    }

    public final double component4() {
        return this.viewportHeight;
    }

    public final double component5() {
        return this.devicePixelRatio;
    }

    public final double component6() {
        return this.fontScale;
    }

    public final boolean component7() {
        return this.nightMode;
    }

    public final String component8() {
        return this.platform;
    }

    public final String component9() {
        return this.relaxVersion;
    }

    public final GlobalState copy(double r110, double r210, double r211, double r212, double r213, double r214, boolean r310, String r311, String r312) {
        Intrinsics.checkNotNullParameter(r311, "platform");
        Intrinsics.checkNotNullParameter(r312, "relaxVersion");
        return new GlobalState(r110, r210, r211, r212, r213, r214, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalState) == true) goto L8;
        return false;
    L8:
        GlobalState r101 = (GlobalState) r100;
        if (Intrinsics.areEqual(Double.valueOf(this.screenWidth), Double.valueOf(r101.screenWidth)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Double.valueOf(this.screenHeight), Double.valueOf(r101.screenHeight)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Double.valueOf(this.viewportWidth), Double.valueOf(r101.viewportWidth)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Double.valueOf(this.viewportHeight), Double.valueOf(r101.viewportHeight)) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Double.valueOf(this.devicePixelRatio), Double.valueOf(r101.devicePixelRatio)) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(Double.valueOf(this.fontScale), Double.valueOf(r101.fontScale)) == true) goto L27;
        return false;
    L27:
        if (this.nightMode == r101.nightMode) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.platform, r101.platform) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.relaxVersion, r101.relaxVersion) == true) goto L35;
        return false;
    L35:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.screenWidth);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.screenHeight);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.viewportWidth);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.viewportHeight);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.devicePixelRatio);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.fontScale);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        boolean r112 = this.nightMode;
        ?? r113 = r112;
        if (r112 == false) goto L6;
        r113 = 1;
    L6:
        return ((((r111 + r113) * 31) + this.platform.hashCode()) * 31) + this.relaxVersion.hashCode();
    }

    public String toString() {
        return "GlobalState(screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", viewportWidth=" + this.viewportWidth + ", viewportHeight=" + this.viewportHeight + ", devicePixelRatio=" + this.devicePixelRatio + ", fontScale=" + this.fontScale + ", nightMode=" + this.nightMode + ", platform=" + this.platform + ", relaxVersion=" + this.relaxVersion + ')';
    }

    public final double getDevicePixelRatio() {
        return this.devicePixelRatio;
    }

    public final double getFontScale() {
        return this.fontScale;
    }

    public final boolean getNightMode() {
        return this.nightMode;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getRelaxVersion() {
        return this.relaxVersion;
    }

    public final double getScreenHeight() {
        return this.screenHeight;
    }

    public final double getScreenWidth() {
        return this.screenWidth;
    }

    public final double getViewportHeight() {
        return this.viewportHeight;
    }

    public final double getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setDevicePixelRatio(double r100) {
        this.devicePixelRatio = r100;
    }

    public final void setFontScale(double r100) {
        this.fontScale = r100;
    }

    public final void setNightMode(boolean r100) {
        this.nightMode = r100;
    }

    public final void setPlatform(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.platform = r100;
    }

    public final void setRelaxVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.relaxVersion = r100;
    }

    public final void setScreenHeight(double r100) {
        this.screenHeight = r100;
    }

    public final void setScreenWidth(double r100) {
        this.screenWidth = r100;
    }

    public final void setViewportHeight(double r100) {
        this.viewportHeight = r100;
    }

    public final void setViewportWidth(double r100) {
        this.viewportWidth = r100;
    }

    public GlobalState(double r100, double r101, double r110, double r111, double r112, double r113, boolean r114, String r115, String r210) {
        Intrinsics.checkNotNullParameter(r115, "platform");
        Intrinsics.checkNotNullParameter(r210, "relaxVersion");
        this.screenWidth = r100;
        this.screenHeight = r101;
        this.viewportWidth = r110;
        this.viewportHeight = r111;
        this.devicePixelRatio = r112;
        this.fontScale = r113;
        this.nightMode = r114;
        this.platform = r115;
        this.relaxVersion = r210;
    }
}
