package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u000f\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/BaseLinkedScrollView;", "Landroid/widget/FrameLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "getYataRecyclerView", "Lkotlin/Function0;", "", "action", "setErrorRetryListener", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/b;", "getVerticalOffset", "Ljg3/b;", "b", "Lkotlin/Lazy;", "getGulContainer", "()Ljg3/b;", "gulContainer", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/a;", "e", "getFootRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/a;", "footRefreshHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseLinkedScrollView extends FrameLayout {
    public static final /* synthetic */ int l = 0;
    public final OrderCommonYataView a;
    public final Lazy b;
    public View c;
    public final OrderCommonRefreshSloganView d;
    public final Lazy e;
    public final TouchHelper f;
    public final LinkedScrollFlingHelper g;
    public int h;
    public int i;
    public final ConcurrentHashMap<String, c> j;
    public final a k;

    public static final class a implements c {
        public final /* synthetic */ BaseLinkedScrollView a;

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void a() {
            Iterator<Map.Entry<String, c>> r0 = this.a.j.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().getValue().a();
            goto L4
        }

        public a(BaseLinkedScrollView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void c(float r3) {
            Iterator<Map.Entry<String, c>> r0 = this.a.j.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().getValue().c(r3);
            goto L4
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void onScrollStateChanged(int r3) {
            BaseLinkedScrollView r0 = this.a;
            if (r0.i != r3) goto L5;
            return;
        L5:
            r0.i = r3;
            Iterator<Map.Entry<String, c>> r1 = r0.j.entrySet().iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            r1.next().getValue().onScrollStateChanged(r3);
            goto L7
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void b(int r3, b r4) {
            Intrinsics.checkNotNullParameter(r4, "verticalOffsetInfo");
            Iterator<Map.Entry<String, c>> r0 = this.a.j.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().getValue().b(r3, r4);
            goto L4
        }
    }

    public BaseLinkedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseLinkedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a c(jg3.b r1, OrderCommonYataView r2, OrderCommonRefreshSloganView r3);

    public abstract jg3.b d();

    public final com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a getFootRefreshHelper() {
        return (com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a) this.e.getValue();
    }

    public final jg3.b getGulContainer() {
        return (jg3.b) this.b.getValue();
    }

    public abstract boolean l();

    public final boolean b() {
        if (this.a.c == false) goto L6;
        return false;
    L6:
        return l();
    }

    @Override // android.view.View
    public final void computeScroll() {
        LinkedScrollFlingHelper r0 = this.g;
        r0.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r0.a.computeScrollOffset() == false) goto L6;
        int r2 = r0.a.getCurrY();     // Catch: Throwable -> L9
        int r3 = r2 - r0.c;     // Catch: Throwable -> L9
        r0.e.invoke(Integer.valueOf(r3));     // Catch: Throwable -> L9
        r0.c = r2;     // Catch: Throwable -> L9
        r0.d.invalidate();     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r0.f.invoke();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final b getVerticalOffset() {
        return new b(this.a.getYataRecyclerView().computeVerticalScrollOffset(), getGulContainer().getGULVerticalOffset(), getScrollY());
    }

    public final RecyclerView getYataRecyclerView() {
        return this.a.getYataRecyclerView();
    }

    public final void n() {
        this.g.a();
        setScrollY(0);
        this.a.d();
        getGulContainer().t0();
        this.k.a();
    }

    public static void j(final String r1) {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logDispatchScrollY$1(r1));
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r4) {
        if (r4 <= 0) goto L8;
        if (getScrollY() < this.h) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (getScrollY() <= 0) goto L10;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedScrollView", new AnonymousClass1(r6));
        this.f.a(r6, null);
        LinkedScrollFlingHelper r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        OrderCommonLog.a("LinkedScrollFlingHelper", new LinkedScrollFlingHelper$dispatchTouchEvent$1(r6));
        if (r6.getAction() != 0) goto L5;
    L6:
        r2.a();
        r2.b.clear();
    L7:
        TouchHelper.TouchIntent r0 = this.f.c;
        if (r0 != TouchHelper.TouchIntent.V_MOVING_UP) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L17:
        OrderCommonLog.a("BaseLinkedScrollView", AnonymousClass2.INSTANCE);
        if (canScrollVertically(-1) == false) goto L20;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == false) goto L28;
        getParent().requestDisallowInterceptTouchEvent(true);
    L29:
        final boolean r5 = super.dispatchTouchEvent(r6);
        OrderCommonLog.a("BaseLinkedScrollView", new AnonymousClass3(r6, r5));
        return r5;
    L28:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L29
    L20:
        if (this.a.a() == true) goto L25;
        if (getGulContainer().a() == true) goto L25;
        r4 = false;
        goto L26
    L13:
        if (r0 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L29;
    L15:
        r7 = false;
        goto L16
    L10:
        r3 = false;
        goto L11
    L5:
        if (r6.getAction() != 3) goto L7;
        goto L6
    }

    public final void e(int r11) {
        if (r11 != 0) goto L4;
        return;
    L4:
        this.k.b(r11, getVerticalOffset());
        if (r11 <= 0) goto L52;
        boolean r5 = i(this.a);
        boolean r6 = i(getGulContainer());
        boolean r7 = i(this.d);
        boolean r8 = h(this.d);
        if (r5 == true) goto L9;
    L11:
        if (r5 == true) goto L13;
    L17:
        if (r5 == true) goto L19;
    L25:
        if (r5 == true) goto L27;
    L33:
        if (r7 == true) goto L35;
        if (r8 == false) goto L42;
        if (r7 == true) goto L42;
        j("[Foot部分展示]->[容器消费滑动]  " + r11);
        scrollBy(0, r11);
        this.k.onScrollStateChanged(3);
        return;
    L42:
        if (r6 == false) goto L47;
        if (getGulContainer().c() == false) goto L47;
        j("[GUL完全展示 && GUL可以上滑]->[GUL消费滑动]  " + r11);
        getGulContainer().scrollBy(0, r11);
        this.k.onScrollStateChanged(2);
        return;
    L47:
        if (canScrollVertically(r11) == false) goto L50;
        j("[兜底逻辑，容器可以滑动]->[容器消费滑动]  " + r11);
        scrollBy(0, r11);
        this.k.onScrollStateChanged(3);
        return;
    L50:
        if (canScrollVertically(r11) == true) goto L76;
        j("[兜底逻辑，容器不能滑动]->[无消费]  " + r11);
        this.g.a();
        this.k.onScrollStateChanged(0);
        return;
    L76:
        return;
    L35:
        if (b() == false) goto L37;
        j("[Foot完全展示到底 && Yata需要加载更多]->[启动yataFootRefresh，Foot到底部无消费]  " + r11);
        getFootRefreshHelper().e();
        this.g.a();
    L38:
        this.k.onScrollStateChanged(0);
        return;
    L37:
        j("[Foot完全展示到底 && Yata不需要加载更多]->[兜底启动gulFootRefresh，Foot到底部无消费]  " + r11);
        getFootRefreshHelper().b();
        this.g.a();
        goto L38
    L27:
        if (this.a.b() == true) goto L33;
        if (b() == true) goto L33;
        if (getGulContainer().b() == false) goto L33;
        j("[Yata完全展示 && Yata不可以上滑 && Yata不需要加载更多 && GUL加载完成]->[隐藏Foot，展示GUL，容器消费滑动]  " + r11);
        getFootRefreshHelper().a();
        getGulContainer().show();
        scrollBy(0, r11);
        this.k.onScrollStateChanged(3);
        return;
    L19:
        if (this.a.b() == true) goto L25;
        if (b() == true) goto L25;
        if (getGulContainer().isLoading() == false) goto L25;
        j("[Yata完全展示 && Yata不可以上滑 && Yata不需要加载更多 && GUL正在加载]->[显示Foot,容器消费滑动]  " + r11);
        getFootRefreshHelper().d();
        scrollBy(0, r11);
        getGulContainer().f(new BaseLinkedScrollView$dispatchMovingUp$1(this));
        this.k.onScrollStateChanged(3);
        return;
    L13:
        if (this.a.b() == true) goto L17;
        if (b() == false) goto L17;
        j("[Yata完全展示 && Yata不可以上滑  && Yata需要加载更多]->[启动YataFootRefresh, 容器消费滑动]  " + r11);
        getFootRefreshHelper().e();
        scrollBy(0, r11);
        this.k.onScrollStateChanged(3);
        return;
    L9:
        if (this.a.b() == false) goto L11;
        j("[Yata完全展示 && Yata可以上滑]->Yata消费上滑 " + r11);
        this.a.scrollBy(0, r11);
        this.k.onScrollStateChanged(1);
        return;
    L52:
        boolean r9 = i(this.a);
        if (i(getGulContainer()) == true) goto L55;
    L57:
        if (r9 == false) goto L62;
        if (this.a.a() == false) goto L62;
        j("[Yata完全展示 && Yata可以下滑]->[Yata消费滑动]  " + r11);
        this.a.scrollBy(0, r11);
        this.k.onScrollStateChanged(1);
        return;
    L62:
        if (canScrollVertically(r11) == false) goto L65;
        j("[兜底逻辑，容器可以下滑]->[容器消费滑动]  " + r11);
        scrollBy(0, r11);
        this.k.onScrollStateChanged(3);
        return;
    L65:
        if (canScrollVertically(r11) == true) goto L81;
        j("[兜底逻辑，容器不能滑动]->[无消费]  " + r11);
        this.g.a();
        this.k.onScrollStateChanged(0);
        return;
    L81:
        return;
    L55:
        if (getGulContainer().a() == false) goto L57;
        j("[GUL完全展示 && GUL可以下滑]->[GUL消费滑动]  " + r11);
        getGulContainer().scrollBy(0, r11);
        this.k.onScrollStateChanged(2);
    }

    public final void f(final boolean r3) {
        OrderCommonErrorMonitorKt.c(null, "BaseLinkedScrollView-handleYataExpandErrorCase", new BaseLinkedScrollView$handleYataExpandErrorCase$1(this, r3));
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c(r2, BaseLinkedScrollView$hideGUL$1.INSTANCE);
        getGulContainer().e(r2);
    }

    public final boolean h(OrderCommonRefreshSloganView r3) {
        if (r3.getMeasuredHeight() != 0) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3, this.d) == false) goto L12;
        if (getScrollY() <= 0) goto L13;
        return true;
    L13:
        return false;
    L12:
        throw new Exception("view must in (footContainer)");
    }

    public final boolean i(Object r5) {
        if ((r5 instanceof View) == true) goto L5;
        return false;
    L5:
        View r0 = (View) r5;
        if (r0.getMeasuredHeight() != 0) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5, this.a) == true) goto L26;
        if (Intrinsics.areEqual(r5, getGulContainer()) == true) goto L26;
        if (Intrinsics.areEqual(r5, this.d) == false) goto L24;
        if (getScrollY() < this.d.getMeasuredHeight()) goto L18;
    L21:
        return true;
    L18:
        if (r0.getTop() >= getTop()) goto L20;
        return false;
    L20:
        if (r0.getBottom() <= getBottom()) goto L21;
        return false;
    L24:
        throw new Exception("view must in (yataContainer or footContainer or gulContainer)");
    L26:
        if (r0.getTop() != getScrollY()) goto L31;
        return true;
    L31:
        return false;
    }

    public final void m(float r2) {
        this.g.a();
        setScrollY(0);
        this.a.c();
        e((int) (getHeight() * r2));
        this.k.c(r2);
    }

    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c(r2, BaseLinkedScrollView$showGUL$1.INSTANCE);
        getGulContainer().show();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        TouchHelper.TouchIntent r0 = this.f.c;
        final boolean r2 = true;
        final boolean r3 = false;
        if (r0 != TouchHelper.TouchIntent.DOWN_STATE) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L14;
        Lazy r7 = OrderCommonLog.a;
        final String r4 = "手指按下";
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnInterceptTouchEvent$1(r3, r4));
        if (this.i != 0) goto L31;
        return false;
    L31:
        return true;
    L14:
        if (r0 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L29:
        Lazy r8 = OrderCommonLog.a;
        final String r9 = "上下滑动中";
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnInterceptTouchEvent$1(r2, r9));
        return true;
    L19:
        if (r0 != TouchHelper.TouchIntent.V_MOVING_UP) goto L21;
        r3 = true;
    L21:
        if (r3 == true) goto L29;
        final boolean r10 = super.onInterceptTouchEvent(r6);
        if (r6.getAction() != 1) goto L26;
        final String r11 = "手指抬起";
    L27:
        Lazy r12 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnInterceptTouchEvent$1(r10, r11));
        return r10;
    L26:
        r11 = "其他事件";
        goto L27
    L16:
        r5 = false;
        goto L17
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r18) {
        Intrinsics.checkNotNullParameter(r18, "e");
        LinkedScrollFlingHelper r3 = this.g;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r18, "e");
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.a("LinkedScrollFlingHelper", new LinkedScrollFlingHelper$handleOnTouchEventActionUpToFling$1(r18));
        int r4 = r18.getAction();
        boolean r5 = false;
        if (r4 == 0) goto L9;
        if (r4 == 1) goto L8;
        if (r4 != 2) goto L11;
        r3.b.addMovement(r18);
    L11:
        if (r18.getAction() != 0) goto L15;
        k(true, "手指按下");
        return true;
    L15:
        if (r18.getAction() != 2) goto L31;
        TouchHelper r1 = this.f;
        TouchHelper.TouchIntent r6 = r1.c;
        if (r6 != TouchHelper.TouchIntent.V_MOVING_UP) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L23;
        com.bytedance.android.shopping.orderlist.common.widgets.touch.c r8 = r1.b;
        float r9 = Math.abs(r8.b - r8.d);
    L28:
        e((int) r9);
        k(true, "移动分发");
        return true;
    L23:
        if (r6 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L25;
        r5 = true;
    L25:
        if (r5 == false) goto L27;
        com.bytedance.android.shopping.orderlist.common.widgets.touch.c r10 = r1.b;
        r9 = -Math.abs(r10.b - r10.d);
        goto L28
    L27:
        r9 = 0.0f;
        goto L28
    L19:
        r7 = false;
        goto L20
    L31:
        if (r18.getAction() != 1) goto L34;
        k(true, "手指抬起");
        return true;
    L34:
        boolean r11 = super.onTouchEvent(r18);
        k(r11, "其他 " + r18.getAction());
        return r11;
    L8:
        r3.b.addMovement(r18);
        r3.b.computeCurrentVelocity(1000);
        int r12 = -((int) r3.b.getYVelocity());
        OrderCommonLog.a("LinkedScrollFlingHelper", LinkedScrollFlingHelper$startFling$1.INSTANCE);
        r3.c = 0;
        r3.a.fling(0, 0, 0, r12, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r3.d.invalidate();
        OrderCommonLog.a("LinkedScrollFlingHelper", LinkedScrollFlingHelper$handleOnTouchEventActionUpToFling$2.INSTANCE);
        goto L11
    L9:
        r3.a();
        r3.b.clear();
        r3.b.addMovement(r18);
        goto L11
    }

    public final void p(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "disposableCallback");
        getGulContainer().d(r2);
    }

    public final void setErrorRetryListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.a.setErrorRetryListener(r2);
    }

    public static void k(final boolean r1, final String r2) {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnTouchEvent$1(r1, r2));
    }

    public final void a(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "scrollListener");
        this.j.put(r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(final int r3, final int r4) {
        super.onMeasure(r3, r4);
        measureChildren(r3, r4);
        getGulContainer().setGULHeight(getMeasuredHeight());
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedScrollView", new C02861(r3, r4));
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        if (r3 >= 0) goto L4;
        r3 = 0;
    L7:
        super.scrollTo(r2, r3);
        return;
    L4:
        int r0 = this.h;
        if (r3 <= r0) goto L7;
        r3 = r0;
        goto L7
    }

    public BaseLinkedScrollView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        OrderCommonYataView r8 = new OrderCommonYataView(r5, null, 0);
        this.a = r8;
        this.b = LazyKt.lazy(new BaseLinkedScrollView$gulContainer$2(this));
        OrderCommonRefreshSloganView r1 = new OrderCommonRefreshSloganView(r5, null, 6, 0);
        this.d = r1;
        this.e = LazyKt.lazy(new BaseLinkedScrollView$footRefreshHelper$2(this));
        this.f = new TouchHelper(r5);
        this.g = new LinkedScrollFlingHelper(r5, this, new BaseLinkedScrollView$flingHelper$1(this), new BaseLinkedScrollView$flingHelper$2(this));
        this.j = new ConcurrentHashMap();
        this.k = new a(this);
        addView(r8, new FrameLayout.LayoutParams(-1, -2));
        addView(r1, new FrameLayout.LayoutParams(-1, 0));
        Object r9 = getGulContainer();
        if (r9 == null) goto L7;
        addView((View) r9, new FrameLayout.LayoutParams(-1, -2));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public /* synthetic */ BaseLinkedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        OrderCommonYataView r10 = this.a;
        if (r10 == null) goto L7;
        final int r11 = r10.getMeasuredHeight();
        final int r12 = this.d.getMeasuredHeight();
        final int r13 = getGulContainer().getView().getMeasuredHeight();
        this.a.layout(r6, 0, r8, r11);
        int r2 = r11 + r12;
        this.d.layout(r6, r11, r8, r2);
        getGulContainer().getView().layout(r6, r2, r8, r2 + r13);
        this.h = Math.max(0, ((r11 + r13) + r12) - getHeight());
        Lazy r14 = OrderCommonLog.a;
        OrderCommonLog.a("BaseLinkedScrollView", new C02851(this, r11, r12, r13));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
}
