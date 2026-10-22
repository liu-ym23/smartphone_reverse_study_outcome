package com.ss.android.ugc.aweme.search.utils;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes40.dex */
public class EventBusWrapper {
    public static void a(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == true) goto L6;
        EventBus.getDefault().register(r100);
        return;
    }

    public static void b(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == false) goto L6;
        EventBus.getDefault().unregister(r100);
        return;
    }
}
