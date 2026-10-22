package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class NoPermissionModuleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.security.compliance.infra.network.userscpoe.a f418101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f418102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k8b.c f418103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<NoPermissionType> f418104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f418105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f418106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f418107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f418108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<Activity> f418109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f418110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<Boolean> f418111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f418112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<String, n4c.a> f418113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f418114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f418115o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Handler f418116p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f418117q;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qnc.e f418118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final qnc.b f418119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final qnc.c.a f418120c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f418118a, r101.f418118a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f418119b, r101.f418119b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f418120c, r101.f418120c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f418118a.hashCode() * 31) + this.f418119b.hashCode()) * 31) + this.f418120c.hashCode();
        }

        public final String toString() {
            return "PendingNavRequest(source=" + this.f418118a + ", request=" + this.f418119b + ", chain=" + this.f418120c + ')';
        }

        public b(qnc.e r100, qnc.b r101, qnc.c.a r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "request");
            Intrinsics.checkNotNullParameter(r102, "chain");
            this.f418118a = r100;
            this.f418119b = r101;
            this.f418120c = r102;
        }
    }

    public static final class c implements qnc.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionModuleManager f418121a;

        public c(NoPermissionModuleManager r100) {
            this.f418121a = r100;
        }

        @Override // qnc.c
        public final boolean a(qnc.e r100, qnc.a r101, qnc.d r102) {
            return qnc.g.a.a(r100, r101, r102);
        }

        @Override // qnc.c
        public final void b(qnc.e r100, qnc.b r101, qnc.d r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "request");
            Intrinsics.checkNotNullParameter(r102, "chain");
            int r103 = ScsLogger.f440428a;
            StringBuilder r104 = new StringBuilder("interceptNavigate ");
            r104.append(r101.f534128a);
            r104.append(", hasArgs=");
            if (r101.f534129b == null) goto L5;
            boolean r105 = true;
        L6:
            r104.append(r105);
            ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r104.toString());
            NoPermissionModuleManager.d(this.f418121a, true, r100, r101, r102);
            return;
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionModuleManager f418122a;

        public d(NoPermissionModuleManager r100) {
            this.f418122a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ScsLogger.e("SecurityPolicy_NoPermissionModuleManager", "CALL ACTIVITY FAILED, RELEASE");     // Catch: Throwable -> L4
            this.f418122a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void f() {
        int r100 = ScsLogger.f440428a;
        StringBuilder r101 = new StringBuilder("gotoCurrentNoPermissionActivity, type: ");
        NoPermissionType r102 = this.f418104d.get();
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r101.append(r103);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r101.toString());
        NoPermissionType r104 = this.f418104d.get();
        if (r104 == null) goto L28;
        UserSession r105 = this.f418102b.b();
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "[start show page], realGotoNoPermissionActivity, type:" + r104);
        Handler r106 = this.f418116p;
        if (r106 == null) goto L11;
        r106.removeCallbacks(this.f418117q);
    L11:
        this.f418116p = null;
        if (r105 != null) goto L14;
        ScsLogger.c("SecurityPolicy_NoPermissionModuleManager", "realGotoNoPermissionActivity, userSession is null!");
        FileAuthMonitor.o("RESPONSE_HEADER", "", "userSessionNull");
        FileAuthMonitor.AccessControlScene r107 = FileAuthMonitor.AccessControlScene.OpenNoPermissionPage;
        Intrinsics.checkNotNullParameter(r107, "scene");
        String r108 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_usersession_null", MapsKt.mapOf(TuplesKt.to("scene", r107.name())), null, null, 0, 28);
        i();
        this.f418111k.postValue(Boolean.FALSE);
        return;
    L14:
        Activity r109 = AppLifecycle.a.f408803a.f();
        if (r109 != null) goto L18;
    L19:
        boolean r110 = false;
    L21:
        if (r110 == true) goto L30;
        Handler r111 = new Handler(Looper.getMainLooper());
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "setup timer");
        r111.postDelayed(this.f418117q, 5000);
        this.f418116p = r111;
        Application r112 = LarkContext.getApplication();
        int r113 = NoPermissionActivity.f418237n;
        Intrinsics.checkNotNull(r112);
        Bundle r114 = this.f418105e;
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "noPermissionType");
        Intrinsics.checkNotNullParameter(r114, "extra");
        Intrinsics.checkNotNullParameter(r105, "userSession");
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "startUi: extra: " + r114 + ", type: " + r104.getValue());
        Intent r115 = new Intent(r112, NoPermissionActivity.class);
        PassportcConvention.g(r115, r105);
        r115.putExtra("unauthorized_type", r104.getValue());
        r115.putExtra("biz_extra", r114);
        if ((r112 instanceof Activity) == true) goto L26;
        r115.addFlags(268435456);
    L26:
        r115.putExtra("can_be_covered", false);
        r112.startActivity(r115);
        FileAuthMonitor.UpdateTrigger[] r116 = FileAuthMonitor.f418450a;
        FileAuthMonitor.b(FileAuthMonitor.AccessControlScene.OpenNoPermissionPage);
        return;
    L30:
        return;
    L18:
        if (h(r109) == false) goto L19;
        r110 = true;
        this.f418108h = true;
        this.f418109i = new WeakReference(r109);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "defer no permission activity for protected oauth web container");
        goto L21
    L28:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void g() {
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new NoPermissionModuleManager$handleNoPermissionAction$1(this, null), 3, null);
    }

    public final void i() {
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new NoPermissionModuleManager$release$1(this, null), 3, null);
    }

    public final void j() {
        i();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new NoPermissionModuleManager$releaseOnLogout$1(null), 3, null);
    }

    public static final void b(NoPermissionModuleManager r100) {
        String r101 = com.ss.android.lark.security.compliance.infra.util.f.c((InternalSecurityAction) r100.f418105e.getParcelable("param_action"));     // Catch: Exception -> L4
    L5:
        n4c.a r102 = r100.f418113m.get(r100.f418110j);
        if (r102 == null) goto L11;
        NoPermissionType r103 = r100.f418104d.get();
        if (r103 == null) goto L10;
        r103.name();
    L10:
        Intrinsics.checkNotNull(r101);
        r102.b();
        Unit r104 = Unit.INSTANCE;
    L12:
        if (r104 != null) goto L14;
        int r105 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "currentInterceptor " + r100.f418110j + " not found, default handle");
        r100.f();
        return;
    L14:
        r100.f418111k.postValue(Boolean.FALSE);
        return;
    L11:
        r104 = null;
    L4:
        r101 = "";
        goto L5
    }

    public static final String c(NoPermissionModuleManager r100) {
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "searchInterceptor, currentInterceptor: " + r100.f418110j);
        if (r100.f418110j.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = r100.f418110j;
    L16:
        int r104 = ScsLogger.f440428a;
        StringBuilder r105 = new StringBuilder("searchInterceptor, destInterceptor: ");
        String r106 = r103;
        r105.append(r106);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r105.toString());
        return r106;
    L8:
        Iterator<Map.Entry<String, n4c.a>> r107 = r100.f418113m.entrySet().iterator();
    L10:
        if (r107.hasNext() == false) goto L15;
        Map.Entry<String, n4c.a> r108 = r107.next();
        if (r108.getValue().a() == true) goto L13;
        int r109 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "biz: " + r108.getValue().getBizName() + ", need: false");
        goto L10
    L13:
        int r110 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "biz: " + r108.getValue().getBizName() + ", need: true");
        r103 = r108.getKey();
        goto L16
    L15:
        r103 = "scs_interceptor";
        goto L16
    L5:
        r102 = false;
        goto L6
    }

    public final void e(String r100) {
        if (this.f418108h == false) goto L5;
    L6:
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "clear deferred no permission activity, reason=".concat(r100));
    L7:
        this.f418108h = false;
        this.f418109i = null;
        return;
    L5:
        if (this.f418109i == null) goto L7;
        goto L6
    }

    public final boolean h(Activity r100) {
        if (this.f418103c.n(r100) == false) goto L13;
        Intent r101 = r100.getIntent();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.getBooleanExtra("can_be_covered", true) == true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public final boolean k(NoPermissionType r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "noPermissionType");
        Intrinsics.checkNotNullParameter(r111, "extra");
        int r100 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "setCurrentNoPermissionType: enter, type=" + r110.name() + ", mainPageStack=0, hasAction=" + r111.containsKey("param_action"));
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L9;
        ScsLogger.e("SecurityPolicy_NoPermissionModuleManager", "setCurrentUnauthorizedType fail, mainPageLaunchedInStack: 0");
        if (this.f418104d.get() != null) goto L11;
        ScsLogger.e("SecurityPolicy_NoPermissionModuleManager", "_isProcessingNoPermission set true");
        this.f418111k.postValue(Boolean.TRUE);
        return false;
    L11:
        return false;
    L9:
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new NoPermissionModuleManager$setCurrentNoPermissionType$1(this, r110, r111, qqb.a.d(), null), 3, null);
        return true;
    }

    public final void l(String r100, Activity r101) {
        if (this.f418108h == true) goto L6;
        return;
    L6:
        if (this.f418104d.get() != null) goto L8;
    L23:
        e("invalid_no_permission_state");
        return;
    L8:
        if (this.f418107g == true) goto L23;
        AppLifecycle r102 = AppLifecycle.a.f408803a;
        Activity r103 = r102.f();
        if (r103 == null) goto L18;
        if (r103 == r101) goto L18;
        if (h(r103) == false) goto L18;
        this.f418109i = new WeakReference(r103);
        int r104 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "deferred no permission still waits protected oauth, reason=".concat(r100));
        return;
    L18:
        if (r102.h() == true) goto L21;
        int r105 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "deferred no permission waits app foreground, reason=".concat(r100));
        return;
    L21:
        this.f418108h = false;
        this.f418109i = null;
        int r106 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "resume deferred no permission activity, reason=".concat(r100));
        f();
    }

    @Inject
    public NoPermissionModuleManager(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100, com.ss.android.lark.passportc.api.j r101, k8b.c r102) {
        Intrinsics.checkNotNullParameter(r100, "scRequest");
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "conditionalAccessDependency");
        this.f418101a = r100;
        this.f418102b = r101;
        this.f418103c = r102;
        this.f418104d = new AtomicReference();
        this.f418105e = new Bundle();
        this.f418106f = "";
        this.f418110j = "";
        this.f418111k = new MutableLiveData();
        this.f418112l = new CopyOnWriteArrayList();
        this.f418113m = new HashMap();
        this.f418114n = true;
        this.f418115o = new c(this);
        this.f418117q = new d(this);
    }

    public static final boolean a(NoPermissionModuleManager r100, Activity r101, String r102) {
        if (r100.h(r101) == true) goto L5;
        return false;
    L5:
        r100.f418109i = new WeakReference(r101);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "protected oauth web container bound, scene=".concat(r102));
        return true;
    }

    public static final void d(NoPermissionModuleManager r100, boolean r101, qnc.e r102, qnc.b r110, qnc.c.a r111) {
        r100.getClass();
        List<String> r103 = w4c.c.a().w0();
        String r104 = null;
        if (Intrinsics.areEqual(r110.f534128a, "webview_activity") == true) goto L5;
    L47:
        if (r104 == null) goto L61;
        Bundle r105 = r110.f534129b;
        if (r105 == null) goto L51;
        r105.putBoolean("can_be_covered", false);
    L51:
        int r106 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "mark protected oauth web route, identity: ".concat(r104));
        if (r101 == false) goto L57;
        if (r100.f418114n == false) goto L57;
        new Handler(Looper.getMainLooper()).postDelayed(new i(r100, r102, r110, r111), 200);
    L60:
        r100.f418114n = false;
        return;
    L57:
        if (Intrinsics.areEqual(r100.f418111k.getValue(), Boolean.TRUE) == false) goto L59;
        r100.f418112l.add(new b(r102, r110, r111));
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "pendingNavRequests " + r100.f418112l.size() + ", identity: " + r104);
        goto L60
    L59:
        r111.a(r102, r110);
        goto L60
    L61:
        r111.a(r102, r110);
        return;
    L5:
        if (r103.isEmpty() == true) goto L47;
        Bundle r107 = r110.f534129b;
        if (r107 == null) goto L47;
        String r108 = r107.getString("app_id");
        boolean r109 = true;
        if (r108 != null) goto L13;
    L16:
        boolean r112 = true;
    L17:
        if (r112 == false) goto L19;
    L21:
        String r113 = r107.getString("url");
        if (r113 != null) goto L25;
        r113 = "";
    L25:
        if (r113.length() != 0) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == true) goto L47;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L32
        Object r116 = Result.m9449constructorimpl(UriProtector.getQueryParameter(UriProtector.parse(r113), "client_id"));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r116) == false) goto L37;
        r116 = null;
    L37:
        String r117 = (String) r116;
        if (r117 != null) goto L40;
    L43:
        if (r109 == true) goto L47;
        if (r103.contains(r117) == false) goto L47;
        r104 = "client_id=" + r117;
        goto L47
    L40:
        if (r117.length() == 0) goto L43;
        r109 = false;
    L32:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L27:
        r114 = false;
        goto L28
    L19:
        if (r103.contains(r108) == false) goto L21;
        r104 = "app_id=" + r108;
        goto L47
    L13:
        if (r108.length() == 0) goto L16;
        r112 = false;
        goto L17
    }
}
