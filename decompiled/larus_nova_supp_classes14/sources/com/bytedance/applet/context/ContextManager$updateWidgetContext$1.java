package com.bytedance.applet.context;

import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.applet.utils.MessageUtils;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.context.ContextManager$updateWidgetContext$1", f = "ContextManager.kt", i = {}, l = {100, 113}, m = "invokeSuspend", n = {}, s = {})
public final class ContextManager$updateWidgetContext$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $context;
    final /* synthetic */ String $msgId;
    int label;

    public ContextManager$updateWidgetContext$1(String r1, String r2, Continuation<? super ContextManager$updateWidgetContext$1> r3) {
        this.$msgId = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContextManager$updateWidgetContext$1(this.$msgId, this.$context, r4);
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
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L50:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        String r9 = (String) r8;
        if (r9 == null) goto L50;
        String r2 = this.$msgId;
        String r4 = this.$context;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L18
        Object r10 = Result.constructor-impl((WidgetInfo) ContextManager.b.fromJson(r9, WidgetInfo.class));     // Catch: Throwable -> L18
    L20:
        String r6 = null;
        if (Result.isFailure-impl(r10) == false) goto L23;
        r10 = null;
    L23:
        WidgetInfo r11 = (WidgetInfo) r10;
        if (r11 == null) goto L26;
        String r7 = r11.getAppletId();
    L27:
        if (r7 != null) goto L29;
    L32:
        if (r3 == false) goto L35;
        FLogger.a.w("ContextManager", r2 + " is not a widget message");
        return Unit.INSTANCE;
    L35:
        if (r11 == null) goto L38;
        r6 = r11.getResponseForModel();
    L38:
        if (Intrinsics.areEqual(r6, r4) == true) goto L50;
        if (r11 == null) goto L41;
        r11.setResponseForModel(r4);
    L41:
        MessageUtils r12 = MessageUtils.a;
        String r13 = GsonProtectorUtils.toJson(ContextManager.b, r11);
        if (r11 == null) goto L45;
        String r14 = r11.getResponseForModel();
        if (r14 == null) goto L45;
    L46:
        this.label = 2;
        if (r12.o(r2, r13, r14, this) != r0) goto L50;
        return r0;
    L45:
        r14 = "";
        goto L46
    L29:
        if (r7.length() == 0) goto L32;
        r3 = false;
        goto L32
    L26:
        r7 = null;
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L10:
        ResultKt.throwOnFailure(r8);
        MessageUtils r16 = MessageUtils.a;
        String r17 = this.$msgId;
        this.label = 1;
        r8 = r16.h(r17, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
