package com.bytedance.lark.base.open.pkm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7231c;
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
        if (Intrinsics.areEqual(this.f7229a, r9.f7229a) == true) goto L12;
        return false;
    L12:
        if (this.f7230b == r9.f7230b) goto L15;
        return false;
    L15:
        if (this.f7231c == r9.f7231c) goto L18;
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
        int r0 = this.f7229a.hashCode() * 31;
        long r1 = this.f7230b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f7231c) * 31;
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
        return "InvokeHookInfo(moduleName=" + this.f7229a + ", libraryId=" + this.f7230b + ", libId=" + this.f7231c + ", instance=" + this.d + ", methodName=" + this.e + ')';
    }

    public e(Long r3, String r4) {
        Intrinsics.checkNotNullParameter("open_pkm", "moduleName");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        this.f7229a = "open_pkm";
        this.f7230b = -1289516615139540930L;
        this.f7231c = 2124726334;
        this.d = r3;
        this.e = r4;
    }
}
