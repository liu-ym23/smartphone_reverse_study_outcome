package com.bytedance.ee.bear.tts.impl;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.model.TtsPlaybackModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadPlayback$2", f = "TtsViewModel.kt", i = {}, l = {810, 816}, m = "invokeSuspend", n = {}, s = {})
final class TtsViewModel$preloadPlayback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    int label;
    final /* synthetic */ TtsViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadPlayback$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadPlayback$2$1", f = "TtsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TtsViewModel this$0;

        public AnonymousClass1(TtsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r7);
            TtsViewModel r8 = this.this$0;
            so5.a r0 = r8.x.d;
            if (r0 == null) goto L7;
            long r3 = r0.j;
        L8:
            r8.l.setValue(Boxing.boxLong(r3));
            TtsViewModel r9 = this.this$0;
            r9.m.setValue(r9.u.a(r3));
            TtsViewModel r10 = this.this$0;
            MutableLiveData<Long> r1 = r10.o;
            Long r11 = Boxing.boxLong(r10.u.c());
            if (r11.longValue() <= 0) goto L11;
            boolean r4 = true;
        L12:
            Long r5 = null;
            if (r4 == true) goto L16;
            r11 = null;
        L16:
            if (r11 != null) goto L23;
            so5.a r12 = this.this$0.x.d;
            if (r12 == null) goto L20;
            r5 = Boxing.boxLong(r12.i);
        L20:
            if (r5 != null) goto L22;
            r11 = Boxing.boxLong(0);
            goto L23
        L22:
            r11 = r5;
        L23:
            r1.setValue(r11);
            TtsViewModel r13 = this.this$0;
            r13.j.setValue(TtsViewModel.x(r13));
            return Unit.INSTANCE;
        L11:
            r4 = false;
            goto L12
        L7:
            r3 = 0;
            goto L8
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TtsViewModel$preloadPlayback$2(TtsViewModel r1, Continuation<? super TtsViewModel$preloadPlayback$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TtsViewModel$preloadPlayback$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L20:
        TtsResult r7 = TtsResult.d;
        return TtsResult.d;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L17:
        tt5.a.h("TtsViewModel", this.this$0.d + " preloadPlayback, completion");
        TtsViewModel.y(this.this$0);
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        TtsPlaybackModel r9 = this.this$0.x;
        if (r9.e == false) goto L14;
        tt5.a.h("TtsViewModel", this.this$0.d + " preloadPlayback, already loaded: " + this.this$0.x);
        TtsResult r10 = TtsResult.d;
        return TtsResult.d;
    L14:
        this.label = 1;
        if (r9.b(this) != r0) goto L17;
        return r0;
    }
}
