package com.bytedance.android.shopping.orderlist.search.widget.gul;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0017B%\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/widget/gul/OrderSearchResultGULView;", "Landroid/widget/FrameLayout;", "Ljg3/b;", "Landroid/view/View;", "getView", "", "height", "", "setGULHeight", "getGULVerticalOffset", "Ljg3/a;", "b", "Lkotlin/Lazy;", "getGulComponent", "()Ljg3/a;", "gulComponent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LoadState", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSearchResultGULView extends FrameLayout implements jg3.b {
    public final FrameLayout a;
    public final Lazy b;
    public LoadState c;
    public int d;
    public Function0<Unit> e;
    public final CopyOnWriteArrayList<Function0<Unit>> f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/widget/gul/OrderSearchResultGULView$LoadState;", "", "NONE", "LOADING", "SUCCESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState LOADING = null;
        public static final LoadState NONE = null;
        public static final LoadState SUCCESS = null;
        public static final /* synthetic */ LoadState[] a = null;

        static {
            LoadState r1 = new LoadState("NONE", 0);
            NONE = r1;
            LoadState r2 = new LoadState("LOADING", 1);
            LOADING = r2;
            LoadState r3 = new LoadState("SUCCESS", 2);
            SUCCESS = r3;
            a = new LoadState[]{r1, r2, r3};
        }

        public static LoadState valueOf(String r1) {
            return (LoadState) r27.a.a(LoadState.class, r1);
        }

        public static LoadState[] values() {
            return (LoadState[]) a.clone();
        }

        public LoadState(String r1, int r2) {
            super(r1, r2);
        }
    }

    private final jg3.a getGulComponent() {
        return (jg3.a) this.b.getValue();
    }

    @Override // jg3.b
    public View getView() {
        return this;
    }

    @Override // jg3.b
    public final boolean a() {
        WebView r0 = g(this.a);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canScrollVertically(-1);
    }

    @Override // jg3.b
    public final boolean b() {
        if (this.c != LoadState.SUCCESS) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // jg3.b
    public final boolean c() {
        WebView r0 = g(this.a);
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.canScrollVertically(1);
    }

    @Override // jg3.b
    public int getGULVerticalOffset() {
        WebView r0 = g(this.a);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getScrollY();
    }

    public final void h() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultGULView", OrderSearchResultGULView$initOrReload$1.INSTANCE);
        this.c = LoadState.LOADING;
        getGulComponent().a(new OrderSearchResultGULView$initOrReload$2(this));
    }

    @Override // jg3.b
    public final boolean isLoading() {
        if (this.c != LoadState.LOADING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // jg3.b
    public final void show() {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (r0 != null) goto L5;
    L7:
        i(this.a, Integer.valueOf(this.d));
        return;
    L5:
        if (r0.height != this.d) goto L7;
    }

    @Override // jg3.b
    public final void t0() {
        final WebView r0 = g(this.a);
        if (r0 == null) goto L14;
        Object r1 = d0.a.getActivity(r0.getContext());
        lg3.a r3 = null;
        if ((r1 instanceof OrderSearchResultActivity) == true) goto L7;
        r1 = null;
    L7:
        OrderSearchResultActivity r2 = (OrderSearchResultActivity) r1;
        if (r2 == null) goto L12;
        OrderSearchResultViewModel r4 = r2.I1();
        if (r4 == null) goto L12;
        r3 = r4.getTracker();
    L12:
        OrderCommonErrorMonitorKt.c(r3, "OrderSearchResultGULView-scrollToTop", new OrderSearchResultGULView$scrollToTop$1(r0));
        return;
    }

    @Override // jg3.b
    public final void release() {
        getGulComponent().release();
    }

    public static WebView g(View r2) {
        WebView r1 = null;
        if ((r2 instanceof ViewGroup) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L16;
        Iterator r4 = com.bytedance.commerce.base.view.b.a(r3).iterator();
    L9:
        if (r4.hasNext() == false) goto L22;
        View r0 = (View) r4.next();
        if ((r0 instanceof WebView) == true) goto L21;
        r1 = g(r0);
        if (r1 == null) goto L9;
        return r1;
    L21:
        return (WebView) r0;
    L22:
        return r1;
    L16:
        return null;
    }

    @Override // jg3.b
    public final void d(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "disposableCallback");
        if (this.c != LoadState.SUCCESS) goto L5;
        r3.invoke();
        return;
    L5:
        this.e = r3;
    }

    @Override // jg3.b
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
        if (r3 != null) goto L5;
    L7:
        i(this.a, 0);
        return;
    L5:
        if (r3.height != 0) goto L7;
    }

    @Override // jg3.b
    public final void f(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "disposableCallback");
        if (this.c != LoadState.SUCCESS) goto L5;
        r3.invoke();
        return;
    L5:
        this.f.add(r3);
    }

    @Override // jg3.b
    public void setGULHeight(int r1) {
        this.d = r1;
    }

    public final void i(View r3, Integer r4) {
        int r1 = 0;
        if (r3.getLayoutParams() == null) goto L9;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r4 == null) goto L7;
        r1 = r4.intValue();
    L7:
        r0.height = r1;
    L12:
        r3.requestLayout();
        r3.invalidate();
        return;
    L9:
        if (r4 == null) goto L11;
        r1 = r4.intValue();
    L11:
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, r1));
        goto L12
    }

    @Override // android.view.View, jg3.b
    public final void scrollBy(int r2, int r3) {
        WebView r0 = g(this.a);
        if (r0 == null) goto L6;
        r0.scrollBy(r2, r3);
        return;
    }

    public OrderSearchResultGULView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout r5 = new FrameLayout(r2);
        this.a = r5;
        this.b = LazyKt.lazy(new OrderSearchResultGULView$gulComponent$2(this, r2));
        this.c = LoadState.NONE;
        removeAllViews();
        r5.removeAllViews();
        addView(r5, new FrameLayout.LayoutParams(-1, -2));
        this.f = new CopyOnWriteArrayList();
    }
}
