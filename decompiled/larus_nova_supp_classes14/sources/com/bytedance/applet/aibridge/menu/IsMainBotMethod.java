package com.bytedance.applet.aibridge.menu;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/menu/IsMainBotMethod;", "Lcom/bytedance/applet/aibridge/menu/AbsIsMainBotMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/menu/AbsIsMainBotMethodIDL$IsMainBotParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/menu/AbsIsMainBotMethodIDL$IsMainBotResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsMainBotMethod extends AbsIsMainBotMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.menu.IsMainBotMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.aibridge.menu.IsMainBotMethod$handle$1", f = "IsMainBotMethod.kt", i = {0}, l = {25}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f3.h<AbsIsMainBotMethodIDL.b> $callback;
        final /* synthetic */ String $conversationId;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, f3.h<AbsIsMainBotMethodIDL.b> r2, Continuation<? super AnonymousClass1> r3) {
            this.$conversationId = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$conversationId, this.$callback, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L11:
            wc9.e r11 = (wc9.e) r10;
            if (r11 == null) goto L14;
            f3.h<AbsIsMainBotMethodIDL.b> r3 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsIsMainBotMethodIDL.b.class, "<this>");
            AbsIsMainBotMethodIDL.b r4 = k3.c.a(AbsIsMainBotMethodIDL.b.class);
            r4.setValue(com.larus.bmhome.utils.i.f(r11));
            f3.h.a.b(r3, r4);
        L16:
            return Unit.INSTANCE;
        L14:
            f3.h.a.a(this.$callback, "Failed to get conversation info by conversation=" + this.$conversationId, null, null, 14);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            IConversationRepoService r5 = zh8.a.b;
            String r6 = this.$conversationId;
            this.L$0 = r12;
            this.label = 1;
            r10 = IConversationRepoService.a.c(r5, r6, true, null, this, 4);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public IsMainBotMethod() {
    }

    public final void handle(e3.d r8, ParamModel r9, f3.h r10) {
        AbsIsMainBotMethodIDL.a r11 = (AbsIsMainBotMethodIDL.a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r12 = r11.getConversationId();
        if (r12.length() != 0) goto L5;
        boolean r13 = true;
    L7:
        if (r13 == false) goto L9;
        f3.h.a.a(r10, "conversationId is empty", null, null, 14);
        return;
    L9:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r12, r10, null), 3, null);
        return;
    L5:
        r13 = false;
        goto L7
    }
}
