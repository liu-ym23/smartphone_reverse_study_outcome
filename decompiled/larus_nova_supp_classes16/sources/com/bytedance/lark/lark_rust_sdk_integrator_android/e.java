package com.bytedance.lark.lark_rust_sdk_integrator_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final String a;
    public final long b;
    public final int c;
    public final Long d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31;
        Long r3 = this.d;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.e.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "InvokeHookInfo(moduleName=" + this.a + ", libraryId=" + this.b + ", libId=" + this.c + ", instance=" + this.d + ", methodName=" + this.e + ')';
    }

    public e(Long r3, String r4) {
        Intrinsics.checkNotNullParameter("lark_rust_sdk_integrator", "moduleName");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        this.a = "lark_rust_sdk_integrator";
        this.b = 7244955805902941472L;
        this.c = -2009092832;
        this.d = r3;
        this.e = r4;
    }
}
