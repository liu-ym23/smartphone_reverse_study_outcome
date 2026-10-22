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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.banner.adapter.BannerAdapter;
import com.bytedance.ee.bear.bizwidget.banner.config.IndicatorConfig;
import com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver;
import com.bytedance.ee.bear.bizwidget.banner.util.ScrollSpeedManger;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.CompositePageTransformer;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes16.dex */
public class Banner<T, BA extends BannerAdapter> extends FrameLayout implements BannerLifecycleObserver {
    public static final /* synthetic */ int H = 0;
    public float A;
    public float B;
    public boolean C;
    public final boolean D;
    public Paint E;
    public Paint F;
    public final a G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f216309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f216310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BA f216311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qv4.a f216312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositePageTransformer f216313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Banner<T, BA>.c f216314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f216315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f216316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f216317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f216318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f216319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f216320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f216321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f216322n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f216323o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f216324p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f216325q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f216326r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f216327s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f216328t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f216329u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f216330v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f216331w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f216332x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f216333y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f216334z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public class a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Banner f216335a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            if (this.f216335a.getItemCount() > 1) goto L5;
            this.f216335a.d();
        L6:
            Banner r100 = this.f216335a;
            if (r100.f216312d == null) goto L10;
            int r101 = rv4.a.b(r100.f216315g, r100.getCurrentItem(), r100.getRealCount());
            r100.f216312d.b(r100.getRealCount(), r101);
            return;
        L10:
            return;
        L5:
            this.f216335a.c();
            goto L6
        }

        public a(Banner r100) {
            this.f216335a = r100;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Banner> f216336a;

        @Override // java.lang.Runnable
        public final void run() {
            Banner r100 = this.f216336a.get();     // Catch: Throwable -> L11
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f216316h == false) goto L18;
            int r101 = r100.getItemCount();     // Catch: Throwable -> L11
            if (r101 == 0) goto L19;
            int r102 = (r100.getCurrentItem() + 1) % r101;     // Catch: Throwable -> L11
            r100.getViewPager2().setCurrentItem(r102, true);     // Catch: Throwable -> L11
            r100.postDelayed(r100.f216310b, r100.f216317i);     // Catch: Throwable -> L11
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

        public b(Banner r100) {
            this.f216336a = new WeakReference(r100);
        }
    }

    public class c extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f216337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f216338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Banner f216339c;

        public c(Banner r100) {
            this.f216339c = r100;
            this.f216337a = -1;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 1) goto L5;
        L17:
            this.f216338b = true;
        L18:
            Banner r101 = this.f216339c;
            int r102 = Banner.H;
            r101.getClass();
            qv4.a r103 = this.f216339c.f216312d;
            if (r103 == null) goto L22;
            r103.onPageScrollStateChanged(r100);
            return;
        L22:
            return;
        L5:
            if (r100 == 2) goto L17;
            if (r100 != 0) goto L18;
            this.f216338b = false;
            int r104 = this.f216337a;
            if (r104 == (-1)) goto L18;
            Banner r105 = this.f216339c;
            if (r105.f216315g == false) goto L18;
            if (r104 != 0) goto L15;
            int r106 = r105.getRealCount();
            r105.getViewPager2().setCurrentItem(r106, false);
            goto L18
        L15:
            if (r104 != (r105.getItemCount() - 1)) goto L18;
            this.f216339c.getViewPager2().setCurrentItem(1, false);
            goto L18
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r100) {
            if (this.f216338b == false) goto L8;
            this.f216337a = r100;
            Banner r101 = this.f216339c;
            int r102 = rv4.a.b(r101.f216315g, r100, r101.getRealCount());
            this.f216339c.getClass();
            qv4.a r103 = this.f216339c.f216312d;
            if (r103 == null) goto L9;
            r103.onPageSelected(r102);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r100, float r101, int r102) {
            Banner r103 = this.f216339c;
            int r104 = rv4.a.b(r103.f216315g, r100, r103.getRealCount());
            this.f216339c.getClass();
            qv4.a r105 = this.f216339c.f216312d;
            if (r105 == null) goto L6;
            r105.a(r104, r101);
            return;
        }
    }

    public final void a() {
        if (this.f216312d != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L8;
        return;
    L8:
        if (this.f216312d.getIndicatorConfig().f216351l == false) goto L13;
        qv4.a r100 = this.f216312d;
        if (r100 == null) goto L12;
        removeView(r100.getIndicatorView());
    L12:
        addView(this.f216312d.getIndicatorView());
    L13:
        int r101 = this.f216327s;
        if (r101 == 0) goto L16;
        b(new IndicatorConfig.a(r101, r101, r101, r101));
    L25:
        int r102 = this.f216326r;
        if (r102 <= 0) goto L30;
        qv4.a r103 = this.f216312d;
        if (r103 == null) goto L30;
        r103.getIndicatorConfig().f216343d = r102;
    L30:
        int r104 = this.f216325q;
        if (r104 == 1) goto L37;
        qv4.a r105 = this.f216312d;
        if (r105 == null) goto L37;
        if (r105.getIndicatorConfig().f216351l == false) goto L37;
        this.f216312d.getIndicatorConfig().f216342c = r104;
        this.f216312d.getIndicatorView().postInvalidate();
    L37:
        int r106 = this.f216321m;
        if (r106 <= 0) goto L42;
        qv4.a r107 = this.f216312d;
        if (r107 == null) goto L42;
        r107.getIndicatorConfig().f216344e = r106;
    L42:
        int r108 = this.f216322n;
        if (r108 <= 0) goto L47;
        qv4.a r109 = this.f216312d;
        if (r109 == null) goto L47;
        r109.getIndicatorConfig().f216345f = r108;
    L47:
        int r110 = this.f216332x;
        if (r110 <= 0) goto L52;
        qv4.a r111 = this.f216312d;
        if (r111 == null) goto L52;
        r111.getIndicatorConfig().f216349j = r110;
    L52:
        int r112 = this.f216333y;
        if (r112 <= 0) goto L57;
        qv4.a r113 = this.f216312d;
        if (r113 == null) goto L57;
        r113.getIndicatorConfig().f216348i = r112;
    L57:
        int r114 = this.f216323o;
        qv4.a r115 = this.f216312d;
        if (r115 == null) goto L60;
        r115.getIndicatorConfig().f216346g = r114;
    L60:
        int r116 = this.f216324p;
        qv4.a r117 = this.f216312d;
        if (r117 == null) goto L64;
        r117.getIndicatorConfig().f216347h = r116;
    L64:
        if (this.f216312d == null) goto L68;
        int r118 = rv4.a.b(this.f216315g, getCurrentItem(), getRealCount());
        this.f216312d.b(getRealCount(), r118);
        return;
    L68:
        return;
    L16:
        int r119 = this.f216328t;
        if (r119 == 0) goto L19;
    L24:
        b(new IndicatorConfig.a(r119, this.f216329u, this.f216330v, this.f216331w));
        goto L25
    L19:
        if (this.f216329u != 0) goto L24;
        if (this.f216330v != 0) goto L24;
        if (this.f216331w == 0) goto L25;
        goto L24
    }

    public final void c() {
        if (this.f216316h == false) goto L6;
        d();
        postDelayed(this.f216310b, this.f216317i);
        return;
    }

    public final void d() {
        if (this.f216316h == false) goto L6;
        removeCallbacks(this.f216310b);
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
        return this.f216311c;
    }

    public qv4.a getIndicator() {
        return this.f216312d;
    }

    public int getScrollTime() {
        return this.f216318j;
    }

    public ViewPager2 getViewPager2() {
        return this.f216309a;
    }

    public Banner(Context r100) {
        this(r100, null);
    }

    private void setRecyclerViewPadding(int r100) {
        RecyclerView r101 = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() != 1) goto L5;
        r101.setPadding(0, r100, 0, r100);
    L6:
        r101.setClipToPadding(false);
        return;
    L5:
        r101.setPadding(r100, 0, r100, 0);
        goto L6
    }

    public final void b(IndicatorConfig.a r100) {
        qv4.a r101 = this.f216312d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getIndicatorConfig().f216351l == false) goto L9;
        this.f216312d.getIndicatorConfig().f216350k = r100;
        this.f216312d.getIndicatorView().requestLayout();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        if (this.f216320l <= 0.0f) goto L5;
        r100.saveLayer(new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight()), this.F, 31);
        super.dispatchDraw(r100);
        Path r101 = new Path();
        r101.moveTo(0.0f, this.f216320l);
        r101.lineTo(0.0f, 0.0f);
        r101.lineTo(this.f216320l, 0.0f);
        float r102 = this.f216320l * 2.0f;
        r101.arcTo(new RectF(0.0f, 0.0f, r102, r102), -90.0f, -90.0f);
        r101.close();
        r100.drawPath(r101, this.E);
        int r103 = getWidth();
        Path r104 = new Path();
        float r105 = r103;
        r104.moveTo(r105 - this.f216320l, 0.0f);
        r104.lineTo(r105, 0.0f);
        r104.lineTo(r105, this.f216320l);
        float r106 = this.f216320l * 2.0f;
        r104.arcTo(new RectF(r105 - r106, 0.0f, r105, r106), 0.0f, -90.0f);
        r104.close();
        r100.drawPath(r104, this.E);
        int r107 = getHeight();
        Path r108 = new Path();
        float r109 = r107;
        r108.moveTo(0.0f, r109 - this.f216320l);
        r108.lineTo(0.0f, r109);
        r108.lineTo(this.f216320l, r109);
        float r110 = this.f216320l * 2.0f;
        r108.arcTo(new RectF(0.0f, r109 - r110, r110, r109), 90.0f, 90.0f);
        r108.close();
        r100.drawPath(r108, this.E);
        int r111 = getHeight();
        int r112 = getWidth();
        Path r113 = new Path();
        float r114 = r112;
        float r115 = r111;
        r113.moveTo(r114 - this.f216320l, r115);
        r113.lineTo(r114, r115);
        r113.lineTo(r114, r115 - this.f216320l);
        float r116 = this.f216320l * 2.0f;
        r113.arcTo(new RectF(r114 - r116, r115 - r116, r114, r115), 0.0f, 90.0f);
        r113.close();
        r100.drawPath(r113, this.E);
        r100.restore();
        return;
    L5:
        super.dispatchDraw(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (getViewPager2().isUserInputEnabled() == false) goto L5;
        int r101 = r100.getActionMasked();
        if (r101 != 1) goto L9;
    L15:
        c();
    L17:
        return super.dispatchTouchEvent(r100);
    L9:
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L15;
        if (r101 != 0) goto L17;
        d();
        goto L17
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        if (getViewPager2() != null) goto L5;
    L7:
        d();
        return;
    L5:
        if (this.f216314f == null) goto L7;
        getViewPager2().unregisterOnPageChangeCallback(this.f216314f);
        this.f216314f = null;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (getViewPager2().isUserInputEnabled() == false) goto L38;
        if (this.D == false) goto L38;
        int r101 = r100.getAction();
        boolean r102 = true;
        if (r101 != 0) goto L10;
        this.A = r100.getX();
        this.B = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L36:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r101 != 1) goto L12;
    L33:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L36
    L12:
        if (r101 != 2) goto L14;
        float r103 = r100.getX();
        float r104 = r100.getY();
        float r105 = Math.abs(r103 - this.A);
        float r106 = Math.abs(r104 - this.B);
        if (getViewPager2().getOrientation() != 0) goto L26;
        if (r105 > this.f216334z) goto L21;
    L23:
        r102 = false;
    L24:
        this.C = r102;
    L32:
        getParent().requestDisallowInterceptTouchEvent(this.C);
        goto L36
    L21:
        if (r105 <= r106) goto L23;
    L26:
        if (r106 > this.f216334z) goto L28;
    L30:
        r102 = false;
    L31:
        this.C = r102;
        goto L32
    L28:
        if (r106 <= r105) goto L30;
    L14:
        if (r101 == 3) goto L33;
    L38:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver
    public final void onStart(LifecycleOwner r100) {
        c();
    }

    @Override // com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserver
    public final void onStop(LifecycleOwner r100) {
        d();
    }

    public Banner(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public Banner(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f216315g = true;
        this.f216316h = true;
        this.f216317i = 3000;
        this.f216318j = 600;
        this.f216319k = 1;
        this.f216320l = 0.0f;
        this.f216321m = pv4.a.f530813a;
        this.f216322n = pv4.a.f530814b;
        this.f216323o = -1996488705;
        this.f216324p = -1;
        this.f216325q = 1;
        this.f216332x = pv4.a.f530817e;
        this.f216333y = pv4.a.f530818f;
        this.D = true;
        this.G = new a(this);
        this.f216334z = ViewConfiguration.get(r110).getScaledTouchSlop() / 2;
        this.f216313e = new CompositePageTransformer();
        this.f216314f = new c(this);
        this.f216310b = new b(this);
        ViewPager2 r100 = new ViewPager2(r110);
        this.f216309a = r100;
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f216309a.setOffscreenPageLimit(1);
        this.f216309a.registerOnPageChangeCallback(this.f216314f);
        this.f216309a.setPageTransformer(this.f216313e);
        if (getScrollTime() >= 100) goto L23;
    L15:
        addView(this.f216309a);
        Paint r101 = new Paint();
        this.E = r101;
        r101.setColor(-1);
        this.E.setAntiAlias(true);
        this.E.setStyle(Paint.Style.FILL);
        this.E.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint r102 = new Paint();
        this.F = r102;
        r102.setXfermode(null);
        if (r111 == null) goto L25;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.banner_auto_loop, R.attr.banner_indicator_gravity, R.attr.banner_indicator_height, R.attr.banner_indicator_margin, R.attr.banner_indicator_marginBottom, R.attr.banner_indicator_marginLeft, R.attr.banner_indicator_marginRight, R.attr.banner_indicator_marginTop, R.attr.banner_indicator_normal_color, R.attr.banner_indicator_normal_width, R.attr.banner_indicator_radius, R.attr.banner_indicator_selected_color, R.attr.banner_indicator_selected_width, R.attr.banner_indicator_space, R.attr.banner_infinite_loop, R.attr.banner_loop_time, R.attr.banner_orientation, R.attr.banner_radius});
        this.f216320l = r113.getDimensionPixelSize(17, 0);
        this.f216317i = r113.getInt(15, 3000);
        this.f216316h = r113.getBoolean(0, true);
        this.f216315g = r113.getBoolean(14, true);
        this.f216321m = r113.getDimensionPixelSize(9, pv4.a.f530813a);
        this.f216322n = r113.getDimensionPixelSize(12, pv4.a.f530814b);
        this.f216323o = r113.getColor(8, -1996488705);
        this.f216324p = r113.getColor(11, -1);
        this.f216325q = r113.getInt(1, 1);
        this.f216326r = r113.getDimensionPixelSize(13, 0);
        this.f216327s = r113.getDimensionPixelSize(3, 0);
        this.f216328t = r113.getDimensionPixelSize(5, 0);
        this.f216329u = r113.getDimensionPixelSize(7, 0);
        this.f216330v = r113.getDimensionPixelSize(6, 0);
        this.f216331w = r113.getDimensionPixelSize(4, 0);
        this.f216332x = r113.getDimensionPixelSize(2, pv4.a.f530817e);
        this.f216333y = r113.getDimensionPixelSize(10, pv4.a.f530818f);
        getViewPager2().setOrientation(r113.getInt(16, 0));
        boolean r114 = this.f216315g;
        if (r114 == true) goto L21;
        this.f216316h = false;
    L21:
        this.f216319k = r114 ? 1 : 0;
        r113.recycle();
        return;
    L25:
        return;
    L23:
        ViewPager2 r103 = getViewPager2();     // Catch: Exception -> L13
        RecyclerView r104 = (RecyclerView) r103.getChildAt(0);     // Catch: Exception -> L13
        r104.setOverScrollMode(2);     // Catch: Exception -> L13
        ScrollSpeedManger r105 = new ScrollSpeedManger(this, (LinearLayoutManager) r104.getLayoutManager());     // Catch: Exception -> L13
        r104.setLayoutManager(r105);     // Catch: Exception -> L13
        Field r106 = ViewPager2.class.getDeclaredField("mLayoutManager");     // Catch: Exception -> L13
        r106.setAccessible(true);     // Catch: Exception -> L13
        r106.set(r103, r105);     // Catch: Exception -> L13
        Field r107 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");     // Catch: Exception -> L13
        r107.setAccessible(true);     // Catch: Exception -> L13
        Object r108 = r107.get(r103);     // Catch: Exception -> L13
        if (r108 == null) goto L9;
        Field r109 = r108.getClass().getDeclaredField("mLayoutManager");     // Catch: Exception -> L13
        r109.setAccessible(true);     // Catch: Exception -> L13
        r109.set(r108, r105);     // Catch: Exception -> L13
    L9:
        Field r115 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");     // Catch: Exception -> L13
        r115.setAccessible(true);     // Catch: Exception -> L13
        Object r116 = r115.get(r103);     // Catch: Exception -> L13
        if (r116 == null) goto L15;
        Field r117 = r116.getClass().getDeclaredField("mLayoutManager");     // Catch: Exception -> L13
        r117.setAccessible(true);     // Catch: Exception -> L13
        r117.set(r116, r105);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
