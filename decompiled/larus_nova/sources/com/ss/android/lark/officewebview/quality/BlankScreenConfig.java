package com.ss.android.lark.officewebview.quality;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0017\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0003J\u008f\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0001J\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\rHÖ\u0001J\t\u0010I\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR,\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006J"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;", "", "enableDetection", "", "enableDetectionWhenAppear", "minCheckInterval", "", "minCheckIntervalWhenAppear", "blankThreshold", "", "replaceWebview", "dropOnFastEntry", "checkEnterTimeWindow", "", "enableNearBlankPixelNormalize", "nearBlankPixelColorThreshold", "enablePixelCopyBlankCapture", "pixelCopyCropRectByBiz", "", "", "Lcom/ss/android/lark/officewebview/quality/PixelCopyCropRectConfig;", "<init>", "(ZZJJFZZIZIZLjava/util/Map;)V", "getEnableDetection", "()Z", "setEnableDetection", "(Z)V", "getEnableDetectionWhenAppear", "setEnableDetectionWhenAppear", "getMinCheckInterval", "()J", "setMinCheckInterval", "(J)V", "getMinCheckIntervalWhenAppear", "setMinCheckIntervalWhenAppear", "getBlankThreshold", "()F", "setBlankThreshold", "(F)V", "getReplaceWebview", "setReplaceWebview", "getDropOnFastEntry", "setDropOnFastEntry", "getCheckEnterTimeWindow", "()I", "setCheckEnterTimeWindow", "(I)V", "getEnableNearBlankPixelNormalize", "setEnableNearBlankPixelNormalize", "getNearBlankPixelColorThreshold", "setNearBlankPixelColorThreshold", "getEnablePixelCopyBlankCapture", "setEnablePixelCopyBlankCapture", "getPixelCopyCropRectByBiz", "()Ljava/util/Map;", "setPixelCopyCropRectByBiz", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlankScreenConfig {

    @SerializedName("min_blank_pixel_rate")
    private float blankThreshold;

    @SerializedName("check_enter_time_window")
    private int checkEnterTimeWindow;

    @SerializedName("dispose_by_enter_frequency")
    private boolean dropOnFastEntry;

    @SerializedName("enable_snapshot_detection")
    private boolean enableDetection;

    @SerializedName("enable_detection_when_appear")
    private boolean enableDetectionWhenAppear;

    @SerializedName("enable_near_blank_pixel_normalize")
    private boolean enableNearBlankPixelNormalize;

    @SerializedName("enable_pixel_copy_blank_capture")
    private boolean enablePixelCopyBlankCapture;

    @SerializedName("minimum_check_time_interval")
    private long minCheckInterval;

    @SerializedName("minimum_check_time_interval_when_appear")
    private long minCheckIntervalWhenAppear;

    @SerializedName("near_blank_pixel_color_threshold")
    private int nearBlankPixelColorThreshold;

    @SerializedName("pixel_copy_crop_rect_by_biz")
    private Map<String, PixelCopyCropRectConfig> pixelCopyCropRectByBiz;

    @SerializedName("replace_webview_when_display")
    private boolean replaceWebview;

    public BlankScreenConfig() {
        this(false, false, 0, 0, 0.0f, false, false, 0, false, 0, false, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlankScreenConfig copy$default(BlankScreenConfig r110, boolean r111, boolean r112, long r113, long r210, float r211, boolean r212, boolean r213, int r214, boolean r215, int r216, boolean r217, Map r218, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        boolean r100 = r110.enableDetection;
    L7:
        if ((r310 & 2) == 0) goto L9;
        boolean r101 = r110.enableDetectionWhenAppear;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = r110.minCheckInterval;
    L15:
        if ((r310 & 8) == 0) goto L17;
        long r103 = r110.minCheckIntervalWhenAppear;
    L19:
        if ((r310 & 16) == 0) goto L21;
        float r104 = r110.blankThreshold;
    L23:
        if ((r310 & 32) == 0) goto L25;
        boolean r105 = r110.replaceWebview;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r114 = r110.dropOnFastEntry;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r115 = r110.checkEnterTimeWindow;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r116 = r110.enableNearBlankPixelNormalize;
    L39:
        if ((r310 & 512) == 0) goto L41;
        int r117 = r110.nearBlankPixelColorThreshold;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        boolean r118 = r110.enablePixelCopyBlankCapture;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Map r106 = r110.pixelCopyCropRectByBiz;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r118, r106);
    L49:
        r106 = r218;
        goto L51
    L45:
        r118 = r217;
        goto L47
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final boolean component1() {
        return this.enableDetection;
    }

    public final int component10() {
        return this.nearBlankPixelColorThreshold;
    }

    public final boolean component11() {
        return this.enablePixelCopyBlankCapture;
    }

    public final Map<String, PixelCopyCropRectConfig> component12() {
        return this.pixelCopyCropRectByBiz;
    }

    public final boolean component2() {
        return this.enableDetectionWhenAppear;
    }

    public final long component3() {
        return this.minCheckInterval;
    }

    public final long component4() {
        return this.minCheckIntervalWhenAppear;
    }

    public final float component5() {
        return this.blankThreshold;
    }

    public final boolean component6() {
        return this.replaceWebview;
    }

    public final boolean component7() {
        return this.dropOnFastEntry;
    }

    public final int component8() {
        return this.checkEnterTimeWindow;
    }

    public final boolean component9() {
        return this.enableNearBlankPixelNormalize;
    }

    public final BlankScreenConfig copy(boolean r110, boolean r111, long r112, long r210, float r211, boolean r212, boolean r213, int r214, boolean r215, int r216, boolean r217, Map<String, PixelCopyCropRectConfig> r310) {
        return new BlankScreenConfig(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r310);
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
        if (this.enableDetectionWhenAppear == r101.enableDetectionWhenAppear) goto L15;
        return false;
    L15:
        if (this.minCheckInterval == r101.minCheckInterval) goto L18;
        return false;
    L18:
        if (this.minCheckIntervalWhenAppear == r101.minCheckIntervalWhenAppear) goto L21;
        return false;
    L21:
        if (Float.compare(this.blankThreshold, r101.blankThreshold) == 0) goto L24;
        return false;
    L24:
        if (this.replaceWebview == r101.replaceWebview) goto L27;
        return false;
    L27:
        if (this.dropOnFastEntry == r101.dropOnFastEntry) goto L30;
        return false;
    L30:
        if (this.checkEnterTimeWindow == r101.checkEnterTimeWindow) goto L33;
        return false;
    L33:
        if (this.enableNearBlankPixelNormalize == r101.enableNearBlankPixelNormalize) goto L36;
        return false;
    L36:
        if (this.nearBlankPixelColorThreshold == r101.nearBlankPixelColorThreshold) goto L39;
        return false;
    L39:
        if (this.enablePixelCopyBlankCapture == r101.enablePixelCopyBlankCapture) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.pixelCopyCropRectByBiz, r101.pixelCopyCropRectByBiz) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableDetection == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableDetectionWhenAppear == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.minCheckInterval;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.minCheckIntervalWhenAppear;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + Float.floatToIntBits(this.blankThreshold)) * 31;
        if (this.replaceWebview == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        if (this.dropOnFastEntry == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((r110 + r111) * 31) + this.checkEnterTimeWindow) * 31;
        if (this.enableNearBlankPixelNormalize == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (((r112 + r113) * 31) + this.nearBlankPixelColorThreshold) * 31;
        if (this.enablePixelCopyBlankCapture == true) goto L26;
        r100 = 1237;
    L26:
        int r115 = (r114 + r100) * 31;
        Map<String, PixelCopyCropRectConfig> r116 = this.pixelCopyCropRectByBiz;
        if (r116 != null) goto L29;
        int r117 = 0;
    L31:
        return r115 + r117;
    L29:
        r117 = r116.hashCode();
        goto L31
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "BlankScreenConfig(enableDetection=" + this.enableDetection + ", enableDetectionWhenAppear=" + this.enableDetectionWhenAppear + ", minCheckInterval=" + this.minCheckInterval + ", minCheckIntervalWhenAppear=" + this.minCheckIntervalWhenAppear + ", blankThreshold=" + this.blankThreshold + ", replaceWebview=" + this.replaceWebview + ", dropOnFastEntry=" + this.dropOnFastEntry + ", checkEnterTimeWindow=" + this.checkEnterTimeWindow + ", enableNearBlankPixelNormalize=" + this.enableNearBlankPixelNormalize + ", nearBlankPixelColorThreshold=" + this.nearBlankPixelColorThreshold + ", enablePixelCopyBlankCapture=" + this.enablePixelCopyBlankCapture + ", pixelCopyCropRectByBiz=" + this.pixelCopyCropRectByBiz + ')';
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

    public final boolean getEnableDetectionWhenAppear() {
        return this.enableDetectionWhenAppear;
    }

    public final boolean getEnableNearBlankPixelNormalize() {
        return this.enableNearBlankPixelNormalize;
    }

    public final boolean getEnablePixelCopyBlankCapture() {
        return this.enablePixelCopyBlankCapture;
    }

    public final long getMinCheckInterval() {
        return this.minCheckInterval;
    }

    public final long getMinCheckIntervalWhenAppear() {
        return this.minCheckIntervalWhenAppear;
    }

    public final int getNearBlankPixelColorThreshold() {
        return this.nearBlankPixelColorThreshold;
    }

    public final Map<String, PixelCopyCropRectConfig> getPixelCopyCropRectByBiz() {
        return this.pixelCopyCropRectByBiz;
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

    public final void setEnableDetectionWhenAppear(boolean r100) {
        this.enableDetectionWhenAppear = r100;
    }

    public final void setEnableNearBlankPixelNormalize(boolean r100) {
        this.enableNearBlankPixelNormalize = r100;
    }

    public final void setEnablePixelCopyBlankCapture(boolean r100) {
        this.enablePixelCopyBlankCapture = r100;
    }

    public final void setMinCheckInterval(long r100) {
        this.minCheckInterval = r100;
    }

    public final void setMinCheckIntervalWhenAppear(long r100) {
        this.minCheckIntervalWhenAppear = r100;
    }

    public final void setNearBlankPixelColorThreshold(int r100) {
        this.nearBlankPixelColorThreshold = r100;
    }

    public final void setPixelCopyCropRectByBiz(Map<String, PixelCopyCropRectConfig> r100) {
        this.pixelCopyCropRectByBiz = r100;
    }

    public final void setReplaceWebview(boolean r100) {
        this.replaceWebview = r100;
    }

    public BlankScreenConfig(boolean r100, boolean r101, long r102, long r103, float r104, boolean r105, boolean r106, int r110, boolean r111, int r112, boolean r113, Map<String, PixelCopyCropRectConfig> r114) {
        this.enableDetection = r100;
        this.enableDetectionWhenAppear = r101;
        this.minCheckInterval = r102;
        this.minCheckIntervalWhenAppear = r103;
        this.blankThreshold = r104;
        this.replaceWebview = r105;
        this.dropOnFastEntry = r106;
        this.checkEnterTimeWindow = r110;
        this.enableNearBlankPixelNormalize = r111;
        this.nearBlankPixelColorThreshold = r112;
        this.enablePixelCopyBlankCapture = r113;
        this.pixelCopyCropRectByBiz = r114;
    }

    public /* synthetic */ BlankScreenConfig(boolean r110, boolean r111, long r112, long r210, float r211, boolean r212, boolean r213, int r214, boolean r215, int r216, boolean r217, Map r218, int r310, DefaultConstructorMarker r311) {
        boolean r100 = false;
        if ((r310 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r310 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r103 = 2;
    L15:
        if ((r310 & 8) == 0) goto L17;
        long r104 = 3;
    L19:
        if ((r310 & 16) == 0) goto L21;
        float r105 = 0.99f;
    L23:
        if ((r310 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r113 = false;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r114 = 30;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r115 = false;
    L39:
        if ((r310 & 512) == 0) goto L41;
        int r116 = 15;
    L43:
        if ((r310 & 1024) != 0) goto L47;
        r100 = r217;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Map r107 = null;
    L50:
        this(r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r100, r107);
        return;
    L49:
        r107 = r218;
        goto L50
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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
