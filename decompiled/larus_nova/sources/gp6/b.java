package gp6;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.api.CubeTimingVersion;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.config.LynxInitConfig;
import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.i.ICubeListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.CubeLynxError;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.b2;
import com.ss.android.lark.utils.statistics.PerfLog;
import fp6.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements ICubeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<? super c, Unit> f482072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f482073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f482074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f482075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f482076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f482077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f482078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f482079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f482080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f482081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f482082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f482083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f482084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f482085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f482086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f482087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f482088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f482089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, Long> f482090s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, Object> f482091t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, Object> f482092u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CubeTimingVersion f482093v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public IPoiLynxKitDelegate f482094w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f482095x;

    public static final class a {
        public static Map a(Map r110, String r111) {
            LinkedHashMap r100 = new LinkedHashMap();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L73
            LinkedHashMap r102 = new LinkedHashMap();     // Catch: Throwable -> L73
            Iterator r103 = r110.keySet().iterator();     // Catch: Throwable -> L73
        L5:
            long r104 = 0;
            if (r103.hasNext() == false) goto L38;
            String r105 = (String) r103.next();     // Catch: Throwable -> L73
            if (StringsKt.endsWith$default(r105, "_start", false, 2, null) == true) goto L9;
            if (StringsKt.endsWith$default(r105, "_end", false, 2, null) == true) goto L21;
            Map r106 = (Map) r102.get(r105);     // Catch: Throwable -> L73
            if (r106 != null) goto L34;
            r106 = new LinkedHashMap();     // Catch: Throwable -> L73
        L34:
            Number r107 = (Number) r110.get(r105);     // Catch: Throwable -> L73
            if (r107 == null) goto L37;
            r104 = r107.longValue();     // Catch: Throwable -> L73
        L37:
            r106.put(r105, Long.valueOf(r104));     // Catch: Throwable -> L73
            r102.put(r105, r106);     // Catch: Throwable -> L73
            goto L5
        L21:
            String r108 = StringsKt.replace$default(r105, "_end", "", false, 4, null);     // Catch: Throwable -> L73
            Number r109 = (Number) r110.get(r105);     // Catch: Throwable -> L73
            if (r109 == null) goto L24;
            long r112 = r109.longValue();     // Catch: Throwable -> L73
        L26:
            if (r112 <= 0) goto L5;
            Map r113 = (Map) r102.get(r108);     // Catch: Throwable -> L73
            if (r113 != null) goto L30;
            r113 = new LinkedHashMap();     // Catch: Throwable -> L73
        L30:
            r113.put("end", Long.valueOf(r112));     // Catch: Throwable -> L73
            r102.put(r108, r113);     // Catch: Throwable -> L73
            goto L5
        L24:
            r112 = 0;
            goto L26
        L9:
            String r114 = StringsKt.replace$default(r105, "_start", "", false, 4, null);     // Catch: Throwable -> L73
            Number r115 = (Number) r110.get(r105);     // Catch: Throwable -> L73
            if (r115 == null) goto L12;
            long r116 = r115.longValue();     // Catch: Throwable -> L73
        L14:
            if (r116 <= 0) goto L5;
            Map r117 = (Map) r102.get(r114);     // Catch: Throwable -> L73
            if (r117 != null) goto L18;
            r117 = new LinkedHashMap();     // Catch: Throwable -> L73
        L18:
            r117.put("start", Long.valueOf(r116));     // Catch: Throwable -> L73
            r102.put(r114, r117);     // Catch: Throwable -> L73
            goto L5
        L12:
            r116 = 0;
            goto L14
        L38:
            Iterator r118 = r102.entrySet().iterator();     // Catch: Throwable -> L73
        L40:
            if (r118.hasNext() == false) goto L71;
            Map.Entry r119 = (Map.Entry) r118.next();     // Catch: Throwable -> L73
            if (((Map) r119.getValue()).containsKey("start") == false) goto L55;
            if (((Map) r119.getValue()).containsKey("end") == false) goto L55;
            String r120 = ((String) r119.getKey()) + "_cost";     // Catch: Throwable -> L73
            if (ap6.a.b(r111) == false) goto L48;
            r120 = r111 + r120;     // Catch: Throwable -> L73
        L48:
            Object r121 = ((Map) r119.getValue()).get("end");     // Catch: Throwable -> L73
            if (r121 != null) goto L51;
            r121 = 0L;     // Catch: Throwable -> L73
        L51:
            long r122 = ((Number) r121).longValue();     // Catch: Throwable -> L73
            Object r123 = ((Map) r119.getValue()).get("start");     // Catch: Throwable -> L73
            if (r123 != null) goto L54;
            r123 = 0L;     // Catch: Throwable -> L73
        L54:
            r100.put(r120, Long.valueOf(r122 - ((Number) r123).longValue()));     // Catch: Throwable -> L73
        L55:
            Iterator r124 = ((Map) r119.getValue()).entrySet().iterator();     // Catch: Throwable -> L73
        L57:
            if (r124.hasNext() == false) goto L40;
            Map.Entry r125 = (Map.Entry) r124.next();     // Catch: Throwable -> L73
            if (Intrinsics.areEqual(r125.getKey(), "start") == true) goto L67;
            if (Intrinsics.areEqual(r125.getKey(), "end") == true) goto L67;
            String r126 = (String) r125.getKey();     // Catch: Throwable -> L73
            if (ap6.a.b(r111) == false) goto L66;
            r126 = r111 + r126;     // Catch: Throwable -> L73
        L66:
            r100.put(r126, r125.getValue());     // Catch: Throwable -> L73
        L67:
            String r127 = ((String) r119.getKey()) + '_' + ((String) r125.getKey());     // Catch: Throwable -> L73
            if (ap6.a.b(r111) == false) goto L70;
            r127 = r111 + r127;     // Catch: Throwable -> L73
        L70:
            r100.put(r127, r125.getValue());     // Catch: Throwable -> L73
            goto L57
        L71:
            Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L73
        L75:
            Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
            if (r129 == null) goto L78;
            com.bytedance.locallife.cube.d.c("extractSetupTiming error", r129);
        L78:
            return r100;
        L73:
            th = move-exception;
            Result.Companion r130 = Result.Companion;
            r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L75
        }
    }

    static {
    }

    public b() {
        this(null, 4194303);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void beforeReadTemplate() {
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void beforeUpdateProps(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalProps");
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void loadTemplateError(Throwable r100) {
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onBeforeLoadTransformLynxKitParams(LynxLoadConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxLoadConfig");
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onBeforeUpdateData(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onDataUpdated(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onFirstLoadPerfReady(CubeContext r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadSuccess(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadUriFailed(String r100, CubeContext r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "cause");
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadUriSucceed(String r100, CubeContext r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLynxViewAndJSRuntimeDestroy() {
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLynxViewClientDestroy() {
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onPageStart(String r100, CubeContext r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onPageUpdate(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onReceivedError(CubeContext r100, CubeLynxError r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onRuntimeReady(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onUpdateDataWithoutChange(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void beforeDestroy() {
        Function1<? super c, Unit> r100 = this.f482072a;
        Intrinsics.checkNotNullParameter(new LinkedHashMap(), "params");
        IPoiLynxKitDelegate r101 = this.f482094w;
        if (r101 == null) goto L323;
        CubeContext r102 = r101.getCubeContext();
        if (r102 == null) goto L323;
        LinkedHashMap r103 = new LinkedHashMap();
        j r104 = com.bytedance.locallife.cube.d.f257194a;
        com.bytedance.locallife.cube.d.d("lynxSetupTiming:" + kp6.d.b(this.f482091t));
        com.bytedance.locallife.cube.d.d("lynxUpdateTiming:" + kp6.d.b(this.f482092u));
        Map<String, Object> r105 = this.f482091t;
        Map<String, Object> r106 = this.f482092u;
        Intrinsics.checkNotNullParameter(r105, LynxTemplateRender.RENDER_PHASE_SETUP);
        Intrinsics.checkNotNullParameter(r106, "update");
        if (r105.isEmpty() == false) goto L13;
        if (r106.isEmpty() == false) goto L13;
        LinkedHashMap r107 = null;
    L43:
        Map<String, Object> r108 = this.f482092u;
        if (TypeIntrinsics.isMutableMap(r108) == true) goto L48;
        r108 = null;
    L48:
        if (r108 != null) goto L50;
    L55:
        Map r109 = null;
    L56:
        long r110 = this.f482088q;
        if (r110 > 0) goto L63;
        r110 = this.f482086o;
        if (r110 > 0) goto L63;
        r110 = this.f482085n;
    L63:
        long r111 = this.f482076e;
        if (r111 <= 0) goto L68;
        Object r112 = LynxMonitorService.KEY_SETUP_TIMING;
        long r113 = this.f482075d;
        if (r113 <= 0) goto L69;
        r103.put("open_to_create_cost", Long.valueOf(r111 - r113));
    L69:
        long r114 = this.f482078g;
        if (r114 <= 0) goto L74;
        long r115 = this.f482077f;
        if (r115 <= 0) goto L74;
        r103.put("instance_create_cost", Long.valueOf(r114 - r115));
    L74:
        long r116 = this.f482078g;
        if (r116 <= 0) goto L79;
        long r117 = this.f482080i;
        if (r117 <= 0) goto L79;
        r103.put("create_view_component_cost", Long.valueOf(r116 - r117));
    L79:
        long r118 = this.f482083l;
        if (r118 <= 0) goto L82;
        r103.put("get_to_load_cost", Long.valueOf(r118 - this.f482078g));
    L82:
        long r119 = this.f482083l;
        if (r119 <= 0) goto L87;
        long r120 = this.f482082k;
        if (r120 <= 0) goto L87;
        r103.put("init_to_start_render_cost", Long.valueOf(r120 - r119));
    L87:
        long r121 = this.f482079h;
        if (r121 <= 0) goto L92;
        long r122 = this.f482083l;
        if (r122 <= 0) goto L92;
        r103.put("load_to_prepare_template", Long.valueOf(r121 - r122));
    L92:
        long r123 = this.f482089r;
        if (r123 <= 0) goto L97;
        long r124 = this.f482083l;
        if (r124 <= 0) goto L97;
        r103.put("prepare_init_data_cost", Long.valueOf(r123 - r124));
    L97:
        long r125 = this.f482082k;
        if (r125 <= 0) goto L102;
        long r126 = this.f482079h;
        if (r126 <= 0) goto L102;
        r103.put("prepare_template_cost", Long.valueOf(r125 - r126));
    L102:
        long r127 = this.f482081j;
        if (r127 <= 0) goto L107;
        long r128 = this.f482079h;
        if (r128 <= 0) goto L107;
        r103.put("resource_load_cost", Long.valueOf(r127 - r128));
    L107:
        long r129 = this.f482081j;
        if (r129 <= 0) goto L112;
        long r130 = this.f482082k;
        if (r130 <= 0) goto L112;
        r103.put("read_template_cost", Long.valueOf(r130 - r129));
    L112:
        long r131 = this.f482085n;
        if (r131 <= 0) goto L117;
        long r132 = this.f482082k;
        if (r132 <= 0) goto L117;
        r103.put("lynx_render_cost", Long.valueOf(r131 - r132));
    L117:
        long r133 = this.f482084m;
        if (r133 <= 0) goto L122;
        long r134 = this.f482082k;
        if (r134 <= 0) goto L122;
        r103.put("render_template_main_cost", Long.valueOf(r133 - r134));
    L122:
        long r135 = this.f482095x;
        if (r135 <= 0) goto L127;
        long r136 = r110 - r135;
        if (r136 <= 0) goto L127;
        r103.put("total_fmp", Long.valueOf(r136));
    L128:
        if (r107 == null) goto L135;
        boolean r137 = true;
        if ((!r107.isEmpty()) == true) goto L133;
        r107 = null;
    L133:
        if (r107 == null) goto L136;
        r103.putAll(r107);
    L136:
        if (r109 != null) goto L138;
    L143:
        Object r138 = r103.get("open_time");
        if ((r138 instanceof Number) == false) goto L146;
        Number r139 = (Number) r138;
    L147:
        if (r139 == null) goto L149;
        Long r140 = Long.valueOf(r139.longValue());
    L150:
        if (r140 != null) goto L152;
    L153:
        r103.put("open_time", Long.valueOf(this.f482075d));
        com.bytedance.locallife.cube.d.e("====>not set open time or open time is null");
    L154:
        r103.put("bind_time", Long.valueOf(this.f482095x));
        r103.put("setup_draw_end", Long.valueOf(this.f482086o));
        r103.put("set_state_trigger", Long.valueOf(this.f482087p));
        r103.put("update_draw_end", Long.valueOf(this.f482088q));
        long r141 = this.f482088q;
        if (r141 <= 0) goto L159;
        long r142 = this.f482087p;
        if (r142 <= 0) goto L159;
        r103.put("lynx_update_cost", Long.valueOf(r141 - r142));
    L159:
        r103.put("last_draw_end", Long.valueOf(r110));
        if (r103.containsKey("total_fcp") == true) goto L167;
        long r143 = this.f482075d;
        if (r143 <= 0) goto L167;
        long r144 = this.f482086o - r143;
        if (r144 <= 0) goto L167;
        r103.put("total_fcp", Long.valueOf(r144));
    L167:
        if (r103.containsKey("total_actual_fmp") == true) goto L174;
        long r145 = this.f482075d;
        if (r145 <= 0) goto L174;
        long r146 = this.f482088q - r145;
        if (r146 <= 0) goto L174;
        r103.put("total_actual_fmp", Long.valueOf(r146));
    L174:
        if (r103.containsKey("start_schema_cost") == true) goto L179;
        long r147 = this.f482073b;
        if (r147 < 0) goto L179;
        r103.put("start_schema_cost", Long.valueOf(r147));
    L179:
        if (r103.containsKey("update_schema_cost") == true) goto L183;
        long r148 = this.f482074c;
        if (r148 < 0) goto L183;
        r103.put("update_schema_cost", Long.valueOf(r148));
    L183:
        Object r149 = this.f482091t.get(r112);
        if ((r149 instanceof Map) == false) goto L186;
        Map r150 = (Map) r149;
    L188:
        if (r150 == null) goto L201;
        Long r151 = (Long) r150.get("draw_end");
        Long r152 = (Long) r150.get("ui_operation_flush_end");
        Long r153 = (Long) r150.get("load_template_end");
        if (r151 == null) goto L201;
        r151.longValue();
        if (r152 == null) goto L195;
        if (r153 == null) goto L195;
        boolean r154 = true;
    L196:
        if (r154 == true) goto L199;
        r151 = null;
    L199:
        if (r151 == null) goto L201;
        long r155 = r151.longValue();
        Intrinsics.checkNotNull(r152);
        long r156 = r152.longValue();
        Intrinsics.checkNotNull(r153);
        Long r157 = Long.valueOf(r155 - Math.max(r156, r153.longValue()));
    L202:
        if (r157 == null) goto L240;
        long r158 = r157.longValue();
        Object r159 = r103.get("total_actual_fmp");
        if ((r159 instanceof Long) == false) goto L206;
        Long r160 = (Long) r159;
    L207:
        if (r160 == null) goto L209;
        r103.put("total_fix_actual_fmp", Long.valueOf(r160.longValue() - r158));
    L209:
        Object r161 = r103.get("total_fcp");
        if ((r161 instanceof Long) == false) goto L212;
        Long r162 = (Long) r161;
    L213:
        if (r162 == null) goto L215;
        r103.put("total_fix_fcp", Long.valueOf(r162.longValue() - r158));
    L215:
        Object r163 = r103.get("total_fmp");
        if ((r163 instanceof Long) == false) goto L218;
        Long r164 = (Long) r163;
    L219:
        if (r164 == null) goto L221;
        r103.put("total_fix_fmp", Long.valueOf(r164.longValue() - r158));
    L221:
        Object r165 = r103.get("total_tti");
        if ((r165 instanceof Long) == false) goto L224;
        Long r166 = (Long) r165;
    L225:
        if (r166 == null) goto L227;
        r103.put("total_fix_tti", Long.valueOf(r166.longValue() - r158));
    L227:
        Object r167 = r103.get("lynx_tti");
        if ((r167 instanceof Long) == false) goto L230;
        Long r168 = (Long) r167;
    L231:
        if (r168 == null) goto L233;
        r103.put("fix_lynx_tti", Long.valueOf(r168.longValue() - r158));
    L233:
        Object r169 = r103.get("lynx_fcp");
        if ((r169 instanceof Long) == false) goto L236;
        Long r170 = (Long) r169;
    L237:
        if (r170 == null) goto L239;
        r103.put("fix_lynx_fcp", Long.valueOf(r170.longValue() - r158));
    L239:
        r103.put("draw_wait_cost", Long.valueOf(r158));
        goto L240
    L236:
        r170 = null;
        goto L237
    L230:
        r168 = null;
        goto L231
    L224:
        r166 = null;
        goto L225
    L218:
        r164 = null;
        goto L219
    L212:
        r162 = null;
        goto L213
    L206:
        r160 = null;
    L240:
        LinkedHashMap r171 = new LinkedHashMap();
        LinkedHashMap r172 = new LinkedHashMap();
        IPoiLynxKitDelegate r173 = this.f482094w;
        if (r173 == null) goto L307;
        CubeContext r174 = r173.getCubeContext();
        if (r174 == null) goto L307;
        r172.put("cube_key", r174.f257176o);
        r172.put("timing_version", this.f482093v.name());
        CubeConfig r175 = r174.f257181t;
        if (r175 == null) goto L252;
        LynxLoadConfig r176 = r175.getLynxLoadConfig();
        if (r176 == null) goto L252;
        Map<String, String> r177 = r176.getMonitorContext();
        if (r177 == null) goto L252;
        String r178 = r177.get("life_biz_code");
    L253:
        r172.put("life_biz_code", r178);
        r172.put("is_preload", ap6.a.d(Boolean.valueOf(r174.f257170i)));
        List<String> r179 = r174.f257171j;
        List<String> r180 = r179;
        if (r180 != null) goto L256;
    L259:
        boolean r181 = true;
    L260:
        if (r181 == false) goto L262;
        String r182 = "[]";
    L263:
        r172.put("predecode_dc_list", r182);
        r172.put("is_precreate", ap6.a.d(Boolean.valueOf(r174.f257169h)));
        r172.put("is_predecode", ap6.a.d(Boolean.valueOf(r174.f257165d)));
        r172.put("is_precodecache", ap6.a.d(Boolean.valueOf(r174.f257166e)));
        CubeConfig r183 = r174.f257181t;
        if (r183 == null) goto L268;
        Activity r184 = r183.getActivity();
        if (r184 == null) goto L268;
        String r185 = r184.getClass().getName();
    L269:
        r172.put("activity_class", r185);
        r172.put("current_thread", ap6.a.a());
        r172.put("session_id", r174.f257177p);
        CubeConfig r186 = r174.f257181t;
        if (r186 == null) goto L274;
        LynxInitConfig r187 = r186.getLynxInitConfig();
        if (r187 == null) goto L274;
        int r188 = r187.getThreadStrategy();
    L275:
        ThreadStrategyForRendering[] r189 = ThreadStrategyForRendering.values();
        int r190 = r189.length;
        int r191 = 0;
    L276:
        if (r191 >= r190) goto L284;
        ThreadStrategyForRendering r192 = r189[r191];
        if (r192.id() != r188) goto L280;
        boolean r193 = true;
    L281:
        if (r193 == true) goto L285;
        r191 = r191 + 1;
    L285:
        if (r192 == null) goto L289;
        String r194 = r192.name();
        if (r194 == null) goto L289;
        String r195 = r194.toUpperCase();
    L290:
        r172.put("thread_strategy", r195);
        String r196 = r174.a().name();
        if (r196 == null) goto L306;
        r172.put("stage", r196.toUpperCase());
        CubeConfig r197 = r174.f257181t;
        if (r197 == null) goto L297;
        LynxLoadConfig r198 = r197.getLynxLoadConfig();
        if (r198 == null) goto L297;
        String r199 = ap6.a.d(Boolean.valueOf(r198.getReadResOnMainThread()));
    L298:
        r172.put("read_res_on_main_thread", r199);
        CubeConfig r200 = r174.f257181t;
        if (r200 == null) goto L303;
        LynxLoadConfig r201 = r200.getLynxLoadConfig();
        if (r201 == null) goto L303;
        String r202 = ap6.a.d(Boolean.valueOf(r201.getRenderTemplateOnMainThread()));
    L304:
        r172.put("render_template_on_main_thread", r202);
    L303:
        r202 = null;
    L297:
        r199 = null;
        goto L298
    L306:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L289:
        r195 = null;
        goto L290
    L280:
        r193 = false;
        goto L281
    L284:
        r192 = null;
    L274:
        LynxInitConfig.Companion.getClass();
        r188 = LynxInitConfig.access$getDEFAULT_THREAD_STRATEGY$cp().id();
    L268:
        r185 = null;
        goto L269
    L262:
        r182 = CollectionsKt.joinToString$default(r179, ",", "[", "]", 0, null, null, 56, null);
        goto L263
    L256:
        if (r180.isEmpty() == true) goto L259;
        r181 = false;
    L252:
        r178 = null;
    L307:
        r171.putAll(r172);
        ConcurrentHashMap<Class<?>, Object> r203 = LifeServiceManager.f162660a;
        ((e) LifeServiceManager.b(e.class)).a(this.f482094w, r171);
        Map<String, Long> r204 = this.f482090s;
        if ((!r204.isEmpty()) == true) goto L311;
        r204 = null;
    L311:
        if (r204 == null) goto L313;
        r103.putAll(r204);
    L313:
        String r205 = r102.f257173l;
        CubeInternalSchemaModel r206 = r102.c();
        if (r206 == null) goto L316;
        String r207 = r206.getSchema();
    L317:
        c r208 = new c(r207, r103, r171, r205, 1);
        if (r100 == null) goto L320;
        r100.invoke(r208);
        Unit r209 = Unit.INSTANCE;
    L321:
        if (r209 != null) goto L327;
        j r210 = com.bytedance.locallife.cube.d.f257194a;
        com.bytedance.locallife.cube.d.e("CubeTiming report method but not get a reporter,info:\n" + kp6.d.b(r208));
        return;
    L327:
        return;
    L320:
        r209 = null;
        goto L321
    L316:
        r207 = null;
    L195:
        r154 = false;
    L201:
        r157 = null;
        goto L202
    L186:
        r150 = null;
        goto L188
    L152:
        if (r140.longValue() > 0) goto L154;
    L149:
        r140 = null;
        goto L150
    L146:
        r139 = null;
        goto L147
    L138:
        if ((r109.isEmpty() ^ r137) == true) goto L141;
        r109 = null;
    L141:
        if (r109 == null) goto L143;
        r103.putAll(r109);
        goto L143
    L135:
        r137 = true;
    L127:
        com.bytedance.locallife.cube.d.e("firstScreenTime:" + r110 + ",bindTime:" + this.f482095x);
        goto L128
    L68:
        r112 = LynxMonitorService.KEY_SETUP_TIMING;
        goto L69
    L50:
        if ((!r108.isEmpty()) == true) goto L53;
        r108 = null;
    L53:
        if (r108 == null) goto L55;
        r109 = a.a(r108, "update_");
    L13:
        if (r106.containsKey(LynxMonitorService.KEY_SETUP_TIMING) == false) goto L15;
        Object r211 = r106.get(LynxMonitorService.KEY_SETUP_TIMING);
    L17:
        if (TypeIntrinsics.isMutableMap(r211) == false) goto L19;
        Map r212 = (Map) r211;
    L21:
        if (r106.containsKey(LynxMonitorService.KEY_EXTRA_TIMING) == false) goto L23;
        Object r213 = r106.get(LynxMonitorService.KEY_EXTRA_TIMING);
    L25:
        if (TypeIntrinsics.isMutableMap(r213) == false) goto L27;
        Map r214 = (Map) r213;
    L29:
        if (r106.containsKey("metrics") == false) goto L31;
        Object r215 = r106.get("metrics");
    L33:
        if (TypeIntrinsics.isMutableMap(r215) == false) goto L35;
        Map r216 = (Map) r215;
    L36:
        r107 = new LinkedHashMap();
        if (r212 == null) goto L39;
        r107.putAll(a.a(r212, null));
    L39:
        if (r214 == null) goto L41;
        r107.putAll(a.a(r214, null));
    L41:
        if (r216 == null) goto L43;
        r107.putAll(a.a(r216, null));
        goto L43
    L35:
        r216 = null;
        goto L36
    L31:
        r215 = r105.get("metrics");
        goto L33
    L27:
        r214 = null;
        goto L29
    L23:
        r213 = r105.get(LynxMonitorService.KEY_EXTRA_TIMING);
        goto L25
    L19:
        r212 = null;
        goto L21
    L15:
        r211 = r105.get(LynxMonitorService.KEY_SETUP_TIMING);
    L323:
        com.bytedance.locallife.cube.d.e("lynxKitDelegate is null");
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void afterRender() {
        this.f482084m = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void beforeLoadTemplate() {
        this.f482079h = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void beforeRender() {
        this.f482082k = System.currentTimeMillis();
        j r100 = com.bytedance.locallife.cube.d.f257194a;
        StringBuilder r101 = new StringBuilder("beforeRender url:");
        IPoiLynxKitDelegate r102 = this.f482094w;
        Unit r103 = null;
        if (r102 == null) goto L9;
        CubeContext r104 = r102.getCubeContext();
        if (r104 == null) goto L9;
        CubeInternalSchemaModel r105 = r104.c();
        if (r105 == null) goto L9;
        String r106 = r105.getSchema();
    L10:
        r101.append(r106);
        com.bytedance.locallife.cube.d.d(r101.toString());
        if (this.f482075d > 0) goto L15;
        long r107 = this.f482095x;
        if (r107 <= 0) goto L15;
        this.f482075d = r107;
    L15:
        IPoiLynxKitDelegate r108 = this.f482094w;
        if (r108 == null) goto L18;
        View r109 = r108.realView();
    L20:
        if ((r109 instanceof LynxView) == false) goto L22;
        LynxView r110 = (LynxView) r109;
    L23:
        if (r110 == null) goto L25;
        b2 r111 = new b2();
        r111.f381841a = this.f482075d;
        r111.f381844d = this.f482079h;
        r111.f381845e = this.f482082k;
        r111.f381842b = this.f482077f;
        r111.f381843c = this.f482078g;
        r110.setExtraTiming(r111);
        r103 = Unit.INSTANCE;
    L25:
        if (r103 != null) goto L28;
        com.bytedance.locallife.cube.d.b("beforeRender CubeTiming beforeLoadTemplate lynxview not found");
        return;
    L28:
        return;
    L22:
        r110 = null;
        goto L23
    L18:
        r109 = null;
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onInitDataEnd() {
        this.f482089r = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void loadTemplateReady(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceInfo");
        this.f482081j = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onFirstScreen(CubeContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.locallife.cube.d.a("onFirstScreen");
        this.f482085n = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLoadStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f482083l = System.currentTimeMillis();
    }

    public b(Function1 r110, int r111) {
        LinkedHashMap r100 = null;
        if ((r111 & 1) == 0) goto L5;
        r110 = null;
    L5:
        long r101 = -1;
        if ((r111 & 2) == 0) goto L8;
        long r102 = -1;
    L10:
        if ((r111 & 4) != 0) goto L14;
        r101 = 0;
    L14:
        if ((r111 & 32) == 0) goto L16;
        long r103 = System.currentTimeMillis();
    L18:
        if ((524288 & r111) == 0) goto L20;
        LinkedHashMap r104 = new LinkedHashMap();
    L22:
        if ((1048576 & r111) == 0) goto L24;
        LinkedHashMap r112 = new LinkedHashMap();
    L26:
        if ((r111 & 2097152) == 0) goto L28;
        r100 = new LinkedHashMap();
    L28:
        Intrinsics.checkNotNullParameter(r104, "extraTiming");
        Intrinsics.checkNotNullParameter(r112, "lynxSetupTiming");
        Intrinsics.checkNotNullParameter(r100, "lynxUpdateTiming");
        this.f482072a = r110;
        this.f482073b = r102;
        this.f482074c = r101;
        this.f482075d = 0;
        this.f482076e = 0;
        this.f482077f = r103;
        this.f482078g = 0;
        this.f482079h = 0;
        this.f482080i = 0;
        this.f482081j = 0;
        this.f482082k = 0;
        this.f482083l = 0;
        this.f482084m = 0;
        this.f482085n = 0;
        this.f482086o = 0;
        this.f482087p = 0;
        this.f482088q = 0;
        this.f482089r = 0;
        this.f482090s = r104;
        this.f482091t = r112;
        this.f482092u = r100;
        this.f482093v = CubeTimingVersion.V2;
        return;
    L24:
        r112 = null;
        goto L26
    L20:
        r104 = null;
        goto L22
    L16:
        r103 = 0;
        goto L18
    L8:
        r102 = 0;
        goto L10
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void beforeCreateLynxView(CubeContext r100, IPoiLynxKitDelegate r101) {
        Intrinsics.checkNotNullParameter(r100, "cubeContext");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f482080i = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onLynxKitDelegateCreated(CubeContext r100, IPoiLynxKitDelegate r101) {
        Intrinsics.checkNotNullParameter(r100, "cubeContext");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f482078g = System.currentTimeMillis();
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onTimingSetup(CubeContext r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get(LynxMonitorService.KEY_SETUP_TIMING);
    L7:
        if ((r103 instanceof Map) == false) goto L9;
        Map r104 = (Map) r103;
    L10:
        if (r104 == null) goto L12;
        Object r105 = r104.get("draw_end");
    L14:
        if ((r105 instanceof Number) == false) goto L16;
        Number r106 = (Number) r105;
    L17:
        if (r106 == null) goto L19;
        long r107 = r106.longValue();
    L20:
        this.f482086o = r107;
        if (r101 == null) goto L23;
        this.f482091t.putAll(r101);
    L23:
        j r108 = com.bytedance.locallife.cube.d.f257194a;
        StringBuilder r109 = new StringBuilder("lynxSetupTiming:");
        r109.append(kp6.d.b(this.f482091t));
        r109.append("\nurl:");
        CubeInternalSchemaModel r110 = r100.c();
        if (r110 == null) goto L26;
        r102 = r110.getSchema();
    L26:
        r109.append(r102);
        com.bytedance.locallife.cube.d.a(r109.toString());
        return;
    L19:
        r107 = 0;
        goto L20
    L16:
        r106 = null;
        goto L17
    L12:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static void a(b r100, long r101, long r110) {
        long r102 = System.currentTimeMillis();
        if (r100.f482075d > 0) goto L6;
        r100.f482075d = r101;
    L6:
        if (r100.f482073b > 0) goto L9;
        r100.f482073b = r110;
    L9:
        if (r100.f482076e > 0) goto L12;
        r100.f482076e = r102;
        return;
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void afterReadTemplate(String r100, byte[] r101, q r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "lynxFile");
        Intrinsics.checkNotNullParameter(r102, "listener");
        j r103 = com.bytedance.locallife.cube.d.f257194a;
        StringBuilder r104 = new StringBuilder("afterReadTemplate url:");
        IPoiLynxKitDelegate r105 = this.f482094w;
        if (r105 == null) goto L9;
        CubeContext r106 = r105.getCubeContext();
        if (r106 == null) goto L9;
        CubeInternalSchemaModel r107 = r106.c();
        if (r107 == null) goto L9;
        String r108 = r107.getSchema();
    L10:
        r104.append(r108);
        com.bytedance.locallife.cube.d.d(r104.toString());
        System.currentTimeMillis();
        return;
    L9:
        r108 = null;
        goto L10
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeListener
    public final void onTimingUpdate(CubeContext r100, Map<String, Object> r101, Map<String, Long> r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (StringsKt.equals("__lynx_timing_actual_fmp", r111, true) == false) goto L56;
        String r102 = null;
        if (r110 == null) goto L7;
        Long r103 = r110.get("set_state_trigger");
    L9:
        if ((r103 instanceof Number) == true) goto L12;
        r103 = null;
    L12:
        long r104 = 0;
        if (r103 == null) goto L15;
        long r105 = r103.longValue();
    L16:
        this.f482087p = r105;
        if (r110 == null) goto L19;
        Long r106 = r110.get("draw_end");
    L21:
        if ((r106 instanceof Number) == true) goto L24;
        r106 = null;
    L24:
        if (r106 == null) goto L26;
        long r107 = r106.longValue();
    L27:
        this.f482088q = r107;
        if (r110 == null) goto L30;
        this.f482092u.putAll(r110);
    L30:
        if (r101 == null) goto L33;
        this.f482091t.putAll(r101);
    L33:
        if (this.f482086o > 0) goto L51;
        if (r101 == null) goto L36;
        Object r108 = r101.get(LynxMonitorService.KEY_SETUP_TIMING);
    L38:
        if ((r108 instanceof Map) == false) goto L40;
        Map r109 = (Map) r108;
    L41:
        if (r109 == null) goto L43;
        Object r112 = r109.get("draw_end");
    L45:
        if ((r112 instanceof Number) == false) goto L47;
        Number r113 = (Number) r112;
    L48:
        if (r113 == null) goto L50;
        r104 = r113.longValue();
    L50:
        this.f482086o = r104;
        goto L51
    L47:
        r113 = null;
        goto L48
    L43:
        r112 = null;
        goto L45
    L40:
        r109 = null;
        goto L41
    L36:
        r108 = null;
    L51:
        j r114 = com.bytedance.locallife.cube.d.f257194a;
        StringBuilder r115 = new StringBuilder("onTimingUpdate url:");
        CubeInternalSchemaModel r116 = r100.c();
        if (r116 == null) goto L54;
        r102 = r116.getSchema();
    L54:
        r115.append(r102);
        com.bytedance.locallife.cube.d.a(r115.toString());
        com.bytedance.locallife.cube.d.a("onTimingUpdate,flag:" + r111 + ",timingInfo:" + kp6.d.b(r101) + ",updateTiming:" + kp6.d.b(r110));
        return;
    L26:
        r107 = 0;
        goto L27
    L19:
        r106 = null;
        goto L21
    L15:
        r105 = 0;
        goto L16
    L7:
        r103 = null;
        goto L9
    }
}
