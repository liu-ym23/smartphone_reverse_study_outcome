package com.bytedance.manager;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.flow_audio.api.business.tts.error.FlowAudioAssistantError;
import com.bytedance.flow_audio.api.config.connection.FlowAudioAudioTransportType;
import com.bytedance.flow_audio.api.config.connection.FlowAudioTokenType;
import com.bytedance.flow_audio.api.config.session.FlowAudioSessionRequestType;
import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;
import com.bytedance.flow_audio.api.player.KmpAudioPlayerErrorEnum;
import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import com.bytedance.flow_audio.api.service.KmpTtsEventEnum;
import com.bytedance.flow_audio.api.service.KmpTtsLifeState;
import com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.api.tracer.FlowTtsTraceHelper;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.bytedance.flow_audio.impl.business.tts.FlowTtsSession;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate;
import com.larus.audio.o;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.obric.aiagent.sharedstate.StateKey;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ouc.d0;
import ouc.e0;
import ouc.j;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowTtsKmpManager implements qw5.b {
    public static final CoroutineScope A = null;
    public static Job B;
    public static final com.bytedance.manager.a C = null;
    public static long D;
    public static long E;
    public static String F;
    public static boolean G;
    public static final buc.a H = null;
    public static String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final buc.e<String> f265442J = null;
    public static Job K;
    public static final f L = null;
    public static final b M = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowTtsKmpManager f265443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f265444b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static qw5.e f265445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final buc.e<String> f265446d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static AudioPlayerStatus f265447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static fw5.a f265448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final buc.a f265449g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final KmpThreadSafeQueue<byte[]> f265450h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.a f265451i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static FlowTtsSession f265452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static ww5.b f265453k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f265454l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static tw5.a f265455m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final buc.a f265456n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final buc.a f265457o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Function1<? super String, Unit> f265458p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final buc.e<String> f265459q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final buc.a f265460r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final buc.a f265461s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final buc.d f265462t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final buc.e<String> f265463u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final buc.e<String> f265464v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f265465w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f265466x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f265467y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static Function0<Unit> f265468z;

    public static final class a implements uw5.b {

        /* JADX INFO: renamed from: com.bytedance.manager.FlowTtsKmpManager$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes21.dex */
        public /* synthetic */ class C3717a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f265469a = null;

            static {
                int[] r100 = new int[AudioPlayerStatus.values().length];
                r100[AudioPlayerStatus.Paused.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[AudioPlayerStatus.Stopped.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f265469a = r100;
            }
        }

        public a() {
        }

        @Override // uw5.b
        public final int c() {
            return 0;
        }

        @Override // uw5.b
        public final void a() {
            FlowTtsTraceHelper r100 = FlowTtsTraceHelper.INSTANCE;
            String r101 = FlowTtsKmpManager.f265459q.c();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            TtsTracer r102 = r100.getTracerByTaskId(r101);
            if (r102 == null) goto L9;
            r102.playFirstFrame(true);
            return;
        }

        @Override // uw5.b
        public final void b(AudioPlayerStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            IKMPLoggerService r101 = lp7.a.f510233a;
            lp7.a.a("FlowTtsKmpManager", "onAudioPlayer StateChange state:" + r100);
            int r102 = C3717a.f265469a[r100.ordinal()];
            if (r102 != 1) goto L5;
            FlowTtsKmpManager.f265443a.x(AudioPlayerStatus.Paused);
            return;
        L5:
            if (r102 != 2) goto L11;
            FlowTtsKmpManager.f265443a.x(AudioPlayerStatus.Stopped);
            return;
        }

        @Override // uw5.b
        public final void d(KmpAudioPlayerErrorEnum r100, uw5.a r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            IKMPLoggerService r102 = lp7.a.f510233a;
            lp7.a.a("FlowTtsKmpManager", "onAudioPlayer Failed code:" + r100);
            FlowTtsKmpManager.f265443a.x(AudioPlayerStatus.Stopped);
            if (r101 == null) goto L11;
            FlowTtsTraceHelper r103 = FlowTtsTraceHelper.INSTANCE;
            String r104 = FlowTtsKmpManager.f265459q.c();
            if (r104 != null) goto L7;
            r104 = "";
        L7:
            TtsTracer r105 = r103.getTracerByTaskId(r104);
            if (r105 == null) goto L12;
            r105.onPlayErr(r101.f551946a, r101.f551947b);
            return;
        L12:
            return;
        }
    }

    public static final class b implements ow5.b {

        /* JADX INFO: loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f265470a = null;

            static {
                int[] r100 = new int[FlowAudioAssistantError.ErrorType.values().length];
                r100[FlowAudioAssistantError.ErrorType.SessionFailed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[FlowAudioAssistantError.ErrorType.ConnectFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[FlowAudioAssistantError.ErrorType.TaskFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f265470a = r100;
            }
        }

        public b() {
        }

        @Override // ow5.b
        public final void M(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void O0(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            ww5.b r101 = FlowTtsKmpManager.f265453k;
            if (r101 == null) goto L5;
            ww5.b.a.a(r101, KmpTtsEventEnum.TTS_START, null, 0, 30);
        L5:
            TtsTracer r102 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r100.f244064d);
            if (r102 == null) goto L9;
            r102.receiveFirstPkg();
            return;
        }

        @Override // ow5.b
        public final void S1(ow5.a r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void a0(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void k3(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void q2(ow5.a r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            FlowTtsKmpManager r101 = FlowTtsKmpManager.f265443a;
            String r102 = null;
            if (FlowTtsKmpManager.A(r101, r100) == false) goto L9;
            IKMPLoggerService r103 = lp7.a.f510233a;
            StringBuilder r104 = new StringBuilder("ttsSessionDidEnd ignored, stale session=");
            r104.append(r100.getSessionId());
            r104.append(", curSession=");
            FlowTtsSession r105 = FlowTtsKmpManager.f265452j;
            if (r105 == null) goto L7;
            r102 = r105.f244064d;
        L7:
            r104.append(r102);
            lp7.a.d("FlowTtsKmpManager", r104.toString());
            return;
        L9:
            FlowTtsKmpManager.B(r101, r100.getSessionId());
            ww5.b r106 = FlowTtsKmpManager.f265453k;
            if (r106 == null) goto L13;
            ww5.b.a.a(r106, KmpTtsEventEnum.TTS_END, null, 0, 30);
            return;
        }

        @Override // ow5.b
        public final void r1(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void s0(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void v0(FlowTtsSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        @Override // ow5.b
        public final void A(ow5.a r110, FlowAudioAssistantError r111) {
            Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            FlowTtsKmpManager r100 = FlowTtsKmpManager.f265443a;
            String r101 = null;
            if (FlowTtsKmpManager.A(r100, r110) == false) goto L13;
            IKMPLoggerService r102 = lp7.a.f510233a;
            StringBuilder r103 = new StringBuilder("ttsSessionDidFail ignored, stale session=");
            r103.append(r110.getSessionId());
            r103.append(", curSession=");
            FlowTtsSession r112 = FlowTtsKmpManager.f265452j;
            if (r112 == null) goto L7;
            String r113 = r112.f244064d;
        L8:
            r103.append(r113);
            r103.append(", error=");
            if (r111 == null) goto L11;
            r101 = r111.f243689a;
        L11:
            r103.append(r101);
            lp7.a.d("FlowTtsKmpManager", r103.toString());
            return;
        L7:
            r113 = null;
            goto L8
        L13:
            if (r111 != null) goto L16;
            FlowTtsKmpManager.B(r100, r110.getSessionId());
            IKMPLoggerService r114 = lp7.a.f510233a;
            lp7.a.c("FlowTtsKmpManager", "ttsSessionDidFail ignored because didFinish is success, sessionId=" + r110.getSessionId());
            return;
        L16:
            boolean r104 = true;
            FlowTtsKmpManager.f265460r.d(true);
            FlowTtsKmpManager.f265449g.d(true);
            FlowTtsKmpManager.f265450h.a();
            Job r105 = FlowTtsKmpManager.B;
            if (r105 == null) goto L19;
            Job.DefaultImpls.cancel$default(r105, null, 1, null);
        L19:
            FlowTtsKmpManager.E();
            FlowAudioAssistantError.ErrorType r106 = r111.f243691c;
            int r107 = -1;
            if (r106 != null) goto L22;
            int r108 = -1;
        L23:
            String r109 = "";
            if (r108 != 1) goto L26;
            String r115 = r111.b();
            if (r115 == null) goto L70;
            r109 = r115;
        L70:
            if (r109.length() == 0) goto L73;
            r104 = false;
        L73:
            if (r104 == false) goto L75;
            r109 = KmpTtsEventEnum.TTS_SESSION_FAILED.getMassage();
        L75:
            int r116 = r111.f243690b;
            if (r116 != 0) goto L79;
            r116 = KmpTtsEventEnum.TTS_SESSION_FAILED.getCode();
        L79:
            FlowTtsKmpManager.C(r100, r110, KmpTtsEventEnum.TTS_SESSION_FAILED, r109, r116);
        L80:
            FlowTtsKmpManager.M(r110.getSessionId(), false);
            FlowTtsKmpManager.G(r110.getSessionId());
            FlowTtsKmpManager.f265446d.d(null);
            FlowTtsKmpManager.F = null;
            FlowTtsKmpManager.f265459q.d(null);
            FlowTtsKmpManager.f265464v.d(null);
            FlowTtsKmpManager.D = -1;
            return;
        L26:
            if (r108 != 2) goto L28;
            String r117 = r111.b();
            if (r117 == null) goto L50;
            r109 = r117;
        L50:
            if (r109.length() == 0) goto L53;
            r104 = false;
        L53:
            if (r104 == false) goto L55;
            r109 = KmpTtsEventEnum.TTS_NETWORK_FAILED.getMassage();
        L55:
            Integer r118 = r111.a();
            if (r118 != null) goto L59;
        L61:
            Integer r119 = r111.a();
            if (r119 == null) goto L64;
            r107 = r119.intValue();
        L64:
            FlowTtsKmpManager.C(r100, r110, KmpTtsEventEnum.TTS_NETWORK_FAILED, r109, r107);
            goto L80
        L59:
            if (r118.intValue() != (-1)) goto L61;
            r107 = KmpTtsEventEnum.TTS_NETWORK_FAILED.getCode();
            goto L64
        L28:
            if (r108 == 3) goto L30;
            IKMPLoggerService r120 = lp7.a.f510233a;
            lp7.a.d("FlowTtsKmpManager", "ttsSessionDidFail unknown errorType=" + r111);
            goto L80
        L30:
            String r121 = r111.b();
            if (r121 == null) goto L35;
            r109 = r121;
        L35:
            if (r109.length() == 0) goto L38;
            r104 = false;
        L38:
            if (r104 == false) goto L40;
            r109 = KmpTtsEventEnum.TTS_TASK_FAILED.getMassage();
        L40:
            int r122 = r111.f243690b;
            if (r122 != 0) goto L44;
            r122 = KmpTtsEventEnum.TTS_TASK_FAILED.getCode();
        L44:
            FlowTtsKmpManager.C(r100, r110, KmpTtsEventEnum.TTS_TASK_FAILED, r109, r122);
            goto L80
        L22:
            r108 = a.f265470a[r106.ordinal()];
            goto L23
        }

        @Override // ow5.b
        public final void i2(ow5.a r100, nw5.e r101) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r101, "ttsSentence");
            ww5.b r102 = FlowTtsKmpManager.f265453k;
            if (r102 == null) goto L6;
            ww5.b.a.a(r102, KmpTtsEventEnum.TTS_SENTENCE_START, null, 0, 30);
            return;
        }

        @Override // ow5.b
        public final void w2(ow5.a r100, nw5.b r101) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r101, "sentenceInfo");
        }

        @Override // ow5.b
        public final void x1(FlowTtsSession r110, rw5.d r111) {
            Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r111, "data");
            IKMPLoggerService r100 = lp7.a.f510233a;
            lp7.a.c("FlowTtsKmpManager", "received audio data: session_id=" + r110.f244064d + " size=" + r111.f539717b.length + " shouldCalRenderingTime=" + r111.f539718c);
            String r101 = null;
            if (FlowTtsKmpManager.A(FlowTtsKmpManager.f265443a, r110) == false) goto L9;
            StringBuilder r112 = new StringBuilder("ttsSessionWillPlayAudio ignored, stale session=");
            r112.append(r110.f244064d);
            r112.append(", curSession=");
            FlowTtsSession r113 = FlowTtsKmpManager.f265452j;
            if (r113 == null) goto L7;
            r101 = r113.f244064d;
        L7:
            r112.append(r101);
            lp7.a.d("FlowTtsKmpManager", r112.toString());
            return;
        L9:
            byte[] r102 = r111.f539717b;
            String r103 = r110.f244062b.f534993a;
            int r104 = r102.length;
            int r105 = FlowTtsKmpManager.f265451i.f33902g;
            if (r105 <= 0) goto L17;
            int r106 = 0;
            if (r104 <= r105) goto L16;
        L13:
            int r107 = r106 + r105;
            if (r107 >= r104) goto L16;
            FlowTtsKmpManager.f265450h.b(ArraysKt.copyOfRange(r102, r106, r107));
            r106 = r107;
        L16:
            FlowTtsKmpManager.f265450h.b(ArraysKt.copyOfRange(r102, r106, r104));
            FlowTtsKmpManager.K(r103);
        L18:
            buc.a r108 = FlowTtsKmpManager.H;
            r108.d(Intrinsics.areEqual(r111.f539716a, "1"));
            if (r108.c() == false) goto L26;
            ww5.b r114 = FlowTtsKmpManager.f265453k;
            if (r114 == null) goto L23;
            r114.c(KmpTtsLifeState.TTS_START, r110.f244064d, null);
        L23:
            ww5.b r115 = FlowTtsKmpManager.f265453k;
            if (r115 == null) goto L26;
            ww5.b.a.a(r115, KmpTtsEventEnum.TTS_FIRST_PACKAGE, null, 0, 30);
        L26:
            ww5.b r116 = FlowTtsKmpManager.f265453k;
            if (r116 == null) goto L31;
            r116.a(r102);
            return;
        L31:
            return;
        L17:
            lp7.a.b("FlowTtsKmpManager", "onAudioData AudioPlayer MinBufferSize: " + r105 + " error");
            goto L18
        }
    }

    public FlowTtsKmpManager() {
    }

    @Override // qw5.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
    }

    @Override // qw5.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "funcChannel");
    }

    @Override // qw5.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
    }

    @Override // qw5.b
    public final void enableTtsCache() {
    }

    @Override // qw5.b
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "step");
    }

    @Override // qw5.b
    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "step");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.manager.f] */
    static {
        f265443a = new FlowTtsKmpManager();
        f265444b = new Object();
        f265446d = buc.b.d(null);
        f265447e = AudioPlayerStatus.Stopped;
        f265449g = buc.b.a(false);
        f265450h = new KmpThreadSafeQueue();
        f265451i = new com.bytedance.a();
        f265454l = LazyKt.lazy(new e());
        f265455m = new tw5.a(0);
        f265456n = buc.b.a(false);
        f265457o = buc.b.a(false);
        f265459q = buc.b.d(null);
        f265460r = buc.b.a(false);
        f265461s = buc.b.a(true);
        f265462t = buc.b.c(0);
        f265463u = buc.b.d(null);
        f265464v = buc.b.d(null);
        A = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault().limitedParallelism(1)));
        D = -1;
        E = -1;
        H = buc.b.a(false);
        f265442J = buc.b.d(null);
        L = new f();
        M = new b();
        C = new com.bytedance.manager.a(new uw5.b[]{new a()});
    }

    public static void E() {
        Job r100 = K;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        K = null;
    }

    public static AudioPlayerStatus H() {
        IKMPAppInfoProvider r100 = xw5.a.f565227a;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a() != true) goto L7;
    L8:
        if (r101 == false) goto L18;
        Object r102 = f265444b;
        monitor-enter(r102);
        AudioPlayerStatus r103 = f265447e;     // Catch: Throwable -> L14
        monitor-exit(r102);
        return r103;
    L14:
        th = move-exception;
        throw th;
    L18:
        return f265451i.f33899d;
    L7:
        r101 = false;
        goto L8
    }

    @Override // qw5.b
    public final void k() {
        com.bytedance.a r100 = f265451i;
        AudioPlayerStatus r101 = r100.f33899d;
        AudioPlayerStatus r102 = AudioPlayerStatus.Playing;
        if (r101 != r102) goto L6;
        lp7.a.c("FlowTtsKmpManager", "resumeAudioPlay already started");
        return;
    L6:
        buc.e<String> r103 = f265459q;
        String r104 = r103.c();
        boolean r105 = true;
        if (r104 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L31;
        buc.e<String> r107 = f265464v;
        String r108 = r107.c();
        if (r108 != null) goto L17;
    L20:
        if (r105 == true) goto L31;
        r100.resume();
        lp7.a.a("FlowTtsKmpManager", "resumeAudioPlay");
        x(r102);
        String r109 = r103.c();
        if (r109 == null) goto L33;
        f265443a.getClass();
        if (H() != r102) goto L29;
        N(r109, r107.c(), f265462t.c());
        ww5.b r110 = f265453k;
        if (r110 == null) goto L34;
        r110.c(KmpTtsLifeState.TTS_RESUME, r109, null);
        return;
    L34:
        return;
    L29:
        lp7.a.c("FlowTtsKmpManager", "resumeAudioPlay failed audioPlayState=" + H());
        return;
    L33:
        return;
    L17:
        if (r108.length() == 0) goto L20;
        r105 = false;
    L31:
        IKMPLoggerService r111 = lp7.a.f510233a;
        lp7.a.c("FlowTtsKmpManager", "resumeAudioPlay finalPlayingTaskId=" + r103 + " finalPlayingMsgId=" + f265464v);
        return;
    L9:
        if (r104.length() == 0) goto L12;
        r106 = false;
        goto L13
    }

    @Override // qw5.b
    public final void l() {
        com.bytedance.a r100 = f265451i;
        AudioPlayerStatus r101 = r100.f33899d;
        AudioPlayerStatus r102 = AudioPlayerStatus.Paused;
        if (r101 != r102) goto L6;
        lp7.a.c("FlowTtsKmpManager", "pauseAudioPlay already paused");
        return;
    L6:
        E();
        r100.pause();
        lp7.a.a("FlowTtsKmpManager", "pauseAudioPlay");
        x(r102);
        String r103 = f265459q.c();
        f265443a.getClass();
        if (H() != r102) goto L11;
        ww5.b r104 = f265453k;
        if (r104 == null) goto L13;
        r104.c(KmpTtsLifeState.TTS_PAUSE, r103, null);
        return;
    L13:
        return;
    L11:
        lp7.a.c("FlowTtsKmpManager", "pauseAudioPlay failed audioPlayState=" + H());
    }

    @Override // qw5.b
    public final boolean a() {
        if (H() != AudioPlayerStatus.Playing) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // qw5.b
    public final AudioPlayerStatus m() {
        return H();
    }

    public static long D(String r100) {
        long r101 = f265462t.d();
        IKMPLoggerService r102 = lp7.a.f510233a;
        lp7.a.c("FlowTtsKmpManager", "[TTS] audio play generation advanced to " + r101 + ", reason=" + r100);
        return r101;
    }

    public static void G(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L17;
        FlowTtsSession r102 = f265452j;
        if (r102 == null) goto L12;
        String r103 = r102.f244064d;
    L14:
        if (Intrinsics.areEqual(r103, r100) == false) goto L18;
        f265452j = null;
        return;
    L18:
        return;
    L12:
        r103 = null;
        goto L14
    L17:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void K(String r100) {
        if (G == true) goto L5;
        return;
    L5:
        E();
        I = r100;
        f r101 = L;
        if (r101 == null) goto L9;
        K = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new FlowTtsKmpManager$scheduleTimerTask$1$1(r100, r101, null), 2, null);
        return;
    }

    public static void L(AudioPlayerStatus r100) {
        Object r101 = f265444b;
        monitor-enter(r101);
        f265447e = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // qw5.b
    public final void c(o r100) {
        f265468z = r100;
    }

    @Override // qw5.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Function1<? super String, Unit> r101 = f265458p;
        if (r101 == null) goto L5;
        r101.invoke(r100);
    L5:
        String r102 = I;
        if (r102 != null) goto L10;
        r102 = f265459q.c();
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        Object r103 = f265444b;
        monitor-enter(r103);
        f265443a.F(true, r102, r100);     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r103);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // qw5.b
    public final void h(i78.a r100) {
        rw5.g r101 = com.bytedance.manager.b.f265478a;
        com.bytedance.manager.b.f265478a = r100;
    }

    @Override // qw5.b
    public final void j(boolean r100) {
        G = r100;
        if (r100 == true) goto L6;
        E();
        return;
    }

    @Override // qw5.b
    public final void n(boolean r100) {
        IKMPLoggerService r101 = lp7.a.f510233a;
        StringBuilder r102 = new StringBuilder("setInterruptStopTts ");
        r102.append(r100);
        r102.append(" curMsgId=");
        buc.e<String> r103 = f265446d;
        r102.append(r103.c());
        lp7.a.c("FlowTtsKmpManager", r102.toString());
        if (r103.c() == null) goto L6;
        if (r100 == false) goto L6;
        f265465w = true;
        return;
    L6:
        f265465w = false;
    }

    @Override // qw5.b
    public final void o(FlowTtsClientKmpManagerDelegate.c r100) {
        f265448f = r100;
    }

    @Override // qw5.b
    public final void p(i78.e r100) {
        Intrinsics.checkNotNullParameter(r100, "audioPlayerListener");
        com.bytedance.manager.a r101 = C;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        lp7.c<uw5.b> r102 = r101.f265477a;
        ReentrantLock r103 = r102.f510235b;
        r103.lock();
        boolean r104 = ((ArrayList) r102.f510234a).contains(r100);     // Catch: Throwable -> L31
        r103.unlock();
        if (r104 == false) goto L12;
        lp7.c<uw5.b> r105 = r101.f265477a;
        ReentrantLock r106 = r105.f510235b;
        r106.lock();
        ((ArrayList) r105.f510234a).remove(r100);     // Catch: Throwable -> L9
        r106.unlock();
    L9:
        th = move-exception;
        r106.unlock();
        throw th;
    L12:
        Iterator<T> r107 = r101.f265477a.a().iterator();
    L14:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();
        if (((uw5.b) r108).c() != r100.f488480a) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L14;
    L22:
        uw5.b r110 = (uw5.b) r108;
        if (r110 == null) goto L30;
        lp7.c<uw5.b> r111 = r101.f265477a;
        ReentrantLock r112 = r111.f510235b;
        r112.lock();
        ((ArrayList) r111.f510234a).remove(r110);     // Catch: Throwable -> L27
        r112.unlock();
        return;
    L27:
        th = move-exception;
        r112.unlock();
        throw th;
    L30:
        return;
    L18:
        r109 = false;
        goto L19
    L21:
        r108 = null;
    L31:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    @Override // qw5.b
    public final void q(qw5.e r100) {
        f265445c = r100;
    }

    @Override // qw5.b
    public final void r(i78.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f265458p = r100;
    }

    @Override // qw5.b
    public final void setVolume(float r100) {
        f265451i.duck(r100);
    }

    @Override // qw5.b
    public final void w(i78.e r100) {
        Intrinsics.checkNotNullParameter(r100, "audioPlayerListener");
        com.bytedance.manager.a r101 = C;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        lp7.c<uw5.b> r102 = r101.f265477a;
        ReentrantLock r103 = r102.f510235b;
        r103.lock();
        boolean r104 = ((ArrayList) r102.f510234a).contains(r100);     // Catch: Throwable -> L14
        r103.unlock();
        if (r104 == true) goto L21;
        lp7.c<uw5.b> r105 = r101.f265477a;
        ReentrantLock r106 = r105.f510235b;
        r106.lock();
        ((ArrayList) r105.f510234a).add(r100);     // Catch: Throwable -> L11
        r106.unlock();
        return;
    L11:
        th = move-exception;
        r106.unlock();
        throw th;
    L21:
        return;
    L14:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    @Override // qw5.b
    public final void x(AudioPlayerStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "playStateEnum");
        IKMPLoggerService r101 = lp7.a.f510233a;
        lp7.a.a("FlowTtsKmpManager", "changeAudioPlayState playStateEnum:" + r100 + " ，mKmpAudioPlayStateChangeCallback " + f265448f);
        IKMPAppInfoProvider r102 = xw5.a.f565227a;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.a() != true) goto L7;
    L8:
        if (r103 == false) goto L20;
        AudioPlayerStatus r104 = AudioPlayerStatus.Stopped;
        if (r100 == r104) goto L12;
        L(r100);
        goto L20
    L12:
        Object r105 = f265444b;
        monitor-enter(r105);
        f265447e = r104;     // Catch: Throwable -> L17
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r105);
    L17:
        th = move-exception;
        throw th;
    L20:
        fw5.a r107 = f265448f;
        if (r107 == null) goto L24;
        r107.c(r100);
    L24:
        if (r100 == AudioPlayerStatus.Playing) goto L31;
        fw5.a r108 = f265448f;
        if (r108 == null) goto L32;
        r108.d(r100);
        return;
    L32:
        return;
    L31:
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // qw5.b
    public final void y(boolean r100) {
        f265461s.d(r100);
    }

    @Override // qw5.b
    public final void z(tw5.a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f547761a > 0) goto L7;
        return;
    L7:
        f265455m = r100;
    }

    public static final boolean A(FlowTtsKmpManager r100, ow5.a r101) {
        r100.getClass();
        FlowTtsSession r102 = f265452j;
        if (r102 == null) goto L8;
        String r103 = r102.f244064d;
        if (r103 == null) goto L8;
        return !Intrinsics.areEqual(r103, r101.getSessionId());
    L8:
        return false;
    }

    public static final void B(FlowTtsKmpManager r100, String r101) {
        r100.getClass();
        buc.e<String> r102 = f265442J;
        if (r102.a(null, r101) == true) goto L5;
        IKMPLoggerService r103 = lp7.a.f510233a;
        lp7.a.c("FlowTtsKmpManager", "notifyTtsDataEnd ignored because already notified, taskId=" + r101 + ", notifiedTaskId=" + r102.c());
        return;
    L5:
        f265449g.d(true);
        f265450h.b(new byte[0]);
        E();
    }

    public static void M(String r110, boolean r111) {
        com.bytedance.a r100 = f265451i;
        if (r100.f33899d == AudioPlayerStatus.Stopped) goto L25;
        r100.stop();
        Function0<Unit> r101 = f265468z;
        if (r101 == null) goto L7;
        r101.invoke();
    L7:
        boolean r102 = true;
        if (r111 == false) goto L12;
        TtsTracer r103 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r110);
        if (r103 == null) goto L12;
        r103.playEnd(1);
    L12:
        buc.e<String> r104 = f265464v;
        String r105 = r104.c();
        if (r105 != null) goto L15;
    L18:
        if (r102 == true) goto L25;
        if (r111 == false) goto L25;
        if (D <= 0) goto L25;
        E = SystemClock.elapsedRealtime() - D;
        fw5.a r106 = f265448f;
        if (r106 == null) goto L25;
        r106.b(f265467y, r104.c(), r110, E);
        goto L25
    L15:
        if (r105.length() == 0) goto L18;
        r102 = false;
    L25:
        f265459q.d(null);
        f265464v.d(null);
        f265446d.d(null);
        F = null;
        D = -1;
    }

    @Override // qw5.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        N(r100, r101, f265462t.c());
    }

    public static void N(String r110, String r111, long r112) {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.a("FlowTtsKmpManager", "[TTS] tryPlay start taskId:" + r110 + " msgId=" + r111 + " generation=" + r112);
        F = r111;
        B = BuildersKt.launch$default(A, null, null, new FlowTtsKmpManager$tryPlay$1(r110, r112, r111, null), 3, null);
    }

    public final void F(boolean r110, String r111, String r112) {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.b("FlowTtsKmpManager", "[TTS][INTERRUPTED] cancelTtsAndAudioPlay shouldCancelAll=" + r110 + ", taskId:" + r111 + ", reason:[" + StringsKt.replace$default(r112, ' ', '_', false, 4, null) + "] interruptStopTts:" + f265465w);
        if (f265465w == false) goto L5;
        return;
    L5:
        FlowTtsSession r113 = f265452j;
        String r101 = null;
        if (r113 == null) goto L8;
        String r102 = r113.f244064d;
    L10:
        if (r111.length() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
    L17:
        boolean r104 = false;
    L19:
        if (f265461s.c() == true) goto L30;
        if (r110 == true) goto L30;
        if (r104 == true) goto L30;
        if (r102 != null) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == true) goto L30;
        boolean r106 = true;
    L31:
        if (r110 == true) goto L38;
        if (r104 == true) goto L38;
        if (r106 == true) goto L37;
        lp7.a.d("FlowTtsKmpManager", "[TTS][INTERRUPTED] skip cancel because task mismatch, taskId=" + r111 + ", curSessionId=" + r102 + ", finalPlayingTaskId=" + f265459q.c() + ", pendingTimeoutTaskId=" + I);
        return;
    L37:
        lp7.a.d("FlowTtsKmpManager", "[TTS][INTERRUPTED] cancel current session because task mismatch, taskId=" + r111 + ", curSessionId=" + r102 + ", finalPlayingTaskId=" + f265459q.c() + ", pendingTimeoutTaskId=" + I);
    L38:
        if (r106 == false) goto L42;
        if (r102 != null) goto L41;
        r111 = "";
        goto L42
    L41:
        r111 = r102;
    L42:
        if (r104 == true) goto L45;
        if (r106 == true) goto L45;
    L47:
        boolean r107 = false;
    L48:
        f265460r.d(true);
        D("stopAudioPlayAndRelease taskId=" + r111 + " isCancel=true");
        f265449g.d(false);
        KmpThreadSafeQueue<byte[]> r108 = f265450h;
        r108.a();
        r108.b(new byte[0]);
        M(r111, true);
        if (r110 == false) goto L61;
        ww5.b r114 = f265453k;
        if (r114 == null) goto L64;
        StringBuilder r109 = new StringBuilder("[TTS][CANCEL_ALL] cancelTtsAndAudioPlay cancelAll taskId:");
        FlowTtsSession r115 = f265452j;
        if (r115 == null) goto L55;
        String r116 = r115.f244064d;
    L56:
        r109.append(r116);
        lp7.a.b("FlowTtsKmpManager", r109.toString());
        KmpTtsLifeState r117 = KmpTtsLifeState.TTS_STOP;
        FlowTtsSession r118 = f265452j;
        if (r118 == null) goto L59;
        String r119 = r118.f244064d;
    L60:
        LinkedHashMap r120 = new LinkedHashMap();
        r120.put("scene_from", TtsStopType.USER_CANCEL.getType());
        Unit r121 = Unit.INSTANCE;
        r114.c(r117, r119, r120);
        goto L64
    L59:
        r119 = null;
        goto L60
    L55:
        r116 = null;
    L64:
        E();
        if (r104 == true) goto L68;
        if (r110 == true) goto L68;
        if (r106 == true) goto L68;
    L70:
        if (r107 == false) goto L72;
        x(AudioPlayerStatus.Stopped);
    L72:
        if (r104 == true) goto L75;
        if (r110 == true) goto L75;
        if (r106 == true) goto L75;
        return;
    L75:
        if (r113 == null) goto L77;
        r101 = r113.f244064d;
    L77:
        G(r101);
        return;
    L68:
        if (r113 == null) goto L70;
        r113.stop();
        goto L70
    L61:
        ww5.b r122 = f265453k;
        if (r122 == null) goto L64;
        KmpTtsLifeState r123 = KmpTtsLifeState.TTS_STOP;
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put("scene_from", TtsStopType.USER_CANCEL.getType());
        Unit r125 = Unit.INSTANCE;
        r122.c(r123, r111, r124);
    L45:
        if (f265451i.f33899d != AudioPlayerStatus.Initial) goto L47;
        r107 = true;
        goto L48
    L24:
        if (r102.length() == 0) goto L27;
        r105 = false;
    L30:
        r106 = false;
        goto L31
    L15:
        if (Intrinsics.areEqual(r102, r111) == false) goto L17;
        r104 = true;
        goto L19
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = null;
        goto L10
    }

    @Override // qw5.b
    public final void g(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "reason");
        f265467y = r101;
        Object r103 = f265444b;
        monitor-enter(r103);
        f265443a.F(false, r100, r102);     // Catch: Throwable -> L7
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final void C(FlowTtsKmpManager r100, ow5.a r101, KmpTtsEventEnum r102, String r103, int r104) {
        r100.getClass();
        ww5.b r105 = f265453k;
        if (r105 == null) goto L5;
        ww5.b.a.a(r105, r102, r103, r104, 24);
    L5:
        ww5.b r106 = f265453k;
        if (r106 == null) goto L8;
        KmpTtsLifeState r107 = KmpTtsLifeState.TTS_ERROR;
        String r108 = r101.getSessionId();
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put("scene_from", r102.name());
        r109.put("error_code", String.valueOf(r104));
        r109.put("error_msg", r103);
        Unit r110 = Unit.INSTANCE;
        r106.c(r107, r108, r109);
    L8:
        TtsTracer r111 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r101.getSessionId());
        if (r111 == null) goto L12;
        r111.onPlayErr(false, r103);
        return;
    }

    @Override // qw5.b
    public final void v(String r110, String r111, String r210, String r211, String r212, String r213, Map r214, FlowTtsClientKmpManagerDelegate.d r215, String r216, float r217, int r218, boolean r219, int r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        I(r110, r111, r212, true, r211, true, r214, r213, r210, r215, r216, r217, r218, r219, r310, r311);
    }

    /* JADX WARN: Type inference failed for: r5v29, types: [com.bytedance.manager.g] */
    public final void J(String r310, String r311, String r312, boolean r313, String r314, Map r315, String r316, String r410, ww5.b r411, String r412, float r413, int r414, boolean r415, int r416, boolean r417) {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.c("FlowTtsKmpManager", "[TTS] inner start tts taskId: " + r310 + ", msgId: " + r312 + ", curPlayingMsgId: " + f265446d + ", speakerStyleId: " + r314 + ", ext:" + r315);
        f265453k = r411;
        e0 r101 = new e0();
        if (r315 == null) goto L10;
        Iterator r102 = r315.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getValue();
        if (r104 == null) goto L6;
        j.c(r101, (String) r103.getKey(), r104);
    L10:
        d0 r105 = r101.a();
        if (r410 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        boolean r210 = !r106;
        if (r315 == null) goto L20;
        String r107 = (String) r315.get(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID);
    L21:
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        if (r315 == null) goto L25;
        String r108 = (String) r315.get("bot_id");
    L26:
        if (r108 != null) goto L28;
        r108 = "";
    L28:
        e0 r109 = new e0();
        f265443a.getClass();
        qw5.e r110 = f265445c;
        if (r110 == null) goto L31;
        String r111 = r110.f535012d;
    L32:
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        j.c(r109, "uid", r111);
        if (r311 != null) goto L37;
        String r112 = "";
    L38:
        j.c(r109, "conversation_id", r112);
        if (r312 != null) goto L41;
        String r113 = "";
    L42:
        j.c(r109, MusicAppletPage.KEY_MESSAGE_ID, r113);
        j.a(r109, "new_conversation", Boolean.valueOf(r313));
        j.c(r109, com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r107);
        j.c(r109, "bot_id", r108);
        r109.b("extra", r105);
        d0 r114 = r109.a();
        int r115 = d.f265481a;
        if (r316 != null) goto L45;
        String r116 = "";
    L46:
        Intrinsics.checkNotNullParameter(r116, "rawExtra");
        d0 r117 = lp7.b.b(r116);
        e0 r118 = new e0();
        if (r315 == null) goto L51;
        String r119 = (String) r315.get("query_local_message_id");
        if (r119 == null) goto L51;
        j.c(r118, "query_local_message_id", r119);
    L51:
        if (r315 == null) goto L55;
        String r120 = (String) r315.get("section_id");
        if (r120 == null) goto L55;
        j.c(r118, "section_id", r120);
    L55:
        if (r315 == null) goto L59;
        String r121 = (String) r315.get("reply_unique_key");
        if (r121 == null) goto L59;
        j.c(r118, "reply_unique_key", r121);
    L59:
        IKMPAppInfoProvider r122 = xw5.a.f565227a;
        if (r122 == null) goto L64;
        Integer r123 = r122.o();
        if (r123 == null) goto L64;
        j.b(r118, "network_level", Integer.valueOf(r123.intValue()));
    L64:
        String r124 = lp7.b.a(r117, r118.a()).toString();
        if (r314 != null) goto L67;
        String r125 = "";
    L68:
        if (r314 != null) goto L70;
        String r126 = "";
    L71:
        mw5.c r211 = new mw5.c(FlowAudioAssistantScene.Im, new mw5.b(new mw5.d(r125, r126, r412, r124), 24000, 32000, 6), f265455m.f547761a / 1000.0d, r210);
        if (r210 == false) goto L74;
        FlowAudioSessionRequestType r127 = FlowAudioSessionRequestType.BidirectionalTTS;
    L75:
        FlowAudioSessionRequestType r128 = r127;
        qw5.e r129 = f265445c;
        if (r129 == null) goto L78;
        String r130 = r129.f535017i;
    L79:
        if (r130 != null) goto L81;
        r130 = "";
    L81:
        if (r129 == null) goto L83;
        int r131 = r129.f535015g;
    L84:
        Intrinsics.checkNotNullParameter(r130, "url");
        boolean r132 = StringsKt.isBlank(r130);
        String r133 = r130;
        if (r132 == false) goto L366;
    L109:
        qw5.e r134 = f265445c;
        if (r134 == null) goto L117;
        Function1<? super String, String> r135 = r134.f535022n;
        if (r135 == null) goto L117;
        String r136 = r134.f535009a;
        if (r136 != null) goto L116;
        r136 = "";
    L116:
        String r137 = r135.invoke(r136);
    L118:
        if (r137 != null) goto L120;
        r137 = "";
    L120:
        if (r311 != null) goto L122;
        String r138 = "";
    L123:
        FlowAudioAssistantScene r139 = FlowAudioAssistantScene.Im;
        String r212 = r114.toString();
        if (r412 != null) goto L126;
    L129:
        boolean r140 = true;
    L130:
        if (r140 == false) goto L132;
    L138:
        mw5.a r213 = null;
    L139:
        qw5.e r141 = f265445c;
        if (r141 == null) goto L142;
        int r142 = r141.f535018j;
    L143:
        FlowAudioAudioTransportType r143 = FlowAudioAudioTransportType.WEBSOCKET;
        if (r137.length() <= 0) goto L146;
        boolean r144 = true;
    L147:
        if (r144 == false) goto L156;
        qw5.e r145 = f265445c;
        if (r145 != null) goto L151;
    L153:
        boolean r146 = false;
    L154:
        if (r146 == false) goto L156;
        boolean r147 = true;
    L157:
        qw5.e r148 = f265445c;
        if (r148 != null) goto L160;
    L162:
        boolean r149 = false;
    L164:
        if (r149 == false) goto L179;
        if (r147 == false) goto L179;
        if (r148 != null) goto L168;
    L170:
        boolean r150 = false;
    L171:
        if (r150 == false) goto L179;
        if (r148 != null) goto L174;
    L176:
        boolean r151 = false;
    L177:
        if (r151 == false) goto L179;
        lp7.a.c("FlowTtsKmpManager", "quic enable");
        r143 = FlowAudioAudioTransportType.QUIC;
    L192:
        FlowAudioAudioTransportType r152 = r143;
        qw5.e r153 = f265445c;
        if (r153 == null) goto L195;
        String r154 = r153.f535009a;
    L196:
        if (r154 != null) goto L198;
        r154 = "";
    L198:
        String r155 = r154;
        if (r153 == null) goto L201;
        String r156 = r153.f535010b;
    L202:
        if (r156 != null) goto L204;
        r156 = "";
    L204:
        String r157 = r156;
        if (r153 == null) goto L207;
        String r158 = r153.f535011c;
    L208:
        if (r158 != null) goto L210;
        r158 = "";
    L210:
        String r159 = r158;
        FlowAudioTokenType r214 = FlowAudioTokenType.TOKEN_TO_B;
        qw5.e r160 = f265445c;
        if (r160 == null) goto L217;
        qw5.d r161 = r160.f535019k;
        if (r161 == null) goto L217;
        qw5.c r162 = r161.f535008a;
        if (r162 == null) goto L217;
        boolean r215 = r162.f535006a;
    L218:
        if (r160 == null) goto L227;
        qw5.d r163 = r160.f535019k;
        if (r163 == null) goto L227;
        qw5.c r164 = r163.f535008a;
        if (r164 == null) goto L227;
        int[] r165 = r164.f535007b;
        if (r165 == null) goto L227;
        List r166 = ArraysKt.toList(r165);
        if (r166 == null) goto L227;
    L228:
        List r216 = r166;
        qw5.e r167 = f265445c;
        if (r167 == null) goto L231;
        String r168 = r167.f535016h;
    L232:
        if (r168 != null) goto L234;
        r168 = "";
    L234:
        String r217 = r168;
        if (r167 == null) goto L237;
        boolean r218 = r167.f535023o;
    L238:
        if (r167 == null) goto L240;
        boolean r219 = r167.f535025q;
    L241:
        if (r167 == null) goto L243;
        boolean r317 = r167.f535026r;
    L244:
        pw5.a r318 = new pw5.a(r133, r159, r152, r155, r214, r157, r142, r215, r216, r217, r137, r310, r218, r219, r317);
        int r169 = d.f265481a;
        boolean r170 = !r210;
        e0 r171 = new e0();
        f265443a.getClass();
        qw5.e r172 = f265445c;
        if (r172 == null) goto L247;
        String r173 = r172.f535014f;
    L248:
        String r174 = "";
        if (r173 != null) goto L251;
        r173 = "";
    L251:
        j.c(r171, "app_version", r173);
        qw5.e r175 = f265445c;
        if (r175 == null) goto L254;
        int r176 = r175.f535015g;
    L255:
        j.b(r171, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.valueOf(r176));
        qw5.e r177 = f265445c;
        if (r177 == null) goto L258;
        String r178 = r177.f535013e;
    L259:
        if (r178 != null) goto L261;
        r178 = "";
    L261:
        j.c(r171, com.bytedance.android.ec.core.event.a.KEY_DID, r178);
        qw5.e r179 = f265445c;
        if (r179 == null) goto L264;
        String r180 = r179.f535012d;
    L265:
        if (r180 != null) goto L267;
        r180 = "";
    L267:
        j.c(r171, "uid", r180);
        j.c(r171, "flow_social", "false");
        if (r170 == false) goto L273;
        if (r315 == null) goto L273;
        String r181 = (String) r315.get("enable_toast_reading");
        if (r181 == null) goto L273;
        j.c(r171, "enable_toast_reading", r181);
    L273:
        if (r315 == null) goto L284;
        String r182 = (String) r315.get("chat_next");
        if (r182 == null) goto L284;
        e0 r183 = new e0();     // Catch: Exception -> L282
        j.c(r183, "chat_next", r182);     // Catch: Exception -> L282
        d0 r184 = r183.a();     // Catch: Exception -> L282
        if (r124 != null) goto L279;
        String r185 = SliceInitService.DEFAULT_SWITCH;
    L280:
        r174 = lp7.b.a(r184, lp7.b.b(r185)).toString();     // Catch: Exception -> L282
    L287:
        j.c(r171, "extra", r174);
        if (r315 == null) goto L292;
        String r186 = (String) r315.get("is_son_msg");
        if (r186 == null) goto L292;
        j.c(r171, "is_son_msg", r186);
    L292:
        if (r315 == null) goto L296;
        String r187 = (String) r315.get("parent_msg_id");
        if (r187 == null) goto L296;
        j.c(r171, "parent_msg_id", r187);
    L296:
        qw5.a r188 = new qw5.a(r310, r138, r128, "unknown_trace_info", r139, r416, r212, r318, r211, null, r213, r171.a().toString(), 4608);
        f265465w = false;
        if (r312 != null) goto L299;
    L302:
        boolean r189 = true;
    L303:
        if (r189 == true) goto L308;
        buc.e<String> r190 = f265446d;
        if (Intrinsics.areEqual(r312, r190.c()) == false) goto L308;
        lp7.a.c("FlowTtsKmpManager", "[TTS][CURRENT_MSG_IS_PLAYING] startTts taskId: " + r310 + ", curPlayingMsgId: " + r190.c());
        return;
    L308:
        f265446d.d(r312);
        f265466x = r415;
        FlowTtsTraceHelper r191 = FlowTtsTraceHelper.INSTANCE;
        if (r312 != null) goto L311;
        String r192 = "";
    L312:
        TtsTracer r193 = r191.getTracerByTaskId(r192);
        if (r193 != null) goto L319;
        r193 = TtsTracer.Companion.generateTracer();
        int r194 = 1;
        r193.setTmpTracer(true);
        if (r312 != null) goto L317;
        String r195 = "";
    L318:
        r191.addTracer(r195, r193);
    L320:
        TtsTracer r196 = r193;
        if (r312 != null) goto L323;
        String r197 = "";
    L324:
        r191.replaceTracer(r197, r310);
        r196.appendExtra(r315, r316);
        if (r315 == null) goto L327;
        String r198 = (String) r315.get("bot_id");
    L328:
        r196.appendData(r310, r311, r312, r198, r314, null);
        if (r410 != null) goto L331;
        String r199 = "";
    L333:
        if (r199.length() <= 0) goto L335;
        boolean r200 = true;
    L336:
        r196.initTask(r200);
        long r201 = D("startTts taskId=".concat(r310));
        f265450h.a();
        f265449g.d(false);
        f265460r.d(false);
        lp7.a.a("FlowTtsKmpManager", "initAudioPlayer");
        com.bytedance.a r202 = f265451i;
        rw5.f r203 = (rw5.f) f265454l.getValue();
        r202.getClass();
        Intrinsics.checkNotNullParameter(r203, "config");
        r202.f33901f = r203;
        r202.f33898c = C;
        r202.start();
        FlowTtsSession r204 = new FlowTtsSession(r188, new c(new g()));
        b r205 = M;
        Intrinsics.checkNotNullParameter(r205, "listener");
        if (r204.f244067g == false) goto L346;
        Object r206 = r204.f244066f;
        monitor-enter(r206);
        r204.f244065e = r205;     // Catch: Throwable -> L343
        Unit r207 = Unit.INSTANCE;     // Catch: Throwable -> L343
        monitor-exit(r206);
    L347:
        r204.n3("setListener sessionId=" + r204.f244064d);
        f265452j = r204;
        Job r208 = B;
        if (r208 == null) goto L350;
        Job.DefaultImpls.cancel$default(r208, null, r194, null);
    L350:
        if (r210 == false) goto L357;
        FlowTtsSession r209 = f265452j;
        if (r209 == null) goto L360;
        if (r410 != null) goto L355;
        String r220 = "";
    L356:
        r209.o3(r220);
        goto L360
    L355:
        r220 = r410;
    L360:
        f265456n.d(false);
        f265457o.d(false);
        f265463u.d(r312);
        f265442J.d(null);
        E = -1;
        H.d(false);
        K(r310);
        if (r417 == false) goto L363;
        N(r310, r312, r201);
    L364:
        x(AudioPlayerStatus.Initial);
        return;
    L363:
        lp7.a.c("FlowTtsKmpManager", "[TTS] skip startAudioPlay because audio focus is not ready, taskId=" + r310 + ", msgId=" + r312);
        goto L364
    L357:
        FlowTtsSession r221 = f265452j;
        if (r221 == null) goto L360;
        r221.start();
    L343:
        th = move-exception;
        throw th;
    L346:
        r204.f244065e = r205;
        goto L347
    L335:
        r200 = false;
        goto L336
    L331:
        r199 = r410;
        goto L333
    L327:
        r198 = null;
        goto L328
    L323:
        r197 = r312;
        goto L324
    L317:
        r195 = r312;
        goto L318
    L319:
        r194 = 1;
        goto L320
    L311:
        r192 = r312;
        goto L312
    L299:
        if (r312.length() == 0) goto L302;
        r189 = false;
        goto L303
    L279:
        r185 = r124;
    L282:
        e = move-exception;
        IKMPLoggerService r222 = lp7.a.f510233a;
        lp7.a.b("ExtraUtil", "buildTtsExtra from json error e=" + e);
    L284:
        if (r124 == null) goto L287;
        r174 = r124;
        goto L287
    L264:
        r180 = null;
        goto L265
    L258:
        r178 = null;
        goto L259
    L254:
        r176 = 0;
        goto L255
    L247:
        r173 = null;
        goto L248
    L243:
        r317 = false;
        goto L244
    L240:
        r219 = false;
        goto L241
    L237:
        r218 = false;
        goto L238
    L231:
        r168 = null;
    L227:
        r166 = CollectionsKt.emptyList();
    L217:
        r215 = false;
        goto L218
    L207:
        r158 = null;
        goto L208
    L201:
        r156 = null;
        goto L202
    L195:
        r154 = null;
        goto L196
    L174:
        if (r148.f535023o != true) goto L176;
        r151 = true;
        goto L177
    L168:
        if (r148.f535024p != true) goto L170;
        r150 = true;
    L179:
        IKMPLoggerService r223 = lp7.a.f510233a;
        StringBuilder r224 = new StringBuilder("quic not enable. isUseFrontierQuic=");
        qw5.e r225 = f265445c;
        if (r225 == null) goto L182;
        Boolean r226 = Boolean.valueOf(r225.f535020l);
    L183:
        r224.append(r226);
        r224.append(", isConnectPoolEnableForBusiness=");
        r224.append(r147);
        r224.append(", audioFrontierQuicEnable=");
        qw5.e r227 = f265445c;
        if (r227 == null) goto L186;
        Boolean r228 = Boolean.valueOf(r227.f535024p);
    L187:
        r224.append(r228);
        r224.append(", isConnectPoolEnable=");
        qw5.e r229 = f265445c;
        if (r229 == null) goto L190;
        Boolean r230 = Boolean.valueOf(r229.f535023o);
    L191:
        r224.append(r230);
        lp7.a.c("FlowTtsKmpManager", r224.toString());
        goto L192
    L190:
        r230 = null;
        goto L191
    L186:
        r228 = null;
        goto L187
    L182:
        r226 = null;
        goto L183
    L160:
        if (r148.f535020l != true) goto L162;
        r149 = true;
        goto L164
    L151:
        if (r145.f535021m != true) goto L153;
        r146 = true;
    L156:
        r147 = false;
        goto L157
    L146:
        r144 = false;
        goto L147
    L142:
        r142 = 10000;
        goto L143
    L132:
        if (r413 != 0.0f) goto L134;
        boolean r231 = true;
    L135:
        if (r231 == true) goto L138;
        r213 = new mw5.a(r412.toString(), "{\"target_lufs\": " + r413 + '}', r414);
        goto L139
    L134:
        r231 = false;
        goto L135
    L126:
        if (r412.length() == 0) goto L129;
        r140 = false;
        goto L130
    L122:
        r138 = r311;
    L117:
        r137 = null;
        goto L118
    L366:
        Result.Companion r232 = Result.Companion;     // Catch: Throwable -> L102
        Uri r233 = UriProtector.parse(r130);     // Catch: Throwable -> L102
        Set<String> r234 = UriProtector.getQueryParameterNames(r233);     // Catch: Throwable -> L102
        Uri.Builder r235 = r233.buildUpon();     // Catch: Throwable -> L102
        if (r131 <= 0) goto L90;
        cv5.a.a(r234, r235, StateKey.KEY_DOUBAO_UPDATE_VERSION_CODE, String.valueOf(r131));     // Catch: Throwable -> L102
    L90:
        String r236 = Build.VERSION.RELEASE;     // Catch: Throwable -> L102
        if (r236 != null) goto L94;
        r236 = "";
    L94:
        cv5.a.a(r234, r235, "doubao_os_version", r236);     // Catch: Throwable -> L102
        String r237 = Build.MODEL;     // Catch: Throwable -> L102
        if (r237 != null) goto L97;
        r237 = "";
    L97:
        cv5.a.a(r234, r235, "doubao_device_type", r237);     // Catch: Throwable -> L102
        String r238 = Build.BRAND;     // Catch: Throwable -> L102
        if (r238 != null) goto L100;
        r238 = "";
    L100:
        cv5.a.a(r234, r235, "doubao_device_brand", r238);     // Catch: Throwable -> L102
        cv5.a.a(r234, r235, "doubao_device_platform", "android");     // Catch: Throwable -> L102
        Object r239 = Result.m9449constructorimpl(r235.build().toString());     // Catch: Throwable -> L102
    L104:
        Object r240 = r130;
        if (Result.m9455isFailureimpl(r239) == true) goto L108;
        r240 = r239;
    L108:
        r133 = (String) r240;
    L102:
        th = move-exception;
        Result.Companion r241 = Result.Companion;
        r239 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L104
    L83:
        r131 = 0;
        goto L84
    L78:
        r130 = null;
        goto L79
    L74:
        r127 = FlowAudioSessionRequestType.MessageTTS;
        goto L75
    L70:
        r126 = r314;
        goto L71
    L67:
        r125 = r314;
        goto L68
    L45:
        r116 = r316;
        goto L46
    L41:
        r113 = r312;
        goto L42
    L37:
        r112 = r311;
        goto L38
    L31:
        r111 = null;
        goto L32
    L25:
        r108 = null;
        goto L26
    L20:
        r107 = null;
        goto L21
    L13:
        if (r410.length() == 0) goto L16;
        r106 = false;
        goto L17
    }

    public static void I(String r110, String r111, String r210, boolean r211, String r212, boolean r213, Map r214, String r215, String r216, ww5.b r217, String r218, float r219, int r310, boolean r311, int r312, boolean r313) {
        Object r100 = f265444b;
        monitor-enter(r100);
        f265443a.J(r110, r111, r210, r211, r212, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313);     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // qw5.b
    public final void u(String r110, String r111, String r210, boolean r211, String r212, String r213, boolean r214, Map r215, String r216, i78.c r217, String r218, float r219, int r310, boolean r311, int r312, boolean r313) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        I(r110, r111, r210, r211, r212, r214, r215, r216, "", r217, r218, r219, r310, r311, r312, r313);
    }
}
