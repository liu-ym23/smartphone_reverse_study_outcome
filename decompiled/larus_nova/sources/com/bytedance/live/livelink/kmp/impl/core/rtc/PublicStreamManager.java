package com.bytedance.live.livelink.kmp.impl.core.rtc;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.core.rtc.PublicStreamType;
import fg2.b;
import gi6.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import oi6.d;
import ui6.c;
import yf2.f;

/* JADX INFO: loaded from: classes19.dex */
public final class PublicStreamManager implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f255423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ei6.a f255424b;

    public static final class a {
    }

    static {
    }

    public final void e() {
        e r100 = this.f255424b.getEventManager();
        if (r100 == null) goto L8;
        String r101 = r100.a(EventCategory.RTC_WTN_STREAM_EVENT, null, new PublicStreamManager$init$1(this));
        if (r101 == null) goto L9;
        this.f255423a.add(r101);
        return;
    L9:
        return;
    }

    @Override // ui6.c
    public final void release() {
        Iterator<String> r100 = this.f255423a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next();
        e r102 = this.f255424b.getEventManager();
        if (r102 == null) goto L4;
        r102.c(r101);
        goto L4
    L8:
        this.f255423a.clear();
    }

    public PublicStreamManager(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f255424b = r100;
        this.f255423a = new LinkedHashSet();
    }

    @Override // ui6.c
    public final void a(final String r100, final PublicStreamType r101) {
        Intrinsics.checkNotNullParameter(r100, "publicStreamId");
        Intrinsics.checkNotNullParameter(r101, "streamType");
        d r102 = this.f255424b.s();
        if (r102 == null) goto L6;
        oi6.c.c(r102, new PublicStreamManager$startPlayPublicStream$1(this, r101, r100), "PublicStreamManager- startPlay");
        return;
    }

    @Override // ui6.c
    public final void b(final String r100, final f r101) {
        Intrinsics.checkNotNullParameter(r100, "publicStreamId");
        Intrinsics.checkNotNullParameter(r101, "videoCanvas");
        d r102 = this.f255424b.s();
        if (r102 == null) goto L6;
        oi6.c.c(r102, new PublicStreamManager$setPublicStreamVideoCanvas$1(this, r100, r101), "PublicStreamManager- setCanvas");
        return;
    }

    @Override // ui6.c
    public final void d(final String r100, final PublicStreamType r101) {
        Intrinsics.checkNotNullParameter(r100, "publicStreamId");
        Intrinsics.checkNotNullParameter(r101, "streamType");
        d r102 = this.f255424b.s();
        if (r102 == null) goto L6;
        oi6.c.c(r102, new PublicStreamManager$stopPlayPublicStream$1(this, r101, r100), "PublicStreamManager- stopPlay");
        return;
    }

    @Override // ui6.c
    public final void c(final String r100, final ILiveWrappedVideoSink r101, final b r102) {
        Intrinsics.checkNotNullParameter(r100, "publicStreamId");
        Intrinsics.checkNotNullParameter(r101, "videoSink");
        Intrinsics.checkNotNullParameter(r102, "sinkConfig");
        d r103 = this.f255424b.s();
        if (r103 == null) goto L6;
        oi6.c.c(r103, new PublicStreamManager$setPublicStreamVideoSink$1(this, r100, r101, r102), "PublicStreamManager- setSink");
        return;
    }
}
