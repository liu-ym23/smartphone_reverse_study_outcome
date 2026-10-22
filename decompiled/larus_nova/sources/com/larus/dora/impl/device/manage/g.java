package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f333770d;

    public g() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f333767a, r101.f333767a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333768b, r101.f333768b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333769c, r101.f333769c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333770d, r101.f333770d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f333767a.hashCode() * 31) + this.f333768b.hashCode()) * 31) + this.f333769c.hashCode()) * 31) + this.f333770d.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementFirmwareUpdateItem(id=" + this.f333767a + ", title=" + this.f333768b + ", subtitle=" + this.f333769c + ", buttonText=" + this.f333770d + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333767a;
    }

    public g(String r100, int r101) {
        String r102 = null;
        if ((r101 & 1) == 0) goto L5;
        String r103 = "DoraGDeviceManagementFirmwareUpdateItem";
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r104 = com.larus.utils.j0.f375426a;
        String r105 = com.larus.utils.j0.d(R.string.larus_dora_g_firmware_new_version_tip_cn);
    L11:
        if ((r101 & 4) == 0) goto L14;
        r100 = "";
    L14:
        if ((r101 & 8) == 0) goto L16;
        int r106 = com.larus.utils.j0.f375426a;
        r102 = com.larus.utils.j0.d(R.string.larus_dora_g_update_btn_cn);
    L16:
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r100, "subtitle");
        Intrinsics.checkNotNullParameter(r102, "buttonText");
        this.f333767a = r103;
        this.f333768b = r105;
        this.f333769c = r100;
        this.f333770d = r102;
        return;
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L7
    }
}
