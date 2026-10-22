package com.larus.navigation.api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f359694a = null;

    static {
        f359694a = LazyKt.lazy(new s());
    }

    public static final NavigationService a() {
        return (NavigationService) f359694a.getValue();
    }

    public static final void e(NavigationService r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("new_open_navigation_map", "reason");
        if ((r100 instanceof q) == false) goto L5;
        q r101 = (q) r100;
    L6:
        if (r101 == null) goto L9;
        r101.i();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final void b(NavigationService r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        if ((r100 instanceof q) == false) goto L5;
        q r102 = (q) r100;
    L6:
        if (r102 == null) goto L9;
        r102.n(r101);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final String c(NavigationService r100, NavigationLocationPrewarmMode r101, x r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mode");
        if ((r100 instanceof q) == false) goto L5;
        q r103 = (q) r100;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.p(r101, r102);
    L5:
        r103 = null;
        goto L6
    }

    public static final void f(NavigationService r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
        if ((r100 instanceof q) == false) goto L5;
        q r103 = (q) r100;
    L6:
        if (r103 == null) goto L9;
        r103.o(r101, r102);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void d(NavigationService r100, w r101, v r102, i r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r102, "hostContext");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if ((r100 instanceof u) == false) goto L5;
        u r104 = (u) r100;
    L6:
        if (r104 != null) goto L8;
        r100.g(r101, r103);
        return;
    L8:
        r104.d(r101, r102, r103);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
