package com.bytedance.live.livelink.kmp.impl.core.link;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishState;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishStateChangeReason;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomState;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomStateChangeReason;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.core.audio.AudioMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.bytedance.live.livelink.kmp.api.core.mixer.TaskMixerConfig;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import ej6.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import li6.f;
import org.json.JSONObject;
import ti6.h;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
public final class LinkManager implements si6.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f255403k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f255404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f255405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f255406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public si6.c f255407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f255408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f255409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f255410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f255411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f255412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ei6.a f255413j;

    public static final class a {
        public static void a(ei6.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "service");
            if (r101 == null) goto L25;
            String r102 = null;
            if ((!StringsKt.isBlank(r101)) == false) goto L7;
            String r103 = r101;
        L8:
            if (r103 == null) goto L28;
            li6.a r104 = r100.e();
            if (r104 == null) goto L13;
            li6.c r105 = (li6.c) r104.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
        L14:
            if (r105 == null) goto L17;
            r102 = r105.f509382a;
        L17:
            if ((!Intrinsics.areEqual(r102, r101)) == false) goto L26;
            li6.c r106 = hj6.a.a(r101);
            if (r106 == null) goto L27;
            li6.a r107 = r100.e();
            if (r107 == null) goto L23;
            r107.update("TYPE_LIVE_RTC_EXT_INFO", r106);
        L23:
            int r108 = e.f472877a;
            TraceEvent r109 = TraceEvent.LINK_MANAGER;
            JSONObject r110 = new JSONObject();
            r110.put("rtcExtInfo", r101);
            Unit r111 = Unit.INSTANCE;
            e.a(r109, "updateRtcExtInfo", 0, null, r110, 12);
            return;
        L27:
            return;
        L26:
            return;
        L13:
            r105 = null;
            goto L14
        L28:
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    static {
    }

    public final String A() {
        li6.a r100 = this.f255413j.e();
        if (r100 == null) goto L9;
        li6.c r101 = (li6.c) r100.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
        if (r101 == null) goto L9;
        li6.b r102 = r101.f509384c;
        if (r102 == null) goto L9;
        String r103 = r102.f509375b;
    L11:
        return String.valueOf(r103);
    L9:
        r103 = null;
        goto L11
    }

    public final void B() {
        ej6.a.c("LinkManager", "handleServerMix");
        fi6.a r100 = y();
        String r101 = null;
        if (r100 == null) goto L5;
        MixStreamType r102 = r100.U;
    L7:
        if (r102 != MixStreamType.SERVER_MIX) goto L12;
        xi6.c r103 = this.f255413j.t();
        if (r103 == null) goto L11;
        r103.e();
    L11:
        int r104 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "StopCDNStreamPushWhenServerMix", 0, null, null, 28);
    L12:
        fi6.a r105 = y();
        if (r105 != null) goto L15;
        return;
    L15:
        if (r105.f477402r != true) goto L39;
        ei6.a r106 = this.f255413j;
        Intrinsics.checkNotNullParameter(r106, "service");
        fi6.a r107 = r106.g();
        if (r107 == null) goto L19;
        String r108 = r107.V;
    L20:
        fi6.a r109 = r106.g();
        if (r109 == null) goto L29;
        ji6.c r110 = r106.u();
        if (r110 == null) goto L27;
        List<String> r111 = r110.getUrls();
        if (r111 == null) goto L27;
        String r112 = (String) CollectionsKt.getOrNull(r111, 0);
    L28:
        r109.V = r112;
    L27:
        r112 = null;
    L29:
        fi6.a r113 = r106.g();
        if (r113 == null) goto L32;
        r101 = r113.V;
    L32:
        ej6.a.c("PlatformUtils", "checkLiveStreamUrlChanged preUrl " + r108 + " curUrl " + r101);
        if ((!Intrinsics.areEqual(r108, r101)) == false) goto L40;
        int r114 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "restartServerMix", 0, null, null, 28);
        ti6.d r115 = this.f255413j.p();
        if (r115 == null) goto L41;
        r115.j();
        return;
    L41:
        return;
    L40:
        return;
    L19:
        r108 = null;
        goto L20
    L39:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void C() {
        int r100 = ej6.a.f472874a;
        ej6.a.c("LinkManager", this + " init");
        gi6.e r101 = this.f255413j.getEventManager();
        if (r101 == null) goto L7;
        String r102 = r101.a(EventCategory.RTC_ENGINE_EVENT, null, new LinkManager$init$1(this));
        if (r102 == null) goto L7;
        this.f255404a.add(r102);
    L7:
        gi6.e r103 = this.f255413j.getEventManager();
        if (r103 == null) goto L12;
        String r104 = r103.a(EventCategory.RTC_ENGINE_EVENT_EX, null, new LinkManager$init$2(this));
        if (r104 == null) goto L12;
        this.f255404a.add(r104);
    L12:
        gi6.e r105 = this.f255413j.getEventManager();
        if (r105 == null) goto L17;
        String r106 = r105.a(EventCategory.RTC_ROOM_EVENT, null, new LinkManager$init$3(this));
        if (r106 == null) goto L17;
        this.f255404a.add(r106);
    L17:
        gi6.e r107 = this.f255413j.getEventManager();
        if (r107 == null) goto L22;
        String r108 = r107.a(EventCategory.RTC_ROOM_EVENT_EX, null, new LinkManager$init$4(this));
        if (r108 == null) goto L22;
        this.f255404a.add(r108);
    L22:
        gi6.e r109 = this.f255413j.getEventManager();
        if (r109 == null) goto L28;
        String r110 = r109.a(EventCategory.RTC_MIXER_EVENT, null, new LinkManager$init$5(this));
        if (r110 == null) goto L29;
        this.f255404a.add(r110);
        return;
    L29:
        return;
    }

    public final void F() {
        oi6.d r100 = this.f255413j.s();
        if (r100 == null) goto L10;
        Function0<Unit> r101 = new LinkManager$startStatsReport$1(this);
        fi6.a r102 = y();
        if (r102 == null) goto L7;
        int r103 = r102.S;
    L8:
        r100.d(r101, "LinkManager interact stats report", r103 * 1000);
        return;
    L7:
        r103 = 5;
        goto L8
    }

    @Override // si6.b
    public final int i() {
        ej6.a.c("LinkManager", "stopNetworkDetection");
        mi6.a r100 = z();
        if (r100 == null) goto L5;
        r100.i();
        return -2;
    L5:
        return -1;
    }

    @Override // si6.b
    public final void j() {
        int r100 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "CallStartPushData", 0, null, null, 28);
        oi6.d r101 = this.f255413j.s();
        if (r101 == null) goto L6;
        oi6.c.c(r101, new LinkManager$startPushData$1(this), "LinkManager-startPushData");
        return;
    }

    @Override // si6.b
    public final void release() {
        int r100 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "CallRelease", 0, null, null, 28);
        oi6.d r101 = this.f255413j.s();
        if (r101 == null) goto L6;
        oi6.c.c(r101, new AnonymousClass1(this), "LinkManager-release");
        return;
    }

    public final fi6.a y() {
        return this.f255413j.g();
    }

    public final mi6.a z() {
        ui6.d r100 = this.f255413j.l();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final boolean D() {
        fi6.a r100 = y();
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.f477402r != true) goto L18;
        fi6.a r101 = y();
        Character r102 = null;
        if (r101 == null) goto L9;
        MixStreamType r103 = r101.U;
    L11:
        if (r103 != MixStreamType.SERVER_MIX) goto L18;
        fi6.a r104 = y();
        if (r104 == null) goto L16;
        r102 = r104.D;
    L16:
        if (r102 != Character.ANCHOR) goto L18;
        return true;
    L9:
        r103 = null;
        goto L11
    }

    public final void E() {
        fi6.a r100 = y();
        if (r100 != null) goto L5;
    L7:
        int r101 = 3;
    L8:
        ji6.c r102 = this.f255413j.u();
        if (r102 == null) goto L12;
        r102.H(7, 0, new Object[]{Integer.valueOf(r101), 0});
        return;
    L12:
        return;
    L5:
        if (r100.b() != true) goto L7;
        r101 = 2;
        goto L8
    }

    @Override // si6.b
    public final String m() {
        return A();
    }

    public LinkManager(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f255413j = r100;
        this.f255404a = new LinkedHashSet();
        this.f255405b = new AtomicBoolean(false);
        this.f255406c = new AtomicBoolean(false);
        this.f255408e = new AtomicBoolean(false);
        this.f255409f = new AtomicBoolean(false);
        this.f255410g = new c();
        this.f255411h = LazyKt.lazy(new LinkManager$interactListener$2(this));
        this.f255412i = LazyKt.lazy(new LinkManager$logReporter$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    public static final void w(final LinkManager r110) {
        fi6.a r100 = r110.y();
        Character r101 = null;
        if (r100 == null) goto L5;
        Character r102 = r100.D;
    L6:
        Character r103 = Character.ANCHOR;
        if (r102 != r103) goto L18;
        ej6.a.c("LinkManager", "handleStartMix");
        int r104 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "handleStartMix", 0, null, null, 28);
        ri6.b r105 = r110.f255413j.r();
        if (r105 == null) goto L12;
        r105.t(AudioMode.MODE_VOICE_COMMUNICATION);
    L12:
        if (r110.D() == false) goto L17;
        Intrinsics.checkNotNullParameter(new LinkManager$handleStartMix$1(r110), "block");
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r106 = ILiveWrappedLivePusher.a.b();
        if (r106 == null) goto L16;
        r106.getPrivacyCertManager();
    L16:
        r110.f255407d = new d(null);
        goto L18
    L17:
        r110.B();
    L18:
        final Ref.ObjectRef r107 = new Ref.ObjectRef();
        li6.a r108 = r110.f255413j.e();
        if (r108 == null) goto L27;
        li6.c r109 = (li6.c) r108.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
        if (r109 == null) goto L27;
        li6.d r111 = r109.f509385d;
        if (r111 == null) goto L27;
        f r112 = r111.f509387a;
        if (r112 == null) goto L27;
        String r113 = r112.f509396b;
    L28:
        r107.element = String.valueOf(r113);
        fi6.a r114 = r110.f255413j.g();
        if (r114 != null) goto L31;
    L48:
        fi6.a r115 = r110.f255413j.g();
        if (r115 == null) goto L51;
        MixStreamType r116 = r115.U;
    L52:
        MixStreamType r117 = MixStreamType.RTC_CLIENT_MIX;
        if (r116 == r117) goto L60;
        fi6.a r118 = r110.f255413j.g();
        if (r118 == null) goto L57;
        MixStreamType r119 = r118.U;
    L59:
        if (r119 == MixStreamType.CLIENT_MIX) goto L60;
    L61:
        ti6.d r120 = r110.f255413j.p();
        if (r120 == null) goto L75;
        TaskMixerConfig r121 = new TaskMixerConfig();
        String r122 = (String) r107.element;
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r121.f255246c = r122;
        String r123 = r110.A();
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r121.f255247d = r123;
        fi6.a r124 = r110.y();
        if (r124 == null) goto L66;
        h r125 = r124.T;
    L67:
        r121.f255249f = r125;
        r121.b(TaskMixerConfig.TaskType.MAIN);
        fi6.a r126 = r110.f255413j.g();
        if (r126 == null) goto L70;
        MixStreamType r127 = r126.U;
    L71:
        MixStreamType r128 = MixStreamType.SERVER_MIX;
        if (r127 != r128) goto L74;
        r117 = r128;
    L74:
        r121.a(r117);
        r121.f255253j = new LinkManager$handleStartMix$$inlined$apply$lambda$2(r110, r107);
        Unit r129 = Unit.INSTANCE;
        r120.l(r121);
        goto L75
    L70:
        r127 = null;
        goto L71
    L66:
        r125 = null;
    L75:
        int r130 = e.f472877a;
        TraceEvent r131 = TraceEvent.LINK_MANAGER;
        StringBuilder r132 = new StringBuilder("mixSteamType ");
        fi6.a r133 = r110.f255413j.g();
        if (r133 == null) goto L78;
        MixStreamType r134 = r133.U;
    L79:
        r132.append(r134);
        e.a(r131, "startMix", 0, r132.toString(), null, 20);
        ti6.d r135 = r110.f255413j.p();
        if (r135 == null) goto L82;
        r135.d((String) r107.element, "handleStartMix");
    L82:
        ji6.c r136 = r110.f255413j.u();
        if (r136 == null) goto L102;
        r136.H(1, 0, new Object[0]);
        fi6.a r137 = r110.y();
        if (r137 == null) goto L87;
        MixStreamType r138 = r137.U;
    L89:
        if (r138 != MixStreamType.SERVER_MIX) goto L95;
        fi6.a r139 = r110.y();
        if (r139 == null) goto L93;
        r101 = r139.D;
    L93:
        if (r101 != r103) goto L95;
        boolean r140 = true;
    L96:
        if (r140 == false) goto L99;
        r136.x(true);
    L99:
        if (r110.D() == false) goto L103;
        r136.p(false);
        ej6.a.c("LinkManager", "ServerMixOpt startLink setShouldAutoReconnect false");
        return;
    L103:
        return;
    L95:
        r140 = false;
        goto L96
    L87:
        r138 = null;
        goto L89
    L102:
        return;
    L78:
        r134 = null;
        goto L79
    L57:
        r119 = null;
    L60:
        r107.element = "rtc_client_mix_task";
        goto L61
    L51:
        r116 = null;
        goto L52
    L31:
        if (r114.f477394l != true) goto L48;
        fi6.a r141 = r110.f255413j.g();
        if (r141 == null) goto L35;
        MixStreamType r142 = r141.U;
    L36:
        MixStreamType r143 = MixStreamType.SERVER_MIX;
        if (r142 != r143) goto L82;
        ti6.d r144 = r110.f255413j.p();
        if (r144 == null) goto L45;
        TaskMixerConfig r145 = new TaskMixerConfig();
        String r146 = (String) r107.element;
        Intrinsics.checkNotNullParameter(r146, "<set-?>");
        r145.f255246c = r146;
        String r147 = r110.A();
        Intrinsics.checkNotNullParameter(r147, "<set-?>");
        r145.f255247d = r147;
        fi6.a r148 = r110.y();
        if (r148 == null) goto L43;
        h r149 = r148.T;
    L44:
        r145.f255249f = r149;
        r145.b(TaskMixerConfig.TaskType.MAIN);
        r145.a(r143);
        r145.f255253j = new LinkManager$handleStartMix$$inlined$apply$lambda$1(r110, r107);
        Unit r150 = Unit.INSTANCE;
        r144.l(r145);
        goto L45
    L43:
        r149 = null;
    L45:
        int r151 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "startServerMix", 0, "taskId " + ((String) r107.element), null, 20);
        ti6.d r152 = r110.f255413j.p();
        if (r152 == null) goto L82;
        r152.d((String) r107.element, "handleStartMix startServerMix");
        goto L82
    L35:
        r142 = null;
    L27:
        r113 = null;
        goto L28
    L5:
        r102 = null;
        goto L6
    }

    @Override // si6.b
    public final void a(final InteractMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        oi6.d r101 = this.f255413j.s();
        if (r101 == null) goto L6;
        oi6.c.c(r101, new LinkManager$switchInteractMode$1(this, r100), "LinkManager-switchInteractMode");
        return;
    }

    @Override // si6.b
    public final void c(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        final String r101 = r100;
    L7:
        if (r101 == null) goto L13;
        oi6.d r102 = this.f255413j.s();
        if (r102 == null) goto L14;
        oi6.c.c(r102, new LinkManager$updateRtcExtInfo$$inlined$let$lambda$1(r101, this, r100), "LinkManager-updateRtcExtInfo");
        return;
    L14:
        return;
    L13:
        return;
    L6:
        r101 = null;
        goto L7
    }

    @Override // si6.b
    public final void d(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        oi6.d r101 = this.f255413j.s();
        if (r101 == null) goto L6;
        oi6.c.c(r101, new LinkManager$setRuntimeParams$1(this, r100), "LinkManager-setRuntimeParams");
        return;
    }

    @Override // si6.b
    public final void f(final String r100) {
        oi6.d r101 = this.f255413j.s();
        if (r101 == null) goto L6;
        oi6.c.c(r101, new LinkManager$updateLiveClientParams$1(this, r100), "LinkManager-updateLiveClientParams");
        return;
    }

    @Override // si6.b
    public final void g(String r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "setBusinessId " + r100);
        if (r100 == null) goto L20;
        String r102 = null;
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r103 = r100;
    L8:
        if (r103 == null) goto L21;
        fi6.a r104 = y();
        if (r104 == null) goto L12;
        r104.f477375b0 = r100;
    L12:
        mi6.a r105 = z();
        if (r105 == null) goto L15;
        r105.g(r103);
    L15:
        fi6.a r106 = y();
        if (r106 == null) goto L18;
        r102 = r106.f477377c0;
    L18:
        s(r102);
        return;
    L21:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // si6.b
    public final void k(final Object r100) {
        int r101 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "CallStartMix", 0, null, null, 28);
        oi6.d r102 = this.f255413j.s();
        if (r102 == null) goto L6;
        oi6.c.c(r102, new LinkManager$startMix$1(this, r100), "LinkManager-startMix");
        return;
    }

    @Override // si6.b
    public final int l(dg2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "setCellularEnhancement config " + r100);
        mi6.a r102 = z();
        if (r102 == null) goto L5;
        r102.l(r100);
        return -2;
    L5:
        return -1;
    }

    @Override // si6.b
    public final int q(int r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "startNetworkDetection isTestUpLinktrue upLinkBitrate" + r100 + " isTestDownLink false downLinkBitrate 0");
        mi6.a r102 = z();
        if (r102 == null) goto L5;
        r102.G();
        return -2;
    L5:
        return -1;
    }

    @Override // si6.b
    public final void r(String r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "setRuntimeParams param " + r100);
        if (r100 != null) goto L10;
        return;
    L10:
        d(new JSONObject(r100));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        int r102 = ej6.a.f472874a;
        ej6.a.b("LinkManager", "setRuntimeParams exception" + e);
    }

    @Override // si6.b
    public final void s(String r100) {
        fi6.a r101 = y();
        if (r101 == null) goto L5;
        r101.f477377c0 = r100;
    L5:
        fi6.a r102 = y();
        if (r102 == null) goto L9;
        String r103 = r102.f477377c0;
        if (r103 == null) goto L9;
    L13:
        int r104 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "setRtcSceneTag, rtcSceneTag: " + r100 + ", updateRtcSceneTag: " + r103);
        if (r103 == null) goto L22;
        mi6.a r105 = z();
        if (r105 == null) goto L23;
        JSONObject r106 = new JSONObject();
        r106.put("rtc.scene_tag", r103);
        ej6.a.c("LinkManager", "onBusinessIdChanged ".concat(r103));
        ji6.c r107 = this.f255413j.u();
        if (r107 == null) goto L20;
        r107.H(13, 0, new Object[]{r103});
    L20:
        Unit r108 = Unit.INSTANCE;
        r105.d(r106);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        fi6.a r109 = y();
        if (r109 == null) goto L12;
        r103 = r109.f477375b0;
        goto L13
    L12:
        r103 = null;
        goto L13
    }

    public static final void u(LinkManager r110, gi6.b r111) {
        r110.getClass();
        String r100 = r111.f481420b.f481422a;
        Object r101 = null;
        int r102 = 0;
        switch(r100.hashCode()) {
            case -1932693357: goto L83;
            case -1349867671: goto L71;
            case -1097440953: goto L46;
            case 201580245: goto L17;
            case 1086908205: goto L6;
            default: goto L111;
        };
    L111:
        return;
    L6:
        if (r100.equals("onFirstRemoteVideoFrameDecoded") == false) goto L96;
        int r103 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "ON_FIRST_REMOTE_VIDEO_FRAME_DECODED " + r111.f481421c);
        Object r112 = r111.f481421c.get("remoteStreamKey");
        if ((r112 instanceof k0) == true) goto L10;
        r112 = null;
    L10:
        k0 r113 = (k0) r112;
        if (r113 == null) goto L13;
        r101 = r113.f571727b;
    L13:
        String r114 = String.valueOf(r101);
        ni6.a r115 = r110.f255413j.k();
        if (r115 == null) goto L97;
        r115.h(r114);
        return;
    L97:
        return;
    L96:
        return;
    L17:
        if (r100.equals("onNetworkDetectionDuringTheCallResult") == false) goto L99;
        Object r104 = r111.f481421c.get("rtt");
        if (r104 == null) goto L44;
        int r105 = ((Integer) r104).intValue();
        Object r106 = r111.f481421c.get("lost_rate");
        if (r106 == null) goto L42;
        float r107 = ((Float) r106).floatValue();
        Object r116 = r111.f481421c.get("bitrate_bps");
        if (r116 == null) goto L40;
        int r117 = ((Integer) r116).intValue();
        Object r118 = r111.f481421c.get("jitter");
        if (r118 == null) goto L38;
        int r119 = ((Integer) r118).intValue();
        Object r120 = r111.f481421c.get("background_loss");
        if (r120 == null) goto L36;
        float r108 = ((Float) r120).floatValue();
        Object r121 = r111.f481421c.get("request_bitrate_bps_max");
        if (r121 == null) goto L34;
        int r122 = ((Integer) r121).intValue();
        ji6.c r123 = r110.f255413j.u();
        if (r123 == null) goto L100;
        r123.H(10, 0, new Object[]{Integer.valueOf(r105), Float.valueOf(r107), Integer.valueOf(r117), Integer.valueOf(r119), Float.valueOf(r108), Integer.valueOf(r122)});
        return;
    L100:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L99:
        return;
    L46:
        if (r100.equals("onVideoSolutionDescription") == false) goto L102;
        Object r109 = r111.f481421c.get("width");
        if (r109 == null) goto L69;
        int r124 = ((Integer) r109).intValue();
        Object r125 = r111.f481421c.get("height");
        if (r125 == null) goto L67;
        int r126 = ((Integer) r125).intValue();
        Object r127 = r111.f481421c.get("fps");
        if (r127 == null) goto L65;
        int r128 = ((Integer) r127).intValue();
        Object r129 = r111.f481421c.get("max_send_kbps");
        if (r129 == null) goto L63;
        int r130 = ((Integer) r129).intValue();
        Object r131 = r111.f481421c.get("min_send_kbps");
        if (r131 == null) goto L61;
        int r132 = ((Integer) r131).intValue();
        ji6.c r133 = r110.f255413j.u();
        if (r133 == null) goto L103;
        r133.H(11, 0, new Object[]{Integer.valueOf(r124), Integer.valueOf(r126), Integer.valueOf(r128), Integer.valueOf(r130), Integer.valueOf(r132)});
        return;
    L103:
        return;
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L65:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L67:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L69:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L102:
        return;
    L71:
        if (r100.equals(LynxVideoManagerLite.EVENT_ON_ERROR) == false) goto L105;
        Object r134 = r111.f481421c.get("err");
        if ((r134 instanceof Integer) == false) goto L76;
        r101 = r134;
    L76:
        Integer r135 = (Integer) r101;
        if (r135 == null) goto L79;
        r102 = r135.intValue();
    L79:
        ni6.a r136 = r110.f255413j.k();
        if (r136 == null) goto L106;
        r136.e(r102, "Error code " + r102);
        return;
    L106:
        return;
    L105:
        return;
    L83:
        if (r100.equals("onLocalStreamStats") == false) goto L108;
        Object r137 = r111.f481421c.get("index");
        if ((r137 instanceof LiveWrappedStreamIndex) == true) goto L87;
        r137 = null;
    L87:
        LiveWrappedStreamIndex r138 = (LiveWrappedStreamIndex) r137;
        Object r139 = r111.f481421c.get("stats");
        if ((r139 instanceof dg2.c) == false) goto L91;
        r101 = r139;
    L91:
        dg2.c r140 = (dg2.c) r101;
        if (r138 != LiveWrappedStreamIndex.STREAM_INDEX_MAIN) goto L109;
        if (r140 == null) goto L110;
        r110.E();
        return;
    L110:
        return;
    L109:
        return;
    }

    public static final void v(final LinkManager r110, gi6.b r210) {
        r110.getClass();
        String r100 = r210.f481420b.f481422a;
        int r101 = r100.hashCode();
        if (r101 == (-1932693357)) goto L127;
        if (r101 == (-1642280985)) goto L31;
        if (r101 == 1109158934) goto L10;
        return;
    L10:
        if (r100.equals("onVideoPublishStateChanged") == false) goto L136;
        int r102 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "onVideoPublishStateChanged " + r210);
        Object r103 = r210.f481421c.get("roomId");
        if (r103 == null) goto L29;
        String r104 = (String) r103;
        Object r105 = r210.f481421c.get("uid");
        if (r105 == null) goto L27;
        String r106 = (String) r105;
        Object r107 = r210.f481421c.get("state");
        if (r107 == null) goto L25;
        LiveWrappedPublishState r108 = (LiveWrappedPublishState) r107;
        Object r109 = r210.f481421c.get("reason");
        if (r109 == null) goto L23;
        LiveWrappedPublishStateChangeReason r111 = (LiveWrappedPublishStateChangeReason) r109;
        ji6.c r112 = r110.f255413j.u();
        if (r112 == null) goto L137;
        r112.H(12, 0, new Object[]{r104, r106, Integer.valueOf(r108.value()), Integer.valueOf(r111.value())});
        return;
    L137:
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.livelink.kmp.api.base.rtc.PublishStateChangeReason /* = com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishStateChangeReason */");
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.livelink.kmp.api.base.rtc.PublishState /* = com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishState */");
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L136:
        return;
    L31:
        if (r100.equals("onRoomStateChangedWithReason") == false) goto L139;
        Intrinsics.checkNotNullParameter(r210, "event");
        HashMap<String, Object> r113 = r210.f481421c;
        if (r113 == null) goto L35;
        Object r114 = r113.get("state");
    L37:
        if ((r114 instanceof LiveWrappedRoomState) == true) goto L39;
        r114 = null;
    L39:
        LiveWrappedRoomState r115 = (LiveWrappedRoomState) r114;
        HashMap<String, Object> r116 = r210.f481421c;
        if (r116 == null) goto L42;
        Object r117 = r116.get("reason");
    L44:
        if ((r117 instanceof LiveWrappedRoomStateChangeReason) == true) goto L46;
        r117 = null;
    L46:
        LiveWrappedRoomStateChangeReason r118 = (LiveWrappedRoomStateChangeReason) r117;
        if (r115 == LiveWrappedRoomState.JOIN_SUCCESS) goto L49;
    L51:
        boolean r119 = false;
    L52:
        if (r119 == false) goto L110;
        boolean r120 = Intrinsics.areEqual(r210.f481421c.get("roomId"), r110.A());
        int r121 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "join room success isMainRoom=" + r120);
        gi6.e r122 = r110.f255413j.getEventManager();
        if (r122 == null) goto L59;
        EventCategory r123 = EventCategory.LINK_MANAGER;
        gi6.f.c r124 = gi6.f.c.f481425b;
        Pair[] r125 = new Pair[2];
        Object r126 = r210.f481421c.get("roomId");
        if (r126 != null) goto L58;
        r126 = "";
    L58:
        r125[0] = TuplesKt.to("roomId", r126);
        r125[1] = TuplesKt.to("isMainRoom", Boolean.valueOf(r120));
        r122.d(new gi6.b(r123, r124, MapsKt.hashMapOf(r125)));
    L59:
        int r127 = e.f472877a;
        TraceEvent r128 = TraceEvent.LINK_MANAGER;
        e.a(r128, "JoinRTCRoomSuccess", 0, "roomId=" + r210.f481421c.get("roomId") + " isMainRoom=" + r120, null, 20);
        if (r120 == false) goto L140;
        c r129 = r110.f255410g;
        long r130 = r129.f255416b - r129.f255415a;
        long r131 = r129.f255418d - r129.f255417c;
        i97.a r132 = i97.a.f488802a;
        long r133 = System.currentTimeMillis() - r129.f255419e;
        long r134 = System.currentTimeMillis() - r129.f255415a;
        LinkedHashMap r135 = new LinkedHashMap();
        r135.put("link_result", String.valueOf(0));
        r135.put("call_to_start_execute_delay", String.valueOf(r130));
        r135.put("video_pipeline_start_duration", String.valueOf(r131));
        r135.put("join_rtc_room_duration", String.valueOf(r133));
        r135.put("link_duration", String.valueOf(r134));
        e.a(r128, "start_link_success", 0, "link_duration=" + r134 + " join_rtc_room_duration=" + r133 + ", video_pipeline_start_duration=" + r131 + ", start_execute_delay=" + r130, null, 20);
        ej6.d.a(r135);
        long r136 = (long) 0;
        r129.f255415a = r136;
        r129.f255416b = r136;
        r129.f255417c = r136;
        r129.f255418d = r136;
        r129.f255419e = r136;
        IMiddlewareUserService r137 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r137 == null) goto L66;
        com.bytedance.android.livesdk.user.e r138 = r137.user();
        if (r138 == null) goto L66;
        String r139 = r138.n();
    L67:
        if (r139 != null) goto L69;
    L73:
        ni6.a r140 = r110.f255413j.k();
        if (r140 == null) goto L76;
        r140.f();
    L76:
        fi6.a r141 = r110.y();
        if (r141 == null) goto L79;
        Character r142 = r141.D;
    L81:
        if (r142 != Character.ANCHOR) goto L141;
        fi6.a r143 = r110.f255413j.g();
        if (r143 != null) goto L85;
    L107:
        ti6.d r144 = r110.f255413j.p();
        if (r144 == null) goto L142;
        r144.i(true, false);
        return;
    L142:
        return;
    L85:
        if (r143.f477394l != true) goto L107;
        fi6.a r145 = r110.f255413j.g();
        if (r145 == null) goto L89;
        MixStreamType r146 = r145.U;
    L90:
        MixStreamType r147 = MixStreamType.RTC_CLIENT_MIX;
        if (r146 != r147) goto L107;
        ti6.d r148 = r110.f255413j.p();
        if (r148 == null) goto L95;
        ti6.c r149 = r148.c();
    L96:
        if (r149 != null) goto L107;
        ti6.d r150 = r110.f255413j.p();
        if (r150 == null) goto L104;
        TaskMixerConfig r151 = new TaskMixerConfig();
        Intrinsics.checkNotNullParameter("rtc_client_mix_task", "<set-?>");
        r151.f255246c = "rtc_client_mix_task";
        String r152 = r110.A();
        Intrinsics.checkNotNullParameter(r152, "<set-?>");
        r151.f255247d = r152;
        r151.b(TaskMixerConfig.TaskType.MAIN);
        r151.a(r147);
        fi6.a r153 = r110.f255413j.g();
        if (r153 == null) goto L102;
        h r154 = r153.T;
    L103:
        r151.f255249f = r154;
        r151.f255253j = new LinkManager$handleRoomEvent$$inlined$apply$lambda$1(r110);
        Unit r155 = Unit.INSTANCE;
        r150.l(r151);
        goto L104
    L102:
        r154 = null;
    L104:
        ej6.a.c("LinkManager", "start client mix on joined room success");
        e.a(r128, "startRtcClientMix", 0, "StartMixTimeOpt StartClientMix onJoinRoomSuccess", null, 20);
        ti6.d r156 = r110.f255413j.p();
        if (r156 == null) goto L107;
        r156.d("rtc_client_mix_task", "StartMixTimeOpt StartClientMix onJoinRoomSuccess");
        goto L107
    L95:
        r149 = null;
        goto L96
    L89:
        r146 = null;
        goto L90
    L141:
        return;
    L79:
        r142 = null;
        goto L81
    L69:
        if ((!StringsKt.isBlank(r139)) == false) goto L73;
        mi6.a r157 = r110.z();
        if (r157 == null) goto L73;
        r157.Z(r139);
    L66:
        r139 = null;
        goto L67
    L140:
        return;
    L110:
        Intrinsics.checkNotNullParameter(r210, "event");
        Object r158 = r210.f481421c.get("state");
        if ((r158 instanceof LiveWrappedRoomState) == true) goto L113;
        r158 = null;
    L113:
        LiveWrappedRoomState r159 = (LiveWrappedRoomState) r158;
        Object r160 = r210.f481421c.get("reason");
        if ((r160 instanceof LiveWrappedRoomStateChangeReason) == true) goto L116;
        r160 = null;
    L116:
        LiveWrappedRoomStateChangeReason r161 = (LiveWrappedRoomStateChangeReason) r160;
        if (r159 != LiveWrappedRoomState.JOIN_FAILED) goto L121;
        if (r161 == null) goto L120;
        int r162 = r161.value();
    L122:
        if (r162 == 0) goto L144;
        boolean r163 = Intrinsics.areEqual(r210.f481421c.get("roomId"), r110.A());
        if (r163 == false) goto L145;
        int r164 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "join room failed isMainRoom=" + r163);
        int r165 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "StartLinkFailed", 0, "join rtc room failed reason=" + r162, null, 20);
        r110.f255410g.a(FailCategory.LINK_RTC, "join rtc room failed reason=" + r162);
        return;
    L145:
        return;
    L144:
        return;
    L120:
        r162 = -1111111;
        goto L122
    L121:
        r162 = 0;
        goto L122
    L49:
        if (r118 != LiveWrappedRoomStateChangeReason.JOIN_ROOM) goto L51;
        r119 = true;
        goto L52
    L42:
        r117 = null;
        goto L44
    L35:
        r114 = null;
        goto L37
    L139:
        return;
    L127:
        if (r100.equals("onLocalStreamStats") == false) goto L147;
        Object r166 = r210.f481421c.get("stats");
        if ((r166 instanceof dg2.c) == true) goto L131;
        Object r167 = null;
    L133:
        if (((dg2.c) r167) == null) goto L148;
        r110.E();
        return;
    L148:
        return;
    L131:
        r167 = r166;
        goto L133
    }

    @Override // si6.b
    public final void h(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "source");
        int r102 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "leaveRTCRoom", 0, "roomId=" + r100 + " source=" + r101, null, 20);
        oi6.d r103 = this.f255413j.s();
        if (r103 == null) goto L6;
        oi6.c.c(r103, new LinkManager$leaveRTCRoom$1(this, r100, r101), "LinkManager-leaveRTCRoom");
        return;
    }

    @Override // si6.b
    public final void n(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "message");
        oi6.d r102 = this.f255413j.s();
        if (r102 == null) goto L6;
        oi6.c.c(r102, new LinkManager$sendRoomMessage$1(this, r100, r101), "LinkManager-sendMessageToRoom");
        return;
    }

    @Override // si6.b
    public final void o(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        int r102 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "setUserVisibility roomId " + r100 + " enable " + r101);
        ui6.e r103 = this.f255413j.n();
        if (r103 == null) goto L8;
        mi6.b r104 = r103.d(r100);
        if (r104 == null) goto L9;
        r104.k(r101);
        return;
    L9:
        return;
    }

    public static final void x(final LinkManager r100, boolean r101, final String r110) {
        r100.getClass();
        int r102 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "stopInternal skipResetLayer " + r101 + " source " + r110);
        int r103 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "stopInternal", 0, "source=" + r110, null, 20);
        ni6.a r104 = r100.f255413j.k();
        if (r104 == null) goto L5;
        r104.a();
    L5:
        Intrinsics.checkNotNullParameter(r110, "source");
        oi6.d r105 = r100.f255413j.s();
        if (r105 == null) goto L8;
        oi6.c.c(r105, new LinkManager$leaveAllRTCRoom$1(r100, r110), "LinkManager-leaveAllRTCRoom");
    L8:
        ri6.b r106 = r100.f255413j.r();
        if (r106 == null) goto L11;
        r106.stop();
    L11:
        xi6.c r107 = r100.f255413j.t();
        if (r107 == null) goto L14;
        r107.stop(r101);
    L14:
        vi6.a r108 = r100.f255413j.v();
        if (r108 == null) goto L17;
        r108.stop();
    L17:
        ti6.d r109 = r100.f255413j.p();
        if (r109 == null) goto L20;
        r109.stop();
    L20:
        ti6.d r111 = r100.f255413j.p();
        if (r111 == null) goto L27;
        ti6.e r112 = r111.f();
        if (r112 == null) goto L27;
        HashMap<String, RTCWaterMarkRegion> r113 = r112.c();
        if (r113 == null) goto L27;
        r113.clear();
    L27:
        wi6.a r114 = r100.f255413j.j();
        if (r114 == null) goto L30;
        r114.e(r110);
    L30:
        gi6.e r115 = r100.f255413j.getEventManager();
        if (r115 == null) goto L33;
        r115.d(new gi6.b(EventCategory.LINK_MANAGER, gi6.f.d.f481426b));
    L33:
        ji6.c r116 = r100.f255413j.u();
        if (r116 == null) goto L36;
        r116.H(12, 0, new Object[]{"", "", Integer.valueOf(LiveWrappedPublishState.UNPUBLISHED.value()), Integer.valueOf(LiveWrappedPublishStateChangeReason.UNPUBLISH.value())});
    L36:
        ji6.c r117 = r100.f255413j.u();
        if (r117 == null) goto L39;
        r117.H(2, 0, new Object[0]);
    L39:
        ej6.a.c("LinkManager", "setNetBandwidthCompetitionStatus false");
        mi6.a r118 = r100.z();
        if (r118 != null) goto L58;
    L45:
        vi6.a r119 = r100.f255413j.v();
        if (r119 == null) goto L48;
        r119.f();
    L48:
        ej6.a.c("LinkManager", "unregisterLiveForInteractListener");
        ji6.c r120 = r100.f255413j.u();
        if (r120 == null) goto L51;
        r120.G(null);
    L51:
        ej6.a.c("LinkManager", "stopInteractStatsReport");
        r100.f255409f.set(false);
        ki6.a r121 = r100.f255413j.d();
        if (r121 == null) goto L54;
        r121.d((LinkManager$logReporter$2.a) r100.f255412i.getValue());
    L54:
        mi6.a r122 = r100.z();
        if (r122 == null) goto L60;
        r122.g("");
        return;
    L60:
        return;
    L58:
        JSONObject r123 = new JSONObject();     // Catch: Exception -> L43
        r123.put("is_competition", false);     // Catch: Exception -> L43
        JSONObject r124 = new JSONObject();     // Catch: Exception -> L43
        r124.put("rtc.net_bandwidth_competition", r123);     // Catch: Exception -> L43
        ej6.a.c("LinkManager", "setNetBandwidthCompetitionStatus " + r124);     // Catch: Exception -> L43
        r118.d(r124);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        int r125 = ej6.a.f472874a;
        ej6.a.b("LinkManager", "setNetBandwidthCompetitionStatus exception " + e);
        Unit r126 = Unit.INSTANCE;
        goto L45
    }

    @Override // si6.b
    public final void b(final boolean r100, final Object r101, final String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        int r102 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "stopLink source " + r110 + " skipResetLayer " + r100 + " audioCert " + r101);
        int r103 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "CallStopLink", 0, "source=".concat(r110), null, 20);
        oi6.d r104 = this.f255413j.s();
        if (r104 == null) goto L6;
        oi6.c.c(r104, new LinkManager$stopLink$1(this, r110, r100, r101), "LinkManager-stopLink");
        return;
    }

    @Override // si6.b
    public final void p(final String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "rtcUserId");
        Intrinsics.checkNotNullParameter(r102, "message");
        oi6.d r103 = this.f255413j.s();
        if (r103 == null) goto L6;
        oi6.c.c(r103, new LinkManager$sendMessageToUser$1(this, r100, r101, r102), "LinkManager-sendUserMessageInRoom");
        return;
    }

    @Override // si6.b
    public final void t(final String r110, final boolean r111, final boolean r112, final Object r113) {
        Intrinsics.checkNotNullParameter(r110, "roomId");
        int r100 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "startLink roomId=" + r110 + " needPushData=" + r111 + " needStartMix=" + r112 + " audioCert=" + r113);
        int r101 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "CallStartLink", 0, "roomId=" + r110 + " needPushData=" + r111 + " needStartMix=" + r112 + " audioCert=" + r113, null, 20);
        c r102 = this.f255410g;
        r102.getClass();
        i97.a r103 = i97.a.f488802a;
        r102.f255415a = System.currentTimeMillis();
        oi6.d r104 = this.f255413j.s();
        if (r104 == null) goto L6;
        oi6.c.c(r104, new LinkManager$startLink$1(this, r110, r113, r111, r112), "LinkManager - startLink");
        return;
    }

    @Override // si6.b
    public final int e(String r110, String r111, yf2.e r210, boolean r211, yf2.d r212) {
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r210, "userInfo");
        Intrinsics.checkNotNullParameter(r212, "roomConfig");
        int r100 = ej6.a.f472874a;
        ej6.a.c("LinkManager", "joinRTCRoom roomId " + r110 + "  userInfo " + r210.f567435a + " ### " + r210.f567436b + " ### userVisibility " + r211 + " roomConfig " + r212 + " token " + r111);
        if (Intrinsics.areEqual(r110, "null") == false) goto L5;
    L25:
        ej6.a.b("LinkManager", "joinRTCRoom roomId or token is is invalid roomId " + r110 + " token " + r111);
        return -1;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L25;
        if (Intrinsics.areEqual(r111, "null") == true) goto L25;
        if (StringsKt.isBlank(r111) == true) goto L25;
        int r101 = e.f472877a;
        e.a(TraceEvent.LINK_MANAGER, "CallJoinRTCRoom", 0, "roomId=" + r110 + " token=" + r111 + " userInfo=" + r210 + " userVisibility=" + r211 + " roomConfig=" + r212, null, 20);
        mi6.a r102 = z();
        if (r102 == null) goto L24;
        ui6.e r103 = this.f255413j.n();
        if (r103 == null) goto L17;
        mi6.b r104 = r103.d(r110);
        if (r104 == null) goto L17;
    L21:
        if (r104 == null) goto L24;
        return r104.t(r111, r210, r211, r212);
    L17:
        ui6.e r105 = this.f255413j.n();
        if (r105 == null) goto L20;
        r104 = r105.c(r102, r110);
        goto L21
    L20:
        r104 = null;
    L24:
        return -1;
    }
}
