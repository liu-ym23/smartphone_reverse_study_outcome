package v36;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.bullet.service.sdk.param.SecStrategy;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y36.f;
import y36.j;
import y36.m;
import y36.p;
import y36.r;
import y36.s;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends x36.a {
    public y36.a A;
    public y36.a B;
    public y36.a C;
    public y36.a D;
    public y36.a E;
    public y36.a F;
    public y36.a G;
    public y36.a H;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y36.a f552844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y36.a f552845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y36.a f552846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y36.a f552847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y36.c f552848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r f552849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public y36.a f552850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y36.a f552851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public y36.c f552852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r f552853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y36.a f552854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public p f552855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public p f552856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y36.a f552857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p f552858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public y36.a f552859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public p f552860y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public y36.d f552861z;

    public final y36.a g() {
        y36.a r100 = this.f552844i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("blockBackPress");
        return null;
    }

    public final y36.a h() {
        y36.a r100 = this.A;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
        return null;
    }

    public final y36.a i() {
        y36.a r100 = this.f552851p;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(DyPayConstant.KEY_SHOW_LOADING);
        return null;
    }

    public final y36.a j() {
        y36.a r100 = this.B;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("transStatusBar");
        return null;
    }

    public a() {
    }

    @Override // t36.f
    public final void a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        this.f562370h = r100.getOriginUrl().toString();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        r r102 = new r(r100, "container_bg_color");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f562363a = r102;
        Boolean r103 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "disable_builtin", r103), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.a(r100, "disable_offline", r103), "<set-?>");
        Intrinsics.checkNotNullParameter(new s(r100, "fallback_url"), "<set-?>");
        y36.a r104 = new y36.a(r100, "hide_loading", null);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f562364b = r104;
        r r105 = new r(r100, "loading_bg_color");
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f562365c = r105;
        s r106 = new s(r100, "url");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f562366d = r106;
        r r107 = new r(r100, "content_bg_color");
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f562367e = r107;
        r r108 = new r(r100, "container_light_bg_color");
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f562368f = r108;
        r r109 = new r(r100, "container_dark_bg_color");
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        this.f562369g = r109;
        Intrinsics.checkNotNullParameter(new r(r100, "bg_color"), "<set-?>");
        y36.a r110 = new y36.a(r100, "block_back_press", r103);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f552844i = r110;
        Intrinsics.checkNotNullParameter(new r(r100, "container_bgcolor"), "<set-?>");
        y36.a r111 = new y36.a(r100, "enable_font_scale", r103);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        this.f552845j = r111;
        Boolean r112 = Boolean.TRUE;
        y36.a r113 = new y36.a(r100, "enable_trigger_showhide", r112);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f552846k = r113;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "enable_xschema_interceptor", r103), "<set-?>");
        y36.a r114 = new y36.a(r100, "enable_view_zoom", r103);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        this.f552847l = r114;
        y36.c r115 = new y36.c(r100, "font_scale", Float.valueOf(0.0f));
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        this.f552848m = r115;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "force_h5", r103), "<set-?>");
        Intrinsics.checkNotNullParameter(new f(r100, "load_url_delay_time", 0L), "<set-?>");
        r r116 = new r(r100, "loading_bgcolor");
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f552849n = r116;
        Intrinsics.checkNotNullParameter(new y36.d(r100, BdpAppEventConstant.SANDBOX, 0), "<set-?>");
        Intrinsics.checkNotNullParameter(new m(r100, SecStrategy.NORMAL), "<set-?>");
        y36.a r117 = new y36.a(r100, "show_error", r112);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        this.f552850o = r117;
        y36.a r118 = new y36.a(r100, "show_loading", r112);
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        this.f552851p = r118;
        Intrinsics.checkNotNullParameter(new y36.a(r100, AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME, r103), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.a(r100, "use_xbridge3", r103), "<set-?>");
        y36.c r119 = new y36.c(r100, "view_zoom", null);
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        this.f552852q = r119;
        r r120 = new r(r100, "web_bg_color");
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        this.f552853r = r120;
        Intrinsics.checkNotNullParameter(new y36.b(r100, "pad_ratio", null), "<set-?>");
        p r121 = new p(r100, "loader_name", "default");
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        this.f552855t = r121;
        p r122 = new p(r100, "enable_preload", "disable");
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        this.f552856u = r122;
        p r123 = new p(r100, "forest_download_engine", TrafficMetrics.FRPM_TTNET);
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        this.f552858w = r123;
        y36.a r124 = new y36.a(r100, "delay_preload", r103);
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        this.f552857v = r124;
        y36.a r125 = new y36.a(r100, "_close_after_open_success", r103);
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        this.f552859x = r125;
        p r126 = new p(r100, "_open_container_id", "");
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        this.f552860y = r126;
        y36.d r127 = new y36.d(r100, "android_soft_input_mode", -1);
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        this.f552861z = r127;
        y36.a r128 = new y36.a(r100, "hide_status_bar", r103);
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        this.A = r128;
        y36.a r129 = new y36.a(r100, AppConstants.TRANS_STATUS_BAR, r103);
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        this.B = r129;
        y36.a r130 = new y36.a(r100, "use_motion", r103);
        Intrinsics.checkNotNullParameter(r130, "<set-?>");
        this.f552854s = r130;
        Intrinsics.checkNotNullParameter(new j(r100, ECFindSimilarConfig.HEIGHT_PERCENT, null), "<set-?>");
        y36.a r131 = new y36.a(r100, "use_ktx2_transcoder", r103);
        Intrinsics.checkNotNullParameter(r131, "<set-?>");
        this.C = r131;
        y36.a r132 = new y36.a(r100, "enable_lynx_predecode", r103);
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        this.D = r132;
        y36.a r133 = new y36.a(r100, AppConstants.BUNDLE_PULL_DOWN_CLOSE, r103);
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        this.E = r133;
        y36.a r134 = new y36.a(r100, "enable_engine_view_scroll", r103);
        Intrinsics.checkNotNullParameter(r134, "<set-?>");
        this.F = r134;
        y36.a r135 = new y36.a(r100, "disable_input_scroll", r103);
        Intrinsics.checkNotNullParameter(r135, "<set-?>");
        this.G = r135;
        y36.a r136 = new y36.a(r100, "enable_access_token", r103);
        Intrinsics.checkNotNullParameter(r136, "<set-?>");
        this.H = r136;
        return;
    L5:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
