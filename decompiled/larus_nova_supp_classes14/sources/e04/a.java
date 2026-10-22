package e04;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends RecyclerView.OnScrollListener {
    public final /* synthetic */ LoadMoreRecyclerViewAdapter a;

    public a(LoadMoreRecyclerViewAdapter r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        if (r2 == 0) goto L5;
        return;
    L5:
        if (this.a.i == false) goto L7;
        return;
    L7:
        if (r1.canScrollVertically(1) == true) goto L12;
        LoadMoreRecyclerViewAdapter.y2(this.a);
        return;
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
        if (this.a.i == true) goto L5;
    L7:
        LoadMoreRecyclerViewAdapter r4 = this.a;
        if (r4.i == false) goto L12;
        r4.i = false;
        return;
    L12:
        return;
    L5:
        if (r1.canScrollVertically(1) == true) goto L7;
        LoadMoreRecyclerViewAdapter.y2(this.a);
    }
}
