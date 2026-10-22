package com.ss.android.lark.search.doubao.api.request;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f439956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CollaboratorPermissionAction> f439957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f439958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f439959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f439960e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f439956a, r101.f439956a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439957b, r101.f439957b) == true) goto L15;
        return false;
    L15:
        if (this.f439958c == r101.f439958c) goto L18;
        return false;
    L18:
        if (this.f439959d == r101.f439959d) goto L21;
        return false;
    L21:
        if (this.f439960e == r101.f439960e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<Integer> r100 = this.f439956a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CollaboratorPermissionAction> r104 = this.f439957b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f439958c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f439959d == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f439960e == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CollaboratorPermissionsDslModel(permissionActionValues=" + this.f439956a + ", permissionActions=" + this.f439957b + ", checkOUPermission=" + this.f439958c + ", checkSecretPermission=" + this.f439959d + ", checkCrossTenantAdminPermission=" + this.f439960e + ')';
    }

    public d(List r100, boolean r101, boolean r102, boolean r103) {
        this.f439956a = r100;
        this.f439957b = null;
        this.f439958c = r101;
        this.f439959d = r102;
        this.f439960e = r103;
    }
}
