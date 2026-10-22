package com.bytedance.flow_audio.api.tracer;

import android.os.SystemClock;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.service.common.IKMPTrackerService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ouc.a;
import ouc.i;
import ouc.k;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0001AB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010$\u001a\u00020%2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010'2\b\u0010#\u001a\u0004\u0018\u00010\u000fJB\u0010(\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010)\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\bJ\u0016\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203J&\u00104\u001a\u00020%2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"2\u0006\u00105\u001a\u00020\u000fH\u0002J\u0016\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0002J\u000e\u00108\u001a\u00020%2\u0006\u00109\u001a\u000203J-\u0010:\u001a\u00020%2%\u0010;\u001a!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\"\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=J*\u0010>\u001a\u00020%*\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"2\u0006\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/flow_audio/api/tracer/TtsTracer;", "", "<init>", "()V", "initTracerTimeStamp", "", "initTaskTimestamp", "isStartByTxt", "", "callSamiTimestamp", "receiveFirstPkgTimestamp", "startPlayTimestamp", "startPlayFirstFrameTimestamp", "errCode", "errMsg", "", "isTmpTracer", "()Z", "setTmpTracer", "(Z)V", DBDefinition.TASK_ID, "convId", RemoteMessageConst.MSGID, "botId", "speakerId", "ttsStreamType", "Lcom/bytedance/flow_audio/api/business/tts/config/FlowAudioTtsStreamType;", "startMethod", "getStartMethod", "()Ljava/lang/String;", "setStartMethod", "(Ljava/lang/String;)V", "isFinished", "extraPayload", "", "extra", "appendExtra", "", "map", "", "appendData", "initTask", "startCallSami", "receiveFirstPkg", "startPlay", "playFirstFrame", "isSuccess", "onPlayErr", "isClientErr", "playEnd", "endMethod", "", "appendTtsErrorMsgToMap", "rawErrMsg", "createBaseParamMap", "playedSizeInBytes", "playData", "sizeInBytes", "updateParams", "function", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "putNotNullValue", "key", "value", "Companion", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsTracer {
    public static final Companion Companion = null;
    public static final String RECEIVE_AUDIO_SIZE = "receive_audio_size";
    public static final String TTS_CONTENT_LENGTH = "content_length";
    private String botId;
    private long callSamiTimestamp;
    private String convId;
    private long errCode;
    private String errMsg;
    private String extra;
    private final Map<String, String> extraPayload;
    private long initTaskTimestamp;
    private long initTracerTimeStamp;
    private boolean isFinished;
    private boolean isStartByTxt;
    private boolean isTmpTracer;
    private String msgId;
    private int playedSizeInBytes;
    private long receiveFirstPkgTimestamp;
    private String speakerId;
    private String startMethod;
    private long startPlayFirstFrameTimestamp;
    private long startPlayTimestamp;
    private String taskId;
    private FlowAudioTtsStreamType ttsStreamType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/flow_audio/api/tracer/TtsTracer$Companion;", "", "<init>", "()V", "generateTracer", "Lcom/bytedance/flow_audio/api/tracer/TtsTracer;", "RECEIVE_AUDIO_SIZE", "", "TTS_CONTENT_LENGTH", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TtsTracer generateTracer() {
            return new TtsTracer(null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TtsTracer(DefaultConstructorMarker r100) {
        this();
    }

    private final Map<String, Object> createBaseParamMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        putNotNullValue(r100, MusicAppletPage.KEY_MESSAGE_ID, this.msgId);     // Catch: Throwable -> L13
        putNotNullValue(r100, "task_id", this.taskId);     // Catch: Throwable -> L13
        putNotNullValue(r100, "bot_id", this.botId);     // Catch: Throwable -> L13
        putNotNullValue(r100, "conversation_id", this.convId);     // Catch: Throwable -> L13
        putNotNullValue(r100, "speaker_id", this.speakerId);     // Catch: Throwable -> L13
        FlowAudioTtsStreamType r102 = this.ttsStreamType;     // Catch: Throwable -> L13
        if (r102 == null) goto L6;
        String r103 = r102.toString();     // Catch: Throwable -> L13
    L7:
        putNotNullValue(r100, "tts_stream_type", r103);     // Catch: Throwable -> L13
        putNotNullValue(r100, AiProactiveTaskViewModel.PARAM_START_METHOD, this.startMethod);     // Catch: Throwable -> L13
        Iterator r104 = MapsKt.toList(this.extraPayload).iterator();     // Catch: Throwable -> L13
    L9:
        if (r104.hasNext() == false) goto L11;
        Pair r105 = (Pair) r104.next();     // Catch: Throwable -> L13
        r100.put((String) r105.component1(), (String) r105.component2());     // Catch: Throwable -> L13
        goto L9
    L11:
        r100.put("extra", this.extra);     // Catch: Throwable -> L13
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        b r108 = c.f528682a;
        IKMPTrackerService r109 = (IKMPTrackerService) c.a(Reflection.getOrCreateKotlinClass(IKMPTrackerService.class));
        if (r109 == null) goto L20;
        r109.ensureNotReachHere(r107, "kmp_tts_trace createBaseParamMap");
    L20:
        return r100;
    L6:
        r103 = null;
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void receiveFirstPkg() {
        if (this.receiveFirstPkgTimestamp != 0) goto L6;
        this.receiveFirstPkgTimestamp = SystemClock.elapsedRealtime();
        return;
    }

    public final void startCallSami() {
        if (this.callSamiTimestamp != 0) goto L6;
        this.callSamiTimestamp = SystemClock.elapsedRealtime();
        return;
    }

    public final void startPlay() {
        if (this.startPlayTimestamp != 0) goto L6;
        this.startPlayTimestamp = SystemClock.elapsedRealtime();
        return;
    }

    private TtsTracer() {
        this.initTracerTimeStamp = SystemClock.elapsedRealtime();
        this.errMsg = "";
        this.taskId = "";
        this.startMethod = "";
        this.extraPayload = new LinkedHashMap();
        this.extra = "";
    }

    public final String getStartMethod() {
        return this.startMethod;
    }

    public final boolean isTmpTracer() {
        return this.isTmpTracer;
    }

    public final void initTask(boolean r100) {
        if (this.isFinished == false) goto L6;
        return;
    L6:
        if (this.initTaskTimestamp != 0) goto L8;
        this.initTaskTimestamp = SystemClock.elapsedRealtime();
        this.isStartByTxt = r100;
    L8:
        b r101 = c.f528682a;
        IKMPTrackerService r102 = (IKMPTrackerService) c.a(Reflection.getOrCreateKotlinClass(IKMPTrackerService.class));
        if (r102 == null) goto L11;
        r102.event("flow_im_start_tts_task", MapsKt.plus(MapsKt.mapOf(TuplesKt.to("is_temp_tracer", Boolean.valueOf(this.isTmpTracer))), createBaseParamMap()));
    L11:
        if (r102 == null) goto L14;
        r102.W0();
        return;
    }

    public final void playData(int r100) {
        this.playedSizeInBytes += r100;
    }

    public final void playEnd(int r100) {
        if (this.isFinished == false) goto L5;
        return;
    L5:
        b r101 = c.f528682a;
        IKMPTrackerService r102 = (IKMPTrackerService) c.a(Reflection.getOrCreateKotlinClass(IKMPTrackerService.class));
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L9;
        String r103 = "error";
    L11:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(createBaseParamMap());
        r104.put("init_duration", Long.valueOf(this.initTaskTimestamp - this.initTracerTimeStamp));
        r104.put("start_to_receive_first_tts_pkg_duration", Long.valueOf(this.receiveFirstPkgTimestamp - this.initTaskTimestamp));
        r104.put("receive_first_tts_pkg_to_start_play_duration", Long.valueOf(this.startPlayFirstFrameTimestamp - this.receiveFirstPkgTimestamp));
        if (this.isStartByTxt == false) goto L14;
        String r105 = "text";
    L15:
        r104.put("play_type", r105);
        r104.put("start_play_total_duration", Long.valueOf(this.startPlayFirstFrameTimestamp - this.initTaskTimestamp));
        if (this.startPlayFirstFrameTimestamp <= 0) goto L18;
        boolean r106 = true;
    L19:
        r104.put("is_start_play_success", Boolean.valueOf(r106));
        r104.put("end_method", r103);
        r104.put("error_code", Long.valueOf(this.errCode));
        appendTtsErrorMsgToMap(r104, this.errMsg);
        r104.put("is_temp_tracer", Boolean.valueOf(this.isTmpTracer));
        r104.put("play_audio_size", Integer.valueOf(this.playedSizeInBytes));
        if (r102 == null) goto L22;
        r102.event("flow_im_tts_play_end", r104);
    L22:
        this.isFinished = true;
        return;
    L18:
        r106 = false;
        goto L19
    L14:
        r105 = MusicAppletPage.KEY_MESSAGE_ID;
        goto L15
    L9:
        r103 = MessageIndication.STATUS_INTERRUPT;
        goto L11
    L10:
        r103 = BitableAnalytic.SelectSceneClickType.COMPLETE;
        goto L11
    }

    public final void playFirstFrame(boolean r100) {
        this.startPlayFirstFrameTimestamp = SystemClock.elapsedRealtime();
    }

    public final void setStartMethod(String r100) {
        this.startMethod = r100;
    }

    public final void setTmpTracer(boolean r100) {
        this.isTmpTracer = r100;
    }

    public final void updateParams(Function1<? super Map<String, String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        r100.invoke(this.extraPayload);
    }

    private final void appendTtsErrorMsgToMap(Map<String, Object> r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        String r103 = StringsKt.removePrefix(r101, "TTS_NETWORK_FAILED append_msg state=2 textMsg=");     // Catch: Throwable -> L18
        i r104 = (i) k.n(a.f526798d.e(r103)).get("message");     // Catch: Throwable -> L18
        if (r104 == null) goto L6;
        String r105 = k.g(k.o(r104));     // Catch: Throwable -> L18
    L7:
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L15;
        r100.put("error_msg", r105);     // Catch: Throwable -> L18
    L16:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L27;
        r100.put("error_msg", r101);
        return;
    L27:
        return;
    L15:
        r100.put("error_msg", r101);     // Catch: Throwable -> L18
        goto L16
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r106 = false;
        goto L13
    L6:
        r105 = null;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public final void appendExtra(Map<String, String> r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        if (r100 == null) goto L10;
        List r103 = MapsKt.toList(r100);     // Catch: Throwable -> L14
        if (r103 == null) goto L10;
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L14
    L8:
        if (r104.hasNext() == false) goto L10;
        Pair r105 = (Pair) r104.next();     // Catch: Throwable -> L14
        String r106 = (String) r105.component1();     // Catch: Throwable -> L14
        String r107 = (String) r105.component2();     // Catch: Throwable -> L14
        this.extraPayload.put(r106, r107);     // Catch: Throwable -> L14
    L10:
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        this.extra = r101;     // Catch: Throwable -> L14
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L25;
        b r110 = c.f528682a;
        IKMPTrackerService r111 = (IKMPTrackerService) c.a(Reflection.getOrCreateKotlinClass(IKMPTrackerService.class));
        if (r111 == null) goto L26;
        r111.ensureNotReachHere(r109, "kmp_tts_trace appendExtra");
        return;
    L26:
        return;
    L25:
        return;
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void onPlayErr(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        this.errCode = r102;
        this.errMsg = r101;
        playEnd(2);
        return;
    L5:
        r102 = 2;
        goto L6
    }

    public final void putNotNullValue(Map<String, Object> r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 == null) goto L6;
        r100.put(r101, r102);
        return;
    }

    public final void appendData(String r100, String r101, String r102, String r103, String r104, FlowAudioTtsStreamType r105) {
        this.taskId = r100;
        this.convId = r101;
        this.msgId = r102;
        this.botId = r103;
        this.speakerId = r104;
        this.ttsStreamType = r105;
    }
}
