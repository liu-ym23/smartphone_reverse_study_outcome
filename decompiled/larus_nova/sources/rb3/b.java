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
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes13.dex */
public final class b implements g {
    public b() {
        Map<String, Boolean> r100 = bf.a.f18801a;
        ECFavoriteRouter r101 = new ECFavoriteRouter();
        Intrinsics.checkNotNullParameter(r101, "interceptor");
        ((ArrayList) bf.a.f18803c).add(r101);
    }

    @Override // sc3.g
    public final Fragment a(Context r210, Map<String, String> r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "params");
        int r100 = c.f536903j;
        c r101 = new c(UUID.randomUUID().toString());
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "params");
        ECSettingKeys.f43625j.getClass();
        if (ECSettingKeys.g().contains(ShareChannel.COLLECT) == false) goto L176;
        Intrinsics.checkNotNullParameter(r211, "params");
        LinkedHashMap r102 = new LinkedHashMap();
        Boolean r103 = Boolean.FALSE;
        r102.put("need_check_login", r103);
        r102.put("opt_preload_layout", Boolean.TRUE);
        r102.put("need_cache_manager", r103);
        r102.put("biz_type", Integer.valueOf(LauncherBizType.COLLECT.ordinal()));
        r102.put("query_data_in_starter", r103);
        r102.put("page_name", "collect_list_page");
        r102.put("standard_show_event_name", "collect_module_show");
        r102.put("standard_click_event_name", "collect_module_click");
        int r104 = n.f45241a;
        Object r110 = 3;
        int r105 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L159
        Object r107 = d.f42818c.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L55
        if (r107 != null) goto L10;
    L52:
        Object r111 = null;
    L53:
        Object r108 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L55
    L57:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L159
        if (r112 == null) goto L61;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L159
    L61:
        if (Result.m9455isFailureimpl(r108) == false) goto L64;
        r108 = null;
    L64:
        if ((r108 instanceof Integer) == true) goto L66;
        r108 = null;
    L66:
        Object r109 = (Integer) r108;     // Catch: Throwable -> L159
        if (r109 != null) goto L73;
        Object r113 = d.f42816a.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L159
        if ((r113 instanceof Integer) == true) goto L72;
        r113 = null;
    L72:
        r109 = (Integer) r113;     // Catch: Throwable -> L159
    L73:
        if (r109 != null) goto L168;
        int r114 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L159
        Object r115 = d.f42818c.get("ec_cart_gul_preload_threshold");     // Catch: Throwable -> L125
        if (r115 != null) goto L80;
    L122:
        Object r116 = null;
    L123:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L125
    L127:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L150
        if (r118 == null) goto L131;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L150
    L131:
        if (Result.m9455isFailureimpl(r117) == false) goto L134;
        r117 = null;
    L134:
        if ((r117 instanceof Integer) == true) goto L136;
        r117 = null;
    L136:
        r109 = (Integer) r117;     // Catch: Throwable -> L150
        if (r109 != null) goto L157;
        IHybridHostService r119 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r119 == null) goto L142;
        Object r120 = r119.getHostABValue("ec_cart_gul_preload_threshold", r110);     // Catch: Throwable -> L150
    L143:
        if (r120 != null) goto L145;
    L156:
        r109 = r110;
        goto L157
    L145:
        if ((r120 instanceof Integer) == true) goto L147;
        r120 = null;
    L147:
        r109 = (Integer) r120;     // Catch: Throwable -> L150
        if (r109 != null) goto L157;
    L150:
        th = move-exception;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L159
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
        Throwable r122 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L159
        if (r122 == null) goto L155;
        EnsureManager.ensureNotReachHere(r122);     // Catch: Throwable -> L159
    L155:
        if (Result.m9455isFailureimpl(r109) == false) goto L157;
    L142:
        r120 = null;
    L157:
        d.d("ec_cart_gul_preload_threshold", r109);     // Catch: Throwable -> L159
        goto L168
    L80:
        if ((r115 instanceof Integer) == true) goto L82;
        Object r123 = null;
    L83:
        r116 = (Integer) r123;     // Catch: Throwable -> L125
        if (r116 != null) goto L123;
        if ((r115 instanceof Number) == false) goto L110;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L95;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L125
        if ((r124 instanceof Integer) == true) goto L93;
        r124 = null;
    L93:
        r116 = (Integer) r124;     // Catch: Throwable -> L125
        goto L123
    L95:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L101;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L125
        if ((r125 instanceof Integer) == true) goto L99;
        r125 = null;
    L99:
        r116 = (Integer) r125;     // Catch: Throwable -> L125
        goto L123
    L101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L104;
        r116 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L125
        goto L123
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L110;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L125
        if ((r126 instanceof Integer) == true) goto L108;
        r126 = null;
    L108:
        r116 = (Integer) r126;     // Catch: Throwable -> L125
    L110:
        if ((r115 instanceof JSONObject) == false) goto L112;
    L240:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L118
        Object r127 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Integer.class);     // Catch: Throwable -> L118
        if ((r127 instanceof Integer) == true) goto L116;
        r127 = null;
    L116:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L118
    L120:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L123;
    L118:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L125
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L125
        goto L120
    L112:
        if ((r115 instanceof JSONArray) == false) goto L122;
    L82:
        r123 = r115;
    L125:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L150
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L168:
        ((Number) r109).intValue();
        r102.put("gul_preload_threshold", 4);
        LinkedHashMap r131 = (LinkedHashMap) r211;
        r102.put("need_load_gul", Boolean.valueOf(Intrinsics.areEqual((String) r131.get("is_from_personal"), "0")));
        r102.put("need_set_gradient_view", Boolean.valueOf(Intrinsics.areEqual((String) r131.get("is_from_personal"), "1")));
        r102.put("need_pull_refresh", Boolean.FALSE);
        int r132 = CollectListLauncher.f172108c;
        CollectListLauncher.Companion.a();
        int r133 = ECSdk.f48106a;
        IEShoppingService r134 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r134 == null) goto L173;
        sc3.d r135 = r134.getCardKitService();
        if (r135 == null) goto L173;
        CardListFragment r136 = r135.a(r210, r102, r211);
    L174:
        if (r136 == null) goto L176;
        return r136;
    L173:
        r136 = null;
        goto L174
    L10:
        if ((r107 instanceof Integer) == true) goto L12;
        Object r137 = null;
    L13:
        r111 = (Integer) r137;     // Catch: Throwable -> L55
        if (r111 != null) goto L53;
        if ((r107 instanceof Number) == false) goto L40;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r138 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L55
        if ((r138 instanceof Integer) == true) goto L23;
        r138 = null;
    L23:
        r111 = (Integer) r138;     // Catch: Throwable -> L55
        goto L53
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r139 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L55
        if ((r139 instanceof Integer) == true) goto L29;
        r139 = null;
    L29:
        r111 = (Integer) r139;     // Catch: Throwable -> L55
        goto L53
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L34;
        r111 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L55
        goto L53
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L40;
        Long r140 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L55
        if ((r140 instanceof Integer) == true) goto L38;
        r140 = null;
    L38:
        r111 = (Integer) r140;     // Catch: Throwable -> L55
    L40:
        if ((r107 instanceof JSONObject) == false) goto L42;
    L238:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L48
        Object r141 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L48
        if ((r141 instanceof Integer) == true) goto L46;
        r141 = null;
    L46:
        Object r142 = Result.m9449constructorimpl((Integer) r141);     // Catch: Throwable -> L48
    L50:
        r111 = r142;
        if (Result.m9455isFailureimpl(r111) == false) goto L53;
    L48:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L55
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
        goto L50
    L42:
        if ((r107 instanceof JSONArray) == false) goto L52;
    L12:
        r137 = r107;
    L55:
        th = move-exception;
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L159
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L159:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        Object r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r147 = Result.m9452exceptionOrNullimpl(r146);
        if (r147 == null) goto L164;
        EnsureManager.ensureNotReachHere(r147);
    L164:
        if (Result.m9455isFailureimpl(r146) == true) goto L167;
        r110 = r146;
    L167:
        r109 = r110;
    L176:
        LinkedHashMap r148 = (LinkedHashMap) r211;
        String r149 = (String) r148.get("sec_uid");
        if (r149 != null) goto L179;
    L184:
        String r150 = (String) r148.get("uid");
        if (r150 == null) goto L189;
        String r151 = a2.d(r150);
        if (r151 == null) goto L189;
        r101.f536905b = r151;
    L189:
        String r152 = (String) r148.get("ecom_scene_id");
        if (r152 == null) goto L194;
        String r153 = a2.d(r152);
        if (r153 == null) goto L194;
        r101.f536906c = r153;
    L194:
        String r154 = (String) r148.get("previous_page");
        if (r154 == null) goto L200;
        String r155 = a2.d(r154);
        if (r155 == null) goto L200;
        r101.f536908e = r155;
    L200:
        if (r101.f536908e.length() != 0) goto L202;
        boolean r156 = true;
    L203:
        if (r156 == false) goto L205;
        r101.f536908e = com.bytedance.android.ec.core.event.a.VALUE_PERSONAL_HOMEPAGE;
    L205:
        String r157 = (String) r148.get("uid");
        if (r157 == null) goto L210;
        String r158 = a2.d(r157);
        if (r158 == null) goto L210;
        r101.f536909f = r158;
    L210:
        r101.f536910g = Intrinsics.areEqual((String) r148.get("is_from_personal"), "1");
        String r159 = (String) r148.get("collect_experiment_value");
        if (r159 == null) goto L215;
        String r160 = a2.d(r159);
        if (r160 == null) goto L215;
        r101.f536911h = CastIntegerProtector.parseInt(r160);
    L215:
        CollectParams r161 = new CollectParams(r101.f536904a, r101.f536905b, r101.f536909f, r101.f536906c, r101.f536907d, r101.f536908e, r101.f536910g, r101.f536912i, r101.f536911h);
        Map<String, pb3.a> r162 = pb3.a.f528424h;
        Intrinsics.checkNotNullParameter(r161, "collectParam");
        pb3.a r163 = new pb3.a(r161);
        String r164 = UUID.randomUUID().toString();
        pb3.a.f528424h.put(r164, r163);
        r161.setMonitorId(r164);
        JSONObject r165 = new JSONObject();
        r165.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r165.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r165.put("page_name", "collect_list_page");
        r165.put("previous_page", r161.getPreviousPage());
        String r166 = r161.getSession_id();
        String r167 = "";
        if (r166 != null) goto L218;
        r166 = "";
    L218:
        r165.put("session_id", r166);
        CollectYataFirstScreenDurationMonitor r168 = new CollectYataFirstScreenDurationMonitor(r161.getMonitorId(), x0.a(r165));
        r163.f528426b = r168;
        CollectYataFirstScreenDurationMonitor.a(r168, CollectYataFirstScreenPoint.START);
        Map<String, com.bytedance.android.shopping.collect.monitor.error.a> r169 = com.bytedance.android.shopping.collect.monitor.error.a.f172238b;
        String r170 = r161.getMonitorId();
        if (r170 == null) goto L222;
        r167 = r170;
    L222:
        JSONObject r171 = x0.a(r165);
        Intrinsics.checkNotNullParameter(r167, "id");
        Intrinsics.checkNotNullParameter(r171, "baseParams");
        com.bytedance.android.shopping.collect.monitor.error.a r172 = new com.bytedance.android.shopping.collect.monitor.error.a(r171);
        com.bytedance.android.shopping.collect.monitor.error.a.f172238b.put(r167, r172);
        r163.f528427c = r172;
        r163.f528428d = new CollectYataFpsMonitor(r161, x0.a(r165));
        Map<String, com.bytedance.android.ec.core.monitor.a> r173 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.b(MonitorScenes.EC_PERF_PAGE_START_COLLECT, null, r163.a());
        int r174 = CollectYataFragment.f172128t;
        Intrinsics.checkNotNullParameter(r161, "collectParams");
        CollectYataFragment r175 = new CollectYataFragment();
        if (r175.getArguments() != null) goto L225;
        Bundle r176 = new Bundle();
    L226:
        r175.setArguments(r176);
        Bundle r177 = r175.getArguments();
        if (r177 == null) goto L229;
        r177.putSerializable("collect_params", r161);
    L229:
        Context r178 = ECAppInfoService.f48114e.getApplicationContext();
        if (r178 == null) goto L233;
        CollectYataTemplateManager.b(r178);
    L233:
        return r175;
    L225:
        r176 = r175.getArguments();
        goto L226
    L202:
        r156 = false;
        goto L203
    L179:
        if (com.bytedance.android.shopping.anchorv3.a.b(r149) == true) goto L182;
        r149 = null;
    L182:
        if (r149 == null) goto L184;
        r101.f536904a = r149;
        goto L184
    }
}
