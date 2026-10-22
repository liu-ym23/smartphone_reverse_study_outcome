package com.suite.lark.component.navroute.navigation;

import android.os.Bundle;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.suite.lark.component.navroute.api.NavRouteNavigator;
import com.suite.lark.component.navroute.api.g;
import com.suite.lark.component.navroute.api.i;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements i<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f460394a = null;

    static {
        f460394a = new a();
    }

    public a() {
    }

    @Override // com.suite.lark.component.navroute.api.i
    public final g a(i.a r110) {
        g.b r100 = new g.b();
        NavOptions r101 = r110.f460273b;
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.shouldLaunchSingleTop();
    L6:
        r100.f460267a = r103;
        NavOptions r104 = r110.f460273b;
        NavRouteNavigator.NavRouteExtras r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.getPopUpToRoute();
    L10:
        NavOptions r107 = r110.f460273b;
        if (r107 == null) goto L13;
        r102 = r107.isPopUpToInclusive();
    L13:
        r100.f460268b = r106;
        r100.f460269c = r102;
        NavOptions r108 = r110.f460273b;
        if (r108 == null) goto L16;
        r108.shouldRestoreState();
    L16:
        Navigator.Extras r109 = r110.f460274c;
        if ((r109 instanceof NavRouteNavigator.NavRouteExtras) == false) goto L19;
        r105 = (NavRouteNavigator.NavRouteExtras) r109;
    L19:
        r100.f460271e = r105;
        NavOptions r111 = r110.f460273b;
        int r112 = -1;
        if (r111 == null) goto L22;
        int r113 = r111.getEnterAnim();
    L23:
        NavOptions r114 = r110.f460273b;
        if (r114 == null) goto L26;
        int r115 = r114.getExitAnim();
    L27:
        NavOptions r116 = r110.f460273b;
        if (r116 == null) goto L30;
        int r117 = r116.getPopEnterAnim();
    L31:
        NavOptions r118 = r110.f460273b;
        if (r118 == null) goto L34;
        r112 = r118.getPopExitAnim();
    L34:
        g.a r119 = new g.a(r113, r115, r117, r112);
        r100.f460270d = r119;
        return new g(false, r100.f460267a, r100.f460268b, r100.f460269c, r119, r100.f460271e);
    L30:
        r117 = -1;
        goto L31
    L26:
        r115 = -1;
        goto L27
    L22:
        r113 = -1;
        goto L23
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.suite.lark.component.navroute.api.i
    public final i.a b(g r110) {
        if (r110 == null) goto L19;
        Bundle r100 = new Bundle();
        NavOptions.Builder r101 = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder().setLaunchSingleTop(r110.f460258b), r110.f460259c, r110.f460260d, false, 4, null);
        g.a r102 = r110.f460261e;
        int r103 = -1;
        if (r102 == null) goto L6;
        int r104 = r102.f460263a;
    L7:
        NavOptions.Builder r105 = r101.setEnterAnim(r104);
        g.a r106 = r110.f460261e;
        if (r106 == null) goto L10;
        int r107 = r106.f460264b;
    L11:
        NavOptions.Builder r108 = r105.setExitAnim(r107);
        g.a r109 = r110.f460261e;
        if (r109 == null) goto L14;
        int r111 = r109.f460265c;
    L15:
        NavOptions.Builder r112 = r108.setPopEnterAnim(r111);
        g.a r113 = r110.f460261e;
        if (r113 == null) goto L21;
        r103 = r113.f460266d;
    L21:
        return new i.a(r100, r112.setPopExitAnim(r103).build(), r110.a());
    L14:
        r111 = -1;
        goto L15
    L10:
        r107 = -1;
        goto L11
    L6:
        r104 = -1;
        goto L7
    L19:
        return null;
    }
}
