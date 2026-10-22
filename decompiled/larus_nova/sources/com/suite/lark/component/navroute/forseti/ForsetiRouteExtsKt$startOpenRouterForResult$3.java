package com.suite.lark.component.navroute.forseti;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions$Builder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ForsetiRouteExtsKt$startOpenRouterForResult$3 extends Lambda implements Function1<ForsetiNavOptions.a, Unit> {
    final /* synthetic */ ForsetiNavOptions $navRouteOptions;
    final /* synthetic */ int $requestCode;

    public ForsetiRouteExtsKt$startOpenRouterForResult$3(ForsetiNavOptions r100, int r101) {
        this.$navRouteOptions = r100;
        this.$requestCode = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ForsetiNavOptions.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$navigate");
        ForsetiNavOptions r101 = this.$navRouteOptions;
        int r102 = this.$requestCode;
        r100.f460327f = r101.f460261e;
        r100.f460322a = r101.f460258b;
        r100.f460323b = r101.f460259c;
        r100.f460324c = r101.f460260d;
        r100.c(r101.f460316h);
        r100.f460325d = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ForsetiNavOptions.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
