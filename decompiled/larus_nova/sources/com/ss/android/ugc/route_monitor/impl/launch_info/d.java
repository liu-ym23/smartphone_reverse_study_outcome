package com.ss.android.ugc.route_monitor.impl.launch_info;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.t;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements jhc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f454463a = null;

    public d() {
    }

    @Override // jhc.e
    public final void b() {
    }

    @Override // jhc.e
    public final String getName() {
        return "DefaultBizLaunchModeInfoGetter";
    }

    static {
        f454463a = new d();
    }

    public static String c(Intent r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Uri r102 = r100.getData();
    L7:
        if (r102 != null) goto L9;
    L11:
        String r103 = null;
    L12:
        if (r103 != null) goto L14;
    L21:
        if (r103 != null) goto L25;
        return "";
    L25:
        return r103;
    L14:
        if (r103.length() != 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 != true) goto L21;
        if (r100 == null) goto L20;
        r101 = r100.getStringExtra(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD);
    L20:
        r103 = r101;
        goto L21
    L16:
        r104 = false;
        goto L17
    L9:
        if (r102.isHierarchical() != true) goto L11;
        r103 = UriProtector.getQueryParameter(r102, AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD);
        goto L12
    L5:
        r102 = null;
        goto L7
    }

    @Override // jhc.e
    public final ihc.d a(f r110, Activity r111) {
        RouteMonitorManager.f454384g.b().getClass();
        String r100 = r111.getPackageName();
        String r101 = r111.getClass().getName();
        Intent r102 = r111.getIntent();
        String r103 = r110.f454466b;
        String r104 = h.a(null);
        boolean r105 = false;
        if (Intrinsics.areEqual(r103, r104) == false) goto L21;
        int r112 = t.f454783a;
        if (t.a(r111.getIntent(), "mSourceBounds") != null) goto L7;
        boolean r113 = true;
    L9:
        if (r113 == false) goto L11;
        ihc.d r114 = new ihc.d("os_suggest");
        r114.f489934b = "os_suggest";
        ((ConcurrentHashMap) r114.f489935c).put("referrer", r103);
        ((ConcurrentHashMap) r114.f489935c).put("launcher_package_name", r104);
        return r114;
    L11:
        com.ss.android.ugc.route_monitor.c.a().getClass();
        if (ihc.f.h(r101) == false) goto L14;
        ihc.d r115 = new ihc.d("enter_launch");
        r115.f489934b = "enter_launch";
        ((ConcurrentHashMap) r115.f489935c).put("referrer", r103);
        ((ConcurrentHashMap) r115.f489935c).put("launcher_package_name", r104);
        return r115;
    L14:
        String r116 = c(r102);
        if (r116.length() != 0) goto L17;
        r105 = true;
    L17:
        if (r105 == false) goto L19;
        r116 = "default_".concat(r101);
    L19:
        ihc.d r117 = new ihc.d(r116);
    L38:
        return r117;
    L7:
        r113 = false;
        goto L9
    L21:
        if (r110.f454467c == false) goto L23;
    L31:
        String r118 = c(r102);
        if (r118.length() != 0) goto L34;
        r105 = true;
    L34:
        if (r105 == false) goto L36;
        r118 = "default_".concat(r101);
    L36:
        r117 = new ihc.d(r118);
        goto L38
    L23:
        if ((!Intrinsics.areEqual(r103, r100)) == true) goto L31;
        Logger r119 = Logger.f454747c;
        r119.getClass();
        com.ss.android.ugc.route_monitor.c.a().getClass();
        r119.c();
        String r120 = c(r102);
        if (r120.length() != 0) goto L28;
        r105 = true;
    L28:
        if (r105 == false) goto L30;
        r120 = "default_".concat(r101);
    L30:
        r117 = new ihc.d(r120);
        goto L38
    }
}
