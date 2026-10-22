package com.bytedance.dux.indicator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"com/bytedance/dux/indicator/DuxBaseIndicator$setViewPager2$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/bytedance/dux/indicator/DuxBaseIndicator$c;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBaseIndicator$setViewPager2$2 extends RecyclerView.AdapterDataObserver implements DuxBaseIndicator.c {
    @Override // com.bytedance.dux.indicator.DuxBaseIndicator.c
    public final Function1<DuxBaseIndicator.c, Unit> a() {
        final ViewPager2 r100 = null;
        return new DuxBaseIndicator$setViewPager2$2$releaseAction$1(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        super.onChanged();
        throw null;
    }
}
