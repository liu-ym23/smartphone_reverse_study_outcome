package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.impl.model.TtsToneModel;
import com.bytedance.ee.bear.tts.tone.TtsToneListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/tone/TtsToneListBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$2$loadToneJob$1", f = "TtsViewModel.kt", i = {}, l = {599}, m = "invokeSuspend", n = {}, s = {})
public final class TtsViewModel$prepareModel$2$2$loadToneJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsToneListBean>, Object> {
    final /* synthetic */ String $mainLanguageCode;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    public TtsViewModel$prepareModel$2$2$loadToneJob$1(TtsViewModel r1, String r2, Continuation<? super TtsViewModel$prepareModel$2$2$loadToneJob$1> r3) {
        this.this$0 = r1;
        this.$mainLanguageCode = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsViewModel$prepareModel$2$2$loadToneJob$1(this.this$0, this.$mainLanguageCode, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsToneListBean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L17:
        return (TtsToneListBean) r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        TtsToneModel r6 = this.this$0.y;
        if (r6.d == false) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L18;
        String r2 = this.$mainLanguageCode;
        this.label = 1;
        r5 = r6.a(r2, this);
        if (r5 != r0) goto L17;
        return r0;
    L18:
        return null;
    }
}
