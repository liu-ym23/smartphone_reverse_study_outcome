package com.bytedance.applet.context;

import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.applet.utils.MessageUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.context.ContextManager", f = "ContextManager.kt", i = {}, l = {88}, m = "getWidgetContext", n = {}, s = {})
final class ContextManager$getWidgetContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContextManager this$0;

    public ContextManager$getWidgetContext$1(ContextManager r1, Continuation<? super ContextManager$getWidgetContext$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        ContextManager r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ContextManager$getWidgetContext$1 r0 = this;
    L6:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        ResultKt.throwOnFailure(r8);
    L15:
        String r9 = (String) r8;
        if (r9 == null) goto L27;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        Object r10 = Result.constructor-impl(((WidgetInfo) ContextManager.b.fromJson(r9, WidgetInfo.class)).getResponseForModel());     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r10) == true) goto L25;
        r4 = r10;
    L25:
        r4 = (String) r4;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        return r4;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        MessageUtils r12 = MessageUtils.a;
        r0.label = 1;
        r8 = r12.h(null, r0);
        if (r8 != r2) goto L15;
        return r2;
    L5:
        r0 = new ContextManager$getWidgetContext$1(r7, this);
        goto L6
    }
}
