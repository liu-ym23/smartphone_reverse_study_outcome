package com.bytedance.applet.task;

import android.app.Activity;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements gd9.a {
    public x() {
    }

    public final void onCreate(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onPreDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Object r0 = NavigationMultitaskCard.f;
        monitor-enter(r0);
        NavigationMultitaskCard.a r1 = NavigationMultitaskCard.g;     // Catch: Throwable -> L19
        if (r1.b == false) goto L16;
        NavigationMultitaskCard r2 = NavigationMultitaskCard.a;     // Catch: Throwable -> L19
        AppletApplication r3 = r1.a();     // Catch: Throwable -> L19
        r2.getClass();     // Catch: Throwable -> L19
        if (r5 == null) goto L13;
        if (r3 == null) goto L10;
        AppletAppActivity r4 = r3.d;     // Catch: Throwable -> L19
    L11:
        if (r5 == r4) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        NavigationMultitaskCard.g = new NavigationMultitaskCard.a(r1.a, false);     // Catch: Throwable -> L19
        goto L16
    L10:
        r4 = null;
    L13:
        r6 = false;
    L16:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void onStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }
}
