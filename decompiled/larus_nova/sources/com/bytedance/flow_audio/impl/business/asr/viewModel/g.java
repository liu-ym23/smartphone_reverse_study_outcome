package com.bytedance.flow_audio.impl.business.asr.viewModel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements xw5.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceInputViewModel f244055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f244056c;

    @Override // xw5.e
    public final void V0(xw5.f r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (r100.f565230a == false) goto L5;
        this.f244055b.getClass();
        this.f244055b.h3("[activateAudioSceneResourceAsync] activate audio scene success: scene=" + this.f244055b.f244026b + " hasResource=false");
        this.f244056c.invoke(Boolean.TRUE);
        return;
    L5:
        this.f244055b.l3("[activateAudioSceneResourceAsync] activate audio scene failed: scene=" + this.f244055b.f244026b + " error=" + r100.f565231b);
        this.f244056c.invoke(Boolean.FALSE);
    }

    public g(VoiceInputViewModel r100, d r101) {
        this.f244055b = r100;
        this.f244056c = r101;
    }
}
