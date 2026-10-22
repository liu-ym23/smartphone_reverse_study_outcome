package jd8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.component.bottom.core.follow.InputSwipePanelHost$2;
import com.larus.bmhome.clarification.x1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class l extends FrameLayout {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze8.a f498708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f498709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f498710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f498711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f498712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewPager2 f498713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f498714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f498715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f498716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f498717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f498718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f498719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f498720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f498721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f498722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f498723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f498724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<a> f498725r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f498726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f498727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Path f498728u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f498729v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f498730w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f498731x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f498732y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f498733z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f498734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f498735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f498736c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f498734a, r101.f498734a) == true) goto L12;
            return false;
        L12:
            if (this.f498735b == r101.f498735b) goto L15;
            return false;
        L15:
            if (this.f498736c == r101.f498736c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f498734a.hashCode() * 31;
            int r101 = 1231;
            if (this.f498735b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f498736c == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ClippingParentState(parent=" + this.f498734a + ", clipChildren=" + this.f498735b + ", clipToPadding=" + this.f498736c + ')';
        }

        public a(ViewGroup r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            this.f498734a = r100;
            this.f498735b = r101;
            this.f498736c = r102;
        }
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f498737a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f498737a.f498708a.getPageCount();
        }

        public b(l r100) {
            this.f498737a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            this.f498737a.f498708a.a(r102.itemView, r101);
            r102.itemView.setTranslationY(this.f498737a.f498717j[r101]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            x1.a r102 = this.f498737a.f498708a.b(r100);
            r102.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return new c(r102);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "page");
            super(r100);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f498723p = -1;
        this.f498724q = false;
        g();
        h();
        super.onDetachedFromWindow();
    }

    private final int getBasePageStrokeAlpha() {
        return ((Number) this.f498729v.getValue()).intValue();
    }

    private final View getMeasurePage() {
        return (View) this.f498715h.getValue();
    }

    private final Paint getPageStrokePaint() {
        return (Paint) this.f498727t.getValue();
    }

    public final void c() {
        if (this.f498730w >= 0.0f) goto L5;
        return;
    L5:
        this.f498730w = -1.0f;
        getPageStrokePaint().setAlpha(getBasePageStrokeAlpha());
        invalidate();
    }

    public final boolean d() {
        if (this.f498721n == true) goto L15;
        g r100 = this.f498709b;
        if (r100.f498681i == null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r100.f498696x != null) goto L10;
        r101 = false;
        goto L11
    L15:
        return true;
    }

    public final void g() {
        int r100 = 0;
        ArraysKt.fill$default(this.f498717j, 0, 0, 0, 6, null);
        View r101 = this.f498713f.getChildAt(0);
        if ((r101 instanceof RecyclerView) == false) goto L5;
        RecyclerView r102 = (RecyclerView) r101;
    L6:
        if (r102 == null) goto L10;
        int r103 = r102.getChildCount();
    L8:
        if (r100 >= r103) goto L10;
        r102.getChildAt(r100).setTranslationY(0.0f);
        r100 = r100 + 1;
    L10:
        invalidate();
        if (this.f498721n == true) goto L15;
        b(i(this.f498719l));
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void h() {
        Iterator<T> r100 = this.f498725r.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a r101 = (a) r100.next();
        r101.f498734a.setClipChildren(r101.f498735b);
        r101.f498734a.setClipToPadding(r101.f498736c);
        goto L4
    L6:
        ((ArrayList) this.f498725r).clear();
    }

    public static int a(l r100) {
        return Color.alpha(r100.getPageStrokePaint().getColor());
    }

    public final void b(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r101 = this.f498713f.getLayoutParams();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.height == r100) goto L11;
        r101.height = r100;
        this.f498713f.setLayoutParams(r101);
        return;
    L11:
        if (this.f498713f.getHeight() == r100) goto L15;
        this.f498713f.requestLayout();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.dispatchDraw(r110);
        boolean r100 = this.f498721n;
        int r101 = 0;
        if (r100 == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 == true) goto L11;
        if (r102 == true) goto L11;
        return;
    L11:
        Paint r103 = getPageStrokePaint();
        if (r102 == false) goto L14;
        int r104 = RangesKt.coerceIn(MathKt.roundToInt(getBasePageStrokeAlpha() * this.f498730w), 0, 255);
    L15:
        r103.setAlpha(r104);
        View r105 = this.f498713f.getChildAt(0);
        if ((r105 instanceof RecyclerView) == false) goto L18;
        RecyclerView r106 = (RecyclerView) r105;
    L19:
        if (r106 != null) goto L21;
        return;
    L21:
        Resources r107 = getResources();
        float r108 = (int) TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()));
        float r109 = getPageStrokePaint().getStrokeWidth() / 2.0f;
        int r111 = r106.getChildCount();
    L22:
        if (r101 >= r111) goto L29;
        View r112 = r106.getChildAt(r101);
        int r113 = r106.getChildAdapterPosition(r112);
        if (r113 == (-1)) goto L28;
        int r114 = e(r113);
        if (r114 <= 0) goto L28;
        float r115 = ((this.f498713f.getX() + r106.getX()) + r112.getX()) + r109;
        float r116 = (((this.f498713f.getX() + r106.getX()) + r112.getX()) + r112.getWidth()) - r109;
        float r117 = ((this.f498713f.getY() + r106.getY()) + r112.getY()) + r112.getHeight();
        float r118 = (r117 - r114) + r109;
        this.f498728u.reset();
        this.f498728u.moveTo(r115, r117);
        float r119 = r118 + r108;
        this.f498728u.lineTo(r115, r119);
        this.f498728u.quadTo(r115, r118, r115 + r108, r118);
        this.f498728u.lineTo(r116 - r108, r118);
        this.f498728u.quadTo(r116, r118, r116, r119);
        this.f498728u.lineTo(r116, r117);
        r110.drawPath(this.f498728u, getPageStrokePaint());
    L28:
        r101 = r101 + 1;
        goto L22
    L29:
        return;
    L18:
        r106 = null;
        goto L19
    L14:
        r104 = getBasePageStrokeAlpha();
        goto L15
    L5:
        if (this.f498730w < 0.0f) goto L7;
        r102 = true;
        goto L8
    }

    public final int e(int r110) {
        int r100 = getWidth();
        if (r100 > 0) goto L6;
        return 0;
    L6:
        if (this.f498718k == r100) goto L8;
        ArraysKt.fill$default(this.f498716i, -1, 0, 0, 6, null);
        this.f498718k = r100;
    L8:
        int r101 = this.f498716i[r110];
        if (r101 <= 0) goto L11;
        return r101;
    L11:
        this.f498708a.a(getMeasurePage(), r110);
        getMeasurePage().measure(View.MeasureSpec.makeMeasureSpec(r100, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r102 = getMeasurePage().getMeasuredHeight();
        int r103 = this.f498720m;
        if (r103 > 0) goto L15;
        Resources r104 = getResources();
        r103 = (int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels * 0.6f);
    L15:
        int r105 = RangesKt.coerceAtMost(r102, r103);
        this.f498716i[r110] = r105;
        return r105;
    }

    public final int f(ze8.d r100) {
        int r101 = this.f498708a.getPageCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (Intrinsics.areEqual(this.f498708a.c(r102).f571562a, r100.f571562a) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }

    public final int i(int r100) {
        int[] r101 = this.f498717j;
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        int r103 = r101[r100];
    L12:
        return e(r100) + RangesKt.coerceAtLeast(-r103, 0);
    L10:
        r103 = 0;
        goto L12
    L5:
        if (r100 >= r101.length) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Function0<Boolean> r101 = this.f498710c;
        if (r101 == null) goto L5;
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L9;
        this.f498732y = r100.getX();
        this.f498733z = r100.getY();
        this.A = false;
        this.B = false;
    L25:
        return super.onInterceptTouchEvent(r100);
    L9:
        if (r102 != 2) goto L25;
        if (this.A == true) goto L25;
        float r103 = r100.getX() - this.f498732y;
        float r104 = r100.getY() - this.f498733z;
        if (Math.abs(r103) <= this.f498731x) goto L16;
    L17:
        this.A = true;
        if (Math.abs(r103) <= Math.abs(r104)) goto L25;
        if (r101.invoke().booleanValue() == false) goto L25;
        this.B = true;
        return true;
    L16:
        if (Math.abs(r104) <= this.f498731x) goto L25;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.B == false) goto L7;
        return true;
    L7:
        return super.onTouchEvent(r100);
    }

    public final void setSettleBorderFraction(float r100) {
        this.f498730w = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f498723p < 0) goto L6;
        setMeasuredDimension(getMeasuredWidth(), this.f498723p);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f498724q == false) goto L6;
        if (r101 == r103) goto L6;
        this.f498724q = false;
        h();
    L6:
        if (r100 <= 0) goto L10;
        if (r100 == r102) goto L11;
        b(i(this.f498719l));
        return;
    L11:
        return;
    }

    public l(final Context r100, x1 r101, g r102, int r103, n r104, ViewGroup r105, m r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "panelAdapter");
        Intrinsics.checkNotNullParameter(r102, "follow");
        super(r100);
        this.f498708a = r101;
        this.f498709b = r102;
        this.f498710c = r104;
        this.f498711d = r105;
        this.f498712e = r106;
        this.f498713f = new ViewPager2(r100);
        this.f498714g = new b(this);
        this.f498715h = LazyKt.lazy(new i(this));
        int r107 = r101.getPageCount();
        int[] r108 = new int[r107];
        int r109 = 0;
    L4:
        if (r109 >= r107) goto L6;
        r108[r109] = -1;
        r109 = r109 + 1;
        goto L4
    L6:
        this.f498716i = r108;
        this.f498717j = new int[this.f498708a.getPageCount()];
        this.f498720m = r103;
        this.f498723p = -1;
        this.f498725r = new ArrayList();
        this.f498726s = new int[2];
        this.f498727t = LazyKt.lazy(new j(r100));
        this.f498728u = new Path();
        this.f498729v = LazyKt.lazy(new k(this));
        this.f498730w = -1.0f;
        this.f498731x = ViewConfiguration.get(r100).getScaledTouchSlop();
        setClipChildren(false);
        this.f498713f.setClipChildren(false);
        this.f498713f.setClipToPadding(false);
        this.f498713f.setOrientation(0);
        this.f498713f.setOffscreenPageLimit(RangesKt.coerceAtLeast(this.f498708a.getPageCount(), 1));
        this.f498713f.setAdapter(this.f498714g);
        ViewPager2 r110 = this.f498713f;
        Resources r111 = getResources();
        r110.setPageTransformer(new MarginPageTransformer((int) TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()))));
        View r112 = this.f498713f.getChildAt(0);
        if ((r112 instanceof RecyclerView) == false) goto L9;
        RecyclerView r113 = (RecyclerView) r112;
    L10:
        if (r113 == null) goto L12;
        r113.setClipChildren(false);
        r113.setClipToPadding(false);
    L12:
        addView(this.f498713f, new FrameLayout.LayoutParams(-1, -2, 80));
        this.f498713f.registerOnPageChangeCallback(new InputSwipePanelHost$2(this));
        return;
    L9:
        r113 = null;
        goto L10
    }
}
