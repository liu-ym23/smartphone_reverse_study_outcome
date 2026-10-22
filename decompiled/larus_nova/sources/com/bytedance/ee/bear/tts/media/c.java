package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239722a;

    public c(b r100) {
        this.f239722a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "itemList");
        tt5.a.h("TtsMediaViewModel", "albumItemListObserver, itemList: " + r101);
        b.a(this.f239722a);
    }
}
