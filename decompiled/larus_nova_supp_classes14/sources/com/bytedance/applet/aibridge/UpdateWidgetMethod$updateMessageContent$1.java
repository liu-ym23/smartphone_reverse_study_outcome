package com.bytedance.applet.aibridge;

import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.bytedance.applet.aibridge.UpdateWidgetMethod$updateMessageContent$1", f = "UpdateWidgetMethod.kt", i = {}, l = {117, 134}, m = "invokeSuspend", n = {}, s = {})
final class UpdateWidgetMethod$updateMessageContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsUpdateWidgetMethodIDL.b> $callback;
    final /* synthetic */ AbsUpdateWidgetMethodIDL.a $params;
    int label;

    public UpdateWidgetMethod$updateMessageContent$1(AbsUpdateWidgetMethodIDL.a r1, f3.h<AbsUpdateWidgetMethodIDL.b> r2, Continuation<? super UpdateWidgetMethod$updateMessageContent$1> r3) {
        this.$params = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UpdateWidgetMethod$updateMessageContent$1(this.$params, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r6 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L40:
        if (((Boolean) r9).booleanValue() == true) goto L42;
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        int r2 = UpdateWidgetMethod.b;
        r10.e("UpdateWidgetMethod", "updateMessage fail!!!");
        f3.h.a.a(this.$callback, "updateMessage error", null, null, 14);
    L44:
        return Unit.INSTANCE;
    L42:
        f3.h<AbsUpdateWidgetMethodIDL.b> r11 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsUpdateWidgetMethodIDL.b.class, "<this>");
        f3.h.a.b(r11, k3.c.a(AbsUpdateWidgetMethodIDL.b.class));
        goto L44
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        String r12 = (String) r9;
        if (r12 != null) goto L16;
    L19:
        if (r6 == false) goto L45;
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        int r3 = UpdateWidgetMethod.b;
        r13.e("UpdateWidgetMethod", "message not found messageId=" + this.$params.getMsgId());
        f3.h.a.a(this.$callback, "message not found", null, null, 14);
        return Unit.INSTANCE;
    L45:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L24
        Object r14 = Result.constructor-impl((WidgetInfo) sy5.b.b.a.fromJson(r12, WidgetInfo.class));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r14) == false) goto L29;
        r14 = null;
    L29:
        WidgetInfo r15 = (WidgetInfo) r14;
        if (r15 != null) goto L33;
        com.bytedance.ai.utils.g r16 = com.bytedance.ai.utils.g.a;
        int r5 = UpdateWidgetMethod.b;
        r16.e("UpdateWidgetMethod", "message content error messageId=" + this.$params.getMsgId());
        f3.h.a.a(this.$callback, "message content error", null, null, 14);
        return Unit.INSTANCE;
    L33:
        r15.setWidgetData(this.$params.getWidgetData());
        r15.setArchiveText(this.$params.getArchiveText());
        String r7 = GsonProtectorUtils.toJson(sy5.b.b.a, r15, WidgetInfo.class);
        MessageUtils r8 = MessageUtils.a;
        String r17 = this.$params.getMsgId();
        Intrinsics.checkNotNull(r7);
        String r18 = r15.getResponseForModel();
        if (r18 != null) goto L36;
        r18 = "";
    L36:
        this.label = 2;
        r9 = r8.o(r17, r7, r18, this);
        if (r9 != r0) goto L40;
        return r0;
    L24:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L16:
        if (r12.length() == 0) goto L19;
        r6 = false;
        goto L19
    L10:
        ResultKt.throwOnFailure(r9);
        MessageUtils r20 = MessageUtils.a;
        String r21 = this.$params.getMsgId();
        this.label = 1;
        r9 = r20.h(r21, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
