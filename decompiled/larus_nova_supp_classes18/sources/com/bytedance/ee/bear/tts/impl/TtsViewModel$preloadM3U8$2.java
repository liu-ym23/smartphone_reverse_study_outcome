package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.model.TtsM3U8Model;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadM3U8$2", f = "TtsViewModel.kt", i = {}, l = {801}, m = "invokeSuspend", n = {}, s = {})
final class TtsViewModel$preloadM3U8$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    final /* synthetic */ TtsLoadScene $scene;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TtsLoadScene.values().length];
            r0[TtsLoadScene.SWITCH_TONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TtsLoadScene.PRELOAD_TONE_LIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public TtsViewModel$preloadM3U8$2(TtsViewModel r1, TtsLoadScene r2, Continuation<? super TtsViewModel$preloadM3U8$2> r3) {
        this.this$0 = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsViewModel$preloadM3U8$2(this.this$0, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L27:
        TtsResult r10 = TtsResult.d;
        return TtsResult.d;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        qo5.a r11 = new qo5.a();
        TtsLoadScene r2 = this.$scene;
        TtsViewModel r3 = this.this$0;
        int r4 = a.a[r2.ordinal()];
        long r5 = 0;
        String r6 = null;
        if (r4 != 1) goto L11;
        so5.a r7 = r3.x.d;
        if (r7 == null) goto L20;
        r6 = r7.l;
    L20:
        r11.a = r6;
        if (r7 == null) goto L23;
        r5 = r7.j;
    L23:
        r11.b = r5;
    L24:
        TtsM3U8Model r8 = this.this$0.u;
        TtsLoadScene r12 = this.$scene;
        this.label = 1;
        if (r8.e(r12, r11, this) != r0) goto L27;
        return r0;
    L11:
        if (r4 != 2) goto L24;
        r11.a = null;
        so5.a r13 = r3.x.d;
        if (r13 == null) goto L16;
        r5 = r13.j;
    L16:
        r11.b = r5;
        goto L24
    }
}
