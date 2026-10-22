package com.larus.voicecall.impl.ui;

import com.larus.voicecall.impl.util.t0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0.b f379388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoiceCallVideoView f379389b;

    public /* synthetic */ j0(t0.b r100, VoiceCallVideoView r101) {
        this.f379388a = r100;
        this.f379389b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VoiceCallVideoView.a(this.f379388a, this.f379389b);
    }
}
