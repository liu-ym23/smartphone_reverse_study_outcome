package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        mo5.j r4 = (mo5.j) r3;
        Intrinsics.checkNotNullParameter(r4, "itemInfo");
        tt5.a.h("TtsMediaViewModel", "itemInfoObserver, itemInfo: " + r4);
        b.a(this.a);
    }
}
