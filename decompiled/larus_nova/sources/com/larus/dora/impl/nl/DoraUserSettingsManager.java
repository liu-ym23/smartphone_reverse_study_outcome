package com.larus.dora.impl.nl;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.INLService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraUserSettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraUserSettingsManager f336185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f336186b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.larus.dora.impl.network.f0 f336187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableSharedFlow<Boolean> f336188d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutableSharedFlow f336189e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final StateFlowImpl f336190f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final StateFlowImpl f336191g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final StateFlowImpl f336192h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final StateFlowImpl f336193i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final StateFlowImpl f336194j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final StateFlowImpl f336195k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final StateFlowImpl f336196l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final StateFlowImpl f336197m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final StateFlowImpl f336198n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final StateFlowImpl f336199o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final StateFlowImpl f336200p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final StateFlowImpl f336201q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final StateFlowImpl f336202r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final StateFlowImpl f336203s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final NLServiceImpl f336204t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final List<com.larus.dora.impl.network.s> f336205u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final StateFlowImpl f336206v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final StateFlowImpl f336207w = null;

    public static final class a extends com.larus.dora.impl.util.t0 {
        public a() {
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            if (r102 != 2) goto L6;
            DoraUserSettingsManager.f336185a.h("doraConnected");
            return;
        }
    }

    public static final class b implements com.larus.platform.api.b {
        public b() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (DoraAdapterExtKt.r(kj4.a.g()) == false) goto L6;
            DoraUserSettingsManager.f336185a.h("onLogIn");
            return;
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            g49.d.d("DoraUserSettingsManager", "onLogout clearUserSettings");
            com.larus.dora.impl.util.x.f338160a.getClass();
            com.larus.dora.impl.util.b0.f338123a.getClass();
            com.larus.dora.impl.util.b0.j().erase("dora_user_settings");
            com.larus.dora.impl.util.b0.j().erase("dora_nl_confirm_timestamp");
            Type r101 = k.f336275e;
            k.b.f336280a.c(DoraUserSettingsManager.f336205u);
        }
    }

    public DoraUserSettingsManager() {
    }

    static {
        f336185a = new DoraUserSettingsManager();
        f336186b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f336187c = new com.larus.dora.impl.network.f0(null, null, 31);
        MutableSharedFlow<Boolean> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f336188d = r100;
        f336189e = r100;
        Boolean r101 = Boolean.FALSE;
        StateFlowImpl r102 = j1.a(r101);
        f336190f = r102;
        f336191g = r102;
        StateFlowImpl r103 = j1.a(Integer.valueOf(CastIntegerProtector.parseInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)));
        f336192h = r103;
        f336193i = r103;
        StateFlowImpl r104 = j1.a(CollectionsKt.emptyList());
        f336194j = r104;
        f336195k = r104;
        StateFlowImpl r105 = j1.a(new q59.a(0));
        f336196l = r105;
        f336197m = r105;
        StateFlowImpl r106 = j1.a(r101);
        f336198n = r106;
        f336199o = r106;
        StateFlowImpl r107 = j1.a("2");
        f336200p = r107;
        f336201q = r107;
        StateFlowImpl r108 = j1.a(3);
        f336202r = r108;
        f336203s = r108;
        Object r109 = ServiceManager.get().getService(INLService.class);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.larus.dora.impl.nl.NLServiceImpl");
        f336204t = (NLServiceImpl) r109;
        int r110 = com.larus.utils.j0.f375426a;
        f336205u = CollectionsKt.listOf(new com.larus.dora.impl.network.s[]{new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_weixin_cn), "", "com.tencent.mm", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_feishu_cn), "", "com.ss.android.lark", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_douyin_cn), "", "com.ss.android.ugc.aweme", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_xiaohongshu_cn), "", "com.xingin.xhs", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_BiliBili_cn), "", "tv.danmaku.bili", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_didi_cn), "", "com.sdu.didi.psnger", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_taobao_cn), "", "com.taobao.taobao", 1), new com.larus.dora.impl.network.s(com.larus.utils.j0.d(R.string.larus_broadcast_meituan_cn), "", "com.sankuai.meituan", 1)});
        StateFlowImpl r111 = j1.a(null);
        f336206v = r111;
        f336207w = r111;
    }

    public static final void a() {
        com.larus.dora.impl.network.g0 r100 = f336187c.d();
        if (r100 == null) goto L6;
        String r101 = r100.e();
        if (r101 == null) goto L6;
    L7:
        String r102 = r101.concat("s");
        DoraBuryPointManager.f331862a.L("dora_proactive_broadcast_settings", MapsKt.mapOf(TuplesKt.to("broadcast_frequency", r102)));
        return;
    L6:
        r101 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        goto L7
    }

    public static final void b() {
        com.larus.dora.impl.network.g0 r100 = f336187c.d();
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.j();
    L7:
        if (Intrinsics.areEqual(r102, "1") == false) goto L9;
        String r103 = "on";
    L10:
        com.larus.dora.impl.network.g0 r104 = f336187c.d();
        if (r104 == null) goto L14;
        r101 = r104.i();
    L14:
        if (Intrinsics.areEqual(r101, "2") == false) goto L16;
        String r105 = "greet_then_chat";
    L17:
        com.larus.dora.impl.network.g0 r106 = f336187c.d();
        if (r106 == null) goto L21;
        String r107 = r106.h();
        if (r107 == null) goto L21;
    L22:
        DoraBuryPointManager.f331862a.L("dora_proactive_chat_settings", MapsKt.mapOf(new Pair[]{TuplesKt.to("proactive_chat_switch", r103), TuplesKt.to("proactive_chat_method", r105), TuplesKt.to("proactive_chat_frequency", r107)}));
        return;
    L21:
        r107 = "3";
        goto L22
    L16:
        r105 = "direct_chat";
        goto L17
    L9:
        r103 = "off";
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static boolean f() {
        com.larus.dora.impl.network.g0 r100 = f336187c.d();
        if (r100 == null) goto L5;
        String r101 = r100.f();
    L7:
        return Intrinsics.areEqual(r101, "2");
    L5:
        r101 = null;
        goto L7
    }

    public static void g() {
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$setNotificationPrivacyAgreed$1(null), 3, null);
    }

    public final void e() {
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$initData$1(null), 3, null);
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == true) goto L5;
    L7:
        kj4.a.g().registerDoraLinkCallback(new a());
        r100.E(new b());
        return;
    L5:
        if (kj4.a.g().hasDoraDevice() == false) goto L7;
        h("init");
        goto L7
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "where");
        DoraDevice r101 = DoraAdapterExtKt.h(kj4.a.g());
        if (r101 == null) goto L15;
        String r102 = r101.f204390sn;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L15;
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$syncNotificationBroadcastV3Settings$1(r101, r100, null), 3, null);
        return;
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
    L15:
        g49.d.b("DoraUserSettingsManager", "syncNotificationBroadcastV3Settings failed, device is null or sn is empty, where=".concat(r100));
    }

    public static void l(int r100) {
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$updateNotificationFreq$1(r100, null), 3, null);
    }

    public static void m(boolean r100) {
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$updateNotificationSwitch$1(r100, null), 3, null);
    }

    public static void n(boolean r100) {
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$updateProactiveSwitch$1(r100, null), 3, null);
    }

    public static void o(boolean r100) {
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$updateWearingRemind$1(r100, null), 3, null);
    }

    public final void h(String r110) {
        Intrinsics.checkNotNullParameter(r110, "where");
        j(this, r110);
        List r100 = CollectionsKt.listOf("wearing_reminder_switch");
        Intrinsics.checkNotNullParameter(r110, "where");
        Intrinsics.checkNotNullParameter(r100, "keys");
        DoraDevice r101 = DoraAdapterExtKt.h(kj4.a.g());
        if (r101 == null) goto L22;
        String r102 = r101.f204390sn;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L22;
        List r104 = CollectionsKt.toMutableList(r100);
        if (o59.a.l(r101) == false) goto L19;
        if (r100.contains("wearing_reminder_switch") == false) goto L19;
        g49.d.d("DoraUserSettingsManager", "syncUserSettingV2 filter, G does not have wearing remind switch");
        r104.remove("wearing_reminder_switch");
    L19:
        if (r104.isEmpty() == false) goto L21;
        g49.d.d("DoraUserSettingsManager", "syncUserSettingV2 filteredKeys is empty, no need to request");
        return;
    L21:
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$syncUserSettingV2$1(r101, r104, r100, r110, null), 3, null);
        return;
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
    L22:
        g49.d.b("DoraUserSettingsManager", "syncUserSettingV2 failed, device is null or sn is empty, where=".concat(r110));
    }

    public static void j(DoraUserSettingsManager r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "where");
        g49.d.d("DoraUserSettingsManager", "syncUserSettings start from ".concat(r101));
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$syncUserSettings$1(true, r101, null), 3, null);
    }

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
    public static final Object d(DoraUserSettingsManager r110, com.larus.dora.impl.network.f0 r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof DoraUserSettingsManager$updateUserSettings$1) == false) goto L7;
        DoraUserSettingsManager$updateUserSettings$1 r100 = (DoraUserSettingsManager$updateUserSettings$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        r111 = (com.larus.dora.impl.network.f0) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Object r115 = ((Result) r113).m9458unboximpl();
    L73:
        if (Result.m9456isSuccessimpl(r115) == true) goto L75;
    L78:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L83;
        g49.d.c("DoraUserSettingsManager", "updateUserSettings failed", r116);
        t19.s r117 = t19.s.f544207a;
        Application r118 = AppHost.f326268a.getApplication();
        r117.getClass();
        t19.s.b(r118, R.string.larus_network_error, false);
        r115 = Boxing.boxBoolean(false);
    L83:
        return r115;
    L75:
        if (((Boolean) r115).booleanValue() == false) goto L77;
        g49.d.d("DoraUserSettingsManager", "updateUserSettings success");
        f336187c = r111;
        com.larus.dora.impl.util.x.f338160a.getClass();
        com.larus.dora.impl.util.x.b(r111);
        goto L78
    L77:
        g49.d.b("DoraUserSettingsManager", "updateUserSettings error code");
        goto L78
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        List<com.larus.dora.impl.network.s> r119 = r111.c();
        List<com.larus.dora.impl.network.s> r103 = f336187c.c();
        JSONObject r104 = null;
        if (r103 == null) goto L17;
        List r105 = CollectionsKt.filterNotNull(r103);
    L18:
        if (r105 != null) goto L20;
        r105 = CollectionsKt.emptyList();
    L20:
        List r106 = r105;
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r106, 10)), 16));
        Iterator r108 = r106.iterator();
    L22:
        if (r108.hasNext() == false) goto L24;
        Object r109 = r108.next();
        r107.put(((com.larus.dora.impl.network.s) r109).d(), r109);
        goto L22
    L24:
        if (r119 == null) goto L39;
        List r120 = CollectionsKt.filterNotNull(r119);
        if (r120 == null) goto L39;
        ArrayList r121 = new ArrayList();
        Iterator r122 = r120.iterator();
    L29:
        if (r122.hasNext() == false) goto L40;
        Object r123 = r122.next();
        com.larus.dora.impl.network.s r124 = (com.larus.dora.impl.network.s) r123;
        com.larus.dora.impl.network.s r125 = (com.larus.dora.impl.network.s) r107.get(r124.d());
        if (r125 != null) goto L33;
    L36:
        boolean r126 = true;
    L37:
        if (r126 == false) goto L29;
        r121.add(r123);
        goto L29
    L33:
        if (Intrinsics.areEqual(r125, r124) == false) goto L36;
        r126 = false;
    L40:
        if (r121 != null) goto L42;
    L45:
        boolean r127 = true;
    L46:
        if (r127 == false) goto L48;
        JSONArray r128 = null;
    L52:
        com.larus.dora.impl.network.g0 r129 = r111.d();
        if (r129 == null) goto L64;
        JSONObject r130 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), f336187c.d()));
        JSONObject r131 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r129));
        JSONObject r132 = new JSONObject();
        Iterator<String> r133 = r131.keys();
    L57:
        if (r133.hasNext() == false) goto L62;
        String r134 = r133.next();
        if (Intrinsics.areEqual(r130.opt(r134), r131.opt(r134)) == true) goto L57;
        r132.put(r134, r131.opt(r134));
        goto L57
    L62:
        if (r132.length() <= 0) goto L64;
        r104 = r132;
    L64:
        JSONObject r135 = new JSONObject();
        JSONObject r136 = new JSONObject();
        if (r128 == null) goto L67;
        r136.put("notification_app_list", r128);
    L67:
        if (r104 == null) goto L69;
        r136.put("extra_params", r104);
    L69:
        Unit r137 = Unit.INSTANCE;
        r135.put("user_settings", r136);
        g49.d.d("DoraUserSettingsManager", "updateUserSettings param " + r135);
        DoraNetworkApi r138 = DoraNetworkApi.f336157a;
        r100.L$0 = r111;
        r100.label = 1;
        r115 = r138.I(r135, r100);
        if (r115 != r114) goto L73;
        return r114;
    L48:
        new Gson();
        r128 = new JSONArray();
        Iterator r139 = r121.iterator();
    L50:
        if (r139.hasNext() == false) goto L52;
        com.larus.dora.impl.network.s r140 = (com.larus.dora.impl.network.s) r139.next();
        JSONObject r141 = new JSONObject();
        r141.put("notification_app_package", r140.d());
        r141.put("notification_app_status", r140.e());
        r128.put(r141);
        goto L50
    L42:
        if (r121.isEmpty() == true) goto L45;
        r127 = false;
    L39:
        r121 = null;
        goto L40
    L17:
        r105 = null;
    L7:
        r100 = new DoraUserSettingsManager$updateUserSettings$1(r110, r112);
        goto L8
    }

    public static void k(String r100, Object r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        BuildersKt.launch$default(f336186b, null, null, new DoraUserSettingsManager$updateNotificationBroadcastV3DeviceSetting$1(r100, r101, r102, null), 3, null);
    }

    public static final Object c(DoraUserSettingsManager r100, String r101, Object r102, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof DoraUserSettingsManager$updateUserSettingV2$1) == false) goto L7;
        DoraUserSettingsManager$updateUserSettingV2$1 r103 = (DoraUserSettingsManager$updateUserSettingV2$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r102 = r103.L$1;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
        Object r107 = ((Result) r105).m9458unboximpl();
    L34:
        if (Result.m9456isSuccessimpl(r107) == true) goto L36;
    L39:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L47;
        g49.d.c("DoraUserSettingsManager", "updateUserSettingV2 failed", r108);
        t19.s r109 = t19.s.f544207a;
        Application r112 = AppHost.f326268a.getApplication();
        r109.getClass();
        t19.s.b(r112, R.string.larus_network_error, false);
        r107 = Boxing.boxBoolean(false);
    L47:
        return r107;
    L36:
        if (((Boolean) r107).booleanValue() == false) goto L38;
        g49.d.d("DoraUserSettingsManager", "updateUserSettingV2 success");
        com.larus.dora.impl.util.b0.f338123a.getClass();
        com.larus.dora.impl.util.b0.O(r101, r102);
        goto L39
    L38:
        g49.d.b("DoraUserSettingsManager", "updateUserSettingV2 error code");
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        DoraDevice r113 = DoraAdapterExtKt.h(kj4.a.g());
        if (r113 == null) goto L44;
        String r114 = r113.f204390sn;
        if (r114 != null) goto L19;
    L22:
        boolean r115 = true;
    L23:
        if (r115 == true) goto L44;
        if (o59.a.l(r113) == true) goto L28;
    L30:
        DoraNetworkApi r116 = DoraNetworkApi.f336157a;
        JSONObject r117 = new JSONObject();
        r117.put(r101, r102);
        Unit r118 = Unit.INSTANCE;
        r103.L$0 = r101;
        r103.L$1 = r102;
        r103.label = 1;
        r107 = r116.A(r113, r117, r103);
        if (r107 != r111) goto L34;
        return r111;
    L28:
        if (Intrinsics.areEqual(r101, "wearing_reminder_switch") == false) goto L30;
        g49.d.d("DoraUserSettingsManager", "updateUserSettingV2 return, G does not have wearing remind switch");
        return Boxing.boxBoolean(false);
    L19:
        if (r114.length() == 0) goto L22;
        r115 = false;
    L44:
        g49.d.b("DoraUserSettingsManager", "updateUserSettingV2 failed, device is null or sn is empty");
        return Boxing.boxBoolean(false);
    L7:
        r103 = new DoraUserSettingsManager$updateUserSettingV2$1(r100, r110);
        goto L8
    }
}
