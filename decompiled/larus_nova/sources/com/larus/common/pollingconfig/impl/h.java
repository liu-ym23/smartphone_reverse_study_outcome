package com.larus.common.pollingconfig.impl;

import com.dtf.face.config.IConstValues;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009a\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u00068"}, d2 = {"Lcom/larus/common/pollingconfig/impl/UploadMetricsRequest;", "", "scene", "", "version", "", "nextPollingInterval", "", "deviceId", "updateVersionCode", "osVersion", IConstValues.DEVICE_TYPE, "deviceModel", "deviceBrand", "buildChannel", "statusCode", "previousVersion", "<init>", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()I", "getVersion", "()Ljava/lang/String;", "getNextPollingInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeviceId", "getUpdateVersionCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOsVersion", "getDeviceType", "getDeviceModel", "getDeviceBrand", "getBuildChannel", "getStatusCode", "getPreviousVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/larus/common/pollingconfig/impl/UploadMetricsRequest;", "equals", "", "other", "hashCode", "toString", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("channel")
    private final String buildChannel;

    @SerializedName("device_brand")
    private final String deviceBrand;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("device_model")
    private final String deviceModel;

    @SerializedName("device_type")
    private final String deviceType;

    @SerializedName("next_polling_interval")
    private final Long nextPollingInterval;

    @SerializedName("os_version")
    private final Integer osVersion;

    @SerializedName("previous_version")
    private final String previousVersion;

    @SerializedName("polling_scene")
    private final int scene;

    @SerializedName("polling_status_code")
    private final int statusCode;

    @SerializedName("update_version_code")
    private final Integer updateVersionCode;

    @SerializedName("version")
    private final String version;

    public h() {
        this(-1, null, null, null, null, null, null, null, null, null, -1, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nextPollingInterval, r101.nextPollingInterval) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateVersionCode, r101.updateVersionCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.osVersion, r101.osVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.deviceType, r101.deviceType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deviceModel, r101.deviceModel) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.deviceBrand, r101.deviceBrand) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.buildChannel, r101.buildChannel) == true) goto L39;
        return false;
    L39:
        if (this.statusCode == r101.statusCode) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.previousVersion, r101.previousVersion) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.scene * 31;
        String r101 = this.version;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.nextPollingInterval;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.deviceId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.updateVersionCode;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.osVersion;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.deviceType;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.deviceModel;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.deviceBrand;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.buildChannel;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (((r125 + r127) * 31) + this.statusCode) * 31;
        String r129 = this.previousVersion;
        if (r129 == null) goto L43;
        r102 = r129.hashCode();
    L43:
        return r128 + r102;
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadMetricsRequest(scene=" + this.scene + ", version=" + this.version + ", nextPollingInterval=" + this.nextPollingInterval + ", deviceId=" + this.deviceId + ", updateVersionCode=" + this.updateVersionCode + ", osVersion=" + this.osVersion + ", deviceType=" + this.deviceType + ", deviceModel=" + this.deviceModel + ", deviceBrand=" + this.deviceBrand + ", buildChannel=" + this.buildChannel + ", statusCode=" + this.statusCode + ", previousVersion=" + this.previousVersion + ')';
    }

    public h(int r100, String r101, Long r102, String r103, Integer r104, Integer r105, String r106, String r107, String r108, String r110, int r111, String r112) {
        this.scene = r100;
        this.version = r101;
        this.nextPollingInterval = r102;
        this.deviceId = r103;
        this.updateVersionCode = r104;
        this.osVersion = r105;
        this.deviceType = r106;
        this.deviceModel = r107;
        this.deviceBrand = r108;
        this.buildChannel = r110;
        this.statusCode = r111;
        this.previousVersion = r112;
    }
}
