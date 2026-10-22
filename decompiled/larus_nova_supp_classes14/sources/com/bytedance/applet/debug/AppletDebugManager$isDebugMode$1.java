package com.bytedance.applet.debug;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.applet.debug.view.AppletDebugActivity;
import com.larus.bmhome.chat.j4;
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
@DebugMetadata(c = "com.bytedance.applet.debug.AppletDebugManager$isDebugMode$1", f = "AppletDebugManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebugManager$isDebugMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletDebugManager.a $previewDebugInfo;
    final /* synthetic */ String $shortToken;
    int label;

    public AppletDebugManager$isDebugMode$1(String r1, AppletDebugManager.a r2, Continuation<? super AppletDebugManager$isDebugMode$1> r3) {
        this.$shortToken = r1;
        this.$previewDebugInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppletDebugManager$isDebugMode$1(this.$shortToken, this.$previewDebugInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r6);
        AppHost.Companion r7 = AppHost.a;
        Activity r0 = r7.a().getCurrentActivity();
        j4 r1 = null;
        if (r0 == null) goto L7;
        Activity r2 = r7.a().a(r0, null);
    L8:
        Intent r3 = new Intent(r7.getApplication(), AppletDebugActivity.class);
        r3.putExtra("actionName", "startDebug");
        String r8 = this.$shortToken;
        if (r8 == null) goto L11;
        r3.putExtra("shortToken", r8);
    L11:
        AppletDebugManager.a r9 = this.$previewDebugInfo;
        if (r9 == null) goto L15;
        r3.putExtra("debugInfo", r9.a);
        r3.putExtra("debugToken", r9.b);
    L15:
        if ((r2 instanceof j4) == false) goto L17;
        r1 = (j4) r2;
    L17:
        if (r1 == null) goto L21;
        boolean r10 = r1.s1();
        boolean r4 = true;
        if (r10 != true) goto L21;
    L22:
        r3.putExtra("callerIsMainBotChatPage", r4);
        if (r2 == null) goto L26;
        r2.startActivity(r3);
    L26:
        return Unit.INSTANCE;
    L21:
        r4 = false;
        goto L22
    L7:
        r2 = null;
        goto L8
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
