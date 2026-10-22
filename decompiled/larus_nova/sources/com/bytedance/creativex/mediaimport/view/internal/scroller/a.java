package com.bytedance.creativex.mediaimport.view.internal.scroller;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.creativex.mediaimport.widget.scroller.TouchableFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti4.e;
import ti4.f;
import ti4.g;
import xi4.i;
import xi4.j;
import xi4.k;
import xi4.l;
import xi4.m;
import xi4.n;
import xi4.o;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f204034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f204035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f204036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f204037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f204038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f204039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C2960a f204040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f204041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f204042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f204043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f204044k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewPropertyAnimator f204045l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f204046m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f204047n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f204048o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f204049p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f204050q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f204051r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f204052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final o f204053t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final n f204054u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f204055v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f204056w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final m f204057x;

    /* JADX INFO: renamed from: com.bytedance.creativex.mediaimport.view.internal.scroller.a$a, reason: collision with other inner class name */
    public static class C2960a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f204058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f204059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f204060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f204061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f204062e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f204063f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f204064g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f204065h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f204066i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f204067j;

        public C2960a() {
            this.f204058a = false;
            this.f204059b = 30.0f;
            this.f204060c = 56.0f;
            this.f204061d = 146.0f;
            this.f204062e = 178.0f;
            this.f204063f = 150;
            this.f204064g = 300;
            this.f204065h = 300;
            this.f204066i = 150;
            this.f204067j = 175;
        }
    }

    public final TextView d() {
        TextView r100 = this.f204038e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bubbleView");
        return null;
    }

    public final ViewGroup e() {
        ViewGroup r100 = this.f204037d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("content");
        return null;
    }

    public final View g() {
        View r100 = this.f204039f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("handleView");
        return null;
    }

    @Override // ti4.e
    public final boolean getVisible() {
        return this.f204042i;
    }

    public static final void a(a r100) {
        ValueAnimator r101 = r100.f204043j;
        if (r101 == null) goto L6;
        r101.removeAllListeners();
        r101.removeAllUpdateListeners();
        r100.f204043j = null;
    L6:
        if (r100.f204040g.f204058a == false) goto L8;
        r100.d().setTranslationX(0.0f);
        i(r100.g(), r100.f(r100.f204040g.f204061d));
    L8:
        r100.f204046m = false;
    }

    public static final void b(a r100) {
        ci4.a.a(r100.e(), false);
        if (r100.f204040g.f204058a == true) goto L5;
        ci4.a.b(r100.d(), false);
        i(r100.g(), r100.f(r100.f204040g.f204060c));
    L5:
        r100.f204044k = null;
    }

    public static final void c(a r100) {
        ViewGroup r101 = r100.e();
        r101.setTranslationX(0.0f);
        r101.setAlpha(1.0f);
        if (r100.f204040g.f204058a == false) goto L9;
        ViewPropertyAnimator r102 = r100.f204045l;
        if (r102 == null) goto L7;
        r102.cancel();
    L7:
        r100.f204045l = null;
        TextView r103 = r100.d();
        r103.setTranslationX(0.0f);
        r103.setAlpha(1.0f);
        return;
    }

    public final float f(float r100) {
        return com.ss.android.ugc.tools.utils.i.a(this.f204034a.getContext(), r100);
    }

    public final void h(boolean r100) {
        TextView r101 = d();
        Intrinsics.checkNotNullParameter(r101, "$this$visibleOrInvisible");
        if (r101.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f204047n = true;
        TextView r103 = d();
        r103.setAlpha(0.0f);
        ci4.a.b(r103, true);
        r103.setTranslationX(f(this.f204049p));
        ViewPropertyAnimator r104 = d().animate();
        r104.translationX(0.0f);
        r104.alpha(1.0f);
        r104.setDuration(this.f204040g.f204063f);
        r104.setStartDelay(this.f204040g.f204066i);
        r104.setListener(this.f204055v);
        this.f204045l = r104;
        float r105 = f(this.f204040g.f204060c);
        C2960a r106 = this.f204040g;
        if (r100 == false) goto L11;
        float r107 = r106.f204062e;
    L12:
        float r108 = f(r107);
        if (r100 == false) goto L15;
        long r109 = this.f204040g.f204064g;
    L16:
        ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{r105, r108});
        r110.setDuration(r109);
        r110.setEvaluator(this.f204057x);
        r110.addListener(this.f204053t);
        r110.start();
        this.f204043j = r110;
        return;
    L15:
        r109 = this.f204040g.f204063f;
        goto L16
    L11:
        r107 = r106.f204061d;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    @Override // ti4.e
    public final void setVisible(boolean r100) {
        this.f204042i = r100;
        if (r100 == false) goto L11;
        ViewGroup r101 = e();
        r101.setAlpha(0.0f);
        ci4.a.a(r101, true);
        r101.setTranslationX(f(this.f204050q));
        ViewPropertyAnimator r102 = e().animate();
        r102.translationX(0.0f);
        r102.alpha(1.0f);
        r102.setDuration(this.f204040g.f204064g);
        r102.setListener(this.f204051r);
        this.f204044k = r102;
        C2960a r103 = this.f204040g;
        if (r103.f204058a == true) goto L7;
        return;
    L7:
        if (d().getWidth() != 0) goto L9;
    L10:
        float r104 = r103.f204061d - r103.f204059b;
        i(d(), f(r104));
        h(false);
        return;
    L9:
        if (g().getWidth() == 0) goto L10;
        return;
    L11:
        C2960a r105 = this.f204040g;
        if (r105.f204058a == false) goto L14;
        long r106 = r105.f204066i;
    L15:
        ViewPropertyAnimator r107 = e().animate();
        r107.translationX(f(this.f204050q));
        r107.alpha(0.0f);
        r107.setDuration(this.f204040g.f204065h);
        r107.setStartDelay(r106);
        r107.setListener(this.f204052s);
        this.f204044k = r107;
        if (this.f204040g.f204058a == false) goto L22;
        ViewPropertyAnimator r108 = d().animate();
        r108.translationX(f(this.f204049p));
        r108.alpha(0.0f);
        r108.setDuration(this.f204040g.f204063f);
        return;
    L22:
        return;
    L14:
        r106 = 0;
        goto L15
    }

    public static void i(View r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.width = (int) r101;
        r100.setLayoutParams(r102);
    }

    public a(TouchableFrameLayout r100, b r101, g r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "listScroller");
        Intrinsics.checkNotNullParameter(r102, "sectionIndexer");
        this.f204034a = r100;
        this.f204035b = r101;
        this.f204036c = r102;
        C2960a r104 = new C2960a();
        this.f204040g = r104;
        Context r105 = r100.getContext();
        int r106 = com.ss.android.ugc.tools.utils.i.f454862a;
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r107 = true;
        if (r105.getResources().getConfiguration().getLayoutDirection() == 1) goto L6;
        r107 = false;
    L6:
        this.f204041h = r107;
        if (r103 == null) goto L9;
        r103.invoke(r104);
    L9:
        float r108 = 20.0f;
        if (r107 == false) goto L12;
        r108 = -20.0f;
    L12:
        this.f204049p = r108;
        float r109 = 56.0f;
        if (r107 == false) goto L15;
        r109 = -56.0f;
    L15:
        this.f204050q = r109;
        this.f204051r = new l(this);
        this.f204052s = new k(this);
        this.f204053t = new o(this);
        this.f204054u = new n(this);
        this.f204055v = new j(this);
        this.f204056w = new i(this);
        this.f204057x = new m(this);
    }
}
