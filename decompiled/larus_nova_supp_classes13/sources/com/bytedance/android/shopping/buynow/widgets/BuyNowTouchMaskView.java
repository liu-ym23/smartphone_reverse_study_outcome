package com.bytedance.android.shopping.buynow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/widgets/BuyNowTouchMaskView;", "Landroid/view/View;", "Lcom/bytedance/android/shopping/buynow/viewmodel/BuyNowViewModel;", "viewModel", "", "setMaskOnClick", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowTouchMaskView extends View {

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BuyNowViewModel a;

        public b(BuyNowViewModel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            BuyNowLog.d("BuyNowTouchMaskView", "loading mask onClick");
            com.bytedance.android.shopping.buynow.tracker.a r4 = this.a.getTracker();
            int r0 = com.bytedance.android.shopping.buynow.monitor.error.b.a;
            if (r4 == null) goto L6;
            r4.b("buynow_error_monitor", MapsKt.mapOf(TuplesKt.to("type", "loading_mask_click")));
            return;
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ BuyNowViewModel a;

        public c(BuyNowViewModel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            BuyNowLog.d("BuyNowTouchMaskView", "loading mask onLongClick");
            com.bytedance.android.shopping.buynow.tracker.a r4 = this.a.getTracker();
            int r0 = com.bytedance.android.shopping.buynow.monitor.error.b.a;
            if (r4 == null) goto L7;
            r4.b("buynow_error_monitor", MapsKt.mapOf(TuplesKt.to("type", "loading_mask_click")));
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    public BuyNowTouchMaskView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BuyNowTouchMaskView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setMaskOnClick(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        setOnClickListener(new b(r2));
        setOnLongClickListener(new c(r2));
    }

    public BuyNowTouchMaskView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ BuyNowTouchMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
