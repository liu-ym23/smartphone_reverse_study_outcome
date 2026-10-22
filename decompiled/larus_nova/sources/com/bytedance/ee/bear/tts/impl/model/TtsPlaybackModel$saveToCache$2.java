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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsPlaybackModel$saveToCache$2", f = "TtsPlaybackModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsPlaybackModel$saveToCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsPlaybackModel this$0;

    public TtsPlaybackModel$saveToCache$2(TtsPlaybackModel r100, Continuation<? super TtsPlaybackModel$saveToCache$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TtsPlaybackModel$saveToCache$2 r102 = new TtsPlaybackModel$saveToCache$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((TtsPlaybackModel$saveToCache$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        TtsPlaybackModel r102 = this.this$0;
        a r103 = r102.f239606d;
        boolean r104 = false;
        if (r103 != null) goto L8;
        tt5.a.h("TtsPlaybackModel", "savePlaybackBean, playbackBean == null");
        return Boxing.boxBoolean(false);
    L8:
        ((g) r102.f239603a.getValue()).getNtpTime();
        r103.f542721g = 0;
        long r105 = ((c0) org.koin.java.a.c(c0.class, null, null, 6)).g0(r103);
        tt5.a.h("TtsPlaybackModel", "savePlaybackBean, ret: " + r105);
        if (r105 <= 0) goto L12;
        r104 = true;
    L12:
        return Boxing.boxBoolean(r104);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
