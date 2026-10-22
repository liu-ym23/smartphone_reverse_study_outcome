package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1", f = "LiveListTabResortAbility.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
public final class LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Long, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    Object L$0;
    Object L$1;
    int label;
    private FlowCollector p$;
    final /* synthetic */ LiveListTabResortAbility$updateRequestCategoryName$1 this$0;

    public static final class a implements FlowCollector<Pair<? extends Long, ? extends Map<String, ? extends String>>> {
        public final /* synthetic */ LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1 a;
        public final /* synthetic */ FlowCollector b;

        public a(LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1 r1, FlowCollector r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r9, Continuation r10) {
            FlowCollector r0 = this.b;
            Pair r11 = (Pair) r9;
            Object r1 = r11.getFirst();
            Map r12 = (Map) r11.getSecond();
            String r2 = null;
            if (r12 == null) goto L19;
            Iterator r13 = r12.entrySet().iterator();
            if (r13.hasNext() == true) goto L7;
            Object r3 = null;
        L16:
            Map.Entry r4 = (Map.Entry) r3;
            if (r4 == null) goto L19;
            r2 = (String) r4.getKey();
            goto L19
        L7:
            r3 = r13.next();
            if (r13.hasNext() == false) goto L16;
            float r5 = CastFloatProtector.parseFloat((String) ((Map.Entry) r3).getValue()) * this.a.this$0.this$0.d().a();
        L11:
            Object r6 = r13.next();
            float r7 = CastFloatProtector.parseFloat((String) ((Map.Entry) r6).getValue()) * this.a.this$0.this$0.d().a();
            if (Float.compare(r5, r7) >= 0) goto L15;
            r3 = r6;
            r5 = r7;
        L15:
            if (r13.hasNext() == true) goto L11;
        L19:
            Object r14 = r0.emit(TuplesKt.to(r1, r2), r10);
            if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
            return r14;
        L23:
            return Unit.INSTANCE;
        }
    }

    public LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1(Flow r1, Continuation r2, LiveListTabResortAbility$updateRequestCategoryName$1 r3) {
        this.$this_transform = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1 r0 = new LiveListTabResortAbility$updateRequestCategoryName$1$invokeSuspend$$inlined$transform$1(this.$this_transform, r5, this.this$0);
        r0.p$ = (FlowCollector) r4;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FlowCollector r6 = this.p$;
        Flow r2 = this.$this_transform;
        a r3 = new a(this, r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
