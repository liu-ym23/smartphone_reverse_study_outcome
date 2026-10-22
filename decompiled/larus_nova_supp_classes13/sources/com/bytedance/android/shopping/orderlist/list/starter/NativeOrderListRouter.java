package com.bytedance.android.shopping.orderlist.list.starter;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.h0;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.shopping.orderlist.common.controller.n;
import com.bytedance.android.shopping.orderlist.common.model.OrderListRenderWithPreloadCode;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.list.container.OrderListActivity;
import com.bytedance.android.shopping.orderlist.list.model.PageContext;
import com.bytedance.android.shopping.orderlist.list.model.PageEnvironment;
import com.bytedance.android.shopping.orderlist.list.network.OrderListRequestViewModel;
import com.bytedance.android.shopping.orderlist.list.tab.OrderListFirstScreenTabResolver;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import ka3.b;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NativeOrderListRouter implements c {

    public static final class a {
    }

    static {
    }

    public NativeOrderListRouter() {
    }

    public final void a() {
    }

    public final String b() {
        return "ecom_order_list";
    }

    public final boolean c(final Context r11, final Uri r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "uri");
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.c("NativeOrderListRouter", new NativeOrderListRouter$open$1(r12));
        String r2 = n.a;
        Intrinsics.checkNotNullParameter(r12, "schema");
        n.b = r12;
        int r3 = OrderListStarter.i;
        boolean r4 = false;
        if (n.a.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
    L11:
        String r6 = "";
        n.a = "";
        final Boolean r7 = null;
        n.b = null;
        String r8 = UUID.randomUUID().toString();
        final OrderListStarter r9 = new OrderListStarter(r8);
        OrderListStarterHolder.INSTANCE.put(r8, r9);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "uri");
        OrderCommonLog.c(r9.a, new OrderListStarter$openDirectly$1(r12));
        ph.a.a(r11);
        Map<String, ig3.a> r14 = ig3.a.h;
        ig3.a r15 = ig3.a.C0206a.b(r9.g, "yata_order_list", MonitorScenes.FPS_SCENE_ORDER_LIST, r12);
        r9.b = r15;
        OrderCommonFirstScreenMonitor r16 = r15.a;
        if (r16 == null) goto L14;
        r16.e(MonitorScenes.EC_PERF_PAGE_START_ORDER_LIST);
    L14:
        ig3.a r17 = r9.b;
        if (r17 == null) goto L19;
        OrderCommonFirstScreenMonitor r18 = r17.a;
        if (r18 == null) goto L19;
        r18.a(FirstScreenPoint.INITIAL);
    L19:
        ig3.a r19 = r9.b;
        if (r19 == null) goto L24;
        OrderCommonFirstScreenMonitor r110 = r19.a;
        if (r110 == null) goto L24;
        r110.a(FirstScreenPoint.C_PAGE_INIT);
    L24:
        int r111 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r112 = com.bytedance.android.ec.base.settings.a.a;
        Object r10 = new ArrayList();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L185
        Object r21 = d.c.get("ec_order_list_pre_connect_url_list");     // Catch: Throwable -> L78
        if (r21 != null) goto L30;
    L75:
        Object r22 = null;
    L76:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L78
    L80:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L185
        if (r24 == null) goto L84;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L185
    L84:
        if (Result.isFailure-impl(r23) == false) goto L87;
        r23 = null;
    L87:
        if ((r23 instanceof ArrayList) == true) goto L89;
        r23 = null;
    L89:
        Object r25 = (ArrayList) r23;     // Catch: Throwable -> L185
        if (r25 != null) goto L96;
        Object r26 = d.a.get("ec_order_list_pre_connect_url_list");     // Catch: Throwable -> L185
        if ((r26 instanceof ArrayList) == true) goto L95;
        r26 = null;
    L95:
        r25 = (ArrayList) r26;     // Catch: Throwable -> L185
    L96:
        if (r25 != null) goto L194;
        int r27 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L185
        Object r28 = d.c.get("ec_order_list_pre_connect_url_list");     // Catch: Throwable -> L151
        if (r28 != null) goto L103;
    L148:
        Object r29 = null;
    L149:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L151
    L153:
        Throwable r31 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L176
        if (r31 == null) goto L157;
        EnsureManager.ensureNotReachHere(r31);     // Catch: Throwable -> L176
    L157:
        if (Result.isFailure-impl(r30) == false) goto L160;
        r30 = null;
    L160:
        if ((r30 instanceof ArrayList) == true) goto L162;
        r30 = null;
    L162:
        r25 = (ArrayList) r30;     // Catch: Throwable -> L176
        if (r25 != null) goto L183;
        IHybridHostService r32 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L176
        if (r32 == null) goto L168;
        Object r33 = r32.getHostABValue("ec_order_list_pre_connect_url_list", r10);     // Catch: Throwable -> L176
    L169:
        if (r33 != null) goto L171;
    L182:
        r25 = r10;
        goto L183
    L171:
        if ((r33 instanceof ArrayList) == true) goto L173;
        r33 = null;
    L173:
        r25 = (ArrayList) r33;     // Catch: Throwable -> L176
        if (r25 != null) goto L183;
    L176:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L185
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L185
        Throwable r35 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L185
        if (r35 == null) goto L181;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L185
    L181:
        if (Result.isFailure-impl(r25) == false) goto L183;
    L168:
        r33 = null;
    L183:
        d.d("ec_order_list_pre_connect_url_list", r25);     // Catch: Throwable -> L185
        goto L194
    L103:
        if ((r28 instanceof ArrayList) == true) goto L105;
        Object r36 = null;
    L106:
        r29 = (ArrayList) r36;     // Catch: Throwable -> L151
        if (r29 != null) goto L149;
        if ((r28 instanceof Number) == false) goto L136;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L118;
        Float r37 = Float.valueOf(((Number) r28).floatValue());     // Catch: Throwable -> L151
        if ((r37 instanceof ArrayList) == true) goto L116;
        r37 = null;
    L116:
        r29 = (ArrayList) r37;     // Catch: Throwable -> L151
        goto L149
    L118:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L124;
        Double r38 = Double.valueOf(((Number) r28).doubleValue());     // Catch: Throwable -> L151
        if ((r38 instanceof ArrayList) == true) goto L122;
        r38 = null;
    L122:
        r29 = (ArrayList) r38;     // Catch: Throwable -> L151
        goto L149
    L124:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L130;
        Integer r39 = Integer.valueOf(((Number) r28).intValue());     // Catch: Throwable -> L151
        if ((r39 instanceof ArrayList) == true) goto L128;
        r39 = null;
    L128:
        r29 = (ArrayList) r39;     // Catch: Throwable -> L151
        goto L149
    L130:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L136;
        Long r40 = Long.valueOf(((Number) r28).longValue());     // Catch: Throwable -> L151
        if ((r40 instanceof ArrayList) == true) goto L134;
        r40 = null;
    L134:
        r29 = (ArrayList) r40;     // Catch: Throwable -> L151
    L136:
        if ((r28 instanceof JSONObject) == false) goto L138;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L144
        Object r41 = SDKSettingsCacheManager.a().fromJson(r28.toString(), ArrayList.class);     // Catch: Throwable -> L144
        if ((r41 instanceof ArrayList) == true) goto L142;
        r41 = null;
    L142:
        Object r42 = Result.constructor-impl((ArrayList) r41);     // Catch: Throwable -> L144
    L146:
        r29 = r42;
        if (Result.isFailure-impl(r29) == false) goto L149;
    L144:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L151
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
        goto L146
    L138:
        if ((r28 instanceof JSONArray) == false) goto L148;
    L105:
        r36 = r28;
    L151:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L176
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
    L194:
        Iterator r113 = ((ArrayList) r25).iterator();
    L196:
        if (r113.hasNext() == false) goto L198;
        h0.a((String) r113.next());
        goto L196
    L198:
        m.a r114 = m.a;
        m.b(new OrderListStarter$openDirectly$3(r9, r11));
        ig3.a r115 = r9.b;
        if (r115 == null) goto L203;
        OrderCommonFirstScreenMonitor r116 = r115.a;
        if (r116 == null) goto L203;
        r116.a(FirstScreenPoint.PARSE_SCHEMA_START);
    L203:
        Intrinsics.checkNotNullParameter(r12, "uri");
        HashMap r117 = j1.a(r12);
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r118 = r117.entrySet().iterator();
    L205:
        if (r118.hasNext() == false) goto L207;
        Map.Entry r45 = (Map.Entry) r118.next();
        r0.put(r45.getKey(), r45.getValue());
        goto L205
    L207:
        String r119 = (String) r0.get("entry_anchor_tab_id");
        if (r119 != null) goto L210;
    L215:
        Integer r46 = null;
    L216:
        if (r46 == null) goto L218;
        final int r47 = r46.intValue();
    L219:
        if (r119 != null) goto L221;
    L224:
        boolean r48 = true;
    L226:
        if (r48 == true) goto L229;
        if (r46 != null) goto L229;
        OrderCommonErrorMonitorKt.b(null, "SCHEMA_ERROR", "OrderListStarter-composeQueryParams: entryAnchorTabId is invalid originEntryAnchorTabId:" + r119);
    L229:
        final String r49 = j1.c(r12, SimilarProductParam.ENTER_FROM);
        if (r49 != null) goto L233;
        r49 = "";
    L233:
        if (UriProtector.getQueryParameterNames(r12).contains(SimilarProductParam.ENTER_FROM) == true) goto L235;
        OrderCommonErrorMonitorKt.b(null, "SCHEMA_ERROR", "OrderListStarter-composeQueryParams: do not contain enter_from");
    L235:
        String r120 = j1.c(r12, "biz_identity");
        if (r120 == null) goto L239;
        r6 = r120;
    L239:
        String r121 = UriProtector.getQueryParameter(r12, "source_btm_token");
        Lazy r50 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStarter", new OrderListStarter$Companion$composeQueryParams$1(r47, r49));
        OrderListParams r51 = new OrderListParams();
        r51.setTabId(r47);
        r51.setSourceBtmToken(r121);
        r51.setSchemaParamsMap(r0);
        PageContext r122 = new PageContext();
        r122.setEnvironment(PageEnvironment.FULLSCREEN);
        Unit r52 = Unit.INSTANCE;
        r51.setPageContext(r122);
        r51.setBizIdentity(r6);
        r9.d = r51;
        int r123 = OrderListFirstScreenTabResolver.a;
        r9.e = OrderListFirstScreenTabResolver.a(r11.getApplicationContext(), r9.d, true);
        ig3.a r124 = r9.b;
        if (r124 == null) goto L244;
        OrderCommonFirstScreenMonitor r125 = r124.a;
        if (r125 == null) goto L244;
        r125.a(FirstScreenPoint.PARSE_SCHEMA_END);
    L244:
        Map<String, OrderListRequestViewModel> r126 = OrderListRequestViewModel.z;
        String r127 = r9.g;
        Intrinsics.checkNotNullParameter(r127, "sessionId");
        OrderListRequestViewModel r53 = new OrderListRequestViewModel(r127);
        OrderListRequestViewModel.z.put(r127, r53);
        r9.c = r53;
        nj.d r128 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        int r54 = com.bytedance.android.ec.base.settings.c.a;
        Object r55 = 0;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L320
        Object r57 = d.c.get("ec_order_split_container_na");     // Catch: Throwable -> L295
        if (r57 != null) goto L250;
    L292:
        Object r58 = null;
    L293:
        Object r59 = Result.constructor-impl(r58);     // Catch: Throwable -> L295
    L297:
        Throwable r60 = Result.exceptionOrNull-impl(r59);     // Catch: Throwable -> L320
        if (r60 == null) goto L301;
        EnsureManager.ensureNotReachHere(r60);     // Catch: Throwable -> L320
    L301:
        if (Result.isFailure-impl(r59) == false) goto L304;
        r59 = null;
    L304:
        if ((r59 instanceof Integer) == true) goto L306;
        r59 = null;
    L306:
        Object r61 = (Integer) r59;     // Catch: Throwable -> L320
        if (r61 == null) goto L309;
        r55 = r61;
    L329:
        if (((Number) r55).intValue() != 1) goto L331;
        boolean r62 = true;
    L332:
        if (r62 == false) goto L343;
        if (r128 == null) goto L335;
        r128.l();
        final Boolean r63 = Boolean.FALSE;
    L336:
        if (r128 == null) goto L338;
        r128.a();
        r7 = Boolean.FALSE;
    L338:
        Lazy r129 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStarter", new OrderListStarter$openDirectly$isSplitPage$1(r63, r7));
        Boolean r130 = Boolean.TRUE;
        if (Intrinsics.areEqual(r63, r130) == false) goto L343;
        if (Intrinsics.areEqual(r7, r130) == false) goto L343;
        r4 = true;
        goto L343
    L335:
        r63 = null;
    L343:
        OrderListRequestViewModel r131 = r9.c;
        if (r131 == null) goto L346;
        r131.f(r9.d, r4, r9.e);
    L346:
        ig3.a r132 = r9.b;
        if (r132 == null) goto L351;
        OrderCommonFirstScreenMonitor r133 = r132.a;
        if (r133 == null) goto L351;
        r133.a(FirstScreenPoint.CONTAINER_INIT_START);
    L351:
        ig3.a r134 = r9.b;
        if (r134 == null) goto L357;
        OrderCommonFirstScreenMonitor r135 = r134.a;
        if (r135 == null) goto L357;
        r135.a(FirstScreenPoint.T_CONTAINER_INIT);
    L357:
        if (r9.c == null) goto L359;
        r9.a(OrderAppletPageScene.GO_TO_LANDING);
    L360:
        int r136 = OrderListActivity.l;
        OrderListActivity.Companion.a(r11, r9.d, r9.g, r12, r4);
        int r137 = b.a;
        t.b(new ka3.a(r11));
        return true;
    L359:
        Lazy r138 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStarter", OrderListStarter$openDirectly$4.INSTANCE);
        goto L360
    L331:
        r62 = false;
        goto L332
    L309:
        IHybridHostService r64 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L320
        if (r64 == null) goto L312;
        Object r65 = r64.getHostABValue("ec_order_split_container_na", r55);     // Catch: Throwable -> L320
    L313:
        if (r65 == null) goto L329;
        if ((r65 instanceof Integer) == true) goto L317;
        r65 = null;
    L317:
        Object r66 = (Integer) r65;     // Catch: Throwable -> L320
        if (r66 == null) goto L329;
    L327:
        r55 = r66;
        goto L329
    L312:
        r65 = null;
        goto L313
    L250:
        if ((r57 instanceof Integer) == true) goto L252;
        Object r67 = null;
    L253:
        r58 = (Integer) r67;     // Catch: Throwable -> L295
        if (r58 != null) goto L293;
        if ((r57 instanceof Number) == false) goto L280;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L265;
        Float r68 = Float.valueOf(((Number) r57).floatValue());     // Catch: Throwable -> L295
        if ((r68 instanceof Integer) == true) goto L263;
        r68 = null;
    L263:
        r58 = (Integer) r68;     // Catch: Throwable -> L295
        goto L293
    L265:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L271;
        Double r69 = Double.valueOf(((Number) r57).doubleValue());     // Catch: Throwable -> L295
        if ((r69 instanceof Integer) == true) goto L269;
        r69 = null;
    L269:
        r58 = (Integer) r69;     // Catch: Throwable -> L295
        goto L293
    L271:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L274;
        r58 = Integer.valueOf(((Number) r57).intValue());     // Catch: Throwable -> L295
        goto L293
    L274:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L280;
        Long r70 = Long.valueOf(((Number) r57).longValue());     // Catch: Throwable -> L295
        if ((r70 instanceof Integer) == true) goto L278;
        r70 = null;
    L278:
        r58 = (Integer) r70;     // Catch: Throwable -> L295
    L280:
        if ((r57 instanceof JSONObject) == false) goto L282;
    L374:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L288
        Object r71 = SDKSettingsCacheManager.a().fromJson(r57.toString(), Integer.class);     // Catch: Throwable -> L288
        if ((r71 instanceof Integer) == true) goto L286;
        r71 = null;
    L286:
        Object r72 = Result.constructor-impl((Integer) r71);     // Catch: Throwable -> L288
    L290:
        r58 = r72;
        if (Result.isFailure-impl(r58) == false) goto L293;
    L288:
        th = move-exception;
        Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L295
        r72 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L295
        goto L290
    L282:
        if ((r57 instanceof JSONArray) == false) goto L292;
    L252:
        r67 = r57;
    L295:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L320
        r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L320
    L320:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        r66 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r76 = Result.exceptionOrNull-impl(r66);
        if (r76 == null) goto L325;
        EnsureManager.ensureNotReachHere(r76);
    L325:
        if (Result.isFailure-impl(r66) == false) goto L327;
    L221:
        if (StringsKt.isBlank(r119) == true) goto L224;
        r48 = false;
        goto L226
    L218:
        r47 = 0;
        goto L219
    L210:
        if ((!StringsKt.isBlank(r119)) == false) goto L212;
        String r77 = r119;
    L213:
        if (r77 == null) goto L215;
        r46 = StringsKt.toIntOrNull(r77);
        goto L216
    L212:
        r77 = null;
        goto L213
    L30:
        if ((r21 instanceof ArrayList) == true) goto L32;
        Object r78 = null;
    L33:
        r22 = (ArrayList) r78;     // Catch: Throwable -> L78
        if (r22 != null) goto L76;
        if ((r21 instanceof Number) == false) goto L63;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L45;
        Float r79 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L78
        if ((r79 instanceof ArrayList) == true) goto L43;
        r79 = null;
    L43:
        r22 = (ArrayList) r79;     // Catch: Throwable -> L78
        goto L76
    L45:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L51;
        Double r80 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L78
        if ((r80 instanceof ArrayList) == true) goto L49;
        r80 = null;
    L49:
        r22 = (ArrayList) r80;     // Catch: Throwable -> L78
        goto L76
    L51:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L57;
        Integer r81 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L78
        if ((r81 instanceof ArrayList) == true) goto L55;
        r81 = null;
    L55:
        r22 = (ArrayList) r81;     // Catch: Throwable -> L78
        goto L76
    L57:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ArrayList.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L63;
        Long r82 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L78
        if ((r82 instanceof ArrayList) == true) goto L61;
        r82 = null;
    L61:
        r22 = (ArrayList) r82;     // Catch: Throwable -> L78
    L63:
        if ((r21 instanceof JSONObject) == false) goto L65;
    L376:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L71
        Object r84 = SDKSettingsCacheManager.a().fromJson(r21.toString(), ArrayList.class);     // Catch: Throwable -> L71
        if ((r84 instanceof ArrayList) == true) goto L69;
        r84 = null;
    L69:
        Object r85 = Result.constructor-impl((ArrayList) r84);     // Catch: Throwable -> L71
    L73:
        r22 = r85;
        if (Result.isFailure-impl(r22) == false) goto L76;
    L71:
        th = move-exception;
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L78
        r85 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L78
        goto L73
    L65:
        if ((r21 instanceof JSONArray) == false) goto L75;
    L32:
        r78 = r21;
    L78:
        th = move-exception;
        Result.Companion r87 = Result.Companion;     // Catch: Throwable -> L185
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        Object r139 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r89 = Result.exceptionOrNull-impl(r139);
        if (r89 == null) goto L190;
        EnsureManager.ensureNotReachHere(r89);
    L190:
        if (Result.isFailure-impl(r139) == true) goto L193;
        r10 = r139;
    L193:
        r25 = r10;
        goto L194
    L8:
        if (n.b == null) goto L11;
        OrderListRenderWithPreloadCode.RESULT_EMPTY.getCode();
        goto L11
    L5:
        r5 = false;
        goto L6
    }
}
