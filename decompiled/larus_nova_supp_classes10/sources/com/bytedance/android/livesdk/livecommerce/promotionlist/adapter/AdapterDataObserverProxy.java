package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/AdapterDataObserverProxy;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdapterDataObserverProxy extends RecyclerView.AdapterDataObserver {
    public final RecyclerView.AdapterDataObserver a;
    public final Function0<Integer> b;
    public final Function2<Integer, Integer, Unit> c;

    public final void onChanged() {
        this.a.onChanged();
    }

    public final void onItemRangeChanged(int r3, int r4) {
        this.a.onItemRangeChanged(r3 + ((Number) this.b.invoke()).intValue(), r4);
    }

    public final void onItemRangeInserted(int r3, int r4) {
        this.a.onItemRangeInserted(((Number) this.b.invoke()).intValue() + r3, r4);
        this.c.invoke(Integer.valueOf(r3 + ((Number) this.b.invoke()).intValue()), Integer.valueOf(r4));
    }

    public final void onItemRangeRemoved(int r3, int r4) {
        this.a.onItemRangeRemoved(r3 + ((Number) this.b.invoke()).intValue(), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdapterDataObserverProxy(RecyclerView.AdapterDataObserver r2, Function0<Integer> r3, Function2<? super Integer, ? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "adapterDataObserver");
        Intrinsics.checkNotNullParameter(r3, "getHeaderCount");
        Intrinsics.checkNotNullParameter(r4, "onItemRangeInsertedCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void onItemRangeChanged(int r3, int r4, Object r5) {
        this.a.onItemRangeChanged(r3 + ((Number) this.b.invoke()).intValue(), r4, r5);
    }

    public final void onItemRangeMoved(int r2, int r3, int r4) {
        super.onItemRangeMoved(r2 + ((Number) this.b.invoke()).intValue(), r3 + ((Number) this.b.invoke()).intValue(), r4);
    }
}
