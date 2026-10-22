package com.bytedance.applet.task;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements AppLifecycleCallbacks {
    public b0() {
    }

    public final void onAppAttached(AppletApplication r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
    }

    public final void onAppDestroyed(AppletApplication r6) {
        Intrinsics.checkNotNullParameter(r6, "app");
        if (Intrinsics.areEqual(r6.getAppId(), "db_1GFLTGc") == true) goto L5;
        return;
    L5:
        Object r0 = NavigationMultitaskCard.f;
        monitor-enter(r0);
        boolean r4 = false;
        if (NavigationMultitaskCard.g.a() == r6) goto L10;
        boolean r7 = false;
    L12:
        monitor-exit(r0);
        if (r7 == true) goto L15;
        return;
    L15:
        NavigationMultitaskCard.a.getClass();
        NavigationMultitaskCard.n(null);
        String r8 = NavigationMultitaskCard.d;
        if (r8 != null) goto L18;
    L19:
        r4 = true;
    L20:
        if (r4 == true) goto L28;
        NavigationMultitaskCard.m(true);
        return;
    L28:
        return;
    L18:
        if (r8.length() != 0) goto L20;
    L10:
        NavigationMultitaskCard.a.getClass();     // Catch: Throwable -> L23
        NavigationMultitaskCard.g = new NavigationMultitaskCard.a(null, false);     // Catch: Throwable -> L23
        r7 = true;
    L23:
        th = move-exception;
        throw th;
    }

    public final void onAppCreated(AppletApplication r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "app");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (Intrinsics.areEqual(r4.getAppId(), "db_1GFLTGc") == true) goto L5;
        return;
    L5:
        AppletAppManagerService.INSTANCE.getClass();
        if (AppletAppManagerService.a("db_1GFLTGc") == r4) goto L8;
        return;
    L8:
        Object r0 = NavigationMultitaskCard.f;
        monitor-enter(r0);
        NavigationMultitaskCard.a.getClass();     // Catch: Throwable -> L25
        boolean r2 = false;
        NavigationMultitaskCard.g = new NavigationMultitaskCard.a(new WeakReference(r4), false);     // Catch: Throwable -> L25
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r0);
        String r7 = NavigationMultitaskCard.d;
        if (r7 != null) goto L15;
    L16:
        r2 = true;
    L17:
        if (r2 == false) goto L20;
        return;
    L20:
        if ((r5 instanceof AppletAppActivity) == false) goto L22;
        AppletAppActivity r8 = (AppletAppActivity) r5;
    L23:
        NavigationMultitaskCard.c(r8);
        return;
    L22:
        r8 = null;
        goto L23
    L15:
        if (r7.length() != 0) goto L17;
    L25:
        th = move-exception;
        throw th;
    }

    public final void onAppDestroyView(AppletApplication r6, Context r7) {
        Intrinsics.checkNotNullParameter(r6, "app");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (Intrinsics.areEqual(r6.getAppId(), "db_1GFLTGc") == true) goto L5;
        return;
    L5:
        Object r0 = NavigationMultitaskCard.f;
        monitor-enter(r0);
        NavigationMultitaskCard.a r1 = NavigationMultitaskCard.g;     // Catch: Throwable -> L27
        boolean r3 = false;
        if (r1.a() == r6) goto L10;
        boolean r8 = false;
    L12:
        monitor-exit(r0);
        if (r8 == true) goto L15;
        return;
    L15:
        NavigationMultitaskCard r9 = NavigationMultitaskCard.a;
        if ((r7 instanceof AppletAppActivity) == false) goto L18;
        AppletAppActivity r10 = (AppletAppActivity) r7;
    L19:
        r9.getClass();
        NavigationMultitaskCard.n(r10);
        String r11 = NavigationMultitaskCard.d;
        if (r11 != null) goto L22;
    L23:
        r3 = true;
    L24:
        if (r3 == true) goto L32;
        NavigationMultitaskCard.m(true);
        return;
    L32:
        return;
    L22:
        if (r11.length() != 0) goto L24;
    L18:
        r10 = null;
        goto L19
    L10:
        NavigationMultitaskCard.g = new NavigationMultitaskCard.a(r1.a, false);     // Catch: Throwable -> L27
        r8 = true;
    L27:
        th = move-exception;
        throw th;
    }

    public final void onAppResumed(AppletApplication r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "app");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (Intrinsics.areEqual(r5.getAppId(), "db_1GFLTGc") == true) goto L5;
        return;
    L5:
        AppletAppManagerService.INSTANCE.getClass();
        if (AppletAppManagerService.a("db_1GFLTGc") == r5) goto L8;
        return;
    L8:
        Object r0 = NavigationMultitaskCard.f;
        monitor-enter(r0);
        NavigationMultitaskCard.a r1 = NavigationMultitaskCard.g;     // Catch: Throwable -> L30
        boolean r3 = true;
        if (r1.a() != r5) goto L13;
        NavigationMultitaskCard.a r2 = new NavigationMultitaskCard.a(r1.a, true);     // Catch: Throwable -> L30
    L14:
        NavigationMultitaskCard.g = r2;     // Catch: Throwable -> L30
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r0);
        String r8 = NavigationMultitaskCard.d;
        if (r8 != null) goto L19;
    L22:
        if (r3 == false) goto L24;
        return;
    L24:
        NavigationMultitaskCard r9 = NavigationMultitaskCard.a;
        if ((r6 instanceof AppletAppActivity) == false) goto L27;
        AppletAppActivity r10 = (AppletAppActivity) r6;
    L28:
        r9.getClass();
        NavigationMultitaskCard.c(r10);
        NavigationMultitaskCard.h("app_resumed");
        return;
    L27:
        r10 = null;
        goto L28
    L19:
        if (r8.length() == 0) goto L22;
        r3 = false;
        goto L22
    L13:
        NavigationMultitaskCard.a.getClass();     // Catch: Throwable -> L30
        r2 = new NavigationMultitaskCard.a(new WeakReference(r5), true);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final void onAppStopped(AppletApplication r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "app");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (Intrinsics.areEqual(r4.getAppId(), "db_1GFLTGc") == true) goto L5;
        return;
    L5:
        gd9.i r6 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r6);
        boolean r7 = r6.a().f;
        Object r0 = NavigationMultitaskCard.f;
        monitor-enter(r0);
        NavigationMultitaskCard.a r1 = NavigationMultitaskCard.g;     // Catch: Throwable -> L14
        if (r1.a() != r4) goto L11;
        if (r7 == true) goto L11;
        NavigationMultitaskCard.g = new NavigationMultitaskCard.a(r1.a, false);     // Catch: Throwable -> L14
    L11:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void onAppTaskBackground(AppletApplication r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "app");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (Intrinsics.areEqual(r4.getAppId(), "db_1GFLTGc") == false) goto L26;
        String r6 = NavigationMultitaskCard.d;
        boolean r0 = false;
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L29;
        Object r8 = NavigationMultitaskCard.f;
        monitor-enter(r8);
        if (NavigationMultitaskCard.g.a() != r4) goto L18;
        r0 = true;
    L18:
        monitor-exit(r8);
        if (r0 == true) goto L21;
        return;
    L21:
        NavigationMultitaskCard.a.getClass();
        NavigationMultitaskCard.m(true);
        com.larus.navigation.api.c.d("nav_multitask_map", "onAppTaskBackground: appId=db_1GFLTGc, show navigation card");
        return;
    L23:
        th = move-exception;
        throw th;
    L29:
        return;
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
        goto L11
    }

    public final void onAppTaskForeground(AppletApplication r1, Context r2) {
        AppLifecycleCallbacks.a.b(r1, r2);
    }
}
