package com.bytedance.live.livelink.kmp.impl.core.video;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimulcastStreamType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.video.VideoPipelineType;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.output.VideoSubscribeMixerPushNode;
import com.bytedance.live.livelink.kmp.impl.core.video.pipeline.subscribe.process.AndroidVideoSubscribeMixerFilterNode;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import gi6.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
public class g implements xi6.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f255457m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c f255458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f255459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f255460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f255461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f255462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, lj6.b> f255463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f255464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f255465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f255466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f255467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveWrappedVideoPixelFormat f255468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ei6.a f255469l;

    public static final class a {
    }

    static {
    }

    @Override // xi6.b
    public final void b() {
        this.f255467j = this.f255466i;
    }

    public final void c() {
        boolean r100 = false;
        if (this.f255458a.b("VideoSubscribeMixerInputNode") == null) goto L5;
    L15:
        fi6.a r101 = this.f255469l.g();
        if (r101 == null) goto L18;
        Boolean r102 = Boolean.valueOf(r101.f477403s);
    L20:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == true) goto L22;
    L27:
        int r103 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "buildRtcMixPushNodes call enableEffectFilter=" + r102);
        return;
    L22:
        if (this.f255458a.b("VideoSubscribeMixerFilterNode") != null) goto L27;
        xi6.c r104 = this.f255469l.t();
        if (r104 == null) goto L26;
        VideoPipelineType r105 = VideoPipelineType.VIDEO_RTC_SUBSCRIBE_PIPELINE;
        ei6.a r106 = this.f255469l;
        Intrinsics.checkNotNullParameter(r106, "linkService");
        AndroidVideoSubscribeMixerFilterNode r107 = new AndroidVideoSubscribeMixerFilterNode(r106);
        ArrayList r108 = new ArrayList();
        r108.add("VideoSubscribeMixerInputNode");
        Unit r109 = Unit.INSTANCE;
        ArrayList r110 = new ArrayList();
        r110.add("VideoSubscribeMixerPushNode");
        r100 = r104.g(r105, r107, r108, r110);
    L26:
        int r111 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "buildRtcMixPushNodes toInsertEffect call effectInsertResult=" + r100);
        goto L27
    L18:
        r102 = null;
        goto L20
    L5:
        if (this.f255458a.b("VideoSubscribeMixerPushNode") != null) goto L15;
        xi6.c r112 = this.f255469l.t();
        if (r112 == null) goto L9;
        boolean r113 = r112.g(VideoPipelineType.VIDEO_RTC_SUBSCRIBE_PIPELINE, new mj6.a(this.f255469l), new ArrayList(), new ArrayList());
    L10:
        xi6.c r114 = this.f255469l.t();
        if (r114 == null) goto L13;
        VideoPipelineType r115 = VideoPipelineType.VIDEO_RTC_SUBSCRIBE_PIPELINE;
        VideoSubscribeMixerPushNode r116 = new VideoSubscribeMixerPushNode(this.f255469l);
        ArrayList r117 = new ArrayList();
        r117.add("VideoSubscribeMixerInputNode");
        Unit r118 = Unit.INSTANCE;
        boolean r119 = r114.g(r115, r116, r117, new ArrayList());
    L14:
        int r120 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "buildRtcMixPushNodes toInsertBase call inputInsertResult=" + r113 + " pushInsertResult=" + r119);
        goto L15
    L13:
        r119 = false;
        goto L14
    L9:
        r113 = false;
        goto L10
    }

    public final String f() {
        li6.a r100 = this.f255469l.e();
        if (r100 == null) goto L10;
        li6.c r101 = (li6.c) r100.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
        if (r101 == null) goto L10;
        li6.b r102 = r101.f509384c;
        if (r102 == null) goto L10;
        String r103 = r102.f509375b;
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    public final LiveWrappedVideoPixelFormat g() {
        if (this.f255468k != null) goto L19;
        LiveWrappedVideoPixelFormat r100 = LiveWrappedVideoPixelFormat.I420;
        fi6.a r101 = this.f255469l.g();
        if (r101 == null) goto L17;
        String r102 = r101.f477386h;
        if (r102 == null) goto L17;
        if ((!StringsKt.isBlank(r102)) == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L17;
        boolean r103 = com.bytedance.live.livelink.kmp.impl.base.rtc.g.a(r102, "rtc_ab_android_hwdec_tex_render", "rtc_enable_tex_render", false);
        if (r103 == false) goto L16;
        r100 = LiveWrappedVideoPixelFormat.UNKNOWN;
    L16:
        int r104 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "renderABResult=" + r103);
    L17:
        this.f255468k = r100;
    L19:
        return this.f255468k;
    }

    public final boolean h() {
        MixStreamType r100 = null;
        if (this.f255466i <= this.f255467j) goto L5;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == true) goto L25;
        KmpEnv r102 = KmpEnv.f255139a;
        if (v.a() == false) goto L25;
        fi6.a r103 = this.f255469l.g();
        if (r103 == null) goto L25;
        if (r103.f477396m != true) goto L25;
        int r104 = ej6.a.f472874a;
        StringBuilder r105 = new StringBuilder("isReadyToReceiveFrame not ready receive=");
        r105.append(this.f255466i);
        r105.append(" deliver=");
        r105.append(this.f255467j);
        r105.append(" isRtcClientMixStart=");
        r105.append(this.f255464g);
        r105.append(" mixType=");
        fi6.a r106 = this.f255469l.g();
        if (r106 == null) goto L24;
        r100 = r106.U;
    L24:
        r105.append(r100);
        ej6.a.c("Video_VideoSubscribeManager", r105.toString());
    L25:
        return r101;
    L5:
        if (this.f255464g == false) goto L13;
        fi6.a r107 = this.f255469l.g();
        if (r107 == null) goto L9;
        MixStreamType r108 = r107.U;
    L11:
        if (r108 != MixStreamType.RTC_CLIENT_MIX) goto L13;
        r101 = true;
        goto L14
    L9:
        r108 = null;
        goto L11
    }

    public final void i() {
        this.f255466i++;
    }

    public final void j() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "markRtcClientMixPushReady isRtcClientMixPushReady=" + this.f255465h + " isReady=true");
        int r101 = ej6.e.f472877a;
        ej6.e.a(TraceEvent.VIDEO_MANAGER, "markRtcClientMixPushReady", 0, "isRtcClientMixStart=" + this.f255464g + " isRtcClientMixPushReady=" + this.f255465h + " isReady=true", null, 20);
        this.f255465h = true;
    }

    @Override // xi6.b
    public final long a() {
        return this.f255466i;
    }

    public g(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        this.f255469l = r100;
        this.f255458a = new com.bytedance.live.livelink.kmp.impl.core.video.pipeline.c();
        this.f255459b = new LinkedHashSet();
        this.f255461d = true;
        this.f255463f = new ConcurrentHashMap();
    }

    public final com.bytedance.live.livelink.kmp.impl.core.video.pipeline.a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        ei6.a r101 = this.f255469l;
        Intrinsics.checkNotNullParameter(r101, "linkService");
        Intrinsics.checkNotNullParameter(r100, "interactId");
        return new com.bytedance.live.livelink.kmp.impl.core.video.pipeline.a(r101, r100);
    }

    public final void e(boolean r100) {
        this.f255461d = r100;
        Iterator<Map.Entry<String, lj6.b>> r101 = this.f255463f.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, lj6.b> r102 = r101.next();
        r102.getValue().c(r100);
        lj6.a r103 = r102.getValue().f509500g;
        if (r103 == null) goto L4;
        r103.d();
        goto L4
    }

    public final boolean m(qi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "videoFrame");
        Object r101 = r100.f533157g.get("interact_id");
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        if (r102 == null) goto L13;
        lj6.b r103 = this.f255463f.get(r102);
        if (r103 == null) goto L14;
        lj6.a r104 = r103.f509500g;
        if (r104 != null) goto L12;
        return true;
    L12:
        return r104.e(r100);
    L14:
        return true;
    L13:
        return true;
    }

    public final void n(qi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "videoFrame");
        Object r101 = r100.f533157g.get("interact_id");
        if (r101 == null) goto L10;
        lj6.b r102 = this.f255463f.get(r101);
        if (r102 == null) goto L11;
        lj6.a r103 = r102.f509500g;
        if (r103 == null) goto L12;
        r103.a(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void o(boolean r100) {
        this.f255460c = r100;
        Iterator<Map.Entry<String, lj6.b>> r101 = this.f255463f.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().f509495b = r100;
        goto L4
    }

    public final void r(boolean r100) {
        fi6.a r101 = this.f255469l.g();
        if (r101 == null) goto L6;
        int r102 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "setSingleViewMode old=" + r101.Z + " new=" + r100);
        r101.Z = r100;
        return;
    }

    public final void u(boolean r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "updateUnSubscribeScreenStream old=" + this.f255462e + " new=" + r100);
        this.f255462e = r100;
    }

    public final void k(boolean r110, String r111) {
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "muteAllRemoteVideoStreams mute=" + r110 + " reason=" + r111);
        ui6.e r101 = this.f255469l.n();
        if (r101 == null) goto L11;
        mi6.b r102 = r101.d(f());
        if (r102 == null) goto L12;
        if (r110 == false) goto L8;
        int r103 = r102.p();
    L9:
        ej6.a.c("Video_VideoSubscribeManager", "muteAllRemoteVideoStreams rtcRoomId=" + f() + " mute=" + r110 + " reason=" + r111 + " result=" + r103);
        int r104 = ej6.e.f472877a;
        ej6.e.a(TraceEvent.VIDEO_MANAGER, "muteAllRemoteVideoStreams", 0, "rtcRoomId=" + f() + " mute=" + r110 + " reason=" + r111 + " result=" + r103, null, 20);
        return;
    L8:
        r103 = r102.h();
        goto L9
    L12:
        return;
    }

    public final int p(String r100, LiveWrappedSimulcastStreamType r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter("1", "interactId");
        Intrinsics.checkNotNullParameter(r101, "streamType");
        ui6.e r102 = this.f255469l.n();
        if (r102 == null) goto L7;
        mi6.b r103 = r102.d(r100);
        if (r103 == null) goto L7;
        return r103.l(r101);
    L7:
        return -1;
    }

    public final void q(k0 r100, LiveWrappedVideoSuperResolutionMode r101) {
        Intrinsics.checkNotNullParameter(r100, "remoteStreamKey");
        Intrinsics.checkNotNullParameter(r101, "mode");
        ui6.d r102 = this.f255469l.l();
        if (r102 == null) goto L8;
        mi6.a r103 = r102.b();
        if (r103 == null) goto L9;
        r103.C(r100, r101);
        return;
    L9:
        return;
    }

    public final void s(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        lj6.b r102 = this.f255463f.get(r100);
        if (r102 == null) goto L6;
        r102.f509495b = r101;
        return;
    }

    public final void t(String r100, LiveWrappedStreamIndex r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "streamIndex");
        k0 r102 = new k0(f(), r100, r101);
        fg2.b r103 = new fg2.b();
        LiveWrappedVideoPixelFormat r104 = g();
        if (r104 != null) goto L5;
        r104 = LiveWrappedVideoPixelFormat.I420;
    L5:
        r103.a(r104);
        lj6.b r105 = this.f255463f.get(r100);
        ui6.d r106 = this.f255469l.l();
        if (r106 == null) goto L11;
        mi6.a r107 = r106.b();
        if (r107 == null) goto L12;
        r107.z(r102, r105, r103);
        return;
    L12:
        return;
    }

    public final void l(String r110, boolean r111, String r210) {
        Intrinsics.checkNotNullParameter(r110, "interactId");
        int r100 = ej6.a.f472874a;
        ej6.a.c("Video_VideoSubscribeManager", "muteRemoteVideoStream interactId=" + r110 + " mute=" + r111 + " reason=" + r210);
        ui6.e r101 = this.f255469l.n();
        if (r101 == null) goto L14;
        mi6.b r102 = r101.d(f());
        if (r102 == null) goto L15;
        if (r111 == false) goto L8;
        r102.w(r110, LiveWrappedStreamIndex.STREAM_INDEX_MAIN, LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO);
        Unit r103 = Unit.INSTANCE;
    L9:
        gi6.e r104 = this.f255469l.getEventManager();
        if (r104 == null) goto L12;
        r104.d(new gi6.b(EventCategory.VIDEO_MANAGER, l.c.f481450b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("interactId", r110), TuplesKt.to(ITTVideoEngineEventSource.KEY_MUTE, Boolean.valueOf(r111)), TuplesKt.to("reason", r210)})));
    L12:
        ej6.a.c("Video_VideoSubscribeManager", "muteRemoteVideoStream rtcRoomId=" + f() + " interactId=" + r110 + " mute=" + r111 + " reason=" + r210 + " result=" + r103);
        int r105 = ej6.e.f472877a;
        ej6.e.a(TraceEvent.VIDEO_MANAGER, "muteRemoteVideoStream", 0, "rtcRoomId=" + f() + " interactId=" + r110 + " mute=" + r111 + " reason=" + r210 + " result=" + r103, null, 20);
        return;
    L8:
        r102.n(r110, LiveWrappedStreamIndex.STREAM_INDEX_MAIN, LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO);
        r103 = Unit.INSTANCE;
        goto L9
    L15:
        return;
    }
}
