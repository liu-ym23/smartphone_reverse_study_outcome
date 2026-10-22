package com.suite.lark.component.navroute.forseti;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.suite.lark.component.navroute.NavRouter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/suite/lark/component/navroute/group/NavRouteHostManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AutoCrossActivityInterceptor$navHostManager$2 extends Lambda implements Function0<com.suite.lark.component.navroute.group.c> {
    public static final AutoCrossActivityInterceptor$navHostManager$2 INSTANCE = null;

    static {
        INSTANCE = new AutoCrossActivityInterceptor$navHostManager$2();
    }

    public AutoCrossActivityInterceptor$navHostManager$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final com.suite.lark.component.navroute.group.c invoke() {
        NavRouter.a r100 = NavRouter.f460191a;
        return NavRouter.f460195e;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ com.suite.lark.component.navroute.group.c invoke() {
        return invoke();
    }
}
