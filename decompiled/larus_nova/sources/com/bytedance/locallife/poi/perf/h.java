package com.bytedance.locallife.poi.perf;

import com.bytedance.locallife.dito.Dito;
import com.google.gson.Gson;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class<? extends Serializable> f263706a;

    public h(Class<? extends Serializable> r100) {
        this.f263706a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Dito r101 = Dito.f257280a;
        Gson r102 = (Gson) Dito.a().a(Gson.class);
        if (r102 != null) goto L5;
        r102 = new Gson();
    L5:
        r102.getAdapter(this.f263706a);
    }
}
