package com.larus.call_plugins_doubao_common.manager;

import android.os.Handler;
import android.os.Looper;
import com.larus.media.MediaLevel;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.model.SceneConfig;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.y1;
import com.larus.voicecall.impl.plugins.z1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f321428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f321429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f321430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Float, Unit> f321431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f321432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f321433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f321434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f321435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f321436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f321437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f321438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f321439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f321440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f321441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.larus.media.model.a f321442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.media.model.a f321443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g0 f321444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f321445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f321446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.larus.media.model.a f321447t;

    public void j(float r100) {
    }

    public void m() {
    }

    public final com.larus.media.model.a c() {
        com.larus.media.model.a r100 = this.f321447t;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (com.larus.media.model.a) this.f321445r.getValue();
    }

    public boolean f() {
        lq9.k r100 = z2.f365865a.continueTalkV2Config();
        boolean r101 = false;
        if (r100.a() == false) goto L6;
        FLogger.f375446a.i(h(), "getPlayGainApplicantMixResult: enableContinueTalkV2=true, return false. config=" + r100);
        return false;
    L6:
        boolean r102 = com.larus.media.o.a();
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r103 = com.larus.media.m0.b(MediaScene.CALL_TTS_PLAY, 2);
        if (r103 == null) goto L9;
        boolean r104 = r103.getMixWithOthers();
    L10:
        if (r102 == false) goto L13;
        if (r104 == false) goto L13;
        r101 = true;
    L13:
        FLogger.f375446a.i(h(), "getPlayGainApplicantMixResult: enableV2=false, mediaEnabled=" + r102 + ", sceneMix=" + r104 + ", result=" + r101);
        return r101;
    L9:
        r104 = false;
        goto L10
    }

    public void k() {
        FLogger.f375446a.i(h(), "onRelease: currentPlayApplicant: " + c());
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.c(this.f321442o);
        MediaResourceManager.a(g());
        MediaResourceManager.a(c());
    }

    public final void l() {
        FLogger.f375446a.i(h(), "releaseMediaFocusSync: currentPlayApplicant: " + c());
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.c(this.f321442o);
        MediaResourceManager.a(g());
        MediaResourceManager.a(c());
    }

    public boolean e() {
        boolean r100 = com.larus.media.o.a();
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r101 = com.larus.media.m0.b(MediaScene.CALL_TTS_PLAY, 2);
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.getMixWithOthers();
    L6:
        if (r100 == false) goto L9;
        if (r103 == false) goto L9;
        r102 = true;
    L9:
        FLogger.f375446a.i(h(), "getPlayDuckApplicantMixResult: mediaEnabled=" + r100 + ", sceneMix=" + r103 + ", result=" + r102);
        return r102;
    L5:
        r103 = false;
        goto L6
    }

    public com.larus.media.v d() {
        return this.f321444q;
    }

    public com.larus.media.model.a g() {
        return this.f321443p;
    }

    public String h() {
        return this.f321437j;
    }

    public static /* synthetic */ void b(r r100) {
        r100.a(-1, "");
    }

    public final boolean i(int r100) {
        if (((Boolean) this.f321441n.getValue()).booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f321436i == false) goto L9;
        if (r100 != (-3)) goto L9;
        return true;
    }

    public void a(int r110, String r111) {
        if (r110 != 2) goto L5;
    L57:
        Lazy r100 = MediaResourceManager.f358950a;
        com.larus.media.model.a r101 = this.f321442o;
        Function1 r102 = new s();
        Function1 r103 = new v(this);
        Intrinsics.checkNotNullParameter(r101, "applicant");
        ((com.larus.media.j0) MediaResourceManager.f358950a.getValue()).b(r101, r103, r102);
        FLogger.f375446a.i(h(), "dealWithMediaRequestOnStateChange: state: " + r110 + ", callId: " + r111 + ", currentPlayApplicant: " + c());
        if (this.f321433f.invoke().booleanValue() == false) goto L60;
    L63:
        MediaResourceManager.j(g(), c(), new w(), new x());
        return;
    L60:
        if (this.f321434g.invoke().booleanValue() == true) goto L63;
        MediaResourceManager.a(c());
        return;
    L5:
        if (r110 == 3) goto L57;
        boolean r104 = false;
        if (r110 != 4) goto L9;
        boolean r112 = z2.f365865a.realtimeSceneMixEnable();
        FLogger r105 = FLogger.f375446a;
        r105.i(h(), "dealWithMediaRequestOnStateChange: state: THINKING, callId: " + r111 + ", before assignment currentPlayApplicant: " + c() + " sceneMixable=" + r112);
        if (this.f321435h.invoke().booleanValue() == true) goto L51;
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L46;
        r106.K0();
        if (com.larus.music.i.f359475a.h() != true) goto L46;
        r104 = true;
    L46:
        if (r104 == true) goto L51;
        if (this.f321432e.invoke().booleanValue() == false) goto L51;
        com.larus.media.model.a r107 = (com.larus.media.model.a) this.f321445r.getValue();
    L53:
        if (Intrinsics.areEqual(r107.f359114b, c().f359114b) == false) goto L56;
        if (r112 == false) goto L56;
        Lazy r108 = MediaResourceManager.f358950a;
        MediaResourceManager.a(c());
    L56:
        Intrinsics.checkNotNullParameter(r107, "value");
        this.f321447t = r107;
        r105.i(h(), "dealWithMediaRequestOnStateChange: state: THINKING, callId: " + r111 + ", after assignment currentPlayApplicant: " + c() + " sceneMixable=" + r112);
        Lazy r113 = MediaResourceManager.f358950a;
        MediaResourceManager.j(c(), g(), new y(this), new z(this));
        return;
    L51:
        r107 = (com.larus.media.model.a) this.f321446s.getValue();
        goto L53
    L9:
        if (r110 == 5) goto L20;
        if (r110 != 7) goto L13;
        FLogger.f375446a.i(h(), "dealWithMediaRequestOnStateChange: state: PAUSED, callId: " + r111 + ", currentPlayApplicant: " + c() + ", hasPausedPlay: " + this.f321439l);
        Lazy r114 = MediaResourceManager.f358950a;
        MediaResourceManager.c(this.f321442o);
        MediaResourceManager.a(g());
        MediaResourceManager.a(c());
        return;
    L13:
        if (r110 == 17) goto L16;
        return;
    L16:
        if (com.larus.audio.call.f.f() == false) goto L65;
        FLogger.f375446a.i(h(), "dealWithMediaRequestOnStateChange: LISTEN_AND_SPEAK -> handle as SPEAKING");
        a(5, r111);
        return;
    L65:
        return;
    L20:
        if (com.larus.media.o.a() == false) goto L68;
        boolean r115 = z2.f365865a.realtimeSceneMixEnable();
        Lazy r109 = MediaResourceManager.f358950a;
        MediaResourceManager.c(this.f321442o);
        FLogger r116 = FLogger.f375446a;
        r116.i(h(), "dealWithMediaRequestOnStateChange: state: SPEAKING, callId: " + r111 + ", before assignment currentPlayApplicant: " + c() + " sceneMixable=" + r115);
        if (this.f321435h.invoke().booleanValue() == true) goto L33;
        IFlowSdkDepend r117 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r117 == null) goto L28;
        r117.K0();
        if (com.larus.music.i.f359475a.h() != true) goto L28;
        r104 = true;
    L28:
        if (r104 == true) goto L33;
        if (this.f321432e.invoke().booleanValue() == false) goto L33;
        com.larus.media.model.a r118 = (com.larus.media.model.a) this.f321445r.getValue();
    L35:
        if (Intrinsics.areEqual(r118.f359114b, c().f359114b) == false) goto L38;
        if (r115 == false) goto L38;
        MediaResourceManager.a(c());
    L38:
        Intrinsics.checkNotNullParameter(r118, "value");
        this.f321447t = r118;
        r116.i(h(), "dealWithMediaRequestOnStateChange: state: SPEAKING, callId: " + r111 + ", after assignment currentPlayApplicant: " + c() + " sceneMixable=" + r115);
        MediaResourceManager.j(c(), g(), new a0(this), new b0(this));
        return;
    L33:
        r118 = (com.larus.media.model.a) this.f321446s.getValue();
        goto L35
    }

    public n0(Function0 r410, Function0 r411, Function0 r412, Function1 r413, Function0 r414, Function0 r415, y1 r416, z1 r417, boolean r418, boolean r510, int r511) {
        if ((r511 & 16) == 0) goto L5;
        Function0 r100 = new com.bytedance.applet.aibridge.p();
    L7:
        if ((r511 & 32) == 0) goto L9;
        Function0 r101 = new com.bytedance.applet.aibridge.p();
    L11:
        if ((r511 & 64) == 0) goto L13;
        Function0<Boolean> r102 = new zb8.c();
    L15:
        if ((r511 & 128) == 0) goto L17;
        Function0<Boolean> r103 = new zb8.c();
    L19:
        if ((r511 & 512) == 0) goto L21;
        boolean r110 = false;
    L23:
        if ((r511 & 1024) == 0) goto L25;
        boolean r104 = false;
    L26:
        Intrinsics.checkNotNullParameter(r410, "onFinish");
        Intrinsics.checkNotNullParameter(r411, "onPause");
        Intrinsics.checkNotNullParameter(r412, "onResume");
        Intrinsics.checkNotNullParameter(r413, "onMediaVolumeChange");
        Intrinsics.checkNotNullParameter(r100, "shouldPauseWhenOtherStart");
        Intrinsics.checkNotNullParameter(r101, "shouldPauseOtherWhenRecording");
        Intrinsics.checkNotNullParameter(r102, "shouldDuckOtherWhenRecording");
        Intrinsics.checkNotNullParameter(r103, "shouldDuckOtherWhenPlaying");
        this.f321428a = r410;
        this.f321429b = r411;
        this.f321430c = r412;
        this.f321431d = r413;
        this.f321432e = r100;
        this.f321433f = r101;
        this.f321434g = r102;
        this.f321435h = r103;
        this.f321436i = r110;
        this.f321437j = "RealtimeCallMediaManager";
        this.f321440m = new Handler(Looper.getMainLooper());
        this.f321441n = LazyKt.lazy(new c0(this));
        if (r104 == false) goto L29;
        String r111 = MediaScene.O_CALL;
    L30:
        this.f321442o = new com.larus.media.model.a(null, r111, false, 0, 1, false, 0, false, false, 0, false, new j0(this), DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
        if (r104 == false) goto L33;
        String r210 = MediaScene.O_CALL;
    L34:
        int r310 = MediaLevel.PLAY_HIGH.getValue();
        if (r102.invoke().booleanValue() == false) goto L37;
    L40:
        int r311 = 1;
    L41:
        com.larus.media.model.a r105 = new com.larus.media.model.a(null, r210, false, r311, 2, false, 0, false, false, r310, false, new m0(this), 1509);
        Function0<Boolean> r106 = new d0(this);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f359129q = r106;
        this.f321443p = r105;
        this.f321444q = new g0(this);
        this.f321445r = LazyKt.lazy(new t(this));
        this.f321446s = LazyKt.lazy(new u(this));
        return;
    L37:
        if (z2.f365865a.realtimeSceneMixEnable() == true) goto L40;
        r311 = 0;
        goto L41
    L33:
        r210 = "CALL";
        goto L34
    L29:
        r111 = "CALL";
        goto L30
    L25:
        r104 = r510;
        goto L26
    L21:
        r110 = r418;
        goto L23
    L17:
        r103 = r417;
        goto L19
    L13:
        r102 = r416;
        goto L15
    L9:
        r101 = r415;
        goto L11
    L5:
        r100 = r414;
        goto L7
    }
}
