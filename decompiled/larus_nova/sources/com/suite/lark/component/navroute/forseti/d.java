package com.suite.lark.component.navroute.forseti;

import android.os.Bundle;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements com.suite.lark.component.navroute.api.i<ForsetiNavOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f460339a = null;

    static {
        f460339a = new d();
    }

    public d() {
    }

    @Override // com.suite.lark.component.navroute.api.i
    public final com.suite.lark.component.navroute.api.g a(com.suite.lark.component.navroute.api.i.a r100) {
        ForsetiNavOptions.a r101 = new ForsetiNavOptions.a();
        NavOptions r102 = r100.f460273b;
        boolean r103 = false;
        if (r102 == null) goto L5;
        boolean r104 = r102.shouldLaunchSingleTop();
    L6:
        r101.f460322a = r104;
        Bundle r105 = r100.f460272a;
        ForsetiNavigator.ForsetiNavExtras r106 = null;
        if (r105 == null) goto L9;
        String r107 = r105.getString("navroute_options_clear_top");
    L10:
        Bundle r108 = r100.f460272a;
        if (r108 == null) goto L13;
        boolean r109 = r108.getBoolean("navroute_options_inclusive", false);
    L14:
        r101.f460323b = r107;
        r101.f460324c = r109;
        Navigator.Extras r110 = r100.f460274c;
        if ((r110 instanceof ForsetiNavigator.ForsetiNavExtras) == false) goto L17;
        r106 = (ForsetiNavigator.ForsetiNavExtras) r110;
    L17:
        r101.f460329h = r106;
        Bundle r111 = r100.f460272a;
        if (r111 == null) goto L21;
        String r112 = r111.getString("navroute_options_style");
        if (r112 == null) goto L21;
    L22:
        r101.c(ForsetiNavOptions.DestinationStyle.valueOf(r112));
        Bundle r113 = r100.f460272a;
        int r114 = -1;
        if (r113 == null) goto L25;
        int r115 = r113.getInt("navroute_options_request_code", -1);
    L26:
        r101.f460325d = r115;
        NavOptions r116 = r100.f460273b;
        if (r116 == null) goto L29;
        int r117 = r116.getEnterAnim();
    L30:
        NavOptions r118 = r100.f460273b;
        if (r118 == null) goto L33;
        int r119 = r118.getExitAnim();
    L34:
        NavOptions r120 = r100.f460273b;
        if (r120 == null) goto L37;
        int r121 = r120.getPopEnterAnim();
    L38:
        NavOptions r122 = r100.f460273b;
        if (r122 == null) goto L41;
        r114 = r122.getPopExitAnim();
    L41:
        com.suite.lark.component.navroute.api.g.a r123 = new com.suite.lark.component.navroute.api.g.a(r117, r119, r121, r114);
        Intrinsics.checkNotNullParameter(r123, "value");
        r101.f460327f = r123;
        Bundle r124 = r100.f460272a;
        boolean r125 = true;
        if (r124 == null) goto L44;
        r125 = r124.getBoolean("navroute_options_use_forseti_animation", true);
    L44:
        r101.f460328g = r125;
        Bundle r126 = r100.f460272a;
        if (r126 == null) goto L47;
        r103 = r126.getBoolean("navroute_options_is_multi_mode_display");
    L47:
        r101.f460330i = r103;
        return r101.a();
    L37:
        r121 = -1;
        goto L38
    L33:
        r119 = -1;
        goto L34
    L29:
        r117 = -1;
        goto L30
    L25:
        r115 = -1;
    L21:
        r112 = EffectConstants.NORMAL;
        goto L22
    L13:
        r109 = false;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.suite.lark.component.navroute.api.i
    public final com.suite.lark.component.navroute.api.i.a b(com.suite.lark.component.navroute.api.g r100) {
        ForsetiNavOptions r101 = (ForsetiNavOptions) r100;
        if (r101 == null) goto L20;
        Bundle r102 = new Bundle();
        r102.putString("navroute_options_clear_top", r101.f460259c);
        r102.putBoolean("navroute_options_inclusive", r101.f460260d);
        r102.putString("navroute_options_style", r101.f460316h.name());
        r102.putInt("navroute_options_request_code", r101.f460315g);
        r102.putBoolean("navroute_options_use_forseti_animation", r101.f460318j);
        r102.putBoolean("navroute_options_is_multi_mode_display", r101.f460319k);
        NavOptions.Builder r103 = new NavOptions.Builder().setLaunchSingleTop(r101.f460258b);
        com.suite.lark.component.navroute.api.g.a r104 = r101.f460261e;
        int r105 = -1;
        if (r104 == null) goto L7;
        int r106 = r104.f460263a;
    L8:
        NavOptions.Builder r107 = r103.setEnterAnim(r106);
        com.suite.lark.component.navroute.api.g.a r108 = r101.f460261e;
        if (r108 == null) goto L11;
        int r109 = r108.f460264b;
    L12:
        NavOptions.Builder r110 = r107.setExitAnim(r109);
        com.suite.lark.component.navroute.api.g.a r111 = r101.f460261e;
        if (r111 == null) goto L15;
        int r112 = r111.f460265c;
    L16:
        NavOptions.Builder r113 = r110.setPopEnterAnim(r112);
        com.suite.lark.component.navroute.api.g.a r114 = r101.f460261e;
        if (r114 == null) goto L22;
        r105 = r114.f460266d;
    L22:
        return new com.suite.lark.component.navroute.api.i.a(r102, r113.setPopExitAnim(r105).build(), r101.f460317i);
    L15:
        r112 = -1;
        goto L16
    L11:
        r109 = -1;
        goto L12
    L7:
        r106 = -1;
        goto L8
    L20:
        return null;
    }
}
