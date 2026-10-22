package com.bytedance.ee.bear.account.container.dwarf;

import android.app.Application;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.contract.config.LoginInfo;
import com.bytedance.ee.bear.contract.config.TenantInfo;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f0c.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public final class a implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile DocDynamicConfig f206191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f206192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t45.c f206193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t45.b f206194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<a0.a> f206195e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.account.container.dwarf.a$a, reason: collision with other inner class name */
    public static final class C2969a implements NetService.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t45.c f206196a;

        public C2969a(t45.c r100) {
            this.f206196a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.b
        public final String s0(String r100) {
            return this.f206196a.s0(r100);
        }
    }

    public static final class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f206197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f206198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t45.c f206199c;

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
            return this.f206197a;
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            tt5.a.h(this.f206198b.a(), "afterUserOffline");
            this.f206197a.c(this);
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            tt5.a.h(this.f206198b.a(), "afterUserOnline. compatListenerSize=" + this.f206198b.f206195e.size() + " Thread " + ThreadMethodProxy.currentThread());
            DocDynamicConfig r101 = this.f206198b.docDynamicConfig();
            t45.c r102 = this.f206199c;
            TenantInfo r103 = r101.f216918b;
            r102.O7(r103.f216936a, r103.f216938c, r103.f216940e.f216926a);
            Iterator<a0.a> r104 = this.f206198b.f206195e.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            r104.next().a(r101);
            goto L4
        }

        public b(m r100, a r101, t45.c r102) {
            this.f206197a = r100;
            this.f206198b = r101;
            this.f206199c = r102;
        }
    }

    public static final class c {
    }

    static {
    }

    public final String a() {
        return "UserAccountInfoServiceImpl_" + hashCode();
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final DocDynamicConfig docDynamicConfig() {
        if (this.f206191a != null) goto L30;
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L6:
        if (this.f206191a != null) goto L24;
        com.bytedance.ee.bear.account.a r100 = (com.bytedance.ee.bear.account.a) ClaymoreServiceLoader.loadFirst(com.bytedance.ee.bear.account.a.class);     // Catch: Throwable -> L27
        User r101 = this.f206192b.getUser();     // Catch: Throwable -> L27
        String r102 = r101.userId;     // Catch: Throwable -> L27
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        String r103 = r102;
        String r104 = r101.getSession();     // Catch: Throwable -> L27
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        LoginInfo r110 = new LoginInfo(r103, r104, r101.avatarUrl, r101.getUserName(), r101.enName, r101.getTenantId(), r101.getTenantName(), r101.isGuest);     // Catch: Throwable -> L27
        String r105 = r100.getDeviceId();     // Catch: Throwable -> L27
        if (r100.isShowGlobalWatermark() == true) goto L16;
        boolean r106 = true;
    L17:
        Application r107 = LarkContext.getApplication();     // Catch: Throwable -> L27
        if (PackageChannelManager.isKABuildPackage(r107) == true) goto L20;
    L22:
        boolean r108 = false;
    L23:
        this.f206191a = new DocDynamicConfig(r110, r105, this.f206194d.a(), r106, r108, PackageChannelManager.getBuildPackageChannel(r107), r101.userUnit, r101.getTenantBrand(), r100.isUsPackage());     // Catch: Throwable -> L27
        tt5.a.h("UserAccountInfoServiceImpl", "getDocDynamicConfig userSession=" + this.f206192b.getSession() + " this@" + hashCode() + " getDocDynamicConfig: " + this.f206191a);     // Catch: Throwable -> L27
        goto L24
    L20:
        if (PackageChannelManager.getDeployMode(r107) == 1) goto L22;
        r108 = true;
        goto L23
    L16:
        r106 = false;
    L24:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
    L30:
        DocDynamicConfig r111 = this.f206191a;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.config.DocDynamicConfig");
        return r111;
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final m Ad() {
        return this.f206192b;
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final void E1(a0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f206195e.add(r100);
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final void Vb(a0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f206195e.remove(r100);
    }

    @Inject
    public a(m r100, t45.c r101, NetService r102, t45.b r103) {
        Intrinsics.checkNotNullParameter(r100, "passportUserService");
        Intrinsics.checkNotNullParameter(r101, "spacekitUrlHelper");
        Intrinsics.checkNotNullParameter(r102, "netService");
        Intrinsics.checkNotNullParameter(r103, "docDomainConfig");
        this.f206195e = new CopyOnWriteArraySet();
        tt5.a.h(a(), "constructor thread= " + ThreadMethodProxy.currentThread());
        this.f206192b = r100;
        this.f206193c = r101;
        this.f206194d = r103;
        r102.C7(new C2969a(r101));
        r100.d(new b(r100, this, r101));
    }
}
