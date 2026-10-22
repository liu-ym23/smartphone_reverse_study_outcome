package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        mo5.i r5 = (mo5.i) r4;
        Intrinsics.checkNotNullParameter(r5, "change");
        tt5.a.h("TtsMediaViewModel", "albumItemSelectionObserver, change: " + r5);
        this.a.c((mo5.g) r5.a);
        b r0 = this.a;
        mo5.g r6 = (mo5.g) r5.b;
        r0.getClass();
        if (r6 != null) goto L5;
        tt5.a.d("TtsMediaViewModel", "startItemObservers, itemVM is null.");
        return;
    L5:
        tt5.a.h("TtsMediaViewModel", "startItemObservers.");
        r6.i().observeForever(r0.d);
        r6.u().observeForever(r0.e);
        r6.o().observeForever(r0.f);
        r6.r().observeForever(r0.g);
        r6.g().observeForever(r0.h);
    }
}
