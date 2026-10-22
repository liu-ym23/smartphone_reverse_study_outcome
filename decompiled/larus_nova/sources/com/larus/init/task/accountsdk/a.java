package com.larus.init.task.accountsdk;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;
import com.bytedance.android.livesdkapi.depend.constant.SchemaConstants;
import com.bytedance.apm.ApmAgent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.account.saas.runtime.depend.ToastType;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.minor.api.IMinorService;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements d48.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f351133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<d48.c.a, f09.a.b> f351134b = null;

    /* JADX INFO: renamed from: com.larus.init.task.accountsdk.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes30.dex */
    public /* synthetic */ class C4380a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351135a = null;

        static {
            int[] r100 = new int[ToastType.values().length];
            r100[ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ToastType.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f351135a = r100;
        }
    }

    public a() {
    }

    static {
        f351133a = new a();
        f351134b = new ConcurrentHashMap();
    }

    public final int a() {
        return AppHost.f326268a.getAppId();
    }

    @Override // d48.c
    public final boolean b() {
        return !AppHost.f326268a.a().isAppBackground();
    }

    public final String c() {
        return AppHost.f326268a.getAppName();
    }

    @Override // d48.c
    public final Activity currentActivity() {
        return AppHost.f326268a.a().getCurrentActivity();
    }

    public final boolean d() {
        return AppHost.f326268a.isDebug();
    }

    @Override // d48.c
    public final String e() {
        return o.f365780a.getDeviceId();
    }

    @Override // d48.c
    public final Application getApplication() {
        return AppHost.f326268a.getApplication();
    }

    @Override // d48.c
    public final boolean isTeenMode() {
        return IMinorService.f359156a.a();
    }

    @Override // d48.c
    public final void g(d48.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ConcurrentHashMap<d48.c.a, f09.a.b> r101 = f351134b;
        f09.a.b r102 = r101.get(r100);
        if (r102 == null) goto L6;
        AppHost.f326268a.a().c(r102);
        r101.remove(r100);
        return;
    }

    @Override // d48.c
    public final void h(com.larus.account.saas.mfa.assist.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b r101 = new b(r100);
        f351134b.put(r100, r101);
        AppHost.f326268a.a().j(r101);
    }

    @Override // d48.c
    public final boolean f(ToastType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "text");
        Application r102 = getApplication();
        int r103 = C4380a.f351135a[r100.ordinal()];
        if (r103 != 1) goto L5;
        s.f544207a.getClass();
        s.p(r102, r101);
    L9:
        return true;
    L5:
        if (r103 == 2) goto L7;
        s.j(s.f544207a, r102, r101, null, false, 28);
        goto L9
    L7:
        s.f544207a.getClass();
        s.t(r102, r101);
        goto L9
    }

    public final boolean i(String r100, String r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L19;
        if (r101 != null) goto L13;
    L14:
        r102 = true;
    L15:
        if (r102 == true) goto L19;
        String r104 = UriProtector.parse(r100).buildUpon().authority("webview").encodedPath("").appendQueryParameter("url", r101).build().toString();
        FLogger.f375446a.i("FlowAccountSaasAppHost", "openSchema: " + r104);
        com.bytedance.router.i r105 = SmartRouter.buildRoute(AppHost.f326268a.getApplication(), r104);
        r105.f267555d = R.anim.larus_router_slide_in_right;
        r105.f267556e = R.anim.larus_router_no_anim;
        r105.d();
        IApplog.Companion r106 = IApplog.f287053a;
        JSONObject r107 = new JSONObject();
        r107.put("schema", r104);
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("account_sdk_open_scheme", r107);
        JSONObject r109 = new JSONObject();
        r109.put("schema", r104);
        ApmAgent.monitorEvent("account_sdk_open_scheme", r109, null, null);
        return true;
    L13:
        if (r101.length() != 0) goto L15;
    L19:
        FLogger.f375446a.e("FlowAccountSaasAppHost", "openSchema schema or url is null, schema: " + r100 + ", url: " + r101);
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final boolean j(String r100, Map<String, ?> r101) {
        FLogger.f375446a.i("FlowAccountSaasAppHost", "openSchema: " + r100);
        com.bytedance.router.i r102 = SmartRouter.buildRoute(AppHost.f326268a.getApplication(), SchemaConstants.SCHEMA_WEBVIEW);
        r102.f267554c.putExtra("url", r100);
        r102.d();
        return true;
    }

    public final boolean k(String r100, Intent r101) {
        FLogger.f375446a.i("FlowAccountSaasAppHost", "openSchema raw: " + r100);
        com.bytedance.router.i r102 = SmartRouter.buildRoute(AppHost.f326268a.getApplication(), r100);
        if (r101 == null) goto L5;
        r102.f(r101);
    L5:
        r102.d();
        return true;
    }

    @Override // d48.c
    public boolean startActivity(Activity r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r101, "intent");
        ContextWrapper r102 = r100;
        if (r100 != null) goto L8;
        Activity r103 = currentActivity();
        r102 = r103;
        if (r103 != null) goto L8;
        r102 = AppHost.f326268a.getApplication();
    L8:
        if ((r102 instanceof Activity) == true) goto L10;
        r101.addFlags(268435456);
    L10:
        r102.startActivity(r101);
        return true;
    }
}
