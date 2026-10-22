package rb3;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.card_list.container.CardListFragment;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.collect.components.CollectListLauncher;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenPoint;
import com.bytedance.android.shopping.collect.monitor.fps.CollectYataFpsMonitor;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.router.ECFavoriteRouter;
import com.bytedance.android.shopping.collect.slice.CollectYataTemplateManager;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import sc3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements g {
    public b() {
        Map r0 = bf.a.a;
        ECFavoriteRouter r1 = new ECFavoriteRouter();
        Intrinsics.checkNotNullParameter(r1, "interceptor");
        ((ArrayList) bf.a.c).add(r1);
    }

    @Override // sc3.g
    public final Fragment a(Context r21, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "params");
        int r4 = c.j;
        c r5 = new c(UUID.randomUUID().toString());
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "params");
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.g().contains("collect") == false) goto L176;
        Intrinsics.checkNotNullParameter(r22, "params");
        LinkedHashMap r3 = new LinkedHashMap();
        Boolean r0 = Boolean.FALSE;
        r3.put("need_check_login", r0);
        r3.put("opt_preload_layout", Boolean.TRUE);
        r3.put("need_cache_manager", r0);
        r3.put("biz_type", Integer.valueOf(LauncherBizType.COLLECT.ordinal()));
        r3.put("query_data_in_starter", r0);
        r3.put(PdpOpenThirdParam.KEY_PAGE_NAME, "collect_list_page");
        r3.put("standard_show_event_name", "collect_module_show");
        r3.put("standard_click_event_name", "collect_module_click");
        int r1 = n.a;
        Object r11 = 3;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L159
        Object r7 = d.c.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L55
        if (r7 != null) goto L10;
    L52:
        Object r12 = null;
    L53:
        Object r8 = Result.constructor-impl(r12);     // Catch: Throwable -> L55
    L57:
        Throwable r13 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L159
        if (r13 == null) goto L61;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L159
    L61:
        if (Result.isFailure-impl(r8) == false) goto L64;
        r8 = null;
    L64:
        if ((r8 instanceof Integer) == true) goto L66;
        r8 = null;
    L66:
        Object r9 = (Integer) r8;     // Catch: Throwable -> L159
        if (r9 != null) goto L73;
        Object r10 = d.a.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L159
        if ((r10 instanceof Integer) == true) goto L72;
        r10 = null;
    L72:
        r9 = (Integer) r10;     // Catch: Throwable -> L159
    L73:
        if (r9 != null) goto L168;
        int r14 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L159
        Object r15 = d.c.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L125
        if (r15 != null) goto L80;
    L122:
        Object r16 = null;
    L123:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L125
    L127:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L150
        if (r18 == null) goto L131;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L150
    L131:
        if (Result.isFailure-impl(r17) == false) goto L134;
        r17 = null;
    L134:
        if ((r17 instanceof Integer) == true) goto L136;
        r17 = null;
    L136:
        r9 = (Integer) r17;     // Catch: Throwable -> L150
        if (r9 != null) goto L157;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r19 == null) goto L142;
        Object r20 = r19.getHostABValue("ec_cart_gul_preload_threshold", r11);     // Catch: Throwable -> L150
    L143:
        if (r20 != null) goto L145;
    L156:
        r9 = r11;
        goto L157
    L145:
        if ((r20 instanceof Integer) == true) goto L147;
        r20 = null;
    L147:
        r9 = (Integer) r20;     // Catch: Throwable -> L150
        if (r9 != null) goto L157;
    L150:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L159
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
        Throwable r111 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L159
        if (r111 == null) goto L155;
        EnsureManager.ensureNotReachHere(r111);     // Catch: Throwable -> L159
    L155:
        if (Result.isFailure-impl(r9) == false) goto L157;
    L142:
        r20 = null;
    L157:
        d.d("ec_cart_gul_preload_threshold", r9);     // Catch: Throwable -> L159
        goto L168
    L80:
        if ((r15 instanceof Integer) == true) goto L82;
        Object r112 = null;
    L83:
        r16 = (Integer) r112;     // Catch: Throwable -> L125
        if (r16 != null) goto L123;
        if ((r15 instanceof Number) == false) goto L110;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L95;
        Float r23 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L125
        if ((r23 instanceof Integer) == true) goto L93;
        r23 = null;
    L93:
        r16 = (Integer) r23;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L101;
        Double r24 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L125
        if ((r24 instanceof Integer) == true) goto L99;
        r24 = null;
    L99:
        r16 = (Integer) r24;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L104;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L110;
        Long r25 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L125
        if ((r25 instanceof Integer) == true) goto L108;
        r25 = null;
    L108:
        r16 = (Integer) r25;     // Catch: Throwable -> L125
    L110:
        if ((r15 instanceof JSONObject) == false) goto L112;
    L240:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L118
        Object r26 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r26 instanceof Integer) == true) goto L116;
        r26 = null;
    L116:
        Object r27 = Result.constructor-impl((Integer) r26);     // Catch: Throwable -> L118
    L120:
        r16 = r27;
        if (Result.isFailure-impl(r16) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L125
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r15 instanceof JSONArray) == false) goto L122;
    L82:
        r112 = r15;
    L125:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L150
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L168:
        ((Number) r9).intValue();
        r3.put("gul_preload_threshold", 4);
        LinkedHashMap r28 = (LinkedHashMap) r22;
        r3.put("need_load_gul", Boolean.valueOf(Intrinsics.areEqual((String) r28.get("is_from_personal"), "0")));
        r3.put("need_set_gradient_view", Boolean.valueOf(Intrinsics.areEqual((String) r28.get("is_from_personal"), "1")));
        r3.put("need_pull_refresh", Boolean.FALSE);
        int r29 = CollectListLauncher.c;
        CollectListLauncher.Companion.a();
        int r30 = ECSdk.a;
        IEShoppingService r31 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r31 == null) goto L173;
        sc3.d r32 = r31.getCardKitService();
        if (r32 == null) goto L173;
        CardListFragment r33 = r32.a(r21, r3, r22);
    L174:
        if (r33 == null) goto L176;
        return r33;
    L173:
        r33 = null;
        goto L174
    L10:
        if ((r7 instanceof Integer) == true) goto L12;
        Object r115 = null;
    L13:
        r12 = (Integer) r115;     // Catch: Throwable -> L55
        if (r12 != null) goto L53;
        if ((r7 instanceof Number) == false) goto L40;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r34 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L55
        if ((r34 instanceof Integer) == true) goto L23;
        r34 = null;
    L23:
        r12 = (Integer) r34;     // Catch: Throwable -> L55
        goto L53
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r35 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L55
        if ((r35 instanceof Integer) == true) goto L29;
        r35 = null;
    L29:
        r12 = (Integer) r35;     // Catch: Throwable -> L55
        goto L53
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L34;
        r12 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L55
        goto L53
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L40;
        Long r36 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L55
        if ((r36 instanceof Integer) == true) goto L38;
        r36 = null;
    L38:
        r12 = (Integer) r36;     // Catch: Throwable -> L55
    L40:
        if ((r7 instanceof JSONObject) == false) goto L42;
    L238:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L48
        Object r37 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L48
        if ((r37 instanceof Integer) == true) goto L46;
        r37 = null;
    L46:
        Object r38 = Result.constructor-impl((Integer) r37);     // Catch: Throwable -> L48
    L50:
        r12 = r38;
        if (Result.isFailure-impl(r12) == false) goto L53;
    L48:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L55
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
        goto L50
    L42:
        if ((r7 instanceof JSONArray) == false) goto L52;
    L12:
        r115 = r7;
    L55:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L159
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L159:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r119 = Result.exceptionOrNull-impl(r39);
        if (r119 == null) goto L164;
        EnsureManager.ensureNotReachHere(r119);
    L164:
        if (Result.isFailure-impl(r39) == true) goto L167;
        r11 = r39;
    L167:
        r9 = r11;
    L176:
        LinkedHashMap r40 = (LinkedHashMap) r22;
        String r41 = (String) r40.get("sec_uid");
        if (r41 != null) goto L179;
    L184:
        String r42 = (String) r40.get("uid");
        if (r42 == null) goto L189;
        String r43 = a2.d(r42);
        if (r43 == null) goto L189;
        r5.b = r43;
    L189:
        String r44 = (String) r40.get("ecom_scene_id");
        if (r44 == null) goto L194;
        String r45 = a2.d(r44);
        if (r45 == null) goto L194;
        r5.c = r45;
    L194:
        String r46 = (String) r40.get("previous_page");
        if (r46 == null) goto L200;
        String r47 = a2.d(r46);
        if (r47 == null) goto L200;
        r5.e = r47;
    L200:
        if (r5.e.length() != 0) goto L202;
        boolean r48 = true;
    L203:
        if (r48 == false) goto L205;
        r5.e = "personal_homepage";
    L205:
        String r49 = (String) r40.get("uid");
        if (r49 == null) goto L210;
        String r50 = a2.d(r49);
        if (r50 == null) goto L210;
        r5.f = r50;
    L210:
        r5.g = Intrinsics.areEqual((String) r40.get("is_from_personal"), "1");
        String r51 = (String) r40.get("collect_experiment_value");
        if (r51 == null) goto L215;
        String r52 = a2.d(r51);
        if (r52 == null) goto L215;
        r5.h = CastIntegerProtector.parseInt(r52);
    L215:
        CollectParams r53 = new CollectParams(r5.a, r5.b, r5.f, r5.c, r5.d, r5.e, r5.g, r5.i, r5.h);
        Map<String, pb3.a> r54 = pb3.a.h;
        Intrinsics.checkNotNullParameter(r53, "collectParam");
        pb3.a r55 = new pb3.a(r53);
        String r56 = UUID.randomUUID().toString();
        pb3.a.h.put(r56, r55);
        r53.setMonitorId(r56);
        JSONObject r57 = new JSONObject();
        r57.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r57.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r57.put(PdpOpenThirdParam.KEY_PAGE_NAME, "collect_list_page");
        r57.put("previous_page", r53.getPreviousPage());
        String r58 = r53.getSession_id();
        String r59 = "";
        if (r58 != null) goto L218;
        r58 = "";
    L218:
        r57.put("session_id", r58);
        CollectYataFirstScreenDurationMonitor r60 = new CollectYataFirstScreenDurationMonitor(r53.getMonitorId(), x0.a(r57));
        r55.b = r60;
        CollectYataFirstScreenDurationMonitor.a(r60, CollectYataFirstScreenPoint.START);
        Map<String, com.bytedance.android.shopping.collect.monitor.error.a> r61 = com.bytedance.android.shopping.collect.monitor.error.a.b;
        String r62 = r53.getMonitorId();
        if (r62 == null) goto L222;
        r59 = r62;
    L222:
        JSONObject r63 = x0.a(r57);
        Intrinsics.checkNotNullParameter(r59, "id");
        Intrinsics.checkNotNullParameter(r63, "baseParams");
        com.bytedance.android.shopping.collect.monitor.error.a r64 = new com.bytedance.android.shopping.collect.monitor.error.a(r63);
        com.bytedance.android.shopping.collect.monitor.error.a.b.put(r59, r64);
        r55.c = r64;
        r55.d = new CollectYataFpsMonitor(r53, x0.a(r57));
        Map r65 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.b(MonitorScenes.EC_PERF_PAGE_START_COLLECT, null, r55.a());
        int r66 = CollectYataFragment.t;
        Intrinsics.checkNotNullParameter(r53, "collectParams");
        CollectYataFragment r67 = new CollectYataFragment();
        if (r67.getArguments() != null) goto L225;
        Bundle r68 = new Bundle();
    L226:
        r67.setArguments(r68);
        Bundle r69 = r67.getArguments();
        if (r69 == null) goto L229;
        r69.putSerializable("collect_params", r53);
    L229:
        Context r70 = ECAppInfoService.e.getApplicationContext();
        if (r70 == null) goto L233;
        CollectYataTemplateManager.b(r70);
    L233:
        return r67;
    L225:
        r68 = r67.getArguments();
        goto L226
    L202:
        r48 = false;
        goto L203
    L179:
        if (com.bytedance.android.shopping.anchorv3.a.b(r41) == true) goto L182;
        r41 = null;
    L182:
        if (r41 == null) goto L184;
        r5.a = r41;
        goto L184
    }
}
