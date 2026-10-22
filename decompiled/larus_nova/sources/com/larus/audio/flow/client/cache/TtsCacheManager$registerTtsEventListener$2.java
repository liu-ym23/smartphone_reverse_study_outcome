package com.larus.audio.flow.client.cache;

import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$2", f = "TtsCacheManager.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
final class TtsCacheManager$registerTtsEventListener$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f289731a = null;

        /* JADX INFO: renamed from: com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$2$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3969a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f289732a = null;

            static {
                int[] r100 = new int[TtsState.values().length];
                r100[TtsState.TTS_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f289732a = r100;
            }
        }

        static {
            f289731a = new a();
        }

        public a() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            TtsState r102 = (TtsState) r100;
            int r103 = c68.b.f22600a;
            c68.b.a("TtsCacheManager", "ttsEventFlow = " + r102);
            if (C3969a.f289732a[r102.ordinal()] != 1) goto L6;
            TtsCacheManager.a();
        L6:
            return Unit.INSTANCE;
        }
    }

    public TtsCacheManager$registerTtsEventListener$2(Continuation<? super TtsCacheManager$registerTtsEventListener$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TtsCacheManager$registerTtsEventListener$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TtsCacheManager$registerTtsEventListener$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        MutableSharedFlow<TtsState> r104 = f.f289742b;
        FlowCollector<? super TtsState> r105 = a.f289731a;
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
