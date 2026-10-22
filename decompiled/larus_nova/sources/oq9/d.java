package oq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/model/camera/CameraCommonConfig;", "", "terminalDetectionEnable", "", "cameraZoomRatioType", "", "optZoomUiEnable", "<init>", "(ZIZ)V", "getTerminalDetectionEnable", "()Z", "getCameraZoomRatioType", "()I", "getOptZoomUiEnable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("camera_zoom_ratio_type")
    private final int cameraZoomRatioType;

    @SerializedName("opt_zoom_ui_enable")
    private final boolean optZoomUiEnable;

    @SerializedName("terminal_detection_enable")
    private final boolean terminalDetectionEnable;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.terminalDetectionEnable == r101.terminalDetectionEnable) goto L12;
        return false;
    L12:
        if (this.cameraZoomRatioType == r101.cameraZoomRatioType) goto L15;
        return false;
    L15:
        if (this.optZoomUiEnable == r101.optZoomUiEnable) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.terminalDetectionEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.cameraZoomRatioType) * 31;
        if (this.optZoomUiEnable == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraCommonConfig(terminalDetectionEnable=" + this.terminalDetectionEnable + ", cameraZoomRatioType=" + this.cameraZoomRatioType + ", optZoomUiEnable=" + this.optZoomUiEnable + ')';
    }

    public final int a() {
        return this.cameraZoomRatioType;
    }

    public final boolean b() {
        return this.optZoomUiEnable;
    }

    public final boolean c() {
        return this.terminalDetectionEnable;
    }

    public /* synthetic */ d(int r100) {
        this(false, 1, true);
    }

    public d(boolean r100, int r101, boolean r102) {
        this.terminalDetectionEnable = r100;
        this.cameraZoomRatioType = r101;
        this.optZoomUiEnable = r102;
    }
}
