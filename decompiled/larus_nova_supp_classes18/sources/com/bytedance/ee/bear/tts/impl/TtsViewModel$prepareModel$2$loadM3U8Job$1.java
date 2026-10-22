package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/m3u8/TtsM3U8Bean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$prepareModel$2$loadM3U8Job$1", f = "TtsViewModel.kt", i = {0, 0}, l = {573, 574}, m = "invokeSuspend", n = {"m3u8LoadParams", "it"}, s = {"L$0", "L$2"})
public final class TtsViewModel$prepareModel$2$loadM3U8Job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsM3U8Bean>, Object> {
    final /* synthetic */ TtsLoadScene $scene;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    public TtsViewModel$prepareModel$2$loadM3U8Job$1(TtsViewModel r1, TtsLoadScene r2, Continuation<? super TtsViewModel$prepareModel$2$loadM3U8Job$1> r3) {
        this.this$0 = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsViewModel$prepareModel$2$loadM3U8Job$1(this.this$0, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsM3U8Bean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L31:
        return (TtsM3U8Bean) r9;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        TtsM3U8Model r2 = (TtsM3U8Model) this.L$2;
        TtsLoadScene r3 = (TtsLoadScene) this.L$1;
        qo5.a r5 = (qo5.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L27:
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        r9 = r2.f(r3, r5, this);
        if (r9 != r0) goto L31;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        r5 = new qo5.a();
        TtsViewModel r10 = this.this$0;
        so5.a r4 = r10.x.d;
        if (r4 == null) goto L13;
        String r6 = r4.l;
    L14:
        r5.a = r6;
        if (r4 == null) goto L17;
        long r7 = r4.j;
    L18:
        r5.b = r7;
        TtsM3U8Model r11 = r10.u;
        if (r11.d == true) goto L21;
        r2 = r11;
    L22:
        if (r2 == null) goto L32;
        TtsLoadScene r12 = this.$scene;
        this.L$0 = r5;
        this.L$1 = r12;
        this.L$2 = r2;
        this.label = 1;
        if (r2.e(r12, r5, this) != r0) goto L26;
        return r0;
    L26:
        r3 = r12;
        goto L27
    L32:
        return null;
    L21:
        r2 = null;
        goto L22
    L17:
        r7 = 0;
        goto L18
    L13:
        r6 = null;
        goto L14
    }
}
