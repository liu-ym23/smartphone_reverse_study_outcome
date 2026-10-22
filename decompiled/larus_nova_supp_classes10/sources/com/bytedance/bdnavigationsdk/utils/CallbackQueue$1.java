package com.bytedance.bdnavigationsdk.utils;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.bdnavigationsdk.utils.CallbackQueue$1", f = "CallbackQueue.kt", i = {}, l = {h1.LINKER_LOCK_POSITION}, m = "invokeSuspend", n = {}, s = {})
final class CallbackQueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public CallbackQueue$1(a r1, Continuation<? super CallbackQueue$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CallbackQueue$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:13:0x003b). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r7);
        ChannelIterator r3 = r2;
        Object r4 = r0;
        CallbackQueue$1 r5 = this;
    L14:
        if (((Boolean) r7).booleanValue() == false) goto L22;
        ((Function0) r3.next()).invoke();     // Catch: Throwable -> L18
    L20:
        CallbackQueue$1 r8 = r5;
        r0 = r4;
        ChannelIterator r6 = r3;
    L9:
        r8.L$0 = r6;
        r8.label = 1;
        Object r9 = r6.hasNext(r8);
        if (r9 != r0) goto L12;
        return r0;
    L12:
        Object r10 = r0;
        r5 = r8;
        r7 = r9;
        r3 = r6;
        r4 = r10;
    L18:
        th = move-exception;
        com.bytedance.bdnavigationsdk.e r11 = r84.a.a;
        r84.a.b("Unhandled exception in navigation callback", th, 1);
        goto L20
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r6 = this.this$0.b.iterator();
        r8 = this;
        goto L9
    }
}
