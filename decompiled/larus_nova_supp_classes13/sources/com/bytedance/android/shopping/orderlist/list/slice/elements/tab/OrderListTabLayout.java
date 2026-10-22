package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.store.window.popup.ShopPopupWindowManager;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.ui.base.widget.round.RoundView;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u0004\u0018\u00010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\b\u0010\f\u001a\u0004\u0018\u00010\bJ\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabLayout;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundLinearlayout;", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/e;", "event", "", "onTabBubbleEvent", "", "getTabSize", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabLayout$a;", "getSelectedViewInfo", "getSelectedRightViewInfo", "getSelectedLeftViewInfo", "getFirstViewInfo", "getLastViewInfo", "", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/g;", "tabList", "setTabAccessible", "tabInfo", "setStartTabAccessible", "setOtherTabsAccessible", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BindType", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListTabLayout extends SlcRoundLinearlayout {
    public final FrameLayout a;
    public final LinearLayout b;
    public final RoundView c;
    public final Space d;
    public boolean e;
    public f f;
    public f g;
    public final LinkedHashMap<Integer, a> h;
    public final b i;
    public PopupWindow j;
    public Integer k;
    public boolean l;
    public LifecycleOwner m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabLayout$BindType;", "", "FULL_INIT", "DIFF_UPDATE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BindType extends Enum<BindType> {
        public static final BindType DIFF_UPDATE = null;
        public static final BindType FULL_INIT = null;
        public static final /* synthetic */ BindType[] a = null;

        static {
            BindType r1 = new BindType("FULL_INIT", 0);
            FULL_INIT = r1;
            BindType r2 = new BindType("DIFF_UPDATE", 1);
            DIFF_UPDATE = r2;
            a = new BindType[]{r1, r2};
        }

        public static BindType valueOf(String r1) {
            return (BindType) r27.a.a(BindType.class, r1);
        }

        public static BindType[] values() {
            return (BindType[]) a.clone();
        }

        public BindType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public g a;
        public final OrderListTabItemView b;

        public a(g r2, OrderListTabItemView r3) {
            Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
            Intrinsics.checkNotNullParameter(r3, "itemTabView");
            this.a = r2;
            this.b = r3;
        }
    }

    public OrderListTabLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderListTabLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void d() {
        PopupWindow r0 = this.j;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.j = null;
        this.k = null;
        this.l = false;
    }

    public final a getFirstViewInfo() {
        Iterator<Map.Entry<Integer, a>> r0 = this.h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r1 = r0.next();
        if (r1.getValue().a.g == false) goto L4;
        return r1.getValue();
    L9:
        return null;
    }

    public final a getLastViewInfo() {
        Iterator<Map.Entry<Integer, a>> r0 = this.h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r1 = r0.next();
        if (r1.getValue().a.h == false) goto L4;
        return r1.getValue();
    L9:
        return null;
    }

    public final a getSelectedLeftViewInfo() {
        List r0 = MapsKt.toList(this.h);
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L15;
        Object r3 = r1.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) ((Pair) r3).getSecond()).a.f == true) goto L10;
        r2 = r5;
        goto L4
    L10:
        Pair r4 = (Pair) CollectionsKt.getOrNull(r0, r2 - 1);
        if (r4 != null) goto L13;
        return null;
    L13:
        return (a) r4.getSecond();
    L15:
        return null;
    }

    public final a getSelectedRightViewInfo() {
        List r0 = MapsKt.toList(this.h);
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L15;
        Object r3 = r1.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) ((Pair) r3).getSecond()).a.f == true) goto L10;
        r2 = r5;
        goto L4
    L10:
        Pair r4 = (Pair) CollectionsKt.getOrNull(r0, r5);
        if (r4 != null) goto L13;
        return null;
    L13:
        return (a) r4.getSecond();
    L15:
        return null;
    }

    public final a getSelectedViewInfo() {
        Iterator<Map.Entry<Integer, a>> r0 = this.h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r1 = r0.next();
        if (r1.getValue().a.f == false) goto L4;
        return r1.getValue();
    L9:
        return null;
    }

    public final int getTabSize() {
        return this.h.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.LinearLayout*/.onAttachedToWindow();
        s0.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        d();
        s0.e(this);
        this.m = null;
        super/*android.widget.LinearLayout*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setOtherTabsAccessible(g r8) {
        a r0 = e(r8.d);
        if (r0 == null) goto L42;
        ConstraintLayout r1 = r0.b;
        if (r1 == null) goto L43;
        g r2 = r0.a;
        String r3 = null;
        if (r2 == null) goto L9;
        String r4 = r2.b;
    L11:
        if (r4 == null) goto L31;
        if (f(r8.d) == false) goto L22;
        Resources r9 = getResources();
        Object[] r5 = new Object[2];
        g r6 = r0.a;
        if (r6 == null) goto L17;
        String r7 = r6.a;
    L18:
        r5[0] = r7;
        if (r6 == null) goto L21;
        r3 = r6.b;
    L21:
        r5[1] = r3;
        CharSequence r10 = r9.getString(2131912780, r5);
    L40:
        r1.setContentDescription(r10);
        return;
    L17:
        r7 = null;
        goto L18
    L22:
        Resources r11 = getResources();
        Object[] r12 = new Object[2];
        g r13 = r0.a;
        if (r13 == null) goto L25;
        String r14 = r13.a;
    L26:
        r12[0] = r14;
        if (r13 == null) goto L29;
        r3 = r13.b;
    L29:
        r12[1] = r3;
        r10 = r11.getString(2131912781, r12);
        goto L40
    L25:
        r14 = null;
        goto L26
    L31:
        if (f(r8.d) == false) goto L36;
        Resources r15 = getResources();
        Object[] r16 = new Object[1];
        g r17 = r0.a;
        if (r17 == null) goto L35;
        r3 = r17.a;
    L35:
        r16[0] = r3;
        r10 = r15.getString(2131912778, r16);
        goto L40
    L36:
        Resources r18 = getResources();
        Object[] r19 = new Object[1];
        g r20 = r0.a;
        if (r20 == null) goto L39;
        r3 = r20.a;
    L39:
        r19[0] = r3;
        r10 = r18.getString(2131912779, r19);
        goto L40
    L9:
        r4 = null;
        goto L11
    L43:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setStartTabAccessible(g r5) {
        Integer r0 = null;
        if (r5 == null) goto L5;
        Integer r1 = Integer.valueOf(r5.d);
    L6:
        a r2 = e(com.bytedance.android.shopping.extensions.k.f(r1));
        if (r2 == null) goto L17;
        ConstraintLayout r3 = r2.b;
        if (r5 == null) goto L12;
        r0 = Integer.valueOf(r5.d);
    L12:
        if (f(com.bytedance.android.shopping.extensions.k.f(r0)) == false) goto L14;
        CharSequence r6 = getResources().getString(2131912778, new Object[]{r2.a.a});
    L15:
        r3.setContentDescription(r6);
        return;
    L14:
        r6 = getResources().getString(2131912779, new Object[]{r2.a.a});
        goto L15
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void setTabAccessible(List<g> r3) {
        setStartTabAccessible((g) CollectionsKt.firstOrNull(r3));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(r3.subList(1, r3.size()));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = null;
    L10:
        List r5 = (List) r4;
        if (r5 == null) goto L16;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L20;
        setOtherTabsAccessible((g) r6.next());
        goto L14
    L20:
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.LinearLayout*/.dispatchHoverEvent(r1);
    }

    public final a e(int r4) {
        Iterator<Map.Entry<Integer, a>> r0 = this.h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r1 = r0.next();
        if (r1.getKey().intValue() != r4) goto L4;
        return r1.getValue();
    L9:
        return null;
    }

    public final boolean f(int r2) {
        a r0 = getSelectedViewInfo();
        if (r0 == null) goto L9;
        g r1 = r0.a;
        if (r1 == null) goto L9;
        if (r1.d != r2) goto L9;
        return true;
    L9:
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onTabBubbleEvent(e r20) {
        Intrinsics.checkNotNullParameter(r20, "event");
        if (r20.b == false) goto L24;
        int r2 = r20.a;
        String r3 = r20.c;
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        String r8 = r3;
        Long r4 = r20.d;
        boolean r10 = Intrinsics.areEqual(r20.e, Boolean.TRUE);
        int r15 = r20.f;
        if (StringsKt.isBlank(r8) == true) goto L33;
        LifecycleOwner r1 = this.m;
        if (r1 == null) goto L34;
        a r9 = e(r2);
        if (r9 == null) goto L35;
        d();
        ArrayList r7 = new ArrayList();
        if (r10 == false) goto L19;
        r7.add(new sn.d.a());
    L19:
        if (r4 != null) goto L21;
    L23:
        rn.d r5 = new rn.d(r7, new tn.a.c(0, 0, false, r15, new tn.a.a(12.0f, 12.0f, 12.0f, 12.0f)), CollectionsKt.listOf(new rn.c[]{new rn.b(new tn.a.b()), new rn.f(CollectionsKt.emptyList(), new tn.a.e(18, 13, -1, r8, true)), new rn.b(new tn.a.b())}));
        int r6 = ShopPopupWindowManager.a;
        PopupWindow r11 = ShopPopupWindowManager.b(r9.b, r5, r1, ShopPopupWindowManager.PopupPosition.BELOW, ShopPopupWindowManager.PopupRelativeAnchorPosition.HORIZONTAL_CENTER);
        r11.setOnDismissListener(new i(r11, this));
        Unit r12 = Unit.INSTANCE;
        this.j = r11;
        this.k = Integer.valueOf(r2);
        this.l = r10;
        return;
    L21:
        if (r4.longValue() <= 0) goto L23;
        r7.add(new sn.d.c(r4.longValue()));
        goto L23
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L24:
        int r13 = r20.a;
        Integer r14 = this.k;
        if (r14 != null) goto L28;
        return;
    L28:
        if (r14.intValue() != r13) goto L37;
        d();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderListTabLayout(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.h = new LinkedHashMap();
        setOrientation(1);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r7).aU(2131564148, this, true);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, 0, 0);
        FrameLayout r2 = (FrameLayout) findViewById(2131372859);
        this.a = r2;
        this.b = (LinearLayout) findViewById(2131378843);
        RoundView r4 = findViewById(2131388025);
        this.c = r4;
        this.d = (Space) findViewById(2131388051);
        this.i = new b(this, r2, (CustomHorizontalScrollView) findViewById(2131385238), r4, findViewById(2131386044));
    }

    public /* synthetic */ OrderListTabLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, com.bytedance.android.shopping.orderlist.list.slice.elements.tab.OrderListTabItemView] */
    public static final void b(final OrderListTabLayout r6, final Function0 r7, final f r8, final BindType r9) {
        r6.getClass();
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListTabLayout", new OrderListTabLayout$initView$1(r9, r8));
        List<g> r1 = r8.e;
        r6.setTabAccessible(r1);
        if (r9 != BindType.FULL_INIT) goto L34;
        r6.a.removeAllViews();
        r6.b.removeAllViews();
        r6.h.clear();
        Iterator<T> r10 = r1.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        final g r11 = (g) r10.next();
        ?? r2 = new OrderListTabItemView(r6.getContext(), null, 6, 0);
        com.bytedance.android.ec.core.widget.f.c(r2, null, null, new OrderListTabLayout$initView$$inlined$forEach$lambda$1(r11, r6, r7), 3);
        r6.h.put(Integer.valueOf(r11.d), new a(r11, r2));
        goto L6
    L8:
        g r12 = (g) CollectionsKt.firstOrNull(r1);
        if (r12 == null) goto L42;
        a r13 = r6.e(r12.d);
        FrameLayout r3 = r6.a;
        if (r13 == null) goto L13;
        ConstraintLayout r14 = r13.b;
    L14:
        r3.addView(r14, new LinearLayout.LayoutParams(-2, -1));
        goto L42
    L13:
        r14 = null;
    L42:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Object r16 = Result.constructor-impl(r1.subList(1, r1.size()));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r16) == false) goto L22;
        r16 = null;
    L22:
        List r17 = (List) r16;
        if (r17 == null) goto L32;
        Iterator r18 = r17.iterator();
    L26:
        if (r18.hasNext() == false) goto L32;
        a r4 = r6.e(((g) r18.next()).d);
        LinearLayout r5 = r6.b;
        if (r4 == null) goto L30;
        ConstraintLayout r19 = r4.b;
    L31:
        r5.addView(r19, new LinearLayout.LayoutParams(-2, -1));
        goto L26
    L30:
        r19 = null;
    L32:
        r6.b.addView(r6.d);
        return;
    L17:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L34:
        if (r9 != BindType.DIFF_UPDATE) goto L53;
        Iterator<T> r21 = r8.e.iterator();
    L37:
        if (r21.hasNext() == false) goto L54;
        g r22 = (g) r21.next();
        a r23 = r6.h.get(Integer.valueOf(r22.d));
        if (r23 == null) goto L37;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r23.a = r22;
        goto L37
    L54:
        return;
    }

    public final void c(final com.bytedance.android.ecom.arch.slice.render.context.b r8, final Function0<OrderListFragment> r9, final f r10, final BindType r11) {
        Intrinsics.checkNotNullParameter(r8, "slcDisplayMetrics");
        Intrinsics.checkNotNullParameter(r9, "fragmentProvider");
        Intrinsics.checkNotNullParameter(r10, "tabInfo");
        Intrinsics.checkNotNullParameter(r11, "type");
        m.a r0 = m.a;
        m.c(new OrderListTabLayout$bindView$1(this, r9, r10, r11, r8));
    }
}
