package com.bytedance.locallife.dito.event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static void a(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == true) goto L9;
        EventBus.getDefault().register(r100);     // Catch: EventBusException -> L6
        return;
    L10:
        return;
    }

    public static void b(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == false) goto L6;
        EventBus.getDefault().unregister(r100);
        return;
    }
}
