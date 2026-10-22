package com.ss.android.ugc.route_monitor.impl.route_in;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class h extends com.ss.android.ugc.route_monitor.utils.a {
    public h() {
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Iterator r101 = ((ArrayList) t.c()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        u r102 = (u) r101.next();
        if (r102.f454574n == true) goto L4;
        r102.f454581u.a(r100, "onDestroyed");
        goto L4
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Iterator r101 = ((ArrayList) t.c()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        u r102 = (u) r101.next();
        if (r102.f454574n == true) goto L4;
        r102.f454581u.a(r100, "onPaused");
        goto L4
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Iterator r101 = ((ArrayList) t.c()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        u r102 = (u) r101.next();
        if (r102.f454574n == true) goto L4;
        r102.f454581u.a(r100, "onResumed");
        goto L4
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Iterator r101 = ((ArrayList) t.c()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        u r102 = (u) r101.next();
        if (r102.f454574n == true) goto L4;
        r102.f454581u.a(r100, "onStarted");
        goto L4
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Iterator r101 = ((ArrayList) t.c()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        u r102 = (u) r101.next();
        if (r102.f454574n == true) goto L4;
        r102.f454581u.a(r100, "onStopped");
        goto L4
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Iterator r102 = ((ArrayList) t.c()).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        u r103 = (u) r102.next();
        if (r103.f454574n == true) goto L4;
        r103.f454581u.a(r100, "onCreated");
        goto L4
    }
}
