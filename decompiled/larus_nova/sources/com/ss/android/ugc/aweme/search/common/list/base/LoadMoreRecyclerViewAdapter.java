package com.ss.android.ugc.aweme.search.common.list.base;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.larus.nova.R;
import xgc.a;

/* JADX INFO: loaded from: classes40.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f451670j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f451671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f451672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f451673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f451674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoadMoreViewHolder f451675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ILoadMore f451676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GridLayoutManager.SpanSizeLookup f451677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f451678i;

    public interface ILoadMore {
        void a();
    }

    public interface ILoadMoreWithSource extends ILoadMore {
        void b();
    }

    public class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f451681c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f451682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f451683b;

        public final void T3() {
            int r100 = LoadMoreRecyclerViewAdapter.f451670j;
            int r101 = this.f451683b.f451671b;
            this.f451682a.setMovementMethod(null);
            DmtStatusView r102 = (DmtStatusView) this.itemView;
            r102.setStatus(this.f451683b.f451671b);
            ILoadMore r103 = this.f451683b.f451676g;
            if ((r103 instanceof ILoadMoreWithSource) == false) goto L5;
            return;
        L5:
            if (r102.f248431b != (-1)) goto L7;
            boolean r104 = true;
        L8:
            if (r104 == false) goto L13;
            if (r103 == null) goto L14;
            r103.a();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r104 = false;
            goto L8
        }

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r100, DmtStatusView r101, TextView r102) {
            this.f451683b = r100;
            super(r101);
            this.f451682a = r102;
            r102.setOnClickListener(new a(this));
        }
    }

    public LoadMoreRecyclerViewAdapter() {
        this.f451671b = -1;
        this.f451674e = -1;
        this.f451678i = -1;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getBasicItemCount() != 0) goto L7;
        return 0;
    L7:
        return super.getItemCount();
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        final GridLayoutManager r102 = (GridLayoutManager) r101;
        r102.setSpanSizeLookup(new AnonymousClass1(this, r102));
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof LoadMoreViewHolder) == false) goto L6;
        ((LoadMoreViewHolder) r100).T3();
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.common.list.base.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        DmtStatusView r101 = new DmtStatusView(r100.getContext());
        int r102 = y2(r100);
        r101.setLayoutParams(new RecyclerView.LayoutParams(this.f451678i, r102));
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.view_default_common_empty_list, null);
        TextView r104 = (TextView) r103;
        this.f451673d = r104;
        if (r104 == null) goto L8;
        int r105 = this.f451672c;
        if (r105 == 0) goto L7;
        r104.setText(r105);
    L7:
        this.f451673d.setGravity(17);
    L8:
        TextView r106 = (TextView) LayoutInflater.from(r100.getContext()).inflate(R.layout.view_default_common_retry_list, null);
        r106.setText(R.string.common_load_status_click_retry);
        r106.setGravity(17);
        DmtStatusView.a r107 = DmtStatusView.a.a(r100.getContext());
        r107.b(r103);
        r107.d(r106);
        r101.setBuilder(r107);
        LoadMoreViewHolder r108 = new LoadMoreViewHolder(this, r101, r106);
        this.f451675f = r108;
        return r108;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        super.onViewAttachedToWindow(r100);
        ViewGroup.LayoutParams r101 = r100.itemView.getLayoutParams();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L13;
        StaggeredGridLayoutManager.LayoutParams r102 = (StaggeredGridLayoutManager.LayoutParams) r101;
        if (getItemViewType(r100.getLayoutPosition()) != Integer.MIN_VALUE) goto L9;
        boolean r103 = true;
    L10:
        r102.setFullSpan(r103);
        return;
    L9:
        r103 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        super.onViewDetachedFromWindow(r100);
        if (this.f451674e != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.f451674e = -1;
        return;
    }

    public int y2(View r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.default_common_list_loadmore_height);
    }
}
