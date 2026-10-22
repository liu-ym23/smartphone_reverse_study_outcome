package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f215261a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f215262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f215263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f215264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f215265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f215266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f215267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f215268g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f215262a, r101.f215262a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f215263b, r101.f215263b) == true) goto L15;
            return false;
        L15:
            if (this.f215264c == r101.f215264c) goto L18;
            return false;
        L18:
            if (this.f215265d == r101.f215265d) goto L21;
            return false;
        L21:
            if (this.f215266e == r101.f215266e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f215267f, r101.f215267f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f215268g, r101.f215268g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f215262a.hashCode() * 31) + this.f215263b.hashCode()) * 31;
            long r101 = this.f215264c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f215265d;
            return ((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f215266e) * 31) + this.f215267f.hashCode()) * 31) + this.f215268g.hashCode();
        }

        public final String toString() {
            return "ClientVarsResource(payload=" + this.f215262a + ", source=" + this.f215263b + ", cacheElapsedTime=" + this.f215264c + ", requestStart=" + this.f215265d + ", apiCode=" + this.f215266e + ", errorMsg=" + this.f215267f + ", xttLogId=" + this.f215268g + ')';
        }

        public a(String r100, String r101, long r102, long r103, int r104, String r105, String r110) {
            Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
            Intrinsics.checkNotNullParameter(r101, "source");
            Intrinsics.checkNotNullParameter(r105, "errorMsg");
            Intrinsics.checkNotNullParameter(r110, "xttLogId");
            this.f215262a = r100;
            this.f215263b = r101;
            this.f215264c = r102;
            this.f215265d = r103;
            this.f215266e = r104;
            this.f215267f = r105;
            this.f215268g = r110;
        }
    }

    static {
        f215261a = new c();
    }

    public c() {
    }

    public static com.bytedance.lark.lark_bitable_android.a b() {
        String r100 = com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f216922f.f216928a;
        Intrinsics.checkNotNull(r100);
        ULong r101 = UStringsKt.toULongOrNull(r100);
        Object r102 = null;
        if (r101 == null) goto L18;
        long r103 = r101.m9675unboximpl();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(new com.bytedance.lark.lark_bitable_android.a(r103));     // Catch: Throwable -> L7
    L9:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L13;
        tt5.a.l("BitableBaseAppPreloadRustBridge", "getContainer failed", r106);
    L13:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r102 = r105;
    L17:
        return (com.bytedance.lark.lark_bitable_android.a) r102;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L18:
        tt5.a.d("BitableBaseAppPreloadRustBridge", "getContainer: userId cannot be parsed to ULong");
        return null;
    }

    public static a a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Object r100 = null;
        if (com.bytedance.ee.bear.bitable.c.e() == true) goto L22;
        return null;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.lark.lark_bitable_android.a r102 = b();     // Catch: Throwable -> L11
        if (r102 != null) goto L9;
        tt5.a.k("BitableBaseAppPreloadRustBridge", "getClientVarsResource skipped: container is null");     // Catch: Throwable -> L11
        return null;
    L9:
        com.bytedance.lark.lark_bitable_android.b r111 = r102.c(r110);     // Catch: Throwable -> L11
        Object r112 = Result.m9449constructorimpl(new a(r111.f252979a, r111.f252980b, r111.f252981c, r111.f252982d, r111.f252983e, r111.f252984f, r111.f252985g));     // Catch: Throwable -> L11
    L13:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r112);
        if (r103 == null) goto L17;
        tt5.a.l("BitableBaseAppPreloadRustBridge", "getClientVarsResource failed", r103);
    L17:
        if (Result.m9455isFailureimpl(r112) == true) goto L21;
        r100 = r112;
    L21:
        return (a) r100;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean c(String r100) {
        if (com.bytedance.ee.bear.bitable.c.e() == false) goto L28;
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L28;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        com.bytedance.lark.lark_bitable_android.a r103 = b();     // Catch: Throwable -> L18
        if (r103 != null) goto L16;
        tt5.a.k("BitableBaseAppPreloadRustBridge", "refreshClientVars skipped: container is null");     // Catch: Throwable -> L18
        return false;
    L16:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103.e(r100)));     // Catch: Throwable -> L18
    L20:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L23;
        tt5.a.l("BitableBaseAppPreloadRustBridge", "refreshClientVars failed", r105);
    L23:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L27;
        r104 = r106;
    L27:
        return ((Boolean) r104).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
    L28:
        return false;
    }
}
