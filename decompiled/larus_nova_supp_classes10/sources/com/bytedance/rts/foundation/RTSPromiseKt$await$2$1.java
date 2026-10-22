package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RTSPromiseKt$await$2$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Continuation<Object> $continuation;

    public RTSPromiseKt$await$2$1(Continuation<Object> r1) {
        this.$continuation = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1426invoke(Object r2) {
        this.$continuation.resumeWith(Result.constructor-impl(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1426invoke(r1);
        return Unit.INSTANCE;
    }
}
