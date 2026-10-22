package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "_ele", "", "_elementId", "sign", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RenderFnRenderer$createList$enqueueComponentCallback$1 extends Lambda implements Function3<Long, Long, Long, Unit> {
    final /* synthetic */ Function1<Long, Unit> $enqueueComponent;

    /* JADX WARN: Multi-variable type inference failed */
    public RenderFnRenderer$createList$enqueueComponentCallback$1(Function1<? super Long, Unit> r100) {
        this.$enqueueComponent = r100;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long r100, Long r101, Long r110) {
        invoke(r100.longValue(), r101.longValue(), r110.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long r100, long r101, long r102) {
        this.$enqueueComponent.invoke(Long.valueOf(r102));
    }
}
