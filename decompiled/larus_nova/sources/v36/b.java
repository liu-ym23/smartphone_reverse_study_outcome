package v36;

import com.android.ttcjpaysdk.base.h5.CJPayH5Activity;
import com.lynx.canvas.LynxGroupKryptonConfigs;
import kotlin.jvm.internal.Intrinsics;
import t36.f;
import y36.p;
import y36.s;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements f {
    public s A;
    public y36.a B;
    public s C;
    public y36.d D;
    public y36.a E;
    public y36.a F;
    public y36.a G;
    public p H;
    public y36.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public y36.a f552862J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f552863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f552864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f552865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y36.a f552866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y36.a f552867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y36.a f552868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f552869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y36.a f552870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y36.d f552871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y36.a f552872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y36.a f552873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y36.a f552874l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y36.a f552875m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p f552876n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public y36.a f552877o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f552878p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public y36.d f552879q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y36.d f552880r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y36.d f552881s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public y36.d f552882t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public y36.d f552883u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y36.d f552884v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p f552885w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public y36.a f552886x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y36.a f552887y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public y36.a f552888z;

    public b() {
        this.I = new y36.a(Boolean.FALSE);
    }

    @Override // t36.f
    public final void a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        s r101 = new s(r100, "a_surl");
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f552863a = r101;
        p r102 = new p(r100, "bundle", null);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f552864b = r102;
        Boolean r103 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "cache_script", r103), "<set-?>");
        p r104 = new p(r100, "channel", null);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f552865c = r104;
        y36.a r105 = new y36.a(r100, "close_by_back", r103);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f552866d = r105;
        Boolean r106 = Boolean.FALSE;
        y36.a r107 = new y36.a(r100, "create_view_async", r106);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f552867e = r107;
        y36.a r108 = new y36.a(r100, "enable_sync_flush", r106);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f552868f = r108;
        s r109 = new s(r100, "durl");
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        this.f552869g = r109;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "decode_script_sync", r103), "<set-?>");
        y36.a r110 = new y36.a(r100, "disable_auto_expose", r106);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f552870h = r110;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "disable_js_ctx_share", r106), "<set-?>");
        y36.d r111 = new y36.d(r100, "dynamic", 0);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        this.f552871i = r111;
        y36.a r112 = new y36.a(r100, LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS, r106);
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        this.f552872j = r112;
        y36.a r113 = new y36.a(r100, "enable_animax", r106);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f552873k = r113;
        y36.a r114 = new y36.a(r100, "enable_dynamic_v8", r106);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        this.f552874l = r114;
        y36.a r115 = new y36.a(r100, "enable_canvas_optimize", r106);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        this.f552875m = r115;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "enable_radon_compatible", r106), "<set-?>");
        p r116 = new p(r100, "group", "default_lynx_group");
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f552876n = r116;
        y36.a r117 = new y36.a(r100, "use_storage_group", r106);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        this.f552877o = r117;
        p r118 = new p(r100, "initial_data", null);
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        this.f552878p = r118;
        y36.d r119 = new y36.d(r100, "lynx_preset_height", 0);
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        this.f552879q = r119;
        y36.d r120 = new y36.d(r100, "lynx_init_width", null);
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        this.f552883u = r120;
        y36.d r121 = new y36.d(r100, "lynx_init_height", null);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        this.f552880r = r121;
        y36.d r122 = new y36.d(r100, "lynx_preset_height_spec", 0);
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        this.f552881s = r122;
        y36.d r123 = new y36.d(r100, "lynx_preset_width", 0);
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        this.f552882t = r123;
        y36.d r124 = new y36.d(r100, "lynx_preset_width_spec", 0);
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        this.f552884v = r124;
        Intrinsics.checkNotNullParameter(new s(r100, CJPayH5Activity.POST_URL), "<set-?>");
        p r125 = new p(r100, "preloadFonts", null);
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        this.f552885w = r125;
        Intrinsics.checkNotNullParameter(new y36.d(r100, "preset_height", 0), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.d(r100, "preset_width", 0), "<set-?>");
        y36.a r126 = new y36.a(r100, "preset_safe_point", r106);
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        this.f552886x = r126;
        y36.a r127 = new y36.a(r100, "read_res_info_in_main", r103);
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        this.f552887y = r127;
        y36.a r128 = new y36.a(r100, "render_temp_in_main", r103);
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        this.f552888z = r128;
        s r129 = new s(r100, "res_url");
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        this.A = r129;
        y36.a r130 = new y36.a(r100, "share_group", r103);
        Intrinsics.checkNotNullParameter(r130, "<set-?>");
        this.B = r130;
        s r131 = new s(r100, "surl");
        Intrinsics.checkNotNullParameter(r131, "<set-?>");
        this.C = r131;
        y36.d r132 = new y36.d(r100, "thread_strategy", 0);
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        this.D = r132;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "ui_running_mode", r103), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.a(r100, "use_gecko_first", r106), "<set-?>");
        this.I = new y36.a(r100, "enable_code_cache", r106);
        y36.a r133 = new y36.a(r100, "enable_pending_js_task", r106);
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        this.E = r133;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "use_piper_data", r106), "<set-?>");
        y36.a r134 = new y36.a(r100, "enable_vsync_aligned_message_loop", r106);
        Intrinsics.checkNotNullParameter(r134, "<set-?>");
        this.F = r134;
        y36.a r135 = new y36.a(r100, "air_strict_mode", r106);
        Intrinsics.checkNotNullParameter(r135, "<set-?>");
        this.G = r135;
        p r136 = new p(r100, "predefine", "");
        Intrinsics.checkNotNullParameter(r136, "<set-?>");
        this.H = r136;
        y36.a r137 = new y36.a(r100, "enable_lynx_generic_fetcher", r106);
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        this.f552862J = r137;
    }
}
