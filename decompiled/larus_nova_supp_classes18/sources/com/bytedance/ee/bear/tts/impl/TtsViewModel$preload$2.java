package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preload$2", f = "TtsViewModel.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
final class TtsViewModel$preload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    final /* synthetic */ TtsLoadScene $loadScene;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$preload$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preload$2$1", f = "TtsViewModel.kt", i = {}, l = {187, 188, 189}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
        final /* synthetic */ TtsLoadScene $loadScene;
        int label;
        final /* synthetic */ TtsViewModel this$0;

        public AnonymousClass1(TtsViewModel r1, TtsLoadScene r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$loadScene = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$loadScene, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r7);
        L21:
            return r7;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L18:
            TtsViewModel r8 = this.this$0;
            this.label = 3;
            int r2 = TtsViewModel.E;
            r8.getClass();
            r7 = BuildersKt.withContext(Dispatchers.getIO(), new TtsViewModel$preloadPlayback$2(r8, null), this);
            if (r7 != r0) goto L21;
            return r0;
        L11:
            ResultKt.throwOnFailure(r7);
        L15:
            TtsViewModel r9 = this.this$0;
            TtsLoadScene r3 = this.$loadScene;
            this.label = 2;
            int r4 = TtsViewModel.E;
            r9.getClass();
            if (BuildersKt.withContext(Dispatchers.getIO(), new TtsViewModel$preloadM3U8$2(r9, r3, null), this) != r0) goto L18;
            return r0;
        L12:
            ResultKt.throwOnFailure(r7);
            TtsViewModel r10 = this.this$0;
            this.label = 1;
            int r5 = TtsViewModel.E;
            r10.getClass();
            if (BuildersKt.withContext(Dispatchers.getIO(), new TtsViewModel$preloadMeta$2(r10, null), this) != r0) goto L15;
            return r0;
        }
    }

    public TtsViewModel$preload$2(TtsViewModel r1, TtsLoadScene r2, Continuation<? super TtsViewModel$preload$2> r3) {
        this.this$0 = r1;
        this.$loadScene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsViewModel$preload$2(this.this$0, this.$loadScene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        TtsResult r8 = TtsResult.d;
        return TtsResult.d;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$loadScene, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L11;
        return r0;
    }
}
