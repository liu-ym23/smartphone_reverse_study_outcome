package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseAdapter<T> extends LoadMoreRecyclerViewAdapter {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f196962n = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<T> f196963l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f196964m;

    public class a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAdapter f196965a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            BaseAdapter r100 = this.f196965a;
            r100.f196964m = r100.getItemCount();
            int r101 = BaseAdapter.f196962n;
        }

        public a(BaseAdapter r100) {
            this.f196965a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            BaseAdapter r102 = this.f196965a;
            r102.f196964m = r102.getItemCount();
            int r103 = BaseAdapter.f196962n;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            BaseAdapter r102 = this.f196965a;
            r102.f196964m = r102.getItemCount();
            int r103 = BaseAdapter.f196962n;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            BaseAdapter r102 = this.f196965a;
            r102.f196964m = r102.getItemCount();
            int r103 = BaseAdapter.f196962n;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            BaseAdapter r103 = this.f196965a;
            r103.f196964m = r103.getItemCount();
            int r104 = BaseAdapter.f196962n;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        List<T> r100 = this.f196963l;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public BaseAdapter() {
        this.f196964m = 0;
        registerAdapterDataObserver(new a(this));
    }

    static {
    }

    public final void B2(boolean r100) {
        if (r100 == false) goto L4;
        notifyItemInserted(getItemCount());
    L5:
        this.f196964m = getItemCount();
        return;
    L4:
        notifyItemRemoved(getItemCount() - 1);
        goto L5
    }
}
