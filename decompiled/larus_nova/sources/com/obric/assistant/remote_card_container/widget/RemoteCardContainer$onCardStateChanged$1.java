package com.obric.assistant.remote_card_container.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$onCardStateChanged$1", f = "RemoteCardContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardContainer$onCardStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardUri;
    int label;
    final /* synthetic */ RemoteCardContainer this$0;

    public RemoteCardContainer$onCardStateChanged$1(String r100, RemoteCardContainer r101, Continuation<? super RemoteCardContainer$onCardStateChanged$1> r102) {
        this.$cardUri = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RemoteCardContainer$onCardStateChanged$1(this.$cardUri, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteCardContainer$onCardStateChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$cardUri;
        a r102 = this.this$0.f391297b;
        if (r102 == null) goto L7;
        String r103 = r102.f391303a;
    L9:
        if (Intrinsics.areEqual(r101, r103) == false) goto L12;
        p9a.b.a("RemoteCardContainer", "onCardStateChanged");
        RemoteCardContainer r104 = this.this$0;
        r104.d(r104.f391297b, false);
    L12:
        return Unit.INSTANCE;
    L7:
        r103 = null;
        goto L9
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
