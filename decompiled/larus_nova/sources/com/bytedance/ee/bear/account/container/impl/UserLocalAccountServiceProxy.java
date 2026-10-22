package com.bytedance.ee.bear.account.container.impl;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.contract.config.LoginInfo;
import com.bytedance.ee.bear.contract.h0;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class UserLocalAccountServiceProxy extends c0c.b implements h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f206200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f206201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<h0> f206202d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.contract.b f206203a;

        public b(com.bytedance.ee.bear.contract.b r100) {
            this.f206203a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AccountService$Account r101 = (AccountService$Account) r100;
            com.bytedance.ee.bear.contract.b r102 = this.f206203a;
            if (r102 == null) goto L6;
            r102.a(r101);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f206204a = null;

        static {
            f206204a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            AccountService$Account r101 = (AccountService$Account) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f206205a = null;

        static {
            f206205a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("UserLocalAccountServiceProxy", (Throwable) r100, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.contract.h0
    @Deprecated(message = "Deprecated in Java")
    public final Flowable<Boolean> Be(String r100) {
        return this.f206200b.Be(r100);
    }

    @Override // com.bytedance.ee.bear.contract.h0
    @Deprecated(message = "Deprecated in Java")
    public final Flowable<Boolean> C1(DocDynamicConfig r100) {
        return this.f206200b.C1(r100);
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final AccountService$Account G2() {
        return this.f206200b.G2();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final Flowable<AccountService$Account> T4() {
        return this.f206200b.T4();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final AccountService$Account U5() {
        return this.f206200b.U5();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    @Deprecated(message = "Deprecated in Java")
    public final Flowable<Boolean> e5() {
        return this.f206200b.e5();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final boolean hasLogin() {
        return this.f206200b.hasLogin();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    @Deprecated(message = "Deprecated in Java")
    public final void j9(LoginInfo r100) {
        this.f206200b.j9(r100);
    }

    @Override // com.bytedance.ee.bear.contract.h0
    @Deprecated(message = "Deprecated in Java")
    public final Flowable<Boolean> n4(LoginInfo r100) {
        return this.f206200b.n4(r100);
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final void Pe(final com.bytedance.ee.bear.contract.b r100) {
        this.f206202d.c().T4().doOnNext(new b(r100)).subscribe(c.f206204a, d.f206205a);
        com.ss.android.lark.passportc.convention.b<h0> r101 = this.f206202d;
        if (r100 != null) goto L5;
        Object r102 = "";
    L6:
        r101.a(new com.ss.android.lark.passportc.convention.b.C5239b(com.bytedance.ee.bear.contract.b.class, r102), new com.ss.android.lark.passportc.convention.b.c(new UserLocalAccountServiceProxy$registerChangeCallback$4(r100), new UserLocalAccountServiceProxy$registerChangeCallback$5(r100)));
        return;
    L5:
        r102 = r100;
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final void qc(com.bytedance.ee.bear.contract.b r100) {
        com.ss.android.lark.passportc.convention.b<h0> r101 = this.f206202d;
        Object r102 = r100;
        if (r100 != null) goto L5;
        r102 = "";
    L5:
        r101.d(new com.ss.android.lark.passportc.convention.b.C5239b(com.bytedance.ee.bear.contract.b.class, r102));
    }

    public UserLocalAccountServiceProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h0> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), h0.class), h0.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f206200b = r103.b();
        this.f206201c = r101;
        this.f206202d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f206201c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        h0 r104 = (h0) k.b(r102.c(r103), h0.class);
        this.f206202d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
