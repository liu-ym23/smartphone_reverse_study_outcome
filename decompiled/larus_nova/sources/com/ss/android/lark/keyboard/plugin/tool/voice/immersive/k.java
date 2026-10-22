package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes36.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsrInputVoiceView f430290a;

    public k(AsrInputVoiceView r100) {
        this.f430290a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        AsrInputVoiceView r101 = this.f430290a;
        AsrInputVoiceView.C6(r101, AsrInputVoiceView.n6(r101));
        return;
    }
}
