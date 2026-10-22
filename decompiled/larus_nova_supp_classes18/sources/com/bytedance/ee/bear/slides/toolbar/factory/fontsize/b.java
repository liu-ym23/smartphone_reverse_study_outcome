package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.widget.SeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ FontSizeAdapter.FontSizeSliderViewHolder a;
    public final /* synthetic */ FontSizeAdapter b;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r4) {
        if (r4 == null) goto L4;
        int r5 = r4.getProgress();
    L5:
        int r0 = this.a.d + r5;
        tt5.a.h("FontSizeAdapter", "onStopTrackingTouch: progress:" + r5 + " actualFontSize:" + r0);
        i r6 = this.b.c;
        if (r6 == null) goto L9;
        r6.a(r0);
        return;
    L9:
        return;
    L4:
        r5 = 0;
        goto L5
    }

    public b(FontSizeAdapter.FontSizeSliderViewHolder r1, FontSizeAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r3, int r4, boolean r5) {
        if (r5 == false) goto L5;
        FontSizeAdapter.FontSizeSliderViewHolder r6 = this.a;
        int r7 = r6.d + r4;
        FontSizeAdapter r0 = this.b;
        int r1 = FontSizeAdapter.d;
        r0.getClass();
        FontSizeAdapter.y2(r6, r7);
        tt5.a.h("FontSizeAdapter", "onProgressChanged:progress " + r4 + ',');
        return;
    }
}
