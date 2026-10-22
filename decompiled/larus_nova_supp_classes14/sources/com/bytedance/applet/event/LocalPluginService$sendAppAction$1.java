package com.bytedance.applet.event;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.LocalPluginService$sendAppAction$1", f = "LocalPluginService.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
final class LocalPluginService$sendAppAction$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AppAction $appAction;
    final /* synthetic */ Object $localPluginContext;
    final /* synthetic */ Long $messageId;
    final /* synthetic */ jw3.e $transport;
    int label;

    public LocalPluginService$sendAppAction$1(AppAction r1, Object r2, jw3.e r3, Long r4, Continuation<? super LocalPluginService$sendAppAction$1> r5) {
        this.$appAction = r1;
        this.$localPluginContext = r2;
        this.$transport = r3;
        this.$messageId = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new LocalPluginService$sendAppAction$1(this.$appAction, this.$localPluginContext, this.$transport, this.$messageId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L20 Exception -> L22
    L13:
        jw3.e r10 = this.$transport;
        if (r10 == null) goto L16;
        r10.f(this.$localPluginContext);
    L16:
        jw3.e r11 = this.$transport;
        if (r11 == null) goto L19;
        r11.a(this.$messageId);
    L19:
        FLogger.a.i("LocalPluginService", "Send ack finished for messageId: " + this.$messageId);
    L31:
        LocalPluginService.o.set(false);
        LocalPluginService.a();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        byte[] r12 = LocalPluginService.b.toJson(this.$appAction).getBytes(Charsets.UTF_8);     // Catch: Throwable -> L20 Exception -> L22
        LocalPluginService r3 = LocalPluginService.a;     // Catch: Throwable -> L20 Exception -> L22
        Object r7 = this.$localPluginContext;     // Catch: Throwable -> L20 Exception -> L22
        this.label = 1;     // Catch: Throwable -> L20 Exception -> L22
        if (LocalPluginService.b(r3, r12, 2, r7, this) != r1) goto L13;
        return r1;
    L20:
        th = move-exception;
        jw3.e r0 = this.$transport;
        if (r0 == null) goto L36;
        r0.f(this.$localPluginContext);
    L36:
        jw3.e r4 = this.$transport;
        if (r4 == null) goto L39;
        r4.a(this.$messageId);
    L39:
        FLogger.a.i("LocalPluginService", "Send ack finished for messageId: " + this.$messageId);
        LocalPluginService.o.set(false);
        LocalPluginService.a();
        throw th;
    L22:
        e = move-exception;
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L20
        r5.e("LocalPluginService", "Failed to send app action: " + e.getMessage());     // Catch: Throwable -> L20
        jw3.e r13 = this.$transport;
        if (r13 == null) goto L27;
        r13.f(this.$localPluginContext);
    L27:
        jw3.e r14 = this.$transport;
        if (r14 == null) goto L30;
        r14.a(this.$messageId);
    L30:
        r5.i("LocalPluginService", "Send ack finished for messageId: " + this.$messageId);
        goto L31
    }
}
