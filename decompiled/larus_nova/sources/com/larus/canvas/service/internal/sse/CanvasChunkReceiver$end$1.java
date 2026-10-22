package com.larus.canvas.service.internal.sse;

import com.larus.canvas.service.bean.CanvasBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.CanvasChunkReceiver$end$1", f = "CanvasChunkReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasChunkReceiver$end$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $data;
    int label;
    final /* synthetic */ CanvasChunkReceiver this$0;

    public CanvasChunkReceiver$end$1(CanvasChunkReceiver r100, f r101, Continuation<? super CanvasChunkReceiver$end$1> r102) {
        this.this$0 = r100;
        this.$data = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CanvasChunkReceiver$end$1(this.this$0, this.$data, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CanvasChunkReceiver$end$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r110);
        CanvasChunkReceiver r111 = this.this$0;
        ny8.c r100 = r111.f323842a;
        List<CanvasBlock> r112 = r111.f323845d;
        f r101 = this.$data;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r113 = r112.iterator();
    L6:
        if (r113.hasNext() == false) goto L8;
        r102.add(CanvasBlock.copy$default((CanvasBlock) r113.next(), null, null, null, false, r101.f323873b, 15, null));
        goto L6
    L8:
        r100.b(r102);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
