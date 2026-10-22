package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/platform/model/camera/CameraSettings;", "", "support1080p", "", "asyncDestroyRecorder", "firstStopPreview", "asyncStopPreview", "asyncCloseCapture", "veLogLevel", "isStartCameraSync", "", "<init>", "(IIIIIIZ)V", "getSupport1080p", "()I", "getAsyncDestroyRecorder", "getFirstStopPreview", "getAsyncStopPreview", "getAsyncCloseCapture", "getVeLogLevel", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSettings {
    public static final a Companion = null;
    private static final CameraSettings default_in_api_26_or_27 = null;
    private static final CameraSettings default_normal = null;

    @SerializedName("async_close_capture")
    private final int asyncCloseCapture;

    @SerializedName("async_destroy_recorder")
    private final int asyncDestroyRecorder;

    @SerializedName("async_stop_preview")
    private final int asyncStopPreview;

    @SerializedName("first_stop_preview")
    private final int firstStopPreview;

    @SerializedName("is_start_camera_sync")
    private final boolean isStartCameraSync;

    @SerializedName("support_1080p")
    private final int support1080p;

    @SerializedName("ve_log_level")
    private final int veLogLevel;

    public static final class a {
        public a() {
        }
    }

    public CameraSettings() {
        this(0, 0, 0, 0, 0, 0, false, 127, null);
    }

    public static /* synthetic */ CameraSettings copy$default(CameraSettings r100, int r101, int r102, int r103, int r104, int r110, int r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.support1080p;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.asyncDestroyRecorder;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.firstStopPreview;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.asyncStopPreview;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.asyncCloseCapture;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.veLogLevel;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.isStartCameraSync;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.support1080p;
    }

    public final int component2() {
        return this.asyncDestroyRecorder;
    }

    public final int component3() {
        return this.firstStopPreview;
    }

    public final int component4() {
        return this.asyncStopPreview;
    }

    public final int component5() {
        return this.asyncCloseCapture;
    }

    public final int component6() {
        return this.veLogLevel;
    }

    public final boolean component7() {
        return this.isStartCameraSync;
    }

    public final CameraSettings copy(int r110, int r111, int r112, int r113, int r114, int r115, boolean r116) {
        return new CameraSettings(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraSettings) == true) goto L8;
        return false;
    L8:
        CameraSettings r101 = (CameraSettings) r100;
        if (this.support1080p == r101.support1080p) goto L12;
        return false;
    L12:
        if (this.asyncDestroyRecorder == r101.asyncDestroyRecorder) goto L15;
        return false;
    L15:
        if (this.firstStopPreview == r101.firstStopPreview) goto L18;
        return false;
    L18:
        if (this.asyncStopPreview == r101.asyncStopPreview) goto L21;
        return false;
    L21:
        if (this.asyncCloseCapture == r101.asyncCloseCapture) goto L24;
        return false;
    L24:
        if (this.veLogLevel == r101.veLogLevel) goto L27;
        return false;
    L27:
        if (this.isStartCameraSync == r101.isStartCameraSync) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.support1080p * 31) + this.asyncDestroyRecorder) * 31) + this.firstStopPreview) * 31) + this.asyncStopPreview) * 31) + this.asyncCloseCapture) * 31) + this.veLogLevel) * 31;
        if (this.isStartCameraSync == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "CameraSettings(support1080p=" + this.support1080p + ", asyncDestroyRecorder=" + this.asyncDestroyRecorder + ", firstStopPreview=" + this.firstStopPreview + ", asyncStopPreview=" + this.asyncStopPreview + ", asyncCloseCapture=" + this.asyncCloseCapture + ", veLogLevel=" + this.veLogLevel + ", isStartCameraSync=" + this.isStartCameraSync + ')';
    }

    static {
        Companion = new a();
        default_normal = new CameraSettings(0, 0, 0, 0, 0, 0, false, 127, null);
        default_in_api_26_or_27 = new CameraSettings(0, 1, 0, 0, 0, 0, false, 125, null);
    }

    public static final /* synthetic */ CameraSettings access$getDefault_in_api_26_or_27$cp() {
        return default_in_api_26_or_27;
    }

    public static final /* synthetic */ CameraSettings access$getDefault_normal$cp() {
        return default_normal;
    }

    public final int getAsyncCloseCapture() {
        return this.asyncCloseCapture;
    }

    public final int getAsyncDestroyRecorder() {
        return this.asyncDestroyRecorder;
    }

    public final int getAsyncStopPreview() {
        return this.asyncStopPreview;
    }

    public final int getFirstStopPreview() {
        return this.firstStopPreview;
    }

    public final int getSupport1080p() {
        return this.support1080p;
    }

    public final int getVeLogLevel() {
        return this.veLogLevel;
    }

    public final boolean isStartCameraSync() {
        return this.isStartCameraSync;
    }

    public CameraSettings(int r100, int r101, int r102, int r103, int r104, int r105, boolean r106) {
        this.support1080p = r100;
        this.asyncDestroyRecorder = r101;
        this.firstStopPreview = r102;
        this.asyncStopPreview = r103;
        this.asyncCloseCapture = r104;
        this.veLogLevel = r105;
        this.isStartCameraSync = r106;
    }

    public /* synthetic */ CameraSettings(int r100, int r101, int r102, int r103, int r110, int r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        int r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        int r115 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r106 = 1;
    L15:
        if ((r113 & 8) != 0) goto L19;
        r104 = r103;
    L19:
        if ((r113 & 16) == 0) goto L21;
        int r107 = 1;
    L23:
        if ((r113 & 32) == 0) goto L25;
        int r108 = 2;
    L27:
        if ((r113 & 64) == 0) goto L29;
        boolean r116 = true;
    L30:
        this(r115, r105, r106, r104, r107, r108, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L25:
        r108 = r111;
        goto L27
    L21:
        r107 = r110;
        goto L23
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
