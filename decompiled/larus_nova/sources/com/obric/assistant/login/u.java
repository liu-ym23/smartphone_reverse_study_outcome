package com.obric.assistant.login;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f390269d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile u f390270e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f390271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.assistant.login.a f390272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricLoginType f390273c;

    public static final class a {
        public a() {
        }

        public static g b() {
            Object r100 = null;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
            OAccount.f396900a.getClass();     // Catch: Throwable -> L16
            OAccount.c(true);     // Catch: Throwable -> L16
            com.obric.matrix.platform.sdk.ones.account.g r102 = OAccount.f396903d;     // Catch: Throwable -> L16
            if (r102 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");     // Catch: Throwable -> L16
            r102 = null;
        L6:
            monitor-enter(r102);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L8:
            if (com.obric.matrix.platform.sdk.ones.account.g.f396942d != null) goto L10;
            r102.f();     // Catch: Throwable -> L13
        L10:
            com.obric.matrix.platform.sdk.ones.account.a r103 = com.obric.matrix.platform.sdk.ones.account.g.f396942d;     // Catch: Throwable -> L13
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L13
            monitor-exit(r102);     // Catch: Throwable -> L16
            Object r104 = Result.m9449constructorimpl(r103.f396910c);     // Catch: Throwable -> L16
        L18:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 == null) goto L22;
            FLogger.f375446a.e("ObricLoginContext", "get OAccount.accountInfo failed: " + r105, r105);
        L22:
            if (Result.m9455isFailureimpl(r104) == true) goto L26;
            r100 = r104;
        L26:
            return new g(com.obric.assistant.onelogin.c0.d(), (String) r100);
        L16:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L18
        }

        public static u a() {
            g r100 = b();
            ILoginService r101 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            boolean r102 = false;
            if (r101 == null) goto L7;
            q38.a r103 = r101.getAccountInfo();
            if (r103 == null) goto L7;
            com.obric.assistant.login.a r104 = new com.obric.assistant.login.a(r103.f531528a, r103.f531531d, r103.f531534g);
        L8:
            u r105 = u.f390270e;
            ObricLoginType.Companion.getClass();
            ILoginService r106 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (r106 == null) goto L11;
            q38.a r107 = r106.getAccountInfo();
        L12:
            if (r107 != null) goto L14;
        L16:
            if (r102 == true) goto L19;
            ObricLoginType r108 = ObricLoginType.NONE;
        L22:
            r105.getClass();
            Intrinsics.checkNotNullParameter(r100, "oAccount");
            Intrinsics.checkNotNullParameter(r104, "assistantAccount");
            Intrinsics.checkNotNullParameter(r108, "loginType");
            u r109 = new u(r100, r104, r108);
            u.f390270e = r109;
            return r109;
        L19:
            if (r107.f531534g == false) goto L21;
            r108 = ObricLoginType.LARK_ENTERPRISE;
            goto L22
        L21:
            r108 = ObricLoginType.O_SYSTEM_ONE_LOGIN;
            goto L22
        L14:
            if (r107.f531528a != true) goto L16;
            r102 = true;
            goto L16
        L11:
            r107 = null;
        L7:
            r104 = new com.obric.assistant.login.a(0);
            goto L8
        }
    }

    public u() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f390271a, r101.f390271a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390272b, r101.f390272b) == true) goto L15;
        return false;
    L15:
        if (this.f390273c == r101.f390273c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f390271a.hashCode() * 31) + this.f390272b.hashCode()) * 31) + this.f390273c.hashCode();
    }

    public final String toString() {
        return "ObricLoginContext(oAccount=" + this.f390271a + ", assistantAccount=" + this.f390272b + ", loginType=" + this.f390273c + ')';
    }

    static {
        f390269d = new a();
        f390270e = new u(0);
    }

    public /* synthetic */ u(int r100) {
        this(new g(0), new com.obric.assistant.login.a(0), ObricLoginType.NONE);
    }

    public u(g r100, com.obric.assistant.login.a r101, ObricLoginType r102) {
        Intrinsics.checkNotNullParameter(r100, "oAccount");
        Intrinsics.checkNotNullParameter(r101, "assistantAccount");
        Intrinsics.checkNotNullParameter(r102, "loginType");
        this.f390271a = r100;
        this.f390272b = r101;
        this.f390273c = r102;
    }
}
