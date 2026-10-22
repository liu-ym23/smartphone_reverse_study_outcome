package com.bytedance.applet.impl;

import com.bytedance.applet.utils.MessageUtils;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletBridgeFlavorDelegate$sendOutput$1", f = "AppletBridgeFlavorDelegate.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class AppletBridgeFlavorDelegate$sendOutput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ k2.i $aiContainer;
    final /* synthetic */ String $message;
    int label;

    public AppletBridgeFlavorDelegate$sendOutput$1(k2.i r1, String r2, Continuation<? super AppletBridgeFlavorDelegate$sendOutput$1> r3) {
        this.$aiContainer = r1;
        this.$message = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletBridgeFlavorDelegate$sendOutput$1(this.$aiContainer, this.$message, r4);
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
        Object r2 = null;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L21:
        wc9.e r6 = (wc9.e) r5;     // Catch: Throwable -> L7
        if (r6 == null) goto L24;
        String r3 = r6.a;     // Catch: Throwable -> L7
    L25:
        Object r7 = Result.constructor-impl(r3);     // Catch: Throwable -> L7
    L29:
        if (Result.isFailure-impl(r7) == true) goto L32;
        r2 = r7;
    L32:
        String r4 = (String) r2;
        if (r4 == null) goto L36;
        MessageUtils r8 = MessageUtils.a;
        String r9 = this.$message;
        r8.getClass();
        MessageUtils.a(r4, r9);
    L36:
        return Unit.INSTANCE;
    L24:
        r3 = null;
        goto L25
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        k2.i r10 = this.$aiContainer;
        if (r10 == null) goto L15;
        String r11 = r10.getBotId();
        if (r11 == null) goto L15;
    L16:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L7
        r3 = x4.a.a(r11);     // Catch: Throwable -> L7
        if (r3 != null) goto L25;
        IConversationRepoService r13 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r5 = r13.a(r11, this);     // Catch: Throwable -> L7
        if (r5 != r0) goto L21;
        return r0;
    L15:
        r11 = "";
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
