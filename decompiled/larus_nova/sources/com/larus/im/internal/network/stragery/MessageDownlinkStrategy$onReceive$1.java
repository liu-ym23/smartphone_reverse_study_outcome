package com.larus.im.internal.network.stragery;

import com.larus.im.internal.protocol.bean.DownlinkMessage;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.stragery.MessageDownlinkStrategy$onReceive$1", f = "MessageDownlinkStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MessageDownlinkStrategy$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownlinkMessage $downlink;
    int label;
    final /* synthetic */ MessageDownlinkStrategy this$0;

    public MessageDownlinkStrategy$onReceive$1(MessageDownlinkStrategy r100, DownlinkMessage r101, Continuation<? super MessageDownlinkStrategy$onReceive$1> r102) {
        this.this$0 = r100;
        this.$downlink = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessageDownlinkStrategy$onReceive$1(this.this$0, this.$downlink, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MessageDownlinkStrategy$onReceive$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        vt7.b<Function1<DownlinkMessage, Unit>> r101 = this.this$0.f349535c;
        DownlinkMessage r102 = this.$downlink;
        Iterator<Function1<DownlinkMessage, Unit>> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r103.next().invoke(r102);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
