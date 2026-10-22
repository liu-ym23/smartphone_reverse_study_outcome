package com.bytedance.applet.jsb;

import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
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
@DebugMetadata(c = "com.bytedance.applet.jsb.AppletUpdateWidgetDataMethod$updateMessageContent$1", f = "AppletUpdateWidgetDataMethod.kt", i = {}, l = {47, 69}, m = "invokeSuspend", n = {}, s = {})
final class AppletUpdateWidgetDataMethod$updateMessageContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ String $messageId;
    final /* synthetic */ cx7.d $params;
    int label;
    final /* synthetic */ b1 this$0;

    public AppletUpdateWidgetDataMethod$updateMessageContent$1(String r1, b1 r2, IvyBridgeMethod.a r3, cx7.d r4, Continuation<? super AppletUpdateWidgetDataMethod$updateMessageContent$1> r5) {
        this.$messageId = r1;
        this.this$0 = r2;
        this.$callback = r3;
        this.$params = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AppletUpdateWidgetDataMethod$updateMessageContent$1(this.$messageId, this.this$0, this.$callback, this.$params, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L48:
        if (((Boolean) r9).booleanValue() == true) goto L50;
        FLogger.a.e("AppletUpdateWidgetDataMethod", "updateMessage fail!!!");
        b1 r10 = this.this$0;
        IvyBridgeMethod.a r2 = this.$callback;
        int r3 = b1.b;
        r10.getClass();
        b1.f(r2, 0, "updateMessage error", false);
    L52:
        return Unit.INSTANCE;
    L50:
        b1 r11 = this.this$0;
        IvyBridgeMethod.a r4 = this.$callback;
        int r5 = b1.b;
        r11.getClass();
        b1.f(r4, 1, "update success", true);
        goto L52
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        String r12 = (String) r9;
        if (r12 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L23;
        FLogger.a.e("AppletUpdateWidgetDataMethod", "message not found messageId=" + this.$messageId);
        b1 r13 = this.this$0;
        IvyBridgeMethod.a r7 = this.$callback;
        int r8 = b1.b;
        r13.getClass();
        b1.f(r7, -9, "message not found", false);
        return Unit.INSTANCE;
    L23:
        Gson r14 = new Gson();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L26
        Object r16 = Result.constructor-impl((WidgetInfo) r14.fromJson(r12, WidgetInfo.class));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r16) == false) goto L31;
        r16 = null;
    L31:
        WidgetInfo r17 = (WidgetInfo) r16;
        if (r17 != null) goto L36;
        FLogger.a.e("AppletUpdateWidgetDataMethod", "message content error messageId=" + this.$messageId);
        b1 r18 = this.this$0;
        IvyBridgeMethod.a r19 = this.$callback;
        int r20 = b1.b;
        r18.getClass();
        b1.f(r19, 0, "message content error", false);
        return Unit.INSTANCE;
    L36:
        if (this.$params.hasKey("data") == false) goto L39;
        r17.setWidgetData(this.$params.getString("data"));
    L39:
        if (this.$params.hasKey("archiveText") == false) goto L41;
        r17.setArchiveText(this.$params.getString("archiveText"));
    L41:
        String r21 = GsonProtectorUtils.toJson(r14, r17, WidgetInfo.class);
        MessageUtils r22 = MessageUtils.a;
        String r23 = this.$messageId;
        Intrinsics.checkNotNull(r21);
        String r24 = r17.getResponseForModel();
        if (r24 != null) goto L44;
        r24 = "";
    L44:
        this.label = 2;
        r9 = r22.o(r23, r21, r24, this);
        if (r9 != r0) goto L48;
        return r0;
    L26:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L16:
        if (r12.length() == 0) goto L19;
        r6 = false;
        goto L20
    L10:
        ResultKt.throwOnFailure(r9);
        MessageUtils r26 = MessageUtils.a;
        String r27 = this.$messageId;
        this.label = 1;
        r9 = r26.h(r27, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
