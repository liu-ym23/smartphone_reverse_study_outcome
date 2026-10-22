package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.localmedia.LocalMediaBottomProvider$saveCurrent$1$saved$1", f = "LocalMediaBottomProvider.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class LocalMediaBottomProvider$saveCurrent$1$saved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ ifa.c $item;
    int label;

    public LocalMediaBottomProvider$saveCurrent$1$saved$1(Context r100, ifa.c r101, Continuation<? super LocalMediaBottomProvider$saveCurrent$1$saved$1> r102) {
        this.$ctx = r100;
        this.$item = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LocalMediaBottomProvider$saveCurrent$1$saved$1(this.$ctx, this.$item, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((LocalMediaBottomProvider$saveCurrent$1$saved$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        LocalMediaShareHelper r103 = LocalMediaShareHelper.f390800a;
        Context r104 = this.$ctx;
        ifa.c r105 = this.$item;
        this.label = 1;
        r100 = r103.b(r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
