package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxElementImpl$__consumeGesture$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $gestureId;
    final /* synthetic */ Map<String, Object> $params;
    final /* synthetic */ RxElementImpl this$0;

    public RxElementImpl$__consumeGesture$1(RxElementImpl r100, int r101, Map<String, Object> r102) {
        this.this$0 = r100;
        this.$gestureId = r101;
        this.$params = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        long r100 = this.this$0.E();
        int r101 = this.$gestureId;
        Map<String, Object> r102 = this.$params;
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().g(r100, r101, r102);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
