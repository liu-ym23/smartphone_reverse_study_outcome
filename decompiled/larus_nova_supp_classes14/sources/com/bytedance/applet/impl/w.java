package com.bytedance.applet.impl;

import android.app.Application;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements r4.f {
    public final ConcurrentHashMap<r4.f.a, Application.ActivityLifecycleCallbacks> a;

    public w() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(r4.f.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Application.ActivityLifecycleCallbacks r3 = this.a.remove(r2);
        if (r3 == null) goto L6;
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        r0.getApplication().unregisterActivityLifecycleCallbacks(r3);
        return;
    }

    public final void b(com.bytedance.ai.applet.login.d r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        v r0 = new v(r3);
        if (this.a.putIfAbsent(r3, r0) == null) goto L5;
        return;
    L5:
        gd9.i r4 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r4);
        r4.getApplication().registerActivityLifecycleCallbacks(r0);
    }
}
