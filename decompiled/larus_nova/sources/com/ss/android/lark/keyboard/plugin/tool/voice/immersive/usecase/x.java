package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class x<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430593a;

    public x(VoiceBubbleAreaUseCase r100) {
        this.f430593a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L5;
    L7:
        this.f430593a.f430447d.i().setVisibility(4);
        return;
    L5:
        if (((Boolean) KeyboardVoiceFGUtils.f429818d.getValue()).booleanValue() == false) goto L7;
        this.f430593a.f430447d.i().setVisibility(0);
    }
}
