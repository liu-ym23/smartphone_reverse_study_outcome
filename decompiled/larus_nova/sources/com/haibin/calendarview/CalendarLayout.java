package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class CalendarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f276065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MonthViewPager f276066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CalendarView f276067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeekViewPager f276068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public YearViewPager f276069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f276070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f276071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f276072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f276073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f276074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f276075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f276076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f276077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f276078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f276079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final VelocityTracker f276080q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f276081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f276082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l f276083t;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CalendarLayout f276084a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f276084a.b(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(CalendarLayout r100) {
            this.f276084a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CalendarLayout f276085a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f276085a.d(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(CalendarLayout r100) {
            this.f276085a = r100;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CalendarLayout f276086a;

        public c(CalendarLayout r100) {
            this.f276086a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = ((Float) r100.getAnimatedValue()).floatValue() * 1.0f;
            CalendarLayout r102 = this.f276086a;
            r102.f276066c.setTranslationY(r102.f276075l * (r101 / r102.f276074k));
            this.f276086a.f276078o = true;
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CalendarLayout f276087a;

        public d(CalendarLayout r100) {
            this.f276087a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            CalendarLayout r101 = this.f276087a;
            r101.f276078o = false;
            if (r101.f276071h != 2) goto L5;
            r101.requestLayout();
        L5:
            CalendarLayout r102 = this.f276087a;
            if (r102.f276066c.getVisibility() == 0) goto L9;
            r102.f276083t.getClass();
        L9:
            r102.f276068e.setVisibility(8);
            r102.f276066c.setVisibility(0);
            this.f276087a.f276083t.getClass();
            this.f276087a.getClass();
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CalendarLayout f276088a;

        public e(CalendarLayout r100) {
            this.f276088a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = ((Float) r100.getAnimatedValue()).floatValue() * 1.0f;
            CalendarLayout r102 = this.f276088a;
            r102.f276066c.setTranslationY(r102.f276075l * (r101 / r102.f276074k));
            this.f276088a.f276078o = true;
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CalendarLayout f276089a;

        public f(CalendarLayout r100) {
            this.f276089a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            CalendarLayout r101 = this.f276089a;
            r101.f276078o = false;
            CalendarLayout.a(r101);
            this.f276089a.getClass();
        }
    }

    public interface g {
        boolean a();
    }

    private int getCalendarViewHeight() {
        if (this.f276066c.getVisibility() == 0) goto L7;
        l r100 = this.f276083t;
        int r101 = r100.f276163d0;
        return r100.f276159b0 + r101;
    L7:
        return this.f276083t.f276163d0 + this.f276066c.getHeight();
    }

    public final boolean c() {
        if (this.f276070g != null) goto L5;
    L8:
        return true;
    L5:
        if (this.f276066c.getVisibility() == 0) goto L8;
        return false;
    }

    public final void e() {
        this.f276066c.setTranslationY(this.f276075l * ((this.f276070g.getTranslationY() * 1.0f) / this.f276074k));
    }

    public final void f() {
        l r100 = this.f276083t;
        Calendar r101 = r100.f276185o0;
        if (r100.f276158b != 0) goto L5;
        this.f276074k = this.f276082s * 5;
    L7:
        if (this.f276068e.getVisibility() != 0) goto L13;
        ViewGroup r102 = this.f276070g;
        if (r102 != null) goto L11;
        return;
    L11:
        r102.setTranslationY(-this.f276074k);
        return;
    L13:
        return;
    L5:
        this.f276074k = com.haibin.calendarview.f.e(r101.getYear(), r101.getMonth(), this.f276082s, this.f276083t.f276156a) - this.f276082s;
        goto L7
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("super", super.onSaveInstanceState());
        r100.putBoolean("isExpand", c());
        return r100;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f276066c = (MonthViewPager) findViewById(R.id.vp_month);
        this.f276068e = (WeekViewPager) findViewById(R.id.vp_week);
        if (getChildCount() <= 0) goto L5;
        this.f276067d = (CalendarView) getChildAt(0);
    L5:
        this.f276070g = (ViewGroup) findViewById(this.f276079p);
        this.f276069f = (YearViewPager) findViewById(R.id.selectLayout);
        ViewGroup r100 = this.f276070g;
        if (r100 == null) goto L9;
        r100.setOverScrollMode(2);
        return;
    }

    public static void a(CalendarLayout r100) {
        if (r100.f276068e.getVisibility() == 0) goto L6;
        r100.f276083t.getClass();
    L6:
        r100.f276068e.getAdapter().notifyDataSetChanged();
        r100.f276068e.setVisibility(0);
        r100.f276066c.setVisibility(4);
    }

    public final boolean b(int r100) {
        if (this.f276078o == false) goto L5;
    L18:
        return false;
    L5:
        if (this.f276072i == 1) goto L18;
        if (this.f276070g == null) goto L18;
        if (this.f276066c.getVisibility() == 0) goto L16;
        this.f276068e.setVisibility(8);
        if (this.f276066c.getVisibility() == 0) goto L15;
        this.f276083t.getClass();
    L15:
        this.f276066c.setVisibility(0);
    L16:
        ViewGroup r101 = this.f276070g;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), 0.0f});
        r102.setDuration(r100);
        r102.addUpdateListener(new c(this));
        r102.addListener(new d(this));
        r102.start();
        return true;
    }

    public final boolean d(int r100) {
        if (this.f276071h != 2) goto L6;
        requestLayout();
    L6:
        if (this.f276078o == true) goto L12;
        ViewGroup r101 = this.f276070g;
        if (r101 == null) goto L12;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), -this.f276074k});
        r102.setDuration(r100);
        r102.addUpdateListener(new e(this));
        r102.addListener(new f(this));
        r102.start();
        return true;
    L12:
        return false;
    }

    public final void g(int r100) {
        this.f276075l = (((r100 + 7) / 7) - 1) * this.f276082s;
    }

    public final void h(int r100) {
        this.f276075l = (r100 - 1) * this.f276082s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f276078o == false) goto L6;
        return true;
    L6:
        if (this.f276071h != 2) goto L9;
        return false;
    L9:
        if (this.f276069f == null) goto L84;
        CalendarView r100 = this.f276067d;
        if (r100 == null) goto L84;
        if (r100.getVisibility() == 8) goto L84;
        ViewGroup r101 = this.f276070g;
        if (r101 == null) goto L84;
        if (r101.getVisibility() != 0) goto L84;
        int r102 = this.f276072i;
        if (r102 == 2) goto L82;
        if (r102 == 1) goto L82;
        if (this.f276069f.getVisibility() == 0) goto L81;
        this.f276083t.getClass();
        int r103 = r110.getAction();
        float r104 = r110.getY();
        if (r103 == 0) goto L77;
        if (r103 != 2) goto L79;
        float r105 = r104 - this.f276077n;
        if (r105 >= 0.0f) goto L35;
        if (this.f276070g.getTranslationY() != (-this.f276074k)) goto L35;
        return false;
    L35:
        if (r105 > 0.0f) goto L37;
    L61:
        if (r105 <= 0.0f) goto L68;
        if (this.f276070g.getTranslationY() != 0.0f) goto L68;
        if (r104 < com.haibin.calendarview.f.a(getContext(), 98.0f)) goto L68;
        return false;
    L68:
        if (Math.abs(r105) <= this.f276073j) goto L79;
        if (r105 > 0.0f) goto L71;
    L72:
        if (r105 >= 0.0f) goto L79;
        if (this.f276070g.getTranslationY() < (-this.f276074k)) goto L79;
    L75:
        this.f276077n = r104;
        return true;
    L71:
        if (this.f276070g.getTranslationY() <= 0.0f) goto L75;
    L37:
        if (this.f276070g.getTranslationY() != (-this.f276074k)) goto L61;
        if (r104 < com.haibin.calendarview.f.a(getContext(), 98.0f)) goto L61;
        ViewGroup r106 = this.f276070g;
        if ((r106 instanceof g) == false) goto L44;
        boolean r107 = ((g) r106).a();
    L59:
        if (r107 == true) goto L61;
        return false;
    L44:
        if ((r106 instanceof RecyclerView) == false) goto L49;
        if (((RecyclerView) r106).computeVerticalScrollOffset() == 0) goto L57;
    L58:
        r107 = false;
    L57:
        r107 = true;
        goto L59
    L49:
        if ((r106 instanceof AbsListView) == false) goto L56;
        AbsListView r108 = (AbsListView) r106;
        if (r108.getFirstVisiblePosition() != 0) goto L58;
        if (r108.getChildAt(0).getTop() != 0) goto L58;
    L56:
        if (r106.getScrollY() != 0) goto L58;
    L79:
        return super.onInterceptTouchEvent(r110);
    L77:
        c();
        this.f276064a = MotionEventCompat.getPointerId(r110, MotionEventCompat.getActionIndex(r110));
        this.f276076m = r104;
        this.f276077n = r104;
        goto L79
    L81:
        return super.onInterceptTouchEvent(r110);
    L82:
        return false;
    L84:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        Bundle r101 = (Bundle) r100;
        Parcelable r102 = r101.getParcelable("super");
        if (r101.getBoolean("isExpand") == false) goto L5;
        post(new a(this));
    L6:
        super.onRestoreInstanceState(r102);
        return;
    L5:
        post(new b(this));
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f276083t.getClass();
        if (this.f276070g == null) goto L85;
        CalendarView r101 = this.f276067d;
        if (r101 == null) goto L85;
        if (r101.getVisibility() == 8) goto L85;
        int r102 = r100.getAction();
        float r103 = r100.getY();
        this.f276080q.addMovement(r100);
        if (r102 != 0) goto L12;
        this.f276064a = MotionEventCompat.getPointerId(r100, MotionEventCompat.getActionIndex(r100));
        this.f276076m = r103;
        this.f276077n = r103;
        return true;
    L12:
        if (r102 != 1) goto L14;
        VelocityTracker r104 = this.f276080q;
        r104.computeCurrentVelocity(1000, this.f276081r);
        float r105 = r104.getYVelocity();
        if (this.f276070g.getTranslationY() != 0.0f) goto L66;
    L80:
        b(240);
    L82:
        return super.onTouchEvent(r100);
    L66:
        if (this.f276070g.getTranslationY() == this.f276074k) goto L80;
        if (Math.abs(r105) < 800.0f) goto L77;
        if (r105 >= 0.0f) goto L73;
        d(240);
    L75:
        return super.onTouchEvent(r100);
    L73:
        b(240);
        goto L75
    L77:
        if ((r100.getY() - this.f276076m) <= 0.0f) goto L79;
        b(240);
        goto L82
    L79:
        d(240);
        goto L82
    L14:
        if (r102 == 2) goto L33;
        if (r102 != 3) goto L18;
    L25:
        int r106 = MotionEventCompat.findPointerIndex(r100, this.f276064a);
        if (r106 != (-1)) goto L29;
        this.f276064a = -1;
    L29:
        if (this.f276064a == (-1)) goto L82;
        this.f276077n = MotionEventCompat.getY(r100, r106);
        goto L82
    L18:
        if (r102 != 5) goto L20;
        int r107 = MotionEventCompat.getPointerId(r100, MotionEventCompat.getActionIndex(r100));
        this.f276064a = r107;
        if (r107 != 0) goto L82;
        this.f276077n = MotionEventCompat.getY(r100, r107);
        goto L82
    L20:
        if (r102 == 6) goto L25;
    L33:
        if (this.f276071h == 2) goto L62;
        int r108 = this.f276072i;
        if (r108 == 2) goto L62;
        if (r108 == 1) goto L62;
        if (MotionEventCompat.findPointerIndex(r100, this.f276064a) != (-1)) goto L42;
        this.f276064a = -1;
    L42:
        if (this.f276064a != (-1)) goto L44;
        this.f276077n = r103;
        this.f276064a = 1;
    L44:
        float r109 = r103 - this.f276077n;
        if (r109 < 0.0f) goto L47;
    L50:
        this.f276068e.setVisibility(8);
        this.f276066c.setVisibility(0);
        if (r109 > 0.0f) goto L53;
    L56:
        if (r109 >= 0.0f) goto L61;
        float r110 = this.f276070g.getTranslationY() + r109;
        float r111 = -this.f276074k;
        if (r110 > r111) goto L61;
        this.f276070g.setTranslationY(r111);
        e();
        this.f276077n = r103;
        return super.onTouchEvent(r100);
    L61:
        ViewGroup r112 = this.f276070g;
        r112.setTranslationY(r112.getTranslationY() + r109);
        e();
        this.f276077n = r103;
        goto L82
    L53:
        if ((this.f276070g.getTranslationY() + r109) < 0.0f) goto L56;
        this.f276070g.setTranslationY(0.0f);
        e();
        this.f276077n = r103;
        return super.onTouchEvent(r100);
    L47:
        if (this.f276070g.getTranslationY() != (-this.f276074k)) goto L50;
        this.f276077n = r103;
        return false;
    L62:
        return false;
    L85:
        return false;
    }

    public final void setup(l r100) {
        this.f276083t = r100;
        this.f276082s = r100.f276159b0;
        if (r100.f276183n0.isAvailable() == false) goto L5;
        Calendar r101 = r100.f276183n0;
    L6:
        g((com.haibin.calendarview.f.g(r101, this.f276083t.f276156a) + r101.getDay()) - 1);
        f();
        return;
    L5:
        r101 = r100.c();
        goto L6
    }

    public CalendarLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f276075l = 0;
        this.f276078o = false;
        setOrientation(1);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.calendar_content_view_id, R.attr.calendar_show_mode, R.attr.default_status, R.attr.gesture_mode});
        this.f276079p = r102.getResourceId(0, 0);
        this.f276065b = r102.getInt(2, 0);
        this.f276072i = r102.getInt(1, 0);
        this.f276071h = r102.getInt(3, 0);
        r102.recycle();
        this.f276080q = VelocityTracker.obtain();
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        this.f276073j = r103.getScaledTouchSlop();
        this.f276081r = r103.getScaledMaximumFlingVelocity();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f276070g != null) goto L5;
    L44:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.f276067d == null) goto L44;
        int r102 = this.f276083t.f276185o0.getYear();
        int r103 = this.f276083t.f276185o0.getMonth();
        int r104 = com.haibin.calendarview.f.a(getContext(), 1.0f);
        l r105 = this.f276083t;
        int r106 = r104 + r105.f276163d0;
        int r107 = r105.f276159b0;
        int r108 = r105.f276156a;
        if (r105.f276158b != 0) goto L10;
        int r109 = r107 * 6;
    L11:
        int r110 = r109 + r106;
        int r111 = View.MeasureSpec.getSize(r101);
        if (this.f276083t.f276161c0 == false) goto L15;
        super.onMeasure(r100, r101);
        int r112 = View.MeasureSpec.makeMeasureSpec((r111 - r106) - this.f276083t.f276159b0, 1073741824);
        this.f276070g.measure(r100, r112);
        ViewGroup r113 = this.f276070g;
        r113.layout(r113.getLeft(), this.f276070g.getTop(), this.f276070g.getRight(), this.f276070g.getBottom());
        return;
    L15:
        if (r110 >= r111) goto L17;
    L19:
        if (r110 < r111) goto L21;
    L24:
        if (this.f276072i == 2) goto L38;
        if (this.f276067d.getVisibility() == 8) goto L38;
        if (this.f276071h == 2) goto L31;
    L36:
        r111 = r111 - r106;
        int r114 = this.f276082s;
    L41:
        int r115 = r111 - r114;
    L42:
        super.onMeasure(r100, r101);
        int r116 = View.MeasureSpec.makeMeasureSpec(r115, 1073741824);
        this.f276070g.measure(r100, r116);
        ViewGroup r117 = this.f276070g;
        r117.layout(r117.getLeft(), this.f276070g.getTop(), this.f276070g.getRight(), this.f276070g.getBottom());
        return;
    L31:
        if (this.f276078o == true) goto L36;
        if (c() == false) goto L35;
        r115 = r111 - r110;
        goto L42
    L35:
        r111 = r111 - r106;
        r114 = this.f276082s;
    L38:
        if (this.f276067d.getVisibility() != 8) goto L40;
        r114 = 0;
        goto L41
    L40:
        r114 = this.f276067d.getHeight();
        goto L41
    L21:
        if (this.f276066c.getHeight() <= 0) goto L24;
        r101 = View.MeasureSpec.makeMeasureSpec(r111, 1073741824);
        goto L24
    L17:
        if (this.f276066c.getHeight() <= 0) goto L19;
        r101 = View.MeasureSpec.makeMeasureSpec((r110 + r106) + this.f276083t.f276163d0, 1073741824);
        r111 = r110;
        goto L24
    L10:
        r109 = com.haibin.calendarview.f.e(r102, r103, r107, r108);
        goto L11
    }
}
