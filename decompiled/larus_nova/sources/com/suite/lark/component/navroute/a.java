package com.suite.lark.component.navroute;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import com.ss.android.lark.log.Log;
import com.suite.lark.component.navroute.activity.AppNavRouteHost;
import com.suite.lark.component.navroute.api.BaseNavRouteHost$onCreate$1;
import com.suite.lark.component.navroute.api.NavRouteNavigator;
import com.suite.lark.component.navroute.api.g;
import com.suite.lark.component.navroute.api.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f460213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f460214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NavController f460215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<? extends g> f460216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<qnc.g> f460217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f460218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<ync.a<qnc.g>> f460219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.suite.lark.component.navroute.api.d f460220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.suite.lark.component.navroute.d f460221i;

    /* JADX INFO: renamed from: com.suite.lark.component.navroute.a$a, reason: collision with other inner class name */
    public static final class C5519a {
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f460222a = null;

        static {
            f460222a = new b();
        }

        public b() {
        }

        @Override // com.suite.lark.component.navroute.a.c
        public final void b() {
        }

        @Override // com.suite.lark.component.navroute.a.c
        public final boolean a(com.suite.lark.component.navroute.api.b<?> r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
            return true;
        }
    }

    public interface c {
        boolean a(com.suite.lark.component.navroute.api.b<?> r100);

        void b();
    }

    public interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5520a f460223a = null;

        /* JADX INFO: renamed from: com.suite.lark.component.navroute.a$d$a, reason: collision with other inner class name */
        public static final class C5520a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ C5520a f460224a = null;

            static {
                f460224a = new C5520a();
            }

            public C5520a() {
            }
        }

        static {
            f460223a = C5520a.f460224a;
        }

        e getPriority();
    }

    public static final class e implements Comparable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle.State f460225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f460226b;

        @Override // java.lang.Comparable
        public final int compareTo(e r100) {
            e r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "other");
            if (r101.f460225a.ordinal() != this.f460225a.ordinal()) goto L6;
            return Intrinsics.compare(this.f460226b, r101.f460226b);
        L6:
            return Intrinsics.compare(this.f460225a.ordinal(), r101.f460225a.ordinal());
        }

        public e(Lifecycle.State r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "currentState");
            this.f460225a = r100;
            this.f460226b = r101;
        }
    }

    static {
    }

    public final com.suite.lark.component.navroute.api.d b() {
        com.suite.lark.component.navroute.api.d r100 = this.f460220h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("nav graph has not set");
    }

    public final String c() {
        String r100 = this.f460214b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return String.valueOf(hashCode());
    L12:
        return this.f460214b;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String toString() {
        return "NavRouteController(name=" + this.f460214b + ", hash=" + hashCode() + ")})";
    }

    public final void a(NavRouteNavigator<? extends NavDestination, ? extends g> r100) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        Navigator<? extends NavDestination> r101 = this.f460215c.getNavigatorProvider().addNavigator(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof ActivityNavigator) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("navigator with same name is already existed:\n new: " + r100.getClass() + "\n last:" + r101.getClass());
    }

    public final boolean d(qnc.e r100, qnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "request");
        com.suite.lark.component.navroute.d r102 = this.f460221i;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "request");
        String r103 = com.suite.lark.component.navroute.d.f460280b;
        Log.i(r103, "goBack start, source:" + r100.toString() + " request:" + r101.toString());
        boolean r104 = r102.a().b(r100, r101);
        Log.i(r103, "goBack end, source:" + r100.toString() + " result:" + r104);
        return r104;
    }

    public final void e(qnc.e r100, qnc.b r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "request");
        com.suite.lark.component.navroute.d r102 = this.f460221i;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "request");
        String r103 = com.suite.lark.component.navroute.d.f460280b;
        Log.i(r103, "navigate start, requestId=" + r101.hashCode() + " source:" + r100.toString() + " request:" + r101.toString());
        r102.a().a(r100, r101);
        StringBuilder r104 = new StringBuilder("navigate end, requestId=");
        r104.append(r101.hashCode());
        Log.i(r103, r104.toString());
    }

    public a(Context r100, String r101, BaseNavRouteHost$onCreate$1 r110, List r111) {
        com.suite.lark.component.navroute.navigation.a r102 = com.suite.lark.component.navroute.navigation.a.f460394a;
        d.f460223a.getClass();
        this(r100, r101, r110, r102, r111, new com.suite.lark.component.navroute.b());
    }

    public a(Context r100, String r101, BaseNavRouteHost$onCreate$1 r102, i r110, List r111, d r112) {
        Intrinsics.checkNotNullParameter(r100, "hostContext");
        Intrinsics.checkNotNullParameter(r102, "navController");
        Intrinsics.checkNotNullParameter(r110, "optionsConverter");
        Intrinsics.checkNotNullParameter(r111, "buildInInterceptors");
        Intrinsics.checkNotNullParameter(r112, "priorityProvider");
        this.f460213a = r100;
        this.f460214b = r101;
        this.f460215c = r102;
        this.f460216d = r110;
        this.f460217e = r111;
        this.f460218f = r112;
        List r113 = r111;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r104 = r113.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(new ync.a((qnc.g) r104.next()));
        goto L4
    L6:
        ync.a[] r105 = (ync.a[]) r103.toArray(new ync.a[0]);
        this.f460219g = SetsKt.mutableSetOf(Arrays.copyOf(r105, r105.length));
        this.f460221i = new com.suite.lark.component.navroute.d(this);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NavRouteController$1(this, null), 3, null);
    }

    public static void f(a r100, com.suite.lark.component.navroute.api.d r101, String r102, Bundle r103, AppNavRouteHost.b r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = null;
    L8:
        c r106 = r104;
        if ((r105 & 8) == 0) goto L11;
        r106 = b.f460222a;
    L11:
        Intrinsics.checkNotNullParameter(r101, "graph");
        Intrinsics.checkNotNullParameter(r106, "filter");
        NavController r107 = r100.f460215c;
        r100.f460220h = r101;
        if (r102 != null) goto L14;
        r102 = r101.getStart();
    L14:
        NavGraphBuilder r108 = new NavGraphBuilder(r107.getNavigatorProvider(), r102, r101.getRoute());
        Iterator<T> r109 = r101.b().iterator();
    L16:
        if (r109.hasNext() == false) goto L20;
        com.suite.lark.component.navroute.api.b<?> r110 = (com.suite.lark.component.navroute.api.b) r109.next();
        if (r106.a(r110) == false) goto L16;
        r110.c(r108, r110);
        goto L16
    L20:
        r106.b();
        r107.setGraph(r108.build(), r103);
    }
}
