package com.larus.security.api;

import android.app.Application;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b2;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f367855a = 0;

    public static final class a implements cpa.b {
        public a() {
        }

        @Override // cpa.b
        public final Pair getRequestTagHeader() {
            Pair<String, String> r100 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new com.larus.security.api.c());
            FLogger.f375446a.d("AzerothManager", "init BDNetworkTagManager triggerType: " + r100);
            return r100;
        }
    }

    public static final class b implements soa.b {
        public b() {
        }
    }

    public static final class c implements apa.b {
        public c() {
        }

        @Override // apa.b
        public final void i(String r100) {
            FLogger.f375446a.i("AzerothPrivacy", r100);
        }

        @Override // apa.b
        public final void d(String r100, String r101) {
            FLogger.f375446a.d(r100, r101);
        }

        @Override // apa.b
        public final void e(String r100, String r101) {
            FLogger.f375446a.e(r100, r101);
        }

        @Override // apa.b
        public final void w(String r100, Throwable r101) {
            FLogger.f375446a.w("AzerothPrivacyWarn", r100, r101);
        }

        @Override // apa.b
        public final void e(String r100, String r101, Throwable r102) {
            FLogger.f375446a.e(r100, r101, r102);
        }
    }

    /* JADX INFO: renamed from: com.larus.security.api.d$d, reason: collision with other inner class name */
    public static final class C4482d implements com.larus.platform.api.b {
        public C4482d() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = d.f367855a;
            String r102 = r100.f364876b;
            Intrinsics.checkNotNullParameter(r102, "userId");
            FLogger.f375446a.i("AzerothManager", "invokeAfterLogin userid: " + r102);
            AzerothPrivacy.invokeAfterLogin(r102);
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = d.f367855a;
            FLogger.f375446a.i("AzerothManager", "invokeAfterLogout");
            AzerothPrivacy.invokeAfterLogout();
        }
    }

    static {
    }

    public static void a() {
        FLogger r100 = FLogger.f375446a;
        AccountService r101 = AccountService.f365697a;
        r100.i("AzerothManager", "init userid: ".concat(r101.getUserId()));
        cpa.a.f464730a = new a();
        AppHost.Companion r102 = AppHost.f326268a;
        Application r103 = r102.getApplication();
        poa.a r104 = new poa.a();
        r104.f530142a = r102.getAppId();
        r104.f530143b = String.valueOf(r102.getVersionCode());
        r104.f530144c = String.valueOf(r102.getUpdateVersionCode());
        r104.f530145d = o.f365780a.getDeviceId();
        r104.f530146e = r101.getUserId();
        r104.f530147f = r102.getBuildChannel();
        r104.f530148g = r102.getApplication().getPackageName();
        poa.f r105 = new poa.f();
        int r106 = h.f367858a;
        r105.f530151a = new poa.f.b();
        if (HttpExtKt.e().f360166a == false) goto L5;
        String r107 = "https://alice-boe.bytedance.net/ukms";
    L6:
        r105.f530152b = new poa.f.a(r107.concat("/kexg"), r107.concat("/akexg"));
        Unit r108 = Unit.INSTANCE;
        Object r109 = b2.f364870a.m();
        if ((r109 instanceof NetworkClient) == false) goto L9;
        NetworkClient r110 = (NetworkClient) r109;
    L12:
        AzerothPrivacy.init(r103, r104, r105, r110, new com.larus.security.api.a(), new com.larus.security.api.b(), new b(), new c());
        r101.E(new C4482d());
        return;
    L9:
        if (r109 == null) goto L11;
        r100.w("AzerothManager", "invalid Azeroth network client type: ".concat(r109.getClass().getName()));
    L11:
        NetworkClient r111 = NetworkClient.getDefault();
        Intrinsics.checkNotNull(r111);
        r110 = r111;
        goto L12
    L5:
        r107 = "https://api-normal.doubao.com/ukms";
        goto L6
    }
}
