package com.bytedance.ee.bear.bitable.rust;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final c a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final long c;
        public final long d;
        public final int e;
        public final String f;
        public final String g;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.d;
            return ((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public final String toString() {
            return "ClientVarsResource(payload=" + this.a + ", source=" + this.b + ", cacheElapsedTime=" + this.c + ", requestStart=" + this.d + ", apiCode=" + this.e + ", errorMsg=" + this.f + ", xttLogId=" + this.g + ')';
        }

        public a(String r2, String r3, long r4, long r6, int r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r2, "payload");
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r9, "errorMsg");
            Intrinsics.checkNotNullParameter(r10, "xttLogId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r8;
            this.f = r9;
            this.g = r10;
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public static com.bytedance.lark.lark_bitable_android.a b() {
        String r0 = com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f.a;
        Intrinsics.checkNotNull(r0);
        ULong r1 = UStringsKt.toULongOrNull(r0);
        Object r2 = null;
        if (r1 == null) goto L18;
        long r3 = r1.unbox-impl();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(new com.bytedance.lark.lark_bitable_android.a(r3));     // Catch: Throwable -> L7
    L9:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        tt5.a.l("BitableBaseAppPreloadRustBridge", "getContainer failed", r6);
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r2 = r5;
    L17:
        return (com.bytedance.lark.lark_bitable_android.a) r2;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L18:
        tt5.a.d("BitableBaseAppPreloadRustBridge", "getContainer: userId cannot be parsed to ULong");
        return null;
    }

    public static a a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "token");
        Object r2 = null;
        if (com.bytedance.ee.bear.bitable.c.e() == true) goto L22;
        return null;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.lark.lark_bitable_android.a r3 = b();     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        tt5.a.k("BitableBaseAppPreloadRustBridge", "getClientVarsResource skipped: container is null");     // Catch: Throwable -> L11
        return null;
    L9:
        com.bytedance.lark.lark_bitable_android.b r14 = r3.c(r13);     // Catch: Throwable -> L11
        Object r16 = Result.constructor-impl(new a(r14.a, r14.b, r14.c, r14.d, r14.e, r14.f, r14.g));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r16);
        if (r4 == null) goto L17;
        tt5.a.l("BitableBaseAppPreloadRustBridge", "getClientVarsResource failed", r4);
    L17:
        if (Result.isFailure-impl(r16) == true) goto L21;
        r2 = r16;
    L21:
        return (a) r2;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean c(String r3) {
        if (com.bytedance.ee.bear.bitable.c.e() == false) goto L28;
        if (r3 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L28;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        com.bytedance.lark.lark_bitable_android.a r4 = b();     // Catch: Throwable -> L18
        if (r4 != null) goto L16;
        tt5.a.k("BitableBaseAppPreloadRustBridge", "refreshClientVars skipped: container is null");     // Catch: Throwable -> L18
        return false;
    L16:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r4.e(r3)));     // Catch: Throwable -> L18
    L20:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L23;
        tt5.a.l("BitableBaseAppPreloadRustBridge", "refreshClientVars failed", r6);
    L23:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L27;
        r5 = r0;
    L27:
        return ((Boolean) r5).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L6:
        if (r3.length() == 0) goto L9;
        r1 = false;
    L28:
        return false;
    }
}
