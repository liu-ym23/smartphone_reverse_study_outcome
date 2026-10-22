package kp6;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.locallife.biz.base.cube.l;
import com.bytedance.locallife.biz.base.cube.p;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.CubeInitConfig;
import com.bytedance.locallife.cube.api.config.LynxInitConfig;
import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.i.ICubeCustomizeInterceptor;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.mob.PoiLynxKitMonitor;
import com.bytedance.locallife.cube.mob.PoiLynxKitReportInfo;
import com.bytedance.locallife.cube.model.CubeSchemaData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.lynx.canvas.LynxGroupKryptonConfigs;
import fp6.j;
import fp6.k;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y36.s;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f505514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<ICubeCustomizeInterceptor> f505515b = null;

    public c() {
    }

    static {
        f505514a = new c();
        f505515b = new CopyOnWriteArrayList();
    }

    public static String b(String r110) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == false) goto L49;
        return null;
    L49:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L38
        Uri r104 = UriProtector.parse(r110);     // Catch: Throwable -> L38
        String r105 = UriProtector.getQueryParameter(r104, "prefetch_lynx_version");     // Catch: Throwable -> L38
        if (r105 == null) goto L15;
        Long r106 = StringsKt.toLongOrNull(r105);     // Catch: Throwable -> L38
    L16:
        String r107 = UriProtector.getQueryParameter(r104, "channel");     // Catch: Throwable -> L38
        long r108 = -1;
        if (r106 != null) goto L20;
    L22:
        if (r106 == null) goto L35;
        if (r107 != null) goto L25;
    L28:
        if (r100 == true) goto L35;
        k r109 = com.bytedance.locallife.cube.c.e();     // Catch: Throwable -> L38
        if (r109 == null) goto L33;
        r108 = ((l) r109).b(r107);     // Catch: Throwable -> L38
    L33:
        if (r108 < r106.longValue()) goto L35;
        String r111 = r110;
    L36:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L38
    L40:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L44;
        j r114 = com.bytedance.locallife.cube.d.f257194a;
        com.bytedance.locallife.cube.d.c("checkSchema failed lynxSchema:" + r110, r113);
    L44:
        if (Result.m9455isFailureimpl(r112) == true) goto L48;
        r102 = r112;
    L48:
        return (String) r102;
    L25:
        if (r107.length() == 0) goto L28;
        r100 = false;
    L35:
        r111 = null;
        goto L36
    L20:
        if (r106.longValue() != (-1)) goto L22;
        return r110;
    L15:
        r106 = null;
    L38:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String c(String r100) {
        boolean r101 = false;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        if (r100 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return null;
    L12:
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L21
        String r105 = UriProtector.getQueryParameter(r104, "bid");     // Catch: Throwable -> L21
        if (r105 != null) goto L15;
        r105 = "default_bid";
    L15:
        Lazy<SchemaService> r106 = SchemaService.f248116f;     // Catch: Throwable -> L21
        Uri r107 = (Uri) new s(SchemaService.a.a().b(r105, r104), "url").f565862b;     // Catch: Throwable -> L21
        if (r107 == null) goto L19;
        r104 = r107;
    L19:
        return new a36.a(r104).b();
    L6:
        if (StringsKt.isBlank(r100) == true) goto L9;
        r103 = false;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Throwable r109 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r109 == null) goto L32;
        com.bytedance.locallife.cube.c.f();
        if (p.f256548a.e() != true) goto L27;
        r101 = true;
    L27:
        if (r101 == true) goto L30;
        com.bytedance.locallife.cube.c.d().getApmService();
        com.bytedance.locallife.biz.base.cube.b.f256532a.a(r109);
        return null;
    L30:
        throw r109;
    L32:
        throw new KotlinNothingValueException();
    }

    public static Float f(CubeConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeConfig");
        Iterator<ICubeCustomizeInterceptor> r101 = f505515b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Float r102 = r101.next().getFontScale(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    public static String g(CubeInternalSchemaModel r100) {
        Object r101 = null;
        if (r100 != null) goto L33;
        return null;
    L33:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        Uri r103 = r100.schemaUri;     // Catch: Throwable -> L22
        String r104 = UriProtector.getQueryParameter(r103, "cache_key");     // Catch: Throwable -> L22
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r104) == false) goto L8;
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L22
    L24:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L28;
        j r107 = com.bytedance.locallife.cube.d.f257194a;
        com.bytedance.locallife.cube.d.c("getLynxSchemaKeyInfo failed lynxSchema:" + r100.schemaUri, r106);
    L28:
        if (Result.m9455isFailureimpl(r105) == true) goto L32;
        r101 = r105;
    L32:
        return (String) r101;
    L8:
        String r108 = r100.getLynxBundle();     // Catch: Throwable -> L22
        String r109 = r100.getLynxChannel();     // Catch: Throwable -> L22
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r108) == true) goto L11;
    L13:
        String r110 = r100.getSchema();     // Catch: Throwable -> L22
    L14:
        Iterator<ICubeCustomizeInterceptor> r111 = f505515b.iterator();     // Catch: Throwable -> L22
    L16:
        if (r111.hasNext() == false) goto L21;
        String r112 = r111.next().appendCacheUniqueKey(r100, r103);     // Catch: Throwable -> L22
        if (r112 == null) goto L16;
        r110 = r110 + r112;     // Catch: Throwable -> L22
        goto L16
    L21:
        return r110;
    L11:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r109) == false) goto L13;
        r110 = r108 + '|' + r109;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public static String h(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L23;
        return null;
    L23:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        return g(new CubeInternalSchemaModel(UriProtector.parse(r100), r100, 0));
    L13:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Object r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        com.bytedance.locallife.cube.d.c("getLynxSchemaKeyInfo failed", r106);
    L18:
        if (Result.m9455isFailureimpl(r105) == true) goto L22;
        r102 = r105;
    L22:
        return (String) r102;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static boolean k(CubeSchemaData r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        String r101 = r100.getEnterFrom();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        return false;
    L14:
        String r103 = r100.getScene();
        if (r103 != null) goto L17;
    L20:
        boolean r104 = true;
    L21:
        if (r104 == true) goto L24;
        return false;
    L24:
        if (r100.getRenderTemplateInMain() == null) goto L27;
        return false;
    L27:
        if (r100.getReadResInMain() == null) goto L29;
        return false;
    L29:
        String r105 = r100.getGroup();
        if (r105 != null) goto L32;
    L35:
        boolean r106 = true;
    L36:
        if (r106 == true) goto L39;
        return false;
    L39:
        if (r100.getDisableJsCtxShare() == null) goto L42;
        return false;
    L42:
        if (r100.getEnableCanvas() == null) goto L45;
        return false;
    L45:
        if (r100.getEnableCanvasOptimize() == null) goto L48;
        return false;
    L48:
        if (r100.getEnableDynamicV8() == null) goto L51;
        return false;
    L51:
        if (r100.getLynxPresetWidth() == null) goto L54;
        return false;
    L54:
        if (r100.getLynxPresetHeight() == null) goto L57;
        return false;
    L57:
        if (r100.getLynxPresetWidthSpecMode() == null) goto L60;
        return false;
    L60:
        if (r100.getLynxPresetHeightSpecMode() == null) goto L63;
        return false;
    L63:
        if (r100.getPresetSafePoint() == null) goto L66;
        return false;
    L66:
        if (r100.getThreadStrategy() == null) goto L69;
        return false;
    L69:
        if (r100.getEnableVsyncAlignedMessageLoop() == null) goto L72;
        return false;
    L72:
        if (r100.getEnablePreFetchImage() == null) goto L75;
        return false;
    L75:
        if (r100.getEnableFontScale() == null) goto L78;
        return false;
    L78:
        if (r100.getEnableJsGroupThread() == null) goto L81;
        return false;
    L81:
        if (r100.getEnablePendingJsTask() == null) goto L83;
        return false;
    L83:
        return true;
    L32:
        if (StringsKt.isBlank(r105) == true) goto L35;
        r106 = false;
        goto L36
    L17:
        if (StringsKt.isBlank(r103) == true) goto L20;
        r104 = false;
        goto L21
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r102 = false;
        goto L12
    }

    public static CubeSchemaData m(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L11;
        return null;
    L11:
        Uri r103 = UriProtector.parse(r100);
        CubeSchemaData r104 = new CubeSchemaData();
        r104.setOriginUrl(r100);
        long r105 = SystemClock.elapsedRealtime();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        Object r107 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enter_from"));     // Catch: Throwable -> L14
    L16:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enter_from failure", r108);
    L20:
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        r107 = null;
    L22:
        r104.setEnterFrom((String) r107);
        Object r109 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "scene"));     // Catch: Throwable -> L25
    L27:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L31;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter scene failure", r110);
    L31:
        if (Result.m9455isFailureimpl(r109) == false) goto L33;
        r109 = null;
    L33:
        r104.setScene((String) r109);
        Object r111 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "render_temp_in_main"));     // Catch: Throwable -> L36
    L38:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L42;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter render_temp_in_main failure", r112);
    L42:
        if (Result.m9455isFailureimpl(r111) == false) goto L44;
        r111 = null;
    L44:
        r104.setRenderTemplateInMain(ap6.a.c((String) r111));
        Object r113 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "read_res_info_in_main"));     // Catch: Throwable -> L47
    L49:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L53;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter read_res_info_in_main failure", r114);
    L53:
        if (Result.m9455isFailureimpl(r113) == false) goto L55;
        r113 = null;
    L55:
        r104.setReadResInMain(ap6.a.c((String) r113));
        Object r115 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS));     // Catch: Throwable -> L58
    L60:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L64;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_canvas failure", r116);
    L64:
        if (Result.m9455isFailureimpl(r115) == false) goto L66;
        r115 = null;
    L66:
        r104.setEnableCanvas(ap6.a.c((String) r115));
        Object r117 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enable_canvas_optimize"));     // Catch: Throwable -> L69
    L71:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L75;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_canvas_optimize failure", r118);
    L75:
        if (Result.m9455isFailureimpl(r117) == false) goto L77;
        r117 = null;
    L77:
        r104.setEnableCanvasOptimize(ap6.a.c((String) r117));
        Object r119 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enable_dynamic_v8"));     // Catch: Throwable -> L80
    L82:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L86;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_dynamic_v8 failure", r120);
    L86:
        if (Result.m9455isFailureimpl(r119) == false) goto L88;
        r119 = null;
    L88:
        r104.setEnableDynamicV8(ap6.a.c((String) r119));
        Object r121 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "lynx_preset_width_mode"));     // Catch: Throwable -> L91
    L93:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L97;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter lynx_preset_width_mode failure", r122);
    L97:
        if (Result.m9455isFailureimpl(r121) == false) goto L99;
        r121 = null;
    L99:
        String r123 = (String) r121;
        if (r123 == null) goto L102;
        Integer r124 = StringsKt.toIntOrNull(r123);
    L103:
        r104.setLynxPresetWidthSpecMode(r124);
        Object r125 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "lynx_preset_width"));     // Catch: Throwable -> L106
    L108:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L112;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter lynx_preset_width failure", r126);
    L112:
        if (Result.m9455isFailureimpl(r125) == false) goto L114;
        r125 = null;
    L114:
        String r127 = (String) r125;
        if (r127 == null) goto L117;
        Integer r128 = StringsKt.toIntOrNull(r127);
    L118:
        r104.setLynxPresetWidth(r128);
        Object r129 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "lynx_preset_height_mode"));     // Catch: Throwable -> L121
    L123:
        Throwable r130 = Result.m9452exceptionOrNullimpl(r129);
        if (r130 == null) goto L127;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter lynx_preset_height_mode failure", r130);
    L127:
        if (Result.m9455isFailureimpl(r129) == false) goto L129;
        r129 = null;
    L129:
        String r131 = (String) r129;
        if (r131 == null) goto L132;
        Integer r132 = StringsKt.toIntOrNull(r131);
    L133:
        r104.setLynxPresetHeightSpecMode(r132);
        Object r133 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "lynx_preset_height"));     // Catch: Throwable -> L136
    L138:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L142;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter lynx_preset_height failure", r134);
    L142:
        if (Result.m9455isFailureimpl(r133) == false) goto L144;
        r133 = null;
    L144:
        String r135 = (String) r133;
        if (r135 == null) goto L147;
        Integer r136 = StringsKt.toIntOrNull(r135);
    L148:
        r104.setLynxPresetHeight(r136);
        Object r137 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "preset_safe_point"));     // Catch: Throwable -> L151
    L153:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L157;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter preset_safe_point failure", r138);
    L157:
        if (Result.m9455isFailureimpl(r137) == false) goto L159;
        r137 = null;
    L159:
        r104.setPresetSafePoint(ap6.a.c((String) r137));
        Object r139 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "thread_strategy"));     // Catch: Throwable -> L162
    L164:
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 == null) goto L168;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter thread_strategy failure", r140);
    L168:
        if (Result.m9455isFailureimpl(r139) == false) goto L170;
        r139 = null;
    L170:
        String r141 = (String) r139;
        if (r141 == null) goto L173;
        Integer r142 = StringsKt.toIntOrNull(r141);
    L174:
        r104.setThreadStrategy(r142);
    L181:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Object r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L183:
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L187;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter group failure", r145);
    L187:
        if (Result.m9455isFailureimpl(r144) == false) goto L189;
        r144 = null;
    L189:
        r104.setGroup((String) r144);
        Object r146 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "disable_js_ctx_share"));     // Catch: Throwable -> L192
    L194:
        Throwable r147 = Result.m9452exceptionOrNullimpl(r146);
        if (r147 == null) goto L198;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter disable_js_ctx_share failure", r147);
    L198:
        if (Result.m9455isFailureimpl(r146) == false) goto L200;
        r146 = null;
    L200:
        r104.setDisableJsCtxShare(ap6.a.c((String) r146));
        Object r148 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enable_vsync_aligned_message_loop"));     // Catch: Throwable -> L203
    L205:
        Throwable r149 = Result.m9452exceptionOrNullimpl(r148);
        if (r149 == null) goto L209;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_vsync_aligned_message_loop failure", r149);
    L209:
        if (Result.m9455isFailureimpl(r148) == false) goto L211;
        r148 = null;
    L211:
        r104.setEnableVsyncAlignedMessageLoop(ap6.a.c((String) r148));
        Object r150 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enable_prefetch_image"));     // Catch: Throwable -> L214
    L216:
        Throwable r151 = Result.m9452exceptionOrNullimpl(r150);
        if (r151 == null) goto L220;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_prefetch_image failure", r151);
    L220:
        if (Result.m9455isFailureimpl(r150) == false) goto L222;
        r150 = null;
    L222:
        r104.setEnablePreFetchImage(ap6.a.c((String) r150));
        String r152 = UriProtector.getQueryParameter(r103, "enable_font_scale");     // Catch: Throwable -> L229
        if (r152 == null) goto L226;
        Boolean r153 = y36.a.e(r152);     // Catch: Throwable -> L229
    L227:
        Object r154 = Result.m9449constructorimpl(r153);     // Catch: Throwable -> L229
    L231:
        Throwable r155 = Result.m9452exceptionOrNullimpl(r154);
        if (r155 == null) goto L235;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_font_scale failure", r155);
    L235:
        if (Result.m9455isFailureimpl(r154) == false) goto L237;
        r154 = null;
    L237:
        r104.setEnableFontScale((Boolean) r154);
        Object r156 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enable_js_group_thread"));     // Catch: Throwable -> L240
    L242:
        Throwable r157 = Result.m9452exceptionOrNullimpl(r156);
        if (r157 == null) goto L246;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_js_group_thread failure", r157);
    L246:
        if (Result.m9455isFailureimpl(r156) == false) goto L248;
        r156 = null;
    L248:
        r104.setEnableJsGroupThread(ap6.a.c((String) r156));
        Object r158 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r103, "enable_pending_js_task"));     // Catch: Throwable -> L251
    L253:
        Throwable r159 = Result.m9452exceptionOrNullimpl(r158);
        if (r159 == null) goto L257;
        com.bytedance.locallife.cube.d.c("parseSchemaData get parameter enable_pending_js_task failure", r159);
    L257:
        if (Result.m9455isFailureimpl(r158) == true) goto L260;
        r102 = r158;
    L260:
        r104.setEnablePendingJsTask(ap6.a.c((String) r102));
        r104.setParseDuration(SystemClock.elapsedRealtime() - r105);
        return r104;
    L251:
        th = move-exception;
        Result.Companion r160 = Result.Companion;
        r158 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L240:
        th = move-exception;
        Result.Companion r161 = Result.Companion;
        r156 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L242
    L226:
        r153 = null;
    L229:
        th = move-exception;
        Result.Companion r162 = Result.Companion;
        r154 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L214:
        th = move-exception;
        Result.Companion r163 = Result.Companion;
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L203:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        r148 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L192:
        th = move-exception;
        Result.Companion r165 = Result.Companion;
        r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L194
    L176:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r103, "enable_multi_js_group"), "1") == false) goto L178;
        String r166 = UriProtector.getQueryParameter(r103, "channel") + UriProtector.getQueryParameter(r103, "bundle");     // Catch: Throwable -> L181
    L179:
        r144 = Result.m9449constructorimpl(r166);     // Catch: Throwable -> L181
        goto L183
    L178:
        r166 = UriProtector.getQueryParameter(r103, "group");     // Catch: Throwable -> L181
        goto L179
    L173:
        r142 = null;
    L162:
        th = move-exception;
        Result.Companion r167 = Result.Companion;
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L151:
        th = move-exception;
        Result.Companion r168 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L153
    L147:
        r136 = null;
    L136:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L138
    L132:
        r132 = null;
    L121:
        th = move-exception;
        Result.Companion r170 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L123
    L117:
        r128 = null;
    L106:
        th = move-exception;
        Result.Companion r171 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L108
    L102:
        r124 = null;
    L91:
        th = move-exception;
        Result.Companion r172 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L80:
        th = move-exception;
        Result.Companion r173 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L69:
        th = move-exception;
        Result.Companion r174 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L58:
        th = move-exception;
        Result.Companion r175 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L47:
        th = move-exception;
        Result.Companion r176 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L36:
        th = move-exception;
        Result.Companion r177 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        th = move-exception;
        Result.Companion r178 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r179 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static Integer n(int r100) {
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L13;
        return null;
    L13:
        return Integer.MIN_VALUE;
    L14:
        return 1073741824;
    L11:
        return 0;
    }

    public static CubeInternalSchemaModel a(CubeInternalSchemaModel r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CU_KEY_OPERATOR);
        String r102 = (String) r101.invoke(r100.getSchema());
        if (Intrinsics.areEqual(r102, r100.getSchema()) == false) goto L6;
        return r100;
    L6:
        return new CubeInternalSchemaModel(UriProtector.parse(r102), r100.originSchema, r100.schemaCost);
    }

    public static CubeInternalSchemaModel d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Uri r102 = UriProtector.parse(r100);
        Iterator<ICubeCustomizeInterceptor> r103 = f505515b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102 = r103.next().interceptSchema(r102);
        goto L4
    L6:
        j r104 = com.bytedance.locallife.cube.d.f257194a;
        com.bytedance.locallife.cube.d.a("schema:" + r100 + ",newSchemaUri:" + r102);
        return new CubeInternalSchemaModel(r102, r100, System.currentTimeMillis() - r101);
    }

    public static /* synthetic */ CubeInternalSchemaModel e(c r100, String r101) {
        long r102 = System.currentTimeMillis();
        r100.getClass();
        return d(r101, r102);
    }

    public static String i(String r100, boolean r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L22;
        return "";
    L22:
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r100), "surl");     // Catch: Exception -> L19
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r103) == false) goto L23;
        Uri r104 = UriProtector.parse(r103);     // Catch: Exception -> L19
        if (r101 == false) goto L17;
        String r105 = a36.b.d(r104);     // Catch: Exception -> L19
    L24:
        return r105;
    L17:
        r105 = String.valueOf(r103);     // Catch: Exception -> L19
        goto L24
    L23:
        return "";
    L19:
        e = move-exception;
        j r106 = com.bytedance.locallife.cube.d.f257194a;
        com.bytedance.locallife.cube.d.c("getLynxSurl failed lynxSchema:" + r100, e);
        return "";
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r102 = false;
        goto L9
    }

    public static JSONObject j(CubeInternalSchemaModel r100, CubeConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        JSONObject r102 = new JSONObject();
        Uri r103 = r100.schemaUri;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Set<String> r105 = UriProtector.getQueryParameterNames(r103);     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L17
    L7:
        if (r106.hasNext() == false) goto L13;
        String r107 = (String) r106.next();     // Catch: Throwable -> L17
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L11
        Result.m9449constructorimpl(r102.put(r107, UriProtector.getQueryParameter(r103, r107)));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L17
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L7
    L13:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L17
    L19:
        if (r101 != null) goto L34;
    L31:
        return r102;
    L34:
        f505514a.getClass();     // Catch: Throwable -> L29
        Float r111 = f(r101);     // Catch: Throwable -> L29
        if (r111 == null) goto L23;
    L25:
        if (r111 == null) goto L27;
        r102.put("font_scale", r111.toString());     // Catch: Throwable -> L29
    L27:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        goto L31
    L23:
        if (Intrinsics.areEqual(r101.getLynxInitConfig().getFontScaleEnable(), Boolean.FALSE) == true) goto L25;
        r111 = r101.getLynxInitConfig().getFontScale();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L14:
        r110 = null;
    L17:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static CubeConfig l(CubeSchemaData r310, CubeConfig r311) {
        Intrinsics.checkNotNullParameter(r311, "old");
        if (r310 != null) goto L6;
        return r311;
    L6:
        if (k(r310) == false) goto L8;
        return r311;
    L8:
        String r100 = r310.getScene();
        if (r100 != null) goto L11;
        r100 = r311.getScene();
    L11:
        String r101 = r100;
        CubeInitConfig r102 = r311.getCubeInitConfig();
        String r103 = r310.getEnterFrom();
        if (r103 != null) goto L14;
        r103 = r311.getCubeInitConfig().getEnterFrom();
    L14:
        CubeInitConfig r104 = CubeInitConfig.copy$default(r102, r103, null, 2, null);
        LynxInitConfig r105 = r311.getLynxInitConfig();
        Boolean r106 = r310.getEnableFontScale();
        if (r106 != null) goto L17;
        r106 = r311.getLynxInitConfig().getFontScaleEnable();
    L17:
        Boolean r110 = r106;
        String r107 = r310.getGroup();
        if (r107 != null) goto L20;
        r107 = r311.getLynxInitConfig().getGroupName();
    L20:
        String r111 = r107;
        Boolean r108 = r310.getDisableJsCtxShare();
        if (r108 != null) goto L23;
        boolean r112 = r311.getLynxInitConfig().getShareGroup();
    L27:
        Boolean r109 = r310.getEnableCanvas();
        if (r109 == null) goto L30;
        boolean r113 = r109.booleanValue();
    L31:
        boolean r114 = r113;
        Boolean r115 = r310.getEnableCanvasOptimize();
        if (r115 == null) goto L34;
        boolean r116 = r115.booleanValue();
    L35:
        boolean r210 = r116;
        Boolean r117 = r310.getEnableDynamicV8();
        if (r117 == null) goto L38;
        boolean r118 = r117.booleanValue();
    L39:
        boolean r211 = r118;
        Integer r119 = r310.getLynxPresetWidth();
        if (r119 == null) goto L42;
        int r120 = r119.intValue();
    L43:
        int r212 = r120;
        Integer r121 = r310.getLynxPresetWidthSpecMode();
        if (r121 == null) goto L48;
        Integer r122 = n(r121.intValue());
        if (r122 == null) goto L48;
        int r123 = r122.intValue();
    L49:
        int r213 = r123;
        Integer r124 = r310.getLynxPresetHeight();
        if (r124 == null) goto L52;
        int r125 = r124.intValue();
    L53:
        int r214 = r125;
        Integer r126 = r310.getLynxPresetHeightSpecMode();
        if (r126 == null) goto L58;
        Integer r127 = n(r126.intValue());
        if (r127 == null) goto L58;
        int r128 = r127.intValue();
    L59:
        int r215 = r128;
        Boolean r129 = r310.getPresetSafePoint();
        if (r129 == null) goto L62;
        boolean r130 = r129.booleanValue();
    L63:
        boolean r216 = r130;
        Integer r131 = r310.getThreadStrategy();
        if (r131 == null) goto L66;
        int r132 = r131.intValue();
    L67:
        int r217 = r132;
        Boolean r133 = r310.getEnableVsyncAlignedMessageLoop();
        if (r133 == null) goto L70;
        boolean r134 = r133.booleanValue();
    L71:
        boolean r312 = r134;
        Boolean r135 = r310.getEnableJsGroupThread();
        if (r135 == null) goto L74;
        boolean r136 = r135.booleanValue();
    L75:
        boolean r137 = r136;
        Boolean r138 = r310.getEnablePendingJsTask();
        if (r138 == null) goto L78;
        boolean r139 = r138.booleanValue();
    L79:
        LynxInitConfig r140 = LynxInitConfig.copy$default(r105, null, r110, null, null, false, r137, r111, r112, r114, null, r211, r210, r212, r213, r214, r215, null, r216, r217, false, null, r312, false, r139, 5833245, null);
        LynxLoadConfig r141 = r311.getLynxLoadConfig();
        Boolean r142 = r310.getReadResInMain();
        if (r142 == null) goto L82;
        boolean r143 = r142.booleanValue();
    L83:
        boolean r144 = r143;
        Boolean r145 = r310.getRenderTemplateInMain();
        if (r145 == null) goto L86;
        boolean r146 = r145.booleanValue();
    L87:
        boolean r147 = r146;
        Boolean r148 = r310.getEnablePreFetchImage();
        if (r148 == null) goto L90;
        boolean r149 = r148.booleanValue();
    L91:
        CubeConfig r150 = CubeConfig.copy$default(r311, null, r101, r104, r140, LynxLoadConfig.copy$default(r141, r144, r147, null, null, null, r149, false, 92, null), 1, null);
        f505514a.getClass();
        String r151 = r310.getOriginUrl();
        String r152 = r310.getEnterFrom();
        if (r152 != null) goto L94;
        r152 = r311.getCubeInitConfig().getEnterFrom();
    L94:
        String r153 = r152;
        JSONObject r154 = new JSONObject();
        String r155 = r310.getScene();
        if (r155 != null) goto L97;
        r155 = r311.getScene();
    L97:
        r154.put("cube_key", r155);
        r154.put("current_thread", ap6.a.a());
        Boolean r156 = r310.getEnableCanvas();
        if (r156 == null) goto L100;
        r154.put(LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS, ap6.a.d(Boolean.valueOf(r156.booleanValue())));
    L100:
        Boolean r157 = r310.getEnableCanvasOptimize();
        if (r157 == null) goto L103;
        r154.put("enable_canvas_optimize", ap6.a.d(Boolean.valueOf(r157.booleanValue())));
    L103:
        Boolean r158 = r310.getEnableDynamicV8();
        if (r158 == null) goto L106;
        r154.put("enable_dynamic_v8", ap6.a.d(Boolean.valueOf(r158.booleanValue())));
    L106:
        Integer r159 = r310.getLynxPresetWidth();
        if (r159 == null) goto L109;
        r154.put("preset_width", String.valueOf(r159.intValue()));
    L109:
        Integer r160 = r310.getLynxPresetHeight();
        if (r160 == null) goto L112;
        r154.put("preset_height", String.valueOf(r160.intValue()));
    L112:
        Integer r161 = r310.getLynxPresetWidthSpecMode();
        if (r161 == null) goto L115;
        r154.put("preset_width_spec", String.valueOf(r161.intValue()));
    L115:
        Integer r162 = r310.getLynxPresetHeightSpecMode();
        if (r162 == null) goto L118;
        r154.put("preset_height_spec", String.valueOf(r162.intValue()));
    L118:
        Boolean r163 = r310.getPresetSafePoint();
        if (r163 == null) goto L121;
        r154.put("preset_safe_point", ap6.a.d(Boolean.valueOf(r163.booleanValue())));
    L121:
        Integer r164 = r310.getThreadStrategy();
        if (r164 == null) goto L124;
        r154.put("thread_strategy", String.valueOf(r164.intValue()));
    L124:
        String r165 = r310.getGroup();
        if (r165 == null) goto L127;
        r154.put("group", r165);
    L127:
        Boolean r166 = r310.getDisableJsCtxShare();
        if (r166 == null) goto L130;
        r154.put("disable_js_ctx_share", ap6.a.d(Boolean.valueOf(r166.booleanValue())));
    L130:
        Boolean r167 = r310.getEnableJsGroupThread();
        if (r167 == null) goto L133;
        r154.put("enable_js_group_thread", ap6.a.d(Boolean.valueOf(r167.booleanValue())));
    L133:
        Boolean r168 = r310.getEnablePendingJsTask();
        if (r168 == null) goto L136;
        r154.put("enable_pending_js_task", ap6.a.d(Boolean.valueOf(r168.booleanValue())));
    L136:
        JSONObject r169 = new JSONObject();
        r169.put("parse_schema_duration", r310.getParseDuration());
        PoiLynxKitReportInfo r170 = new PoiLynxKitReportInfo(null, r151, r169, r154, r153, 1, null);
        int r171 = PoiLynxKitMonitor.f257254a;
        Intrinsics.checkNotNullParameter(r170, "info");
        r170.setEventName("cube_schema_data_apply");
        PoiLynxKitMonitor.b(r170);
        return r150;
    L90:
        r149 = r311.getLynxLoadConfig().getEnablePreFetchImage();
        goto L91
    L86:
        r146 = r311.getLynxLoadConfig().getRenderTemplateOnMainThread();
        goto L87
    L82:
        r143 = r311.getLynxLoadConfig().getReadResOnMainThread();
        goto L83
    L78:
        r139 = r311.getLynxInitConfig().getEnablePendingJsTask();
        goto L79
    L74:
        r136 = r311.getLynxInitConfig().getEnableJsGroupThread();
        goto L75
    L70:
        r134 = r311.getLynxInitConfig().getEnableVsyncAlignedMessageLoop();
        goto L71
    L66:
        r132 = r311.getLynxInitConfig().getThreadStrategy();
        goto L67
    L62:
        r130 = r311.getLynxInitConfig().getPresetSafePoint();
    L58:
        r128 = r311.getLynxInitConfig().getHeightSpecMode();
        goto L59
    L52:
        r125 = r311.getLynxInitConfig().getHeightSize();
    L48:
        r123 = r311.getLynxInitConfig().getWidthSpecMode();
        goto L49
    L42:
        r120 = r311.getLynxInitConfig().getWidthSize();
        goto L43
    L38:
        r118 = r311.getLynxInitConfig().getEnableDynamicV8();
        goto L39
    L34:
        r116 = r311.getLynxInitConfig().getEnableCanvasOptimize();
        goto L35
    L30:
        r113 = r311.getLynxInitConfig().getEnableCanvas();
        goto L31
    L23:
        if (r108.booleanValue() == true) goto L25;
        r112 = true;
        goto L27
    L25:
        r112 = false;
        goto L27
    }
}
