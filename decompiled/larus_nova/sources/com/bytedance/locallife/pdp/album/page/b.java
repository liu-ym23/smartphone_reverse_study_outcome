package com.bytedance.locallife.pdp.album.page;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PictureViewHolder.a f261009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f261010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PictureViewHolder f261011c;

    public b(PictureRecyclerViewAdapter.a r100, int r101, PictureViewHolder r102) {
        this.f261009a = r100;
        this.f261010b = r101;
        this.f261011c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PictureViewHolder.a r101 = this.f261009a;
        if (r101 == null) goto L6;
        r101.a(this.f261010b, this.f261011c.f261004b);
        return;
    }
}
