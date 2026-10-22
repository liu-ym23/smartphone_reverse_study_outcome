package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/relax/relaxframework/v1;", "value", "Lcom/relax/relaxframework/CSSModifierProperty;", "key", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/v1;Lcom/relax/relaxframework/CSSModifierProperty;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class ComputedStyle$forEachProperties$1 extends Lambda implements Function2<v1, CSSModifierProperty, Unit> {
    final /* synthetic */ Function2<CSSModifierProperty, v1, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public ComputedStyle$forEachProperties$1(Function2<? super CSSModifierProperty, ? super v1, Unit> r100) {
        this.$action = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(v1 r100, CSSModifierProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.$action.invoke(r101, r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(v1 r100, CSSModifierProperty r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
