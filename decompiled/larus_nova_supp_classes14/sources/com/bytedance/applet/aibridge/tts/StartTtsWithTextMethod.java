package com.bytedance.applet.aibridge.tts;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.d1;
import e3.d;
import f3.h;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/tts/StartTtsWithTextMethod;", "Lcom/bytedance/applet/aibridge/tts/AbsStartTtsWithTextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/tts/AbsStartTtsWithTextMethodIDL$StartTtsWithTextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/tts/AbsStartTtsWithTextMethodIDL$StartTtsWithTextResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartTtsWithTextMethod extends AbsStartTtsWithTextMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.tts.StartTtsWithTextMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.aibridge.tts.StartTtsWithTextMethod$handle$1", f = "StartTtsWithTextMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AbsStartTtsWithTextMethodIDL.a $params;
        int label;

        public AnonymousClass1(AbsStartTtsWithTextMethodIDL.a r1, Continuation<? super AnonymousClass1> r2) {
            this.$params = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$params, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r18);
            d1 r2 = AudioServiceDelegate.a.i0();
            String r3 = "jsbtts" + System.currentTimeMillis();
            String r1 = this.$params.getTtsText();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            d1.a.a(r2, r3, null, r1, true, null, null, null, false, true, null, null, null, null, 3824);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public StartTtsWithTextMethod() {
    }

    public final void handle(d r7, ParamModel r8, h r9) {
        AbsStartTtsWithTextMethodIDL.a r10 = (AbsStartTtsWithTextMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(r10, null), 2, null);
    }
}
