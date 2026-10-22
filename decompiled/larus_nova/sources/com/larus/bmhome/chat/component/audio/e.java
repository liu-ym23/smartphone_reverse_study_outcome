package com.larus.bmhome.chat.component.audio;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.component.cvs.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements y.a<wc9.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableLiveData<wc9.e> f297937a;

    public e(MutableLiveData<wc9.e> r100) {
        this.f297937a = r100;
    }

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(wc9.e r100) {
        wc9.e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "new");
        this.f297937a.postValue(r101);
    }
}
