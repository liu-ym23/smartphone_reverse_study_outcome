package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FloatingPanelService$removeCards$2 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ Function1<yoc.c, Boolean> $filter;
    final /* synthetic */ int $type;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingPanelService$removeCards$2(int r100, Function1<? super yoc.c, Boolean> r101) {
        this.$type = r100;
        this.$filter = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$runOnMain");
        int r101 = this.$type;
        Function1<yoc.c, Boolean> r102 = this.$filter;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "filter");
        r100.f460669a.j(r101, r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
