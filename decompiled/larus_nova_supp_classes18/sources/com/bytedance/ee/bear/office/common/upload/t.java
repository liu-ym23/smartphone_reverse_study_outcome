package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {
    public final OfficeUploadActionType a;
    public final g0 b;
    public final Function0<Boolean> c;
    public final Function0<Boolean> d;
    public final boolean e;
    public final Function0<Boolean> f;
    public final Function0<PermissionResponse> g;

    public t() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeUploadGuardContext(actionType=" + this.a + ", target=" + this.b + ", ownerReadyProvider=" + this.c + ", networkConnectedProvider=" + this.d + ", menuConfigEnabled=" + this.e + ", parentWritableProvider=" + this.f + ", permissionResponseProvider=" + this.g + ')';
    }

    public t(OfficeUploadActionType r3, g0 r4, Function0 r5, Function0 r6, Function0 r7) {
        OfficeUploadGuardContext$2 r0 = OfficeUploadGuardContext$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r5, "ownerReadyProvider");
        Intrinsics.checkNotNullParameter(r6, "networkConnectedProvider");
        Intrinsics.checkNotNullParameter(r7, "parentWritableProvider");
        Intrinsics.checkNotNullParameter(r0, "permissionResponseProvider");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = true;
        this.f = r7;
        this.g = r0;
    }
}
