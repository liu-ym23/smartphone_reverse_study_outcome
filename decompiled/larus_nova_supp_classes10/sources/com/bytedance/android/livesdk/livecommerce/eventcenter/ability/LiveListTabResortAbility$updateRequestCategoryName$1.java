package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility$updateRequestCategoryName$1", f = "LiveListTabResortAbility.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
public final class LiveListTabResortAbility$updateRequestCategoryName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LiveListTabResortAbility this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility$updateRequestCategoryName$1$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility$updateRequestCategoryName$1$2", f = "LiveListTabResortAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Pair<? extends Long, ? extends String>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation r2) {
            super(3, r2);
        }

        public final Continuation<Unit> create(FlowCollector<? super Pair<Long, String>> r2, Throwable r3, Continuation<? super Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "$this$create");
            Intrinsics.checkNotNullParameter(r3, "it");
            Intrinsics.checkNotNullParameter(r4, "continuation");
            AnonymousClass2 r5 = new AnonymousClass2(r4);
            r5.L$0 = r3;
            return r5;
        }

        public final Object invoke(Object r1, Object r2, Object r3) {
            return create((FlowCollector) r1, (Throwable) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ECExceptionMonitor.e((Throwable) this.L$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements FlowCollector<Pair<? extends Long, ? extends String>> {
        public final /* synthetic */ LiveListTabResortAbility$updateRequestCategoryName$1 a;
        public final /* synthetic */ CoroutineScope b;

        public a(LiveListTabResortAbility$updateRequestCategoryName$1 r1, CoroutineScope r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r7, Continuation r8) {
            Pair r9 = (Pair) r7;
            if (r9.getSecond() == null) goto L25;
            if (((Number) r9.getFirst()).longValue() <= this.a.this$0.d) goto L25;
            CoroutineScope r0 = this.b;
            monitor-enter(r0);
        L21:
            th = move-exception;
            throw th;
        L9:
            if (((Number) r9.getFirst()).longValue() <= this.a.this$0.d) goto L18;
            dm.a.b r1 = dm.a.a("LiveListTabResortAbility");     // Catch: Throwable -> L21
            StringBuilder r2 = new StringBuilder("updateRequestCategoryName from: ");     // Catch: Throwable -> L21
            LiveListTabResortAbility r10 = this.a.this$0;     // Catch: Throwable -> L21
            if (r10.d().e() != 2) goto L13;
            boolean r3 = true;
        L14:
            if (r3 == false) goto L16;
            String r11 = r10.c;     // Catch: Throwable -> L21
        L17:
            r2.append(r11);     // Catch: Throwable -> L21
            r2.append(" to ");     // Catch: Throwable -> L21
            r2.append((String) r9.getSecond());     // Catch: Throwable -> L21
            r2.append(" oldTime: ");     // Catch: Throwable -> L21
            r2.append(this.a.this$0.d);     // Catch: Throwable -> L21
            r2.append(" updateTime: ");     // Catch: Throwable -> L21
            r2.append(((Number) r9.getFirst()).longValue());     // Catch: Throwable -> L21
            r1.i(r2.toString());     // Catch: Throwable -> L21
            LiveListTabResortAbility r12 = this.a.this$0;     // Catch: Throwable -> L21
            r12.d = ((Number) r9.getFirst()).longValue();     // Catch: Throwable -> L21
            LiveListTabResortAbility r13 = this.a.this$0;     // Catch: Throwable -> L21
            r13.c = (String) r9.getSecond();     // Catch: Throwable -> L21
            goto L18
        L16:
            r11 = null;
            goto L17
        L13:
            r3 = false;
        L18:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r0);
        L25:
            return Unit.INSTANCE;
        }
    }

    public LiveListTabResortAbility$updateRequestCategoryName$1(LiveListTabResortAbility r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        LiveListTabResortAbility$updateRequestCategoryName$1 r0 = new LiveListTabResortAbility$updateRequestCategoryName$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Long r2 = Boxing.boxLong(System.currentTimeMillis());
        this.this$0.c();
        FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r3 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new c1(new LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1(kotlinx.coroutines.flow.e.w(new kotlinx.coroutines.flow.n(TuplesKt.to(r2, null)), Dispatchers.getIO()), null, this)), new AnonymousClass2(null));
        a r4 = new a(this, r7);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
