package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonRefreshSloganView;", "Landroid/widget/LinearLayout;", "", "text", "", "setHintContent", "Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getBallView", "()Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "ballView", "Landroid/widget/TextView;", "b", "getHintText", "()Landroid/widget/TextView;", "hintText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonRefreshSloganView extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final String c;
    public boolean d;

    public OrderCommonRefreshSloganView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderCommonRefreshSloganView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final OrderCommonDoubleColorBallAnimationView getBallView() {
        return (OrderCommonDoubleColorBallAnimationView) this.a.getValue();
    }

    private final TextView getHintText() {
        return (TextView) this.b.getValue();
    }

    private final void setHintContent(String r2) {
        if (Intrinsics.areEqual(this.c, r2) == false) goto L5;
        return;
    L5:
        getHintText().setText(r2);
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (this.d == true) goto L6;
        this.d = true;
        getBallView().setVisibility(0);
        getBallView().c();
    L6:
        setHintContent(r3);
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.d = false;
        getBallView().setVisibility(8);
        getBallView().d();
        setHintContent(r3);
    }

    public OrderCommonRefreshSloganView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new OrderCommonRefreshSloganView$ballView$2(this));
        this.b = LazyKt.lazy(new OrderCommonRefreshSloganView$hintText$2(this));
        setGravity(17);
        setOrientation(0);
        th.a.c(r2, 2131564145, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c = "";
    }

    public /* synthetic */ OrderCommonRefreshSloganView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
