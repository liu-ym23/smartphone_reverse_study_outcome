package com.ss.android.ugc.aweme.search.common.list.base;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RecyclerHeaderViewAdapter<DATA> extends BaseAdapter<DATA> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f451684o = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f451685n;

    public RecyclerHeaderViewAdapter() {
        super(0);
        this.f451685n = -1;
        this.f451677h = new AnonymousClass1(this);
        TextView r100 = this.f451673d;
        if (r100 == null) goto L5;
        r100.setText(R.string.cur_no_more);
    L5:
        this.f451672c = R.string.cur_no_more;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public int getBasicItemViewType(int r100) {
        return 0;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.BaseAdapter, com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        return super.getBasicItemCount() + 0;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (getItemViewType(r101) != 0) goto L6;
        return;
    L6:
        if (getItemViewType(r101) == 20000) goto L8;
        return;
    L8:
        if ((r100 instanceof LoadMoreRecyclerViewAdapter.LoadMoreViewHolder) == false) goto L12;
        ((LoadMoreRecyclerViewAdapter.LoadMoreViewHolder) r100).T3();
        return;
    }
}
