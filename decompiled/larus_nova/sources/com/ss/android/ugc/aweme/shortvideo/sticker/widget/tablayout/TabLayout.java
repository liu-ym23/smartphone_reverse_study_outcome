package com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout;

import android.animation.Animator;
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
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.tools.utils.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    public static final Pools.SynchronizedPool I = null;
    public AdapterChangeListener A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public final Pools.SimplePool G;
    public final int H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Tab> f454197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Tab f454198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SlidingTabStrip f454199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f454200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f454201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f454202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f454203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f454204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f454205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f454206j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f454207k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f454208l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f454209m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f454210n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f454211o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f454212p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f454213q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f454214r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OnTabSelectedListener f454215s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<OnTabSelectedListener> f454216t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewPagerOnTabSelectedListener f454217u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f454218v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewPager f454219w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PagerAdapter f454220x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DataSetObserver f454221y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TabLayoutOnPageChangeListener f454222z;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f454224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TabLayout f454225b;

        public AdapterChangeListener(TabLayout r100) {
            this.f454225b = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            TabLayout r103 = this.f454225b;
            if (r103.f454219w != r100) goto L6;
            r103.m(r102, this.f454224a);
            return;
        }
    }

    public interface IndicatorDrawProxy {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabClickListener {
    }

    public interface OnTabSelectedListener {
        void a(Tab r100);

        void b(Tab r100);

        void c(Tab r100, boolean r101);
    }

    public class PagerAdapterObserver extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabLayout f454226a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f454226a.k();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f454226a.k();
        }

        public PagerAdapterObserver(TabLayout r100) {
            this.f454226a = r100;
        }
    }

    public class SlidingTabStrip extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f454227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f454228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f454229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f454230d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f454231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f454232f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f454233g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f454234h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f454235i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f454236j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ValueAnimator f454237k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f454238l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f454239m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f454240n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f454241o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ TabLayout f454242p;

        public final void b() {
            View r100 = getChildAt(this.f454229c);
            int r101 = -1;
            if (r100 != null) goto L5;
        L12:
            int r102 = -1;
        L14:
            if (r101 == this.f454233g) goto L16;
        L17:
            this.f454233g = r101;
            this.f454234h = r102;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L16:
            if (r102 != this.f454234h) goto L17;
            return;
        L5:
            if (r100.getWidth() <= 0) goto L12;
            int r103 = r100.getLeft();
            r102 = r100.getRight();
            if (this.f454230d > 0.0f) goto L9;
        L11:
            r101 = r103;
            goto L14
        L9:
            if (this.f454229c >= (getChildCount() - 1)) goto L11;
            View r104 = getChildAt(this.f454229c + 1);
            float r105 = this.f454230d * r104.getLeft();
            float r106 = this.f454230d;
            r103 = (int) (r105 + ((1.0f - r106) * r103));
            r102 = (int) ((r106 * r104.getRight()) + ((1.0f - this.f454230d) * r102));
            goto L11
        }

        @Override // android.view.View
        public final void draw(Canvas r100) {
            super.draw(r100);
            TabLayout r101 = this.f454242p;
            if (r101.E == false) goto L5;
            return;
        L5:
            int r102 = this.f454233g;
            if (r102 >= 0) goto L8;
            return;
        L8:
            if (this.f454234h > r102) goto L10;
            return;
        L10:
            if (r101.D == true) goto L39;
            r101.getClass();
            TabLayout r103 = this.f454242p;
            if (r103.F == false) goto L35;
            View r104 = getChildAt(r103.getSelectedTabPosition());
            if (r104 == null) goto L35;
            View r105 = r104.findViewById(R.id.layout_tab_indicator);
            View r106 = r104.findViewById(R.id.tab_item_dot);
            if (r105 == null) goto L35;
            if (this.f454242p.f454219w == null) goto L23;
            if (this.f454241o == false) goto L23;
        L33:
            r100.drawRoundRect(new RectF(this.f454239m, getHeight() - this.f454227a, this.f454240n, getHeight()), this.f454235i, this.f454236j, this.f454228b);
            return;
        L23:
            if (r106 != null) goto L25;
        L27:
            int r107 = this.f454233g;
            this.f454239m = r107 + (((this.f454234h - r107) - r105.getWidth()) / 2.0f);
        L28:
            this.f454240n = this.f454239m + r105.getWidth();
            int r108 = this.f454231e;
            if (r108 == (-1)) goto L33;
            if (r108 >= r105.getWidth()) goto L33;
            float r109 = (r105.getWidth() - this.f454231e) / 2;
            this.f454239m += r109;
            this.f454240n -= r109;
            goto L33
        L25:
            if (r106.getVisibility() == 8) goto L27;
            int r110 = this.f454233g;
            this.f454239m = r110 + ((((this.f454234h - r110) - r105.getWidth()) - (r106.getRight() - r105.getRight())) / 2.0f);
        L35:
            r100.drawRoundRect(new RectF(this.f454233g, getHeight() - this.f454227a, this.f454234h, getHeight()), this.f454235i, this.f454236j, this.f454228b);
            return;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r100) {
            super.onRtlPropertiesChanged(r100);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f454232f == r100) goto L9;
            requestLayout();
            this.f454232f = r100;
            return;
        }

        public SlidingTabStrip(TabLayout r100, Context r101) {
            this.f454242p = r100;
            super(r101);
            this.f454229c = -1;
            this.f454231e = -1;
            this.f454232f = -1;
            this.f454233g = -1;
            this.f454234h = -1;
            this.f454235i = 0.0f;
            this.f454236j = 0.0f;
            r100.h(27);
            this.f454238l = Integer.MAX_VALUE;
            setWillNotDraw(false);
            this.f454228b = new Paint();
        }

        public final void a(final int r110, int r111) {
            ValueAnimator r100 = this.f454237k;
            if (r100 == null) goto L8;
            if (r100.isRunning() == false) goto L8;
            this.f454237k.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r101 = true;
        L11:
            View r102 = getChildAt(r110);
            if (r102 != null) goto L15;
            b();
            return;
        L15:
            final int r103 = r102.getLeft();
            final int r104 = r102.getRight();
            if (Math.abs(r110 - this.f454229c) > 1) goto L18;
            final int r105 = this.f454233g;
            final int r106 = this.f454234h;
        L26:
            if (r105 != r103) goto L28;
            if (r106 != r104) goto L28;
            return;
        L28:
            ValueAnimator r107 = new ValueAnimator();
            this.f454237k = r107;
            r107.setInterpolator(AnimationUtils.f454193a);
            r107.setDuration(r111);
            r107.setFloatValues(new float[]{0.0f, 1.0f});
            r107.addUpdateListener(new AnonymousClass1(this, r105, r103, r106, r104));
            r107.addListener(new AnonymousClass2(this, r110));
            r107.start();
            return;
        L18:
            int r108 = this.f454242p.h(24);
            if (r110 >= this.f454229c) goto L22;
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
            int r100 = getChildCount();
            int r101 = 0;
            int r102 = 0;
            int r103 = 0;
        L6:
            if (r102 >= r100) goto L11;
            View r104 = getChildAt(r102);
            if (r104.getVisibility() != 0) goto L10;
            r103 = Math.max(r103, r104.getMeasuredWidth());
            this.f454238l = Math.min(this.f454238l, r104.getMeasuredWidth());
        L10:
            r102 = r102 + 1;
            goto L6
        L11:
            TabLayout r105 = this.f454242p;
            int r106 = r105.f454213q;
            boolean r107 = true;
            if (r106 == 1) goto L14;
        L31:
            if (r106 == 0) goto L33;
            return;
        L33:
            if (r105.f454214r == true) goto L35;
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
            if (r109 > 0) goto L49;
            return;
        L49:
            if (r109 >= this.f454242p.getMeasuredWidth()) goto L93;
            int r113 = r103 * r100;
            if (r113 >= this.f454242p.getMeasuredWidth()) goto L64;
            int r114 = (this.f454242p.getMeasuredWidth() - r113) / (r100 * 2);
            boolean r115 = false;
        L53:
            if (r101 >= r100) goto L71;
            LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            if (r116.width == r103) goto L57;
        L62:
            r116.width = r103;
            r116.weight = 0.0f;
            r116.leftMargin = r114;
            r116.rightMargin = r114;
            r115 = true;
        L63:
            r101 = r101 + 1;
            goto L53
        L57:
            if (r116.weight != 0.0f) goto L62;
            if (r116.leftMargin != r114) goto L62;
            if (r116.rightMargin == r114) goto L63;
        L71:
            if (r115 == false) goto L94;
            super.onMeasure(r110, r111);
            return;
        L94:
            return;
        L64:
            int r117 = (this.f454242p.getMeasuredWidth() - r109) / (r100 * 2);
            boolean r118 = false;
        L65:
            if (r101 >= r100) goto L70;
            if (getChildAt(r101).getVisibility() == 8) goto L69;
            LinearLayout.LayoutParams r119 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            r119.leftMargin = r117;
            r119.rightMargin = r117;
            r118 = true;
        L69:
            r101 = r101 + 1;
            goto L65
        L70:
            r115 = r118;
            goto L71
        L93:
            return;
        L14:
            if (r105.f454212p != 1) goto L31;
            if (r103 > 0) goto L17;
            return;
        L17:
            int r120 = r105.h(16);
            if ((r103 * r100) > (getMeasuredWidth() - (r120 * 2))) goto L28;
            boolean r121 = false;
        L20:
            if (r101 >= r100) goto L27;
            LinearLayout.LayoutParams r122 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            if (r122.width == r103) goto L24;
        L25:
            r122.width = r103;
            r122.weight = 0.0f;
            r121 = true;
        L26:
            r101 = r101 + 1;
            goto L20
        L24:
            if (r122.weight == 0.0f) goto L26;
        L27:
            r107 = r121;
        L29:
            if (r107 == false) goto L89;
            super.onMeasure(r110, r111);
            return;
        L89:
            return;
        L28:
            TabLayout r123 = this.f454242p;
            r123.f454212p = 0;
            r123.r(false);
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.f454237k;
            if (r105 != null) goto L5;
        L7:
            b();
            return;
        L5:
            if (r105.isRunning() == false) goto L7;
            this.f454237k.cancel();
            a(this.f454229c, Math.round((1.0f - this.f454237k.getAnimatedFraction()) * this.f454237k.getDuration()));
        }
    }

    public static final class Tab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f454250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f454251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f454252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f454253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f454254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TabLayout f454255f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TabView f454256g;

        public final void a() {
            TabView r100 = this.f454256g;
            if (r100 == null) goto L6;
            r100.update();
            return;
        }

        public Tab() {
            this.f454252c = -1;
            this.f454254e = true;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f454257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f454258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f454259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f454260d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f454261e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArgbEvaluator f454262f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AccelerateInterpolator f454263g;

        public TabLayoutOnPageChangeListener(TabLayout r100) {
            this.f454262f = new ArgbEvaluator();
            this.f454263g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f454257a = new WeakReference(r100);
            this.f454261e = r100.getTabTextColors().getColorForState(TabLayout.a(), 0);
            this.f454260d = r100.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f454258b = this.f454259c;
            this.f454259c = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            TabLayout r101 = this.f454257a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getSelectedTabPosition() != r100) goto L7;
            return;
        L7:
            if (r100 >= r101.getTabCount()) goto L27;
            int r102 = this.f454259c;
            if (r102 != 0) goto L11;
        L16:
            boolean r103 = true;
        L17:
            if (r100 >= 0) goto L19;
        L22:
            Tab r104 = null;
        L23:
            r101.l(r104, r103, true);
            return;
        L19:
            if (r100 >= r101.getTabCount()) goto L22;
            r104 = (Tab) ListProtector.get(r101.f454197a, r100);
            goto L23
        L11:
            if (r102 == 2) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (this.f454258b != 0) goto L15;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r110, float r111, int r112) {
            TabLayout r113 = this.f454257a.get();
            if (r113 == null) goto L41;
            int r100 = this.f454259c;
            if (r100 == 2) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r100 == 2) goto L13;
        L16:
            boolean r102 = true;
        L17:
            r113.n(r110, r111, r101, r102);
            if (this.f454259c == 2) goto L20;
        L22:
            SlidingTabStrip r114 = r113.f454199c;
            r114.f454241o = true;
            View r115 = r114.getChildAt(r114.f454229c);
            SlidingTabStrip r103 = r113.f454199c;
            View r104 = r103.getChildAt(r103.f454229c + 1);
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
            int r121 = ((Integer) this.f454262f.evaluate(r111, Integer.valueOf(this.f454261e), Integer.valueOf(this.f454260d))).intValue();
            if (r117 == null) goto L33;
            if (r118 == null) goto L33;
            r118.setTextColor(r121);
            r117.setImageAlpha(Color.alpha(r121));
        L33:
            int r122 = ((Integer) this.f454262f.evaluate(r111, Integer.valueOf(this.f454260d), Integer.valueOf(this.f454261e))).intValue();
            if (r119 == null) goto L38;
            if (r120 == null) goto L38;
            r120.setTextColor(r122);
            r119.setImageAlpha(Color.alpha(r122));
        L38:
            r113.f454199c.f454239m = r116 + ((r108 - r116) * this.f454263g.getInterpolation(r111));
            r113.f454199c.f454240n = r107 + ((r109 - r107) * this.f454263g.getInterpolation(r111));
        L39:
            ViewCompat.postInvalidateOnAnimation(r113.f454199c);
            return;
        L20:
            if (this.f454258b != 0) goto L22;
            r113.f454199c.f454241o = false;
            goto L39
        L13:
            if (this.f454258b != 0) goto L16;
            r102 = false;
            goto L17
        L7:
            if (this.f454258b == 1) goto L10;
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

    public class TabView extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Tab f454264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f454265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabLayout f454266c;

        public TextView getTextView() {
            return null;
        }

        public final void update() {
            Tab r100 = this.f454264a;
            if (r100 == null) goto L5;
            View r101 = r100.f454253d;
        L6:
            if (r101 == null) goto L16;
            ViewParent r102 = r101.getParent();
            if (r102 == this) goto L12;
            if (r102 == null) goto L11;
            ((ViewGroup) r102).removeView(r101);
        L11:
            addView(r101);
        L12:
            this.f454265b = r101;
            TextView r103 = (TextView) r101.findViewById(android.R.id.text1);
            if (r103 == null) goto L15;
            TextViewCompat.getMaxLines(r103);
        L15:
            ImageView r104 = (ImageView) r101.findViewById(android.R.id.icon);
        L19:
            boolean r105 = false;
            if (r100 == null) goto L35;
            TabLayout r106 = r100.f454255f;
            if (r106 == null) goto L34;
            if (r100.f454254e == true) goto L28;
            if (r100.f454252c != (-1)) goto L28;
        L30:
            boolean r107 = false;
        L31:
            if (r107 == false) goto L35;
            r105 = true;
        L28:
            if (r106.getSelectedTabPosition() != r100.f454252c) goto L30;
            r107 = true;
            goto L31
        L34:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L35:
            setSelected(r105);
            return;
        L16:
            View r108 = this.f454265b;
            if (r108 == null) goto L19;
            removeView(r108);
            this.f454265b = null;
            goto L19
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r100 = super.performClick();
            if (this.f454264a != null) goto L5;
            return r100;
        L5:
            if (r100 == true) goto L7;
            playSoundEffect(0);
        L7:
            TabLayout r101 = this.f454266c;
            Pools.SynchronizedPool r102 = TabLayout.I;
            r101.getClass();
            Tab r103 = this.f454264a;
            TabLayout r104 = r103.f454255f;
            if (r104 == null) goto L11;
            r104.l(r103, true, false);
            return true;
        L11:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab getTab() {
            return this.f454264a;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
            super.onInitializeAccessibilityEvent(r100);
            r100.setClassName(Button.class.getName());
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
            super.onInitializeAccessibilityNodeInfo(r100);
            r100.setClassName(Button.class.getName());
        }

        @Override // android.view.View
        public void setSelected(boolean r100) {
            isSelected();
            super.setSelected(r100);
            View r101 = this.f454265b;
            if (r101 == null) goto L6;
            r101.setSelected(r100);
            return;
        }

        public void setTab(Tab r100) {
            if (r100 == this.f454264a) goto L6;
            this.f454264a = r100;
            update();
            return;
        }

        public TabView(TabLayout r100, Context r101) {
            this.f454266c = r100;
            super(r101);
            int r102 = r100.f454206j;
            if (r102 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r101, r102));
        L5:
            ViewCompat.setPaddingRelative(this, r100.f454201e, r100.f454202f, r100.f454203g, r100.f454204h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            int r102 = View.MeasureSpec.getSize(r100);
            int r103 = View.MeasureSpec.getMode(r100);
            int r104 = this.f454266c.getTabMaxWidth();
            if (r104 <= 0) goto L7;
            if (r103 == 0) goto L6;
            if (r102 <= r104) goto L7;
        L6:
            r100 = View.MeasureSpec.makeMeasureSpec(this.f454266c.f454207k, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r100, r101);
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f454267a;

        @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout.OnTabSelectedListener
        public final void a(Tab r100) {
        }

        @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout.OnTabSelectedListener
        public final void b(Tab r100) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager r100) {
            this.f454267a = r100;
        }

        @Override // com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout.TabLayout.OnTabSelectedListener
        public final void c(Tab r100, boolean r101) {
            this.f454267a.setCurrentItem(r100.f454252c);
        }
    }

    public void setIndicatorDrawProxy(IndicatorDrawProxy r100) {
    }

    public void setOnTabClickListener(OnTabClickListener r100) {
    }

    static {
        I = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        int r100 = this.f454197a.size();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        Tab r103 = (Tab) ListProtector.get(this.f454197a, r102);
        if (r103 == null) goto L11;
        if (r103.f454250a == null) goto L11;
        if (TextUtils.isEmpty(r103.f454251b) == true) goto L11;
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
        SlidingTabStrip r100 = this.f454199c;
        return r100.f454229c + r100.f454230d;
    }

    private int getTabMinWidth() {
        int r100 = this.f454208l;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        if (this.f454213q == 0) goto L10;
        return 0;
    L10:
        return this.f454210n;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f454199c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public final void f() {
        if (this.f454213q != 0) goto L5;
        int r100 = Math.max(0, this.f454211o - this.f454201e);
    L6:
        ViewCompat.setPaddingRelative(this.f454199c, r100, 0, 0, 0);
        int r101 = this.f454213q;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L12;
        this.f454199c.setGravity(1);
    L12:
        r(true);
        return;
    L11:
        this.f454199c.setGravity(GravityCompat.START);
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public int getSelectedTabPosition() {
        Tab r100 = this.f454198b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f454252c;
    }

    public int getTabCount() {
        return this.f454197a.size();
    }

    public final void i() {
        if (this.f454218v != null) goto L6;
        ValueAnimator r100 = new ValueAnimator();
        this.f454218v = r100;
        r100.setInterpolator(AnimationUtils.f454193a);
        this.f454218v.setDuration(300);
        this.f454218v.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Tab j() {
        Tab r100 = (Tab) I.acquire();
        if (r100 != null) goto L5;
        r100 = new Tab();
    L5:
        r100.f454255f = this;
        Pools.SimplePool r101 = this.G;
        if (r101 == null) goto L8;
        TabView r102 = (TabView) r101.acquire();
    L9:
        if (r102 != null) goto L11;
        r102 = new TabView(this, getContext());
    L11:
        r102.setTab(r100);
        r102.setFocusable(true);
        r102.setMinimumWidth(getTabMinWidth());
        r100.f454256g = r102;
        return r100;
    L8:
        r102 = null;
        goto L9
    }

    public final void k() {
        if (this.C == true) goto L5;
        return;
    L5:
        int r100 = this.f454199c.getChildCount() - 1;
    L6:
        Tab r101 = null;
        if (r100 < 0) goto L12;
        TabView r102 = (TabView) this.f454199c.getChildAt(r100);
        this.f454199c.removeViewAt(r100);
        if (r102 == null) goto L11;
        r102.setTab(null);
        r102.setSelected(false);
        this.G.release(r102);
    L11:
        requestLayout();
        r100 = r100 - 1;
        goto L6
    L12:
        Iterator<Tab> r103 = this.f454197a.iterator();
    L14:
        if (r103.hasNext() == false) goto L16;
        Tab r104 = r103.next();
        r103.remove();
        r104.f454255f = null;
        r104.f454256g = null;
        r104.f454250a = null;
        r104.f454251b = null;
        r104.f454252c = -1;
        r104.f454253d = null;
        I.release(r104);
        goto L14
    L16:
        this.f454198b = null;
        PagerAdapter r105 = this.f454220x;
        if (r105 == null) goto L40;
        int r106 = r105.getCount();
        int r107 = 0;
    L19:
        if (r107 >= r106) goto L21;
        Tab r108 = j();
        r108.f454251b = this.f454220x.getPageTitle(r107);
        r108.a();
        c(r108, false);
        r107 = r107 + 1;
        goto L19
    L21:
        ViewPager r109 = this.f454219w;
        if (r109 == null) goto L41;
        if (r106 <= 0) goto L42;
        int r110 = r109.getCurrentItem();
        if (r110 != getSelectedTabPosition()) goto L27;
        return;
    L27:
        if (r110 >= getTabCount()) goto L44;
        if (r110 >= 0) goto L30;
    L33:
        l(r101, true, false);
        return;
    L30:
        if (r110 >= getTabCount()) goto L33;
        r101 = (Tab) ListProtector.get(this.f454197a, r110);
        goto L33
    L44:
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f454219w != null) goto L8;
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewPager) == false) goto L9;
        p((ViewPager) r100, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.B == false) goto L6;
        setupWithViewPager(null);
        this.B = false;
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

    public Tab getCurSelectedTab() {
        return this.f454198b;
    }

    public int getTabGravity() {
        return this.f454212p;
    }

    public int getTabMaxWidth() {
        return this.f454207k;
    }

    public int getTabMode() {
        return this.f454213q;
    }

    public ColorStateList getTabTextColors() {
        return this.f454205i;
    }

    public TabLayout(Context r100) {
        this(r100, null);
    }

    private void setSelectedTabView(int r100) {
        int r101 = this.f454199c.getChildCount();
        if (r100 >= r101) goto L11;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L15;
        View r103 = this.f454199c.getChildAt(r102);
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
        d(r100);
    }

    public void b(OnTabSelectedListener r100) {
        if (this.f454216t.contains(r100) == true) goto L6;
        this.f454216t.add(r100);
        return;
    }

    public final void d(View r100) {
        if ((r100 instanceof TabItem) == false) goto L19;
        TabItem r101 = (TabItem) r100;
        Tab r102 = j();
        CharSequence r103 = r101.f454194a;
        if (r103 == null) goto L7;
        r102.f454251b = r103;
        r102.a();
    L7:
        Drawable r104 = r101.f454195b;
        if (r104 == null) goto L10;
        r102.f454250a = r104;
        r102.a();
    L10:
        int r105 = r101.f454196c;
        if (r105 == 0) goto L14;
        r102.f454253d = LayoutInflater.from(r102.f454256g.getContext()).inflate(r105, r102.f454256g, false);
        r102.a();
    L14:
        if (TextUtils.isEmpty(r101.getContentDescription()) == true) goto L16;
        r101.getContentDescription();
        r102.a();
    L16:
        c(r102, this.f454197a.isEmpty());
        return;
    L19:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void e(int r100) {
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L23:
        n(r100, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        SlidingTabStrip r101 = this.f454199c;
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
        int r106 = g(r100, 0.0f);
        if (r105 == r106) goto L21;
        i();
        this.f454218v.setIntValues(new int[]{r105, r106});
        this.f454218v.start();
    L21:
        this.f454199c.a(r100, 300);
        return;
    L15:
        r104 = false;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public final int h(int r100) {
        Resources r101 = getResources();
        return Math.round(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
    }

    public final void q(LinearLayout.LayoutParams r100) {
        if (this.f454213q == 1) goto L5;
    L7:
        r100.width = -2;
        r100.weight = 0.0f;
    L8:
        int r101 = this.f454200d;
        if (r101 == 0) goto L12;
        r100.leftMargin = r101;
        r100.rightMargin = r101;
        return;
    L12:
        return;
    L5:
        if (this.f454212p != 0) goto L7;
        r100.width = 0;
        r100.weight = 1.0f;
        goto L8
    }

    public final void r(boolean r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f454199c.getChildCount()) goto L9;
        View r102 = this.f454199c.getChildAt(r101);
        r102.setMinimumWidth(getTabMinWidth());
        q((LinearLayout.LayoutParams) r102.getLayoutParams());
        if (r100 == false) goto L8;
        r102.requestLayout();
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void setAutoFillWhenScrollable(boolean r100) {
        this.f454214r = r100;
    }

    public void setDefaultAddTab(boolean r100) {
        this.C = r100;
    }

    public void setFixedIndicatorWidth(int r100) {
        this.f454199c.f454231e = r100;
    }

    public void setForceHideIndicatorView(boolean r100) {
        this.E = r100;
    }

    public void setHideIndicatorView(boolean r100) {
        this.D = r100;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener r100) {
        OnTabSelectedListener r101 = this.f454215s;
        if (r101 == null) goto L5;
        this.f454216t.remove(r101);
    L5:
        this.f454215s = r100;
        if (r100 == null) goto L9;
        b(r100);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r100) {
        i();
        this.f454218v.addListener(r100);
    }

    public void setSelectedTabIndicatorColor(int r100) {
        SlidingTabStrip r101 = this.f454199c;
        if (r101.f454228b.getColor() == r100) goto L6;
        r101.f454228b.setColor(r100);
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorCornerRadius(float r100) {
        SlidingTabStrip r101 = this.f454199c;
        r101.getClass();
        if (r100 < 0.0f) goto L12;
        if (r100 >= 0.0f) goto L7;
        return;
    L7:
        if (r101.f454235i == r100) goto L9;
    L10:
        r101.f454235i = r100;
        r101.f454236j = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    L9:
        if (r101.f454236j != r100) goto L10;
        return;
    }

    public void setSelectedTabIndicatorHeight(int r100) {
        SlidingTabStrip r101 = this.f454199c;
        if (r101.f454227a == r100) goto L6;
        r101.f454227a = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSupportCustomIndicator(boolean r100) {
        this.F = r100;
    }

    public void setTabGravity(int r100) {
        if (this.f454212p == r100) goto L6;
        this.f454212p = r100;
        f();
        return;
    }

    public void setTabMargin(int r100) {
        setTabMarginByPixel(h(r100));
    }

    public void setTabMarginByPixel(int r100) {
        this.f454200d = r100;
        int r101 = 0;
    L4:
        if (r101 >= getTabCount()) goto L6;
        View r102 = this.f454199c.getChildAt(r101);
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        int r104 = this.f454200d;
        r103.leftMargin = r104;
        r103.rightMargin = r104;
        r102.setLayoutParams(r103);
        r102.invalidate();
        r101 = r101 + 1;
        goto L4
    }

    public void setTabMode(int r100) {
        if (r100 == this.f454213q) goto L6;
        this.f454213q = r100;
        f();
        return;
    }

    public void setTabStripLeftMargin(int r100) {
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) this.f454199c.getLayoutParams();
        r101.leftMargin = r100;
        this.f454199c.setLayoutParams(r101);
    }

    public void setTabTextColors(ColorStateList r100) {
        if (this.f454205i == r100) goto L7;
        this.f454205i = r100;
        int r101 = this.f454197a.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((Tab) ListProtector.get(this.f454197a, r102)).a();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r100) {
        m(r100, false);
    }

    public void setupWithViewPager(ViewPager r100) {
        p(r100, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateDefaultLayoutParams();
    }

    public TabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        d(r100);
    }

    public final void c(Tab r100, boolean r101) {
        int r102 = this.f454197a.size();
        if (r100.f454255f != this) goto L17;
        r100.f454252c = r102;
        ListProtector.add(this.f454197a, r102, r100);
        int r103 = this.f454197a.size();
    L5:
        r102 = r102 + 1;
        if (r102 >= r103) goto L8;
        ((Tab) ListProtector.get(this.f454197a, r102)).f454252c = r102;
        goto L5
    L8:
        TabView r104 = r100.f454256g;
        SlidingTabStrip r105 = this.f454199c;
        int r106 = r100.f454252c;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -1);
        q(r107);
        r105.addView(r104, r106, r107);
        if (r101 == false) goto L15;
        TabLayout r108 = r100.f454255f;
        if (r108 == null) goto L14;
        r108.l(r100, true, false);
        return;
    L14:
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final int g(int r100, float r101) {
        int r102 = 0;
        if (this.f454213q != 0) goto L18;
        View r103 = this.f454199c.getChildAt(r100);
        int r104 = r100 + 1;
        if (r104 >= this.f454199c.getChildCount()) goto L7;
        View r105 = this.f454199c.getChildAt(r104);
    L8:
        if (r103 == null) goto L10;
        int r106 = r103.getWidth();
    L11:
        if (r105 == null) goto L13;
        r102 = r105.getWidth();
    L13:
        int r107 = (r103.getLeft() + (r106 / 2)) - (getWidth() / 2);
        int r108 = (int) ((((r106 + r102) + (this.f454200d * 4)) * 0.5f) * r101);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L17;
        return r107 + r108;
    L17:
        return r107 - r108;
    L10:
        r106 = 0;
        goto L11
    L7:
        r105 = null;
        goto L8
    L18:
        return 0;
    }

    public final void m(PagerAdapter r100, boolean r101) {
        PagerAdapter r102 = this.f454220x;
        if (r102 == null) goto L7;
        DataSetObserver r103 = this.f454221y;
        if (r103 == null) goto L7;
        r102.unregisterDataSetObserver(r103);
    L7:
        this.f454220x = r100;
        if (r101 == false) goto L14;
        if (r100 == null) goto L14;
        if (this.f454221y != null) goto L13;
        this.f454221y = new PagerAdapterObserver(this);
    L13:
        r100.registerDataSetObserver(this.f454221y);
    L14:
        k();
    }

    public final void o(int r100, int r101) {
        setTabTextColors(new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r101, r100}));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = (h(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r103 = View.MeasureSpec.getMode(r101);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 0) goto L8;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L8:
        int r104 = View.MeasureSpec.getSize(r100);
        if (View.MeasureSpec.getMode(r100) == 0) goto L15;
        int r105 = this.f454209m;
        if (r105 > 0) goto L14;
        r105 = r104 - h(56);
    L14:
        this.f454207k = r105;
    L15:
        super.onMeasure(r100, r101);
        boolean r106 = true;
        if (getChildCount() != 1) goto L32;
        boolean r107 = false;
        View r108 = getChildAt(0);
        int r109 = this.f454213q;
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

    public final void p(ViewPager r100, boolean r101) {
        ViewPager r102 = this.f454219w;
        if (r102 == null) goto L10;
        TabLayoutOnPageChangeListener r103 = this.f454222z;
        if (r103 == null) goto L7;
        r102.removeOnPageChangeListener(r103);
    L7:
        AdapterChangeListener r104 = this.A;
        if (r104 == null) goto L10;
        this.f454219w.removeOnAdapterChangeListener(r104);
    L10:
        ViewPagerOnTabSelectedListener r105 = this.f454217u;
        if (r105 == null) goto L14;
        this.f454216t.remove(r105);
        this.f454217u = null;
    L14:
        if (r100 == null) goto L25;
        this.f454219w = r100;
        if (this.f454222z != null) goto L18;
        this.f454222z = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r106 = this.f454222z;
        r106.f454259c = 0;
        r106.f454258b = 0;
        r100.addOnPageChangeListener(r106);
        ViewPagerOnTabSelectedListener r107 = new ViewPagerOnTabSelectedListener(r100);
        this.f454217u = r107;
        b(r107);
        PagerAdapter r108 = r100.getAdapter();
        if (r108 == null) goto L22;
        m(r108, true);
    L22:
        if (this.A != null) goto L24;
        this.A = new AdapterChangeListener(this);
    L24:
        AdapterChangeListener r109 = this.A;
        r109.f454224a = true;
        r100.addOnAdapterChangeListener(r109);
        n(r100.getCurrentItem(), 0.0f, true, true);
    L26:
        this.B = r101;
        return;
    L25:
        this.f454219w = null;
        m(null, false);
        goto L26
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        d(r100);
    }

    public TabLayout(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f454197a = new ArrayList();
        this.f454207k = Integer.MAX_VALUE;
        this.f454216t = new ArrayList();
        this.C = true;
        this.F = true;
        this.G = new Pools.SimplePool(12);
        TypedArray r101 = r100.obtainStyledAttributes(ThemeUtils.f454268a);
        boolean r102 = !r101.hasValue(0);
        r101.recycle();
        if (r102 == true) goto L24;
        setHorizontalScrollBarEnabled(false);
        SlidingTabStrip r103 = new SlidingTabStrip(this, r100);
        this.f454199c = r103;
        super.addView(r103, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.tabBackground, R.attr.tabContentStart, R.attr.tabGravity, R.attr.tabIconTint, R.attr.tabIconTintMode, R.attr.tabIndicator, R.attr.tabIndicatorAnimationDuration, R.attr.tabIndicatorColor, R.attr.tabIndicatorFullWidth, R.attr.tabIndicatorGravity, R.attr.tabIndicatorHeight, R.attr.tabInlineLabel, R.attr.tabMaxWidth, R.attr.tabMinWidth, R.attr.tabMode, R.attr.tabPadding, R.attr.tabPaddingBottom, R.attr.tabPaddingEnd, R.attr.tabPaddingStart, R.attr.tabPaddingTop, R.attr.tabRippleColor, R.attr.tabSelectedTextColor, R.attr.tabTextAppearance, R.attr.tabTextColor, R.attr.tabUnboundedRipple}, r111, R.style.Widget_Design_TabLayout);
        int r113 = r112.getDimensionPixelSize(10, 0);
        if (r103.f454227a == r113) goto L7;
        r103.f454227a = r113;
        ViewCompat.postInvalidateOnAnimation(r103);
    L7:
        int r114 = r112.getColor(7, 0);
        if (r103.f454228b.getColor() == r114) goto L10;
        r103.f454228b.setColor(r114);
        ViewCompat.postInvalidateOnAnimation(r103);
    L10:
        int r115 = r112.getDimensionPixelSize(15, 0);
        this.f454204h = r115;
        this.f454203g = r115;
        this.f454202f = r115;
        this.f454201e = r115;
        this.f454201e = r112.getDimensionPixelSize(18, r115);
        this.f454202f = r112.getDimensionPixelSize(19, r115);
        this.f454203g = r112.getDimensionPixelSize(17, r115);
        this.f454204h = r112.getDimensionPixelSize(16, r115);
        TypedArray r104 = r100.obtainStyledAttributes(r112.getResourceId(22, R.style.TextAppearance_Design_Tab), new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        r104.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L20
        this.f454205i = r104.getColorStateList(3);     // Catch: Throwable -> L20
        r104.recycle();
        if (r112.hasValue(23) == false) goto L16;
        this.f454205i = r112.getColorStateList(23);
    L16:
        if (r112.hasValue(21) == false) goto L18;
        this.f454205i = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r112.getColor(21, 0), this.f454205i.getDefaultColor()});
    L18:
        this.f454208l = r112.getDimensionPixelSize(13, -1);
        this.f454209m = r112.getDimensionPixelSize(12, -1);
        this.f454206j = r112.getResourceId(0, 0);
        this.f454211o = r112.getDimensionPixelSize(1, 0);
        this.f454213q = r112.getInt(14, 1);
        this.f454212p = r112.getInt(2, 0);
        r112.recycle();
        Resources r105 = getResources();
        r105.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.f454210n = r105.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        i.a(getContext(), 1.5f);
        i.a(getContext(), 1.5f);
        this.H = getResources().getConfiguration().orientation;
        f();
        return;
    L20:
        th = move-exception;
        r104.recycle();
        throw th;
    L24:
        throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        d(r100);
    }

    public final void l(Tab r100, boolean r101, boolean r102) {
        Tab r103 = this.f454198b;
        if (r103 != r100) goto L10;
        if (r103 == null) goto L35;
        int r104 = this.f454216t.size() - 1;
    L6:
        if (r104 < 0) goto L8;
        ((OnTabSelectedListener) ListProtector.get(this.f454216t, r104)).b(r100);
        r104 = r104 - 1;
        goto L6
    L8:
        e(r100.f454252c);
        return;
    L35:
        return;
    L10:
        if (r100 == null) goto L12;
        int r105 = r100.f454252c;
    L13:
        if (r101 == false) goto L22;
        if (r103 != null) goto L16;
    L17:
        if (r105 == (-1)) goto L19;
        n(r105, 0.0f, true, true);
    L20:
        if (r105 == (-1)) goto L22;
        setSelectedTabView(r105);
    L19:
        e(r105);
        goto L20
    L16:
        if (r103.f454252c != (-1)) goto L19;
    L22:
        if (r103 == null) goto L26;
        int r106 = this.f454216t.size() - 1;
    L24:
        if (r106 < 0) goto L26;
        ((OnTabSelectedListener) ListProtector.get(this.f454216t, r106)).a(r103);
        r106 = r106 - 1;
    L26:
        this.f454198b = r100;
        if (r100 == null) goto L31;
        int r107 = this.f454216t.size() - 1;
    L29:
        if (r107 < 0) goto L36;
        ((OnTabSelectedListener) ListProtector.get(this.f454216t, r107)).c(r100, r102);
        r107 = r107 - 1;
        goto L29
    L36:
        return;
    L31:
        return;
    L12:
        r105 = -1;
        goto L13
    }

    public final void n(int r100, float r101, boolean r102, boolean r103) {
        int r104 = Math.round(r100 + r101);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.f454199c.getChildCount()) goto L25;
        if (r103 == false) goto L14;
        SlidingTabStrip r105 = this.f454199c;
        ValueAnimator r106 = r105.f454237k;
        if (r106 != null) goto L11;
    L13:
        r105.f454229c = r100;
        r105.f454230d = r101;
        r105.b();
        goto L14
    L11:
        if (r106.isRunning() == false) goto L13;
        r105.f454237k.cancel();
    L14:
        ValueAnimator r107 = this.f454218v;
        if (r107 != null) goto L17;
    L19:
        scrollTo(g(r100, r101), 0);
        if (r102 == false) goto L24;
        setSelectedTabView(r104);
        return;
    L24:
        return;
    L17:
        if (r107.isRunning() == false) goto L19;
        this.f454218v.cancel();
        goto L19
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, boolean r118) {
        return super.overScrollBy(r110, r111, r112, r113, r114, r115, 80, r117, r118);
    }
}
