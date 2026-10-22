package com.larus.login.impl;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.PhoneLoginAccountDiscoverySource;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.login.api.AccountTrackService;
import com.larus.login.api.DouyinConversationAuthService;
import com.larus.login.api.DouyinConversationAuthTriggerScene;
import com.larus.login.api.IAccountTrackApi;
import com.larus.login.api.TouristManager;
import com.larus.login.impl.impl.AccountTrace;
import com.larus.login.impl.lark_discover.PhoneLoginAccountDiscovery;
import com.larus.login.impl.lark_discover.PhoneLoginAccountDiscoverySession;
import com.larus.login.impl.logindialog.LoginOptionsDialogFragment;
import com.larus.nova.R;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f357729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f357730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, LoginPlatform> f357731c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f357732a = null;

        static {
            int[] r100 = new int[LoginPlatform.values().length];
            r100[LoginPlatform.GOOGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[LoginPlatform.LINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[LoginPlatform.FACEBOOK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[LoginPlatform.DOUYIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[LoginPlatform.WEIXIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f357732a = r100;
        }
    }

    public static final class b implements n38.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f357733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f357734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f357735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f357736d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Fragment f357737e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.larus.common_ui.dialog.l0 f357738f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f357739g;

        @Override // n38.h
        public final void b(LoginPlatform r110, String r111, Boolean r112) {
            DouyinConversationAuthService.f356984a.b(DouyinConversationAuthTriggerScene.DOUYIN_LOGIN);
            if (IAccountService.f286094a.h() == true) goto L5;
            AccountUtils r113 = AccountUtils.f357130a;
            AccountUtils.s("DouyinLogin");
        L6:
            TouristManager.f357001a.g();
            AccountTrackService r100 = AccountTrackService.f356934a;
            r100.a("douyin", System.currentTimeMillis() - this.f357733a);
            IAccountTrackApi.a.c(r100, "douyin", 1, this.f357734b, this.f357735c, null, null, null, null, this.f357736d, null, 704);
            return;
        L5:
            int r114 = WhiteListChecker.f357247a;
            WhiteListChecker.b();
            AccountUtils r115 = AccountUtils.f357130a;
            AccountUtils.s("DouyinLogin");
            goto L6
        }

        public b(long r100, String r101, String r102, String r103, Fragment r104, com.larus.common_ui.dialog.l0 r105, boolean r106) {
            this.f357733a = r100;
            this.f357734b = r101;
            this.f357735c = r102;
            this.f357736d = r103;
            this.f357737e = r104;
            this.f357738f = r105;
            this.f357739g = r106;
        }

        @Override // n38.h
        public final void a(LoginPlatform r210, int r211, String r212, String r213, String r214, Integer r215, String r216, Map r217) {
            String r100 = "";
            if (r211 != 1041) goto L5;
        L64:
            t19.s r101 = t19.s.f544207a;
            Fragment r102 = this.f357737e;
            if (r102 == null) goto L67;
            Context r103 = r102.getContext();
        L68:
            if (r212 == null) goto L71;
            r100 = r212;
        L71:
            r101.getClass();
            t19.s.c(r103, r100);
        L72:
            h0 r104 = h0.f357729a;
            Fragment r105 = this.f357737e;
            if (r105 == null) goto L75;
            FragmentActivity r106 = r105.getActivity();
        L76:
            com.larus.common_ui.dialog.l0 r107 = this.f357738f;
            r104.getClass();
            h0.q(r106, r107);
            AccountTrackService r108 = AccountTrackService.f356934a;
            r108.a("douyin", System.currentTimeMillis() - this.f357733a);
            String r110 = this.f357734b;
            String r111 = this.f357735c;
            String r112 = String.valueOf(r211);
            if (r215 == null) goto L79;
            String r113 = r215.toString();
        L80:
            IAccountTrackApi.a.c(r108, "douyin", 0, r110, r111, r112, r212, r113, r216, this.f357736d, null, 512);
            h0.e(r104, this.f357737e, r210, r211, r212, r213, r214);
            if (this.f357739g == false) goto L89;
            if (r211 != (-1009)) goto L90;
            Fragment r109 = this.f357737e;
            if (r109 == null) goto L91;
            FragmentActivity r114 = r109.getActivity();
            if (r114 == null) goto L92;
            r114.finish();
            return;
        L92:
            return;
        L91:
            return;
        L90:
            return;
        L89:
            return;
        L79:
            r113 = null;
            goto L80
        L75:
            r106 = null;
            goto L76
        L67:
            r103 = null;
            goto L68
        L5:
            if (com.larus.login.api.i0.f357058b.contains(Integer.valueOf(r211)) == true) goto L64;
            if (r211 != (-1009)) goto L40;
            com.larus.platform.service.z2 r115 = com.larus.platform.service.z2.f365865a;
            FlowDowngradeToastConfig r116 = r115.getFlowDowngradeToastConfig();
            if (r116 == null) goto L12;
            String r117 = r116.getTrafficDegradationLogInDisableCn();
        L13:
            if (r117 != null) goto L15;
        L18:
            boolean r118 = true;
        L19:
            if (r118 == false) goto L28;
            Fragment r119 = this.f357737e;
            if (r119 == null) goto L33;
            Context r120 = r119.getContext();
            if (r120 == null) goto L33;
            String r121 = r120.getString(R.string.larus_trafficDegradation_logInDisable_cn);
            if (r121 == null) goto L33;
            String r122 = r121;
        L34:
            t19.s r123 = t19.s.f544207a;
            Fragment r124 = this.f357737e;
            if (r124 == null) goto L37;
            Context r125 = r124.getContext();
        L38:
            t19.s.j(r123, r125, r122, null, false, 28);
            IApplog.Companion r126 = IApplog.f287053a;
            JSONObject r127 = new JSONObject();
            r127.put("current_page", "login_home");
            Unit r128 = Unit.INSTANCE;
            r126.reportEvent("login_error_toast", r127);
            goto L72
        L37:
            r125 = null;
        L33:
            r122 = r100;
            goto L34
        L28:
            FlowDowngradeToastConfig r129 = r115.getFlowDowngradeToastConfig();
            if (r129 == null) goto L31;
            String r130 = r129.getTrafficDegradationLogInDisableCn();
        L32:
            r100 = String.valueOf(r130);
            goto L33
        L31:
            r130 = null;
            goto L32
        L15:
            if (r117.length() == 0) goto L18;
            r118 = false;
            goto L19
        L12:
            r117 = null;
            goto L13
        L40:
            if (r211 != 4048) goto L55;
            t19.s r131 = t19.s.f544207a;
            Fragment r132 = this.f357737e;
            if (r132 == null) goto L44;
            Context r133 = r132.getContext();
        L45:
            Fragment r134 = this.f357737e;
            if (r134 == null) goto L53;
            Context r135 = r134.getContext();
            if (r135 == null) goto L53;
            String r136 = r135.getString(R.string.larus_account_risk_modal_toast_changeLogin);
            if (r136 == null) goto L53;
            r100 = r136;
        L53:
            r131.getClass();
            t19.s.t(r133, r100);
            IApplog.Companion r137 = IApplog.f287053a;
            JSONObject r138 = new JSONObject();
            r138.put("current_page", this.f357734b);
            Unit r139 = Unit.INSTANCE;
            r137.reportEvent("account_risk_toast", r138);
            goto L72
        L44:
            r133 = null;
            goto L45
        L55:
            if (com.larus.login.api.i0.f357057a.contains(Integer.valueOf(r211)) == false) goto L72;
            t19.s r140 = t19.s.f544207a;
            Fragment r141 = this.f357737e;
            if (r141 == null) goto L59;
            Context r142 = r141.getContext();
        L60:
            if (r212 != null) goto L62;
            String r143 = "";
        L63:
            t19.s.j(r140, r142, r143, null, false, 28);
            goto L72
        L62:
            r143 = r212;
            goto L63
        L59:
            r142 = null;
            goto L60
        }
    }

    public static final class c implements n38.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f357740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f357741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f357742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.larus.common_ui.dialog.l0 f357743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f357744e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f357745f;

        @Override // n38.h
        public final void b(LoginPlatform r100, String r101, Boolean r102) {
            AccountUtils r103 = AccountUtils.f357130a;
            AccountUtils.s("PhoneLogin");
            TouristManager.f357001a.g();
            h0 r104 = h0.f357729a;
            String r105 = this.f357740a;
            String r106 = this.f357741b;
            Fragment r107 = this.f357742c;
            if (r107 == null) goto L7;
            Bundle r108 = r107.getArguments();
            if (r108 == null) goto L7;
            String r109 = r108.getString("key_trigger_app_id");
        L8:
            h0.d(r104, "login_tel_sdk_confirm", r105, r106, r109);
            return;
        L7:
            r109 = null;
            goto L8
        }

        public c(String r100, String r101, Fragment r102, com.larus.common_ui.dialog.l0 r103, Function0<Unit> r104, boolean r105) {
            this.f357740a = r100;
            this.f357741b = r101;
            this.f357742c = r102;
            this.f357743d = r103;
            this.f357744e = r104;
            this.f357745f = r105;
        }

        @Override // n38.h
        public final void a(LoginPlatform r110, int r111, String r112, String r210, String r211, Integer r212, String r213, Map r214) {
            h0 r100 = h0.f357729a;
            Fragment r101 = this.f357742c;
            if (r101 == null) goto L5;
            FragmentActivity r102 = r101.getActivity();
        L6:
            com.larus.common_ui.dialog.l0 r103 = this.f357743d;
            r100.getClass();
            h0.q(r102, r103);
            if (r111 != 1454) goto L34;
            if (r214 == null) goto L10;
            Object r104 = r214.get(EventConstant.Key.RAW_DATA);
        L12:
            if ((r104 instanceof String) == false) goto L14;
            String r105 = (String) r104;
        L15:
            yj9.j.f568109a.getClass();
            PhoneLoginAccountDiscovery r106 = yj9.j.a(r105);
            if (r106 == null) goto L105;
            Fragment r107 = this.f357742c;
            PhoneLoginAccountDiscoverySource r108 = PhoneLoginAccountDiscoverySource.CARRIER_ONE_KEY;
            if (r107 == null) goto L22;
            Bundle r109 = r107.getArguments();
            if (r109 == null) goto L22;
            String r113 = r109.getString("key_trigger_app_id");
        L23:
            if (r107 == null) goto L27;
            Bundle r114 = r107.getArguments();
            if (r114 == null) goto L27;
            String r115 = r114.getString("pending_deeplink_schema");
        L28:
            PhoneLoginAccountDiscoverySession r116 = new PhoneLoginAccountDiscoverySession(null, r106, r108, r113, r115);
            if (r107 == null) goto L31;
            FragmentActivity r117 = r107.getActivity();
        L32:
            com.bytedance.router.i r118 = SmartRouter.buildRoute(r117, "//flow/phone_login_account_discovery");
            r118.f267554c.putExtra("phone_login_account_discovery_session", r116);
            r118.d();
            return;
        L31:
            r117 = null;
        L27:
            r115 = null;
        L22:
            r113 = null;
            goto L23
        L105:
            return;
        L14:
            r105 = null;
            goto L15
        L10:
            r104 = null;
            goto L12
        L34:
            String r119 = "";
            if (r111 != (-1009)) goto L62;
            com.larus.platform.service.z2 r120 = com.larus.platform.service.z2.f365865a;
            FlowDowngradeToastConfig r121 = r120.getFlowDowngradeToastConfig();
            if (r121 == null) goto L39;
            String r122 = r121.getTrafficDegradationLogInDisableCn();
        L40:
            if (r122 != null) goto L42;
        L45:
            boolean r123 = true;
        L46:
            if (r123 == false) goto L54;
            Fragment r124 = this.f357742c;
            if (r124 == null) goto L53;
            Context r125 = r124.getContext();
            if (r125 == null) goto L53;
            String r126 = r125.getString(R.string.larus_trafficDegradation_logInDisable_cn);
            if (r126 == null) goto L53;
        L59:
            String r127 = r126;
        L60:
            t19.s.j(t19.s.f544207a, AppHost.f326268a.getApplication(), r127, null, false, 28);
            IApplog.Companion r128 = IApplog.f287053a;
            JSONObject r129 = new JSONObject();
            r129.put("current_page", "login_tel_sdk_page");
            Unit r130 = Unit.INSTANCE;
            r128.reportEvent("login_error_toast", r129);
        L72:
            FLogger r131 = FLogger.f375446a;
            r131.e("PhoneOneKeyLoginFragment", "phoneOneKeyLogin failed, errorCode: " + r111 + ", errorMessage: " + r112);
            Function0<Unit> r132 = this.f357744e;
            if (r132 == null) goto L76;
            r132.invoke();
        L76:
            if (this.f357745f == false) goto L97;
            Fragment r133 = this.f357742c;
            if (r133 == null) goto L80;
            Context r134 = r133.getContext();
        L81:
            com.bytedance.router.i r135 = SmartRouter.buildRoute(r134, "//flow/phone_login");
            Fragment r136 = this.f357742c;
            String r137 = this.f357740a;
            String r138 = this.f357741b;
            if (r136 == null) goto L88;
            Bundle r139 = r136.getArguments();
            if (r139 == null) goto L88;
            String r140 = r139.getString("pending_deeplink_schema");
            if (r140 == null) goto L88;
            r131.i("PhoneOneKeyLoginFragment", "pass uri from push or other deeplink when route to ROUTER_PHONE_LOGIN");
            r135.j("pending_deeplink_schema", r140);
        L88:
            r135.j("account_previous_page", r137);
            r135.j("account_enter_method", r138);
            if (r136 == null) goto L96;
            Bundle r141 = r136.getArguments();
            if (r141 == null) goto L96;
            String r142 = r141.getString("key_trigger_app_id");
            if (r142 == null) goto L96;
            r119 = r142;
        L96:
            r135.j("key_trigger_app_id", r119);
            r135.k("key_carrier_login_failed", true);
            r135.f267555d = R.anim.larus_router_slide_in_right;
            r135.f267556e = R.anim.larus_router_no_anim;
            r135.d();
            goto L97
        L80:
            r134 = null;
        L97:
            String r143 = this.f357740a;
            String r144 = this.f357741b;
            String r145 = String.valueOf(r111);
            Fragment r146 = this.f357742c;
            if (r146 == null) goto L102;
            Bundle r147 = r146.getArguments();
            if (r147 == null) goto L102;
            String r148 = r147.getString("key_trigger_app_id");
        L103:
            h0.c(r100, "login_tel_sdk_confirm", r143, r144, r145, r112, r148);
            AccountTrackService.f356934a.c("login_tel_sdk_confirm_fail", this.f357740a);
            h0.e(r100, this.f357742c, r110, r111, r112, r210, r211);
            return;
        L102:
            r148 = null;
        L53:
            r127 = "";
            goto L60
        L54:
            FlowDowngradeToastConfig r149 = r120.getFlowDowngradeToastConfig();
            if (r149 == null) goto L57;
            String r150 = r149.getTrafficDegradationLogInDisableCn();
        L58:
            r126 = String.valueOf(r150);
            goto L59
        L57:
            r150 = null;
            goto L58
        L42:
            if (r122.length() == 0) goto L45;
            r123 = false;
            goto L46
        L39:
            r122 = null;
            goto L40
        L62:
            if (com.larus.login.api.i0.f357057a.contains(Integer.valueOf(r111)) == false) goto L67;
            String r151 = com.larus.utils.p0.a(r112);
            if (r151 == null) goto L72;
            t19.s.j(t19.s.f544207a, AppHost.f326268a.getApplication(), r151, null, false, 28);
            goto L72
        L67:
            if (r111 == (-1008)) goto L72;
            t19.s r152 = t19.s.f544207a;
            Application r153 = AppHost.f326268a.getApplication();
            String r154 = com.larus.utils.p0.a(r112);
            if (r154 != null) goto L71;
            int r155 = com.larus.utils.j0.f375426a;
            r154 = com.larus.utils.j0.d(R.string.larus_log_in_internet_error);
        L71:
            r152.getClass();
            t19.s.c(r153, r154);
            goto L72
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class d implements n38.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f357746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f357747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f357748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f357749d;

        @Override // n38.h
        public final void b(LoginPlatform r100, String r101, Boolean r102) {
            AccountUtils r103 = AccountUtils.f357130a;
            AccountUtils.s("PhoneLogin");
            TouristManager.f357001a.g();
            h0 r104 = h0.f357729a;
            String r105 = this.f357746a;
            String r106 = this.f357747b;
            Fragment r107 = this.f357748c;
            if (r107 == null) goto L7;
            Bundle r108 = r107.getArguments();
            if (r108 == null) goto L7;
            String r109 = r108.getString("key_trigger_app_id");
        L8:
            h0.d(r104, "input_login_tel_sdk_confirm", r105, r106, r109);
            return;
        L7:
            r109 = null;
            goto L8
        }

        public d(String r100, String r101, Fragment r102, Function0<Unit> r103) {
            this.f357746a = r100;
            this.f357747b = r101;
            this.f357748c = r102;
            this.f357749d = r103;
        }

        @Override // n38.h
        public final void a(LoginPlatform r100, int r101, String r110, String r111, String r112, Integer r113, String r114, Map r115) {
            FLogger.f375446a.w("CommonLoginUtils", "loginByPhoneOneKeyValidate failed, errorCode: " + r101 + ", errorMessage: " + r110);
            this.f357749d.invoke();
            h0 r116 = h0.f357729a;
            String r102 = this.f357746a;
            String r103 = this.f357747b;
            String r104 = String.valueOf(r101);
            Fragment r117 = this.f357748c;
            if (r117 == null) goto L7;
            Bundle r118 = r117.getArguments();
            if (r118 == null) goto L7;
            String r119 = r118.getString("key_trigger_app_id");
        L8:
            h0.c(r116, "input_login_tel_sdk_confirm", r102, r103, r104, r110, r119);
            h0.e(r116, this.f357748c, r100, r101, r110, r111, r112);
            return;
        L7:
            r119 = null;
            goto L8
        }
    }

    public static final class e implements n38.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f357750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f357751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f357752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f357753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Fragment f357754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LoginPlatform f357755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.larus.common_ui.dialog.l0 f357756g;

        @Override // n38.h
        public final void b(LoginPlatform r100, String r101, Boolean r102) {
            new AccountTrace().a(this.f357750a, System.currentTimeMillis() - this.f357751b);
            int r103 = WhiteListChecker.f357247a;
            WhiteListChecker.b();
            AccountUtils r104 = AccountUtils.f357130a;
            String r105 = this.f357750a;
            int r106 = r105.hashCode();
            if (r106 == (-1240244679)) goto L18;
            if (r106 == 3321844) goto L14;
            if (r106 == 497130182) goto L10;
        L20:
            String r107 = "";
        L21:
            AccountUtils.s(r107);
            TouristManager.f357001a.g();
            h0 r108 = h0.f357729a;
            String r109 = this.f357750a;
            String r110 = this.f357752c;
            String r111 = this.f357753d;
            Fragment r112 = this.f357754e;
            if (r112 == null) goto L26;
            Bundle r113 = r112.getArguments();
            if (r113 == null) goto L26;
            String r114 = r113.getString("key_trigger_app_id");
        L27:
            h0.d(r108, r109, r110, r111, r114);
            IAccountService.Companion r115 = IAccountService.f286094a;
            if (this.f357755f != LoginPlatform.GOOGLE) goto L30;
            boolean r116 = true;
        L31:
            r115.q(r116);
            return;
        L30:
            r116 = false;
        L26:
            r114 = null;
            goto L27
        L10:
            if (r105.equals("facebook") == false) goto L20;
            r107 = "FacebookLogin";
            goto L21
        L14:
            if (r105.equals("line") == false) goto L20;
            r107 = "LineLogin";
            goto L21
        L18:
            if (r105.equals("google") == false) goto L20;
            r107 = "GoogleLogin";
            goto L21
        }

        public e(String r100, long r101, String r102, String r103, Fragment r104, LoginPlatform r105, com.larus.common_ui.dialog.l0 r106) {
            this.f357750a = r100;
            this.f357751b = r101;
            this.f357752c = r102;
            this.f357753d = r103;
            this.f357754e = r104;
            this.f357755f = r105;
            this.f357756g = r106;
        }

        @Override // n38.h
        public final void a(LoginPlatform r110, int r111, String r112, String r113, String r114, Integer r115, String r210, Map r211) {
            AccountTrackService.f356934a.a(this.f357750a, System.currentTimeMillis() - this.f357751b);
            h0 r100 = h0.f357729a;
            Fragment r101 = this.f357754e;
            if (r101 == null) goto L5;
            FragmentActivity r102 = r101.getActivity();
        L6:
            com.larus.common_ui.dialog.l0 r103 = this.f357756g;
            r100.getClass();
            h0.q(r102, r103);
            Fragment r104 = this.f357754e;
            if (r211 == null) goto L9;
            Object r105 = r211.get("third_party_login_error_source");
        L11:
            if ((r105 instanceof String) == false) goto L13;
            String r106 = (String) r105;
        L14:
            if (r211 == null) goto L16;
            boolean r107 = Intrinsics.areEqual(r211.get("third_party_login_is_user_cancel"), Boolean.TRUE);
        L17:
            if (r107 == false) goto L19;
        L34:
            String r108 = this.f357750a;
            String r109 = this.f357752c;
            String r116 = this.f357753d;
            String r117 = String.valueOf(r111);
            Fragment r118 = this.f357754e;
            if (r118 == null) goto L39;
            Bundle r119 = r118.getArguments();
            if (r119 == null) goto L39;
            String r120 = r119.getString("key_trigger_app_id");
        L40:
            h0.c(r100, r108, r109, r116, r117, r112, r120);
            h0.e(r100, this.f357754e, r110, r111, r112, r113, r114);
            return;
        L39:
            r120 = null;
            goto L40
        L19:
            if (Intrinsics.areEqual(r106, "age_gate") == true) goto L34;
            if (r106 != null) goto L26;
            if (r112 == null) goto L26;
            if ((!StringsKt.isBlank(r112)) == false) goto L26;
            String r121 = r112;
        L27:
            t19.s r122 = t19.s.f544207a;
            if (r104 == null) goto L30;
            Context r123 = r104.getContext();
        L31:
            if (r121 != null) goto L33;
            int r124 = com.larus.utils.j0.f375426a;
            r121 = com.larus.utils.j0.d(R.string.larus_log_in_internet_error);
        L33:
            r122.getClass();
            t19.s.c(r123, r121);
            goto L34
        L30:
            r123 = null;
        L26:
            r121 = null;
            goto L27
        L16:
            r107 = false;
            goto L17
        L13:
            r106 = null;
            goto L14
        L9:
            r105 = null;
            goto L11
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class f implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f357757a;

        public f(b0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f357757a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f357757a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f357757a.invoke(r100);
        }
    }

    public static final class g implements n38.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f357758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f357759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f357760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Fragment f357761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.larus.common_ui.dialog.l0 f357762e;

        @Override // n38.h
        public final void b(LoginPlatform r110, String r111, Boolean r112) {
            if (IAccountService.f286094a.h() == true) goto L5;
            AccountUtils r113 = AccountUtils.f357130a;
            AccountUtils.s("weixinLogin");
        L6:
            TouristManager.f357001a.g();
            AccountTrackService r100 = AccountTrackService.f356934a;
            r100.a("weixin", System.currentTimeMillis() - this.f357758a);
            IAccountTrackApi.a.c(r100, "wechat", 1, this.f357759b, this.f357760c, null, null, null, null, null, null, 960);
            return;
        L5:
            int r114 = WhiteListChecker.f357247a;
            WhiteListChecker.b();
            AccountUtils r115 = AccountUtils.f357130a;
            AccountUtils.s("weixinLogin");
            goto L6
        }

        public g(long r100, String r101, String r102, Fragment r103, com.larus.common_ui.dialog.l0 r104) {
            this.f357758a = r100;
            this.f357759b = r101;
            this.f357760c = r102;
            this.f357761d = r103;
            this.f357762e = r104;
        }

        @Override // n38.h
        public final void a(LoginPlatform r110, int r210, String r211, String r212, String r213, Integer r214, String r215, Map r216) {
            FLogger.f375446a.w("CommonLoginUtils", "weixinLogin onFailed:" + r210 + ": " + r211);
            FragmentActivity r111 = null;
            if (r210 != 1060) goto L5;
            h0.f(h0.f357729a, this.f357761d, this.f357759b, true, r213);
        L20:
            AccountTrackService r100 = AccountTrackService.f356934a;
            r100.a("weixin", System.currentTimeMillis() - this.f357758a);
            IAccountTrackApi.a.c(r100, "wechat", 0, this.f357759b, this.f357760c, String.valueOf(r210), r211, null, null, null, null, 960);
            h0 r101 = h0.f357729a;
            Fragment r102 = this.f357761d;
            if (r102 == null) goto L23;
            r111 = r102.getActivity();
        L23:
            com.larus.common_ui.dialog.l0 r103 = this.f357762e;
            r101.getClass();
            h0.q(r111, r103);
            h0.e(r101, this.f357761d, r110, r210, r211, r212, r213);
            return;
        L5:
            if (r210 == 1342) goto L18;
            t19.s r104 = t19.s.f544207a;
            Fragment r105 = this.f357761d;
            if (r105 == null) goto L9;
            Context r106 = r105.getContext();
        L10:
            if (r211 != null) goto L12;
        L16:
            int r107 = com.larus.utils.j0.f375426a;
            String r108 = com.larus.utils.j0.d(R.string.larus_log_in_internet_error);
        L17:
            r104.getClass();
            t19.s.c(r106, r108);
            goto L20
        L12:
            if ((true ^ StringsKt.isBlank(r211)) == false) goto L14;
            r108 = r211;
        L15:
            if (r108 != null) goto L17;
        L14:
            r108 = null;
            goto L15
        L9:
            r106 = null;
            goto L10
        L18:
            h0.f(h0.f357729a, this.f357761d, this.f357759b, false, r213);
            goto L20
        }
    }

    public h0() {
    }

    static {
        f357729a = new h0();
        HashMap<String, LoginPlatform> r100 = new HashMap();
        r100.put("phone_verify_code", LoginPlatform.PHONE);
        r100.put("douyin", LoginPlatform.DOUYIN);
        r100.put("google", LoginPlatform.GOOGLE);
        r100.put("line", LoginPlatform.LINE);
        r100.put("facebook", LoginPlatform.FACEBOOK);
        f357731c = r100;
    }

    public static void a(com.larus.common_ui.dialog.l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(com.larus.common_ui.dialog.l0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static boolean g(FragmentActivity r100, Fragment r101) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.isFinishing() == false) goto L6;
        return true;
    L6:
        if (r100.isDestroyed() == true) goto L21;
        if (r101 != null) goto L10;
        return true;
    L10:
        if (r101.isAdded() == true) goto L12;
        return true;
    L12:
        if (r101.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L22;
        return false;
    L22:
        return true;
    L21:
        return true;
    }

    public static boolean h(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "mobile");
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return true;
    L5:
        if (r111 != null) goto L7;
    L9:
        boolean r100 = false;
    L10:
        if (r100 == true) goto L12;
        return true;
    L12:
        if (TextUtils.isEmpty(r110) == true) goto L80;
        String r101 = r111.substring(0, 3);
        String r112 = r111.substring(7, 11);
        int r102 = r110.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L16:
        if (r103 > r102) goto L31;
        if (r104 == true) goto L19;
        int r105 = r103;
    L21:
        if (Intrinsics.compare(r110.charAt(r105), 32) > 0) goto L23;
        boolean r106 = true;
    L24:
        if (r104 == false) goto L25;
        if (r106 == false) goto L31;
        r102 = r102 - 1;
        goto L16
    L25:
        if (r106 == false) goto L26;
        r103 = r103 + 1;
        goto L16
    L26:
        r104 = true;
        goto L16
    L23:
        r106 = false;
        goto L24
    L19:
        r105 = r102;
    L31:
        String r113 = r110.subSequence(r103, r102 + 1).toString();
        if (StringsKt.startsWith$default(r113, "+86", false, 2, null) == false) goto L51;
        String r114 = r113.substring(3);
        int r107 = r114.length() - 1;
        int r108 = 0;
        boolean r109 = false;
    L34:
        if (r108 > r107) goto L49;
        if (r109 == true) goto L37;
        int r115 = r108;
    L39:
        if (Intrinsics.compare(r114.charAt(r115), 32) > 0) goto L41;
        boolean r116 = true;
    L42:
        if (r109 == false) goto L43;
        if (r116 == false) goto L49;
        r107 = r107 - 1;
        goto L34
    L43:
        if (r116 == false) goto L44;
        r108 = r108 + 1;
        goto L34
    L44:
        r109 = true;
        goto L34
    L41:
        r116 = false;
        goto L42
    L37:
        r115 = r107;
    L49:
        r113 = r114.subSequence(r108, r107 + 1).toString();
    L51:
        if (StringsKt.startsWith$default(r113, r101, false, 2, null) == true) goto L53;
        return true;
    L53:
        if (StringsKt.endsWith$default(r113, r112, false, 2, null) == false) goto L81;
        return false;
    L81:
        return true;
    L80:
        return true;
    L7:
        if (r111.length() != 11) goto L9;
        r100 = true;
        goto L10
    }

    public static void q(FragmentActivity r100, com.larus.common_ui.dialog.l0 r101) {
        if (r100 != null) goto L17;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L19;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isShowing() == false) goto L21;
        a(r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        FLogger.f375446a.e("CommonLoginUtils", "accountDialog dismiss crash because: " + e.getMessage(), e);
        return;
    L21:
        return;
    L19:
        return;
    L17:
        if (r100.isFinishing() == true) goto L8;
        r102 = true;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.login.impl.b0] */
    public static void o(final FragmentActivity r100, Fragment r101, boolean r102, final JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "viewLifecycleOwner");
        if (r102 == false) goto L7;
        com.bytedance.router.i r104 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//main_page");
        r104.f267554c.putExtra("key_hook_main_activity_on_new_intent", true);
        r104.f267554c.addFlags(335544320);
        r104.d();
        return;
    L7:
        if (NetworkUtils.isNetworkAvailable(r100) == true) goto L10;
        t19.s.f544207a.g(r100, R.string.larus_log_in_internet_error, false);
        return;
    L10:
        LiveData<com.larus.network.http.a<Object>> r105 = TouristManager.f357001a.y();
        r105.removeObservers(r101);
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        r105.observe(r101, new f(new b0(r106, r100, r103)));
    }

    public static void s(com.larus.common_ui.dialog.l0 r210, Fragment r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r212, "currentPage");
        Intrinsics.checkNotNullParameter(r213, "enterMethod");
        FragmentActivity r100 = null;
        if (r211 == null) goto L5;
        FragmentActivity r101 = r211.getActivity();
    L7:
        if (g(r101, r211) == false) goto L9;
        return;
    L9:
        if (r210 == null) goto L11;
        b(r210);
    L11:
        long r102 = System.currentTimeMillis();
        if (r211 == null) goto L18;
        FragmentActivity r103 = r211.getActivity();
        if (r103 == null) goto L18;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L18;
        r104.addObserver(new CommonLoginUtils$dismissLoadingWhenOnResume$1(r211, r210));
    L18:
        ILoginService r105 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r105 == null) goto L25;
        LoginPlatform r110 = LoginPlatform.WEIXIN;
        g r111 = new g(r102, r212, r213, r211, r210);
        boolean r112 = AppHost.f326268a.isOversea();
        if (r211 == null) goto L23;
        r100 = r211.getActivity();
    L23:
        e10 r106 = e10.f368561a;
        ILoginService.a.a(r105, r110, r111, r112, "AccountLoginFragment", r100, null, false, e10.y0().b(), null, 352);
        return;
    L25:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static final void d(h0 r110, String r111, String r112, String r113, String r114) {
        r110.getClass();
        IAccountTrackApi.a.c(AccountTrackService.f356934a, r111, 1, r112, r113, null, null, null, null, r114, null, 752);
    }

    public static final void f(h0 r100, Fragment r101, String r102, boolean r103, String r104) {
        r100.getClass();
        if (r101 == null) goto L5;
        Context r105 = r101.getContext();
    L6:
        com.bytedance.router.i r106 = SmartRouter.buildRoute(r105, "//flow/phone_login");
        if (r101 == null) goto L13;
        Bundle r107 = r101.getArguments();
        if (r107 == null) goto L13;
        String r108 = r107.getString("pending_deeplink_schema");
        if (r108 == null) goto L13;
        FLogger.f375446a.i("PhoneOneKeyLoginFragment", "pass uri from push or other deeplink when route to ROUTER_PHONE_LOGIN");
        r106.j("pending_deeplink_schema", r108);
    L13:
        r106.j("account_previous_page", r102);
        int r109 = com.larus.utils.j0.f375426a;
        r106.j("phoneLoginTitle", com.larus.utils.j0.d(R.string.larus_bind_phone_enter_number));
        r106.k("key_bind_phone_when_login", true);
        r106.k("key_bind_phone_is_new_user", r103);
        r106.j("key_bind_phone_profile_key", r104);
        r106.f267555d = R.anim.larus_router_slide_in_right;
        r106.f267556e = R.anim.larus_router_no_anim;
        r106.d();
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static /* synthetic */ void m(h0 r100, com.larus.common_ui.dialog.l0 r101, Fragment r102, String r103, String r110) {
        r100.getClass();
        l(r101, r102, r103, r110, true, null);
    }

    public static void p(String r210, com.larus.common_ui.dialog.l0 r211, Fragment r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r210, "channel");
        Intrinsics.checkNotNullParameter(r213, "currentPage");
        Intrinsics.checkNotNullParameter(r214, "enterMethod");
        Context r110 = null;
        if (r212 == null) goto L5;
        FragmentActivity r100 = r212.getActivity();
    L7:
        if (g(r100, r212) == false) goto L9;
        return;
    L9:
        LoginPlatform r111 = f357731c.get(r210);
        if (r111 != null) goto L12;
        return;
    L12:
        long r101 = System.currentTimeMillis();
        if (r211 == null) goto L36;
        b(r211);
    L36:
        ILoginService r112 = (ILoginService) ServiceManager.get().getService(ILoginService.class);     // Catch: Exception -> L27
        if (r112 == null) goto L38;
        e r113 = new e(r210, r101, r213, r214, r212, r111, r211);     // Catch: Exception -> L27
        boolean r114 = AppHost.f326268a.isOversea();     // Catch: Exception -> L27
        if (r212 == null) goto L20;
        FragmentActivity r115 = r212.getActivity();     // Catch: Exception -> L27
    L21:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L27
        r102.put("current_page", r213);     // Catch: Exception -> L27
        Unit r103 = Unit.INSTANCE;     // Catch: Exception -> L27
        if (r111 != LoginPlatform.GOOGLE) goto L24;
        boolean r215 = true;
    L25:
        ILoginService.a.a(r112, r111, r113, r114, "AccountLoginFragment", r115, r102, r215, false, null, 384);     // Catch: Exception -> L27
        return;
    L24:
        r215 = false;
        goto L25
    L20:
        r115 = null;
        goto L21
    L38:
        return;
    L27:
        e = move-exception;
        if (r212 == null) goto L30;
        FragmentActivity r104 = r212.getActivity();
    L31:
        q(r104, r211);
        t19.s r105 = t19.s.f544207a;
        if (r212 == null) goto L34;
        r110 = r212.getContext();
    L34:
        int r106 = com.larus.utils.j0.f375426a;
        String r107 = com.larus.utils.j0.d(R.string.larus_log_in_internet_error);
        r105.getClass();
        t19.s.c(r110, r107);
        FLogger.f375446a.e("CommonLoginUtils", "login fail e=" + e.getMessage());
        return;
    L30:
        r104 = null;
        goto L31
    L5:
        r100 = null;
        goto L7
    }

    public static void i(com.larus.common_ui.dialog.l0 r210, Fragment r211, String r212, String r213, String r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r212, "currentPage");
        Intrinsics.checkNotNullParameter(r213, "enterMethod");
        FragmentActivity r110 = null;
        if (r211 == null) goto L5;
        FragmentActivity r100 = r211.getActivity();
    L7:
        if (g(r100, r211) == false) goto L9;
        return;
    L9:
        if (r210 == null) goto L11;
        b(r210);
    L11:
        long r101 = System.currentTimeMillis();
        if (r211 == null) goto L18;
        FragmentActivity r102 = r211.getActivity();
        if (r102 == null) goto L18;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L18;
        r103.addObserver(new CommonLoginUtils$dismissLoadingWhenOnResume$1(r211, r210));
    L18:
        ILoginService r111 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r111 == null) goto L25;
        LoginPlatform r112 = LoginPlatform.DOUYIN;
        b r113 = new b(r101, r212, r213, r214, r211, r210, r215);
        boolean r114 = AppHost.f326268a.isOversea();
        if (r211 == null) goto L23;
        r110 = r211.getActivity();
    L23:
        ILoginService.a.a(r111, r112, r113, r114, "AccountLoginFragment", r110, null, false, false, r214, 224);
        return;
    L25:
        return;
    L5:
        r100 = null;
        goto L7
    }

    public static /* synthetic */ void j(h0 r100, com.larus.common_ui.dialog.l0 r101, Fragment r102, String r103, String r110, String r111) {
        r100.getClass();
        i(r101, r102, r103, r110, r111, false);
    }

    public static void l(com.larus.common_ui.dialog.l0 r110, Fragment r111, String r112, String r113, boolean r114, Function0 r115) {
        Intrinsics.checkNotNullParameter(r112, "currentPage");
        Intrinsics.checkNotNullParameter(r113, "enterMethod");
        String r100 = null;
        if (r111 == null) goto L5;
        FragmentActivity r101 = r111.getActivity();
    L7:
        if (g(r101, r111) == false) goto L9;
        return;
    L9:
        if (r110 == null) goto L11;
        b(r110);
    L11:
        ILoginService r102 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r102 == null) goto L20;
        LoginPlatform r116 = LoginPlatform.PHONE;
        c r117 = new c(r112, r113, r111, r110, r115, r114);
        if (r111 == null) goto L18;
        Bundle r103 = r111.getArguments();
        if (r103 == null) goto L18;
        r100 = r103.getString("key_trigger_app_id");
    L18:
        r102.t(r116, r117, r100);
        return;
    L20:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static void r(String r100, String r101, by7.e r102, FragmentManager r103, zj9.f r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "previousPage");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        Intrinsics.checkNotNullParameter(r103, "fragmentManager");
        Intrinsics.checkNotNullParameter(r110, "loginOptionsDialogModel");
        Intrinsics.checkNotNullParameter(r111, "endCallBack");
        int r104 = LoginOptionsDialogFragment.f357840h;
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r103, "fragmentManager");
        Intrinsics.checkNotNullParameter("dialog", "tag");
        LoginOptionsDialogFragment r105 = new LoginOptionsDialogFragment();
        Intrinsics.checkNotNullParameter(r110, "data");
        r105.f357842e = r110;
        FragmentTransaction r106 = r103.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "dialog", R.id.dialogFragmentContainer) == true) goto L6;
        r106 = r106.replace(R.id.dialogFragmentContainer, r105, "dialog");
    L6:
        r106.commitAllowingStateLoss();
        tx9.s1.b(r101, r100, "other_login_method", null, r102, 24);
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.put("current_page", r101);     // Catch: JSONException -> L9
        r107.put("previous_page", r100);     // Catch: JSONException -> L9
    L11:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("show_login_popup");
        if (r102 == null) goto L14;
        r109.f21464b = r102;
    L14:
        r109.f21463a.merge(r108);
        r109.b();
        r111.invoke();
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("LoginEventHelper", "error in LoginEventHelper showLoginPopup " + e.getLocalizedMessage());
        goto L11
    }

    public static final void c(h0 r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        r110.getClass();
        FLogger.f375446a.e("AccountLoginFragment", "login => errCode:" + r114 + "  errMsg:" + r115);
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        r101.put("source_path", 3);
        r101.put("status", 2);
        r101.put("error_code", r114);
        r101.put("error_msg", r115);
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("login", r101);
        IAccountTrackApi.a.c(AccountTrackService.f356934a, r111, 0, r112, r113, r114, r115, null, null, r116, null, 704);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(h0 r100, Fragment r101, LoginPlatform r102, int r103, String r104, String r105, String r106) {
        r100.getClass();
        if ((r101 instanceof com.larus.login.impl.loginfragment.l1) == false) goto L6;
        ((com.larus.login.impl.loginfragment.l1) r101).Mq(r102, r103, r104);
        return;
    }

    public static void n(String r100, String r101, com.larus.common_ui.dialog.l0 r102, Fragment r110, String r111, String r112, Function0 r113) {
        Intrinsics.checkNotNullParameter(r100, "mobile");
        Intrinsics.checkNotNullParameter(r101, "maskMobile");
        Intrinsics.checkNotNullParameter(r111, "currentPage");
        Intrinsics.checkNotNullParameter(r112, "enterMethod");
        Intrinsics.checkNotNullParameter(r113, "failCallBack");
        String r103 = null;
        if (r110 == null) goto L5;
        FragmentActivity r104 = r110.getActivity();
    L7:
        if (g(r104, r110) == false) goto L9;
        return;
    L9:
        if (r102 == null) goto L11;
        b(r102);
    L11:
        AccountTrackService.f356934a.c("input_login_tel_sdk_confirm", r111);
        ILoginService r105 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r105 == null) goto L20;
        LoginPlatform r106 = LoginPlatform.PHONE;
        d r107 = new d(r111, r112, r110, r113);
        if (r110 == null) goto L18;
        Bundle r108 = r110.getArguments();
        if (r108 == null) goto L18;
        r103 = r108.getString("key_trigger_app_id");
    L18:
        r105.h(r106, r101, r100, r107, r103);
        return;
    L20:
        return;
    L5:
        r104 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.login.impl.e0] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.login.impl.c0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.larus.login.impl.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.login.impl.f0] */
    public static zj9.f k(final String r210, final String r211, final Fragment r310, final boolean r311, final com.larus.common_ui.dialog.l0 r312, final Function1 r313, final Function0 r314, final Function0 r315, final String r316) {
        Intrinsics.checkNotNullParameter(r210, "previousPage");
        Intrinsics.checkNotNullParameter(r211, "currentPage");
        Intrinsics.checkNotNullParameter(r310, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r313, "clickLoginCallBack");
        Intrinsics.checkNotNullParameter(r314, "dialogShow");
        Intrinsics.checkNotNullParameter(r315, "dialogDismiss");
        int r100 = zj9.j.f572536a;
        List r110 = CollectionsKt.listOf(LoginPlatform.PHONE);
        final ?? r111 = new c0(r312, r310, r211, r316, r210, r313);
        Intrinsics.checkNotNullParameter(r110, "excludePlatforms");
        Intrinsics.checkNotNullParameter(r111, SendEventContainerMethodParamModel.EventKinds.onClick);
        List r101 = uj9.d.a(true, false);
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101).iterator();
    L3:
        boolean r104 = r103.hasNext();
        int r105 = zj9.j.f572536a;
        if (r104 == false) goto L20;
        Object r106 = r103.next();
        LoginPlatform r107 = zj9.j.a((String) r106);
        if (r107 == LoginPlatform.UNKNOWN) goto L17;
        ILoginService r108 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r108 != null) goto L10;
    L12:
        boolean r109 = false;
    L13:
        if (r109 == false) goto L17;
        if (r110.contains(r107) == true) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L3;
        r102.add(r106);
        goto L3
    L10:
        if (r108.C(r107) != true) goto L12;
        r109 = true;
    L17:
        r112 = false;
        goto L18
    L20:
        final ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r114 = r102.iterator();
        final int r115 = 0;
    L22:
        if (r114.hasNext() == false) goto L57;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        final String r118 = (String) r116;
        final LoginPlatform r119 = zj9.j.a(r118);
        LoginPlatform r212 = zj9.j.a(r118);
        if (r115 != 0) goto L29;
        boolean r213 = true;
    L30:
        int[] r214 = zj9.j.a.f572537a;
        switch(r214[r119.ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L34;
            case 6: goto L33;
            default: goto L32;
        };
    L32:
        int r215 = 0;
    L42:
        switch(r214[r119.ordinal()]) {
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            case 4: goto L46;
            case 5: goto L45;
            case 6: goto L44;
            default: goto L43;
        };
    L43:
        int r216 = 0;
    L50:
        if (r115 != 0) goto L52;
        int r217 = R.color.larus_base_1;
    L53:
        if (r115 != 0) goto L55;
        int r218 = R.drawable.larus_bg_account_button_white;
    L56:
        r113.add(new zj9.g(r118, r212, r215, r216, r217, r218, new zj9.i(r111, r115, r118, r119)));
        r115 = r117;
        goto L22
    L55:
        r218 = R.drawable.larus_bg_account_button;
        goto L56
    L52:
        r217 = R.color.larus_neutral_100;
        goto L53
    L44:
        r216 = R.string.larus_wechat_login;
        goto L50
    L45:
        r216 = R.string.larus_log_in_with_phone_button;
        goto L50
    L46:
        r216 = R.string.larus_log_in_with_facebook_button;
        goto L50
    L47:
        r216 = R.string.larus_log_in_with_line_button;
        goto L50
    L48:
        r216 = R.string.larus_log_in_with_oin_button_cn;
        goto L50
    L49:
        r216 = R.string.larus_log_in_with_google_button;
        goto L50
    L33:
        r215 = R.drawable.larus_ic_wechat;
        goto L42
    L34:
        if (r213 == false) goto L36;
        r215 = R.drawable.larus_ic_phone_primary;
        goto L42
    L36:
        r215 = R.drawable.larus_ic_phone;
        goto L42
    L37:
        r215 = R.drawable.larus_ic_facebook;
        goto L42
    L38:
        r215 = R.drawable.larus_ic_line;
        goto L42
    L39:
        r215 = R.drawable.larus_ic_douyin;
        goto L42
    L40:
        r215 = R.drawable.larus_ic_google;
        goto L42
    L29:
        r213 = false;
        goto L30
    L57:
        Iterator r120 = r113.iterator();
        int r121 = 0;
    L59:
        if (r120.hasNext() == false) goto L64;
        Object r122 = r120.next();
        int r123 = r121 + 1;
        if (r121 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        tx9.s1.d(r211, r210, Long.valueOf(r121), ((zj9.g) r122).f572524a, null, 48);
        r121 = r123;
        goto L59
    L64:
        int r124 = zj9.j.f572536a;
        boolean r125 = r113.isEmpty();
        final ?? r126 = new d0(r310, r311, r113, r211, r210);
        Intrinsics.checkNotNullParameter(r126, SendEventContainerMethodParamModel.EventKinds.onClick);
        LoginPlatform r219 = LoginPlatform.UNKNOWN;
        if (r125 == false) goto L67;
        int r220 = R.color.larus_base_1;
    L68:
        if (r125 == false) goto L70;
        int r221 = R.drawable.larus_bg_account_button_white;
    L71:
        zj9.g r127 = new zj9.g("", r219, R.drawable.larus_ic_tourist, R.string.larus_guest_login, r220, r221, new zj9.h(r126));
        List r128 = CollectionsKt.toMutableList(r113);
        if (Intrinsics.areEqual(TouristManager.f357001a.w().getValue(), Boolean.TRUE) == false) goto L81;
        if (r316 != null) goto L75;
    L78:
        boolean r129 = true;
    L79:
        if (r129 == false) goto L81;
        r128.add(r127);
        tx9.s1.d(r211, r210, Long.valueOf(r128.size()), "use_without_login", null, 48);
        goto L81
    L75:
        if (r316.length() == 0) goto L78;
        r129 = false;
    L81:
        Unit r130 = Unit.INSTANCE;
        return new zj9.f(r128, new e0(r314, r211), new f0(r315));
    L70:
        r221 = R.drawable.larus_bg_account_button;
        goto L71
    L67:
        r220 = R.color.larus_neutral_100;
        goto L68
    }
}
