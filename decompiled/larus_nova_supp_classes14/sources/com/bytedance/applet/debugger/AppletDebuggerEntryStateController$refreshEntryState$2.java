package com.bytedance.applet.debugger;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerEntryStateController$refreshEntryState$2", f = "AppletDebuggerEntryStateController.kt", i = {0, 0, 1, 2, 2, 3, 3}, l = {144, 88, 154, 154}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv", "deferred", "deferred", "$this$withLock_u24default$iv", "deferred", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$2"})
public final class AppletDebuggerEntryStateController$refreshEntryState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AppletDebuggerEntryStateController this$0;

    public AppletDebuggerEntryStateController$refreshEntryState$2(AppletDebuggerEntryStateController r1, String r2, Continuation<? super AppletDebuggerEntryStateController$refreshEntryState$2> r3) {
        this.this$0 = r1;
        this.$userId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AppletDebuggerEntryStateController$refreshEntryState$2 r0 = new AppletDebuggerEntryStateController$refreshEntryState$2(this.this$0, this.$userId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L18;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        AppletDebuggerEntryStateController r1 = (AppletDebuggerEntryStateController) this.L$3;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$2;
        Throwable r4 = (Throwable) this.L$1;
        Deferred r5 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r17);
    L87:
        AppletDebuggerEntryStateController.a r6 = r1.e;     // Catch: Throwable -> L75
        if (r6 == null) goto L70;
        Deferred r7 = r6.b;     // Catch: Throwable -> L75
    L71:
        if (r7 != r5) goto L73;
        r1.e = null;     // Catch: Throwable -> L75
    L73:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L75
        r3.unlock(null);
        throw r4;
    L70:
        r7 = null;
    L75:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        AppletDebuggerEntryStateController r9 = (AppletDebuggerEntryStateController) this.L$2;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) this.L$1;
        Deferred r11 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r17);
    L89:
        AppletDebuggerEntryStateController.a r12 = r9.e;     // Catch: Throwable -> L54
        if (r12 == null) goto L49;
        Deferred r13 = r12.b;     // Catch: Throwable -> L54
    L50:
        if (r13 != r11) goto L52;
        r9.e = null;     // Catch: Throwable -> L54
    L52:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L54
        r10.unlock(null);
    L58:
        return Unit.INSTANCE;
    L49:
        r13 = null;
    L54:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L12:
        Deferred r15 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
        r11 = r15;
    L41:
        if (r11.isCompleted() == false) goto L58;
        r9 = this.this$0;
        kotlinx.coroutines.sync.a r16 = r9.b;
        this.L$0 = r11;
        this.L$1 = r16;
        this.L$2 = r9;
        this.label = 3;
        if (r16.a(null, this) != r2) goto L45;
        return r2;
    L45:
        r10 = r16;
    L15:
        th = th;
        r5 = r15;
    L62:
        if (r5.isCompleted() == false) goto L78;
        AppletDebuggerEntryStateController r18 = this.this$0;
        kotlinx.coroutines.sync.a r19 = r18.b;
        this.L$0 = r5;
        this.L$1 = th;
        this.L$2 = r19;
        this.L$3 = r18;
        this.label = 4;
        if (r19.a(null, this) != r2) goto L66;
        return r2;
    L66:
        r4 = th;
        r1 = r18;
        r3 = r19;
        goto L87
    L78:
        throw th;
    L17:
        String r20 = (String) this.L$3;
        AppletDebuggerEntryStateController r21 = (AppletDebuggerEntryStateController) this.L$2;
        kotlinx.coroutines.sync.a r22 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r17);
    L82:
        AppletDebuggerEntryStateController.a r111 = r21.e;     // Catch: Throwable -> L79
        if (r111 == null) goto L24;
        String r112 = r111.a;     // Catch: Throwable -> L79
    L26:
        if (Intrinsics.areEqual(r112, r20) == true) goto L28;
    L30:
        if (r111 == null) goto L34;
        Deferred<Unit> r113 = r111.b;     // Catch: Throwable -> L79
        if (r113 == null) goto L34;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);     // Catch: Throwable -> L79
    L34:
        Deferred r23 = BuildersKt.async$default(r110, null, null, new AppletDebuggerEntryStateController$refreshEntryState$2$deferred$1$1(r21, r20, null), 3, null);     // Catch: Throwable -> L79
        r21.e = new AppletDebuggerEntryStateController.a(r20, r23);     // Catch: Throwable -> L79
    L35:
        r22.unlock(null);
        this.L$0 = r23;     // Catch: Throwable -> L59
        this.L$1 = null;     // Catch: Throwable -> L59
        this.L$2 = null;     // Catch: Throwable -> L59
        this.L$3 = null;     // Catch: Throwable -> L59
        this.label = 2;     // Catch: Throwable -> L59
        if (r23.await(this) != r2) goto L39;
        return r2;
    L39:
        r11 = r23;
    L59:
        th = th;
        r5 = r23;
        goto L62
    L28:
        if (r111.b.isActive() == false) goto L30;
        r23 = r111.b;     // Catch: Throwable -> L79
        goto L35
    L24:
        r112 = null;
    L79:
        th = move-exception;
        r22.unlock(null);
        throw th;
    L18:
        ResultKt.throwOnFailure(r17);
        r110 = (CoroutineScope) this.L$0;
        r21 = this.this$0;
        r22 = r21.b;
        r20 = this.$userId;
        this.L$0 = r110;
        this.L$1 = r22;
        this.L$2 = r21;
        this.L$3 = r20;
        this.label = 1;
        if (r22.a(null, this) != r2) goto L82;
        return r2;
    }
}
