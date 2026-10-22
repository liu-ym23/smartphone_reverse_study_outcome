package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class v<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430591a;

    public v(VoiceBubbleAreaUseCase r100) {
        this.f430591a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        int r101 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        KeyboardFunctionEditText r102 = this.f430591a.f430447d.a();
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.k(r102, (CharSequence) r100, -1);
    }
}
