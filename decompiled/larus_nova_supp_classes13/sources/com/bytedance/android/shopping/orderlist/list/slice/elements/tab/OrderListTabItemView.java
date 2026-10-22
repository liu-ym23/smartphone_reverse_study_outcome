package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.bytedance.android.ui.base.widget.round.RoundView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getIndicatorBottomOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListTabItemView extends ConstraintLayout {
    public final View a;
    public final TextView b;
    public final CornersButton c;
    public final RoundView d;

    public OrderListTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderListTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getIndicatorBottomOffset() {
        int r0 = this.d.getBottom();
        Object r1 = this.d.getParent();
        if ((r1 instanceof View) == true) goto L5;
        r1 = null;
    L5:
        View r2 = (View) r1;
    L6:
        if (r2 == null) goto L14;
        if ((!Intrinsics.areEqual(r2, this)) == false) goto L14;
        r0 = r0 + r2.getTop();
        Object r3 = r2.getParent();
        if ((r3 instanceof View) == true) goto L12;
        r3 = null;
    L12:
        r2 = (View) r3;
    L14:
        return RangesKt.coerceAtLeast(getHeight() - r0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderListTabItemView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        Map r7 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r4).aU(2131564147, this, true);
        this.a = findViewById(2131375861);
        this.b = (TextView) findViewById(2131375860);
        CornersButton r8 = findViewById(2131375858);
        this.c = r8;
        this.d = findViewById(2131375859);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r9 = null;
    L5:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        if (r10 == null) goto L8;
        r10.setMargins(r10.leftMargin, r10.topMargin, 0, r10.bottomMargin);
        Unit r11 = Unit.INSTANCE;
        ViewGroup.LayoutParams r12 = r10;
    L9:
        r8.setLayoutParams(r12);
        return;
    L8:
        r12 = r8.getLayoutParams();
        goto L9
    }

    public /* synthetic */ OrderListTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
