package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.widget.SeekBar;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayControlBar f460823a;

    public b(PlayControlBar r100) {
        this.f460823a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        PlayControlBar.a r101 = this.f460823a.f460821h;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        PlayControlBar.a r101 = this.f460823a.f460821h;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        float r103 = r101;
        this.f460823a.f460819f = (1.0f * r103) / r100.getMax();
        PlayControlBar r104 = this.f460823a;
        PlayControlBar.b(r104, r104.f460819f);
        PlayControlBar.a r105 = this.f460823a.f460821h;
        if (r105 == null) goto L6;
        r105.onProgressChanged((int) (r103 * 0.1f));
        return;
    }
}
