package com.bytedance.android.shopping.card_list.widgets.nest;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevNestedScrollView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListTwoRevNestedScrollView$scrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ CardListTwoRevNestedScrollView a;

    public CardListTwoRevNestedScrollView$scrollListener$1(CardListTwoRevNestedScrollView r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        if (r5 != 0) goto L5;
    L16:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        r0.put("session_id", CardListTwoRevNestedScrollView.e(this.a));     // Catch: Exception -> L12
        if (r5 != 0) goto L9;
        String r2 = "0";
    L10:
        r0.put("is_scrolling", r2);     // Catch: Exception -> L12
        ECLiveHybridUtil.f("page_scroll_state_change", r0);     // Catch: Exception -> L12
    L14:
        this.a.getViewAction().d.invoke(Integer.valueOf(r5));
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

    public final void onScrolled(RecyclerView r2, int r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        if (Intrinsics.areEqual(r2, this.a.c) == false) goto L6;
        this.a.j += r4;
        Lazy r5 = CardListCommonLog.a;
        CardListCommonLog.a("CardListTwoRevNestedScrollView", new CardListTwoRevNestedScrollView$scrollListener$1$onScrolled$1(this, r4));
        return;
    }
}
