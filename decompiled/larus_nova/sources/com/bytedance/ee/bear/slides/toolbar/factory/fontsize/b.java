package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.widget.SeekBar;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FontSizeAdapter.FontSizeSliderViewHolder f238594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FontSizeAdapter f238595b;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getProgress();
    L5:
        int r102 = this.f238594a.f238585d + r101;
        tt5.a.h("FontSizeAdapter", "onStopTrackingTouch: progress:" + r101 + " actualFontSize:" + r102);
        i r103 = this.f238595b.f238581c;
        if (r103 == null) goto L9;
        r103.a(r102);
        return;
    L9:
        return;
    L4:
        r101 = 0;
        goto L5
    }

    public b(FontSizeAdapter.FontSizeSliderViewHolder r100, FontSizeAdapter r101) {
        this.f238594a = r100;
        this.f238595b = r101;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        FontSizeAdapter.FontSizeSliderViewHolder r103 = this.f238594a;
        int r104 = r103.f238585d + r101;
        FontSizeAdapter r105 = this.f238595b;
        int r106 = FontSizeAdapter.f238578d;
        r105.getClass();
        FontSizeAdapter.y2(r103, r104);
        tt5.a.h("FontSizeAdapter", "onProgressChanged:progress " + r101 + ',');
        return;
    }
}
