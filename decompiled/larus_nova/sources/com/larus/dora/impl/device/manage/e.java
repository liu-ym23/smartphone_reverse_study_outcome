package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f333738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f333739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f333740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f333741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f333742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f333743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f333744j;

    public e() {
        this(null, null, null, null, null, false, false, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f333735a, r101.f333735a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333736b, r101.f333736b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333737c, r101.f333737c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333738d, r101.f333738d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f333739e, r101.f333739e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f333740f, r101.f333740f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f333741g, r101.f333741g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f333742h, r101.f333742h) == true) goto L33;
        return false;
    L33:
        if (this.f333743i == r101.f333743i) goto L36;
        return false;
    L36:
        if (this.f333744j == r101.f333744j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f333735a.hashCode() * 31) + this.f333736b.hashCode()) * 31;
        String r101 = this.f333737c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f333738d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f333739e.hashCode()) * 31;
        String r108 = this.f333740f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f333741g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f333742h;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        int r115 = (r113 + r102) * 31;
        int r116 = 1231;
        if (this.f333743i == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f333744j == true) goto L31;
        r116 = 1237;
    L31:
        return r118 + r116;
    L25:
        r117 = 1237;
        goto L26
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraGDeviceManagementDocItem(id=" + this.f333735a + ", title=" + this.f333736b + ", subtitle=" + this.f333737c + ", content=" + this.f333738d + ", actionText=" + this.f333739e + ", imageUrl=" + this.f333740f + ", url=" + this.f333741g + ", thumbnail=" + this.f333742h + ", isEmptyState=" + this.f333743i + ", isLoading=" + this.f333744j + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333735a;
    }

    public e(String r100, String r101, String r102, String r103, String r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r104 = "DoraGDeviceManagementDocItem";
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = com.larus.utils.j0.f375426a;
        String r106 = com.larus.utils.j0.d(R.string.larus_dora_gesture_quick_note_cn);
    L11:
        if ((r113 & 4) == 0) goto L14;
        r100 = null;
    L14:
        if ((r113 & 8) == 0) goto L17;
        r101 = null;
    L17:
        if ((r113 & 16) == 0) goto L20;
        int r107 = com.larus.utils.j0.f375426a;
        r102 = com.larus.utils.j0.d(R.string.larus_dora_g_device_more_option_cn);
    L20:
        if ((r113 & 64) == 0) goto L23;
        r103 = null;
    L23:
        if ((r113 & 128) == 0) goto L26;
        r110 = null;
    L26:
        if ((r113 & 256) == 0) goto L29;
        r111 = false;
    L29:
        if ((r113 & 512) == 0) goto L31;
        r112 = false;
    L31:
        Intrinsics.checkNotNullParameter(r104, "id");
        Intrinsics.checkNotNullParameter(r106, "title");
        Intrinsics.checkNotNullParameter(r102, "actionText");
        this.f333735a = r104;
        this.f333736b = r106;
        this.f333737c = r100;
        this.f333738d = r101;
        this.f333739e = r102;
        this.f333740f = null;
        this.f333741g = r103;
        this.f333742h = r110;
        this.f333743i = r111;
        this.f333744j = r112;
        return;
    L9:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L7
    }
}
