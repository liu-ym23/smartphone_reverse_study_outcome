package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes36.dex */
public final class d0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430511a;

    public d0(VoiceBubbleAreaUseCase r100) {
        this.f430511a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AppCompatTextView r101 = this.f430511a.f430447d.r();
        r101.setText((String) r100);
    }
}
