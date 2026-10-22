package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f333913d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f333910a, r101.f333910a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333911b, r101.f333911b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333912c, r101.f333912c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333913d, r101.f333913d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f333910a.hashCode() * 31) + this.f333911b.hashCode()) * 31) + this.f333912c.hashCode()) * 31) + this.f333913d.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementMoreFeaturesItem(id=" + this.f333910a + ", title=" + this.f333911b + ", subtitle=" + this.f333912c + ", iconResourceName=" + this.f333913d + ')';
    }

    public s0() {
        int r100 = com.larus.utils.j0.f375426a;
        String r101 = com.larus.utils.j0.d(R.string.larus_dora_g_device_more_play_cn);
        String r102 = com.larus.utils.j0.d(R.string.larus_dora_g_device_intro_function_cn);
        Intrinsics.checkNotNullParameter("DoraGDeviceManagementMoreFeaturesItem", "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        Intrinsics.checkNotNullParameter("larus_dora_g_device_management_more_features_icon", "iconResourceName");
        this.f333910a = "DoraGDeviceManagementMoreFeaturesItem";
        this.f333911b = r101;
        this.f333912c = r102;
        this.f333913d = "larus_dora_g_device_management_more_features_icon";
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333910a;
    }
}
