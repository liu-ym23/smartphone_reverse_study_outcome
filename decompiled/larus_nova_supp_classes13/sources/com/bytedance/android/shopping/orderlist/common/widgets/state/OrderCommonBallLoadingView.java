package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonBallLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "a", "Lkotlin/Lazy;", "getBallView", "()Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "ballView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonBallLoadingView extends ConstraintLayout {
    public final Lazy a;

    public OrderCommonBallLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderCommonBallLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final OrderCommonDoubleColorBallAnimationView getBallView() {
        return (OrderCommonDoubleColorBallAnimationView) this.a.getValue();
    }

    public final void S5() {
        m.a r0 = m.a;
        m.c(new OrderCommonBallLoadingView$startLoading$1(this));
    }

    public final void T5() {
        m.a r0 = m.a;
        m.c(new OrderCommonBallLoadingView$stopLoading$1(this));
    }

    public static final /* synthetic */ OrderCommonDoubleColorBallAnimationView R5(OrderCommonBallLoadingView r0) {
        return r0.getBallView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderCommonBallLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new OrderCommonBallLoadingView$ballView$2(this));
        LayoutInflater.from(r2).inflate(2131564139, this, true);
    }

    public /* synthetic */ OrderCommonBallLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
