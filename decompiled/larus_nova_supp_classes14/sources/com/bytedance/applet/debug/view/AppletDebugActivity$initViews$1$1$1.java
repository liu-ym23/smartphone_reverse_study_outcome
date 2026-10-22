package com.bytedance.applet.debug.view;

import androidx.appcompat.app.AlertDialog;
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
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity$initViews$1$1$1", f = "AppletDebugActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugActivity$initViews$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppletDebugActivity this$0;

    public AppletDebugActivity$initViews$1$1$1(AppletDebugActivity r1, Continuation<? super AppletDebugActivity$initViews$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AppletDebugActivity$initViews$1$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Activity, android.content.Context, com.bytedance.applet.debug.view.AppletDebugActivity, java.lang.Object] */
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        AppletDebugActivity r5 = this.this$0;
        int r0 = AppletDebugActivity.l;
        r5.R1(true);
        final ?? r6 = this.this$0;
        r6.getClass();
        AlertDialog.Builder r1 = new AlertDialog.Builder(r6);
        r1.setMessage(r6.getString(2131894338));
        r1.setPositiveButton(r6.getString(2131894325), new a(r6));
        r1.setCancelable(false);
        r1.show();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
