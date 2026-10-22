package com.larus.im.internal.audio.session.v2;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.audio.call.record.AVInnerRecordAdapter$linkAudioRecorder$1;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.internal.network.adapter.abs.ProtocolMode;
import com.larus.im.internal.network.link.impl.rtc.RTCConnectionType;
import com.larus.im.internal.network.link.impl.rtc.abs.FlowRTCLinkSession;
import com.larus.im.internal.network.proto2.AvCmd;
import com.larus.im.internal.rtcsdk.service.AudioEncodeType;
import com.larus.im.internal.trace.legacy.RTCEstablishReportScene;
import com.larus.im.internal.trace.stable.FlowAVSessionStableTrace;
import com.larus.im.internal.utils.TimerUtils;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.im.service.audio.AvConnectionType;
import com.larus.im.service.audio.MediaSession;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.bytertc.engine.data.AudioRenderType;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class CommonV2MediaSession extends MediaSession implements qf9.e {
    public volatile cf9.d A;
    public final LinkedBlockingQueue<com.larus.im.service.audio.l> B;
    public final Lazy C;
    public final Lazy D;
    public final z0 E;
    public final b F;
    public final a G;
    public com.larus.im.service.audio.o H;
    public volatile long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final e f347403J;
    public boolean K;
    public final c L;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final d Q;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f347404z;

    public final class a implements com.larus.im.service.audio.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonV2MediaSession f347405a;

        public a(CommonV2MediaSession r100) {
            this.f347405a = r100;
        }

        @Override // com.larus.im.service.audio.m
        public final com.larus.im.internal.rtcsdk.impl.a a(com.larus.im.internal.rtcsdk.impl.a r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            CommonV2MediaSession r101 = this.f347405a;
            if (r101.f350644a.f350816k.f350693f != AvAudioKitMode.PURE_RTC) goto L8;
            int r102 = r100.f349839a.length;
            if (r101.f350660q == false) goto L8;
            if (r102 <= 0) goto L8;
            r101.f350659p.incrementAndGet();
            r101.f350657n.addAndGet(r102);
        L8:
            int r103 = 0;
            if (r100.f349842d.f350022f == false) goto L28;
            com.larus.im.internal.delegate.w.c r104 = com.larus.im.internal.delegate.w.j().f348360e;
            boolean r105 = true;
            if (r104 == null) goto L13;
            boolean r106 = r104.f348343o;
        L14:
            if (r106 == false) goto L28;
            he9.a.C6134a r107 = ge9.d.a().f481028b.a(r100.f349840b);
            CommonV2MediaSession r108 = this.f347405a;
            if (r107 == null) goto L18;
            long r109 = r107.f484898e;
        L19:
            r0 r110 = (r0) r108.f350648e.a(r0.class);
            if (r110 == null) goto L28;
            Integer r111 = Integer.valueOf((int) r109);
            SpeechRealtimeCallTask r112 = r110.f347459g;
            if (r112 != null) goto L24;
        L26:
            r105 = false;
        L27:
            r110.f347455c.e("SAMICoreInterceptorProvider", "[resetLoudness] Task reset loudness parameter result(" + r105 + ").");
            goto L28
        L24:
            if (r112.setLocalParam(303, r111) != 0) goto L26;
        L18:
            r109 = 0;
            goto L19
        L13:
            r106 = true;
        L28:
            CommonV2MediaSession r113 = this.f347405a;
            ByteBuffer r114 = com.flow.kmp.common.util.b.g(r100.f349839a);
            if (r114 != null) goto L31;
            r114 = ByteBuffer.allocate(0);
        L31:
            Intrinsics.checkNotNull(r114);
            byte[] r115 = r100.f349840b;
            byte[] r116 = null;
            if (r115 == null) goto L34;
            ByteBuffer r117 = com.flow.kmp.common.util.b.g(r115);
        L35:
            nd9.b.a r118 = (nd9.b.a) r113.f350648e.b(new nd9.b.a(r114, r117), new n(), new o());
            byte[] r119 = com.flow.kmp.common.util.b.e(r118.f518809a);
            ByteBuffer r120 = r118.f518810b;
            if (r120 == null) goto L38;
            r116 = com.flow.kmp.common.util.b.e(r120);
        L38:
            ByteBuffer r121 = r118.f518810b;
            if (r121 == null) goto L42;
            r103 = r121.capacity();
        L42:
            return new com.larus.im.internal.rtcsdk.impl.a(r119, r116, r103);
        L34:
            r117 = null;
            goto L35
        }
    }

    public final class b implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonV2MediaSession f347406a;

        public b(CommonV2MediaSession r100) {
            this.f347406a = r100;
        }

        @Override // com.larus.im.internal.audio.session.v2.q0
        public final void a(nd9.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
        }

        @Override // com.larus.im.internal.audio.session.v2.q0
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
            fe9.c.f476624a.e(this.f347406a.f347404z, "[onSpeechOnlyEvent] eventName: " + r100 + ", payload: " + r101);
            if (this.f347406a.L() == false) goto L5;
            return;
        L5:
            final we9.g r102 = new we9.g(r100, r101);
            final CommonV2MediaSession r103 = this.f347406a;
            this.f347406a.W(MediaSession.U(r103, null, new g0(r103, r102), 5), r102, false);
        }
    }

    public static final class c extends ue9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonV2MediaSession f347407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.larus.im.service.audio.x0 f347408b;

        @Override // ue9.a
        public final void a(ue9.f r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            Intrinsics.checkNotNullParameter(r100, "frame");
            if ((r100.getType() instanceof ue9.g.a) == false) goto L20;
            CommonV2MediaSession r101 = this.f347407a;
            byte[] r102 = r100.f549867a;
            String r103 = r100.f549872f;
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            r101.P(new com.larus.im.service.audio.l(r102, r103, r100.getType(), r100.f549871e));
            CommonV2MediaSession r104 = this.f347407a;
            if (r104.K == true) goto L15;
            r104.K = true;
            if (this.f347408b.f350816k.f350693f == AvAudioKitMode.PURE_RTC) goto L15;
            rf9.a r105 = r104.Z();
            if (r105 == null) goto L15;
            r105.b();
        L15:
            if (sf9.a.b(sf9.a.f(r100.f549872f), "status", -1) != 1) goto L21;
            CommonV2MediaSession r106 = this.f347407a;
            r106.K = false;
            rf9.a r107 = r106.Z();
            if (r107 == null) goto L22;
            r107.g();
            return;
        L22:
            return;
        L21:
            return;
        }

        public c(CommonV2MediaSession r100, com.larus.im.service.audio.x0 r101) {
            this.f347407a = r100;
            this.f347408b = r101;
        }
    }

    public static final class d extends ue9.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonV2MediaSession f347409a;

        public d(CommonV2MediaSession r100) {
            this.f347409a = r100;
        }

        @Override // ue9.d
        public final void c(ff9.i.u r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r100, "result");
            fe9.c.f476624a.e(this.f347409a.f347404z, "[onMessageSendResult] message send result: " + r100 + '.');
            CommonV2MediaSession r101 = this.f347409a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "result");
            monitor-enter(r101);
            cf9.d r102 = r101.A;     // Catch: Throwable -> L45
            monitor-exit(r101);
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (r102 != null) goto L9;
        L15:
            boolean r103 = false;
        L16:
            if (r103 == true) goto L18;
            return;
        L18:
            if (r100.f476751b != 0) goto L43;
            Intrinsics.checkNotNullParameter(r100, "result");
            ue9.i r104 = r101.H();
            Object r105 = null;
            if ((r104 instanceof FlowRTCLinkSession) == false) goto L22;
            FlowRTCLinkSession r106 = (FlowRTCLinkSession) r104;
        L23:
            if (r106 == null) goto L27;
            ff9.s r107 = r106.f349259w;
            if (r107 == null) goto L27;
            r107.e();
        L27:
            ReentrantReadWriteLock r108 = if9.c.f489641a;
            String r109 = r101.H().getTraceId();
            ReentrantReadWriteLock.ReadLock r110 = if9.c.f489641a.readLock();
            r110.lock();
            if9.b r111 = if9.c.f489642b.get(r109);     // Catch: Throwable -> L40
            if (r111 == null) goto L35;
            if9.a r112 = r111.c("RTCBusinessConnectStep");     // Catch: Throwable -> L40
            if (r112 == null) goto L35;
            r105 = jf9.b.class.cast(r112);     // Catch: ClassCastException -> L34 Throwable -> L40
        L35:
            r110.unlock();
            jf9.b r113 = (jf9.b) r105;
            if (r113 == null) goto L54;
            long r114 = SystemClock.elapsedRealtime();
            if (r113.f498909m > 0) goto L55;
            r113.f498909m = r114;
            return;
        L55:
            return;
        L54:
            return;
        L40:
            th = move-exception;
            r110.unlock();
            throw th;
        L22:
            r106 = null;
            goto L23
        L43:
            r101.a0(r100);
            return;
        L9:
            if (cf9.e.a(r102) == false) goto L15;
            if (cf9.e.a(r100.f476750a) == false) goto L15;
            if (Intrinsics.areEqual(r100.f476750a, r102) == false) goto L15;
            r103 = true;
        L45:
            th = move-exception;
            throw th;
        }

        @Override // ue9.e
        public final void d(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            CommonV2MediaSession r102 = this.f347409a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "event");
            if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_START_CALL") == true) goto L5;
            return;
        L5:
            if (od9.a.a(r102.f350644a) != AvConnectionType.TokenPoolWithRTCMerge) goto L14;
            fe9.a.f476620a.f(r102.f347404z, "[handleOtherEvent] token pool with rtc merge, not need send start call.");
            ue9.i r103 = r102.H();
            if ((r103 instanceof FlowRTCLinkSession) == false) goto L9;
            FlowRTCLinkSession r104 = (FlowRTCLinkSession) r103;
        L10:
            if (r104 == null) goto L17;
            ff9.s r105 = r104.f349259w;
            if (r105 == null) goto L18;
            r105.e();
            return;
        L18:
            return;
        L17:
            return;
        L9:
            r104 = null;
            goto L10
        L14:
            CommonV2MediaSession.b0(r102);
        }
    }

    public static final class e implements kd9.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonV2MediaSession f347410a;

        @Override // kd9.s
        public final void a(long r100, long r101) {
        }

        @Override // kd9.s
        public final void b(ouc.d0 r100) {
        }

        @Override // kd9.s
        public final void e(Integer r100) {
        }

        @Override // kd9.s
        public final void h(boolean r100) {
        }

        public e(CommonV2MediaSession r100) {
            this.f347410a = r100;
        }

        @Override // kd9.s
        public final void c(com.larus.im.internal.rtcsdk.impl.trace.b r100) {
            if (r100 == null) goto L7;
            long r101 = r100.c();
            if (r101 <= 0) goto L8;
            this.f347410a.I = r101;
            return;
        L8:
            return;
        }

        @Override // kd9.s
        public final void d(ouc.d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "traceInfo");
            this.f347410a.I = 0;
        }

        @Override // kd9.s
        public final void f(ouc.d0 r100) {
            CommonV2MediaSession r101 = this.f347410a;
            long r102 = r101.I;
            r101.getClass();
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
            r0 r104 = (r0) r101.f350648e.a(r0.class);     // Catch: Throwable -> L9
            if (r104 == null) goto L6;
            Boolean r105 = Boolean.valueOf(r104.c(r102));     // Catch: Throwable -> L9
        L7:
            Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
        L11:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L14;
            fe9.c.f476624a.c(r101.f347404z, "[notifyTTSPlayEnd] notify TTS play end failed.", r107);
        L14:
            this.f347410a.I = 0;
            return;
        L6:
            r105 = null;
        L9:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final he9.d J() {
        return (le9.b) this.P.getValue();
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void Q() {
        if (this.f350644a.f350817l == false) goto L9;
        y0 r100 = (y0) this.N.getValue();
        List r101 = CollectionsKt.toList(r100.f347491a);
        r101.size();
        r100.f347491a.clear();
        fe9.c.f476624a.e(this.f347404z, "replay messages, count: " + r101.size());
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        y0.b r103 = (y0.b) r102.next();
        W(V(r103.f347494c, true), r103.f347493b, true);
        fe9.c.f476624a.e(this.f347404z, "send message, type: " + r103.getType());
    L9:
        ue9.i r104 = H();
        FlowRTCLinkSession r105 = null;
        if ((r104 instanceof FlowRTCLinkSession) == false) goto L12;
        FlowRTCLinkSession r106 = (FlowRTCLinkSession) r104;
    L13:
        if (r106 != null) goto L15;
    L22:
        super.Q();
        ue9.i r107 = H();
        if ((r107 instanceof FlowRTCLinkSession) == false) goto L25;
        r105 = (FlowRTCLinkSession) r107;
    L25:
        if (r105 == null) goto L29;
        com.larus.im.internal.network.link.impl.rtc.o r108 = r105.f349261y;
        r108.getClass();
        fe9.a.f476620a.e(r108.f349229b, "[ignoreLost] update:false");
        return;
    L29:
        return;
    L15:
        if ((r106.F instanceof ue9.b.a) == true) goto L17;
    L21:
        fe9.a.f476620a.b("FlowRTCLinkSession", "[publishAudio] connect: " + r106.F + ", destroyed: " + r106.f349255s.get());
        goto L22
    L17:
        if (r106.f349255s.get() == true) goto L21;
        ff9.s r109 = r106.f349259w;
        if (r109 == null) goto L22;
        r109.h();
        goto L22
    L12:
        r106 = null;
        goto L13
    }

    public final rf9.a Z() {
        return (rf9.a) this.M.getValue();
    }

    @Override // id9.d
    public final com.larus.im.service.audio.y a() {
        return (com.larus.im.service.audio.y) this.D.getValue();
    }

    @Override // id9.e
    public final com.larus.im.service.audio.z e() {
        return (com.larus.im.service.audio.z) this.C.getValue();
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final com.larus.im.service.audio.q v() {
        if (this.f350644a.f350816k.f350693f != AvAudioKitMode.PURE_RTC) goto L20;
        fe9.c.f476624a.f(this.f347404z, "[createAudioPlayer]");
        com.larus.im.service.audio.q r100 = this.f350665v;
        if (r100 == null) goto L7;
        return r100;
    L7:
        FlowRTCLinkSession r101 = Y();
        ge9.d.b r102 = ge9.d.a();
        com.larus.im.service.audio.c r103 = this.f350644a.f350816k;
        kd9.g0 r104 = new kd9.g0(r101, r102, r103.f350689b, r103.f350688a, this.G);
        this.f350665v = r104;
        if (X() == false) goto L15;
        kd9.w0 r105 = r104.f502898g;
        if ((r105 instanceof kd9.r) == true) goto L13;
        r105 = null;
    L13:
        if (r105 == null) goto L15;
        r105.j(this.f347403J);
    L15:
        rf9.a r106 = Z();
        if (r106 == null) goto L18;
        r106.c(r104);
    L18:
        return r104;
    L20:
        throw new RuntimeException("createAudioPlayer, current session not support audio kit mode: " + this.f350644a.f350816k.f350693f.getType());
    }

    public static boolean X() {
        com.larus.im.internal.delegate.w.l r100 = com.larus.im.internal.delegate.w.j().f348356a;
        if (r100 == null) goto L6;
        com.larus.im.internal.delegate.w.d r101 = r100.f348407d;
        if (r101 == null) goto L6;
    L8:
        if (r101.f348350a <= 0) goto L11;
        return true;
    L11:
        return false;
    L6:
        r101 = new com.larus.im.internal.delegate.w.d(0);
        goto L8
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void E() {
        if ((H().getCurrentState() instanceof ue9.b.a) == true) goto L5;
    L7:
        fe9.a.f476620a.f(this.f347404z, "[afterConnect] not need send start call.");
        return;
    L5:
        if (od9.a.a(this.f350644a) == AvConnectionType.TokenPoolWithRTCMerge) goto L7;
        b0(this);
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void O() {
        ((com.larus.im.internal.rtcsdk.impl.s) Y().d()).K();
        fe9.c.f476624a.e(this.f347404z, "[onPseudoSessionConnected] start audio capture.");
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final boolean R() {
        super.R();
        rf9.a r100 = Z();
        if (r100 == null) goto L5;
        r100.a(this);
    L5:
        H().l(this.Q);
        AvAudioKitMode r101 = AvAudioKitMode.PURE_RTC;
        AvAudioKitMode r102 = AvAudioKitMode.MIX_SPEECH_BIZ;
        boolean r103 = !CollectionsKt.listOf(new AvAudioKitMode[]{r101, r102}).contains(this.f350644a.f350816k.f350693f);
        AvAudioKitMode r104 = this.f350644a.f350816k.f350693f;
        if (r104 == r101) goto L8;
        boolean r105 = true;
    L9:
        if (r103 == false) goto L14;
        if (r104 != r102) goto L12;
        AudioEncodeType r106 = AudioEncodeType.OPUS;
    L13:
        FlowRTCLinkSession r107 = Y();
        com.larus.im.service.audio.c r108 = this.f350644a.f350816k;
        r107.n(r108.f350691d, r108.f350690c, r106);
        goto L14
    L12:
        r106 = AudioEncodeType.PCM_16;
    L14:
        if (r105 == false) goto L19;
        FlowRTCLinkSession r109 = Y();
        com.larus.im.service.audio.c r110 = this.f350644a.f350816k;
        int r111 = r110.f350689b;
        int r112 = r110.f350688a;
        a r113 = this.G;
        ge9.d.b r114 = ge9.d.a();
        k0 r115 = new k0(this);
        r109.getClass();
        ((com.larus.im.internal.rtcsdk.impl.s) r109.d()).k(new ff9.c(AudioRenderType.AUDIO_RENDER_TYPE_EXTERNAL, r111, r112, r114));
        ff9.p r116 = ((com.larus.im.internal.rtcsdk.impl.s) r109.d()).b();
        r116.c(r109.I);
        if (r113 == null) goto L18;
        r116.a(r113);
    L18:
        r116.b(r115);
    L19:
        this.E.c(this.F);
        r0 r117 = new r0(this.f350646c, this.E);
        com.larus.im.internal.network.link.impl.sami.x r118 = r117.f347463k;
        r118.b(new SAMICoreInterceptorProvider$initialize$succeed$1$1(r117));
        r118.b(new SAMICoreInterceptorProvider$initialize$succeed$1$2(r117));
        r118.b(new SAMICoreInterceptorProvider$initialize$succeed$1$3(r117));
        if (ve9.j.d(r117.f347453a).f554475a == false) goto L22;
        r118.b(new SAMICoreInterceptorProvider$initialize$succeed$1$4(r117));
    L22:
        ouc.d0 r119 = ve9.j.f(r117.f347453a).f554488b;
        String r120 = "";
        Integer r121 = null;
        if (r119 == null) goto L25;
        String r122 = sf9.a.c(r119, "flute_vad_config", "");
    L26:
        if (r122 == null) goto L30;
        r120 = r122;
    L30:
        if (r120.length() <= 0) goto L32;
        boolean r123 = true;
    L33:
        if (r123 == false) goto L35;
        r118.b(new SAMICoreInterceptorProvider$initialize$succeed$1$5(r117));
    L35:
        boolean r124 = r118.a();
        r117.f347455c.e("SAMICoreInterceptorProvider", "[initialize] Provider initialize succeed(" + r124 + ").");
        if (r124 == true) goto L38;
        return false;
    L38:
        nd9.e r125 = this.f350648e;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r117, ShortVideoSegments.KEY_PROP_PROVIDER);
        r125.f518812a.add(r117);
        ue9.i r126 = H();
        if ((r126 instanceof FlowRTCLinkSession) == false) goto L41;
        FlowRTCLinkSession r127 = (FlowRTCLinkSession) r126;
    L42:
        if (r127 == null) goto L51;
        r127.C = this.f350644a.f350817l;
        ByteBuffer r128 = com.flow.kmp.common.util.b.g(((le9.b) this.P.getValue()).b(ProtocolMode.PROTO, new xe9.b(we9.a.a(this.f350644a), 14)));
        if (r128 != null) goto L46;
        fe9.c.f476624a.b(this.f347404z, "[buildStartCallMessage] message to direct buffer failed.");
        byte[] r129 = null;
    L47:
        r127.B = r129;
        fe9.a r130 = fe9.a.f476620a;
        StringBuilder r131 = new StringBuilder("[setStartSessionMessage] message size: ");
        if (r129 == null) goto L50;
        r121 = Integer.valueOf(r129.length);
    L50:
        r131.append(r121);
        r130.e("FlowRTCLinkSession", r131.toString());
        goto L51
    L46:
        r129 = com.flow.kmp.common.util.b.e((ByteBuffer) this.f350648e.b(r128, new x(), new z()));
    L51:
        return true;
    L41:
        r127 = null;
        goto L42
    L32:
        r123 = false;
        goto L33
    L25:
        r122 = null;
        goto L26
    L8:
        r105 = false;
        goto L9
    }

    public final FlowRTCLinkSession Y() {
        ue9.i r100 = H();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.im.internal.network.link.impl.rtc.abs.FlowRTCLinkSession");
        return (FlowRTCLinkSession) r100;
    }

    @Override // qf9.e
    public final String i() {
        return H().getTraceId();
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final boolean k() {
        ue9.i r100 = H();
        if ((r100 instanceof FlowRTCLinkSession) == false) goto L5;
        FlowRTCLinkSession r101 = (FlowRTCLinkSession) r100;
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.f349239c;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final void t() {
        if (L() == false) goto L21;
        return;
    L21:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        r0 r101 = (r0) this.f350648e.a(r0.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        boolean r102 = r101.d();     // Catch: Throwable -> L11
    L9:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        fe9.c.f476624a.c(this.f347404z, "[notifyCloudWakeupIntentResult] Notify failed, result(true).", r104);
    L16:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L19;
        r103 = r105;
    L19:
        boolean r106 = ((Boolean) r103).booleanValue();
        fe9.c.f476624a.e(this.f347404z, "[notifyCloudWakeupIntentResult] result(true), handled(" + r106 + ").");
        return;
    L8:
        r102 = false;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final ue9.a I() {
        return this.L;
    }

    public CommonV2MediaSession(final com.larus.im.service.audio.x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
        this.f347404z = "CommonV2MediaSession";
        this.B = new LinkedBlockingQueue();
        this.C = LazyKt.lazy(new com.larus.im.internal.audio.session.v2.d(this));
        this.D = LazyKt.lazy(new com.larus.im.internal.audio.session.v2.e(this));
        this.E = new z0();
        this.F = new b(this);
        this.G = new a(this);
        this.f347403J = new e(this);
        this.L = new c(this, r100);
        this.M = LazyKt.lazy(new f(r100));
        this.N = LazyKt.lazy(new g());
        this.O = LazyKt.lazy(new h(r100, this));
        this.P = LazyKt.lazy(new i(this));
        this.Q = new d(this);
    }

    public static void b0(final CommonV2MediaSession r100) {
        monitor-enter(r100);
        cf9.d r101 = r100.A;     // Catch: Throwable -> L18
        monitor-exit(r100);
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (cf9.e.a(r101) != true) goto L10;
    L11:
        if (r102 == true) goto L24;
        fe9.c r103 = fe9.c.f476624a;
        String r104 = r100.f347404z;
        StringBuilder r105 = new StringBuilder("[oldSendStartCall] The current session room id = ");
        ue9.i r106 = r100.H();
        Intrinsics.checkNotNullParameter(r106, "<this>");
        r105.append(r106.o().optString("roomId"));
        r105.append("}) send start call.");
        r103.e(r104, r105.toString());
        final we9.h r107 = we9.a.a(r100.f350644a);
        cf9.d r108 = MediaSession.U(r100, new a0(r100, r107), new b0(r100, r107), 3);
        r100.W(r108, r107, false);
        if (cf9.e.a(r108) == true) goto L16;
        r100.a0(new ff9.i.u(r108, (int) r108.f23550a));
        return;
    L16:
        r100.c0(r108);
        return;
    L24:
        return;
    L10:
        r102 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // id9.d
    public final void A(com.larus.im.service.audio.o r100) {
        this.H = r100;
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final void B(final xe9.d r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (L() == false) goto L5;
        return;
    L5:
        W(MediaSession.U(this, null, new t(this, r100), 7), r100, false);
    }

    @Override // id9.e
    public final void C(SessionReleaseReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.im.internal.audio.u r101 = com.larus.im.internal.audio.u.f347501c;
        com.larus.im.internal.audio.u.f347501c.f(this, r100);
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final ue9.i G(ve9.g r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        int r100 = com.larus.im.internal.network.link.impl.rtc.c.f349293a;
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r101 = ve9.h.c(r110, "rtc_user_id");
        Intrinsics.checkNotNullParameter("ppe_info", "key");
        String r102 = "";
        Intrinsics.checkNotNullParameter("", "default");
        String r103 = r110.f554467a.get("ppe_info");
        if (r103 == null) goto L6;
        r102 = r103;
    L6:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r104 = ve9.h.b(r110, "rtc_client_connection_type", 0);
        String r105 = ve9.h.c(r110, "request_token_business");
        String r106 = ve9.h.c(r110, "request_token_sub_business");
        String r111 = ve9.h.c(r110, "stream_app");
        boolean r107 = ve9.h.a(r110, "enable_uplink_burst_mode", false);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r112 = ve9.h.c(r110, "rtc_app_id");
        boolean r113 = ve9.h.a(r110, "rtc_audio_encode_stereo", false);
        RTCConnectionType.Companion.getClass();
        RTCConnectionType[] r108 = RTCConnectionType.values();
        int r114 = r108.length;
        int r115 = 0;
    L8:
        if (r115 >= r114) goto L16;
        RTCConnectionType r116 = r108[r115];
        if (r116.getType() != r104) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == true) goto L17;
        r115 = r115 + 1;
    L17:
        if (r116 != null) goto L19;
        RTCConnectionType r117 = RTCConnectionType.Default;
    L20:
        FlowRTCLinkSession r118 = new FlowRTCLinkSession(new com.larus.im.internal.network.link.impl.rtc.p(r101, r102, r117, r105, r106, r111, r112, Boolean.valueOf(r107), r113));
        r118.A = true;
        r118.D().e();
        com.larus.im.internal.network.link.impl.rtc.o r119 = r118.f349261y;
        monitor-enter(r119);
    L28:
        th = move-exception;
        throw th;
    L23:
        if (r119.f349234g == true) goto L25;
        r119.g(SystemClock.elapsedRealtime());     // Catch: Throwable -> L28
    L25:
        r119.f349234g = true;     // Catch: Throwable -> L28
        fe9.a.f476620a.e(r119.f349229b, "[isAttached] update:true");     // Catch: Throwable -> L28
        monitor-exit(r119);
        return r118;
    L19:
        r117 = r116;
        goto L20
    L12:
        r109 = false;
        goto L13
    L16:
        r116 = null;
        goto L17
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void K(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ((com.larus.im.internal.audio.session.v2.a) this.O.getValue()).a(r100);
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final Object M(Continuation<? super Unit> r110) {
        com.flow.kmp.common.util.a r100 = new com.flow.kmp.common.util.a();
    L4:
        if (JobKt.isActive(r110.getContext()) == false) goto L48;
        if (L() == true) goto L48;
        com.larus.im.service.audio.l r101 = this.B.poll(10, TimeUnit.MILLISECONDS);
        if (JobKt.isActive(r110.getContext()) == false) goto L48;
        if (r101 == null) goto L4;
        byte[] r102 = r101.f350772a;
        boolean r103 = false;
        if (r102 == null) goto L15;
        int r104 = r102.length;
    L16:
        ByteBuffer r105 = r100.f274151a;
        if (r105 != null) goto L19;
        r105 = ByteBuffer.allocateDirect(r104);
        r100.f274151a = r105;
    L23:
        if (r102 != null) goto L25;
    L29:
        r103 = true;
    L30:
        if (r103 == true) goto L32;
        r105.put(r102);
    L32:
        ge9.d.b r106 = ge9.d.a();
        if (r106 == null) goto L37;
        ge9.d.c r107 = r106.f481027a;
        if (r107 == null) goto L37;
        byte[] r108 = r107.b(r101.f350773b);
    L38:
        ByteBuffer r109 = com.flow.kmp.common.util.b.g(r108);
        int r111 = r105.remaining();
        if (this.f350660q == false) goto L42;
        if (r111 <= 0) goto L42;
        this.f350658o.incrementAndGet();
        this.f350655l.addAndGet(r111);
    L42:
        nd9.b.a r112 = (nd9.b.a) this.f350648e.b(new nd9.b.a(r105, r109), new com.larus.im.internal.audio.session.v2.b(), new m());
        byte[] r113 = com.flow.kmp.common.util.b.e(r112.f518809a);
        ue9.g r114 = r101.getType();
        ByteBuffer r115 = r112.f518810b;
        if (r115 == null) goto L45;
        byte[] r116 = com.flow.kmp.common.util.b.e(r115);
    L46:
        ue9.f r117 = new ue9.f(r113, r114, r116, null, false, null, 56);
        H().f(r117);
        com.larus.im.service.audio.l r118 = com.larus.im.service.audio.l.a(r101, r117.f549867a, null, 30);
        Intrinsics.checkNotNullParameter(r118, "frame");
        this.f350662s.b(r118);
        goto L4
    L45:
        r116 = null;
    L37:
        r108 = null;
        goto L38
    L25:
        if (r102.length != 0) goto L27;
        boolean r119 = true;
    L28:
        if (r119 == false) goto L30;
    L27:
        r119 = false;
        goto L28
    L19:
        r105.clear();
        if (r105.capacity() == r104) goto L23;
        r105.capacity();
        r100.f274151a = null;
        r105 = ByteBuffer.allocateDirect(r104);
        r100.f274151a = r105;
        goto L23
    L15:
        r104 = 0;
    L48:
        return Unit.INSTANCE;
    }

    public final synchronized void a0(final ff9.i.u r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "result");     // Catch: Throwable -> L26
        fe9.c.f476624a.b(this.f347404z, "[onSendStartCallFailed] send start call failed, result: " + r100 + '.');     // Catch: Throwable -> L26
        FlowRTCLinkSession r101 = null;
        c0(null);     // Catch: Throwable -> L26
        ReentrantReadWriteLock r102 = if9.c.f489641a;     // Catch: Throwable -> L26
        String r103 = H().getTraceId();     // Catch: Throwable -> L26
        ReentrantReadWriteLock.ReadLock r104 = if9.c.f489641a.readLock();     // Catch: Throwable -> L26
        r104.lock();     // Catch: Throwable -> L26
        if9.b r105 = if9.c.f489642b.get(r103);     // Catch: Throwable -> L23
        if (r105 == null) goto L11;
        if9.a r106 = r105.c("RTCBusinessConnectStep");     // Catch: Throwable -> L23
        if (r106 == null) goto L11;
        Object r107 = jf9.b.class.cast(r106);     // Catch: ClassCastException -> L29 Throwable -> L23
    L12:
        r104.unlock();     // Catch: Throwable -> L26
        final jf9.b r108 = (jf9.b) r107;     // Catch: Throwable -> L26
        if (r108 == null) goto L20;
        long r109 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L26
        Function0<Unit> r110 = new d0(r108, r100);     // Catch: Throwable -> L26
        ue9.i r111 = H();     // Catch: Throwable -> L26
        if ((r111 instanceof FlowRTCLinkSession) == false) goto L17;
        r101 = (FlowRTCLinkSession) r111;     // Catch: Throwable -> L26
    L17:
        if (r101 == null) goto L19;
        r101.C(RTCEstablishReportScene.NORMAL, r109, r110);     // Catch: Throwable -> L26
        goto L20
    L19:
        r110.invoke();     // Catch: Throwable -> L26
        gf9.a.f481074a.b(H().getTraceId(), RTCEstablishReportScene.NORMAL, r109);     // Catch: Throwable -> L26
    L20:
        this.f350650g.a(ue9.c.k.f549855c);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L11:
        r107 = null;
    L23:
        th = move-exception;
        r104.unlock();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final synchronized void c0(cf9.d r100) {
        monitor-enter(this);
        this.A = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsJson");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 != null) goto L16;
        JSONObject r104 = (JSONObject) r102;
        ue9.i r105 = H();
        if ((r105 instanceof ue9.h) == false) goto L12;
        ue9.h r106 = (ue9.h) r105;
    L13:
        if (r106 == null) goto L20;
        r106.B(r104);
        return;
    L20:
        return;
    L12:
        r106 = null;
        goto L13
    L16:
        fe9.c.f476624a.c(this.f347404z, "[setRuntimeParameters] invalid params json: " + r100, r103);
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // qf9.e
    public final void g(kf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = H().getTraceId();
        if9.b r102 = new if9.b();
        r102.f489637c = r100;
        if9.b r103 = if9.c.c(r101);
        if (r103 != null) goto L5;
        if9.c.b(r101, r102);
        return;
    L5:
        r103.f489637c = r100;
    }

    @Override // qf9.e
    public final void j(FlowAVSessionStableTrace.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        H().l(r100);
    }

    @Override // com.larus.im.service.audio.MediaSession, qf9.c
    public final void l(SessionReleaseReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        super.l(r100);
        this.B.clear();
        Lazy r101 = TimerUtils.f350521a;
        kd9.r r102 = null;
        TimerUtils.a(new CommonV2MediaSession$releaseInternal$1(this, null));
        H().c(this.Q);
        rf9.a r103 = Z();
        if (r103 == null) goto L5;
        r103.d(this);
    L5:
        com.larus.im.service.audio.q r104 = this.f350665v;
        if (r104 != null) goto L8;
    L17:
        gf9.a.f481074a.c(H().getTraceId());
        return;
    L8:
        if (X() == false) goto L14;
        com.larus.im.service.audio.r r105 = r104.f();
        if ((r105 instanceof kd9.r) == false) goto L12;
        r102 = (kd9.r) r105;
    L12:
        if (r102 == null) goto L14;
        r102.s(this.f347403J);
    L14:
        rf9.a r106 = Z();
        if (r106 == null) goto L17;
        r106.h(r104);
        goto L17
    }

    @Override // id9.d
    public final void r(Map<String, ? extends Object> r100) {
        final we9.b r101 = new we9.b(r100);
        W(MediaSession.U(this, new r(this, r101), new s(this, r101), 3), r101, false);
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final void u(com.larus.im.service.audio.l r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r100, "frame");
        L();
        this.B.offer(r100);
    }

    @Override // qf9.e
    public final void z(FlowAVSessionStableTrace.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        H().c(r100);
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final boolean F(xe9.e r110, byte[] r111) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ue9.i r100 = H();
        List r101 = null;
        if ((r100 instanceof FlowRTCLinkSession) == false) goto L5;
        FlowRTCLinkSession r102 = (FlowRTCLinkSession) r100;
    L7:
        if (r102 == null) goto L9;
        boolean r103 = r102.D.get();
    L10:
        if (r103 == false) goto L69;
        y0 r104 = (y0) this.N.getValue();
        Function1 r105 = new e0(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r105, "onClearCacheAudio");
        FlowAVMessageReplayEnqueueType r106 = FlowAVMessageReplayEnqueueType.UNKNOWN;
        if ((r110 instanceof xe9.c) == false) goto L15;
        final Integer r107 = Integer.valueOf(com.larus.im.internal.network.adapter.impl.v2.converter.e.a((xe9.c) r110).getNumber());
    L23:
        if (r107 != null) goto L26;
        fe9.c.f476624a.f("SessionMessageReplayStrategy", "message type is null, model: " + r110);
        goto L69
    L26:
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(AvCmd.CommandEventType.SWITCH_SCENE.getNumber()), Integer.valueOf(AvCmd.CommandEventType.SWITCH_MODAL.getNumber())}).contains(r107) == false) goto L28;
        r105.invoke(r107);
    L28:
        int r108 = r107.intValue();
        com.larus.im.internal.delegate.w.a r109 = com.larus.im.internal.delegate.w.j().f348361f;
        if (r109 == null) goto L32;
        List<Integer> r112 = r109.f348290c;
        if (r112 == null) goto L32;
    L34:
        if (r112.contains(Integer.valueOf(r108)) == false) goto L36;
        fe9.c.f476624a.e("SessionMessageReplayStrategy", "message filtered, type: " + r107);
        goto L69
    L36:
        int r113 = r107.intValue();
        com.larus.im.internal.delegate.w.a r114 = com.larus.im.internal.delegate.w.j().f348361f;
        if (r114 == null) goto L40;
        List<Integer> r115 = r114.f348291d;
        if (r115 == null) goto L40;
    L42:
        if ((!r115.contains(Integer.valueOf(r113))) == true) goto L44;
    L46:
        int r116 = r107.intValue();
        Map r117 = new LinkedHashMap();
        com.larus.im.internal.delegate.w.a r118 = com.larus.im.internal.delegate.w.j().f348361f;
        if (r118 == null) goto L56;
        Map<String, List<Integer>> r119 = r118.f348292e;
        if (r119 == null) goto L56;
        Iterator<Map.Entry<String, List<Integer>>> r120 = r119.entrySet().iterator();
    L52:
        if (r120.hasNext() == false) goto L57;
        Map.Entry<String, List<Integer>> r121 = r120.next();
        List<Integer> r122 = r121.getValue();
        if (r122 == null) goto L52;
        r117.put(r121.getKey(), r122);
    L57:
        List r123 = (List) r117.get(String.valueOf(r116));
        if (r123 == null) goto L61;
        r101 = r123;
    L61:
        if (r101 == null) goto L68;
        Iterator r124 = r101.iterator();
    L64:
        if (r124.hasNext() == false) goto L68;
        final int r125 = ((Number) r124.next()).intValue();
        if (CollectionsKt.removeAll(r104.f347491a, new x0(r125)) == false) goto L64;
        FlowAVMessageReplayEnqueueType r126 = FlowAVMessageReplayEnqueueType.UNKNOWN;
        fe9.c.f476624a.e("SessionMessageReplayStrategy", "message overridden (removed all old overrideable messages), newType: " + r107 + ", oldType: " + r125);
    L68:
        r104.f347491a.add(new y0.b(r107.intValue(), r110, r111));
        fe9.c.f476624a.e("SessionMessageReplayStrategy", "message enqueued, type: " + r107);
    L56:
        r117 = com.larus.im.internal.delegate.w.b();
        goto L57
    L44:
        if (CollectionsKt.removeAll(r104.f347491a, new w0(r107)) == false) goto L46;
        fe9.c.f476624a.e("SessionMessageReplayStrategy", "message deduplicated (removed all old same-type messages), type: " + r107);
    L40:
        r115 = CollectionsKt.emptyList();
    L32:
        r112 = com.larus.im.internal.delegate.w.a();
        goto L34
    L15:
        if ((r110 instanceof xe9.f) == false) goto L21;
        xe9.f r127 = (xe9.f) r110;
        Intrinsics.checkNotNullParameter(r127, "<this>");
        if ((r127 instanceof we9.i) == false) goto L19;
        AvCmd.CommandEventType r128 = AvCmd.CommandEventType.SWITCH_MODAL;
    L20:
        r107 = Integer.valueOf(r128.getNumber());
        goto L23
    L19:
        r128 = AvCmd.CommandEventType.COMMON_UNUSED;
        goto L20
    L21:
        r107 = null;
    L69:
        return r103;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final void m(ModalType r100, TargetVideoSourceType r101) {
        Intrinsics.checkNotNullParameter(r100, "modalType");
        Intrinsics.checkNotNullParameter(r101, "videoSourceType");
        final we9.i r102 = new we9.i(ve9.j.g(this.f350646c), r100, r101);
        W(MediaSession.U(this, new f0(this, r102), new com.larus.im.internal.audio.session.v2.c(this, r102), 3), r102, false);
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void W(cf9.d r100, xe9.e r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "ticket");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super.W(r100, r101, r102);
        Integer r103 = null;
        if ((r101 instanceof xe9.c) == false) goto L11;
        rf9.a r104 = Z();
        if (r104 == null) goto L44;
        xe9.c r105 = (xe9.c) r101;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        int r106 = AvCmd.AVCMD.COMMAND_SIGNAL_UPLINK.getNumber();
        AvCmd.CommandEventType r107 = com.larus.im.internal.network.adapter.impl.v2.converter.e.a(r105);
        if (r107 == null) goto L9;
        r103 = Integer.valueOf(r107.getNumber());
    L9:
        r104.f(r100, r106, r102, r103);
    L44:
        if ((r101 instanceof we9.d) == false) goto L49;
        rf9.a r108 = Z();
        if (r108 == null) goto L50;
        r108.onInterrupt();
        return;
    L50:
        return;
    L49:
        return;
    L11:
        if ((r101 instanceof xe9.a) == false) goto L23;
        rf9.a r109 = Z();
        if (r109 == null) goto L44;
        xe9.a r110 = (xe9.a) r101;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if ((r110 instanceof we9.h) == false) goto L18;
        AvCmd.AVCMD r111 = AvCmd.AVCMD.START_SESSION;
    L21:
        r109.f(r100, r111.getNumber(), r102, null);
        goto L44
    L18:
        if ((r110 instanceof we9.c) == false) goto L20;
        r111 = AvCmd.AVCMD.FINISH_SESSION;
        goto L21
    L20:
        r111 = AvCmd.AVCMD.COMMAND_SIGNAL_UPLINK;
        goto L21
    L23:
        if ((r101 instanceof xe9.f) == false) goto L39;
        rf9.a r112 = Z();
        if (r112 == null) goto L34;
        xe9.f r113 = (xe9.f) r101;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        int r114 = AvCmd.AVCMD.COMMAND_SIGNAL_UPLINK.getNumber();
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if ((r113 instanceof we9.i) == false) goto L29;
        AvCmd.CommandEventType r115 = AvCmd.CommandEventType.SWITCH_MODAL;
    L30:
        if (r115 == null) goto L32;
        r103 = Integer.valueOf(r115.getNumber());
    L32:
        r112.f(r100, r114, r102, r103);
        goto L34
    L29:
        r115 = AvCmd.CommandEventType.COMMON_UNUSED;
    L34:
        if ((r101 instanceof we9.i) == false) goto L44;
        rf9.a r116 = Z();
        if (r116 == null) goto L44;
        we9.i r117 = (we9.i) r101;
        r116.e(r117.f559433b, r117.f559434c);
        goto L44
    L39:
        if ((r101 instanceof xe9.d) == false) goto L44;
        rf9.a r118 = Z();
        if (r118 == null) goto L44;
        Intrinsics.checkNotNullParameter((xe9.d) r101, "<this>");
        r118.f(r100, AvCmd.AVCMD.FILE_UPLINK.getNumber(), false, null);
        goto L44
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final com.larus.im.service.audio.n c(int r110, AvAecType r111, AVInnerRecordAdapter$linkAudioRecorder$1 r112) {
        Intrinsics.checkNotNullParameter(r111, "aecType");
        Intrinsics.checkNotNullParameter(r112, "preProcessor");
        AvAudioKitMode r100 = AvAudioKitMode.MIX_SPEECH_BIZ;
        if (CollectionsKt.listOf(new AvAudioKitMode[]{AvAudioKitMode.PURE_RTC, r100}).contains(this.f350644a.f350816k.f350693f) == false) goto L14;
        fe9.c.f476624a.f(this.f347404z, "[createAudioRecorder] aec type: " + r111);
        com.larus.im.service.audio.n r101 = this.f350666w;
        if (r101 == null) goto L8;
        return r101;
    L8:
        if (this.f350644a.f350816k.f350693f != r100) goto L10;
        FlowRTCLinkSession r102 = Y();
        z0 r103 = this.E;
        ue9.i r104 = H();
        ge9.d.b r105 = ge9.d.a();
        com.larus.im.service.audio.c r106 = this.f350644a.f350816k;
        com.larus.im.service.audio.n r107 = new kd9.y0(r102, r103, r104, r105, r106.f350691d, r106.f350690c, new i0(this, r112));
    L11:
        this.f350666w = r107;
        return r107;
    L10:
        FlowRTCLinkSession r108 = Y();
        ge9.d.b r109 = ge9.d.a();
        com.larus.im.service.audio.c r113 = this.f350644a.f350816k;
        r107 = new kd9.f0(r108, r109, r113.f350691d, r113.f350690c, r110, r111, r113.f350695h, r113.f350698k, r113.f350699l, new j0(this, r112));
        goto L11
    L14:
        throw new RuntimeException("createAudioRecorder, current session not support audio kit mode " + this.f350644a.f350816k.f350693f.getType());
    }
}
