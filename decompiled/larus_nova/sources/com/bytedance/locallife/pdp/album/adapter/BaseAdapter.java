package com.bytedance.locallife.pdp.album.adapter;

import aw6.a;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public abstract class BaseAdapter<T> extends LoadMoreRecyclerViewAdapter {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f260946l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<T> f260947k;

    @Override // com.bytedance.locallife.pdp.album.adapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        List<T> r100 = this.f260947k;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public BaseAdapter() {
        registerAdapterDataObserver(new a(this));
    }

    static {
    }

    public final void y2(boolean r100) {
        notifyItemInserted(getItemCount() - 1);
        getItemCount();
    }
}
