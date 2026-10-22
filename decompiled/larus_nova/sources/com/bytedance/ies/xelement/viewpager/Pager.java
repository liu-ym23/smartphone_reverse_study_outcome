package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.tabbar.LynxTabLayout;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import x6a.i;

/* JADX INFO: loaded from: classes19.dex */
public abstract class Pager<T extends BaseCustomViewPager> extends LinearLayout implements x6a.e {
    public boolean A;
    public int B;
    public final HashMap<View, c> C;
    public final HashSet<a> D;
    public final int[] E;
    public final Rect F;
    public final Rect G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public d f250464J;
    public String K;
    public String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f250465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxTabBarView f250466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f250467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f250468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f250469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f250470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pager<T>.Adapter f250471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f250472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f250473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<LynxViewpagerItem> f250474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<LynxViewpagerItem> f250475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i f250476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f250477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TabLayout f250478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f250479o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f250480p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f250481q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f250482r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f250483s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f250484t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f250485u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f250486v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f250487w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f f250488x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f250489y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f250490z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/Pager$Adapter;", "Landroidx/viewpager/widget/PagerAdapter;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
    public final class Adapter extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pager<T> f250491a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return ((ArrayList) this.f250491a.f250474j).size();
        }

        public Adapter(Pager r100) {
            this.f250491a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "object");
            int r101 = CollectionsKt.indexOf(this.f250491a.f250474j, r100);
            if (r101 != (-1)) goto L6;
            return -2;
        L6:
            return r101;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            if (r100 > (this.f250491a.getMTabLayoutTitles().size() - 1)) goto L9;
            Pager<T> r101 = this.f250491a;
            if (r101.f250479o != 1) goto L8;
            return null;
        L8:
            return (CharSequence) ListProtector.get(r101.getMTabLayoutTitles(), r100);
        L9:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View] */
        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            LynxViewpagerItem r102 = (LynxViewpagerItem) ListProtector.get(this.f250491a.f250474j, r101);
            ViewGroup r103 = (ViewGroup) ((s86.f) r102.getView()).getParent();
            if (r103 == 0) goto L5;
            r103.removeView(r102.getView());
        L5:
            r100.addView(r102.getView());
            r102.M(true, r101);
            return r102;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            if ((r101 instanceof LynxViewpagerItem) == true) goto L5;
            return false;
        L5:
            if (r100 != ((LynxViewpagerItem) r101).getView()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, "object");
            if ((r102 instanceof LynxViewpagerItem) == false) goto L6;
            LynxViewpagerItem r103 = (LynxViewpagerItem) r102;
            r100.removeView(r103.getView());
            r103.M(false, r101);
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f250492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f250493b;

        public final int hashCode() {
            return this.f250492a << (this.f250493b + 16);
        }

        public final boolean equals(Object r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (this != r100) goto L9;
            return true;
        L9:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (r101.f250492a == this.f250492a) goto L13;
            return false;
        L13:
            if (r101.f250493b != this.f250493b) goto L18;
            return true;
        L18:
            return false;
        L16:
            return false;
        }

        public a(int r100, int r101) {
            this.f250492a = r100;
            this.f250493b = r101;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f250494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f250495b;

        public c() {
            this(0, 3);
        }

        public c(int r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = -1;
        L5:
            this.f250494a = r100;
            this.f250495b = false;
        }
    }

    public interface d {
        void a(int r100, String r101);
    }

    public interface e {
        void a(TabLayout.Tab r100);
    }

    public interface f {
        void a(TabLayout r100, boolean r101);
    }

    public interface g {
        void a(boolean r100);
    }

    public static final class h implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pager<T> f250496a;

        public h(Pager<T> r100) {
            this.f250496a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            if (r100 == null) goto L8;
            c r101 = this.f250496a.C.get(r100);
            if (r101 == null) goto L9;
            r101.f250495b = true;
            return;
        L9:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            if (r100 == null) goto L8;
            c r101 = this.f250496a.C.get(r100);
            if (r101 == null) goto L9;
            r101.f250495b = false;
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        x6a.d.a(this, r100, r101);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r100) {
        x6a.d.b(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r100) {
        x6a.d.c(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return x6a.d.d(this, r100);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    public abstract void setTabBarElementAdded(boolean r100);

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final void a() {
        Drawable r100 = null;
        if (this.f250478n != null) goto L5;
        b(null);
    L5:
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L8;
        r100 = r101.getBackground();
    L8:
        if (r100 != null) goto L18;
        TabLayout r102 = this.f250478n;
        if (r102 == null) goto L12;
        r102.setBackgroundResource(R.drawable.lynx_tab_line_bg);
    L12:
        TabLayout r103 = this.f250478n;
        if (r103 == null) goto L19;
        Drawable r104 = r103.getBackground();
        if (r104 == null) goto L20;
        r104.mutate();
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void c() {
        HashSet r100 = new HashSet();
        ArrayList r101 = new ArrayList();
        Iterator<View> r102 = this.C.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        View r103 = r102.next();
        c r104 = this.C.get(r103);
        if (r104 == null) goto L4;
        if (r103.isShown() == false) goto L4;
        if (r104.f250495b == false) goto L4;
        this.G.set(0, 0, r103.getWidth(), r103.getHeight());
        r103.getLocationOnScreen(this.E);
        Rect r105 = this.G;
        int[] r106 = this.E;
        r105.offset(r106[0], r106[1]);
        if (this.G.intersect(this.F) == false) goto L4;
        a r107 = new a(this.I, r104.f250494a);
        r100.add(r107);
        if (this.D.contains(r107) == true) goto L4;
        r101.add(r107);
        goto L4
    L16:
        this.D.removeAll(r100);
        Iterator<a> r108 = this.D.iterator();
    L17:
        String r109 = "";
        if (r108.hasNext() == false) goto L26;
        a r110 = r108.next();
        LLog.i("Foldview#BaseViewPagerImpl", "disappear: [sign, position] = [" + r110.f250492a + ", " + r110.f250493b);
        d r111 = this.f250464J;
        if (r111 == null) goto L17;
        int r112 = r110.f250493b;
        String r113 = this.L;
        if (r113 == null) goto L25;
        r109 = r113;
    L25:
        r111.a(r112, r109);
        goto L17
    L26:
        this.D.clear();
        this.D.addAll(r100);
        Iterator r114 = r101.iterator();
    L28:
        if (r114.hasNext() == false) goto L35;
        a r115 = (a) r114.next();
        LLog.i("Foldview#BaseViewPagerImpl", "appear: [sign, position] = [" + r115.f250492a + ", " + r115.f250493b);
        d r116 = this.f250464J;
        if (r116 == null) goto L28;
        int r117 = r115.f250493b;
        String r118 = this.K;
        if (r118 != null) goto L34;
        r118 = "";
    L34:
        r116.a(r117, r118);
        goto L28
    }

    public final void d() {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return;
    L6:
        if (this.f250469e > 0) goto L8;
        return;
    L8:
        if (this.f250467c > 0) goto L10;
        return;
    L10:
        if (this.f250468d <= 0) goto L23;
        int r100 = t86.a.f545052a;
        int r101 = (t86.a.b(getContext()) - this.f250468d) / 2;
        int r102 = this.f250469e - this.f250467c;
        TabLayout r103 = this.f250478n;
        if (r103 == null) goto L15;
        Drawable r104 = r103.getBackground();
    L16:
        if (r104 == null) goto L20;
        ((LayerDrawable) r104).setLayerInset(1, r101, r102, r101, 0);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L15:
        r104 = null;
        goto L16
    }

    public final void g() {
        if (this.f250479o != 1) goto L9;
        LynxTabBarView r100 = this.f250466b;
        if (r100 == null) goto L79;
        r100.O(this.B);
        return;
    L79:
        return;
    L9:
        if (this.f250478n != null) goto L11;
        this.f250465a.setCurrentItem(this.B, false);
    L11:
        this.C.clear();
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L14;
        int r102 = r101.getTabCount();
    L15:
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L72;
        TabLayout r104 = this.f250478n;
        if (r104 == null) goto L71;
        final TabLayout.Tab r105 = r104.getTabAt(r103);
        if (r105 == null) goto L71;
        if (r103 != this.B) goto L26;
        r105.select();
    L26:
        if (r105.getCustomView() != null) goto L71;
        View r106 = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_tab, r105.view, false);
        TextView r107 = (TextView) r106.findViewById(android.R.id.text1);
        r107.setText(r105.getText());
        TabLayout r108 = this.f250478n;
        if (r108 != null) goto L30;
    L32:
        boolean r109 = false;
    L33:
        if (r109 == false) goto L41;
        r107.setTextSize(1, this.f250480p);
        if (this.f250484t == false) goto L37;
        Typeface r110 = Typeface.DEFAULT_BOLD;
    L38:
        r107.setTypeface(r110);
        int r111 = this.f250481q;
        if (r111 == 0) goto L49;
        r107.setTextColor(r111);
    L49:
        if (this.H == false) goto L51;
        r106.addOnAttachStateChangeListener(new h(this));
        this.C.put(r106, new c(r105.getPosition(), 2));
    L51:
        r105.setCustomView(r106);
        r105.view.setBackgroundColor(0);
        int r112 = t86.a.f545052a;
        int r113 = t86.a.a(getContext(), this.f250470f);
        if (this.f250489y != (-1109)) goto L55;
        this.f250489y = r113;
    L55:
        if (this.f250490z != (-1109)) goto L57;
        this.f250490z = r113;
    L57:
        if (r103 != 0) goto L59;
        int r114 = this.f250489y;
    L61:
        if (r103 != (((ArrayList) this.f250477m).size() - 1)) goto L63;
        r113 = this.f250490z;
    L63:
        View r115 = r105.getCustomView();
        if (r115 == null) goto L66;
        ViewCompat.setPaddingRelative(r115, r114, r115.getPaddingTop(), r113, r115.getPaddingBottom());
    L66:
        TabLayout.TabView r116 = r105.view;
        if (r116 == null) goto L70;
        r116.setOnClickListener(new r86.g(this, r105));
        goto L71
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L59:
        r114 = r113;
        goto L61
    L37:
        r110 = Typeface.DEFAULT;
        goto L38
    L41:
        r107.setTextSize(1, this.f250482r);
        if (this.f250485u == false) goto L44;
        Typeface r117 = Typeface.DEFAULT_BOLD;
    L45:
        r107.setTypeface(r117);
        int r118 = this.f250483s;
        if (r118 == 0) goto L49;
        r107.setTextColor(r118);
        goto L49
    L44:
        r117 = Typeface.DEFAULT;
        goto L45
    L30:
        if (r103 != r108.getSelectedTabPosition()) goto L32;
        r109 = true;
    L71:
        r103 = r103 + 1;
        goto L16
    L72:
        return;
    L14:
        r102 = 0;
        goto L15
    }

    public final boolean getMChanged() {
        return this.f250473i;
    }

    public final List<LynxViewpagerItem> getMPendingChildren() {
        return this.f250475k;
    }

    public final LynxTabBarView getMTabBarView() {
        return this.f250466b;
    }

    public final TabLayout getMTabLayout() {
        return this.f250478n;
    }

    public final List<String> getMTabLayoutTitles() {
        return this.f250477m;
    }

    public final T getMViewPager() {
        return this.f250465a;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.f250476l;
    }

    public final int getTabLayoutCodeMode() {
        return this.f250479o;
    }

    public final void b(TabLayout r100) {
        ViewParent r101 = null;
        if (r100 == null) goto L5;
        removeView(this.f250478n);
        TabLayout r102 = this.f250478n;
        if (r102 == null) goto L13;
        r102.setupWithViewPager(null);
    L13:
        this.f250478n = r100;
        ((ArrayList) this.f250477m).clear();
        this.f250479o = 1;
    L14:
        TabLayout r103 = this.f250478n;
        if (r103 == null) goto L17;
        r103.setupWithViewPager(this.f250465a);
    L17:
        this.f250465a.setAdapter(this.f250471g);
        f(this.f250472h);
        TabLayout r104 = this.f250478n;
        if (r104 == null) goto L20;
        r101 = r104.getParent();
    L20:
        if (r101 != null) goto L22;
        addView(this.f250478n, 0);
    L22:
        f r105 = this.f250488x;
        if (r105 == null) goto L26;
        r105.a(this.f250478n, this.A);
        return;
    L26:
        return;
    L5:
        if (this.f250478n == null) goto L7;
        return;
    L7:
        int r106 = LynxTabBarView.f250449k;
        LynxTabLayout r107 = LynxTabBarView.a.a(getContext());
        this.f250478n = r107;
        TabLayout.OnTabSelectedListener r108 = this.f250487w;
        if (r108 == null) goto L14;
        r107.addOnTabSelectedListener(r108);
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        i r101 = this.f250476l;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void f(boolean r100) {
        ReversingAdapter r101 = this.f250465a.getReversingAdapter();
        int r102 = this.f250465a.getCurrentItem();
        this.f250472h = r100;
        this.f250465a.setRTL(r100);
        if (r101 == null) goto L6;
        r101.f250498b = r100;
        r101.notifyDataSetChanged();
    L6:
        if (this.f250479o != 1) goto L10;
        LynxTabBarView r103 = this.f250466b;
        if (r103 == null) goto L11;
        r103.P(0, r102);
    L11:
        this.f250465a.setCurrentItem(r102);
        return;
    L10:
        g();
        goto L11
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        i r101 = this.f250476l;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    L6:
        super.onDraw(r100);
    }

    public final void setAllowHorizontalGesture(boolean r100) {
        this.f250465a.setMAllowHorizontalGesture(r100);
    }

    public final void setBorderHeight(float r100) {
        a();
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L5;
        Drawable r102 = r101.getBackground();
    L6:
        if (r102 == null) goto L14;
        Drawable r103 = ((LayerDrawable) r102).getDrawable(1);
        if (r103 == null) goto L12;
        GradientDrawable r104 = (GradientDrawable) r103;
        int r105 = r104.getIntrinsicWidth();
        int r106 = t86.a.f545052a;
        r104.setSize(r105, t86.a.a(getContext(), r100));
        this.f250467c = t86.a.a(getContext(), r100);
        d();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r102 = null;
        goto L6
    }

    public final void setBorderLineColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        a();
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L5;
        Drawable r102 = r101.getBackground();
    L6:
        if (r102 == null) goto L14;
        Drawable r103 = ((LayerDrawable) r102).getDrawable(1);
        if (r103 == null) goto L12;
        ((GradientDrawable) r103).setColor(t86.a.d(r100));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r102 = null;
        goto L6
    }

    public final void setBorderWidth(float r100) {
        a();
        int r101 = t86.a.f545052a;
        int r102 = (int) (t86.a.b(getContext()) * (r100 / 375.0f));
        TabLayout r103 = this.f250478n;
        if (r103 == null) goto L5;
        Drawable r104 = r103.getBackground();
    L6:
        if (r104 == null) goto L14;
        Drawable r105 = ((LayerDrawable) r104).getDrawable(1);
        if (r105 == null) goto L12;
        GradientDrawable r106 = (GradientDrawable) r105;
        r106.setSize(r102, r106.getIntrinsicHeight());
        this.f250468d = t86.a.a(getContext(), r100);
        d();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r104 = null;
        goto L6
    }

    public final void setCurrentSelectIndex(int r100) {
        this.f250465a.setCurrentItem(r100);
    }

    public final void setKeepItemView(boolean r100) {
        if (r100 == false) goto L4;
        this.f250465a.setOffscreenPageLimit(Integer.MAX_VALUE);
        return;
    L4:
        this.f250465a.setOffscreenPageLimit(1);
    }

    public final void setLynxDirection(int r100) {
        if (r100 == 2) goto L7;
        if (r100 == 2) goto L7;
        boolean r101 = false;
    L9:
        if (r101 == this.f250472h) goto L12;
        f(r101);
        return;
    L12:
        return;
    L7:
        r101 = true;
        goto L9
    }

    public final void setMChanged(boolean r100) {
        this.f250473i = r100;
    }

    public final void setMTabBarView(LynxTabBarView r100) {
        this.f250466b = r100;
    }

    public final void setMTabLayout(TabLayout r100) {
        this.f250478n = r100;
    }

    public final void setMViewPager(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f250465a = r100;
    }

    public final void setRTLMode(boolean r100) {
        this.f250472h = r100;
    }

    @Override // x6a.e
    public void setRenderer(i r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f250476l = r100;
    }

    public final void setSelectedIndex(int r100) {
        this.B = r100;
    }

    public final void setSelectedTabIndicatorColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        if (this.f250478n != null) goto L5;
        b(null);
    L5:
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L9;
        r101.setSelectedTabIndicatorColor(t86.a.d(r100));
        return;
    }

    public final void setSelectedTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        this.f250481q = t86.a.d(r100);
        TabLayout r101 = this.f250478n;
        TabLayout.Tab r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getSelectedTabPosition());
    L6:
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
        TabLayout r105 = this.f250478n;
        if (r105 == null) goto L10;
        r102 = r105.getTabAt(r104);
    L10:
        if (r102 == null) goto L17;
        View r106 = r102.getCustomView();
        if (r106 == null) goto L18;
        TextView r107 = (TextView) r106.findViewById(android.R.id.text1);
        if (r107 == null) goto L19;
        setSelectedTextStyle(r107);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setSelectedTextSize(float r100) {
        this.f250480p = r100;
        TabLayout r101 = this.f250478n;
        TabLayout.Tab r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getSelectedTabPosition());
    L6:
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
        TabLayout r105 = this.f250478n;
        if (r105 == null) goto L10;
        r102 = r105.getTabAt(r104);
    L10:
        if (r102 == null) goto L17;
        View r106 = r102.getCustomView();
        if (r106 == null) goto L18;
        TextView r107 = (TextView) r106.findViewById(android.R.id.text1);
        if (r107 == null) goto L19;
        setSelectedTextStyle(r107);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setSelectedTextStyle(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (this.f250479o == 0) goto L5;
        return;
    L5:
        r100.setTextSize(1, this.f250480p);
        if (this.f250484t == false) goto L8;
        Typeface r101 = Typeface.DEFAULT_BOLD;
    L9:
        r100.setTypeface(r101);
        r100.setTextColor(this.f250481q);
        return;
    L8:
        r101 = Typeface.DEFAULT;
        goto L9
    }

    public final void setTabBarDragEnable(boolean r100) {
        this.A = r100;
    }

    public final void setTabClickListenerListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "tabClickListener");
        this.f250486v = r100;
    }

    public final void setTabIndicatorHeight(float r100) {
        GradientDrawable r101 = null;
        if (this.f250478n != null) goto L5;
        b(null);
    L5:
        TabLayout r102 = this.f250478n;
        if (r102 == null) goto L8;
        Drawable r103 = r102.getTabSelectedIndicator();
    L10:
        if ((r103 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r104 = (LayerDrawable) r103;
    L13:
        if (r104 == null) goto L15;
        Drawable r105 = r104.getDrawable(0);
    L17:
        if ((r105 instanceof GradientDrawable) == false) goto L19;
        r101 = (GradientDrawable) r105;
    L19:
        if (r101 == null) goto L21;
        int r106 = r101.getIntrinsicWidth();
        int r107 = t86.a.f545052a;
        r101.setSize(r106, t86.a.a(getContext(), r100));
    L21:
        TabLayout r108 = this.f250478n;
        if (r108 == null) goto L25;
        r108.requestLayout();
        return;
    L25:
        return;
    L15:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    public final void setTabIndicatorRadius(float r100) {
        GradientDrawable r101 = null;
        if (this.f250478n != null) goto L5;
        b(null);
    L5:
        TabLayout r102 = this.f250478n;
        if (r102 == null) goto L8;
        Drawable r103 = r102.getTabSelectedIndicator();
    L10:
        if ((r103 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r104 = (LayerDrawable) r103;
    L13:
        if (r104 == null) goto L15;
        Drawable r105 = r104.getDrawable(0);
    L17:
        if ((r105 instanceof GradientDrawable) == false) goto L19;
        r101 = (GradientDrawable) r105;
    L19:
        if (r101 == null) goto L22;
        int r106 = t86.a.f545052a;
        r101.setCornerRadius(t86.a.a(getContext(), r100));
    L22:
        TabLayout r107 = this.f250478n;
        if (r107 == null) goto L26;
        r107.requestLayout();
        return;
    L26:
        return;
    L15:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    public final void setTabIndicatorWidth(float r100) {
        GradientDrawable r101 = null;
        if (this.f250478n != null) goto L5;
        b(null);
    L5:
        TabLayout r102 = this.f250478n;
        if (r102 == null) goto L8;
        Drawable r103 = r102.getTabSelectedIndicator();
    L10:
        if ((r103 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r104 = (LayerDrawable) r103;
    L13:
        if (r104 == null) goto L15;
        Drawable r105 = r104.getDrawable(0);
    L17:
        if ((r105 instanceof GradientDrawable) == false) goto L19;
        r101 = (GradientDrawable) r105;
    L19:
        if (r101 == null) goto L21;
        int r106 = t86.a.f545052a;
        r101.setSize((int) (t86.a.b(getContext()) * (r100 / 375.0f)), r101.getIntrinsicHeight());
    L21:
        TabLayout r107 = this.f250478n;
        if (r107 == null) goto L25;
        r107.requestLayout();
        return;
    L25:
        return;
    L15:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    public final void setTabInterspace(float r100) {
        this.f250470f = r100 / 2;
    }

    public final void setTabLayout(LynxTabBarView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxTabBarView");
        this.f250466b = r100;
        LynxTabLayout r101 = r100.f250451b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        b(r101);
    }

    public final void setTabLayoutUpdateListener$x_element_fold_view_release(f r100) {
        Intrinsics.checkNotNullParameter(r100, "mOnTabLayoutUpdateListener");
        this.f250488x = r100;
    }

    public final void setTabPaddingBottom(int r100) {
        int r101 = t86.a.f545052a;
        t86.a.a(getContext(), r100);
        g();
    }

    public final void setTabPaddingEnd(int r100) {
        int r101 = t86.a.f545052a;
        this.f250490z = t86.a.a(getContext(), r100);
        g();
    }

    public final void setTabPaddingStart(int r100) {
        int r101 = t86.a.f545052a;
        this.f250489y = t86.a.a(getContext(), r100);
        g();
    }

    public final void setTabPaddingTop(int r100) {
        int r101 = t86.a.f545052a;
        t86.a.a(getContext(), r100);
        g();
    }

    public final void setTabSelectedListener$x_element_fold_view_release(TabLayout.OnTabSelectedListener r100) {
        this.f250487w = r100;
    }

    public final void setTabbarBackground(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        a();
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L5;
        Drawable r102 = r101.getBackground();
    L6:
        if (r102 == null) goto L14;
        Drawable r103 = ((LayerDrawable) r102).getDrawable(0);
        if (r103 == null) goto L12;
        ((GradientDrawable) r103).setColor(t86.a.d(r100));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r102 = null;
        goto L6
    }

    public final void setTablayoutGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        Object r101 = null;
        ViewGroup.LayoutParams r102 = null;
        ViewGroup.LayoutParams r103 = null;
        if (this.f250478n != null) goto L5;
        b(null);
    L5:
        String r104 = r100.toLowerCase(Locale.ROOT);
        int r105 = r104.hashCode();
        if (r105 == (-1364013995)) goto L45;
        if (r105 == 3143043) goto L25;
        if (r105 == 3317767) goto L13;
        return;
    L13:
        if (r104.equals("left") == false) goto L84;
        TabLayout r106 = this.f250478n;
        if (r106 == null) goto L18;
        r102 = r106.getLayoutParams();
    L18:
        if (r102 == null) goto L21;
        r102.width = -1;
    L21:
        TabLayout r107 = this.f250478n;
        if (r107 == null) goto L78;
        r107.requestLayout();
        return;
    L78:
        return;
    L84:
        return;
    L25:
        if (r104.equals(LynxVideoManagerLite.FILL) == false) goto L85;
        TabLayout r108 = this.f250478n;
        if (r108 == null) goto L31;
        r108.setTabMode(1);
    L31:
        TabLayout r109 = this.f250478n;
        if (r109 == null) goto L34;
        r103 = r109.getLayoutParams();
    L34:
        if (r103 == null) goto L37;
        r103.width = -1;
    L37:
        TabLayout r110 = this.f250478n;
        if (r110 == null) goto L41;
        r110.setTabGravity(0);
    L41:
        TabLayout r111 = this.f250478n;
        if (r111 == null) goto L80;
        r111.requestLayout();
        return;
    L80:
        return;
    L85:
        return;
    L45:
        if (r104.equals("center") == false) goto L86;
        TabLayout r112 = this.f250478n;
        if (r112 == null) goto L51;
        r112.setTabGravity(1);
    L51:
        TabLayout r113 = this.f250478n;
        if (r113 == null) goto L54;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L55:
        if (r114 == null) goto L77;
        r114.width = -1;
    L77:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L71
        TabLayout r116 = this.f250478n;     // Catch: Throwable -> L71
        if (r116 == null) goto L61;
        Field r117 = r116.getClass().getDeclaredField("slidingTabIndicator");     // Catch: Throwable -> L71
    L62:
        if (r117 == null) goto L65;
        r117.setAccessible(true);     // Catch: Throwable -> L71
    L65:
        if (r117 == null) goto L67;
        r101 = r117.get(this.f250478n);     // Catch: Throwable -> L71
    L67:
        if (r101 == null) goto L70;
        LinearLayout r118 = (LinearLayout) r101;     // Catch: Throwable -> L71
        r118.setGravity(17);     // Catch: Throwable -> L71
        r118.getLayoutParams().width = -2;     // Catch: Throwable -> L71
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        TabLayout r119 = this.f250478n;
        if (r119 == null) goto L82;
        r119.requestLayout();
        return;
    L82:
        return;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");     // Catch: Throwable -> L71
    L61:
        r117 = null;
    L71:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L54:
        r114 = null;
        goto L55
    }

    public final void setTextBold(String r100) {
        Intrinsics.checkNotNullParameter(r100, "boldMode");
        if (Intrinsics.areEqual(r100, "selected") == false) goto L6;
        this.f250484t = true;
        this.f250485u = false;
        return;
    L6:
        if (Intrinsics.areEqual(r100, "unselected") == false) goto L10;
        this.f250484t = false;
        this.f250485u = true;
        return;
    }

    public final void setUnSelectedTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getSelectedTabPosition());
    L6:
        this.f250483s = t86.a.d(r100);
        TabLayout r103 = this.f250478n;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.getTabCount();
    L10:
        if (r104 >= r105) goto L26;
        if (r102 != null) goto L14;
    L15:
        TabLayout r106 = this.f250478n;
        if (r106 == null) goto L25;
        TabLayout.Tab r107 = r106.getTabAt(r104);
        if (r107 == null) goto L25;
        View r108 = r107.getCustomView();
        if (r108 == null) goto L25;
        TextView r109 = (TextView) r108.findViewById(android.R.id.text1);
        if (r109 == null) goto L25;
        setUnSelectedTextStyle(r109);
    L25:
        r104 = r104 + 1;
        goto L10
    L14:
        if (r102.intValue() == r104) goto L25;
    L26:
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setUnSelectedTextSize(float r100) {
        this.f250482r = r100;
        TabLayout r101 = this.f250478n;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getSelectedTabPosition());
    L6:
        TabLayout r103 = this.f250478n;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.getTabCount();
    L10:
        if (r104 >= r105) goto L26;
        if (r102 != null) goto L14;
    L15:
        TabLayout r106 = this.f250478n;
        if (r106 == null) goto L25;
        TabLayout.Tab r107 = r106.getTabAt(r104);
        if (r107 == null) goto L25;
        View r108 = r107.getCustomView();
        if (r108 == null) goto L25;
        TextView r109 = (TextView) r108.findViewById(android.R.id.text1);
        if (r109 == null) goto L25;
        setUnSelectedTextStyle(r109);
    L25:
        r104 = r104 + 1;
        goto L10
    L14:
        if (r102.intValue() == r104) goto L25;
    L26:
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setUnSelectedTextStyle(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (this.f250479o == 0) goto L5;
        return;
    L5:
        r100.setTextSize(1, this.f250482r);
        if (this.f250485u == false) goto L8;
        Typeface r101 = Typeface.DEFAULT_BOLD;
    L9:
        r100.setTypeface(r101);
        r100.setTextColor(this.f250483s);
        return;
    L8:
        r101 = Typeface.DEFAULT;
        goto L9
    }

    public Pager(T r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "mViewPager");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r101);
        this.f250465a = r100;
        this.f250470f = 9.0f;
        Pager<T>.Adapter r102 = new Adapter(this);
        this.f250471g = r102;
        this.f250473i = true;
        this.f250474j = new ArrayList();
        this.f250475k = new ArrayList();
        this.f250477m = new ArrayList();
        this.f250480p = 16.0f;
        this.f250482r = 16.0f;
        this.f250489y = -1109;
        this.f250490z = -1109;
        this.A = true;
        this.C = new HashMap();
        this.D = new HashSet();
        this.E = new int[2];
        this.F = new Rect();
        this.G = new Rect();
        setOrientation(1);
        this.f250465a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f250465a.setAdapter(r102);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.f250465a, 0);
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "platformRendererContext");
        return new i(r100, r101);
    }

    public final void e(float r100, boolean r101) {
        ViewGroup.LayoutParams r102 = null;
        if (r101 == false) goto L10;
        TabLayout r103 = this.f250478n;
        if (r103 == null) goto L7;
        r102 = r103.getLayoutParams();
    L7:
        if (r102 == null) goto L16;
        int r104 = t86.a.f545052a;
        r102.height = t86.a.c(getContext(), r100);
    L16:
        TabLayout r105 = this.f250478n;
        if (r105 == null) goto L21;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L21;
        int r107 = r106.height;
    L22:
        this.f250469e = r107;
        d();
        TabLayout r108 = this.f250478n;
        if (r108 == null) goto L26;
        r108.requestLayout();
        return;
    L26:
        return;
    L21:
        r107 = 0;
        goto L22
    L10:
        TabLayout r109 = this.f250478n;
        if (r109 == null) goto L13;
        r102 = r109.getLayoutParams();
    L13:
        if (r102 == null) goto L16;
        int r110 = t86.a.f545052a;
        r102.height = t86.a.a(getContext(), r100);
        goto L16
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        i r103 = this.f250476l;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        boolean r104 = super.drawChild(r100, r101, r102);
        if (this.f250476l == null) goto L8;
        r100.restore();
    L8:
        return r104;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        i r105 = this.f250476l;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
