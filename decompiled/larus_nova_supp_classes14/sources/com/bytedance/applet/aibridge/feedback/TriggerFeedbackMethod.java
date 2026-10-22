package com.bytedance.applet.aibridge.feedback;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.feedback.IChatFeedbackService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d3.a0;
import f3.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/feedback/TriggerFeedbackMethod;", "Lcom/bytedance/applet/aibridge/feedback/AbsTriggerFeedbackMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/feedback/AbsTriggerFeedbackMethodIDL$BridgeParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/feedback/AbsTriggerFeedbackMethodIDL$BridgeResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TriggerFeedbackMethod extends AbsTriggerFeedbackMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.feedback.TriggerFeedbackMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.aibridge.feedback.TriggerFeedbackMethod$handle$1", f = "TriggerFeedbackMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ h<AbsTriggerFeedbackMethodIDL.b> $callback;
        final /* synthetic */ Fragment $fragment;
        final /* synthetic */ AbsTriggerFeedbackMethodIDL.a $params;
        int label;
        final /* synthetic */ TriggerFeedbackMethod this$0;

        public AnonymousClass1(Fragment r1, AbsTriggerFeedbackMethodIDL.a r2, TriggerFeedbackMethod r3, h<AbsTriggerFeedbackMethodIDL.b> r4, Continuation<? super AnonymousClass1> r5) {
            this.$fragment = r1;
            this.$params = r2;
            this.this$0 = r3;
            this.$callback = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$fragment, this.$params, this.this$0, this.$callback, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.applet.aibridge.feedback.TriggerFeedbackMethod$handle$1$1] */
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r9);
            IChatFeedbackService r0 = (IChatFeedbackService) ServiceManager.get().getService(IChatFeedbackService.class);
            if (r0 == null) goto L8;
            Fragment r1 = this.$fragment;
            FragmentManager r2 = r1.getChildFragmentManager();
            String r3 = this.$params.getMessageID();
            TriggerFeedbackMethod r10 = this.this$0;
            AbsTriggerFeedbackMethodIDL.a r4 = this.$params;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            List r5 = (List) GsonProtectorUtils.fromJson(new Gson(), r4.getFeedbackTagListJson(), new com.bytedance.applet.aibridge.feedback.a().getType());
            String r6 = this.$params.getFeedbackPlaceholderText();
            final h<AbsTriggerFeedbackMethodIDL.b> r11 = this.$callback;
            final Fragment r7 = this.$fragment;
            r0.a(r1, r2, r3, r5, r6, new C00491(r11, r7));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public TriggerFeedbackMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, h r9) {
        AbsTriggerFeedbackMethodIDL.a r2 = (AbsTriggerFeedbackMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Fragment r1 = mv3.a.a(r7);
        if (r1 != null) goto L9;
        StringBuilder r10 = new StringBuilder("no_fragment:");
        a0 r11 = r7.getContainerContext();
        if (r11 == null) goto L7;
        ContainerType r12 = r11.getContainerType();
    L8:
        r10.append(r12);
        h.a.a(r9, r10.toString(), null, null, 14);
        return;
    L7:
        r12 = null;
        goto L8
    L9:
        FLogger.a.v("js_fb_tri", "start;");
        LifecycleOwnerKt.getLifecycleScope(r1).launchWhenResumed(new AnonymousClass1(r1, r2, this, r9, null));
    }
}
