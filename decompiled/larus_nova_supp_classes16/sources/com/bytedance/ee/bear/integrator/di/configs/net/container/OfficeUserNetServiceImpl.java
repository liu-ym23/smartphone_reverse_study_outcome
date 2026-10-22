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
import com.bytedance.ee.bear.net.ParseException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.utils.ApiUtils;
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
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0003LMNB-\b\u0017\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0013H\u0016J,\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H+0.H\u0016J6\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H+0.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0017H\u0016J\u0012\u00105\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u0017H\u0017J\b\u00109\u001a\u00020:H\u0016J\u0014\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001e\u0010?\u001a\u0004\u0018\u00010@2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001c\u0010C\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010D\u001a\u00020#H\u0016J\u0012\u0010E\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010=\u001a\u00020HH\u0002J,\u0010I\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H+0KH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ee/bear/integrator/di/configs/net/container/OfficeUserNetServiceImpl;", "Lcom/bytedance/ee/bear/contract/NetService;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "userDocDomainConfig", "Lcom/bytedance/ee/bear/domain/container/IDocDomainConfig;", "passportUserService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "cookiesAdapterV2", "Lcom/bytedance/ee/bear/facade/common/CCMUserCookiesAdapterV2;", "userFgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "<init>", "(Lcom/bytedance/ee/bear/domain/container/IDocDomainConfig;Lcom/ss/android/lark/passportc/api/IPassportUserService;Lcom/bytedance/ee/bear/facade/common/CCMUserCookiesAdapterV2;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "net", "Lcom/bytedance/ee/bear/net/Net;", "cookiesAdapter", "Lokhttp3/CookieJar;", "netConfig", "Lcom/bytedance/ee/bear/contract/NetService$Config;", "connectionService", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "loginEnv", "", "wifiTimeout", "", "mobileTimeout", "currentNetworkState", "liveConnectionDetector", "Landroidx/lifecycle/LiveData;", "dependency", "Lcom/bytedance/ee/bear/contract/NetService$Dependency;", "userScopeConvention", "Lcom/ss/android/lark/passportc/api/IUserScopeConvention;", "initNetConfig", "", "onChanged", "networkState", "initNet", "getMaxRequestsPerHost", "getConfig", "createPuller", "Lcom/bytedance/ee/bear/contract/NetService$Puller;", "R", "Lcom/bytedance/ee/bear/contract/Result;", "parser", "Lcom/bytedance/ee/bear/contract/NetService$Parser;", "interceptor", "Lcom/bytedance/ee/bear/contract/NetService$HeaderInterceptor;", "type", "Ljava/lang/reflect/Type;", "switchToEnv", "env", "changeHost", "host", "", "getEnv", "isTestEnv", "", "sendRequestSync", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "sendRequestAsync", "Lokhttp3/Call;", "responseCallback", "Lokhttp3/Callback;", "downloadRequest", "onConfigChanged", "setDependency", "convertRequest", "Lcom/bytedance/ee/bear/net/NetRequest;", "Lcom/bytedance/ee/bear/contract/NetService$Request;", "convertPuller", "puller", "Lcom/bytedance/ee/bear/net/ServerResultPuller;", "Companion", "ParserWrapper", "InterceptorWrapper", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUserNetServiceImpl implements NetService, Observer<ConnectionService.NetworkState> {
    public static final /* synthetic */ int m = 0;
    public i a;
    public final t45.b b;
    public final m c;
    public final g d;
    public final NetService.a e;
    public final j f;
    public final int g;
    public long h;
    public long i;
    public ConnectionService.NetworkState j;
    public LiveData<ConnectionService.NetworkState> k;
    public NetService.b l;

    public static final class a implements r {
        public final /* synthetic */ m a;
        public final /* synthetic */ OfficeUserNetServiceImpl b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.integrator.di.configs.net.container.OfficeUserNetServiceImpl$a$a, reason: collision with other inner class name */
        public static final class RunnableC0194a implements Runnable {
            public final /* synthetic */ OfficeUserNetServiceImpl a;

            public RunnableC0194a(OfficeUserNetServiceImpl r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeUserNetServiceImpl r0 = this.a;     // Catch: Throwable -> L6
                LiveData<ConnectionService.NetworkState> r1 = r0.k;     // Catch: Throwable -> L6
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
            com.bytedance.ee.util.ui.m.a(new RunnableC0194a(this.b));
        }

        public a(m r1, OfficeUserNetServiceImpl r2) {
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
    public final boolean w6() {
        if (this.g != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final int getEnv() {
        return jl5.a.d();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final NetService.a getConfig() {
        return this.e;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void C7(NetService.b r1) {
        this.l = r1;
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
        return new nb5.c(new w(r0, new ak5.c(r4), null), this);
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
        return new nb5.c(new w(r0, r1, r5), this);
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
        ConnectionService.NetworkState r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        i r4 = null;
        if (r2 == false) goto L23;
        if (r8.b() == false) goto L23;
        tt5.a.h("UserNetServiceImpl", "onChanged: NetworkState has switched to mobile, so rebuild okHttpClient, currentTimeout is " + this.i);
        i r9 = this.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L21:
        r4.c.b = this.i;
        return;
    L20:
        r4 = r9;
    L23:
        if (this.a != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L25:
        ConnectionService.NetworkState r3 = this.j;
        if (r3 != null) goto L28;
    L30:
        if (r1 == true) goto L32;
    L38:
        this.j = r8;
        return;
    L32:
        if (r8.c() == false) goto L38;
        tt5.a.h("UserNetServiceImpl", "onChanged: NetworkState has switched to wifi, so rebuild okHttpClient, currentTimeout is " + this.h);
        i r10 = this.a;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L37:
        r4.c.b = this.h;
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
    public OfficeUserNetServiceImpl(t45.b r9, m r10, sa5.j r11, g r12) {
        Intrinsics.checkNotNullParameter(r9, "userDocDomainConfig");
        Intrinsics.checkNotNullParameter(r10, "passportUserService");
        Intrinsics.checkNotNullParameter(r11, "cookiesAdapterV2");
        Intrinsics.checkNotNullParameter(r12, "userFgService");
        this.d = r12;
        this.b = r9;
        NetService.a r0 = new NetService.a();
        this.e = r0;
        String r13 = r9.a().e.a;
        boolean r2 = false;
        i r5 = null;
        if (TextUtils.isEmpty(r13) == false) goto L5;
        tt5.a.k("UserNetServiceImpl", "docsApiHost is empty");
    L8:
        r0.a = r13;
        j r14 = j.a.a;
        this.f = r14;
        int r1 = jl5.a.a;
        int r3 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).envType();
        this.g = r3;
        this.c = r10;
        r10.d(new a(r10, this));
        com.bytedance.ee.bear.appsetting.c r16 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.i = ((Number) r16.d("carrier_timeout", 0)).intValue();
        this.h = ((Number) r16.d("wifi_timeout", 0)).intValue();
        this.j = r14.getNetworkState();
        com.bytedance.ee.util.ui.m.a(new nb5.e(this));
        ConnectionService.NetworkState r17 = this.j;
        if (r17 != null) goto L11;
    L13:
        boolean r18 = false;
    L14:
        if (r18 == false) goto L16;
        long r19 = this.i;
    L25:
        tt5.a.h("UserNetServiceImpl", "initNet: timeout = " + r19);
        i.a r4 = new i.a();
        r4.b(jl5.a.d());
        if (r3 == 3) goto L28;
    L30:
        r4.e = r2;
        r4.f = r19;
        if (r12.isCurrentEnable("ccm.mobile.max_requests_per_host") == false) goto L33;
        int r20 = 5;
    L34:
        r4.h = r20;
        r4.c = new nb5.d(this);
        r4.d = r11;
        this.a = r4.a();
        if (TextUtils.isEmpty(r0.a) == false) goto L41;
        i r21 = this.a;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("net");
    L40:
        r0.a = r5.a.a;
        goto L41
    L39:
        r5 = r21;
    L41:
        tt5.a.h("UserNetServiceImpl", "initNet()...host = " + r0.a + ", env = " + jl5.a.d());
        return;
    L33:
        r20 = 64;
        goto L34
    L28:
        if (eu5.c.c() == false) goto L30;
        r2 = true;
        goto L30
    L16:
        ConnectionService.NetworkState r22 = this.j;
        if (r22 != null) goto L19;
    L21:
        boolean r23 = false;
    L22:
        if (r23 == false) goto L24;
        r19 = this.h;
        goto L25
    L24:
        r19 = 0;
        goto L25
    L19:
        if (r22.c() != true) goto L21;
        r23 = true;
        goto L22
    L11:
        if (r17.b() != true) goto L13;
        r18 = true;
        goto L14
    L5:
        Intrinsics.checkNotNull(r13);
        if (StringsKt.startsWith$default(r13, "https://", false, 2, null) == true) goto L8;
        r13 = "https://" + r13;
        goto L8
    }
}
