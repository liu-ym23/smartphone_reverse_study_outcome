package com.larus.camera.impl.utils;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.integrated.counter.outerpay.IntegratedOuterPayRooter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.utils.a4;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.network.BoeDomainResolver;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.b2;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class CameraScanLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CameraScanLogic f322690a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<Unit> f322691b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f322692c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f322693d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f322694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<String, Unit> f322695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<String, Unit> f322696c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f322694a == r101.f322694a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f322695b, r101.f322695b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f322696c, r101.f322696c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f322694a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f322695b.hashCode()) * 31) + this.f322696c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "HostScanCodeCallback(onlyFromCamera=" + this.f322694a + ", onResult=" + this.f322695b + ", onFailure=" + this.f322696c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean r100, Function1<? super String, Unit> r101, Function1<? super String, Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "onResult");
            Intrinsics.checkNotNullParameter(r102, "onFailure");
            this.f322694a = r100;
            this.f322695b = r101;
            this.f322696c = r102;
        }
    }

    public CameraScanLogic() {
    }

    static {
        f322690a = new CameraScanLogic();
        f322691b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f322692c = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16, types: [com.larus.camera.impl.utils.o] */
    /* JADX WARN: Type inference failed for: r11v20, types: [com.larus.camera.impl.utils.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static boolean a(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        FLogger.f375446a.e("CameraScanLogic", "empty BashScanResult");
        return false;
    L13:
        a4.f314971a.getClass();
        a4.a(a4.f314972b);
        String r102 = y0.k(UriProtector.parse(r110).buildUpon().appendQueryParameter("enter_from", "app_chat_list_plus").build());
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L20;
        FlowAppletServiceImpl r104 = r103.g0();
        if (r104 == null) goto L20;
        if (r104.l(r110) != true) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L23;
        return true;
    L23:
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L30;
        FlowAppletServiceImpl r107 = r106.g0();
        if (r107 == null) goto L30;
        if (r107.n(r110) != true) goto L30;
        boolean r108 = true;
    L32:
        if (r108 == false) goto L34;
        FLogger.f375446a.i("CameraScanLogic", "try to start debug mode");
    L183:
        com.larus.platform.service.o r109 = com.larus.platform.service.o.f365780a;
        JSONObject r111 = new JSONObject();
        f322690a.getClass();
        String r112 = AppHost.f326268a.d() + "/inapp/scan-login";
        if (r110 != null) goto L186;
    L188:
        boolean r113 = false;
    L189:
        if (r113 == false) goto L191;
        String r114 = "login";
    L201:
        r111.putOpt("result", r114);
        Unit r115 = Unit.INSTANCE;
        r109.reportEvent("scan_qr_code_result", r111);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CameraScanLogic$interceptBashScanResult$3(null), 3, null);
        FLogger.f375446a.i("CameraScanLogic", "open url from camera scan qrcode, link_url: " + r102);
        return true;
    L191:
        if (r110 != null) goto L193;
    L195:
        if (r100 == false) goto L200;
        Uri r116 = y0.j(r110);
        if (r116 == null) goto L200;
        r114 = UriProtector.getQueryParameter(r116, "enter_method");
        if (r114 != null) goto L201;
    L200:
        r114 = "other";
        goto L201
    L193:
        if (StringsKt.contains$default(r110, "//flow/realtime_chat", false, 2, null) != true) goto L195;
        r100 = true;
        goto L195
    L186:
        if (StringsKt.startsWith$default(r110, r112, false, 2, null) != true) goto L188;
        r113 = true;
        goto L189
    L34:
        z2 r117 = z2.f365865a;
        if (r117.larkScanCodeLoginEnabled() == false) goto L63;
        List<String> r118 = m.f322790a;
        Intrinsics.checkNotNullParameter(r110, "scanResult");
        String r119 = AccountService.f365697a.d(r110);
        if (r119 != null) goto L40;
    L58:
        boolean r120 = false;
    L61:
        if (r120 == false) goto L63;
        r102 = "lark_qr_login";
        goto L183
    L40:
        if (StringsKt.isBlank(r119) == false) goto L42;
        FLogger.f375446a.w("CameraScanInfo", "LarkQrLoginScanSdk can handle result, but returned empty url");
        t19.s r121 = t19.s.f544207a;
        Application r122 = AppHost.f326268a.getApplication();
        r121.getClass();
        t19.s.b(r122, R.string.larus_log_in_internet_error, false);
    L60:
        r120 = true;
        goto L61
    L42:
        Uri r123 = y0.j(r119);
        if (r123 == null) goto L47;
        Uri r124 = y0.l(r123, "hide_nav_bar", "1");
        if (r124 == null) goto L47;
        String r125 = y0.k(r124);
    L48:
        if (r125 != null) goto L50;
    L53:
        boolean r126 = true;
    L54:
        if (r126 == false) goto L56;
        FLogger.f375446a.w("CameraScanInfo", "LarkQrLoginScanSdk url parse failed");
        goto L58
    L56:
        String r127 = y0.k(UriProtector.parse("//flow/webview").buildUpon().appendQueryParameter("link_url", r125).build());
        if (r127 == null) goto L58;
        com.bytedance.router.i r128 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), r127);
        Bundle r129 = new Bundle();
        r129.putBoolean("bundle_need_lark_auth_cookie_sync", true);
        r128.f267554c.putExtras(r129);
        r128.d();
        goto L60
    L50:
        if (StringsKt.isBlank(r125) == true) goto L53;
        r126 = false;
    L47:
        r125 = null;
    L63:
        FLogger r130 = FLogger.f375446a;
        r130.d("CameraScanLogic", "parseScanToPayInAppAction url: " + r102);
        if (r117.enableScanToPayInApp() == true) goto L66;
        r130.i("CameraScanLogic", "parseScanToPayInAppAction enableScanToPayInApp is false");
    L126:
        Object r131 = null;
    L127:
        if (r131 == null) goto L147;
        AppHost.Companion r132 = AppHost.f326268a;
        Context r133 = r132.a().getCurrentActivity();
        if (r133 != null) goto L132;
        r133 = r132.getApplication();
    L132:
        if ((r131 instanceof q) == false) goto L139;
        q r134 = (q) r131;
        final String r135 = r134.f322796a.get("papi_id");
        final String r136 = GsonProtectorUtils.toJson(new Gson(), r134.f322796a);
        ICommerceMembershipService r137 = (ICommerceMembershipService) ServiceManager.get().getService(ICommerceMembershipService.class);
        if (r137 == null) goto L137;
        r137.B(r135, null, "20", r136, "scan");
    L137:
        FLogger.f375446a.i("CameraScanLogic", "routeSign called");
        com.larus.platform.service.w.f365817a.b(r133, r134.f322796a, new n(r135, r136));
        goto L183
    L139:
        if ((r131 instanceof p) == false) goto L145;
        p r138 = (p) r131;
        final String r139 = r138.f322795a.get("papi_id");
        final String r140 = GsonProtectorUtils.toJson(new Gson(), r138.f322795a);
        f0 r141 = new f0("1", "1");
        ICommerceMembershipService r142 = (ICommerceMembershipService) ServiceManager.get().getService(ICommerceMembershipService.class);
        if (r142 == null) goto L143;
        r142.B(r139, null, "20", r140, "scan");
    L143:
        FLogger.f375446a.i("CameraScanLogic", "pay called");
        com.larus.platform.service.w.f365817a.d(r133, r140, GsonProtectorUtils.toJson(new Gson(), r141), new o(r139, r140));
        goto L183
    L145:
        throw new NoWhenBranchMatchedException();
    L147:
        if (y0.e(r102) == false) goto L182;
        int r143 = BoeDomainResolver.f359972a;
        if (r102 != null) goto L152;
        String r144 = null;
    L181:
        com.larus.platform.service.q.f365787a.e(AppHost.f326268a.getApplication(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r144)}), null);
        goto L183
    L152:
        if (AppHost.f326268a.isOversea() == false) goto L154;
    L156:
        boolean r145 = false;
    L157:
        if (r145 == false) goto L180;
        com.larus.platform.api.i r146 = b2.f364870a.a();
        if (r146.f365141a.length() != 0) goto L162;
        boolean r147 = true;
    L163:
        if (r147 == true) goto L180;
        if (r146.f365142b.length() != 0) goto L167;
        boolean r148 = true;
    L168:
        if (r148 == true) goto L180;
        Uri r149 = y0.j(r102);
        if (r149 == null) goto L180;
        if (Intrinsics.areEqual(r149.getHost(), r146.f365141a) == false) goto L180;
        r144 = y0.k(r149.buildUpon().authority(r146.f365142b).build());
        if (r144 != null) goto L179;
        r144 = r102;
    L179:
        FLogger.f375446a.i("BoeDomainResolver", "adaptWebUrl: host replaced for BOE");
        goto L181
    L167:
        r148 = false;
        goto L168
    L162:
        r147 = false;
    L180:
        r144 = r102;
        goto L181
    L154:
        if (HttpExtKt.e().f360166a == false) goto L156;
        r145 = true;
        goto L157
    L182:
        SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), r102).d();
        goto L183
    L66:
        if (r102 == null) goto L126;
        Uri r150 = y0.j(r102);
        if (r150 == null) goto L126;
        String r151 = r150.getHost();
        if (r151 != null) goto L73;
    L76:
        boolean r152 = true;
    L77:
        if (r152 == false) goto L79;
    L125:
        r130.i("CameraScanLogic", "parseScanToPayInAppAction host not in allow list, host: " + r150 + ".host");
        goto L126
    L79:
        if (CollectionsKt.contains(m.f322790a, r150.getHost()) == false) goto L125;
        Result.Companion r153 = Result.Companion;     // Catch: Throwable -> L83
        Object r154 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r150, "papi_id"));     // Catch: Throwable -> L83
    L86:
        if (Result.m9455isFailureimpl(r154) == false) goto L88;
        r154 = null;
    L88:
        String r155 = (String) r154;
        if (r155 != null) goto L91;
    L94:
        boolean r156 = true;
    L95:
        if (r156 == false) goto L205;
        FLogger.f375446a.i("CameraScanLogic", "parseScanToPayInAppAction papiId is null");
        goto L126
    L205:
        Object r157 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r150, "scan_scene"));     // Catch: Throwable -> L99
    L102:
        if (Result.m9455isFailureimpl(r157) == false) goto L104;
        r157 = null;
    L104:
        String r158 = (String) r157;
        if (r158 != null) goto L107;
        r158 = "";
    L107:
        FLogger.f375446a.i("CameraScanLogic", "parseScanToPayInAppAction scanScene: ".concat(r158));
        Map r159 = MapsKt.mapOf(new Pair[]{TuplesKt.to("papi_id", r155), TuplesKt.to("scan_scene", r158), TuplesKt.to(CJOuterPayBean.KEY_SAAS_SCENE, "jh_saas")});
        int r160 = r158.hashCode();
        if (r160 == (-557969986)) goto L122;
        if (r160 == 110760) goto L119;
        if (r160 != 3530173) goto L126;
        if (r158.equals("sign") == false) goto L126;
        r131 = new q(r159);
        goto L127
    L119:
        if (r158.equals("pay") == false) goto L126;
    L124:
        r131 = new p(r159);
        goto L127
    L122:
        if (r158.equals(IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY) == true) goto L124;
    L99:
        th = move-exception;
        Result.Companion r161 = Result.Companion;
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L102
    L91:
        if (StringsKt.isBlank(r155) == true) goto L94;
        r156 = false;
    L83:
        th = move-exception;
        Result.Companion r162 = Result.Companion;
        r154 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L86
    L73:
        if (StringsKt.isBlank(r151) == true) goto L76;
        r152 = false;
    L30:
        r108 = false;
    L20:
        r105 = false;
        goto L21
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L10
    }
}
