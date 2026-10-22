package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f345364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f345365b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f345364a, r101.f345364a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345365b, r101.f345365b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f345364a.hashCode() * 31) + this.f345365b.hashCode();
    }

    public final String toString() {
        return "SideBarDeviceItem(deviceId=" + this.f345364a + ", displayName=" + this.f345365b + ')';
    }

    public n0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        this.f345364a = r100;
        this.f345365b = r101;
    }
}
