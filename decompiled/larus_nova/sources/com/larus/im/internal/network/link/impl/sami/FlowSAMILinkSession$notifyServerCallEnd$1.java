package com.larus.im.internal.network.link.impl.sami;

import com.larus.im.internal.delegate.j0;
import com.larus.im.internal.network.link.impl.sami.protocol.SamiApiChannel;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.link.impl.sami.FlowSAMILinkSession$notifyServerCallEnd$1", f = "FlowSAMILinkSession.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID}, m = "invokeSuspend", n = {}, s = {})
final class FlowSAMILinkSession$notifyServerCallEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localCallId;
    int label;

    public FlowSAMILinkSession$notifyServerCallEnd$1(String r100, Continuation<? super FlowSAMILinkSession$notifyServerCallEnd$1> r101) {
        this.$localCallId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowSAMILinkSession$notifyServerCallEnd$1(this.$localCallId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowSAMILinkSession$notifyServerCallEnd$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        gd9.e r104 = (gd9.e) r100;
        if (r104 != null) goto L14;
    L16:
        r103 = false;
    L17:
        fe9.a.f476620a.e("FlowSAMILinkSession", "call server isSuccess:" + r103 + ",ret:" + r104);
        return Unit.INSTANCE;
    L14:
        if (r104.c() == false) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        j0 r105 = SamiApiChannel.f349490a;
        String r106 = this.$localCallId;
        this.label = 1;
        r100 = SamiApiChannel.a(r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
