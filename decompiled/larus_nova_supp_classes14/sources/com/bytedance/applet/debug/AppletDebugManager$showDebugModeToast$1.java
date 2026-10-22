package com.bytedance.applet.debug;

import android.widget.Toast;
import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.bytedance.applet.debug.AppletDebugManager$showDebugModeToast$1", f = "AppletDebugManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugManager$showDebugModeToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $message;
    int label;

    public AppletDebugManager$showDebugModeToast$1(boolean r1, String r2, Continuation<? super AppletDebugManager$showDebugModeToast$1> r3) {
        this.$isSuccess = r1;
        this.$message = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletDebugManager$showDebugModeToast$1(this.$isSuccess, this.$message, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        if (this.$isSuccess == false) goto L7;
        String r4 = "鉴权成功，调试通道已开启";
    L10:
        Toast.makeText(AppHost.a.getApplication(), r4, 0).show();
        return Unit.INSTANCE;
    L7:
        r4 = this.$message;
        if (r4 != null) goto L10;
        r4 = "扫码处理失败";
        goto L10
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
