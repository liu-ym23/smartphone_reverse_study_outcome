package com.larus.browsertakeover.session;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.session.BrowserTakeoverSession$startPendingCompletion$1$success$1", f = "BrowserTakeoverSession.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "invokeSuspend", n = {}, s = {})
public final class BrowserTakeoverSession$startPendingCompletion$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ com.larus.browsertakeover.entry.a.C4138a $current;
    int label;

    public BrowserTakeoverSession$startPendingCompletion$1$success$1(com.larus.browsertakeover.entry.a.C4138a r100, Continuation<? super BrowserTakeoverSession$startPendingCompletion$1$success$1> r101) {
        this.$current = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BrowserTakeoverSession$startPendingCompletion$1$success$1(this.$current, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((BrowserTakeoverSession$startPendingCompletion$1$success$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.larus.browsertakeover.entry.a.C4138a r103 = this.$current;
        hv8.d r104 = r103.f319483b;
        hv8.a r105 = r103.f319482a;
        this.label = 1;
        r100 = r104.a(r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
