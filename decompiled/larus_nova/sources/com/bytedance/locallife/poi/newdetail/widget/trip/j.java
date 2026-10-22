package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadTagViewHolder f263684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadTagsAdapter f263685b;

    public j(TripPoiHeadTagViewHolder r100, TripPoiHeadTagsAdapter r101) {
        this.f263684a = r100;
        this.f263685b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f263684a.getAdapterPosition();
        if (r101 < 0) goto L10;
        TripPoiHeadTagsAdapter r102 = this.f263685b;
        int r103 = r102.f263583b;
        if (r101 == r103) goto L11;
        d r104 = r102.f263585d;
        if (r104 == null) goto L12;
        r104.e(r102.f263584c, r103, r101);
        return;
    L12:
        return;
    L11:
        return;
    }
}
