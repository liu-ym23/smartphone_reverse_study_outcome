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
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "started", "", "value"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$transform$1", f = "ComponentStateOperator.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$transform$1 extends SuspendLambda implements Function3<Boolean, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.channels.k<Object> $$this$channelFlow;
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ComponentStateOperator$flowWhenStarted$1$1$transform$1(kotlinx.coroutines.channels.k<Object> r100, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$transform$1> r101) {
        this.$$this$channelFlow = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Object r101, Continuation<? super Unit> r102) {
        return invoke(r100.booleanValue(), r101, r102);
    }

    public final Object invoke(boolean r100, Object r101, Continuation<? super Unit> r102) {
        ComponentStateOperator$flowWhenStarted$1$1$transform$1 r103 = new ComponentStateOperator$flowWhenStarted$1$1$transform$1(this.$$this$channelFlow, r102);
        r103.Z$0 = r100;
        r103.L$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        boolean r103 = this.Z$0;
        Object r104 = this.L$0;
        if (r103 == false) goto L14;
        kotlinx.coroutines.channels.k<Object> r105 = this.$$this$channelFlow;
        this.label = 1;
        if (r105.send(r104, this) != r101) goto L14;
        return r101;
    }
}
