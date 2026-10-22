package koa;

import androidx.recyclerview.widget.RecyclerView;
import com.oubowu.stickyitemdecoration.StickyItemDecoration;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickyItemDecoration f504543a;

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        StickyItemDecoration.h(this.f504543a);
    }

    public b(StickyItemDecoration r100) {
        this.f504543a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101) {
        StickyItemDecoration.h(this.f504543a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int r100, int r101) {
        StickyItemDecoration.h(this.f504543a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        StickyItemDecoration.h(this.f504543a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101, Object r102) {
        StickyItemDecoration.h(this.f504543a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        StickyItemDecoration.h(this.f504543a);
    }
}
