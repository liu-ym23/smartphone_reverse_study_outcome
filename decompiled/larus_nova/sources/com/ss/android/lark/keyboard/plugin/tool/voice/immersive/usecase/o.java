package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f430566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430567b;

    public o(AppCompatImageView r100, VoiceBubbleAreaUseCase r101) {
        this.f430566a = r100;
        this.f430567b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        this.f430566a.startAnimation((Animation) this.f430567b.f430449f.getValue());
    }
}
