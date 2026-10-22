package ub1;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f549336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f549337b;

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView r100, int r101) {
    }

    public c(View r100, View r101) {
        this.f549336a = r100;
        this.f549337b = r101;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView r100, int r101, int r102, int r103) {
        com.bytedance.android.live.uikit.dialog.a.a(r100, this.f549336a, this.f549337b);
    }
}
