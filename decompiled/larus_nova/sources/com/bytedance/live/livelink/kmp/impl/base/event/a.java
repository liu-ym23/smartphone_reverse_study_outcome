package com.bytedance.live.livelink.kmp.impl.base.event;

import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ii6.a f255259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f255260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f255261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f255262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f255263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ei6.a f255264f;

    /* JADX INFO: renamed from: com.bytedance.live.livelink.kmp.impl.base.event.a$a, reason: collision with other inner class name */
    public static final class C3629a {
    }

    static {
    }

    public a(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f255264f = r100;
        this.f255263e = new LinkedHashSet();
        this.f255260b = new c(r100);
        this.f255261c = new e(r100);
        this.f255262d = new g(r100);
        gi6.e r101 = r100.getEventManager();
        if (r101 == null) goto L7;
        String r102 = r101.a(EventCategory.RTC_WTN_STREAM_EVENT, null, new EventDispatcher$initEventObserver$1(this));
        if (r102 == null) goto L7;
        a(r102);
    L7:
        gi6.e r103 = r100.getEventManager();
        if (r103 == null) goto L12;
        String r104 = r103.a(EventCategory.RTC_ENGINE_EVENT, null, new EventDispatcher$initEventObserver$2(this));
        if (r104 == null) goto L12;
        a(r104);
    L12:
        gi6.e r105 = r100.getEventManager();
        if (r105 == null) goto L17;
        String r106 = r105.a(EventCategory.RTC_ENGINE_EVENT_EX, null, new EventDispatcher$initEventObserver$3(this));
        if (r106 == null) goto L17;
        a(r106);
    L17:
        gi6.e r107 = r100.getEventManager();
        if (r107 == null) goto L22;
        String r108 = r107.a(EventCategory.RTC_ROOM_EVENT, null, new EventDispatcher$initEventObserver$4(this));
        if (r108 == null) goto L22;
        a(r108);
    L22:
        gi6.e r109 = r100.getEventManager();
        if (r109 == null) goto L27;
        String r110 = r109.a(EventCategory.RTC_ROOM_EVENT_EX, null, new EventDispatcher$initEventObserver$5(this));
        if (r110 == null) goto L27;
        a(r110);
    L27:
        gi6.e r111 = r100.getEventManager();
        if (r111 == null) goto L30;
        gi6.d.a(r111, EventCategory.LINK_MANAGER, new EventDispatcher$initEventObserver$6(this));
    L30:
        gi6.e r112 = r100.getEventManager();
        if (r112 == null) goto L35;
        String r113 = r112.a(EventCategory.VIDEO_MANAGER, null, new EventDispatcher$initEventObserver$7(this));
        if (r113 == null) goto L35;
        a(r113);
    L35:
        gi6.e r114 = r100.getEventManager();
        if (r114 == null) goto L40;
        String r115 = r114.a(EventCategory.AUDIO_MANAGER, null, new EventDispatcher$initEventObserver$8(this));
        if (r115 == null) goto L40;
        a(r115);
    L40:
        gi6.e r116 = r100.getEventManager();
        if (r116 == null) goto L46;
        String r117 = r116.a(EventCategory.RTC_MIXER_EVENT, null, new EventDispatcher$initEventObserver$9(this));
        if (r117 == null) goto L47;
        a(r117);
        return;
    L47:
        return;
    }

    public final void a(String r100) {
        this.f255263e.add(r100);
    }
}
