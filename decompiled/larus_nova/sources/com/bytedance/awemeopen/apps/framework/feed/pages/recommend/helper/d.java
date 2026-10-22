package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.event.AutoPlayAction;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    static {
    }

    public static void a() {
        LiveDataBus r100 = LiveDataBus.f196946c;
        LiveDataBus.a.b(new gz3.a(AutoPlayAction.REOPEN_AUTOPLAY));
    }

    public static void b() {
        LiveDataBus r100 = LiveDataBus.f196946c;
        LiveDataBus.a.b(new gz3.a(AutoPlayAction.STOP_AUTOPLAY));
    }

    public static void c() {
        LiveDataBus r100 = LiveDataBus.f196946c;
        LiveDataBus.a.b(new gz3.a(AutoPlayAction.TRY_STOP_AUTOPLAY));
    }
}
