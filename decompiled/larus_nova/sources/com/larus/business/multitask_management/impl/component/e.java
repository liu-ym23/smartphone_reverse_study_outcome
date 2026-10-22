package com.larus.business.multitask_management.impl.component;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter<?> f320805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320806b;

    public e(RecyclerView.Adapter<?> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.f320805a = r100;
        this.f320806b = r101;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(int r100, int r101) {
        this.f320805a.notifyItemRangeInserted(r100 + this.f320806b, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(int r100, int r101) {
        RecyclerView.Adapter<?> r102 = this.f320805a;
        int r103 = this.f320806b;
        r102.notifyItemMoved(r100 + r103, r101 + r103);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(int r100, int r101) {
        this.f320805a.notifyItemRangeRemoved(r100 + this.f320806b, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onChanged(int r100, int r101, Object r102) {
        this.f320805a.notifyItemRangeChanged(r100 + this.f320806b, r101, r102);
    }
}
