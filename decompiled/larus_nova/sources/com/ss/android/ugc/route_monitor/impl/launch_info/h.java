package com.ss.android.ugc.route_monitor.impl.launch_info;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.j;
import ihc.p;
import jhc.i;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f454476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f454477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f454478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f454479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j<i> f454480e = null;

    public static final class a implements j.a<i> {
        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((i) r100);
        }

        public void call(i r100) {
            r100.c();
        }

        public a(f r100, f r101) {
        }
    }

    static {
        p r100 = p.f489954g;
        f454478c = "";
        f454479d = "";
        f454480e = new j();
    }

    public static String a(Context r100) {
        if (r100 != null) goto L6;
        r100 = RouteMonitorManager.f454384g.a();
    L6:
        if (StringsKt.isBlank(f454478c) == false) goto L15;
        Intent r101 = new Intent("android.intent.action.MAIN");
        r101.addCategory("android.intent.category.HOME");
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 65536);
        if (r102 == null) goto L12;
        ActivityInfo r103 = r102.activityInfo;
        if (r103 == null) goto L12;
        String r104 = r103.packageName;
    L13:
        f454478c = r104;
    L12:
        r104 = "";
    L15:
        return f454478c;
    }

    public static String b(Context r100) {
        if (r100 != null) goto L6;
        r100 = RouteMonitorManager.f454384g.a();
    L6:
        if (f454479d.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L16;
        String r102 = r100.getPackageName();
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        f454479d = r102;
    L16:
        return f454479d;
    L8:
        r101 = false;
        goto L9
    }

    public static void c(f r100) {
        boolean r101 = r100.f454467c;
        if (r101 == false) goto L5;
    L7:
        p r102 = r100.f454465a;
        String r103 = r100.f454466b;
        f454476a = r101;
        f r104 = f454477b;
        f454480e.b(new a(r104, r100));
        f454477b = r100;
        Logger.f454747c.b();
        return;
    L5:
        if (Intrinsics.areEqual(r100.f454465a, p.f489953f) == false) goto L7;
    }
}
