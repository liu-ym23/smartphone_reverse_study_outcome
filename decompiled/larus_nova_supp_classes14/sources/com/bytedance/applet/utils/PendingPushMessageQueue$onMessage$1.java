package com.bytedance.applet.utils;

import com.larus.bmhome.chat.model.repo.a2;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.PendingPushMessageQueue$onMessage$1", f = "PendingPushMessageQueue.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class PendingPushMessageQueue$onMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    Object L$0;
    int label;

    public PendingPushMessageQueue$onMessage$1(Message r1, Continuation<? super PendingPushMessageQueue$onMessage$1> r2) {
        this.$msg = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PendingPushMessageQueue$onMessage$1(this.$msg, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        if (r2.hasNext() == false) goto L24;
        PendingPushMessageQueue.a r3 = (PendingPushMessageQueue.a) r2.next();
        FLogger.a.i("PendingPushMessageQueue", "create message, botId " + r3.a + ", questionId " + r3.c);
        MessageUtils r4 = MessageUtils.a;
        String r5 = r3.a;
        String r6 = r3.b;
        String r7 = r3.c;
        List<a2> r8 = r3.d;
        List<String> r9 = r3.e;
        List<String> r11 = r3.f;
        this.L$0 = r2;
        this.label = 1;
        if (r4.b(r5, r6, r7, r8, r9, false, r11, this) != r0) goto L19;
        return r0;
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        if (o0.d(this.$msg.getReplyId()) == false) goto L24;
        Map<String, List<PendingPushMessageQueue.a>> r14 = PendingPushMessageQueue.a;
        if (((ConcurrentHashMap) r14).containsKey(this.$msg.getReplyId()) == false) goto L24;
        if (com.larus.bmhome.chat.bean.d.j0(this.$msg) == false) goto L24;
        List r15 = (List) TypeIntrinsics.asMutableMap(r14).remove(this.$msg.getReplyId());
        if (r15 == null) goto L24;
        r2 = r15.iterator();
        goto L19
    }
}
