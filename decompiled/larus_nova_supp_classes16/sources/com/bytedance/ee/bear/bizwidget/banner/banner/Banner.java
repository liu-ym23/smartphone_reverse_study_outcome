package com.bytedance.ee.bear.bizwidget.banner.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.bear.bizwidget.banner.adapter.BannerAdapter;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;
import com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver;
import com.bytedance.ee.bear.bizwidget.banner.util.ScrollSpeedManger;
import com.bytedance.ee.bear.document.DocumentSplitWindowPlugin;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.CompositePageTransformer;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Banner<T, BA extends BannerAdapter> extends FrameLayout implements BannerLifecycleObserver {
    public static final /* synthetic */ int H = 0;
    public float A;
    public float B;
    public boolean C;
    public final boolean D;
    public Paint E;
    public Paint F;
    public final a G;
    public ViewPager2 a;
    public b b;
    public BA c;
    public qv4.a d;
    public CompositePageTransformer e;
    public Banner<T, BA>.c f;
    public boolean g;
    public boolean h;
    public long i;
    public final int j;
    public int k;
    public float l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ Banner a;

        public final void onChanged() {
            if (this.a.getItemCount() > 1) goto L5;
            this.a.d();
        L6:
            Banner r0 = this.a;
            if (r0.d == null) goto L10;
            int r1 = rv4.a.b(r0.g, r0.getCurrentItem(), r0.getRealCount());
            r0.d.b(r0.getRealCount(), r1);
            return;
        L10:
            return;
        L5:
            this.a.c();
            goto L6
        }

        public a(Banner r1) {
            this.a = r1;
        }
    }

    public static class b implements Runnable {
        public final WeakReference<Banner> a;

        @Override // java.lang.Runnable
        public final void run() {
            Banner r0 = this.a.get();     // Catch: Throwable -> L11
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.h == false) goto L18;
            int r1 = r0.getItemCount();     // Catch: Throwable -> L11
            if (r1 == 0) goto L19;
            int r2 = (r0.getCurrentItem() + 1) % r1;     // Catch: Throwable -> L11
            r0.getViewPager2().setCurrentItem(r2, true);     // Catch: Throwable -> L11
            r0.postDelayed(r0.b, r0.i);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public b(Banner r2) {
            this.a = new WeakReference(r2);
        }
    }

    public class c extends ViewPager2.OnPageChangeCallback {
        public int a;
        public boolean b;
        public final /* synthetic */ Banner c;

        public c(Banner r1) {
            this.c = r1;
            this.a = -1;
        }

        public final void onPageScrollStateChanged(int r6) {
            if (r6 != 1) goto L5;
        L17:
            this.b = true;
        L18:
            Banner r0 = this.c;
            int r1 = Banner.H;
            r0.getClass();
            qv4.a r2 = this.c.d;
            if (r2 == null) goto L22;
            r2.onPageScrollStateChanged(r6);
            return;
        L22:
            return;
        L5:
            if (r6 == 2) goto L17;
            if (r6 != 0) goto L18;
            this.b = false;
            int r3 = this.a;
            if (r3 == (-1)) goto L18;
            Banner r4 = this.c;
            if (r4.g == false) goto L18;
            if (r3 != 0) goto L15;
            int r5 = r4.getRealCount();
            r4.getViewPager2().setCurrentItem(r5, false);
            goto L18
        L15:
            if (r3 != (r4.getItemCount() - 1)) goto L18;
            this.c.getViewPager2().setCurrentItem(1, false);
            goto L18
        }

        public final void onPageSelected(int r3) {
            if (this.b == false) goto L8;
            this.a = r3;
            Banner r0 = this.c;
            int r4 = rv4.a.b(r0.g, r3, r0.getRealCount());
            this.c.getClass();
            qv4.a r1 = this.c.d;
            if (r1 == null) goto L9;
            r1.onPageSelected(r4);
            return;
        L9:
            return;
        }

        public final void onPageScrolled(int r2, float r3, int r4) {
            Banner r5 = this.c;
            int r6 = rv4.a.b(r5.g, r2, r5.getRealCount());
            this.c.getClass();
            qv4.a r7 = this.c.d;
            if (r7 == null) goto L6;
            r7.a(r6, r3);
            return;
        }
    }

    public final void a() {
        if (this.d != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L8;
        return;
    L8:
        if (this.d.getIndicatorConfig().l == false) goto L13;
        qv4.a r0 = this.d;
        if (r0 == null) goto L12;
        removeView(r0.getIndicatorView());
    L12:
        addView(this.d.getIndicatorView());
    L13:
        int r1 = this.s;
        if (r1 == 0) goto L16;
        b(new IndicatorConfig.a(r1, r1, r1, r1));
    L25:
        int r2 = this.r;
        if (r2 <= 0) goto L30;
        qv4.a r3 = this.d;
        if (r3 == null) goto L30;
        r3.getIndicatorConfig().d = r2;
    L30:
        int r4 = this.q;
        if (r4 == 1) goto L37;
        qv4.a r5 = this.d;
        if (r5 == null) goto L37;
        if (r5.getIndicatorConfig().l == false) goto L37;
        this.d.getIndicatorConfig().c = r4;
        this.d.getIndicatorView().postInvalidate();
    L37:
        int r6 = this.m;
        if (r6 <= 0) goto L42;
        qv4.a r7 = this.d;
        if (r7 == null) goto L42;
        r7.getIndicatorConfig().e = r6;
    L42:
        int r8 = this.n;
        if (r8 <= 0) goto L47;
        qv4.a r9 = this.d;
        if (r9 == null) goto L47;
        r9.getIndicatorConfig().f = r8;
    L47:
        int r10 = this.x;
        if (r10 <= 0) goto L52;
        qv4.a r11 = this.d;
        if (r11 == null) goto L52;
        r11.getIndicatorConfig().j = r10;
    L52:
        int r12 = this.y;
        if (r12 <= 0) goto L57;
        qv4.a r13 = this.d;
        if (r13 == null) goto L57;
        r13.getIndicatorConfig().i = r12;
    L57:
        int r14 = this.o;
        qv4.a r16 = this.d;
        if (r16 == null) goto L60;
        r16.getIndicatorConfig().g = r14;
    L60:
        int r17 = this.p;
        qv4.a r18 = this.d;
        if (r18 == null) goto L64;
        r18.getIndicatorConfig().h = r17;
    L64:
        if (this.d == null) goto L68;
        int r19 = rv4.a.b(this.g, getCurrentItem(), getRealCount());
        this.d.b(getRealCount(), r19);
        return;
    L68:
        return;
    L16:
        int r20 = this.t;
        if (r20 == 0) goto L19;
    L24:
        b(new IndicatorConfig.a(r20, this.u, this.v, this.w));
        goto L25
    L19:
        if (this.u != 0) goto L24;
        if (this.v != 0) goto L24;
        if (this.w == 0) goto L25;
        goto L24
    }

    public final void c() {
        if (this.h == false) goto L6;
        d();
        postDelayed(this.b, this.i);
        return;
    }

    public final void d() {
        if (this.h == false) goto L6;
        removeCallbacks(this.b);
        return;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public IndicatorConfig getIndicatorConfig() {
        if (getIndicator() != null) goto L5;
        return null;
    L5:
        return getIndicator().getIndicatorConfig();
    }

    public int getItemCount() {
        if (getAdapter() != null) goto L7;
        return 0;
    L7:
        return getAdapter().getItemCount();
    }

    public int getRealCount() {
        return getAdapter().y2();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public BA getAdapter() {
        return this.c;
    }

    public qv4.a getIndicator() {
        return this.d;
    }

    public int getScrollTime() {
        return this.j;
    }

    public ViewPager2 getViewPager2() {
        return this.a;
    }

    public Banner(Context r2) {
        this(r2, null);
    }

    private void setRecyclerViewPadding(int r5) {
        RecyclerView r0 = getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() != 1) goto L5;
        r0.setPadding(0, r5, 0, r5);
    L6:
        r0.setClipToPadding(false);
        return;
    L5:
        r0.setPadding(r5, 0, r5, 0);
        goto L6
    }

    public final void b(IndicatorConfig.a r2) {
        qv4.a r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getIndicatorConfig().l == false) goto L9;
        this.d.getIndicatorConfig().k = r2;
        this.d.getIndicatorView().requestLayout();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r9) {
        if (this.l <= 0.0f) goto L5;
        r9.saveLayer(new RectF(0.0f, 0.0f, r9.getWidth(), r9.getHeight()), this.F, 31);
        super.dispatchDraw(r9);
        Path r0 = new Path();
        r0.moveTo(0.0f, this.l);
        r0.lineTo(0.0f, 0.0f);
        r0.lineTo(this.l, 0.0f);
        float r3 = this.l * 2.0f;
        r0.arcTo(new RectF(0.0f, 0.0f, r3, r3), -90.0f, -90.0f);
        r0.close();
        r9.drawPath(r0, this.E);
        int r1 = getWidth();
        Path r2 = new Path();
        float r4 = r1;
        r2.moveTo(r4 - this.l, 0.0f);
        r2.lineTo(r4, 0.0f);
        r2.lineTo(r4, this.l);
        float r6 = this.l * 2.0f;
        r2.arcTo(new RectF(r4 - r6, 0.0f, r4, r6), 0.0f, -90.0f);
        r2.close();
        r9.drawPath(r2, this.E);
        int r5 = getHeight();
        Path r7 = new Path();
        float r8 = r5;
        r7.moveTo(0.0f, r8 - this.l);
        r7.lineTo(0.0f, r8);
        r7.lineTo(this.l, r8);
        float r10 = this.l * 2.0f;
        r7.arcTo(new RectF(0.0f, r8 - r10, r10, r8), 90.0f, 90.0f);
        r7.close();
        r9.drawPath(r7, this.E);
        int r11 = getHeight();
        int r12 = getWidth();
        Path r13 = new Path();
        float r14 = r12;
        float r16 = r11;
        r13.moveTo(r14 - this.l, r16);
        r13.lineTo(r14, r16);
        r13.lineTo(r14, r16 - this.l);
        float r17 = this.l * 2.0f;
        r13.arcTo(new RectF(r14 - r17, r16 - r17, r14, r16), 0.0f, 90.0f);
        r13.close();
        r9.drawPath(r13, this.E);
        r9.restore();
        return;
    L5:
        super.dispatchDraw(r9);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (getViewPager2().isUserInputEnabled() == false) goto L5;
        int r0 = r3.getActionMasked();
        if (r0 != 1) goto L9;
    L15:
        c();
    L17:
        return super.dispatchTouchEvent(r3);
    L9:
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L15;
        if (r0 != 0) goto L17;
        d();
        goto L17
    L5:
        return super.dispatchTouchEvent(r3);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver
    public final void onDestroy(LifecycleOwner r2) {
        if (getViewPager2() != null) goto L5;
    L7:
        d();
        return;
    L5:
        if (this.f == null) goto L7;
        getViewPager2().unregisterOnPageChangeCallback(this.f);
        this.f = null;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        if (getViewPager2().isUserInputEnabled() == false) goto L38;
        if (this.D == false) goto L38;
        int r0 = r6.getAction();
        boolean r1 = true;
        if (r0 != 0) goto L10;
        this.A = r6.getX();
        this.B = r6.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L36:
        return super.onInterceptTouchEvent(r6);
    L10:
        if (r0 != 1) goto L12;
    L33:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L36
    L12:
        if (r0 != 2) goto L14;
        float r2 = r6.getX();
        float r3 = r6.getY();
        float r4 = Math.abs(r2 - this.A);
        float r5 = Math.abs(r3 - this.B);
        if (getViewPager2().getOrientation() != 0) goto L26;
        if (r4 > this.z) goto L21;
    L23:
        r1 = false;
    L24:
        this.C = r1;
    L32:
        getParent().requestDisallowInterceptTouchEvent(this.C);
        goto L36
    L21:
        if (r4 <= r5) goto L23;
    L26:
        if (r5 > this.z) goto L28;
    L30:
        r1 = false;
    L31:
        this.C = r1;
        goto L32
    L28:
        if (r5 <= r4) goto L30;
    L14:
        if (r0 == 3) goto L33;
    L38:
        return super.onInterceptTouchEvent(r6);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver
    public final void onStart(LifecycleOwner r1) {
        c();
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver
    public final void onStop(LifecycleOwner r1) {
        d();
    }

    public Banner(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public Banner(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.g = true;
        this.h = true;
        this.i = ToastModel.DEFAULT_DURATION;
        this.j = DocumentSplitWindowPlugin.MIN_SMALLEST_WIDTH_IN_DP;
        this.k = 1;
        this.l = 0.0f;
        this.m = pv4.a.a;
        this.n = pv4.a.b;
        this.o = -1996488705;
        this.p = -1;
        this.q = 1;
        this.x = pv4.a.e;
        this.y = pv4.a.f;
        this.D = true;
        this.G = new a(this);
        this.z = ViewConfiguration.get(r10).getScaledTouchSlop() / 2;
        this.e = new CompositePageTransformer();
        this.f = new c(this);
        this.b = new b(this);
        ViewPager2 r2 = new ViewPager2(r10);
        this.a = r2;
        r2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setOffscreenPageLimit(1);
        this.a.registerOnPageChangeCallback(this.f);
        this.a.setPageTransformer(this.e);
        if (getScrollTime() >= 100) goto L23;
    L15:
        addView(this.a);
        Paint r3 = new Paint();
        this.E = r3;
        r3.setColor(-1);
        this.E.setAntiAlias(true);
        this.E.setStyle(Paint.Style.FILL);
        this.E.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint r4 = new Paint();
        this.F = r4;
        r4.setXfermode(null);
        if (r11 == null) goto L25;
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{2130968934, 2130968937, 2130968938, 2130968939, 2130968940, 2130968941, 2130968942, 2130968943, 2130968944, 2130968945, 2130968946, 2130968947, 2130968948, 2130968949, 2130968950, 2130968952, 2130968953, 2130968955});
        this.l = r13.getDimensionPixelSize(17, 0);
        this.i = r13.getInt(15, 3000);
        this.h = r13.getBoolean(0, true);
        this.g = r13.getBoolean(14, true);
        this.m = r13.getDimensionPixelSize(9, pv4.a.a);
        this.n = r13.getDimensionPixelSize(12, pv4.a.b);
        this.o = r13.getColor(8, -1996488705);
        this.p = r13.getColor(11, -1);
        this.q = r13.getInt(1, 1);
        this.r = r13.getDimensionPixelSize(13, 0);
        this.s = r13.getDimensionPixelSize(3, 0);
        this.t = r13.getDimensionPixelSize(5, 0);
        this.u = r13.getDimensionPixelSize(7, 0);
        this.v = r13.getDimensionPixelSize(6, 0);
        this.w = r13.getDimensionPixelSize(4, 0);
        this.x = r13.getDimensionPixelSize(2, pv4.a.e);
        this.y = r13.getDimensionPixelSize(10, pv4.a.f);
        getViewPager2().setOrientation(r13.getInt(16, 0));
        boolean r14 = this.g;
        if (r14 == true) goto L21;
        this.h = false;
    L21:
        this.k = r14 ? 1 : 0;
        r13.recycle();
        return;
    L25:
        return;
    L23:
        ViewPager2 r5 = getViewPager2();     // Catch: Exception -> L13
        RecyclerView r6 = r5.getChildAt(0);     // Catch: Exception -> L13
        r6.setOverScrollMode(2);     // Catch: Exception -> L13
        ScrollSpeedManger r7 = new ScrollSpeedManger(this, r6.getLayoutManager());     // Catch: Exception -> L13
        r6.setLayoutManager(r7);     // Catch: Exception -> L13
        Field r8 = ViewPager2.class.getDeclaredField("mLayoutManager");     // Catch: Exception -> L13
        r8.setAccessible(true);     // Catch: Exception -> L13
        r8.set(r5, r7);     // Catch: Exception -> L13
        Field r9 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");     // Catch: Exception -> L13
        r9.setAccessible(true);     // Catch: Exception -> L13
        Object r16 = r9.get(r5);     // Catch: Exception -> L13
        if (r16 == null) goto L9;
        Field r17 = r16.getClass().getDeclaredField("mLayoutManager");     // Catch: Exception -> L13
        r17.setAccessible(true);     // Catch: Exception -> L13
        r17.set(r16, r7);     // Catch: Exception -> L13
    L9:
        Field r18 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");     // Catch: Exception -> L13
        r18.setAccessible(true);     // Catch: Exception -> L13
        Object r19 = r18.get(r5);     // Catch: Exception -> L13
        if (r19 == null) goto L15;
        Field r20 = r19.getClass().getDeclaredField("mLayoutManager");     // Catch: Exception -> L13
        r20.setAccessible(true);     // Catch: Exception -> L13
        r20.set(r19, r7);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
