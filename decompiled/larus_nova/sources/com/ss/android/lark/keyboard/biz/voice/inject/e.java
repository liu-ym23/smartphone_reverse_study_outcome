package com.ss.android.lark.keyboard.biz.voice.inject;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceInnerEndPlugin f428633a;

    public e(VoiceInnerEndPlugin r100) {
        this.f428633a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        if (this.f428633a.f428572m == true) goto L11;
        VoiceInnerEndPlugin r109 = this.f428633a;
        if (r109.f428573n == true) goto L7;
        return;
    L7:
        if (r109.f428574o == false) goto L13;
        r109.f428574o = false;
        r109.k(0);
        return;
    L13:
        return;
    }
}
