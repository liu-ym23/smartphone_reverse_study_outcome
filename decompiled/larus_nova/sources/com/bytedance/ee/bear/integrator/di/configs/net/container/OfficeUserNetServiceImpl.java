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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0003LMNB-\b\u0017\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0013H\u0016J,\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H+0.H\u0016J6\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H+0.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0017H\u0016J\u0012\u00105\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u0017H\u0017J\b\u00109\u001a\u00020:H\u0016J\u0014\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001e\u0010?\u001a\u0004\u0018\u00010@2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001c\u0010C\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010D\u001a\u00020#H\u0016J\u0012\u0010E\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010=\u001a\u00020HH\u0002J,\u0010I\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u000e\b\u0000\u0010+*\b\u0012\u0002\b\u0003\u0018\u00010,2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H+0KH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ee/bear/integrator/di/configs/net/container/OfficeUserNetServiceImpl;", "Lcom/bytedance/ee/bear/contract/NetService;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "userDocDomainConfig", "Lcom/bytedance/ee/bear/domain/container/IDocDomainConfig;", "passportUserService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "cookiesAdapterV2", "Lcom/bytedance/ee/bear/facade/common/CCMUserCookiesAdapterV2;", "userFgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "<init>", "(Lcom/bytedance/ee/bear/domain/container/IDocDomainConfig;Lcom/ss/android/lark/passportc/api/IPassportUserService;Lcom/bytedance/ee/bear/facade/common/CCMUserCookiesAdapterV2;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", com.alipay.sdk.m.k.b.f25406k, "Lcom/bytedance/ee/bear/net/Net;", "cookiesAdapter", "Lokhttp3/CookieJar;", "netConfig", "Lcom/bytedance/ee/bear/contract/NetService$Config;", "connectionService", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "loginEnv", "", "wifiTimeout", "", "mobileTimeout", "currentNetworkState", "liveConnectionDetector", "Landroidx/lifecycle/LiveData;", "dependency", "Lcom/bytedance/ee/bear/contract/NetService$Dependency;", "userScopeConvention", "Lcom/ss/android/lark/passportc/api/IUserScopeConvention;", "initNetConfig", "", "onChanged", "networkState", "initNet", "getMaxRequestsPerHost", "getConfig", "createPuller", "Lcom/bytedance/ee/bear/contract/NetService$Puller;", "R", "Lcom/bytedance/ee/bear/contract/Result;", "parser", "Lcom/bytedance/ee/bear/contract/NetService$Parser;", "interceptor", "Lcom/bytedance/ee/bear/contract/NetService$HeaderInterceptor;", "type", "Ljava/lang/reflect/Type;", "switchToEnv", "env", "changeHost", "host", "", "getEnv", "isTestEnv", "", "sendRequestSync", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "sendRequestAsync", "Lokhttp3/Call;", "responseCallback", "Lokhttp3/Callback;", "downloadRequest", "onConfigChanged", "setDependency", "convertRequest", "Lcom/bytedance/ee/bear/net/NetRequest;", "Lcom/bytedance/ee/bear/contract/NetService$Request;", "convertPuller", "puller", "Lcom/bytedance/ee/bear/net/ServerResultPuller;", "Companion", "ParserWrapper", "InterceptorWrapper", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUserNetServiceImpl implements NetService, Observer<ConnectionService.NetworkState> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f227090m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f227091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t45.b f227092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f227093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f227094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NetService.a f227095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f227096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f227097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f227098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f227099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConnectionService.NetworkState f227100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f227101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public NetService.b f227102l;

    public static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f227103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeUserNetServiceImpl f227104b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.integrator.di.configs.net.container.OfficeUserNetServiceImpl$a$a, reason: collision with other inner class name */
        public static final class RunnableC3250a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OfficeUserNetServiceImpl f227105a;

            public RunnableC3250a(OfficeUserNetServiceImpl r100) {
                this.f227105a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeUserNetServiceImpl r100 = this.f227105a;     // Catch: Throwable -> L6
                LiveData<ConnectionService.NetworkState> r101 = r100.f227101k;     // Catch: Throwable -> L6
                if (r101 == null) goto L9;
                r101.removeObserver(r100);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
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
            return this.f227103a;
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            tt5.a.h("UserNetServiceImpl", "afterUserOffline thread=" + ThreadMethodProxy.currentThread());
            this.f227103a.c(this);
            com.bytedance.ee.util.ui.m.a(new RunnableC3250a(this.f227104b));
        }

        public a(m r100, OfficeUserNetServiceImpl r101) {
            this.f227103a = r100;
            this.f227104b = r101;
        }
    }

    public static final class b {
    }

    public static final class c implements e {
        @Override // ak5.e
        public final void a(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "header");
        }

        public c() {
        }
    }

    public static final class d<R extends Result<?>> implements s<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NetService.c<R> f227106a;

        public d(NetService.c<R> r100) {
            Intrinsics.checkNotNullParameter(r100, "mParser");
            this.f227106a = r100;
        }

        @Override // ak5.s
        public final Serializable parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            return this.f227106a.parse(r100);
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
        if (this.f227097g != 2) goto L5;
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
        return this.f227095e;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void C7(NetService.b r100) {
        this.f227102l = r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result<?>> NetService.d<R> Rb(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        i r101 = this.f227091a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
        r101 = null;
    L5:
        r101.getClass();
        return new nb5.c(new w(r101, new ak5.c(r100), null), this);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result<?>> NetService.d<R> Vc(NetService.c<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        Intrinsics.checkNotNullParameter(r100, "parser");
        i r101 = this.f227091a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
        r101 = null;
    L5:
        d r102 = new d(r100);
        c r103 = new c();
        r101.getClass();
        return new nb5.c(new w(r101, r102, r103), this);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final Response g6(Request r100) {
        if (r100 != null) goto L13;
        return null;
    L13:
        i r101 = this.f227091a;     // Catch: Exception -> L10
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);     // Catch: Exception -> L10
        r101 = null;
    L8:
        return r101.f4022c.b().newCall(r100).execute();
    L10:
        e = move-exception;
        tt5.a.h("UserNetServiceImpl", " sendRequestSync e: " + e);
        return null;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(ConnectionService.NetworkState r100) {
        ConnectionService.NetworkState r101 = r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f227091a == null) goto L43;
        ConnectionService.NetworkState r102 = this.f227100j;
        boolean r103 = false;
        if (r102 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        i r105 = null;
        if (r104 == false) goto L23;
        if (r101.b() == false) goto L23;
        tt5.a.h("UserNetServiceImpl", "onChanged: NetworkState has switched to mobile, so rebuild okHttpClient, currentTimeout is " + this.f227099i);
        i r106 = this.f227091a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
    L21:
        r105.f4022c.f4041b = this.f227099i;
        return;
    L20:
        r105 = r106;
    L23:
        if (this.f227091a != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
    L25:
        ConnectionService.NetworkState r107 = this.f227100j;
        if (r107 != null) goto L28;
    L30:
        if (r103 == true) goto L32;
    L38:
        this.f227100j = r101;
        return;
    L32:
        if (r101.c() == false) goto L38;
        tt5.a.h("UserNetServiceImpl", "onChanged: NetworkState has switched to wifi, so rebuild okHttpClient, currentTimeout is " + this.f227098h);
        i r108 = this.f227091a;
        if (r108 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
    L37:
        r105.f4022c.f4041b = this.f227098h;
        return;
    L36:
        r105 = r108;
        goto L37
    L28:
        if (r107.c() == true) goto L30;
        r103 = true;
        goto L30
    L10:
        if (r102.b() == true) goto L12;
        r104 = true;
        goto L13
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void z8(Request r100, Callback r101) {
        if (r100 == null) goto L8;
        i r102 = this.f227091a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
        r102 = null;
    L6:
        r102.f4022c.b().newBuilder().build().newCall(r100).enqueue(r101);
        return;
    }

    @Inject
    public OfficeUserNetServiceImpl(t45.b r100, m r110, sa5.j r111, g r112) {
        Intrinsics.checkNotNullParameter(r100, "userDocDomainConfig");
        Intrinsics.checkNotNullParameter(r110, "passportUserService");
        Intrinsics.checkNotNullParameter(r111, "cookiesAdapterV2");
        Intrinsics.checkNotNullParameter(r112, "userFgService");
        this.f227094d = r112;
        this.f227092b = r100;
        NetService.a r101 = new NetService.a();
        this.f227095e = r101;
        String r102 = r100.a().f216940e.f216926a;
        boolean r103 = false;
        i r104 = null;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        tt5.a.k("UserNetServiceImpl", "docsApiHost is empty");
    L8:
        r101.f216903a = r102;
        j r105 = j.a.f217090a;
        this.f227096f = r105;
        int r106 = jl5.a.f499529a;
        int r107 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).envType();
        this.f227097g = r107;
        this.f227093c = r110;
        r110.d(new a(r110, this));
        com.bytedance.ee.bear.appsetting.c r113 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f227099i = ((Number) r113.d("carrier_timeout", 0)).intValue();
        this.f227098h = ((Number) r113.d("wifi_timeout", 0)).intValue();
        this.f227100j = r105.getNetworkState();
        com.bytedance.ee.util.ui.m.a(new nb5.e(this));
        ConnectionService.NetworkState r108 = this.f227100j;
        if (r108 != null) goto L11;
    L13:
        boolean r109 = false;
    L14:
        if (r109 == false) goto L16;
        long r114 = this.f227099i;
    L25:
        tt5.a.h("UserNetServiceImpl", "initNet: timeout = " + r114);
        i.a r115 = new i.a();
        r115.b(jl5.a.d());
        if (r107 == 3) goto L28;
    L30:
        r115.f4028e = r103;
        r115.f4029f = r114;
        if (r112.isCurrentEnable("ccm.mobile.max_requests_per_host") == false) goto L33;
        int r116 = 5;
    L34:
        r115.f4031h = r116;
        r115.f4026c = new nb5.d(this);
        r115.f4027d = r111;
        this.f227091a = r115.a();
        if (TextUtils.isEmpty(r101.f216903a) == false) goto L41;
        i r117 = this.f227091a;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.k.b.f25406k);
    L40:
        r101.f216903a = ((ak5.j.a) r104.f4020a).f4032a;
        goto L41
    L39:
        r104 = r117;
    L41:
        tt5.a.h("UserNetServiceImpl", "initNet()...host = " + r101.f216903a + ", env = " + jl5.a.d());
        return;
    L33:
        r116 = 64;
        goto L34
    L28:
        if (eu5.c.c() == false) goto L30;
        r103 = true;
        goto L30
    L16:
        ConnectionService.NetworkState r118 = this.f227100j;
        if (r118 != null) goto L19;
    L21:
        boolean r119 = false;
    L22:
        if (r119 == false) goto L24;
        r114 = this.f227098h;
        goto L25
    L24:
        r114 = 0;
        goto L25
    L19:
        if (r118.c() != true) goto L21;
        r119 = true;
        goto L22
    L11:
        if (r108.b() != true) goto L13;
        r109 = true;
        goto L14
    L5:
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(r102, "https://", false, 2, null) == true) goto L8;
        r102 = "https://" + r102;
        goto L8
    }
}
