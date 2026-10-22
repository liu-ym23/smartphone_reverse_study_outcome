package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ b a;

    public h(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        tt5.a.h("TtsMediaViewModel", "playerSpeedObserver, speed: " + ((Number) r3).floatValue());
        b.a(this.a);
    }
}
