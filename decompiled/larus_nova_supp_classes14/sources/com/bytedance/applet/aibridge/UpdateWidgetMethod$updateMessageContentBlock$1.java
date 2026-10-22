package com.bytedance.applet.aibridge;

import com.bytedance.applet.utils.MessageUtils;
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
@DebugMetadata(c = "com.bytedance.applet.aibridge.UpdateWidgetMethod$updateMessageContentBlock$1", f = "UpdateWidgetMethod.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
final class UpdateWidgetMethod$updateMessageContentBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsUpdateWidgetMethodIDL.b> $callback;
    final /* synthetic */ AbsUpdateWidgetMethodIDL.a $params;
    int label;

    public UpdateWidgetMethod$updateMessageContentBlock$1(AbsUpdateWidgetMethodIDL.a r1, f3.h<AbsUpdateWidgetMethodIDL.b> r2, Continuation<? super UpdateWidgetMethod$updateMessageContentBlock$1> r3) {
        this.$params = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UpdateWidgetMethod$updateMessageContentBlock$1(this.$params, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) r5).booleanValue() == true) goto L14;
        com.bytedance.ai.utils.g r6 = com.bytedance.ai.utils.g.a;
        int r2 = UpdateWidgetMethod.b;
        r6.e("UpdateWidgetMethod", "updateMessageContentBlock fail!!!");
        f3.h.a.a(this.$callback, "updateMessageContentBlock error", null, null, 14);
    L16:
        return Unit.INSTANCE;
    L14:
        f3.h<AbsUpdateWidgetMethodIDL.b> r7 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsUpdateWidgetMethodIDL.b.class, "<this>");
        f3.h.a.b(r7, k3.c.a(AbsUpdateWidgetMethodIDL.b.class));
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MessageUtils r8 = MessageUtils.a;
        String r3 = this.$params.getMsgId();
        String r4 = this.$params.getWidgetData();
        this.label = 1;
        r5 = r8.n(r3, r4, true, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
