package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceActionAreaUseCase f430522a;

    public f(VoiceActionAreaUseCase r100) {
        this.f430522a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        this.f430522a.f430433g = true;
        return;
    }
}
