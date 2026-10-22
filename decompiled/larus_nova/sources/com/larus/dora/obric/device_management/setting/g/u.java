package com.larus.dora.obric.device_management.setting.g;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f340612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f340613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f340614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f340615d;

    public u() {
        boolean r100 = false;
        this(r100, r100, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f340612a == r101.f340612a) goto L12;
        return false;
    L12:
        if (this.f340613b == r101.f340613b) goto L15;
        return false;
    L15:
        if (this.f340614c == r101.f340614c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f340615d, r101.f340615d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f340612a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f340613b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f340614c == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        String r106 = this.f340615d;
        if (r106 != null) goto L17;
        int r107 = 0;
    L19:
        return r105 + r107;
    L17:
        r107 = r106.hashCode();
        goto L19
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricGSettingsUiState(isDeviceConnected=" + this.f340612a + ", isReconnecting=" + this.f340613b + ", showDeviceInfoRedDot=" + this.f340614c + ", envObserveStatusText=" + this.f340615d + ')';
    }

    public /* synthetic */ u(boolean r100, boolean r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, false, r101, r102);
    }

    public u(boolean r100, boolean r101, boolean r102, String r103) {
        this.f340612a = r100;
        this.f340613b = r101;
        this.f340614c = r102;
        this.f340615d = r103;
    }

    public static u a(u r100, boolean r101, boolean r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        boolean r105 = r100.f340612a;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r101 = r100.f340613b;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = r100.f340614c;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = r100.f340615d;
    L15:
        r100.getClass();
        return new u(r105, r101, r102, r103);
    L5:
        r105 = false;
        goto L7
    }
}
