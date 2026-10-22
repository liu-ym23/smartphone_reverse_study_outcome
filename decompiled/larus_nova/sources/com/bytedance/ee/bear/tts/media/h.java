package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239727a;

    public h(b r100) {
        this.f239727a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        tt5.a.h("TtsMediaViewModel", "playerSpeedObserver, speed: " + ((Number) r100).floatValue());
        b.a(this.f239727a);
    }
}
