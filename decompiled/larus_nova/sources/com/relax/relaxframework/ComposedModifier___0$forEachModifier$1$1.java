package com.relax.relaxframework;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/relax/relaxframework/p6;", MapController.ITEM_LAYER_TAG, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/p6;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class ComposedModifier___0$forEachModifier$1$1 extends Lambda implements Function1<p6, Unit> {
    final /* synthetic */ Function1<p6, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public ComposedModifier___0$forEachModifier$1$1(Function1<? super p6, Unit> r100) {
        this.$action = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p6 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.$action.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p6 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
