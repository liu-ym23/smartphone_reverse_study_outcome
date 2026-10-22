package com.suite.lark.component.navroute.forseti;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.suite.lark.component.navroute.api.NavRouteNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0012*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0003\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u001f\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/suite/lark/component/navroute/forseti/ForsetiNavigator;", "D", "Landroidx/navigation/NavDestination;", "Lcom/suite/lark/component/navroute/api/NavRouteNavigator;", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions;", "<init>", "()V", "converter", "Lcom/suite/lark/component/navroute/api/OptionsConverter;", MusicAppletPage.ROUTE_MODE_NAVIGATION, "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "(Landroidx/navigation/NavBackStackEntry;Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions;)Landroidx/navigation/NavDestination;", "navigateInternal", "navigatorExtras", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavigator$ForsetiNavExtras;", "(Landroidx/navigation/NavBackStackEntry;Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions;Lcom/suite/lark/component/navroute/forseti/ForsetiNavigator$ForsetiNavExtras;)Landroidx/navigation/NavDestination;", "Companion", "ForsetiNavExtras", "ForsetiNavExtrasBuilder", "router-forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ForsetiNavigator<D extends NavDestination> extends NavRouteNavigator<D, ForsetiNavOptions> {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B+\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/suite/lark/component/navroute/forseti/ForsetiNavigator$ForsetiNavExtras;", "Lcom/suite/lark/component/navroute/api/NavRouteNavigator$NavRouteExtras;", "targetInstance", "", "sourceFragment", "Landroidx/fragment/app/Fragment;", "sourceActivity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Ljava/lang/Object;Landroidx/fragment/app/Fragment;Landroidx/fragment/app/FragmentActivity;)V", "copyBuilder", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavigator$ForsetiNavExtrasBuilder;", "router-forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ForsetiNavExtras extends NavRouteNavigator.NavRouteExtras {
        public b b() {
            b r100 = new b();
            r100.f460250b = this.f460247b;
            r100.f460251c = this.f460248c;
            r100.f460249a = this.f460246a;
            return r100;
        }

        @Override // com.suite.lark.component.navroute.api.NavRouteNavigator.NavRouteExtras
        public /* bridge */ /* synthetic */ NavRouteNavigator.a a() {
            return b();
        }

        public ForsetiNavExtras(Object r100, Fragment r101, FragmentActivity r102) {
            super(r100, r101, r102);
        }
    }

    public static final class a {
    }

    public static class b extends NavRouteNavigator.a {
        public ForsetiNavExtras e() {
            return new ForsetiNavExtras(this.f460249a, this.f460250b, this.f460251c);
        }

        @Override // com.suite.lark.component.navroute.api.NavRouteNavigator.a
        public /* bridge */ /* synthetic */ NavRouteNavigator.NavRouteExtras a() {
            return e();
        }

        public b() {
        }

        @Override // com.suite.lark.component.navroute.api.NavRouteNavigator.a
        public /* bridge */ /* synthetic */ NavRouteNavigator.a b(FragmentActivity r100) {
            return f(r100);
        }

        @Override // com.suite.lark.component.navroute.api.NavRouteNavigator.a
        public /* bridge */ /* synthetic */ NavRouteNavigator.a c(Fragment r100) {
            return g(r100);
        }

        @Override // com.suite.lark.component.navroute.api.NavRouteNavigator.a
        public /* bridge */ /* synthetic */ NavRouteNavigator.a d(Object r100) {
            return h(r100);
        }

        public b f(FragmentActivity r100) {
            this.f460251c = r100;
            return this;
        }

        public b g(Fragment r100) {
            this.f460250b = r100;
            return this;
        }

        public b h(Object r100) {
            this.f460249a = r100;
            return this;
        }
    }

    static {
    }

    public abstract D c(NavBackStackEntry r100, ForsetiNavOptions r101, ForsetiNavExtras r102);

    public ForsetiNavigator() {
    }

    @Override // com.suite.lark.component.navroute.api.NavRouteNavigator
    public final com.suite.lark.component.navroute.api.i<ForsetiNavOptions> a() {
        return d.f460339a;
    }

    @Override // com.suite.lark.component.navroute.api.NavRouteNavigator
    public final NavDestination b(NavBackStackEntry r100, com.suite.lark.component.navroute.api.g r101) {
        ForsetiNavOptions r102 = (ForsetiNavOptions) r101;
        Intrinsics.checkNotNullParameter(r100, "entry");
        if (r102 != null) goto L5;
        ForsetiNavOptions r103 = new ForsetiNavOptions(0);
    L6:
        if (r102 == null) goto L9;
        ForsetiNavExtras r104 = r102.f460317i;
        if (r104 == null) goto L9;
    L11:
        return c(r100, r103, r104);
    L9:
        r104 = new b().e();
        goto L11
    L5:
        r103 = r102;
        goto L6
    }
}
