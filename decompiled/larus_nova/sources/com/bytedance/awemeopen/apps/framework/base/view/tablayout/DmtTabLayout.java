package com.bytedance.awemeopen.apps.framework.base.view.tablayout;

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
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.UserProfileViewPager;
import com.bytedance.awemeopen.apps.framework.profile.AosUserProfileFragment;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@ViewPager.DecorView
public class DmtTabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f193672J = null;
    public static final Pools.SynchronizedPool K = null;
    public ViewPager A;
    public PagerAdapter B;
    public f C;
    public TabLayoutOnPageChangeListener D;
    public b E;
    public boolean F;
    public d G;
    public final Pools.SimplePool H;
    public final int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<h> f193673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f193674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f193675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f193677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f193678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f193679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f193680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f193681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f193682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f193683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f193684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f193685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f193686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f193687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f193688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f193689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f193690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f193691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f193692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f193693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f193694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public e f193695w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList<e> f193696x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public j f193697y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f193698z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DmtTabLayout> f193699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f193700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f193701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f193702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f193703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArgbEvaluator f193704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AccelerateInterpolator f193705g;

        public TabLayoutOnPageChangeListener(DmtTabLayout r100) {
            this.f193704f = new ArgbEvaluator();
            this.f193705g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f193699a = new WeakReference(r100);
            this.f193703e = r100.getTabTextColors().getColorForState(DmtTabLayout.a(), 0);
            this.f193702d = r100.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f193700b = this.f193701c;
            this.f193701c = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            DmtTabLayout r101 = this.f193699a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getSelectedTabPosition() != r100) goto L7;
            return;
        L7:
            if (r100 >= r101.getTabCount()) goto L21;
            int r102 = this.f193701c;
            if (r102 != 0) goto L11;
        L16:
            boolean r103 = true;
        L17:
            r101.l(r101.i(r100), r103);
            return;
        L11:
            if (r102 == 2) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (this.f193700b != 0) goto L15;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r110, float r111, int r112) {
            DmtTabLayout r113 = this.f193699a.get();
            if (r113 == null) goto L41;
            int r100 = this.f193701c;
            if (r100 == 2) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r100 == 2) goto L13;
        L16:
            boolean r102 = true;
        L17:
            r113.n(r110, r111, r101, r102);
            if (this.f193701c == 2) goto L20;
        L22:
            g r114 = r113.f193675c;
            r114.f193721l = true;
            View r115 = r114.getChildAt(r114.f193712c);
            g r103 = r113.f193675c;
            View r104 = r103.getChildAt(r103.f193712c + 1);
            if (r115 == null) goto L39;
            if (r104 == null) goto L39;
            View r105 = r115.findViewById(R.id.aos_layout_tab_indicator);
            View r106 = r104.findViewById(R.id.aos_layout_tab_indicator);
            if (r105 == null) goto L39;
            if (r106 == null) goto L39;
            float r116 = r115.getLeft() + ((r115.getWidth() - r105.getWidth()) / 2);
            float r107 = r105.getWidth() + r116;
            float r108 = r104.getLeft() + ((r104.getWidth() - r106.getWidth()) / 2);
            float r109 = r106.getWidth() + r108;
            ImageView r117 = (ImageView) r105.findViewById(R.id.aos_tab_item_img);
            TextView r118 = (TextView) r105.findViewById(R.id.aos_tab_item_text);
            ImageView r119 = (ImageView) r106.findViewById(R.id.aos_tab_item_img);
            TextView r120 = (TextView) r106.findViewById(R.id.aos_tab_item_text);
            int r121 = ((Integer) this.f193704f.evaluate(r111, Integer.valueOf(this.f193703e), Integer.valueOf(this.f193702d))).intValue();
            if (r117 == null) goto L33;
            if (r118 == null) goto L33;
            r118.setTextColor(r121);
            r117.setImageAlpha(Color.alpha(r121));
        L33:
            int r122 = ((Integer) this.f193704f.evaluate(r111, Integer.valueOf(this.f193702d), Integer.valueOf(this.f193703e))).intValue();
            if (r119 == null) goto L38;
            if (r120 == null) goto L38;
            r120.setTextColor(r122);
            r119.setImageAlpha(Color.alpha(r122));
        L38:
            r113.f193675c.f193719j = r116 + ((r108 - r116) * this.f193705g.getInterpolation(r111));
            r113.f193675c.f193720k = r107 + ((r109 - r107) * this.f193705g.getInterpolation(r111));
        L39:
            ViewCompat.postInvalidateOnAnimation(r113.f193675c);
            return;
        L20:
            if (this.f193700b != 0) goto L22;
            r113.f193675c.f193721l = false;
            goto L39
        L13:
            if (this.f193700b != 0) goto L16;
            r102 = false;
            goto L17
        L7:
            if (this.f193700b == 1) goto L10;
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
        public final /* synthetic */ DmtTabLayout f193706a;

        public a(DmtTabLayout r100) {
            this.f193706a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f193706a.scrollTo(((Integer) r100.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f193707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f193708b;

        public b(DmtTabLayout r100) {
            this.f193708b = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            DmtTabLayout r103 = this.f193708b;
            if (r103.A != r100) goto L6;
            r103.m(r102, this.f193707a);
            return;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
        void V();

        void W();

        void X(h r100);
    }

    public class f extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f193709a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f193709a.k();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f193709a.k();
        }

        public f(DmtTabLayout r100) {
            this.f193709a = r100;
        }
    }

    public class g extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f193710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f193711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f193712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f193713d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f193714e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f193715f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f193716g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ValueAnimator f193717h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f193718i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f193719j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f193720k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f193721l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f193722m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f193723n;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f193724a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f193725b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f193726c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f193727d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ g f193728e;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                float r101 = r100.getAnimatedFraction();
                g r102 = this.f193728e;
                int r103 = this.f193724a;
                int r104 = this.f193725b;
                r102.getClass();
                int r105 = r103 + Math.round((r104 - r103) * r101);
                g r106 = this.f193728e;
                int r107 = this.f193726c;
                int r108 = this.f193727d;
                r106.getClass();
                int r109 = r107 + Math.round(r101 * (r108 - r107));
                if (r105 == r102.f193715f) goto L5;
            L6:
                r102.f193715f = r105;
                r102.f193716g = r109;
                ViewCompat.postInvalidateOnAnimation(r102);
                return;
            L5:
                if (r109 != r102.f193716g) goto L6;
            }

            public a(g r100, int r101, int r102, int r103, int r104) {
                this.f193728e = r100;
                this.f193724a = r101;
                this.f193725b = r102;
                this.f193726c = r103;
                this.f193727d = r104;
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f193729a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f193730b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                g r101 = this.f193730b;
                r101.f193712c = this.f193729a;
                r101.f193713d = 0.0f;
            }

            public b(g r100, int r101) {
                this.f193730b = r100;
                this.f193729a = r101;
            }
        }

        public final void b() {
            View r100 = getChildAt(this.f193712c);
            int r101 = -1;
            if (r100 != null) goto L5;
        L12:
            int r102 = -1;
        L14:
            if (r101 == this.f193715f) goto L16;
        L17:
            this.f193715f = r101;
            this.f193716g = r102;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L16:
            if (r102 != this.f193716g) goto L17;
            return;
        L5:
            if (r100.getWidth() <= 0) goto L12;
            int r103 = r100.getLeft();
            r102 = r100.getRight();
            if (this.f193713d > 0.0f) goto L9;
        L11:
            r101 = r103;
            goto L14
        L9:
            if (this.f193712c >= (getChildCount() - 1)) goto L11;
            View r104 = getChildAt(this.f193712c + 1);
            float r105 = this.f193713d * r104.getLeft();
            float r106 = this.f193713d;
            r103 = (int) (r105 + ((1.0f - r106) * r103));
            r102 = (int) ((r106 * r104.getRight()) + ((1.0f - this.f193713d) * r102));
            goto L11
        }

        @Override // android.view.View
        public final void draw(Canvas r100) {
            super.draw(r100);
            int r101 = this.f193715f;
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (this.f193716g <= r101) goto L20;
            View r102 = getChildAt(this.f193723n.getSelectedTabPosition());
            if (r102 == null) goto L17;
            View r103 = r102.findViewById(R.id.aos_layout_tab_indicator);
            if (r103 == null) goto L17;
            if (this.f193723n.A != null) goto L13;
        L14:
            int r104 = this.f193715f;
            float r105 = r104 + (((this.f193716g - r104) - r103.getWidth()) / 2);
            this.f193719j = r105;
            this.f193720k = r105 + r103.getWidth();
        L15:
            r100.drawRect(this.f193719j + this.f193722m, getHeight() - this.f193710a, this.f193720k - this.f193722m, getHeight(), this.f193711b);
            return;
        L13:
            if (this.f193721l == true) goto L15;
        L17:
            r100.drawRect(this.f193715f + this.f193722m, getHeight() - this.f193710a, this.f193716g - this.f193722m, getHeight(), this.f193711b);
            return;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r100) {
            super.onRtlPropertiesChanged(r100);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.f193714e == r100) goto L9;
            requestLayout();
            this.f193714e = r100;
            return;
        }

        public g(DmtTabLayout r100, Context r101) {
            this.f193723n = r100;
            super(r101);
            this.f193712c = -1;
            this.f193714e = -1;
            this.f193715f = -1;
            this.f193716g = -1;
            r100.g(27);
            this.f193718i = Integer.MAX_VALUE;
            setWillNotDraw(false);
            this.f193711b = new Paint();
        }

        public final void a(int r110, int r111) {
            ValueAnimator r100 = this.f193717h;
            if (r100 == null) goto L8;
            if (r100.isRunning() == false) goto L8;
            this.f193717h.cancel();
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
            if (Math.abs(r110 - this.f193712c) > 1) goto L18;
            int r105 = this.f193715f;
            int r106 = this.f193716g;
        L26:
            if (r105 != r103) goto L28;
            if (r106 != r104) goto L28;
            return;
        L28:
            ValueAnimator r107 = new ValueAnimator();
            this.f193717h = r107;
            r107.setInterpolator(DmtTabLayout.f193672J);
            r107.setDuration(r111);
            r107.setFloatValues(new float[]{0.0f, 1.0f});
            r107.addUpdateListener(new a(this, r105, r103, r106, r104));
            r107.addListener(new b(this, r110));
            r107.start();
            return;
        L18:
            int r108 = this.f193723n.g(24);
            if (r110 >= this.f193712c) goto L22;
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
            this.f193718i = Math.min(this.f193718i, r104.getMeasuredWidth());
        L10:
            r102 = r102 + 1;
            goto L6
        L11:
            DmtTabLayout r105 = this.f193723n;
            int r106 = r105.f193692t;
            boolean r107 = true;
            if (r106 == 1) goto L14;
        L31:
            if (r106 == 0) goto L33;
            return;
        L33:
            if (r105.f193694v == true) goto L35;
            return;
        L35:
            if (r105.I == getResources().getConfiguration().orientation) goto L37;
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
            int r113 = (this.f193723n.getMeasuredWidth() - this.f193723n.f193675c.getPaddingLeft()) - this.f193723n.f193675c.getPaddingRight();
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
            if (r105.f193691s != 1) goto L31;
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
            DmtTabLayout r122 = this.f193723n;
            r122.f193691s = 0;
            r122.q(false);
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.f193717h;
            if (r105 != null) goto L5;
        L7:
            b();
            return;
        L5:
            if (r105.isRunning() == false) goto L7;
            this.f193717h.cancel();
            a(this.f193712c, Math.round((1.0f - this.f193717h.getAnimatedFraction()) * this.f193717h.getDuration()));
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f193731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f193732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f193733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f193734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f193735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DmtTabLayout f193736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public i f193737g;

        public final void a() {
            DmtTabLayout r100 = this.f193736f;
            if (r100 == null) goto L7;
            r100.l(this, true);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final void d() {
            i r100 = this.f193737g;
            if (r100 == null) goto L6;
            r100.update();
            return;
        }

        public h() {
            this.f193734d = -1;
        }

        public final void b(int r100) {
            DmtTabLayout r101 = this.f193737g.f193745h;
            FastOutSlowInInterpolator r102 = DmtTabLayout.f193672J;
            r101.getClass();
            int r103 = com.bytedance.awemeopen.apps.framework.base.view.tablayout.a.f193747a;
            Context r104 = this.f193737g.getContext();
            i r105 = this.f193737g;
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, RootDescription.ROOT_ELEMENT);
            int r106 = com.bytedance.awemeopen.apps.framework.base.view.tablayout.a.f193747a;
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f193735e = LayoutInflater.from(r104).inflate(r100, r105, false);
            d();
        }

        public final void c(CharSequence r100) {
            this.f193732b = r100;
            d();
        }
    }

    public class i extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f193738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f193739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f193740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f193741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f193742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ImageView f193743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f193744g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ DmtTabLayout f193745h;

        public final void update() {
            h r100 = this.f193738a;
            if (r100 == null) goto L5;
            View r101 = r100.f193735e;
        L6:
            if (r101 == null) goto L22;
            ViewParent r102 = r101.getParent();
            if (r102 == this) goto L12;
            if (r102 == null) goto L11;
            ((ViewGroup) r102).removeView(r101);
        L11:
            addView(r101);
        L12:
            this.f193741d = r101;
            TextView r103 = this.f193739b;
            if (r103 == null) goto L15;
            r103.setVisibility(8);
        L15:
            ImageView r104 = this.f193740c;
            if (r104 == null) goto L18;
            r104.setVisibility(8);
            this.f193740c.setImageDrawable(null);
        L18:
            TextView r105 = (TextView) r101.findViewById(android.R.id.text1);
            this.f193742e = r105;
            if (r105 == null) goto L21;
            this.f193744g = TextViewCompat.getMaxLines(r105);
        L21:
            this.f193743f = (ImageView) r101.findViewById(android.R.id.icon);
        L26:
            boolean r106 = false;
            if (this.f193741d == null) goto L29;
            TextView r107 = this.f193742e;
            if (r107 == null) goto L41;
        L42:
            a(r107, this.f193743f);
        L43:
            if (r100 == null) goto L54;
            DmtTabLayout r108 = r100.f193736f;
            if (r108 == null) goto L53;
            if (r108.getSelectedTabPosition() != r100.f193734d) goto L49;
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
            if (this.f193743f == null) goto L43;
        L29:
            if (this.f193740c != null) goto L32;
            ImageView r110 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            addView(r110, 0);
            this.f193740c = r110;
        L32:
            if (this.f193739b != null) goto L34;
            TextView r111 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            addView(r111);
            this.f193739b = r111;
            this.f193744g = TextViewCompat.getMaxLines(r111);
        L34:
            TextViewCompat.setTextAppearance(this.f193739b, this.f193745h.f193681i);
            ColorStateList r112 = this.f193745h.f193682j;
            if (r112 == null) goto L37;
            this.f193739b.setTextColor(r112);
        L37:
            a(this.f193739b, this.f193740c);
            goto L43
        L22:
            View r113 = this.f193741d;
            if (r113 == null) goto L25;
            removeView(r113);
            DmtTabLayout r114 = this.f193745h;
            FastOutSlowInInterpolator r115 = DmtTabLayout.f193672J;
            r114.getClass();
            this.f193741d = null;
        L25:
            this.f193742e = null;
            this.f193743f = null;
            goto L26
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r100 = super.performClick();
            if (this.f193738a == null) goto L14;
            if (r100 == true) goto L6;
            playSoundEffect(0);
        L6:
            d r101 = this.f193745h.G;
            if (r101 == null) goto L12;
            h r102 = this.f193738a;
            AosUserProfileFragment r103 = ((com.bytedance.awemeopen.apps.framework.profile.j) r101).f197338a;
            int r104 = AosUserProfileFragment.D;
            Intrinsics.checkNotNullParameter(r103, "this$0");
            UserProfileViewPager r105 = r103.f197301m;
            if (r105 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            r105 = null;
        L11:
            r105.y(r102.f193734d, true);
        L13:
            return true;
        L12:
            this.f193738a.a();
            goto L13
        L14:
            return r100;
        }

        public h getTab() {
            return this.f193738a;
        }

        public TextView getTextView() {
            return this.f193739b;
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
            TextView r101 = this.f193739b;
            if (r101 == null) goto L9;
            r101.setSelected(r100);
        L9:
            ImageView r102 = this.f193740c;
            if (r102 == null) goto L12;
            r102.setSelected(r100);
        L12:
            View r103 = this.f193741d;
            if (r103 == null) goto L16;
            r103.setSelected(r100);
            return;
        }

        public void setTab(h r100) {
            if (r100 == this.f193738a) goto L6;
            this.f193738a = r100;
            update();
            return;
        }

        public i(DmtTabLayout r100, Context r101) {
            this.f193745h = r100;
            super(r101);
            this.f193744g = 2;
            int r102 = r100.f193685m;
            if (r102 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r101, r102));
        L5:
            ViewCompat.setPaddingRelative(this, r100.f193677e, r100.f193678f, r100.f193679g, r100.f193680h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final void a(TextView r100, ImageView r101) {
            h r102 = this.f193738a;
            CharSequence r103 = null;
            if (r102 == null) goto L5;
            Drawable r104 = r102.f193731a;
        L6:
            if (r102 == null) goto L8;
            CharSequence r105 = r102.f193732b;
        L9:
            if (r102 == null) goto L11;
            CharSequence r106 = r102.f193733c;
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
            r107 = this.f193745h.g(8);
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
            int r104 = this.f193745h.getTabMaxWidth();
            if (r104 <= 0) goto L7;
            if (r103 == 0) goto L6;
            if (r102 <= r104) goto L7;
        L6:
            r100 = View.MeasureSpec.makeMeasureSpec(this.f193745h.f193686n, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r100, r101);
            if (this.f193739b == null) goto L35;
            getResources();
            float r105 = this.f193745h.f193683k;
            int r106 = this.f193744g;
            ImageView r107 = this.f193740c;
            boolean r108 = true;
            if (r107 != null) goto L12;
        L14:
            TextView r109 = this.f193739b;
            if (r109 != null) goto L17;
        L19:
            float r110 = this.f193739b.getTextSize();
            int r111 = this.f193739b.getLineCount();
            int r112 = TextViewCompat.getMaxLines(this.f193739b);
            if (r105 != r110) goto L24;
            if (r112 < 0) goto L36;
            if (r106 != r112) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.f193745h.f193692t != 1) goto L32;
            if (r105 <= r110) goto L32;
            if (r111 != 1) goto L32;
            Layout r113 = this.f193739b.getLayout();
            if (r113 != null) goto L30;
        L31:
            r108 = false;
            goto L32
        L30:
            if ((r113.getLineWidth(0) * (r105 / r113.getPaint().getTextSize())) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r108 == false) goto L38;
            this.f193739b.setTextSize(0, r105);
            this.f193739b.setMaxLines(r106);
            super.onMeasure(r100, r101);
            return;
        L38:
            return;
        L17:
            if (r109.getLineCount() <= 1) goto L19;
            r105 = this.f193745h.f193684l;
            goto L19
        L12:
            if (r107.getVisibility() != 0) goto L14;
            r106 = 1;
            goto L19
        }
    }

    public static class j implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f193746a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout.e
        public final void V() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout.e
        public final void W() {
        }

        public j(ViewPager r100) {
            this.f193746a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout.e
        public final void X(h r100) {
            this.f193746a.setCurrentItem(r100.f193734d);
        }
    }

    public void setCustomViewInflate(c r100) {
    }

    static {
        f193672J = new FastOutSlowInInterpolator();
        K = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        int r100 = this.f193673a.size();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        h r103 = (h) ListProtector.get(this.f193673a, r102);
        if (r103 == null) goto L11;
        if (r103.f193731a == null) goto L11;
        if (TextUtils.isEmpty(r103.f193732b) == true) goto L11;
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
        g r100 = this.f193675c;
        return r100.f193712c + r100.f193713d;
    }

    private int getTabMinWidth() {
        int r100 = this.f193687o;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        if (this.f193692t == 0) goto L10;
        return 0;
    L10:
        return this.f193689q;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f193675c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public final void e() {
        if (this.f193692t != 0) goto L5;
        int r100 = Math.max(0, this.f193690r - this.f193677e);
    L6:
        ViewCompat.setPaddingRelative(this.f193675c, r100, 0, 0, 0);
        int r101 = this.f193692t;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L12;
        this.f193675c.setGravity(1);
    L12:
        q(true);
        return;
    L11:
        this.f193675c.setGravity(GravityCompat.START);
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    public int getSelectedTabPosition() {
        h r100 = this.f193674b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f193734d;
    }

    public int getTabCount() {
        return this.f193673a.size();
    }

    public int getTabStripLeftPadding() {
        return this.f193675c.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f193675c.getPaddingRight();
    }

    public final void h() {
        if (this.f193698z != null) goto L6;
        ValueAnimator r100 = new ValueAnimator();
        this.f193698z = r100;
        r100.setInterpolator(f193672J);
        this.f193698z.setDuration(200);
        this.f193698z.addUpdateListener(new a(this));
        return;
    }

    public final void k() {
        int r100 = this.f193675c.getChildCount() - 1;
    L4:
        if (r100 < 0) goto L9;
        i r101 = (i) this.f193675c.getChildAt(r100);
        this.f193675c.removeViewAt(r100);
        if (r101 == null) goto L8;
        r101.setTab(null);
        r101.setSelected(false);
        this.H.release(r101);
    L8:
        requestLayout();
        r100 = r100 - 1;
        goto L4
    L9:
        Iterator<h> r102 = this.f193673a.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        h r103 = r102.next();
        r102.remove();
        r103.f193736f = null;
        r103.f193737g = null;
        r103.f193731a = null;
        r103.f193732b = null;
        r103.f193733c = null;
        r103.f193734d = -1;
        r103.f193735e = null;
        K.release(r103);
        goto L11
    L13:
        this.f193674b = null;
        PagerAdapter r104 = this.B;
        if (r104 == null) goto L32;
        int r105 = r104.getCount();
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L18;
        h r107 = j(this.f193693u);
        r107.f193732b = this.B.getPageTitle(r106);
        r107.d();
        b(r107, false);
        r106 = r106 + 1;
        goto L16
    L18:
        ViewPager r108 = this.A;
        if (r108 == null) goto L33;
        if (r105 <= 0) goto L34;
        int r109 = r108.getCurrentItem();
        if (r109 != getSelectedTabPosition()) goto L24;
        return;
    L24:
        if (r109 >= getTabCount()) goto L36;
        l(i(r109), true);
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
        if (this.A != null) goto L8;
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewPager) == false) goto L9;
        o((ViewPager) r100, true);
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
        return this.f193691s;
    }

    public int getTabMaxWidth() {
        return this.f193686n;
    }

    public int getTabMode() {
        return this.f193692t;
    }

    public ColorStateList getTabTextColors() {
        return this.f193682j;
    }

    public DmtTabLayout(Context r100) {
        this(r100, null);
    }

    private void setSelectedTabView(int r100) {
        int r101 = this.f193675c.getChildCount();
        if (r100 >= r101) goto L11;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L15;
        View r103 = this.f193675c.getChildAt(r102);
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
        if ((r100 instanceof DmtTabItem) == false) goto L18;
        DmtTabItem r101 = (DmtTabItem) r100;
        h r102 = j(0);
        CharSequence r103 = r101.f193669a;
        if (r103 == null) goto L7;
        r102.c(r103);
    L7:
        Drawable r104 = r101.f193670b;
        if (r104 == null) goto L10;
        r102.f193731a = r104;
        r102.d();
    L10:
        int r105 = r101.f193671c;
        if (r105 == 0) goto L14;
        r102.b(r105);
    L14:
        if (TextUtils.isEmpty(r101.getContentDescription()) == true) goto L16;
        r102.f193733c = r101.getContentDescription();
        r102.d();
    L16:
        b(r102, this.f193673a.isEmpty());
        return;
    L18:
        if ((r100 instanceof g) == true) goto L20;
        AoLogger.b("DmtTabLayout", new Object[]{r100.getClass().getName()});
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
        n(r100, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        g r101 = this.f193675c;
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
        this.f193698z.setIntValues(new int[]{r105, r106});
        this.f193698z.start();
    L21:
        this.f193675c.a(r100, 200);
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

    public final h i(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r100 >= getTabCount()) goto L7;
        return (h) ListProtector.get(this.f193673a, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final h j(int r100) {
        h r101 = (h) K.acquire();
        if (r101 != null) goto L5;
        r101 = new h();
    L5:
        r101.f193736f = this;
        Pools.SimplePool r102 = this.H;
        if (r102 == null) goto L8;
        i r103 = (i) r102.acquire();
    L9:
        if (r103 != null) goto L11;
        r103 = new i(this, getContext());
    L11:
        r103.setFocusable(true);
        r103.setMinimumWidth(getTabMinWidth());
        r101.f193737g = r103;
        if (r100 > 0) goto L14;
        r103.setTab(r101);
    L18:
        return r101;
    L14:
        if (r101 == r103.f193738a) goto L16;
        r103.f193738a = r101;
    L16:
        r101.b(r100);
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    public final void p(LinearLayout.LayoutParams r100) {
        if (this.f193692t == 1) goto L5;
    L7:
        r100.width = -2;
        r100.weight = 0.0f;
    L8:
        int r101 = this.f193676d;
        if (r101 == 0) goto L12;
        r100.leftMargin = r101;
        r100.rightMargin = r101;
        return;
    L12:
        return;
    L5:
        if (this.f193691s != 0) goto L7;
        r100.width = 0;
        r100.weight = 1.0f;
        goto L8
    }

    public final void q(boolean r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f193675c.getChildCount()) goto L9;
        View r102 = this.f193675c.getChildAt(r101);
        r102.setMinimumWidth(getTabMinWidth());
        p((LinearLayout.LayoutParams) r102.getLayoutParams());
        if (r100 == false) goto L8;
        r102.requestLayout();
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void setAutoFillWhenScrollable(boolean r100) {
        this.f193694v = r100;
    }

    public void setContentInsetStart(int r100) {
        this.f193690r = r100;
    }

    public void setCustomTabViewResId(int r100) {
        this.f193693u = r100;
    }

    public void setOnTabClickListener(d r100) {
        this.G = r100;
    }

    public void setOnTabSelectedListener(e r100) {
        e r101 = this.f193695w;
        if (r101 == null) goto L5;
        this.f193696x.remove(r101);
    L5:
        this.f193695w = r100;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f193696x.contains(r100) == true) goto L12;
        this.f193696x.add(r100);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r100) {
        h();
        this.f193698z.addListener(r100);
    }

    public void setSelectedTabHorizontalPadding(int r100) {
        this.f193675c.f193722m = r100;
    }

    public void setSelectedTabIndicatorColor(int r100) {
        g r101 = this.f193675c;
        if (r101.f193711b.getColor() == r100) goto L6;
        r101.f193711b.setColor(r100);
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r100) {
        g r101 = this.f193675c;
        if (r101.f193710a == r100) goto L6;
        r101.f193710a = r100;
        ViewCompat.postInvalidateOnAnimation(r101);
        return;
    }

    public void setTabBackgroundResId(int r100) {
        this.f193685m = r100;
    }

    public void setTabGravity(int r100) {
        if (this.f193691s == r100) goto L6;
        this.f193691s = r100;
        e();
        return;
    }

    public void setTabMargin(int r100) {
        this.f193676d = g(r100);
        int r101 = 0;
    L4:
        if (r101 >= getTabCount()) goto L6;
        View r102 = this.f193675c.getChildAt(r101);
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r103.leftMargin = g(r100);
        r103.rightMargin = g(r100);
        r102.setLayoutParams(r103);
        r101 = r101 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r100) {
        this.f193688p = r100;
    }

    public void setTabMinWidth(int r100) {
        this.f193687o = r100;
    }

    public void setTabMode(String r100) {
        r100.getClass();
        if (r100.equals("scrollable") == true) goto L11;
        if (r100.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.f193692t == 1) goto L14;
        this.f193692t = 1;
        e();
        return;
    L14:
        return;
    L11:
        if (this.f193692t == 0) goto L16;
        this.f193692t = 0;
        e();
        return;
    }

    public void setTabPaddingBottom(int r100) {
        this.f193680h = r100;
    }

    public void setTabPaddingEnd(int r100) {
        this.f193679g = r100;
    }

    public void setTabPaddingStart(int r100) {
        this.f193677e = r100;
    }

    public void setTabPaddingTop(int r100) {
        this.f193678f = r100;
    }

    public void setTabTextAppearance(int r100) {
        this.f193681i = r100;
    }

    public void setTabTextColors(ColorStateList r100) {
        if (this.f193682j == r100) goto L7;
        this.f193682j = r100;
        int r101 = this.f193673a.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((h) ListProtector.get(this.f193673a, r102)).d();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r100) {
        m(r100, false);
    }

    public void setupWithViewPager(ViewPager r100) {
        o(r100, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateDefaultLayoutParams();
    }

    public void setTabMode(int r100) {
        if (r100 == this.f193692t) goto L6;
        this.f193692t = r100;
        e();
        return;
    }

    public DmtTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101) {
        c(r100);
    }

    public final void b(h r100, boolean r101) {
        int r102 = this.f193673a.size();
        if (r100.f193736f != this) goto L13;
        r100.f193734d = r102;
        ListProtector.add(this.f193673a, r102, r100);
        int r103 = this.f193673a.size();
    L5:
        r102 = r102 + 1;
        if (r102 >= r103) goto L8;
        ((h) ListProtector.get(this.f193673a, r102)).f193734d = r102;
        goto L5
    L8:
        i r104 = r100.f193737g;
        g r105 = this.f193675c;
        int r106 = r100.f193734d;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -1);
        p(r107);
        r105.addView(r104, r106, r107);
        if (r101 == false) goto L15;
        r100.a();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final int f(int r100, float r101) {
        int r102 = 0;
        if (this.f193692t != 0) goto L18;
        View r103 = this.f193675c.getChildAt(r100);
        int r104 = r100 + 1;
        if (r104 >= this.f193675c.getChildCount()) goto L7;
        View r105 = this.f193675c.getChildAt(r104);
    L8:
        if (r103 == null) goto L10;
        int r106 = r103.getWidth();
    L11:
        if (r105 == null) goto L13;
        r102 = r105.getWidth();
    L13:
        int r107 = (r103.getLeft() + (r106 / 2)) - (getWidth() / 2);
        int r108 = (int) ((((r106 + r102) + (this.f193676d * 4)) * 0.5f) * r101);
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

    public final void l(h r100, boolean r101) {
        h r102 = this.f193674b;
        if (r102 != r100) goto L9;
        if (r102 == null) goto L30;
        int r103 = this.f193696x.size() - 1;
    L6:
        if (r103 < 0) goto L8;
        ((e) ListProtector.get(this.f193696x, r103)).V();
        r103 = r103 - 1;
        goto L6
    L8:
        d(r100.f193734d);
        return;
    L30:
        return;
    L9:
        if (r100 == null) goto L11;
        int r104 = r100.f193734d;
    L12:
        if (r101 == false) goto L21;
        if (r102 != null) goto L15;
    L16:
        if (r104 == (-1)) goto L18;
        n(r104, 0.0f, true, true);
    L19:
        if (r104 == (-1)) goto L21;
        setSelectedTabView(r104);
    L18:
        d(r104);
        goto L19
    L15:
        if (r102.f193734d != (-1)) goto L18;
    L21:
        if (r102 == null) goto L25;
        int r105 = this.f193696x.size() - 1;
    L23:
        if (r105 < 0) goto L25;
        ((e) ListProtector.get(this.f193696x, r105)).W();
        r105 = r105 - 1;
    L25:
        this.f193674b = r100;
        if (r100 == null) goto L35;
        int r106 = this.f193696x.size() - 1;
    L28:
        if (r106 < 0) goto L36;
        ((e) ListProtector.get(this.f193696x, r106)).X(r100);
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

    public final void m(PagerAdapter r100, boolean r101) {
        PagerAdapter r102 = this.B;
        if (r102 == null) goto L7;
        f r103 = this.C;
        if (r103 == null) goto L7;
        r102.unregisterDataSetObserver(r103);
    L7:
        this.B = r100;
        if (r101 == false) goto L14;
        if (r100 == null) goto L14;
        if (this.C != null) goto L13;
        this.C = new f(this);
    L13:
        r100.registerDataSetObserver(this.C);
    L14:
        k();
    }

    public final void o(ViewPager r100, boolean r101) {
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
        j r105 = this.f193697y;
        if (r105 == null) goto L14;
        this.f193696x.remove(r105);
        this.f193697y = null;
    L14:
        if (r100 == null) goto L28;
        this.A = r100;
        if (this.D != null) goto L18;
        this.D = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r106 = this.D;
        r106.f193700b = 0;
        r106.f193701c = 0;
        r100.addOnPageChangeListener(r106);
        j r107 = new j(r100);
        this.f193697y = r107;
        if (this.f193696x.contains(r107) == true) goto L21;
        this.f193696x.add(r107);
    L21:
        PagerAdapter r108 = r100.getAdapter();
        if (r108 == null) goto L25;
        m(r108, true);
    L25:
        if (this.E != null) goto L27;
        this.E = new b(this);
    L27:
        b r109 = this.E;
        r109.f193707a = true;
        r100.addOnAdapterChangeListener(r109);
        n(r100.getCurrentItem(), 0.0f, true, true);
    L29:
        this.F = r101;
        return;
    L28:
        this.A = null;
        m(null, false);
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
        int r105 = this.f193688p;
        if (r105 > 0) goto L14;
        r105 = r104 - g(56);
    L14:
        this.f193686n = r105;
    L15:
        super.onMeasure(r100, r101);
        boolean r106 = true;
        if (getChildCount() != 1) goto L32;
        boolean r107 = false;
        View r108 = getChildAt(0);
        int r109 = this.f193692t;
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

    public DmtTabLayout(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f193673a = new ArrayList();
        this.f193686n = Integer.MAX_VALUE;
        this.f193696x = new ArrayList();
        this.H = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        g r101 = new g(this, r100);
        this.f193675c = r101;
        super.addView(r101, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.tabBackground, R.attr.tabContentStart, R.attr.tabGravity, R.attr.tabIconTint, R.attr.tabIconTintMode, R.attr.tabIndicator, R.attr.tabIndicatorAnimationDuration, R.attr.tabIndicatorColor, R.attr.tabIndicatorFullWidth, R.attr.tabIndicatorGravity, R.attr.tabIndicatorHeight, R.attr.tabInlineLabel, R.attr.tabMaxWidth, R.attr.tabMinWidth, R.attr.tabMode, R.attr.tabPadding, R.attr.tabPaddingBottom, R.attr.tabPaddingEnd, R.attr.tabPaddingStart, R.attr.tabPaddingTop, R.attr.tabRippleColor, R.attr.tabSelectedTextColor, R.attr.tabTextAppearance, R.attr.tabTextColor, R.attr.tabUnboundedRipple}, r111, R.style.Widget_Design_TabLayout);
        int r113 = r112.getDimensionPixelSize(10, 0);
        if (r101.f193710a == r113) goto L5;
        r101.f193710a = r113;
        ViewCompat.postInvalidateOnAnimation(r101);
    L5:
        int r114 = r112.getDimensionPixelSize(15, 0);
        this.f193677e = r114;
        this.f193678f = r114;
        this.f193679g = r114;
        this.f193680h = r114;
        this.f193677e = r112.getDimensionPixelSize(18, r114);
        this.f193678f = r112.getDimensionPixelSize(19, this.f193678f);
        this.f193679g = r112.getDimensionPixelSize(17, this.f193679g);
        this.f193680h = r112.getDimensionPixelSize(16, this.f193680h);
        int r115 = r112.getResourceId(22, R.style.TextAppearance_Design_Tab);
        this.f193681i = r115;
        TypedArray r102 = r100.obtainStyledAttributes(r115, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        int r116 = r112.getColor(7, 0);     // Catch: Throwable -> L18
        if (r101.f193711b.getColor() == r116) goto L9;
        r101.f193711b.setColor(r116);     // Catch: Throwable -> L18
        ViewCompat.postInvalidateOnAnimation(r101);     // Catch: Throwable -> L18
    L9:
        this.f193683k = r102.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L18
        this.f193682j = r102.getColorStateList(3);     // Catch: Throwable -> L18
        r102.recycle();
        if (r112.hasValue(23) == false) goto L14;
        this.f193682j = r112.getColorStateList(23);
    L14:
        if (r112.hasValue(21) == false) goto L16;
        this.f193682j = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r112.getColor(21, 0), this.f193682j.getDefaultColor()});
    L16:
        this.f193687o = r112.getDimensionPixelSize(13, -1);
        this.f193688p = r112.getDimensionPixelSize(12, -1);
        this.f193685m = r112.getResourceId(0, 0);
        this.f193690r = r112.getDimensionPixelSize(1, 0);
        this.f193692t = r112.getInt(14, 1);
        this.f193691s = r112.getInt(2, 0);
        r112.recycle();
        Resources r103 = getResources();
        this.f193684l = r103.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.f193689q = r103.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        n0.a(getContext(), 1.5f);
        n0.a(getContext(), 1.5f);
        this.I = getResources().getConfiguration().orientation;
        e();
        return;
    L18:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        c(r100);
    }

    public final void n(int r100, float r101, boolean r102, boolean r103) {
        int r104 = Math.round(r100 + r101);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.f193675c.getChildCount()) goto L25;
        if (r103 == false) goto L14;
        g r105 = this.f193675c;
        ValueAnimator r106 = r105.f193717h;
        if (r106 != null) goto L11;
    L13:
        r105.f193712c = r100;
        r105.f193713d = r101;
        r105.b();
        goto L14
    L11:
        if (r106.isRunning() == false) goto L13;
        r105.f193717h.cancel();
    L14:
        ValueAnimator r107 = this.f193698z;
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
        this.f193698z.cancel();
        goto L19
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, boolean r118) {
        return super.overScrollBy(r110, r111, r112, r113, r114, r115, 80, r117, r118);
    }
}
