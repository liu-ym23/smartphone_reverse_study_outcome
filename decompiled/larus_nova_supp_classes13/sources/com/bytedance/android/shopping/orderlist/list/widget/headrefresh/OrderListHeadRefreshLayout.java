package com.bytedance.android.shopping.orderlist.list.widget.headrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import c53.d;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.c;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/OrderListHeadRefreshLayout;", "Landroid/view/ViewGroup;", "Lc53/d;", "Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;", "d", "Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;", "getHeadRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;", "setHeadRefreshHelper", "(Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;)V", "headRefreshHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MoveState", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListHeadRefreshLayout extends ViewGroup implements d {
    public OrderCommonRefreshSloganView a;
    public OrderListLinkedScrollView b;
    public final TouchHelper c;
    public com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a d;
    public boolean e;
    public MoveState f;
    public final /* synthetic */ c53.b g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/OrderListHeadRefreshLayout$MoveState;", "", "IDLE", "DOWN", "V_MOVING_HEAD", "V_MOVING_CONTENT", "V_MOVING_HEAD_UP_OR_CANCEL", "V_MOVING_CONTENT_UP_OR_CANCEL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MoveState extends Enum<MoveState> {
        public static final MoveState DOWN = null;
        public static final MoveState IDLE = null;
        public static final MoveState V_MOVING_CONTENT = null;
        public static final MoveState V_MOVING_CONTENT_UP_OR_CANCEL = null;
        public static final MoveState V_MOVING_HEAD = null;
        public static final MoveState V_MOVING_HEAD_UP_OR_CANCEL = null;
        public static final /* synthetic */ MoveState[] a = null;

        static {
            MoveState r1 = new MoveState("IDLE", 0);
            IDLE = r1;
            MoveState r2 = new MoveState("DOWN", 1);
            DOWN = r2;
            MoveState r3 = new MoveState("V_MOVING_HEAD", 2);
            V_MOVING_HEAD = r3;
            MoveState r4 = new MoveState("V_MOVING_CONTENT", 3);
            V_MOVING_CONTENT = r4;
            MoveState r5 = new MoveState("V_MOVING_HEAD_UP_OR_CANCEL", 4);
            V_MOVING_HEAD_UP_OR_CANCEL = r5;
            MoveState r6 = new MoveState("V_MOVING_CONTENT_UP_OR_CANCEL", 5);
            V_MOVING_CONTENT_UP_OR_CANCEL = r6;
            a = new MoveState[]{r1, r2, r3, r4, r5, r6};
        }

        public static MoveState valueOf(String r1) {
            return (MoveState) r27.a.a(MoveState.class, r1);
        }

        public static MoveState[] values() {
            return (MoveState[]) a.clone();
        }

        public MoveState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements com.bytedance.android.shopping.orderlist.common.widgets.touch.b {
        public final /* synthetic */ OrderListHeadRefreshLayout a;

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void onCancel() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void onClick() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void c() {
            OrderListHeadRefreshLayout r0 = this.a;
            r0.f = MoveState.DOWN;
            OrderListHeadRefreshLayout.a(r0, "[onDownState]->[下发事件]->[手指处于按下状态]");
        }

        public a(OrderListHeadRefreshLayout r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void a(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r3, "moveToMoveInfo");
            com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r4 = this.a.getHeadRefreshHelper();
            if (r4 != null) goto L5;
        L7:
            OrderListLinkedScrollView r5 = this.a.b;
            if (r5 != null) goto L10;
        L16:
            OrderListHeadRefreshLayout r6 = this.a;
            r6.f = MoveState.V_MOVING_CONTENT;
            OrderListHeadRefreshLayout.a(r6, "[下滑]->[下发事件]->[其他情况]->[内容下滑]");
            return;
        L10:
            if (r5.i(r5.a) != true) goto L16;
            OrderListLinkedScrollView r7 = this.a.b;
            if (r7 == null) goto L16;
            if (r7.a.a() == true) goto L16;
            OrderListHeadRefreshLayout r8 = this.a;
            r8.f = MoveState.V_MOVING_HEAD;
            OrderListHeadRefreshLayout.a(r8, "[下滑]->[不下发事件]->[当前Yata完全展示 && Yata无法下滑]->[响应Head下拉]");
            return;
        L5:
            if (r4.g() != true) goto L7;
            OrderListHeadRefreshLayout r9 = this.a;
            r9.f = MoveState.V_MOVING_HEAD;
            OrderListHeadRefreshLayout.a(r9, "[下滑]->[不下发事件]->[Head正在展示]->[当前处于Head下拉状态，需要持续响应Move事件，同时需要计算Head的动画效果]");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void b(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r3, "moveToMoveInfo");
            com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r4 = this.a.getHeadRefreshHelper();
            if (r4 != null) goto L5;
        L7:
            OrderListHeadRefreshLayout r5 = this.a;
            r5.f = MoveState.V_MOVING_CONTENT;
            OrderListHeadRefreshLayout.a(r5, "[上滑]->[下发事件]->[其他情况]->[内容上滑]");
            return;
        L5:
            if (r4.g() != true) goto L7;
            OrderListHeadRefreshLayout r6 = this.a;
            r6.f = MoveState.V_MOVING_HEAD;
            OrderListHeadRefreshLayout.a(r6, "[上滑]->[不下发事件]->[Head正在展示]->[当前处于Head上拉状态，需要持续响应Move事件，同时需要计算Head的动画效果]");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void d(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r3, "moveToMoveInfo");
            com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r4 = this.a.getHeadRefreshHelper();
            if (r4 != null) goto L5;
        L7:
            OrderListHeadRefreshLayout r5 = this.a;
            r5.f = MoveState.V_MOVING_CONTENT_UP_OR_CANCEL;
            OrderListHeadRefreshLayout.a(r5, "[竖向滑动抬起]->[下发事件]->[Head不可见]");
            return;
        L5:
            if (r4.g() != true) goto L7;
            OrderListHeadRefreshLayout r6 = this.a;
            r6.f = MoveState.V_MOVING_HEAD_UP_OR_CANCEL;
            OrderListHeadRefreshLayout.a(r6, "[竖向滑动抬起]->[不下发事件]->[Head可见]");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void e(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r3, c r4) {
            Intrinsics.checkNotNullParameter(r3, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r4, "moveToMoveInfo");
            Intrinsics.checkNotNullParameter(r3, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r4, "moveToMoveInfo");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void f(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r3, c r4) {
            Intrinsics.checkNotNullParameter(r3, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r4, "moveToMoveInfo");
            Intrinsics.checkNotNullParameter(r3, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r4, "moveToMoveInfo");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void g(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r3, c r4) {
            Intrinsics.checkNotNullParameter(r3, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r4, "moveToMoveInfo");
            Intrinsics.checkNotNullParameter(r3, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r4, "moveToMoveInfo");
        }
    }

    public OrderListHeadRefreshLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderListHeadRefreshLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.g.add(r2);
        return r2;
    }

    public final void doClear() {
        this.g.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.g.remove(r2);
    }

    @Override // android.view.View
    public final void computeScroll() {
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.computeScroll();
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r0 = qc3.a.c(this, 0);
        View r2 = null;
        if ((r0 instanceof OrderCommonRefreshSloganView) == true) goto L5;
        r0 = null;
    L5:
        this.a = (OrderCommonRefreshSloganView) r0;
        View r1 = qc3.a.c(this, 1);
        if ((r1 instanceof OrderListLinkedScrollView) == false) goto L9;
        r2 = r1;
    L9:
        this.b = (OrderListLinkedScrollView) r2;
    }

    public final com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a getHeadRefreshHelper() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.e == false) goto L5;
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r0 = this.d;
        if (r0 != null) goto L9;
    L11:
        this.c.a(r5, new a(this));
        MoveState r1 = this.f;
        int r2 = b.a[r1.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L23;
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r3 = this.d;
        if (r3 == null) goto L23;
        r3.c();
    L23:
        MoveState r4 = this.f;
        int r6 = b.b[r4.ordinal()];
        if (r6 == 1) goto L28;
        if (r6 != 2) goto L27;
        return true;
    L27:
        return super.dispatchTouchEvent(r5);
    L28:
        return true;
    L18:
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r7 = this.d;
        if (r7 == null) goto L21;
        Integer r8 = Integer.valueOf(r7.a(this.c.b));
    L22:
        scrollBy(0, k.f(r8));
        goto L23
    L21:
        r8 = null;
        goto L22
    L9:
        if (r0.b() != true) goto L11;
        return true;
    L5:
        return super.dispatchTouchEvent(r5);
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.g.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    public final void setHeadRefreshHelper(com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r1) {
        this.d = r1;
    }

    public static final void a(final OrderListHeadRefreshLayout r1, final String r2) {
        r1.getClass();
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListHeadRefreshLayout", new OrderListHeadRefreshLayout$logDispatchTouchEvent$1(r1, r2));
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        measureChildren(r1, r2);
    }

    @Override // android.view.View
    public final void scrollTo(int r3, int r4) {
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.f(r4);
    L5:
        if (r4 == 0) goto L7;
    L9:
        if (r4 <= 0) goto L11;
        r4 = 0;
    L11:
        super.scrollTo(r3, r4);
        return;
    L7:
        if (this.f != MoveState.V_MOVING_HEAD_UP_OR_CANCEL) goto L9;
        this.f = MoveState.IDLE;
        goto L9
    }

    public OrderListHeadRefreshLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = new c53.b();
        this.c = new TouchHelper(r2);
        this.e = true;
        this.f = MoveState.IDLE;
    }

    public /* synthetic */ OrderListHeadRefreshLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        OrderCommonRefreshSloganView r7 = this.a;
        if (r7 == null) goto L5;
        int r8 = r7.getMeasuredHeight();
    L6:
        OrderListLinkedScrollView r9 = this.b;
        if (r9 == null) goto L9;
        int r10 = r9.getMeasuredHeight();
    L10:
        OrderCommonRefreshSloganView r0 = this.a;
        if (r0 == null) goto L13;
        r0.layout(r3, 0 - r8, r5, 0);
    L13:
        OrderListLinkedScrollView r11 = this.b;
        if (r11 == null) goto L17;
        r11.layout(r3, 0, r5, r10);
        return;
    L17:
        return;
    L9:
        r10 = 0;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }
}
