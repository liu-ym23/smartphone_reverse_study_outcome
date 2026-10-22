package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseAdapter<T> extends LoadMoreRecyclerViewAdapter {
    public static final /* synthetic */ int n = 0;
    public List<T> l;
    public int m;

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ BaseAdapter a;

        public final void onChanged() {
            BaseAdapter r0 = this.a;
            r0.m = r0.getItemCount();
            int r1 = BaseAdapter.n;
        }

        public a(BaseAdapter r1) {
            this.a = r1;
        }

        public final void onItemRangeChanged(int r1, int r2) {
            BaseAdapter r3 = this.a;
            r3.m = r3.getItemCount();
            int r4 = BaseAdapter.n;
        }

        public final void onItemRangeInserted(int r1, int r2) {
            BaseAdapter r3 = this.a;
            r3.m = r3.getItemCount();
            int r4 = BaseAdapter.n;
        }

        public final void onItemRangeRemoved(int r1, int r2) {
            BaseAdapter r3 = this.a;
            r3.m = r3.getItemCount();
            int r4 = BaseAdapter.n;
        }

        public final void onItemRangeMoved(int r1, int r2, int r3) {
            BaseAdapter r4 = this.a;
            r4.m = r4.getItemCount();
            int r5 = BaseAdapter.n;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        List<T> r0 = this.l;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public BaseAdapter() {
        this.m = 0;
        registerAdapterDataObserver(new a(this));
    }

    static {
    }

    public final void B2(boolean r1) {
        if (r1 == false) goto L4;
        notifyItemInserted(getItemCount());
    L5:
        this.m = getItemCount();
        return;
    L4:
        notifyItemRemoved(getItemCount() - 1);
        goto L5
    }
}
