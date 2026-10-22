package mv1;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;

/* JADX INFO: loaded from: classes8.dex */
public final class j extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f515849a;

    public j(k r100) {
        this.f515849a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L11;
        BaseFeedAdapter r102 = this.f515849a.f515850a;
        r102.F2(r102.f123599g);
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if ((r103 instanceof StaggeredGridLayoutManager) == false) goto L13;
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r103;
        int r105 = r104.findFirstVisibleItemPositions(null)[0];
        if (r105 >= 0) goto L9;
        return;
    L9:
        if (r105 >= 3) goto L15;
        r104.invalidateSpanAssignments();
        return;
    L15:
        return;
    L13:
        return;
    L11:
        this.f515849a.f515850a.f123595c.removeCallbacksAndMessages(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        super.onScrolled(r100, r101, r102);
        if (r101 > 0) goto L5;
        if (r102 > 0) goto L5;
        return;
    L5:
        this.f515849a.f515850a.f123595c.removeCallbacksAndMessages(null);
    }
}
