package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "resolve", "Lkotlin/Function1;", "reject", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RTSPromiseKt$async$1 extends Lambda implements Function2<Function1<Object, ? extends Unit>, Function1<? super Object, ? extends Unit>, Unit> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $block;

    public static final class a implements Continuation<Object> {
        public final EmptyCoroutineContext a;
        public final /* synthetic */ Function1<Object, Unit> b;
        public final /* synthetic */ Function1<Object, Unit> c;

        public CoroutineContext getContext() {
            return this.a;
        }

        public final void resumeWith(Object r3) {
            Function1<Object, Unit> r0 = this.b;
            if (Result.isSuccess-impl(r3) == false) goto L5;
            r0.invoke(r3);
        L5:
            Function1<Object, Unit> r1 = this.c;
            Throwable r4 = Result.exceptionOrNull-impl(r3);
            if (r4 == null) goto L9;
            r1.invoke(r4);
            return;
        }

        public a(Function1<Object, Unit> r1, Function1<Object, Unit> r2) {
            this.b = r1;
            this.c = r2;
            this.a = EmptyCoroutineContext.INSTANCE;
        }
    }

    public RTSPromiseKt$async$1(Function1<? super Continuation<Object>, ? extends Object> r1) {
        this.$block = r1;
        super(2);
    }

    public final void invoke(Function1<Object, Unit> r3, Function1<Object, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "resolve");
        Intrinsics.checkNotNullParameter(r4, "reject");
        ContinuationKt.startCoroutine(this.$block, new a(r3, r4));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Function1) r1, (Function1) r2);
        return Unit.INSTANCE;
    }
}
