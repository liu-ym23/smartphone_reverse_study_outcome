package com.obric.assistant.upload.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJz\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\"\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\"\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001e¨\u0006:"}, d2 = {"Lcom/obric/assistant/upload/internal/TraceData;", "", "uploadResult", "", "uploadFailedCode", "", "uploadFailedMsg", "timeUpload", "", "timeCost", "imageCompressScene", "imageCompressId", "imageSize", "imageCompressSize", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getUploadResult", "()Ljava/lang/Boolean;", "setUploadResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUploadFailedCode", "()Ljava/lang/String;", "setUploadFailedCode", "(Ljava/lang/String;)V", "getUploadFailedMsg", "setUploadFailedMsg", "getTimeUpload", "()Ljava/lang/Long;", "setTimeUpload", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTimeCost", "setTimeCost", "getImageCompressScene", "setImageCompressScene", "getImageCompressId", "setImageCompressId", "getImageSize", "setImageSize", "getImageCompressSize", "setImageCompressSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/assistant/upload/internal/TraceData;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("image_compress_id")
    private String imageCompressId;

    @SerializedName("image_compress_scene")
    private String imageCompressScene;

    @SerializedName("image_compress_size")
    private Long imageCompressSize;

    @SerializedName("image_size")
    private Long imageSize;

    @SerializedName("time_cost")
    private Long timeCost;

    @SerializedName("time_upload")
    private Long timeUpload;

    @SerializedName("upload_failed_code")
    private String uploadFailedCode;

    @SerializedName("upload_failed_msg")
    private String uploadFailedMsg;

    @SerializedName("upload_result")
    private Boolean uploadResult;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.uploadResult, r101.uploadResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadFailedCode, r101.uploadFailedCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadFailedMsg, r101.uploadFailedMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timeUpload, r101.timeUpload) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timeCost, r101.timeCost) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageCompressScene, r101.imageCompressScene) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageCompressId, r101.imageCompressId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.imageSize, r101.imageSize) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageCompressSize, r101.imageCompressSize) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.uploadResult;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uploadFailedCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uploadFailedMsg;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.timeUpload;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.timeCost;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.imageCompressScene;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.imageCompressId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.imageSize;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.imageCompressSize;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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

    public final String toString() {
        return "TraceData(uploadResult=" + this.uploadResult + ", uploadFailedCode=" + this.uploadFailedCode + ", uploadFailedMsg=" + this.uploadFailedMsg + ", timeUpload=" + this.timeUpload + ", timeCost=" + this.timeCost + ", imageCompressScene=" + this.imageCompressScene + ", imageCompressId=" + this.imageCompressId + ", imageSize=" + this.imageSize + ", imageCompressSize=" + this.imageCompressSize + ')';
    }

    public l(int r100) {
        this.uploadResult = null;
        this.uploadFailedCode = null;
        this.uploadFailedMsg = null;
        this.timeUpload = null;
        this.timeCost = null;
        this.imageCompressScene = null;
        this.imageCompressId = null;
        this.imageSize = null;
        this.imageCompressSize = null;
    }

    public final void a(String r100) {
        this.imageCompressId = r100;
    }

    public final void b(String r100) {
        this.imageCompressScene = r100;
    }

    public final void c(Long r100) {
        this.imageCompressSize = r100;
    }

    public final void d(Long r100) {
        this.imageSize = r100;
    }

    public final void e(Long r100) {
        this.timeCost = r100;
    }

    public final void f(Long r100) {
        this.timeUpload = r100;
    }

    public final void g(String r100) {
        this.uploadFailedCode = r100;
    }

    public final void h(String r100) {
        this.uploadFailedMsg = r100;
    }

    public final void i(Boolean r100) {
        this.uploadResult = r100;
    }
}
