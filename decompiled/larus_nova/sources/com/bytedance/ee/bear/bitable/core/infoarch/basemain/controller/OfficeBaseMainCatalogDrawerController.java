package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainBlockCatalogContainer;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainInfoArchViewHolder;
import com.bytedance.ee.bear.bitable.infoarch.block.IDrawerAbility$EFlingDirection;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class OfficeBaseMainCatalogDrawerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeBaseMainInfoArchViewHolder f210298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.g f210299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentActivity f210300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OfficeBaseMainHeaderScrollController f210301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f210302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f210303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f210304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.a f210305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f210306i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainCatalogDrawerController f210307a;

        public b(OfficeBaseMainCatalogDrawerController r100) {
            this.f210307a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f210307a.i();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainCatalogDrawerController f210308a;

        public c(OfficeBaseMainCatalogDrawerController r100) {
            this.f210308a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f210308a.i();
        }
    }

    public static final class d implements com.bytedance.ee.bear.bitable.infoarch.block.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainCatalogDrawerController f210309a;

        public d(OfficeBaseMainCatalogDrawerController r100) {
            this.f210309a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.infoarch.block.c
        public final void a(IDrawerAbility$EFlingDirection r100) {
            Intrinsics.checkNotNullParameter(r100, "flingDirection");
            if (r100 != IDrawerAbility$EFlingDirection.LEFT) goto L6;
            this.f210309a.j(false);
            return;
        }
    }

    static {
    }

    public final float d() {
        return this.f210298a.f210507d.getWidth() - e();
    }

    public final int e() {
        if (this.f210299b.f210558f == false) goto L6;
        return (int) (this.f210298a.f210507d.getWidth() * 0.45f);
    L6:
        return com.bytedance.ee.util.ui.n.c(45.0f);
    }

    public final void f() {
        this.f210298a.f210520q.setStatusBarInset(this.f210306i);
        this.f210298a.f210508e.setOnClickListener(new b(this));
        this.f210298a.f210520q.setToggleListener(new c(this));
        this.f210298a.f210520q.setOnFlingListener(new d(this));
        this.f210298a.f210520q.setGetFocusView(new OfficeBaseMainCatalogDrawerController$init$4(this));
    }

    public final void i() {
        com.bytedance.ee.bear.bitable.core.infoarch.g r100 = this.f210299b;
        if (r100.f210556d == true) goto L6;
        tt5.a.h("OfficeBaseMainCatalogDrawerController", "toggleDrawer ignored, drawer disabled");
        return;
    L6:
        j(!r100.f210554b);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = this.f210298a.a();
        int r102 = Math.max((this.f210298a.f210505b.getTop() + r101) - this.f210306i, 0);
        tt5.a.h("OfficeBaseMainCatalogDrawerController", "getCatalogTopOffset titleHeight:" + r101 + ", statusBarHeight:" + this.f210306i + ", appBarTop:" + this.f210298a.f210505b.getTop() + ", topOffset:" + r102);
        float r103 = -((float) r102);
    L7:
        if (r100 == true) goto L9;
        g(true);
    L9:
        h(this.f210298a.f210505b, !r100);
        AppBarLayout r104 = this.f210298a.f210505b;
        r104.animate().cancel();
        r104.animate().translationY(r103).alpha(1.0f).setDuration(250).setInterpolator(new DecelerateInterpolator()).start();
        this.f210298a.f210512i.animate().cancel();
        this.f210298a.f210512i.setTranslationX(0.0f);
        this.f210298a.f210512i.setTranslationY(0.0f);
        this.f210298a.f210512i.setAlpha(1.0f);
        return;
    L5:
        r103 = 0.0f;
        goto L7
    }

    public final void g(boolean r100) {
        float r101 = 1.0f;
        this.f210298a.f210508e.setAlpha(1.0f);
        this.f210298a.f210517n.animate().cancel();
        View r102 = this.f210298a.f210517n;
        if (r100 == true) goto L6;
        r101 = 0.0f;
    L6:
        r102.setAlpha(r101);
    }

    public final void j(boolean r100) {
        com.bytedance.ee.bear.bitable.core.infoarch.g r101 = this.f210299b;
        if (r101.f210556d == true) goto L7;
        tt5.a.h("OfficeBaseMainCatalogDrawerController", "updateDrawerState ignored, drawer disabled, openDrawer:" + r100);
        return;
    L7:
        if (r100 == false) goto L18;
        com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.a r102 = this.f210305h;
        vz4.b.a r103 = r102.f210394b;
        if (r103 != null) goto L14;
        vz4.b r104 = r102.f210393a;
        if (r104 == null) goto L13;
        r103 = r104.qh("OfficeBaseMainCatalog");
        goto L14
    L13:
        r103 = null;
    L14:
        r102.f210394b = r103;
        this.f210299b.f210554b = true;
        this.f210302e.g(true);
        s r105 = this.f210303f;
        r105.f210492h = true;
        r105.b(true);
        this.f210304g.d(true);
        this.f210302e.f();
        OfficeBaseMainBlockCatalogContainer r106 = this.f210298a.f210520q;
        com.bytedance.ee.bear.bitable.core.infoarch.g r107 = this.f210299b;
        boolean r108 = r107.f210558f;
        boolean r109 = r107.f210553a;
        int r110 = this.f210301d.h();
        int r111 = e() + com.bytedance.ee.util.ui.n.c(12.0f);
        if (r106.getDismissArea().getLayoutParams().width == r111) goto L17;
        r106.getDismissArea().getLayoutParams().width = r111;
        r106.getDismissArea().requestLayout();
    L17:
        r106.e(true, r108, r109, r110);
        com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.c r112 = new com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.c(this);
        this.f210301d.d();
        this.f210301d.f210318a.f210509f.setClipBounds(null);
        com.bytedance.ee.util.ui.j.c(new com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.d(this, r112));
        return;
    L18:
        r101.f210555c = true;
        this.f210304g.d(false);
        this.f210302e.g(false);
        this.f210302e.f();
        this.f210298a.f210520q.setHeaderVisible(false);
        g(true);
        com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.b r113 = new com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.b(this);
        this.f210301d.d();
        this.f210301d.f210318a.f210509f.setClipBounds(null);
        a(false);
        c(this, this.f210298a.f210509f, 0.0f);
        ViewGroup r114 = this.f210298a.f210511h;
        if (r114 == null) goto L21;
        c(this, r114, 0.0f);
    L21:
        b(this.f210298a.f210520q, -d(), this.f210298a.f210520q.getTranslationX(), r113);
    }

    public static void h(AppBarLayout r100, boolean r101) {
        r100.animate().cancel();
        View r102 = r100.findViewById(R.id.titleContentLayout);
        if (r102 == null) goto L10;
        r102.animate().cancel();
        if (r101 == false) goto L7;
        float r103 = 1.0f;
    L8:
        r102.setAlpha(r103);
        return;
    L7:
        r103 = 0.0f;
        goto L8
    }

    public static /* synthetic */ void c(OfficeBaseMainCatalogDrawerController r100, View r101, float r102) {
        float r103 = r101.getTranslationX();
        r100.getClass();
        b(r101, r102, r103, null);
    }

    public static void b(View r100, float r101, float r102, com.bytedance.ee.bear.bitable.common.b r103) {
        r100.animate().cancel();
        r100.setTranslationX(r102);
        ViewPropertyAnimator r104 = r100.animate().translationX(r101).setDuration(250).setInterpolator(new DecelerateInterpolator());
        if (r103 == null) goto L5;
        r104.setListener(r103);
    L5:
        r104.start();
    }

    public OfficeBaseMainCatalogDrawerController(OfficeBaseMainInfoArchViewHolder r100, com.bytedance.ee.bear.bitable.core.infoarch.g r101, FragmentActivity r102, OfficeBaseMainHeaderScrollController r103, l r104, s r105, e r106, com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.a r107) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r103, "headerScrollController");
        Intrinsics.checkNotNullParameter(r104, "layoutController");
        Intrinsics.checkNotNullParameter(r105, "statusBarController");
        Intrinsics.checkNotNullParameter(r106, "dashboardThemeController");
        Intrinsics.checkNotNullParameter(r107, "appletCapsuleController");
        this.f210298a = r100;
        this.f210299b = r101;
        this.f210300c = r102;
        this.f210301d = r103;
        this.f210302e = r104;
        this.f210303f = r105;
        this.f210304g = r106;
        this.f210305h = r107;
        this.f210306i = com.bytedance.ee.util.ui.k.e(r100.f210507d.getContext());
    }
}
