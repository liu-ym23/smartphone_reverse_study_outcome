package com.bytedance.ee.bear.integrator.di.configs.net.container;

import ak5.e;
import ak5.i;
import ak5.s;
import ak5.w;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.net.ParseException;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f0c.h;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;
import javax.inject.Inject;
import jdb.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nb5.f;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 N2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0003NOPB-\b\u0017\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0015H\u0016J,\u0010+\u001a\b\u0012\u0004\u0012\u0002H-0,\"\u000e\b\u0000\u0010-*\b\u0012\u0002\b\u0003\u0018\u00010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-00H\u0016J6\u0010+\u001a\b\u0012\u0004\u0012\u0002H-0,\"\u000e\b\u0000\u0010-*\b\u0012\u0002\b\u0003\u0018\u00010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-002\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u0010+\u001a\b\u0012\u0004\u0012\u0002H-0,\"\u000e\b\u0000\u0010-*\b\u0012\u0002\b\u0003\u0018\u00010.2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u0019H\u0016J\u0012\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u0019H\u0017J\b\u0010;\u001a\u00020<H\u0016J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001e\u0010A\u001a\u0004\u0018\u00010B2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001c\u0010E\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020%H\u0016J\u0012\u0010G\u001a\u00020%2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010?\u001a\u00020JH\u0002J,\u0010K\u001a\b\u0012\u0004\u0012\u0002H-0,\"\u000e\b\u0000\u0010-*\b\u0012\u0002\b\u0003\u0018\u00010.2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002H-0MH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/integrator/di/configs/net/container/UserNetServiceImpl;", "Lcom/bytedance/ee/bear/contract/NetService;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "userDocDomainConfig", "Lcom/bytedance/ee/bear/domain/container/IDocDomainConfig;", "passportUserService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "cookiesAdapterV2", "Lcom/bytedance/ee/bear/facade/common/CCMUserCookiesAdapterV2;", "userFgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "<init>", "(Lcom/bytedance/ee/bear/domain/container/IDocDomainConfig;Lcom/ss/android/lark/passportc/api/IPassportUserService;Lcom/bytedance/ee/bear/facade/common/CCMUserCookiesAdapterV2;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "net", "Lcom/bytedance/ee/bear/net/Net;", "cookiesAdapter", "Lokhttp3/CookieJar;", "globalDependency", "Lcom/bytedance/ee/bear/account/IAccountModuleDependency;", "netConfig", "Lcom/bytedance/ee/bear/contract/NetService$Config;", "connectionService", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "loginEnv", "", "wifiTimeout", "", "mobileTimeout", "currentNetworkState", "liveConnectionDetector", "Landroidx/lifecycle/LiveData;", "dependency", "Lcom/bytedance/ee/bear/contract/NetService$Dependency;", "userScopeConvention", "Lcom/ss/android/lark/passportc/api/IUserScopeConvention;", "initNetConfig", "", "onChanged", "networkState", "initNet", "getMaxRequestsPerHost", "getConfig", "createPuller", "Lcom/bytedance/ee/bear/contract/NetService$Puller;", "R", "Lcom/bytedance/ee/bear/contract/Result;", "parser", "Lcom/bytedance/ee/bear/contract/NetService$Parser;", "interceptor", "Lcom/bytedance/ee/bear/contract/NetService$HeaderInterceptor;", "type", "Ljava/lang/reflect/Type;", "switchToEnv", "env", "changeHost", "host", "", "getEnv", "isTestEnv", "", "sendRequestSync", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "sendRequestAsync", "Lokhttp3/Call;", "responseCallback", "Lokhttp3/Callback;", "downloadRequest", "onConfigChanged", "setDependency", "convertRequest", "Lcom/bytedance/ee/bear/net/NetRequest;", "Lcom/bytedance/ee/bear/contract/NetService$Request;", "convertPuller", "puller", "Lcom/bytedance/ee/bear/net/ServerResultPuller;", "Companion", "ParserWrapper", "InterceptorWrapper", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserNetServiceImpl implements NetService, Observer<ConnectionService.NetworkState> {
    public static final /* synthetic */ int n = 0;
    public i a;
    public final t45.b b;
    public final m c;
    public final com.bytedance.ee.bear.account.a d;
    public final g e;
    public final NetService.a f;
    public final j g;
    public final int h;
    public long i;
    public long j;
    public ConnectionService.NetworkState k;
    public LiveData<ConnectionService.NetworkState> l;
    public NetService.b m;

    public static final class a implements r {
        public final /* synthetic */ m a;
        public final /* synthetic */ UserNetServiceImpl b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.integrator.di.configs.net.container.UserNetServiceImpl$a$a, reason: collision with other inner class name */
        public static final class RunnableC0195a implements Runnable {
            public final /* synthetic */ UserNetServiceImpl a;

            public RunnableC0195a(UserNetServiceImpl r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                UserNetServiceImpl r0 = this.a;     // Catch: Throwable -> L6
                LiveData<ConnectionService.NetworkState> r1 = r0.l;     // Catch: Throwable -> L6
                if (r1 == null) goto L9;
                r1.removeObserver(r0);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void afterUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final m getPassport() {
            return this.a;
        }

        public final void afterUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            tt5.a.h("UserNetServiceImpl", "afterUserOffline thread=" + ThreadMethodProxy.currentThread());
            this.a.c(this);
            com.bytedance.ee.util.ui.m.a(new RunnableC0195a(this.b));
        }

        public a(m r1, UserNetServiceImpl r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    public static final class c implements e {
        public final void a(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "header");
        }

        public c() {
        }
    }

    public static final class d<R extends Result<?>> implements s<R> {
        public final NetService.c<R> a;

        public d(NetService.c<R> r2) {
            Intrinsics.checkNotNullParameter(r2, "mParser");
            this.a = r2;
        }

        public final Serializable parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            return this.a.parse(r2);
        L6:
            throw new ParseException();
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final int getEnv() {
        return this.d.oldEnv();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final boolean w6() {
        if (this.h != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final NetService.a getConfig() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void C7(NetService.b r1) {
        this.m = r1;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result<?>> NetService.d<R> Rb(Type r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        i r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("net");
        r0 = null;
    L5:
        r0.getClass();
        return new f(new w(r0, new ak5.c(r4), null), this);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result<?>> NetService.d<R> Vc(NetService.c<R> r4) {
        Intrinsics.checkNotNullParameter(r4, "parser");
        Intrinsics.checkNotNullParameter(r4, "parser");
        i r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("net");
        r0 = null;
    L5:
        d r1 = new d(r4);
        c r5 = new c();
        r0.getClass();
        return new f(new w(r0, r1, r5), this);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final Response g6(Request r4) {
        if (r4 != null) goto L13;
        return null;
    L13:
        i r1 = this.a;     // Catch: Exception -> L10
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("net");     // Catch: Exception -> L10
        r1 = null;
    L8:
        return r1.c.b().newCall(r4).execute();
    L10:
        e = move-exception;
        tt5.a.h("UserNetServiceImpl", " sendRequestSync e: " + e);
        return null;
    }

    public final void onChanged(Object r7) {
        ConnectionService.NetworkState r8 = (ConnectionService.NetworkState) r7;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.a == null) goto L43;
        ConnectionService.NetworkState r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        i r4 = null;
        if (r2 == false) goto L23;
        if (r8.b() == false) goto L23;
        tt5.a.h("UserNetServiceImpl", "onChanged: NetworkState has switched to mobile, so rebuild okHttpClient, currentTimeout is " + this.j);
        i r9 = this.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L21:
        r4.c.b = this.j;
        return;
    L20:
        r4 = r9;
    L23:
        if (this.a != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L25:
        ConnectionService.NetworkState r3 = this.k;
        if (r3 != null) goto L28;
    L30:
        if (r1 == true) goto L32;
    L38:
        this.k = r8;
        return;
    L32:
        if (r8.c() == false) goto L38;
        tt5.a.h("UserNetServiceImpl", "onChanged: NetworkState has switched to wifi, so rebuild okHttpClient, currentTimeout is " + this.i);
        i r10 = this.a;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L37:
        r4.c.b = this.i;
        return;
    L36:
        r4 = r10;
        goto L37
    L28:
        if (r3.c() == true) goto L30;
        r1 = true;
        goto L30
    L10:
        if (r0.b() == true) goto L12;
        r2 = true;
        goto L13
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void z8(Request r2, Callback r3) {
        if (r2 == null) goto L8;
        i r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("net");
        r0 = null;
    L6:
        r0.c.b().newBuilder().build().newCall(r2).enqueue(r3);
        return;
    }

    @Inject
    public UserNetServiceImpl(t45.b r10, m r11, sa5.j r12, g r13) {
        Intrinsics.checkNotNullParameter(r10, "userDocDomainConfig");
        Intrinsics.checkNotNullParameter(r11, "passportUserService");
        Intrinsics.checkNotNullParameter(r12, "cookiesAdapterV2");
        Intrinsics.checkNotNullParameter(r13, "userFgService");
        this.e = r13;
        this.b = r10;
        NetService.a r0 = new NetService.a();
        this.f = r0;
        com.bytedance.ee.bear.account.a r1 = (com.bytedance.ee.bear.account.a) ClaymoreServiceLoader.loadFirst(com.bytedance.ee.bear.account.a.class);
        this.d = r1;
        String r14 = r10.a().e.a;
        boolean r3 = false;
        i r6 = null;
        if (TextUtils.isEmpty(r14) == false) goto L5;
        tt5.a.k("UserNetServiceImpl", "docsApiHost is empty");
    L8:
        r0.a = r14;
        j r16 = j.a.a;
        this.g = r16;
        int r2 = r1.loginEnv();
        this.h = r2;
        this.c = r11;
        r11.d(new a(r11, this));
        com.bytedance.ee.bear.appsetting.c r17 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.j = ((Number) r17.d("carrier_timeout", 0)).intValue();
        this.i = ((Number) r17.d("wifi_timeout", 0)).intValue();
        this.k = r16.getNetworkState();
        com.bytedance.ee.util.ui.m.a(new nb5.h(this));
        ConnectionService.NetworkState r18 = this.k;
        if (r18 != null) goto L11;
    L13:
        boolean r19 = false;
    L14:
        if (r19 == false) goto L16;
        long r110 = this.j;
    L25:
        tt5.a.h("UserNetServiceImpl", "initNet: timeout = " + r110);
        i.a r4 = new i.a();
        r4.b(getEnv());
        if (r2 == 3) goto L28;
    L30:
        boolean r5 = false;
    L31:
        r4.e = r5;
        r4.f = r110;
        if (r13.isCurrentEnable("ccm.mobile.max_requests_per_host") == false) goto L34;
        int r111 = 5;
    L35:
        r4.h = r111;
        r4.c = new nb5.g(this);
        r4.d = r12;
        int r112 = mb5.a.a;
        boolean r113 = ((z) ClaymoreServiceLoader.loadFirst(z.class)).isDebugEnabled(eu5.b.a);
        boolean r114 = ((Boolean) new ml5.b("debug_config").a("net_interceptable", Boolean.FALSE)).booleanValue();
        if (r113 == false) goto L39;
        if (r114 == false) goto L39;
        r3 = true;
    L39:
        if (r3 == false) goto L41;
        r4.g = new mb5.a();
    L41:
        this.a = r4.a();
        if (TextUtils.isEmpty(r0.a) == false) goto L48;
        i r115 = this.a;
        if (r115 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L47:
        r0.a = r6.a.a;
        goto L48
    L46:
        r6 = r115;
    L48:
        tt5.a.h("UserNetServiceImpl", "initNet()...host = " + r0.a + ", env = " + getEnv());
        return;
    L34:
        r111 = 64;
        goto L35
    L28:
        if (eu5.c.c() == false) goto L30;
        r5 = true;
        goto L31
    L16:
        ConnectionService.NetworkState r116 = this.k;
        if (r116 != null) goto L19;
    L21:
        boolean r117 = false;
    L22:
        if (r117 == false) goto L24;
        r110 = this.i;
        goto L25
    L24:
        r110 = 0;
        goto L25
    L19:
        if (r116.c() != true) goto L21;
        r117 = true;
        goto L22
    L11:
        if (r18.b() != true) goto L13;
        r19 = true;
        goto L14
    L5:
        Intrinsics.checkNotNull(r14);
        if (StringsKt.startsWith$default(r14, "https://", false, 2, null) == true) goto L8;
        r14 = "https://" + r14;
        goto L8
    }
}
