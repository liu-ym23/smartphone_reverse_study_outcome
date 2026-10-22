package v36;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import kotlin.jvm.internal.Intrinsics;
import y36.g;
import y36.h;
import y36.n;
import y36.p;
import y36.r;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends x36.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y36.a f552889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y36.a f552890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f552891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y36.a f552892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public y36.a f552893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r f552894o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.sdk.param.a f552895p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p f552896q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y36.a f552897r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y36.a f552898s;

    public static final class a {
    }

    static {
    }

    public final h c() {
        h r100 = this.f552891l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("needOutAnimation");
        return null;
    }

    public c() {
    }

    @Override // t36.f
    public final void a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Boolean r101 = Boolean.FALSE;
        y36.a r102 = new y36.a(r100, "hide_nav_bar", r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f562371a = r102;
        y36.a r103 = new y36.a(r100, "hide_status_bar", r101);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f562372b = r103;
        r r104 = new r(r100, "nav_bar_color");
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f562373c = r104;
        Intrinsics.checkNotNullParameter(new g(r100, NavBtnType.NONE), "<set-?>");
        y36.a r105 = new y36.a(r100, "show_closeall", r101);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f562374d = r105;
        r r106 = new r(r100, AppConstants.BUNDLE_STATUS_BAR_BG_COLOR);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f562375e = r106;
        com.bytedance.ies.bullet.service.sdk.param.a r107 = new com.bytedance.ies.bullet.service.sdk.param.a(r100, "status_font_mode", null);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f562376f = r107;
        p r108 = new p(r100, "title", null);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f562377g = r108;
        r r109 = new r(r100, "title_color");
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        this.f562378h = r109;
        y36.a r110 = new y36.a(r100, AppConstants.TRANS_STATUS_BAR, r101);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f562379i = r110;
        Intrinsics.checkNotNullParameter(new y36.a(r100, AppConstants.BUNDLE_SUPPORT_EXCHANGE_THEME, r101), "<set-?>");
        Boolean r111 = Boolean.TRUE;
        y36.a r112 = new y36.a(r100, "enable_immersion_keyboard_control", r111);
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        this.f552889j = r112;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "hide_back", r101), "<set-?>");
        y36.a r113 = new y36.a(r100, "is_adjust_pan", r111);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f552890k = r113;
        h r114 = new h(r100, OutAnimation.AUTO);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        this.f552891l = r114;
        y36.a r115 = new y36.a(r100, "should_full_screen", r101);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        this.f552892m = r115;
        y36.a r116 = new y36.a(r100, "show_keyboard", r101);
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f552893n = r116;
        Intrinsics.checkNotNullParameter(new y36.a(r100, "show_more_button", r101), "<set-?>");
        Intrinsics.checkNotNullParameter(new n(r100), "<set-?>");
        r r117 = new r(r100, AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        this.f552894o = r117;
        com.bytedance.ies.bullet.service.sdk.param.a r118 = new com.bytedance.ies.bullet.service.sdk.param.a(r100, "status_font_dark", null);
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        this.f552895p = r118;
        Intrinsics.checkNotNullParameter(new y36.d(r100, "title_bar_style", 0), "<set-?>");
        y36.a r119 = new y36.a(r100, "use_webview_title", r111);
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        this.f552897r = r119;
        p r120 = new p(r100, "native_trigger_show_hide_event", "none");
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        this.f552896q = r120;
        y36.a r121 = new y36.a(r100, "enable_pull_down_refresh", r101);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        this.f552898s = r121;
    }
}
