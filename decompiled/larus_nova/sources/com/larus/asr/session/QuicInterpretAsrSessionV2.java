package com.larus.asr.session;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.keva.Keva;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.asr.session.component.AsrSessionComponentUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class QuicInterpretAsrSessionV2 extends ComponentAsrSession {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f287486n = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<xa8.d> f287487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile QuicInterpretTransportRoute f287488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f287489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s1 f287490m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/session/QuicInterpretAsrSessionV2$QuicInterpretTransportRoute;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LEGACY", "FLOW_ASR_CLIENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum QuicInterpretTransportRoute extends Enum<QuicInterpretTransportRoute> {
        public static final QuicInterpretTransportRoute FLOW_ASR_CLIENT = null;
        public static final QuicInterpretTransportRoute LEGACY = null;
        public static final QuicInterpretTransportRoute NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ QuicInterpretTransportRoute[] f287491a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f287492b = null;

        public static EnumEntries<QuicInterpretTransportRoute> getEntries() {
            return f287492b;
        }

        static {
            QuicInterpretTransportRoute r100 = new QuicInterpretTransportRoute(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            QuicInterpretTransportRoute r101 = new QuicInterpretTransportRoute("LEGACY", 1);
            LEGACY = r101;
            QuicInterpretTransportRoute r102 = new QuicInterpretTransportRoute("FLOW_ASR_CLIENT", 2);
            FLOW_ASR_CLIENT = r102;
            QuicInterpretTransportRoute[] r103 = {r100, r101, r102};
            f287491a = r103;
            f287492b = EnumEntriesKt.enumEntries(r103);
        }

        public static QuicInterpretTransportRoute[] values() {
            return (QuicInterpretTransportRoute[]) f287491a.clone();
        }

        public static QuicInterpretTransportRoute valueOf(String r100) {
            return (QuicInterpretTransportRoute) r27.a.a(QuicInterpretTransportRoute.class, r100);
        }

        public QuicInterpretTransportRoute(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f287493a = null;

        static {
            int[] r100 = new int[QuicInterpretTransportRoute.values().length];
            r100[QuicInterpretTransportRoute.FLOW_ASR_CLIENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[QuicInterpretTransportRoute.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[QuicInterpretTransportRoute.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f287493a = r100;
        }
    }

    static {
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final boolean m0() {
        return false;
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.f287439a, new n1()), new com.larus.asr.session.component.z(this.f287439a, new o1(), new QuicInterpretAsrSessionV2$createComponents$3(this), 10)}), CollectionsKt.emptyList());
    }

    public final int m() {
        String r100 = AccountService.f365697a.getUserId().concat("-selected_translator_mode");
        return Intrinsics.areEqual(((Keva) this.f287489l.getValue()).getString(r100, "1"), "1") ? 1 : 0;
    }

    public final xa8.d n() {
        return this.f287487j.invoke();
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void clear() {
        super.clear();
        this.f287444f.d();
        if (this.f287488k != QuicInterpretTransportRoute.FLOW_ASR_CLIENT) goto L9;
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService r100 = IFlowAsrClientService.a.a();
        String r101 = this.f287444f.f287711m;
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.j(r101);
        this.f287488k = QuicInterpretTransportRoute.NONE;
        return;
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void i(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f287488k = QuicInterpretTransportRoute.NONE;
        String r101 = this.f287440b;
        AsrEngineRoute r102 = r100.f287713o;
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, CloudControlInf.ROUTE);
        r100.f287711m = r101;
        r100.f287712n = 0;
        r100.f287713o = r102;
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void qa(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        super.qa(r100, r101);
        QuicInterpretTransportRoute r102 = this.f287488k;
        int r103 = b.f287493a[r102.ordinal()];
        if (r103 != 1) goto L5;
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService r104 = IFlowAsrClientService.a.a();
        r104.f(r100);
        r104.j(r100);
        this.f287488k = QuicInterpretTransportRoute.NONE;
    L20:
        int r105 = AsrSessionComponentUtils.f287672a;
        AsrSessionComponentUtils.b(this.f287439a, r100, null, "onCancel:".concat(r100), 12);
        FLogger.f375446a.i("QuicInterpretAsrSessionV2", "onCancel setSpeakerViewVisible: false");
        return;
    L5:
        if (r103 != 2) goto L7;
        xa8.d r106 = n();
        if (r106 == null) goto L20;
        if (r106.K70() == false) goto L20;
        if (r106.Ig() == true) goto L20;
        FLogger.f375446a.i("QuicInterpretAsrSessionV2", "speaker cancel");
        r106.gq(0);
        goto L20
    L7:
        if (r103 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    }

    public static final void l(QuicInterpretAsrSessionV2 r100, byte[] r101, JSONObject r102) {
        r100.getClass();
        boolean r103 = com.larus.platform.service.z2.f365865a.A2().getForcePlay();
        FLogger r104 = FLogger.f375446a;
        r104.i("QuicInterpretAsrSessionV2", "onReceiveAudioData forcePlay=" + r103 + ", ttsEnabled=" + r100.f287439a.I9());
        if (r103 == false) goto L5;
    L7:
        AudioServiceDelegate.f288288a.r0().n(PlayStateEnum.PLAY_STATE_PLAYING);
        r104.i("QuicInterpretAsrSessionV2", "simultaneousTranslator onReceiveAudioData " + r101.length + ", extraJson=" + r102);
        if (r102 == null) goto L10;
        String r105 = r102.optString("status");
    L12:
        if (Intrinsics.areEqual(r105, "1") == false) goto L16;
        r104.i("QuicInterpretAsrSessionV2", "simultaneousTranslator onReceiveAudioData end");
        return;
    L16:
        return;
    L10:
        r105 = null;
        goto L12
    L5:
        if (r100.f287439a.I9() == true) goto L7;
        r104.i("QuicInterpretAsrSessionV2", "tts switch off, stopPlayAudioData");
        AudioServiceDelegate.f288288a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void ma(String r100, Message r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        super.ma(r100, r101, r102);
        QuicInterpretTransportRoute r103 = this.f287488k;
        int r104 = b.f287493a[r103.ordinal()];
        if (r104 != 1) goto L5;
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService.a.a().r(r100);
    L15:
        int r105 = AsrSessionComponentUtils.f287672a;
        AsrSessionComponentUtils.b(this.f287439a, r100, null, "onCancel:".concat(r100), 12);
        FLogger.f375446a.i("QuicInterpretAsrSessionV2", "onSubmit setSpeakerViewVisible: false");
        return;
    L5:
        if (r104 != 2) goto L7;
        xa8.d r106 = n();
        if (r106 == null) goto L15;
        r106.JX();
        goto L15
    L7:
        if (r104 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public QuicInterpretAsrSessionV2(p r100, String r101, com.larus.asr.x0 r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "abilityGetter");
        Intrinsics.checkNotNullParameter(r103, "isCurrentSession");
        super(r100, r101, VoiceInputType.TouchSpeaker, r103);
        this.f287487j = r102;
        this.f287488k = QuicInterpretTransportRoute.NONE;
        this.f287489l = LazyKt.lazy(new r1());
        this.f287490m = new s1(this, r100, r101);
    }
}
