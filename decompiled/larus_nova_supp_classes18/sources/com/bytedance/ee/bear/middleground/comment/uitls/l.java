package com.bytedance.ee.bear.middleground.comment.uitls;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ Function1<String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super String, Unit> r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        Function1<String, Unit> r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.invoke(r3);
    }
}
