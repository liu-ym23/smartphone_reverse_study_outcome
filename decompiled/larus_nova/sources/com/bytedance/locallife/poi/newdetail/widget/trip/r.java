package com.bytedance.locallife.poi.newdetail.widget.trip;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadWidget f263696a;

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.b
    public final void a() {
        TripPoiHeadWidget r100 = this.f263696a;
        ViewPager2 r101 = r100.f263663s;
        if (r101 == null) goto L6;
        r101.postDelayed(r100.P0, 3000);
        return;
    }

    public r(TripPoiHeadWidget r100) {
        this.f263696a = r100;
    }
}
