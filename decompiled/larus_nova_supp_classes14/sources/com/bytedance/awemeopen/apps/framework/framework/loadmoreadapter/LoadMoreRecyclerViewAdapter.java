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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {
    public static final /* synthetic */ int k = 0;
    public int b;
    public int c;
    public TextView d;
    public long e;
    public RecyclerView f;
    public LoadMoreViewHolder g;
    public final int h;
    public boolean i;
    public b j;

    public class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public PullUpLoadMoreHelper a;
        public final TextView b;
        public final /* synthetic */ LoadMoreRecyclerViewAdapter c;

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r1, DmtStatusView r2, TextView r3) {
            this.c = r1;
            super(r2);
            this.b = r3;
            r3.setOnClickListener(new e04.b(this));
        }
    }

    public class a extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ GridLayoutManager a;
        public final /* synthetic */ LoadMoreRecyclerViewAdapter b;

        public final int getSpanSize(int r2) {
            if (this.b.getItemViewType(r2) == Integer.MIN_VALUE) goto L5;
            LoadMoreRecyclerViewAdapter r3 = this.b;
            int r0 = LoadMoreRecyclerViewAdapter.k;
            r3.getClass();
            return 1;
        L5:
            return this.a.getSpanCount();
        }

        public a(LoadMoreRecyclerViewAdapter r1, GridLayoutManager r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface b {
        void a();
    }

    public interface c extends b {
        void Zc(int r1);
    }

    public final void A2() {
        LoadMoreViewHolder r0 = this.g;
        if (r0 == null) goto L5;
        int r2 = LoadMoreViewHolder.d;
        DmtStatusView r1 = (DmtStatusView) ((RecyclerView.ViewHolder) r0).itemView;
        r1.setVisibility(0);
        r1.setStatus(1);
    L5:
        this.b = 1;
    }

    public final void resetLoadMoreState() {
        LoadMoreViewHolder r0 = this.g;
        if (r0 == null) goto L5;
        int r1 = LoadMoreViewHolder.d;
        ((DmtStatusView) ((RecyclerView.ViewHolder) r0).itemView).c();
    L5:
        this.b = -1;
        this.e = -1;
    }

    public final void showLoadMoreLoading() {
        LoadMoreViewHolder r0 = this.g;
        if (r0 == null) goto L5;
        int r1 = LoadMoreViewHolder.d;
        ((DmtStatusView) ((RecyclerView.ViewHolder) r0).itemView).e();
    L5:
        this.b = 0;
        if (this.e != (-1)) goto L9;
        this.e = System.currentTimeMillis();
        return;
    }

    public LoadMoreRecyclerViewAdapter() {
        this.b = -1;
        this.e = -1;
        this.h = -1;
        this.i = true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final int getItemCount() {
        if (getBasicItemCount() != 0) goto L7;
        return 0;
    L7:
        return super.getItemCount();
    }

    static {
    }

    public static void y2(LoadMoreRecyclerViewAdapter r2) {
        if ((r2.j instanceof c) == true) goto L15;
        LoadMoreViewHolder r0 = r2.g;
        if (r0 == null) goto L16;
        DmtStatusView r1 = (DmtStatusView) ((RecyclerView.ViewHolder) r0).itemView;
        r1.getClass();
        b r3 = r2.j;
        if (r3 != null) goto L9;
        return;
    L9:
        if (r1.b != (-1)) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L18;
        r3.a();
        return;
    L18:
        return;
    L11:
        r4 = false;
        goto L12
    L16:
        return;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        super.onAttachedToRecyclerView(r2);
        this.f = r2;
        GridLayoutManager r3 = r2.getLayoutManager();
        if ((r3 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r4 = r3;
        r4.setSpanSizeLookup(new a(this, r4));
    L5:
        this.f.addOnScrollListener(new e04.a(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r3) {
        if ((r3 instanceof LoadMoreViewHolder) == false) goto L6;
        LoadMoreViewHolder r4 = (LoadMoreViewHolder) r3;
        r4.getClass();
        int r0 = r4.c.b;
        r4.b.setMovementMethod(null);
        ((DmtStatusView) ((RecyclerView.ViewHolder) r4).itemView).setStatus(r4.c.b);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r6) {
        DmtStatusView r0 = new DmtStatusView(r6.getContext());
        int r1 = z2(r6);
        r0.setLayoutParams(new RecyclerView.LayoutParams(this.h, r1));
        TextView r2 = (TextView) LayoutInflater.from(r6.getContext()).inflate(2131558701, null);
        this.d = r2;
        int r3 = this.c;
        if (r3 == 0) goto L5;
        r2.setTextColor(r3);
    L5:
        this.d.setGravity(17);
        TextView r4 = (TextView) LayoutInflater.from(r6.getContext()).inflate(2131558703, null);
        r4.setText(2131894221);
        r4.setGravity(17);
        DmtStatusView.a r7 = DmtStatusView.a.a(r6.getContext());
        r7.b(this.d);
        r7.d(r4);
        r0.setBuilder(r7);
        LoadMoreViewHolder r8 = new LoadMoreViewHolder(this, r0, r4);
        this.g = r8;
        return r8;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        super.onViewAttachedToWindow(r3);
        StaggeredGridLayoutManager.LayoutParams r0 = r3.itemView.getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L13;
        StaggeredGridLayoutManager.LayoutParams r1 = r0;
        if (getItemViewType(r3.getLayoutPosition()) != Integer.MIN_VALUE) goto L9;
        boolean r4 = true;
    L10:
        r1.setFullSpan(r4);
        return;
    L9:
        r4 = false;
        goto L10
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        super.onViewDetachedFromWindow(r5);
        if (this.e != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.e = -1;
        return;
    }

    public int z2(View r2) {
        return r2.getResources().getDimensionPixelSize(2131165324);
    }
}
