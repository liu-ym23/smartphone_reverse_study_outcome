package kotlinx.coroutines.flow.internal;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", ShareChannel.COLLECT, "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 176)
public final class SafeCollector_commonKt$unsafeFlow$1 implements Flow<Object> {
    final /* synthetic */ Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector_commonKt$unsafeFlow$1(Function2<? super FlowCollector<Object>, ? super Continuation<? super Unit>, ? extends Object> r100) {
        this.$block = r100;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Object> r100, Continuation<? super Unit> r101) {
        Object r102 = this.$block.invoke(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector<Object> r100, final Continuation<? super Unit> r101) {
        InlineMarker.mark(4);
        new SafeCollector_commonKt$unsafeFlow$1$collect$1(this, r101);
        InlineMarker.mark(5);
        this.$block.invoke(r100, r101);
        return Unit.INSTANCE;
    }
}
