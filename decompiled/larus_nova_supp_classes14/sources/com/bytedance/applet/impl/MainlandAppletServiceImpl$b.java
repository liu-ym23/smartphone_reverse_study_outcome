package com.bytedance.applet.impl;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MainlandAppletServiceImpl$b implements com.larus.platform.api.b {
    public final /* synthetic */ Function1<Integer, Unit> a;

    public MainlandAppletServiceImpl$b(i1 r1) {
        this.a = r1;
    }

    public final void a(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.invoke(1);
    }

    public final void b(com.larus.platform.api.c r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.a.invoke(0);
        AppletAppManagerService.INSTANCE.getClass();
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "clearInstalledApps");
        Iterator r4 = CollectionsKt.toList(AppletAppManagerService.a.keySet()).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = (String) r4.next();
        AppletAppManagerService r1 = AppletAppManagerService.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.getClass();
        AppletAppManagerService.f(r0);
        goto L4
    }
}
