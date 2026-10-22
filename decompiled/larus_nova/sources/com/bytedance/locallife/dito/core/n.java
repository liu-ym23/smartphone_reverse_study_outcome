package com.bytedance.locallife.dito.core;

import com.bytedance.locallife.dito.common.lynx.DitoLynxNativeModule;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f257966a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Function1<? super Integer, Unit> r100) {
        this.f257966a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        rq6.a.f538927a.a(DitoLynxNativeModule.NAME, "retryToScrollToTarget.invoke(), times = " + r101);
        this.f257966a.invoke(Integer.valueOf((int) r101.longValue()));
    }
}
