package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239728a;

    public i(b r100) {
        this.f239728a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        tt5.a.h("TtsMediaViewModel", "totalDurationObserver, totalDurationMs: " + ((Number) r100).longValue());
        b.a(this.f239728a);
    }
}
