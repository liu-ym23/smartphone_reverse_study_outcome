package com.suite.lark.component.navroute.navigation.fragment;

import com.suite.lark.component.navroute.api.BaseNavRouteHost;
import com.suite.lark.component.navroute.fragment.BaseNavRouteHostFragment;
import com.suite.lark.component.navroute.navigation.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/suite/lark/component/navroute/navigation/fragment/NavigationHostFragment;", "Lcom/suite/lark/component/navroute/fragment/BaseNavRouteHostFragment;", "Lcom/suite/lark/component/navroute/navigation/NavigationRouter;", "<init>", "()V", "navHostDelegate", "Lcom/suite/lark/component/navroute/api/BaseNavRouteHost;", "getNavHostDelegate", "()Lcom/suite/lark/component/navroute/api/BaseNavRouteHost;", "navHostDelegate$delegate", "Lkotlin/Lazy;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationHostFragment extends BaseNavRouteHostFragment<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f460414f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f460415e;

    @Override // com.suite.lark.component.navroute.fragment.BaseNavRouteHostFragment
    public final BaseNavRouteHost<c> S90() {
        return (BaseNavRouteHost) this.f460415e.getValue();
    }

    public NavigationHostFragment() {
        this.f460415e = LazyKt.lazy(new NavigationHostFragment$navHostDelegate$2(this));
    }
}
