package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class InputPanelDragController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f299021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f299022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f299023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f299024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Integer> f299025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f299026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f299027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f299028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f299029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f299030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f299031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f299032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f299033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f299034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f299035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f299036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f299037q;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelDragController$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function2<Float, Boolean, Unit> {
        public AnonymousClass8(Object r100) {
            super(2, r100, InputPanelDragController.class, "finishDrag", "finishDrag(FZ)V", 0);
        }

        public final void invoke(float r100, boolean r101) {
            InputPanelDragController r102 = (InputPanelDragController) this.receiver;
            r102.f299031k = false;
            int r103 = r102.e();
            int r104 = r102.f();
            if (r102.f299029i == false) goto L11;
            if (r101 == true) goto L11;
            if (r103 < (r104 - c7.b(48))) goto L10;
            if (r103 >= r104) goto L11;
            if (r100 <= c7.b(1000)) goto L11;
        L10:
            boolean r105 = true;
        L12:
            int r106 = ((r102.d() - r104) / 2) + r104;
            if (r105 == false) goto L15;
            int r107 = 0;
        L32:
            if (r105 == false) goto L34;
            Integer r108 = null;
        L35:
            r102.f299030j = r108;
            r102.a(r107, r105, 180, new DecelerateInterpolator());
            return;
        L34:
            r108 = Integer.valueOf(r107);
            goto L35
        L15:
            if (r101 == false) goto L20;
            if (r102.f299032l < r106) goto L31;
            int r109 = r102.d();
        L30:
            r107 = r109;
        L31:
            r107 = r104;
            goto L32
        L20:
            if (r102.f299029i == false) goto L23;
            r109 = r102.d();
            goto L30
        L23:
            if (r100 >= (-c7.b(1000))) goto L26;
            r109 = r102.d();
            goto L30
        L26:
            if (r100 > c7.b(1000)) goto L31;
            if (r103 < r106) goto L31;
            r109 = r102.d();
        L11:
            r105 = false;
            goto L12
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Float r100, Boolean r101) {
            invoke(r100.floatValue(), r101.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputPanelDragController f299038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f299039b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            InputPanelDragController r101 = this.f299038a;
            r101.f299034n = null;
            r101.f299035o = null;
            r101.f299036p = false;
            if (this.f299039b == false) goto L6;
            r101.f299024d.invoke();
            return;
        }

        public a(InputPanelDragController r100, boolean r101) {
            this.f299038a = r100;
            this.f299039b = r101;
        }
    }

    public final void c() {
        ValueAnimator r100 = this.f299034n;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        ValueAnimator r101 = this.f299034n;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f299034n = null;
        this.f299035o = null;
        this.f299036p = false;
    }

    public final int d() {
        return Math.min(this.f299027g, RangesKt.coerceAtLeast(this.f299023c.invoke().intValue(), 0));
    }

    public final int e() {
        return RangesKt.coerceAtLeast(this.f299021a.getLayoutParams().height, 0);
    }

    public final int f() {
        if (this.f299029i == false) goto L6;
        return d();
    L6:
        return Math.min(this.f299028h, d());
    }

    public final int h() {
        Integer r100 = this.f299025e.invoke();
        if (r100 != null) goto L5;
        Integer r101 = this.f299030j;
        if (r101 == null) goto L9;
        int r102 = r101.intValue();
    L11:
        return RangesKt.coerceIn(r102, f(), d());
    L9:
        r102 = f();
        goto L11
    L5:
        return RangesKt.coerceIn(r100.intValue(), 0, d());
    }

    public final void b(int r100) {
        ViewGroup.LayoutParams r101 = this.f299021a.getLayoutParams();
        if (r101.height == r100) goto L6;
        r101.height = r100;
        this.f299021a.setLayoutParams(r101);
        return;
    }

    public final void g(boolean r100) {
        if (this.f299036p == false) goto L5;
        return;
    L5:
        if (this.f299031k == true) goto L33;
        int r101 = h();
        ValueAnimator r102 = this.f299034n;
        boolean r103 = false;
        if (r102 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L20;
        Integer r105 = this.f299035o;
        if (r105 == null) goto L20;
        if (r105.intValue() != r101) goto L20;
        return;
    L20:
        c();
        this.f299037q.setTranslationY(0.0f);
        if (r100 == true) goto L23;
    L29:
        b(r101);
        return;
    L23:
        if (this.f299021a.getVisibility() != 0) goto L25;
        r103 = true;
    L25:
        if (r103 == false) goto L29;
        if (r101 >= e()) goto L29;
        a(r101, false, 250, PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        return;
    L10:
        if (r102.isRunning() != true) goto L12;
        r104 = true;
        goto L13
    }

    public final void i(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        int r101 = 0;
        if (r100 == true) goto L12;
        n r102 = this.f299021a;
        if (r102.f299083k == false) goto L11;
        r102.a(true);
    L11:
        r102.b();
        c();
        this.f299031k = false;
        this.f299030j = null;
        this.f299037q.setTranslationY(0.0f);
    L12:
        n r103 = this.f299021a;
        if (r100 == true) goto L16;
        r101 = 8;
    L16:
        r103.setVisibility(r101);
        return;
    L4:
        if (this.f299036p == false) goto L6;
    }

    public final void j(int r100, int r101, boolean r102) {
        if (this.f299036p == false) goto L5;
        return;
    L5:
        Integer r103 = Integer.valueOf(r100);
        boolean r104 = false;
        if (r103.intValue() <= 0) goto L8;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L38;
        int r106 = r103.intValue();
        Integer r107 = Integer.valueOf(r101);
        if (r107.intValue() <= 0) goto L17;
        r104 = true;
    L17:
        if (r104 == true) goto L20;
        r107 = null;
    L20:
        if (r107 == null) goto L22;
        int r108 = RangesKt.coerceAtMost(r107.intValue(), r106);
    L24:
        if (this.f299027g == r106) goto L26;
    L30:
        n r109 = this.f299021a;
        if (r109.f299083k == false) goto L33;
        r109.a(true);
    L33:
        r109.b();
        c();
        this.f299027g = r106;
        this.f299028h = r108;
        if (this.f299029i == r102) goto L36;
        this.f299030j = null;
    L36:
        this.f299029i = r102;
        this.f299037q.setTranslationY(0.0f);
        b(h());
        return;
    L26:
        if (this.f299028h != r108) goto L30;
        if (this.f299029i != r102) goto L30;
        return;
    L22:
        r108 = r106;
        goto L24
    L38:
        return;
    L8:
        r105 = false;
        goto L10
    }

    public final void a(final int r100, boolean r101, long r102, Interpolator r103) {
        c();
        this.f299036p = r101;
        this.f299035o = Integer.valueOf(r100);
        final float r104 = this.f299037q.getTranslationY();
        final int r105 = e();
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r106.setDuration(r102);
        r106.setInterpolator(r103);
        r106.addUpdateListener(new b(this, r105, r100, r104));
        r106.addListener(new a(this, r101));
        r106.start();
        this.f299034n = r106;
    }

    public InputPanelDragController(n r100, RecyclerView r101, Function0<Integer> r102, Function0<Unit> r103, Function0<Integer> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "list");
        Intrinsics.checkNotNullParameter(r102, "contentHeightPx");
        Intrinsics.checkNotNullParameter(r103, "onClose");
        Intrinsics.checkNotNullParameter(r104, "lockedHeightPx");
        Intrinsics.checkNotNullParameter(r105, "onDragStart");
        this.f299021a = r100;
        this.f299022b = r101;
        this.f299023c = r102;
        this.f299024d = r103;
        this.f299025e = r104;
        this.f299026f = r105;
        Context r106 = r100.getContext();
        int r107 = c7.b(360);
        this.f299027g = r107;
        this.f299028h = r107;
        View r108 = new View(r106);
        r108.setImportantForAccessibility(2);
        GradientDrawable r109 = new GradientDrawable();
        r109.setCornerRadius(c7.b(2));
        r109.setColor(ContextCompat.getColor(r108.getContext(), v19.c.b(R.attr.larus_neutral_transparent_2, r108.getContext(), R.color.larus_neutral_transparent_2)));
        r108.setBackground(r109);
        this.f299037q = r108;
        r100.setClickable(true);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(c7.b(36), c7.b(4));
        r110.gravity = 49;
        r110.topMargin = c7.b(8);
        Unit r111 = Unit.INSTANCE;
        r100.addView(r108, r110);
        r100.setHandleHit(new d(this));
        r100.setCanDrag(new e(this));
        r100.setOnDragStart(new f(this));
        r100.setOnDragBy(new g(this));
        r100.setOnDragEnd(new AnonymousClass8(this));
    }
}
