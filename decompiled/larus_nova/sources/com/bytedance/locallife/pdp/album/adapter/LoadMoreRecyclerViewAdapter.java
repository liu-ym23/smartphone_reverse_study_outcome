package com.bytedance.locallife.pdp.album.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import aw6.b;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes21.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f260948j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f260949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f260951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f260952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f260953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f260954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LoadMoreViewHolder f260955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f260956i;

    public class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f260957c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f260958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f260959b;

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r100, DmtStatusView r101, TextView r102) {
            this.f260959b = r100;
            super(r101);
            this.f260958a = r102;
            r102.setOnClickListener(new b(this));
        }
    }

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f260960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f260961b;

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int getSpanSize(int r100) {
            if (this.f260961b.getItemViewType(r100) == Integer.MIN_VALUE) goto L5;
            LoadMoreRecyclerViewAdapter r101 = this.f260961b;
            int r102 = LoadMoreRecyclerViewAdapter.f260948j;
            r101.getClass();
            return 1;
        L5:
            return this.f260960a.getSpanCount();
        }

        public a(LoadMoreRecyclerViewAdapter r100, GridLayoutManager r101) {
            this.f260961b = r100;
            this.f260960a = r101;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int getSpanGroupIndex(int r100, int r101) {
            LoadMoreRecyclerViewAdapter r102 = this.f260961b;
            int r103 = LoadMoreRecyclerViewAdapter.f260948j;
            r102.getClass();
            return super.getSpanGroupIndex(r100, r101);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int getSpanIndex(int r100, int r101) {
            LoadMoreRecyclerViewAdapter r102 = this.f260961b;
            int r103 = LoadMoreRecyclerViewAdapter.f260948j;
            r102.getClass();
            return super.getSpanIndex(r100, r101);
        }
    }

    public LoadMoreRecyclerViewAdapter() {
        this.f260949b = -1;
        this.f260954g = -1;
        this.f260956i = -1;
    }

    @Override // com.bytedance.locallife.pdp.album.adapter.RecyclerViewWithFooterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getBasicItemCount() != 0) goto L7;
        return 0;
    L7:
        return super.getItemCount();
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        GridLayoutManager r102 = (GridLayoutManager) r101;
        r102.setSpanSizeLookup(new a(this, r102));
        return;
    }

    @Override // com.bytedance.locallife.pdp.album.adapter.RecyclerViewWithFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof LoadMoreViewHolder) == false) goto L11;
        LoadMoreViewHolder r101 = (LoadMoreViewHolder) r100;
        r101.getClass();
        int r102 = r101.f260959b.f260949b;
        r101.f260958a.setMovementMethod(null);
        DmtStatusView r103 = (DmtStatusView) r101.itemView;
        r103.setStatus(r101.f260959b.f260949b);
        r101.f260959b.getClass();
        if (r103.f248431b != (-1)) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L12;
        r101.f260959b.getClass();
        return;
    L12:
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // com.bytedance.locallife.pdp.album.adapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        DmtStatusView r101 = new DmtStatusView(r100.getContext());
        int r102 = r100.getResources().getDimensionPixelSize(R.dimen.default_list_loadmore_height);
        r101.setLayoutParams(new RecyclerView.LayoutParams(this.f260956i, r102));
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_view_default_empty_list, null);
        TextView r104 = (TextView) r103;
        this.f260953f = r104;
        if (r104 == null) goto L11;
        int r105 = this.f260950c;
        if (r105 == 0) goto L7;
        r104.setTextColor(r105);
    L7:
        int r106 = this.f260952e;
        if (r106 == 0) goto L10;
        this.f260953f.setText(r106);
    L10:
        this.f260953f.setGravity(17);
    L11:
        TextView r107 = (TextView) LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_view_default_retry_list, null);
        r107.setText(R.string.load_status_click_retry);
        r107.setGravity(17);
        int r108 = this.f260951d;
        if (r108 == 0) goto L14;
        r107.setTextColor(r108);
    L14:
        DmtStatusView.a r109 = DmtStatusView.a.a(r100.getContext());
        r109.b(r103);
        r109.d(r107);
        r101.setBuilder(r109);
        LoadMoreViewHolder r110 = new LoadMoreViewHolder(this, r101, r107);
        this.f260955h = r110;
        return r110;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
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
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        super.onViewDetachedFromWindow(r100);
        if (this.f260954g != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.f260954g = -1;
        return;
    }
}
