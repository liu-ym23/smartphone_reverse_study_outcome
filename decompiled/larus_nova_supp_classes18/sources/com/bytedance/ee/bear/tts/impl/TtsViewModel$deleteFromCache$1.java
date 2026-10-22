package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$deleteFromCache$1", f = "TtsViewModel.kt", i = {}, l = {513, 520}, m = "invokeSuspend", n = {}, s = {})
final class TtsViewModel$deleteFromCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ mo5.b $callback;
    final /* synthetic */ String $desc;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$deleteFromCache$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$deleteFromCache$1$1", f = "TtsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ mo5.b $callback;
        final /* synthetic */ boolean $deleteSuccess;
        int label;

        public AnonymousClass1(boolean r1, mo5.b r2, Continuation<? super AnonymousClass1> r3) {
            this.$deleteSuccess = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$deleteSuccess, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r2);
            if (this.$deleteSuccess == false) goto L7;
            TtsResult r3 = TtsResult.d;
        L8:
            mo5.b r0 = this.$callback;
            if (r0 == null) goto L12;
            r0.a(r3);
        L12:
            return Unit.INSTANCE;
        L7:
            r3 = new TtsResult(TtsResult.ModelCode.DELETE_FAILED);
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TtsViewModel$deleteFromCache$1(TtsViewModel r1, String r2, mo5.b r3, Continuation<? super TtsViewModel$deleteFromCache$1> r4) {
        this.this$0 = r1;
        this.$desc = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        TtsViewModel$deleteFromCache$1 r0 = new TtsViewModel$deleteFromCache$1(this.this$0, this.$desc, this.$callback, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r6 = false;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L11
    L17:
        List r16 = (List) r15;     // Catch: Exception -> L11
        tt5.a.h("TtsViewModel", this.this$0.d + " deleteFromCache, desc: " + this.$desc + ", result: " + r16);     // Catch: Exception -> L11
        List r17 = r16;     // Catch: Exception -> L11
        if ((r17 instanceof Collection) == true) goto L20;
    L22:
        Iterator r18 = r17.iterator();     // Catch: Exception -> L11
    L23:
        if (r18.hasNext() == false) goto L21;
        if (((Boolean) r18.next()).booleanValue() == true) goto L23;
    L29:
        MainCoroutineDispatcher r19 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(r6, this.$callback, null);
        this.label = 2;
        if (BuildersKt.withContext(r19, r2, this) != r0) goto L33;
        return r0;
    L21:
        r6 = true;
        goto L29
    L20:
        if (r17.isEmpty() == false) goto L22;
    L13:
        ResultKt.throwOnFailure(r15);
        Deferred[] r3 = {BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new TtsViewModel$deleteFromCache$1$deletePlaybackJob$1(this.this$0, null), 3, null)};     // Catch: Exception -> L11
        this.label = 1;     // Catch: Exception -> L11
        r15 = AwaitKt.b(r3, this);     // Catch: Exception -> L11
        if (r15 != r0) goto L17;
        return r0;
    L11:
        e = move-exception;
        tt5.a.e("TtsViewModel", this.this$0.d + " deleteFromCache, desc: " + this.$desc + ", error:", e, false);
        goto L29
    }
}
