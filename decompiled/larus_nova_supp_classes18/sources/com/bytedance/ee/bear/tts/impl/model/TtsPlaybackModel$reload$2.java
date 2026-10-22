package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.lark.dependency.g;
import com.bytedance.ee.bear.tts.TtsDataSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import so5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/playback/TtsPlaybackBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsPlaybackModel$reload$2", f = "TtsPlaybackModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsPlaybackModel$reload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
    int label;
    final /* synthetic */ TtsPlaybackModel this$0;

    public TtsPlaybackModel$reload$2(TtsPlaybackModel r1, Continuation<? super TtsPlaybackModel$reload$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TtsPlaybackModel$reload$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r6);
        a r7 = this.this$0.d;
        a r0 = ((c0) org.koin.java.a.c(c0.class, null, null, 6)).p0(this.this$0.b);
        if (r0 == null) goto L8;
        TtsDataSource r8 = TtsDataSource.UNKNOWN;
        r0.k = 1.0f;
        tt5.a.h("TtsPlaybackModel", "reload, read from db: " + r0);
        r7 = r0;
    L11:
        TtsPlaybackModel r1 = this.this$0;
        r1.d = r7;
        r1.e = true;
        return r7;
    L8:
        if (r7 == null) goto L10;
        TtsPlaybackModel r2 = this.this$0;
        TtsDataSource r4 = TtsDataSource.UNKNOWN;
        ((g) r2.a.getValue()).getNtpTime();
        r7.f = 0;
        r7.g = 0;
        tt5.a.h("TtsPlaybackModel", "reload, use lastPlaybackBean: " + r7);
        goto L11
    L10:
        r7 = new a();
        TtsPlaybackModel r3 = this.this$0;
        TtsDataSource r5 = TtsDataSource.UNKNOWN;
        r7.a = r3.b;
        r7.b = r3.c;
        ((g) r3.a.getValue()).getNtpTime();
        r7.f = 0;
        r7.g = 0;
        tt5.a.h("TtsPlaybackModel", "reload, create a new one: " + r7);
        goto L11
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
