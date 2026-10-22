package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ b a;

    public i(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        tt5.a.h("TtsMediaViewModel", "totalDurationObserver, totalDurationMs: " + ((Number) r4).longValue());
        b.a(this.a);
    }
}
