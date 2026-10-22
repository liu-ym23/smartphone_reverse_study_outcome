package com.bytedance.awemeopen.apps.framework.base.view.tablayout;

import android.R;
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
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.UserProfileViewPager;
import com.bytedance.awemeopen.apps.framework.profile.AosUserProfileFragment;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@ViewPager.DecorView
public class DmtTabLayout extends HorizontalScrollView {
    public static final FastOutSlowInInterpolator J = null;
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
    public final ArrayList<h> a;
    public h b;
    public final g c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public ColorStateList j;
    public final float k;
    public final float l;
    public int m;
    public int n;
    public int o;
    public int p;
    public final int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public e w;
    public final ArrayList<e> x;
    public j y;
    public ValueAnimator z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public final WeakReference<DmtTabLayout> a;
        public int b;
        public int c;
        public final int d;
        public final int e;
        public final ArgbEvaluator f;
        public final AccelerateInterpolator g;

        public TabLayoutOnPageChangeListener(DmtTabLayout r4) {
            this.f = new ArgbEvaluator();
            this.g = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.a = new WeakReference(r4);
            this.e = r4.getTabTextColors().getColorForState(DmtTabLayout.a(), 0);
            this.d = r4.getTabTextColors().getDefaultColor();
        }

        public final void onPageScrollStateChanged(int r2) {
            this.b = this.c;
            this.c = r2;
        }

        public final void onPageSelected(int r4) {
            DmtTabLayout r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.c;
            if (r1 != 0) goto L11;
        L16:
            boolean r2 = true;
        L17:
            r0.l(r0.i(r4), r2);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r2 = false;
            goto L17
        L13:
            if (this.b != 0) goto L15;
        }

        public final void onPageScrolled(int r11, float r12, int r13) {
            DmtTabLayout r14 = this.a.get();
            if (r14 == null) goto L41;
            int r0 = this.c;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L16:
            boolean r1 = true;
        L17:
            r14.n(r11, r12, r4, r1);
            if (this.c == 2) goto L20;
        L22:
            g r15 = r14.c;
            r15.l = true;
            View r16 = r15.getChildAt(r15.c);
            g r2 = r14.c;
            View r3 = r2.getChildAt(r2.c + 1);
            if (r16 == null) goto L39;
            if (r3 == null) goto L39;
            View r5 = r16.findViewById(2131363070);
            View r6 = r3.findViewById(2131363070);
            if (r5 == null) goto L39;
            if (r6 == null) goto L39;
            float r17 = r16.getLeft() + ((r16.getWidth() - r5.getWidth()) / 2);
            float r7 = r5.getWidth() + r17;
            float r8 = r3.getLeft() + ((r3.getWidth() - r6.getWidth()) / 2);
            float r9 = r6.getWidth() + r8;
            ImageView r10 = (ImageView) r5.findViewById(2131363079);
            TextView r18 = (TextView) r5.findViewById(2131363080);
            ImageView r19 = (ImageView) r6.findViewById(2131363079);
            TextView r20 = (TextView) r6.findViewById(2131363080);
            int r21 = ((Integer) this.f.evaluate(r12, Integer.valueOf(this.e), Integer.valueOf(this.d))).intValue();
            if (r10 == null) goto L33;
            if (r18 == null) goto L33;
            r18.setTextColor(r21);
            r10.setImageAlpha(Color.alpha(r21));
        L33:
            int r22 = ((Integer) this.f.evaluate(r12, Integer.valueOf(this.d), Integer.valueOf(this.e))).intValue();
            if (r19 == null) goto L38;
            if (r20 == null) goto L38;
            r20.setTextColor(r22);
            r19.setImageAlpha(Color.alpha(r22));
        L38:
            r14.c.j = r17 + ((r8 - r17) * this.g.getInterpolation(r12));
            r14.c.k = r7 + ((r9 - r7) * this.g.getInterpolation(r12));
        L39:
            ViewCompat.postInvalidateOnAnimation(r14.c);
            return;
        L20:
            if (this.b != 0) goto L22;
            r14.c.l = false;
            goto L39
        L13:
            if (this.b != 0) goto L16;
            r1 = false;
            goto L17
        L7:
            if (this.b == 1) goto L10;
            r4 = false;
            goto L11
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {
        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageSelected(int r1) {
            throw null;
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
            throw null;
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ DmtTabLayout a;

        public a(DmtTabLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            this.a.scrollTo(((Integer) r3.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {
        public boolean a;
        public final /* synthetic */ DmtTabLayout b;

        public b(DmtTabLayout r1) {
            this.b = r1;
        }

        public final void onAdapterChanged(ViewPager r2, PagerAdapter r3, PagerAdapter r4) {
            DmtTabLayout r5 = this.b;
            if (r5.A != r2) goto L6;
            r5.m(r4, this.a);
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

        void X(h r1);
    }

    public class f extends DataSetObserver {
        public final /* synthetic */ DmtTabLayout a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.a.k();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.a.k();
        }

        public f(DmtTabLayout r1) {
            this.a = r1;
        }
    }

    public class g extends LinearLayout {
        public int a;
        public final Paint b;
        public int c;
        public float d;
        public int e;
        public int f;
        public int g;
        public ValueAnimator h;
        public int i;
        public float j;
        public float k;
        public boolean l;
        public int m;
        public final /* synthetic */ DmtTabLayout n;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ g e;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r6) {
                float r7 = r6.getAnimatedFraction();
                g r0 = this.e;
                int r1 = this.a;
                int r2 = this.b;
                r0.getClass();
                int r3 = r1 + Math.round((r2 - r1) * r7);
                g r4 = this.e;
                int r5 = this.c;
                int r8 = this.d;
                r4.getClass();
                int r9 = r5 + Math.round(r7 * (r8 - r5));
                if (r3 == r0.f) goto L5;
            L6:
                r0.f = r3;
                r0.g = r9;
                ViewCompat.postInvalidateOnAnimation(r0);
                return;
            L5:
                if (r9 != r0.g) goto L6;
            }

            public a(g r1, int r2, int r3, int r4, int r5) {
                this.e = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
            }
        }

        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;
            public final /* synthetic */ g b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                g r3 = this.b;
                r3.c = this.a;
                r3.d = 0.0f;
            }

            public b(g r1, int r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final void b() {
            View r0 = getChildAt(this.c);
            int r1 = -1;
            if (r0 != null) goto L5;
        L12:
            int r2 = -1;
        L14:
            if (r1 == this.f) goto L16;
        L17:
            this.f = r1;
            this.g = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L16:
            if (r2 != this.g) goto L17;
            return;
        L5:
            if (r0.getWidth() <= 0) goto L12;
            int r3 = r0.getLeft();
            r2 = r0.getRight();
            if (this.d > 0.0f) goto L9;
        L11:
            r1 = r3;
            goto L14
        L9:
            if (this.c >= (getChildCount() - 1)) goto L11;
            View r4 = getChildAt(this.c + 1);
            float r5 = this.d * r4.getLeft();
            float r6 = this.d;
            r3 = (int) (r5 + ((1.0f - r6) * r3));
            r2 = (int) ((r6 * r4.getRight()) + ((1.0f - this.d) * r2));
            goto L11
        }

        @Override // android.view.View
        public final void draw(Canvas r9) {
            super.draw(r9);
            int r0 = this.f;
            if (r0 >= 0) goto L5;
            return;
        L5:
            if (this.g <= r0) goto L20;
            View r1 = getChildAt(this.n.getSelectedTabPosition());
            if (r1 == null) goto L17;
            View r2 = r1.findViewById(2131363070);
            if (r2 == null) goto L17;
            if (this.n.A != null) goto L13;
        L14:
            int r3 = this.f;
            float r4 = r3 + (((this.g - r3) - r2.getWidth()) / 2);
            this.j = r4;
            this.k = r4 + r2.getWidth();
        L15:
            r9.drawRect(this.j + this.m, getHeight() - this.a, this.k - this.m, getHeight(), this.b);
            return;
        L13:
            if (this.l == true) goto L15;
        L17:
            r9.drawRect(this.f + this.m, getHeight() - this.a, this.g - this.m, getHeight(), this.b);
            return;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int r3) {
            super.onRtlPropertiesChanged(r3);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.e == r3) goto L9;
            requestLayout();
            this.e = r3;
            return;
        }

        public g(DmtTabLayout r1, Context r2) {
            this.n = r1;
            super(r2);
            this.c = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            r1.g(27);
            this.i = Integer.MAX_VALUE;
            setWillNotDraw(false);
            this.b = new Paint();
        }

        public final void a(int r10, int r11) {
            ValueAnimator r0 = this.h;
            if (r0 == null) goto L8;
            if (r0.isRunning() == false) goto L8;
            this.h.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r1 = true;
        L11:
            View r2 = getChildAt(r10);
            if (r2 != null) goto L15;
            b();
            return;
        L15:
            int r6 = r2.getLeft();
            int r8 = r2.getRight();
            if (Math.abs(r10 - this.c) > 1) goto L18;
            int r5 = this.f;
            int r7 = this.g;
        L26:
            if (r5 != r6) goto L28;
            if (r7 != r8) goto L28;
            return;
        L28:
            ValueAnimator r3 = new ValueAnimator();
            this.h = r3;
            r3.setInterpolator(DmtTabLayout.J);
            r3.setDuration(r11);
            r3.setFloatValues(new float[]{0.0f, 1.0f});
            r3.addUpdateListener(new a(this, r5, r6, r7, r8));
            r3.addListener(new b(this, r10));
            r3.start();
            return;
        L18:
            int r4 = this.n.g(24);
            if (r10 >= this.c) goto L22;
            if (r1 == true) goto L24;
        L23:
            int r9 = r4 + r8;
        L25:
            r5 = r9;
            r7 = r5;
        L24:
            r9 = r6 - r4;
            goto L25
        L22:
            if (r1 == false) goto L24;
        L10:
            r1 = false;
            goto L11
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
            return;
        L5:
            View.MeasureSpec.getMode(r10);
            int r0 = getChildCount();
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r2 >= r0) goto L11;
            View r4 = getChildAt(r2);
            if (r4.getVisibility() != 0) goto L10;
            r3 = Math.max(r3, r4.getMeasuredWidth());
            this.i = Math.min(this.i, r4.getMeasuredWidth());
        L10:
            r2 = r2 + 1;
            goto L6
        L11:
            DmtTabLayout r5 = this.n;
            int r6 = r5.t;
            boolean r7 = true;
            if (r6 == 1) goto L14;
        L31:
            if (r6 == 0) goto L33;
            return;
        L33:
            if (r5.v == true) goto L35;
            return;
        L35:
            if (r5.I == getResources().getConfiguration().orientation) goto L37;
            return;
        L37:
            if (r3 > 0) goto L39;
            return;
        L39:
            int r8 = 0;
            int r9 = 0;
        L41:
            if (r8 >= r0) goto L46;
            View r12 = getChildAt(r8);
            if (r12.getVisibility() == 8) goto L45;
            r9 = r9 + r12.getMeasuredWidth();
        L45:
            r8 = r8 + 1;
            goto L41
        L46:
            if (r9 > 0) goto L48;
            return;
        L48:
            int r13 = (this.n.getMeasuredWidth() - this.n.c.getPaddingLeft()) - this.n.c.getPaddingRight();
            if (r9 < r13) goto L51;
        L67:
            if (r1 == 0) goto L89;
            super.onMeasure(r10, r11);
            return;
        L89:
            return;
        L51:
            if ((r3 * r0) >= r13) goto L60;
            int r14 = 0;
            int r15 = 0;
        L53:
            if (r14 >= r0) goto L66;
            LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) getChildAt(r14).getLayoutParams();
            if (r16.width == 0) goto L57;
        L58:
            r16.width = 0;
            r16.weight = 1.0f;
            r15 = 1;
        L59:
            r14 = r14 + 1;
            goto L53
        L57:
            if (r16.weight == 1.0f) goto L59;
        L66:
            r1 = r15;
            goto L67
        L60:
            int r17 = (r13 - r9) / (r0 * 2);
            r15 = 0;
        L61:
            if (r1 >= r0) goto L66;
            if (getChildAt(r1).getVisibility() == 8) goto L65;
            LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) getChildAt(r1).getLayoutParams();
            r18.leftMargin = r17;
            r18.rightMargin = r17;
            r15 = 1;
        L65:
            r1 = r1 + 1;
            goto L61
        L14:
            if (r5.s != 1) goto L31;
            if (r3 > 0) goto L17;
            return;
        L17:
            int r19 = r5.g(16);
            if ((r3 * r0) > (getMeasuredWidth() - (r19 * 2))) goto L28;
            boolean r20 = false;
        L20:
            if (r1 >= r0) goto L27;
            LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) getChildAt(r1).getLayoutParams();
            if (r21.width == r3) goto L24;
        L25:
            r21.width = r3;
            r21.weight = 0.0f;
            r20 = true;
        L26:
            r1 = r1 + 1;
            goto L20
        L24:
            if (r21.weight == 0.0f) goto L26;
        L27:
            r7 = r20;
        L29:
            if (r7 == false) goto L85;
            super.onMeasure(r10, r11);
            return;
        L85:
            return;
        L28:
            DmtTabLayout r22 = this.n;
            r22.s = 0;
            r22.q(false);
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.h;
            if (r6 != null) goto L5;
        L7:
            b();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            this.h.cancel();
            a(this.c, Math.round((1.0f - this.h.getAnimatedFraction()) * this.h.getDuration()));
        }
    }

    public static final class h {
        public Drawable a;
        public CharSequence b;
        public CharSequence c;
        public int d;
        public View e;
        public DmtTabLayout f;
        public i g;

        public final void a() {
            DmtTabLayout r0 = this.f;
            if (r0 == null) goto L7;
            r0.l(this, true);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final void d() {
            i r0 = this.g;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        public h() {
            this.d = -1;
        }

        public final void b(int r5) {
            DmtTabLayout r0 = this.g.h;
            FastOutSlowInInterpolator r1 = DmtTabLayout.J;
            r0.getClass();
            int r2 = com.bytedance.awemeopen.apps.framework.base.view.tablayout.a.a;
            Context r3 = this.g.getContext();
            i r4 = this.g;
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "root");
            int r6 = com.bytedance.awemeopen.apps.framework.base.view.tablayout.a.a;
            Intrinsics.checkNotNullParameter(r3, "context");
            this.e = LayoutInflater.from(r3).inflate(r5, r4, false);
            d();
        }

        public final void c(CharSequence r1) {
            this.b = r1;
            d();
        }
    }

    public class i extends LinearLayout {
        public h a;
        public TextView b;
        public ImageView c;
        public View d;
        public TextView e;
        public ImageView f;
        public int g;
        public final /* synthetic */ DmtTabLayout h;

        public final void update() {
            h r0 = this.a;
            if (r0 == null) goto L5;
            View r2 = r0.e;
        L6:
            if (r2 == null) goto L22;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) r3).removeView(r2);
        L11:
            addView(r2);
        L12:
            this.d = r2;
            TextView r4 = this.b;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.c;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.c.setImageDrawable(null);
        L18:
            TextView r1 = (TextView) r2.findViewById(R.id.text1);
            this.e = r1;
            if (r1 == null) goto L21;
            this.g = TextViewCompat.getMaxLines(r1);
        L21:
            this.f = (ImageView) r2.findViewById(R.id.icon);
        L26:
            boolean r6 = false;
            if (this.d == null) goto L29;
            TextView r7 = this.e;
            if (r7 == null) goto L41;
        L42:
            a(r7, this.f);
        L43:
            if (r0 == null) goto L54;
            DmtTabLayout r8 = r0.f;
            if (r8 == null) goto L53;
            if (r8.getSelectedTabPosition() != r0.d) goto L49;
            boolean r9 = true;
        L50:
            if (r9 == false) goto L54;
            r6 = true;
            goto L54
        L49:
            r9 = false;
            goto L50
        L53:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L54:
            setSelected(r6);
            return;
        L41:
            if (this.f == null) goto L43;
        L29:
            if (this.c != null) goto L32;
            ImageView r10 = (ImageView) LayoutInflater.from(getContext()).inflate(2131560004, this, false);
            addView(r10, 0);
            this.c = r10;
        L32:
            if (this.b != null) goto L34;
            TextView r11 = (TextView) LayoutInflater.from(getContext()).inflate(2131560005, this, false);
            addView(r11);
            this.b = r11;
            this.g = TextViewCompat.getMaxLines(r11);
        L34:
            TextViewCompat.setTextAppearance(this.b, this.h.i);
            ColorStateList r12 = this.h.j;
            if (r12 == null) goto L37;
            this.b.setTextColor(r12);
        L37:
            a(this.b, this.c);
            goto L43
        L22:
            View r13 = this.d;
            if (r13 == null) goto L25;
            removeView(r13);
            DmtTabLayout r14 = this.h;
            FastOutSlowInInterpolator r15 = DmtTabLayout.J;
            r14.getClass();
            this.d = null;
        L25:
            this.e = null;
            this.f = null;
            goto L26
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r0 = super.performClick();
            if (this.a == null) goto L14;
            if (r0 == true) goto L6;
            playSoundEffect(0);
        L6:
            d r1 = this.h.G;
            if (r1 == null) goto L12;
            h r2 = this.a;
            AosUserProfileFragment r3 = ((com.bytedance.awemeopen.apps.framework.profile.j) r1).a;
            int r4 = AosUserProfileFragment.D;
            Intrinsics.checkNotNullParameter(r3, "this$0");
            UserProfileViewPager r5 = r3.m;
            if (r5 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            r5 = null;
        L11:
            r5.y(r2.d, true);
        L13:
            return true;
        L12:
            this.a.a();
            goto L13
        L14:
            return r0;
        }

        public h getTab() {
            return this.a;
        }

        public TextView getTextView() {
            return this.b;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r2);
            r2.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
            super.onInitializeAccessibilityNodeInfo(r2);
            r2.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void setSelected(boolean r2) {
            if (isSelected() != r2) goto L6;
        L6:
            super.setSelected(r2);
            TextView r0 = this.b;
            if (r0 == null) goto L9;
            r0.setSelected(r2);
        L9:
            ImageView r1 = this.c;
            if (r1 == null) goto L12;
            r1.setSelected(r2);
        L12:
            View r3 = this.d;
            if (r3 == null) goto L16;
            r3.setSelected(r2);
            return;
        }

        public void setTab(h r2) {
            if (r2 == this.a) goto L6;
            this.a = r2;
            update();
            return;
        }

        public i(DmtTabLayout r3, Context r4) {
            this.h = r3;
            super(r4);
            this.g = 2;
            int r0 = r3.m;
            if (r0 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r4, r0));
        L5:
            ViewCompat.setPaddingRelative(this, r3.e, r3.f, r3.g, r3.h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final void a(TextView r7, ImageView r8) {
            h r0 = this.a;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            Drawable r2 = r0.a;
        L6:
            if (r0 == null) goto L8;
            CharSequence r3 = r0.b;
        L9:
            if (r0 == null) goto L11;
            CharSequence r4 = r0.c;
        L12:
            int r5 = 0;
            if (r8 == null) goto L18;
            if (r2 == null) goto L16;
            r8.setImageDrawable(r2);
            r8.setVisibility(0);
            setVisibility(0);
        L17:
            r8.setContentDescription(r4);
            goto L18
        L16:
            r8.setVisibility(8);
            r8.setImageDrawable(null);
        L18:
            boolean r6 = !TextUtils.isEmpty(r3);
            if (r7 == null) goto L24;
            if (r6 == false) goto L22;
            r7.setText(r3);
            r7.setVisibility(0);
            setVisibility(0);
        L23:
            r7.setContentDescription(r4);
            goto L24
        L22:
            r7.setVisibility(8);
            r7.setText(null);
        L24:
            if (r8 == null) goto L33;
            ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
            if (r6 == false) goto L31;
            if (r8.getVisibility() != 0) goto L31;
            r5 = this.h.g(8);
        L31:
            if (r5 == r9.bottomMargin) goto L33;
            r9.bottomMargin = r5;
            r8.requestLayout();
        L33:
            if (r6 == true) goto L36;
            r1 = r4;
        L36:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L11:
            r4 = null;
            goto L12
        L8:
            r3 = null;
            goto L9
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r8, int r9) {
            int r0 = View.MeasureSpec.getSize(r8);
            int r1 = View.MeasureSpec.getMode(r8);
            int r2 = this.h.getTabMaxWidth();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r8 = View.MeasureSpec.makeMeasureSpec(this.h.n, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r8, r9);
            if (this.b == null) goto L35;
            getResources();
            float r3 = this.h.k;
            int r4 = this.g;
            ImageView r5 = this.c;
            boolean r6 = true;
            if (r5 != null) goto L12;
        L14:
            TextView r7 = this.b;
            if (r7 != null) goto L17;
        L19:
            float r10 = this.b.getTextSize();
            int r11 = this.b.getLineCount();
            int r12 = TextViewCompat.getMaxLines(this.b);
            if (r3 != r10) goto L24;
            if (r12 < 0) goto L36;
            if (r4 != r12) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.h.t != 1) goto L32;
            if (r3 <= r10) goto L32;
            if (r11 != 1) goto L32;
            Layout r13 = this.b.getLayout();
            if (r13 != null) goto L30;
        L31:
            r6 = false;
            goto L32
        L30:
            if ((r13.getLineWidth(0) * (r3 / r13.getPaint().getTextSize())) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r6 == false) goto L38;
            this.b.setTextSize(0, r3);
            this.b.setMaxLines(r4);
            super.onMeasure(r8, r9);
            return;
        L38:
            return;
        L17:
            if (r7.getLineCount() <= 1) goto L19;
            r3 = this.h.l;
            goto L19
        L12:
            if (r5.getVisibility() != 0) goto L14;
            r4 = 1;
            goto L19
        }
    }

    public static class j implements e {
        public final ViewPager a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout.e
        public final void V() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout.e
        public final void W() {
        }

        public j(ViewPager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout.e
        public final void X(h r2) {
            this.a.setCurrentItem(r2.d);
        }
    }

    public void setCustomViewInflate(c r1) {
    }

    static {
        J = new FastOutSlowInInterpolator();
        K = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        int r0 = this.a.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        h r3 = (h) ListProtector.get(this.a, r2);
        if (r3 == null) goto L11;
        if (r3.a == null) goto L11;
        if (TextUtils.isEmpty(r3.b) == true) goto L11;
        r1 = true;
    L11:
        r2 = r2 + 1;
    L12:
        if (r1 == false) goto L14;
        return 72;
    L14:
        return 48;
    }

    private float getScrollPosition() {
        g r0 = this.c;
        return r0.c + r0.d;
    }

    private int getTabMinWidth() {
        int r0 = this.o;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (this.t == 0) goto L10;
        return 0;
    L10:
        return this.q;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public final void e() {
        if (this.t != 0) goto L5;
        int r0 = Math.max(0, this.r - this.e);
    L6:
        ViewCompat.setPaddingRelative(this.c, r0, 0, 0, 0);
        int r1 = this.t;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L12;
        this.c.setGravity(1);
    L12:
        q(true);
        return;
    L11:
        this.c.setGravity(8388611);
        goto L12
    L5:
        r0 = 0;
        goto L6
    }

    public int getSelectedTabPosition() {
        h r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.d;
    }

    public int getTabCount() {
        return this.a.size();
    }

    public int getTabStripLeftPadding() {
        return this.c.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.c.getPaddingRight();
    }

    public final void h() {
        if (this.z != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.z = r0;
        r0.setInterpolator(J);
        this.z.setDuration(200);
        this.z.addUpdateListener(new a(this));
        return;
    }

    public final void k() {
        int r0 = this.c.getChildCount() - 1;
    L4:
        if (r0 < 0) goto L9;
        i r4 = (i) this.c.getChildAt(r0);
        this.c.removeViewAt(r0);
        if (r4 == null) goto L8;
        r4.setTab(null);
        r4.setSelected(false);
        this.H.release(r4);
    L8:
        requestLayout();
        r0 = r0 - 1;
        goto L4
    L9:
        Iterator<h> r1 = this.a.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        h r5 = r1.next();
        r1.remove();
        r5.f = null;
        r5.g = null;
        r5.a = null;
        r5.b = null;
        r5.c = null;
        r5.d = -1;
        r5.e = null;
        K.release(r5);
        goto L11
    L13:
        this.b = null;
        PagerAdapter r2 = this.B;
        if (r2 == null) goto L32;
        int r3 = r2.getCount();
        int r6 = 0;
    L16:
        if (r6 >= r3) goto L18;
        h r7 = j(this.u);
        r7.b = this.B.getPageTitle(r6);
        r7.d();
        b(r7, false);
        r6 = r6 + 1;
        goto L16
    L18:
        ViewPager r8 = this.A;
        if (r8 == null) goto L33;
        if (r3 <= 0) goto L34;
        int r9 = r8.getCurrentItem();
        if (r9 != getSelectedTabPosition()) goto L24;
        return;
    L24:
        if (r9 >= getTabCount()) goto L36;
        l(i(r9), true);
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
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L9;
        o((ViewPager) r0, true);
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
        return this.s;
    }

    public int getTabMaxWidth() {
        return this.n;
    }

    public int getTabMode() {
        return this.t;
    }

    public ColorStateList getTabTextColors() {
        return this.j;
    }

    public DmtTabLayout(Context r2) {
        this(r2, null);
    }

    private void setSelectedTabView(int r6) {
        int r0 = this.c.getChildCount();
        if (r6 >= r0) goto L11;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L15;
        View r3 = this.c.getChildAt(r2);
        if (r2 != r6) goto L9;
        boolean r4 = true;
    L10:
        r3.setSelected(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r4 = false;
        goto L10
    L15:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r1) {
        c(r1);
    }

    public final void c(View r5) {
        if ((r5 instanceof DmtTabItem) == false) goto L18;
        DmtTabItem r6 = (DmtTabItem) r5;
        h r0 = j(0);
        CharSequence r1 = r6.a;
        if (r1 == null) goto L7;
        r0.c(r1);
    L7:
        Drawable r2 = r6.b;
        if (r2 == null) goto L10;
        r0.a = r2;
        r0.d();
    L10:
        int r3 = r6.c;
        if (r3 == 0) goto L14;
        r0.b(r3);
    L14:
        if (TextUtils.isEmpty(r6.getContentDescription()) == true) goto L16;
        r0.c = r6.getContentDescription();
        r0.d();
    L16:
        b(r0, this.a.isEmpty());
        return;
    L18:
        if ((r5 instanceof g) == true) goto L20;
        AoLogger.b("DmtTabLayout", new Object[]{r5.getClass().getName()});
        return;
    L20:
        if (indexOfChild(r5) != (-1)) goto L25;
        super.addView(r5, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    }

    public final void d(int r8) {
        if (r8 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L23:
        n(r8, 0.0f, true, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        g r0 = this.c;
        int r3 = r0.getChildCount();
        int r5 = 0;
    L10:
        if (r5 >= r3) goto L15;
        if (r0.getChildAt(r5).getWidth() <= 0) goto L13;
        r5 = r5 + 1;
        goto L10
    L13:
        boolean r1 = true;
    L16:
        if (r1 == true) goto L23;
        int r2 = getScrollX();
        int r4 = f(r8, 0.0f);
        if (r2 == r4) goto L21;
        h();
        this.z.setIntValues(new int[]{r2, r4});
        this.z.start();
    L21:
        this.c.a(r8, 200);
        return;
    L15:
        r1 = false;
        goto L16
    }

    public final int g(int r3) {
        Resources r0 = getResources();
        return Math.round(WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public final h i(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return (h) ListProtector.get(this.a, r2);
    }

    public final h j(int r4) {
        h r0 = (h) K.acquire();
        if (r0 != null) goto L5;
        r0 = new h();
    L5:
        r0.f = this;
        Pools.SimplePool r1 = this.H;
        if (r1 == null) goto L8;
        i r2 = (i) r1.acquire();
    L9:
        if (r2 != null) goto L11;
        r2 = new i(this, getContext());
    L11:
        r2.setFocusable(true);
        r2.setMinimumWidth(getTabMinWidth());
        r0.g = r2;
        if (r4 > 0) goto L14;
        r2.setTab(r0);
    L18:
        return r0;
    L14:
        if (r0 == r2.a) goto L16;
        r2.a = r0;
    L16:
        r0.b(r4);
        goto L18
    L8:
        r2 = null;
        goto L9
    }

    public final void p(LinearLayout.LayoutParams r3) {
        if (this.t == 1) goto L5;
    L7:
        r3.width = -2;
        r3.weight = 0.0f;
    L8:
        int r0 = this.d;
        if (r0 == 0) goto L12;
        r3.leftMargin = r0;
        r3.rightMargin = r0;
        return;
    L12:
        return;
    L5:
        if (this.s != 0) goto L7;
        r3.width = 0;
        r3.weight = 1.0f;
        goto L8
    }

    public final void q(boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.c.getChildCount()) goto L9;
        View r1 = this.c.getChildAt(r0);
        r1.setMinimumWidth(getTabMinWidth());
        p((LinearLayout.LayoutParams) r1.getLayoutParams());
        if (r4 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public void setAutoFillWhenScrollable(boolean r1) {
        this.v = r1;
    }

    public void setContentInsetStart(int r1) {
        this.r = r1;
    }

    public void setCustomTabViewResId(int r1) {
        this.u = r1;
    }

    public void setOnTabClickListener(d r1) {
        this.G = r1;
    }

    public void setOnTabSelectedListener(e r3) {
        e r0 = this.w;
        if (r0 == null) goto L5;
        this.x.remove(r0);
    L5:
        this.w = r3;
        if (r3 != null) goto L8;
        return;
    L8:
        if (this.x.contains(r3) == true) goto L12;
        this.x.add(r3);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r2) {
        h();
        this.z.addListener(r2);
    }

    public void setSelectedTabHorizontalPadding(int r2) {
        this.c.m = r2;
    }

    public void setSelectedTabIndicatorColor(int r3) {
        g r0 = this.c;
        if (r0.b.getColor() == r3) goto L6;
        r0.b.setColor(r3);
        ViewCompat.postInvalidateOnAnimation(r0);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r3) {
        g r0 = this.c;
        if (r0.a == r3) goto L6;
        r0.a = r3;
        ViewCompat.postInvalidateOnAnimation(r0);
        return;
    }

    public void setTabBackgroundResId(int r1) {
        this.m = r1;
    }

    public void setTabGravity(int r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        e();
        return;
    }

    public void setTabMargin(int r5) {
        this.d = g(r5);
        int r0 = 0;
    L4:
        if (r0 >= getTabCount()) goto L6;
        View r1 = this.c.getChildAt(r0);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        r2.leftMargin = g(r5);
        r2.rightMargin = g(r5);
        r1.setLayoutParams(r2);
        r0 = r0 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r1) {
        this.p = r1;
    }

    public void setTabMinWidth(int r1) {
        this.o = r1;
    }

    public void setTabMode(String r2) {
        r2.getClass();
        if (r2.equals("scrollable") == true) goto L11;
        if (r2.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.t == 1) goto L14;
        this.t = 1;
        e();
        return;
    L14:
        return;
    L11:
        if (this.t == 0) goto L16;
        this.t = 0;
        e();
        return;
    }

    public void setTabPaddingBottom(int r1) {
        this.h = r1;
    }

    public void setTabPaddingEnd(int r1) {
        this.g = r1;
    }

    public void setTabPaddingStart(int r1) {
        this.e = r1;
    }

    public void setTabPaddingTop(int r1) {
        this.f = r1;
    }

    public void setTabTextAppearance(int r1) {
        this.i = r1;
    }

    public void setTabTextColors(ColorStateList r3) {
        if (this.j == r3) goto L7;
        this.j = r3;
        int r4 = this.a.size();
        int r0 = 0;
    L5:
        if (r0 >= r4) goto L9;
        ((h) ListProtector.get(this.a, r0)).d();
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r2) {
        m(r2, false);
    }

    public void setupWithViewPager(ViewPager r2) {
        o(r2, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    public void setTabMode(int r2) {
        if (r2 == this.t) goto L6;
        this.t = r2;
        e();
        return;
    }

    public DmtTabLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r1, int r2) {
        c(r1);
    }

    public final void b(h r7, boolean r8) {
        int r0 = this.a.size();
        if (r7.f != this) goto L13;
        r7.d = r0;
        ListProtector.add(this.a, r0, r7);
        int r1 = this.a.size();
    L5:
        r0 = r0 + 1;
        if (r0 >= r1) goto L8;
        ((h) ListProtector.get(this.a, r0)).d = r0;
        goto L5
    L8:
        i r2 = r7.g;
        g r3 = this.c;
        int r4 = r7.d;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -1);
        p(r5);
        r3.addView(r2, r4, r5);
        if (r8 == false) goto L15;
        r7.a();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final int f(int r4, float r5) {
        int r1 = 0;
        if (this.t != 0) goto L18;
        View r0 = this.c.getChildAt(r4);
        int r6 = r4 + 1;
        if (r6 >= this.c.getChildCount()) goto L7;
        View r7 = this.c.getChildAt(r6);
    L8:
        if (r0 == null) goto L10;
        int r2 = r0.getWidth();
    L11:
        if (r7 == null) goto L13;
        r1 = r7.getWidth();
    L13:
        int r8 = (r0.getLeft() + (r2 / 2)) - (getWidth() / 2);
        int r9 = (int) ((((r2 + r1) + (this.d * 4)) * 0.5f) * r5);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L17;
        return r8 + r9;
    L17:
        return r8 - r9;
    L10:
        r2 = 0;
        goto L11
    L7:
        r7 = null;
        goto L8
    L18:
        return 0;
    }

    public final void l(h r5, boolean r6) {
        h r0 = this.b;
        if (r0 != r5) goto L9;
        if (r0 == null) goto L30;
        int r7 = this.x.size() - 1;
    L6:
        if (r7 < 0) goto L8;
        ((e) ListProtector.get(this.x, r7)).V();
        r7 = r7 - 1;
        goto L6
    L8:
        d(r5.d);
        return;
    L30:
        return;
    L9:
        if (r5 == null) goto L11;
        int r2 = r5.d;
    L12:
        if (r6 == false) goto L21;
        if (r0 != null) goto L15;
    L16:
        if (r2 == (-1)) goto L18;
        n(r2, 0.0f, true, true);
    L19:
        if (r2 == (-1)) goto L21;
        setSelectedTabView(r2);
    L18:
        d(r2);
        goto L19
    L15:
        if (r0.d != (-1)) goto L18;
    L21:
        if (r0 == null) goto L25;
        int r8 = this.x.size() - 1;
    L23:
        if (r8 < 0) goto L25;
        ((e) ListProtector.get(this.x, r8)).W();
        r8 = r8 - 1;
    L25:
        this.b = r5;
        if (r5 == null) goto L35;
        int r9 = this.x.size() - 1;
    L28:
        if (r9 < 0) goto L36;
        ((e) ListProtector.get(this.x, r9)).X(r5);
        r9 = r9 - 1;
        goto L28
    L36:
        return;
    L35:
        return;
    L11:
        r2 = -1;
        goto L12
    }

    public final void m(PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.B;
        if (r0 == null) goto L7;
        f r1 = this.C;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.B = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.C != null) goto L13;
        this.C = new f(this);
    L13:
        r3.registerDataSetObserver(this.C);
    L14:
        k();
    }

    public final void o(ViewPager r4, boolean r5) {
        ViewPager r0 = this.A;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.D;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        b r2 = this.E;
        if (r2 == null) goto L10;
        this.A.removeOnAdapterChangeListener(r2);
    L10:
        j r3 = this.y;
        if (r3 == null) goto L14;
        this.x.remove(r3);
        this.y = null;
    L14:
        if (r4 == null) goto L28;
        this.A = r4;
        if (this.D != null) goto L18;
        this.D = new TabLayoutOnPageChangeListener(this);
    L18:
        TabLayoutOnPageChangeListener r6 = this.D;
        r6.b = 0;
        r6.c = 0;
        r4.addOnPageChangeListener(r6);
        j r7 = new j(r4);
        this.y = r7;
        if (this.x.contains(r7) == true) goto L21;
        this.x.add(r7);
    L21:
        PagerAdapter r8 = r4.getAdapter();
        if (r8 == null) goto L25;
        m(r8, true);
    L25:
        if (this.E != null) goto L27;
        this.E = new b(this);
    L27:
        b r9 = this.E;
        r9.a = true;
        r4.addOnAdapterChangeListener(r9);
        n(r4.getCurrentItem(), 0.0f, true, true);
    L29:
        this.F = r5;
        return;
    L28:
        this.A = null;
        m(null, false);
        goto L29
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = (g(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 0) goto L8;
        r7 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L8:
        int r2 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L15;
        int r3 = this.p;
        if (r3 > 0) goto L14;
        r3 = r2 - g(56);
    L14:
        this.n = r3;
    L15:
        super.onMeasure(r6, r7);
        boolean r4 = true;
        if (getChildCount() != 1) goto L32;
        boolean r8 = false;
        View r5 = getChildAt(0);
        int r9 = this.t;
        if (r9 == 0) goto L25;
        if (r9 == 1) goto L22;
    L29:
        if (r8 == false) goto L33;
        int r10 = HorizontalScrollView.getChildMeasureSpec(r7, getPaddingTop() + getPaddingBottom(), r5.getLayoutParams().height);
        r5.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r10);
        return;
    L33:
        return;
    L22:
        if (r5.getMeasuredWidth() != getMeasuredWidth()) goto L28;
    L27:
        r4 = false;
    L28:
        r8 = r4;
        goto L29
    L25:
        if (r5.getMeasuredWidth() >= getMeasuredWidth()) goto L27;
    L32:
        return;
    L7:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.min(r0, View.MeasureSpec.getSize(r7)), 1073741824);
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r1, ViewGroup.LayoutParams r2) {
        c(r1);
    }

    public DmtTabLayout(Context r9, AttributeSet r10, int r11) {
        super(r9, r10, r11);
        this.a = new ArrayList();
        this.n = Integer.MAX_VALUE;
        this.x = new ArrayList();
        this.H = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        g r2 = new g(this, r9);
        this.c = r2;
        super.addView(r2, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r12 = r9.obtainStyledAttributes(r10, new int[]{2130974357, 2130974358, 2130974359, 2130974360, 2130974361, 2130974362, 2130974363, 2130974364, 2130974365, 2130974366, 2130974367, 2130974370, 2130974371, 2130974372, 2130974373, 2130974375, 2130974376, 2130974377, 2130974378, 2130974379, 2130974380, 2130974381, 2130974383, 2130974384, 2130974385}, r11, 2131954019);
        int r13 = r12.getDimensionPixelSize(10, 0);
        if (r2.a == r13) goto L5;
        r2.a = r13;
        ViewCompat.postInvalidateOnAnimation(r2);
    L5:
        int r14 = r12.getDimensionPixelSize(15, 0);
        this.e = r14;
        this.f = r14;
        this.g = r14;
        this.h = r14;
        this.e = r12.getDimensionPixelSize(18, r14);
        this.f = r12.getDimensionPixelSize(19, this.f);
        this.g = r12.getDimensionPixelSize(17, this.g);
        this.h = r12.getDimensionPixelSize(16, this.h);
        int r15 = r12.getResourceId(22, 2131953595);
        this.i = r15;
        TypedArray r16 = r9.obtainStyledAttributes(r15, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, 2130970118, 2130970129, 2130974497, 2130974532});
        int r17 = r12.getColor(7, 0);     // Catch: Throwable -> L18
        if (r2.b.getColor() == r17) goto L9;
        r2.b.setColor(r17);     // Catch: Throwable -> L18
        ViewCompat.postInvalidateOnAnimation(r2);     // Catch: Throwable -> L18
    L9:
        this.k = r16.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L18
        this.j = r16.getColorStateList(3);     // Catch: Throwable -> L18
        r16.recycle();
        if (r12.hasValue(23) == false) goto L14;
        this.j = r12.getColorStateList(23);
    L14:
        if (r12.hasValue(21) == false) goto L16;
        this.j = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r12.getColor(21, 0), this.j.getDefaultColor()});
    L16:
        this.o = r12.getDimensionPixelSize(13, -1);
        this.p = r12.getDimensionPixelSize(12, -1);
        this.m = r12.getResourceId(0, 0);
        this.r = r12.getDimensionPixelSize(1, 0);
        this.t = r12.getInt(14, 1);
        this.s = r12.getInt(2, 0);
        r12.recycle();
        Resources r18 = getResources();
        this.l = r18.getDimensionPixelSize(2131165822);
        this.q = r18.getDimensionPixelSize(2131165820);
        n0.a(getContext(), 1.5f);
        n0.a(getContext(), 1.5f);
        this.I = getResources().getConfiguration().orientation;
        e();
        return;
    L18:
        th = move-exception;
        r16.recycle();
        throw th;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        c(r1);
    }

    public final void n(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.c.getChildCount()) goto L25;
        if (r6 == false) goto L14;
        g r7 = this.c;
        ValueAnimator r1 = r7.h;
        if (r1 != null) goto L11;
    L13:
        r7.c = r3;
        r7.d = r4;
        r7.b();
        goto L14
    L11:
        if (r1.isRunning() == false) goto L13;
        r7.h.cancel();
    L14:
        ValueAnimator r8 = this.z;
        if (r8 != null) goto L17;
    L19:
        scrollTo(f(r3, r4), 0);
        if (r5 == false) goto L24;
        setSelectedTabView(r0);
        return;
    L24:
        return;
    L17:
        if (r8.isRunning() == false) goto L19;
        this.z.cancel();
        goto L19
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, boolean r19) {
        return super.overScrollBy(r11, r12, r13, r14, r15, r16, 80, r18, r19);
    }
}
