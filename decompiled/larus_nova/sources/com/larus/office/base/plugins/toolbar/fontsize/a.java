package com.larus.office.base.plugins.toolbar.fontsize;

import android.widget.SeekBar;
import com.larus.utils.logger.FLogger;
import hn9.e;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FontSizeAdapter.FontSizeSliderViewHolder f360905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FontSizeAdapter f360906b;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getProgress();
    L5:
        int r102 = this.f360905a.f360896d + r101;
        FLogger.f375446a.i("FontSizeAdapter", "onStopTrackingTouch: progress:" + r101 + " actualFontSize:" + r102);
        e r103 = this.f360906b.f360892c;
        if (r103 == null) goto L9;
        r103.a(r102);
        return;
    L9:
        return;
    L4:
        r101 = 0;
        goto L5
    }

    public a(FontSizeAdapter.FontSizeSliderViewHolder r100, FontSizeAdapter r101) {
        this.f360905a = r100;
        this.f360906b = r101;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        FontSizeAdapter.FontSizeSliderViewHolder r103 = this.f360905a;
        int r104 = r103.f360896d + r101;
        FontSizeAdapter r105 = this.f360906b;
        int r106 = FontSizeAdapter.f360889d;
        r105.getClass();
        FontSizeAdapter.y2(r103, r104);
        FLogger.f375446a.i("FontSizeAdapter", "onProgressChanged:progress " + r101 + ',');
        return;
    }
}
