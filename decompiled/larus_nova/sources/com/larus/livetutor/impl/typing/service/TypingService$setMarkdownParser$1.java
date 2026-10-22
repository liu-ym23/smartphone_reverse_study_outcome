package com.larus.livetutor.impl.typing.service;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import lw8.l;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.typing.service.TypingService$setMarkdownParser$1", f = "TypingService.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
final class TypingService$setMarkdownParser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TypingService this$0;

    public TypingService$setMarkdownParser$1(TypingService r100, Continuation<? super TypingService$setMarkdownParser$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TypingService$setMarkdownParser$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TypingService$setMarkdownParser$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        l r103 = (l) r100;
        if (r103 == null) goto L19;
        TypingService r104 = this.this$0;
        r104.f356627p = r103.e();
        this.this$0.f356628q = r103;
        if (TypingService.j(this.this$0) == false) goto L24;
        TypingService.l(this.this$0);
    L24:
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        if (this.this$0.f356626o.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L24;
        TypingService r106 = this.this$0;
        StringBuffer r107 = r106.f356626o;
        long r108 = SystemClock.elapsedRealtime();
        this.label = 1;
        r100 = TypingService.k(r106, r107, r108, this);
        if (r100 != r101) goto L16;
        return r101;
    L11:
        r105 = false;
        goto L12
    }
}
