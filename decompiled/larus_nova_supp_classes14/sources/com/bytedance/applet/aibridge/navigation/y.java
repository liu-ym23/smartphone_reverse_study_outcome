package com.bytedance.applet.aibridge.navigation;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.platform.service.w0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements com.larus.navigation.api.b {
    public static final Set<String> f = null;
    public final Handler a;
    public final ArrayDeque<String> b;
    public b c;
    public final Lazy d;
    public boolean e;

    public static final class a {
    }

    public final class b {
        public final String a;
        public boolean b;
        public boolean c;
        public Runnable d;
        public final com.larus.media.model.a e;
        public final C0052b f;
        public final c g;

        public static final class a implements com.larus.media.v {
            public final /* synthetic */ y a;
            public final /* synthetic */ b b;

            public final boolean b(lk9.g r2) {
                Intrinsics.checkNotNullParameter(r2, "applicant");
                Map r0 = o0.a;
                return o0.a("NAVIGATION", r2.getScene());
            }

            public final void e(lk9.g r4) {
                Intrinsics.checkNotNullParameter(r4, "applicant");
                final y r5 = this.a;
                Handler r0 = r5.a;
                final b r1 = this.b;
                r0.post(new b0(r5, r1));
            }

            public final void f(MediaResourceManager.a r2) {
                Intrinsics.checkNotNullParameter(r2, "event");
            }

            public a(y r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a(lk9.g r1, float r2) {
                com.larus.media.v.a.f(r1, r2);
            }

            public final void d(lk9.g r1, lk9.g r2) {
                com.larus.media.v.a.c(r1, r2);
            }

            public final void g(lk9.g r4, final float r5) {
                Intrinsics.checkNotNullParameter(r4, "applicant");
                final y r6 = this.a;
                Handler r0 = r6.a;
                final b r1 = this.b;
                r0.post(new z(r6, r1, r5));
            }

            public final void i(lk9.g r3, lk9.g r4) {
                Intrinsics.checkNotNullParameter(r3, "current");
                Intrinsics.checkNotNullParameter(r4, "applicant");
                final y r5 = this.a;
                Handler r6 = r5.a;
                final b r0 = this.b;
                r6.post(new a0(r5, r0));
            }

            public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
                return com.larus.media.v.a.a(this, r1, r2, r3);
            }

            public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
                Intrinsics.checkNotNullParameter(r1, "current");
                Intrinsics.checkNotNullParameter(r2, "applicant");
                return MediaOccupyStrategy.INTERRUPT;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.applet.aibridge.navigation.y$b$b, reason: collision with other inner class name */
        public static final class C0052b implements q58.b {
            public final /* synthetic */ y a;
            public final /* synthetic */ b b;

            public final void b(AudioPlayerState r2) {
                Intrinsics.checkNotNullParameter(r2, "state");
            }

            public final void a(AudioPlayerErrorEnum r4) {
                Intrinsics.checkNotNullParameter(r4, "code");
                final y r5 = this.a;
                Handler r0 = r5.a;
                final b r1 = this.b;
                r0.post(new c0(r5, r1));
            }

            public C0052b(y r1, b r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class c implements l68.b {
            public final /* synthetic */ y a;
            public final /* synthetic */ b b;

            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[TtsLifeState.values().length];
                    r0[TtsLifeState.TTS_FINISH_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[TtsLifeState.TTS_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[TtsLifeState.TTS_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[TtsLifeState.TTS_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    a = r0;
                }
            }

            public final void b(byte[] r1, boolean r2) {
                Intrinsics.checkNotNullParameter(r1, "data");
            }

            public final void d(TtsState r2) {
                Intrinsics.checkNotNullParameter(r2, "state");
            }

            public final void a(TtsTracer r2) {
                Intrinsics.checkNotNullParameter(r2, "tracer");
            }

            public c(y r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void e(final TtsLifeState r3, String r4, Map<String, String> r5) {
                Intrinsics.checkNotNullParameter(r3, "lifeState");
                if (Intrinsics.areEqual(r4, this.b.a) == true) goto L5;
                return;
            L5:
                final y r6 = this.a;
                Handler r7 = r6.a;
                final b r0 = this.b;
                r7.post(new d0(r3, r6, r0));
            }

            public final void c(TtsEventEnum r1, String r2, int r3, String r4, Map<String, ? extends Object> r5) {
                Intrinsics.checkNotNullParameter(r1, "event");
                Intrinsics.checkNotNullParameter(r2, "customErrorMsg");
                Intrinsics.checkNotNullParameter(r4, "ext");
                Intrinsics.checkNotNullParameter(r5, "extMap");
                if (r1 != TtsEventEnum.TTS_FIRST_PACKAGE) goto L6;
                final y r6 = this.a;
                Handler r7 = r6.a;
                final b r8 = this.b;
                r7.post(new e0(r6, r8));
                return;
            }
        }

        public b(y r19, String r20) {
            Intrinsics.checkNotNullParameter(r20, "id");
            this.a = r20;
            this.e = new com.larus.media.model.a(null, "NAVIGATION", false, 1, 2, false, 0, false, true, 0, false, new a(r19, this), 1765);
            this.f = new C0052b(r19, this);
            this.g = new c(r19, this);
        }
    }

    public static boolean e() {
        AudioServiceDelegate r1 = AudioServiceDelegate.a;     // Catch: Exception -> L22
        if (r1.i0().g() == false) goto L6;
        return true;
    L6:
        if (r1.g() == true) goto L31;
        Lazy r2 = MediaResourceManager.a;     // Catch: Exception -> L22
        List r3 = MediaResourceManager.f();     // Catch: Exception -> L22
        if ((r3 instanceof Collection) == true) goto L10;
    L12:
        Iterator r4 = r3.iterator();     // Catch: Exception -> L22
    L13:
        if (r4.hasNext() == false) goto L18;
        String r5 = (String) r4.next();     // Catch: Exception -> L22
        if (f.contains(r5) == false) goto L13;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L33;
        return false;
    L33:
        return true;
    L18:
        r6 = false;
        goto L19
    L10:
        if (r3.isEmpty() == false) goto L12;
    L31:
        return true;
    L22:
        e = move-exception;
        int r7 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("navi_tts_ctrl", "audio state unavailable type=".concat(e.getClass().getSimpleName()));
        return true;
    }

    static {
        f = SetsKt.setOf(new String[]{"asr", "o_asr", "UGC_VOICE", "CALL", "O_CALL", "CALL_TTS_PLAY", "AI_NOTE", "dora", "DORA_ONBOARDING"});
    }

    public final IFlowTtsClientService d() {
        return (IFlowTtsClientService) this.d.getValue();
    }

    public final void stop() {
        f(new o(this));
    }

    public y() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = new ArrayDeque();
        this.d = LazyKt.lazy(new p());
    }

    public final boolean b() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L42;
        return false;
    L42:
        FragmentActivity r0 = AppHost.a.a().getTopActivity();     // Catch: Exception -> L40
        if (r0 != null) goto L8;
        return false;
    L8:
        xe8.a r2 = w0.a(r0);     // Catch: Exception -> L40
        String r4 = null;
        if ((r2 instanceof Fragment) == true) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.getActivity() == r0) goto L17;
    L39:
        return false;
    L17:
        if (r2.isResumed() == false) goto L39;
        if (r2.isVisible() == false) goto L39;
        if ((r2 instanceof xe8.a) == false) goto L24;
        xe8.a r3 = r2;     // Catch: Exception -> L40
    L25:
        if (r3 == null) goto L39;
        String r1 = r3.getConversationId();     // Catch: Exception -> L40
        if (r1 == null) goto L39;
        if ((!StringsKt.isBlank(r1)) == false) goto L31;
        r4 = r1;
    L31:
        if (r4 == null) goto L39;
        AudioServiceDelegate r5 = AudioServiceDelegate.a;     // Catch: Exception -> L40
        if (r5.q0() == false) goto L35;
        return false;
    L35:
        if (r5.D() == true) goto L45;
        if (r5.L().c(r4) == false) goto L46;
        return true;
    L46:
        return false;
    L45:
        return false;
    L24:
        r3 = null;
    L40:
        com.larus.navigation.api.c.e("navi_tts_ctrl", "first speech: IM state unavailable, keep navigation speech");
        return false;
    }

    public final void a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        f(new q(r2, this));
    }

    public final void f(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.a.post(new s(r3));
    }

    public final void g(String r21) {
        if (e() == false) goto L6;
        this.b.clear();
        com.larus.navigation.api.c.d("navi_tts_ctrl", "skip: recording or higher priority audio active");
        return;
    L6:
        final b r2 = new b(this, "navigation_" + UUID.randomUUID());
        this.c = r2;
        Runnable r4 = new t(this, r2);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.d = r4;
        this.a.postDelayed(r4, 30000);
        AudioServiceDelegate r5 = AudioServiceDelegate.a;     // Catch: Exception -> L48
        BotModel r6 = r5.i0().i();     // Catch: Exception -> L48
        String r7 = null;
        if (r6 == null) goto L12;
        SpeakerVoice r8 = r6.getVoiceType();     // Catch: Exception -> L48
        if (r8 == null) goto L12;
    L26:
        d().x(r2.f);     // Catch: Exception -> L48
        IFlowTtsClientService r9 = d();     // Catch: Exception -> L48
        String r10 = r2.a;     // Catch: Exception -> L48
        if (r8 == null) goto L30;
        String r11 = r8.getStyleId();     // Catch: Exception -> L48
    L32:
        if (r11 != null) goto L34;
        String r12 = "";
    L35:
        if (r8 == null) goto L37;
        String r13 = r8.getExtra();     // Catch: Exception -> L48
    L38:
        if (r13 != null) goto L40;
        String r14 = "";
    L41:
        if (r8 == null) goto L43;
        r7 = r8.getAudioMetrics();     // Catch: Exception -> L48
    L43:
        if (r7 != null) goto L45;
        String r16 = "";
    L46:
        IFlowTtsClientService.b.a(r9, r10, null, r21, r12, r14, null, r2.g, r16, 0.0f, 0, 7762);     // Catch: Exception -> L48
        int r15 = com.larus.navigation.api.c.a;     // Catch: Exception -> L48
        com.larus.navigation.api.c.d("navi_tts_ctrl", "prepare task=" + r2.a);     // Catch: Exception -> L48
        return;
    L45:
        r16 = r7;
        goto L46
    L40:
        r14 = r13;
        goto L41
    L37:
        r13 = null;
        goto L38
    L34:
        r12 = r11;
        goto L35
    L30:
        r11 = null;
    L12:
        if (FeatureKitDelegate.b.w0().b() == false) goto L18;
        AudioUserConfig r17 = (AudioUserConfig) r5.p().getValue();     // Catch: Exception -> L48
        if (r17 == null) goto L25;
        List r18 = r17.getNewVoiceList();     // Catch: Exception -> L48
        if (r18 == null) goto L25;
        r8 = (SpeakerVoice) CollectionsKt.firstOrNull(r18);     // Catch: Exception -> L48
    L25:
        r8 = null;
        goto L26
    L18:
        com.larus.bmhome.chat.api.e0 r19 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();     // Catch: Exception -> L48
        if (r19 == null) goto L25;
        LaunchInfo r20 = r19.a;     // Catch: Exception -> L48
        if (r20 == null) goto L25;
        List r22 = r20.T0();     // Catch: Exception -> L48
        if (r22 == null) goto L25;
        r8 = (SpeakerVoice) CollectionsKt.firstOrNull(r22);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        int r23 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("navi_tts_ctrl", "prepare failed type=".concat(e.getClass().getSimpleName()));
        c(r2, "prepare_failed", false);
    }

    public final void setEnabled(boolean r1) {
        this.e = r1;
    }

    public final void c(b r6, String r7, boolean r8) {
        if (this.c == r6) goto L5;
        return;
    L5:
        Runnable r2 = null;
        this.c = null;
        Handler r3 = this.a;
        Runnable r4 = r6.d;
        if (r4 == null) goto L8;
        r2 = r4;
    L9:
        r3.removeCallbacks(r2);
        if (r8 == false) goto L28;
        this.b.clear();
    L28:
        d().t(r6.f);     // Catch: Exception -> L14
    L32:
        d().g(r6.a, false, "navigation_".concat(r7));     // Catch: Exception -> L18
    L21:
        if (r6.b == true) goto L30;
    L26:
        int r9 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("navi_tts_ctrl", "finish task=" + r6.a + " reason=" + r7);
        this.a.post(new r(this));
        return;
    L30:
        Lazy r10 = MediaResourceManager.a;     // Catch: Exception -> L24
        MediaResourceManager.a(r6.e);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("navi_tts_ctrl", "release focus failed type=".concat(e.getClass().getSimpleName()));
    L18:
        e = move-exception;
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("navi_tts_ctrl", "cancel failed type=".concat(e.getClass().getSimpleName()));
    L14:
        e = move-exception;
        int r5 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("navi_tts_ctrl", "remove listener failed type=".concat(e.getClass().getSimpleName()));
        goto L32
    L8:
        Intrinsics.throwUninitializedPropertyAccessException("timeout");
        goto L9
    }
}
