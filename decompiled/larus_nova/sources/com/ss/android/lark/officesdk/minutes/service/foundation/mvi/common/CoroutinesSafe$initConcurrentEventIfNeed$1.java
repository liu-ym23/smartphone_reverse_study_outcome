package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.c;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/repo/ConcurrentEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$initConcurrentEventIfNeed$1", f = "CoroutinesSafe.kt", i = {}, l = {34, 35}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesSafe$initConcurrentEventIfNeed$1 extends SuspendLambda implements Function2<c<a>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public CoroutinesSafe$initConcurrentEventIfNeed$1(Continuation<? super CoroutinesSafe$initConcurrentEventIfNeed$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CoroutinesSafe$initConcurrentEventIfNeed$1 r102 = new CoroutinesSafe$initConcurrentEventIfNeed$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(c<a> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c<a> r100, Continuation<? super Unit> r101) {
        return ((CoroutinesSafe$initConcurrentEventIfNeed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0062 -> B:12:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ChannelIterator r103 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r100);
        ChannelIterator r104 = r103;
    L11:
        CoroutinesSafe$initConcurrentEventIfNeed$1 r105 = this;
    L12:
        r105.L$0 = r104;
        r105.label = 1;
        Object r106 = r104.hasNext(r105);
        if (r106 != r101) goto L15;
        return r101;
    L15:
        CoroutinesSafe$initConcurrentEventIfNeed$1 r107 = r105;
        ChannelIterator r108 = r104;
        r100 = r106;
        CoroutinesSafe$initConcurrentEventIfNeed$1 r109 = r107;
    L17:
        if (((Boolean) r100).booleanValue() == false) goto L23;
        Function1<Continuation<? super Unit>, Object> r110 = ((a) r108.next()).f433825a;
        r109.L$0 = r108;
        r109.label = 2;
        if (r110.invoke(r109) != r101) goto L21;
        return r101;
    L21:
        r104 = r108;
        r105 = r109;
        goto L12
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r108 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r100);
        r109 = this;
        goto L17
    L10:
        ResultKt.throwOnFailure(r100);
        r104 = ((c) this.L$0).getChannel().iterator();
        goto L11
    }
}
