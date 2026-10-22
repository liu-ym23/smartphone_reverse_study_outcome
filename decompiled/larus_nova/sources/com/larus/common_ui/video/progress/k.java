package com.larus.common_ui.video.progress;

import android.widget.SeekBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerProgressView f328102a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public k(PlayerProgressView r100) {
        this.f328102a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        PlayerProgressView.a r103 = this.f328102a.f328075e;
        if (r103 == null) goto L6;
        r103.onProgressChanged(r101 / r100.getMax());
        return;
    }
}
