package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "itemList");
        tt5.a.h("TtsMediaViewModel", "albumItemListObserver, itemList: " + r4);
        b.a(this.a);
    }
}
