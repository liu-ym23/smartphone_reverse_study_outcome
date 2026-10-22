package com.larus.paging.adapter;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zo9.a.C8483a f363766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.d f363767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f363768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC4459b f363769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f363770e;

    public class a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f363771a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            b r100 = this.f363771a;
            r100.f363770e = r100.f363768c.getItemCount();
            ((com.larus.paging.adapter.a) this.f363771a.f363769d).f363755a.notifyDataSetChanged();
        }

        public a(b r100) {
            this.f363771a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            b r102 = this.f363771a;
            com.larus.paging.adapter.a r103 = (com.larus.paging.adapter.a) r102.f363769d;
            int r104 = r103.a(r102);
            r103.f363755a.notifyItemRangeChanged(r100 + r104, r101, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            b r102 = this.f363771a;
            r102.f363770e += r101;
            com.larus.paging.adapter.a r103 = (com.larus.paging.adapter.a) r102.f363769d;
            r103.f363755a.notifyItemRangeInserted(r100 + r103.a(r102), r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            b r102 = this.f363771a;
            r102.f363770e -= r101;
            com.larus.paging.adapter.a r103 = (com.larus.paging.adapter.a) r102.f363769d;
            r103.f363755a.notifyItemRangeRemoved(r100 + r103.a(r102), r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            b r103 = this.f363771a;
            com.larus.paging.adapter.a r104 = (com.larus.paging.adapter.a) r103.f363769d;
            int r105 = r104.a(r103);
            r104.f363755a.notifyItemRangeChanged(r100 + r105, r101, r102);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            b r103 = this.f363771a;
            com.larus.paging.adapter.a r104 = (com.larus.paging.adapter.a) r103.f363769d;
            int r105 = r104.a(r103);
            r104.f363755a.notifyItemMoved(r100 + r105, r101 + r105);
        }
    }

    /* JADX INFO: renamed from: com.larus.paging.adapter.b$b, reason: collision with other inner class name */
    public interface InterfaceC4459b {
    }

    public b(RecyclerView.Adapter r100, com.larus.paging.adapter.a r101, zo9.a r102, c.d r103) {
        a r104 = new a(this);
        this.f363768c = r100;
        this.f363769d = r101;
        r102.getClass();
        this.f363766a = new zo9.a.C8483a(r102, this);
        this.f363767b = r103;
        this.f363770e = r100.getItemCount();
        r100.registerAdapterDataObserver(r104);
    }
}
