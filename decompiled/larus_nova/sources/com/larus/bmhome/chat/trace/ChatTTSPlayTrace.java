package com.larus.bmhome.chat.trace;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010)\u001a\u00020*2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\tH\u0016J.\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J*\u00101\u001a\u00020*2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u00102\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u0018\u00103\u001a\u00020*2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016J\u0018\u00104\u001a\u00020*2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000bH\u0016JB\u00106\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u0010;\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u001bH\u0002J\u0018\u0010@\u001a\u0004\u0018\u00010\r2\u0006\u0010<\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010AJ\u0018\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010AJ\b\u0010E\u001a\u00020\u001fH\u0002J \u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010JJ\u0012\u0010K\u001a\u00020*2\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010M\u001a\u00020*H\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0002J\u0010\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020\rH\u0002J\u0018\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/bmhome/chat/trace/ChatTTSPlayTrace;", "Lcom/larus/platform/spi/IAIChatTtsPlayTraceService;", "<init>", "()V", "TAG", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "chatMessageAdapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "socialMessageGetter", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "currentTaskId", "currentPlayMessageID", "value", "endMethod", "setEndMethod", "(Ljava/lang/String;)V", "startMethod", "setStartMethod", "startPlayTime", "", "endPlayTime", "chatTypeGetter", "extraCommonParams", "Lorg/json/JSONObject;", "voiceID", "toTtsSpeakerId", "haveStartPlay", "", "currentPlayChatMessage", "setCurrentPlayChatMessage", "(Lcom/larus/im/bean/message/Message;)V", "currentPlaySocialMessage", "intentionDialectSet", "", "ttsDialectSet", "trackChatMessageInvoker", "traceSocialMessageInvoker", "bindPageMessageListSource", "", "adapter", "onSentenceStart", DBDefinition.TASK_ID, "sentenceTxt", "sentenceInst", "sentenceRes", "bindSocialMessageListSource", "getter", "setChatTypeFetcher", "setExtraCommonParams", "commonParamsGetter", "startTTS", "startTTSReason", com.heytap.mcssdk.constant.b.f276353c, "ttsSpeaker", "traceInfo", "mobTTSStart", RemoteMessageConst.MSGID, "mobFailedReportTtsStart", "reason", GXTemplateKey.GAIAX_JS, "findMessage", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConv", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "needSendFinishTTS", "findBot", "Lcom/larus/im/bean/bot/BotModel;", "botId", "forceNew", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTTS", "stopTTSReason", "findChatMessage", "findSocialMessage", "trackFinishTTS", "trackSocialTTS", "message", "trackChatTTS", "chatMessage", "playTotalDuration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTTSPlayTrace implements IAIChatTtsPlayTraceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ChatTTSPlayTrace f310061b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static by7.e f310062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static wq8.b f310063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f310064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f310065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f310066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f310067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f310068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Function0<String> f310069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f310070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Message f310071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set<String> f310072m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set<String> f310073n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a0 f310074o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b0 f310075p = null;

    public static final class a implements n68.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f310076a = null;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.trace.ChatTTSPlayTrace$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4077a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f310077a = null;

            static {
                int[] r100 = new int[PlayStateEnum.values().length];
                r100[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f310077a = r100;
            }
        }

        static {
            f310076a = new a();
        }

        public a() {
        }

        @Override // n68.a
        public final void d(PlayStateEnum r100) {
        }

        @Override // n68.a
        public final void e(TtsErrorType r100) {
        }

        @Override // n68.a
        public final void c(PlayStateEnum r100) {
            FLogger.f375446a.i("ChatTTSPlayTrace", "play tts callback:" + r100);
            if (r100 != null) goto L5;
            int r101 = -1;
        L7:
            if (r101 != 1) goto L9;
            ChatTTSPlayTrace.f310070k = false;
            ChatTTSPlayTrace r102 = ChatTTSPlayTrace.f310061b;
            if (ChatTTSPlayTrace.f310071l == null) goto L15;
            r102.getClass();
            Message r103 = (Message) ChatTTSPlayTrace.f310074o.invoke();
        L16:
            ChatTTSPlayTrace.f310075p.getClass();
            return;
        L15:
            r102.getClass();
            ChatTTSPlayTrace.f();
            Message r104 = (Message) ChatTTSPlayTrace.f310074o.invoke();
            goto L16
        L9:
            if (r101 != 2) goto L19;
            ChatTTSPlayTrace.f310061b.getClass();
            AudioServiceDelegate.f288288a.O().b("auto_end");
            ChatTTSPlayTrace.f310066g = "auto_end";
            return;
        L19:
            return;
        L5:
            r101 = C4077a.f310077a[r100.ordinal()];
            goto L7
        }

        @Override // n68.a
        public final void a(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        }

        @Override // n68.a
        public final void b(boolean r100, String r101, String r102, long r103) {
            Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        }
    }

    private ChatTTSPlayTrace() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.chat.trace.b0] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.bmhome.chat.trace.c0] */
    static {
        f310061b = new ChatTTSPlayTrace();
        f310066g = "";
        f310067h = "";
        f310068i = -1;
        f310070k = true;
        f310072m = new LinkedHashSet();
        f310073n = new LinkedHashSet();
        f310074o = new a0();
        f310075p = new b0();
        a r100 = a.f310076a;
        AudioServiceDelegate.f288288a.r0().m(r100);
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().z(new c0());
    }

    public static void f() {
        wq8.b r100 = f310063d;     // Catch: Exception -> L13
        if (r100 == null) goto L23;
        List<Message> r101 = r100.getCurrentList();     // Catch: Exception -> L13
        if (r101 == null) goto L24;
        Iterator<T> r102 = r101.iterator();     // Catch: Exception -> L13
    L8:
        if (r102.hasNext() == false) goto L25;
        Message r103 = (Message) r102.next();     // Catch: Exception -> L13
        if (Intrinsics.areEqual(r103.getMessageId(), f310065f) == false) goto L8;
        f310061b.getClass();     // Catch: Exception -> L13
        AudioServiceDelegate.f288288a.O().h(r103);     // Catch: Exception -> L13
        f310071l = r103;     // Catch: Exception -> L13
        goto L8
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        e = move-exception;
        AudioServiceDelegate.f288288a.O().h(null);
        f310071l = null;
        FLogger.f375446a.d("ChatTTSPlayTrace", "findchatMessage crash---" + e);
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void a(String r100) {
        FLogger.f375446a.i("ChatTTSPlayTrace", "[TTS][INTERRUPTED] " + r100);
        if (f310070k == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        AudioServiceDelegate.f288288a.O().b(r100);
        f310066g = r100;
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void b(com.larus.bmhome.chat.component.list.h0 r100) {
        f310069j = r100;
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void c(by7.e r100, wq8.b r101) {
        f310063d = r101;
        f310062c = r100;
    }

    public static final void e(ChatTTSPlayTrace r100, String r101, JSONObject r102) {
        r100.getClass();
        com.larus.platform.service.o r103 = com.larus.platform.service.o.f365780a;
        r102.put("fail_reason", r101);
        Unit r104 = Unit.INSTANCE;
        r103.reportEvent("start_tts_report_failed", r102);
    }

    @Override // com.larus.platform.spi.IAIChatTtsPlayTraceService
    public final void d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        int r104 = c68.b.f22600a;
        c68.b.d("ChatTTSPlayTrace", "TraceOnSentenceStart: taskId:" + r100 + ", currentTaskId:" + f310064e + ", sentenceTxt:" + r101 + ", sentenceInst:" + r102 + ", sentenceRes:" + r103);
        if (Intrinsics.areEqual(f310064e, r100) == true) goto L5;
        return;
    L5:
        if (r102 == null) goto L7;
        f310072m.add(r102);
    L7:
        if (r103 == null) goto L10;
        f310073n.add(r103);
        return;
    }

    public final void g(String r100, String r101, String r102, String r110, String r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        f310064e = r100;
        f310065f = r102;
        f310068i = System.currentTimeMillis();
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        AudioServiceDelegate r113 = AudioServiceDelegate.f288288a;
        r113.O().f(r103);
        f310067h = r103;
        f310070k = true;
        r113.O().h(null);
        f310071l = null;
        f310072m.clear();
        f310073n.clear();
        f();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatTTSPlayTrace$mobTTSStart$1(r102, r112, null), 2, null);
        FLogger.f375446a.i("ChatTTSPlayTrace", "startTTS: startReason：" + r101 + "---messageID:" + r102);
        return;
    L5:
        r103 = r101;
        goto L6
    }
}
