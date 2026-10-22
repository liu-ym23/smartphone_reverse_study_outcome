package com.obric.assistant.state.impl.v2.core;

import com.obric.assistant.state.api.v2.core.bean.ObricState;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.core.ObricStateDispatcher$onObricStateChanged$1", f = "ObricStateDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricStateDispatcher$onObricStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricState $state;
    int label;

    public ObricStateDispatcher$onObricStateChanged$1(ObricState r100, Continuation<? super ObricStateDispatcher$onObricStateChanged$1> r101) {
        this.$state = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricStateDispatcher$onObricStateChanged$1(this.$state, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricStateDispatcher$onObricStateChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        Set<cha.c> r101 = ObricStateDispatcher.f393178b.get(this.$state.getConversationId());
        if (r101 == null) goto L10;
        ObricState r102 = this.$state;
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((cha.c) r103.next()).c(r102);
    L10:
        CopyOnWriteArraySet<cha.c> r104 = ObricStateDispatcher.f393179c;
        ObricState r105 = this.$state;
        Iterator<T> r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L15;
        ((cha.c) r106.next()).c(r105);
        goto L12
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
