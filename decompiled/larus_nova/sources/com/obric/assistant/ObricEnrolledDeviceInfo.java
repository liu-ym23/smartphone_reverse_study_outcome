package com.obric.assistant;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/ObricEnrolledDeviceInfo;", "", "macId", "", "deviceName", "blueDeviceType", "", "blueProductId", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getMacId", "()Ljava/lang/String;", "getDeviceName", "getBlueDeviceType", "()I", "getBlueProductId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrolledDeviceInfo {
    private final int blueDeviceType;
    private final int blueProductId;
    private final String deviceName;
    private final String macId;

    public static /* synthetic */ ObricEnrolledDeviceInfo copy$default(ObricEnrolledDeviceInfo r100, String r101, String r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.macId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.deviceName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.blueDeviceType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.blueProductId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.macId;
    }

    public final String component2() {
        return this.deviceName;
    }

    public final int component3() {
        return this.blueDeviceType;
    }

    public final int component4() {
        return this.blueProductId;
    }

    public final ObricEnrolledDeviceInfo copy(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "macId");
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        return new ObricEnrolledDeviceInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricEnrolledDeviceInfo) == true) goto L8;
        return false;
    L8:
        ObricEnrolledDeviceInfo r101 = (ObricEnrolledDeviceInfo) r100;
        if (Intrinsics.areEqual(this.macId, r101.macId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceName, r101.deviceName) == true) goto L15;
        return false;
    L15:
        if (this.blueDeviceType == r101.blueDeviceType) goto L18;
        return false;
    L18:
        if (this.blueProductId == r101.blueProductId) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.macId.hashCode() * 31) + this.deviceName.hashCode()) * 31) + this.blueDeviceType) * 31) + this.blueProductId;
    }

    public String toString() {
        return "ObricEnrolledDeviceInfo(macId=" + this.macId + ", deviceName=" + this.deviceName + ", blueDeviceType=" + this.blueDeviceType + ", blueProductId=" + this.blueProductId + ')';
    }

    public final int getBlueDeviceType() {
        return this.blueDeviceType;
    }

    public final int getBlueProductId() {
        return this.blueProductId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getMacId() {
        return this.macId;
    }

    public ObricEnrolledDeviceInfo(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "macId");
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        this.macId = r100;
        this.deviceName = r101;
        this.blueDeviceType = r102;
        this.blueProductId = r103;
    }

    public /* synthetic */ ObricEnrolledDeviceInfo(String r100, String r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = 0;
    L8:
        this(r100, r101, r102, r103);
    }
}
