package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "reason", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RTSPromiseKt$await$2$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Continuation<Object> $continuation;

    public RTSPromiseKt$await$2$2(Continuation<Object> r1) {
        this.$continuation = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1427invoke(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        if ((r3 instanceof Throwable) == false) goto L5;
        Throwable r4 = (Throwable) r3;
    L6:
        Continuation<Object> r0 = this.$continuation;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r4)));
        return;
    L5:
        r4 = new RuntimeException(r3.toString());
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1427invoke(r1);
        return Unit.INSTANCE;
    }
}
