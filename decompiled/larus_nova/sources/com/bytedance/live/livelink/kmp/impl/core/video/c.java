package com.bytedance.live.livelink.kmp.impl.core.video;

import com.bytedance.android.livesdk.live.extension.plugin.api.realx.ILiveWrappedRealX;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.base.video.Status;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends g {

    public static final class a {
    }

    static {
    }

    public final void v() {
        ej6.a.c("Video_AndroidVideoSubscribeManager", "init call");
        mj6.b r100 = new mj6.b(this.f255469l);
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.process.f r101 = new com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.process.f(this.f255469l);
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.output.a r102 = new com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.output.a(this.f255469l);
        this.f255458a.d(r100, new ArrayList(), new ArrayList());
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c r103 = this.f255458a;
        ArrayList r104 = new ArrayList();
        r104.add(r100);
        Unit r105 = Unit.INSTANCE;
        r103.d(r101, r104, new ArrayList());
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c r106 = this.f255458a;
        ArrayList r107 = new ArrayList();
        r107.add(r101);
        r106.d(r102, r107, new ArrayList());
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c r108 = this.f255458a;
        r108.getClass();
        r108.f255490d = Status.READY;
        Iterator<qi6.f> r109 = r108.f255489c.iterator();
    L4:
        if (r109.hasNext() == false) goto L6;
        r109.next().init();
        goto L4
    L6:
        this.f255458a.i("Video_VideoSubscribeManager");
        this.f255458a.h("Video_VideoSubscribeManager");
        Set<String> r110 = this.f255459b;
        gi6.e r111 = this.f255469l.getEventManager();
        String r112 = null;
        if (r111 == null) goto L9;
        String r113 = r111.a(EventCategory.RTC_MIXER_EVENT, null, new CommonVideoSubscribeManager$init$3(this));
    L10:
        r110.add(r113);
        Set<String> r114 = this.f255459b;
        gi6.e r115 = this.f255469l.getEventManager();
        if (r115 == null) goto L13;
        r112 = r115.a(EventCategory.RTC_ROOM_EVENT_EX, null, new CommonVideoSubscribeManager$init$4(this));
    L13:
        r114.add(r112);
        return;
    L9:
        r113 = null;
        goto L10
    }

    public final void w() {
        int r100 = ej6.e.f472877a;
        ej6.e.a(TraceEvent.VIDEO_MANAGER, "VideoSubscribeManager#release", 0, null, null, 28);
        this.f255458a.j();
        Iterator<T> r101 = this.f255459b.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();
        if (r102 == null) goto L4;
        gi6.e r103 = this.f255469l.getEventManager();
        if (r103 == null) goto L4;
        r103.c(r102);
        goto L4
    L10:
        this.f255459b.clear();
    }

    public final void x() {
        ej6.a.c("Video_AndroidVideoSubscribeManager", "start call");
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c r100 = this.f255458a;
        r100.getClass();
        r100.f255490d = Status.STARTED;
        Iterator<qi6.f> r101 = r100.f255489c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().i();
        goto L4
    L6:
        fi6.a r102 = this.f255469l.g();
        if (r102 != null) goto L9;
    L13:
        fi6.a r103 = this.f255469l.g();
        if (r103 != null) goto L16;
    L20:
        fi6.a r104 = this.f255469l.g();
        MixStreamType r105 = null;
        if (r104 == null) goto L23;
        Character r106 = r104.D;
    L25:
        if (r106 != Character.ANCHOR) goto L34;
        fi6.a r107 = this.f255469l.g();
        if (r107 == null) goto L30;
        r105 = r107.U;
    L30:
        if (r105 != MixStreamType.RTC_CLIENT_MIX) goto L35;
        c();
        return;
    L35:
        return;
    L34:
        return;
    L23:
        r106 = null;
        goto L25
    L16:
        if (r103.f477374b != true) goto L20;
        ILiveWrappedRealX.Companion.getClass();
        ILiveWrappedRealX r108 = (ILiveWrappedRealX) va1.b.a.f553922a.a(ILiveWrappedRealX.class);
        if (r108 == null) goto L20;
        r108.getThreadUtils();
        goto L20
    L9:
        if (r102.f477372a != true) goto L13;
        ILiveWrappedRealX.Companion.getClass();
        ILiveWrappedRealX r109 = (ILiveWrappedRealX) va1.b.a.f553922a.a(ILiveWrappedRealX.class);
        if (r109 == null) goto L13;
        r109.getThreadUtils();
        goto L13
    }

    public final void y() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "stop call subscribeVideoSinkMap size=" + this.f255463f.size());
        int r101 = ej6.e.f472877a;
        ej6.e.a(TraceEvent.VIDEO_MANAGER, "VideoSubscribeManager#stop", 0, "subscribeVideoSinkMap size=" + this.f255463f.size(), null, 20);
        com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c r102 = this.f255458a;
        r102.getClass();
        r102.f255490d = Status.STOPPED;
        Iterator<qi6.f> r103 = r102.f255489c.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().stop();
        goto L4
    L6:
        Iterator<Map.Entry<String, lj6.b>> r104 = this.f255463f.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().getValue().b();
        goto L8
    L10:
        this.f255463f.clear();
    }

    public c(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        super(r100);
    }
}
