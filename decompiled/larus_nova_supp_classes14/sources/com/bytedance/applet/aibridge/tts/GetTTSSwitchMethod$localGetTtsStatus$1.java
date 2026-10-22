package com.bytedance.applet.aibridge.tts;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.bmhome.utils.i;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import f3.h;
import k3.c;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.tts.GetTTSSwitchMethod$localGetTtsStatus$1", f = "GetTTSSwitchMethod.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class GetTTSSwitchMethod$localGetTtsStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ h<AbsGetTTSSwitchMethodIDL.b> $callback;
    private /* synthetic */ Object L$0;
    int label;

    public GetTTSSwitchMethod$localGetTtsStatus$1(h<AbsGetTTSSwitchMethodIDL.b> r1, String r2, Continuation<? super GetTTSSwitchMethod$localGetTtsStatus$1> r3) {
        this.$callback = r1;
        this.$botId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        GetTTSSwitchMethod$localGetTtsStatus$1 r0 = new GetTTSSwitchMethod$localGetTtsStatus$1(this.$callback, this.$botId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        Object r4 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L26
    L16:
        e r7 = (e) r6;     // Catch: Throwable -> L26
        if (r7 != null) goto L20;
        Boolean r8 = null;
    L24:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L26
    L28:
        Throwable r3 = Result.exceptionOrNull-impl(r9);
        if (r3 == null) goto L33;
        FLogger.a.e("GetTTSSwitchMethod", r3.toString());
        r9 = Result.constructor-impl(null);
    L33:
        if (Result.isFailure-impl(r9) == true) goto L36;
        r4 = r9;
    L36:
        Boolean r5 = (Boolean) r4;
        h<AbsGetTTSSwitchMethodIDL.b> r10 = this.$callback;
        Intrinsics.checkNotNullParameter(AbsGetTTSSwitchMethodIDL.b.class, "<this>");
        AbsGetTTSSwitchMethodIDL.b r11 = c.a(AbsGetTTSSwitchMethodIDL.b.class);
        AbsGetTTSSwitchMethodIDL.b r12 = r11;
        if (r5 == null) goto L39;
        r2 = r5.booleanValue();
    L39:
        r12.setValue(r2);
        h.a.b(r10, r11);
        return Unit.INSTANCE;
    L20:
        if (i.f(r7) == false) goto L22;
        boolean r13 = i.d(UserSettingRepoDelegate.b.d(r7.a), true, null);     // Catch: Throwable -> L26
    L23:
        r8 = Boxing.boxBoolean(r13);     // Catch: Throwable -> L26
        goto L24
    L22:
        r13 = i.d(UserSettingRepoDelegate.b.d(r7.a), false, r7.a);     // Catch: Throwable -> L26
        goto L23
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        String r15 = this.$botId;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L26
        if (z2.a.voiceGlobalSwitchEnable() == false) goto L13;
        r8 = Boxing.boxBoolean(i.c(UserSettingRepoDelegate.b.b()));     // Catch: Throwable -> L26
        goto L24
    L13:
        IConversationRepoService r17 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        r6 = r17.a(r15, this);     // Catch: Throwable -> L26
        if (r6 != r0) goto L16;
        return r0;
    L26:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
