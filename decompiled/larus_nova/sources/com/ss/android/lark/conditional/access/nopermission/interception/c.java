package com.ss.android.lark.conditional.access.nopermission.interception;

import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NoPermissionType f418095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InternalSecurityAction f418096b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f418095a == r101.f418095a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f418096b, r101.f418096b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f418095a.hashCode() * 31) + this.f418096b.hashCode();
    }

    public final String toString() {
        return "RestoredInterception(noPermissionType=" + this.f418095a + ", action=" + this.f418096b + ')';
    }

    public c(NoPermissionType r100, InternalSecurityAction r101) {
        Intrinsics.checkNotNullParameter(r100, "noPermissionType");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f418095a = r100;
        this.f418096b = r101;
    }
}
