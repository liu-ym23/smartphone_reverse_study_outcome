package com.bytedance.applet.impl;

import com.bytedance.applet.event.EventDispatcher;
import com.bytedance.applet.event.LocalPluginService;
import com.bytedance.applet.provider.impl.AppletLaneInitializer;
import com.larus.audio.AudioServiceDelegate;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class j1 implements Function0 {
    public /* synthetic */ j1() {
    }

    public final Object invoke() {
        int r0 = MainlandAppletServiceImpl.d;
        AtomicReference<AppletLaneInitializer.Phase> r1 = AppletLaneInitializer.a;
        if (jw3.c.b.get() == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L22;
        if (AppletLaneInitializer.c.compareAndSet(false, true) == false) goto L11;
        LocalPluginService r3 = LocalPluginService.a;
        LocalPluginService.e();
    L11:
        if (AppletLaneInitializer.d.compareAndSet(false, true) == false) goto L17;
        LocalPluginService.a r4 = EventDispatcher.a;
        if (EventDispatcher.i.compareAndSet(false, true) == false) goto L17;
        LocalPluginService r5 = LocalPluginService.a;
        Intrinsics.checkNotNullParameter(r4, "listener");
        LocalPluginService.h.add(r4);
        com.larus.im.d.e().registerOnGlobalMessageObserver(r4);
        AudioServiceDelegate.a.r0().m(EventDispatcher.d);
    L17:
        if (AppletLaneInitializer.e.compareAndSet(false, true) == false) goto L20;
        EventDispatcher r6 = EventDispatcher.a;
        com.bytedance.applet.event.e r7 = com.bytedance.applet.event.e.a;
        Intrinsics.checkNotNullParameter(r7, "listener");
        EventDispatcher.g.add(r7);
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("provider must be installed before applet facade lane-owned registration".toString());
    L5:
        r2 = false;
        goto L6
    }
}
