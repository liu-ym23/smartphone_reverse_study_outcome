package com.bytedance.ee.bear.account.container.impl;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.contract.config.LoginInfo;
import com.bytedance.ee.bear.contract.h0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f0c.h;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public final class c implements h0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f206208i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f206209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f206210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVRepo f206211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f206212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NetService f206213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile AccountService$Account f206214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.bytedance.ee.bear.contract.b> f206215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.util.db.a f206216h;

    public static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f206217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f206218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.util.db.a f206219c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.account.container.impl.c$a$a, reason: collision with other inner class name */
        public static final class RunnableC2970a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f206220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.contract.b f206221b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ AccountService$Account f206222c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ c f206223d;

            public RunnableC2970a(m r100, com.bytedance.ee.bear.contract.b r101, AccountService$Account r102, c r103) {
                this.f206220a = r100;
                this.f206221b = r101;
                this.f206222c = r102;
                this.f206223d = r103;
            }

            public final void a() {
                if (this.f206220a.getState().f475035a != UserState.ONLINE) goto L5;
                ((com.bytedance.ee.bear.contract.c) this.f206221b).a(this.f206222c);
                return;
            L5:
                c r100 = this.f206223d;
                int r101 = c.f206208i;
                tt5.a.k(r100.a(), "after UICallbackExecutor user offline, ignore uid=" + this.f206222c.uid + " callback=" + this.f206221b);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.r
        public final m getPassport() {
            return this.f206217a;
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            tt5.a.h(this.f206218b.a(), "afterUserOffline thread=" + ThreadMethodProxy.currentThread());
            this.f206217a.c(this);
            this.f206218b.f206212d.clear();
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            tt5.a.h(this.f206218b.a(), "afterUserOnline. compatListenerSize=" + this.f206218b.f206215g.size() + " thread=" + ThreadMethodProxy.currentThread());
            c r101 = this.f206218b;
            CompositeDisposable r102 = r101.f206212d;
            int r103 = com.bytedance.ee.bear.account.container.impl.b.f206207a;
            NetService r104 = r101.f206213e;
            Intrinsics.checkNotNullParameter(r104, "netService");
            NetService.e r105 = new NetService.e();
            r105.f216905b = "/api/user/";
            r105.f216906c = 2;
            r102.add(r104.Vc(com.bytedance.ee.bear.account.container.impl.a.f206206a).a(r105).subscribe(new com.bytedance.ee.bear.account.container.impl.d(r101), new e(r101)));
            AccountService$Account r106 = this.f206218b.G2();
            this.f206219c.init(r106.uid);
            tt5.a.h(this.f206218b.a(), "afterUserOnline, account=" + r106);
            if (hu5.a.d(this.f206218b.f206215g) == true) goto L13;
            Iterator<com.bytedance.ee.bear.contract.b> r107 = this.f206218b.f206215g.iterator();
        L6:
            if (r107.hasNext() == false) goto L22;
            com.bytedance.ee.bear.contract.b r108 = r107.next();
            if (r108 == null) goto L6;
            if ((r108 instanceof com.bytedance.ee.bear.contract.c) == true) goto L11;
            r108.a(r106);
            goto L6
        L11:
            com.bytedance.ee.util.ui.m.a(new RunnableC2970a(this.f206217a, r108, r106, this.f206218b));
            goto L6
        L22:
            return;
        }

        public a(m r100, c r101, com.bytedance.ee.util.db.a r102) {
            this.f206217a = r100;
            this.f206218b = r101;
            this.f206219c = r102;
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.account.container.impl.c$c, reason: collision with other inner class name */
    public static final class C2971c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f206224a;

        public C2971c(c r100) {
            this.f206224a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            return this.f206224a.G2();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f206225a;

        public d(c r100) {
            this.f206225a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            c r102 = this.f206225a;
            r102.f206216h.init(r102.f206209a.getUser().userId);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final void j9(LoginInfo r100) {
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final AccountService$Account G2() {
        if (this.f206214f != null) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.f206214f != null) goto L13;
        long r100 = SystemClock.uptimeMillis();     // Catch: Throwable -> L16
        AccountService$Account r101 = new AccountService$Account();     // Catch: Throwable -> L16
        User r102 = this.f206209a.getUser();     // Catch: Throwable -> L16
        r101.state = 1;     // Catch: Throwable -> L16
        r101.tenantId = r102.getTenantId();     // Catch: Throwable -> L16
        r101.tenantName = r102.getTenantName();     // Catch: Throwable -> L16
        r101.tenantTag = String.valueOf(r102.getTenantTag());     // Catch: Throwable -> L16
        r101.token = r102.getSession();     // Catch: Throwable -> L16
        r101.uid = r102.userId;     // Catch: Throwable -> L16
        b(r101);     // Catch: Throwable -> L16
        r101.avatarUrl = r102.avatarUrl;     // Catch: Throwable -> L16
        r101.cnName = r102.getUserName();     // Catch: Throwable -> L16
        r101.userName = r102.getUserName();     // Catch: Throwable -> L16
        r101.enName = r102.enName;     // Catch: Throwable -> L16
        r101.displayName = r102.displayName;     // Catch: Throwable -> L10
        r101.i18Name = r102.i18Name;     // Catch: Throwable -> L10
        r101.i18DisplayName = r102.i18DisplayName;     // Catch: Throwable -> L10
    L12:
        this.f206214f = r101;     // Catch: Throwable -> L16
        tt5.a.h(a(), "getAccountTimeCost=" + (SystemClock.uptimeMillis() - r100));     // Catch: Throwable -> L16
        goto L13
    L10:
        th = move-exception;
        tt5.a.f(a(), th, false);     // Catch: Throwable -> L16
    L13:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
    L19:
        AccountService$Account r104 = this.f206214f;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.AccountService.Account");
        return r104;
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final Flowable<AccountService$Account> T4() {
        return Flowable.just("").observeOn(fo5.d.b()).map(new C2971c(this));
    }

    public final String a() {
        return "UserLocalAccountServiceImpl_" + hashCode();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final Flowable<Boolean> e5() {
        return Flowable.just(Boolean.TRUE);
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final boolean hasLogin() {
        if (this.f206209a.getState().f475035a.getState() != UserState.ONLINE.getState()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final AccountService$Account U5() {
        return G2();
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final Flowable<Boolean> Be(String r100) {
        if (hasLogin() == true) goto L5;
    L7:
        boolean r101 = false;
    L9:
        return Flowable.just(Boolean.valueOf(r101));
    L5:
        if (Intrinsics.areEqual(r100, this.f206209a.getUser().getSession()) == false) goto L7;
        r101 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final Flowable<Boolean> C1(DocDynamicConfig r100) {
        return Flowable.just(Boolean.TRUE).doOnNext(new d(this));
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final void Pe(com.bytedance.ee.bear.contract.b r100) {
        if (r100 == null) goto L5;
        this.f206215g.add(r100);
        return;
    }

    public final void b(AccountService$Account r100) {
        r100.departmentId = this.f206211c.getString("ccm_account_department_id", "0");
        r100.domain = this.f206211c.getString("ccm_account_domain", this.f206210b.docDynamicConfig().f216918b.f216936a);
        r100.isSuperAdmin = this.f206211c.getBoolean("ccm_account_isSuperAdmin", false);
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final Flowable<Boolean> n4(LoginInfo r100) {
        if (hasLogin() == false) goto L15;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.f216928a;
    L9:
        if (Intrinsics.areEqual(r102, this.f206209a.getUser().userId) == false) goto L15;
        if (r100 == null) goto L13;
        r101 = r100.f216929b;
    L13:
        if (Intrinsics.areEqual(r101, this.f206209a.getUser().getSession()) == false) goto L15;
        boolean r103 = true;
    L17:
        return Flowable.just(Boolean.valueOf(r103));
    L7:
        r102 = null;
    L15:
        r103 = false;
        goto L17
    }

    @Override // com.bytedance.ee.bear.contract.h0
    public final void qc(com.bytedance.ee.bear.contract.b r100) {
        if (r100 == null) goto L5;
        this.f206215g.remove(r100);
        return;
    }

    @Inject
    public c(m r100, a0 r101, NetService r102, com.bytedance.ee.util.db.a r103, by4.d r104) {
        Intrinsics.checkNotNullParameter(r100, "passportUserService");
        Intrinsics.checkNotNullParameter(r101, "userAccountInfoService");
        Intrinsics.checkNotNullParameter(r102, "netService");
        Intrinsics.checkNotNullParameter(r103, "dbController");
        Intrinsics.checkNotNullParameter(r104, "kvStore");
        this.f206212d = new CompositeDisposable();
        this.f206215g = new CopyOnWriteArraySet();
        this.f206209a = r100;
        this.f206210b = r101;
        this.f206213e = r102;
        this.f206216h = r103;
        this.f206211c = r104.b("account");
        a r105 = new a(r100, this, r103);
        tt5.a.h(a(), "init");
        r100.d(r105);
    }
}
