package v36;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerType;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;
import y36.j;
import y36.k;
import y36.l;
import y36.p;
import y36.r;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends x36.c {
    public y36.a A;
    public y36.a B;
    public r C;
    public r D;
    public p E;
    public y36.d F;
    public l G;
    public y36.b H;
    public p I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public r f552899J;
    public y36.d K;
    public k L;
    public l M;
    public y36.a N;
    public j O;
    public y36.a P;
    public y36.b Q;
    public j R;
    public y36.a S;
    public y36.a T;
    public y36.a U;
    public y36.a V;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y36.a f552900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y36.b f552901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y36.a f552902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y36.a f552903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y36.a f552904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y36.a f552905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public y36.a f552906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public y36.a f552907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y36.b f552908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public y36.b f552909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y36.a f552910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y36.a f552911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public y36.b f552912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j f552913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y36.b f552914v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j f552915w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public y36.a f552916x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y36.a f552917y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public y36.a f552918z;

    public final l getType() {
        l r100 = this.M;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public d() {
    }

    @Override // t36.f
    public final void a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Boolean r101 = Boolean.FALSE;
        y36.a r102 = new y36.a(r100, "disable_outside_click_close", r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f562380a = r102;
        y36.a r103 = new y36.a(r100, "enable_pull_down_close", r101);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f562381b = r103;
        l r104 = new l(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY, PopupType.BOTTOM);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f562382c = r104;
        y36.b r105 = new y36.b(r100, "height", null);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f562383d = r105;
        r r106 = new r(r100, "mask_bg_color");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f562384e = r106;
        y36.b r107 = new y36.b(r100, "radius", Double.valueOf(8.0d));
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f562385f = r107;
        Intrinsics.checkNotNullParameter(new y36.b(r100, "radius", null), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.a(r100, "show_mask", r101), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.d(r100, "transition_animation", 0), "<set-?>");
        y36.b r108 = new y36.b(r100, "width", null);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f562386g = r108;
        Boolean r109 = Boolean.TRUE;
        y36.a r110 = new y36.a(r100, "allowClosed", r109);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f552900h = r110;
        y36.b r111 = new y36.b(r100, TextureRenderKeys.KEY_IS_ASPECT_RATIO, null);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        this.f552901i = r111;
        y36.a r112 = new y36.a(r100, "click_through_mask", r101);
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        this.f552902j = r112;
        y36.a r113 = new y36.a(r100, "close_by_gesture", null);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f552903k = r113;
        y36.a r114 = new y36.a(r100, "close_by_mask", null);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        this.f552904l = r114;
        y36.a r115 = new y36.a(r100, "disable_immersive", null);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        this.f552905m = r115;
        y36.a r116 = new y36.a(r100, "drag_back", null);
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f552906n = r116;
        y36.a r117 = new y36.a(r100, "drag_by_gesture", null);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        this.f552907o = r117;
        Double r118 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        y36.b r119 = new y36.b(r100, "drag_down_close_threshold", r118);
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        this.f552908p = r119;
        y36.b r120 = new y36.b(r100, "drag_down_threshold", r118);
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        this.f552909q = r120;
        y36.a r121 = new y36.a(r100, "drag_except_statusbar", null);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        this.f552910r = r121;
        y36.a r122 = new y36.a(r100, "drag_follow_gesture", r109);
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        this.f552911s = r122;
        y36.b r123 = new y36.b(r100, "drag_height", null);
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        this.f552912t = r123;
        j r124 = new j(r100, "drag_height_percent", null);
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        this.f552913u = r124;
        y36.b r125 = new y36.b(r100, "drag_up_threshold", r118);
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        this.f552914v = r125;
        j r126 = new j(r100, ECFindSimilarConfig.HEIGHT_PERCENT, null);
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        this.f552915w = r126;
        y36.a r127 = new y36.a(r100, "hide_nav_bar", r109);
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        this.f552916x = r127;
        y36.a r128 = new y36.a(r100, "is_adjust_pan", r109);
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        this.f552917y = r128;
        y36.a r129 = new y36.a(r100, "keyboard_adjust", r101);
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        this.f552918z = r129;
        y36.a r130 = new y36.a(r100, "listen_keyboard", r101);
        Intrinsics.checkNotNullParameter(r130, "<set-?>");
        this.A = r130;
        y36.a r131 = new y36.a(r100, "mask_close_until_loaded", r101);
        Intrinsics.checkNotNullParameter(r131, "<set-?>");
        this.B = r131;
        r r132 = new r(r100, "mask_color");
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        this.C = r132;
        r r133 = new r(r100, "nav_bar_color");
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        this.D = r133;
        p r134 = new p(r100, "origin_container_id", null);
        Intrinsics.checkNotNullParameter(r134, "<set-?>");
        this.E = r134;
        y36.d r135 = new y36.d(r100, "peek_down_close_threshold", null);
        Intrinsics.checkNotNullParameter(r135, "<set-?>");
        this.F = r135;
        PopupType r136 = PopupType.CENTER;
        l r137 = new l(r100, "popup_enter_type", r136);
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        this.G = r137;
        y36.b r138 = new y36.b(r100, "resize_duration", Double.valueOf(0.3d));
        Intrinsics.checkNotNullParameter(r138, "<set-?>");
        this.H = r138;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "show_on_success", r101), "<set-?>");
        p r139 = new p(r100, "title", null);
        Intrinsics.checkNotNullParameter(r139, "<set-?>");
        this.I = r139;
        r r140 = new r(r100, "title_color");
        Intrinsics.checkNotNullParameter(r140, "<set-?>");
        this.f552899J = r140;
        y36.d r141 = new y36.d(r100, "touch_limit", 0);
        Intrinsics.checkNotNullParameter(r141, "<set-?>");
        this.K = r141;
        k r142 = new k(r100, PopupTriggerType.FINISH);
        Intrinsics.checkNotNullParameter(r142, "<set-?>");
        this.L = r142;
        l r143 = new l(r100, "type", r136);
        Intrinsics.checkNotNullParameter(r143, "<set-?>");
        this.M = r143;
        y36.a r144 = new y36.a(r100, "use_screen_height", r101);
        Intrinsics.checkNotNullParameter(r144, "<set-?>");
        this.N = r144;
        j r145 = new j(r100, "width_percent", null);
        Intrinsics.checkNotNullParameter(r145, "<set-?>");
        this.O = r145;
        y36.a r146 = new y36.a(r100, "ignore_keyboard_padding", r101);
        Intrinsics.checkNotNullParameter(r146, "<set-?>");
        this.P = r146;
        y36.b r147 = new y36.b(r100, "drag_upping_space", null);
        Intrinsics.checkNotNullParameter(r147, "<set-?>");
        this.Q = r147;
        j r148 = new j(r100, "drag_upping_space_percent", null);
        Intrinsics.checkNotNullParameter(r148, "<set-?>");
        this.R = r148;
        y36.a r149 = new y36.a(r100, "drag_upping_with_statusbar", r101);
        Intrinsics.checkNotNullParameter(r149, "<set-?>");
        this.S = r149;
        y36.a r150 = new y36.a(r100, "compat_lynx_foldview", r101);
        Intrinsics.checkNotNullParameter(r150, "<set-?>");
        this.T = r150;
        y36.a r151 = new y36.a(r100, "radius_use_dp", r101);
        Intrinsics.checkNotNullParameter(r151, "<set-?>");
        this.U = r151;
        y36.a r152 = new y36.a(r100, "hide_status_bar", r101);
        Intrinsics.checkNotNullParameter(r152, "<set-?>");
        this.V = r152;
    }
}
