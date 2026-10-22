package com.larus.voicecall.impl.component.translator;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.home.impl.sdk.s;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.urlplayer.IAudioUrlPlayService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.quic.QuicCallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.tencent.open.SocialConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;
import o3a.c;
import o3a.e;
import o3a.f;
import tx9.c1;
import xa8.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020,H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0015H\u0016J\b\u0010;\u001a\u00020,H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b)\u0010**\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lcom/larus/voicecall/impl/component/translator/QuicInterpretComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/bmhome/audio/ISimultaneousTranslatorAbility;", "<init>", "()V", "TAG", "", "titleComponentAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getTitleComponentAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "titleComponentAbility$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "currentParam", "Lcom/larus/audio/call/RealtimeCallParam;", "isSessionStarted", "", "isUserSpeaking", "hasSendAudioData", "sessionGeneration", "Ljava/util/concurrent/atomic/AtomicInteger;", "listener", "com/larus/voicecall/impl/component/translator/QuicInterpretComponent$listener$1", "Lcom/larus/voicecall/impl/component/translator/QuicInterpretComponent$listener$1;", "gainApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "duckApplicant", "needPauseByDora", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "quicServiceDelegate", "Lkotlin/Lazy;", "Lcom/larus/voicecall/impl/quic/QuicCallService;", "quicService", "getQuicService$delegate", "(Lcom/larus/voicecall/impl/component/translator/QuicInterpretComponent;)Ljava/lang/Object;", "getQuicService", "()Lcom/larus/voicecall/impl/quic/QuicCallService;", "onAttach", "", "startSession", "speakerMode", "", "finishSession", "stopPlayAudioData", "endMethod", "onUserSpeakingChanged", "isSpeaking", "triggerSendAudioData", "registerTranslatorAudioCallback", SocialConstants.PARAM_RECEIVER, "Lcom/larus/voicecall/api/IQuicAudioCallback;", "onTtsSwitchStatusChange", "isTtsOpen", "onFragmentViewDestroyed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuicInterpretComponent extends Component implements d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f377737l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f377738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f377739n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RealtimeCallParam f377740o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f377741p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f377742q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f377743r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicInteger f377744s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.larus.media.model.a f377745t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.larus.media.model.a f377746u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy<QuicCallService> f377747v;

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuicInterpretComponent f377748a;

        @Override // com.larus.media.v
        public final boolean b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            return false;
        }

        public a(QuicInterpretComponent r100) {
            this.f377748a = r100;
        }

        @Override // com.larus.media.v
        public final void e(g r210) {
            Intrinsics.checkNotNullParameter(r210, "applicant");
            v.a.d(r210);
            FLogger.f375446a.i(this.f377748a.f377737l, "onMediaInterrupted");
            this.f377748a.gq(0);
            zh8.a.f572196a.getReceiver().c().r6(null);
            AudioServiceDelegate.f288288a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
            c1.a(null, null, null, null, null, null, "auto_play", "interrupted", null, null, null, null, null, null, "1", null, null, 114495);
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(g r100, g r101) {
            v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(g r100, float r101) {
            v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(g r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            v.a.e(r100, r101);
            FLogger.f375446a.i(this.f377748a.f377737l, "onMediaPaused");
            this.f377748a.gq(0);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(g r100, g r101, int r102) {
            return v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(g r100, g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            Map<String, o0.a> r103 = o0.f359131a;
            boolean r104 = false;
            if (o0.c(MediaScene.IM_TTS, r101.getScene()) == false) goto L19;
            this.f377748a.getClass();
            if (Intrinsics.areEqual(r101.getScene(), MediaScene.DORA) == false) goto L16;
            IFlowSdkDepend r105 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r105 == null) goto L13;
            s r106 = r105.s0();
            if (r106 == null) goto L13;
            if (r106.L() != true) goto L13;
            boolean r107 = true;
        L14:
            if (r107 == false) goto L16;
            boolean r108 = true;
        L17:
            if (r108 == false) goto L19;
            r104 = true;
        L13:
            r107 = false;
        L16:
            r108 = false;
        L19:
            if (r104 == false) goto L22;
            return MediaOccupyStrategy.PAUSE;
        L22:
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b extends com.larus.audio.call.tracer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f377749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f377750b;

        @Override // com.larus.audio.call.tracer.b
        public final void a(String r100, String r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r100, "spanName");
        }

        @Override // com.larus.audio.call.tracer.b
        public final void c() {
        }

        @Override // com.larus.audio.call.tracer.b
        public final void f(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "spanName");
            Intrinsics.checkNotNullParameter(r101, "parentSpanName");
        }

        public b() {
            this.f377749a = "";
            this.f377750b = "";
        }

        @Override // com.larus.audio.call.tracer.b
        public final String d() {
            return this.f377749a;
        }

        @Override // com.larus.audio.call.tracer.b
        public final String e() {
            return this.f377750b;
        }
    }

    public QuicInterpretComponent() {
        this.f377737l = "QuicInterpretComponent" + hashCode();
        this.f377738m = LazyKt.lazy(new o3a.b(this));
        this.f377739n = LazyKt.lazy(new c(this));
        this.f377744s = new AtomicInteger(0);
        a r100 = new a(this);
        this.f377745t = new com.larus.media.model.a(null, MediaScene.IM_TTS, false, 0, 2, false, 0, false, false, 0, false, r100, 2021);
        this.f377746u = new com.larus.media.model.a(null, MediaScene.IM_TTS, false, 1, 2, false, 0, false, false, 0, false, r100, 2021);
        this.f377747v = LazyKt.lazy(new o3a.d(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        FLogger.f375446a.i(this.f377737l, "fragment view destory");
        gq(0);
        if (this.f377747v.isInitialized() == false) goto L6;
        F2().b();
        return;
    }

    public final QuicCallService F2() {
        return this.f377747v.getValue();
    }

    @Override // xa8.d
    public final void JX() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f377737l, "triggerSendAudioData , isUserSpeaking = false");
        this.f377742q = false;
        this.f377743r = true;
        F2().i().a2();
        QuicCallService r101 = F2();
        RealtimeCallParam r102 = o3a.a.a(0, null, null);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r102, "param");
        r100.i("QuicCallService", ITTVideoEngineEventSource.KEY_MUTE);
        r101.f378662u.G(r102);
    }

    @Override // xa8.d
    public final void rV() {
        FLogger.f375446a.i(this.f377737l, "on user speaking change, isSpeaking = true");
        this.f377742q = true;
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, d.class);
    }

    @Override // xa8.d
    public final boolean Ig() {
        return this.f377743r;
    }

    @Override // xa8.d
    public final boolean K70() {
        return this.f377742q;
    }

    @Override // xa8.d
    public final void HE(boolean r100) {
        if (r100 == true) goto L5;
        ZM("click_tts_icon");
        return;
    }

    @Override // xa8.d
    public final void VJ(z2a.a r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        FLogger r101 = FLogger.f375446a;
        r101.i(this.f377737l, "registerTranslatorAudioCallback in component , receiver = " + r100);
        QuicCallService r102 = F2();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        r101.i("QuicCallService", "registerAudioFrameReceiver in service, receiver = " + r100);
        r102.i().d2(r100);
    }

    @Override // xa8.d
    public final void ZM(String r100) {
        Intrinsics.checkNotNullParameter(r100, "endMethod");
        FLogger r101 = FLogger.f375446a;
        r101.i(this.f377737l, "stopPlayAudioData, stopPlayAudioData ".concat(r100));
        if (this.f377741p == false) goto L5;
        QuicCallService r102 = F2();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "endMethod");
        r101.i("QuicCallService", "stopPlayAudioData, stopAudioPlay ".concat(r100));
        r102.i().C(r100);
    L5:
        IAudioUrlPlayService r103 = (IAudioUrlPlayService) ServiceManager.get().getService(IAudioUrlPlayService.class);
        if (r103 == null) goto L8;
        r103.C(r100);
    L8:
        zh8.a.f572196a.getReceiver().c().r6(null);
        AudioServiceDelegate.f288288a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
    }

    @Override // xa8.d
    public final synchronized void gq(int r100) {
        monitor-enter(this);
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L8
        r101.i(this.f377737l, "finishSession");     // Catch: Throwable -> L8
        this.f377744s.incrementAndGet();     // Catch: Throwable -> L8
        if (this.f377741p == false) goto L6;
        this.f377741p = false;     // Catch: Throwable -> L8
        QuicCallService r102 = F2();     // Catch: Throwable -> L8
        RealtimeCallParam r103 = o3a.a.a(r100, null, null);     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r103, "param");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r103, "param");     // Catch: Throwable -> L8
        r101.i("QuicCallService", "unMute");     // Catch: Throwable -> L8
        r102.f378662u.U(r103);     // Catch: Throwable -> L8
        F2().e(o3a.a.a(r100, null, null));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // xa8.d
    public final synchronized void lw(final int r100) {
        monitor-enter(this);
        FLogger.f375446a.i(this.f377737l, "startSession speakerMode " + r100);     // Catch: Throwable -> L11
        final int r101 = this.f377744s.incrementAndGet();     // Catch: Throwable -> L11
        this.f377743r = false;     // Catch: Throwable -> L11
        this.f377742q = false;     // Catch: Throwable -> L11
        Lazy r102 = MediaResourceManager.f358950a;     // Catch: Throwable -> L11
        if (z2.f365865a.realtimeCallAllSceneMixEnable() == false) goto L7;
        com.larus.media.model.a r103 = this.f377746u;     // Catch: Throwable -> L11
    L8:
        MediaResourceManager.m(r103, new e(r101, this, r100), new f(this), 0, 8);     // Catch: Throwable -> L11
        F2().f288925a = new o3a.g(this);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r103 = this.f377745t;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
