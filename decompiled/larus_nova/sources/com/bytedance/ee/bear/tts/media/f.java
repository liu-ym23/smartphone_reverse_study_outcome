package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239725a;

    public f(b r100) {
        this.f239725a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        mo5.j r101 = (mo5.j) r100;
        Intrinsics.checkNotNullParameter(r101, "itemInfo");
        tt5.a.h("TtsMediaViewModel", "itemInfoObserver, itemInfo: " + r101);
        b.a(this.f239725a);
    }
}
