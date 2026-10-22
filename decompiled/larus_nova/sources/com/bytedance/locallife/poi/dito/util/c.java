package com.bytedance.locallife.poi.dito.util;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f262547a = null;

    static {
        f262547a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        r100.onNext("兜底");
        r100.onComplete();
    }
}
