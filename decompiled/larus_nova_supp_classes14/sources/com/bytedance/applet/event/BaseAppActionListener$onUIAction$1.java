package com.bytedance.applet.event;

import java.util.Map;
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
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener$onUIAction$1", f = "BaseAppActionListener.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
final class BaseAppActionListener$onUIAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiName;
    final /* synthetic */ String $appId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Long $createTime;
    final /* synthetic */ Map<String, String> $featureMap;
    final /* synthetic */ Job $job;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $param;
    final /* synthetic */ String $questionId;
    final /* synthetic */ Function1<String, Boolean> $responseCallback;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseAppActionListener$onUIAction$1(String r1, String r2, String r3, String r4, String r5, Map<String, String> r6, String r7, String r8, Long r9, Job r10, Function1<? super String, Boolean> r11, Continuation<? super BaseAppActionListener$onUIAction$1> r12) {
        this.$botId = r1;
        this.$conversationId = r2;
        this.$appId = r3;
        this.$apiName = r4;
        this.$param = r5;
        this.$featureMap = r6;
        this.$msgId = r7;
        this.$questionId = r8;
        this.$createTime = r9;
        this.$job = r10;
        this.$responseCallback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new BaseAppActionListener$onUIAction$1(this.$botId, this.$conversationId, this.$appId, this.$apiName, this.$param, this.$featureMap, this.$msgId, this.$questionId, this.$createTime, this.$job, this.$responseCallback, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.applet.event.g] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        e r2 = e.a;
        String r16 = this.$botId;
        String r3 = this.$conversationId;
        String r4 = this.$appId;
        final String r5 = this.$apiName;
        String r6 = this.$param;
        Map<String, String> r7 = this.$featureMap;
        String r8 = this.$msgId;
        final String r9 = this.$questionId;
        Long r10 = this.$createTime;
        final Job r11 = this.$job;
        final Function1<String, Boolean> r12 = this.$responseCallback;
        ?? r13 = new g(r11, r9, r5, r12);
        this.label = 1;
        if (e.d(r2, r16, r3, r4, r5, r6, r7, r8, r9, r10, r13, this) != r0) goto L12;
        return r0;
    }
}
