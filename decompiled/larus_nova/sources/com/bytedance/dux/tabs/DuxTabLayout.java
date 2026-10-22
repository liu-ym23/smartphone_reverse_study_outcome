package com.bytedance.dux.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes15.dex */
@ViewPager.DecorView
public class DuxTabLayout extends HorizontalScrollView {
    public static final FastOutSlowInInterpolator I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Pools.SynchronizedPool f205674J = null;
    public ViewPager A;
    public PagerAdapter B;
    public e C;
    public TabLayoutOnPageChangeListener D;
    public b E;
    public boolean F;
    public final Pools.SimplePool G;
    public final int H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<g> f205675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f205676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f205677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f205678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f205680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f205681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f205684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f205685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f205686l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f205687m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f205688n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f205689o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f205690p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f205691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f205692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f205693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f205694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f205695u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f205696v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d f205697w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList<d> f205698x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public i f205699y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f205700z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DuxTabLayout> f205701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f205702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f205703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f205704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f205705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArgbEvaluator f205706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AccelerateInterpolator f205707g;

        public TabLayoutOnPageChangeListener(DuxTabLayout r100) {
            this.f205706f = new ArgbEvaluator();
            this.f205707g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f205701a = new WeakReference(r100);
            this.f205705e = r100.getTabTextColors().getColorForState(DuxTabLayout.a(), 0);
            this.f205704d = r100.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f205702b = this.f205703c;
            this.f205703c = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            DuxTabLayout r101 = this.f205701a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getSelectedTabPosition() != r100) goto L7;
            return;
        L7:
            if (r100 >= r101.getTabCount()) goto L27;
            int r102 = this.f205703c;
            if (r102 != 0) goto L11;
        L16:
            boolean r103 = true;
        L17:
            if (r100 >= 0) goto L19;
        L22:
            g r104 = null;
        L23:
            r101.k(r104, r103);
            return;
        L19:
            if (r100 >= r101.getTabCount()) goto L22;
            r104 = (g) ListProtector.get(r101.f205675a, r100);
            goto L23
        L11:
            if (r102 == 2) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (this.f205702b != 0) goto L15;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r110, float r111, int r112) {
            DuxTabLayout r113 = this.f205701a.get();
            if (r113 == null) goto L41;
            int r100 = this.f205703c;
            if (r100 == 2) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r100 == 2) goto L13;
        L16:
            boolean r102 = true;
        L17:
            r113.m(r110, r111, r101, r102);
            if (this.f205703c == 2) goto L20;
        L22:
            f r114 = r113.f205677c;
            r114.f205724m = true;
            View r115 = r114.getChildAt(r114.f205715d);
            f r103 = r113.f205677c;
            View r104 = r103.getChildAt(r103.f205715d + 1);
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
            int r121 = ((Integer) this.f205706f.evaluate(r111, Integer.valueOf(this.f205705e), Integer.valueOf(this.f205704d))).intValue();
            if (r117 == null) goto L33;
            if (r118 == null) goto L33;
            r118.setTextColor(r121);
            r117.setImageAlpha(Color.alpha(r121));
        L33:
            int r122 = ((Integer) this.f205706f.evaluate(r111, Integer.valueOf(this.f205704d), Integer.valueOf(this.f205705e))).intValue();
            if (r119 == null) goto L38;
            if (r120 == null) goto L38;
            r120.setTextColor(r122);
            r119.setImageAlpha(Color.alpha(r122));
        L38:
            r113.f205677c.f205722k = r116 + ((r108 - r116) * this.f205707g.getInterpolation(r111));
            r113.f205677c.f205723l = r107 + ((r109 - r107) * this.f205707g.getInterpolation(r111));
        L39:
            ViewCompat.postInvalidateOnAnimation(r113.f205677c);
            return;
        L20:
            if (this.f205702b != 0) goto L22;
            r113.f205677c.f205724m = false;
            goto L39
        L13:
            if (this.f205702b != 0) goto L16;
            r102 = false;
            goto L17
        L7:
            if (this.f205702b == 1) goto L10;
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
        public final /* synthetic */ DuxTabLayout f205708a;

        public a(DuxTabLayout r100) {
            this.f205708a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f205708a.scrollTo(((Integer) r100.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f205709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DuxTabLayout f205710b;

        public b(DuxTabLayout r100) {
            this.f205710b = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            DuxTabLayout r103 = this.f205710b;
            if (r103.A != r100) goto L6;
            r103.l(r102, this.f205709a);
            return;
        }
    }

    public interface c {
    }

    public interface d {
        void V();

        void W();

        void a(g r100);
    }

    public class e extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxTabLayout f205711a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f205711a.j();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f205711a.j();
        }

        public e(DuxTabLayout r100) {
            this.f205711a = r100;
        }
    }

    public class f extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f205712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f205713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f205714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f205715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f205716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f205717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f205718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f205719h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ValueAnimator f205720i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f205721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f205722k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f205723l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f205724m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f205725n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f205726o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Paint f205727p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f205728q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ DuxTabLayout f205729r;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f205730a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f205731b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f205732c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f205733d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ f f205734e;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                float r101 = r100.getAnimatedFraction();
                f r102 = this.f205734e;
                int r103 = this.f205730a;
                int r104 = this.f205731b;
                r102.getClass();
                int r105 = r103 + Math.round((r104 - r103) * r101);
                f r106 = this.f205734e;
                int r107 = this.f205732c;
                int r108 = this.f205733d;
                r106.getClass();
                int r109 = r107 + Math.round(r101 * (r108 - r107));
                if (r105 == r102.f205718g) goto L5;
            L6:
                r102.f205718g = r105;
                r102.f205719h = r109;
                ViewCompat.postInvalidateOnAnimation(r102);
                return;
            L5:
                if (r109 != r102.f205719h) goto L6;
            }

            public a(f r100, int r101, int r102, int r103, int r104) {
                this.f205734e = r100;
                this.f205730a = r101;
                this.f205731b = r102;
                this.f205732c = r103;
                this.f205733d = r104;
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f205735a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f205736b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                f r101 = this.f205736b;
                r101.f205715d = this.f205735a;
                r101.f205716e = 0.0f;
            }

            public b(f r100, int r101) {
                this.f205736b = r100;
                this.f205735a = r101;
            }
        }

        public final void b() {
            View r100 = getChildAt(this.f205715d);
            int r101 = -1;
            if (r100 != null) goto L5;
        L12:
            int r102 = -1;
        L14:
            if (r101 == this.f205718g) goto L16;
        L17:
            this.f205718g = r101;
            this.f205719h = r102;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L16:
            if (r102 != this.f205719h) goto L17;
            return;
        L5:
            if (r100.getWidth() <= 0) goto L12;
            int r103 = r100.getLeft();
            r102 = r100.getRight();
            if (this.f205716e > 0.0f) goto L9;
        L11:
            r101 = r103;
            goto L14
        L9:
            if (this.f205715d >= (getChildCount() - 1)) goto L11;
            View r104 = getChildAt(this.f205715d + 1);
            float r105 = this.f205716e * r104.getLeft();
            float r106 = this.f205716e;
            r103 = (int) (r105 + ((1.0f - r106) * r103));
            r102 = (int) ((r106 * r104.getRight()) + ((1.0f - this.f205716e) * r102));
            goto L11
        }

        @Override // android.view.View
        public final void draw(Canvas r110) {
            super.draw(r110);
            if (this.f205726o == false) goto L5;
            r110.drawLine(getLeft(), getBottom() - 1, getRight() * 2, getBottom(), this.f205727p);
        L5:
            int r100 = this.f205718g;
            if (r100 >= 0) goto L8;
            return;
        L8:
            if (this.f205719h <= r100) goto L34;
            View r101 = getChildAt(this.f205729r.getSelectedTabPosition());
            if (r101 == null) goto L20;
            View r102 = r101.findViewById(R.id.layout_tab_indicator);
            if (r102 == null) goto L20;
            if (this.f205729r.A != null) goto L16;
        L17:
            int r103 = this.f205718g;
            float r104 = r103 + (((this.f205719h - r103) - r102.getWidth()) / 2);
            this.f205722k = r104;
            this.f205723l = r104 + r102.getWidth();
        L18:
            r110.drawRect(this.f205722k + this.f205725n, getHeight() - this.f205712a, this.f205723l - this.f205725n, getHeight(), this.f205714c);
            return;
        L16:
            if (this.f205724m == true) goto L18;
        L20:
            int r105 = this.f205713b;
            if (r105 <= 0) goto L26;
            int r106 = this.f205719h;
            int r107 = this.f205718g;
            if (r105 >= (r106 - r107)) goto L26;
            float r108 = (r107 + r106) * 0.5f;
            float r109 = r108 - (r105 * 0.5f);
            float r111 = r108 + (r105 * 0.5f);
        L31:
            float r112 = this.f205712a * 0.5f;
            r110.drawRoundRect(r109 + this.f205725n, getHeight() - this.f205712a, r111 - this.f205725n, getHeight(), r112, r112, this.f205714c);
            return;
        L26:
            if (this.f205728q == false) goto L28;
        L30:
            r109 = this.f205718g;
            r111 = this.f205719h;
            goto L31
        L28:
            if ((r101 instanceof h) == false) goto L30;
            float r113 = (this.f205718g + this.f205719h) * 0.5f;
            h r114 = (h) r101;
            r109 = r113 - (r114.getContentWidth() * 0.5f);
            r111 = (r114.getContentWidth() * 0.5f) + r113;
            goto L31
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r100) {
            super.onRtlPropertiesChanged(r100);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f205717f == r100) goto L9;
            requestLayout();
            this.f205717f = r100;
            return;
        }

        public f(DuxTabLayout r100, Context r101) {
            this.f205729r = r100;
            super(r101);
            this.f205715d = -1;
            this.f205717f = -1;
            this.f205718g = -1;
            this.f205719h = -1;
            this.f205721j = Integer.MAX_VALUE;
            setWillNotDraw(false);
            this.f205714c = new Paint();
        }

        public final void a(int r110, int r111) {
            ValueAnimator r100 = this.f205720i;
            if (r100 == null) goto L8;
            if (r100.isRunning() == false) goto L8;
            this.f205720i.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r101 = true;
        L11:
            View r102 = getChildAt(r110);
            if (r102 != null) goto L15;
            b();
            return;
        L15:
            int r103 = r102.getLeft();
            int r104 = r102.getRight();
            if (Math.abs(r110 - this.f205715d) > 1) goto L18;
            int r105 = this.f205718g;
            int r106 = this.f205719h;
        L26:
            if (r105 != r103) goto L28;
            if (r106 != r104) goto L28;
            return;
        L28:
            ValueAnimator r107 = new ValueAnimator();
            this.f205720i = r107;
            r107.setInterpolator(DuxTabLayout.I);
            r107.setDuration(r111);
            r107.setFloatValues(new float[]{0.0f, 1.0f});
            r107.addUpdateListener(new a(this, r105, r103, r106, r104));
            r107.addListener(new b(this, r110));
            r107.start();
            return;
        L18:
            int r108 = this.f205729r.g(24);
            if (r110 >= this.f205715d) goto L22;
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

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r110, int r111) {
            super.onMeasure(r110, r111);
            if (View.MeasureSpec.getMode(r110) == 1073741824) goto L5;
            return;
        L5:
            View.MeasureSpec.getMode(r110);
            int r100 = getChildCount();
            int r101 = 0;
            int r102 = 0;
            int r103 = 0;
        L6:
            if (r102 >= r100) goto L11;
            View r104 = getChildAt(r102);
            if (r104.getVisibility() != 0) goto L10;
            r103 = Math.max(r103, r104.getMeasuredWidth());
            this.f205721j = Math.min(this.f205721j, r104.getMeasuredWidth());
        L10:
            r102 = r102 + 1;
            goto L6
        L11:
            DuxTabLayout r105 = this.f205729r;
            int r106 = r105.f205694t;
            boolean r107 = true;
            if (r106 == 1) goto L14;
        L31:
            if (r106 == 0) goto L33;
            return;
        L33:
            if (r105.f205696v == true) goto L35;
            return;
        L35:
            if (r105.H == getResources().getConfiguration().orientation) goto L37;
            return;
        L37:
            if (r103 > 0) goto L39;
            return;
        L39:
            int r108 = 0;
            int r109 = 0;
        L41:
            if (r108 >= r100) goto L46;
            View r112 = getChildAt(r108);
            if (r112.getVisibility() == 8) goto L45;
            r109 = r109 + r112.getMeasuredWidth();
        L45:
            r108 = r108 + 1;
            goto L41
        L46:
            if (r109 > 0) goto L48;
            return;
        L48:
            int r113 = (this.f205729r.getMeasuredWidth() - this.f205729r.f205677c.getPaddingLeft()) - this.f205729r.f205677c.getPaddingRight();
            if (r109 < r113) goto L51;
        L67:
            if (r101 == 0) goto L89;
            super.onMeasure(r110, r111);
            return;
        L89:
            return;
        L51:
            if ((r103 * r100) >= r113) goto L60;
            int r114 = 0;
            int r115 = 0;
        L53:
            if (r114 >= r100) goto L66;
            LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) getChildAt(r114).getLayoutParams();
            if (r116.width == 0) goto L57;
        L58:
            r116.width = 0;
            r116.weight = 1.0f;
            r115 = 1;
        L59:
            r114 = r114 + 1;
            goto L53
        L57:
            if (r116.weight == 1.0f) goto L59;
        L66:
            r101 = r115;
            goto L67
        L60:
            int r117 = (r113 - r109) / (r100 * 2);
            r115 = 0;
        L61:
            if (r101 >= r100) goto L66;
            if (getChildAt(r101).getVisibility() == 8) goto L65;
            LinearLayout.LayoutParams r118 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            r118.leftMargin = r117;
            r118.rightMargin = r117;
            r115 = 1;
        L65:
            r101 = r101 + 1;
            goto L61
        L14:
            if (r105.f205693s != 1) goto L31;
            if (r103 > 0) goto L17;
            return;
        L17:
            int r119 = r105.g(16);
            if ((r103 * r100) > (getMeasuredWidth() - (r119 * 2))) goto L28;
            boolean r120 = false;
        L20:
            if (r101 >= r100) goto L27;
            LinearLayout.LayoutParams r121 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            if (r121.width == r103) goto L24;
        L25:
            r121.width = r103;
            r121.weight = 0.0f;
            r120 = true;
        L26:
            r101 = r101 + 1;
            goto L20
        L24:
            if (r121.weight == 0.0f) goto L26;
        L27:
            r107 = r120;
        L29:
            if (r107 == false) goto L85;
            super.onMeasure(r110, r111);
            return;
        L85:
            return;
        L28:
            DuxTabLayout r122 = this.f205729r;
            r122.f205693s = 0;
            r122.p(false);
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.f205720i;
            if (r105 != null) goto L5;
        L7:
            b();
            return;
        L5:
            if (r105.isRunning() == false) goto L7;
            this.f205720i.cancel();
            a(this.f205715d, Math.round((1.0f - this.f205720i.getAnimatedFraction()) * this.f205720i.getDuration()));
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f205737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f205738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f205739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f205740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f205741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DuxTabLayout f205742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h f205743g;

        public final void a() {
            h r100 = this.f205743g;
            if (r100 == null) goto L6;
            r100.update();
            return;
        }

        public g() {
            this.f205740d = -1;
        }
    }

    public class h extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f205744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f205745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f205746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f205747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f205748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ImageView f205749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f205750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ DuxTabLayout f205751h;

        public int getContentWidth() {
            TextView r100 = this.f205745b;
            boolean r101 = true;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
            int r103 = 0;
            int r104 = 0;
        L8:
            ImageView r105 = this.f205746c;
            if (r105 != null) goto L11;
        L19:
            r101 = r102;
        L20:
            View r106 = this.f205747d;
            if (r106 == null) goto L32;
            if (r106.getVisibility() != 0) goto L32;
            int r107 = this.f205747d.getLeft();
            if (r101 == false) goto L27;
            r107 = Math.min(r103, r107);
        L27:
            r103 = r107;
            int r108 = this.f205747d.getRight();
            if (r101 == false) goto L30;
            r108 = Math.max(r104, r108);
        L30:
            r104 = r108;
        L32:
            return r104 - r103;
        L11:
            if (r105.getVisibility() != 0) goto L19;
            if (r102 == false) goto L14;
            r103 = Math.min(r103, this.f205746c.getLeft());
        L15:
            if (r102 == false) goto L17;
            int r109 = Math.max(r104, this.f205746c.getRight());
        L18:
            r104 = r109;
            goto L20
        L17:
            r109 = this.f205746c.getRight();
            goto L18
        L14:
            r103 = this.f205746c.getLeft();
            goto L15
        L5:
            if (r100.getVisibility() != 0) goto L7;
            int r110 = this.f205745b.getLeft();
            r104 = this.f205745b.getRight();
            r103 = r110;
            r102 = true;
            goto L8
        }

        public final void update() {
            g r100 = this.f205744a;
            if (r100 == null) goto L5;
            View r101 = r100.f205741e;
        L6:
            if (r101 == null) goto L22;
            ViewParent r102 = r101.getParent();
            if (r102 == this) goto L12;
            if (r102 == null) goto L11;
            ((ViewGroup) r102).removeView(r101);
        L11:
            addView(r101);
        L12:
            this.f205747d = r101;
            TextView r103 = this.f205745b;
            if (r103 == null) goto L15;
            r103.setVisibility(8);
        L15:
            ImageView r104 = this.f205746c;
            if (r104 == null) goto L18;
            r104.setVisibility(8);
            this.f205746c.setImageDrawable(null);
        L18:
            TextView r105 = (TextView) r101.findViewById(android.R.id.text1);
            this.f205748e = r105;
            if (r105 == null) goto L21;
            this.f205750g = TextViewCompat.getMaxLines(r105);
        L21:
            this.f205749f = (ImageView) r101.findViewById(android.R.id.icon);
        L26:
            boolean r106 = false;
            if (this.f205747d == null) goto L29;
            TextView r107 = this.f205748e;
            if (r107 == null) goto L41;
        L42:
            a(r107, this.f205749f);
        L43:
            if (r100 == null) goto L54;
            DuxTabLayout r108 = r100.f205742f;
            if (r108 == null) goto L53;
            if (r108.getSelectedTabPosition() != r100.f205740d) goto L49;
            boolean r109 = true;
        L50:
            if (r109 == false) goto L54;
            r106 = true;
            goto L54
        L49:
            r109 = false;
            goto L50
        L53:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L54:
            setSelected(r106);
            return;
        L41:
            if (this.f205749f == null) goto L43;
        L29:
            if (this.f205746c != null) goto L32;
            ImageView r110 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            addView(r110, 0);
            this.f205746c = r110;
        L32:
            if (this.f205745b != null) goto L34;
            TextView r111 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            addView(r111);
            this.f205745b = r111;
            this.f205750g = TextViewCompat.getMaxLines(r111);
        L34:
            TextViewCompat.setTextAppearance(this.f205745b, this.f205751h.f205683i);
            ColorStateList r112 = this.f205751h.f205684j;
            if (r112 == null) goto L37;
            this.f205745b.setTextColor(r112);
        L37:
            a(this.f205745b, this.f205746c);
            goto L43
        L22:
            View r113 = this.f205747d;
            if (r113 == null) goto L25;
            removeView(r113);
            this.f205747d = null;
        L25:
            this.f205748e = null;
            this.f205749f = null;
            goto L26
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r100 = super.performClick();
            if (this.f205744a == null) goto L11;
            if (r100 == true) goto L6;
            playSoundEffect(0);
        L6:
            DuxTabLayout r101 = this.f205751h;
            FastOutSlowInInterpolator r102 = DuxTabLayout.I;
            r101.getClass();
            g r103 = this.f205744a;
            DuxTabLayout r104 = r103.f205742f;
            if (r104 == null) goto L10;
            r104.k(r103, true);
            return true;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L11:
            return r100;
        }

        public g getTab() {
            return this.f205744a;
        }

        public TextView getTextView() {
            return this.f205745b;
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

        @Override // android.view.View
        public void setSelected(boolean r100) {
            if (isSelected() != r100) goto L6;
        L6:
            super.setSelected(r100);
            TextView r101 = this.f205745b;
            if (r101 == null) goto L12;
            r101.setSelected(r100);
            if (r100 == false) goto L11;
            this.f205745b.setTypeface(Typeface.DEFAULT_BOLD);
            goto L12
        L11:
            this.f205745b.setTypeface(Typeface.DEFAULT);
        L12:
            ImageView r102 = this.f205746c;
            if (r102 == null) goto L15;
            r102.setSelected(r100);
        L15:
            View r103 = this.f205747d;
            if (r103 == null) goto L19;
            r103.setSelected(r100);
            return;
        }

        public void setTab(g r100) {
            if (r100 == this.f205744a) goto L6;
            this.f205744a = r100;
            update();
            return;
        }

        public h(DuxTabLayout r100, Context r101) {
            this.f205751h = r100;
            super(r101);
            this.f205750g = 2;
            int r102 = r100.f205687m;
            if (r102 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r101, r102));
        L5:
            ViewCompat.setPaddingRelative(this, r100.f205679e, r100.f205680f, r100.f205681g, r100.f205682h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final void a(TextView r100, ImageView r101) {
            g r102 = this.f205744a;
            CharSequence r103 = null;
            if (r102 == null) goto L5;
            Drawable r104 = r102.f205737a;
        L6:
            if (r102 == null) goto L8;
            CharSequence r105 = r102.f205738b;
        L9:
            if (r102 == null) goto L11;
            CharSequence r106 = r102.f205739c;
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
            r107 = this.f205751h.g(8);
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

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            int r102 = View.MeasureSpec.getSize(r100);
            int r103 = View.MeasureSpec.getMode(r100);
            int r104 = this.f205751h.getTabMaxWidth();
            if (r104 <= 0) goto L7;
            if (r103 == 0) goto L6;
            if (r102 <= r104) goto L7;
        L6:
            r100 = View.MeasureSpec.makeMeasureSpec(this.f205751h.f205688n, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r100, r101);
            if (this.f205745b == null) goto L35;
            getResources();
            float r105 = this.f205751h.f205685k;
            int r106 = this.f205750g;
            ImageView r107 = this.f205746c;
            boolean r108 = true;
            if (r107 != null) goto L12;
        L14:
            TextView r109 = this.f205745b;
            if (r109 != null) goto L17;
        L19:
            float r110 = this.f205745b.getTextSize();
            int r111 = this.f205745b.getLineCount();
            int r112 = TextViewCompat.getMaxLines(this.f205745b);
            if (r105 != r110) goto L24;
            if (r112 < 0) goto L36;
            if (r106 != r112) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.f205751h.f205694t != 1) goto L32;
            if (r105 <= r110) goto L32;
            if (r111 != 1) goto L32;
            Layout r113 = this.f205745b.getLayout();
            if (r113 != null) goto L30;
        L31:
            r108 = false;
            goto L32
        L30:
            if ((r113.getLineWidth(0) * (r105 / r113.getPaint().getTextSize())) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r108 == false) goto L38;
            this.f205745b.setTextSize(0, r105);
            this.f205745b.setMaxLines(r106);
            super.onMeasure(r100, r101);
            return;
        L38:
            return;
        L17:
            if (r109.getLineCount() <= 1) goto L19;
            r105 = this.f205751h.f205686l;
            goto L19
        L12:
            if (r107.getVisibility() != 0) goto L14;
            r106 = 1;
            goto L19
        }
    }

    public static class i implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f205752a;

        @Override // com.bytedance.dux.tabs.DuxTabLayout.d
        public final void V() {
        }

        @Override // com.bytedance.dux.tabs.DuxTabLayout.d
        public final void W() {
        }

        public i(ViewPager r100) {
            this.f205752a = r100;
        }

        @Override // com.bytedance.dux.tabs.DuxTabLayout.d
        public final void a(g r100) {
            this.f205752a.setCurrentItem(r100.f205740d);
        }
    }

    public void setOnTabClickListener(c r100) {
    }

    static {
        DuxComponent r100 = DuxComponent.DIALOG;
        I = new FastOutSlowInInterpolator();
        f205674J = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        int r100 = this.f205675a.size();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        g r103 = (g) ListProtector.get(this.f205675a, r102);
        if (r103 == null) goto L11;
        if (r103.f205737a == null) goto L11;
        if (TextUtils.isEmpty(r103.f205738b) == true) goto L11;
        r101 = true;
    L11:
        r102 = r102 + 1;
    L12:
        if (r101 == false) goto L14;
        return 72;
    L14:
        return 48;
    }

    private float getScrollPosition() {
        f r100 = this.f205677c;
        return r100.f205715d + r100.f205716e;
    }

    private int getTabMinWidth() {
        int r100 = this.f205689o;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        if (this.f205694t == 0) goto L10;
        return 0;
    L10:
        return this.f205691q;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f205677c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public final void e() {
        if (this.f205694t != 0) goto L5;
        int r100 = Math.max(0, this.f205692r - this.f205679e);
    L6:
        ViewCompat.setPaddingRelative(this.f205677c, r100, 0, 0, 0);
        int r101 = this.f205694t;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L12;
        this.f205677c.setGravity(1);
    L12:
        p(true);
        return;
    L11:
        this.f205677c.setGravity(GravityCompat.START);
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public int getSelectedTabPosition() {
        g r100 = this.f205676b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f205740d;
    }

    public int getTabCount() {
        return this.f205675a.size();
    }

    public int getTabStripLeftPadding() {
        return this.f205677c.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f205677c.getPaddingRight();
    }

    public final void h() {
        if (this.f205700z != null) goto L6;
        ValueAnimator r100 = new ValueAnimator();
        this.f205700z = r100;
        r100.setInterpolator(I);
        this.f205700z.setDuration(200);
        this.f205700z.addUpdateListener(new a(this));
        return;
    }

    public final void j() {
        int r100 = this.f205677c.getChildCount() - 1;
    L3:
        g r101 = null;
        if (r100 < 0) goto L9;
        h r102 = (h) this.f205677c.getChildAt(r100);
        this.f205677c.removeViewAt(r100);
        if (r102 == null) goto L8;
        r102.setTab(null);
        r102.setSelected(false);
        this.G.release(r102);
    L8:
        requestLayout();
        r100 = r100 - 1;
        goto L3
    L9:
        Iterator<g> r103 = this.f205675a.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        g r104 = r103.next();
        r103.remove();
        r104.f205742f = null;
        r104.f205743g = null;
        r104.f205737a = null;
        r104.f205738b = null;
        r104.f205739c = null;
        r104.f205740d = -1;
        r104.f205741e = null;
        f205674J.release(r104);
        goto L11
    L13:
        this.f205676b = null;
        PagerAdapter r105 = this.B;
        if (r105 == null) goto L37;
        int r106 = r105.getCount();
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L18;
        g r108 = i(this.f205695u);
        r108.f205738b = this.B.getPageTitle(r107);
        r108.a();
        b(r108, false);
        r107 = r107 + 1;
        goto L16
    L18:
        ViewPager r109 = this.A;
        if (r109 == null) goto L38;
        if (r106 <= 0) goto L39;
        int r110 = r109.getCurrentItem();
        if (r110 != getSelectedTabPosition()) goto L24;
        return;
    L24:
        if (r110 >= getTabCount()) goto L41;
        if (r110 >= 0) goto L27;
    L30:
        k(r101, true);
        return;
    L27:
        if (r110 >= getTabCount()) goto L30;
        r101 = (g) ListProtector.get(this.f205675a, r110);
        goto L30
    L41:
        return;
    L39:
        return;
    L38:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A != null) goto L8;
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewPager) == false) goto L9;
        n((ViewPager) r100, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.F == false) goto L6;
        setupWithViewPager(null);
        this.F = false;
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ int[] a() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    public int getTabGravity() {
        return this.f205693s;
    }

    public int getTabMaxWidth() {
        return this.f205688n;
    }

    public int getTabMode() {
        return this.f205694t;
    }

    public ColorStateList getTabTextColors() {
        return this.f205684j;
    }

    public DuxTabLayout(Context r100) {
        this(r100, null);
    }

    private void setSelectedTabView(int r100) {
        int r101 = this.f205677c.getChildCount();
        if (r100 >= r101) goto L11;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L15;
        View r103 = this.f205677c.getChildAt(r102);
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

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100) {
        c(r100);
    }

    public final void c(View r100) {
        if ((r100 instanceof DuxTabItem) == false) goto L18;
        DuxTabItem r101 = (DuxTabItem) r100;
        g r102 = i(0);
        CharSequence r103 = r101.f205671a;
        if (r103 == null) goto L7;
        r102.f205738b = r103;
        r102.a();
    L7:
        Drawable r104 = r101.f205672b;
        if (r104 == null) goto L10;
        r102.f205737a = r104;
        r102.a();
    L10:
        int r105 = r101.f205673c;
        if (r105 == 0) goto L14;
        r102.f205741e = LayoutInflater.from(r102.f205743g.getContext()).inflate(r105, r102.f205743g, false);
        r102.a();
    L14:
        if (TextUtils.isEmpty(r101.getContentDescription()) == true) goto L16;
        r102.f205739c = r101.getContentDescription();
        r102.a();
    L16:
        b(r102, this.f205675a.isEmpty());
        return;
    L18:
        if ((r100 instanceof f) == true) goto L20;
        return;
    L20:
        if (indexOfChild(r100) != (-1)) goto L25;
        super.addView(r100, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    }

    public final void d(int r100) {
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L23:
        m(r100, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        f r101 = this.f205677c;
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
        int r106 = f(r100, 0.0f);
        if (r105 == r106) goto L21;
        h();
        this.f205700z.setIntValues(new int[]{r105, r106});
        this.f205700z.start();
    L21:
        this.f205677c.a(r100, 200);
        return;
    L15:
        r104 = false;
        goto L16
    }

    public final int g(int r100) {
        Resources r101 = getResources();
        return Math.round(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g i(int r100) {
        g r101 = (g) f205674J.acquire();
        if (r101 != null) goto L5;
        r101 = new g();
    L5:
        r101.f205742f = this;
        Pools.SimplePool r102 = this.G;
        if (r102 == null) goto L8;
        h r103 = (h) r102.acquire();
    L9:
        if (r103 != null) goto L11;
        r103 = new h(this, getContext());
    L11:
        r103.setFocusable(true);
        r103.setMinimumWidth(getTabMinWidth());
        r101.f205743g = r103;
        if (r100 > 0) goto L14;
        r103.setTab(r101);
    L18:
        return r101;
    L14:
        if (r101 == r103.f205744a) goto L16;
        r103.f205744a = r101;
    L16:
        r101.f205741e = LayoutInflater.from(r103.getContext()).inflate(r100, r101.f205743g, false);
        r101.a();
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    public final void o(LinearLayout.LayoutParams r100) {
        if (this.f205694t == 1) goto L5;
    L7:
        r100.width = -2;
        r100.weight = 0.0f;
    L8:
        int r101 = this.f205678d;
        if (r101 == 0) goto L12;
        r100.leftMargin = r101;
        r100.rightMargin = r101;
        return;
    L12:
        return;
    L5:
        if (this.f205693s != 0) goto L7;
        r100.width = 0;
        r100.weight = 1.0f;
        goto L8
    }

    public final void p(boolean r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f205677c.getChildCount()) goto L9;
        View r102 = this.f205677c.getChildAt(r101);
        r102.setMinimumWidth(getTabMinWidth());
        o((LinearLayout.LayoutParams) r102.getLayoutParams());
        if (r100 == false) goto L8;
        r102.requestLayout();
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void setAutoFillWhenScrollable(boolean r100) {
        this.f205696v = r100;
    }

    public void setContentInsetStart(int r100) {
        this.f205692r = r100;
    }

    public void setCustomTabViewResId(int r100) {
        this.f205695u = r100;
    }

    public void setOnTabSelectedListener(d r100) {
        d r101 = this.f205697w;
        if (r101 == null) goto L5;
        this.f205698x.remove(r101);
    L5:
        this.f205697w = r100;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f205698x.contains(r100) == true) goto L12;
        this.f205698x.add(r100);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r100) {
        h();
        this.f205700z.addListener(r100);
    }

    public void setSelectedTabHorizontalPadding(int r100) {
        this.f205677c.f205725n = r100;
    }

    public void setSelectedTabIndicatorColor(int r100) {
        f r101 = this.f205677c;
        if (r101.f205714c.getColor() == r100) goto L6;
        r101.f205714c.setColor(r100);
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r100) {
        f r101 = this.f205677c;
        if (r101.f205712a == r100) goto L6;
        r101.f205712a = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorWidth(int r100) {
        f r101 = this.f205677c;
        if (r101.f205713b == r100) goto L6;
        r101.f205713b = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setTabBackgroundResId(int r100) {
        this.f205687m = r100;
    }

    public void setTabGravity(int r100) {
        if (this.f205693s == r100) goto L6;
        this.f205693s = r100;
        e();
        return;
    }

    public void setTabMargin(int r100) {
        this.f205678d = g(r100);
        int r101 = 0;
    L4:
        if (r101 >= getTabCount()) goto L6;
        View r102 = this.f205677c.getChildAt(r101);
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r103.leftMargin = g(r100);
        r103.rightMargin = g(r100);
        r102.setLayoutParams(r103);
        r101 = r101 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r100) {
        this.f205690p = r100;
    }

    public void setTabMinWidth(int r100) {
        this.f205689o = r100;
    }

    public void setTabMode(String r100) {
        r100.getClass();
        if (r100.equals("scrollable") == true) goto L11;
        if (r100.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.f205694t == 1) goto L14;
        this.f205694t = 1;
        e();
        return;
    L14:
        return;
    L11:
        if (this.f205694t == 0) goto L16;
        this.f205694t = 0;
        e();
        return;
    }

    public void setTabPaddingBottom(int r100) {
        this.f205682h = r100;
    }

    public void setTabPaddingEnd(int r100) {
        this.f205681g = r100;
    }

    public void setTabPaddingStart(int r100) {
        this.f205679e = r100;
    }

    public void setTabPaddingTop(int r100) {
        this.f205680f = r100;
    }

    public void setTabTextAppearance(int r100) {
        this.f205683i = r100;
    }

    public void setTabTextColors(ColorStateList r100) {
        if (this.f205684j == r100) goto L7;
        this.f205684j = r100;
        int r101 = this.f205675a.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((g) ListProtector.get(this.f205675a, r102)).a();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabTextSize(float r100) {
        if (this.f205685k == r100) goto L7;
        this.f205685k = r100;
        int r101 = this.f205675a.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((g) ListProtector.get(this.f205675a, r102)).a();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r100) {
        l(r100, false);
    }

    public void setupWithViewPager(ViewPager r100) {
        n(r100, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateDefaultLayoutParams();
    }

    public void setTabMode(int r100) {
        if (r100 == this.f205694t) goto L6;
        this.f205694t = r100;
        e();
        return;
    }

    public DuxTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        c(r100);
    }

    public final void b(g r100, boolean r101) {
        int r102 = this.f205675a.size();
        if (r100.f205742f != this) goto L17;
        r100.f205740d = r102;
        ListProtector.add(this.f205675a, r102, r100);
        int r103 = this.f205675a.size();
    L5:
        r102 = r102 + 1;
        if (r102 >= r103) goto L8;
        ((g) ListProtector.get(this.f205675a, r102)).f205740d = r102;
        goto L5
    L8:
        h r104 = r100.f205743g;
        f r105 = this.f205677c;
        int r106 = r100.f205740d;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -1);
        o(r107);
        r105.addView(r104, r106, r107);
        if (r101 == false) goto L15;
        DuxTabLayout r108 = r100.f205742f;
        if (r108 == null) goto L14;
        r108.k(r100, true);
        return;
    L14:
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final int f(int r100, float r101) {
        int r102 = 0;
        if (this.f205694t != 0) goto L21;
        View r103 = this.f205677c.getChildAt(r100);
        int r104 = r100 + 1;
        if (r104 >= this.f205677c.getChildCount()) goto L7;
        View r105 = this.f205677c.getChildAt(r104);
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
        int r109 = (int) ((((r106 + r107) + (this.f205678d * 4)) * 0.5f) * r101);
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

    public final void k(g r100, boolean r101) {
        g r102 = this.f205676b;
        if (r102 != r100) goto L9;
        if (r102 == null) goto L30;
        int r103 = this.f205698x.size() - 1;
    L6:
        if (r103 < 0) goto L8;
        ((d) ListProtector.get(this.f205698x, r103)).V();
        r103 = r103 - 1;
        goto L6
    L8:
        d(r100.f205740d);
        return;
    L30:
        return;
    L9:
        if (r100 == null) goto L11;
        int r104 = r100.f205740d;
    L12:
        if (r101 == false) goto L21;
        if (r102 != null) goto L15;
    L16:
        if (r104 == (-1)) goto L18;
        m(r104, 0.0f, true, true);
    L19:
        if (r104 == (-1)) goto L21;
        setSelectedTabView(r104);
    L18:
        d(r104);
        goto L19
    L15:
        if (r102.f205740d != (-1)) goto L18;
    L21:
        if (r102 == null) goto L25;
        int r105 = this.f205698x.size() - 1;
    L23:
        if (r105 < 0) goto L25;
        ((d) ListProtector.get(this.f205698x, r105)).W();
        r105 = r105 - 1;
    L25:
        this.f205676b = r100;
        if (r100 == null) goto L35;
        int r106 = this.f205698x.size() - 1;
    L28:
        if (r106 < 0) goto L36;
        ((d) ListProtector.get(this.f205698x, r106)).a(r100);
        r106 = r106 - 1;
        goto L28
    L36:
        return;
    L35:
        return;
    L11:
        r104 = -1;
        goto L12
    }

    public final void l(PagerAdapter r100, boolean r101) {
        PagerAdapter r102 = this.B;
        if (r102 == null) goto L7;
        e r103 = this.C;
        if (r103 == null) goto L7;
        r102.unregisterDataSetObserver(r103);
    L7:
        this.B = r100;
        if (r101 == false) goto L14;
        if (r100 == null) goto L14;
        if (this.C != null) goto L13;
        this.C = new e(this);
    L13:
        r100.registerDataSetObserver(this.C);
    L14:
        j();
    }

    public final void n(ViewPager r100, boolean r101) {
        ViewPager r102 = this.A;
        if (r102 == null) goto L10;
        TabLayoutOnPageChangeListener r103 = this.D;
        if (r103 == null) goto L7;
        r102.removeOnPageChangeListener(r103);
    L7:
        b r104 = this.E;
        if (r104 == null) goto L10;
        this.A.removeOnAdapterChangeListener(r104);
    L10:
        i r105 = this.f205699y;
        if (r105 == null) goto L14;
        this.f205698x.remove(r105);
        this.f205699y = null;
    L14:
        if (r100 == null) goto L28;
        this.A = r100;
        if (this.D != null) goto L18;
        this.D = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r106 = this.D;
        r106.f205702b = 0;
        r106.f205703c = 0;
        r100.addOnPageChangeListener(r106);
        i r107 = new i(r100);
        this.f205699y = r107;
        if (this.f205698x.contains(r107) == true) goto L21;
        this.f205698x.add(r107);
    L21:
        PagerAdapter r108 = r100.getAdapter();
        if (r108 == null) goto L25;
        l(r108, true);
    L25:
        if (this.E != null) goto L27;
        this.E = new b(this);
    L27:
        b r109 = this.E;
        r109.f205709a = true;
        r100.addOnAdapterChangeListener(r109);
        m(r100.getCurrentItem(), 0.0f, true, true);
    L29:
        this.F = r101;
        return;
    L28:
        this.A = null;
        l(null, false);
        goto L29
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = (g(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r103 = View.MeasureSpec.getMode(r101);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 0) goto L8;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L8:
        int r104 = View.MeasureSpec.getSize(r100);
        if (View.MeasureSpec.getMode(r100) == 0) goto L15;
        int r105 = this.f205690p;
        if (r105 > 0) goto L14;
        r105 = r104 - g(56);
    L14:
        this.f205688n = r105;
    L15:
        super.onMeasure(r100, r101);
        boolean r106 = true;
        if (getChildCount() != 1) goto L32;
        boolean r107 = false;
        View r108 = getChildAt(0);
        int r109 = this.f205694t;
        if (r109 == 0) goto L25;
        if (r109 == 1) goto L22;
    L29:
        if (r107 == false) goto L33;
        int r110 = HorizontalScrollView.getChildMeasureSpec(r101, getPaddingTop() + getPaddingBottom(), r108.getLayoutParams().height);
        r108.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r110);
        return;
    L33:
        return;
    L22:
        if (r108.getMeasuredWidth() != getMeasuredWidth()) goto L28;
    L27:
        r106 = false;
    L28:
        r107 = r106;
        goto L29
    L25:
        if (r108.getMeasuredWidth() >= getMeasuredWidth()) goto L27;
    L32:
        return;
    L7:
        r101 = View.MeasureSpec.makeMeasureSpec(Math.min(r102, View.MeasureSpec.getSize(r101)), 1073741824);
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        c(r100);
    }

    public DuxTabLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f205675a = new ArrayList();
        this.f205688n = Integer.MAX_VALUE;
        this.f205698x = new ArrayList();
        this.G = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        f r100 = new f(this, r110);
        this.f205677c = r100;
        super.addView(r100, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{R.attr.duxTabTextSize, R.attr.limitLargeFontScale, R.attr.showBottomLine, R.attr.tabIndicatorFullWidth, R.attr.tabIndicatorWidth});
        boolean r102 = r101.getBoolean(3, true);     // Catch: Throwable -> L39
        if (r100.f205728q == r102) goto L6;
        r100.f205728q = r102;     // Catch: Throwable -> L39
        ViewCompat.postInvalidateOnAnimation(r100);     // Catch: Throwable -> L39
    L6:
        int r103 = r101.getDimensionPixelSize(4, 0);     // Catch: Throwable -> L39
        if (r100.f205713b == r103) goto L9;
        r100.f205713b = r103;     // Catch: Throwable -> L39
        ViewCompat.postInvalidateOnAnimation(r100);     // Catch: Throwable -> L39
    L9:
        boolean r104 = r101.getBoolean(2, false);     // Catch: Throwable -> L39
        r100.f205726o = r104;     // Catch: Throwable -> L39
        if (r104 == false) goto L12;
        Paint r105 = new Paint();     // Catch: Throwable -> L39
        r100.f205727p = r105;     // Catch: Throwable -> L39
        r105.setColor(ContextCompat.getColor(r100.getContext(), R.color.LinePrimary));     // Catch: Throwable -> L39
        r100.f205727p.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L39
    L12:
        this.f205685k = r101.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L39
        if (r101.getBoolean(1, false) == false) goto L17;
        float r106 = this.f205685k;     // Catch: Throwable -> L39
        if (r106 <= 0.0f) goto L17;
        this.f205685k = com.bytedance.dux.largefont.a.d(Float.valueOf(r106));     // Catch: Throwable -> L39
    L17:
        r101.recycle();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.tabBackground, R.attr.tabContentStart, R.attr.tabGravity, R.attr.tabIconTint, R.attr.tabIconTintMode, R.attr.tabIndicator, R.attr.tabIndicatorAnimationDuration, R.attr.tabIndicatorColor, R.attr.tabIndicatorFullWidth, R.attr.tabIndicatorGravity, R.attr.tabIndicatorHeight, R.attr.tabInlineLabel, R.attr.tabMaxWidth, R.attr.tabMinWidth, R.attr.tabMode, R.attr.tabPadding, R.attr.tabPaddingBottom, R.attr.tabPaddingEnd, R.attr.tabPaddingStart, R.attr.tabPaddingTop, R.attr.tabRippleColor, R.attr.tabSelectedTextColor, R.attr.tabTextAppearance, R.attr.tabTextColor, R.attr.tabUnboundedRipple}, r112, R.style.Widget_Design_TabLayout);
        int r114 = r113.getDimensionPixelSize(10, 0);
        if (r100.f205712a == r114) goto L20;
        r100.f205712a = r114;
        ViewCompat.postInvalidateOnAnimation(r100);
    L20:
        int r115 = r113.getColor(7, 0);
        if (r100.f205714c.getColor() == r115) goto L23;
        r100.f205714c.setColor(r115);
        ViewCompat.postInvalidateOnAnimation(r100);
    L23:
        int r116 = r113.getDimensionPixelSize(15, 0);
        this.f205679e = r116;
        this.f205680f = r116;
        this.f205681g = r116;
        this.f205682h = r116;
        this.f205679e = r113.getDimensionPixelSize(18, r116);
        this.f205680f = r113.getDimensionPixelSize(19, this.f205680f);
        this.f205681g = r113.getDimensionPixelSize(17, this.f205681g);
        this.f205682h = r113.getDimensionPixelSize(16, this.f205682h);
        int r117 = r113.getResourceId(22, R.style.TextAppearance_Design_Tab);
        this.f205683i = r117;
        TypedArray r118 = r110.obtainStyledAttributes(r117, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
    L36:
        th = move-exception;
        r118.recycle();
        throw th;
    L25:
        if (this.f205685k > 0.0f) goto L27;
        this.f205685k = r118.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L36
    L27:
        this.f205684j = r118.getColorStateList(3);     // Catch: Throwable -> L36
        r118.recycle();
        if (r113.hasValue(23) == false) goto L32;
        this.f205684j = r113.getColorStateList(23);
    L32:
        if (r113.hasValue(21) == false) goto L34;
        this.f205684j = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r113.getColor(21, 0), this.f205684j.getDefaultColor()});
    L34:
        this.f205689o = r113.getDimensionPixelSize(13, -1);
        this.f205690p = r113.getDimensionPixelSize(12, -1);
        this.f205687m = r113.getResourceId(0, 0);
        this.f205692r = r113.getDimensionPixelSize(1, 0);
        this.f205694t = r113.getInt(14, 1);
        this.f205693s = r113.getInt(2, 0);
        r113.recycle();
        Resources r119 = getResources();
        this.f205686l = r119.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.f205691q = r119.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        em4.g.b(1.5f);
        em4.g.b(1.5f);
        this.H = getResources().getConfiguration().orientation;
        e();
        return;
    L39:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        c(r100);
    }

    public final void m(int r100, float r101, boolean r102, boolean r103) {
        int r104 = Math.round(r100 + r101);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.f205677c.getChildCount()) goto L25;
        if (r103 == false) goto L14;
        f r105 = this.f205677c;
        ValueAnimator r106 = r105.f205720i;
        if (r106 != null) goto L11;
    L13:
        r105.f205715d = r100;
        r105.f205716e = r101;
        r105.b();
        goto L14
    L11:
        if (r106.isRunning() == false) goto L13;
        r105.f205720i.cancel();
    L14:
        ValueAnimator r107 = this.f205700z;
        if (r107 != null) goto L17;
    L19:
        scrollTo(f(r100, r101), 0);
        if (r102 == false) goto L24;
        setSelectedTabView(r104);
        return;
    L24:
        return;
    L17:
        if (r107.isRunning() == false) goto L19;
        this.f205700z.cancel();
        goto L19
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, boolean r118) {
        return super.overScrollBy(r110, r111, r112, r113, r114, r115, 80, r117, r118);
    }
}
