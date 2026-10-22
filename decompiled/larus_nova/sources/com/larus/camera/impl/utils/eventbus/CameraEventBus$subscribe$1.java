package com.larus.camera.impl.utils.eventbus;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/camera/impl/utils/eventbus/Event;", "it"}, k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "com.larus.camera.impl.utils.eventbus.CameraEventBus$subscribe$1", f = "CameraEventBus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraEventBus$subscribe$1 extends SuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<g, Unit> $onEachBlock;
    /* synthetic */ Object L$0;
    int label;

    public CameraEventBus$subscribe$1(Function1<g, Unit> r100, Continuation<? super CameraEventBus$subscribe$1> r101) {
        this.$onEachBlock = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.needClassReification();
        CameraEventBus$subscribe$1 r102 = new CameraEventBus$subscribe$1(this.$onEachBlock, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(g r100, Continuation<? super Unit> r101) {
        return ((CameraEventBus$subscribe$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(g r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        g r101 = (g) this.L$0;
        this.$onEachBlock.invoke(r101);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object r100) {
        g r101 = (g) this.L$0;
        InlineMarker.mark(10);
        this.$onEachBlock.invoke(r101);
        return Unit.INSTANCE;
    }
}
