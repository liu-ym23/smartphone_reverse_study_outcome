package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcInitInfo;", "Ljava/io/Serializable;", "serverVendorType", "", "rtcAppId", "", "businessId", "isMediaOversea", "", "isDataOversea", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZZ)V", "getServerVendorType", "()I", "getRtcAppId", "()Ljava/lang/String;", "getBusinessId", "()Z", "getRtcVendorType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcVendorType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRtcInitInfo implements Serializable {

    @SerializedName("businessId")
    private final String businessId;

    @SerializedName("isDataOversea")
    private final boolean isDataOversea;

    @SerializedName("isMediaOversea")
    private final boolean isMediaOversea;

    @SerializedName("rtcAppId")
    private final String rtcAppId;

    @SerializedName("serverVendorType")
    private final int serverVendorType;

    public static /* synthetic */ MmRtcInitInfo copy$default(MmRtcInitInfo r100, int r101, String r102, String r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.serverVendorType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.rtcAppId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.businessId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isMediaOversea;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isDataOversea;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.serverVendorType;
    }

    public final String component2() {
        return this.rtcAppId;
    }

    public final String component3() {
        return this.businessId;
    }

    public final boolean component4() {
        return this.isMediaOversea;
    }

    public final boolean component5() {
        return this.isDataOversea;
    }

    public final MmRtcInitInfo copy(int r100, String r101, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "rtcAppId");
        Intrinsics.checkNotNullParameter(r110, "businessId");
        return new MmRtcInitInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRtcInitInfo) == true) goto L8;
        return false;
    L8:
        MmRtcInitInfo r101 = (MmRtcInitInfo) r100;
        if (this.serverVendorType == r101.serverVendorType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rtcAppId, r101.rtcAppId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.businessId, r101.businessId) == true) goto L18;
        return false;
    L18:
        if (this.isMediaOversea == r101.isMediaOversea) goto L21;
        return false;
    L21:
        if (this.isDataOversea == r101.isDataOversea) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.serverVendorType * 31) + this.rtcAppId.hashCode()) * 31) + this.businessId.hashCode()) * 31;
        int r101 = 1231;
        if (this.isMediaOversea == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isDataOversea == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "MmRtcInitInfo(serverVendorType=" + this.serverVendorType + ", rtcAppId=" + this.rtcAppId + ", businessId=" + this.businessId + ", isMediaOversea=" + this.isMediaOversea + ", isDataOversea=" + this.isDataOversea + ')';
    }

    public final MmRtcVendorType getRtcVendorType() {
        MmServerVendorType.a r100 = MmServerVendorType.Companion;
        int r101 = this.serverVendorType;
        r100.getClass();
        MmServerVendorType[] r102 = MmServerVendorType.values();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L12;
        MmServerVendorType r105 = r102[r104];
        if (r105.getValue() != r101) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L13;
        r104 = r104 + 1;
    L13:
        if (r105 != null) goto L15;
        r105 = MmServerVendorType.UNKNOWN_VENDOR_TYPE;
    L15:
        int r107 = MmServerVendorType.a.C5169a.f434390a[r105.ordinal()];
        if (r107 == 1) goto L31;
        if (r107 == 2) goto L38;
        if (r107 == 3) goto L37;
        if (r107 == 4) goto L36;
        if (r107 == 5) goto L35;
        return MmRtcVendorType.VENDOR_TYPE_RTC;
    L35:
        return MmRtcVendorType.VENDOR_TYPE_TEST;
    L36:
        return MmRtcVendorType.VENDOR_TYPE_TEST_GAUSS;
    L37:
        return MmRtcVendorType.VENDOR_TYPE_TEST_PRE;
    L38:
        return MmRtcVendorType.VENDOR_TYPE_LARKPRERTC;
    L31:
        return MmRtcVendorType.VENDOR_TYPE_LARKRTC;
    L8:
        r106 = false;
        goto L9
    L12:
        r105 = null;
        goto L13
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    public final int getServerVendorType() {
        return this.serverVendorType;
    }

    public final boolean isDataOversea() {
        return this.isDataOversea;
    }

    public final boolean isMediaOversea() {
        return this.isMediaOversea;
    }

    public MmRtcInitInfo(int r100, String r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "rtcAppId");
        Intrinsics.checkNotNullParameter(r102, "businessId");
        this.serverVendorType = r100;
        this.rtcAppId = r101;
        this.businessId = r102;
        this.isMediaOversea = r103;
        this.isDataOversea = r104;
    }

    public /* synthetic */ MmRtcInitInfo(int r100, String r101, String r102, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
