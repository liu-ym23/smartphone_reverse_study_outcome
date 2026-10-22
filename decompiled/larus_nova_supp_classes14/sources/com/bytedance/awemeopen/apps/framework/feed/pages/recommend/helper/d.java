package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.event.AutoPlayAction;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    static {
    }

    public static void a() {
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new gz3.a(AutoPlayAction.REOPEN_AUTOPLAY));
    }

    public static void b() {
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new gz3.a(AutoPlayAction.STOP_AUTOPLAY));
    }

    public static void c() {
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new gz3.a(AutoPlayAction.TRY_STOP_AUTOPLAY));
    }
}
