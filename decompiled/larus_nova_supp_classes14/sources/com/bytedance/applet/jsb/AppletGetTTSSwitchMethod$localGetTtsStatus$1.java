package com.bytedance.applet.jsb;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.jsb.AppletGetTTSSwitchMethod$localGetTtsStatus$1", f = "AppletGetTTSSwitchMethod.kt", i = {}, l = {ECDraweeView.SELF_ADJUST_1X_TO_DP}, m = "invokeSuspend", n = {}, s = {})
final class AppletGetTTSSwitchMethod$localGetTtsStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ IvyBridgeMethod.a $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ x this$0;

    public AppletGetTTSSwitchMethod$localGetTtsStatus$1(x r1, IvyBridgeMethod.a r2, String r3, Continuation<? super AppletGetTTSSwitchMethod$localGetTtsStatus$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$botId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppletGetTTSSwitchMethod$localGetTtsStatus$1 r0 = new AppletGetTTSSwitchMethod$localGetTtsStatus$1(this.this$0, this.$callback, this.$botId, r6);
        r0.L$0 = r5;
        return r0;
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
        Object r3 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L26
    L16:
        wc9.e r6 = (wc9.e) r5;     // Catch: Throwable -> L26
        if (r6 != null) goto L20;
        Boolean r7 = null;
    L24:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L26
    L28:
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 == null) goto L33;
        FLogger.a.e("AppletGetTTSSwitch", r2.toString());
        r8 = Result.constructor-impl(null);
    L33:
        if (Result.isFailure-impl(r8) == true) goto L36;
        r3 = r8;
    L36:
        x r9 = this.this$0;
        IvyBridgeMethod.a r4 = this.$callback;
        r9.getClass();
        x.f(r4, (Boolean) r3);
        return Unit.INSTANCE;
    L20:
        if (com.larus.bmhome.utils.i.f(r6) == false) goto L22;
        boolean r10 = com.larus.bmhome.utils.i.d(UserSettingRepoDelegate.b.d(r6.a), true, null);     // Catch: Throwable -> L26
    L23:
        r7 = Boxing.boxBoolean(r10);     // Catch: Throwable -> L26
        goto L24
    L22:
        r10 = com.larus.bmhome.utils.i.d(UserSettingRepoDelegate.b.d(r6.a), false, r6.a);     // Catch: Throwable -> L26
        goto L23
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        String r12 = this.$botId;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L26
        if (z2.a.voiceGlobalSwitchEnable() == false) goto L13;
        r7 = Boxing.boxBoolean(com.larus.bmhome.utils.i.c(UserSettingRepoDelegate.b.b()));     // Catch: Throwable -> L26
        goto L24
    L13:
        IConversationRepoService r14 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        r5 = r14.a(r12, this);     // Catch: Throwable -> L26
        if (r5 != r0) goto L16;
        return r0;
    L26:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
