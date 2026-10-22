package com.suite.lark.component.navroute.navigation;

import androidx.navigation.NavDestination;
import com.suite.lark.component.navroute.api.NavRouteNavigator;
import com.suite.lark.component.navroute.api.g;
import com.suite.lark.component.navroute.api.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¨\u0006\t"}, d2 = {"Lcom/suite/lark/component/navroute/navigation/NavigationNavigator;", "D", "Landroidx/navigation/NavDestination;", "Lcom/suite/lark/component/navroute/api/NavRouteNavigator;", "Lcom/suite/lark/component/navroute/api/NavRouteOptions;", "<init>", "()V", "converter", "Lcom/suite/lark/component/navroute/api/OptionsConverter;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NavigationNavigator<D extends NavDestination> extends NavRouteNavigator<D, g> {
    public NavigationNavigator() {
    }

    @Override // com.suite.lark.component.navroute.api.NavRouteNavigator
    public final i<g> a() {
        return a.f460394a;
    }
}
