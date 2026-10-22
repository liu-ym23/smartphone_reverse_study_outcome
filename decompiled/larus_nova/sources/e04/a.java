package e04;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadMoreRecyclerViewAdapter f470636a;

    public a(LoadMoreRecyclerViewAdapter r100) {
        this.f470636a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        if (this.f470636a.f196985i == false) goto L7;
        return;
    L7:
        if (r100.canScrollVertically(1) == true) goto L12;
        LoadMoreRecyclerViewAdapter.y2(this.f470636a);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        super.onScrolled(r100, r101, r102);
        if (this.f470636a.f196985i == true) goto L5;
    L7:
        LoadMoreRecyclerViewAdapter r103 = this.f470636a;
        if (r103.f196985i == false) goto L12;
        r103.f196985i = false;
        return;
    L12:
        return;
    L5:
        if (r100.canScrollVertically(1) == true) goto L7;
        LoadMoreRecyclerViewAdapter.y2(this.f470636a);
    }
}
