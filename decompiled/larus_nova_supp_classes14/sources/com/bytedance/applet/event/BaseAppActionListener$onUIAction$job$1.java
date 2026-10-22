package com.bytedance.applet.event;

import androidx.collection.LruCache;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener$onUIAction$job$1", f = "BaseAppActionListener.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, s = {})
final class BaseAppActionListener$onUIAction$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiName;
    final /* synthetic */ String $appId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $questionId;
    final /* synthetic */ Function1<String, Boolean> $responseCallback;
    final /* synthetic */ Integer $timeoutMs;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    public static final class a implements k5.j {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public final void a(AppletMonitorableEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            r3.f("message_id", this.a);
            r3.f("questionId", this.b);
            r3.f("botId", this.c);
            r3.f("conversationId", this.d);
            r3.f("applet_id", this.e);
        }

        public a(String r1, String r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseAppActionListener$onUIAction$job$1(Integer r1, String r2, String r3, Function1<? super String, Boolean> r4, String r5, String r6, String r7, String r8, Continuation<? super BaseAppActionListener$onUIAction$job$1> r9) {
        this.$timeoutMs = r1;
        this.$questionId = r2;
        this.$apiName = r3;
        this.$responseCallback = r4;
        this.$msgId = r5;
        this.$botId = r6;
        this.$conversationId = r7;
        this.$appId = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new BaseAppActionListener$onUIAction$job$1(this.$timeoutMs, this.$questionId, this.$apiName, this.$responseCallback, this.$msgId, this.$botId, this.$conversationId, this.$appId, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L9;
        String r1 = (String) this.L$6;
        String r4 = (String) this.L$5;
        String r5 = (String) this.L$4;
        String r6 = (String) this.L$3;
        Function1<String, Boolean> r7 = (Function1) this.L$2;
        String r8 = (String) this.L$1;
        String r9 = (String) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L31
        String r18 = r1;
        String r17 = r4;
        String r16 = r5;
        String r14 = r6;
        String r15 = r9;
    L19:
        LruCache r2 = com.bytedance.ai.utils.j.a;     // Catch: Throwable -> L31
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L27
        com.bytedance.ai.utils.j.a r11 = com.bytedance.ai.utils.j.b(Boxing.boxLong(CastLongProtector.parseLong(r14)));     // Catch: Throwable -> L27
        if (r11 == null) goto L24;
        r11.i = new com.bytedance.ai.utils.j.b.e();     // Catch: Throwable -> L27
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Result.constructor-impl(r12);     // Catch: Throwable -> L27
    L29:
        FLogger.a.i("BaseAppActionListener", "ui action questionId " + r15 + " apiName " + r8 + " timeout!!");     // Catch: Throwable -> L31
        e.a.getClass();     // Catch: Throwable -> L31
        r7.invoke(e.e(-1, "timeout", null));     // Catch: Throwable -> L31
        com.bytedance.ai.monitor.b.d("applet_local_plugin_timeout", new a(r14, r15, r16, r17, r18));     // Catch: Throwable -> L31
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r19 = Result.exceptionOrNull-impl(r13);
        if (r19 == null) goto L37;
        FLogger.a.i("BaseAppActionListener", "timeout job cancelled " + r19);
    L37:
        return Unit.INSTANCE;
    L24:
        r12 = null;
    L27:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L31
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
        goto L29
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r20);
        Integer r22 = this.$timeoutMs;
        String r23 = this.$questionId;
        r8 = this.$apiName;
        r7 = this.$responseCallback;
        String r24 = this.$msgId;
        String r110 = this.$botId;
        String r111 = this.$conversationId;
        String r112 = this.$appId;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L31
        if (r22 == null) goto L14;
        long r114 = r22.intValue();     // Catch: Throwable -> L31
    L15:
        this.L$0 = r23;     // Catch: Throwable -> L31
        this.L$1 = r8;     // Catch: Throwable -> L31
        this.L$2 = r7;     // Catch: Throwable -> L31
        this.L$3 = r24;     // Catch: Throwable -> L31
        this.L$4 = r110;     // Catch: Throwable -> L31
        this.L$5 = r111;     // Catch: Throwable -> L31
        this.L$6 = r112;     // Catch: Throwable -> L31
        this.label = 1;     // Catch: Throwable -> L31
        if (DelayKt.delay(r114, this) != r0) goto L18;
        return r0;
    L18:
        r14 = r24;
        r15 = r23;
        r16 = r110;
        r17 = r111;
        r18 = r112;
        goto L19
    L14:
        r114 = 5000;
    L31:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }
}
