package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceWaveBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class u<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430590a;

    public u(VoiceBubbleAreaUseCase r100) {
        this.f430590a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Double r101 = (Double) r100;
        VoiceWaveBar r102 = this.f430590a.f430447d.s();
        Intrinsics.checkNotNull(r101);
        r102.a(r101);
    }
}
