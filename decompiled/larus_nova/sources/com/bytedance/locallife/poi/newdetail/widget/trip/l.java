package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.widget.SeekBar;

/* JADX INFO: loaded from: classes21.dex */
public final class l implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadVideoViewHolder f263687a;

    public l(TripPoiHeadVideoViewHolder r100) {
        this.f263687a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        s r101 = this.f263687a.f263623h;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        this.f263687a.f263627l = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        s r101 = this.f263687a.f263623h;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        this.f263687a.f263627l = false;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        TripPoiHeadVideoViewHolder r103 = this.f263687a;
        if (r103.f263627l == false) goto L6;
        r103.f263632q.k();
        return;
    }
}
