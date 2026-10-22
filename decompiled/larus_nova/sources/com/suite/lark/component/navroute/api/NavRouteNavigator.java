package com.suite.lark.component.navroute.api;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.suite.lark.component.navroute.api.g;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tH&J!\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u000eJ*\u0010\n\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J&\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u0017"}, d2 = {"Lcom/suite/lark/component/navroute/api/NavRouteNavigator;", "D", "Landroidx/navigation/NavDestination;", "Option", "Lcom/suite/lark/component/navroute/api/NavRouteOptions;", "Landroidx/navigation/Navigator;", "<init>", "()V", "converter", "Lcom/suite/lark/component/navroute/api/OptionsConverter;", MusicAppletPage.ROUTE_MODE_NAVIGATION, "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "(Landroidx/navigation/NavBackStackEntry;Lcom/suite/lark/component/navroute/api/NavRouteOptions;)Landroidx/navigation/NavDestination;", "", "entries", "", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "NavRouteExtras", "NavRouteExtrasBuilder", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NavRouteNavigator<D extends NavDestination, Option extends g> extends Navigator<D> {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/suite/lark/component/navroute/api/NavRouteNavigator$NavRouteExtras;", "Landroidx/navigation/Navigator$Extras;", "targetInstance", "", "sourceFragment", "Landroidx/fragment/app/Fragment;", "sourceActivity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Ljava/lang/Object;Landroidx/fragment/app/Fragment;Landroidx/fragment/app/FragmentActivity;)V", "getTargetInstance", "()Ljava/lang/Object;", "getSourceFragment", "()Landroidx/fragment/app/Fragment;", "setSourceFragment", "(Landroidx/fragment/app/Fragment;)V", "getSourceActivity", "()Landroidx/fragment/app/FragmentActivity;", "setSourceActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "copyBuilder", "Lcom/suite/lark/component/navroute/api/NavRouteNavigator$NavRouteExtrasBuilder;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class NavRouteExtras implements Navigator.Extras {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f460246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Fragment f460247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FragmentActivity f460248c;

        public a a() {
            a r100 = new a();
            r100.f460250b = this.f460247b;
            r100.f460251c = this.f460248c;
            return r100;
        }

        public NavRouteExtras(Object r100, Fragment r101, FragmentActivity r102) {
            this.f460246a = r100;
            this.f460247b = r101;
            this.f460248c = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f460249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f460250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FragmentActivity f460251c;

        public a() {
        }

        public NavRouteExtras a() {
            return new NavRouteExtras(this.f460249a, this.f460250b, this.f460251c);
        }

        public a b(FragmentActivity r100) {
            this.f460251c = r100;
            return this;
        }

        public a c(Fragment r100) {
            this.f460250b = r100;
            return this;
        }

        public a d(Object r100) {
            this.f460249a = r100;
            return this;
        }
    }

    public abstract i<Option> a();

    public abstract D b(NavBackStackEntry r100, Option r101);

    public NavRouteNavigator() {
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List<NavBackStackEntry> r100, final NavOptions r101, final Navigator.Extras r102) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        Iterator r103 = SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(r100), new AnonymousClass1(this, r101, r102))).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        NavBackStackEntry r104 = (NavBackStackEntry) r103.next();
        getState().push(r104);
        goto L4
    }
}
