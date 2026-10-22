package com.bytedance.ies.uikit.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f249097b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f249098a;

        public a(LoadMoreRecyclerViewAdapter r100) {
            this.f249098a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f249098a.getClass();
        }
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f249099a;

        public b(LoadMoreRecyclerViewAdapter r100, LoadingStatusView r101) {
            this.f249099a = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.ies.uikit.recyclerview.RecyclerViewWithFooterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getBasicItemCount() != 0) goto L7;
        return 0;
    L7:
        return super.getItemCount();
    }

    public LoadMoreRecyclerViewAdapter() {
    }

    @Override // com.bytedance.ies.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof b) == true) goto L5;
        return;
    L5:
        b r101 = (b) r100;
        if (((LoadingStatusView) r101.itemView).f249102c != (-1)) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r101.f249099a.getClass();
    L11:
        RecyclerView.LayoutParams r103 = (RecyclerView.LayoutParams) this.f249097b.itemView.getLayoutParams();
        if ((r103 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L14;
        ((StaggeredGridLayoutManager.LayoutParams) r103).setFullSpan(true);
    L14:
        this.f249097b.itemView.setLayoutParams(r103);
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.ies.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        LoadingStatusView r101 = new LoadingStatusView(r100.getContext());
        int r102 = r100.getResources().getDimensionPixelSize(R.dimen.default_list_loadmore_height);
        int r103 = r100.getResources().getDimensionPixelSize(R.dimen.default_list_loadmore_progressbar);
        r101.setLayoutParams(new RecyclerView.LayoutParams(-1, r102));
        Context r104 = r100.getContext();
        LoadingStatusView.a r105 = new LoadingStatusView.a(r104);
        CircularProgressView r106 = (CircularProgressView) LayoutInflater.from(r104).inflate(R.layout.load_status_item_progressbar, null);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.height = r103;
        r107.width = r103;
        r107.gravity = 17;
        r106.setLayoutParams(r107);
        r105.f249103a = r106;
        a r108 = new a(this);
        TextView r109 = (TextView) LayoutInflater.from(r104).inflate(R.layout.load_status_item_view, null);
        r109.setText(R.string.load_status_click_retry);
        r109.setOnClickListener(r108);
        r105.f249105c = r109;
        r105.f249103a = LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_loading_more, r100, false);
        r101.setBuilder(r105);
        b r110 = new b(this, r101);
        this.f249097b = r110;
        return r110;
    }
}
