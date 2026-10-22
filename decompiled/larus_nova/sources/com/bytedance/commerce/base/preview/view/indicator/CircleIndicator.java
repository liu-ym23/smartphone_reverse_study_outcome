package com.bytedance.commerce.base.preview.view.indicator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes15.dex */
public class CircleIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f202853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f202854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GradientDrawable f202855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f202856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f202857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f202858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animator f202859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f202860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f202861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f202862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f202863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f202864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f202865m;

    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleIndicator f202866a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public a(CircleIndicator r100) {
            this.f202866a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            if (this.f202866a.f202854b.getAdapter() == null) goto L23;
            CircleIndicator r101 = this.f202866a;
            int r102 = r101.f202853a;
            if (r102 <= 0) goto L24;
            int r103 = r100 % r102;
            if (r101.f202857e.isRunning() == false) goto L11;
            this.f202866a.f202857e.end();
            this.f202866a.f202857e.cancel();
        L11:
            if (this.f202866a.f202856d.isRunning() == false) goto L13;
            this.f202866a.f202856d.end();
            this.f202866a.f202856d.cancel();
        L13:
            CircleIndicator r104 = this.f202866a;
            int r105 = r104.f202863k;
            if (r105 < 0) goto L18;
            View r106 = r104.getChildAt(r105);
            if (r106 == null) goto L18;
            r106.setBackgroundDrawable(this.f202866a.f202855c);
            this.f202866a.f202857e.setTarget(r106);
            this.f202866a.f202857e.start();
        L18:
            View r107 = this.f202866a.getChildAt(r103);
            if (r107 == null) goto L21;
            r107.setBackgroundDrawable(this.f202866a.f202855c);
            this.f202866a.f202856d.setTarget(r107);
            this.f202866a.f202856d.start();
        L21:
            this.f202866a.f202863k = r103;
            return;
        L24:
            return;
        }
    }

    public class b extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleIndicator f202867a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            super.onChanged();
            CircleIndicator r100 = this.f202867a;
            if (r100.f202854b != null) goto L5;
            return;
        L5:
            int r101 = r100.f202853a;
            if (r101 != r100.getChildCount()) goto L8;
            return;
        L8:
            CircleIndicator r102 = this.f202867a;
            if (r102.f202863k >= r101) goto L11;
            r102.f202863k = r102.f202854b.getCurrentItem();
        L12:
            this.f202867a.c();
            return;
        L11:
            r102.f202863k = -1;
            goto L12
        }

        public b(CircleIndicator r100) {
            this.f202867a = r100;
        }
    }

    public class c implements Interpolator {
        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return Math.abs(1.0f - r100);
        }
    }

    public static Animator b() {
        ObjectAnimator r100 = ObjectAnimator.ofFloat(null, "alpha", new float[]{0.5f, 1.0f});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(null, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.8f});
        ObjectAnimator r102 = ObjectAnimator.ofFloat(null, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.8f});
        AnimatorSet r103 = new AnimatorSet();
        r103.play(r100).with(r101).with(r102);
        return r103;
    }

    public final void c() {
        removeAllViews();
        int r100 = this.f202853a;
        if (r100 > 0) goto L5;
        return;
    L5:
        int r101 = this.f202854b.getCurrentItem();
        int r102 = getOrientation();
        int r103 = 0;
    L6:
        if (r103 >= r100) goto L11;
        if (r101 != r103) goto L9;
        a(r102, this.f202858f);
    L10:
        r103 = r103 + 1;
        goto L6
    L9:
        a(r102, this.f202859g);
        goto L10
    }

    public final int d() {
        Resources r100 = getResources();
        return (int) ((5.0f * WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density) + 0.5f);
    }

    public DataSetObserver getDataSetObserver() {
        return this.f202865m;
    }

    public CircleIndicator(Context r100) {
        this(r100, null);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        ViewPager r101 = this.f202854b;
        if (r101 == null) goto L7;
        r101.removeOnPageChangeListener(r100);
        this.f202854b.addOnPageChangeListener(r100);
        return;
    L7:
        throw new NullPointerException("can not find Viewpager , setViewPager first");
    }

    public void setRealCount(int r100) {
        this.f202853a = r100;
    }

    public void setViewPager(ViewPager r100) {
        this.f202854b = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getAdapter() == null) goto L9;
        this.f202863k = -1;
        c();
        this.f202854b.removeOnPageChangeListener(this.f202864l);
        this.f202854b.addOnPageChangeListener(this.f202864l);
        this.f202864l.onPageSelected(this.f202854b.getCurrentItem());
        return;
    }

    public CircleIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, Animator r101) {
        if (r101.isRunning() == false) goto L5;
        r101.end();
        r101.cancel();
    L5:
        View r102 = new View(getContext());
        r102.setBackgroundDrawable(this.f202855c);
        addView(r102, this.f202861i, this.f202862j);
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102.getLayoutParams();
        if (r100 != 0) goto L8;
        int r104 = this.f202860h;
        r103.leftMargin = r104;
        r103.rightMargin = r104;
    L9:
        r102.setLayoutParams(r103);
        r101.setTarget(r102);
        r101.start();
        return;
    L8:
        int r105 = this.f202860h;
        r103.topMargin = r105;
        r103.bottomMargin = r105;
        goto L9
    }

    public CircleIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f202860h = -1;
        this.f202861i = -1;
        this.f202862j = -1;
        this.f202863k = -1;
        this.f202864l = new a(this);
        this.f202865m = new b(this);
        GradientDrawable r103 = new GradientDrawable();
        this.f202855c = r103;
        int r104 = 1;
        r103.setShape(1);
        this.f202855c.setColor(-1);
        if (r101 == null) goto L14;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.circle_indicator_gravity, R.attr.circle_indicator_height, R.attr.circle_indicator_margin, R.attr.circle_indicator_orientation, R.attr.circle_indicator_width});
        this.f202861i = r105.getDimensionPixelSize(4, -1);
        this.f202862j = r105.getDimensionPixelSize(1, -1);
        this.f202860h = r105.getDimensionPixelSize(2, -1);
        if (r105.getInt(3, -1) == 1) goto L9;
        r104 = 0;
    L9:
        setOrientation(r104);
        int r106 = r105.getInt(0, -1);
        if (r106 >= 0) goto L13;
        r106 = 17;
    L13:
        setGravity(r106);
        r105.recycle();
    L14:
        int r107 = this.f202861i;
        if (r107 >= 0) goto L17;
        r107 = d();
    L17:
        this.f202861i = r107;
        int r108 = this.f202862j;
        if (r108 >= 0) goto L20;
        r108 = d();
    L20:
        this.f202862j = r108;
        int r109 = this.f202860h;
        if (r109 >= 0) goto L23;
        r109 = d();
    L23:
        this.f202860h = r109;
        this.f202856d = b();
        Animator r110 = b();
        this.f202858f = r110;
        r110.setDuration(0);
        Animator r111 = b();
        r111.setInterpolator(new c());
        this.f202857e = r111;
        Animator r112 = b();
        r112.setInterpolator(new c());
        this.f202859g = r112;
        r112.setDuration(0);
    }
}
