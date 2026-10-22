package com.larus.ui.arch.vm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1", f = "ComponentStateOperator.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_flowWhenStarted;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.k<T> f375198a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlinx.coroutines.channels.k<? super T> r100) {
            this.f375198a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r101) {
            Object r102 = this.f375198a.send(r100, r101);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r102;
        L6:
            return Unit.INSTANCE;
        }
    }

    public ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1(Flow<Object> r100, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1> r101) {
        this.$this_flowWhenStarted = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1 r102 = new ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1(this.$this_flowWhenStarted, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.k<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.k<Object> r100, Continuation<? super Unit> r101) {
        return ((ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        kotlinx.coroutines.channels.k r103 = (kotlinx.coroutines.channels.k) this.L$0;
        Flow<Object> r104 = this.$this_flowWhenStarted;
        a r105 = new a(r103);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
