package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f196977k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f196978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f196979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f196980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f196981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f196982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LoadMoreViewHolder f196983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f196984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f196985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f196986j;

    public class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f196987d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PullUpLoadMoreHelper f196988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f196989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f196990c;

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r100, DmtStatusView r101, TextView r102) {
            this.f196990c = r100;
            super(r101);
            this.f196989b = r102;
            r102.setOnClickListener(new e04.b(this));
        }
    }

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f196991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f196992b;

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public final int getSpanSize(int r100) {
            if (this.f196992b.getItemViewType(r100) == Integer.MIN_VALUE) goto L5;
            LoadMoreRecyclerViewAdapter r101 = this.f196992b;
            int r102 = LoadMoreRecyclerViewAdapter.f196977k;
            r101.getClass();
            return 1;
        L5:
            return this.f196991a.getSpanCount();
        }

        public a(LoadMoreRecyclerViewAdapter r100, GridLayoutManager r101) {
            this.f196992b = r100;
            this.f196991a = r101;
        }
    }

    public interface b {
        void a();
    }

    public interface c extends b {
        void Zc(int r100);
    }

    public final void A2() {
        LoadMoreViewHolder r100 = this.f196983g;
        if (r100 == null) goto L5;
        int r101 = LoadMoreViewHolder.f196987d;
        DmtStatusView r102 = (DmtStatusView) r100.itemView;
        r102.setVisibility(0);
        r102.setStatus(1);
    L5:
        this.f196978b = 1;
    }

    public final void resetLoadMoreState() {
        LoadMoreViewHolder r100 = this.f196983g;
        if (r100 == null) goto L5;
        int r101 = LoadMoreViewHolder.f196987d;
        ((DmtStatusView) r100.itemView).c();
    L5:
        this.f196978b = -1;
        this.f196981e = -1;
    }

    public final void showLoadMoreLoading() {
        LoadMoreViewHolder r100 = this.f196983g;
        if (r100 == null) goto L5;
        int r101 = LoadMoreViewHolder.f196987d;
        ((DmtStatusView) r100.itemView).e();
    L5:
        this.f196978b = 0;
        if (this.f196981e != (-1)) goto L9;
        this.f196981e = System.currentTimeMillis();
        return;
    }

    public LoadMoreRecyclerViewAdapter() {
        this.f196978b = -1;
        this.f196981e = -1;
        this.f196984h = -1;
        this.f196985i = true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getBasicItemCount() != 0) goto L7;
        return 0;
    L7:
        return super.getItemCount();
    }

    static {
    }

    public static void y2(LoadMoreRecyclerViewAdapter r100) {
        if ((r100.f196986j instanceof c) == true) goto L15;
        LoadMoreViewHolder r101 = r100.f196983g;
        if (r101 == null) goto L16;
        DmtStatusView r102 = (DmtStatusView) r101.itemView;
        r102.getClass();
        b r103 = r100.f196986j;
        if (r103 != null) goto L9;
        return;
    L9:
        if (r102.f193288b != (-1)) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L18;
        r103.a();
        return;
    L18:
        return;
    L11:
        r104 = false;
        goto L12
    L16:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        this.f196982f = r100;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r102 = (GridLayoutManager) r101;
        r102.setSpanSizeLookup(new a(this, r102));
    L5:
        this.f196982f.addOnScrollListener(new e04.a(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof LoadMoreViewHolder) == false) goto L6;
        LoadMoreViewHolder r101 = (LoadMoreViewHolder) r100;
        r101.getClass();
        int r102 = r101.f196990c.f196978b;
        r101.f196989b.setMovementMethod(null);
        ((DmtStatusView) r101.itemView).setStatus(r101.f196990c.f196978b);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        DmtStatusView r101 = new DmtStatusView(r100.getContext());
        int r102 = z2(r100);
        r101.setLayoutParams(new RecyclerView.LayoutParams(this.f196984h, r102));
        TextView r103 = (TextView) LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_view_default_empty_list, null);
        this.f196980d = r103;
        int r104 = this.f196979c;
        if (r104 == 0) goto L5;
        r103.setTextColor(r104);
    L5:
        this.f196980d.setGravity(17);
        TextView r105 = (TextView) LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_view_default_retry_list, null);
        r105.setText(R.string.aos_load_status_click_retry);
        r105.setGravity(17);
        DmtStatusView.a r106 = DmtStatusView.a.a(r100.getContext());
        r106.b(this.f196980d);
        r106.d(r105);
        r101.setBuilder(r106);
        LoadMoreViewHolder r107 = new LoadMoreViewHolder(this, r101, r105);
        this.f196983g = r107;
        return r107;
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
        if (this.f196981e != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.f196981e = -1;
        return;
    }

    public int z2(View r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.aos_default_list_loadmore_height);
    }
}
