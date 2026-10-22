package com.larus.account.base;

import android.os.Handler;
import android.util.Pair;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.coreapi.IAccountInitManager;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.i0;
import com.larus.network.HttpConst;
import com.larus.network.http.HttpExtKt;
import com.obric.assistant.common.spi.network.IObricSecurityNetworkService;
import com.ss.android.account.k;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import d48.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pc7.e;
import wqa.c;
import wqa.g;
import wqa.h;
import wqa.i;
import x38.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/account/base/TTAccount;", "", "<init>", "()V", "TAG", "", "init", "", "commonDepend", "Lcom/larus/account/saas/runtime/depend/IFlowAccountSaasCommonDepend;", "configExtraConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTAccount {
    public static final TTAccount INSTANCE = null;
    private static final String TAG = "TTAccount";

    public static final class a implements c {

        /* JADX INFO: renamed from: com.larus.account.base.TTAccount$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes4.dex */
        public static final class C3940a extends BDNetworkTagContextProviderAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f286089a;

            @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
            public final int triggerType() {
                return !this.f286089a ? 1 : 0;
            }

            public C3940a(boolean r100) {
                this.f286089a = r100;
            }
        }

        public a() {
        }

        @Override // wqa.c
        public final i getRequestTagHeader(boolean r100) {
            Pair<String, String> r101 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new C3940a(r100));
            return new i((String) r101.first, (String) r101.second);
        }
    }

    public static final class b implements f {
        public b() {
        }

        @Override // x38.f
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "platform");
        }

        @Override // x38.f
        public final void d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uid");
        }

        @Override // x38.f
        public final void c(b48.b r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
        }

        @Override // x38.f
        public final void a(String r100, b48.b r101) {
            Intrinsics.checkNotNullParameter(r101, "info");
            ILoginService r102 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (r102 == null) goto L6;
            r102.M(r100, r101);
            return;
        }
    }

    static {
        INSTANCE = new TTAccount();
    }

    private TTAccount() {
    }

    private final void configExtraConfig() {
        h r100 = k.f406319c;
        if (r100 != null) goto L5;
        r100 = new h();
    L5:
        IOfficeSDKLgwHeaderProvider r101 = (IOfficeSDKLgwHeaderProvider) ServiceManager.get().getService(IOfficeSDKLgwHeaderProvider.class);
        if (r101 == null) goto L8;
        Map<String, String> r102 = r101.a();
    L9:
        if (r102 != null) goto L11;
    L34:
        k.f406319c = r100;
        return;
    L11:
        if (r102.isEmpty() == true) goto L34;
        HashSet r103 = new HashSet();
        Iterator<String> r104 = r102.keySet().iterator();
        boolean r105 = false;
        boolean r106 = false;
    L15:
        if (r104.hasNext() == false) goto L29;
        String r107 = r104.next();
        if (fc7.b.f476362a.contains(r107) == true) goto L18;
        Map<String, String> r108 = r100.f560774a;
        if (r108 == null) goto L25;
        if (((HashMap) r108).size() < 100) goto L25;
        tb7.a.e("TTAccountExtraConfig", "commonRequestParams size is bigger than 100, can not be added");
        r106 = true;
    L25:
        if (r100.f560774a != null) goto L27;
        r100.f560774a = new HashMap(8);
    L27:
        ((HashMap) r100.f560774a).put(r107, r102.get(r107));
        tb7.a.d("TTAccountExtraConfig", "common param added, key: " + r107 + ", value: " + r102.get(r107));
        r103.add(r107);
        goto L15
    L18:
        tb7.a.e("TTAccountExtraConfig", r107 + " is reserved key, can not be added");
        r105 = true;
        goto L15
    L29:
        if (AccountHostSettingsManager.f269319d.a() <= 0) goto L32;
        new Handler().postDelayed(new g(r100, r103, r105, r106), KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
        goto L34
    L32:
        if (k.f406321e == false) goto L34;
        com.bytedance.sdk.account.monitor.c.h(r103, r105, r106, ((HashMap) r100.f560774a).size());
        goto L34
    L8:
        r102 = null;
        goto L9
    }

    public final void init(d r110) {
        Intrinsics.checkNotNullParameter(r110, "commonDepend");
        k.f406320d = new a();
        configExtraConfig();
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isOversea() == true) goto L5;
        JSONObject r101 = com.bytedance.sdk.account.ticketguard.f.f269445a;
        tb7.a.d("TokenGuardSettingManage", "setEnableTokenGuard enable=true");
        com.bytedance.sdk.account.ticketguard.f.f269459h = true;
        com.bytedance.sdk.account.ticketguard.f.f269461i = true;
    L5:
        ArrayList r102 = new ArrayList();
        if (HttpExtKt.e().f360166a == false) goto L8;
        r102.add(kb9.a.f502270a);
        r102.add("ocapp-boe.bytedance.net");
    L13:
        if (r100.isOversea() == true) goto L15;
        HttpConst.f359979a.getClass();
        r102.add(HttpConst.f360019u);
        r102.add(HttpConst.f360021v);
        r102.add(HttpConst.f360023w);
        r102.addAll(kb9.a.f502276g);
        r102.addAll(kb9.a.f502277h);
    L15:
        IObricSecurityNetworkService r103 = (IObricSecurityNetworkService) ServiceManager.get().getService(IObricSecurityNetworkService.class);
        if (r103 == null) goto L19;
        r103.b(HttpExtKt.e().f360166a, HttpExtKt.e().f360168c, r102);
    L19:
        if (HttpExtKt.e().f360166a == false) goto L21;
        String r104 = kb9.a.f502270a;
    L22:
        IAccountInitManager r105 = FlowAccountSdk.g();
        int r106 = b48.d.f17608d;
        b48.d.a r107 = new b48.d.a();
        b48.a r108 = new b48.a(r100.getAppName(), r104, r102);
        Intrinsics.checkNotNullParameter(r108, "baseConfig");
        r107.f17612a = r108;
        List<Integer> r109 = i0.f357057a;
        b48.i r111 = new b48.i(new b48.i.a(), new b48.i.b("2089"), new b48.i.b("2198"), new b48.i.b("2195"));
        Intrinsics.checkNotNullParameter(r111, "thirdPartyAuthConfig");
        r107.f17613b = r111;
        Intrinsics.checkNotNullParameter(r110, "commonDepend");
        if (r110 == null) goto L44;
        b48.a r112 = r107.f17612a;
        if (r112 == null) goto L42;
        r105.a(new b48.d(r112, r107.f17613b, r110));
        IApplog.Companion r113 = IApplog.f287053a;
        Integer r114 = Integer.valueOf(com.bytedance.sdk.account.impl.h.a().i());
        if (com.bytedance.sdk.account.impl.h.a().isLogin() == false) goto L29;
        long r115 = com.bytedance.sdk.account.impl.h.a().getUserId();
    L30:
        r113.d(new Pair(r114, Long.valueOf(r115)));
        e.c().getClass();
        pc7.d.a("TwiceVerifyManager", "init()");
        jb7.b.a(new jb7.a[]{new pc7.c()});
    L37:
        th = move-exception;
        pc7.d.b(5, "TwiceVerifyManager", "addRetryRequestByHeaderCallback fail, switch to use error handler", th);
    L39:
        FlowAccountSdk.f().b(new b());
        return;
    L32:
        if (NetworkParams.addRetryRequestByHeaderCallback("x-tt-verify-passport-decision", new pc7.h()) == false) goto L34;
        String r116 = "success";
    L35:
        pc7.d.a("TwiceVerifyManager", "addRetryRequestByHeaderCallback ".concat(r116));     // Catch: Throwable -> L37
        goto L39
    L34:
        r116 = "fail";
        goto L35
    L29:
        r115 = 0;
        goto L30
    L42:
        throw new IllegalArgumentException("baseConfig must be provided.".toString());
    L44:
        throw new IllegalArgumentException("commonDepend must be provided.".toString());
    L21:
        HttpConst.f359979a.getClass();
        r104 = HttpConst.f359995i;
        goto L22
    L8:
        String r117 = kb9.a.f502270a;
        HttpConst.f359979a.getClass();
        r102.add(HttpConst.f359995i);
        if (r100.isOversea() == true) goto L11;
        r102.add("mp.oceancloudapi.com");
        r102.add("flow-first-party-applet.zijieapi.com");
        goto L13
    L11:
        r102.add("");
        goto L13
    }
}
