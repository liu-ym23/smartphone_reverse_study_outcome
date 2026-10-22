package com.larus.office.base;

import android.app.Application;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.dora.device.api.IDoraDeviceInfo;
import com.larus.platform.api.IFlowOfficeThemeConfigProvider;
import com.larus.platform.api.UserAction;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.LarkSocialImModuleState;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKSharePanelType;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKShareScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.api.ILogoutCallback;
import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.OfficeSDKPassportUserAction;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.api.init.RuntimeStrategy;
import com.ss.android.lark.officesdk.launcher.load.OfficeLoadCoordinator;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.m2;
import hq9.v2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeSdkInitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeSdkInitor f360451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f360452b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile OfficeSDKUserApi f360453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile v2 f360454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static OfficeSDKGlobalApi f360455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static IOfficeSDKLifeCycle f360456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f360457g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile v2 f360458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile v2 f360459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile v2 f360460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f360461k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CoroutineScope f360462l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Job f360463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Job f360464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile OfficeSdkLoginType f360465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f360466p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final q0 f360467q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c f360468r = null;

    public interface a {
        void a(OfficeSDKUserApi r100);

        void b(OfficeSDKGlobalApi r100);
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360469a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f360470b = null;

        static {
            int[] r100 = new int[IOfficeSDKSharePanelType.values().length];
            r100[IOfficeSDKSharePanelType.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[IOfficeSDKSharePanelType.MERGE_FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[IOfficeSDKSharePanelType.SINGLE_FORWARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[IOfficeSDKSharePanelType.ASK_DOUBAO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f360469a = r100;
            int[] r101 = new int[IOfficeSDKShareScene.values().length];
            r101[IOfficeSDKShareScene.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[IOfficeSDKShareScene.REPLY_IN_THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[IOfficeSDKShareScene.MY_QR_CODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[IOfficeSDKShareScene.GROUP_QR_CODE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f360470b = r101;
        }
    }

    public static final class c implements com.larus.platform.api.b {
        public c() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            LarkSocialExp r101 = LarkSocialExp.f365340a;
            r101.getClass();
            v2 r102 = LarkSocialExp.a();
            if (r102 != null) goto L5;
        L8:
            FLogger r103 = FLogger.f375446a;
            r103.i("OfficeSdkInitor", "OfficeSDK registerAccountStatusCallback onLogIn");
            IFlowOfficeThemeConfigProvider r104 = (IFlowOfficeThemeConfigProvider) ServiceManager.get().getService(IFlowOfficeThemeConfigProvider.class);
            if (r104 == null) goto L11;
            Boolean r105 = Boolean.valueOf(r104.a(new k(), AdaptThemeFeatureKey.OFFICE_COPY_LINK_DIRECTLY));
        L12:
            r103.i("OfficeSdkInitor", "OfficeSDK OFFICE_COPY_LINK_DIRECTLY disableFeature=" + r105 + " imEnable=" + LarkSocialExp.f());
            if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L15;
        L16:
            OfficeSdkInitor r106 = OfficeSdkInitor.f360451a;
            OfficeSdkLoginType r107 = OfficeSdkLoginType.FULL_LOGIN;
            r106.getClass();
            OfficeSdkInitor.b(r107);
            return;
        L15:
            if (r101.c() == true) goto L16;
            return;
        L11:
            r105 = null;
            goto L12
        L5:
            if (Intrinsics.areEqual(r102.f486794a, r100.f364876b) == true) goto L8;
            FLogger.f375446a.w("OfficeSdkInitor", "ignore stale OfficeSDK online currentGeneration=" + r102.f486795b);
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            LarkSocialExp r100 = LarkSocialExp.f365340a;
            r100.getClass();
            v2 r101 = LarkSocialExp.a();
            boolean r102 = false;
            if (r101 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            v2 r104 = OfficeSdkInitor.f360459i;
            if (r104 == null) goto L11;
            String r105 = r104.f486794a;
        L13:
            if (Intrinsics.areEqual(r105, r110.f364876b) == true) goto L20;
            v2 r106 = OfficeSdkInitor.f360454d;
            if (r106 == null) goto L17;
            String r107 = r106.f486794a;
        L19:
            if (Intrinsics.areEqual(r107, r110.f364876b) == true) goto L20;
        L22:
            if (r103 == false) goto L30;
            if (r102 == true) goto L30;
            FLogger r111 = FLogger.f375446a;
            StringBuilder r108 = new StringBuilder("ignore stale OfficeSDK offline currentGeneration=");
            if (r101 == null) goto L27;
            long r109 = r101.f486795b;
        L28:
            r108.append(r109);
            r111.w("OfficeSdkInitor", r108.toString());
            return;
        L27:
            r109 = -1;
        L30:
            FLogger.f375446a.i("OfficeSdkInitor", "OfficeSDK registerAccountStatusCallback onLogout " + r110.f364878d);
            Job r112 = OfficeSdkInitor.f360463m;
            if (r112 == null) goto L33;
            Job.DefaultImpls.cancel$default(r112, null, 1, null);
        L33:
            OfficeSdkInitor.f360463m = null;
            OfficeSdkInitor.f360459i = null;
            if (r103 == true) goto L37;
            r101 = null;
        L37:
            OfficeSdkInitor.f360460j = r101;
            OfficeSdkInitor.f360453c = null;
            OfficeSdkInitor.f360454d = null;
            xp9.o.c(null);
            LarkSocialExp.f365345f = null;
            LarkSocialExp.f365347h = null;
            r100.n("office_user_unavailable");
            if (r110.f364878d != UserAction.ACCOUNT_SWITCH) goto L40;
            OfficeSDKPassportUserAction r113 = OfficeSDKPassportUserAction.SWITCH;
        L41:
            OfficeSdkInitor r114 = OfficeSdkInitor.f360451a;
            v2 r115 = OfficeSdkInitor.f360460j;
            r114.getClass();
            OfficeSdkInitor.h(r115, r113, "account_offline");
            return;
        L40:
            r113 = OfficeSDKPassportUserAction.LOGOUT;
            goto L41
        L17:
            r107 = null;
        L20:
            r102 = true;
            goto L22
        L11:
            r105 = null;
            goto L13
        L5:
            if (Intrinsics.areEqual(r101.f486794a, r110.f364876b) == true) goto L7;
            r103 = true;
            goto L8
        }
    }

    public static final class d implements ILogoutCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f360473a;

        public d(String r100) {
            this.f360473a = r100;
        }

        @Override // com.ss.android.lark.officesdk.api.ILogoutCallback
        public final void onLogoutError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.e("OfficeSdkInitor", "OfficeSDK logout error source=" + this.f360473a + ' ' + r100.getMessage(), r100);
            OfficeSdkInitor.f360461k.set(false);
            Lazy r101 = h.f360505a;
            Intrinsics.checkNotNullParameter(r100, "error");
            h.f("logout", r100);
            OfficeSdkInitor.f360451a.getClass();
            OfficeSdkInitor.i("logout_error");
        }

        @Override // com.ss.android.lark.officesdk.api.ILogoutCallback
        public final void onLogoutSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            FLogger.f375446a.i("OfficeSdkInitor", "OfficeSDK logout success source=" + this.f360473a);
            OfficeSdkInitor.f360461k.set(false);
            OfficeSdkInitor.f360451a.getClass();
            OfficeSdkInitor.i("logout_success");
        }
    }

    public OfficeSdkInitor() {
    }

    static {
        f360451a = new OfficeSdkInitor();
        f360452b = new AtomicBoolean(false);
        f360457g = new AtomicBoolean(false);
        f360461k = new AtomicBoolean(false);
        f360462l = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        f360465o = OfficeSdkLoginType.FAST_LOGIN;
        f360466p = LazyKt.lazy(new i());
        f360467q = new q0(0);
        f360468r = new c();
    }

    public static CopyOnWriteArrayList d() {
        return (CopyOnWriteArrayList) f360466p.getValue();
    }

    public static final List a(OfficeSdkInitor r100) {
        r100.getClass();
        ArrayList r101 = new ArrayList();
        JSONObject r102 = new JSONObject();
        com.larus.office.base.net.h r103 = com.larus.office.base.net.h.f360588a;
        String[] r104 = com.larus.network.ttnet.p.f360240a;
        com.larus.network.ttnet.a r105 = com.larus.network.ttnet.a.f360220a;
        HashMap r106 = new HashMap();
        Application r107 = AppHost.f326268a.getApplication();
        Level r108 = Level.L1;
        AppLog.putCommonParams(r107, r106, true, r108);
        IDoraDeviceInfo r109 = com.larus.network.ttnet.d.f360225a;
        r108.value();
        r106.putAll(com.larus.network.ttnet.d.a());
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r111 = r106.entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L8;
        Map.Entry r112 = (Map.Entry) r111.next();
        if (com.larus.office.base.net.h.f360590c.contains(r112.getKey()) == false) goto L4;
        r110.put(r112.getKey(), r112.getValue());
        goto L4
    L8:
        Iterator r113 = r110.entrySet().iterator();
    L10:
        if (r113.hasNext() == false) goto L12;
        Map.Entry r114 = (Map.Entry) r113.next();
        r102.put((String) r114.getKey(), r114.getValue());
        goto L10
    L12:
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put("x-lgw-custom-doubao", String.valueOf(r102));
        if (AppHost.f326268a.isTestChannel() == false) goto L17;
        Lazy r116 = com.larus.network.m.f360210a;
        if ((!StringsKt.isBlank(com.larus.network.m.f360213d)) == false) goto L17;
        r115.put("env", com.larus.network.m.f360213d);
    L17:
        r101.add(new HostUriParamGroup(null, r115));
        return r101;
    }

    public static void b(OfficeSdkLoginType r110) {
        LarkSocialExp.f365340a.getClass();
        v2 r100 = LarkSocialExp.a();
        if (r100 != null) goto L6;
        return;
    L6:
        if (f360461k.get() == false) goto L9;
        f360460j = r100;
        FLogger.f375446a.i("OfficeSdkInitor", "OfficeSDK queue login while logout is in flight generation=" + r100.f486795b);
        return;
    L9:
        v2 r101 = f360459i;
        if (Intrinsics.areEqual(r101, r100) == false) goto L13;
        FLogger.f375446a.i("OfficeSdkInitor", "OfficeSDK login already pending generation=" + r100.f486795b);
        return;
    L13:
        if (r101 != null) goto L15;
    L18:
        v2 r102 = f360454d;
        if (r102 == null) goto L25;
        if (Intrinsics.areEqual(r102, r100) == true) goto L25;
        h(r100, OfficeSDKPassportUserAction.SWITCH, "replace_ready_user");
        return;
    L25:
        if (Intrinsics.areEqual(r102, r100) == true) goto L27;
    L30:
        IUserManager r103 = OfficeSDK.a();
        if (r103 == null) goto L35;
        i1<IOnlineOfflineService.State> r104 = r103.loginState();
        if (r104 == null) goto L35;
        IOnlineOfflineService.State r105 = r104.getValue();
    L36:
        FLogger r106 = FLogger.f375446a;
        r106.i("OfficeSdkInitor", "OfficeSDK current loginState=" + r105);
        boolean r107 = true;
        if (Intrinsics.areEqual(r105, IOnlineOfflineService.State.Offline.INSTANCE) == false) goto L46;
        Job r108 = f360463m;
        if (r108 == null) goto L41;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L41:
        f360463m = null;
        if (xp9.n.f564774a == null) goto L61;
        f360459i = r100;
        f360467q.b(r110);
        IUserManager r111 = OfficeSDK.a();
        if (r111 == null) goto L62;
        r111.login(new l(r100));
        return;
    L62:
        return;
    L61:
        return;
    L46:
        if (r103 == null) goto L64;
        Job r109 = f360463m;
        if (r109 != null) goto L50;
    L52:
        r107 = false;
    L53:
        if (r107 == true) goto L55;
        f360465o = r110;
        f360463m = BuildersKt.launch$default(f360462l, null, null, new OfficeSdkInitor$callOfficeSdkLogin$1(r103, null), 3, null);
        return;
    L55:
        if (r110 != OfficeSdkLoginType.FULL_LOGIN) goto L57;
        f360465o = r110;
    L57:
        r106.i("OfficeSdkInitor", "OfficeSDK already waiting for loginState Offline");
        return;
    L50:
        if (r109.isActive() != true) goto L52;
    L64:
        return;
    L35:
        r105 = null;
        goto L36
    L27:
        if (f360453c == null) goto L30;
        c("login_already_ready");
        return;
    L15:
        if (Intrinsics.areEqual(r101, r100) == true) goto L18;
        h(r100, OfficeSDKPassportUserAction.SWITCH, "replace_pending_login");
    }

    public static void c(String r110) {
        LarkSocialExp r100 = LarkSocialExp.f365340a;
        r100.getClass();
        v2 r101 = LarkSocialExp.a();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.c() == true) goto L8;
        return;
    L8:
        if (f360453c != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(f360454d, r101) == true) goto L13;
        return;
    L13:
        if (((m2) LarkSocialExp.f365344e.getValue()).f486677f != LarkSocialImModuleState.READY) goto L17;
        g(r101, "module_already_ready_".concat(r110));
        return;
    L17:
        if (com.larus.platform.exp.q.f365393a.b() == false) goto L24;
        if (f360457g.compareAndSet(false, true) == false) goto L21;
        FLogger.f375446a.i("OfficeSdkInitor_Lifecycle", "OfficeSDK launch-prewarmed IM awaiting runtime dependencies source=".concat(r110));
    L21:
        g(r101, "launch_prewarm_".concat(r110));
        return;
    L24:
        if (f360457g.compareAndSet(false, true) == true) goto L26;
        return;
    L26:
        FLogger.f375446a.i("OfficeSdkInitor_Lifecycle", "OfficeSDK load IM source=".concat(r110));
        f360458h = r101;
        r100.j(r101);
        h.e();
        OfficeBizType r111 = OfficeBizType.IM;
        AtomicBoolean r102 = OfficeSDK.f433090a;
        RuntimeStrategy r103 = RuntimeStrategy.MAIN;
        Intrinsics.checkNotNullParameter(r111, "bizType");
        Intrinsics.checkNotNullParameter(r103, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Log.i("OfficeSDK", "load called, bizType=" + r111 + ", strategy=" + r103);
        OfficeLoadCoordinator.f433452a.getClass();
        OfficeLoadCoordinator.c(r111, r103);
        Job r112 = f360464n;
        if (r112 == null) goto L29;
        Job.DefaultImpls.cancel$default(r112, null, 1, null);
    L29:
        f360464n = BuildersKt.launch$default(f360462l, null, null, new OfficeSdkInitor$startImLoadTimeoutCheck$1(r101, null), 3, null);
    }

    public static void i(String r100) {
        v2 r101 = f360460j;
        if (r101 != null) goto L5;
        return;
    L5:
        LarkSocialExp r102 = LarkSocialExp.f365340a;
        r102.getClass();
        v2 r103 = LarkSocialExp.a();
        if (Intrinsics.areEqual(r101, r103) == true) goto L17;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("replace stale queued OfficeSDK login source=");
        r105.append(r100);
        r105.append(" retryGeneration=");
        r105.append(r101.f486795b);
        r105.append(" currentGeneration=");
        if (r103 == null) goto L10;
        long r106 = r103.f486795b;
    L11:
        r105.append(r106);
        r104.w("OfficeSdkInitor", r105.toString());
        f360460j = null;
        if (r103 != null) goto L14;
        return;
    L14:
        if (r102.c() == false) goto L20;
        b(OfficeSdkLoginType.FULL_LOGIN);
        return;
    L20:
        return;
    L10:
        r106 = -1;
        goto L11
    L17:
        f360460j = null;
        b(OfficeSdkLoginType.FULL_LOGIN);
    }

    public static void g(v2 r100, String r101) {
        if (f360453c != null) goto L5;
    L9:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L17;
        LarkSocialExp r103 = LarkSocialExp.f365340a;
        if (r103.c() == false) goto L17;
        FLogger.f375446a.i("OfficeSdkInitor_Lifecycle", "IM runtime ready source=" + r101 + " generation=" + r100.f486795b);
        r103.k(r100);
        h.g("office_sdk_load_im_success");
        return;
    L17:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("ignore stale IM ready source=");
        r105.append(r101);
        r105.append(" generation=");
        r105.append(r100.f486795b);
        r105.append(" currentGeneration=");
        LarkSocialExp.f365340a.getClass();
        v2 r106 = LarkSocialExp.a();
        if (r106 == null) goto L20;
        long r107 = r106.f486795b;
    L21:
        r105.append(r107);
        r104.w("OfficeSdkInitor_Lifecycle", r105.toString());
        return;
    L20:
        r107 = -1;
        goto L21
    L5:
        if (Intrinsics.areEqual(f360454d, r100) == false) goto L9;
        LarkSocialExp.f365340a.getClass();
        if (Intrinsics.areEqual(LarkSocialExp.a(), r100) == false) goto L9;
        r102 = true;
        goto L11
    }

    public final void e(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r101, "source");
        f(null, r100, r101, false);
    }

    public static void h(v2 r100, OfficeSDKPassportUserAction r101, String r110) {
        f360459i = null;
        Job r102 = f360463m;
        boolean r103 = true;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        f360463m = null;
        f360453c = null;
        f360454d = null;
        xp9.o.c(null);
        LarkSocialExp r104 = LarkSocialExp.f365340a;
        r104.getClass();
        LarkSocialExp.f365345f = null;
        LarkSocialExp.f365347h = null;
        r104.n("office_user_unavailable");
        AtomicBoolean r105 = f360461k;
        if (r105.compareAndSet(false, true) == true) goto L15;
        if (r100 == null) goto L9;
        f360460j = r100;
    L9:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("OfficeSDK logout already in flight source=");
        r107.append(r110);
        r107.append(" hasRetry=");
        if (r100 != null) goto L13;
        r103 = false;
    L13:
        r107.append(r103);
        r106.i("OfficeSdkInitor", r107.toString());
        return;
    L15:
        f360460j = r100;
        IUserManager r108 = OfficeSDK.a();
        if (r108 != null) goto L19;
        r105.set(false);
        i("logout_no_user_manager");
        return;
    L19:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("OfficeSDK logout source=");
        r111.append(r110);
        r111.append(" hasRetry=");
        if (r100 != null) goto L23;
        r103 = false;
    L23:
        r111.append(r103);
        r109.i("OfficeSdkInitor", r111.toString());
        r108.logout(new d(r110), r101);
    }

    public static void f(final OfficeSDKInitConfig.InitStageConfig r100, final a r101, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r110, "source");
        OfficeSDKUserApi r102 = f360453c;
        if (r102 == null) goto L8;
        v2 r103 = f360454d;
        LarkSocialExp.f365340a.getClass();
        if (Intrinsics.areEqual(r103, LarkSocialExp.a()) == false) goto L8;
        r101.a(r102);
        FLogger.f375446a.i("OfficeSdkInitor", "initOfficeSDK return for already has user message");
        return;
    L8:
        d().addIfAbsent(r101);
        OfficeSDKUserApi r104 = f360453c;
        v2 r105 = f360454d;
        if (r104 == null) goto L23;
        LarkSocialExp.f365340a.getClass();
        if (Intrinsics.areEqual(r105, LarkSocialExp.a()) == false) goto L23;
        if (d().remove(r101) == false) goto L23;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L16
        r101.a(r104);     // Catch: Throwable -> L16
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L45;
        FLogger.f375446a.e("OfficeSdkInitor_Lifecycle", "Notify Office user ready after registration failed", r108);
        return;
    L45:
        return;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        if (r111 == false) goto L25;
    L27:
        f360452b.set(true);
        Lazy r112 = h.f360505a;
        Intrinsics.checkNotNullParameter(r110, "source");
        h.f360506b = SystemClock.elapsedRealtime();
        h.f360507c = 0;
        h.f360508d = 0;
        h.f360509e++;
        if ((!StringsKt.isBlank(r110)) == false) goto L30;
        String r113 = r110;
    L31:
        String r114 = "unknown";
        if (r113 != null) goto L34;
        r113 = "unknown";
    L34:
        h.f360510f = r113;
        h.f360511g = AccountService.f365697a.isLogin().booleanValue() ? 1 : 0;
        h.f360513i.set(false);
        h.f360514j.set(false);
        final int r115 = h.f360509e;
        ((Handler) h.f360505a.getValue()).postDelayed(new g(r115), z2.f365865a.getLarkMixedFeedMonitorConfig().b());
        FLogger.f375446a.i("OfficeSdkInitMonitor", "markLoadStart source=" + h.f360510f + " isInitLogin=" + h.f360511g);
        q0 r116 = f360467q;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "source");
        if ((!StringsKt.isBlank(r110)) == true) goto L38;
        r110 = null;
    L38:
        if (r110 == null) goto L41;
        r114 = r110;
    L41:
        r116.f361044c = r114;
        LarkContext.setApplication(AppHost.f326268a.getApplication());
        IApplog.f287053a.f(new j(r100, r101));
        return;
    L30:
        r113 = null;
        goto L31
    L25:
        if (f360452b.compareAndSet(false, true) == true) goto L27;
    }
}
