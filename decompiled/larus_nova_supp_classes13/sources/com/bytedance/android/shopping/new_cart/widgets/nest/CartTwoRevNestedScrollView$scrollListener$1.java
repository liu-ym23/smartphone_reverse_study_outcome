package com.bytedance.android.shopping.new_cart.widgets.nest;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/new_cart/widgets/nest/CartTwoRevNestedScrollView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartTwoRevNestedScrollView$scrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ CartTwoRevNestedScrollView a;

    public CartTwoRevNestedScrollView$scrollListener$1(CartTwoRevNestedScrollView r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r4, final int r5) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        if (r5 != 0) goto L5;
    L16:
        Lazy r0 = CartCommonLog.a;     // Catch: Exception -> L12
        CartCommonLog.a("CartTwoRevNestedScrollView", new CartTwoRevNestedScrollView$scrollListener$1$onScrollStateChanged$1(this, r5));     // Catch: Exception -> L12
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L12
        r1.put("session_id", this.a.getSessionId());     // Catch: Exception -> L12
        if (r5 != 0) goto L9;
        String r2 = "0";
    L10:
        r1.put("is_scrolling", r2);     // Catch: Exception -> L12
        ECLiveHybridUtil.f("page_scroll_state_change", r1);     // Catch: Exception -> L12
    L14:
        this.a.g(r5);
        super.onScrollStateChanged(r4, r5);
        return;
    L9:
        r2 = "1";
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L14
    L5:
        if (r5 != 2) goto L14;
        goto L14
    }
}
