package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.model.TtsMetaModel;
import com.bytedance.ee.bear.tts.impl.model.TtsPermissionModel;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadMeta$2", f = "TtsViewModel.kt", i = {}, l = {772, 773, 779}, m = "invokeSuspend", n = {}, s = {})
final class TtsViewModel$preloadMeta$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    int label;
    final /* synthetic */ TtsViewModel this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadMeta$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsViewModel$preloadMeta$2$3", f = "TtsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TtsViewModel this$0;

        public AnonymousClass3(TtsViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            TtsViewModel r3 = this.this$0;
            r3.j.setValue(TtsViewModel.x(r3));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TtsViewModel$preloadMeta$2(TtsViewModel r1, Continuation<? super TtsViewModel$preloadMeta$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TtsViewModel$preloadMeta$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L36:
        TtsResult r9 = TtsResult.d;
        return TtsResult.d;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L32:
        ro5.a r10 = (ro5.a) r8;
    L33:
        tt5.a.h("TtsViewModel", this.this$0.d + " preloadMeta, completion");
        TtsViewModel.y(this.this$0);
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass3 r2 = new AnonymousClass3(this.this$0, null);
        this.label = 3;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L36;
        return r0;
    L11:
        ResultKt.throwOnFailure(r8);
    L23:
        TtsMetaBean r12 = (TtsMetaBean) r8;
    L24:
        TtsPermissionModel r13 = this.this$0.w;
        if (r13.d == false) goto L28;
        r13 = null;
    L28:
        if (r13 == null) goto L33;
        this.label = 2;
        r8 = r13.a(this);
        if (r8 != r0) goto L32;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        TtsMetaModel r14 = this.this$0.v;
        boolean r3 = r14.d;
        if (r3 == false) goto L16;
        tt5.a.h("TtsViewModel", this.this$0.d + " preloadMeta, already loaded: " + this.this$0.v);
        TtsResult r15 = TtsResult.d;
        return TtsResult.d;
    L16:
        if (r3 == false) goto L19;
        r14 = null;
    L19:
        if (r14 == null) goto L24;
        this.label = 1;
        r8 = r14.a(this);
        if (r8 != r0) goto L23;
        return r0;
    }
}
