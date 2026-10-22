package com.larus.doc.impl.video.widget;

import android.widget.SeekBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerProgressView f331565a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public j(PlayerProgressView r100) {
        this.f331565a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        PlayerProgressView.a r103 = this.f331565a.f331508d;
        if (r103 == null) goto L6;
        r103.onProgressChanged(r101 / r100.getMax());
        return;
    }
}
