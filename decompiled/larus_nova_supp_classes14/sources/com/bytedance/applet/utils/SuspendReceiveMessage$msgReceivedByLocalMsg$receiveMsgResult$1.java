package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1", f = "SuspendReceiveMessage.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SuspendReceiveMessage this$0;

    public static final class a implements Function1<Boolean, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            if (this.a.isActive() == false) goto L6;
            Boolean r4 = Boolean.valueOf(r3);
            this.a.resumeWith(Result.constructor-impl(r4));
        L6:
            return Unit.INSTANCE;
        }
    }

    public SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1(SuspendReceiveMessage r1, Continuation<? super SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        SuspendReceiveMessage r2 = (SuspendReceiveMessage) this.L$0;
        ResultKt.throwOnFailure(r5);
    L13:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        SuspendReceiveMessage r6 = this.this$0;
        this.L$0 = r6;
        this.label = 1;
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r3.C();
        r6.a = new a(r3);
        r5 = r3.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r5 != r0) goto L13;
        return r0;
    }
}
