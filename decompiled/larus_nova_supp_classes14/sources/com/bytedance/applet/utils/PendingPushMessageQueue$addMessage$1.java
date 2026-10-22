package com.bytedance.applet.utils;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.applet.event.u;
import com.larus.bmhome.chat.model.repo.a2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.PendingPushMessageQueue$addMessage$1", f = "PendingPushMessageQueue.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class PendingPushMessageQueue$addMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ List<a2> $messageContents;
    final /* synthetic */ String $questionId;
    final /* synthetic */ List<String> $suggests;
    final /* synthetic */ List<String> $suggestsV2;
    int label;

    public static final class a implements k5.j {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public final void a(AppletMonitorableEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            String r0 = this.a;
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r3.f("questionId", r0);
            r3.f("botId", this.b);
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public PendingPushMessageQueue$addMessage$1(String r1, String r2, String r3, List<a2> r4, List<String> r5, List<String> r6, Continuation<? super PendingPushMessageQueue$addMessage$1> r7) {
        this.$botId = r1;
        this.$conversationId = r2;
        this.$questionId = r3;
        this.$messageContents = r4;
        this.$suggests = r5;
        this.$suggestsV2 = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new PendingPushMessageQueue$addMessage$1(this.$botId, this.$conversationId, this.$questionId, this.$messageContents, this.$suggests, this.$suggestsV2, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        Map<String, List<PendingPushMessageQueue.a>> r15 = PendingPushMessageQueue.a;
        String r16 = this.$botId;
        String r2 = this.$conversationId;
        if (r2.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        u r17 = u.a;
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        boolean r18 = ((ConcurrentHashMap) u.c).containsKey(r2);
    L16:
        if (r18 == true) goto L21;
        ConcurrentHashMap r19 = (ConcurrentHashMap) PendingPushMessageQueue.a;
        List r4 = (List) r19.get(this.$questionId);
        if (r4 != null) goto L20;
        r4 = new ArrayList();
        r19.put(this.$questionId, r4);
    L20:
        r4.add(new PendingPushMessageQueue.a(this.$botId, this.$conversationId, this.$questionId, this.$messageContents, this.$suggests, this.$suggestsV2));
        FLogger.a.i("PendingPushMessageQueue", "add to pending queue, botId " + this.$botId + ", questionId " + this.$questionId);
        AtomicBoolean r110 = com.bytedance.ai.monitor.b.a;
        com.bytedance.ai.monitor.b.d("applet_pending_bot_reply", new a(this.$questionId, this.$botId));
        Unit r111 = Unit.INSTANCE;
        goto L25
    L21:
        FLogger.a.w("PendingPushMessageQueue", "realtime call case, create message directly");
        MessageUtils r5 = MessageUtils.a;
        String r6 = this.$botId;
        String r7 = this.$conversationId;
        String r8 = this.$questionId;
        List<a2> r9 = this.$messageContents;
        List<String> r10 = this.$suggests;
        List<String> r11 = this.$suggestsV2;
        this.label = 1;
        if (r5.b(r6, r7, r8, r9, r10, false, r11, this) != r0) goto L25;
        return r0;
    L14:
        u r12 = u.a;
        Intrinsics.checkNotNullParameter(r16, "botId");
        r18 = ((ConcurrentHashMap) u.b).containsKey(r16);
        goto L16
    L11:
        r3 = false;
        goto L12
    }
}
