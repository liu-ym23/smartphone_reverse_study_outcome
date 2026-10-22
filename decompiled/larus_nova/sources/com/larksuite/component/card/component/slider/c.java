package com.larksuite.component.card.component.slider;

import android.widget.SeekBar;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UniversalCardLynxSliderUI f283561a;

    public c(UniversalCardLynxSliderUI r100) {
        this.f283561a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        UniversalCardLynxSliderUI r101 = this.f283561a;
        if (r100 == null) goto L5;
        int r102 = r100.getProgress();
    L6:
        UniversalCardLynxSliderUI.M(r101, r102, "start");
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getProgress();
    L5:
        UniversalCardLynxSliderUI.M(this.f283561a, r101, "end");
        return;
    L4:
        r101 = 0;
        goto L5
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        UniversalCardLynxSliderUI.M(this.f283561a, r101, "moving");
        return;
    }
}
