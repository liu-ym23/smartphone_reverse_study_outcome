package com.larus.office.base;

import android.os.SystemClock;
import com.bytedance.lark.office_sdk_im_android.OfficeSdkOpenMessageOperator;
import com.bytedance.lark.office_sdk_im_android.Office_sdk_imKt;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.larkfeed.IOfficeSocialBridge;
import com.larus.office.base.host.DoubaoOfficeMediaApi;
import com.larus.platform.audit.IFlowBehaviorAuditService;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.LarkSocialImModuleState;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.settings.value.p8;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.officesdk.api.OfficeSDKPassportUserAction;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.m2;
import hq9.u2;
import hq9.v2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class r implements IOfficeSDKLifeCycle {

    public static final class a implements x05.a {
        public a() {
        }

        @Override // x05.a
        public final List<String> s0() {
            return CollectionsKt.listOf("doubao.com");
        }
    }

    public r() {
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLoadFailed(OfficeBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        FLogger r101 = FLogger.f375446a;
        r101.i("OfficeSdkInitor_Lifecycle", "onLoadFailed " + r100);
        if (r100 != OfficeBizType.IM) goto L20;
        Job r102 = OfficeSdkInitor.f360464n;
        if (r102 == null) goto L7;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L7:
        OfficeSdkInitor.f360464n = null;
        OfficeSdkInitor.f360457g.set(false);
        v2 r103 = OfficeSdkInitor.f360458h;
        if (r103 != null) goto L10;
        r103 = OfficeSdkInitor.f360454d;
    L10:
        OfficeSdkInitor.f360458h = null;
        if (r103 != null) goto L16;
        LarkSocialExp.f365340a.getClass();
        if (((m2) LarkSocialExp.f365344e.getValue()).f486677f == LarkSocialImModuleState.LOADING) goto L16;
        r101.w("OfficeSdkInitor_Lifecycle", "ignore stale IM load failure without active load");
        return;
    L16:
        LarkSocialExp.f365340a.i(r103);
        h.g("office_sdk_load_im_failed");
        if (Intrinsics.areEqual(r103, LarkSocialExp.a()) == true) goto L21;
        OfficeSdkInitor.f360451a.getClass();
        OfficeSdkInitor.c("stale_im_load_failed_retry");
        return;
    L21:
        return;
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLoadReady(OfficeBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        FLogger r101 = FLogger.f375446a;
        r101.i("OfficeSdkInitor_Lifecycle", "onLoadReady " + r100);
        if (r100 != OfficeBizType.IM) goto L26;
        Job r102 = OfficeSdkInitor.f360464n;
        boolean r103 = true;
        if (r102 == null) goto L7;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L7:
        OfficeSdkInitor.f360464n = null;
        AtomicBoolean r104 = OfficeSdkInitor.f360457g;
        r104.set(true);
        v2 r105 = OfficeSdkInitor.f360458h;
        if (r105 != null) goto L10;
        r105 = OfficeSdkInitor.f360454d;
    L10:
        OfficeSdkInitor.f360458h = null;
        if (r105 != null) goto L15;
        r101.w("OfficeSdkInitor_Lifecycle", "ignore IM load ready without Office user session");
        r104.set(false);
        LarkSocialExp r106 = LarkSocialExp.f365340a;
        r106.getClass();
        if (((m2) LarkSocialExp.f365344e.getValue()).f486677f != LarkSocialImModuleState.LOADING) goto L27;
        r106.i(LarkSocialExp.a());
        h.g("office_sdk_load_im_failed");
        return;
    L27:
        return;
    L15:
        LarkSocialExp r107 = LarkSocialExp.f365340a;
        r107.k(r105);
        h.g("office_sdk_load_im_success");
        OfficeSdkInitor.f360451a.getClass();
        if (OfficeSdkInitor.f360453c != null) goto L18;
    L22:
        r103 = false;
    L23:
        if (r103 == true) goto L29;
        r101.w("OfficeSdkInitor_Lifecycle", "IM module loaded for stale generation=" + r105.f486795b + ", rebind current session");
        OfficeSdkInitor.c("office_load_ready_rebind");
        return;
    L29:
        return;
    L18:
        if (Intrinsics.areEqual(OfficeSdkInitor.f360454d, r105) == false) goto L22;
        r107.getClass();
        if (Intrinsics.areEqual(LarkSocialExp.a(), r105) == false) goto L22;
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLoginSuccess(OfficeSDKUserApi r210) {
        Intrinsics.checkNotNullParameter(r210, "officeSDKUserApi");
        v2 r100 = OfficeSdkInitor.f360459i;
        LarkSocialExp r101 = LarkSocialExp.f365340a;
        r101.getClass();
        v2 r102 = LarkSocialExp.a();
        int r103 = u2.f486784a;
        boolean r104 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        long r106 = -1;
        if (r105 == true) goto L19;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("reject stale Office login success loginGeneration=");
        if (r100 == null) goto L13;
        long r109 = r100.f486795b;
    L14:
        r108.append(r109);
        r108.append(" currentGeneration=");
        if (r102 == null) goto L17;
        r106 = r102.f486795b;
    L17:
        r108.append(r106);
        r107.w("OfficeSdkInitor_Lifecycle", r108.toString());
        OfficeSdkInitor r110 = OfficeSdkInitor.f360451a;
        OfficeSDKPassportUserAction r111 = OfficeSDKPassportUserAction.SWITCH;
        r110.getClass();
        OfficeSdkInitor.h(r102, r111, "stale_login_callback");
        return;
    L13:
        r109 = -1;
        goto L14
    L19:
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("Office login success generation=");
        if (r100 == null) goto L22;
        r106 = r100.f486795b;
    L22:
        r113.append(r106);
        r112.i("OfficeSdkInitor_Lifecycle", r113.toString());
        if (Intrinsics.areEqual(OfficeSdkInitor.f360460j, r102) == false) goto L25;
        OfficeSdkInitor r114 = OfficeSdkInitor.f360451a;
        OfficeSdkInitor.f360460j = null;
    L25:
        OfficeSdkInitor r115 = OfficeSdkInitor.f360451a;
        OfficeSdkInitor.f360453c = r210;
        OfficeSdkInitor.f360454d = r102;
        xp9.o.c(r210);
        OfficeSdkInitor.f360459i = null;
        r101.l(r102);
        OfficeSDKManager.INSTANCE.isFunctionAvailable().compareAndSet(false, true);
        r210.setHostService(x05.a.class, new a());
        OfficeSdkInitor.f360451a.getClass();
        Object r116 = xp9.o.f564776a;
        if ((r116 instanceof OfficeSDKUserApi) == false) goto L28;
        OfficeSDKUserApi r117 = (OfficeSDKUserApi) r116;
    L29:
        if (r117 == null) goto L33;
        aza.d r118 = (aza.d) r117.getService(aza.d.class);
        if (r118 == null) goto L33;
        r118.q4(new s());
    L33:
        Object r119 = xp9.o.f564776a;
        if ((r119 instanceof OfficeSDKUserApi) == false) goto L36;
        OfficeSDKUserApi r120 = (OfficeSDKUserApi) r119;
    L37:
        if (r120 == null) goto L39;
        r120.setHostService(IDoubaoTextSelectService.class, IOfficeSocialBridge.f355120a.d());
    L39:
        Object r121 = xp9.o.f564776a;
        if ((r121 instanceof OfficeSDKUserApi) == false) goto L42;
        OfficeSDKUserApi r122 = (OfficeSDKUserApi) r121;
    L43:
        if (r122 == null) goto L45;
        r122.setHostService(oza.a.class, IOfficeSocialBridge.f355120a.c());
    L45:
        Object r123 = xp9.o.f564776a;
        if ((r123 instanceof OfficeSDKUserApi) == false) goto L48;
        OfficeSDKUserApi r124 = (OfficeSDKUserApi) r123;
    L49:
        if (r124 == null) goto L51;
        r124.setHostService(nza.a.class, IOfficeSocialBridge.f355120a.i());
    L51:
        Iterator r125 = CollectionsKt.toList(OfficeSdkInitor.d()).iterator();
    L53:
        if (r125.hasNext() == false) goto L63;
        OfficeSdkInitor.a r126 = (OfficeSdkInitor.a) r125.next();
        OfficeSdkInitor.f360451a.getClass();
        if (OfficeSdkInitor.d().remove(r126) == false) goto L53;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L58
        r126.a(r210);     // Catch: Throwable -> L58
        Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L58
    L60:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L53;
        FLogger.f375446a.e("OfficeSdkInitor_Lifecycle", "Notify Office user ready failed", r129);
    L58:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L60
    L63:
        IFlowBehaviorAuditService r131 = (IFlowBehaviorAuditService) ServiceManager.get().getService(IFlowBehaviorAuditService.class);
        if (r131 == null) goto L66;
        r131.init(r210);
    L66:
        Lazy r132 = h.f360505a;
        long r133 = SystemClock.elapsedRealtime();
        h.f360508d = r133;
        if (h.f360506b > 0) goto L69;
    L74:
        q0 r134 = OfficeSdkInitor.f360467q;
        long r135 = r134.f361049h;
        if (r135 <= 0) goto L77;
        long r136 = RangesKt.coerceAtLeast(r134.f361042a.invoke().longValue() - r135, 0);
    L79:
        if (r134.f361049h > 0) goto L81;
    L88:
        OfficeSdkInitor.f360451a.getClass();
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L91
        e10 r138 = e10.f368561a;     // Catch: Throwable -> L91
        int r139 = com.larus.utils.l0.f375430a;     // Catch: Throwable -> L91
        new zv9.l();     // Catch: Throwable -> L91
        Object r140 = Result.m9449constructorimpl(Boolean.valueOf(((zv9.k) com.larus.utils.l0.a(new zv9.k(0), new p8())).a()));     // Catch: Throwable -> L91
    L93:
        Boolean r141 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r140) == false) goto L96;
        r140 = r141;
    L96:
        boolean r142 = ((Boolean) r140).booleanValue();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L144;
        if (r142 == false) goto L144;
        Object r143 = Result.m9449constructorimpl((com.ss.android.lark.integrator.security.compliance.export.c) r210.getService(com.ss.android.lark.integrator.security.compliance.export.c.class));     // Catch: Throwable -> L102
    L104:
        Object r144 = r143;
        if (Result.m9455isFailureimpl(r144) == false) goto L107;
        Object r145 = null;
    L108:
        com.ss.android.lark.integrator.security.compliance.export.c r146 = (com.ss.android.lark.integrator.security.compliance.export.c) r145;
        if (r146 != null) goto L158;
        Result r147 = null;
    L116:
        if (r147 == null) goto L121;
        Object r148 = r147.m9458unboximpl();
        if (Result.m9455isFailureimpl(r148) == false) goto L120;
        r148 = null;
    L120:
        boolean r149 = Intrinsics.areEqual(r148, Boolean.TRUE);
    L123:
        if (Result.m9455isFailureimpl(r144) == true) goto L136;
        if (r146 == null) goto L136;
        if (r147 != null) goto L128;
    L130:
        r104 = false;
    L131:
        if (r104 == false) goto L133;
        String r150 = "check_failed";
    L137:
        IApplog.Companion r151 = IApplog.f287053a;
        JSONObject r152 = new JSONObject();
        r152.put("platform", "android");
        r152.put("duration_ms", RangesKt.coerceAtLeast(r136, 0));
        if (r149 == false) goto L140;
        String r153 = "success";
    L141:
        r152.put("result", r153);
        r152.put("error_code", r150);
        Unit r154 = Unit.INSTANCE;
        r151.reportEvent("flow_enterprise_file_key_ready", r152);
        if (r149 == true) goto L144;
        FLogger.f375446a.w("OfficeSdkInitor_Lifecycle", "file crypto key not ready errorCode=".concat(r150));
        goto L144
    L140:
        r153 = "fail";
        goto L141
    L133:
        if (r149 == true) goto L135;
        r150 = "key_not_ready";
        goto L137
    L135:
        r150 = "";
        goto L137
    L128:
        if (Result.m9455isFailureimpl(r147.m9458unboximpl()) != true) goto L130;
    L136:
        r150 = "service_unavailable";
        goto L137
    L121:
        r149 = false;
        goto L123
    L158:
        Object r155 = Result.m9449constructorimpl(Boolean.valueOf(r146.B4()));     // Catch: Throwable -> L112
    L114:
        r147 = Result.m9448boximpl(r155);
    L112:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r155 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L114
    L107:
        r145 = r144;
    L102:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L144:
        OfficeSdkInitor.f360451a.getClass();
        OfficeSdkInitor.c("office_login_success");
        z2 r158 = z2.f365865a;
        boolean r159 = r158.enableMessageMention();
        FLogger r160 = FLogger.f375446a;
        r160.i("OfficeSdkInitor", "[setupMention] enableMention:" + r159);
        if (r159 == false) goto L167;
        String r161 = r158.getLarkCliAppId();
        if (StringsKt.isBlank(r161) == false) goto L150;
        r160.w("OfficeSdkInitor", "[setupMention] lark appId is blank");
        return;
    L150:
        BuildersKt.launch$default(OfficeSdkInitor.f360462l, null, null, new OfficeSdkInitor$setupMention$1(new ICoreInputAbility.f(r161), null), 3, null);
        return;
    L167:
        return;
    L91:
        th = move-exception;
        Result.Companion r162 = Result.Companion;
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L93
    L81:
        if (r134.f361055n.compareAndSet(false, true) == false) goto L88;
        long r163 = r134.f361042a.invoke().longValue();
        if (r134.f361050i <= 0) goto L86;
        long r164 = r134.f361050i - r134.f361049h;
    L87:
        r134.a(r163 - r134.f361049h, r164, r164, r164, true);
        goto L88
    L86:
        r164 = r163 - r134.f361049h;
        goto L87
    L77:
        r136 = 0;
        goto L79
    L69:
        if (r133 <= 0) goto L74;
        if (h.f360513i.compareAndSet(false, true) == false) goto L74;
        JSONObject r165 = new JSONObject();
        r165.put("source", h.f360510f);
        r165.put("global_ready_duration", h.b());
        r165.put("user_ready_duration", h.d());
        h.a(r165);
        FLogger.f375446a.i("OfficeSdkInitMonitor", "report office_sdk_load_success payload=" + r165);
        com.larus.platform.service.o.f365780a.reportEvent("office_sdk_load_success", r165);
        goto L74
    L48:
        r124 = null;
        goto L49
    L42:
        r122 = null;
        goto L43
    L36:
        r120 = null;
        goto L37
    L28:
        r117 = null;
        goto L29
    L5:
        if (Intrinsics.areEqual(r100, r102) == false) goto L7;
        r105 = true;
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLogoutSuccess(String r100) {
        FLogger.f375446a.i("OfficeSdkInitor_Lifecycle", "Office logout success " + r100);
        IFlowBehaviorAuditService r101 = (IFlowBehaviorAuditService) ServiceManager.get().getService(IFlowBehaviorAuditService.class);
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onUserComponentReady(OfficeSDKUserApi r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onUserComponentReady(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onWarmupReady(OfficeBizType r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onWarmupReady(this, r100);
    }

    /* JADX WARN: Type inference failed for: r2v34, types: [com.larus.office.base.q] */
    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onInitReady(IOfficeSDKRuntime r100, OfficeSDKGlobalApi r101) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKRuntime");
        Intrinsics.checkNotNullParameter(r101, "officeSDKGlobalApi");
        FLogger.f375446a.i("OfficeSdkInitor_Lifecycle", "Office init ready");
        OfficeSdkInitor.f360455e = r101;
        xp9.n.f564774a = r101;
        if (r101 == null) goto L8;
        Iterator r102 = ((CopyOnWriteArrayList) xp9.n.f564775b).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((Function1) r102.next()).invoke(r101);
    L8:
        OfficeSdkInitor.f360451a.getClass();
        Iterator r103 = OfficeSdkInitor.d().iterator();
    L10:
        if (r103.hasNext() == false) goto L19;
        OfficeSdkInitor.a r104 = (OfficeSdkInitor.a) r103.next();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        r104.b(r101);     // Catch: Throwable -> L14
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L10;
        FLogger.f375446a.e("OfficeSdkInitor_Lifecycle", "Notify Office global ready failed", r107);
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L19:
        OfficeSdkInitor.f360451a.getClass();
        r101.setHostService(bxa.a.class, new com.larus.office.base.host.p());
        r101.setHostService(oyb.a.class, new com.larus.office.base.host.m());
        r101.setHostService(rwb.a.class, new com.larus.office.base.host.i(OfficeSdkInitor.f360462l));
        r101.setHostService(IOfficeSDKPluginService.class, wm9.a.f560365a);
        Intrinsics.checkNotNullParameter(r101, "officeSDKGlobalApi");
        IOfficeSocialBridge.Companion r109 = IOfficeSocialBridge.f355120a;
        Object r110 = r109.p();
        if ((r110 instanceof OfficeSdkOpenMessageOperator) == false) goto L22;
        OfficeSdkOpenMessageOperator r111 = (OfficeSdkOpenMessageOperator) r110;
    L24:
        if (r111 != null) goto L26;
        FLogger.f375446a.w("OfficeSdkInitor", "setOpenMessageOperator: operator is null, skip registration");
    L31:
        r101.setHostService(IPermissionRequester.class, new OfficeSdkInitor$setPermissionRequester$1());
        r101.setHostService(gtb.a.class, new g0());
        r101.setHostService(etb.b.class, new d0());
        r101.setHostService(etb.a.class, new e0());
        r101.setHostService(etb.d.class, new f0());
        FLogger r112 = FLogger.f375446a;
        r112.i("OfficeSdkInitor", "setOfficeSDKLibraConfig: registering host libra config");
        r101.setHostService(etb.c.class, new h0());
        r101.setHostService(com.ss.android.lark.router.a.class, new OfficeSdkInitor$setOfficeUrlRouter$1());
        r101.setHostService(o0b.c.class, new y());
        r101.setHostService(kub.e.class, new n0());
        r101.setHostService(owb.b.class, new c0());
        r101.setHostService(itb.d.class, new z());
        r101.setHostService(itb.a.class, new a0());
        r101.setHostService(itb.c.class, new b0());
        r101.setHostService(itb.e.class, new DoubaoOfficeMediaApi());
        r101.setHostService(itb.b.class, new com.larus.office.base.host.a());
        r101.setHostService(x1c.d.class, new OfficeSdkInitor$setOfficeProfileProtocol$1());
        r101.setHostService(com.ss.android.lark.biz.im.api.r.class, r109.m());
        r101.setHostService(mpc.e.class, r109.e());
        r101.setHostService(nza.a.class, r109.i());
        r101.setHostService(uza.a.class, new j0());
        r101.setHostService(rw4.d.class, new v());
        r101.setHostService(kza.d.class, new OfficeSdkInitor$setGalleryPreview$1());
        r101.setHostService(jza.b.class, new w());
        r101.setHostService(eza.a.class, new u());
        r101.setHostService(qza.b.class, new m0());
        r101.setHostService(rza.a.class, new i0());
        r101.setHostService(IOfficeAppBaseInfo.class, new x());
        r101.setHostService(dza.a.class, new l0());
        r101.setHostService(qtb.b.class, r109.a());
        r101.setHostService(qza.a.class, r109.n());
        r101.setHostService(gza.b.class, r109.f());
        r101.setHostService(stb.a.class, r109.j());
        tm9.b r113 = new tm9.b(new q());
        r113.onInitReady(r100, r101);
        OfficeSdkInitor.f360456f = r113;
        Lazy r114 = h.f360505a;
        h.f360507c = SystemClock.elapsedRealtime();
        r112.i("OfficeSdkInitMonitor", "markGlobalReady source=" + h.f360510f);
        q0 r115 = OfficeSdkInitor.f360467q;
        long r116 = 0;
        if (r115.f361046e <= 0) goto L34;
        r116 = r115.f361042a.invoke().longValue() - r115.f361046e;
    L34:
        r115.f361048g = r116;
        return;
    L26:
        aza.c r117 = (aza.c) r101.getService(aza.c.class);
        if (r117 == null) goto L31;
        if (r117.G5() == null) goto L31;
        Intrinsics.checkNotNullParameter(r111, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Office_sdk_imKt.officeSdkRegisterMessageOperator(r111);
        goto L31
    L22:
        r111 = null;
        goto L24
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onWarmupFailed(OfficeBizType r100, String r101) {
        IOfficeSDKLifeCycle.DefaultImpls.onWarmupFailed(this, r100, r101);
    }
}
