package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class q0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f333905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f333906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f333907e;

    public q0() {
        this(false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f333903a, r101.f333903a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333904b, r101.f333904b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f333905c, r101.f333905c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f333906d, r101.f333906d) == true) goto L21;
        return false;
    L21:
        if (this.f333907e == r101.f333907e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f333903a.hashCode() * 31) + this.f333904b.hashCode()) * 31) + this.f333905c.hashCode()) * 31) + this.f333906d.hashCode()) * 31;
        if (this.f333907e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGDeviceManagementMediaAlbumItem(id=" + this.f333903a + ", title=" + this.f333904b + ", actionText=" + this.f333905c + ", imageUrls=" + this.f333906d + ", isEmptyState=" + this.f333907e + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333903a;
    }

    public q0(boolean r100, int r101) {
        List<String> r102 = null;
        if ((r101 & 1) == 0) goto L5;
        String r103 = "DoraGDeviceManagementMediaAlbumItem";
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r104 = com.larus.utils.j0.f375426a;
        String r105 = com.larus.utils.j0.d(R.string.larus_dora_album_album_cn);
    L11:
        if ((r101 & 4) == 0) goto L13;
        int r106 = com.larus.utils.j0.f375426a;
        String r107 = com.larus.utils.j0.d(R.string.larus_dora_g_device_more_option_cn);
    L15:
        if ((r101 & 8) == 0) goto L18;
        r102 = CollectionsKt.emptyList();
    L18:
        if ((r101 & 16) == 0) goto L20;
        r100 = false;
    L20:
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r107, "actionText");
        Intrinsics.checkNotNullParameter(r102, "imageUrls");
        this.f333903a = r103;
        this.f333904b = r105;
        this.f333905c = r107;
        this.f333906d = r102;
        this.f333907e = r100;
        return;
    L13:
        r107 = null;
        goto L15
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L7
    }
}
