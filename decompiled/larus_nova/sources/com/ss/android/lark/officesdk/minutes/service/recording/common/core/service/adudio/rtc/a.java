package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.pb.videochat.Bandwidth;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f434391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRtcInitInfo f434392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bandwidth f434393c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f434391a, r101.f434391a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434392b, r101.f434392b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434393c, r101.f434393c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f434391a.hashCode() * 31) + this.f434392b.hashCode()) * 31;
        Bandwidth r101 = this.f434393c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRtcData(rtcInfo=" + this.f434391a + ", vendorType=" + this.f434392b + ".serverVendorType, rtcAppId=" + this.f434392b + ".rtcAppId, businessId=" + this.f434392b + ".businessId, isMediaOversea=" + this.f434392b + ".isMediaOversea, isDataOversea=" + this.f434392b + ".isDataOversea)";
    }

    public a(b r100, MmRtcInitInfo r101, Bandwidth r102) {
        Intrinsics.checkNotNullParameter(r100, "rtcInfo");
        Intrinsics.checkNotNullParameter(r101, "basicInfo");
        this.f434391a = r100;
        this.f434392b = r101;
        this.f434393c = r102;
    }
}
