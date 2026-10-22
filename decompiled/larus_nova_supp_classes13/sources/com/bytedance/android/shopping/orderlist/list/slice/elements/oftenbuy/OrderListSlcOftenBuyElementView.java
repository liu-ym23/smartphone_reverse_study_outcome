package com.bytedance.android.shopping.orderlist.list.slice.elements.oftenbuy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.OftenShopPullLayout;
import com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/oftenbuy/OrderListSlcOftenBuyElementView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundLinearlayout;", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/oftenbuy/OrderListOftenBuyRecyclerView;", "getRecyclerView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListSlcOftenBuyElementView extends SlcRoundLinearlayout {
    public Map<Integer, View> a;

    public static final class a implements b {
        public float a;
        public final /* synthetic */ OrderListSlcOftenBuyElementView b;

        @Override // com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.b
        public final void a() {
        }

        @Override // com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.b
        public final void c() {
        }

        @Override // com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.b
        public final void b() {
            if (this.a <= 0.95f) goto L7;
            BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this.b);
            if (r0 == null) goto L7;
            SlcCommonAction r2 = new SlcCommonAction("showMore", null);
            SlcRoundLinearlayout r3 = this.b;
            r0.a.d(r2, r3, r0.l(), null, null);
        L7:
            this.a = 0.0f;
        }

        public a(OrderListSlcOftenBuyElementView r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.b
        public final void d(float r4) {
            this.a = r4;
            if (r4 <= 0.95f) goto L5;
            ((ImageView) this.b.b(2131381414)).setImageResource(2131245954);
            ((TextView) this.b.b(2131381416)).setText("释放加载");
            return;
        L5:
            ((ImageView) this.b.b(2131381414)).setImageResource(2131245953);
            ((TextView) this.b.b(2131381416)).setText("查看更多");
        }
    }

    public OrderListSlcOftenBuyElementView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OrderListSlcOftenBuyElementView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final OrderListOftenBuyRecyclerView getRecyclerView() {
        return (OrderListOftenBuyRecyclerView) b(2131381413);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.LinearLayout*/.dispatchHoverEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderListSlcOftenBuyElementView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564144, this, true);
        ((OftenShopPullLayout) b(2131381415)).setEasyPullListener(new a(this));
    }

    public /* synthetic */ OrderListSlcOftenBuyElementView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
