package com.bytedance.live.livelink.kmp.impl.extend;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusVideoSinkManager;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ui6.e;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static final fi6.a b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$config");
        return r100.c().f255524m.invoke();
    }

    public static final pj6.a c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$liveCore");
        return (pj6.a) r100.c().f255512a.getValue();
    }

    public static final mi6.b d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mainRTCRoom");
        e r101 = r100.c().f255517f;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.d(e(r100));
    }

    public static final String e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mainRoomID");
        Intrinsics.checkNotNullParameter(r100, "$this$rtcEngineConfig");
        li6.c r101 = g(r100);
        if (r101 == null) goto L5;
        li6.b r102 = r101.f509384c;
    L6:
        if (r102 == null) goto L9;
        String r103 = r102.f509375b;
        if (r103 == null) goto L9;
        return r103;
    L9:
        return "";
    L5:
        r102 = null;
        goto L6
    }

    public static final mi6.a f(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rtcEngine");
        ui6.d r101 = r100.c().f255518g;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.b();
    }

    public static final li6.c g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rtcExtInfo");
        li6.a r101 = r100.c().f255515d;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (li6.c) r101.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
    }

    public static final ti6.d h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamMixManager");
        return r100.c().f255519h;
    }

    public static final boolean i(ChorusVideoSinkManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$hasVideoSink");
        Intrinsics.checkNotNullParameter(r101, "interactID");
        xi6.c r102 = r100.f255562d.f255523l;
        if (r102 == null) goto L9;
        com.bytedance.live.livelink.kmp.impl.core.video.c r103 = r102.d();
        if (r103 == null) goto L9;
        ConcurrentHashMap<String, lj6.b> r104 = r103.f255463f;
        if (r104 == null) goto L9;
        return r104.containsKey(r101);
    L9:
        return false;
    }

    public static final void k(SpatialAudioManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$querySpatialAudio");
        Intrinsics.checkNotNullParameter(r101, "roomID");
        e r102 = r100.f255601c.f255517f;
        if (r102 == null) goto L8;
        mi6.b r103 = r102.d(r101);
        if (r103 == null) goto L9;
        r103.o();
        return;
    L9:
        return;
    }

    public static final ILiveWrappedVideoSink l(b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$queryVideoSink");
        Intrinsics.checkNotNullParameter(r101, "interactID");
        xi6.c r102 = r100.c().f255523l;
        lj6.b r103 = null;
        if (r102 == null) goto L9;
        com.bytedance.live.livelink.kmp.impl.core.video.c r104 = r102.d();
        if (r104 == null) goto L9;
        ConcurrentHashMap<String, lj6.b> r105 = r104.f255463f;
        if (r105 == null) goto L9;
        lj6.b r106 = r105.get(r101);
    L11:
        if ((r106 instanceof ILiveWrappedVideoSink) == false) goto L15;
        r103 = r106;
    L15:
        return r103;
    L9:
        r106 = null;
        goto L11
    }

    public static final void m(b r100, oi6.b r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$releaseThread");
        if (r101 == null) goto L8;
        oi6.d r102 = r100.c().f255514c;
        if (r102 == null) goto L9;
        r102.b(r101);
        return;
    L9:
        return;
    }

    public static final void a(final b r100, final qj6.a r101, final Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$createAndEnter");
        Intrinsics.checkNotNullParameter(r101, "roomConfig");
        n(r100, "ExtendContextHolder createAndEnter", new ExtendContextKt$createAndEnter$1(r100, r101, r102));
    }

    public static void j(b r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$onEngineAPICall");
        Intrinsics.checkNotNullParameter(r101, "apiName");
        Intrinsics.checkNotNullParameter(r102, "parameterInfo");
        ni6.a r103 = r100.c().f255513b;
        if (r103 == null) goto L6;
        r103.g(r101, r102, null, null);
        return;
    }

    public static long n(b r100, String r101, Function0 r102) {
        long r103 = 0;
        Intrinsics.checkNotNullParameter(r100, "$this$submitWorkTask");
        Intrinsics.checkNotNullParameter(r101, "taskInfo");
        Intrinsics.checkNotNullParameter(r102, "task");
        oi6.d r104 = r100.c().f255514c;
        if (r104 != null) goto L7;
        return -1;
    L7:
        return r104.a(r102, r101, r103);
    }
}
