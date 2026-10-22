package com.obric.assistant.remote_card_container;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$showMenu$1$2$1", f = "RemoteCardImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RemoteCardImpl$showMenu$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ o9a.b $menuBean;
    private /* synthetic */ Object L$0;
    int label;

    public RemoteCardImpl$showMenu$1$2$1(o9a.b r100, int r101, Continuation<? super RemoteCardImpl$showMenu$1$2$1> r102) {
        this.$menuBean = r100;
        this.$index = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RemoteCardImpl$showMenu$1$2$1 r102 = new RemoteCardImpl$showMenu$1$2$1(this.$menuBean, this.$index, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteCardImpl$showMenu$1$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        o9a.b r102 = this.$menuBean;
        int r103 = this.$index;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        IHostApiCallback r105 = ((o9a.c) ListProtector.get(r102.f522495a, r103)).f522498b;     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        r105.onHostApiCallback(new Bundle());     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        FLogger.f375446a.w("RemoteCardImpl", "failed: " + r108.getMessage(), r108);
    L17:
        return Unit.INSTANCE;
    L8:
        r106 = null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
