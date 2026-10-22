package com.bytedance.ee.bear.middleground.comment.uitls;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f232213a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super String, Unit> r100) {
        this.f232213a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Function1<String, Unit> r102 = this.f232213a;
        Intrinsics.checkNotNull(r101);
        r102.invoke(r101);
    }
}
