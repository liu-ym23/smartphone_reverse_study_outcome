package com.bytedance.applet.event;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener$onUndefinedAction$1", f = "BaseAppActionListener.kt", i = {0}, l = {205}, m = "invokeSuspend", n = {"uploadDeferred"}, s = {"L$0"})
final class BaseAppActionListener$onUndefinedAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Function1<String, Boolean> $responseCallback;
    final /* synthetic */ long $timeoutMs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseAppActionListener$onUndefinedAction$1(long r1, String r3, Function1<? super String, Boolean> r4, Continuation<? super BaseAppActionListener$onUndefinedAction$1> r5) {
        this.$timeoutMs = r1;
        this.$key = r3;
        this.$responseCallback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        BaseAppActionListener$onUndefinedAction$1 r6 = new BaseAppActionListener$onUndefinedAction$1(this.$timeoutMs, this.$key, this.$responseCallback, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Deferred r3 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r5 = r18;
    L12:
        Result r6 = (Result) r5;
        if (r6 != null) goto L16;
        FLogger.a.e("BaseAppActionListener", "upload snapshot timeout, key=" + this.$key + ", timeoutMs=" + this.$timeoutMs);
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        Function1<String, Boolean> r4 = this.$responseCallback;
        e r7 = e.a;
        String r8 = GsonProtectorUtils.toJson(e.c, new e.b(this.$key, false, null, 0, 0, -1, "timeout", 28));
        r7.getClass();
        r4.invoke(e.e(-1, "timeout", r8));
        return Unit.INSTANCE;
    L16:
        Object r9 = r6.unbox-impl();
        Function1<String, Boolean> r10 = this.$responseCallback;
        String r11 = this.$key;
        if (Result.isSuccess-impl(r9) == false) goto L19;
        com.bytedance.ai.applet.services.e r12 = (com.bytedance.ai.applet.services.e) r9;
        FLogger.a.d("BaseAppActionListener", "upload snapshot success " + r12);
        e r13 = e.a;
        String r14 = GsonProtectorUtils.toJson(e.c, new e.b(r11, true, r12.b, r12.c, r12.d, 0, null, 96));
        r13.getClass();
        r10.invoke(e.e(0, "success", r14));
    L19:
        Function1<String, Boolean> r15 = this.$responseCallback;
        String r16 = this.$key;
        Throwable r17 = Result.exceptionOrNull-impl(r9);
        if (r17 == null) goto L26;
        FLogger.a.e("BaseAppActionListener", "upload snapshot failed " + r17);
        String r19 = r17.getMessage();
        if (r19 != null) goto L24;
        r19 = "upload snapshot failed";
    L24:
        e r20 = e.a;
        String r21 = GsonProtectorUtils.toJson(e.c, new e.b(r16, false, null, 0, 0, -1, r19, 28));
        r20.getClass();
        r15.invoke(e.e(-1, r19, r21));
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        Deferred r22 = BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1(this.$key, null), 3, null);
        long r23 = this.$timeoutMs;
        BaseAppActionListener$onUndefinedAction$1$uploadResult$1 r24 = new BaseAppActionListener$onUndefinedAction$1$uploadResult$1(r22, null);
        this.L$0 = r22;
        this.label = 1;
        r5 = TimeoutKt.c(r23, r24, this);
        if (r5 != r1) goto L11;
        return r1;
    L11:
        r3 = r22;
        goto L12
    }
}
