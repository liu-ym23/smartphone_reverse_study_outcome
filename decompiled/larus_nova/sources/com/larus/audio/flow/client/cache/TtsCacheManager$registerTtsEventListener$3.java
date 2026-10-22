package com.larus.audio.flow.client.cache;

import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$3", f = "TtsCacheManager.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class TtsCacheManager$registerTtsEventListener$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f289733a = null;

        static {
            f289733a = new a();
        }

        public a() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            byte[] r102 = (byte[]) r100;
            int r103 = c68.b.f22600a;
            c68.b.a("TtsCacheManager", "ttsContentData's size = " + r102.length);
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
            String r105 = TtsCacheManager.f289728i;     // Catch: Throwable -> L9
            if (r105 == null) goto L6;
            Lazy r106 = TtsCacheManager.f289720a;     // Catch: Throwable -> L9
            TtsCacheManager.d().b(r105, r102);     // Catch: Throwable -> L9
            Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L9
        L11:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
            if (r109 == null) goto L15;
            c68.b.c("TtsCacheManager", "ttsContentData error: ", r109);
        L15:
            return Unit.INSTANCE;
        L6:
            r107 = null;
        L9:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }
    }

    public TtsCacheManager$registerTtsEventListener$3(Continuation<? super TtsCacheManager$registerTtsEventListener$3> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TtsCacheManager$registerTtsEventListener$3(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TtsCacheManager$registerTtsEventListener$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MutableSharedFlow<TtsEventEnum> r103 = f.f289741a;
        MutableSharedFlow<byte[]> r104 = f.f289743c;
        FlowCollector<? super byte[]> r105 = a.f289733a;
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
