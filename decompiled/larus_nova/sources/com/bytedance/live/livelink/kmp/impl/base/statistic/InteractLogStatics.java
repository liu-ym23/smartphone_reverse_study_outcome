package com.bytedance.live.livelink.kmp.impl.base.statistic;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import li6.b;
import oi6.c;
import oi6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class InteractLogStatics implements ni6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f255322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f255323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f255324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f255325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f255326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ei6.a f255327f;

    public static final class a {
    }

    static {
    }

    @Override // ni6.a
    public final void a() {
        final long r100 = 0;
        final String r101 = "";
        final String r102 = "";
        Intrinsics.checkNotNullParameter("", "remoteColorRange");
        Intrinsics.checkNotNullParameter("", "yuv2RgbColorRange");
        if (this.f255322a == 0) goto L5;
        i97.a r103 = i97.a.f488802a;
        final long r104 = System.currentTimeMillis() - this.f255322a;
    L6:
        i97.a r105 = i97.a.f488802a;
        final long r106 = System.currentTimeMillis();
        d r110 = l();
        if (r110 == null) goto L10;
        c.b(r110, new InteractLogStatics$onLeavingChannel$1(this, r106, r104, r100, r101, r102), "InteractLogStatics-rtc_leave_channel");
        return;
    L10:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // ni6.a
    public final void c() {
        i97.a r100 = i97.a.f488802a;
        final long r101 = System.currentTimeMillis();
        d r102 = l();
        if (r102 == null) goto L6;
        c.b(r102, new InteractLogStatics$onInteractStatus$1(this, r101), "InteractLogStatics onInteractStatus");
        return;
    }

    @Override // ni6.a
    public final void d() {
        if (this.f255326e == false) goto L5;
        return;
    L5:
        this.f255326e = true;
        i97.a r100 = i97.a.f488802a;
        final long r101 = System.currentTimeMillis();
        d r102 = l();
        if (r102 == null) goto L9;
        final int r103 = 0;
        c.b(r102, new InteractLogStatics$onPublishStream$1(this, r101, r103), "InteractLogStatics onPublishStream");
        return;
    }

    @Override // ni6.a
    public final void f() {
        long r100 = 0;
        if (this.f255322a == 0) goto L5;
        i97.a r101 = i97.a.f488802a;
        r100 = System.currentTimeMillis() - this.f255322a;
    L5:
        final long r102 = r100;
        i97.a r103 = i97.a.f488802a;
        final long r104 = System.currentTimeMillis();
        d r105 = l();
        if (r105 == null) goto L8;
        c.b(r105, new InteractLogStatics$onJoinChannelSuccess$1(this, r104, r102), "InteractLogStatics-rtc_join_channel_success");
    L8:
        this.f255323b = false;
    }

    public final d l() {
        return this.f255327f.s();
    }

    public InteractLogStatics(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f255327f = r100;
        this.f255323b = true;
        this.f255324c = new ConcurrentHashMap();
        this.f255325d = new ConcurrentHashMap();
    }

    @Override // ni6.a
    public final void h(final String r110) {
        final boolean r100 = false;
        Intrinsics.checkNotNullParameter(r110, "remoteInteractId");
        i97.a r101 = i97.a.f488802a;
        long r102 = System.currentTimeMillis();
        long r103 = this.f255322a;
        if (r103 == 0) goto L5;
        final long r104 = r102 - r103;
    L6:
        final long r105 = System.currentTimeMillis();
        d r106 = l();
        if (r106 == null) goto L10;
        c.b(r106, new InteractLogStatics$onFirstRemoteFrame$1(this, r100, r105, r110, r104), "InteractLogStatics-rtc_first_remote_frame");
        return;
    L10:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public static final void k(InteractLogStatics r100, JsonObject r101) {
        ki6.a r102 = r100.f255327f.d();
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }

    @Override // ni6.a
    public final void b(final boolean r110, final String r111) {
        Intrinsics.checkNotNullParameter(r111, "remoteInteractId");
        long r100 = 0;
        if (this.f255322a == 0) goto L5;
        i97.a r101 = i97.a.f488802a;
        r100 = System.currentTimeMillis() - this.f255322a;
    L5:
        final long r112 = r100;
        if (r110 == false) goto L8;
        i97.a r102 = i97.a.f488802a;
        System.currentTimeMillis();
    L8:
        i97.a r103 = i97.a.f488802a;
        final long r104 = System.currentTimeMillis();
        d r105 = l();
        if (r105 == null) goto L11;
        c.b(r105, new InteractLogStatics$onRemoteUserOnlineOffline$1(this, r110, r104, r111, r112), "InteractLogStatics-rtc_remote_user_online_offline");
    L11:
        if (r110 == true) goto L13;
        return;
    L13:
        if (this.f255325d.containsKey(r111) == true) goto L16;
        this.f255325d.put(r111, Boolean.TRUE);
    L16:
        if (this.f255324c.containsKey(r111) == true) goto L20;
        this.f255324c.put(r111, Boolean.TRUE);
        return;
    }

    @Override // ni6.a
    public final void e(final int r100, final String r110) {
        i97.a r101 = i97.a.f488802a;
        final long r102 = System.currentTimeMillis();
        d r103 = l();
        if (r103 == null) goto L6;
        c.b(r103, new InteractLogStatics$onErrorOccurs$1(this, r102, r100, r110), "InteractLogStatics onErrorOccurs");
        return;
    }

    @Override // ni6.a
    public final void i(final int r100, final String r110) {
        i97.a r101 = i97.a.f488802a;
        this.f255322a = System.currentTimeMillis();
        final long r102 = System.currentTimeMillis();
        d r103 = l();
        if (r103 == null) goto L6;
        c.b(r103, new InteractLogStatics$onJoiningChannel$1(this, r102, r100, r110), "InteractLogStatics-rtc_join_channel");
        return;
    }

    public static final JsonObject j(InteractLogStatics r100, String r101, Number r102) {
        ki6.a r103 = r100.f255327f.d();
        if (r103 == null) goto L5;
        long r104 = r103.c();
    L6:
        Long r105 = Long.valueOf(r104);
        fi6.a r106 = r100.f255327f.g();
        li6.a r107 = r100.f255327f.e();
        Integer r108 = null;
        if (r107 == null) goto L9;
        li6.c r109 = (li6.c) r107.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
    L11:
        if (r106 != null) goto L13;
        ej6.a.b("InteractLogStatics", "can not get interact config");
        return null;
    L13:
        if (r109 != null) goto L15;
        ej6.a.b("InteractLogStatics", "can not get liveRtcExtInfo");
        return null;
    L15:
        JsonObject r110 = new JsonObject();
        r110.addProperty("version", "1.0.0");
        r110.addProperty(LiveCommonConstants.LOG_PARAM_EVENT_KEY, r101);
        r110.addProperty("mode", "rtc");
        r110.addProperty("timestamp", r102);
        r110.addProperty("report_version", 5);
        r110.addProperty("product_line", "live");
        r110.addProperty("rtc_report_id", r105);
        r110.addProperty("project_key", r106.f477407w);
        r110.addProperty("rtc_type", r106.G.toString());
        r110.addProperty("rtc_interact_type", r106.G.getNameStr());
        Character r111 = r106.D;
        Intrinsics.checkNotNullParameter(r111, "character");
        int r112 = com.bytedance.live.livelink.kmp.impl.base.statistic.a.f255328a[r111.ordinal()];
        if (r112 != 1) goto L18;
        String r113 = "host";
    L23:
        r110.addProperty("rtc_role", r113);
        r110.addProperty("rtc_app_channel", r106.f477409y);
        r110.addProperty("mix_type", r106.U.toString());
        r110.addProperty("stream_name", r106.T.f546200o);
        r110.addProperty("sdkParams", r106.f477406v);
        b r114 = r109.f509384c;
        if (r114 == null) goto L26;
        String r115 = r114.f509375b;
    L27:
        r110.addProperty("rtc_channel_id", r115);
        b r116 = r109.f509384c;
        if (r116 == null) goto L30;
        String r117 = r116.f509378e;
    L31:
        r110.addProperty("rtc_user_id", r117);
        b r118 = r109.f509384c;
        if (r118 == null) goto L34;
        r108 = Integer.valueOf(r118.f509380g);
    L34:
        r110.addProperty("rtc_vendor", r108);
        ILiveWrappedRtcService.a r119 = ILiveWrappedRtcService.Companion;
        r119.getClass();
        String r120 = ILiveWrappedRtcService.a.a().getSDKVersion();
        String r121 = "";
        if (r120 != null) goto L37;
        r120 = "";
    L37:
        r110.addProperty("rtc_version", r120);
        r119.getClass();
        String r122 = ILiveWrappedRtcService.a.a().getSDKVersion();
        if (r122 != null) goto L40;
        r122 = "";
    L40:
        r110.addProperty("rtc_sdk_version", r122);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r123 = ILiveWrappedLivePusher.a.b();
        if (r123 == null) goto L46;
        String r124 = r123.getVersion();
        if (r124 == null) goto L46;
        r121 = r124;
    L46:
        r110.addProperty(IPerformanceManager.Params.live_sdk_version, r121);
        return r110;
    L30:
        r117 = null;
        goto L31
    L26:
        r115 = null;
        goto L27
    L18:
        if (r112 != 2) goto L21;
        r113 = "guest";
        goto L23
    L21:
        throw new NoWhenBranchMatchedException();
    L9:
        r109 = null;
        goto L11
    L5:
        r104 = 0;
        goto L6
    }

    @Override // ni6.a
    public final void g(final String r110, final String r111, final String r112, final String r113) {
        Intrinsics.checkNotNullParameter(r110, "apiName");
        Intrinsics.checkNotNullParameter(r111, "parameterInfo");
        i97.a r100 = i97.a.f488802a;
        final long r101 = System.currentTimeMillis();
        d r102 = l();
        if (r102 == null) goto L6;
        c.b(r102, new InteractLogStatics$onEngineAPICall$1(this, r101, r110, r111, r112, r113), "InteractLogStatics onEngineAPICall");
        return;
    }
}
