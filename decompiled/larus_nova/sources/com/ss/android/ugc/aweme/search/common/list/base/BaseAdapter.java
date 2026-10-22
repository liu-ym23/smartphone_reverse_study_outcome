package com.ss.android.ugc.aweme.search.common.list.base;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class BaseAdapter<T> extends LoadMoreRecyclerViewAdapter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f451666m = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<T> f451667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f451668l;

    public BaseAdapter() {
        this(0);
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public int getBasicItemCount() {
        List<T> r100 = this.f451667k;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    static {
    }

    public BaseAdapter(int r100) {
        this.f451668l = 0;
        registerAdapterDataObserver(new AnonymousClass1(this));
    }

    public final void z2(boolean r100) {
        if (r100 == false) goto L4;
        notifyItemInserted(getItemCount() - 1);
    L5:
        this.f451668l = getItemCount();
        return;
    L4:
        notifyItemRemoved(getItemCount());
        goto L5
    }
}
