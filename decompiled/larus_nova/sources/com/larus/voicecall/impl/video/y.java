package com.larus.voicecall.impl.video;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.voicecall.impl.component.vlm.b1;
import com.larus.voicecall.impl.component.vlm.d1;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f379625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f379626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f379627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Float> f379628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Float> f379629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f379630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewPortContainerView f379631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f379632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f379633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f379634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f379635k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f379636l;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f379637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f379638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f379639c;

        public b(y r100, ViewGroup r101, ViewGroup r102) {
            this.f379637a = r100;
            this.f379638b = r101;
            this.f379639c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            Pair r109 = y.a(this.f379637a, this.f379638b, this.f379639c);
            if (r109 == null) goto L7;
            b0 r110 = (b0) r109.component1();
            h r111 = (h) r109.component2();
            y r112 = this.f379637a;
            r112.f379631g = r110.f379587c;
            r112.f379632h = r111;
            r112.c(r110, true, null, new c(r110));
            return;
        }
    }

    public static final class c implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f379640a;

        public c(b0 r100) {
            this.f379640a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            e1.q(this.f379640a.f379587c.f379573a);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    private final Context getContext() {
        return this.f379625a.getContext();
    }

    public final void f() {
        ViewPortContainerView r100 = this.f379631g;
        h r101 = this.f379632h;
        boolean r102 = true;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        int[] r103 = {(int) ((r101.f379608a - (r101.f379609b / (this.f379626b.getHeight() / this.f379626b.getWidth()))) / 2), 0};
        Unit r104 = Unit.INSTANCE;
        final b0 r105 = new b0(1.0f, r103, r100, 1.0f, 0.0f);
        e1.q(r105.f379587c.f379573a);
        c(r105, false, new v(r105), new w(this));
        return;
    L8:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("invalid state, viewPortContainer is null ? (");
        if (r100 == null) goto L12;
        r102 = false;
    L12:
        r107.append(r102);
        r107.append("), originParams: ");
        r107.append(r101);
        r106.e("ViewPortSwitcher", r107.toString());
    }

    public final void g() {
        ViewGroup r100 = b(this.f379625a);
        if (r100 != null) goto L6;
        FLogger.f375446a.e("ViewPortSwitcher", "content view must in the view tree");
        return;
    L6:
        ViewParent r101 = this.f379625a.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r102 = (ViewGroup) r101;
        e1.x(this.f379626b);
        float r103 = this.f379626b.getX() + (this.f379626b.getWidth() / 2);
        int r104 = m0.f375450a;
        int r105 = m0.b(getContext());
        if (r103 > (r105 / 2)) goto L9;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L17;
        View r107 = this.f379626b;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L16;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        int r110 = this.f379636l;
        r109.leftMargin = r110;
        r109.setMarginStart(r110);
        r107.setLayoutParams(r109);
    L20:
        View r111 = this.f379626b;
        if (r111.isLaidOut() == true) goto L23;
    L28:
        r111.addOnLayoutChangeListener(new b(this, r100, r102));
        return;
    L23:
        if (r111.isLayoutRequested() == true) goto L28;
        Pair r112 = a(this, r100, r102);
        if (r112 == null) goto L33;
        b0 r113 = (b0) r112.component1();
        h r114 = (h) r112.component2();
        this.f379631g = r113.f379587c;
        this.f379632h = r114;
        c(r113, true, null, new c(r113));
        return;
    L33:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        View r115 = this.f379626b;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L31;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        r117.leftMargin = (r105 - this.f379626b.getWidth()) - this.f379636l;
        r115.setLayoutParams(r117);
        goto L20
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        r106 = false;
        goto L11
    }

    public static ViewGroup b(View r100) {
        if (r100.getId() == 16908290) goto L5;
    L8:
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == true) goto L11;
        return null;
    L11:
        return b((View) r101);
    L5:
        if ((r100 instanceof FrameLayout) == false) goto L8;
        return (ViewGroup) r100;
    }

    public static void d(View r100) {
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L9;
        r102.removeView(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void e(ViewPortContainerView r100) {
        Function0<Float> r101 = this.f379628d;
        float r102 = -1.0f;
        if (r101 == null) goto L5;
        float r103 = r101.invoke().floatValue();
    L6:
        Function0<Float> r104 = this.f379629e;
        if (r104 == null) goto L10;
        r102 = r104.invoke().floatValue();
    L10:
        if (r103 >= 0.0f) goto L12;
        return;
    L12:
        if (r102 > 0.0f) goto L14;
        return;
    L14:
        if (r102 <= r103) goto L19;
        e r105 = r100.f379576d;
        r105.getClass();
        r105.f379606o = Math.max(r103, 0.0f);
        int r106 = m0.f375450a;
        r105.f379607p = Math.max(0.0f, Math.min(r102, m0.a(r105.f379592a.getContext())));
        FLogger.f375446a.d("DragFloatingEffect", "setDragLimit, topLmt = " + r105.f379606o + ", bottomLmt = " + r105.f379607p);
        return;
    L19:
        return;
    L5:
        r103 = -1.0f;
        goto L6
    }

    public static final Pair a(final y r110, ViewGroup r111, ViewGroup r210) {
        int[] r100 = new int[2];
        r110.f379625a.getLocationOnScreen(r100);
        int[] r101 = new int[2];
        r110.f379626b.getLocationOnScreen(r101);
        final ViewPortContainerView r102 = new ViewPortContainerView(r110.getContext(), null, 6, 0);
        r102.setUpdateLimitCallBack(new x(r110, r102));
        r102.f379576d.f379601j = r110.f379634j;
        r110.e(r102);
        r102.setDragListener(new a0(r110));
        int r103 = r110.f379626b.getWidth();
        int r104 = r110.f379626b.getHeight();
        if (r103 == 0) goto L17;
        if (r104 == 0) goto L17;
        float r105 = r104;
        int r112 = r110.f379625a.getWidth();
        int r113 = r110.f379625a.getHeight();
        float r114 = r113;
        int r106 = (int) (r114 / (r105 / r103));
        int r115 = (int) r114;
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(r106, r115);
        FLogger.f375446a.d("ViewPortSwitcher", "targetHeight: " + r104 + ", targetWidth: " + r103 + ", contentOriginWidth: " + r112 + ", contentOriginHeight: " + r113 + ", viewPortContainerWidth: " + r106 + ", viewPortContainerHeight: " + r115);
        d(r110.f379625a);
        View r107 = r110.f379625a;
        int r108 = -1;
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r107, "view");
        Intrinsics.checkNotNullParameter(r109, "params");
        r102.f379574b.addView(r107, r109);
        if (r110.f379627c == false) goto L15;
        List r117 = SequencesKt.toList(ViewGroupKt.getChildren(r111));
        ListIterator r118 = r117.listIterator(r117.size());
    L10:
        if (r118.hasPrevious() == false) goto L14;
        if ((((View) r118.previous()) instanceof ViewPortContainerView) == false) goto L10;
        r108 = r118.nextIndex();
    L14:
        r111.addView(r102, r108, r116);
    L16:
        e1.q(r102.f379573a);
        return TuplesKt.to(new b0(r105 / r114, r101, r102, 0.0f, 1.0f), new h(r112, r113, r100, r210));
    L15:
        r111.addView(r102, r116);
    L17:
        FLogger.f375446a.e("ViewPortSwitcher", "place holder view must has positive width: " + r103 + ", height: " + r104);
        return null;
    }

    public y(View r100, View r101, b1 r102, d1 r103) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "placeHolder");
        this.f379625a = r100;
        this.f379626b = r101;
        this.f379627c = true;
        this.f379628d = r102;
        this.f379629e = r103;
        this.f379630f = new o();
        this.f379634j = true;
        this.f379635k = true;
        this.f379636l = i5.j0();
    }

    public final void c(b0 r210, boolean r211, Function0<Unit> r212, Function0<Unit> r213) {
        int[] r100 = r210.f379586b;
        ViewPortContainerView r110 = r210.f379587c;
        float r111 = r210.f379585a;
        float r112 = r100[1];
        float r113 = r100[0];
        float r101 = 0.0f;
        r110.setPivotX(0.0f);
        r110.setPivotY(0.0f);
        FLogger.f375446a.d("ViewPortSwitcher", "target scale: " + r111 + ", targetTransX = " + r113 + ", targetTransY: " + r112 + ", enableZoomAnimate: " + this.f379635k);
        if (this.f379635k == true) goto L10;
        if (r212 == null) goto L6;
        r212.invoke();
    L6:
        r110.setScaleX(r111);
        r110.setScaleY(r111);
        r110.setTranslationX(r113);
        r110.setTranslationY(r112);
        if (r213 == null) goto L29;
        r213.invoke();
        return;
    L29:
        return;
    L10:
        View r102 = (View) SequencesKt.firstOrNull(ViewGroupKt.getChildren(r110));
        if (r102 == null) goto L20;
        o r103 = this.f379630f;
        if (r211 == false) goto L15;
        float r104 = 1.0f;
    L16:
        if (r211 == true) goto L19;
        r101 = 1.0f;
    L19:
        CubicBezierInterpolator r105 = com.larus.voicecall.impl.video.c.f379590a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "view");
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r102, "alpha", new float[]{r104, r101});
        r106.setDuration(50);
        r106.setInterpolator(r105);
        r106.addListener(new z(this, r211, r110, r111, r113, r112, r213, r110, r111, r113, r112, r211, r110, r111, r113, r112, r212));
        ObjectAnimator r107 = r106;
    L21:
        o r108 = this.f379630f;
        float r109 = r210.f379588d;
        float r114 = r210.f379589e;
        CubicBezierInterpolator r115 = com.larus.voicecall.impl.video.c.f379590a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r110, "view");
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{r109, r114});
        r116.setDuration(150);
        r116.setInterpolator(r115);
        AnimatorSet r117 = new AnimatorSet();
        if (r107 == null) goto L26;
        if (r211 == false) goto L25;
        r117.play(r116).after(r107);
    L27:
        r117.start();
        return;
    L25:
        r117.play(r107).after(r116);
        goto L27
    L26:
        r117.play(r116);
        goto L27
    L15:
        r104 = 0.0f;
        goto L16
    L20:
        r107 = null;
        goto L21
    }
}
