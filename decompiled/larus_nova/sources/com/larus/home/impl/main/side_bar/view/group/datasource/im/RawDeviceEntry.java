package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/RawDeviceEntry;", "", "deviceId", "", "deviceName", "appId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getAppId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/RawDeviceEntry;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RawDeviceEntry {

    @SerializedName("app_id")
    private final Long appId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME)
    private final String deviceName;

    public RawDeviceEntry() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RawDeviceEntry copy$default(RawDeviceEntry r100, String r101, String r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.deviceId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.deviceName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.appId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.deviceName;
    }

    public final Long component3() {
        return this.appId;
    }

    public final RawDeviceEntry copy(String r100, String r101, Long r102) {
        return new RawDeviceEntry(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RawDeviceEntry) == true) goto L8;
        return false;
    L8:
        RawDeviceEntry r101 = (RawDeviceEntry) r100;
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceName, r101.deviceName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.deviceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.deviceName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.appId;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RawDeviceEntry(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", appId=" + this.appId + ')';
    }

    public final Long getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public RawDeviceEntry(String r100, String r101, Long r102) {
        this.deviceId = r100;
        this.deviceName = r101;
        this.appId = r102;
    }

    public /* synthetic */ RawDeviceEntry(String r100, String r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
