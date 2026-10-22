package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes36.dex */
public final class f0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430523a;

    public f0(VoiceBubbleAreaUseCase r100) {
        this.f430523a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        AppCompatTextView r109 = this.f430523a.f430447d.l();
        int r110 = this.f430523a.f430453j;
        com.larksuite.framework.utils.g0.a(r109, r110, r110, r110, r110);
    }
}
