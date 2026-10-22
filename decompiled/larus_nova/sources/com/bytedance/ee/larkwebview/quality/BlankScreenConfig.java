package com.bytedance.ee.larkwebview.quality;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003JO\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00062"}, d2 = {"Lcom/bytedance/ee/larkwebview/quality/BlankScreenConfig;", "", "enableDetection", "", "minCheckInterval", "", "blankThreshold", "", "replaceWebview", "dropOnFastEntry", "checkEnterTimeWindow", "", "filterTransparentPixel", "<init>", "(ZJFZZIZ)V", "getEnableDetection", "()Z", "setEnableDetection", "(Z)V", "getMinCheckInterval", "()J", "setMinCheckInterval", "(J)V", "getBlankThreshold", "()F", "setBlankThreshold", "(F)V", "getReplaceWebview", "setReplaceWebview", "getDropOnFastEntry", "setDropOnFastEntry", "getCheckEnterTimeWindow", "()I", "setCheckEnterTimeWindow", "(I)V", "getFilterTransparentPixel", "setFilterTransparentPixel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlankScreenConfig {

    @SerializedName("min_blank_pixel_rate")
    private float blankThreshold;

    @SerializedName("check_enter_time_window")
    private int checkEnterTimeWindow;

    @SerializedName("dispose_by_enter_frequency")
    private boolean dropOnFastEntry;

    @SerializedName("enable_snapshot_detection")
    private boolean enableDetection;

    @SerializedName("filter_transparent_pixel")
    private boolean filterTransparentPixel;

    @SerializedName("minimum_check_time_interval")
    private long minCheckInterval;

    @SerializedName("replace_webview_when_display")
    private boolean replaceWebview;

    public BlankScreenConfig() {
        this(false, 0, 0.0f, false, false, 0, false, 127, null);
    }

    public static /* synthetic */ BlankScreenConfig copy$default(BlankScreenConfig r100, boolean r110, long r111, float r112, boolean r113, boolean r114, int r115, boolean r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        boolean r101 = r100.enableDetection;
    L7:
        if ((r117 & 2) == 0) goto L9;
        long r102 = r100.minCheckInterval;
    L11:
        if ((r117 & 4) == 0) goto L13;
        float r103 = r100.blankThreshold;
    L15:
        if ((r117 & 8) == 0) goto L17;
        boolean r104 = r100.replaceWebview;
    L19:
        if ((r117 & 16) == 0) goto L21;
        boolean r105 = r100.dropOnFastEntry;
    L23:
        if ((r117 & 32) == 0) goto L25;
        int r106 = r100.checkEnterTimeWindow;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.filterTransparentPixel;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final boolean component1() {
        return this.enableDetection;
    }

    public final long component2() {
        return this.minCheckInterval;
    }

    public final float component3() {
        return this.blankThreshold;
    }

    public final boolean component4() {
        return this.replaceWebview;
    }

    public final boolean component5() {
        return this.dropOnFastEntry;
    }

    public final int component6() {
        return this.checkEnterTimeWindow;
    }

    public final boolean component7() {
        return this.filterTransparentPixel;
    }

    public final BlankScreenConfig copy(boolean r110, long r111, float r112, boolean r113, boolean r114, int r115, boolean r116) {
        return new BlankScreenConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlankScreenConfig) == true) goto L8;
        return false;
    L8:
        BlankScreenConfig r101 = (BlankScreenConfig) r100;
        if (this.enableDetection == r101.enableDetection) goto L12;
        return false;
    L12:
        if (this.minCheckInterval == r101.minCheckInterval) goto L15;
        return false;
    L15:
        if (Float.compare(this.blankThreshold, r101.blankThreshold) == 0) goto L18;
        return false;
    L18:
        if (this.replaceWebview == r101.replaceWebview) goto L21;
        return false;
    L21:
        if (this.dropOnFastEntry == r101.dropOnFastEntry) goto L24;
        return false;
    L24:
        if (this.checkEnterTimeWindow == r101.checkEnterTimeWindow) goto L27;
        return false;
    L27:
        if (this.filterTransparentPixel == r101.filterTransparentPixel) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableDetection == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.minCheckInterval;
        int r103 = ((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Float.floatToIntBits(this.blankThreshold)) * 31;
        if (this.replaceWebview == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.dropOnFastEntry == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.checkEnterTimeWindow) * 31;
        if (this.filterTransparentPixel == true) goto L19;
        r100 = 1237;
    L19:
        return r107 + r100;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "BlankScreenConfig(enableDetection=" + this.enableDetection + ", minCheckInterval=" + this.minCheckInterval + ", blankThreshold=" + this.blankThreshold + ", replaceWebview=" + this.replaceWebview + ", dropOnFastEntry=" + this.dropOnFastEntry + ", checkEnterTimeWindow=" + this.checkEnterTimeWindow + ", filterTransparentPixel=" + this.filterTransparentPixel + ')';
    }

    public final float getBlankThreshold() {
        return this.blankThreshold;
    }

    public final int getCheckEnterTimeWindow() {
        return this.checkEnterTimeWindow;
    }

    public final boolean getDropOnFastEntry() {
        return this.dropOnFastEntry;
    }

    public final boolean getEnableDetection() {
        return this.enableDetection;
    }

    public final boolean getFilterTransparentPixel() {
        return this.filterTransparentPixel;
    }

    public final long getMinCheckInterval() {
        return this.minCheckInterval;
    }

    public final boolean getReplaceWebview() {
        return this.replaceWebview;
    }

    public final void setBlankThreshold(float r100) {
        this.blankThreshold = r100;
    }

    public final void setCheckEnterTimeWindow(int r100) {
        this.checkEnterTimeWindow = r100;
    }

    public final void setDropOnFastEntry(boolean r100) {
        this.dropOnFastEntry = r100;
    }

    public final void setEnableDetection(boolean r100) {
        this.enableDetection = r100;
    }

    public final void setFilterTransparentPixel(boolean r100) {
        this.filterTransparentPixel = r100;
    }

    public final void setMinCheckInterval(long r100) {
        this.minCheckInterval = r100;
    }

    public final void setReplaceWebview(boolean r100) {
        this.replaceWebview = r100;
    }

    public BlankScreenConfig(boolean r100, long r101, float r102, boolean r103, boolean r104, int r105, boolean r106) {
        this.enableDetection = r100;
        this.minCheckInterval = r101;
        this.blankThreshold = r102;
        this.replaceWebview = r103;
        this.dropOnFastEntry = r104;
        this.checkEnterTimeWindow = r105;
        this.filterTransparentPixel = r106;
    }

    public /* synthetic */ BlankScreenConfig(boolean r110, long r111, float r112, boolean r113, boolean r114, int r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        boolean r100 = false;
        if ((r117 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r117 & 2) == 0) goto L9;
        long r102 = 2;
    L11:
        if ((r117 & 4) == 0) goto L13;
        float r103 = 0.99f;
    L15:
        if ((r117 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r117 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r117 & 32) == 0) goto L25;
        int r106 = 30;
    L27:
        if ((r117 & 64) != 0) goto L30;
        r100 = r116;
    L30:
        this(r101, r102, r103, r104, r105, r106, r100);
        return;
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
