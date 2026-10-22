package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.lark.dependency.g;
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
import so5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsPlaybackModel$saveToCache$2", f = "TtsPlaybackModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsPlaybackModel$saveToCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsPlaybackModel this$0;

    public TtsPlaybackModel$saveToCache$2(TtsPlaybackModel r1, Continuation<? super TtsPlaybackModel$saveToCache$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        TtsPlaybackModel$saveToCache$2 r0 = new TtsPlaybackModel$saveToCache$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        TtsPlaybackModel r10 = this.this$0;
        a r0 = r10.d;
        boolean r1 = false;
        if (r0 != null) goto L8;
        tt5.a.h("TtsPlaybackModel", "savePlaybackBean, playbackBean == null");
        return Boxing.boxBoolean(false);
    L8:
        ((g) r10.a.getValue()).getNtpTime();
        r0.g = 0;
        long r5 = ((c0) org.koin.java.a.c(c0.class, null, null, 6)).g0(r0);
        tt5.a.h("TtsPlaybackModel", "savePlaybackBean, ret: " + r5);
        if (r5 <= 0) goto L12;
        r1 = true;
    L12:
        return Boxing.boxBoolean(r1);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
