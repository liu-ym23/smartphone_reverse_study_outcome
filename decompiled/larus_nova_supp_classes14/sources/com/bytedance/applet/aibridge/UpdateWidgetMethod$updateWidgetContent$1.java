package com.bytedance.applet.aibridge;

import com.bytedance.applet.utils.WidgetContentManager;
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
@DebugMetadata(c = "com.bytedance.applet.aibridge.UpdateWidgetMethod$updateWidgetContent$1", f = "UpdateWidgetMethod.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
final class UpdateWidgetMethod$updateWidgetContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f3.h<AbsUpdateWidgetMethodIDL.b> $callback;
    final /* synthetic */ String $cardId;
    final /* synthetic */ AbsUpdateWidgetMethodIDL.a $params;
    int label;

    public UpdateWidgetMethod$updateWidgetContent$1(AbsUpdateWidgetMethodIDL.a r1, String r2, f3.h<AbsUpdateWidgetMethodIDL.b> r3, Continuation<? super UpdateWidgetMethod$updateWidgetContent$1> r4) {
        this.$params = r1;
        this.$cardId = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UpdateWidgetMethod$updateWidgetContent$1(this.$params, this.$cardId, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        if (((Boolean) r8).booleanValue() == true) goto L14;
        com.bytedance.ai.utils.g r9 = com.bytedance.ai.utils.g.a;
        int r2 = UpdateWidgetMethod.b;
        r9.e("UpdateWidgetMethod", "updateWidgetContent fail!!!");
        f3.h.a.a(this.$callback, "updateWidgetContent error", null, null, 14);
    L16:
        return Unit.INSTANCE;
    L14:
        f3.h<AbsUpdateWidgetMethodIDL.b> r10 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsUpdateWidgetMethodIDL.b.class, "<this>");
        f3.h.a.b(r10, k3.c.a(AbsUpdateWidgetMethodIDL.b.class));
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        WidgetContentManager r3 = WidgetContentManager.a;
        String r11 = this.$params.getMsgId();
        String r4 = this.$cardId;
        String r5 = this.$params.getWidgetData();
        this.label = 1;
        r8 = r3.c(r11, r4, "", r5, this);
        if (r8 != r0) goto L12;
        return r0;
    }
}
