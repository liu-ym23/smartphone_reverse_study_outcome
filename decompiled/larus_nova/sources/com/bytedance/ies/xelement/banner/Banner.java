package com.bytedance.ies.xelement.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    public final BannerViewPager A;
    public final LinearLayout B;
    public b C;
    public ViewPager.OnPageChangeListener D;
    public boolean E;
    public final List<LynxUI> F;
    public final a G;
    public Method H;
    public Field I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f249774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f249775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f249776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f249777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f249779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f249781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f249782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f249783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f249784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f249785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f249786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f249787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f249788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f249789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f249790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f249791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f249792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f249793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f249794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f249795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f249796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f249797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f249798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<View> f249799z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Banner f249800a;

        public final void a() {
            Banner r100 = this.f249800a;
            if (r100.f249789p == true) goto L5;
            return;
        L5:
            if (r100.f249788o == true) goto L7;
            int r101 = r100.A.getCurrentItem() + 1;
            if (r101 < this.f249800a.A.getAdapter().getCount()) goto L30;
            this.f249800a.A.setCurrentItem(0, false);
            Banner r102 = this.f249800a;
            r102.postDelayed(r102.G, r102.f249778e);
            return;
        L30:
            Banner r103 = this.f249800a;
            r103.A.setCurrentItem(r101, r103.f249792s);
            Banner r104 = this.f249800a;
            r104.postDelayed(r104.G, r104.f249778e);
            return;
        L7:
            if (r100.f249786m.equals("coverflow") == false) goto L9;
        L12:
            boolean r105 = true;
        L13:
            int r106 = ((CopyOnWriteArrayList) this.f249800a.F).size();
            if (this.f249800a.d() == false) goto L16;
            int r107 = 2;
        L18:
            if (r106 > 5) goto L20;
            if (r105 == false) goto L20;
            return;
        L20:
            if (r106 < r107) goto L32;
            int r108 = this.f249800a.A.getCurrentItem() + 1;
            Banner r109 = this.f249800a;
            int r110 = r109.f249774a;
            if (r108 < r110) goto L25;
            r109.A.setCurrentItem(r110 / 2, false);
        L26:
            Banner r111 = this.f249800a;
            r111.postDelayed(r111.G, r111.f249778e);
            return;
        L25:
            r109.A.setCurrentItem(r108, r109.f249792s);
            goto L26
        L32:
            return;
        L16:
            r107 = 3;
            goto L18
        L9:
            if (this.f249800a.f249786m.equals("flat-coverflow") == true) goto L12;
            r105 = false;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Banner r100) {
            this.f249800a = r100;
        }
    }

    public class b extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Banner f249801a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            Banner r100 = this.f249801a;
            if (r100.f249788o == false) goto L6;
            return r100.f249774a;
        L6:
            return ((CopyOnWriteArrayList) r100.F).size();
        }

        public b(Banner r100) {
            this.f249801a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int r100) {
            if (this.f249801a.f249786m.equals("multi-pages") == false) goto L10;
            Banner r101 = this.f249801a;
            int r102 = r101.f249798y;
            if (r102 != 0) goto L8;
            return 1.0f;
        L8:
            return r101.f249785l / r102;
        L10:
            if (this.f249801a.f249786m.equals("carousel") == false) goto L13;
            return 0.8f;
        L13:
            return 1.0f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            int r102 = this.f249801a.j(r101);
            Banner r103 = this.f249801a;
            if (((CopyOnWriteArrayList) r103.F).size() != 0) goto L5;
            View r104 = new View(r103.getContext());
        L25:
            r100.addView(r104);
            return r104;
        L5:
            LynxUI r105 = (LynxUI) ListProtector.get(r103.F, r102);
            View r106 = r105.getView();
            FrameLayout r107 = new FrameLayout(r103.getContext());
            if ((r106 instanceof ViewGroup) == false) goto L13;
            if (r105.getOverflow() != 0) goto L10;
            boolean r108 = true;
        L11:
            r107.setClipChildren(r108);
            goto L13
        L10:
            r108 = false;
        L13:
            if ((r106.getParent() instanceof ViewGroup) == false) goto L16;
            ((ViewGroup) r106.getParent()).removeView(r106);
        L16:
            if (r103.E == false) goto L18;
            r106.setTag("swiper_lynx_view_tag");
        L18:
            r107.addView(r106);
            View r109 = new View(r103.getContext());
            r107.addView(r109, new FrameLayout.LayoutParams(-1, -1));
            if (r103.f249791r == true) goto L22;
            r109.setBackgroundColor(r103.f249793t);
            r109.setTag("swiper_item_mask_tag");
        L22:
            if (r103.E == false) goto L24;
            r107.setTag(Integer.valueOf(r101));
        L24:
            r104 = r107;
            goto L25
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            r100.removeView((View) r102);
        }
    }

    public class c extends Scroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Banner f249802a;

        public c(Banner r100, Context r101) {
            this.f249802a = r100;
            super(r101);
        }

        @Override // android.widget.Scroller
        public final void startScroll(int r100, int r101, int r110, int r111) {
            super.startScroll(r100, r101, r110, r111, this.f249802a.f249779f);
        }

        @Override // android.widget.Scroller
        public final void startScroll(int r100, int r101, int r102, int r110, int r111) {
            super.startScroll(r100, r101, r102, r110, this.f249802a.f249779f);
        }
    }

    public final void c() {
        if (this.C == null) goto L19;
        Iterator r100 = ((ArrayList) this.f249799z).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((View) r100.next()).setBackground(a(this.f249795v));
        goto L6
    L8:
        int r101 = this.f249796w;
        if (r101 >= 0) goto L11;
    L13:
        int r102 = 0;
    L15:
        if (((ArrayList) this.f249799z).size() <= 0) goto L20;
        ((View) ListProtector.get(this.f249799z, r102)).setBackground(a(this.f249794u));
        this.f249797x = this.A.getCurrentItem();
        return;
    L20:
        return;
    L11:
        if (r101 >= ((ArrayList) this.f249799z).size()) goto L13;
        r102 = this.f249796w;
        goto L15
    }

    public final boolean d() {
        if (this.E == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f249788o == false) goto L11;
        if ("normal".equals(this.f249786m) == false) goto L11;
        if (((CopyOnWriteArrayList) this.F).size() != 2) goto L11;
        return true;
    }

    public final void e() {
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.I != null) goto L5;
        Field r100 = ViewPager.class.getDeclaredField("mFirstLayout");     // Catch: Throwable -> L7
        this.I = r100;     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
    L5:
        this.I.set(this.A, Boolean.TRUE);     // Catch: Throwable -> L7
    }

    public final void h() {
        f(this.f249786m, this.f249780g, this.f249781h, this.f249782i);
        boolean r100 = this.f249790q;
        this.f249790q = r100;
        BannerViewPager r101 = this.A;
        if (r101 == null) goto L6;
        r101.setScrollable(r100);
    L6:
        if (this.C != null) goto L8;
        this.C = new b(this);
        this.A.addOnPageChangeListener(this);
        this.A.setAdapter(this.C);
    L8:
        int r102 = this.f249796w;
        if (r102 >= 0) goto L11;
    L12:
        this.f249796w = 0;
    L14:
        if (this.f249788o == false) goto L16;
        int r103 = (this.f249774a / 2) + this.f249796w;
    L17:
        boolean r104 = this.f249792s;
        e();     // Catch: Throwable -> L23
        if (this.H != null) goto L21;
        Class r105 = Boolean.TYPE;     // Catch: Throwable -> L23
        Method r106 = ViewPager.class.getDeclaredMethod("setCurrentItemInternal", new Class[]{Integer.TYPE, r105, r105});     // Catch: Throwable -> L23
        this.H = r106;     // Catch: Throwable -> L23
        r106.setAccessible(true);     // Catch: Throwable -> L23
    L21:
        this.H.invoke(this.A, new Object[]{Integer.valueOf(r103), Boolean.valueOf(r104), Boolean.TRUE});     // Catch: Throwable -> L23
    L26:
        if (this.f249789p == false) goto L31;
        i();
        return;
    L31:
        return;
    L23:
        th = move-exception;
        th.printStackTrace();
        this.A.setCurrentItem(r103, r104);
        goto L26
    L16:
        r103 = this.f249796w;
        goto L17
    L11:
        if (r102 < ((CopyOnWriteArrayList) this.F).size()) goto L14;
        goto L12
    }

    public final void i() {
        removeCallbacks(this.G);
        postDelayed(this.G, this.f249778e);
    }

    public Banner(Context r100) {
        this(r100, null);
    }

    public final GradientDrawable a(int r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(1);
        r101.setColor(r100);
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f249789p == false) goto L15;
        int r101 = r100.getAction();
        if (r101 != 1) goto L7;
    L13:
        i();
        goto L15
    L7:
        if (r101 == 3) goto L13;
        if (r101 == 4) goto L13;
        if (r101 != 0) goto L15;
        removeCallbacks(this.G);
    L15:
        return super.dispatchTouchEvent(r100);
    }

    public final void g(int r100) {
        this.f249796w = r100;
        if (j(this.A.getCurrentItem()) != r100) goto L9;
        b r101 = this.C;
        if (r101 == null) goto L9;
        if (r101.getCount() <= 0) goto L9;
        return;
    L9:
        b r102 = this.C;
        if (r102 != null) goto L12;
    L14:
        this.A.postDelayed(new h76.b(this), 200);
        return;
    L12:
        if (r100 >= r102.getCount()) goto L14;
        this.A.post(new h76.a(this, r100));
    }

    public final int j(int r100) {
        if (((CopyOnWriteArrayList) this.F).size() != 0) goto L6;
        return r100;
    L6:
        if (this.f249788o == false) goto L14;
        int r101 = r100 - (this.f249774a / 2);
        int r102 = Math.abs(r101) % ((CopyOnWriteArrayList) this.F).size();
        if (r101 >= 0) goto L13;
        if (r102 != 0) goto L12;
        return r102;
    L12:
        return ((CopyOnWriteArrayList) this.F).size() - r102;
    L13:
        return r102;
    L14:
        return r100;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        ViewPager.OnPageChangeListener r101 = this.D;
        if (r101 == null) goto L6;
        r101.onPageScrollStateChanged(r100);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        ViewPager.OnPageChangeListener r101 = this.D;
        if (r101 == null) goto L6;
        r101.onPageSelected(j(r100));
    L6:
        if (this.f249787n == false) goto L27;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(this.f249776c, this.f249777d);
        int r103 = this.f249775b;
        r102.leftMargin = r103;
        r102.rightMargin = r103;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(this.f249776c, this.f249777d);
        int r105 = this.f249775b;
        r104.leftMargin = r105;
        r104.rightMargin = r105;
        int r106 = j(this.f249797x);
        int r107 = j(r100);
        boolean r108 = false;
        if (((CopyOnWriteArrayList) this.F).size() != 0) goto L11;
        r107 = 0;
    L11:
        if (((ArrayList) this.f249799z).isEmpty() == true) goto L28;
        List<View> r109 = this.f249799z;
        if (r106 >= 0) goto L15;
    L17:
        boolean r110 = false;
    L18:
        if (r110 == false) goto L29;
        List<View> r111 = this.f249799z;
        if (r107 >= 0) goto L22;
    L24:
        if (r108 == false) goto L30;
        ((View) ListProtector.get(this.f249799z, r106)).setBackground(a(this.f249795v));
        ((View) ListProtector.get(this.f249799z, r106)).setLayoutParams(r104);
        ((View) ListProtector.get(this.f249799z, r107)).setBackground(a(this.f249794u));
        ((View) ListProtector.get(this.f249799z, r107)).setLayoutParams(r102);
        this.f249797x = r100;
        return;
    L30:
        return;
    L22:
        if (r107 >= ((ArrayList) r111).size()) goto L24;
        r108 = true;
        goto L24
    L29:
        return;
    L15:
        if (r106 >= ((ArrayList) r109).size()) goto L17;
        r110 = true;
        goto L18
    L28:
        return;
    }

    public void setLayerTextureType(int r100) {
        this.A.setLayerType(r100, null);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.D = r100;
    }

    public void setOverflow(int r100) {
        boolean r101 = false;
        if (r100 != 0) goto L5;
        this.A.setLayerType(0, null);
    L5:
        if (r100 == 0) goto L7;
        r101 = true;
    L7:
        setClipChildren(r101);
    }

    public void setTwoItemCircularSwipe(boolean r100) {
        this.E = r100;
    }

    public Banner(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(int r100, View r101) {
        if ((r101 instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        if (r101.findViewWithTag("swiper_lynx_view_tag") == null) goto L7;
        return;
    L7:
        int r102 = j(r100);
        if (r102 < 0) goto L17;
        List<LynxUI> r103 = this.F;
        if (r103 == null) goto L17;
        if (((CopyOnWriteArrayList) r103).size() == 0) goto L17;
        if (r102 >= ((CopyOnWriteArrayList) this.F).size()) goto L17;
        View r104 = ((LynxUI) ListProtector.get(this.F, r102)).getView();
    L18:
        if (r104 != null) goto L21;
        return;
    L21:
        if ((r104.getParent() instanceof ViewGroup) == false) goto L23;
        ((ViewGroup) r104.getParent()).removeView(r104);
    L23:
        ((ViewGroup) r101).addView(r104);
        return;
    L17:
        r104 = null;
        goto L18
    }

    public Banner(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f249774a = 5000;
        this.f249775b = 5;
        this.f249776c = 20;
        this.f249777d = 20;
        this.f249778e = 5000;
        this.f249779f = 500;
        this.f249780g = 10;
        this.f249781h = -1;
        this.f249782i = -1;
        this.f249783j = -1;
        this.f249784k = -1;
        this.f249785l = 1;
        this.f249786m = "normal";
        this.f249787n = true;
        this.f249788o = true;
        this.f249789p = true;
        this.f249790q = true;
        this.f249791r = true;
        this.f249792s = true;
        this.f249793t = Color.argb(128, 0, 0, 0);
        this.f249794u = Color.argb(255, 255, 255, 255);
        this.f249795v = Color.argb(89, 255, 255, 255);
        this.f249796w = 0;
        this.f249797x = 0;
        this.f249798y = 0;
        this.E = false;
        this.F = new CopyOnWriteArrayList();
        this.G = new a(this);
        this.f249799z = new ArrayList();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.x_swiper_banner, this, true);
        BannerViewPager r104 = (BannerViewPager) r103.findViewById(R.id.bannerViewPager);
        this.A = r104;
        this.B = (LinearLayout) r103.findViewById(R.id.circleIndicator);
        Field r105 = ViewPager.class.getDeclaredField("mScroller");     // Catch: Exception -> L5
        r105.setAccessible(true);     // Catch: Exception -> L5
        r105.set(r104, new c(this, r104.getContext()));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LLog.e("Banner", e.getMessage());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        if (d() == false) goto L7;
        b(r100, findViewWithTag(Integer.valueOf(r100)));
        if (r101 <= 0.0f) goto L7;
        int r103 = r100 + 1;
        b(r103, findViewWithTag(Integer.valueOf(r103)));
    L7:
        ViewPager.OnPageChangeListener r104 = this.D;
        if (r104 == null) goto L11;
        r104.onPageScrolled(j(r100), r101, r102);
    L11:
        if (this.f249791r == false) goto L13;
        return;
    L13:
        if (this.F == null) goto L65;
        int r105 = j(r100);
        View r106 = null;
        if (r105 < 0) goto L26;
        List<LynxUI> r107 = this.F;
        if (r107 == null) goto L26;
        if (((CopyOnWriteArrayList) r107).size() == 0) goto L26;
        if (r105 >= ((CopyOnWriteArrayList) this.F).size()) goto L26;
        View r108 = ((LynxUI) ListProtector.get(this.F, r105)).getView();
        if (r108 == null) goto L26;
        View r109 = r108.findViewWithTag("swiper_item_mask_tag");
    L27:
        if (r105 < 0) goto L41;
        List<LynxUI> r110 = this.F;
        if (r110 == null) goto L41;
        if (((CopyOnWriteArrayList) r110).size() == 0) goto L41;
        if (r105 >= ((CopyOnWriteArrayList) this.F).size()) goto L41;
        int r111 = ((CopyOnWriteArrayList) this.F).size();
        if (r105 != 0) goto L38;
        View r112 = ((LynxUI) ListProtector.get(this.F, r111 - 1)).getView();
    L39:
        if (r112 == null) goto L41;
        View r113 = r112.findViewWithTag("swiper_item_mask_tag");
    L42:
        if (r105 < 0) goto L56;
        List<LynxUI> r114 = this.F;
        if (r114 == null) goto L56;
        if (((CopyOnWriteArrayList) r114).size() == 0) goto L56;
        if (r105 >= ((CopyOnWriteArrayList) this.F).size()) goto L56;
        if (r105 != (((CopyOnWriteArrayList) this.F).size() - 1)) goto L53;
        View r115 = ((LynxUI) ListProtector.get(this.F, 0)).getView();
    L54:
        if (r115 == null) goto L56;
        r106 = r115.findViewWithTag("swiper_item_mask_tag");
        goto L56
    L53:
        r115 = ((LynxUI) ListProtector.get(this.F, r105 + 1)).getView();
    L56:
        if (r109 == null) goto L59;
        r109.setAlpha(r101);
    L59:
        if (r113 == null) goto L61;
        r113.setAlpha(1.0f - r101);
    L61:
        if (r106 == null) goto L66;
        r106.setAlpha(1.0f - r101);
        return;
    L66:
        return;
    L38:
        r112 = ((LynxUI) ListProtector.get(this.F, r105 - 1)).getView();
    L41:
        r113 = null;
    L26:
        r109 = null;
        goto L27
    }

    public final void f(String r100, int r101, int r102, int r103) {
        b r104 = this.C;
        if (r104 == null) goto L6;
        r104.notifyDataSetChanged();
    L6:
        if (r100.equals("coverflow") == false) goto L8;
    L22:
        this.A.setClipToPadding(false);
        int r105 = this.f249798y / 5;
        if (r102 < 0) goto L26;
        if (r103 < 0) goto L26;
        this.A.setPadding(r102 + r101, 0, r103 + r101, 0);
    L27:
        this.A.setPageMargin(r101);
        this.A.setOffscreenPageLimit(2);
        if (r100.equals("coverflow") == false) goto L33;
        this.A.setPageTransformer(false, new CoverFlowTransformer());
        return;
    L33:
        return;
    L26:
        this.A.setPadding(r105, 0, r105, 0);
        goto L27
    L8:
        if (r100.equals("flat-coverflow") == true) goto L22;
        if (r100.equals("multi-pages") == false) goto L18;
        this.A.setClipToPadding(false);
        int r106 = this.f249783j;
        if (r106 < 0) goto L17;
        int r107 = this.f249784k;
        if (r107 < 0) goto L17;
        this.A.setPadding(r106, 0, r107, 0);
    L17:
        this.A.setPageMargin(r101);
        this.A.setOffscreenPageLimit(1);
        return;
    L18:
        this.A.setPageMargin(r101);
        ViewGroup.LayoutParams r108 = this.A.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r109.leftMargin = 0;
        r109.rightMargin = 0;
    L21:
        this.A.setOffscreenPageLimit(1);
        this.A.setPageTransformer(false, null);
    }
}
