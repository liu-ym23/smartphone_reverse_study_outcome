package com.bytedance.locallife.poi.newdetail.widget.seekbar;

import android.widget.SeekBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SeekBar.OnSeekBarChangeListener> f263488a;

    public d() {
        this.f263488a = new ArrayList();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        Iterator<T> r101 = this.f263488a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((SeekBar.OnSeekBarChangeListener) r101.next()).onStartTrackingTouch(r100);
        goto L4
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        Iterator<T> r101 = this.f263488a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((SeekBar.OnSeekBarChangeListener) r101.next()).onStopTrackingTouch(r100);
        goto L4
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        Iterator<T> r103 = this.f263488a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((SeekBar.OnSeekBarChangeListener) r103.next()).onProgressChanged(r100, r101, r102);
        goto L4
    }
}
