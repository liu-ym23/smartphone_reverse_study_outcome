package com.bytedance.ee.bear.bitable.core.infoarch;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ViewHolder;
import com.bytedance.ee.bear.bitable.core.nested.PinWrapperLinearLayout;
import com.bytedance.ee.bear.bitable.infoarch.header.BitableHeaderContainer;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.BitableToolbarContainer;
import com.bytedance.ee.bear.bitable.infoarch.top.BitableTopContainer;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.list.homepage.KeepWithinParentBoundsScrollingBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements com.bytedance.ee.bear.bitable.core.infoarch.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableInfoArchManagerNew f210559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f210560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f210561c;

    public static final class a implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f210562a;

        public a(i r100) {
            this.f210562a = r100;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout r100, int r101) {
            this.f210562a.b(r101, false);
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f210563a;

        public b(i r100) {
            this.f210563a = r100;
        }

        public static void a(View r100, float r101, com.bytedance.ee.bear.bitable.common.b r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            ViewPropertyAnimator r103 = r100.animate().translationY(r101);
            if (r102 == null) goto L5;
            r103.setListener(r102);
        L5:
            r103.setDuration(300).start();
        }
    }

    public static final class c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f210564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f210565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f210566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f210567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f210568e;

        public d() {
            this.f210564a = "none";
            this.f210566c = true;
        }
    }

    public static final class e extends com.bytedance.ee.bear.bitable.common.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f210569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Boolean f210570b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            i r101 = this.f210569a;
            r101.f210560b.f210565b = true;
            r101.getContext().f210185k.f210553a = true;
            this.f210569a.getContext().f210189o.b();
            b r102 = this.f210569a.f210561c;
            Boolean r103 = this.f210570b;
            int r104 = 8;
            r102.f210563a.f210559a.f210181g.f210220g.setVisibility(8);
            BitableToolbarContainer r105 = r102.f210563a.f210559a.f210181g.f210223j;
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L5;
            r104 = 0;
        L5:
            r105.setVisibility(r104);
            r102.f210563a.f210559a.f210181g.f210219f.setTranslationY(0.0f);
            r102.f210563a.f210559a.f210181g.f210226m.setTranslationY(0.0f);
            r102.f210563a.f210559a.f210181g.f210218e.requestLayout();
            h r106 = this.f210569a.getContext().f210198x;
            if (r106 == null) goto L8;
            r106.a(true);
        L8:
            com.bytedance.ee.bear.bitable.common.b.a(this.f210569a.f210559a.f210181g.f210226m);
        }

        public e(i r100, Boolean r101) {
            this.f210569a = r100;
            this.f210570b = r101;
        }
    }

    public static final class f extends com.bytedance.ee.bear.bitable.common.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f210571a;

        public f(i r100) {
            this.f210571a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            i r101 = this.f210571a;
            r101.f210560b.f210565b = false;
            r101.getContext().f210185k.f210553a = false;
            this.f210571a.getContext().f210189o.b();
            h r102 = this.f210571a.getContext().f210198x;
            if (r102 == null) goto L5;
            r102.a(false);
        L5:
            com.bytedance.ee.bear.bitable.common.b.a(this.f210571a.f210559a.f210181g.f210226m);
        }
    }

    static {
    }

    public final BitableInfoArchManagerNew getContext() {
        return this.f210559a;
    }

    public i(BitableInfoArchManagerNew r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f210559a = r100;
        this.f210560b = new d();
        this.f210561c = new b(this);
        r100.f210181g.f210219f.addOnOffsetChangedListener(new a(this));
        i r101 = j.f210572a;
        j.f210572a = this;
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.e
    public final void a(boolean r100) {
        if (TextUtils.equals(this.f210560b.f210564a, "animator") == true) goto L5;
        return;
    L5:
        d r101 = this.f210560b;
        if (r101.f210566c == true) goto L10;
        if (r100 == true) goto L10;
        return;
    L10:
        if (r101.f210565b != r100) goto L12;
        return;
    L12:
        tt5.a.h("ScrollController", "onToggleHeader");
        SceneModel r102 = this.f210559a.f210184j.f210256b.f210263f;
        if (r102 == null) goto L15;
        Boolean r103 = Boolean.valueOf(r102.isKanban());
    L16:
        SceneModel r104 = this.f210559a.f210184j.f210256b.f210263f;
        if (r104 == null) goto L19;
        Boolean r105 = Boolean.valueOf(r104.hideToolbar());
    L20:
        int r106 = 0;
        if (r100 == false) goto L29;
        this.f210559a.f210181g.f210229p.c(true, 1.0f);
        b r107 = this.f210561c;
        ViewHolder r108 = this.f210559a.f210181g;
        BitableTopContainer r109 = r108.f210219f;
        float r110 = -r108.a();
        r107.getClass();
        b.a(r109, r110, null);
        b r111 = this.f210561c;
        ViewHolder r112 = this.f210559a.f210181g;
        BitableContentContainer r113 = r112.f210226m;
        float r114 = -r112.a();
        Boolean r115 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r115) == false) goto L25;
    L28:
        e r116 = new e(this, r103);
        r111.getClass();
        b.a(r113, r114 - r106, r116);
        return;
    L25:
        if (Intrinsics.areEqual(r105, r115) == true) goto L28;
        r106 = this.f210559a.f210181g.f210223j.getMeasuredHeight();
        goto L28
    L29:
        this.f210559a.f210181g.f210229p.c(false, 0.0f);
        b r117 = this.f210561c;
        r117.f210563a.f210559a.f210181g.f210220g.setVisibility(0);
        BitableToolbarContainer r118 = r117.f210563a.f210559a.f210181g.f210223j;
        Boolean r119 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r119) == false) goto L32;
        int r120 = 8;
    L33:
        r118.setVisibility(r120);
        ViewHolder r121 = r117.f210563a.f210559a.f210181g;
        r121.f210219f.setTranslationY(-r121.a());
        ViewHolder r122 = r117.f210563a.f210559a.f210181g;
        BitableContentContainer r123 = r122.f210226m;
        float r124 = -r122.a();
        if (Intrinsics.areEqual(r103, r119) == false) goto L36;
    L39:
        r123.setTranslationY(r124 - r106);
        b r125 = this.f210561c;
        BitableTopContainer r126 = this.f210559a.f210181g.f210219f;
        r125.getClass();
        b.a(r126, 0.0f, null);
        b r127 = this.f210561c;
        BitableContentContainer r128 = this.f210559a.f210181g.f210226m;
        f r129 = new f(this);
        r127.getClass();
        b.a(r128, 0.0f, r129);
        return;
    L36:
        if (Intrinsics.areEqual(r105, r119) == true) goto L39;
        r106 = r117.f210563a.f210559a.f210181g.f210223j.getMeasuredHeight();
        goto L39
    L32:
        r120 = 0;
        goto L33
    L19:
        r105 = null;
        goto L20
    L15:
        r103 = null;
        goto L16
    }

    public final void d(boolean r100) {
        tt5.a.h("ScrollController", "setWebContentTop:" + r100);
        this.f210560b.f210566c = r100;
        wr4.c r101 = this.f210559a.f210186l;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public final void b(int r100, boolean r101) {
        if (r101 == false) goto L4;
    L6:
        int r102 = Math.abs(r100);
        BitableInfoArchManagerNew r103 = this.f210559a;
        g r104 = r103.f210185k;
        r104.f210557e = r102;
        if (r102 < r103.f210181g.a()) goto L9;
        boolean r105 = true;
    L10:
        r104.f210553a = r105;
        this.f210560b.getClass();
        d r106 = this.f210560b;
        if (r102 < this.f210559a.f210181g.a()) goto L13;
        boolean r107 = true;
    L14:
        r106.f210565b = r107;
        this.f210559a.f210189o.b();
        ViewHolder r108 = this.f210559a.f210181g;
        r108.f210223j.b(r102, r108.a());
        ViewHolder r109 = this.f210559a.f210181g;
        ot4.c r110 = r109.f210229p;
        int r111 = r109.a();
        r110.getClass();
        if (Math.abs(r100) <= r111) goto L17;
        float r112 = 1.0f;
    L19:
        if (Math.abs(r100) < r111) goto L21;
        r110.c(true, r112);
        return;
    L21:
        r110.c(false, r112);
        return;
    L17:
        r112 = Math.abs(r100) / r111;
        goto L19
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L4:
        if (TextUtils.equals(this.f210560b.f210564a, "nested") == true) goto L6;
    }

    public static void c(i r110, SceneModel r111, boolean r112, boolean r113, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, int r215) {
        if ((r215 & 16) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r215 & 32) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r215 & 64) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r215 & 128) == 0) goto L17;
        boolean r103 = false;
    L18:
        r110.getClass();
        tt5.a.h("ScrollController", "onToggleNestedScroll: enableScroll:" + r112 + ", enableViewDepended:" + r210);
        if (r112 == false) goto L21;
        String r114 = "nested";
    L25:
        if (Intrinsics.areEqual(r110.f210560b.f210564a, r114) == true) goto L27;
        d r115 = r110.f210560b;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r115.f210564a = r114;
        boolean r116 = true;
    L28:
        BitableInfoArchManagerNew r117 = r110.f210559a;
        wr4.c r118 = r117.f210186l;
        ViewHolder r119 = r117.f210181g;
        Intrinsics.checkNotNullParameter(r117, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r119, "viewHolder");
        if (r118 != null) goto L31;
    L33:
        boolean r120 = false;
    L34:
        if (r120 == true) goto L37;
        if (r118 == null) goto L37;
        r118.b(r112);
    L37:
        ViewGroup.LayoutParams r121 = r119.f210220g.getLayoutParams();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams r122 = (AppBarLayout.LayoutParams) r121;
        if (r122.getScrollFlags() == r112) goto L40;
        r122.setScrollFlags(r112 ? 1 : 0);
    L40:
        PinWrapperLinearLayout r104 = r119.f210221h;
        if (r112 == true) goto L43;
    L45:
        int r123 = 0;
    L46:
        ViewGroup.LayoutParams r124 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams r125 = (AppBarLayout.LayoutParams) r124;
        if (r125.getScrollFlags() == r123) goto L49;
        r125.setScrollFlags(r123);
    L49:
        if (r112 == true) goto L51;
        r104.a(0);
    L51:
        r110.f210559a.f210181g.f210226m.setEnableScroll(r113);
        if (r116 == false) goto L84;
        ot4.c r105 = r110.f210559a.f210181g.f210229p;
        boolean r106 = r110.f210560b.f210565b;
        if (r106 == false) goto L56;
        float r126 = 1.0f;
    L57:
        r105.c(r106, r126);
        if (TextUtils.equals(r110.f210560b.f210564a, "nested") == true) goto L74;
        if (r100 == true) goto L74;
        if (TextUtils.equals(r110.f210560b.f210564a, "animator") == false) goto L72;
        if (r110.f210560b.f210565b == false) goto L70;
        r110.f210559a.f210181g.f210220g.setVisibility(8);
        BitableToolbarContainer r107 = r110.f210559a.f210181g.f210223j;
        if (r101 == false) goto L68;
        int r108 = 0;
    L69:
        r107.setVisibility(r108);
        BitableInfoArchManagerNew r109 = r110.f210559a;
        r109.f210185k.f210557e = 0;
        r109.f210181g.f210223j.b(0, 0);
        r110.f210559a.f210181g.f210218e.requestLayout();
        goto L84
    L68:
        r108 = 8;
        goto L69
    L70:
        r110.f210559a.f210181g.f210219f.setExpanded(true, false);
        goto L84
    L72:
        if (r103 == false) goto L84;
        r110.b(0, true);
        r110.f210559a.f210181g.f210220g.setVisibility(0);
        r110.f210559a.f210181g.f210218e.requestLayout();
    L74:
        BitableHeaderContainer r127 = r110.f210559a.f210181g.f210220g;
        if (r100 == true) goto L77;
    L79:
        int r128 = 0;
    L80:
        r127.setVisibility(r128);
        r110.f210559a.f210181g.f210223j.setVisibility(0);
        if (r110.f210560b.f210565b == false) goto L84;
        r110.f210559a.f210181g.f210219f.setExpanded(false, false);
        goto L84
    L77:
        if (r110.f210560b.f210565b == false) goto L79;
        r128 = 8;
        goto L80
    L56:
        r126 = 0.0f;
    L84:
        if (r111 != null) goto L86;
    L95:
        if (r102 == true) goto L105;
        if (r111 == null) goto L100;
        boolean r129 = true;
        if (r111.isFormV1() != true) goto L101;
        boolean r130 = true;
    L102:
        if (r130 == false) goto L104;
        int r131 = com.bytedance.ee.bear.bitable.c.f207079a;
    L107:
        if (Intrinsics.areEqual(r110.f210560b.f210567d, Boolean.valueOf(r210)) == true) goto L109;
    L110:
        r110.f210560b.f210567d = Boolean.valueOf(r210);
        r110.f210560b.f210568e = Boolean.valueOf(r129);
        ViewHolder r132 = r110.f210559a.f210181g;
        Intrinsics.checkNotNullParameter(r132, "viewHolder");
        BitableContentContainer r133 = r132.f210226m;
        ViewGroup.LayoutParams r134 = r133.getLayoutParams();
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r135 = (CoordinatorLayout.LayoutParams) r134;
        if (r210 == false) goto L118;
        if (r129 == false) goto L114;
        CoordinatorLayout.Behavior r136 = new KeepWithinParentBoundsScrollingBehavior();
    L119:
        r135.setBehavior(r136);
        r133.requestLayout();
        return;
    L114:
        int r137 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r138 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.content_container_height_fix_enable") == false) goto L117;
        r133.getLayoutParams().height = -1;
    L117:
        r136 = new AppBarLayout.ScrollingViewBehavior();
        goto L119
    L118:
        r136 = null;
        goto L119
    L109:
        if (Intrinsics.areEqual(r110.f210560b.f210568e, Boolean.valueOf(r129)) == false) goto L110;
        return;
    L104:
        r129 = false;
    L101:
        r130 = false;
        goto L102
    L100:
        r129 = true;
        goto L101
    L105:
        r129 = true;
        goto L107
    L86:
        if (r111.hideToolbar() == false) goto L88;
    L94:
        com.bytedance.ee.bear.bitable.core.infoarch.arch.g.a(r111, r110.f210559a.f210181g.f210223j);
        goto L95
    L88:
        if (TextUtils.equals(r110.f210560b.f210564a, "animator") == false) goto L94;
        if (r110.f210560b.f210565b == false) goto L94;
        if (r111.isKanban() == true) goto L94;
        r110.f210559a.f210181g.f210223j.setVisibility(8);
        goto L95
    L43:
        if (r104.getVisibility() != 0) goto L45;
        r123 = 7;
        goto L46
    L31:
        if (r118.a() != r112) goto L33;
        r120 = true;
        goto L34
    L27:
        r116 = false;
        goto L28
    L21:
        if (r113 == false) goto L23;
        r114 = "animator";
        goto L25
    L23:
        r114 = "none";
        goto L25
    L17:
        r103 = r214;
        goto L18
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
