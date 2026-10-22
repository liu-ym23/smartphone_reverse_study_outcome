package ia4;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f488902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f488903b;

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView r100, int r101) {
    }

    public b(View r100, View r101) {
        this.f488902a = r100;
        this.f488903b = r101;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView r100, int r101, int r102, int r103) {
        a.a(r100, this.f488902a, this.f488903b);
    }
}
