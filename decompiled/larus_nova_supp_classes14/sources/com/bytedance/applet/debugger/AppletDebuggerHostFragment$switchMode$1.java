package com.bytedance.applet.debugger;

import android.content.Context;
import com.bytedance.ai.api.DebuggerMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerHostFragment$switchMode$1", f = "AppletDebuggerHostFragment.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebuggerHostFragment$switchMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ DebuggerMode $target;
    int label;
    final /* synthetic */ AppletDebuggerHostFragment this$0;

    public AppletDebuggerHostFragment$switchMode$1(AppletDebuggerHostFragment r1, DebuggerMode r2, Function0<Unit> r3, Function0<Unit> r4, Continuation<? super AppletDebuggerHostFragment$switchMode$1> r5) {
        this.this$0 = r1;
        this.$target = r2;
        this.$onSuccess = r3;
        this.$onFailure = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AppletDebuggerHostFragment$switchMode$1(this.this$0, this.$target, this.$onSuccess, this.$onFailure, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L31
    L13:
        boolean r5 = ((Boolean) r4).booleanValue();     // Catch: Throwable -> L31
        AppletDebuggerHostFragment r2 = this.this$0;
        int r3 = AppletDebuggerHostFragment.m;
        r2.W90(r2.U90().showConversationEnable());
        if (r5 == false) goto L19;
        Function0<Unit> r6 = this.$onSuccess;
        if (r6 == null) goto L30;
        r6.invoke();
    L30:
        return Unit.INSTANCE;
    L19:
        Function0<Unit> r7 = this.$onFailure;
        if (r7 == null) goto L23;
        r7.invoke();
    L23:
        if (this.$target == DebuggerMode.LOCAL_DEBUG) goto L25;
    L27:
        String r8 = this.this$0.getString(2131894383);
    L28:
        Intrinsics.checkNotNull(r8);
        t19.s r9 = t19.s.a;
        Context r10 = this.this$0.getContext();
        r9.getClass();
        t19.s.c(r10, r8);
        goto L30
    L25:
        if (this.this$0.U90().getDebugChannelState().getValue() != DebuggerDebugChannelState.DISCONNECTED) goto L27;
        r8 = this.this$0.getString(2131894380);
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        AppletDebuggerHostFragment r11 = this.this$0;
        int r12 = AppletDebuggerHostFragment.m;
        r11.W90(false);
        DebuggerSessionViewModel r13 = this.this$0.U90();     // Catch: Throwable -> L31
        DebuggerMode r14 = this.$target;     // Catch: Throwable -> L31
        this.label = 1;     // Catch: Throwable -> L31
        r4 = r13.switchMode(r14, this);     // Catch: Throwable -> L31
        if (r4 != r0) goto L13;
        return r0;
    L31:
        th = move-exception;
        AppletDebuggerHostFragment r15 = this.this$0;
        int r16 = AppletDebuggerHostFragment.m;
        r15.W90(r15.U90().showConversationEnable());
        throw th;
    }
}
