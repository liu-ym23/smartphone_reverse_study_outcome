package com.bytedance.applet.aibridge;

import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntimeManager;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/SendOutputMethod;", "Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL$SendOutputMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsSendOutputMethodIDL$SendOutputMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendOutputMethod extends AbsSendOutputMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.SendOutputMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.aibridge.SendOutputMethod$handle$1", f = "SendOutputMethod.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ f3.h<AbsSendOutputMethodIDL.b> $callback;
        final /* synthetic */ AbsSendOutputMethodIDL.a $params;
        int label;

        public AnonymousClass1(AbsSendOutputMethodIDL.a r1, f3.h<AbsSendOutputMethodIDL.b> r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$params = r1;
            this.$callback = r2;
            this.$botId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$params, this.$callback, this.$botId, r5);
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
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L21
        L15:
            wc9.e r6 = (wc9.e) r5;     // Catch: Throwable -> L21
            if (r6 == null) goto L18;
            String r2 = r6.a;     // Catch: Throwable -> L21
        L19:
            Object r7 = Result.constructor-impl(r2);     // Catch: Throwable -> L21
        L24:
            if (Result.isFailure-impl(r7) == false) goto L26;
            r7 = null;
        L26:
            String r8 = (String) r7;
            if (r8 == null) goto L29;
            MessageUtils r3 = MessageUtils.a;
            String r4 = this.$params.getMessage();
            r3.getClass();
            MessageUtils.a(r8, r4);
            f3.h<AbsSendOutputMethodIDL.b> r9 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsSendOutputMethodIDL.b.class, "<this>");
            f3.h.a.b(r9, k3.c.a(AbsSendOutputMethodIDL.b.class));
        L31:
            return Unit.INSTANCE;
        L29:
            f3.h.a.a(this.$callback, "No found conversation ID.", null, null, 14);
            goto L31
        L18:
            r2 = null;
            goto L19
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            String r10 = this.$botId;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L21
            r2 = x4.a.a(r10);     // Catch: Throwable -> L21
            if (r2 != null) goto L19;
            IConversationRepoService r12 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            r5 = r12.a(r10, this);     // Catch: Throwable -> L21
            if (r5 != r0) goto L15;
            return r0;
        L21:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L24
        }
    }

    public SendOutputMethod() {
    }

    public final void handle(e3.d r9, ParamModel r10, f3.h r11) {
        AbsSendOutputMethodIDL.a r12 = (AbsSendOutputMethodIDL.a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        View r13 = r9.getEngineView();
        AppletRuntimeManager.INSTANCE.getClass();
        k2.i r14 = AppletRuntimeManager.d(r13);
        if (r14 == null) goto L6;
        String r15 = r14.getBotId();
        if (r15 == null) goto L6;
    L8:
        if (Intrinsics.areEqual(r12.getType(), AbsSendOutputMethodIDL.SupportedOutputType.Tips.getTypeName()) == false) goto L10;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r12, r11, r15, null), 3, null);
        return;
    L10:
        f3.h.a.a(r11, "Invalid output type.", null, null, 14);
        return;
    L6:
        r15 = "";
        goto L8
    }
}
