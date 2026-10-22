package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239723a;

    public d(b r100) {
        this.f239723a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        mo5.i r101 = (mo5.i) r100;
        Intrinsics.checkNotNullParameter(r101, "change");
        tt5.a.h("TtsMediaViewModel", "albumItemSelectionObserver, change: " + r101);
        this.f239723a.c((mo5.g) r101.f514584a);
        b r102 = this.f239723a;
        mo5.g r103 = (mo5.g) r101.f514585b;
        r102.getClass();
        if (r103 != null) goto L5;
        tt5.a.d("TtsMediaViewModel", "startItemObservers, itemVM is null.");
        return;
    L5:
        tt5.a.h("TtsMediaViewModel", "startItemObservers.");
        r103.i().observeForever(r102.f239701d);
        r103.u().observeForever(r102.f239702e);
        r103.o().observeForever(r102.f239703f);
        r103.r().observeForever(r102.f239704g);
        r103.g().observeForever(r102.f239705h);
    }
}
