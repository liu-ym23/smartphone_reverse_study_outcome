package com.bytedance.applet.event;

import com.larus.platform.api.p2;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.LocalPluginService$sendPayload$2", f = "LocalPluginService.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
public final class LocalPluginService$sendPayload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ byte[] $payload;
    Object L$0;
    int label;

    public static final class a implements Function1<Boolean, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Boolean r3 = Boolean.valueOf(((Boolean) r2).booleanValue());
            this.a.resumeWith(Result.constructor-impl(r3));
            return Unit.INSTANCE;
        }
    }

    public LocalPluginService$sendPayload$2(byte[] r1, Continuation<? super LocalPluginService$sendPayload$2> r2) {
        this.$payload = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocalPluginService$sendPayload$2(this.$payload, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        byte[] r2 = (byte[]) this.L$0;
        ResultKt.throwOnFailure(r6);
    L16:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        byte[] r7 = this.$payload;
        this.L$0 = r7;
        this.label = 1;
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r3.C();
        a r4 = new a(r3);
        p2 r5 = LocalPluginService.d;
        if (r5 == null) goto L11;
        r5.f(r7, null, r4);
    L11:
        r6 = r3.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(this);
    L14:
        if (r6 != r0) goto L16;
        return r0;
    }
}
