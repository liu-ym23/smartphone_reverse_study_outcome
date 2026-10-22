package com.larus.dora.obric.device_management.setting.common.name;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339651c;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f339649a, r101.f339649a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339650b, r101.f339650b) == true) goto L15;
        return false;
    L15:
        if (this.f339651c == r101.f339651c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f339649a.hashCode() * 31;
        String r101 = this.f339650b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f339651c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceNameUiState(deviceName=" + this.f339649a + ", macAddress=" + this.f339650b + ", doubleConfirm=" + this.f339651c + ')';
    }

    public /* synthetic */ i(int r100) {
        this("", null, false);
    }

    public i(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "deviceName");
        this.f339649a = r100;
        this.f339650b = r101;
        this.f339651c = r102;
    }
}
