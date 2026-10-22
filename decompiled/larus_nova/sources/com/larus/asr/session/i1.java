package com.larus.asr.session;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.VoiceInputType;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class i1 implements o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f287873k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f287874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f287875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<xa8.d> f287876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f2a.d f287877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f287878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> f287879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> f287880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> f287881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f287882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j1 f287883j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "withExtHandle");
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r100, Function1<? super com.larus.audio.a, Boolean> r101, Function2<? super String, ? super byte[], Unit> r102, Function1<? super String, Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "successResultHandle");
        Intrinsics.checkNotNullParameter(r101, "failResultHandle");
        Intrinsics.checkNotNullParameter(r102, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r103, "handle");
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return false;
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r100) {
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent.f r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.f287881h.get();
    }

    public final int b() {
        return Intrinsics.areEqual(((Keva) this.f287878e.getValue()).getString(AccountService.f365697a.getUserId().concat("-selected_translator_mode"), "1"), "1") ? 1 : 0;
    }

    public final xa8.d c() {
        return this.f287876c.invoke();
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
        if (this.f287882i == false) goto L6;
        String r100 = this.f287875b;
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService.a.a().j(r100);
        this.f287882i = false;
        return;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287880g.add(r100);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287879f.remove(r100);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287880g.remove(r100);
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287879f.add(r100);
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        FLogger.f375446a.i("QuicInterpretAsrSession", "notifyStateChanged state: " + r100.getClass());
        this.f287881h.set(r100);
        Iterator<com.larus.bmhome.chat.component.bottom.core.speaker.h> r101 = this.f287879f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r100, Message r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (this.f287882i == false) goto L5;
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService r111 = IFlowAsrClientService.a.a();
        r111.f(r100);
        r111.j(r100);
        this.f287882i = false;
    L22:
        this.f287874a.L8(false, false, "onCancel:" + r100, VoiceInputType.TouchSpeaker, r100);
        FLogger.f375446a.i("QuicInterpretAsrSession", "onCancel setSpeakerViewVisible : false");
        return;
    L5:
        xa8.d r112 = c();
        boolean r101 = true;
        if (r112 != null) goto L8;
    L10:
        boolean r113 = false;
    L11:
        if (r113 == false) goto L22;
        xa8.d r114 = c();
        if (r114 != null) goto L15;
    L17:
        r101 = false;
    L18:
        if (r101 == false) goto L22;
        FLogger.f375446a.i("QuicInterpretAsrSession", "speaker cancel");
        xa8.d r115 = c();
        if (r115 == null) goto L22;
        r115.gq(0);
        goto L22
    L15:
        if (r114.Ig() == true) goto L17;
    L8:
        if (r112.K70() != true) goto L10;
        r113 = true;
        goto L11
    }

    public i1(p r100, String r101, com.larus.asr.x0 r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "abilityGetter");
        this.f287874a = r100;
        this.f287875b = r101;
        this.f287876c = r102;
        this.f287877d = new f2a.d("VoiceInput", "QuicInterpretAsrSession");
        this.f287878e = LazyKt.lazy(new e1());
        this.f287879f = new CopyOnWriteArraySet();
        this.f287880g = new CopyOnWriteArraySet();
        this.f287881h = new AtomicReference();
        this.f287883j = new j1(this);
    }

    public static final void a(i1 r100, byte[] r101, JSONObject r102) {
        r100.getClass();
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("enableSimultaneousInterpretationForcePlay = ");
        com.larus.platform.service.z2 r105 = com.larus.platform.service.z2.f365865a;
        r104.append(r105.A2().getForcePlay());
        r104.append(" , checkTtsStatus = ");
        r104.append(r100.f287874a.I9());
        r103.i("QuicInterpretAsrSession", r104.toString());
        if (r105.A2().getForcePlay() == false) goto L5;
    L7:
        AudioServiceDelegate.f288288a.r0().n(PlayStateEnum.PLAY_STATE_PLAYING);
        r103.i("QuicInterpretAsrSession", "simultaneousTranslator onReceiveAudioData " + r101.length + " , extraJson : " + r102);
        if (r102 == null) goto L10;
        String r106 = r102.optString("status");
    L12:
        if (Intrinsics.areEqual(r106, "1") == false) goto L16;
        r103.i("QuicInterpretAsrSession", "simultaneousTranslator onReceiveAudioData end");
        return;
    L16:
        return;
    L10:
        r106 = null;
        goto L12
    L5:
        if (r100.f287874a.I9() == true) goto L7;
        r103.i("QuicInterpretAsrSession", "tts switch off, stopPlayAudioData");
        AudioServiceDelegate.f288288a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r100, Message r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (this.f287882i == false) goto L5;
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService.a.a().r(r100);
    L8:
        this.f287874a.L8(false, false, "onCancel:" + r100, VoiceInputType.TouchSpeaker, r100);
        FLogger.f375446a.i("QuicInterpretAsrSession", "onSubmit setSpeakerViewVisible : false");
        return;
    L5:
        xa8.d r103 = c();
        if (r103 == null) goto L8;
        r103.JX();
        goto L8
    }

    public static void d(i1 r100, String r101, boolean r110, String r111) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "reason");
        if (r110 == false) goto L5;
        FLogger.f375446a.i("QuicInterpretAsrSession", "setSpeakerVisible visible isSpeaking:false");
        r100.f287874a.sb("ban_speaker_visible_".concat(r111));
        e2a.e.b();
        r100.f287874a.L8(true, true, r111, VoiceInputType.TouchSpeaker, r101);
        r100.f287874a.Ja(r101, null);
    L6:
        Unit r102 = Unit.INSTANCE;
        return;
    L5:
        FLogger.f375446a.i("QuicInterpretAsrSession", "setSpeakerVisible invisible");
        r100.f287874a.L8(false, false, r111, VoiceInputType.TouchSpeaker, r101);
        goto L6
    }

    @Override // com.larus.asr.session.o
    public final void pa(String r100, boolean r101, boolean r102, com.larus.audio.asr.c0 r110, long r111, Long r112, Integer r113, d58.a r114) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r110, "traceInfo");
        Intrinsics.checkNotNullParameter(r114, "durationConfig");
        wc9.e r103 = this.f287874a.h();
        if (r103 == null) goto L5;
        String r104 = r103.f559198a;
    L6:
        String r115 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        BotModel r116 = this.f287874a.i();
        if (r116 == null) goto L12;
        String r117 = r116.getBotId();
    L13:
        if (r117 == null) goto L16;
        r115 = r117;
    L16:
        IConversationRepoService.a.f(RepoDispatcherDelegate.f307737b.f(), r104, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
        f2a.c r118 = this.f287877d.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put(new f2a.f("from_text_area"), String.valueOf(r101));
        r119.put(new f2a.f("asr_only"), "false");
        r119.put(f2a.f.f475238h, r104);
        r119.put(f2a.f.f475235e, r115);
        r118.d(r119);
        r118.f475230c.f475256d = "invokeOnSpeak";
        List<String> r105 = CollectionsKt.listOf(r110.f288366a);
        f2a.g r106 = r118.f475230c;
        r106.f475254b = r105;
        r106.f475257e = r110.f288367b;
        f2a.c.c(r118, null, 15);
        final String r107 = this.f287875b;
        this.f287874a.Bb(new a1(this, r107));
        return;
    L12:
        r117 = null;
        goto L13
    L5:
        r104 = null;
        goto L6
    }
}
