package com.obric.oui.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.bouncelayout.OHorizontalScrollView;
import com.obric.oui.color.h0;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.p;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends OHorizontalScrollView implements ValueAnimator.AnimatorUpdateListener, com.obric.oui.material.g {
    public static final FastOutSlowInInterpolator I2 = null;
    public static final Pools.SynchronizedPool J2 = null;
    public int A;
    public int B;
    public int C;
    public ColorStateList D;
    public float E;
    public final Pools.SimplePool E2;
    public final float F;
    public final int F2;
    public int G;
    public int G1;
    public Typeface G2;
    public int H;
    public boolean H0;
    public boolean H1;
    public Typeface H2;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f403132J;
    public int K;
    public final int L;
    public int L0;
    public boolean L1;
    public int M;
    public final boolean M1;
    public int N;
    public int O;
    public boolean P;
    public int P0;
    public final String P1;
    public e Q;
    public final com.obric.oui.material.c[] Q1;
    public final ArrayList<e> R;
    public k S;
    public final com.obric.oui.material.c[] S1;
    public ValueAnimator T;
    public final List<q> T1;
    public ViewPager U;
    public PagerAdapter V;
    public final Drawable V0;
    public boolean V1;
    public f W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public float f403133b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final Rect f403134b2;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final float f403135g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public final Paint f403136g2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public float f403137h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public final pma.b f403138h2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public TabLayoutOnPageChangeListener f403139k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final Paint f403140k1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<i> f403141n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i f403142o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i f403143p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public b f403144p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final Paint f403145p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final ValueAnimator f403146p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f403147q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WeakReference<View> f403148r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f403149s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h f403150t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f403151u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f403152v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final RectF f403153v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final PathInterpolator f403154v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f403155w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f403156x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final RectF f403157x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public final c f403158x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f403159y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final RectF f403160y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public final c f403161y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f403162z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<OTabLayoutBase> f403163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f403164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f403165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f403166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f403167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArgbEvaluator f403168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AccelerateInterpolator f403169g;

        public TabLayoutOnPageChangeListener(OTabLayoutBase r100) {
            this.f403168f = new ArgbEvaluator();
            this.f403169g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f403163a = new WeakReference(r100);
            this.f403167e = r100.getTabTextColors().getColorForState(OTabLayoutBase.g(), 0);
            this.f403166d = r100.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f403164b = this.f403165c;
            this.f403165c = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            OTabLayoutBase r101 = this.f403163a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getSelectedTabPosition() != r100) goto L7;
            return;
        L7:
            if (r100 >= r101.getTabCount()) goto L27;
            int r102 = this.f403165c;
            if (r102 != 0) goto L11;
        L16:
            boolean r103 = true;
        L17:
            if (r100 >= 0) goto L19;
        L22:
            i r104 = null;
        L23:
            r101.w(r104, r103);
            return;
        L19:
            if (r100 >= r101.getTabCount()) goto L22;
            r104 = (i) ListProtector.get(r101.f403141n, r100);
            goto L23
        L11:
            if (r102 == 2) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (this.f403164b != 0) goto L15;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r110, float r111, int r112) {
            OTabLayoutBase r113 = this.f403163a.get();
            if (r113 == null) goto L41;
            int r100 = this.f403165c;
            if (r100 == 2) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r100 == 2) goto L13;
        L16:
            boolean r102 = true;
        L17:
            r113.y(r110, r111, r101, r102);
            if (this.f403165c == 2) goto L20;
        L22:
            h r114 = r113.f403150t;
            r114.f403187s = true;
            View r115 = r114.getChildAt(r114.f403178j);
            h r103 = r113.f403150t;
            View r104 = r103.getChildAt(r103.f403178j + 1);
            if (r115 == null) goto L39;
            if (r104 == null) goto L39;
            View r105 = r115.findViewById(R.id.layout_tab_indicator);
            View r106 = r104.findViewById(R.id.layout_tab_indicator);
            if (r105 == null) goto L39;
            if (r106 == null) goto L39;
            float r116 = r115.getLeft() + ((r115.getWidth() - r105.getWidth()) / 2);
            float r107 = r105.getWidth() + r116;
            float r108 = r104.getLeft() + ((r104.getWidth() - r106.getWidth()) / 2);
            float r109 = r106.getWidth() + r108;
            ImageView r117 = (ImageView) r105.findViewById(R.id.tab_item_img);
            TextView r118 = (TextView) r105.findViewById(R.id.tab_item_text);
            ImageView r119 = (ImageView) r106.findViewById(R.id.tab_item_img);
            TextView r120 = (TextView) r106.findViewById(R.id.tab_item_text);
            int r121 = ((Integer) this.f403168f.evaluate(r111, Integer.valueOf(this.f403167e), Integer.valueOf(this.f403166d))).intValue();
            if (r117 == null) goto L33;
            if (r118 == null) goto L33;
            r118.setTextColor(r121);
            r117.setImageAlpha(Color.alpha(r121));
        L33:
            int r122 = ((Integer) this.f403168f.evaluate(r111, Integer.valueOf(this.f403166d), Integer.valueOf(this.f403167e))).intValue();
            if (r119 == null) goto L38;
            if (r120 == null) goto L38;
            r120.setTextColor(r122);
            r119.setImageAlpha(Color.alpha(r122));
        L38:
            r113.f403150t.f403185q = r116 + ((r108 - r116) * this.f403169g.getInterpolation(r111));
            r113.f403150t.f403186r = r107 + ((r109 - r107) * this.f403169g.getInterpolation(r111));
        L39:
            ViewCompat.postInvalidateOnAnimation(r113.f403150t);
            return;
        L20:
            if (this.f403164b != 0) goto L22;
            r113.f403150t.f403187s = false;
            goto L39
        L13:
            if (this.f403164b != 0) goto L16;
            r102 = false;
            goto L17
        L7:
            if (this.f403164b == 1) goto L10;
            r101 = false;
            goto L11
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            throw null;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            throw null;
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f403170a;

        public a(OTabLayoutBase r100) {
            this.f403170a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f403170a.scrollTo(((Integer) r100.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f403171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f403172b;

        public b(OTabLayoutBase r100) {
            this.f403172b = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            OTabLayoutBase r103 = this.f403172b;
            if (r103.U != r100) goto L6;
            r103.x(r102, this.f403171a);
            return;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f403173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f403174b;

        public final String toString() {
            return "(left = " + this.f403173a + ", right = " + this.f403174b + ")";
        }

        public c() {
            this.f403173a = 0.0f;
            this.f403174b = 0.0f;
        }
    }

    public interface d {
    }

    public interface e {
        void a(i r100);

        void b(i r100);

        void c(i r100);
    }

    public class f extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f403175a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f403175a.t();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f403175a.t();
        }

        public f(OTabLayoutBase r100) {
            this.f403175a = r100;
        }
    }

    public class g implements TypeEvaluator<c> {
        public g(OTabLayoutBase r100) {
        }

        @Override // android.animation.TypeEvaluator
        public final c evaluate(float r100, c r101, c r102) {
            c r103 = r101;
            c r104 = r102;
            float r105 = r103.f403173a;
            float r106 = r105 + ((r104.f403173a - r105) * r100);
            float r107 = r103.f403174b;
            float r108 = r107 + (r100 * (r104.f403174b - r107));
            c r109 = new c();
            r109.f403173a = r106;
            r109.f403174b = r108;
            return r109;
        }
    }

    public class h extends OUILinearLayout {
        public final /* synthetic */ OTabLayoutBase A;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f403176h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Paint f403177i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f403178j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f403179k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f403180l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f403181m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f403182n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ValueAnimator f403183o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f403184p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f403185q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f403186r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f403187s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f403188t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f403189u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f403190v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Paint f403191w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Paint f403192x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final float f403193y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f403194z;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f403195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f403196b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f403197c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f403198d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ h f403199e;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                float r101 = r100.getAnimatedFraction();
                h r102 = this.f403199e;
                int r103 = this.f403195a;
                int r104 = this.f403196b;
                r102.getClass();
                int r105 = r103 + Math.round((r104 - r103) * r101);
                h r106 = this.f403199e;
                int r107 = this.f403197c;
                int r108 = this.f403198d;
                r106.getClass();
                int r109 = r107 + Math.round(r101 * (r108 - r107));
                if (r105 == r102.f403181m) goto L5;
            L6:
                r102.f403181m = r105;
                r102.f403182n = r109;
                ViewCompat.postInvalidateOnAnimation(r102);
                return;
            L5:
                if (r109 != r102.f403182n) goto L6;
            }

            public a(h r100, int r101, int r102, int r103, int r104) {
                this.f403199e = r100;
                this.f403195a = r101;
                this.f403196b = r102;
                this.f403197c = r103;
                this.f403198d = r104;
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f403200a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f403201b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                h r101 = this.f403201b;
                r101.f403178j = this.f403200a;
                r101.f403179k = 0.0f;
            }

            public b(h r100, int r101) {
                this.f403201b = r100;
                this.f403200a = r101;
            }
        }

        public final void e() {
            View r100 = getChildAt(this.f403178j);
            int r101 = -1;
            if (r100 != null) goto L5;
        L12:
            int r102 = -1;
        L14:
            if (r101 == this.f403181m) goto L16;
        L17:
            this.f403181m = r101;
            this.f403182n = r102;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L16:
            if (r102 != this.f403182n) goto L17;
            return;
        L5:
            if (r100.getWidth() <= 0) goto L12;
            int r103 = r100.getLeft();
            r102 = r100.getRight();
            if (this.f403179k > 0.0f) goto L9;
        L11:
            r101 = r103;
            goto L14
        L9:
            if (this.f403178j >= (getChildCount() - 1)) goto L11;
            View r104 = getChildAt(this.f403178j + 1);
            float r105 = this.f403179k * r104.getLeft();
            float r106 = this.f403179k;
            r103 = (int) (r105 + ((1.0f - r106) * r103));
            r102 = (int) ((r106 * r104.getRight()) + ((1.0f - this.f403179k) * r102));
            goto L11
        }

        public final void d(boolean r100) {
            this.f403189u = r100;
            if (r100 == false) goto L6;
            Paint r101 = new Paint();
            this.f403192x = r101;
            r101.setColor(ContextCompat.getColor(getContext(), R.color.oui_line_2));
            this.f403192x.setStyle(Paint.Style.FILL);
            this.f403192x.setStrokeWidth(this.f403193y);
            return;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public final void draw(Canvas r110) {
            super.draw(r110);
            if (this.f403188t == false) goto L6;
            float r100 = getLeft();
            float r101 = getBottom();
            Resources r102 = this.A.getResources();
            r110.drawLine(r100, r101 - ((WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * 0.6f) + 0.5f), getRight() * 2, getBottom(), this.f403191w);
        L6:
            if (this.f403189u == false) goto L8;
            r110.drawLine(getLeft(), this.f403193y + getTop(), getRight() * 2, this.f403193y + getTop(), this.f403192x);
        L8:
            int r103 = this.f403181m;
            if (r103 >= 0) goto L11;
            return;
        L11:
            if (this.f403182n > r103) goto L13;
            return;
        L13:
            if (this.f403190v == false) goto L35;
            View r104 = getChildAt(this.A.getSelectedTabPosition());
            if (r104 == null) goto L26;
            View r111 = r104.findViewById(R.id.layout_tab_indicator);
            if (r111 == null) goto L26;
            if (this.A.U != null) goto L21;
        L22:
            int r105 = this.f403181m;
            float r106 = r105 + (((this.f403182n - r105) - r111.getWidth()) / 2);
            this.f403185q = r106;
            this.f403186r = r106 + r111.getWidth();
        L23:
            Path r107 = new Path();
            r107.addRoundRect(new RectF(((this.f403185q + this.f403186r) / 2.0f) - this.A.o(3), (getHeight() - getPaddingBottom()) - this.A.o(4), ((this.f403185q + this.f403186r) / 2.0f) + this.A.o(3), getHeight() - getPaddingBottom()), new float[]{this.A.o(3), this.A.o(3), this.A.o(3), this.A.o(3), this.A.o(1), this.A.o(1), this.A.o(1), this.A.o(1)}, Path.Direction.CCW);
            r110.drawPath(r107, this.f403177i);
            return;
        L21:
            if (this.f403187s == true) goto L23;
        L26:
            if (this.f403194z == false) goto L28;
        L30:
            float r108 = this.f403181m;
            float r109 = this.f403182n;
        L31:
            Path r112 = new Path();
            float r113 = (r108 + r109) / 2.0f;
            r112.addRoundRect(new RectF(r113 - this.A.o(3), (getHeight() - getPaddingBottom()) - this.A.o(4), r113 + this.A.o(3), getHeight() - getPaddingBottom()), new float[]{this.A.o(3), this.A.o(3), this.A.o(3), this.A.o(3), this.A.o(1), this.A.o(1), this.A.o(1), this.A.o(1)}, Path.Direction.CCW);
            r110.drawPath(r112, this.f403177i);
            return;
        L28:
            if ((r104 instanceof j) == false) goto L30;
            float r114 = (this.f403181m + this.f403182n) * 0.5f;
            j r115 = (j) r104;
            r108 = r114 - (r115.getContentWidth() * 0.5f);
            r109 = r114 + (r115.getContentWidth() * 0.5f);
            goto L31
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r100) {
            super.onRtlPropertiesChanged(r100);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f403180l == r100) goto L9;
            requestLayout();
            this.f403180l = r100;
            return;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public final void setEnabled(boolean r100) {
            super.setEnabled(r100);
            int r101 = getChildCount();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            this.A.f403150t.getChildAt(r102).setEnabled(r100);
            r102 = r102 + 1;
            goto L3
        }

        public h(OTabLayoutBase r100, Context r101) {
            this.A = r100;
            super(r101);
            this.f403178j = -1;
            this.f403180l = -1;
            this.f403181m = -1;
            this.f403182n = -1;
            r100.o(27);
            this.f403184p = Integer.MAX_VALUE;
            setChangeAlphaWhenPress(false);
            setClipChildren(false);
            setClipToPadding(false);
            setWillNotDraw(false);
            this.f403177i = new Paint();
            Resources r102 = r100.getResources();
            this.f403193y = (WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * 0.6f) + 0.5f;
            setChangeAlphaWhenDisable(false);
        }

        public final void c(int r110, int r111) {
            ValueAnimator r100 = this.f403183o;
            if (r100 == null) goto L8;
            if (r100.isRunning() == false) goto L8;
            this.f403183o.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r101 = true;
        L11:
            View r102 = getChildAt(r110);
            if (r102 != null) goto L15;
            e();
            return;
        L15:
            int r103 = r102.getLeft();
            int r104 = r102.getRight();
            if (Math.abs(r110 - this.f403178j) > 1) goto L18;
            int r105 = this.f403181m;
            int r106 = this.f403182n;
        L26:
            if (r105 != r103) goto L28;
            if (r106 != r104) goto L28;
            return;
        L28:
            ValueAnimator r107 = new ValueAnimator();
            this.f403183o = r107;
            r107.setInterpolator(OTabLayoutBase.I2);
            r107.setDuration(r111);
            r107.setFloatValues(new float[]{0.0f, 1.0f});
            r107.addUpdateListener(new a(this, r105, r103, r106, r104));
            r107.addListener(new b(this, r110));
            r107.start();
            return;
        L18:
            int r108 = this.A.o(24);
            if (r110 >= this.f403178j) goto L22;
            if (r101 == true) goto L24;
        L23:
            int r109 = r108 + r104;
        L25:
            r105 = r109;
            r106 = r105;
        L24:
            r109 = r103 - r108;
            goto L25
        L22:
            if (r101 == false) goto L24;
        L10:
            r101 = false;
            goto L11
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r110, int r111) {
            super.onMeasure(r110, r111);
            int r100 = getChildCount();
            boolean r101 = true;
            int r102 = 0;
            if (View.MeasureSpec.getMode(r110) == 1073741824) goto L25;
            OTabLayoutBase r103 = this.A;
            if (r103.N == 1) goto L7;
            return;
        L7:
            if (r103.M != 1) goto L116;
            int r104 = 0;
            int r105 = 0;
        L9:
            if (r104 >= r100) goto L14;
            View r106 = getChildAt(r104);
            if (r106.getVisibility() != 0) goto L13;
            r105 = Math.max(r105, r106.getMeasuredWidth());
            this.f403184p = Math.min(this.f403184p, r106.getMeasuredWidth());
        L13:
            r104 = r104 + 1;
            goto L9
        L14:
            int r107 = Math.min(this.A.I, r105);
            boolean r108 = false;
        L15:
            if (r102 >= r100) goto L22;
            LinearLayout.LayoutParams r109 = (LinearLayout.LayoutParams) getChildAt(r102).getLayoutParams();
            if (r109.width == r107) goto L19;
        L20:
            r109.width = r107;
            r109.weight = 0.0f;
            r108 = true;
        L21:
            r102 = r102 + 1;
            goto L15
        L19:
            if (r109.weight == 0.0f) goto L21;
        L22:
            if (r108 == false) goto L117;
            super.onMeasure(r110, r111);
            return;
        L117:
            return;
        L116:
            return;
        L25:
            Drawable r112 = getDividerDrawable();
            if (r112 == null) goto L28;
            int r113 = r112.getIntrinsicWidth();
        L29:
            int r114 = 0;
            int r115 = 0;
        L30:
            if (r114 >= r100) goto L35;
            View r116 = getChildAt(r114);
            if (r116.getVisibility() != 0) goto L34;
            r115 = Math.max(r115, r116.getMeasuredWidth());
            this.f403184p = Math.min(this.f403184p, r116.getMeasuredWidth());
        L34:
            r114 = r114 + 1;
            goto L30
        L35:
            int r117 = (getPaddingLeft() + getPaddingRight()) + (r113 * (r100 - 1));
            OTabLayoutBase r118 = this.A;
            int r119 = r118.N;
            if (r119 == 1) goto L38;
        L55:
            if (r119 == 0) goto L57;
            return;
        L57:
            if (r118.P == true) goto L59;
            return;
        L59:
            if (r118.F2 == getResources().getConfiguration().orientation) goto L61;
            return;
        L61:
            if (r115 > 0) goto L63;
            return;
        L63:
            int r120 = 0;
            int r121 = 0;
        L65:
            if (r120 >= r100) goto L70;
            View r122 = getChildAt(r120);
            if (r122.getVisibility() == 8) goto L69;
            r121 = r121 + r122.getMeasuredWidth();
        L69:
            r120 = r120 + 1;
            goto L65
        L70:
            if (r121 > 0) goto L72;
            return;
        L72:
            int r123 = getMeasuredWidth() - r117;
            if (r121 < r123) goto L75;
        L91:
            if (r102 == 0) goto L122;
            super.onMeasure(r110, r111);
            return;
        L122:
            return;
        L75:
            if ((r115 * r100) >= r123) goto L84;
            int r124 = 0;
            int r125 = 0;
        L77:
            if (r124 >= r100) goto L90;
            LinearLayout.LayoutParams r126 = (LinearLayout.LayoutParams) getChildAt(r124).getLayoutParams();
            if (r126.width == 0) goto L81;
        L82:
            r126.width = 0;
            r126.weight = 1.0f;
            r125 = 1;
        L83:
            r124 = r124 + 1;
            goto L77
        L81:
            if (r126.weight == 1.0f) goto L83;
        L90:
            r102 = r125;
            goto L91
        L84:
            int r127 = (r123 - r121) / (r100 * 2);
            r125 = 0;
        L85:
            if (r102 >= r100) goto L90;
            if (getChildAt(r102).getVisibility() == 8) goto L89;
            LinearLayout.LayoutParams r128 = (LinearLayout.LayoutParams) getChildAt(r102).getLayoutParams();
            r128.leftMargin = r127;
            r128.rightMargin = r127;
            r125 = 1;
        L89:
            r102 = r102 + 1;
            goto L85
        L38:
            if (r118.M != 1) goto L55;
            if (r115 > 0) goto L42;
            return;
        L42:
            if ((r115 * r100) > (getMeasuredWidth() - r117)) goto L52;
            boolean r129 = false;
        L44:
            if (r102 >= r100) goto L51;
            LinearLayout.LayoutParams r130 = (LinearLayout.LayoutParams) getChildAt(r102).getLayoutParams();
            if (r130.width == r115) goto L48;
        L49:
            r130.width = r115;
            r130.weight = 0.0f;
            r129 = true;
        L50:
            r102 = r102 + 1;
            goto L44
        L48:
            if (r130.weight == 0.0f) goto L50;
        L51:
            r101 = r129;
        L53:
            if (r101 == false) goto L118;
            super.onMeasure(r110, r111);
            return;
        L118:
            return;
        L52:
            OTabLayoutBase r131 = this.A;
            r131.M = 0;
            r131.D(false);
            goto L53
        L28:
            r113 = 0;
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.f403183o;
            if (r105 != null) goto L5;
        L7:
            e();
            return;
        L5:
            if (r105.isRunning() == false) goto L7;
            this.f403183o.cancel();
            c(this.f403178j, Math.round((1.0f - this.f403183o.getAnimatedFraction()) * this.f403183o.getDuration()));
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f403202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f403203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f403204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f403205d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f403206e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public OTabLayoutBase f403207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public j f403208g;

        public final void b() {
            j r100 = this.f403208g;
            if (r100 == null) goto L6;
            r100.update();
            return;
        }

        public i() {
            this.f403205d = -1;
        }

        public final void a(int r100) {
            OTabLayoutBase r101 = this.f403207f;
            if (r101 == null) goto L7;
            this.f403203b = r101.getResources().getText(r100);
            b();
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public class j extends OUILinearLayout implements com.obric.oui.material.g {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final /* synthetic */ int f403209w = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public i f403210h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TextView f403211i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ImageView f403212j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f403213k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public TextView f403214l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ImageView f403215m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f403216n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f403217o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public com.obric.oui.material.c[] f403218p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public com.obric.oui.material.c[] f403219q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public com.obric.oui.material.c[] f403220r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f403221s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public fja.d f403222t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public fja.d f403223u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f403224v;

        @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.a
        public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
        }

        public final void d() {
            q r100 = q.f399591h;
            b(r100.a(), r100.a(), false);
        }

        public final void f() {
            if (this.f403224v.G == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(getContext(), this.f403224v.G));
        L6:
            setOutlineProvider(null);
            return;
        L5:
            setBackground(null);
            goto L6
        }

        public final void g() {
            fja.d r100 = this.f403222t;
            if (r100 == null) goto L5;
            r100.a(false);
        L5:
            fja.d r101 = this.f403223u;
            if (r101 == null) goto L8;
            r101.a(false);
        L8:
            setScaleX(1.0f);
            setScaleY(1.0f);
            i(isSelected());
        }

        public int getContentWidth() {
            TextView r100 = this.f403211i;
            boolean r101 = true;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
            int r103 = 0;
            int r104 = 0;
        L8:
            ImageView r105 = this.f403212j;
            if (r105 != null) goto L11;
        L19:
            r101 = r102;
        L20:
            View r106 = this.f403213k;
            if (r106 == null) goto L32;
            if (r106.getVisibility() != 0) goto L32;
            int r107 = this.f403213k.getLeft();
            if (r101 == false) goto L27;
            r107 = Math.min(r103, r107);
        L27:
            r103 = r107;
            int r108 = this.f403213k.getRight();
            if (r101 == false) goto L30;
            r108 = Math.max(r104, r108);
        L30:
            r104 = r108;
        L32:
            return r104 - r103;
        L11:
            if (r105.getVisibility() != 0) goto L19;
            if (r102 == false) goto L14;
            r103 = Math.min(r103, this.f403212j.getLeft());
        L15:
            if (r102 == false) goto L17;
            int r109 = Math.max(r104, this.f403212j.getRight());
        L18:
            r104 = r109;
            goto L20
        L17:
            r109 = this.f403212j.getRight();
            goto L18
        L14:
            r103 = this.f403212j.getLeft();
            goto L15
        L5:
            if (r100.getVisibility() != 0) goto L7;
            int r110 = this.f403211i.getLeft();
            r104 = this.f403211i.getRight();
            r103 = r110;
            r102 = true;
            goto L8
        }

        public final void update() {
            i r100 = this.f403210h;
            if (r100 == null) goto L5;
            View r101 = r100.f403206e;
        L6:
            boolean r102 = true;
            if (r101 == null) goto L29;
            ViewParent r103 = r101.getParent();
            if (r103 == this) goto L13;
            if (r103 == null) goto L12;
            ((ViewGroup) r103).removeView(r101);
        L12:
            addView(r101);
        L13:
            this.f403213k = r101;
            TextView r104 = this.f403211i;
            if (r104 == null) goto L16;
            r104.setVisibility(8);
        L16:
            ImageView r105 = this.f403212j;
            if (r105 == null) goto L19;
            r105.setVisibility(8);
            this.f403212j.setImageDrawable(null);
        L19:
            TextView r106 = (TextView) r101.findViewById(R.id.title);
            this.f403214l = r106;
            if (r106 == null) goto L26;
            r106.setDuplicateParentStateEnabled(true);
            this.f403216n = TextViewCompat.getMaxLines(this.f403214l);
            OTabLayoutBase r107 = this.f403224v;
            if (r107.G2 != null) goto L26;
            if (this.f403211i == null) goto L26;
            r107.G2 = this.f403214l.getTypeface();
        L26:
            ImageView r108 = (ImageView) r101.findViewById(android.R.id.icon);
            this.f403215m = r108;
            if (r108 == null) goto L34;
            r108.setDuplicateParentStateEnabled(true);
        L34:
            if (this.f403213k == null) goto L36;
            TextView r109 = this.f403214l;
            if (r109 == null) goto L52;
        L53:
            j(r109, this.f403215m);
        L54:
            if (r100 == null) goto L65;
            OTabLayoutBase r110 = r100.f403207f;
            if (r110 == null) goto L64;
            if (r110.getSelectedTabPosition() != r100.f403205d) goto L60;
            boolean r111 = true;
        L61:
            if (r111 == false) goto L65;
        L66:
            setSelected(r102);
            if (isEnabled() == false) goto L69;
            float r112 = 1.0f;
        L70:
            h(r112);
            return;
        L69:
            r112 = this.f403224v.f403151u;
            goto L70
        L60:
            r111 = false;
            goto L61
        L64:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L65:
            r102 = false;
            goto L66
        L52:
            if (this.f403215m == null) goto L54;
        L36:
            if (this.f403212j != null) goto L39;
            ImageView r113 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            addView(r113, 0);
            this.f403212j = r113;
            r113.setDuplicateParentStateEnabled(true);
        L39:
            if (this.f403211i != null) goto L45;
            TextView r114 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            addView(r114, new LinearLayout.LayoutParams(-1, -2));
            this.f403211i = r114;
            r114.setMaxLines(1);
            this.f403211i.setDuplicateParentStateEnabled(true);
            this.f403216n = TextViewCompat.getMaxLines(this.f403211i);
            OTabLayoutBase r115 = this.f403224v;
            if (r115.G2 != null) goto L45;
            TextView r116 = this.f403211i;
            if (r116 == null) goto L45;
            r115.G2 = r116.getTypeface();
        L45:
            this.f403211i.setAllCaps(false);
            ColorStateList r117 = this.f403224v.D;
            if (r117 == null) goto L48;
            this.f403211i.setTextColor(r117);
        L48:
            j(this.f403211i, this.f403212j);
            goto L54
        L29:
            View r118 = this.f403213k;
            if (r118 == null) goto L32;
            removeView(r118);
            this.f403213k = null;
        L32:
            this.f403214l = null;
            this.f403215m = null;
            goto L34
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r100 = super.performClick();
            if (this.f403210h == null) goto L12;
            if (r100 == true) goto L6;
            playSoundEffect(0);
        L6:
            OTabLayoutBase r101 = this.f403224v;
            FastOutSlowInInterpolator r102 = OTabLayoutBase.I2;
            r101.getClass();
            i r103 = this.f403210h;
            OTabLayoutBase r104 = r103.f403207f;
            if (r104 == null) goto L11;
            r104.w(r103, true);
            bma.a.c(getContext(), 1);
            return true;
        L11:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L12:
            return r100;
        }

        public i getTab() {
            return this.f403210h;
        }

        public TextView getTextView() {
            return this.f403211i;
        }

        @Override // com.obric.oui.material.g
        public final void a(int r100) {
            if (this.f403217o == true) goto L5;
            return;
        L5:
            OMaterialHelper.q(this, r100);
        }

        public final void c(boolean r100) {
            if (this.f403221s == false) goto L13;
            if (this.f403217o == false) goto L8;
            if (r100 == false) goto L8;
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            OMaterialHelper.s(this, 2, 1);
            return;
        L11:
            OMaterialHelper.s(this, 0, 0);
            return;
        L8:
            r101 = false;
            goto L9
        L13:
            if (this.f403217o == false) goto L16;
            if (r100 == false) goto L16;
            boolean r102 = true;
        L17:
            if (r102 == false) goto L19;
            OMaterialHelper.s(this, 3, 1);
            return;
        L19:
            OMaterialHelper.s(this, 0, 0);
            return;
        L16:
            r102 = false;
            goto L17
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r100) {
            boolean r101 = super.dispatchTouchEvent(r100);
            int r102 = r100.getActionMasked();
            if (r102 != 0) goto L5;
            e(true, getCurrentShadows());
        L15:
            return r101;
        L5:
            if (r102 != 1) goto L7;
            e(false, getCurrentShadows());
            goto L15
        L7:
            if (r102 != 3) goto L15;
            if (this.f403217o == false) goto L12;
            g();
            goto L15
        L12:
            e(false, getCurrentShadows());
            goto L15
        }

        public final void h(float r100) {
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            TextView r101 = this.f403211i;
            if (r101 == null) goto L5;
            r101.setAlpha(r100);
        L5:
            ImageView r102 = this.f403212j;
            if (r102 == null) goto L8;
            r102.setAlpha(r100);
        L8:
            TextView r103 = this.f403214l;
            if (r103 == null) goto L11;
            r103.setAlpha(r100);
        L11:
            ImageView r104 = this.f403215m;
            if (r104 == null) goto L14;
            r104.setAlpha(r100);
        L14:
            View r105 = this.f403213k;
            if (r105 == null) goto L18;
            r105.setAlpha(r100);
            return;
        }

        public final void i(boolean r100) {
            q r101 = null;
            if (this.f403217o == true) goto L15;
            f();
            if (r100 == false) goto L12;
            List<q> r102 = this.f403224v.T1;
            if (r102 == null) goto L12;
            q r103 = (q) ListProtector.get(r102, 0);
            if (((ArrayList) this.f403224v.T1).size() <= 1) goto L11;
            r101 = (q) ListProtector.get(this.f403224v.T1, 1);
        L11:
            b(r103, r101, false);
        L13:
            c(false);
            return;
        L12:
            d();
            goto L13
        L15:
            if (r100 == false) goto L19;
            com.obric.oui.material.c[] r104 = this.f403220r;
            if (r104 == null) goto L19;
        L20:
            this.f403218p = r104;
            if (r104 == null) goto L58;
            if (r104 == null) goto L50;
            int r105 = (int) pla.d.f(99.0f, getContext());
            setShadowCornerRadius(r105);
            setRadius(r105);
            if (this.f403224v.T1 == null) goto L27;
            ((com.obric.oui.common.style.h) getAlphaHelper()).h(r105);
        L27:
            boolean r106 = this.f403221s;
            if (r106 == false) goto L30;
            int r107 = 2;
        L31:
            if (r106 == false) goto L33;
            p.c(this, this.f403218p, false, r107, null);
        L34:
            com.obric.oui.material.c[] r108 = this.f403218p;
            if (r108 != null) goto L37;
        L46:
            boolean r109 = false;
        L47:
            if (r109 == true) goto L49;
            d();
        L49:
            GradientDrawable r110 = new GradientDrawable();
            r110.setShape(0);
            r110.setCornerRadius(pla.d.f(99.0f, getContext()));
            r110.setColor(0);
            setBackground(r110);
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            goto L50
        L37:
            if (r108.length == 0) goto L46;
            int r111 = OMaterialHelper.g(getContext());
            int r112 = Math.max(0, Math.min(this.f403218p.length - 1, r111 - 1));
            com.obric.oui.material.c r113 = this.f403218p[r112];
            if (r113 == null) goto L46;
            com.obric.oui.shadow.a[] r114 = r113.f401460i;
            if (r114 == null) goto L46;
            if (r114.length <= 0) goto L46;
            r109 = true;
            goto L47
        L33:
            p.e(this, this.f403218p, false, null);
            goto L34
        L30:
            r107 = 3;
        L50:
            c(true);
            if (r100 == false) goto L60;
            List<q> r115 = this.f403224v.T1;
            if (r115 == null) goto L61;
            q r116 = (q) ListProtector.get(r115, 0);
            if (((ArrayList) this.f403224v.T1).size() <= 1) goto L57;
            r101 = (q) ListProtector.get(this.f403224v.T1, 1);
        L57:
            b(r116, r101, false);
            return;
        L61:
            return;
        L60:
            return;
        L58:
            f();
            d();
            c(false);
            return;
        L19:
            r104 = this.f403219q;
            goto L20
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
            super.onInitializeAccessibilityEvent(r100);
            r100.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
            super.onInitializeAccessibilityNodeInfo(r100);
            r100.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // com.obric.oui.material.g
        public void setBackdropTarget(View r100) {
            if (this.f403217o == true) goto L5;
            return;
        L5:
            OMaterialHelper.t(this, r100);
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r100) {
            super.setEnabled(r100);
            if (r100 == false) goto L5;
            float r101 = 1.0f;
        L6:
            h(r101);
            return;
        L5:
            r101 = this.f403224v.f403151u;
            goto L6
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setSelected(boolean r100) {
            if (isSelected() != r100) goto L6;
        L6:
            super.setSelected(r100);
            i(r100);
            if (r100 == false) goto L9;
        L11:
            TextView r101 = this.f403211i;
            if (r101 == null) goto L29;
            if (r100 == false) goto L17;
            float r102 = this.f403224v.F;
            if (r102 <= 0.0f) goto L17;
            r101.setTextSize(0, r102);
        L18:
            TextView r103 = this.f403211i;
            if (r100 == false) goto L26;
            OTabLayoutBase r104 = this.f403224v;
            Typeface r105 = r104.G2;
            if (r104.H2 == null) goto L23;
        L25:
            Typeface r106 = r104.H2;
        L27:
            r103.setTypeface(r106);
            return;
        L23:
            if (Build.VERSION.SDK_INT < 28) goto L25;
            r104.H2 = Typeface.create(r105, 500, false);
            goto L25
        L26:
            r106 = this.f403224v.G2;
        L17:
            r101.setTextSize(0, this.f403224v.E);
            goto L18
        L29:
            return;
        L9:
            if (this.f403224v.T1 == null) goto L11;
            g();
            goto L11
        }

        public void setTab(i r100) {
            if (r100 == this.f403210h) goto L6;
            this.f403210h = r100;
            update();
            return;
        }

        public final void e(boolean r100, List<q> r101) {
            if (isEnabled() == true) goto L5;
            return;
        L5:
            if (this.f403224v.T1 == null) goto L22;
            fja.d r102 = this.f403222t;
            if (r102 == null) goto L10;
            r102.a(false);
        L10:
            fja.d r103 = this.f403223u;
            if (r103 == null) goto L13;
            r103.a(false);
        L13:
            if (r100 == false) goto L15;
            List<q> r104 = getCurrentShadows();
            this.f403222t = ShadowAnimator.a(this, getScaleX(), 0.98f, r104, this.f403224v.T1);
            return;
        L15:
            if (r101 != null) goto L18;
            r101 = getCurrentShadows();
        L18:
            this.f403223u = ShadowAnimator.a(this, getScaleX(), 1.0f, this.f403224v.T1, r101);
            return;
        }

        public final void j(TextView r100, ImageView r101) {
            i r102 = this.f403210h;
            CharSequence r103 = null;
            if (r102 == null) goto L5;
            Drawable r104 = r102.f403202a;
        L6:
            if (r102 == null) goto L8;
            CharSequence r105 = r102.f403203b;
        L9:
            if (r102 == null) goto L11;
            CharSequence r106 = r102.f403204c;
        L12:
            int r107 = 0;
            if (r101 == null) goto L18;
            if (r104 == null) goto L16;
            r101.setImageDrawable(r104);
            r101.setVisibility(0);
            setVisibility(0);
        L17:
            r101.setContentDescription(r106);
            goto L18
        L16:
            r101.setVisibility(8);
            r101.setImageDrawable(null);
        L18:
            boolean r108 = !TextUtils.isEmpty(r105);
            if (r100 == null) goto L24;
            if (r108 == false) goto L22;
            r100.setText(r105);
            r100.setVisibility(0);
            setVisibility(0);
        L23:
            r100.setContentDescription(r106);
            goto L24
        L22:
            r100.setVisibility(8);
            r100.setText(null);
        L24:
            if (r101 == null) goto L33;
            ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r101.getLayoutParams();
            if (r108 == false) goto L31;
            if (r101.getVisibility() != 0) goto L31;
            r107 = this.f403224v.o(8);
        L31:
            if (r107 == r109.bottomMargin) goto L33;
            r109.bottomMargin = r107;
            r101.requestLayout();
        L33:
            if (r108 == true) goto L36;
            r103 = r106;
        L36:
            TooltipCompat.setTooltipText(this, r103);
            return;
        L11:
            r106 = null;
            goto L12
        L8:
            r105 = null;
            goto L9
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r110, int r111) {
            int r100 = View.MeasureSpec.getSize(r110);
            int r101 = View.MeasureSpec.getMode(r110);
            int r102 = this.f403224v.getTabMaxWidth();
            LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) this.f403211i.getLayoutParams();
            if (r102 <= 0) goto L7;
            if (r101 == 0) goto L6;
            if (r100 <= r102) goto L7;
        L6:
            r110 = View.MeasureSpec.makeMeasureSpec(this.f403224v.H, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r110, r111);
            if (this.f403211i == null) goto L37;
            getResources();
            OTabLayoutBase r104 = this.f403224v;
            float r105 = r104.E;
            int r106 = this.f403216n;
            int r107 = r104.f403156x;
            int r108 = r104.f403155w;
            ImageView r109 = this.f403212j;
            boolean r112 = true;
            if (r109 == null) goto L15;
            if (r109.getVisibility() != 0) goto L15;
            r106 = 1;
        L15:
            if (this.f403211i != null) goto L17;
        L21:
            float r113 = this.f403211i.getTextSize();
            int r114 = this.f403211i.getLineCount();
            int r115 = TextViewCompat.getMaxLines(this.f403211i);
            if (r105 != r113) goto L26;
            if (r115 < 0) goto L38;
            if (r106 != r115) goto L26;
            return;
        L38:
            return;
        L26:
            if (this.f403224v.N != 1) goto L34;
            if (r105 <= r113) goto L34;
            if (r114 != 1) goto L34;
            Layout r116 = this.f403211i.getLayout();
            if (r116 != null) goto L32;
        L33:
            r112 = false;
            goto L34
        L32:
            if ((r116.getLineWidth(0) * (r105 / r116.getPaint().getTextSize())) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L33;
        L34:
            if (r112 == false) goto L40;
            this.f403211i.setTextSize(0, r105);
            this.f403211i.setMaxLines(r106);
            r103.topMargin = r107;
            r103.leftMargin = r108;
            r103.rightMargin = r108;
            this.f403211i.setLayoutParams(r103);
            super.onMeasure(r110, r111);
            return;
        L40:
            return;
        L17:
            if (isSelected() == false) goto L21;
            float r117 = this.f403224v.F;
            if (r117 <= 0.0f) goto L21;
            r105 = r117;
            r108 = 0;
            r107 = 0;
            goto L21
        }

        public j(OTabLayoutBase r100, Context r101, boolean r102, com.obric.oui.material.c[] r103, com.obric.oui.material.c[] r104) {
            this.f403224v = r100;
            super(r101);
            this.f403216n = 1;
            this.f403221s = true;
            setEnableShadowWidthRadius(true);
            setRadius((int) r100.f403137h1);
            setShadowCornerRadius((int) r100.f403137h1);
            ((com.obric.oui.common.style.h) getAlphaHelper()).h((int) r100.f403137h1);
            this.f403217o = r102;
            this.f403219q = r103;
            this.f403220r = r104;
            this.f403218p = r103;
            if (r100.T1 == null) goto L5;
            setOverridePressColor(ContextCompat.getColor(r101, R.color.oui_basic_fill_element_2));
            m1("OTabLayoutBase");
        L5:
            int r105 = r100.G;
            if (r105 == 0) goto L9;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r101, r105));
        L9:
            if (r100.T1 == null) goto L11;
            boolean r106 = true;
        L12:
            setChangeAlphaWhenPress(r106);
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            ViewCompat.setPaddingRelative(this, r100.f403162z, r100.A, r100.B, r100.C);
            setMinimumWidth(r100.f403159y);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
            if (this.f403217o == false) goto L16;
            i(isSelected());
            return;
        L16:
            return;
        L11:
            r106 = false;
            goto L12
        }
    }

    public static class k implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f403225a;

        @Override // com.obric.oui.tab.OTabLayoutBase.e
        public final void a(i r100) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.e
        public final void b(i r100) {
        }

        public k(ViewPager r100) {
            this.f403225a = r100;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.e
        public final void c(i r100) {
            this.f403225a.setCurrentItem(r100.f403205d);
        }
    }

    public void setContentInsetStart(int r100) {
    }

    public void setOnTabClickListener(d r100) {
    }

    public void setTabTextAppearance(int r100) {
    }

    static {
        I2 = new FastOutSlowInInterpolator();
        J2 = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        int r100 = this.f403141n.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L14;
        i r102 = (i) ListProtector.get(this.f403141n, r101);
        if (r102 == null) goto L13;
        if (r102.f403202a == null) goto L11;
        if (TextUtils.isEmpty(r102.f403203b) == true) goto L11;
        return 56;
    L11:
        if (r102.f403206e == null) goto L13;
        return 56;
    L13:
        r101 = r101 + 1;
        goto L3
    L14:
        return 56;
    }

    private float getScrollPosition() {
        h r100 = this.f403150t;
        return r100.f403178j + r100.f403179k;
    }

    private int getTabMinWidth() {
        int r100 = this.f403132J;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        if (this.N == 0) goto L10;
        return 0;
    L10:
        return this.L;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f403150t.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public final void B() {
        if (this.H1 == false) goto L5;
        this.f403150t.setShadowStyle(this.f403149s);
        this.f403150t.setShadowCornerRadius((int) this.f403137h1);
        return;
    L5:
        this.f403150t.setShadowStyle(R.style.OUIShadow_None);
    }

    public float getEdgeFadeLength() {
        return this.f403138h2.f529877f;
    }

    public int getSelectedTabPosition() {
        i r100 = this.f403142o;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f403205d;
    }

    public int getTabCount() {
        return this.f403141n.size();
    }

    public int getTabStripLeftPadding() {
        return this.f403150t.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f403150t.getPaddingRight();
    }

    public final void l() {
        int r100 = this.N;
        if (r100 == 0) goto L7;
        if (r100 != 1) goto L8;
        this.f403150t.setGravity(1);
        setOverScrollMode(2);
    L8:
        D(true);
        return;
    L7:
        this.f403150t.setGravity(GravityCompat.START);
        setOverScrollMode(0);
        goto L8
    }

    public final void q() {
        if (this.T != null) goto L6;
        ValueAnimator r100 = new ValueAnimator();
        this.T = r100;
        r100.setInterpolator(I2);
        this.T.setDuration(200);
        this.T.addUpdateListener(new a(this));
        return;
    }

    public final boolean r() {
        int r100 = this.D.getDefaultColor();
        if (r100 != 0) goto L10;
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L11;
        return false;
    L11:
        return true;
    L10:
        return !h0.b(r100);
    }

    public final void u() {
        int r100 = this.f403150t.getChildCount() - 1;
    L4:
        if (r100 < 0) goto L9;
        j r101 = (j) this.f403150t.getChildAt(r100);
        this.f403150t.removeViewAt(r100);
        if (r101 == null) goto L8;
        r101.setTab(null);
        r101.setSelected(false);
        this.E2.release(r101);
    L8:
        requestLayout();
        r100 = r100 - 1;
        goto L4
    L9:
        Iterator<i> r102 = this.f403141n.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        i r103 = r102.next();
        r102.remove();
        r103.f403207f = null;
        r103.f403208g = null;
        r103.f403202a = null;
        r103.f403203b = null;
        r103.f403204c = null;
        r103.f403205d = -1;
        r103.f403206e = null;
        J2.release(r103);
        goto L11
    L13:
        this.f403142o = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.U != null) goto L8;
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewPager) == false) goto L9;
        A((ViewPager) r100, true);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.H0 == false) goto L6;
        setupWithViewPager(null);
        this.H0 = false;
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void t() {
        u();
        PagerAdapter r100 = this.V;
        if (r100 == null) goto L23;
        int r101 = r100.getCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        i r103 = s(this.O);
        r103.f403203b = this.V.getPageTitle(r102);
        r103.b();
        i(r103, false);
        r102 = r102 + 1;
        goto L5
    L7:
        ViewPager r104 = this.U;
        if (r104 == null) goto L24;
        if (r101 <= 0) goto L25;
        int r105 = r104.getCurrentItem();
        if (r105 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r105 >= getTabCount()) goto L27;
        if (r105 >= 0) goto L16;
    L19:
        i r106 = null;
    L20:
        w(r106, true);
        return;
    L16:
        if (r105 >= getTabCount()) goto L19;
        r106 = (i) ListProtector.get(this.f403141n, r105);
        goto L20
    L27:
        return;
    L25:
        return;
    L24:
        return;
    }

    public static /* synthetic */ int[] g() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    public float getIndicatorCornerRadius() {
        return this.f403137h1;
    }

    public ViewGroup getTabContainer() {
        return this.f403150t;
    }

    public float getTabDisabledAlpha() {
        return this.f403151u;
    }

    public int getTabGravity() {
        return this.M;
    }

    public int getTabMaxWidth() {
        return this.H;
    }

    public int getTabMode() {
        return this.N;
    }

    public ColorStateList getTabTextColors() {
        return this.D;
    }

    public OTabLayoutBase(Context r100) {
        this(r100, null);
    }

    private void setSelectedTabView(int r100) {
        int r101 = this.f403150t.getChildCount();
        if (r100 >= r101) goto L11;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L15;
        View r103 = this.f403150t.getChildAt(r102);
        if (r102 != r100) goto L9;
        boolean r104 = true;
    L10:
        r103.setSelected(r104);
        r102 = r102 + 1;
        goto L5
    L9:
        r104 = false;
        goto L10
    L15:
        return;
    }

    public final void C(LinearLayout.LayoutParams r100) {
        if (this.N == 1) goto L5;
    L7:
        r100.width = -2;
        r100.weight = 0.0f;
    L8:
        int r101 = this.f403152v;
        if (r101 == 0) goto L12;
        r100.leftMargin = r101;
        r100.rightMargin = r101;
        return;
    L12:
        return;
    L5:
        if (this.M != 0) goto L7;
        r100.width = 0;
        r100.weight = 1.0f;
        goto L8
    }

    public final void D(boolean r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f403150t.getChildCount()) goto L9;
        View r102 = this.f403150t.getChildAt(r101);
        C((LinearLayout.LayoutParams) r102.getLayoutParams());
        if (r100 == false) goto L8;
        r102.requestLayout();
    L8:
        r101 = r101 + 1;
        goto L4
    }

    @Override // com.obric.oui.material.g
    public final void a(int r100) {
        if (this.M1 == false) goto L7;
        int r101 = this.f403141n.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((i) ListProtector.get(this.f403141n, r102)).f403208g.a(r100);
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100) {
        j(r100);
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r210) {
        float r100 = getBounceTranslation();
        float r101 = pla.d.f(0.5f, getContext());
        if (r100 >= (-r101)) goto L5;
        boolean r102 = true;
    L7:
        if (r100 <= r101) goto L9;
        boolean r103 = true;
    L11:
        if (canScrollHorizontally(-1) == true) goto L15;
        if (r102 == true) goto L15;
        boolean r104 = false;
    L17:
        if (canScrollHorizontally(1) == true) goto L21;
        if (r103 == true) goto L21;
        boolean r105 = false;
    L22:
        final pma.b r110 = this.f403138h2;
        r110.getClass();
        Intrinsics.checkNotNullParameter(this, "invalidateView");
        if (r110.f529876e == false) goto L61;
        if (r110.f529877f <= 0.0f) goto L61;
        if (r104 == false) goto L29;
        final float r106 = 1.0f;
    L30:
        if (r105 == false) goto L32;
        final float r107 = 1.0f;
    L34:
        if (r110.f529880i != r106) goto L36;
        boolean r108 = true;
    L37:
        if (r108 == true) goto L39;
    L44:
        final float r109 = r110.f529878g;
        final float r111 = r110.f529879h;
        r110.f529880i = r106;
        r110.f529881j = r107;
        if (r109 != r106) goto L47;
        boolean r112 = true;
    L48:
        if (r112 == true) goto L50;
    L55:
        ValueAnimator r113 = r110.f529887p;
        if (r113 == null) goto L59;
        r113.cancel();
    L59:
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r114.setDuration(Math.max(1, (long) (120 * Math.max(Math.abs(r106 - r109), Math.abs(r107 - r111)))));
        r114.addUpdateListener(new pma.a(r110, r109, r106, r111, r107, this));
        r114.addListener(new pma.c(r110));
        r110.f529887p = r114;
        r114.start();
    L80:
        pma.b r115 = this.f403138h2;
        if (r115.f529878g <= 0.0f) goto L83;
        boolean r116 = true;
    L85:
        if (r115.f529879h <= 0.0f) goto L87;
        boolean r117 = true;
    L88:
        int r118 = getWidth();
        int r119 = getHeight();
        if (r115.f529876e == true) goto L91;
    L105:
        boolean r120 = false;
    L106:
        if (r120 == false) goto L187;
        float r121 = getScrollX();
        float r122 = getTabStripLeftPadding();
        float r123 = getTabStripRightPadding();
        h r124 = this.f403150t;
        int r125 = getWidth();
        int r126 = getHeight();
        RectF r127 = this.f403157x1;
        RectF r128 = this.f403160y1;
        int r129 = pma.d.f529889a;
        Intrinsics.checkNotNullParameter(r124, "tabContainer");
        Intrinsics.checkNotNullParameter(r127, "outLayerBounds");
        Intrinsics.checkNotNullParameter(r128, "outOverlayBounds");
        int r130 = r124.getChildCount();
        int r131 = 0;
        int r132 = 0;
        int r133 = 0;
    L108:
        if (r131 >= r130) goto L128;
        int r134 = r131 + 1;
        KeyEvent.Callback r135 = r124.getChildAt(r131);
        if ((r135 instanceof com.obric.oui.common.style.b) == false) goto L114;
        List<q> r136 = ((com.obric.oui.common.style.b) r135).getCurrentShadows();
        if (r136 == null) goto L114;
        Iterator<q> r137 = r136.iterator();
        int r138 = r133;
    L117:
        if (r137.hasNext() == false) goto L126;
        h r211 = r124;
        q r139 = r137.next();
        if (r139 == null) goto L125;
        if (r139.e() == false) goto L125;
        r138 = Math.max(r138, (int) Math.ceil((Math.abs(r139.f399594c) + r139.f399593b) + r139.f399596e));
        r132 = Math.max(r132, (int) Math.ceil((Math.abs(r139.f399595d) + r139.f399593b) + r139.f399596e));
    L125:
        r124 = r211;
        r122 = r122;
        r123 = r123;
        goto L117
    L126:
        h r212 = r124;
        float r213 = r122;
        float r214 = r123;
        r133 = r138;
    L127:
        r131 = r134;
        r124 = r212;
        r122 = r213;
        r123 = r214;
    L114:
        r212 = r124;
        r213 = r122;
        r214 = r123;
        goto L127
    L128:
        float r215 = r122;
        float r216 = r123;
        if (r116 == false) goto L131;
        int r140 = 0;
    L132:
        float r141 = r121 - r140;
        float r142 = r125 + r121;
        if (r117 == false) goto L135;
        int r143 = 0;
    L136:
        float r144 = r132;
        r127.set(r141, -r144, r143 + r142, r126 + r144);
        if (r116 == false) goto L139;
        r121 = r127.left;
    L139:
        if (r117 == false) goto L141;
        r142 = r127.right;
    L141:
        r128.set(r121, r127.top, r142, r127.bottom);
        RectF r145 = this.f403157x1;
        int r146 = r210.saveLayer(r145.left, r145.top, r145.right, r145.bottom, null);
        p(r210);
        pma.b r147 = this.f403138h2;
        RectF r148 = this.f403160y1;
        float r149 = r148.left;
        if (r116 == true) goto L145;
        r215 = 0.0f;
    L145:
        float r150 = r149 + r215;
        float r151 = r148.top;
        float r152 = r148.right;
        if (r117 == true) goto L149;
        r216 = 0.0f;
    L149:
        float r153 = r152 - r216;
        float r154 = r148.bottom;
        r147.getClass();
        Intrinsics.checkNotNullParameter(r210, "canvas");
        float r155 = Math.min(r147.f529877f, ((int) (r153 - r150)) / 2.0f);
        if (r155 <= 0.0f) goto L185;
        r147.f529872a.setXfermode(r147.f529873b);
        float[] r156 = pma.b.f529871q;
        if (r116 == false) goto L168;
        float r157 = r147.f529878g;
        float r158 = r155 * r157;
        if (r158 <= 0.0f) goto L168;
        int r159 = MathKt.roundToInt(255 * (1.0f - RangesKt.coerceIn(r157, 0.0f, 1.0f)));
        LinearGradient r160 = r147.f529882k;
        if (r160 != null) goto L159;
    L166:
        r160 = new LinearGradient(0.0f, 0.0f, r155, 0.0f, new int[]{Color.argb(r159, 0, 0, 0), Color.argb(255, 0, 0, 0)}, r156, Shader.TileMode.CLAMP);
        r147.f529882k = r160;
        r147.f529884m = r155;
        r147.f529885n = r159;
    L167:
        r147.f529874c.reset();
        r147.f529874c.setScale(r158 / r155, 1.0f);
        r147.f529874c.postTranslate(r150, 0.0f);
        r160.setLocalMatrix(r147.f529874c);
        r147.f529872a.setShader(r160);
        int r161 = 255;
        r210.drawRect(r150, r151, r158 + r150, r154, r147.f529872a);
    L169:
        if (r117 == false) goto L184;
        float r162 = r147.f529879h;
        float r163 = r155 * r162;
        if (r163 <= 0.0f) goto L184;
        int r164 = MathKt.roundToInt(r161 * (1.0f - RangesKt.coerceIn(r162, 0.0f, 1.0f)));
        LinearGradient r165 = r147.f529883l;
        if (r165 != null) goto L175;
    L182:
        r165 = new LinearGradient(0.0f, 0.0f, r155, 0.0f, new int[]{Color.argb(r161, 0, 0, 0), Color.argb(r164, 0, 0, 0)}, r156, Shader.TileMode.CLAMP);
        r147.f529883l = r165;
        r147.f529884m = r155;
        r147.f529886o = r164;
    L183:
        r147.f529875d.reset();
        r147.f529875d.setScale(r163 / r155, 1.0f);
        float r166 = r153 - r163;
        r147.f529875d.postTranslate(r166, 0.0f);
        r165.setLocalMatrix(r147.f529875d);
        r147.f529872a.setShader(r165);
        r210.drawRect(r166, r151, r153, r154, r147.f529872a);
        goto L184
    L175:
        if (r147.f529884m != r155) goto L177;
        boolean r167 = true;
    L178:
        if (r167 == false) goto L182;
        if (r147.f529886o != r164) goto L182;
    L177:
        r167 = false;
    L184:
        r147.f529872a.setShader(null);
        r147.f529872a.setXfermode(null);
        goto L185
    L159:
        if (r147.f529884m != r155) goto L161;
        boolean r168 = true;
    L162:
        if (r168 == false) goto L166;
        if (r147.f529885n != r159) goto L166;
    L161:
        r168 = false;
    L168:
        r161 = 255;
    L185:
        r210.restoreToCount(r146);
        return;
    L135:
        r143 = r133;
        goto L136
    L131:
        r140 = r133;
        goto L132
    L187:
        p(r210);
        return;
    L91:
        if (r115.f529877f <= 0.0f) goto L105;
        if (r118 <= 0) goto L105;
        if (r119 <= 0) goto L105;
        if (r115.f529878g <= 0.0f) goto L97;
        boolean r169 = true;
    L98:
        if (r169 == false) goto L100;
    L104:
        r120 = true;
        goto L106
    L100:
        if (r115.f529879h <= 0.0f) goto L102;
        boolean r170 = true;
    L103:
        if (r170 == false) goto L105;
    L102:
        r170 = false;
        goto L103
    L97:
        r169 = false;
        goto L98
    L87:
        r117 = false;
        goto L88
    L83:
        r116 = false;
        goto L85
    L50:
        if (r111 != r107) goto L52;
        boolean r171 = true;
    L53:
        if (r171 == false) goto L55;
    L52:
        r171 = false;
        goto L53
    L47:
        r112 = false;
        goto L48
    L39:
        if (r110.f529881j != r107) goto L41;
        boolean r172 = true;
    L42:
        if (r172 == false) goto L44;
    L41:
        r172 = false;
        goto L42
    L36:
        r108 = false;
        goto L37
    L32:
        r107 = 0.0f;
        goto L34
    L29:
        r106 = 0.0f;
    L61:
        if (r110.f529878g <= 0.0f) goto L63;
        boolean r173 = true;
    L64:
        if (r173 == false) goto L66;
    L72:
        boolean r174 = true;
    L73:
        ValueAnimator r175 = r110.f529887p;
        if (r175 == null) goto L77;
        r175.cancel();
    L77:
        r110.f529887p = null;
        r110.f529878g = 0.0f;
        r110.f529879h = 0.0f;
        r110.f529880i = 0.0f;
        r110.f529881j = 0.0f;
        r110.f529884m = -1.0f;
        r110.f529882k = null;
        r110.f529883l = null;
        r110.f529885n = -1;
        r110.f529886o = -1;
        if (r174 == false) goto L80;
        invalidate();
        goto L80
    L66:
        if (r110.f529879h <= 0.0f) goto L68;
        boolean r176 = true;
    L69:
        if (r176 == true) goto L72;
        r174 = false;
        goto L73
    L68:
        r176 = false;
        goto L69
    L63:
        r173 = false;
    L21:
        r105 = true;
    L15:
        r104 = true;
        goto L17
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateDefaultLayoutParams();
    }

    public final void h(i r100) {
        i(r100, this.f403141n.isEmpty());
    }

    public final void j(View r100) {
        if ((r100 instanceof OTabItem) == false) goto L18;
        OTabItem r101 = (OTabItem) r100;
        i r102 = s(0);
        CharSequence r103 = r101.f403129a;
        if (r103 == null) goto L7;
        r102.f403203b = r103;
        r102.b();
    L7:
        Drawable r104 = r101.f403130b;
        if (r104 == null) goto L10;
        r102.f403202a = r104;
        r102.b();
    L10:
        int r105 = r101.f403131c;
        if (r105 == 0) goto L14;
        r102.f403206e = LayoutInflater.from(r102.f403208g.getContext()).inflate(r105, r102.f403208g, false);
        r102.b();
    L14:
        if (TextUtils.isEmpty(r101.getContentDescription()) == true) goto L16;
        r102.f403204c = r101.getContentDescription();
        r102.b();
    L16:
        h(r102);
        return;
    L18:
        if ((r100 instanceof h) == false) goto L23;
        if (indexOfChild(r100) != (-1)) goto L33;
        super.addView(r100, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L33:
        return;
    L23:
        if ((r100 instanceof OBottomTabItem) == false) goto L35;
        OBottomTabItem r106 = (OBottomTabItem) r100;
        OBottomTabItemCustomView r107 = new OBottomTabItemCustomView(getContext());
        i r108 = s(0);
        if (r106.getText() == null) goto L28;
        r107.getTitle().setText(r106.getText());
        r108.f403203b = r106.getText();
        r108.b();
    L28:
        if (r106.getIcon() == null) goto L30;
        r107.getIcon().setImageDrawable(r106.getIcon());
    L30:
        r107.setTextColor(this.D);
        r107.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor(getContext(), R.color.oui_accent_bg_light)));
        r108.f403206e = r107;
        r108.b();
        h(r108);
        return;
    }

    public final void k(int r100) {
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L23:
        y(r100, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        h r101 = this.f403150t;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L15;
        if (r101.getChildAt(r103).getWidth() <= 0) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L23;
        int r105 = getScrollX();
        int r106 = m(r100, 0.0f);
        if (r105 == r106) goto L21;
        q();
        this.T.setIntValues(new int[]{r105, r106});
        this.T.start();
    L21:
        this.f403150t.c(r100, 200);
        return;
    L15:
        r104 = false;
        goto L16
    }

    public final int o(int r100) {
        Resources r101 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        c r101 = (c) r100.getAnimatedValue();
        Rect r102 = this.f403134b2;
        r102.left = (int) r101.f403173a;
        r102.right = (int) r101.f403174b;
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public final void p(Canvas r110) {
        if (isInEditMode() == false) goto L5;
    L47:
        super.dispatchDraw(r110);
        return;
    L5:
        if (getTabCount() <= 0) goto L47;
        float r100 = getBounceTranslation();
        int r101 = getHeight();
        int r102 = getPaddingLeft();
        int r103 = getPaddingTop();
        int r104 = getPaddingBottom();
        if (this.f403133b1 >= 0.0f) goto L9;
        this.f403133b1 = r101 - (this.f403135g1 * 2.0f);
    L9:
        float r105 = this.f403137h1;
        if (r105 >= 0.0f) goto L12;
    L13:
        this.f403137h1 = this.f403133b1;
    L14:
        float r106 = this.f403137h1 + (this.f403135g1 / 2.0f);
        float r107 = getWidth() + r100;
        if (this.f403147q == true) goto L20;
        int r108 = this.G1;
        if (r108 == 0) goto L20;
        this.f403140k1.setColor(r108);
        this.f403153v1.set(r100, r103, r107, r101 - r104);
        r110.drawRoundRect(this.f403153v1, r106, r106, this.f403140k1);
    L20:
        if (this.f403145p1.getColor() == 0) goto L22;
        this.f403153v1.set(r100, r103, r107, r101 - r104);
        r110.drawRoundRect(this.f403153v1, r106, r106, this.f403145p1);
    L22:
        int r109 = 0;
        if (this.H1 == true) goto L25;
        View r111 = this.f403150t.getChildAt(getSelectedTabPosition());
        if (r111 == null) goto L33;
        this.f403134b2.left = r111.getLeft();
        this.f403134b2.right = r111.getRight();
    L33:
        if (this.M1 == true) goto L47;
        int r112 = this.L0;
        if (r112 == 0) goto L38;
        this.f403136g2.setColor(r112);
        Rect r113 = this.f403134b2;
        float r114 = (r113.left + r102) + r100;
        float r115 = this.f403135g1;
        float r116 = (r113.right + r102) + r100;
        float r117 = r115 + this.f403133b1;
        float r118 = this.f403137h1;
        r110.drawRoundRect(r114, r115, r116, r117, r118, r118, this.f403136g2);
    L38:
        if (this.P0 == 0) goto L47;
        if (this.G1 != 0) goto L47;
    L42:
        if (r109 >= getTabCount()) goto L47;
        if (r109 == getSelectedTabPosition()) goto L46;
        View r119 = this.f403150t.getChildAt(r109);
        this.f403136g2.setColor(this.P0);
        float r120 = (r119.getLeft() + r102) + r100;
        float r121 = this.f403135g1;
        float r122 = (r119.getRight() + r102) + r100;
        float r123 = this.f403135g1 + this.f403133b1;
        float r124 = this.f403137h1;
        r110.drawRoundRect(r120, r121, r122, r123, r124, r124, this.f403136g2);
    L46:
        r109 = r109 + 1;
        goto L42
    L25:
        if (this.V1 == false) goto L33;
        this.V1 = false;
        View r125 = this.f403150t.getChildAt(getSelectedTabPosition());
        if (r125 == null) goto L33;
        this.f403134b2.left = r125.getLeft();
        this.f403134b2.right = r125.getRight();
        goto L33
    L12:
        if (r105 <= (this.f403133b1 / 2.0f)) goto L14;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i s(int r110) {
        i r100 = (i) J2.acquire();
        if (r100 != null) goto L5;
        r100 = new i();
    L5:
        r100.f403207f = this;
        Pools.SimplePool r101 = this.E2;
        if (r101 == null) goto L8;
        j r102 = (j) r101.acquire();
    L10:
        if (r102 != null) goto L21;
        r102 = new j(this, getContext(), this.M1, this.Q1, this.S1);
        WeakReference<View> r103 = this.f403148r;
        if (r103 != null) goto L14;
    L16:
        Drawable r104 = this.V0;
        if (r104 == null) goto L27;
        if (this.M1 == true) goto L27;
        r102.setBackground(r104.mutate());
        r102.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L27:
        if (isEnabled() == false) goto L29;
        float r105 = 1.0f;
    L30:
        int r106 = j.f403209w;
        r102.h(r105);
        r102.setFocusable(true);
        r100.f403208g = r102;
        if (r110 > 0) goto L33;
        r102.setTab(r100);
    L37:
        return r100;
    L33:
        if (r100 == r102.f403210h) goto L35;
        r102.f403210h = r100;
    L35:
        r100.f403206e = LayoutInflater.from(r102.getContext()).inflate(r110, r100.f403208g, false);
        r100.b();
        goto L37
    L29:
        r105 = this.f403151u;
        goto L30
    L14:
        if (r103.get() == null) goto L16;
        r102.setBackdropTarget(this.f403148r.get());
        goto L16
    L21:
        boolean r107 = this.M1;
        r102.f403217o = r107;
        if (r107 == false) goto L24;
        r102.i(r102.isSelected());
    L25:
        com.obric.oui.material.c[] r108 = this.Q1;
        com.obric.oui.material.c[] r109 = this.S1;
        r102.f403219q = r108;
        r102.f403220r = r109;
        r102.f403218p = r108;
        goto L27
    L24:
        r102.f();
        r102.d();
        r102.c(false);
        goto L25
    L8:
        r102 = null;
        goto L10
    }

    public void setAutoFillWhenScrollable(boolean r100) {
        this.P = r100;
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r100) {
        if (r100 != null) goto L4;
        this.f403148r = new WeakReference(this);
    L5:
        View r101 = this.f403148r.get();
        if (r101 == null) goto L15;
        if (r100 != null) goto L9;
        OMaterialHelper.t(this, null);
    L11:
        if (this.M1 == false) goto L17;
        int r102 = this.f403141n.size();
        int r103 = 0;
    L13:
        if (r103 >= r102) goto L18;
        ((i) ListProtector.get(this.f403141n, r103)).f403208g.setBackdropTarget(r101);
        r103 = r103 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L9:
        OMaterialHelper.t(this, r101);
        goto L11
    L15:
        return;
    L4:
        this.f403148r = new WeakReference(r100);
        goto L5
    }

    public void setCustomTabViewResId(int r100) {
        this.O = r100;
    }

    public void setEdgeFadeEnabled(boolean r100) {
        pma.b r101 = this.f403138h2;
        if (r101.f529876e != r100) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == false) goto L9;
        invalidate();
        return;
    L9:
        return;
    L5:
        r101.f529876e = r100;
        r102 = true;
        goto L6
    }

    public void setEdgeFadeLength(float r100) {
        pma.b r101 = this.f403138h2;
        r101.getClass();
        float r102 = RangesKt.coerceAtLeast(r100, 0.0f);
        boolean r103 = false;
        if (r101.f529877f != r102) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r101.f529877f = r102;
        r101.f529884m = -1.0f;
        r101.f529882k = null;
        r101.f529883l = null;
        r101.f529885n = -1;
        r101.f529886o = -1;
        r103 = true;
    L9:
        if (r103 == false) goto L12;
        invalidate();
        return;
    L12:
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f403150t.setEnabled(r100);
    }

    public void setIndicatorAnimEnable(boolean r100) {
        this.H1 = r100;
        invalidate();
    }

    public void setIndicatorBounceEnable(boolean r100) {
        this.L1 = r100;
    }

    public void setIndicatorCornerRadius(float r100) {
        this.f403137h1 = r100;
        invalidate();
    }

    public void setOnTabSelectedListener(e r100) {
        e r101 = this.Q;
        if (r101 == null) goto L5;
        this.R.remove(r101);
    L5:
        this.Q = r100;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.R.contains(r100) == true) goto L12;
        this.R.add(r100);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r100) {
        q();
        this.T.addListener(r100);
    }

    public void setSelectedTabHorizontalPadding(int r100) {
        this.f403150t.getClass();
    }

    public void setSelectedTabIndicatorColor(int r100) {
        h r101 = this.f403150t;
        if (r101.f403177i.getColor() == r100) goto L6;
        r101.f403177i.setColor(r100);
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r100) {
        h r101 = this.f403150t;
        if (r101.f403176h == r100) goto L6;
        r101.f403176h = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setShowSelectedIndicator(Boolean r100) {
        h r101 = this.f403150t;
        r101.f403190v = r100.booleanValue();
    }

    public void setShowTopLine(Boolean r100) {
        this.f403150t.d(r100.booleanValue());
    }

    public void setTabBackgroundResId(int r100) {
        this.G = r100;
    }

    public void setTabDisabledAlpha(float r100) {
        this.f403151u = Math.max(0.0f, Math.min(1.0f, r100));
    }

    public void setTabGravity(int r100) {
        if (this.M == r100) goto L6;
        this.M = r100;
        l();
        return;
    }

    public void setTabMargin(int r100) {
        this.f403152v = o(r100);
        int r101 = 0;
    L4:
        if (r101 >= getTabCount()) goto L6;
        View r102 = this.f403150t.getChildAt(r101);
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r103.leftMargin = o(r100);
        r103.rightMargin = o(r100);
        r102.setLayoutParams(r103);
        r101 = r101 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r100) {
        this.K = r100;
        this.I = r100;
    }

    public void setTabMinWidth(int r100) {
        this.f403132J = r100;
    }

    public void setTabMode(String r100) {
        r100.getClass();
        if (r100.equals("scrollable") == true) goto L11;
        if (r100.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.N == 1) goto L14;
        this.N = 1;
        l();
        return;
    L14:
        return;
    L11:
        if (this.N == 0) goto L16;
        this.N = 0;
        l();
        return;
    }

    public void setTabPaddingBottom(int r100) {
        this.C = r100;
    }

    public void setTabPaddingEnd(int r100) {
        this.B = r100;
    }

    public void setTabPaddingStart(int r100) {
        this.f403162z = r100;
    }

    public void setTabPaddingTop(int r100) {
        this.A = r100;
    }

    public void setTabTextColors(ColorStateList r100) {
        if (this.D == r100) goto L7;
        this.D = r100;
        int r101 = this.f403141n.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((i) ListProtector.get(this.f403141n, r102)).b();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabTextSize(float r100) {
        if (this.E == r100) goto L7;
        this.E = r100;
        int r101 = this.f403141n.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((i) ListProtector.get(this.f403141n, r102)).b();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r100) {
        x(r100, false);
    }

    public void setupWithViewPager(ViewPager r100) {
        A(r100, false);
    }

    public final void v(int r100) {
        if (r100 < this.f403141n.size()) goto L5;
        return;
    L5:
        if (this.f403141n.isEmpty() == true) goto L13;
        i r101 = (i) ListProtector.get(this.f403141n, r100);
        if (r101 == null) goto L12;
        w(r101, true);
        return;
    L12:
        return;
    }

    public void setTabMode(int r100) {
        if (r100 == this.N) goto L6;
        this.N = r100;
        l();
        return;
    }

    public OTabLayoutBase(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static ColorStateList n(int r100, int r101) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r101, r100});
    }

    public final void A(ViewPager r100, boolean r101) {
        ViewPager r102 = this.U;
        if (r102 == null) goto L10;
        TabLayoutOnPageChangeListener r103 = this.f403139k0;
        if (r103 == null) goto L7;
        r102.removeOnPageChangeListener(r103);
    L7:
        b r104 = this.f403144p0;
        if (r104 == null) goto L10;
        this.U.removeOnAdapterChangeListener(r104);
    L10:
        k r105 = this.S;
        if (r105 == null) goto L14;
        this.R.remove(r105);
        this.S = null;
    L14:
        if (r100 == null) goto L28;
        this.U = r100;
        if (this.f403139k0 != null) goto L18;
        this.f403139k0 = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r106 = this.f403139k0;
        r106.f403164b = 0;
        r106.f403165c = 0;
        r100.addOnPageChangeListener(r106);
        k r107 = new k(r100);
        this.S = r107;
        if (this.R.contains(r107) == true) goto L21;
        this.R.add(r107);
    L21:
        PagerAdapter r108 = r100.getAdapter();
        if (r108 == null) goto L25;
        x(r108, true);
    L25:
        if (this.f403144p0 != null) goto L27;
        this.f403144p0 = new b(this);
    L27:
        b r109 = this.f403144p0;
        r109.f403171a = true;
        r100.addOnAdapterChangeListener(r109);
        y(r100.getCurrentItem(), 0.0f, true, true);
    L29:
        this.H0 = r101;
        return;
    L28:
        this.U = null;
        x(null, false);
        goto L29
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        j(r100);
    }

    public final void i(i r100, boolean r110) {
        int r101 = this.f403141n.size();
        if (r100.f403207f != this) goto L17;
        r100.f403205d = r101;
        ListProtector.add(this.f403141n, r101, r100);
        int r102 = this.f403141n.size();
        int r103 = r101;
    L5:
        r103 = r103 + 1;
        if (r103 >= r102) goto L8;
        ((i) ListProtector.get(this.f403141n, r103)).f403205d = r103;
        goto L5
    L8:
        j r104 = r100.f403208g;
        h r105 = this.f403150t;
        int r106 = r100.f403205d;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -1);
        C(r107);
        r105.addView(r104, r106, r107);
        r100.f403208g.setOnTouchListener(new com.obric.oui.tab.a(this, r101));
        if (r110 == false) goto L15;
        OTabLayoutBase r111 = r100.f403207f;
        if (r111 == null) goto L14;
        r111.w(r100, true);
        return;
    L14:
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final int m(int r100, float r101) {
        int r102 = 0;
        if (this.N != 0) goto L21;
        View r103 = this.f403150t.getChildAt(r100);
        int r104 = r100 + 1;
        if (r104 >= this.f403150t.getChildCount()) goto L7;
        View r105 = this.f403150t.getChildAt(r104);
    L8:
        if (r103 == null) goto L10;
        int r106 = r103.getWidth();
    L11:
        if (r105 == null) goto L13;
        int r107 = r105.getWidth();
    L14:
        if (r103 == null) goto L16;
        r102 = r103.getLeft();
    L16:
        int r108 = (r102 + (r106 / 2)) - (getWidth() / 2);
        int r109 = (int) ((((r106 + r107) + (this.f403152v * 4)) * 0.5f) * r101);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r108 + r109;
    L20:
        return r108 - r109;
    L13:
        r107 = 0;
        goto L14
    L10:
        r106 = 0;
        goto L11
    L7:
        r105 = null;
        goto L8
    L21:
        return 0;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = (o(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r103 = getMinimumHeight();
        if (r103 <= 0) goto L5;
        r102 = r103;
    L5:
        int r104 = View.MeasureSpec.getMode(r101);
        if (r104 == Integer.MIN_VALUE) goto L10;
        if (r104 == 0) goto L9;
        int r105 = View.MeasureSpec.makeMeasureSpec(Math.max(r102, View.MeasureSpec.getSize(r101)), 1073741824);
    L11:
        int r106 = View.MeasureSpec.getSize(r100);
        if (View.MeasureSpec.getMode(r100) == 0) goto L18;
        int r107 = this.K;
        if (r107 > 0) goto L17;
        r107 = r106 - o(56);
    L17:
        this.H = r107;
    L18:
        super.onMeasure(r100, r105);
        boolean r108 = true;
        if (getChildCount() != 1) goto L35;
        boolean r109 = false;
        View r110 = getChildAt(0);
        int r111 = this.N;
        if (r111 == 0) goto L28;
        if (r111 == 1) goto L25;
    L32:
        if (r109 == false) goto L36;
        int r112 = HorizontalScrollView.getChildMeasureSpec(r105, getPaddingTop() + getPaddingBottom(), r110.getLayoutParams().height);
        r110.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r112);
        return;
    L36:
        return;
    L25:
        if (r110.getMeasuredWidth() != getMeasuredWidth()) goto L31;
    L30:
        r108 = false;
    L31:
        r109 = r108;
        goto L32
    L28:
        if (r110.getMeasuredWidth() >= getMeasuredWidth()) goto L30;
    L35:
        return;
    L9:
        r105 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
        goto L11
    L10:
        r105 = View.MeasureSpec.makeMeasureSpec(Math.min(r102, View.MeasureSpec.getSize(r101)), 1073741824);
        goto L11
    }

    public final void w(i r100, boolean r101) {
        i r102 = this.f403142o;
        if (r102 != r100) goto L9;
        if (r102 == null) goto L47;
        int r103 = this.R.size() - 1;
    L6:
        if (r103 < 0) goto L8;
        ((e) ListProtector.get(this.R, r103)).a(r100);
        r103 = r103 - 1;
        goto L6
    L8:
        k(r100.f403205d);
        return;
    L47:
        return;
    L9:
        if (r100 == null) goto L11;
        int r104 = r100.f403205d;
    L13:
        if (r101 == false) goto L22;
        if (r102 != null) goto L16;
    L17:
        if (r104 == (-1)) goto L19;
        y(r104, 0.0f, true, true);
    L20:
        if (r104 == (-1)) goto L22;
        setSelectedTabView(r104);
    L19:
        k(r104);
        goto L20
    L16:
        if (r102.f403205d != (-1)) goto L19;
    L22:
        if (r102 == null) goto L26;
        int r105 = this.R.size() - 1;
    L24:
        if (r105 < 0) goto L26;
        ((e) ListProtector.get(this.R, r105)).b(r102);
        r105 = r105 - 1;
    L26:
        i r106 = this.f403142o;
        if (r106 != null) goto L29;
        r106 = r100;
    L29:
        this.f403143p = r106;
        this.f403142o = r100;
        if (this.H1 == false) goto L43;
        View r107 = this.f403150t.getChildAt(getSelectedTabPosition());
        if (r107 == null) goto L43;
        this.f403158x2.f403173a = r107.getLeft();
        this.f403158x2.f403174b = r107.getRight();
        j r108 = this.f403143p.f403208g;
        this.f403161y2.f403173a = r108.getLeft();
        this.f403161y2.f403174b = r108.getRight();
        c r109 = this.f403161y2;
        float r110 = r109.f403173a;
        c r111 = this.f403158x2;
        if (r110 == r111.f403173a) goto L37;
    L39:
        this.f403146p2.setObjectValues(new Object[]{r109, r111});
        if (this.L1 == false) goto L42;
        this.f403146p2.setInterpolator(this.f403154v2);
    L42:
        this.f403146p2.setDuration(350);
        this.f403146p2.start();
        goto L43
    L37:
        if (r109.f403174b != r111.f403174b) goto L39;
        invalidate();
    L43:
        if (r100 == null) goto L52;
        int r112 = this.R.size() - 1;
    L45:
        if (r112 < 0) goto L53;
        ((e) ListProtector.get(this.R, r112)).c(r100);
        r112 = r112 - 1;
        goto L45
    L53:
        return;
    L52:
        return;
    L11:
        r104 = -1;
        goto L13
    }

    public final void x(PagerAdapter r100, boolean r101) {
        PagerAdapter r102 = this.V;
        if (r102 == null) goto L7;
        f r103 = this.W;
        if (r103 == null) goto L7;
        r102.unregisterDataSetObserver(r103);
    L7:
        this.V = r100;
        if (r101 == false) goto L14;
        if (r100 == null) goto L14;
        if (this.W != null) goto L13;
        this.W = new f(this);
    L13:
        r100.registerDataSetObserver(this.W);
    L14:
        t();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        j(r100);
    }

    public OTabLayoutBase(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        this.f403141n = new ArrayList();
        this.f403148r = null;
        this.f403151u = 0.3f;
        this.f403155w = 0;
        this.f403156x = 0;
        this.H = Integer.MAX_VALUE;
        this.I = Integer.MAX_VALUE;
        this.R = new ArrayList();
        this.P0 = 0;
        this.V0 = null;
        this.f403133b1 = 0.0f;
        this.f403135g1 = 0.0f;
        this.f403137h1 = 0.0f;
        Paint r100 = new Paint(1);
        this.f403140k1 = r100;
        new Paint(1);
        Paint r101 = new Paint(1);
        this.f403145p1 = r101;
        this.f403153v1 = new RectF();
        new RectF();
        this.f403157x1 = new RectF();
        this.f403160y1 = new RectF();
        this.H1 = true;
        this.L1 = false;
        this.M1 = false;
        this.P1 = null;
        this.Q1 = null;
        this.S1 = null;
        this.T1 = null;
        this.V1 = true;
        this.f403134b2 = new Rect();
        new Rect();
        this.f403136g2 = new Paint();
        pma.b r110 = new pma.b();
        this.f403138h2 = r110;
        this.f403154v2 = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        c r111 = new c();
        this.f403158x2 = r111;
        c r112 = new c();
        this.f403161y2 = r112;
        this.E2 = new Pools.SimplePool(12);
        this.G2 = null;
        this.H2 = null;
        boolean r113 = vma.h.b(r210.getResources().getConfiguration().fontScale);
        if (OMaterialHelper.j(r210) == true) goto L5;
    L7:
        boolean r114 = false;
    L8:
        this.f403147q = r114;
        setHorizontalScrollBarEnabled(false);
        h r102 = new h(this, r210);
        this.f403150t = r102;
        r102.setDuplicateParentStateEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r102, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r103 = r210.obtainStyledAttributes(r211, new int[]{R.attr.tabBackground, R.attr.tabContentStart, R.attr.tabGravity, R.attr.tabIconTint, R.attr.tabIconTintMode, R.attr.tabIndicator, R.attr.tabIndicatorAnimationDuration, R.attr.tabIndicatorColor, R.attr.tabIndicatorFullWidth, R.attr.tabIndicatorGravity, R.attr.tabIndicatorHeight, R.attr.tabInlineLabel, R.attr.tabMaxWidth, R.attr.tabMinWidth, R.attr.tabMode, R.attr.tabPadding, R.attr.tabPaddingBottom, R.attr.tabPaddingEnd, R.attr.tabPaddingStart, R.attr.tabPaddingTop, R.attr.tabRippleColor, R.attr.tabSelectedTextColor, R.attr.tabTextAppearance, R.attr.tabTextColor, R.attr.tabUnboundedRipple}, r212, R.style.OTabText);
        int r115 = r103.getDimensionPixelSize(10, 0);
        if (r102.f403176h == r115) goto L11;
        r102.f403176h = r115;
        ViewCompat.postInvalidateOnAnimation(r102);
    L11:
        int r104 = r103.getColor(7, ContextCompat.getColor(getContext(), R.color.oui_accent_7));
        if (r102.f403177i.getColor() == r104) goto L14;
        r102.f403177i.setColor(r104);
        ViewCompat.postInvalidateOnAnimation(r102);
    L14:
        this.f403159y = r103.getDimensionPixelSize(13, o(56));
        int r105 = r103.getDimensionPixelSize(15, 0);
        this.f403162z = r105;
        this.A = r105;
        this.B = r105;
        this.C = r105;
        this.f403162z = r103.getDimensionPixelSize(18, r105);
        this.A = r103.getDimensionPixelSize(19, this.A);
        this.B = r103.getDimensionPixelSize(17, this.B);
        this.C = r103.getDimensionPixelSize(16, this.C);
        int r106 = r103.getResourceId(22, R.style.TextAppearance_Design_Tab);
        int r107 = this.f403162z;
        if (r107 <= 0) goto L19;
        if (r113 == false) goto L19;
        this.f403162z = (r107 * 2) / 3;
    L19:
        int r108 = this.B;
        if (r108 <= 0) goto L23;
        if (r113 == false) goto L23;
        this.B = (r108 * 2) / 3;
    L23:
        TypedArray r109 = r210.obtainStyledAttributes(r106, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        this.E = r109.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L128
        this.D = r109.getColorStateList(3);     // Catch: Throwable -> L128
        r109.recycle();
        if (r103.hasValue(23) == false) goto L28;
        this.D = r103.getColorStateList(23);
    L28:
        boolean r116 = r103.hasValue(21);
        if (r116 == false) goto L31;
        int r117 = r103.getColor(21, 0);
    L32:
        this.f403132J = r103.getDimensionPixelSize(13, -1);
        int r118 = r103.getDimensionPixelSize(12, -1);
        this.K = r118;
        if (r118 <= 0) goto L35;
        this.I = r118;
    L35:
        this.G = r103.getResourceId(0, 0);
        r103.getDimensionPixelSize(1, 0);
        this.N = r103.getInt(14, 1);
        this.M = r103.getInt(2, 1);
        TypedArray r119 = r210.obtainStyledAttributes(r211, new int[]{android.R.attr.minHeight}, r212, 0);
        int r120 = r119.getDimensionPixelSize(0, 0);
        if (r120 <= 0) goto L38;
        setMinimumHeight(r120);
    L38:
        r119.recycle();
        TypedArray r121 = r210.obtainStyledAttributes(r211, new int[]{R.attr.oui_showBottomLine, R.attr.oui_showSelectedIndicator, R.attr.oui_showTopLine, R.attr.oui_tabIndicatorFullWidth, R.attr.oui_tabSelectedTextSize, R.attr.oui_tabTextSize, R.attr.oui_tab_spec, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetMaterial, R.attr.oui_widgetShadow});
        boolean r122 = r121.getBoolean(3, true);     // Catch: Throwable -> L125
        if (r102.f403194z == r122) goto L42;
        r102.f403194z = r122;     // Catch: Throwable -> L125
        ViewCompat.postInvalidateOnAnimation(r102);     // Catch: Throwable -> L125
    L42:
        boolean r123 = r121.getBoolean(0, false);     // Catch: Throwable -> L125
        r102.f403188t = r123;     // Catch: Throwable -> L125
        if (r123 == false) goto L45;
        Paint r124 = new Paint();     // Catch: Throwable -> L125
        r102.f403191w = r124;     // Catch: Throwable -> L125
        r124.setColor(ContextCompat.getColor(r102.getContext(), R.color.oui_line_2));     // Catch: Throwable -> L125
        r102.f403191w.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L125
    L45:
        r102.d(r121.getBoolean(2, false));     // Catch: Throwable -> L125
        r102.f403190v = r121.getBoolean(1, true);     // Catch: Throwable -> L125
        this.F = r121.getDimensionPixelSize(4, 0);     // Catch: Throwable -> L125
        this.E = r121.getDimensionPixelSize(5, (int) this.E);     // Catch: Throwable -> L125
        this.f403149s = r121.getResourceId(9, R.style.OUIShadow_Oui_Shadow_Regular);     // Catch: Throwable -> L125
        if (r114 == false) goto L48;
        this.f403147q = r121.getBoolean(7, true);     // Catch: Throwable -> L125
    L48:
        int r125 = r121.getInt(6, -1);     // Catch: Throwable -> L125
        if (r125 != 0) goto L51;
    L56:
        int r126 = o(4);     // Catch: Throwable -> L125
        z(r126, r126, r126, r126);     // Catch: Throwable -> L125
        o(4);     // Catch: Throwable -> L125
    L57:
        String r127 = r121.getString(8);     // Catch: Throwable -> L125
        if (r127 != null) goto L60;
        r127 = r210.getString(R.string.oui_material_bg_floating);     // Catch: Throwable -> L125
    L60:
        r121.recycle();
        this.L = getResources().getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        pla.d.f(1.5f, r210);
        pla.d.f(1.5f, r210);
        this.F2 = getResources().getConfiguration().orientation;
        r103.recycle();
        TypedArray r128 = r210.obtainStyledAttributes(r211, new int[]{R.attr.bar_color, R.attr.bar_stroke_color, R.attr.bar_stroke_width, R.attr.divider_color, R.attr.divider_padding, R.attr.divider_width, R.attr.enableDefaultMaskBackground, R.attr.indicator_anim_duration, R.attr.indicator_anim_enable, R.attr.indicator_background, R.attr.indicator_bounce_enable, R.attr.indicator_color, R.attr.indicator_corner_radius, R.attr.indicator_height, R.attr.indicator_marginBottom, R.attr.indicator_marginLeft, R.attr.indicator_marginRight, R.attr.indicator_marginTop, R.attr.indicator_spacing, R.attr.indicator_unselected_color, R.attr.maskBackground, R.attr.mask_blur_radius, R.attr.oui_alpha_disabled, R.attr.oui_bottomActionBarType, R.attr.oui_widgetBlurBlendModes, R.attr.oui_widgetBlurColors, R.attr.oui_widgetBlurRadius, R.attr.oui_widgetFitInsetBottom, R.attr.oui_widgetFitInsetLeft, R.attr.oui_widgetFitInsetRight, R.attr.oui_widgetFitInsetTop, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowPressed, R.attr.shadow_normal, R.attr.shadow_pressed, R.attr.tab_divider, R.attr.tab_edgeFadeEnabled, R.attr.tab_edgeFadeLength, R.attr.tab_enableMaterial, R.attr.tab_material, R.attr.tab_material_selected, R.attr.tab_padding, R.attr.tab_space_equal, R.attr.tab_textAllCaps, R.attr.tab_textBold, R.attr.tab_textPressedColor, R.attr.tab_textSelectColor, R.attr.tab_textSelectedStyle, R.attr.tab_textSize, R.attr.tab_textStyle, R.attr.tab_textUnselectColor, R.attr.tab_width, R.attr.vibrate_on_tab_selected});
        Drawable r129 = r128.getDrawable(37);     // Catch: Throwable -> L122
        if (r129 == null) goto L64;
        r102.setDividerDrawable(r129);     // Catch: Throwable -> L122
        r102.setShowDividers(2);     // Catch: Throwable -> L122
    L64:
        this.L0 = r128.getColor(11, 0);     // Catch: Throwable -> L122
        this.P0 = r128.getColor(19, 0);     // Catch: Throwable -> L122
        Drawable r130 = r128.getDrawable(9);     // Catch: Throwable -> L122
        this.V0 = r130;     // Catch: Throwable -> L122
        this.f403133b1 = r128.getDimension(13, -1.0f);     // Catch: Throwable -> L122
        float r131 = r128.getDimension(12, -1.0f);     // Catch: Throwable -> L122
        this.f403137h1 = r131;     // Catch: Throwable -> L122
        if ((r130 instanceof GradientDrawable) == false) goto L67;
        ((GradientDrawable) r130).setCornerRadius(r131);     // Catch: Throwable -> L122
    L67:
        float r132 = r128.getDimension(18, o(4));     // Catch: Throwable -> L122
        this.f403135g1 = r132;     // Catch: Throwable -> L122
        int r133 = r128.getColor(0, 0);     // Catch: Throwable -> L122
        this.G1 = r133;     // Catch: Throwable -> L122
        if (r133 != 0) goto L70;
        z(0, 0, 0, 0);     // Catch: Throwable -> L122
    L70:
        this.H1 = r128.getBoolean(8, false);     // Catch: Throwable -> L122
        this.L1 = r128.getBoolean(10, true);     // Catch: Throwable -> L122
        boolean r134 = r128.getBoolean(38, false);     // Catch: Throwable -> L122
        if (r110.f529876e == r134) goto L74;
        r110.f529876e = r134;     // Catch: Throwable -> L122
    L74:
        Resources r135 = getResources();     // Catch: Throwable -> L122
        float r136 = RangesKt.coerceAtLeast(r128.getDimension(39, (WindowDisplayMetricsOverride.apply(r135, r135.getDisplayMetrics()).density * 20.0f) + 0.5f), 0.0f);     // Catch: Throwable -> L122
        if (r110.f529877f != r136) goto L77;
        boolean r137 = true;
    L78:
        if (r137 == true) goto L81;
        r110.f529877f = r136;     // Catch: Throwable -> L122
        r110.f529884m = -1.0f;     // Catch: Throwable -> L122
        r110.f529882k = null;     // Catch: Throwable -> L122
        r110.f529883l = null;     // Catch: Throwable -> L122
        r110.f529885n = -1;     // Catch: Throwable -> L122
        r110.f529886o = -1;     // Catch: Throwable -> L122
    L81:
        this.f403151u = Math.max(0.0f, Math.min(1.0f, r128.getFloat(22, this.f403151u)));     // Catch: Throwable -> L122
        r128.getResourceId(49, 0);     // Catch: Throwable -> L122
        r128.getResourceId(51, 0);     // Catch: Throwable -> L122
        int r138 = r128.getColor(47, 0);     // Catch: Throwable -> L122
        if (r114 == false) goto L85;
        this.M1 = r128.getBoolean(40, false);     // Catch: Throwable -> L122
    L85:
        if (this.M1 == false) goto L100;
        String r139 = r128.getString(41);     // Catch: Throwable -> L122
        this.P1 = r139;     // Catch: Throwable -> L122
        String r140 = r128.getString(42);     // Catch: Throwable -> L122
        if (TextUtils.isEmpty(r139) == false) goto L89;
        this.P1 = r210.getString(R.string.oui_material_bg_floating);     // Catch: Throwable -> L122
    L89:
        String r141 = this.P1;     // Catch: Throwable -> L122
        if (r() == true) goto L92;
        boolean r142 = true;
    L93:
        this.Q1 = MaterialToken.parseSet(r141, r142);     // Catch: Throwable -> L122
        if (TextUtils.isEmpty(r140) == true) goto L100;
        if (r() == true) goto L98;
        boolean r143 = true;
    L99:
        this.S1 = MaterialToken.parseSet(r140, r143);     // Catch: Throwable -> L122
        goto L100
    L98:
        r143 = false;
        goto L99
    L92:
        r142 = false;
    L100:
        int r144 = r128.getResourceId(36, 0);     // Catch: Throwable -> L122
        if (r144 == 0) goto L103;
        List<q> r145 = l.g(r210, r144);     // Catch: Throwable -> L122
        ArrayList r146 = new ArrayList(2);     // Catch: Throwable -> L122
        this.T1 = r146;     // Catch: Throwable -> L122
        ArrayList r147 = (ArrayList) r145;     // Catch: Throwable -> L122
        r146.add((q) r147.get(0));     // Catch: Throwable -> L122
        r146.add((q) r147.get(1));     // Catch: Throwable -> L122
    L103:
        r128.recycle();
        if (r116 == false) goto L108;
        if (r138 == 0) goto L107;
        int r148 = this.D.getDefaultColor();
        this.D = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed}, HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{ColorUtils.compositeColors(r138, r117), ColorUtils.compositeColors(r138, r148), r117, r148});
        goto L108
    L107:
        this.D = n(this.D.getDefaultColor(), r117);
    L108:
        ValueAnimator r149 = ValueAnimator.ofObject(new g(this), new Object[]{r112, r111});
        this.f403146p2 = r149;
        r149.addUpdateListener(this);
        r100.setStyle(Paint.Style.FILL);
        r101.setStyle(Paint.Style.STROKE);
        r101.setColor(0);
        float r150 = this.f403137h1 + (r132 / 2.0f);
        if (this.f403147q == false) goto L120;
        this.f403148r = new WeakReference(this);
        com.obric.oui.material.c[] r151 = MaterialToken.parseSet(r127, !r());
        if (r151 == null) goto L120;
        Resources r152 = getResources();
        OMaterialHelper.w(this, 2, r151, WindowDisplayMetricsOverride.apply(r152, r152.getDisplayMetrics()).density);
        GradientDrawable r153 = new GradientDrawable();
        r153.setShape(0);
        r153.setCornerRadius(r150);
        r153.setColor(0);
        setBackground(r153);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        if ((r130 instanceof GradientDrawable) == false) goto L116;
        ((GradientDrawable) r130).setColor(0);
    L116:
        if (OMaterialHelper.g(r210) != 1) goto L120;
        com.obric.oui.material.c r154 = r151[0];
        i0 r155 = r154.f401456e;
        if (r155 == null) goto L120;
        r101.setColor(r155.f399494b);
        r101.setStrokeWidth(o((int) r154.f401456e.f399493a));
    L120:
        B();
        l();
        return;
    L77:
        r137 = false;
    L122:
        th = move-exception;
        r128.recycle();
        throw th;
    L51:
        if (r125 == 1) goto L56;
        if (r125 == 2) goto L55;
        z(o(16), o(4), o(16), o(12));     // Catch: Throwable -> L125
        goto L57
    L55:
        z(o(12), o(6), o(12), o(6));     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        r121.recycle();
        throw th;
    L31:
        r117 = 0;
    L128:
        th = move-exception;
        r109.recycle();
        throw th;
    L5:
        if (OMaterialHelper.l() == false) goto L7;
        r114 = true;
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        j(r100);
    }

    public final void y(int r100, float r101, boolean r102, boolean r103) {
        int r104 = Math.round(r100 + r101);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.f403150t.getChildCount()) goto L25;
        if (r103 == false) goto L14;
        h r105 = this.f403150t;
        ValueAnimator r106 = r105.f403183o;
        if (r106 != null) goto L11;
    L13:
        r105.f403178j = r100;
        r105.f403179k = r101;
        r105.e();
        goto L14
    L11:
        if (r106.isRunning() == false) goto L13;
        r105.f403183o.cancel();
    L14:
        ValueAnimator r107 = this.T;
        if (r107 != null) goto L17;
    L19:
        scrollTo(m(r100, r101), 0);
        if (r102 == false) goto L24;
        setSelectedTabView(r104);
        return;
    L24:
        return;
    L17:
        if (r107.isRunning() == false) goto L19;
        this.T.cancel();
        goto L19
    }

    public final void z(int r100, int r101, int r102, int r103) {
        this.f403150t.setPadding(r100, r101, r102, r103);
    }
}
