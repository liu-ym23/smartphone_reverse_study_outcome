package com.ss.android.lark.flow.chat.message.block.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements FlowAudioWaveView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowAudioPlayBar f422406a;

    public c(FlowAudioPlayBar r100) {
        this.f422406a = r100;
    }

    @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
    public final void a(FlowAudioWaveView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FlowAudioPlayBar.b r102 = this.f422406a.getAudioPlayBarListener();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
    public final void c(FlowAudioWaveView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FlowAudioPlayBar.b r102 = this.f422406a.getAudioPlayBarListener();
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
    public final void d(FlowAudioWaveView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FlowAudioPlayBar.b r102 = this.f422406a.getAudioPlayBarListener();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }
}
