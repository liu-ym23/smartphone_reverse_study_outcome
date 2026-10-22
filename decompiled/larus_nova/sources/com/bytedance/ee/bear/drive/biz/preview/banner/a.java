package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.fragment.i;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView;
import com.bytedance.ee.bear.middleground.permission.secret.o;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.drive.render.j;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import i75.h;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f223204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f223205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f223206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f223207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f223208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final UDNotice f223209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SecretSetBannerView f223210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DLPRiskBannerView f223211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f223212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f223213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ForbiddenBannerView f223214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DriveCustomBannerContainer f223215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList<b> f223216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f223217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f223218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f223219p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f223220q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f223221r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DrivePluginHost f223222s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f223223t;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.banner.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3190a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f223224a;

        public ViewOnClickListenerC3190a(a r100) {
            this.f223224a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f223224a.f();
            this.f223224a.b();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDNotice.Type f223225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f223226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f223227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f223228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f223229e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f223230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f223231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View.OnClickListener f223232h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f223225a == r101.f223225a) goto L12;
            return false;
        L12:
            if (this.f223226b == r101.f223226b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f223227c, r101.f223227c) == true) goto L18;
            return false;
        L18:
            if (this.f223228d == r101.f223228d) goto L21;
            return false;
        L21:
            if (this.f223229e == r101.f223229e) goto L24;
            return false;
        L24:
            if (this.f223230f == r101.f223230f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f223231g, r101.f223231g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f223232h, r101.f223232h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f223225a.hashCode() * 31) + this.f223226b) * 31) + this.f223227c.hashCode()) * 31;
            int r101 = 1231;
            if (this.f223228d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (((r100 + r102) * 31) + this.f223229e) * 31;
            if (this.f223230f == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            String r105 = this.f223231g;
            int r106 = 0;
            if (r105 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r104 + r107) * 31;
            View.OnClickListener r109 = this.f223232h;
            if (r109 == null) goto L19;
            r106 = r109.hashCode();
        L19:
            return r108 + r106;
        L13:
            r107 = r105.hashCode();
            goto L14
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "Notice(type=" + this.f223225a + ", drawableRes=" + this.f223226b + ", tips=" + this.f223227c + ", showClose=" + this.f223228d + ", id=" + this.f223229e + ", overlay=" + this.f223230f + ", clickText=" + this.f223231g + ", clickListener=" + this.f223232h + ')';
        }

        public final UDNotice.Type getType() {
            return this.f223225a;
        }

        public /* synthetic */ b(UDNotice.Type r110, String r111) {
            this(r110, R.drawable.ud_icon_warning_hollow_filled, r111, false, 0, false, null, null);
        }

        public b(UDNotice.Type r100, int r101, String r102, boolean r103, int r104, boolean r105, String r106, View.OnClickListener r107) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "tips");
            this.f223225a = r100;
            this.f223226b = r101;
            this.f223227c = r102;
            this.f223228d = r103;
            this.f223229e = r104;
            this.f223230f = r105;
            this.f223231g = r106;
            this.f223232h = r107;
        }
    }

    public final void b() {
        UDNotice r100 = this.f223209f;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        DLPRiskBannerView r101 = this.f223211h;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        ForbiddenBannerView r102 = this.f223214k;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        SecretSetBannerView r103 = this.f223210g;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        c();
        if (this.f223204a == false) goto L70;
        if (this.f223217n != null) goto L21;
        if (this.f223216m.size() <= 0) goto L70;
    L21:
        if (this.f223217n != null) goto L23;
        f();
    L23:
        b r104 = this.f223217n;
        if (r104 == null) goto L70;
        Intrinsics.checkNotNull(r104);
        UDNotice r105 = this.f223209f;
        if (r105 != null) goto L28;
    L30:
        boolean r106 = false;
    L31:
        if (r106 == true) goto L35;
        UDNotice r107 = this.f223209f;
        if (r107 == null) goto L35;
        r107.setVisibility(0);
    L35:
        UDNotice r108 = this.f223209f;
        if (r108 == null) goto L39;
        r108.setType(r104.getType());
    L39:
        if (TextUtils.isEmpty(r104.f223231g) == false) goto L41;
    L51:
        UDNotice r109 = this.f223209f;
        if (r109 == null) goto L54;
        r109.setText(r104.f223227c);
    L54:
        UDNotice r110 = this.f223209f;
        if (r110 == null) goto L58;
        r110.setIcon(r104.f223226b);
    L58:
        if (r104.f223228d == false) goto L65;
        UDNotice r111 = this.f223209f;
        if (r111 == null) goto L62;
        r111.i6(true);
    L62:
        UDNotice r112 = this.f223209f;
        if (r112 == null) goto L91;
        r112.setIconButton(R.drawable.ud_icon_close_small_outlined);
        return;
    L91:
        return;
    L65:
        UDNotice r113 = this.f223209f;
        if (r113 == null) goto L93;
        r113.i6(false);
        return;
    L93:
        return;
    L41:
        if (r104.f223232h == null) goto L51;
        String r114 = r104.f223227c + r104.f223231g;
        UDNotice r115 = this.f223209f;
        if (r115 == null) goto L89;
        r115.setText(r114);
    L89:
        UDNotice r116 = this.f223209f;     // Catch: Exception -> L49
        if (r116 == null) goto L54;
        r116.S5(r104.f223227c.length(), r114.length(), new d(r104, this));     // Catch: Exception -> L49
        Unit r117 = Unit.INSTANCE;     // Catch: Exception -> L49
    L49:
        e = move-exception;
        tt5.a.f("DriveComponent", e, false);
        Unit r118 = Unit.INSTANCE;
        goto L54
    L28:
        if (r105.getVisibility() != 0) goto L30;
        r106 = true;
    L70:
        if (this.f223206c == false) goto L78;
        if (this.f223207d == true) goto L78;
        DLPRiskBannerView r119 = this.f223211h;
        if (r119 == null) goto L94;
        r119.setVisibility(0);
        return;
    L94:
        return;
    L78:
        if (this.f223208e == false) goto L84;
        ForbiddenBannerView r120 = this.f223214k;
        if (r120 == null) goto L95;
        r120.setVisibility(0);
        return;
    L95:
        return;
    L84:
        if (this.f223205b == false) goto L96;
        SecretSetBannerView r121 = this.f223210g;
        if (r121 == null) goto L97;
        r121.setVisibility(0);
        return;
    L97:
        return;
    }

    public final void c() {
        LinearLayout r100 = this.f223212i;
        if (r100 != null) goto L5;
        return;
    L5:
        FrameLayout r101 = this.f223213j;
        if (r101 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        ConstraintLayout.LayoutParams r103 = null;
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        ConstraintLayout.LayoutParams r104 = (ConstraintLayout.LayoutParams) r102;
    L12:
        if (r104 != null) goto L14;
        return;
    L14:
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if ((r105 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        r103 = (ConstraintLayout.LayoutParams) r105;
    L17:
        if (r103 != null) goto L20;
        return;
    L20:
        if (e() == true) goto L22;
    L24:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L28;
        ((ViewGroup.MarginLayoutParams) r104).topMargin = (this.f223220q + this.f223219p) + this.f223221r;
        r103.topToTop = 0;
        r103.topToBottom = -1;
        r100.bringToFront();
    L29:
        r100.setLayoutParams(r104);
        r101.setLayoutParams(r103);
        return;
    L28:
        ((ViewGroup.MarginLayoutParams) r104).topMargin = this.f223221r;
        r103.topToTop = -1;
        r103.topToBottom = r100.getId();
        goto L29
    L22:
        if (this.f223218o == true) goto L24;
        r106 = true;
        goto L26
    L11:
        r104 = null;
        goto L12
    }

    public final boolean e() {
        DrivePluginHost r100 = this.f223222s;
        if (r100 == null) goto L15;
        Context r101 = r100.f224123a.getContext();
        int r102 = i.f224216a;
        j r103 = null;
        f r104 = (f) org.koin.java.a.c(f.class, null, null, 6);     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        r101 = LarkContext.getApplication();     // Catch: Throwable -> L10
    L8:
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L10
        r103 = r104.U4(r101);     // Catch: Throwable -> L10
    L13:
        if (i.a(r100, r103) != true) goto L15;
        return true;
    L10:
        th = move-exception;
        tt5.a.l("DRIVE_CACHE_FLOW", "media immersive openStrategy resolve failed", th);
    L15:
        return false;
    }

    public final void f() {
        b r100 = this.f223216m.poll();
        this.f223217n = r100;
        if (r100 != null) goto L8;
        UDNotice r101 = this.f223209f;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void a(b r110) {
        boolean r100 = true;
        this.f223204a = true;
        if (r110.f223230f == false) goto L18;
        b r101 = this.f223217n;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
        return;
    L12:
        Iterator<b> r103 = this.f223216m.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        if (r103.next().f223229e != r110.f223229e) goto L14;
        return;
    L7:
        if (r101.f223229e != r110.f223229e) goto L9;
        r102 = true;
    L18:
        this.f223216m.add(new b(r110.getType(), r110.f223226b, r110.f223227c, r110.f223228d, r110.f223229e, r110.f223230f, r110.f223231g, r110.f223232h));
        UDNotice r111 = this.f223209f;
        if (r111 != null) goto L21;
    L23:
        r100 = false;
    L24:
        if (r100 == true) goto L30;
        f();
        b();
        return;
    L30:
        return;
    L21:
        if (r111.getVisibility() != 0) goto L23;
        goto L23
    }

    public a(t r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "uiContainer");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f223216m = new LinkedList();
        View r102 = r100.findView(R.id.drive_notice_layout);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larksuite.component.universe_design.notice.UDNotice");
        UDNotice r103 = (UDNotice) r102;
        this.f223209f = r103;
        View r104 = r100.findView(R.id.drive_secret_tips);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView");
        this.f223210g = (SecretSetBannerView) r104;
        View r105 = r100.findView(R.id.dlp_risk_banner_view);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView");
        this.f223211h = (DLPRiskBannerView) r105;
        View r106 = r100.findView(R.id.banner_container);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.f223212i = (LinearLayout) r106;
        View r107 = r100.findView(R.id.drive_preview_container);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.f223213j = (FrameLayout) r107;
        ForbiddenBannerView r108 = null;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.platform.appeal_v2") == false) goto L7;
        View r109 = r100.findView(R.id.forbidden_banner_new_view);
        if ((r109 instanceof ForbiddenBannerView) == false) goto L10;
        r108 = (ForbiddenBannerView) r109;
    L10:
        this.f223214k = r108;
        View r110 = r100.findView(R.id.drive_custom_banner_container);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.banner.DriveCustomBannerContainer");
        this.f223215l = (DriveCustomBannerContainer) r110;
        this.f223223t = r101;
        if (r103 == null) goto L14;
        r103.setIconButtonListener(new ViewOnClickListenerC3190a(this));
        return;
    L14:
        return;
    L7:
        View r111 = r100.findView(R.id.forbidden_banner_view);
        if ((r111 instanceof ForbiddenBannerView) == false) goto L10;
        r108 = (ForbiddenBannerView) r111;
        goto L10
    }

    public final void g(boolean r100, String r101) {
        SecretSetBannerView r102 = this.f223210g;
        if (r102 == null) goto L10;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        boolean r105 = h.e(r101);
        if (this.f223205b == false) goto L8;
        if (r100 == true) goto L8;
        r102.setVisibility(0);
        d(r104, r105, false);
        return;
    L8:
        r102.setVisibility(8);
        d(r104, r105, r100);
        return;
    }

    public final void h(String r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r102 = r101.f234123d;
        this.f223205b = r102;
        if (r102 == false) goto L20;
        SecretSetBannerView r103 = this.f223210g;
        if (r103 != null) goto L7;
    L9:
        SecretSetBannerView r104 = this.f223210g;
        if (r104 == null) goto L14;
        boolean r105 = r101.f234124e;
        r104.f226556s = r105;
        if (r105 == false) goto L14;
        r104.f226539b.setVisibility(8);
        r104.f226541d.setVisibility(8);
    L14:
        SecretSetBannerView r106 = this.f223210g;
        if (r106 == null) goto L17;
        r106.f226555r = r101.f234121b;
    L17:
        if (r106 == null) goto L19;
        r106.d(r101.f234125f, r101.f234120a);
    L19:
        g(this.f223218o, r100);
        goto L20
    L7:
        if (r101.f234122c == false) goto L9;
        r103.f226549l.setVisibility(0);
    L20:
        b();
    }

    public final void d(LinearLayout.LayoutParams r100, boolean r101, boolean r102) {
        int r103 = 0;
        if (e() == false) goto L6;
        if (r102 == true) goto L6;
        boolean r104 = true;
    L7:
        c();
        if (r104 == true) goto L12;
        if (r101 == false) goto L12;
        if (r102 == true) goto L12;
        r103 = this.f223219p;
    L12:
        r100.topMargin = r103;
        return;
    L6:
        r104 = false;
        goto L7
    }
}
