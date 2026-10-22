package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.new_cart.components.CartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.new_cart.components.CartLoadMoreComponent;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.new_cart.utils.h;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.CartGULView;
import com.bytedance.android.shopping.new_cart.widgets.LoadMoreFooterView;
import com.bytedance.android.shopping.new_cart.widgets.j;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001>B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010)R*\u00102\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00106\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101¨\u0006?"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartLinkedScrollViewV2;", "Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartTwoRevNestedScrollView;", "Lcom/bytedance/android/shopping/new_cart/widgets/j;", "", "getOffsetToBottomScreen", "", "getSessionId", "Landroidx/recyclerview/widget/RecyclerView;", "getYataBody", "getCartRev", "Lcom/bytedance/android/shopping/new_cart/widgets/CartGULView;", "getGul", "Lcom/bytedance/android/shopping/new_cart/widgets/LoadMoreFooterView;", "getLoadingFooter", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "objectContainer", "", "setCartObjectContainer", "Landroid/view/View;", FreqActions.ACTION_VIEW, "setTopView", "getMaxScrollRange", "Lcom/bytedance/android/shopping/new_cart/components/CartLoadMoreComponent;", "v", "Lkotlin/Lazy;", "getCartLoadMoreComponent", "()Lcom/bytedance/android/shopping/new_cart/components/CartLoadMoreComponent;", "cartLoadMoreComponent", "Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "w", "getSliceCustomWidgetAdapterComponent", "()Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "sliceCustomWidgetAdapterComponent", "Lcom/bytedance/android/shopping/new_cart/viewmodel/CartViewModel;", "x", "getCartVM", "()Lcom/bytedance/android/shopping/new_cart/viewmodel/CartViewModel;", "cartVM", "Lcom/bytedance/android/shopping/new_cart/components/CartBackToTopBtnManageComponent;", "y", "getCartBackToTopBtnManageComponent", "()Lcom/bytedance/android/shopping/new_cart/components/CartBackToTopBtnManageComponent;", "cartBackToTopBtnManageComponent", "value", "z", "I", "getOuterHeight", "()I", "setOuterHeight", "(I)V", "outerHeight", "A", "getPhysicalHeight", "setPhysicalHeight", "physicalHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartLinkedScrollViewV2 extends CartTwoRevNestedScrollView implements j {
    public static final /* synthetic */ int E = 0;
    public int A;
    public Boolean B;
    public final Rect C;
    public final Function2<String, Double, Unit> D;
    public final RecyclerView p;
    public final CartGULView q;
    public final LoadMoreFooterView r;
    public final View s;
    public int t;
    public CartObjectContainer u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public int z;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ CartLinkedScrollViewV2 a;

        public a(CartLinkedScrollViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            CartLinkedScrollViewV2 r10 = this.a;
            int r11 = CartLinkedScrollViewV2.E;
            r10.s();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ CartLinkedScrollViewV2 a;

        public b(CartLinkedScrollViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            CartLinkedScrollViewV2 r10 = this.a;
            int r11 = CartLinkedScrollViewV2.E;
            r10.s();
        }
    }

    public static final class c {
    }

    public static final class d implements et3.c.d {
        public final /* synthetic */ CartLinkedScrollViewV2 a;
        public final /* synthetic */ String b;

        public d(CartLinkedScrollViewV2 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void fpsCallBack(double r3) {
            this.a.D.invoke(this.b, Double.valueOf(r3));
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ CartLinkedScrollViewV2 a;
        public final /* synthetic */ int b;

        public e(CartLinkedScrollViewV2 r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2, java.lang.Object] */
        public final void a() {
            ?? r0 = this.a;
            r0.getClass();
            r0.post(new com.bytedance.android.shopping.new_cart.widgets.nest.e(r0));
            CartSliceCustomWidgetAdapterComponent r1 = CartLinkedScrollViewV2.o(this.a);
            if (r1 == null) goto L24;
            if (r1.d != true) goto L24;
            CartViewModel r2 = CartLinkedScrollViewV2.n(this.a);
            if (r2 == null) goto L11;
            com.bytedance.android.shopping.new_cart.yata.customdata.a r3 = r2.getCustomDataCenter();
            if (r3 == null) goto L11;
            r3.c(Boolean.FALSE);
        L11:
            CartSliceCustomWidgetAdapterComponent r4 = CartLinkedScrollViewV2.o(this.a);
            if (r4 == null) goto L14;
            r4.d = false;
        L14:
            CartViewExtentionsKt.c(this.a);
            CartObjectContainer r5 = this.a.u;
            if (r5 == null) goto L24;
            com.bytedance.android.shopping.new_cart.container.b r6 = r5.e;
            if (r6 == null) goto L24;
            Function0<AndroidYaTaInstance> r7 = r6.d;
            if (r7 == null) goto L24;
            AndroidYaTaInstance r8 = (AndroidYaTaInstance) r7.invoke();
            if (r8 == null) goto L24;
            r8.x(null, aa6.a.a.b, null, null);
        L24:
            if (this.b <= 0) goto L28;
            CartLoadMoreComponent r9 = CartLinkedScrollViewV2.m(this.a);
            if (r9 == null) goto L28;
            CartLinkedScrollViewV2 r10 = this.a;
            r9.o(r10, true, r10.getLoadingFooter());
        L28:
            CartLinkedScrollViewV2.k(this.a);
            CartLinkedScrollViewV2.p(this.a);
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
    }

    static {
    }

    public CartLinkedScrollViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CartLinkedScrollViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final CartBackToTopBtnManageComponent getCartBackToTopBtnManageComponent() {
        return (CartBackToTopBtnManageComponent) this.y.getValue();
    }

    private final CartLoadMoreComponent getCartLoadMoreComponent() {
        return (CartLoadMoreComponent) this.v.getValue();
    }

    private final CartViewModel getCartVM() {
        return (CartViewModel) this.x.getValue();
    }

    private final CartSliceCustomWidgetAdapterComponent getSliceCustomWidgetAdapterComponent() {
        return (CartSliceCustomWidgetAdapterComponent) this.w.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final void d() {
    L10:
        th = move-exception;
        CartViewModel r1 = getCartVM();
        if (r1 == null) goto L17;
        bg3.a r2 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(r1, "justify", th.getMessage(), MapsKt.mapOf(TuplesKt.to("location", "justifyList()")));
        return;
    L17:
        return;
    L4:
        if (canScrollVertically(1) == false) goto L8;
        RecyclerView r0 = this.q.getGULRecyclerView();     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r0, "$this$scrollToTop");     // Catch: Throwable -> L10
        com.bytedance.android.shopping.new_cart.utils.a.c.d("scrollToTop", new h(r0));     // Catch: Throwable -> L10
    L8:
        int r3 = getScrollY();     // Catch: Throwable -> L10
        scrollBy(0, -r3);     // Catch: Throwable -> L10
        this.p.startNestedScroll(2, 0);     // Catch: Throwable -> L10
        this.p.scrollBy(0, r3);     // Catch: Throwable -> L10
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int q() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (CartSettingUtils.a() == false) goto L18;
        int r2 = this.p.getBottom();
        if (r2 <= 0) goto L27;
        CartGULView r3 = this.q;
        if (r3.k == false) goto L16;
        if (r3.getHeight() <= 0) goto L16;
        return RangesKt.coerceAtLeast(this.q.getTop(), 0);
    L16:
        if (RangesKt.coerceAtLeast((r1.getHeight() - r2) - this.t, 0) > 0) goto L26;
        return 0;
    L26:
        return RangesKt.coerceAtLeast(r1.getHeight() - getHeight(), 0);
    L27:
        return 0;
    L18:
        View r4 = this.s;
        if (r4 == null) goto L21;
        int r5 = r4.getHeight();
    L23:
        return RangesKt.coerceAtLeast((r1.getHeight() - r5) - getHeight(), 0);
    L21:
        r5 = 0;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final void b() {
        int r0 = this.q.getTop();
        if (r0 <= 0) goto L6;
        scrollBy(0, r0);
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final void c() {
        this.p.stopScroll();
        RecyclerView r0 = this.q.getGULRecyclerView();
        if (r0 == null) goto L5;
        r0.stopScroll();
    L5:
        RecyclerView r1 = this.q.getGULRecyclerView();
        if (r1 == null) goto L8;
        r1.scrollToPosition(0);
    L8:
        scrollTo(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public int getOffsetToBottomScreen() {
        if (getGlobalVisibleRect(this.C) == false) goto L5;
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        return k1.j(getContext()) - this.C.bottom;
    L5:
        return 0;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public String getSessionId() {
        CartObjectContainer r0 = this.u;
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.new_cart.container.b r1 = r0.e;
        if (r1 == null) goto L8;
        String r2 = r1.m;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final boolean a() {
        if (getScrollY() < this.q.getTop()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public int getMaxScrollRange() {
        if (CartSettingUtils.a() == true) goto L7;
        return super.getMaxScrollRange();
    L7:
        return q();
    }

    public final void s() {
        if (CartSettingUtils.a() == true) goto L5;
        return;
    L5:
        RecyclerView r0 = this.p;
        if ((r0 instanceof MaxHeightRecyclerView) == true) goto L8;
        r0 = null;
    L8:
        MaxHeightRecyclerView r1 = (MaxHeightRecyclerView) r0;
        if (r1 != null) goto L11;
        return;
    L11:
        r1.setFooterRoundCornerExtraHeight(this.t);
        int r2 = this.r.getHeight();
        ViewGroup.LayoutParams r3 = this.r.getLayoutParams();
        int r4 = 0;
        if (r3 == null) goto L14;
        int r5 = r3.height;
    L15:
        int r6 = RangesKt.coerceAtLeast(r2, r5);
        if (this.r.getVisibility() != 0) goto L18;
        if (r6 <= 0) goto L18;
    L22:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        r4 = this.t;
    L27:
        r1.setFooterRoundCornerPaddingBottom(r4);
        return;
    L18:
        CartGULView r8 = this.q;
        if (r8.k == true) goto L21;
    L23:
        r7 = false;
        goto L24
    L21:
        if (r8.getHeight() <= 0) goto L23;
    L14:
        r5 = 0;
        goto L15
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public RecyclerView getCartRev() {
        return this.p;
    }

    public final CartGULView getGul() {
        return this.q;
    }

    public final LoadMoreFooterView getLoadingFooter() {
        return this.r;
    }

    public final int getOuterHeight() {
        return this.z;
    }

    public final int getPhysicalHeight() {
        return this.A;
    }

    public RecyclerView getYataBody() {
        return this.p;
    }

    public static final void k(CartLinkedScrollViewV2 r7) {
        CartObjectContainer r0 = r7.u;
        if (r0 == null) goto L49;
        com.bytedance.android.shopping.new_cart.container.b r1 = r0.e;
        if (r1 == null) goto L50;
        Function0<AndroidYaTaInstance> r2 = r1.d;
        if (r2 == null) goto L51;
        AndroidYaTaInstance r3 = (AndroidYaTaInstance) r2.invoke();
        if (r3 == null) goto L54;
        View r4 = r3.K("cart_tab_1");
        if (r4 == null) goto L14;
        ViewParent r5 = r4.getParent();
    L16:
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L22:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r6), r7.B)) == false) goto L52;
        r7.B = Boolean.valueOf(r6);
        List r8 = r3.n("body");
        if (r8 == null) goto L39;
        Iterator r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L37;
        Object r10 = r9.next();
        com.bytedance.kmp.ec.yata.store.node.c r11 = (com.bytedance.kmp.ec.yata.store.node.c) r10;
        if ((r11 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L31;
        r11 = null;
    L31:
        if (r11 == null) goto L33;
        String r12 = r11.getNodeName();
    L35:
        if (Intrinsics.areEqual(r12, "cart_tab") == false) goto L27;
    L38:
        com.bytedance.kmp.ec.yata.store.node.c r13 = (com.bytedance.kmp.ec.yata.store.node.c) r10;
    L40:
        if (r13 == null) goto L53;
        if (r6 == false) goto L43;
        String r14 = "cart_tab_on_screen";
    L44:
        bg3.a r15 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(r7.getCartVM(), r14, new com.bytedance.android.shopping.new_cart.widgets.nest.c(r14, r6, r3, r13), null);
        return;
    L43:
        r14 = "cart_tab_not_on_screen";
        goto L44
    L53:
        return;
    L33:
        r12 = null;
        goto L35
    L37:
        r10 = null;
        goto L38
    L39:
        r13 = null;
        goto L40
    L52:
        return;
    L18:
        if (r4.getBottom() <= 0) goto L20;
        r6 = true;
        goto L22
    L14:
        r5 = null;
        goto L16
    L54:
        return;
    L51:
        return;
    L50:
        return;
    }

    public static final /* synthetic */ CartBackToTopBtnManageComponent l(CartLinkedScrollViewV2 r0) {
        return r0.getCartBackToTopBtnManageComponent();
    }

    public static final /* synthetic */ CartLoadMoreComponent m(CartLinkedScrollViewV2 r0) {
        return r0.getCartLoadMoreComponent();
    }

    public static final /* synthetic */ CartViewModel n(CartLinkedScrollViewV2 r0) {
        return r0.getCartVM();
    }

    public static final /* synthetic */ CartSliceCustomWidgetAdapterComponent o(CartLinkedScrollViewV2 r0) {
        return r0.getSliceCustomWidgetAdapterComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(CartLinkedScrollViewV2 r9) {
        View r0 = r9.getRootView();
        if (r0 == null) goto L105;
        View r1 = r0.findViewById(2131385090);
        if (r1 == null) goto L112;
        CartObjectContainer r2 = r9.u;
        if (r2 == null) goto L106;
        com.bytedance.android.shopping.new_cart.container.b r3 = r2.e;
        if (r3 == null) goto L107;
        Function0<AndroidYaTaInstance> r4 = r3.d;
        if (r4 == null) goto L108;
        AndroidYaTaInstance r5 = (AndroidYaTaInstance) r4.invoke();
        if (r5 == null) goto L113;
        List r6 = r5.n("body");
        Object r7 = null;
        if (r6 == null) goto L32;
        Iterator r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L30;
        Object r10 = r8.next();
        com.bytedance.kmp.ec.yata.store.node.c r11 = (com.bytedance.kmp.ec.yata.store.node.c) r10;
        if ((r11 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L24;
        r11 = null;
    L24:
        if (r11 == null) goto L26;
        String r12 = r11.getNodeName();
    L28:
        if (Intrinsics.areEqual(r12, "save_card_bar_inflow") == false) goto L20;
    L31:
        com.bytedance.kmp.ec.yata.store.node.c r13 = (com.bytedance.kmp.ec.yata.store.node.c) r10;
    L34:
        if (r6 == null) goto L52;
        Iterator r14 = r6.iterator();
    L37:
        if (r14.hasNext() == false) goto L47;
        Object r15 = r14.next();
        com.bytedance.kmp.ec.yata.store.node.c r16 = (com.bytedance.kmp.ec.yata.store.node.c) r15;
        if ((r16 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L41;
        r16 = null;
    L41:
        if (r16 == null) goto L43;
        String r17 = r16.getNodeName();
    L45:
        if (Intrinsics.areEqual(r17, "save_card_bar_sticky") == false) goto L37;
    L48:
        com.bytedance.kmp.ec.yata.store.node.c r18 = (com.bytedance.kmp.ec.yata.store.node.c) r15;
        if (r18 == null) goto L52;
        r7 = r18;
    L67:
        int r19 = 8;
        if (r13 == null) goto L93;
        if (r7 == null) goto L93;
        View r20 = r5.K(r13.getKey());
        if (r20 != null) goto L75;
        return;
    L75:
        if (r20.getHeight() <= 0) goto L115;
        int[] r21 = new int[2];
        int[] r22 = new int[2];
        r9.getLocationOnScreen(r21);
        r20.getLocationOnScreen(r22);
        boolean r23 = true;
        int r24 = r22[1] - r21[1];
        if (r1.getVisibility() != 0) goto L80;
        boolean r25 = true;
    L81:
        if (r25 == false) goto L85;
        if (r24 <= 2) goto L88;
    L87:
        r23 = false;
    L88:
        if (r23 == r25) goto L109;
        if (r23 == false) goto L91;
        r19 = 0;
    L91:
        r1.setVisibility(r19);
        return;
    L109:
        return;
    L85:
        if (r24 > (-2)) goto L87;
    L80:
        r25 = false;
        goto L81
    L115:
        return;
    L93:
        if (r1.getVisibility() != 0) goto L111;
        r1.setVisibility(8);
        return;
    L111:
        return;
    L43:
        r17 = null;
        goto L45
    L47:
        r15 = null;
    L52:
        List r26 = r5.n("save_card_sticky");
        if (r26 == null) goto L67;
        Iterator r27 = r26.iterator();
    L56:
        if (r27.hasNext() == false) goto L66;
        Object r28 = r27.next();
        com.bytedance.kmp.ec.yata.store.node.c r29 = (com.bytedance.kmp.ec.yata.store.node.c) r28;
        if ((r29 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L60;
        r29 = null;
    L60:
        if (r29 == null) goto L62;
        String r30 = r29.getNodeName();
    L64:
        if (Intrinsics.areEqual(r30, "save_card_bar_sticky") == false) goto L56;
        r7 = r28;
        goto L66
    L62:
        r30 = null;
    L66:
        r7 = (com.bytedance.kmp.ec.yata.store.node.c) r7;
        goto L67
    L26:
        r12 = null;
        goto L28
    L30:
        r10 = null;
        goto L31
    L32:
        r13 = null;
        goto L34
    L113:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L112:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r2) {
        if (CartSettingUtils.a() == false) goto L5;
        if (r2 <= 0) goto L12;
        if (getScrollY() >= q()) goto L10;
        return true;
    L10:
        return false;
    L12:
        return super/*android.widget.FrameLayout*/.canScrollVertically(r2);
    L5:
        return super/*android.widget.FrameLayout*/.canScrollVertically(r2);
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public final void g(int r4) {
        CartBackToTopBtnManageComponent r0 = getCartBackToTopBtnManageComponent();
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) r0.c.getValue()).booleanValue() == false) goto L22;
        View r1 = r0.f;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.getVisibility() == 0) goto L13;
        return;
    L13:
        if (r4 != 2) goto L15;
        View r5 = r0.f;
        r5.animate().cancel();
        r5.setAlpha(0.5f);
        r5.animate().alpha(0.5f).setDuration(300).withStartAction(new com.bytedance.android.shopping.new_cart.components.b(r5)).start();
        return;
    L15:
        if (r4 != 0) goto L21;
        View r6 = r0.f;
        r6.animate().cancel();
        r6.animate().alpha(1.0f).setStartDelay(1000).setDuration(500).start();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public final RecyclerView.OnScrollListener h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        final et3.c r0 = new et3.c("yata_cart", true, null);
        r0.c(new d(this, r5));
        return new CartLinkedScrollViewV2$getFpsHook$2(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public final void i(int r2) {
        post(new e(this, r2));
    }

    public final void r(int r3) {
        if (CartSettingUtils.a() == false) goto L7;
        int r4 = RangesKt.coerceAtLeast(r3, 0);
        this.t = r4;
        this.q.setFooterRoundCornerExtraHeight(r4);
        s();
        View r5 = this.s;
        if (r5 == null) goto L11;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        r0.height = this.t;
        Unit r1 = Unit.INSTANCE;
        r5.setLayoutParams(r0);
        r5.requestLayout();
        return;
    L11:
        return;
    L7:
        View r2 = this.s;
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        r6.height = r3;
        Unit r7 = Unit.INSTANCE;
        r2.setLayoutParams(r6);
        r2.requestLayout();
        return;
    }

    public final void setCartObjectContainer(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.u = r2;
        this.q.setObjectContainer(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOuterHeight(int r3) {
        if (this.z == r3) goto L15;
        RecyclerView r0 = this.p;
        if ((r0 instanceof MaxHeightRecyclerView) == true) goto L7;
        r0 = null;
    L7:
        MaxHeightRecyclerView r1 = (MaxHeightRecyclerView) r0;
        if (r1 == null) goto L10;
        r1.setMaxHeight(r3);
    L10:
        this.q.setOuterHeight(r3);
        if (CartSettingUtils.a() == true) goto L15;
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 == null) goto L15;
        r2.height = r3;
    L15:
        this.z = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPhysicalHeight(int r2) {
        if (this.A != r2) goto L5;
    L10:
        this.A = r2;
        return;
    L5:
        if (CartSettingUtils.a() == false) goto L10;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L9;
        r0.height = r2;
    L9:
        requestLayout();
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTopView(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        removeView(this.p);
        ViewGroup r0 = getInnerLayout();
        if (r0 == null) goto L8;
        r0.addView(r3, 0);
        return;
    }

    public final void scrollTo(int r2, int r3) {
        if (CartSettingUtils.a() == true) goto L6;
        super.scrollTo(r2, r3);
        return;
    L6:
        int r0 = q();
        if (r0 <= 0) goto L9;
        r3 = RangesKt.coerceAtMost(r3, r0);
    L9:
        super.scrollTo(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.widgets.LoadMoreFooterView] */
    public CartLinkedScrollViewV2(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.v = LazyKt.lazy(new CartLinkedScrollViewV2$cartLoadMoreComponent$2(this));
        this.w = LazyKt.lazy(new CartLinkedScrollViewV2$sliceCustomWidgetAdapterComponent$2(this));
        this.x = LazyKt.lazy(new CartLinkedScrollViewV2$cartVM$2(this));
        this.y = LazyKt.lazy(new CartLinkedScrollViewV2$cartBackToTopBtnManageComponent$2(this));
        LayoutInflater.from(r3).inflate(2131563707, this, true);
        setInnerLayout((ViewGroup) findViewById(2131367728));
        RecyclerView r6 = findViewById(2131384480);
        r6.setLayoutManager(new LinearLayoutManager(r3, 1, false));
        j("rev1", r6);
        Unit r7 = Unit.INSTANCE;
        this.p = r6;
        CartGULView r8 = (CartGULView) findViewById(2131380663);
        r8.setSetUpCallBack(new CartLinkedScrollViewV2$$special$$inlined$apply$lambda$1(this));
        r8.setOuterScrollView(this);
        this.q = r8;
        ?? r9 = (LoadMoreFooterView) findViewById(2131378951);
        this.r = r9;
        r9.addOnLayoutChangeListener(new a(this));
        r8.addOnLayoutChangeListener(new b(this));
        this.s = findViewById(2131373150);
        jh.b.a r10 = jh.b.c;
        q r11 = new q(MonitorScenes.FPS_SCENE_EC_CART_LIST.getSceneName());
        r10.getClass();
        jh.b.a.c(r11).c(r6);
        this.C = new Rect();
        this.D = new CartLinkedScrollViewV2$fpsCallback$1(this);
    }

    public /* synthetic */ CartLinkedScrollViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
