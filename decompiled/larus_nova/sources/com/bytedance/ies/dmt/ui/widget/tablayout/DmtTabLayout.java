package com.bytedance.ies.dmt.ui.widget.tablayout;

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
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
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
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.dux.api.IDuxComponentService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@ViewPager.DecorView
public class DmtTabLayout extends HorizontalScrollView {
    public static final FastOutSlowInInterpolator N = null;
    public static final Pools.SynchronizedPool O = null;
    public l A;
    public ValueAnimator B;
    public ViewPager C;
    public PagerAdapter D;
    public h E;
    public TabLayoutOnPageChangeListener F;
    public b G;
    public boolean H;
    public f I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Pools.SimplePool f248482J;
    public final int K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f248483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<j> f248484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f248485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f248486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f248487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f248488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f248489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f248490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f248491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f248492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f248493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f248494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f248495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f248496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f248497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f248498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f248499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f248500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f248501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f248502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f248503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f248504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f248505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f248506x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<g> f248507y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList<d> f248508z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DmtTabLayout> f248509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f248510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f248511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f248512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f248513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArgbEvaluator f248514f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AccelerateInterpolator f248515g;

        public TabLayoutOnPageChangeListener(DmtTabLayout r100) {
            this.f248514f = new ArgbEvaluator();
            this.f248515g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f248509a = new WeakReference(r100);
            this.f248513e = r100.getTabTextColors().getColorForState(DmtTabLayout.a(), 0);
            this.f248512d = r100.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f248510b = this.f248511c;
            this.f248511c = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            DmtTabLayout r101 = this.f248509a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getSelectedTabPosition() != r100) goto L7;
            return;
        L7:
            if (r100 >= r101.getTabCount()) goto L21;
            int r102 = this.f248511c;
            if (r102 != 0) goto L11;
        L16:
            boolean r103 = true;
        L17:
            r101.m(r101.j(r100), r103);
            return;
        L11:
            if (r102 == 2) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (this.f248510b != 0) goto L15;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r110, float r111, int r112) {
            DmtTabLayout r113 = this.f248509a.get();
            if (r113 == null) goto L41;
            int r100 = this.f248511c;
            if (r100 == 2) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r100 == 2) goto L13;
        L16:
            boolean r102 = true;
        L17:
            r113.o(r110, r111, r101, r102);
            if (this.f248511c == 2) goto L20;
        L22:
            i r114 = r113.f248486d;
            r114.f248533n = true;
            View r115 = r114.getChildAt(r114.f248524e);
            i r103 = r113.f248486d;
            View r104 = r103.getChildAt(r103.f248524e + 1);
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
            int r121 = ((Integer) this.f248514f.evaluate(r111, Integer.valueOf(this.f248513e), Integer.valueOf(this.f248512d))).intValue();
            if (r117 == null) goto L33;
            if (r118 == null) goto L33;
            r118.setTextColor(r121);
            r117.setImageAlpha(Color.alpha(r121));
        L33:
            int r122 = ((Integer) this.f248514f.evaluate(r111, Integer.valueOf(this.f248512d), Integer.valueOf(this.f248513e))).intValue();
            if (r119 == null) goto L38;
            if (r120 == null) goto L38;
            r120.setTextColor(r122);
            r119.setImageAlpha(Color.alpha(r122));
        L38:
            r113.f248486d.f248531l = r116 + ((r108 - r116) * this.f248515g.getInterpolation(r111));
            r113.f248486d.f248532m = r107 + ((r109 - r107) * this.f248515g.getInterpolation(r111));
        L39:
            ViewCompat.postInvalidateOnAnimation(r113.f248486d);
            return;
        L20:
            if (this.f248510b != 0) goto L22;
            r113.f248486d.f248533n = false;
            goto L39
        L13:
            if (this.f248510b != 0) goto L16;
            r102 = false;
            goto L17
        L7:
            if (this.f248510b == 1) goto L10;
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
        public final /* synthetic */ DmtTabLayout f248516a;

        public a(DmtTabLayout r100) {
            this.f248516a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f248516a.scrollTo(((Integer) r100.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f248517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f248518b;

        public b(DmtTabLayout r100) {
            this.f248518b = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            DmtTabLayout r103 = this.f248518b;
            if (r103.C != r100) goto L6;
            r103.n(r102, this.f248517a);
            return;
        }
    }

    public interface c {
    }

    public interface d {
        void a();
    }

    public interface e {
    }

    public interface f {
        void a(j r100);
    }

    public interface g {
        void a(j r100);

        void b(j r100);

        void c(j r100);
    }

    public class h extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f248519a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f248519a.l();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f248519a.l();
        }

        public h(DmtTabLayout r100) {
            this.f248519a = r100;
        }
    }

    public class i extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f248520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f248521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f248522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f248523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f248524e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f248525f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f248526g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f248527h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f248528i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ValueAnimator f248529j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f248530k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f248531l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f248532m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f248533n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f248534o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f248535p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f248536q;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f248537a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f248538b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f248539c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f248540d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ i f248541e;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                float r101 = r100.getAnimatedFraction();
                i r102 = this.f248541e;
                int r103 = this.f248537a;
                int r104 = this.f248538b;
                r102.getClass();
                int r105 = r103 + Math.round((r104 - r103) * r101);
                i r106 = this.f248541e;
                int r107 = this.f248539c;
                int r108 = this.f248540d;
                r106.getClass();
                int r109 = r107 + Math.round(r101 * (r108 - r107));
                if (r105 == r102.f248527h) goto L5;
            L6:
                r102.f248527h = r105;
                r102.f248528i = r109;
                ViewCompat.postInvalidateOnAnimation(r102);
                return;
            L5:
                if (r109 != r102.f248528i) goto L6;
            }

            public a(i r100, int r101, int r102, int r103, int r104) {
                this.f248541e = r100;
                this.f248537a = r101;
                this.f248538b = r102;
                this.f248539c = r103;
                this.f248540d = r104;
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f248542a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f248543b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                i r101 = this.f248543b;
                int r102 = r101.f248524e;
                r101.getClass();
                r101.f248524e = this.f248542a;
                r101.f248525f = 0.0f;
                DmtTabLayout r103 = r101.f248536q;
                int r104 = r103.f248508z.size();
            L3:
                r104 = r104 - 1;
                if (r104 < 0) goto L6;
                ((d) ListProtector.get(r103.f248508z, r104)).a();
                goto L3
            }

            public b(i r100, int r101) {
                this.f248543b = r100;
                this.f248542a = r101;
            }
        }

        public final void b() {
            View r100 = getChildAt(this.f248524e);
            if (r100 != null) goto L5;
        L11:
            int r101 = -1;
            int r102 = -1;
        L13:
            if (r102 == this.f248527h) goto L15;
        L16:
            this.f248527h = r102;
            this.f248528i = r101;
            ViewCompat.postInvalidateOnAnimation(this);
        L17:
            DmtTabLayout r103 = this.f248536q;
            int r104 = r103.f248508z.size();
        L18:
            r104 = r104 - 1;
            if (r104 < 0) goto L21;
            ((d) ListProtector.get(r103.f248508z, r104)).a();
            goto L18
        L21:
            return;
        L15:
            if (r101 == this.f248528i) goto L17;
        L5:
            if (r100.getWidth() <= 0) goto L11;
            r102 = r100.getLeft();
            r101 = r100.getRight();
            if (this.f248525f <= 0.0f) goto L13;
            if (this.f248524e >= (getChildCount() - 1)) goto L13;
            View r105 = getChildAt(this.f248524e + 1);
            float r106 = this.f248525f * r105.getLeft();
            float r107 = this.f248525f;
            r102 = (int) (r106 + ((1.0f - r107) * r102));
            r101 = (int) ((r107 * r105.getRight()) + ((1.0f - this.f248525f) * r101));
            goto L13
        }

        @Override // android.view.View
        public final void draw(Canvas r110) {
            int r100 = this.f248527h;
            if (r100 >= 0) goto L5;
        L24:
            super.draw(r110);
            return;
        L5:
            if (this.f248528i <= r100) goto L24;
            View r101 = getChildAt(this.f248536q.getSelectedTabPosition());
            if (r101 == null) goto L17;
            View r102 = r101.findViewById(R.id.layout_tab_indicator);
            if (r102 == null) goto L17;
            if (this.f248536q.C != null) goto L13;
        L14:
            int r103 = this.f248527h;
            float r104 = r103 + (((this.f248528i - r103) - r102.getWidth()) / 2);
            this.f248531l = r104;
            this.f248532m = r104 + r102.getWidth();
        L15:
            float r105 = this.f248531l + this.f248534o;
            float r106 = (getHeight() - this.f248520a) - this.f248535p;
            float r107 = this.f248532m - this.f248534o;
            float r108 = getHeight() - this.f248535p;
            int r109 = this.f248523d;
            r110.drawRoundRect(r105, r106, r107, r108, r109, r109, this.f248522c);
            return;
        L13:
            if (this.f248533n == true) goto L15;
        L17:
            int r111 = this.f248521b;
            if (r111 <= 0) goto L22;
            int r112 = this.f248528i;
            int r113 = this.f248527h;
            if (r111 >= (r112 - r113)) goto L22;
            float r114 = (r113 + r112) * 0.5f;
            float r115 = r114 - (r111 * 0.5f);
            float r116 = r114 + (r111 * 0.5f);
        L23:
            float r117 = r115 + this.f248534o;
            float r118 = (getHeight() - this.f248520a) - this.f248535p;
            float r119 = r116 - this.f248534o;
            float r120 = getHeight() - this.f248535p;
            int r121 = this.f248523d;
            r110.drawRoundRect(r117, r118, r119, r120, r121, r121, this.f248522c);
        L22:
            r115 = this.f248527h;
            r116 = this.f248528i;
            goto L23
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r100) {
            super.onRtlPropertiesChanged(r100);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f248526g == r100) goto L9;
            requestLayout();
            this.f248526g = r100;
            return;
        }

        public i(DmtTabLayout r100, Context r101) {
            this.f248536q = r100;
            super(r101);
            this.f248524e = -1;
            this.f248526g = -1;
            this.f248527h = -1;
            this.f248528i = -1;
            this.f248530k = Integer.MAX_VALUE;
            setWillNotDraw(false);
            this.f248522c = new Paint();
        }

        public final void a(int r110, int r111) {
            ValueAnimator r100 = this.f248529j;
            if (r100 == null) goto L8;
            if (r100.isRunning() == false) goto L8;
            this.f248529j.cancel();
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
            if (Math.abs(r110 - this.f248524e) > 1) goto L18;
            int r105 = this.f248527h;
            int r106 = this.f248528i;
        L26:
            if (r105 != r103) goto L28;
            if (r106 != r104) goto L28;
            return;
        L28:
            ValueAnimator r107 = new ValueAnimator();
            this.f248529j = r107;
            r107.setInterpolator(DmtTabLayout.N);
            r107.setDuration(r111);
            r107.setFloatValues(new float[]{0.0f, 1.0f});
            r107.addUpdateListener(new a(this, r105, r103, r106, r104));
            r107.addListener(new b(this, r110));
            r107.start();
            return;
        L18:
            int r108 = this.f248536q.h(24);
            if (r110 >= this.f248524e) goto L22;
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
            this.f248530k = Math.min(this.f248530k, r104.getMeasuredWidth());
        L10:
            r102 = r102 + 1;
            goto L6
        L11:
            DmtTabLayout r105 = this.f248536q;
            int r106 = r105.f248503u;
            boolean r107 = true;
            if (r106 == 1) goto L14;
        L31:
            if (r106 == 0) goto L33;
            return;
        L33:
            if (r105.f248505w == true) goto L35;
            return;
        L35:
            if (r105.K != getResources().getConfiguration().orientation) goto L37;
        L39:
            if (r103 > 0) goto L41;
            return;
        L41:
            int r108 = 0;
            int r109 = 0;
        L43:
            if (r108 >= r100) goto L48;
            View r112 = getChildAt(r108);
            if (r112.getVisibility() == 8) goto L47;
            r109 = r109 + r112.getMeasuredWidth();
        L47:
            r108 = r108 + 1;
            goto L43
        L48:
            if (r109 > 0) goto L50;
            return;
        L50:
            int r113 = (this.f248536q.getMeasuredWidth() - this.f248536q.f248486d.getPaddingLeft()) - this.f248536q.f248486d.getPaddingRight();
            if (r109 >= r113) goto L69;
            if ((r103 * r100) >= r113) goto L62;
            int r114 = 0;
            int r115 = 0;
        L55:
            if (r114 >= r100) goto L78;
            LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) getChildAt(r114).getLayoutParams();
            if (r116.width == 0) goto L59;
        L60:
            r116.width = 0;
            r116.weight = 1.0f;
            r115 = 1;
        L61:
            r114 = r114 + 1;
            goto L55
        L59:
            if (r116.weight == 1.0f) goto L61;
        L78:
            r101 = r115;
        L79:
            if (r101 == 0) goto L104;
            super.onMeasure(r110, r111);
            return;
        L104:
            return;
        L62:
            int r117 = (r113 - r109) / (r100 * 2);
            r115 = 0;
        L63:
            if (r101 >= r100) goto L78;
            if (getChildAt(r101).getVisibility() == 8) goto L67;
            LinearLayout.LayoutParams r118 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            r118.leftMargin = r117;
            r118.rightMargin = r117;
            r115 = 1;
        L67:
            r101 = r101 + 1;
            goto L63
        L69:
            if (this.f248536q.f248483a == false) goto L79;
            int r119 = 0;
            r115 = 0;
        L71:
            if (r119 >= r100) goto L78;
            LinearLayout.LayoutParams r120 = (LinearLayout.LayoutParams) getChildAt(r119).getLayoutParams();
            if (r120.width == 0) goto L75;
        L76:
            r120.width = 0;
            r120.weight = 1.0f;
            r115 = 1;
        L77:
            r119 = r119 + 1;
            goto L71
        L75:
            if (r120.weight == 1.0f) goto L77;
        L37:
            if (((IDuxComponentService) ServiceManager.get().getService(IDuxComponentService.class)).isPad() == true) goto L39;
            return;
        L14:
            if (r105.f248502t != 1) goto L31;
            if (r103 > 0) goto L17;
            return;
        L17:
            int r121 = r105.h(16);
            if ((r103 * r100) > (getMeasuredWidth() - (r121 * 2))) goto L28;
            boolean r122 = false;
        L20:
            if (r101 >= r100) goto L27;
            LinearLayout.LayoutParams r123 = (LinearLayout.LayoutParams) getChildAt(r101).getLayoutParams();
            if (r123.width == r103) goto L24;
        L25:
            r123.width = r103;
            r123.weight = 0.0f;
            r122 = true;
        L26:
            r101 = r101 + 1;
            goto L20
        L24:
            if (r123.weight == 0.0f) goto L26;
        L27:
            r107 = r122;
        L29:
            if (r107 == false) goto L100;
            super.onMeasure(r110, r111);
            return;
        L100:
            return;
        L28:
            DmtTabLayout r124 = this.f248536q;
            r124.f248502t = 0;
            r124.r(false);
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.f248529j;
            if (r105 != null) goto L5;
        L7:
            b();
            return;
        L5:
            if (r105.isRunning() == false) goto L7;
            this.f248529j.cancel();
            a(this.f248524e, Math.round((1.0f - this.f248529j.getAnimatedFraction()) * this.f248529j.getDuration()));
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f248544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f248545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f248546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f248547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f248548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DmtTabLayout f248549f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public k f248550g;

        public final boolean a() {
            DmtTabLayout r100 = this.f248549f;
            if (r100 == null) goto L10;
            if (r100.getSelectedTabPosition() != this.f248547d) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final void b() {
            DmtTabLayout r100 = this.f248549f;
            if (r100 == null) goto L7;
            r100.m(this, true);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final void d() {
            k r100 = this.f248550g;
            if (r100 == null) goto L6;
            r100.update();
            return;
        }

        public j() {
            this.f248547d = -1;
        }

        public final void c(int r100) {
            DmtTabLayout r101 = this.f248550g.f248558h;
            FastOutSlowInInterpolator r102 = DmtTabLayout.N;
            r101.getClass();
            int r103 = d46.a.f466824a;
            Context r104 = this.f248550g.getContext();
            k r105 = this.f248550g;
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, RootDescription.ROOT_ELEMENT);
            int r106 = d46.a.f466824a;
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f248548e = LayoutInflater.from(r104).inflate(r100, r105, false);
            d();
        }
    }

    public class k extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f248551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f248552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f248553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f248554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f248555e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ImageView f248556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f248557g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f248558h;

        public final void update() {
            j r100 = this.f248551a;
            if (r100 == null) goto L5;
            View r101 = r100.f248548e;
        L6:
            if (r101 == null) goto L22;
            ViewParent r102 = r101.getParent();
            if (r102 == this) goto L12;
            if (r102 == null) goto L11;
            ((ViewGroup) r102).removeView(r101);
        L11:
            addView(r101);
        L12:
            this.f248554d = r101;
            TextView r103 = this.f248552b;
            if (r103 == null) goto L15;
            r103.setVisibility(8);
        L15:
            ImageView r104 = this.f248553c;
            if (r104 == null) goto L18;
            r104.setVisibility(8);
            this.f248553c.setImageDrawable(null);
        L18:
            TextView r105 = (TextView) r101.findViewById(android.R.id.text1);
            this.f248555e = r105;
            if (r105 == null) goto L21;
            this.f248557g = TextViewCompat.getMaxLines(r105);
        L21:
            this.f248556f = (ImageView) r101.findViewById(android.R.id.icon);
        L26:
            boolean r106 = false;
            if (this.f248554d == null) goto L29;
            TextView r107 = this.f248555e;
            if (r107 == null) goto L41;
        L42:
            a(r107, this.f248556f);
        L43:
            if (r100 != null) goto L45;
        L47:
            setSelected(r106);
            return;
        L45:
            if (r100.a() == false) goto L47;
            r106 = true;
            goto L47
        L41:
            if (this.f248556f == null) goto L43;
        L29:
            if (this.f248553c != null) goto L32;
            ImageView r108 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            addView(r108, 0);
            this.f248553c = r108;
        L32:
            if (this.f248552b != null) goto L34;
            TextView r109 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            addView(r109);
            this.f248552b = r109;
            this.f248557g = TextViewCompat.getMaxLines(r109);
        L34:
            TextViewCompat.setTextAppearance(this.f248552b, this.f248558h.f248492j);
            ColorStateList r110 = this.f248558h.f248493k;
            if (r110 == null) goto L37;
            this.f248552b.setTextColor(r110);
        L37:
            a(this.f248552b, this.f248553c);
            goto L43
        L22:
            View r111 = this.f248554d;
            if (r111 == null) goto L25;
            removeView(r111);
            DmtTabLayout r112 = this.f248558h;
            FastOutSlowInInterpolator r113 = DmtTabLayout.N;
            r112.getClass();
            this.f248554d = null;
        L25:
            this.f248555e = null;
            this.f248556f = null;
            goto L26
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r100 = super.performClick();
            if (this.f248551a == null) goto L12;
            if (r100 == true) goto L6;
            playSoundEffect(0);
        L6:
            f r101 = this.f248558h.I;
            if (r101 == null) goto L9;
            r101.a(this.f248551a);
        L10:
            return true;
        L9:
            this.f248551a.b();
            goto L10
        L12:
            return r100;
        }

        public j getTab() {
            return this.f248551a;
        }

        public TextView getTextView() {
            return this.f248552b;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r100) {
            DmtTabLayout r101 = this.f248558h;
            FastOutSlowInInterpolator r102 = DmtTabLayout.N;
            r101.getClass();
            return super.dispatchTouchEvent(r100);
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
            TextView r101 = this.f248552b;
            if (r101 == null) goto L9;
            r101.setSelected(r100);
        L9:
            ImageView r102 = this.f248553c;
            if (r102 == null) goto L12;
            r102.setSelected(r100);
        L12:
            View r103 = this.f248554d;
            if (r103 == null) goto L16;
            r103.setSelected(r100);
            return;
        }

        public void setTab(j r100) {
            if (r100 == this.f248551a) goto L6;
            this.f248551a = r100;
            update();
            return;
        }

        public k(DmtTabLayout r100, Context r101) {
            this.f248558h = r100;
            super(r101);
            this.f248557g = 2;
            int r102 = r100.f248496n;
            if (r102 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r101, r102));
        L5:
            ViewCompat.setPaddingRelative(this, r100.f248488f, r100.f248489g, r100.f248490h, r100.f248491i);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final void a(TextView r100, ImageView r101) {
            j r102 = this.f248551a;
            CharSequence r103 = null;
            if (r102 == null) goto L5;
            Drawable r104 = r102.f248544a;
        L6:
            if (r102 == null) goto L8;
            CharSequence r105 = r102.f248545b;
        L9:
            if (r102 == null) goto L11;
            CharSequence r106 = r102.f248546c;
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
            r107 = this.f248558h.h(8);
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
            int r104 = this.f248558h.getTabMaxWidth();
            if (r104 <= 0) goto L7;
            if (r103 == 0) goto L6;
            if (r102 <= r104) goto L7;
        L6:
            r100 = View.MeasureSpec.makeMeasureSpec(this.f248558h.f248497o, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r100, r101);
            if (this.f248552b == null) goto L35;
            getResources();
            float r105 = this.f248558h.f248494l;
            int r106 = this.f248557g;
            ImageView r107 = this.f248553c;
            boolean r108 = true;
            if (r107 != null) goto L12;
        L14:
            TextView r109 = this.f248552b;
            if (r109 != null) goto L17;
        L19:
            float r110 = this.f248552b.getTextSize();
            int r111 = this.f248552b.getLineCount();
            int r112 = TextViewCompat.getMaxLines(this.f248552b);
            if (r105 != r110) goto L24;
            if (r112 < 0) goto L36;
            if (r106 != r112) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.f248558h.f248503u != 1) goto L32;
            if (r105 <= r110) goto L32;
            if (r111 != 1) goto L32;
            Layout r113 = this.f248552b.getLayout();
            if (r113 != null) goto L30;
        L31:
            r108 = false;
            goto L32
        L30:
            if ((r113.getLineWidth(0) * (r105 / r113.getPaint().getTextSize())) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r108 == false) goto L38;
            this.f248552b.setTextSize(0, r105);
            this.f248552b.setMaxLines(r106);
            super.onMeasure(r100, r101);
            return;
        L38:
            return;
        L17:
            if (r109.getLineCount() <= 1) goto L19;
            r105 = this.f248558h.f248495m;
            goto L19
        L12:
            if (r107.getVisibility() != 0) goto L14;
            r106 = 1;
            goto L19
        }
    }

    public static class l implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f248559a;

        @Override // com.bytedance.ies.dmt.ui.widget.tablayout.DmtTabLayout.g
        public final void a(j r100) {
        }

        @Override // com.bytedance.ies.dmt.ui.widget.tablayout.DmtTabLayout.g
        public final void b(j r100) {
        }

        public l(ViewPager r100) {
            this.f248559a = r100;
        }

        @Override // com.bytedance.ies.dmt.ui.widget.tablayout.DmtTabLayout.g
        public final void c(j r100) {
            this.f248559a.setCurrentItem(r100.f248547d);
        }
    }

    public void setCustomViewInflate(c r100) {
    }

    public void setOnDispatchTouchEventListener(e r100) {
    }

    static {
        N = new FastOutSlowInInterpolator();
        O = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        int r100 = this.f248484b.size();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        j r103 = (j) ListProtector.get(this.f248484b, r102);
        if (r103 == null) goto L11;
        if (r103.f248544a == null) goto L11;
        if (TextUtils.isEmpty(r103.f248545b) == true) goto L11;
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
        i r100 = this.f248486d;
        return r100.f248524e + r100.f248525f;
    }

    private int getTabMinWidth() {
        int r100 = this.f248498p;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        if (this.f248503u == 0) goto L10;
        return 0;
    L10:
        return this.f248500r;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f248486d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public final void f() {
        if (this.f248503u != 0) goto L5;
        int r100 = Math.max(0, this.f248501s - this.f248488f);
    L6:
        ViewCompat.setPaddingRelative(this.f248486d, r100, 0, 0, 0);
        int r101 = this.f248503u;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L12;
        this.f248486d.setGravity(1);
    L12:
        r(true);
        return;
    L11:
        this.f248486d.setGravity(GravityCompat.START);
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public int getSelectedTabPosition() {
        j r100 = this.f248485c;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f248547d;
    }

    public int getTabCount() {
        return this.f248484b.size();
    }

    public int getTabStripLeftPadding() {
        return this.f248486d.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f248486d.getPaddingRight();
    }

    public final void i() {
        if (this.B != null) goto L6;
        ValueAnimator r100 = new ValueAnimator();
        this.B = r100;
        r100.setInterpolator(N);
        this.B.setDuration(200);
        this.B.addUpdateListener(new a(this));
        return;
    }

    public final void l() {
        int r100 = this.f248486d.getChildCount() - 1;
    L4:
        if (r100 < 0) goto L9;
        k r101 = (k) this.f248486d.getChildAt(r100);
        this.f248486d.removeViewAt(r100);
        if (r101 == null) goto L8;
        r101.setTab(null);
        r101.setSelected(false);
        this.f248482J.release(r101);
    L8:
        requestLayout();
        r100 = r100 - 1;
        goto L4
    L9:
        Iterator<j> r102 = this.f248484b.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        j r103 = r102.next();
        r102.remove();
        r103.f248549f = null;
        r103.f248550g = null;
        r103.f248544a = null;
        r103.f248545b = null;
        r103.f248546c = null;
        r103.f248547d = -1;
        r103.f248548e = null;
        O.release(r103);
        goto L11
    L13:
        this.f248485c = null;
        PagerAdapter r104 = this.D;
        if (r104 == null) goto L32;
        int r105 = r104.getCount();
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L18;
        j r107 = k(this.f248504v);
        r107.f248545b = this.D.getPageTitle(r106);
        r107.d();
        c(r107, false);
        r106 = r106 + 1;
        goto L16
    L18:
        ViewPager r108 = this.C;
        if (r108 == null) goto L33;
        if (r105 <= 0) goto L34;
        int r109 = r108.getCurrentItem();
        if (r109 != getSelectedTabPosition()) goto L24;
        return;
    L24:
        if (r109 >= getTabCount()) goto L36;
        m(j(r109), true);
        return;
    L36:
        return;
    L34:
        return;
    L33:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C != null) goto L8;
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
        if (this.H == false) goto L6;
        setupWithViewPager(null);
        this.H = false;
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
        return this.f248502t;
    }

    public int getTabMaxWidth() {
        return this.f248497o;
    }

    public int getTabMode() {
        return this.f248503u;
    }

    public ColorStateList getTabTextColors() {
        return this.f248493k;
    }

    public DmtTabLayout(Context r100) {
        this(r100, null);
    }

    private void setSelectedTabView(int r100) {
        int r101 = this.f248486d.getChildCount();
        if (r100 >= r101) goto L11;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L15;
        View r103 = this.f248486d.getChildAt(r102);
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

    public final void b(g r100) {
        if (this.f248507y.contains(r100) == true) goto L6;
        this.f248507y.add(r100);
        return;
    }

    public final void d(View r100) {
        if ((r100 instanceof DmtTabItem) == false) goto L18;
        DmtTabItem r101 = (DmtTabItem) r100;
        j r102 = k(0);
        CharSequence r103 = r101.f248479a;
        if (r103 == null) goto L7;
        r102.f248545b = r103;
        r102.d();
    L7:
        Drawable r104 = r101.f248480b;
        if (r104 == null) goto L10;
        r102.f248544a = r104;
        r102.d();
    L10:
        int r105 = r101.f248481c;
        if (r105 == 0) goto L14;
        r102.c(r105);
    L14:
        if (TextUtils.isEmpty(r101.getContentDescription()) == true) goto L16;
        r102.f248546c = r101.getContentDescription();
        r102.d();
    L16:
        c(r102, this.f248484b.isEmpty());
        return;
    L18:
        if ((r100 instanceof i) == true) goto L20;
        return;
    L20:
        if (indexOfChild(r100) != (-1)) goto L25;
        super.addView(r100, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    }

    public final void e(int r100) {
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L23:
        o(r100, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        i r101 = this.f248486d;
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
        this.B.setIntValues(new int[]{r105, r106});
        this.B.start();
    L21:
        this.f248486d.a(r100, 200);
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

    public final j j(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r100 >= getTabCount()) goto L7;
        return (j) ListProtector.get(this.f248484b, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j k(int r100) {
        j r101 = (j) O.acquire();
        if (r101 != null) goto L5;
        r101 = new j();
    L5:
        r101.f248549f = this;
        Pools.SimplePool r102 = this.f248482J;
        if (r102 == null) goto L8;
        k r103 = (k) r102.acquire();
    L9:
        if (r103 != null) goto L11;
        r103 = new k(this, getContext());
    L11:
        r103.setFocusable(true);
        r103.setMinimumWidth(getTabMinWidth());
        r101.f248550g = r103;
        if (r100 > 0) goto L14;
        r103.setTab(r101);
    L18:
        return r101;
    L14:
        if (r101 == r103.f248551a) goto L16;
        r103.f248551a = r101;
    L16:
        r101.c(r100);
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    public final void q(LinearLayout.LayoutParams r100) {
        if (this.f248503u == 1) goto L5;
    L7:
        r100.width = -2;
        r100.weight = 0.0f;
    L8:
        int r101 = this.f248487e;
        if (r101 == 0) goto L12;
        r100.leftMargin = r101;
        r100.rightMargin = r101;
        return;
    L12:
        return;
    L5:
        if (this.f248502t != 0) goto L7;
        r100.width = 0;
        r100.weight = 1.0f;
        goto L8
    }

    public final void r(boolean r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f248486d.getChildCount()) goto L9;
        View r102 = this.f248486d.getChildAt(r101);
        r102.setMinimumWidth(getTabMinWidth());
        q((LinearLayout.LayoutParams) r102.getLayoutParams());
        if (r100 == false) goto L8;
        r102.requestLayout();
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void setAutoFillWhenScrollable(boolean r100) {
        this.f248505w = r100;
    }

    public void setContentInsetStart(int r100) {
        this.f248501s = r100;
    }

    public void setCustomTabViewResId(int r100) {
        this.f248504v = r100;
    }

    public void setLeftView(View r100) {
        removeAllViews();
        LinearLayout r101 = new LinearLayout(getContext());
        r101.addView(r100);
        r101.addView(this.f248486d, new FrameLayout.LayoutParams(-2, -1));
        super.addView(r101, 0, new FrameLayout.LayoutParams(-2, -1));
    }

    public void setOnTabClickListener(f r100) {
        this.I = r100;
    }

    public void setOnTabSelectedListener(g r100) {
        g r101 = this.f248506x;
        if (r101 == null) goto L5;
        this.f248507y.remove(r101);
    L5:
        this.f248506x = r100;
        if (r100 == null) goto L9;
        b(r100);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r100) {
        i();
        this.B.addListener(r100);
    }

    public void setSelectedTabHorizontalPadding(int r100) {
        this.f248486d.f248534o = r100;
    }

    public void setSelectedTabIndicatorBottomPadding(int r100) {
        this.f248486d.f248535p = r100;
    }

    public void setSelectedTabIndicatorColor(int r100) {
        i r101 = this.f248486d;
        if (r101.f248522c.getColor() == r100) goto L6;
        r101.f248522c.setColor(r100);
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r100) {
        i r101 = this.f248486d;
        if (r101.f248520a == r100) goto L6;
        r101.f248520a = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorRadius(int r100) {
        i r101 = this.f248486d;
        if (r101.f248523d == r100) goto L6;
        r101.f248523d = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorWidth(int r100) {
        i r101 = this.f248486d;
        if (r101.f248521b == r100) goto L6;
        r101.f248521b = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSkipUpdateTabMaxWidth(boolean r100) {
        this.L = r100;
    }

    public void setSkipUpdateTabMaxWidthOnFold(boolean r100) {
        this.M = r100;
    }

    public void setSplitWidthEvenly(boolean r100) {
        this.f248483a = r100;
    }

    public void setTabBackgroundResId(int r100) {
        this.f248496n = r100;
    }

    public void setTabGravity(int r100) {
        if (this.f248502t == r100) goto L6;
        this.f248502t = r100;
        f();
        return;
    }

    public void setTabMargin(int r100) {
        this.f248487e = h(r100);
        int r101 = 0;
    L4:
        if (r101 >= getTabCount()) goto L6;
        View r102 = this.f248486d.getChildAt(r101);
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r103.leftMargin = h(r100);
        r103.rightMargin = h(r100);
        r102.setLayoutParams(r103);
        r101 = r101 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r100) {
        this.f248499q = r100;
    }

    public void setTabMinWidth(int r100) {
        this.f248498p = r100;
    }

    public void setTabMode(String r100) {
        r100.getClass();
        if (r100.equals("scrollable") == true) goto L11;
        if (r100.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.f248503u == 1) goto L14;
        this.f248503u = 1;
        f();
        return;
    L14:
        return;
    L11:
        if (this.f248503u == 0) goto L16;
        this.f248503u = 0;
        f();
        return;
    }

    public void setTabPaddingBottom(int r100) {
        this.f248491i = r100;
    }

    public void setTabPaddingEnd(int r100) {
        this.f248490h = r100;
    }

    public void setTabPaddingStart(int r100) {
        this.f248488f = r100;
    }

    public void setTabPaddingTop(int r100) {
        this.f248489g = r100;
    }

    public void setTabTextAppearance(int r100) {
        this.f248492j = r100;
    }

    public void setTabTextColors(ColorStateList r100) {
        if (this.f248493k == r100) goto L7;
        this.f248493k = r100;
        int r101 = this.f248484b.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((j) ListProtector.get(this.f248484b, r102)).d();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabTextSize(float r100) {
        if (this.f248494l == r100) goto L7;
        this.f248494l = r100;
        int r101 = this.f248484b.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((j) ListProtector.get(this.f248484b, r102)).d();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r100) {
        n(r100, false);
    }

    public void setupWithViewPager(ViewPager r100) {
        p(r100, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateDefaultLayoutParams();
    }

    public void setTabMode(int r100) {
        if (r100 == this.f248503u) goto L6;
        this.f248503u = r100;
        f();
        return;
    }

    public DmtTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        d(r100);
    }

    public final void c(j r100, boolean r101) {
        int r102 = this.f248484b.size();
        if (r100.f248549f != this) goto L13;
        r100.f248547d = r102;
        ListProtector.add(this.f248484b, r102, r100);
        int r103 = this.f248484b.size();
    L5:
        r102 = r102 + 1;
        if (r102 >= r103) goto L8;
        ((j) ListProtector.get(this.f248484b, r102)).f248547d = r102;
        goto L5
    L8:
        k r104 = r100.f248550g;
        i r105 = this.f248486d;
        int r106 = r100.f248547d;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -1);
        q(r107);
        r105.addView(r104, r106, r107);
        if (r101 == false) goto L15;
        r100.b();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final int g(int r100, float r101) {
        int r102 = 0;
        if (this.f248503u != 0) goto L21;
        View r103 = this.f248486d.getChildAt(r100);
        int r104 = r100 + 1;
        if (r104 >= this.f248486d.getChildCount()) goto L7;
        View r105 = this.f248486d.getChildAt(r104);
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
        int r108 = ((r102 + this.f248486d.getLeft()) + (r106 / 2)) - (getWidth() / 2);
        int r109 = (int) ((((r106 + r107) + (this.f248487e * 4)) * 0.5f) * r101);
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

    public final void m(j r100, boolean r101) {
        j r102 = this.f248485c;
        if (r102 != r100) goto L9;
        if (r102 == null) goto L30;
        int r103 = this.f248507y.size() - 1;
    L6:
        if (r103 < 0) goto L8;
        ((g) ListProtector.get(this.f248507y, r103)).a(r100);
        r103 = r103 - 1;
        goto L6
    L8:
        e(r100.f248547d);
        return;
    L30:
        return;
    L9:
        if (r100 == null) goto L11;
        int r104 = r100.f248547d;
    L12:
        if (r101 == false) goto L21;
        if (r102 != null) goto L15;
    L16:
        if (r104 == (-1)) goto L18;
        o(r104, 0.0f, true, true);
    L19:
        if (r104 == (-1)) goto L21;
        setSelectedTabView(r104);
    L18:
        e(r104);
        goto L19
    L15:
        if (r102.f248547d != (-1)) goto L18;
    L21:
        if (r102 == null) goto L25;
        int r105 = this.f248507y.size() - 1;
    L23:
        if (r105 < 0) goto L25;
        ((g) ListProtector.get(this.f248507y, r105)).b(r102);
        r105 = r105 - 1;
    L25:
        this.f248485c = r100;
        if (r100 == null) goto L35;
        int r106 = this.f248507y.size() - 1;
    L28:
        if (r106 < 0) goto L36;
        ((g) ListProtector.get(this.f248507y, r106)).c(r100);
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

    public final void n(PagerAdapter r100, boolean r101) {
        PagerAdapter r102 = this.D;
        if (r102 == null) goto L7;
        h r103 = this.E;
        if (r103 == null) goto L7;
        r102.unregisterDataSetObserver(r103);
    L7:
        this.D = r100;
        if (r101 == false) goto L14;
        if (r100 == null) goto L14;
        if (this.E != null) goto L13;
        this.E = new h(this);
    L13:
        r100.registerDataSetObserver(this.E);
    L14:
        l();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = (h(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r102 = View.MeasureSpec.getMode(r110);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r102 != 0) goto L8;
        r110 = View.MeasureSpec.makeMeasureSpec(r101, 1073741824);
    L8:
        int r103 = View.MeasureSpec.getSize(r100);
        boolean r104 = true;
        if (View.MeasureSpec.getMode(r100) == 0) goto L37;
        int r105 = this.f248499q;
        if (r105 > 0) goto L14;
        r105 = r103 - h(56);
    L14:
        this.f248497o = r105;
        if (((IDuxComponentService) ServiceManager.get().getService(IDuxComponentService.class)).isPad() == true) goto L19;
        if (this.M == false) goto L37;
    L19:
        if (this.L == true) goto L37;
        Context r106 = getContext();
        if (r106 == null) goto L33;
        WindowManager r107 = (WindowManager) r106.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L31
        if (r107 == null) goto L29;
        Display r108 = r107.getDefaultDisplay();     // Catch: Exception -> L31
        Point r109 = new Point();     // Catch: Exception -> L31
        if (r108 == null) goto L54;
        r108.getRealSize(r109);     // Catch: Exception -> L31
        j46.a.f497370b = r109.y;     // Catch: Exception -> L31
        j46.a.f497369a = r109.x;     // Catch: Exception -> L31
    L54:
        goto L33
    L29:
        Resources r111 = r106.getResources();     // Catch: Exception -> L31
        DisplayMetrics r112 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics());     // Catch: Exception -> L31
        j46.a.f497370b = r112.heightPixels;     // Catch: Exception -> L31
        j46.a.f497369a = r112.widthPixels;     // Catch: Exception -> L31
    L33:
        if (this.f248486d.getChildCount() <= 0) goto L35;
        int r113 = this.f248486d.getChildCount();
    L36:
        this.f248497o = (int) Math.ceil(((double) j46.a.b(getContext())) / (((double) r113) * 1.0d));
        goto L37
    L35:
        r113 = 1;
    L37:
        super.onMeasure(r100, r110);
        if (getChildCount() != 1) goto L57;
        boolean r114 = false;
        View r115 = getChildAt(0);
        int r116 = this.f248503u;
        if (r116 == 0) goto L47;
        if (r116 == 1) goto L44;
    L51:
        if (r114 == false) goto L58;
        int r117 = HorizontalScrollView.getChildMeasureSpec(r110, getPaddingTop() + getPaddingBottom(), r115.getLayoutParams().height);
        r115.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r117);
        return;
    L58:
        return;
    L44:
        if (r115.getMeasuredWidth() != getMeasuredWidth()) goto L50;
    L49:
        r104 = false;
    L50:
        r114 = r104;
        goto L51
    L47:
        if (r115.getMeasuredWidth() >= getMeasuredWidth()) goto L49;
    L57:
        return;
    L7:
        r110 = View.MeasureSpec.makeMeasureSpec(Math.min(r101, View.MeasureSpec.getSize(r110)), 1073741824);
        goto L8
    }

    public final void p(ViewPager r100, boolean r101) {
        ViewPager r102 = this.C;
        if (r102 == null) goto L10;
        TabLayoutOnPageChangeListener r103 = this.F;
        if (r103 == null) goto L7;
        r102.removeOnPageChangeListener(r103);
    L7:
        b r104 = this.G;
        if (r104 == null) goto L10;
        this.C.removeOnAdapterChangeListener(r104);
    L10:
        l r105 = this.A;
        if (r105 == null) goto L14;
        this.f248507y.remove(r105);
        this.A = null;
    L14:
        if (r100 == null) goto L25;
        this.C = r100;
        if (this.F != null) goto L18;
        this.F = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r106 = this.F;
        r106.f248510b = 0;
        r106.f248511c = 0;
        r100.addOnPageChangeListener(r106);
        l r107 = new l(r100);
        this.A = r107;
        b(r107);
        PagerAdapter r108 = r100.getAdapter();
        if (r108 == null) goto L22;
        n(r108, true);
    L22:
        if (this.G != null) goto L24;
        this.G = new b(this);
    L24:
        b r109 = this.G;
        r109.f248517a = true;
        r100.addOnAdapterChangeListener(r109);
        o(r100.getCurrentItem(), 0.0f, true, true);
    L26:
        this.H = r101;
        return;
    L25:
        this.C = null;
        n(null, false);
        goto L26
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        d(r100);
    }

    public DmtTabLayout(Context r110, AttributeSet r111, int r210) {
        super(r110, r111, r210);
        this.f248484b = new ArrayList();
        this.f248497o = Integer.MAX_VALUE;
        this.f248507y = new ArrayList();
        this.f248508z = new ArrayList();
        this.f248482J = new Pools.SimplePool(12);
        this.L = false;
        this.M = false;
        setHorizontalScrollBarEnabled(false);
        i r100 = new i(this, r110);
        this.f248486d = r100;
        super.addView(r100, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{R.attr.tabBackground, R.attr.tabContentStart, R.attr.tabGravity, R.attr.tabIconTint, R.attr.tabIconTintMode, R.attr.tabIndicator, R.attr.tabIndicatorAnimationDuration, R.attr.tabIndicatorColor, R.attr.tabIndicatorFullWidth, R.attr.tabIndicatorGravity, R.attr.tabIndicatorHeight, R.attr.tabInlineLabel, R.attr.tabMaxWidth, R.attr.tabMinWidth, R.attr.tabMode, R.attr.tabPadding, R.attr.tabPaddingBottom, R.attr.tabPaddingEnd, R.attr.tabPaddingStart, R.attr.tabPaddingTop, R.attr.tabRippleColor, R.attr.tabSelectedTextColor, R.attr.tabTextAppearance, R.attr.tabTextColor, R.attr.tabUnboundedRipple}, r210, R.style.Widget_Design_TabLayout);
        int r112 = r101.getDimensionPixelSize(10, 0);
        if (r100.f248520a == r112) goto L5;
        r100.f248520a = r112;
        ViewCompat.postInvalidateOnAnimation(r100);
    L5:
        int r113 = r101.getDimensionPixelSize(15, 0);
        this.f248488f = r113;
        this.f248489g = r113;
        this.f248490h = r113;
        this.f248491i = r113;
        this.f248488f = r101.getDimensionPixelSize(18, r113);
        this.f248489g = r101.getDimensionPixelSize(19, this.f248489g);
        this.f248490h = r101.getDimensionPixelSize(17, this.f248490h);
        this.f248491i = r101.getDimensionPixelSize(16, this.f248491i);
        int r114 = r101.getResourceId(22, R.style.TextAppearance_Design_Tab);
        this.f248492j = r114;
        TypedArray r115 = r110.obtainStyledAttributes(r114, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        int r116 = r101.getColor(7, 0);     // Catch: Throwable -> L21
        if (r100.f248522c.getColor() == r116) goto L9;
        r100.f248522c.setColor(r116);     // Catch: Throwable -> L21
        ViewCompat.postInvalidateOnAnimation(r100);     // Catch: Throwable -> L21
    L9:
        this.f248494l = r115.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L21
        this.f248493k = r115.getColorStateList(3);     // Catch: Throwable -> L21
        r115.recycle();
        if (r101.hasValue(23) == false) goto L14;
        this.f248493k = r101.getColorStateList(23);
    L14:
        if (r101.hasValue(21) == false) goto L16;
        this.f248493k = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r101.getColor(21, 0), this.f248493k.getDefaultColor()});
    L16:
        this.f248498p = r101.getDimensionPixelSize(13, -1);
        this.f248499q = r101.getDimensionPixelSize(12, -1);
        this.f248496n = r101.getResourceId(0, 0);
        this.f248501s = r101.getDimensionPixelSize(1, 0);
        this.f248503u = r101.getInt(14, 1);
        this.f248502t = r101.getInt(2, 0);
        r101.recycle();
        TypedArray r102 = r110.obtainStyledAttributes(r111, new int[]{R.attr.tabIndicatorWidth}, r210, R.style.Widget_Design_TabLayout);
        int r103 = r102.getDimensionPixelSize(0, 0);
        if (r100.f248521b == r103) goto L19;
        r100.f248521b = r103;
        ViewCompat.postInvalidateOnAnimation(r100);
    L19:
        r102.recycle();
        Resources r104 = getResources();
        this.f248495m = r104.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.f248500r = r104.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        dm4.a.a(getContext(), 1.5f);
        dm4.a.a(getContext(), 1.5f);
        this.K = getResources().getConfiguration().orientation;
        f();
        return;
    L21:
        th = move-exception;
        r115.recycle();
        throw th;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        d(r100);
    }

    public final void o(int r100, float r101, boolean r102, boolean r103) {
        int r104 = Math.round(r100 + r101);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.f248486d.getChildCount()) goto L25;
        if (r103 == false) goto L14;
        i r105 = this.f248486d;
        ValueAnimator r106 = r105.f248529j;
        if (r106 != null) goto L11;
    L13:
        int r107 = r105.f248524e;
        r105.getClass();
        r105.f248524e = r100;
        r105.f248525f = r101;
        r105.b();
        goto L14
    L11:
        if (r106.isRunning() == false) goto L13;
        r105.f248529j.cancel();
    L14:
        ValueAnimator r108 = this.B;
        if (r108 != null) goto L17;
    L19:
        scrollTo(g(r100, r101), 0);
        if (r102 == false) goto L24;
        setSelectedTabView(r104);
        return;
    L24:
        return;
    L17:
        if (r108.isRunning() == false) goto L19;
        this.B.cancel();
        goto L19
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, boolean r118) {
        return super.overScrollBy(r110, r111, r112, r113, r114, r115, 80, r117, r118);
    }
}
