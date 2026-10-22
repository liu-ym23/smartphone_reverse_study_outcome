package com.suite.lark.component.navroute.forseti.ui;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.suite.lark.component.navroute.NavRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class NavRouteUI$setupWithTabPage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $autoSwitchTabInterceptor;

    public NavRouteUI$setupWithTabPage$1(a r100) {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NavRouter.a r100 = NavRouter.f460191a;
        Intrinsics.checkNotNullParameter(null, "interceptor");
        NavRouter.f460193c.remove(new ync.a(null));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
