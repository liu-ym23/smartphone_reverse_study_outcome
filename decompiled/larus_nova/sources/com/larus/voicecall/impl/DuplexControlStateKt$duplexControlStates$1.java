package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitCoreStates$Paused;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/voicecall/impl/DuplexControlState;", "state", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "isMuted", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.DuplexControlStateKt$duplexControlStates$1", f = "DuplexControlState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DuplexControlStateKt$duplexControlStates$1 extends SuspendLambda implements Function3<AVKitDuplexState, Boolean, Continuation<? super c>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public DuplexControlStateKt$duplexControlStates$1(Continuation<? super DuplexControlStateKt$duplexControlStates$1> r100) {
        super(3, r100);
    }

    public final Object invoke(AVKitDuplexState r100, boolean r101, Continuation<? super c> r102) {
        DuplexControlStateKt$duplexControlStates$1 r103 = new DuplexControlStateKt$duplexControlStates$1(r102);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(AVKitDuplexState r100, Boolean r101, Continuation<? super c> r102) {
        return invoke(r100, r101.booleanValue(), r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        AVKitDuplexState r101 = (AVKitDuplexState) this.L$0;
        boolean r102 = this.Z$0;
        if ((r101.getUpState() instanceof AVKitCoreStates$Paused) == false) goto L7;
    L10:
        boolean r103 = true;
    L12:
        return new c(r102, r103);
    L7:
        if ((r101.getDownState() instanceof AVKitCoreStates$Paused) == true) goto L10;
        r103 = false;
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
