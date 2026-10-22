package com.larus.im.internal.audio.session.v2;

import com.bytedance.common.wschannel.WsConstants;
import com.mammon.speechaudiosdk.session.SpeechSessionManager;
import com.mammon.speechaudiosdk.session.callback.SpeechHostInjectionCallback;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionDownlinkCallbackParam;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionUplinkParam;
import com.mammon.speechaudiosdk.session.param.SpeechVoiceAssistantPlayerEvent;
import com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask;
import com.mammon.speechlinklayersdk.SpeechLinkLayer;
import com.mammon.speechlinklayersdk.SpeechLinkLayerCallback;
import com.mammon.speechlinklayersdk.param.SpeechHostInjectionDownlinkParam;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerUplinkCallbackParam;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r0 implements nd9.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f347452l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve9.g f347453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f347454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe9.d f347455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpeechSessionManager f347456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile d f347457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile b f347458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile SpeechRealtimeCallTask f347459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile SpeechLinkLayer f347460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f347461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f347462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larus.im.internal.network.link.impl.sami.x f347463k;

    public static final class a {
    }

    public static final class b implements nd9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpeechLinkLayer f347464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fe9.d f347465b;

        public b(SpeechLinkLayer r100) {
            Intrinsics.checkNotNullParameter(r100, "linkLayer");
            this.f347464a = r100;
            this.f347465b = fe9.d.f476625a;
        }

        @Override // nd9.b
        public final nd9.b.a a(nd9.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            if (((Boolean) com.larus.im.internal.delegate.w.f348281q.getValue()).booleanValue() == true) goto L5;
            return r100;
        L5:
            SpeechHostInjectionDownlinkParam r101 = new SpeechHostInjectionDownlinkParam();
            r101.audioData = r100.f518809a;
            r101.audioExtraPbData = r100.f518810b;
            r101.speechEvent = 1;
            c r102 = new c(0);
            r101.userContext = r102;
            int r103 = this.f347464a.processDownlinkData(r101);
            if (r103 != 0) goto L14;
            Object r104 = r102.f347466a;
            if ((r104 instanceof nd9.b.a) == false) goto L10;
            nd9.b.a r105 = (nd9.b.a) r104;
        L11:
            if (r105 != null) goto L16;
            return r100;
        L16:
            return r105;
        L10:
            r105 = null;
            goto L11
        L14:
            this.f347465b.b("ReceiveInterceptor", "Intercept receive frame failed, reason(" + r103 + ").");
            return r100;
        }

        @Override // nd9.b
        public final ByteBuffer b(ByteBuffer r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            SpeechHostInjectionDownlinkParam r101 = new SpeechHostInjectionDownlinkParam();
            r101.eventPbData = r100;
            r101.speechEvent = 0;
            c r102 = new c(0);
            r101.userContext = r102;
            int r103 = this.f347464a.processDownlinkData(r101);
            if (r103 != 0) goto L11;
            Object r104 = r102.f347466a;
            if ((r104 instanceof ByteBuffer) == false) goto L7;
            ByteBuffer r105 = (ByteBuffer) r104;
        L8:
            if (r105 != null) goto L13;
            return r100;
        L13:
            return r105;
        L7:
            r105 = null;
            goto L8
        L11:
            this.f347465b.b("ReceiveInterceptor", "Intercept receive message failed, reason(" + r103 + ").");
            return r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f347466a;

        public c() {
            this(0);
        }

        public c(int r100) {
            this.f347466a = null;
        }
    }

    public static final class d implements nd9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpeechRealtimeCallTask f347467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fe9.d f347468b;

        public d(SpeechRealtimeCallTask r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            this.f347467a = r100;
            this.f347468b = fe9.d.f476625a;
        }

        @Override // nd9.b
        public final nd9.b.a a(nd9.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            SpeechHostInjectionUplinkParam r101 = new SpeechHostInjectionUplinkParam();
            r101.speechEvent = 1;
            r101.audioData = r100.f518809a;
            r101.audioExtraPbData = r100.f518810b;
            c r102 = new c(0);
            r101.userContext = r102;
            int r103 = this.f347467a.sendHostInjectionUplinkData(r101);
            if (r103 != 0) goto L11;
            Object r104 = r102.f347466a;
            if ((r104 instanceof nd9.b.a) == false) goto L7;
            nd9.b.a r105 = (nd9.b.a) r104;
        L8:
            if (r105 != null) goto L13;
            return r100;
        L13:
            return r105;
        L7:
            r105 = null;
            goto L8
        L11:
            this.f347468b.b("SendInterceptor", "Intercept push frame failed, reason(" + r103 + ").");
            return r100;
        }

        @Override // nd9.b
        public final ByteBuffer b(ByteBuffer r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            SpeechHostInjectionUplinkParam r101 = new SpeechHostInjectionUplinkParam();
            r101.speechEvent = 0;
            r101.eventPbData = r100;
            c r102 = new c(0);
            r101.userContext = r102;
            int r103 = this.f347467a.sendHostInjectionUplinkData(r101);
            if (r103 != 0) goto L11;
            Object r104 = r102.f347466a;
            if ((r104 instanceof ByteBuffer) == false) goto L7;
            ByteBuffer r105 = (ByteBuffer) r104;
        L8:
            if (r105 != null) goto L13;
            return r100;
        L13:
            return r105;
        L7:
            r105 = null;
            goto L8
        L11:
            this.f347468b.b("SendInterceptor", "Intercept send message failed, reason(" + r103 + ").");
            return r100;
        }
    }

    public static final class e implements SpeechLinkLayerCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f347469a;

        public e(r0 r100) {
            this.f347469a = r100;
        }

        @Override // com.mammon.speechlinklayersdk.SpeechLinkLayerCallback
        public final void onUplinkCallback(SpeechLinkLayerUplinkCallbackParam r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = r100.speechEvent;
            if (r101 >= 0) goto L8;
            this.f347469a.f347455c.b("SAMICoreInterceptorProvider", "[onUplinkCallback] An event(" + r101 + ") that cannot be processed");
            return;
        L8:
            Object r102 = r100.userContext;
            ByteBuffer r103 = null;
            if ((r102 instanceof c) == false) goto L11;
            c r104 = (c) r102;
        L13:
            if (r101 != 1) goto L15;
            ByteBuffer r105 = r100.audioData;
            if (r105 == null) goto L41;
            ByteBuffer r106 = com.flow.kmp.common.util.b.b(r105);
        L42:
            if (r106 != null) goto L45;
            this.f347469a.f347455c.b("SAMICoreInterceptorProvider", "[onUplinkCallback] Audio data buffer is Null.");
            return;
        L45:
            ByteBuffer r107 = r100.audioExtraPbData;
            if (r107 == null) goto L48;
            r103 = com.flow.kmp.common.util.b.b(r107);
        L48:
            nd9.b.a r108 = new nd9.b.a(r106, r103);
            z0 r109 = this.f347469a.f347454b;
            r109.getClass();
            Intrinsics.checkNotNullParameter(r108, "frame");
            if (r109.f347496b == true) goto L52;
        L58:
            if (r104 == null) goto L66;
            r104.f347466a = r108;
            return;
        L66:
            return;
        L52:
            if (r109.f347495a.isEmpty() == false) goto L54;
            fe9.c.f476624a.f("SpeechDataObservable", "[notifyUplinkAudioData] No uplink audio observers registered.");
            goto L58
        L54:
            Iterator<T> r110 = r109.f347495a.iterator();
        L56:
            if (r110.hasNext() == false) goto L58;
            ((q0) r110.next()).a(r108);
            goto L56
        L41:
            r106 = null;
            goto L42
        L15:
            if (r101 == 2) goto L24;
            ByteBuffer r111 = r100.eventPbData;
            if (r111 == null) goto L19;
            r103 = com.flow.kmp.common.util.b.b(r111);
        L19:
            if (r103 != null) goto L22;
            this.f347469a.f347455c.b("SAMICoreInterceptorProvider", "[onUplinkCallback] message data buffer is Null.");
            return;
        L22:
            if (r104 == null) goto L63;
            r104.f347466a = r103;
            return;
        L63:
            return;
        L24:
            String r112 = r100.speechOnlyEventName;
            String r113 = "";
            if (r112 != null) goto L27;
            r112 = "";
        L27:
            String r114 = r100.speechOnlyEventPayload;
            if (r114 == null) goto L31;
            r113 = r114;
        L31:
            z0 r115 = this.f347469a.f347454b;
            r115.getClass();
            Intrinsics.checkNotNullParameter(r112, "eventName");
            Intrinsics.checkNotNullParameter(r113, WsConstants.KEY_PAYLOAD);
            if (r115.f347495a.isEmpty() == false) goto L34;
            fe9.c.f476624a.f("SpeechDataObservable", "[notifySpeechOnlyEvent] No speech only event observers registered.");
            return;
        L34:
            Iterator<T> r116 = r115.f347495a.iterator();
        L36:
            if (r116.hasNext() == false) goto L67;
            ((q0) r116.next()).b(r112, r113);
            goto L36
        L67:
            return;
        L11:
            r104 = null;
            goto L13
        }
    }

    public static final class f implements SpeechHostInjectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f347470a;

        public f(r0 r100) {
            this.f347470a = r100;
        }

        @Override // com.mammon.speechaudiosdk.session.callback.SpeechHostInjectionCallback
        public final void onDownlinkCallback(SpeechHostInjectionDownlinkCallbackParam r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = r100.speechEvent;
            if (r101 >= 0) goto L8;
            this.f347470a.f347455c.b("SAMICoreInterceptorProvider", "[onDownlinkCallback] An event(" + r101 + ") that cannot be processed");
            return;
        L8:
            Object r102 = r100.userContext;
            ByteBuffer r103 = null;
            if ((r102 instanceof c) == false) goto L11;
            c r104 = (c) r102;
        L13:
            if (r101 != 1) goto L26;
            ByteBuffer r105 = r100.audioData;
            if (r105 == null) goto L17;
            ByteBuffer r106 = com.flow.kmp.common.util.b.b(r105);
        L18:
            if (r106 != null) goto L21;
            this.f347470a.f347455c.b("SAMICoreInterceptorProvider", "[onDownlinkCallback] Audio data buffer is Null.");
            return;
        L21:
            ByteBuffer r107 = r100.audioExtraPbData;
            if (r107 == null) goto L24;
            r103 = com.flow.kmp.common.util.b.b(r107);
        L24:
            if (r104 == null) goto L35;
            r104.f347466a = new nd9.b.a(r106, r103);
            return;
        L35:
            return;
        L17:
            r106 = null;
            goto L18
        L26:
            ByteBuffer r108 = r100.eventPbData;
            if (r108 == null) goto L29;
            r103 = com.flow.kmp.common.util.b.b(r108);
        L29:
            if (r103 != null) goto L32;
            this.f347470a.f347455c.b("SAMICoreInterceptorProvider", "[onDownlinkCallback] message data buffer is Null.");
            return;
        L32:
            if (r104 == null) goto L37;
            r104.f347466a = r103;
            return;
        L37:
            return;
        L11:
            r104 = null;
            goto L13
        }
    }

    static {
    }

    public final boolean d() {
        SpeechRealtimeCallTask r100 = this.f347459g;
        boolean r101 = false;
        if (r100 != null) goto L28;
        this.f347455c.b("SAMICoreInterceptorProvider", "[setCloudWakeupIntentResult] Task is null, skip notify, result(true).");
        return false;
    L28:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(r100.setCloudWakeupIntentResult(true)));     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        this.f347455c.c("SAMICoreInterceptorProvider", "[setCloudWakeupIntentResult] Invoke failed, result(true).", r104);
    L15:
        if (Result.m9455isFailureimpl(r103) == false) goto L17;
        r103 = null;
    L17:
        Integer r105 = (Integer) r103;
        if (r105 == null) goto L24;
        if (r105.intValue() != 0) goto L24;
        r101 = true;
    L24:
        if (r101 == false) goto L26;
        this.f347455c.e("SAMICoreInterceptorProvider", "[setCloudWakeupIntentResult] Notify succeed, ret(" + r105 + "), result(true).");
    L27:
        return r101;
    L26:
        this.f347455c.b("SAMICoreInterceptorProvider", "[setCloudWakeupIntentResult] Notify failed, ret(" + r105 + "), result(true).");
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // nd9.c
    public final void release() {
        SpeechRealtimeCallTask r100 = this.f347459g;
        if (r100 == null) goto L5;
        r100.stop();
        this.f347456d.releaseRealtimeCallTask(r100);
    L5:
        f(null);
        SpeechLinkLayer r101 = this.f347460h;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        e(null);
    }

    @Override // nd9.c
    public final d a() {
        return this.f347457e;
    }

    @Override // nd9.c
    public final b b() {
        return this.f347458f;
    }

    public final boolean c(long r100) {
        SpeechRealtimeCallTask r101 = this.f347459g;
        boolean r102 = false;
        if (r101 != null) goto L6;
        this.f347455c.b("SAMICoreInterceptorProvider", "[notifyTTSPlayEnd] Task is null, skip notify, endTimeMs(" + r100 + ").");
        return false;
    L6:
        SpeechVoiceAssistantPlayerEvent r103 = new SpeechVoiceAssistantPlayerEvent();
        r103.event = "TTSPlayEnd";
        r103.timestamp = r100;
        if (r101.setLocalParam(304, r103) != 0) goto L9;
        r102 = true;
    L9:
        if (r102 == false) goto L11;
        this.f347455c.e("SAMICoreInterceptorProvider", "[notifyTTSPlayEnd] Task set player event succeed, endTimeMs(" + r100 + ").");
    L12:
        return r102;
    L11:
        this.f347455c.b("SAMICoreInterceptorProvider", "[notifyTTSPlayEnd] Task set player event failed, endTimeMs(" + r100 + ").");
        goto L12
    }

    public final void e(SpeechLinkLayer r100) {
        if (r100 == null) goto L11;
        b r101 = this.f347458f;
        if (r101 == null) goto L7;
        SpeechLinkLayer r102 = r101.f347464a;
    L9:
        if (Intrinsics.areEqual(r102, r100) == true) goto L11;
        this.f347455c.f("SAMICoreInterceptorProvider", "[SpeechLinkLayer] Replace receiver interceptor instance.");
        this.f347458f = new b(r100);
        goto L11
    L7:
        r102 = null;
    L11:
        if (r100 != null) goto L13;
        this.f347455c.f("SAMICoreInterceptorProvider", "[SpeechLinkLayer] Release receiver interceptor instance.");
        this.f347458f = null;
    L13:
        this.f347460h = r100;
    }

    public final void f(SpeechRealtimeCallTask r100) {
        if (r100 == null) goto L11;
        d r101 = this.f347457e;
        if (r101 == null) goto L7;
        SpeechRealtimeCallTask r102 = r101.f347467a;
    L9:
        if (Intrinsics.areEqual(r102, r100) == true) goto L11;
        this.f347455c.f("SAMICoreInterceptorProvider", "[SpeechRealtimeCallTask] Replace interceptor instance.");
        this.f347457e = new d(r100);
        goto L11
    L7:
        r102 = null;
    L11:
        if (r100 != null) goto L13;
        this.f347455c.f("SAMICoreInterceptorProvider", "[SpeechRealtimeCallTask] Release sender interceptor instance.");
        this.f347457e = null;
    L13:
        this.f347459g = r100;
    }

    public r0(ve9.g r100, z0 r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "speechDataObservable");
        this.f347453a = r100;
        this.f347454b = r101;
        this.f347455c = fe9.d.f476625a;
        this.f347456d = new SpeechSessionManager();
        this.f347461i = new f(this);
        this.f347462j = new e(this);
        this.f347463k = new com.larus.im.internal.network.link.impl.sami.x();
    }
}
