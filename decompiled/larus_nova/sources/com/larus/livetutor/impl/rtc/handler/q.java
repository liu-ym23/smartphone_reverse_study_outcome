package com.larus.livetutor.impl.rtc.handler;

import android.os.Handler;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.larus.livetutor.api.idl.CallStartedMsg;
import com.larus.livetutor.api.idl.ConnectedStatus;
import com.larus.livetutor.api.idl.Signal;
import com.larus.livetutor.api.idl.SignalType;
import com.larus.livetutor.api.idl.UploadDataMsg;
import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioFormat;
import com.ss.bytertc.engine.data.AudioFrameCallbackMethod;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.RoomStateChangeReason;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TutorRTCServiceImpl f356351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f356352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f356353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f356354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f356355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile CallStartedMsg f356356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f356357g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356358a = null;

        static {
            int[] r100 = new int[SignalType.values().length];
            r100[SignalType.CallStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r100[SignalType.CallStartFail.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r100[SignalType.UserAsrEnd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[SignalType.AnswerStart.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[SignalType.AnswerEnd.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r100[SignalType.UserAsrStart.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r100[SignalType.Error.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[SignalType.Subtitle.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[SignalType.BoardMessage.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r100[SignalType.LoadingStart.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r100[SignalType.LiveTutorStart.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r100[SignalType.WaitUserAnswer.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[SignalType.LiveTutorRoundEnd.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r100[SignalType.ClearSubtitle.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r100[SignalType.LiveTutorReplayStart.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r100[SignalType.LiveTutorModifyTtsSpeedAck.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            f356358a = r100;
        }
    }

    public static final class c implements jj9.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f356359a;

        public c(q r100) {
            this.f356359a = r100;
        }

        @Override // jj9.c
        public final void a(final String r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            final q r101 = this.f356359a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "msg");
            r101.f356353c.post(new o(r101, r100));
        }
    }

    static {
    }

    public final void a() {
        if (this.f356355e == true) goto L5;
        return;
    L5:
        if (this.f356356f == null) goto L22;
        this.f356351a.f().getClass();
        Intrinsics.checkNotNullParameter("rtc_core_call_start", "scene");
        v r100 = this.f356351a.h();
        CallStartedMsg r101 = this.f356356f;
        if (r101 == null) goto L9;
        ConnectedStatus r102 = r101.getStartStatus();
    L10:
        r100.b(new RTCAction.ConnectSuccess(r102));
        Object r103 = this.f356354d;
        monitor-enter(r103);
        this.f356355e = false;     // Catch: Throwable -> L16
        this.f356356f = null;     // Catch: Throwable -> L16
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r103);
        return;
    L16:
        th = move-exception;
        throw th;
    L9:
        r102 = null;
        goto L10
    }

    public q(TutorRTCServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        this.f356351a = r100;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("RTCMsgParse");
        ThreadMethodProxy.start(r101);
        this.f356352b = r101;
        this.f356353c = new Handler(r101.getLooper());
        this.f356354d = new Object();
        this.f356357g = "";
    }

    public final void b(RoomStateChangeReason r100) {
        if (r100 != RoomStateChangeReason.JOIN_ROOM) goto L8;
        TutorRTCServiceImpl r101 = this.f356351a;
        com.larus.livetutor.impl.rtc.b r102 = r101.f356250o;
        String r103 = r101.f356255t;
        c r104 = new c(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "callback");
        FLogger.f375446a.i("RTCManager", "registerAudioFrameObserver userId = " + r103);
        RTCEngine r105 = r102.f356277a;
        if (r105 == null) goto L9;
        r105.enableAudioFrameCallback(AudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_REMOTE_USER, new AudioFormat(AudioSampleRate.AUDIO_SAMPLE_RATE_AUTO, AudioChannel.AUDIO_CHANNEL_AUTO));
        r105.registerAudioFrameObserver(new com.larus.livetutor.impl.rtc.c(r103, r104));
        return;
    L9:
        return;
    }

    public final void c(Signal r100, jj9.a<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.LAUNCH_FROM_SIGNAL);
        Intrinsics.checkNotNullParameter(r101, "callback");
        w r102 = this.f356351a.i();
        UploadDataMsg r103 = r100.getUploadDataMsg();
        if (r103 == null) goto L5;
        r102.f356370b.tryEmit(r103);
    L6:
        String r104 = UtilsKt.u(r100);
        TutorRTCServiceImpl r105 = this.f356351a;
        long r106 = r105.f356250o.d(r105.f356255t, r104, MessageConfig.RELIABLE_ORDERED);
        int r107 = m.f356343c;
        this.f356351a.e().b("RTCMsgUtil", "send msg id = " + r106 + " content = " + r104, false);
        if (r106 > 0) goto L9;
        this.f356351a.e().a("RTCMsgUtil", "send msg failed cause error = " + r106);
        r101.onFail((int) r106, "send msg failed cause error = " + r106);
        return;
    L9:
        ((z) this.f356351a.f356242g.getValue()).f356384c.put(Long.valueOf(r106), r101);
        return;
    L5:
        r102.getClass();
        goto L6
    }
}
