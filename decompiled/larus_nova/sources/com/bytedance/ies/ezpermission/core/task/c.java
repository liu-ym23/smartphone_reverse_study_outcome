package com.bytedance.ies.ezpermission.core.task;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.ies.ezpermission.core.permissions.a> f248589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<List<com.bytedance.ies.ezpermission.core.permissions.a>> f248590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<m46.c> f248591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.ies.ezpermission.core.permissions.a> f248592d;

    public c() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f248589a, r101.f248589a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f248590b, r101.f248590b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f248591c, r101.f248591c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f248592d, r101.f248592d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.ies.ezpermission.core.permissions.a> r100 = this.f248589a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r104 = this.f248590b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<m46.c> r107 = this.f248591c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<com.bytedance.ies.ezpermission.core.permissions.a> r110 = this.f248592d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PermissionState(grantedPermissions=" + this.f248589a + ", normalPermissions=" + this.f248590b + ", specialPermissions=" + this.f248591c + ", skipPermissions=" + this.f248592d + ")";
    }

    public c(List r100, List r101, int r102) {
        ArrayList r103 = null;
        if ((r102 & 1) == 0) goto L5;
        ArrayList r104 = new ArrayList();
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = new ArrayList();
    L10:
        if ((r102 & 4) == 0) goto L13;
        r101 = new ArrayList();
    L13:
        if ((r102 & 8) == 0) goto L15;
        r103 = new ArrayList();
    L15:
        Intrinsics.checkNotNullParameter(r104, "grantedPermissions");
        Intrinsics.checkNotNullParameter(r100, "normalPermissions");
        Intrinsics.checkNotNullParameter(r101, "specialPermissions");
        Intrinsics.checkNotNullParameter(r103, "skipPermissions");
        this.f248589a = r104;
        this.f248590b = r100;
        this.f248591c = r101;
        this.f248592d = r103;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
