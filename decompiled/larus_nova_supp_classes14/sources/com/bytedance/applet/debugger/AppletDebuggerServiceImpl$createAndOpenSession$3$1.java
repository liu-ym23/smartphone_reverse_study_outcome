package com.bytedance.applet.debugger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ai.api.DebuggerOpenArgs;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerServiceImpl$createAndOpenSession$3$1", f = "AppletDebuggerServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebuggerServiceImpl$createAndOpenSession$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DebuggerOpenArgs $openArgs;
    int label;

    public AppletDebuggerServiceImpl$createAndOpenSession$3$1(Context r1, DebuggerOpenArgs r2, Continuation<? super AppletDebuggerServiceImpl$createAndOpenSession$3$1> r3) {
        this.$context = r1;
        this.$openArgs = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletDebuggerServiceImpl$createAndOpenSession$3$1(this.$context, this.$openArgs, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        Intent r5 = new Intent(this.$context, AppletDebuggerActivity.class);
        DebuggerOpenArgs r0 = this.$openArgs;
        Context r1 = this.$context;
        r5.putExtra("applet_debugger_open_args", r0);
        if ((r1 instanceof Activity) == true) goto L7;
        r5.addFlags(268435456);
    L7:
        this.$context.startActivity(r5);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
