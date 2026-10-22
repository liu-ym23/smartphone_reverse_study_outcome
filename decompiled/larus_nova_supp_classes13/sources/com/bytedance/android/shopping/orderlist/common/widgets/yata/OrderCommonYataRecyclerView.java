package com.bytedance.android.shopping.orderlist.common.widgets.yata;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.c1;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/yata/OrderCommonYataRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/ec/core/utils/c1;", "a", "Lkotlin/Lazy;", "getOverflowClickHelp", "()Lcom/bytedance/android/ec/core/utils/c1;", "overflowClickHelp", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonYataRecyclerView extends RecyclerView {
    public final Lazy a;

    public OrderCommonYataRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderCommonYataRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final c1 getOverflowClickHelp() {
        return (c1) this.a.getValue();
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t() {
        Lazy r0 = OrderCommonPageConfig.a;
        if (ECSettingKeys.F().getEnableOverflowClick() == false) goto L23;
        int r1 = getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        View r4 = getChildAt(r2);
        if ((r4 instanceof ViewGroup) == false) goto L12;
        if (((ViewGroup) r4).getClipChildren() == true) goto L12;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        return false;
    L16:
        if (getClipChildren() == true) goto L25;
        return true;
    L25:
        return false;
    L12:
        r2 = r2 + 1;
        goto L6
    L13:
        r3 = false;
        goto L14
    L23:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (t() == false) goto L10;
        if (r3 == null) goto L10;
        return getOverflowClickHelp().a(r3);
    L7:
        th = move-exception;
        nq.a.b(th, AnonymousClass1.INSTANCE);
    L10:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
    }

    public final void requestDisallowInterceptTouchEvent(boolean r2) {
        if (t() == false) goto L5;
        getOverflowClickHelp().c = r2;
    L5:
        super.requestDisallowInterceptTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean r(OrderCommonYataRecyclerView r0, MotionEvent r1) {
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderCommonYataRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new OrderCommonYataRecyclerView$overflowClickHelp$2(this));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setLayoutManager(new OrderListCenterLayoutManager(r2));
        Lazy r5 = OrderCommonPageConfig.a;
        setClipChildren(ECSettingKeys.F().getEnableContainerClipChildren());
    }

    public /* synthetic */ OrderCommonYataRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
