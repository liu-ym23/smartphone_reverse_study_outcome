package com.bytedance.applet.utils;

import com.larus.bmhome.chat.model.repo.u1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.MessageUtils$sendTextMessage$1", f = "MessageUtils.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class MessageUtils$sendTextMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botID;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ String $msg;
    int label;

    public MessageUtils$sendTextMessage$1(String r1, String r2, String r3, Map<String, String> r4, Function0<Unit> r5, Continuation<? super MessageUtils$sendTextMessage$1> r6) {
        this.$cvsId = r1;
        this.$botID = r2;
        this.$msg = r3;
        this.$ext = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageUtils$sendTextMessage$1(this.$cvsId, this.$botID, this.$msg, this.$ext, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r3 = r19;
    L15:
        String r4 = (String) r3;
    L16:
        u1.a.f(zh8.a.a.u1(), this.$msg, r4, "", this.$ext, null, null, null, false, null, "utils#sendTextMessage", null, null, null, false, 27616);
        Unit r5 = Unit.INSTANCE;
        String r6 = this.$botID;
        Function0<Unit> r7 = this.$callback;
        FLogger.a.d("MessageUtils", "SendMsg to " + r6);
        if (r7 == null) goto L20;
        r7.invoke();
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        if (o0.d(this.$cvsId) == false) goto L12;
        r4 = this.$cvsId;
        goto L16
    L12:
        MessageUtils r8 = MessageUtils.a;
        String r9 = this.$botID;
        this.label = 1;
        r3 = r8.d(r9, this);
        if (r3 != r1) goto L15;
        return r1;
    }
}
