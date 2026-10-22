package com.obric.assistant.reporter.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.ai.api.AppletExtService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricReporter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public b() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (AppHost.f326268a.a().isAppBackground() == false) goto L28;
        IObricReporter.f391335a.getClass();
        IObricReporter r101 = IObricReporter.a.a();
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.a();
    L9:
        if (Intrinsics.areEqual(r103, "click_desktop_icon") == false) goto L29;
        Lazy r104 = c.f391443a;
        AppletExtService r105 = (AppletExtService) r104.getValue();
        if (r105 == null) goto L15;
        boolean r106 = true;
        if (r105.o(r100) != true) goto L15;
    L16:
        if (r106 == false) goto L30;
        AppletExtService r107 = (AppletExtService) r104.getValue();
        if (r107 == null) goto L20;
        r102 = r107.g(r100);
    L20:
        if (r102 != null) goto L22;
        r102 = "";
    L22:
        FLogger.f375446a.i("MiniAppRectifyLaunchReportManager", "minAppId = ".concat(r102));
        if (Intrinsics.areEqual(r102, "com.flow.calendar") == false) goto L31;
        IObricReporter r108 = IObricReporter.a.a();
        if (r108 == null) goto L32;
        r108.n("mini_app", "mini_app_calendar", false);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L15:
        r106 = false;
        goto L16
    L29:
        return;
    L7:
        r103 = null;
        goto L9
    }
}
