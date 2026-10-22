package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/meta/TtsMetaBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsMetaModel$reload$2", f = "TtsMetaModel.kt", i = {}, l = {UserInfo.OWNER_TYPE_SYNCED_BLOCK}, m = "invokeSuspend", n = {}, s = {})
public final class TtsMetaModel$reload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsMetaBean>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TtsMetaModel this$0;

    public static final class a implements c0.f {
        public final /* synthetic */ i<Pair<TtsMetaBean, ? extends Throwable>> a;

        public a(j r1) {
            this.a = r1;
        }

        public final void a(TtsMetaBean r4) {
            if (this.a.isActive() == false) goto L6;
            i<Pair<TtsMetaBean, ? extends Throwable>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new Pair(r4, null)));
            return;
        }

        public final void onError(Throwable r4) {
            if (this.a.isActive() == false) goto L6;
            i<Pair<TtsMetaBean, ? extends Throwable>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new Pair(null, r4)));
            return;
        }
    }

    public TtsMetaModel$reload$2(TtsMetaModel r1, Continuation<? super TtsMetaModel$reload$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TtsMetaModel$reload$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsMetaBean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Throwable r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        TtsMetaModel r2 = (TtsMetaModel) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        Pair r9 = (Pair) r8;
        tt5.a.h("TtsMetaModel", "reload, load by fetch: " + r9);
        TtsMetaModel r4 = this.this$0;
        if (r9 == null) goto L16;
        TtsMetaBean r5 = (TtsMetaBean) r9.getFirst();
    L17:
        r4.c = r5;
        TtsMetaModel r6 = this.this$0;
        if (r9 == null) goto L20;
        r3 = (Throwable) r9.getSecond();
    L20:
        r6.e = r3;
        TtsMetaModel r10 = this.this$0;
        r10.d = true;
        return r10.c;
    L16:
        r5 = null;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        TtsMetaModel r11 = this.this$0;
        this.L$0 = r11;
        this.label = 1;
        j r7 = new j(IntrinsicsKt.intercepted(this), 1);
        r7.C();
        ((c0) org.koin.java.a.c(c0.class, null, null, 6)).b0(r11.a, r11.b, new a(r7));
        r8 = r7.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r8 != r0) goto L13;
        return r0;
    }
}
