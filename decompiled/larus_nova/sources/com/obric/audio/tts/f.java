package com.obric.audio.tts;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import com.larus.audio.audiov3.audio.player.factory.IAudioPlayerFactory;
import com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory;
import com.larus.audio.audiov3.task.TtsManager;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.home.impl.sdk.s;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import ic8.n;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f395820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f395821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f395822c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f395823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile q58.a f395824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g68.e f395825f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinkedBlockingQueue<byte[]> f395826g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PThreadPoolExecutor f395827h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f395828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f395829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f395830k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile AudioPlayerState f395831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static u58.a f395832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.larus.media.model.a f395833n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.larus.media.model.a f395834o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static com.larus.media.model.a f395835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f395836q = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f395837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpeakerVoice f395838b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f395837a, r101.f395837a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f395838b, r101.f395838b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f395837a.hashCode() * 31) + this.f395838b.hashCode();
        }

        public final String toString() {
            return "MainBotVoice(botId=" + this.f395837a + ", voice=" + this.f395838b + ')';
        }

        public a(String r100, SpeakerVoice r101) {
            Intrinsics.checkNotNullParameter(r100, "botId");
            Intrinsics.checkNotNullParameter(r101, "voice");
            this.f395837a = r100;
            this.f395838b = r101;
        }
    }

    public static final class b implements q58.b {
        public b() {
        }

        @Override // q58.b
        public final void a(AudioPlayerErrorEnum r100) {
            Intrinsics.checkNotNullParameter(r100, "code");
            int r101 = c68.b.f22600a;
            c68.b.b("ObricTtsClient", "audioPlayer onFailed code=" + r100.getCode() + " msg=" + r100.getMassage());
        }

        @Override // q58.b
        public final void b(AudioPlayerState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = c68.b.f22600a;
            c68.b.a("ObricTtsClient", "audioPlayer onStateChange state=" + r100);
            f r102 = f.f395820a;
            f.f395831l = r100;
        }
    }

    public static final class c implements v {
        public c() {
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            String r101 = f.f395835p.f359114b;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.DORA) == true) goto L5;
        L7:
            boolean r102 = false;
        L9:
            if (r102 == false) goto L12;
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] canMixWith=false (DORA)");
            return false;
        L12:
            Map<String, o0.a> r103 = o0.f359131a;
            boolean r104 = o0.a(r101, r100.getScene());
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] canMixWith current=" + r101 + ", applicant=" + r100.getScene() + " canMix=" + r104);
            return r104;
        L5:
            if (Intrinsics.areEqual(r101, MediaScene.OBRIC_DORA) == true) goto L7;
            r102 = true;
            goto L9
        }

        @Override // com.larus.media.v
        public final void e(final lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.d(r100);
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] onMediaInterrupted applicant=" + r100.getScene());
            t0.e(new h(r100));
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] onMediaResume applicant=" + r100.getScene() + " volumeFactor=" + r101);
            t0.e(new j());
            v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, final float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] onMediaVolumeChange applicant=" + r100.getScene() + " volumeFactor=" + r101);
            t0.e(new i(this, r101));
            v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            v.a.e(r100, r101);
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] onMediaPaused applicant=" + r101.getScene());
            t0.e(new k());
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            Map<String, o0.a> r103 = o0.f359131a;
            if (o0.c(r100.getScene(), r101.getScene()) == false) goto L20;
            f.f395820a.getClass();
            boolean r104 = false;
            if (Intrinsics.areEqual(r101.getScene(), MediaScene.DORA) == false) goto L16;
            IFlowSdkDepend r105 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r105 == null) goto L13;
            s r106 = r105.s0();
            if (r106 == null) goto L13;
            if (r106.L() != true) goto L13;
            boolean r107 = true;
        L14:
            if (r107 == false) goto L16;
            r104 = true;
        L13:
            r107 = false;
        L16:
            if (r104 == false) goto L20;
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] gainOccupiedStrategy DORA pause, current=" + r100.getScene() + ", applicant=" + r101.getScene());
            return MediaOccupyStrategy.PAUSE;
        L20:
            if (Intrinsics.areEqual(r101.getScene(), MediaScene.SYSTEM) == true) goto L22;
            MediaOccupyStrategy r108 = o0.b(r100.getScene(), r101.getScene());
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] gainOccupiedStrategy current=" + r100.getScene() + ", applicant=" + r101.getScene() + " strategy=" + r108);
            return r108;
        L22:
            if (r102 != (-3)) goto L24;
        L26:
            MediaOccupyStrategy r109 = MediaOccupyStrategy.PAUSE;
        L27:
            FLogger.f375446a.i("ObricTtsClient", "[OBRIC_TTS] gainOccupiedStrategy SYSTEM focusChange=" + r102 + " strategy=" + r109);
            return r109;
        L24:
            if (r102 == (-2)) goto L26;
            r109 = MediaOccupyStrategy.INTERRUPT;
            goto L27
        }
    }

    public f() {
    }

    static {
        f395820a = new f();
        f395821b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f395822c = new AtomicLong(0);
        f395823d = "";
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().r();
        f395825f = TtsManager.f288522a;
        f395826g = new LinkedBlockingQueue();
        f395827h = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("bricTtsClient"));
        f395830k = new AtomicBoolean(false);
        f395831l = AudioPlayerState.STOPPED;
        c r100 = new c();
        com.larus.media.model.a r110 = new com.larus.media.model.a(null, MediaScene.OBRIC_TTS, false, 1, 2, false, 0, false, false, 0, false, r100, 2021);
        f395833n = r110;
        f395834o = new com.larus.media.model.a(null, MediaScene.OBRIC_DORA, false, 1, 2, false, 0, false, false, 0, false, r100, 2021);
        f395835p = r110;
        f395836q = new b();
    }

    public static void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Lazy r101 = MediaResourceManager.f358950a;     // Catch: Throwable -> L4
        MediaResourceManager.a(f395835p);     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("ObricTtsClient", "abandonMedia error: " + r103.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static q58.a d() {
        q58.a r100 = f395824e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        IAudioPlayerFactory r101 = (IAudioPlayerFactory) ServiceManager.get().getService(IAudioPlayerFactory.class);
        if (r101 != null) goto L23;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] startByText skip, IAudioPlayerFactory not found");
        return null;
    L23:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(r101.create());     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        int r105 = c68.b.f22600a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] create AudioPlayer failed: " + r104.getMessage());
    L17:
        if (Result.m9455isFailureimpl(r103) == false) goto L19;
        r103 = null;
    L19:
        q58.a r106 = (q58.a) r103;
        if (r106 == null) goto L25;
        f395824e = r106;
        return r106;
    L25:
        return null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static u58.a e() {
        u58.a r100 = f395832m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        IAudioPlayerConfigFactory r101 = (IAudioPlayerConfigFactory) ServiceManager.get().getService(IAudioPlayerConfigFactory.class);
        if (r101 != null) goto L23;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] startByText skip, IAudioPlayerConfigFactory not found");
        return null;
    L23:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(r101.a(24000, 4, 2));     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        int r105 = c68.b.f22600a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] create AudioPlayerConfig failed: " + r104.getMessage());
    L17:
        if (Result.m9455isFailureimpl(r103) == false) goto L19;
        r103 = null;
    L19:
        u58.a r106 = (u58.a) r103;
        if (r106 == null) goto L25;
        f395832m = r106;
        return r106;
    L25:
        return null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static void f(final String r100, final q58.a r101) {
        int r102 = c68.b.f22600a;
        c68.b.a("ObricTtsClient", "[OBRIC_TTS] tryPlay taskId=" + r100);
        f395827h.submit(new com.obric.audio.tts.c(r100, r101));
    }

    public final synchronized void c(String r100, boolean r101) {
        monitor-enter(this);
        String r102 = f395823d;     // Catch: Throwable -> L20
        int r103 = c68.b.f22600a;     // Catch: Throwable -> L20
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] cancelTtsAndStopPlay taskId=" + r102 + " reason=" + r100);     // Catch: Throwable -> L20
        boolean r104 = true;
        f395828i = true;     // Catch: Throwable -> L20
        f395829j = false;     // Catch: Throwable -> L20
        LinkedBlockingQueue<byte[]> r105 = f395826g;     // Catch: Throwable -> L20
        r105.clear();     // Catch: Throwable -> L20
        r105.offer(new byte[0]);     // Catch: Throwable -> L20
        q58.a r106 = f395824e;     // Catch: Throwable -> L20
        if (r106 != null) goto L8;
    L11:
        if (r102.length() > 0) goto L14;
        r104 = false;
    L14:
        if (r104 == false) goto L16;
        g68.e r107 = f395825f;     // Catch: Throwable -> L20
        r107.cancel(r102);     // Catch: Throwable -> L20
        r107.stop(r102);     // Catch: Throwable -> L20
        r107.c(r102);     // Catch: Throwable -> L20
    L16:
        if (r101 == false) goto L18;
        a();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L8:
        if (r106.getPlayState() == AudioPlayerState.STOPPED) goto L11;
        r106.stop();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static final Object b(f r110, long r210, Continuation r211) {
        r110.getClass();
        if ((r211 instanceof ObricTtsClient$resolveMainBotVoice$1) == false) goto L7;
        ObricTtsClient$resolveMainBotVoice$1 r100 = (ObricTtsClient$resolveMainBotVoice$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ObricTtsClient$resolveMainBotVoice$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r111 = true;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        long r106 = r102.J$0;
        String r107 = (String) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L71:
        Object r109 = Result.m9449constructorimpl((BotModel) r103);     // Catch: Throwable -> L15
    L80:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L84;
        int r113 = c68.b.f22600a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice query failed requestId=" + r106 + " mainBotId=" + r108 + " error=" + r112.getMessage());
    L84:
        if (Result.m9455isFailureimpl(r109) == false) goto L86;
        r109 = null;
    L86:
        BotModel r114 = (BotModel) r109;
        if (r114 != null) goto L89;
        int r115 = c68.b.f22600a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice failed, botRepo returned null requestId=" + r106 + " mainBotId=" + r108);
    L110:
        return null;
    L89:
        SpeakerVoice r116 = r114.getVoiceType();
        if (r116 == null) goto L100;
        String r117 = r116.getStyleId();
        if (r117 != null) goto L94;
    L97:
        if (r111 == true) goto L100;
        int r118 = c68.b.f22600a;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice success requestId=" + r106 + " mainBotId=" + r108 + " idSource=" + r107 + " voiceSource=main_bot_repo voiceId=" + r116.getId() + " styleId=" + r116.getStyleId());
        return new a(r108, r116);
    L94:
        if (StringsKt.isBlank(r117) == true) goto L97;
        r111 = false;
    L100:
        int r119 = c68.b.f22600a;
        StringBuilder r120 = new StringBuilder("[OBRIC_TTS] resolveMainBotVoice failed, voice is invalid requestId=");
        r120.append(r106);
        r120.append(" mainBotId=");
        r120.append(r108);
        r120.append(" voiceId=");
        if (r116 == null) goto L103;
        String r121 = r116.getId();
    L104:
        r120.append(r121);
        r120.append(" styleId=");
        if (r116 == null) goto L107;
        String r122 = r116.getStyleId();
    L108:
        r120.append(r122);
        c68.b.b("ObricTtsClient", r120.toString());
        goto L110
    L107:
        r122 = null;
        goto L108
    L103:
        r121 = null;
    L15:
        th = th;
        long r123 = r106;
        String r124 = r107;
        String r125 = r108;
    L79:
        Result.Companion r126 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r107 = r124;
        r108 = r125;
        r106 = r123;
        goto L80
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r127 = r102.J$0;
        ResultKt.throwOnFailure(r103);
    L25:
        List r128 = (List) r103;
        if (r128 == null) goto L32;
        String r129 = (String) CollectionsKt.firstOrNull(r128);
        if (r129 == null) goto L32;
        if ((!StringsKt.isBlank(r129)) == false) goto L32;
        r123 = r127;
    L33:
        c1<h0> r130 = AuthModelDelegate.f297134b.a().getValue();
        if (r130 == null) goto L42;
        h0 r131 = r130.f295753d;
        if (r131 == null) goto L42;
        String r132 = r131.b();
        if (r132 == null) goto L42;
        if ((!StringsKt.isBlank(r132)) == false) goto L42;
    L43:
        LaunchInfo r133 = LaunchCacheDelegate.f295726b.c();
        if (r133 == null) goto L50;
        String r134 = r133.W();
        if (r134 == null) goto L50;
        if ((!StringsKt.isBlank(r134)) == false) goto L50;
    L51:
        if (r129 != null) goto L55;
        if (r132 != null) goto L54;
        String r135 = r134;
    L56:
        if (r129 == null) goto L59;
        String r136 = "main_conversation";
    L58:
        String r137 = r136;
        if (r135 != null) goto L64;
        int r138 = c68.b.f22600a;
        c68.b.b("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice failed, mainBotId is empty requestId=" + r123);
        goto L110
    L64:
        int r139 = c68.b.f22600a;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice begin requestId=" + r123 + " mainBotId=" + r135 + " idSource=" + r137 + " forceNew=false");
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L76
        IBotRepoService r141 = zh8.a.f572200e;     // Catch: Throwable -> L76
        r102.L$0 = r135;     // Catch: Throwable -> L76
        r102.L$1 = r137;     // Catch: Throwable -> L76
        r102.J$0 = r123;     // Catch: Throwable -> L76
        r102.label = 2;     // Catch: Throwable -> L76
        String r142 = r137;
        String r143 = r135;
        r103 = IBotRepoService.b.a(r141, r135, false, null, false, r102, 28);     // Catch: Throwable -> L74
        if (r103 == r104) goto L119;
        r106 = r123;
        r107 = r142;
        r108 = r143;
        goto L71
    L119:
        return r104;
    L74:
        th = th;
    L78:
        r124 = r142;
        r125 = r143;
    L76:
        th = th;
        r142 = r137;
        r143 = r135;
        goto L78
    L59:
        if (r132 == null) goto L61;
        r136 = "runtime_launch";
        goto L58
    L61:
        r136 = "persisted_launch";
        goto L58
    L54:
        r135 = r132;
        goto L56
    L55:
        r135 = r129;
    L50:
        r134 = null;
    L42:
        r132 = null;
    L32:
        r123 = r127;
        r129 = null;
        goto L33
    L20:
        ResultKt.throwOnFailure(r103);
        wc9.e r144 = AuthModelDelegate.f297134b.y().getValue();
        r127 = r210;
        if (r144 == null) goto L32;
        r102.J$0 = r127;
        r102.label = 1;
        r103 = n.c(r144, r102);
        if (r103 != r104) goto L25;
        return r104;
    L7:
        r100 = new ObricTtsClient$resolveMainBotVoice$1(r110, r211);
        goto L8
    }
}
