package com.larus.luckydog.impl;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ym7.l;
import ym7.n;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.luckydog.impl.LuckyDogServiceImpl$showLuckDogPendantView$1$1$1", f = "LuckyDogServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LuckyDogServiceImpl$showLuckDogPendantView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FrameLayout $frameLayout;
    int label;

    public LuckyDogServiceImpl$showLuckDogPendantView$1$1$1(FrameLayout r100, Continuation<? super LuckyDogServiceImpl$showLuckDogPendantView$1$1$1> r101) {
        this.$frameLayout = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LuckyDogServiceImpl$showLuckDogPendantView$1$1$1(this.$frameLayout, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LuckyDogServiceImpl$showLuckDogPendantView$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L9;
        ResultKt.throwOnFailure(r100);
        l r101 = (l) wm7.g.a(l.class);
        if (r101 == null) goto L10;
        r101.d("default", new n(this.$frameLayout, null, 6));
        return Unit.INSTANCE;
    L10:
        return null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
