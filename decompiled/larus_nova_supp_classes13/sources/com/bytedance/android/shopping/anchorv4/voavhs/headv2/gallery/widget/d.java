package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.State;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends LinearLayout {
    public static final int x = 0;
    public static final String y = null;
    public final Paint a;
    public final RectF b;
    public boolean c;
    public boolean d;
    public final ImageView e;
    public final TextView f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final ValueAnimator k;
    public final ValueAnimator l;
    public final ValueAnimator m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final Interpolator q;
    public final int r;
    public final int s;
    public final int t;
    public Float u;
    public final e v;
    public final f w;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {
        public final /* synthetic */ d c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r3) {
            f r0 = this.c.w;
            int r1 = d.x;
            return r0.wW(d.y, Integer.valueOf(r3));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final void b(RectF r8) {
            boolean r0 = false;
            if (r8 == null) goto L8;
            d r2 = this.c;
            r2.c = true;
            int r3 = r2.getChildCount();
            int r4 = 0;
        L5:
            if (r4 >= r3) goto L7;
            r2.getChildAt(r4).setAlpha(1.0f);
            r4 = r4 + 1;
            goto L5
        L7:
            this.c.invalidate();
        L8:
            if (r8 != null) goto L10;
            return;
        L10:
            if (r8.height() <= 0) goto L12;
            r0 = true;
        L12:
            if (r0 == true) goto L15;
            r8 = null;
        L15:
            if (r8 == null) goto L23;
            float r9 = r8.bottom;
            float r1 = d.x;
            float r10 = Float.valueOf((r9 - r1) - com.bytedance.android.shopping.extensions.b.a(12)).floatValue();
            d r5 = this.c;
            if (r5.o == false) goto L19;
            r5.setTranslationY((r10 + r1) - r5.j);
            return;
        L19:
            r5.setTranslationY(r10);
            this.c.u = Float.valueOf(r10);
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final void d(boolean r4) {
            dm.a.a("-----xias").b("isShow: " + r4, null);
            if (r4 == false) goto L14;
            d r5 = this.c;
            if (r5.n == true) goto L12;
            if (r5.p == true) goto L28;
            r5.p = true;
            if (r5.w.ey(m.o) == true) goto L29;
            d r6 = this.c;
            e r0 = r6.v;
            int r1 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a;
            r6.postDelayed(r0, 2000);
            return;
        L29:
            return;
        L28:
            return;
        L12:
            if (r5.o == true) goto L31;
            r5.b();
            return;
        L31:
            return;
        L14:
            ValueAnimator r7 = this.c.k;
            if (r7 == null) goto L17;
            r7.cancel();
        L17:
            ValueAnimator r8 = this.c.l;
            if (r8 == null) goto L20;
            r8.cancel();
        L20:
            ValueAnimator r9 = this.c.m;
            if (r9 == null) goto L23;
            r9.cancel();
        L23:
            d r10 = this.c;
            if (r10 == null) goto L26;
            r10.removeCallbacks(r10.v);
        L26:
            this.c.b();
        }

        public b(d r1, View r2, m0 r3) {
            this.c = r1;
            super(r2, r3);
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Function1 r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.invoke((Float) r3);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d$d, reason: collision with other inner class name */
    public static final class C0013d implements Animator.AnimatorListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ Function0 b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.b();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.invoke();
        }

        public C0013d(d r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        x = com.bytedance.android.shopping.extensions.b.a(34);
        y = "bottom_left_find_same";
    }

    public final void b() {
        int r0 = com.bytedance.android.shopping.extensions.b.a(12);
        ImageView r1 = this.e;
        if (r1 == null) goto L15;
        if (r1 == null) goto L6;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L7:
        if (r2 == null) goto L9;
        r2.width = r0;
    L9:
        if (r2 == null) goto L11;
        r2.height = r0;
    L11:
        if (r2 == null) goto L15;
        ImageView r3 = this.e;
        if (r3 == null) goto L15;
        r3.setLayoutParams(r2);
        goto L15
    L6:
        r2 = null;
    L15:
        TextView r4 = this.f;
        if (r4 == null) goto L18;
        r4.setText("找同款");
    L18:
        TextView r5 = this.f;
        if (r5 == null) goto L21;
        r5.setTextSize(1, 10.0f);
    L21:
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L24;
        r6.width = this.h;
    L24:
        if (r6 == null) goto L26;
        r6.height = this.j;
    L26:
        if (r6 == null) goto L28;
        setLayoutParams(r6);
    L28:
        int r7 = this.s;
        setPadding(r7, 0, r7, 0);
        Float r8 = this.u;
        if (r8 == null) goto L31;
        setTranslationY((r8.floatValue() + x) - this.j);
    L31:
        this.o = true;
        this.w.gD(State.SHOW);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b getLayerItem() {
        return new b(this, this, new m0(true, true, true, 1, false, 48));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.v);
        ValueAnimator r0 = this.k;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.l;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ValueAnimator r2 = this.m;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        super.onDetachedFromWindow();
    }

    public final boolean getBubbleIsShown() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        if (this.c == false) goto L5;
        this.a.setColor(1461065763);
        float r0 = getHeight() / 2.0f;
        float r1 = q.a(Double.valueOf(0.5d));
        this.a.setStyle(Paint.Style.FILL);
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.inset(r1, r1);
        r7.drawRoundRect(this.b, r0, r0, this.a);
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.a.setStrokeWidth(r1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(536870911);
        r7.drawRoundRect(this.b, r0, r0, this.a);
    L5:
        super.dispatchDraw(r7);
    }

    public final void setBubbleIsShown(boolean r1) {
        this.d = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        if (r3 != 0) goto L6;
        f r0 = this.w;
        int r1 = m.n;
        if (r0.ey(m.o) == false) goto L6;
        b();
    L6:
        super.setVisibility(r3);
    }

    public d(FragmentActivity r11, f r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        super(r11);
        this.w = r12;
        Paint r13 = new Paint(1);
        r13.setColor(1461065763);
        r13.setStyle(Paint.Style.FILL);
        Unit r1 = Unit.INSTANCE;
        this.a = r13;
        this.b = new RectF();
        int r14 = com.bytedance.android.shopping.extensions.b.a(153);
        int r2 = com.bytedance.android.shopping.extensions.b.a(46);
        this.g = r2;
        int r3 = com.bytedance.android.shopping.extensions.b.a(32);
        int r4 = com.bytedance.android.shopping.extensions.b.a(64);
        this.h = r4;
        this.i = com.bytedance.android.shopping.extensions.b.a(34);
        this.j = com.bytedance.android.shopping.extensions.b.a(20);
        int r6 = 0;
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r14, r2});
        this.k = r15;
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.l = r5;
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r3, r4});
        this.m = r7;
        float r8 = 0.0f;
        this.q = new PathInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        int r9 = com.bytedance.android.shopping.extensions.b.a(14);
        this.r = r9;
        this.s = com.bytedance.android.shopping.extensions.b.a(10);
        int r10 = com.bytedance.android.shopping.extensions.b.a(18);
        this.t = r10;
        setOrientation(0);
        setGravity(17);
        setPadding(r9, 0, r9, 0);
        ImageView r16 = new ImageView(r11);
        this.e = r16;
        r16.setImageResource(2131231266);
        addView(r16, new LinearLayout.LayoutParams(r10, r10));
        TextView r17 = new TextView(r11);
        this.f = r17;
        r17.setText("找图片同款商品");
        r17.setTextColor(-1);
        r17.setSingleLine();
        r17.setTextSize(1, 15.0f);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.leftMargin = com.bytedance.android.shopping.extensions.b.a(2);
        addView(r17, r18);
        a(r15, new FindSimilarLayoutV2$4(this), new FindSimilarLayoutV2$5(this));
        a(r5, new FindSimilarLayoutV2$6(this), new FindSimilarLayoutV2$7(this));
        a(r7, new FindSimilarLayoutV2$8(this), new FindSimilarLayoutV2$9(this));
        if (this.c == false) goto L5;
        r8 = 1.0f;
    L5:
        int r19 = getChildCount();
    L6:
        if (r6 >= r19) goto L8;
        getChildAt(r6).setAlpha(r8);
        r6 = r6 + 1;
        goto L6
    L8:
        this.v = new e(this);
    }

    public final void a(ValueAnimator r3, Function1<? super Float, Unit> r4, Function0<Unit> r5) {
        if (r3 == null) goto L4;
        r3.setDuration(260);
    L4:
        if (r3 == null) goto L6;
        r3.setInterpolator(this.q);
    L6:
        if (r3 == null) goto L8;
        r3.addUpdateListener(new c(r4));
    L8:
        if (r3 == null) goto L11;
        r3.addListener(new C0013d(this, r5));
        return;
    }
}
