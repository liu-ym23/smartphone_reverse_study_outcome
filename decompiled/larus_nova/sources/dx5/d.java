package dx5;

import com.bytedance.flow_audio.api.business.tts.error.FlowAudioAssistantError;
import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.impl.core.task.FlowAudioAssistantTask;
import com.bytedance.flow_audio.impl.core.task.FlowAudioAssistantTaskPool;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioNetConnectionEventParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionDownlinkEventParam;
import com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSessionListener;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioNetConnectionStateType;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTransportType;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionDownlinkEventType;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionUplinkEventType;
import cx5.g;
import cx5.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import nw5.e;
import ouc.d0;
import ouc.g0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements SpeechVoiceAssistantSessionListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f470419i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qw5.a f470420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowAudioAssistantScene f470421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlowAudioAssistantTask f470422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f470423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<dx5.a> f470424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReentrantLock f470425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Long> f470426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f470427h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f470428a = null;

        static {
            int[] r100 = new int[SpeechVoiceAssistantSessionDownlinkEventType.values().length];
            r100[SpeechVoiceAssistantSessionDownlinkEventType.SessionStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.ChatResponse.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.ChatEnded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.TTSSentenceStart.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.TTSResponse.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.TTSSentenceEnd.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.TTSEnded.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.ASRResponse.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.ASREnded.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.SessionFailed.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.TaskFailed.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.SessionFinished.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r100[SpeechVoiceAssistantSessionDownlinkEventType.SessionCanceled.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            f470428a = r100;
        }
    }

    static {
    }

    public final void a() throws Exception {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        e("run:cancel");     // Catch: Throwable -> L10
        ReentrantLock r101 = this.f470423d;     // Catch: Throwable -> L10
        r101.lock();     // Catch: Throwable -> L10
        FlowAudioAssistantTask r102 = this.f470422c;     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.c("cancelSession");     // Catch: Throwable -> L7
        r102.a(r102.d(SpeechVoiceAssistantSessionUplinkEventType.CancelSession, null), "cancelSession");     // Catch: Throwable -> L7
        r102.c("cancelSession: ok");     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
    L6:
        r101.unlock();     // Catch: Throwable -> L10
        e("cancel: ok");     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        d("run:cancel error=" + r105);
    L15:
        ResultKt.throwOnFailure(r104);
        return;
    L7:
        th = move-exception;
        r101.unlock();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final ouc.a c() {
        return (ouc.a) this.f470427h.getValue();
    }

    public final void g() throws Exception {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        e("run:start");     // Catch: Throwable -> L8
        ReentrantLock r101 = this.f470423d;     // Catch: Throwable -> L8
        r101.lock();     // Catch: Throwable -> L8
        FlowAudioAssistantTask r102 = FlowAudioAssistantTaskPool.f244106e.a(this.f470421b, this.f470420a, this);     // Catch: Throwable -> L5
        this.f470422c = r102;     // Catch: Throwable -> L5
        r102.g();     // Catch: Throwable -> L5
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r101.unlock();     // Catch: Throwable -> L8
        e("start: ok");     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        d("run:start error=" + r105);
    L13:
        ResultKt.throwOnFailure(r104);
        return;
    L5:
        th = move-exception;
        r101.unlock();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void h() throws Exception {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        e("run:stop");     // Catch: Throwable -> L10
        ReentrantLock r101 = this.f470423d;     // Catch: Throwable -> L10
        r101.lock();     // Catch: Throwable -> L10
        FlowAudioAssistantTask r102 = this.f470422c;     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.c("stopSession");     // Catch: Throwable -> L7
        r102.a(r102.d(SpeechVoiceAssistantSessionUplinkEventType.FinishSession, null), "stopSession");     // Catch: Throwable -> L7
        r102.c("stopSession: ok");     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
    L6:
        r101.unlock();     // Catch: Throwable -> L10
        e("stop: ok");     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        d("run:stop error=" + r105);
    L15:
        ResultKt.throwOnFailure(r104);
        return;
    L7:
        th = move-exception;
        r101.unlock();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void i() throws Exception {
        mw5.c r100 = this.f470420a.f535001i;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.f515950d != true) goto L7;
    L8:
        if (r101 == false) goto L28;
        return;
    L28:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        e("run:ttsBegin");     // Catch: Throwable -> L19
        ReentrantLock r103 = this.f470423d;     // Catch: Throwable -> L19
        r103.lock();     // Catch: Throwable -> L19
        FlowAudioAssistantTask r104 = this.f470422c;     // Catch: Throwable -> L16
        if (r104 == null) goto L15;
        r104.c("ttsBegin");     // Catch: Throwable -> L16
        r104.a(r104.d(SpeechVoiceAssistantSessionUplinkEventType.StartTTS, null), "ttsBegin");     // Catch: Throwable -> L16
        r104.c("ttsBegin: ok");     // Catch: Throwable -> L16
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L15:
        r103.unlock();     // Catch: Throwable -> L19
        e("ttsBegin: ok");     // Catch: Throwable -> L19
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        d("run:ttsBegin error=" + r107);
    L24:
        ResultKt.throwOnFailure(r106);
        return;
    L16:
        th = move-exception;
        r103.unlock();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = false;
        goto L8
    }

    public final void j() throws Exception {
        mw5.c r100 = this.f470420a.f535001i;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.f515950d != true) goto L7;
    L8:
        if (r101 == true) goto L28;
        return;
    L28:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        e("run:ttsEnd");     // Catch: Throwable -> L19
        ReentrantLock r103 = this.f470423d;     // Catch: Throwable -> L19
        r103.lock();     // Catch: Throwable -> L19
        FlowAudioAssistantTask r104 = this.f470422c;     // Catch: Throwable -> L16
        if (r104 == null) goto L15;
        r104.c("ttsEnd");     // Catch: Throwable -> L16
        r104.a(r104.d(SpeechVoiceAssistantSessionUplinkEventType.BIDIRECTIONALEndTTS, null), "ttsEnd");     // Catch: Throwable -> L16
        r104.c("ttsEnd: ok");     // Catch: Throwable -> L16
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L15:
        r103.unlock();     // Catch: Throwable -> L19
        e("ttsEnd: ok");     // Catch: Throwable -> L19
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        d("run:ttsEnd error=" + r107);
    L24:
        ResultKt.throwOnFailure(r106);
        return;
    L16:
        th = move-exception;
        r103.unlock();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = false;
        goto L8
    }

    public d(qw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f470420a = r100;
        FlowAudioAssistantScene r101 = r100.f534997e;
        this.f470421b = r101;
        String r102 = r100.f534993a;
        this.f470423d = new ReentrantLock();
        this.f470424e = new LinkedHashSet();
        this.f470425f = new ReentrantLock();
        this.f470426g = new LinkedHashMap();
        e("create: sessionId=" + r102 + " scene=" + r101.getRawValue());
        this.f470427h = LazyKt.lazy(new dx5.b());
    }

    public final void b(boolean r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        e("run:clear");     // Catch: Throwable -> L19
        ReentrantLock r102 = this.f470423d;     // Catch: Throwable -> L19
        r102.lock();     // Catch: Throwable -> L19
        FlowAudioAssistantTask r103 = this.f470422c;     // Catch: Throwable -> L16
        if (r103 == null) goto L6;
        r103.f244101f.d(null);     // Catch: Throwable -> L16
    L6:
        this.f470422c = null;     // Catch: Throwable -> L16
        r102.unlock();     // Catch: Throwable -> L19
        if (r103 == null) goto L10;
        FlowAudioAssistantTaskPool.f244106e.e(this.f470420a.f534997e, r103, r100);     // Catch: Throwable -> L19
    L10:
        ReentrantLock r104 = this.f470425f;     // Catch: Throwable -> L19
        r104.lock();     // Catch: Throwable -> L19
        this.f470424e.clear();     // Catch: Throwable -> L13
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r104.unlock();     // Catch: Throwable -> L19
        e("clear: ok");     // Catch: Throwable -> L19
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        d("run:clear error=" + r107);
    L24:
        ResultKt.throwOnFailure(r106);
        return;
    L13:
        th = move-exception;
        r104.unlock();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        r102.unlock();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public final void d(String r100) {
        pd6.b r101 = pd6.c.f528682a;
        IKMPLoggerService r102 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r102 == null) goto L6;
        r102.logError(r100, "kmp_FlowAudioAssistantSession");
        return;
    }

    public final void e(String r100) {
        pd6.b r101 = pd6.c.f528682a;
        IKMPLoggerService r102 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r102 == null) goto L6;
        r102.m1(r100, "kmp_FlowAudioAssistantSession");
        return;
    }

    public final void f(bx5.a r100) {
        if (this.f470420a.f535002j != null) goto L5;
        return;
    L5:
        ReentrantLock r101 = this.f470425f;
        r101.lock();
        List r102 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L12
        r101.unlock();
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        ((dx5.a) r103.next()).h3(this, r100);
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void k(String r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "text");
        mw5.c r101 = this.f470420a.f535001i;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f515950d != true) goto L7;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        String r103 = "ttsSendText len=" + r100.length();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        e("run:" + r103);     // Catch: Throwable -> L19
        ReentrantLock r105 = this.f470423d;     // Catch: Throwable -> L19
        r105.lock();     // Catch: Throwable -> L19
        FlowAudioAssistantTask r106 = this.f470422c;     // Catch: Throwable -> L16
        if (r106 == null) goto L15;
        r106.h(r100);     // Catch: Throwable -> L16
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L15:
        r105.unlock();     // Catch: Throwable -> L19
        e("ttsSendText: ok");     // Catch: Throwable -> L19
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L24;
        d("run:" + r103 + " error=" + r109);
    L24:
        ResultKt.throwOnFailure(r108);
        return;
    L16:
        th = move-exception;
        r105.unlock();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSessionListener
    public final void onDownlinkEvent(SpeechVoiceAssistantSessionDownlinkEventType r100, SpeechVoiceAssistantSessionDownlinkEventParam r110) {
        Intrinsics.checkNotNullParameter(r100, "type");
        e("downlink: type=" + r100);
        int[] r101 = b.f470428a;
        boolean r102 = true;
        String r103 = null;
        String r104 = null;
        String r105 = null;
        nw5.b r106 = null;
        r106 = null;
        r106 = null;
        r106 = null;
        r106 = null;
        Object r107 = null;
        h r108 = null;
        String r109 = "";
        int r111 = 0;
        switch(r101[r100.ordinal()]) {
            case 1: goto L294;
            case 2: goto L92;
            case 3: goto L92;
            case 4: goto L92;
            case 5: goto L92;
            case 6: goto L92;
            case 7: goto L92;
            case 8: goto L48;
            case 9: goto L48;
            case 10: goto L23;
            case 11: goto L23;
            case 12: goto L14;
            case 13: goto L5;
            default: goto L345;
        };
    L5:
        ReentrantLock r112 = this.f470425f;
        r112.lock();
        List r113 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L11
        r112.unlock();
        Iterator r114 = r113.iterator();
    L9:
        if (r114.hasNext() == false) goto L351;
        ((dx5.a) r114.next()).u(this);
        goto L9
    L351:
        return;
    L11:
        th = move-exception;
        r112.unlock();
        throw th;
    L14:
        ReentrantLock r115 = this.f470425f;
        r115.lock();
        List r116 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L20
        r115.unlock();
        Iterator r117 = r116.iterator();
    L18:
        if (r117.hasNext() == false) goto L352;
        ((dx5.a) r117.next()).H2(this, null);
        goto L18
    L352:
        return;
    L20:
        th = move-exception;
        r115.unlock();
        throw th;
    L23:
        int r118 = r101[r100.ordinal()];
        if (r118 != 10) goto L26;
    L28:
        if (r110 == null) goto L30;
        r111 = r110.getStatusCode();
    L30:
        if (r110 == null) goto L36;
        String r119 = r110.getStatusText();
        if (r119 == null) goto L36;
        r109 = r119;
    L36:
        if (r100 != SpeechVoiceAssistantSessionDownlinkEventType.TaskFailed) goto L38;
        FlowAudioAssistantError.ErrorType r120 = FlowAudioAssistantError.ErrorType.TaskFailed;
    L39:
        FlowAudioAssistantError r121 = new FlowAudioAssistantError("sessionFailed:" + r111 + ':' + r109, r111, r120);
        ReentrantLock r122 = this.f470425f;
        r122.lock();
        List r123 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L45
        r122.unlock();
        Iterator r124 = r123.iterator();
    L43:
        if (r124.hasNext() == false) goto L353;
        ((dx5.a) r124.next()).H2(this, r121);
        goto L43
    L353:
        return;
    L45:
        th = move-exception;
        r122.unlock();
        throw th;
    L38:
        r120 = FlowAudioAssistantError.ErrorType.SessionFailed;
        goto L39
    L26:
        if (r118 == 11) goto L28;
        return;
    L48:
        e("handleASREvent: event=" + r100);
        int r125 = r101[r100.ordinal()];
        if (r125 != 8) goto L51;
        if (r110 == null) goto L62;
        String r126 = r110.getTextMsg();
    L63:
        if (r126 == null) goto L67;
        r109 = r126;
    L67:
        if (r109.length() == 0) goto L70;
        r102 = false;
    L70:
        if (r102 == false) goto L324;
        cx5.c r127 = null;
    L83:
        if (r127 != null) goto L86;
        return;
    L86:
        if (r110 == null) goto L88;
        String r128 = r110.getTaskId();
    L89:
        if (r110 == null) goto L91;
        r105 = r110.getSessionId();
    L91:
        f(new bx5.a.b(r128, r105, r127));
        return;
    L88:
        r128 = null;
        goto L89
    L324:
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L74
        ouc.a r130 = c();     // Catch: Throwable -> L74
        r130.getClass();     // Catch: Throwable -> L74
        Object r131 = Result.m9449constructorimpl((cx5.c) r130.c(cx5.c.Companion.serializer(), r109));     // Catch: Throwable -> L74
    L76:
        Throwable r132 = Result.m9452exceptionOrNullimpl(r131);
        if (r132 == null) goto L80;
        d("decodeASRResponse: error=" + r132);
    L80:
        if (Result.m9455isFailureimpl(r131) == false) goto L82;
        r131 = null;
    L82:
        r127 = (cx5.c) r131;
    L74:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L76
    L62:
        r126 = null;
        goto L63
    L51:
        if (r125 == 9) goto L54;
        return;
    L54:
        if (r110 == null) goto L56;
        String r134 = r110.getTaskId();
    L57:
        if (r110 == null) goto L59;
        r104 = r110.getSessionId();
    L59:
        f(new bx5.a.C0371a(r134, r104));
        return;
    L56:
        r134 = null;
        goto L57
    L92:
        int r135 = r101[r100.ordinal()];
        if (r135 != 2) goto L95;
        ReentrantLock r136 = this.f470425f;
        r136.lock();
        List r137 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L291
        r136.unlock();
        Iterator r138 = r137.iterator();
    L289:
        if (r138.hasNext() == false) goto L358;
        ((dx5.a) r138.next()).z0(this, bx5.c.b.f21360a);
        goto L289
    L358:
        return;
    L291:
        th = move-exception;
        r136.unlock();
        throw th;
    L95:
        if (r135 != 4) goto L97;
        if (r110 == null) goto L247;
        String r139 = r110.getTextMsg();
    L248:
        if (r139 != null) goto L251;
        r139 = "";
    L251:
        if (r139.length() == 0) goto L254;
        r102 = false;
    L254:
        if (r102 == false) goto L310;
        e r140 = null;
    L267:
        if (r140 != null) goto L275;
        StringBuilder r141 = new StringBuilder("handleTTSEvent: event=");
        r141.append(r100);
        r141.append(" decode failed. raw_msg=");
        if (r110 == null) goto L271;
        r103 = r110.getTextMsg();
    L271:
        if (r103 == null) goto L274;
        r109 = r103;
    L274:
        r141.append(r109);
        d(r141.toString());
    L276:
        g r142 = new g(r140, 14);
        ReentrantLock r143 = this.f470425f;
        r143.lock();
        List r144 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L282
        r143.unlock();
        Iterator r145 = r144.iterator();
    L280:
        if (r145.hasNext() == false) goto L357;
        ((dx5.a) r145.next()).z0(this, new bx5.c.d(r142));
        goto L280
    L357:
        return;
    L282:
        th = move-exception;
        r143.unlock();
        throw th;
    L275:
        e("handleTTSEvent: event=" + r100 + " sentence=" + r140.f520996a);
        goto L276
    L310:
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L258
        ouc.a r147 = c();     // Catch: Throwable -> L258
        r147.getClass();     // Catch: Throwable -> L258
        Object r148 = Result.m9449constructorimpl((e) r147.c(e.Companion.serializer(), r139));     // Catch: Throwable -> L258
    L260:
        Throwable r149 = Result.m9452exceptionOrNullimpl(r148);
        if (r149 == null) goto L264;
        d("decodeTTSSentence: error=" + r149);
    L264:
        if (Result.m9455isFailureimpl(r148) == false) goto L266;
        r148 = null;
    L266:
        r140 = (e) r148;
    L258:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r148 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L260
    L247:
        r139 = null;
        goto L248
    L97:
        if (r135 != 5) goto L99;
        if (r110 == null) goto L194;
        String r151 = r110.getTextMsg();
    L195:
        if (r151 != null) goto L198;
        r151 = "";
    L198:
        if (r151.length() == 0) goto L201;
        r102 = false;
    L201:
        if (r102 == false) goto L328;
        g r152 = null;
    L214:
        if (r152 != null) goto L223;
        StringBuilder r153 = new StringBuilder("handleTTSEvent: event=");
        r153.append(r100);
        r153.append(" decode failed. raw_msg=");
        if (r110 == null) goto L218;
        String r154 = r110.getTextMsg();
    L219:
        if (r154 == null) goto L222;
        r109 = r154;
    L222:
        r153.append(r109);
        d(r153.toString());
        goto L223
    L218:
        r154 = null;
    L223:
        if (r110 == null) goto L344;
        byte[] r155 = r110.getBinaryData();
        if (r155 != null) goto L228;
        return;
    L228:
        if (r152 == null) goto L230;
        e r156 = r152.f465733a;
    L231:
        if (r152 == null) goto L233;
        String r157 = r152.f465734b;
    L234:
        if (r152 == null) goto L236;
        r108 = r152.f465736d;
    L236:
        g r158 = new g(r156, r157, r155, r108);
        ReentrantLock r159 = this.f470425f;
        r159.lock();
        List r160 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L242
        r159.unlock();
        Iterator r161 = r160.iterator();
    L240:
        if (r161.hasNext() == false) goto L356;
        ((dx5.a) r161.next()).z0(this, new bx5.c.a(r158));
        goto L240
    L356:
        return;
    L242:
        th = move-exception;
        r159.unlock();
        throw th;
    L233:
        r157 = null;
        goto L234
    L230:
        r156 = null;
        goto L231
    L344:
        return;
    L328:
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L205
        ouc.a r163 = c();     // Catch: Throwable -> L205
        r163.getClass();     // Catch: Throwable -> L205
        Object r164 = Result.m9449constructorimpl((g) r163.c(g.Companion.serializer(), r151));     // Catch: Throwable -> L205
    L207:
        Throwable r165 = Result.m9452exceptionOrNullimpl(r164);
        if (r165 == null) goto L211;
        d("decodeTTSResponse: error=" + r165);
    L211:
        if (Result.m9455isFailureimpl(r164) == false) goto L213;
        r164 = null;
    L213:
        r152 = (g) r164;
    L205:
        th = move-exception;
        Result.Companion r166 = Result.Companion;
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L207
    L194:
        r151 = null;
        goto L195
    L99:
        if (r135 != 6) goto L101;
        if (r110 == null) goto L141;
        String r167 = r110.getTextMsg();
    L142:
        if (r167 == null) goto L316;
        r109 = r167;
    L316:
        Result.Companion r168 = Result.Companion;     // Catch: Throwable -> L173
        i r169 = c().e(r109);     // Catch: Throwable -> L173
        if ((r169 instanceof d0) == false) goto L148;
        d0 r170 = (d0) r169;     // Catch: Throwable -> L173
    L149:
        if (r170 == null) goto L183;
        i r171 = (i) r170.get("text");     // Catch: Throwable -> L173
        if (r171 == null) goto L183;
        String r172 = k.g(k.o(r171));     // Catch: Throwable -> L173
        if (r172 == null) goto L183;
        i r173 = (i) r170.get("speech_alignment_result");     // Catch: Throwable -> L173
        if (r173 == null) goto L183;
        if ((r173 instanceof g0) == false) goto L164;
        String r174 = k.g((g0) r173);     // Catch: Throwable -> L173
        if (r174 != null) goto L166;
        r174 = ((g0) r173).toString();     // Catch: Throwable -> L173
    L166:
        if (r174.length() == 0) goto L169;
        r102 = false;
    L169:
        if (r102 == true) goto L183;
        ouc.a r175 = c();     // Catch: Throwable -> L173
        r175.getClass();     // Catch: Throwable -> L173
        Object r176 = Result.m9449constructorimpl(new nw5.b(r172, (nw5.d) r175.c(nw5.d.Companion.serializer(), r174)));     // Catch: Throwable -> L173
    L175:
        Throwable r177 = Result.m9452exceptionOrNullimpl(r176);
        if (r177 == null) goto L179;
        d("decodeSentenceInfo: error=" + r177);
    L179:
        if (Result.m9455isFailureimpl(r176) == true) goto L182;
        r107 = r176;
    L182:
        r106 = (nw5.b) r107;
        goto L183
    L164:
        r174 = r173.toString();     // Catch: Throwable -> L173
    L183:
        ReentrantLock r178 = this.f470425f;
        r178.lock();
        List r179 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L189
        r178.unlock();
        Iterator r180 = r179.iterator();
    L187:
        if (r180.hasNext() == false) goto L355;
        ((dx5.a) r180.next()).z0(this, new bx5.c.e(r106));
        goto L187
    L355:
        return;
    L189:
        th = move-exception;
        r178.unlock();
        throw th;
    L148:
        r170 = null;
    L173:
        th = move-exception;
        Result.Companion r181 = Result.Companion;
        r176 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L175
    L141:
        r167 = null;
        goto L142
    L101:
        if (r135 != 7) goto L349;
        if (r110 == null) goto L105;
        String r182 = r110.getTextMsg();
    L106:
        if (r182 == null) goto L110;
        r109 = r182;
    L110:
        if (r109.length() == 0) goto L113;
        r102 = false;
    L113:
        if (r102 == false) goto L312;
        bx5.b r183 = null;
    L126:
        ReentrantLock r184 = this.f470425f;
        r184.lock();
        List r185 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L136
        r184.unlock();
        Iterator r186 = r185.iterator();
    L130:
        if (r186.hasNext() == false) goto L354;
        dx5.a r187 = (dx5.a) r186.next();
        if (r183 == null) goto L134;
        Boolean r188 = r183.f21356a;
    L135:
        r187.z0(this, new bx5.c.C0373c(r188));
        goto L130
    L134:
        r188 = null;
        goto L135
    L354:
        return;
    L136:
        th = move-exception;
        r184.unlock();
        throw th;
    L312:
        Result.Companion r189 = Result.Companion;     // Catch: Throwable -> L117
        Object r190 = Result.m9449constructorimpl((bx5.b) c().c(bx5.b.Companion.serializer(), r109));     // Catch: Throwable -> L117
    L119:
        Throwable r191 = Result.m9452exceptionOrNullimpl(r190);
        if (r191 == null) goto L123;
        d("decodeTTSEnded: error=" + r191);
    L123:
        if (Result.m9455isFailureimpl(r190) == false) goto L125;
        r190 = null;
    L125:
        r183 = (bx5.b) r190;
    L117:
        th = move-exception;
        Result.Companion r192 = Result.Companion;
        r190 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L119
    L105:
        r182 = null;
        goto L106
    L349:
        return;
    L294:
        ReentrantLock r193 = this.f470425f;
        r193.lock();
        List r194 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L300
        r193.unlock();
        Iterator r195 = r194.iterator();
    L298:
        if (r195.hasNext() == false) goto L359;
        ((dx5.a) r195.next()).k0(this, Unit.INSTANCE);
        goto L298
    L359:
        return;
    L300:
        th = move-exception;
        r193.unlock();
        throw th;
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSessionListener
    public final void onNetConnectionStateChangedEvent(SpeechAudioTransportType r100, SpeechAudioNetConnectionEventParam r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r101 == null) goto L21;
        SpeechAudioNetConnectionStateType r102 = r101.getState();
        if (r102 == null) goto L26;
        e("net: type=" + r100 + " state=" + r102);
        if (r102 != SpeechAudioNetConnectionStateType.ConnectionStateConnectFailed) goto L10;
    L11:
        FlowAudioAssistantError r103 = new FlowAudioAssistantError("netError:" + r102.getValue() + ':' + r102, r102.getValue(), FlowAudioAssistantError.ErrorType.ConnectFailed);
        ReentrantLock r104 = this.f470425f;
        r104.lock();
        List r105 = CollectionsKt.toList(this.f470424e);     // Catch: Throwable -> L18
        r104.unlock();
        Iterator r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L25;
        ((dx5.a) r106.next()).H2(this, r103);
        goto L15
    L25:
        return;
    L18:
        th = move-exception;
        r104.unlock();
        throw th;
    L10:
        if (r102 == SpeechAudioNetConnectionStateType.ConnectionStateConnectClosed) goto L11;
        return;
    L26:
        return;
    }
}
