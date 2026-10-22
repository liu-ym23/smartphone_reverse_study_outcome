package com.larus.tts.impl;

import android.os.Looper;
import com.bytedance.flow_audio.api.tracer.FlowTtsTraceHelper;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.TtsStep;
import com.larus.audio.bean.CacheConfig;
import com.larus.audio.d1;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.trace.ChatTTSPlayTrace;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsScene;
import com.larus.utils.t0;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class TtsReader implements x1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f370203i = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f2a.d f370204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f370205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f370206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f370207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<b> f370208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f370209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutexImpl f370210h;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f370213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f370214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f370215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f370216e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final p68.i f370217f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f370218g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f370219h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f370220i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f370212a, r101.f370212a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370213b, r101.f370213b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f370214c, r101.f370214c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f370215d, r101.f370215d) == true) goto L21;
            return false;
        L21:
            if (this.f370216e == r101.f370216e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f370217f, r101.f370217f) == true) goto L27;
            return false;
        L27:
            if (this.f370218g == r101.f370218g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f370219h, r101.f370219h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f370220i, r101.f370220i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f370212a.hashCode() * 31) + this.f370213b.hashCode()) * 31;
            String r101 = this.f370214c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f370215d.hashCode()) * 31;
            int r105 = 1231;
            if (this.f370216e == false) goto L9;
            int r106 = 1231;
        L10:
            int r107 = (r104 + r106) * 31;
            p68.i r108 = this.f370217f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            if (this.f370218g == true) goto L18;
            r105 = 1237;
        L18:
            int r111 = (r110 + r105) * 31;
            String r112 = this.f370219h;
            if (r112 != null) goto L21;
            int r113 = 0;
        L22:
            int r114 = (r111 + r113) * 31;
            String r115 = this.f370220i;
            if (r115 == null) goto L27;
            r102 = r115.hashCode();
        L27:
            return r114 + r102;
        L21:
            r113 = r112.hashCode();
            goto L22
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = 1237;
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "readerQueueTask(taskId=" + this.f370212a + ", questionId=" + this.f370213b + ", conversationId=" + this.f370214c + ", msgId=" + this.f370215d + ", skipTtsChecked=" + this.f370216e + ", voiceStyleInfo=" + this.f370217f + ", isFromManual=" + this.f370218g + ", replyUniqueKey=" + this.f370219h + ", chatNext=" + this.f370220i + ')';
        }

        public b(String r100, String r101, String r102, String r103, boolean r104, p68.i r105, boolean r106, String r107, String r110) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "questionId");
            Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.MSGID);
            this.f370212a = r100;
            this.f370213b = r101;
            this.f370214c = r102;
            this.f370215d = r103;
            this.f370216e = r104;
            this.f370217f = r105;
            this.f370218g = r106;
            this.f370219h = r107;
            this.f370220i = r110;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final void l6() {
        this.f370207e = false;
    }

    public TtsReader() {
        this.f370204b = new f2a.d("VoiceOutput", "TtsReader");
        this.f370208f = new LinkedList();
        this.f370210h = kotlinx.coroutines.sync.b.a();
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final boolean n6() {
        return this.f370207e;
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final String o6() {
        return this.f370205c;
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final String q6() {
        return this.f370206d;
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final void r6(String r100) {
        this.f370205c = r100;
    }

    public static final CacheConfig a(TtsReader r100, Message r101) {
        r100.getClass();
        if (com.larus.bmhome.chat.bean.d.z0(r101) == false) goto L5;
        CacheConfig r102 = new CacheConfig(1, Boolean.TRUE);
        r102.setMsgOwnerId(r101.getSenderId());
        return r102;
    L5:
        return null;
    }

    public final void g(String r100, boolean r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (z2.f365865a.m3() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        int r102 = c68.b.f22600a;     // Catch: Throwable -> L11
        c68.b.b("TtsReader", "require stopAndCancelAll: " + r100 + ", " + r101);     // Catch: Throwable -> L11
        AudioServiceDelegate.f288288a.i0().cancel(r100, r101);     // Catch: Throwable -> L11
        this.f370205c = null;     // Catch: Throwable -> L11
        this.f370206d = null;     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final void i6(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().n(false);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        t0.a(new e0(this, r100, r101));
        return;
    L5:
        g(r100, r101);
    }

    public static final void b(TtsReader r110, String r111, String r112, String r113) {
        r110.getClass();
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        String r101 = r100.N().b(r112);
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r101 = r100.N().c(r111);
    L11:
        if (r101 != null) goto L13;
    L14:
        r102 = true;
    L15:
        if (r102 == false) goto L17;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TtsReader$startTtsByMsgIdTrace$1(r111, r110, r112, r113, null), 2, null);
        return;
    L17:
        d(r112, r101, r111, r113);
        return;
    L13:
        if (r101.length() != 0) goto L15;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static void d(String r100, String r101, String r102, String r110) {
        AudioServiceDelegate.f288288a.N().g(r100, r101);
        m58.u r103 = m58.h.f512141l;
        if (r103 == null) goto L5;
        JSONObject r104 = new JSONObject();
        r104.put("tts_task_id", r110);
        r104.put("rec_msg_id", r100);
        r104.put("send_msg_id", r102);
        Unit r105 = Unit.INSTANCE;
        m58.u.a.b(r103, r101, "tts_touch_up_to_chat_first_pkg", null, null, r104, 12);
    L5:
        m58.u r106 = m58.h.f512141l;
        if (r106 == null) goto L8;
        m58.u.a.b(r106, r101, "tts_subscribe_cmd_to_chat_first_pkg", null, null, null, 28);
    L8:
        m58.u r107 = m58.h.f512141l;
        if (r107 == null) goto L12;
        r107.f(r101, "tts_chat_first_pkg_to_tts_first_pkg", null);
        return;
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final void k6(String r110, Map r111, Function0 r112, Function1 r113) {
        Intrinsics.checkNotNullParameter("doc", "type");
        Intrinsics.checkNotNullParameter(r110, "uniId");
        Intrinsics.checkNotNullParameter(r111, "payloadParam");
        Intrinsics.checkNotNullParameter(r112, "onNext");
        Intrinsics.checkNotNullParameter(r113, "onFailed");
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        r100.s().b();
        r100.s().a();
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().p(TtsStep.STEP_TTS_PRE_SUB_TO_TEXT_SHOW.getTraceName(), null);
        int r101 = c68.b.f22600a;
        c68.b.d("TtsReader", "[TTS] startTtsWithoutMessage reportStepStart STEP_TTS_TO_AUDIO_PLAY uniId=" + r110);
        IFlowTtsClientService.a.a().e(r110);
        IFlowTtsClientService.a.a().A(TtsStep.STEP_TTS_TO_AUDIO_PLAY.getTraceName(), null);
        d68.c.a(r110);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new TtsReader$startTtsWithoutMessage$1(r110, "doc", r111, r112, r113, this, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final void p6(Message r110, String r111, CoroutineScope r210, TtsScene r211) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "ttsText");
        monitor-enter(this);
        List<ITtsReaderInterceptor> r100 = i0.f370240a;     // Catch: Throwable -> L56
        if (r211 != null) goto L7;
        TtsScene r101 = TtsScene.Default;     // Catch: Throwable -> L56
    L9:
        if (i0.a(r110, r101) == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        AudioServiceDelegate r102 = AudioServiceDelegate.f288288a;     // Catch: Throwable -> L56
        r102.i0().h(r110);     // Catch: Throwable -> L56
        String r103 = r110.getMessageId();     // Catch: Throwable -> L56
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        String r112 = r103;
        String r104 = r110.getConversationId();     // Catch: Throwable -> L56
        if (r104 != null) goto L18;
        r104 = "";
    L18:
        String r105 = r110.getReplyId();     // Catch: Throwable -> L56
        if (r105 != null) goto L21;
        r105 = "";
    L21:
        Map<String, String> r106 = r110.getExt();     // Catch: Throwable -> L56
        if (r106 == null) goto L24;
        String r107 = r106.get("tts_queue");     // Catch: Throwable -> L56
    L25:
        boolean r113 = Intrinsics.areEqual(r107, "true");     // Catch: Throwable -> L56
        int r108 = c68.b.f22600a;     // Catch: Throwable -> L56
        String r109 = g2a.d.d("try startStream, msg:" + r110);     // Catch: Throwable -> L56
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        c68.b.d("TtsReader", r109);     // Catch: Throwable -> L56
        z2 r114 = z2.f365865a;     // Catch: Throwable -> L56
        if (r114.m3() == true) goto L34;
        if (r102.g() == true) goto L34;
        c68.b.e("TtsReader", "try startStream, audioEnable:" + r114.m3() + " isRecording:" + r102.P().isRecording());     // Catch: Throwable -> L56
    L53:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L34:
        if (t58.b.a(null) == false) goto L53;
        if (m58.h.f512130a != null) goto L40;
        c68.b.b("TtsReader", "[TTS][NULL_CONFIG] skip tts, config is null");     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L40:
        StringBuilder r116 = new StringBuilder("start tts, msgId: ");     // Catch: Throwable -> L56
        r116.append(r112);     // Catch: Throwable -> L56
        r116.append(", text: ");     // Catch: Throwable -> L56
        String r117 = g2a.d.b(r111);     // Catch: Throwable -> L56
        if (r117 == null) goto L43;
        String r118 = StringsKt.take(r117, 10);     // Catch: Throwable -> L56
    L44:
        r116.append(r118);     // Catch: Throwable -> L56
        r116.append("by queue: ");     // Catch: Throwable -> L56
        r116.append(r113);     // Catch: Throwable -> L56
        c68.b.a("TtsReader", r116.toString());     // Catch: Throwable -> L56
        this.f370205c = r112;     // Catch: Throwable -> L56
        this.f370206d = com.larus.im.bean.message.a.D(r110);     // Catch: Throwable -> L56
        this.f370207e = false;     // Catch: Throwable -> L56
        String r119 = m58.x.f512148a;     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter("false", "<set-?>");     // Catch: Throwable -> L56
        m58.x.f512148a = "false";     // Catch: Throwable -> L56
        Map<String, String> r120 = r110.getExt();     // Catch: Throwable -> L56
        if (r120 == null) goto L47;
        String r121 = r120.get("reply_unique_key");     // Catch: Throwable -> L56
    L48:
        Map<String, String> r122 = r110.getExt();     // Catch: Throwable -> L56
        if (r122 == null) goto L51;
        String r123 = r122.get("chat_next");     // Catch: Throwable -> L56
    L52:
        TtsTracer r124 = TtsTracer.Companion.generateTracer();     // Catch: Throwable -> L56
        r124.setStartMethod("auto_play");     // Catch: Throwable -> L56
        FlowTtsTraceHelper.INSTANCE.addTracer(r112, r124);     // Catch: Throwable -> L56
        ChatTTSPlayTrace.f310061b.g(e(this, r105, r104, r112, false, null, false, r121, r210, r113, null, null, r123, 3184), "auto_play", r112, "", "", null);     // Catch: Throwable -> L56
        goto L53
    L51:
        r123 = null;
        goto L52
    L47:
        r121 = null;
        goto L48
    L43:
        r118 = null;
        goto L44
    L24:
        r107 = null;
        goto L25
    L7:
        r101 = r211;
    L56:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final Object j6(Message r110, SpeakerVoice r111, boolean r112, String r113, CoroutineScope r114, String r115, TtsScene r116, Continuation<? super Unit> r210) {
        List<ITtsReaderInterceptor> r100 = i0.f370240a;
        if (r116 != null) goto L5;
        TtsScene r101 = TtsScene.Default;
    L7:
        if (i0.a(r110, r101) == false) goto L9;
        f2a.c r102 = this.f370204b.b("[TTS] try readMessage");
        r102.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
        f2a.f r103 = f2a.f.f475239i;
        String r104 = r110.getMessageId();
        String r105 = "";
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        r102.d(MapsKt.mapOf(TuplesKt.to(r103, r104)));
        f2a.c.c(r102, null, 15);
        if (z2.f365865a.m3() == true) goto L22;
        f2a.c r106 = this.f370204b.b("[TTS][AUDIO_DISABLE]");
        r106.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
        String r107 = r110.getMessageId();
        if (r107 == null) goto L19;
        r105 = r107;
    L19:
        r106.d(MapsKt.mapOf(TuplesKt.to(r103, r105)));
        f2a.c.c(r106, null, 15);
        return Unit.INSTANCE;
    L22:
        if (t58.b.a(null) == true) goto L26;
        return Unit.INSTANCE;
    L26:
        if (m58.h.f512130a != null) goto L29;
        f2a.c r108 = this.f370204b.b("[TTS][NULL_CONFIG] skip tts, config is null");
        r108.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
        f2a.c.c(r108, null, 15);
        return Unit.INSTANCE;
    L29:
        Object r109 = BuildersKt.withContext(zh8.a.a(), new TtsReader$readMessage$2(this, r110, r111, r113, r112, r114, r115, null), r210);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        return r109;
    L33:
        return Unit.INSTANCE;
    L9:
        return Unit.INSTANCE;
    L5:
        r101 = r116;
        goto L7
    }

    @Override // com.larus.bmhome.chat.model.repo.x1
    public final Object m6(Message r110, String r111, String r112, String r113, String r114, boolean r115, JSONObject r210, TtsScene r211, String r212, Continuation<? super Unit> r213) {
        List<ITtsReaderInterceptor> r100 = i0.f370240a;
        if (r211 != null) goto L5;
        TtsScene r101 = TtsScene.Default;
    L7:
        if (i0.a(r110, r101) == false) goto L9;
        int r102 = c68.b.f22600a;
        String r103 = g2a.d.d("[TTS] try readContent, msg:" + r110);
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        c68.b.d("TtsReader", r103);
        if (z2.f365865a.m3() == true) goto L18;
        c68.b.b("TtsReader", "[TTS][AUDIO_NOT_ENABLE] audio not enable");
        return Unit.INSTANCE;
    L18:
        if (t58.b.a(null) == true) goto L22;
        return Unit.INSTANCE;
    L22:
        if (m58.h.f512130a != null) goto L25;
        c68.b.b("TtsReader", "[TTS][NULL_CONFIG] skip tts, config is null");
        return Unit.INSTANCE;
    L25:
        Object r104 = BuildersKt.withContext(zh8.a.a(), new TtsReader$readContent$2(this, r113, r110, r111, r115, r112, r114, r210, r212, null), r213);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r104;
    L29:
        return Unit.INSTANCE;
    L9:
        return Unit.INSTANCE;
    L5:
        r101 = r211;
        goto L7
    }

    public final Object f(String r310, String r311, String r312, boolean r313, p68.i r314, String r315, CacheConfig r316, boolean r410, String r411, String r412, String r413, Continuation<? super String> r414) {
        String r100 = r315;
        if ((r414 instanceof TtsReader$startTtsByText$1) == false) goto L7;
        TtsReader$startTtsByText$1 r101 = (TtsReader$startTtsByText$1) r414;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        int r106 = r101.I$0;
        boolean r107 = r101.Z$1;
        boolean r108 = r101.Z$0;
        String r109 = (String) r101.L$11;
        String r110 = (String) r101.L$10;
        String r111 = (String) r101.L$9;
        CacheConfig r112 = (CacheConfig) r101.L$8;
        String r113 = (String) r101.L$7;
        p68.i r114 = (p68.i) r101.L$6;
        String r115 = (String) r101.L$5;
        String r116 = (String) r101.L$4;
        String r117 = (String) r101.L$3;
        d1 r118 = (d1) r101.L$2;
        String r119 = (String) r101.L$1;
        String r120 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        boolean r210 = r107;
        boolean r211 = r108;
        String r212 = r109;
        String r213 = r110;
        d1 r121 = r118;
        String r122 = r117;
        String r214 = r111;
        CacheConfig r215 = r112;
        String r216 = r113;
        p68.i r217 = r114;
        String r123 = r115;
        String r124 = r116;
        String r125 = r119;
        int r126 = r106;
    L28:
        if (r126 == 0) goto L30;
        boolean r218 = true;
    L31:
        d1.a.a(r121, r122, r124, r123, r211, r217, r216, r215, r210, r218, r214, r213, r212, (Map) r103, 256);
        d68.c.a(r120);
        return r125;
    L30:
        r218 = false;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r127 = r101.I$0;
        boolean r128 = r101.Z$1;
        boolean r129 = r101.Z$0;
        String r130 = (String) r101.L$12;
        String r131 = (String) r101.L$11;
        String r132 = (String) r101.L$10;
        CacheConfig r133 = (CacheConfig) r101.L$9;
        String r134 = (String) r101.L$8;
        p68.i r135 = (p68.i) r101.L$7;
        String r136 = (String) r101.L$6;
        String r137 = (String) r101.L$5;
        String r138 = (String) r101.L$4;
        d1 r139 = (d1) r101.L$3;
        String r140 = (String) r101.L$2;
        String r141 = (String) r101.L$1;
        String r142 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r143 = r103;
        d1 r144 = r139;
        boolean r145 = r128;
        int r317 = r127;
        r100 = r141;
        String r318 = r142;
        String r146 = r138;
        p68.i r147 = r135;
        String r148 = r130;
        String r149 = r131;
        String r150 = r136;
        r125 = r140;
        String r151 = r132;
        CacheConfig r152 = r133;
    L24:
        Map<String, String> r153 = (Map) r143;
        r101.L$0 = r100;
        r101.L$1 = r125;
        r101.L$2 = r144;
        r101.L$3 = r146;
        r101.L$4 = r137;
        r101.L$5 = r150;
        r101.L$6 = r147;
        r101.L$7 = r134;
        r101.L$8 = r152;
        r101.L$9 = r151;
        r101.L$10 = r149;
        r101.L$11 = r148;
        String r154 = r146;
        r101.L$12 = null;
        r101.Z$0 = r129;
        r101.Z$1 = r145;
        int r155 = r317;
        r101.I$0 = r155;
        r101.label = 2;
        String r156 = r100;
        Object r157 = AudioServiceDelegate.f288288a.i0().e(r153, r318, r101);
        if (r157 != r104) goto L27;
        return r104;
    L27:
        r210 = r145;
        r211 = r129;
        r213 = r149;
        r123 = r150;
        r217 = r147;
        r215 = r152;
        r214 = r151;
        r216 = r134;
        r212 = r148;
        r120 = r156;
        r103 = r157;
        r121 = r144;
        r126 = r155;
        r122 = r154;
        r124 = r137;
        goto L28
    L16:
        ResultKt.throwOnFailure(r103);
        HashMap r158 = new HashMap();
        r158.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r310);
        AudioServiceDelegate r159 = AudioServiceDelegate.f288288a;
        r159.s().b();
        r159.s().a();
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService r160 = IFlowTtsClientService.a.a();
        if (r100 != null) goto L19;
        String r161 = "";
    L20:
        r160.e(r161);
        IFlowTtsClientService.a.a().p(TtsStep.STEP_TTS_PRE_SUB_TO_TEXT_SHOW.getTraceName(), null);
        int r162 = c68.b.f22600a;
        c68.b.d("TtsReader", "[TTS] startTtsByText reportStepStart STEP_TTS_TO_AUDIO_PLAY msgId=" + r100 + " text=" + g2a.d.b(r311));
        IFlowTtsClientService.a.a().A(TtsStep.STEP_TTS_TO_AUDIO_PLAY.getTraceName(), null);
        int r163 = wf9.b.f559489a;
        String r164 = com.flow.kmp.common.util.i.a();
        d1 r165 = r159.i0();
        r101.L$0 = r312;
        r101.L$1 = r100;
        r101.L$2 = r164;
        r101.L$3 = r165;
        r101.L$4 = r164;
        r101.L$5 = r312;
        r150 = r311;
        r101.L$6 = r150;
        r147 = r314;
        r101.L$7 = r147;
        r101.L$8 = r100;
        r152 = r316;
        r101.L$9 = r152;
        r151 = r411;
        r101.L$10 = r151;
        r101.L$11 = r412;
        r148 = r413;
        r101.L$12 = r148;
        r101.Z$0 = r313;
        r101.Z$1 = r410;
        r101.I$0 = 0;
        r101.label = 1;
        Object r166 = r159.i0().c(r158, null, r101);
        if (r166 != r104) goto L23;
        return r104;
    L23:
        r318 = r312;
        r143 = r166;
        r146 = r164;
        r144 = r165;
        r149 = r412;
        r129 = r313;
        r317 = 0;
        r145 = r410;
        r134 = r100;
        r125 = r146;
        r137 = r318;
        goto L24
    L19:
        r161 = r100;
    L7:
        r101 = new TtsReader$startTtsByText$1(this, r414);
        goto L8
    }

    public static String e(TtsReader r210, String r211, String r212, String r213, boolean r214, p68.i r215, boolean r216, String r217, CoroutineScope r218, boolean r219, String r310, String r311, String r312, int r313) {
        String r100 = null;
        if ((r313 & 16) == 0) goto L5;
        p68.i r101 = null;
    L6:
        boolean r102 = false;
        if ((r313 & 32) == 0) goto L9;
        boolean r110 = false;
    L11:
        if ((r313 & 64) == 0) goto L13;
        int r103 = wf9.b.f559489a;
        String r111 = com.flow.kmp.common.util.i.a();
    L15:
        if ((r313 & 128) == 0) goto L17;
        String r112 = null;
    L19:
        if ((r313 & 256) == 0) goto L21;
        CoroutineScope r104 = null;
    L23:
        if ((r313 & 512) != 0) goto L27;
        r102 = r219;
    L27:
        if ((r313 & 1024) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r313 & 2048) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r313 & 4096) != 0) goto L38;
        r100 = r312;
    L38:
        r210.getClass();
        if (r102 == false) goto L44;
        if (r104 != null) goto L42;
        r104 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    L42:
        CoroutineScope r105 = r104;
        BuildersKt.launch$default(r105, null, null, new TtsReader$startTtsByMsgIdByQueue$1(r210, r111, r211, r212, r213, r214, r101, r110, r112, r100, r105, null), 3, null);
        return r111;
    L44:
        return c(r210, r211, r212, r213, r214, r101, r110, r111, r112, null, null, r113, r114, r100, ISmModel.VERSION_0300);
    L33:
        r114 = r311;
        goto L35
    L29:
        r113 = r310;
        goto L31
    L21:
        r104 = r218;
        goto L23
    L17:
        r112 = r217;
        goto L19
    L13:
        r111 = null;
        goto L15
    L9:
        r110 = r216;
        goto L11
    L5:
        r101 = r215;
        goto L6
    }

    public static String c(TtsReader r210, String r211, String r212, String r213, boolean r214, p68.i r215, boolean r216, String r217, String r218, f0 r310, g0 r311, String r312, String r313, String r314, int r315) {
        if ((r315 & 16) == 0) goto L5;
        p68.i r100 = null;
    L7:
        if ((r315 & 32) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r315 & 64) == 0) goto L13;
        int r102 = wf9.b.f559489a;
        String r110 = com.flow.kmp.common.util.i.a();
    L15:
        if ((r315 & 128) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r315 & 256) == 0) goto L21;
        Function0 r111 = new c0();
    L23:
        if ((r315 & 512) == 0) goto L25;
        Function1 r112 = new d0();
    L27:
        if ((r315 & 1024) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r315 & 2048) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r315 & 4096) == 0) goto L37;
        String r104 = null;
    L38:
        r210.getClass();
        AudioServiceDelegate r105 = AudioServiceDelegate.f288288a;
        r105.s().b();
        r105.s().a();
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().p(TtsStep.STEP_TTS_PRE_SUB_TO_TEXT_SHOW.getTraceName(), null);
        int r106 = c68.b.f22600a;
        c68.b.d("TtsReader", "[TTS] startTtsByMsgId reportStepStart STEP_TTS_TO_AUDIO_PLAY msgId=" + r213);
        IFlowTtsClientService.a.a().e(r213);
        IFlowTtsClientService.a.a().A(TtsStep.STEP_TTS_TO_AUDIO_PLAY.getTraceName(), null);
        d68.c.a(r213);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new TtsReader$startTtsByMsgId$3(r211, r103, r104, r213, r110, r212, r214, r100, r101, r111, r112, r113, r114, r210, null), 3, null);
        return r110;
    L37:
        r104 = r314;
        goto L38
    L33:
        r114 = r313;
        goto L35
    L29:
        r113 = r312;
        goto L31
    L25:
        r112 = r311;
        goto L27
    L21:
        r111 = r310;
        goto L23
    L17:
        r103 = r218;
        goto L19
    L13:
        r110 = r217;
        goto L15
    L9:
        r101 = r216;
        goto L11
    L5:
        r100 = r215;
        goto L7
    }

    public final Object h(Message r210, String r211, boolean r212, boolean r213, boolean r214, p68.i r215, String r216, CacheConfig r217, boolean r310, CoroutineScope r311, String r312, String r313, JSONObject r314, String r315, Continuation<? super Boolean> r316) {
        if ((r316 instanceof TtsReader$suspendStartStream$1) == false) goto L7;
        TtsReader$suspendStartStream$1 r100 = (TtsReader$suspendStartStream$1) r316;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        String r105 = (String) r100.L$4;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$3;
        JSONObject r107 = (JSONObject) r100.L$2;
        String r108 = (String) r100.L$1;
        p68.i r109 = (p68.i) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L15
    L121:
        String r110 = (String) r102;     // Catch: Throwable -> L94
        p68.i r111 = r109;
    L109:
        ChatTTSPlayTrace r112 = ChatTTSPlayTrace.f310061b;     // Catch: Throwable -> L15
        if (r111 == null) goto L112;
        String r113 = r111.f527935c;     // Catch: Throwable -> L15
    L113:
        if (r111 == null) goto L115;
        String r114 = r111.f527933a;     // Catch: Throwable -> L15
    L116:
        r112.g(r110, r108, r105, r113, r114, r107);     // Catch: Throwable -> L15
        Boolean r115 = Boxing.boxBoolean(false);     // Catch: Throwable -> L15
        r106.unlock(null);
        return r115;
    L115:
        r114 = null;
        goto L116
    L112:
        r113 = null;
    L94:
        th = th;
    L95:
        kotlinx.coroutines.sync.a r116 = r106;
    L119:
        r116.unlock(null);
        throw th;
    L15:
        th = th;
        goto L95
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r117 = r100.Z$3;
        boolean r118 = r100.Z$2;
        boolean r119 = r100.Z$1;
        boolean r120 = r100.Z$0;
        r116 = (kotlinx.coroutines.sync.a) r100.L$10;
        String r121 = (String) r100.L$9;
        JSONObject r122 = (JSONObject) r100.L$8;
        String r123 = (String) r100.L$7;
        String r124 = (String) r100.L$6;
        CoroutineScope r125 = (CoroutineScope) r100.L$5;
        CacheConfig r126 = (CacheConfig) r100.L$4;
        r108 = (String) r100.L$3;
        p68.i r127 = (p68.i) r100.L$2;
        String r128 = (String) r100.L$1;
        Message r129 = (Message) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r130 = r128;
        CoroutineScope r317 = r125;
        String r131 = r121;
        boolean r132 = r117;
        String r133 = r124;
        r111 = r127;
    L127:
        AudioServiceDelegate r134 = AudioServiceDelegate.f288288a;     // Catch: Throwable -> L100
        r134.i0().h(r129);     // Catch: Throwable -> L100
        r105 = r129.getMessageId();     // Catch: Throwable -> L100
        if (r105 != null) goto L28;
        r105 = "";
    L28:
        if (r131 != null) goto L32;
        r131 = r129.getConversationId();     // Catch: Throwable -> L100
        if (r131 != null) goto L32;
        r131 = "";
    L32:
        String r218 = r129.getReplyId();     // Catch: Throwable -> L100
        String r318 = r123;
        if (r218 != null) goto L35;
        r218 = "";
    L35:
        String r135 = g2a.d.b(r130);     // Catch: Throwable -> L100
        String r319 = r133;
        Map<String, String> r136 = r129.getExt();     // Catch: Throwable -> L100
        CacheConfig r219 = r126;
        if (r136 == null) goto L38;
        String r137 = r136.get("tts_queue");     // Catch: Throwable -> L100
    L39:
        boolean r138 = Intrinsics.areEqual(r137, "true");     // Catch: Throwable -> L100
        boolean r220 = r119;
        if (r134.i0().g() == false) goto L51;
        f2a.c r139 = this.f370204b.b("[TTS][ASR_RECORDING]");     // Catch: Throwable -> L100
        r139.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L100
        Pair[] r140 = new Pair[2];     // Catch: Throwable -> L100
        r140[0] = TuplesKt.to(f2a.f.f475239i, r105);     // Catch: Throwable -> L100
        f2a.f r141 = f2a.f.f475241k;     // Catch: Throwable -> L100
        if (r135 == null) goto L45;
        String r142 = StringsKt.take(r135, 10);     // Catch: Throwable -> L100
    L46:
        if (r142 != null) goto L48;
        r142 = "";
    L48:
        r140[1] = TuplesKt.to(r141, r142);     // Catch: Throwable -> L100
        r139.d(MapsKt.mapOf(r140));     // Catch: Throwable -> L100
        f2a.c.c(r139, null, 15);     // Catch: Throwable -> L100
        Boolean r143 = Boxing.boxBoolean(true);     // Catch: Throwable -> L100
        r116.unlock(null);
        return r143;
    L45:
        r142 = null;
        goto L46
    L51:
        f2a.c r144 = this.f370204b.b("[TTS] suspend start stream by TtsReader");     // Catch: Throwable -> L100
        String r221 = r130;
        r144.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L100
        Pair[] r145 = new Pair[6];     // Catch: Throwable -> L100
        r145[0] = TuplesKt.to(f2a.f.f475239i, r105);     // Catch: Throwable -> L100
        f2a.f r146 = f2a.f.f475241k;     // Catch: Throwable -> L100
        if (r135 == null) goto L57;
        kotlinx.coroutines.sync.a r147 = r116;
        String r148 = StringsKt.take(r135, 10);     // Catch: Throwable -> L55
    L58:
        if (r148 != null) goto L60;
        r148 = "";
    L60:
        Pair r149 = TuplesKt.to(r146, r148);     // Catch: Throwable -> L55
        boolean r150 = true;
        r145[1] = r149;     // Catch: Throwable -> L55
        f2a.f r151 = new f2a.f("by_queue");     // Catch: Throwable -> L55
        if (r138 == false) goto L63;
        boolean r152 = true;
    L64:
        r145[2] = TuplesKt.to(r151, String.valueOf(r152));     // Catch: Throwable -> L55
        f2a.f r153 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L55
        if (r108 != null) goto L67;
        String r154 = "";
    L68:
        r145[3] = TuplesKt.to(r153, r154);     // Catch: Throwable -> L55
        f2a.f r155 = new f2a.f("is_from_manual");     // Catch: Throwable -> L55
        if (r132 == false) goto L71;
        boolean r156 = true;
    L72:
        r145[4] = TuplesKt.to(r155, String.valueOf(r156));     // Catch: Throwable -> L55
        f2a.f r157 = new f2a.f("start_tts_with_text");     // Catch: Throwable -> L55
        if (r118 == false) goto L75;
        boolean r158 = true;
    L76:
        r145[5] = TuplesKt.to(r157, String.valueOf(r158));     // Catch: Throwable -> L55
        r144.d(MapsKt.mapOf(r145));     // Catch: Throwable -> L55
        f2a.c.c(r144, null, 15);     // Catch: Throwable -> L55
        this.f370205c = r105;     // Catch: Throwable -> L55
        this.f370206d = com.larus.im.bean.message.a.D(r129);     // Catch: Throwable -> L55
        if (r120 == true) goto L80;
        r150 = false;
    L80:
        this.f370207e = r150;     // Catch: Throwable -> L55
        TtsTracer r159 = TtsTracer.Companion.generateTracer();     // Catch: Throwable -> L55
        r159.setStartMethod(r108);     // Catch: Throwable -> L55
        FlowTtsTraceHelper r160 = FlowTtsTraceHelper.INSTANCE;     // Catch: Throwable -> L55
        String r161 = r129.getMessageId();     // Catch: Throwable -> L55
        if (r161 != null) goto L83;
        r161 = "";
    L83:
        r160.addTracer(r161, r159);     // Catch: Throwable -> L55
        if (r118 == false) goto L96;
        r100.L$0 = r111;     // Catch: Throwable -> L55
        r100.L$1 = r108;     // Catch: Throwable -> L55
        r100.L$2 = r122;     // Catch: Throwable -> L55
        kotlinx.coroutines.sync.a r162 = r147;
        r100.L$3 = r162;     // Catch: Throwable -> L100
        r100.L$4 = r105;     // Catch: Throwable -> L100
        r100.L$5 = null;     // Catch: Throwable -> L100
        r100.L$6 = null;     // Catch: Throwable -> L100
        r100.L$7 = null;     // Catch: Throwable -> L100
        r100.L$8 = null;     // Catch: Throwable -> L100
        r100.L$9 = null;     // Catch: Throwable -> L100
        r100.L$10 = null;     // Catch: Throwable -> L100
        r100.label = 2;     // Catch: Throwable -> L100
        r102 = f(r218, r221, r131, r220, r111, r105, r219, r132, r319, r318, r108, r100);     // Catch: Throwable -> L100
        if (r102 != r103) goto L91;
        return r103;
    L91:
        r109 = r111;
        r106 = r162;
        r107 = r122;
        goto L121
    L96:
        kotlinx.coroutines.sync.a r163 = r147;
        Map<String, String> r164 = r129.getExt();     // Catch: Throwable -> L100
        if (r164 == null) goto L102;
        String r165 = r164.get("reply_unique_key");     // Catch: Throwable -> L100
    L103:
        Map<String, String> r166 = r129.getExt();     // Catch: Throwable -> L100
        if (r166 == null) goto L106;
        String r167 = r166.get("chat_next");     // Catch: Throwable -> L100
    L107:
        r110 = e(this, r218, r131, r105, r220, r111, r132, r165, r317, r138, r108, r318, r167, 64);     // Catch: Throwable -> L100
        r106 = r163;
        r107 = r122;
        goto L109
    L106:
        r167 = null;
        goto L107
    L102:
        r165 = null;
        goto L103
    L75:
        r158 = false;
        goto L76
    L71:
        r156 = false;
        goto L72
    L67:
        r154 = r108;
        goto L68
    L63:
        r152 = false;
    L55:
        th = th;
        r116 = r147;
        goto L119
    L57:
        r147 = r116;
        r148 = null;
        goto L58
    L38:
        r137 = null;
    L100:
        th = th;
        goto L119
    L20:
        ResultKt.throwOnFailure(r102);
        MutexImpl r168 = this.f370210h;
        r100.L$0 = r210;
        r100.L$1 = r211;
        r111 = r215;
        r100.L$2 = r111;
        r108 = r216;
        r100.L$3 = r108;
        r126 = r217;
        r100.L$4 = r126;
        r100.L$5 = r311;
        r100.L$6 = r312;
        r100.L$7 = r313;
        r100.L$8 = r314;
        r100.L$9 = r315;
        r100.L$10 = r168;
        r100.Z$0 = r212;
        r100.Z$1 = r213;
        r100.Z$2 = r214;
        r100.Z$3 = r310;
        r100.label = 1;
        if (r168.a(null, r100) != r103) goto L23;
        return r103;
    L23:
        r129 = r210;
        r132 = r310;
        r317 = r311;
        r131 = r315;
        r118 = r214;
        r133 = r312;
        r119 = r213;
        r123 = r313;
        r120 = r212;
        r122 = r314;
        r116 = r168;
        r130 = r211;
    L7:
        r100 = new TtsReader$suspendStartStream$1(this, r316);
        goto L8
    }

    public static /* synthetic */ Object i(TtsReader r110, Message r210, String r211, boolean r212, boolean r213, p68.i r214, String r215, CacheConfig r216, boolean r217, CoroutineScope r218, String r219, String r310, JSONObject r311, String r312, Continuation r313, int r314) {
        if ((r314 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r314 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r314 & 32) == 0) goto L13;
        p68.i r102 = null;
    L15:
        if ((r314 & 64) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r314 & 128) == 0) goto L21;
        CacheConfig r112 = null;
    L23:
        if ((r314 & 256) == 0) goto L25;
        boolean r113 = false;
    L27:
        if ((r314 & 512) == 0) goto L29;
        CoroutineScope r114 = null;
    L31:
        if ((r314 & 1024) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r314 & 2048) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r314 & 4096) == 0) goto L41;
        JSONObject r117 = null;
    L43:
        if ((r314 & 8192) == 0) goto L45;
        String r118 = null;
    L47:
        return r110.h(r210, r211, r212, r100, r101, r102, r111, r112, r113, r114, r115, r116, r117, r118, r313);
    L45:
        r118 = r312;
        goto L47
    L41:
        r117 = r311;
        goto L43
    L37:
        r116 = r310;
        goto L39
    L33:
        r115 = r219;
        goto L35
    L29:
        r114 = r218;
        goto L31
    L25:
        r113 = r217;
        goto L27
    L21:
        r112 = r216;
        goto L23
    L17:
        r111 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = true;
        goto L7
    }
}
