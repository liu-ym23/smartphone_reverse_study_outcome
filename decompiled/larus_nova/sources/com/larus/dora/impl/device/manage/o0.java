package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f333897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f333898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f333899f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f333894a, r101.f333894a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333895b, r101.f333895b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333896c, r101.f333896c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333897d, r101.f333897d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f333898e, r101.f333898e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f333899f, r101.f333899f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f333894a.hashCode() * 31) + this.f333895b.hashCode()) * 31) + this.f333896c.hashCode()) * 31) + this.f333897d.hashCode()) * 31) + this.f333898e.hashCode()) * 31) + this.f333899f.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementHealthItem(id=" + this.f333894a + ", title=" + this.f333895b + ", betaText=" + this.f333896c + ", description=" + this.f333897d + ", actionText=" + this.f333898e + ", url=" + this.f333899f + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333894a;
    }

    public o0(String r100) {
        int r101 = com.larus.utils.j0.f375426a;
        String r102 = com.larus.utils.j0.d(R.string.larus_dora_g_device_health_title_cn);
        String r103 = com.larus.utils.j0.d(R.string.larus_dora_g_device_health_beta_cn);
        String r104 = com.larus.utils.j0.d(R.string.larus_dora_ai_active_health_card_desc_cn);
        String r105 = com.larus.utils.j0.d(R.string.larus_dora_g_device_more_option_cn);
        Intrinsics.checkNotNullParameter("DoraGDeviceManagementHealthItem", "id");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "betaText");
        Intrinsics.checkNotNullParameter(r104, "description");
        Intrinsics.checkNotNullParameter(r105, "actionText");
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f333894a = "DoraGDeviceManagementHealthItem";
        this.f333895b = r102;
        this.f333896c = r103;
        this.f333897d = r104;
        this.f333898e = r105;
        this.f333899f = r100;
    }
}
