package com.bytedance.livesdk.ktvcommon.api;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes20.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f255902a;

    public g(Function1 r100) {
        this.f255902a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f255902a;
        r101.invoke((Throwable) r100);
    }
}
