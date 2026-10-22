package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.contract.c0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.koin.java.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsPlaybackModel$deleteFromCache$2", f = "TtsPlaybackModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsPlaybackModel$deleteFromCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ TtsPlaybackModel this$0;

    public TtsPlaybackModel$deleteFromCache$2(TtsPlaybackModel r1, Continuation<? super TtsPlaybackModel$deleteFromCache$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TtsPlaybackModel$deleteFromCache$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        int r4 = ((c0) a.c(c0.class, null, null, 6)).i0(this.this$0.b);
        tt5.a.h("TtsPlaybackModel", "deletePlaybackBean, ret: " + r4);
        if (r4 != 0) goto L7;
        boolean r5 = true;
    L9:
        return Boxing.boxBoolean(r5);
    L7:
        r5 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
