package com.ss.android.lark.discretescrollview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.discretescrollview.transform.DiscreteScrollItemTransformer;
import java.util.Locale;

/* JADX INFO: loaded from: classes35.dex */
public class DiscreteScrollLayoutManager extends RecyclerView.LayoutManager {
    public DiscreteScrollItemTransformer A;
    public final com.ss.android.lark.discretescrollview.a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Point f420413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Point f420414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Point f420415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f420416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f420417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f420418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f420419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f420420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f420421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f420422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f420423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f420424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SparseArray<View> f420425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DSVOrientation.a f420426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f420427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f420428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f420429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f420430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f420431s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f420432t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f420433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f420434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f420435w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f420436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DSVScrollConfig f420437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f420438z;

    public class a extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiscreteScrollLayoutManager f420439a;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForScrolling(int r100) {
            return (int) (Math.max(0.01f, Math.min(Math.abs(r100), this.f420439a.f420419g) / this.f420439a.f420419g) * this.f420439a.f420429q);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final PointF computeScrollVectorForPosition(int r100) {
            DiscreteScrollLayoutManager r101 = this.f420439a;
            float r102 = r101.f420426n.e(r101.f420422j);
            DiscreteScrollLayoutManager r103 = this.f420439a;
            return new PointF(r102, r103.f420426n.c(r103.f420422j));
        }

        public a(DiscreteScrollLayoutManager r100, Context r101) {
            this.f420439a = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDxToMakeVisible(View r100, int r101) {
            DiscreteScrollLayoutManager r102 = this.f420439a;
            return r102.f420426n.e(-r102.f420422j);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDyToMakeVisible(View r100, int r101) {
            DiscreteScrollLayoutManager r102 = this.f420439a;
            return r102.f420426n.c(-r102.f420422j);
        }
    }

    public interface b {
        int g0();
    }

    public interface c {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return this.f420426n.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return this.f420426n.l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        int r101 = this.f420424l;
        if (r101 == (-1)) goto L5;
        this.f420423k = r101;
    L5:
        r100.putInt("extra_position", this.f420423k);
        return r100;
    }

    public final void p() {
        if (this.A == null) goto L8;
        int r100 = this.f420419g * this.f420431s;
        int r101 = 0;
    L6:
        if (r101 >= this.B.a()) goto L10;
        View r102 = this.B.f420444a.getChildAt(r101);
        this.A.transformItem(r102, Math.min(Math.max(-1.0f, this.f420426n.d(this.f420414b, getDecoratedLeft(r102) + (r102.getWidth() * 0.5f), getDecoratedTop(r102) + (r102.getHeight() * 0.5f)) / r100), 1.0f));
        r101 = r101 + 1;
        goto L6
    L10:
        return;
    }

    public final void u() {
        a r100 = new a(this, this.f420428p);
        r100.setTargetPosition(this.f420423k);
        this.B.f420444a.startSmoothScroll(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State r100) {
        return computeScrollExtent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State r100) {
        int r101 = computeScrollExtent(r100);
        return (this.f420423k * r101) + ((int) ((this.f420421i / this.f420419g) * r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State r100) {
        return computeScrollRange(r100);
    }

    public final int computeScrollExtent(RecyclerView.State r100) {
        if (getItemCount() != 0) goto L7;
        return 0;
    L7:
        return (int) (computeScrollRange(r100) / getItemCount());
    }

    public final int computeScrollRange(RecyclerView.State r100) {
        if (r100.getItemCount() != 0) goto L7;
        return 0;
    L7:
        return this.f420419g * (r100.getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State r100) {
        return computeScrollExtent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State r100) {
        int r101 = computeScrollExtent(r100);
        return (this.f420423k * r101) + ((int) ((this.f420421i / this.f420419g) * r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State r100) {
        return computeScrollRange(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        if (this.B.a() <= 0) goto L6;
        r100.setFromIndex(getPosition(this.B.f420444a.getChildAt(0)));
        com.ss.android.lark.discretescrollview.a r101 = this.B;
        r100.setToIndex(getPosition(r101.f420444a.getChildAt(r101.a() - 1)));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView r100) {
        this.f420423k = Math.min(Math.max(0, this.f420423k), this.B.b() - 1);
        this.f420432t = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        if (this.f420427o == false) goto L6;
        DiscreteScrollView.access$000(((DiscreteScrollView.d) this.f420438z).f420441a);
        this.f420427o = false;
        return;
    L6:
        if (this.f420432t == false) goto L10;
        DiscreteScrollView.access$000(((DiscreteScrollView.d) this.f420438z).f420441a);
        this.f420432t = false;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable r100) {
        this.f420423k = ((Bundle) r100).getInt("extra_position");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int r100) {
        int r101 = this.f420420h;
        if (r101 != 0) goto L11;
        if (r101 == r100) goto L11;
        DiscreteScrollView.d r102 = (DiscreteScrollView.d) this.f420438z;
        DiscreteScrollView r103 = r102.f420441a;
        r103.removeCallbacks(DiscreteScrollView.access$300(r103));
        if (DiscreteScrollView.access$400(r102.f420441a).isEmpty() == true) goto L11;
        int r104 = DiscreteScrollView.access$500(r102.f420441a).f420423k;
        RecyclerView.ViewHolder r105 = r102.f420441a.getViewHolder(r104);
        if (r105 == null) goto L11;
        DiscreteScrollView.access$600(r102.f420441a, r105, r104);
    L11:
        boolean r106 = false;
        if (r100 != 0) goto L40;
        int r107 = this.f420424l;
        if (r107 == (-1)) goto L16;
        this.f420423k = r107;
        this.f420424l = -1;
        this.f420421i = 0;
    L16:
        Direction r108 = Direction.fromDelta(this.f420421i);
        if (Math.abs(this.f420421i) != this.f420419g) goto L20;
        this.f420423k += r108.applyTo(1);
        this.f420421i = 0;
    L20:
        if (Math.abs(this.f420421i) < (this.f420419g * 0.6f)) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L25;
        this.f420422j = Direction.fromDelta(this.f420421i).applyTo(this.f420419g - Math.abs(this.f420421i));
    L27:
        if (this.f420422j != 0) goto L29;
        r106 = true;
    L30:
        if (r106 == false) goto L39;
        DiscreteScrollView.d r110 = (DiscreteScrollView.d) this.f420438z;
        if (DiscreteScrollView.access$700(r110.f420441a).isEmpty() == true) goto L34;
    L36:
        int r111 = DiscreteScrollView.access$500(r110.f420441a).f420423k;
        RecyclerView.ViewHolder r112 = r110.f420441a.getViewHolder(r111);
        if (r112 == null) goto L54;
        DiscreteScrollView.access$800(r110.f420441a, r112, r111);
        DiscreteScrollView.access$900(r110.f420441a, r112, r111);
    L54:
        this.f420420h = r100;
        return;
    L34:
        if (DiscreteScrollView.access$400(r110.f420441a).isEmpty() == false) goto L36;
    L39:
        return;
    L29:
        u();
        goto L30
    L25:
        this.f420422j = -this.f420421i;
        goto L27
    L22:
        r109 = false;
        goto L23
    L40:
        if (r100 != 1) goto L54;
        int r113 = Math.abs(this.f420421i);
        int r114 = this.f420419g;
        if (r113 <= r114) goto L44;
        boolean r115 = true;
    L45:
        if (r115 == false) goto L48;
        int r116 = this.f420421i;
        int r117 = r116 / r114;
        this.f420423k += r117;
        this.f420421i = r116 - (r117 * r114);
    L48:
        if (Math.abs(this.f420421i) < (this.f420419g * 0.6f)) goto L50;
        boolean r118 = true;
    L51:
        if (r118 == false) goto L53;
        this.f420423k += Direction.fromDelta(this.f420421i).applyTo(1);
        this.f420421i = -Direction.fromDelta(this.f420421i).applyTo(this.f420419g - Math.abs(this.f420421i));
    L53:
        this.f420424l = -1;
        this.f420422j = 0;
        goto L54
    L50:
        r118 = false;
        goto L51
    L44:
        r115 = false;
        goto L45
    }

    public final void q(RecyclerView.Recycler r110) {
        this.f420425m.clear();
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= this.B.a()) goto L6;
        View r102 = this.B.f420444a.getChildAt(r101);
        this.f420425m.put(this.B.f420444a.getPosition(r102), r102);
        r101 = r101 + 1;
        goto L4
    L6:
        int r103 = 0;
    L8:
        if (r103 >= this.f420425m.size()) goto L10;
        com.ss.android.lark.discretescrollview.a r104 = this.B;
        View r105 = this.f420425m.valueAt(r103);
        r104.f420444a.detachView(r105);
        r103 = r103 + 1;
        goto L8
    L10:
        this.f420426n.j(this.f420414b, this.f420421i, this.f420415c);
        int r106 = this.f420426n.a(this.B.f420444a.getWidth(), this.B.f420444a.getHeight());
        Point r107 = this.f420415c;
        if (this.f420426n.g(r107, this.f420416d, this.f420417e, r106, this.f420418f) == false) goto L13;
        r(r110, this.f420423k, this.f420415c);
    L13:
        s(r110, Direction.START, r106);
        s(r110, Direction.END, r106);
    L15:
        if (r100 >= this.f420425m.size()) goto L17;
        View r108 = this.f420425m.valueAt(r100);
        this.B.getClass();
        r110.recycleView(r108);
        r100 = r100 + 1;
        goto L15
    L17:
        this.f420425m.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        if (this.f420423k != r100) goto L5;
        return;
    L5:
        this.f420423k = r100;
        this.B.f420444a.requestLayout();
    }

    public final void v(int r100) {
        int r101 = this.f420423k;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.f420422j = -this.f420421i;
        this.f420422j += Direction.fromDelta(r100 - r101).applyTo(Math.abs(r100 - this.f420423k) * this.f420419g);
        this.f420424l = r100;
        u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        this.f420424l = -1;
        this.f420422j = 0;
        this.f420421i = 0;
        if ((r101 instanceof b) == false) goto L5;
        this.f420423k = ((b) r101).g0();
    L6:
        this.B.f420444a.removeAllViews();
        return;
    L5:
        this.f420423k = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (r101.getItemCount() != 0) goto L6;
        this.B.f420444a.removeAndRecycleAllViews(r100);
        this.f420424l = -1;
        this.f420423k = -1;
        this.f420422j = 0;
        this.f420421i = 0;
        return;
    L6:
        int r102 = this.f420423k;
        if (r102 != (-1)) goto L9;
    L10:
        this.f420423k = 0;
    L11:
        boolean r103 = true;
        if (this.B.f420444a.getWidth() == this.f420435w) goto L14;
        boolean r104 = true;
    L16:
        if (this.B.f420444a.getHeight() == this.f420436x) goto L18;
        boolean r105 = true;
    L20:
        if (r101.isMeasuring() == true) goto L24;
        if (r104 == true) goto L23;
        if (r105 == false) goto L24;
    L23:
        boolean r106 = true;
    L25:
        if (r106 == false) goto L27;
        this.f420435w = this.B.f420444a.getWidth();
        this.f420436x = this.B.f420444a.getHeight();
        this.B.f420444a.removeAllViews();
    L27:
        this.f420414b.set(this.B.f420444a.getWidth() / 2, this.B.f420444a.getHeight() / 2);
        if (this.f420427o == false) goto L30;
    L36:
        this.B.f420444a.detachAndScrapAttachedViews(r100);
        q(r100);
        p();
        return;
    L30:
        if (this.B.a() == 0) goto L33;
        r103 = false;
    L33:
        this.f420427o = r103;
        if (r103 == false) goto L36;
        com.ss.android.lark.discretescrollview.a r107 = this.B;
        r107.getClass();
        View r108 = r100.getViewForPosition(0);
        r107.f420444a.addView(r108);
        r107.f420444a.measureChildWithMargins(r108, 0, 0);
        com.ss.android.lark.discretescrollview.a r109 = this.B;
        r109.getClass();
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r108.getLayoutParams();
        int r111 = (r109.f420444a.getDecoratedMeasuredWidth(r108) + r110.leftMargin) + r110.rightMargin;
        com.ss.android.lark.discretescrollview.a r112 = this.B;
        r112.getClass();
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r108.getLayoutParams();
        int r114 = (r112.f420444a.getDecoratedMeasuredHeight(r108) + r113.topMargin) + r113.bottomMargin;
        this.f420416d = r111 / 2;
        this.f420417e = r114 / 2;
        int r115 = this.f420426n.k(r111, r114);
        this.f420419g = r115;
        this.f420418f = r115 * this.f420430r;
        this.B.f420444a.detachAndScrapView(r108, r100);
    L24:
        r106 = false;
        goto L25
    L18:
        r105 = false;
        goto L20
    L14:
        r104 = false;
        goto L16
    L9:
        if (r102 < r101.getItemCount()) goto L11;
        goto L10
    }

    public final int t(int r110, RecyclerView.Recycler r111) {
        if (this.B.a() != 0) goto L5;
        return 0;
    L5:
        Direction r100 = Direction.fromDelta(r110);
        int r101 = this.f420422j;
        if (r101 == 0) goto L9;
        int r102 = Math.abs(r101);
    L50:
        if (r102 > 0) goto L52;
        return 0;
    L52:
        int r112 = r100.applyTo(Math.min(r102, Math.abs(r110)));
        this.f420421i += r112;
        int r103 = this.f420422j;
        if (r103 == 0) goto L55;
        this.f420422j = r103 - r112;
    L55:
        this.f420426n.f(-r112, this.B);
        if (this.f420426n.m(this) == false) goto L59;
        q(r111);
    L59:
        if (this.f420424l == (-1)) goto L61;
        int r113 = Math.abs(this.f420421i + this.f420422j);
    L62:
        float r104 = -Math.min(Math.max(-1.0f, this.f420421i / r113), 1.0f);
        DiscreteScrollView.d r114 = (DiscreteScrollView.d) this.f420438z;
        if (DiscreteScrollView.access$400(r114.f420441a).isEmpty() == true) goto L75;
        int r105 = r114.f420441a.getCurrentItem();
        DiscreteScrollLayoutManager r106 = DiscreteScrollView.access$500(r114.f420441a);
        int r107 = r106.f420421i;
        if (r107 != 0) goto L68;
        int r108 = r106.f420423k;
    L72:
        int r109 = r108;
    L73:
        if (r105 == r109) goto L75;
        DiscreteScrollView r115 = r114.f420441a;
        DiscreteScrollView.access$1000(r115, r104, r105, r109, r115.getViewHolder(r105), r114.f420441a.getViewHolder(r109));
        goto L75
    L68:
        int r116 = r106.f420424l;
        if (r116 == (-1)) goto L71;
        r109 = r116;
        goto L73
    L71:
        r108 = r106.f420423k + Direction.fromDelta(r107).applyTo(1);
    L75:
        p();
        return r112;
    L61:
        r113 = this.f420419g;
        goto L62
    L9:
        if (this.f420420h != 1) goto L14;
        if (this.f420437y.isScrollBlocked(r100) == false) goto L14;
        r102 = r100.reverse().applyTo(this.f420421i);
    L14:
        if (r100.applyTo(this.f420421i) <= 0) goto L16;
        boolean r117 = true;
    L18:
        if (r100 != Direction.START) goto L29;
        if (this.f420423k != 0) goto L29;
        int r118 = this.f420421i;
        if (r118 != 0) goto L24;
        boolean r119 = true;
    L25:
        if (r119 == true) goto L37;
        r102 = Math.abs(r118);
    L43:
        DiscreteScrollView.d r120 = (DiscreteScrollView.d) this.f420438z;
        if (DiscreteScrollView.access$200(r120.f420441a) == false) goto L50;
        DiscreteScrollView r121 = r120.f420441a;
        if (r119 == false) goto L48;
        int r122 = 0;
    L49:
        r121.setOverScrollMode(r122);
        goto L50
    L48:
        r122 = 2;
    L37:
        r102 = 0;
        goto L43
    L24:
        r119 = false;
    L29:
        if (r100 == Direction.END) goto L31;
    L39:
        if (r117 == false) goto L41;
        r102 = this.f420419g - Math.abs(this.f420421i);
    L42:
        r119 = false;
        goto L43
    L41:
        r102 = this.f420419g + Math.abs(this.f420421i);
        goto L42
    L31:
        if (this.f420423k != (this.B.b() - 1)) goto L39;
        int r123 = this.f420421i;
        if (r123 != 0) goto L35;
        r119 = true;
    L36:
        if (r119 == true) goto L37;
        r102 = Math.abs(r123);
        goto L43
    L35:
        r119 = false;
        goto L36
    L16:
        r117 = false;
        goto L18
    }

    public DiscreteScrollLayoutManager(Context r100, DiscreteScrollView.d r101, DSVOrientation r102) {
        this.f420437y = DSVScrollConfig.ENABLED;
        this.f420428p = r100;
        this.f420429q = 300;
        this.f420424l = -1;
        this.f420423k = -1;
        this.f420433u = 2100;
        this.f420434v = false;
        this.f420414b = new Point();
        this.f420415c = new Point();
        this.f420413a = new Point();
        this.f420425m = new SparseArray();
        this.f420438z = r101;
        this.f420426n = r102.createHelper();
        this.B = new com.ss.android.lark.discretescrollview.a(this);
        this.f420431s = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView r100, int r101, int r102) {
        int r103 = this.f420423k;
        if (r103 != (-1)) goto L5;
        r103 = 0;
    L8:
        if (this.f420423k == r103) goto L11;
        this.f420423k = r103;
        this.f420432t = true;
        return;
    L11:
        return;
    L5:
        if (r103 < r101) goto L8;
        r103 = Math.min(r103 + r102, this.B.b() - 1);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        int r103 = this.f420423k;
        if (this.B.b() != 0) goto L5;
        r103 = -1;
    L12:
        if (this.f420423k == r103) goto L15;
        this.f420423k = r103;
        this.f420432t = true;
        return;
    L15:
        return;
    L5:
        int r104 = this.f420423k;
        if (r104 < r101) goto L12;
        if (r104 >= (r101 + r102)) goto L10;
        this.f420423k = -1;
    L10:
        r103 = Math.max(0, this.f420423k - r102);
        goto L12
    }

    public final void r(RecyclerView.Recycler r100, int r101, Point r110) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        View r102 = this.f420425m.get(r101);
        if (r102 != null) goto L7;
        com.ss.android.lark.discretescrollview.a r103 = this.B;
        r103.getClass();
        View r104 = r100.getViewForPosition(r101);
        r103.f420444a.addView(r104);
        r103.f420444a.measureChildWithMargins(r104, 0, 0);
        com.ss.android.lark.discretescrollview.a r105 = this.B;
        int r106 = r110.x;
        int r107 = this.f420416d;
        int r111 = r110.y;
        int r108 = this.f420417e;
        int r109 = r111 + r108;
        RecyclerView.LayoutManager r112 = r105.f420444a;
        r112.layoutDecoratedWithMargins(r104, r106 - r107, r111 - r108, r106 + r107, r109);
        return;
    L7:
        this.B.f420444a.attachView(r102);
        this.f420425m.remove(r101);
    }

    public final void s(RecyclerView.Recycler r110, Direction r111, int r112) {
        int r100 = r111.applyTo(1);
        int r101 = this.f420424l;
        if (r101 != (-1)) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Point r103 = this.f420413a;
        Point r104 = this.f420415c;
        r103.set(r104.x, r104.y);
        int r105 = this.f420423k;
    L10:
        r105 = r105 + r100;
        if (r105 >= 0) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L25;
        if (r105 != this.f420424l) goto L20;
        r102 = true;
    L20:
        this.f420426n.b(r111, this.f420419g, this.f420413a);
        Point r113 = this.f420413a;
        if (this.f420426n.g(r113, this.f420416d, this.f420417e, r112, this.f420418f) == true) goto L22;
        if (r102 == false) goto L10;
        return;
    L22:
        r(r110, r105, this.f420413a);
        goto L10
    L25:
        return;
    L13:
        if (r105 >= this.B.b()) goto L15;
        r106 = true;
        goto L16
    L5:
        if (r111.sameAs(r101 - this.f420423k) == false) goto L8;
        r102 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return t(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return t(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (this.f420423k != r102) goto L5;
        return;
    L5:
        if (this.f420424l != (-1)) goto L19;
        if (r102 < 0) goto L16;
        if (r102 >= r101.getItemCount()) goto L16;
        if (this.f420423k != (-1)) goto L13;
        this.f420423k = r102;
        return;
    L13:
        v(r102);
        return;
    L16:
        throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", new Object[]{Integer.valueOf(r102), Integer.valueOf(r101.getItemCount())}));
    }
}
