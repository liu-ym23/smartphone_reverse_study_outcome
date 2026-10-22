package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceFaceKBPlugin f430418a;

    public b(VoiceFaceKBPlugin r100) {
        this.f430418a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VoiceFaceKBPlugin.H(this.f430418a);
    }
}
