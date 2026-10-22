package com.ss.android.lark.flow.chat.message.block.audio;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowAudioPlayBar f422405a;

    public b(FlowAudioPlayBar r100) {
        this.f422405a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FlowAudioPlayBar.b r101 = this.f422405a.getAudioPlayBarListener();
        if (r101 == null) goto L6;
        r101.b(this.f422405a.f422377a.f422104b);
        return;
    }
}
