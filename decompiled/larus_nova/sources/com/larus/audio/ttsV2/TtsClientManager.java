package com.larus.audio.ttsV2;

import androidx.collection.LruCache;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.audio.record.AsrClientStatus;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsFinishPlayingType;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.audio.bean.CacheConfig;
import com.larus.audio.d1;
import com.larus.audio.utils.j0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.o0;
import com.larus.network.http.ServiceType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.audio.IObricTtsControlService;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import hq9.r4;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.v3;

/* JADX INFO: loaded from: classes4.dex */
public final class TtsClientManager implements d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TtsClientManager f289870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BotModel f289871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f289872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f289873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f289874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f289875f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile TtsState f289876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LruCache<String, Message> f289877h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f2a.d f289878i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f289879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.larus.media.model.a f289880k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.larus.media.model.a f289881l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static com.larus.media.model.a f289882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CopyOnWriteArraySet<b> f289883n = null;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger r101 = FLogger.f375446a;
            TtsClientManager r102 = TtsClientManager.f289870a;
            r101.i("TtsClientManager", "onUserDidOnline action=" + r100.f364878d + " uid=" + r100.f364876b);
            IFlowTtsClientService.f288300a.getClass();
            IFlowTtsClientService.a.a().q();
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger r101 = FLogger.f375446a;
            TtsClientManager r102 = TtsClientManager.f289870a;
            r101.i("TtsClientManager", "onUserDidOffline action=" + r100.f364878d + " uid=" + r100.f364876b);
            IFlowTtsClientService.f288300a.getClass();
            IFlowTtsClientService.a.a().q();
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f289884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f289885b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f289884a, r101.f289884a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f289885b, r101.f289885b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f289884a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f289885b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StartSessionData(conversationId=" + this.f289884a + ", msgId=" + this.f289885b + ')';
        }

        public final String a() {
            return this.f289884a;
        }

        public b(String r100, String r101) {
            this.f289884a = r100;
            this.f289885b = r101;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f289886a = null;

        static {
            int[] r100 = new int[TtsState.values().length];
            r100[TtsState.TTS_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TtsState.TTS_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f289886a = r100;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class d implements com.larus.media.v {
        public d() {
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            FLogger r101 = FLogger.f375446a;
            TtsClientManager r102 = TtsClientManager.f289870a;
            r101.i("TtsClientManager", "[TTS] canMixWith, applicant.scene: " + r100.getScene());
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.DORA) == true) goto L5;
        L7:
            boolean r103 = false;
        L9:
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.TTS_SAMPLE) == false) goto L11;
        L33:
            return false;
        L11:
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.MUSIC_GEN) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.NEWS) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.AI_NOTE) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.STREAM_PLAYER) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.IM_TTS) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.NAVIGATION) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.SYSTEM) == true) goto L25;
        L26:
            if (r103 == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.CALL_TTS_PLAY) == true) goto L33;
            if (Intrinsics.areEqual(r100.getScene(), "CALL") == true) goto L33;
            return true;
        L25:
            if (ObricTtsControlDelegate.f392839b.h(r100) == true) goto L33;
        L5:
            if (z2.f365865a.v3().c() == false) goto L7;
            r103 = true;
            goto L9
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            com.larus.media.v.a.d(r100);
            t0.e(new j());
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            t0.e(new n());
            com.larus.media.v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            com.larus.media.v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, final float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            t0.e(new k(r101));
            com.larus.media.v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            com.larus.media.v.a.e(r100, r101);
            t0.e(new o());
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return com.larus.media.v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            FLogger r103 = FLogger.f375446a;
            TtsClientManager r104 = TtsClientManager.f289870a;
            r103.i("TtsClientManager", "[TTS] gainOccupiedStrategy, applicant.scene: " + r101.getScene() + ", focusChange: " + r102);
            Map<String, o0.a> r105 = o0.f359131a;
            boolean r106 = false;
            if (o0.c(MediaScene.IM_TTS, r101.getScene()) == true) goto L5;
        L19:
            if (r106 == false) goto L23;
            return MediaOccupyStrategy.PAUSE;
        L23:
            if (Intrinsics.areEqual(r101.getScene(), MediaScene.SYSTEM) == false) goto L36;
            ObricTtsControlDelegate r107 = ObricTtsControlDelegate.f392839b;
            r107.i(new l(), new m());
            if (r102 != (-3)) goto L27;
        L29:
            MediaOccupyStrategy r108 = MediaOccupyStrategy.PAUSE;
        L30:
            MediaOccupyStrategy r109 = r107.x(r102);
            if (r109 != null) goto L34;
            return r108;
        L34:
            return r109;
        L27:
            if (r102 == (-2)) goto L29;
            r108 = MediaOccupyStrategy.INTERRUPT;
            goto L30
        L36:
            if (Intrinsics.areEqual(r101.getScene(), MediaScene.OBRIC_TTS) == false) goto L40;
            return MediaOccupyStrategy.PAUSE;
        L40:
            return MediaOccupyStrategy.INTERRUPT;
        L5:
            if (Intrinsics.areEqual(r101.getScene(), MediaScene.DORA) == false) goto L16;
            IFlowSdkDepend r110 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r110 == null) goto L13;
            com.larus.home.impl.sdk.s r111 = r110.s0();
            if (r111 == null) goto L13;
            if (r111.L() != true) goto L13;
            boolean r112 = true;
        L14:
            if (r112 == false) goto L16;
            boolean r113 = true;
        L17:
            if (r113 == false) goto L19;
            r106 = true;
        L13:
            r112 = false;
        L16:
            r113 = false;
            goto L17
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class e implements l68.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f289887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f289888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f289889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f289890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f289891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f289892f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f289893g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f289894h;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f289895a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f289896b = null;

            static {
                int[] r100 = new int[TtsLifeState.values().length];
                r100[TtsLifeState.TTS_FINISH_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L20:
                r100[TtsLifeState.TTS_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L26:
                r100[TtsLifeState.TTS_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L8:
                f289895a = r100;
                int[] r101 = new int[TtsEventEnum.values().length];
                r101[TtsEventEnum.TTS_FIRST_PACKAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L22:
                r101[TtsEventEnum.TTS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L28:
                r101[TtsEventEnum.TTS_SENTENCE_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L12:
                f289896b = r101;
            }
        }

        @Override // l68.b
        public final void b(byte[] r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
        }

        @Override // l68.b
        public final void a(TtsTracer r100) {
            Intrinsics.checkNotNullParameter(r100, "tracer");
        }

        @Override // l68.b
        public final void d(TtsState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            f2a.c r101 = TtsClientManager.f289878i.b("[TTS] onStateChanged");
            r101.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r102 = new Pair[4];
            f2a.f r103 = f2a.f.f475238h;
            String r104 = this.f289887a;
            String r105 = "";
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            r102[0] = TuplesKt.to(r103, r104);
            f2a.f r106 = f2a.f.f475239i;
            String r107 = this.f289888b;
            if (r107 != null) goto L8;
            r107 = "";
        L8:
            r102[1] = TuplesKt.to(r106, r107);
            f2a.f r108 = new f2a.f("start_read_message_reason");
            String r109 = this.f289889c;
            if (r109 != null) goto L11;
            r109 = "";
        L11:
            r102[2] = TuplesKt.to(r108, r109);
            r102[3] = TuplesKt.to(new f2a.f("tts_state"), r100.name());
            r101.d(MapsKt.mapOf(r102));
            f2a.c.c(r101, null, 15);
            if (r100 != TtsState.TTS_STARTED) goto L15;
            FLogger.f375446a.b("TTS", r100.name(), TtsClientManager.f289873d);
        L17:
            Map<String, String> r110 = this.f289890d;
            if (r100 == TtsState.TTS_STOPPED) goto L20;
        L22:
            TtsClientManager.f289876g = r100;
            if (r110 == null) goto L28;
            String r111 = r110.get(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID);
            if (r111 == null) goto L28;
            r105 = r111;
        L28:
            JsonObject r112 = new JsonObject();
            r112.addProperty(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r105);
            int r113 = c.f289886a[r100.ordinal()];
            if (r113 == 1) goto L34;
            if (r113 != 2) goto L33;
            com.larus.platform.service.k.f365753a.a(IAppletJsbEventService.TriggeredEvent.TTS_END, r112);
            return;
        L33:
            throw new NoWhenBranchMatchedException();
        L34:
            com.larus.platform.service.k.f365753a.a(IAppletJsbEventService.TriggeredEvent.TTS_START, r112);
            return;
        L20:
            if (TtsClientManager.f289876g != r100) goto L22;
            return;
        L15:
            if (r100 != TtsState.TTS_STOPPED) goto L17;
            FLogger.f375446a.c("TTS", r100.name(), TtsClientManager.f289873d);
            goto L17
        }

        @Override // l68.b
        public final void e(TtsLifeState r110, String r111, Map<String, String> r210) {
            Intrinsics.checkNotNullParameter(r110, "lifeState");
            f2a.d r100 = TtsClientManager.f289878i;
            f2a.c r101 = r100.b("[TTS] onLifeStateChange");
            r101.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r102 = new Pair[6];
            f2a.f r103 = f2a.f.f475238h;
            String r104 = this.f289887a;
            String r105 = "";
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            r102[0] = TuplesKt.to(r103, r104);
            f2a.f r106 = f2a.f.f475239i;
            String r112 = this.f289888b;
            if (r112 != null) goto L8;
            r112 = "";
        L8:
            r102[1] = TuplesKt.to(r106, r112);
            f2a.f r113 = f2a.f.f475233c;
            if (r111 != null) goto L11;
            String r114 = "";
        L12:
            r102[2] = TuplesKt.to(r113, r114);
            f2a.f r115 = new f2a.f("start_read_message_reason");
            String r116 = this.f289889c;
            if (r116 != null) goto L15;
            r116 = "";
        L15:
            r102[3] = TuplesKt.to(r115, r116);
            r102[4] = TuplesKt.to(new f2a.f("tts_life_state"), r110.name());
            r102[5] = TuplesKt.to(new f2a.f("extra_ap"), GsonProtectorUtils.toJson(new Gson(), r210));
            r101.d(MapsKt.mapOf(r102));
            f2a.c.c(r101, null, 15);
            if (r210 == null) goto L18;
            String r107 = r210.get("scene_from");
        L19:
            int r108 = a.f289895a[r110.ordinal()];
            if (r108 != 1) goto L22;
            f2a.c r109 = r100.b("[TTS][LIFE_STATE] TTS_FINISH_PLAYING");
            r109.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r117 = new Pair[4];
            String r118 = this.f289887a;
            if (r118 != null) goto L50;
            r118 = "";
        L50:
            r117[0] = TuplesKt.to(r103, r118);
            String r119 = this.f289888b;
            if (r119 != null) goto L53;
            r119 = "";
        L53:
            r117[1] = TuplesKt.to(r106, r119);
            if (r111 != null) goto L56;
            String r120 = "";
        L57:
            r117[2] = TuplesKt.to(r113, r120);
            f2a.f r121 = new f2a.f("start_read_message_reason");
            String r122 = this.f289889c;
            if (r122 == null) goto L61;
            r105 = r122;
        L61:
            r117[3] = TuplesKt.to(r121, r105);
            r109.d(MapsKt.mapOf(r117));
            f2a.c.c(r109, null, 15);
            if (Intrinsics.areEqual(r107, TtsFinishPlayingType.PLAY_DONE.getType()) == false) goto L64;
            this.f289891e.invoke();
            return;
        L64:
            Function1<String, Unit> r123 = this.f289892f;
            if (r107 != null) goto L67;
            r107 = "unknown";
        L67:
            r123.invoke(r107);
            return;
        L56:
            r120 = r111;
            goto L57
        L22:
            if (r108 != 2) goto L24;
        L26:
            f2a.c r124 = r100.b("[TTS][LIFE_STATE] TtsLifeState change");
            r124.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r125 = new Pair[5];
            String r126 = this.f289887a;
            if (r126 != null) goto L29;
            r126 = "";
        L29:
            r125[0] = TuplesKt.to(r103, r126);
            String r127 = this.f289888b;
            if (r127 != null) goto L32;
            r127 = "";
        L32:
            r125[1] = TuplesKt.to(r106, r127);
            if (r111 != null) goto L35;
            String r128 = "";
        L36:
            r125[2] = TuplesKt.to(r113, r128);
            f2a.f r129 = new f2a.f("start_read_message_reason");
            String r130 = this.f289889c;
            if (r130 == null) goto L40;
            r105 = r130;
        L40:
            r125[3] = TuplesKt.to(r129, r105);
            r125[4] = TuplesKt.to(new f2a.f("tts_life_state"), r110.name());
            r124.d(MapsKt.mapOf(r125));
            f2a.c.c(r124, null, 15);
            if (Intrinsics.areEqual(r107, TtsFinishPlayingType.PLAY_DONE.getType()) == false) goto L43;
            this.f289891e.invoke();
            return;
        L43:
            Function1<String, Unit> r131 = this.f289892f;
            if (r107 != null) goto L46;
            r107 = "stop or error";
        L46:
            r131.invoke(r107);
            return;
        L35:
            r128 = r111;
            goto L36
        L24:
            if (r108 == 3) goto L26;
            return;
        L18:
            r107 = null;
            goto L19
        L11:
            r114 = r111;
            goto L12
        }

        @Override // l68.b
        public final void c(TtsEventEnum r100, String r110, int r111, String r112, Map<String, ? extends Object> r113) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r110, "customErrorMsg");
            Intrinsics.checkNotNullParameter(r112, "ext");
            Intrinsics.checkNotNullParameter(r113, "extMap");
            IFlowSdkDepend r114 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r114 == null) goto L5;
            r114.K0();
            com.larus.music.i.f359475a.h();
        L5:
            int r115 = a.f289896b[r100.ordinal()];
            String r101 = null;
            String r102 = "";
            if (r115 == 1) goto L45;
            if (r115 == 2) goto L39;
            if (r115 == 3) goto L20;
            f2a.c r103 = TtsClientManager.f289878i.b("other events " + r100.getMassage());
            r103.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r116 = new Pair[3];
            f2a.f r117 = f2a.f.f475238h;
            String r118 = this.f289887a;
            if (r118 != null) goto L12;
            r118 = "";
        L12:
            r116[0] = TuplesKt.to(r117, r118);
            f2a.f r119 = f2a.f.f475239i;
            String r120 = this.f289888b;
            if (r120 != null) goto L15;
            r120 = "";
        L15:
            r116[1] = TuplesKt.to(r119, r120);
            f2a.f r121 = new f2a.f("start_read_message_reason");
            String r122 = this.f289889c;
            if (r122 == null) goto L19;
            r102 = r122;
        L19:
            r116[2] = TuplesKt.to(r121, r102);
            r103.d(MapsKt.mapOf(r116));
            f2a.c.c(r103, null, 15);
            return;
        L20:
            Object r104 = r113.get("text");
            if ((r104 instanceof String) == false) goto L23;
            String r105 = (String) r104;
        L24:
            Object r123 = r113.get(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
            if ((r123 instanceof m68.a) == false) goto L27;
            m68.a r124 = (m68.a) r123;
        L28:
            IAIChatTtsPlayTraceService.Companion r125 = IAIChatTtsPlayTraceService.f365902a;
            String r126 = this.f289894h;
            if (r126 == null) goto L32;
            r102 = r126;
        L32:
            if (r124 == null) goto L34;
            String r127 = r124.a();
        L35:
            if (r124 == null) goto L37;
            r101 = r124.b();
        L37:
            r125.d(r102, r105, r127, r101);
            return;
        L34:
            r127 = null;
            goto L35
        L27:
            r124 = null;
            goto L28
        L23:
            r105 = null;
            goto L24
        L39:
            if (new JSONObject(r112).optBoolean(LocationMonitorConst.IS_CACHE) == false) goto L100;
            String r106 = this.f289889c;
            String r128 = this.f289888b;
            BotModel r129 = TtsClientManager.f289871b;
            if (r129 == null) goto L43;
            r101 = r129.getBotId();
        L43:
            v3.a(r106, r128, r101, this.f289893g, this.f289887a);
            return;
        L100:
            return;
        L45:
            if (TtsClientManager.f289870a.g() == false) goto L59;
            f2a.c r107 = TtsClientManager.f289878i.b("[TTS][ASR_RECORDING] skip startAudioPlay on first package");
            r107.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r130 = new Pair[3];
            f2a.f r131 = f2a.f.f475238h;
            String r132 = this.f289887a;
            if (r132 != null) goto L49;
            r132 = "";
        L49:
            r130[0] = TuplesKt.to(r131, r132);
            f2a.f r133 = f2a.f.f475239i;
            String r134 = this.f289888b;
            if (r134 != null) goto L52;
            r134 = "";
        L52:
            r130[1] = TuplesKt.to(r133, r134);
            f2a.f r135 = new f2a.f("start_read_message_reason");
            String r136 = this.f289889c;
            if (r136 == null) goto L56;
            r102 = r136;
        L56:
            r130[2] = TuplesKt.to(r135, r102);
            r107.d(MapsKt.mapOf(r130));
            f2a.c.c(r107, null, 15);
            IFlowTtsClientService.f288300a.getClass();
            IFlowTtsClientService.a.a().g(TtsClientManager.f289873d, false, "TtsClientManager TTS_FIRST_PACKAGE skipped by ASR recording");
            return;
        L59:
            if (j0.a() == false) goto L72;
            f2a.c r108 = TtsClientManager.f289878i.a("[TTS][O_CALL PLAYING] O_CALL is playing, return");
            r108.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r137 = new Pair[3];
            f2a.f r138 = f2a.f.f475238h;
            String r139 = this.f289887a;
            if (r139 != null) goto L63;
            r139 = "";
        L63:
            r137[0] = TuplesKt.to(r138, r139);
            f2a.f r140 = f2a.f.f475239i;
            String r141 = this.f289888b;
            if (r141 != null) goto L66;
            r141 = "";
        L66:
            r137[1] = TuplesKt.to(r140, r141);
            f2a.f r142 = new f2a.f("start_read_message_reason");
            String r143 = this.f289889c;
            if (r143 == null) goto L70;
            r102 = r143;
        L70:
            r137[2] = TuplesKt.to(r142, r102);
            r108.d(MapsKt.mapOf(r137));
            f2a.c.c(r108, null, 15);
            IFlowTtsClientService.f288300a.getClass();
            IFlowTtsClientService.a.a().g(TtsClientManager.f289873d, false, "TtsClientManager TTS_FIRST_PACKAGE skipped by O_CALL playing");
            return;
        L72:
            IFlowSdkDepend r109 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r109 == null) goto L75;
            r109.K0();
            boolean r144 = com.larus.music.i.f359475a.h();
        L77:
            if (ObricTtsControlDelegate.f392839b.e() == false) goto L80;
            TtsClientManager.f289882m = TtsClientManager.m(r144);
        L86:
            f2a.c r145 = TtsClientManager.f289878i.b("[TTS] TTS_FIRST_PACKAGE");
            r145.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
            Pair[] r146 = new Pair[5];
            f2a.f r147 = f2a.f.f475238h;
            String r148 = this.f289887a;
            if (r148 != null) goto L89;
            r148 = "";
        L89:
            r146[0] = TuplesKt.to(r147, r148);
            f2a.f r149 = f2a.f.f475239i;
            String r150 = this.f289888b;
            if (r150 != null) goto L92;
            r150 = "";
        L92:
            r146[1] = TuplesKt.to(r149, r150);
            f2a.f r151 = new f2a.f("start_read_message_reason");
            String r152 = this.f289889c;
            if (r152 == null) goto L96;
            r102 = r152;
        L96:
            r146[2] = TuplesKt.to(r151, r102);
            r146[3] = TuplesKt.to(new f2a.f("is_qq_music_play"), Boolean.valueOf(r144));
            r146[4] = TuplesKt.to(new f2a.f("current_application"), TtsClientManager.f289882m);
            r145.d(MapsKt.mapOf(r146));
            f2a.c.c(r145, null, 15);
            Lazy r153 = MediaResourceManager.f358950a;
            com.larus.media.model.a r154 = TtsClientManager.f289882m;
            final String r155 = this.f289887a;
            final String r156 = this.f289888b;
            final String r157 = this.f289889c;
            MediaResourceManager.m(r154, new r(r155, r156, r157), new s(r155, r156, r157), 0, 8);
            return;
        L80:
            if (TtsClientManager.f289879j == true) goto L84;
            if (r144 == true) goto L84;
            com.larus.media.model.a r158 = TtsClientManager.f289880k;
        L85:
            TtsClientManager.f289882m = r158;
        L84:
            r158 = TtsClientManager.f289881l;
            goto L85
        L75:
            r144 = false;
            goto L77
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(String r100, String r101, String r102, Map<String, String> r103, Function0<Unit> r104, Function1<? super String, Unit> r105, String r106, String r107) {
            this.f289887a = r100;
            this.f289888b = r101;
            this.f289889c = r102;
            this.f289890d = r103;
            this.f289891e = r104;
            this.f289892f = r105;
            this.f289893g = r106;
            this.f289894h = r107;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class f implements n68.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f289897a = null;

        static {
            f289897a = new f();
        }

        public f() {
        }

        @Override // n68.a
        public final void d(PlayStateEnum r100) {
        }

        @Override // n68.a
        public final void e(TtsErrorType r100) {
        }

        @Override // n68.a
        public final void c(PlayStateEnum r100) {
            if (r100 != PlayStateEnum.PLAY_STATE_STOPPED) goto L5;
        L6:
            FLogger r101 = FLogger.f375446a;
            TtsClientManager r102 = TtsClientManager.f289870a;
            r101.i("TtsClientManager", "addAudioPlayStateChangeCallback1: currentApplicant: " + TtsClientManager.f289882m);
            Lazy r103 = MediaResourceManager.f358950a;
            MediaResourceManager.a(TtsClientManager.f289882m);
            ObricTtsControlDelegate.f392839b.t();
            return;
        L5:
            if (r100 == PlayStateEnum.PLAY_STATE_FAIL) goto L6;
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

    public TtsClientManager() {
    }

    static {
        f289870a = new TtsClientManager();
        f289873d = "";
        f289875f = new ConcurrentHashMap();
        f289876g = TtsState.TTS_STOPPED;
        f289877h = new LruCache(15);
        f289878i = new f2a.d(ServiceType.AUDIO, "TtsClientManager");
        d r100 = new d();
        AccountService.f365697a.E(new a());
        if (z2.f365865a.ttsUseGainTransientFocusType() == false) goto L5;
        int r101 = 2;
    L6:
        com.larus.media.model.a r102 = new com.larus.media.model.a(null, MediaScene.IM_TTS, false, r101, 2, false, 0, false, false, 0, false, r100, 2021);
        f289880k = r102;
        f289881l = new com.larus.media.model.a(null, MediaScene.IM_TTS, false, 1, 2, false, 0, false, false, 0, false, r100, 2021);
        f289882m = r102;
        f289883n = new CopyOnWriteArraySet();
        return;
    L5:
        r101 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void v() {
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService r100 = IFlowTtsClientService.a.a();
        z2 r101 = z2.f365865a;
        r4 r102 = r101.U0().d();
        if (r102 == null) goto L5;
        long r103 = r102.a();
    L6:
        r100.y(new u78.a(r103));
        r100.j(r101.J());
        r100.s(r101.enableKmpTtsCancelTaskIdCheck());
        final m58.p r104 = m58.h.f512144o;
        if (r104 == null) goto L9;
        h r105 = new h(r104);
    L10:
        r100.o(r105);
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 60000;
        goto L6
    }

    @Override // com.larus.audio.d1
    public final boolean a() {
        IFlowTtsClientService.f288300a.getClass();
        return IFlowTtsClientService.a.a().a();
    }

    @Override // com.larus.audio.d1
    public final boolean g() {
        IFlowAsrClientService.f288298a.getClass();
        if (IFlowAsrClientService.a.a().t() != AsrClientStatus.STATE_TOUCH) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.audio.d1
    public final void k() {
        if (ObricAsrDelegate.f392831b.a() == false) goto L6;
        f289879j = true;
        return;
    }

    @Override // com.larus.audio.d1
    public final BotModel i() {
        return f289871b;
    }

    public static final com.larus.media.model.a m(boolean r100) {
        boolean r101 = ObricTtsControlDelegate.f392839b.o();
        if (r101 == false) goto L5;
        FLogger.f375446a.i("TtsClientManager", "[TTS] disable mix with external app by business policy");
    L5:
        if (r101 == true) goto L11;
        if (f289879j == true) goto L12;
        if (r100 == false) goto L11;
    L12:
        return f289881l;
    L11:
        return f289880k;
    }

    public static String n(String r100) {
        if (AppHost.f326268a.isOversea() == true) goto L5;
        return r100;
    L5:
        com.larus.bmhome.chat.api.e0 r101 = AuthModelDelegate.f297134b.e().getValue();
        boolean r102 = false;
        if (r101 == null) goto L10;
        LaunchInfo r103 = r101.f297186a;
        if (r103 == null) goto L10;
        boolean r104 = Intrinsics.areEqual(r103.i0(), Boolean.TRUE);
    L11:
        if (r104 == true) goto L13;
        return r100;
    L13:
        String r105 = com.larus.utils.b0.f375362a;
        AppLocaleUtils.f375332a.getClass();
        String r106 = com.larus.utils.b0.c(AppLocaleUtils.c());
        if (r106.length() != 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L40;
        return r100;
    L40:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L30
        if (r100 != null) goto L22;
        String r109 = "";
    L24:
        if (r109.length() != 0) goto L26;
        r102 = true;
    L26:
        if (r102 == false) goto L28;
        r109 = SliceInitService.DEFAULT_SWITCH;
    L28:
        Object r110 = Result.m9449constructorimpl(new JSONObject(r109).put(EffectConfiguration.KEY_APP_LANGUAGE, r106).toString());     // Catch: Throwable -> L30
    L32:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 != null) goto L35;
        Object r112 = r110;
    L38:
        return (String) r112;
    L35:
        FLogger.f375446a.e("TtsClientManager", "appendDolaAppLanguage error. e=" + r111);
        r112 = r100;
        if (AppHost.f326268a.isDebug() == false) goto L38;
        throw r111;
    L22:
        r109 = r100;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L16:
        r107 = false;
    L10:
        r104 = false;
        goto L11
    }

    public static boolean u(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return true;
    L11:
        final long r102 = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> r103 = f289875f;
        CollectionsKt.removeAll(r103.entrySet(), new i(r102));
        if (r103.putIfAbsent(r100, Long.valueOf(r102)) != null) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.larus.audio.d1
    public final void b(String r100) {
        f289872c = r100;
    }

    @Override // com.larus.audio.d1
    public final void f(SpeakerVoice r610) {
        if (r610 != null) goto L4;
        return;
    L4:
        f2a.c r100 = f289878i.b("updateChatBotVoice");
        r100.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
        Pair[] r101 = new Pair[3];
        f2a.f r102 = f2a.f.f475235e;
        BotModel r103 = f289871b;
        BotModel r104 = null;
        if (r103 == null) goto L7;
        String r105 = r103.getBotId();
    L8:
        String r106 = "";
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r101[0] = TuplesKt.to(r102, r105);
        f2a.f r107 = f2a.f.f475236f;
        BotModel r108 = f289871b;
        if (r108 == null) goto L14;
        String r109 = r108.getName();
    L15:
        if (r109 != null) goto L17;
        r109 = "";
    L17:
        r101[1] = TuplesKt.to(r107, r109);
        f2a.f r110 = f2a.f.f475240j;
        String r111 = r610.getStyleId();
        if (r111 == null) goto L21;
        r106 = r111;
    L21:
        r101[2] = TuplesKt.to(r110, r106);
        r100.d(MapsKt.mapOf(r101));
        f2a.c.c(r100, null, 15);
        BotModel r112 = f289871b;
        if (r112 == null) goto L24;
        r104 = BotModel.copy$default(r112, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r610, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -131073, Integer.MAX_VALUE, null);
    L24:
        f289871b = r104;
        return;
    L14:
        r109 = null;
        goto L15
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.larus.audio.d1
    public final void h(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LruCache<String, Message> r101 = f289877h;
        String r102 = r100.getMessageId();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.put(r102, r100);
    }

    @Override // com.larus.audio.d1
    public final void l(BotModel r100) {
        f289871b = r100;
        f2a.c r101 = f289878i.b("setChatBotInfo");
        r101.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
        Pair[] r102 = new Pair[3];
        f2a.f r103 = f2a.f.f475235e;
        if (r100 == null) goto L5;
        String r104 = r100.getBotId();
    L6:
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r102[0] = TuplesKt.to(r103, r104);
        f2a.f r106 = f2a.f.f475236f;
        if (r100 == null) goto L12;
        String r107 = r100.getName();
    L13:
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        r102[1] = TuplesKt.to(r106, r107);
        f2a.f r108 = f2a.f.f475240j;
        if (r100 == null) goto L20;
        SpeakerVoice r109 = r100.getVoiceType();
        if (r109 == null) goto L20;
        String r110 = r109.getStyleId();
    L21:
        if (r110 == null) goto L24;
        r105 = r110;
    L24:
        r102[2] = TuplesKt.to(r108, r105);
        r101.d(MapsKt.mapOf(r102));
        f2a.c.c(r101, null, 15);
        return;
    L20:
        r110 = null;
        goto L21
    L12:
        r107 = null;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public static Map o(Map r100, String r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return r100;
    L11:
        Message r104 = f289877h.get(r101);
        if (r104 == null) goto L33;
        if (r100 == null) goto L16;
        r100 = MapsKt.toMutableMap(r100);
        if (r100 == null) goto L16;
    L17:
        Map<String, String> r105 = r104.getExt();
        if (r105 == null) goto L20;
        String r106 = r105.get("edu_ext_for_tts");
    L21:
        if (r106 != null) goto L23;
        r106 = "";
    L23:
        r100.put("edu_ext_for_tts", r106);
        String r107 = com.larus.im.bean.message.a.D(r104);
        if (r107 != null) goto L26;
    L31:
        if (r102 == false) goto L33;
        r100.put("is_son_msg", "true");
        r100.put("parent_msg_id", com.larus.im.bean.message.a.D(r104));
        goto L33
    L26:
        if (r107.length() <= 0) goto L28;
        boolean r108 = true;
    L29:
        if (r108 != true) goto L31;
        r102 = true;
        goto L31
    L28:
        r108 = false;
        goto L29
    L20:
        r106 = null;
    L16:
        r100 = new LinkedHashMap();
    L33:
        return r100;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static String p(String r100, String r101) {
        if (r101 != null) goto L37;
        return r100;
    L37:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L28
        Message r103 = f289877h.get(r101);     // Catch: Throwable -> L28
        String r104 = null;
        if (r103 == null) goto L26;
        String r105 = "";
        if (r100 != null) goto L10;
        String r106 = "";
    L12:
        if (r106.length() != 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r106 = SliceInitService.DEFAULT_SWITCH;
    L17:
        JSONObject r108 = new JSONObject(r106);     // Catch: Throwable -> L28
        Map<String, String> r109 = r103.getExt();     // Catch: Throwable -> L28
        if (r109 == null) goto L21;
        r104 = r109.get("music_ext_for_tts");     // Catch: Throwable -> L28
    L21:
        if (r104 == null) goto L24;
        r105 = r104;
    L24:
        r108.put("music_ext_for_tts", r105);     // Catch: Throwable -> L28
        return r108.toString();
    L14:
        r107 = false;
        goto L15
    L10:
        r106 = r100;
        goto L12
    L26:
        Object r110 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L28
    L30:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 != null) goto L33;
        return r100;
    L33:
        FLogger.f375446a.e("TtsClientManager", "appendMessageInfoToExtra error. msg=" + r111);
        if (AppHost.f326268a.isDebug() == true) goto L36;
        return r100;
    L36:
        throw r111;
    L28:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public static String t(String r100, CacheConfig r101) {
        if (r101 == null) goto L21;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (StringsKt.isBlank(r100) == false) goto L6;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
    L7:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L9
        r104.putOpt(com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE, r101.getTextType());     // Catch: Throwable -> L9
        r104.putOpt("use_cache", r101.getUseCache());     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r103.putOpt("cache_config", r104);     // Catch: Throwable -> L9
        Object r106 = Result.m9449constructorimpl(r103.toString());     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == false) goto L14;
        r106 = null;
    L14:
        String r107 = (String) r106;
        if (r107 != null) goto L18;
        return r100;
    L18:
        return r107;
    L6:
        r103 = new JSONObject(r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L21:
        return r100;
    }

    @Override // com.larus.audio.d1
    public final void cancel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        IAIChatTtsPlayTraceService r102 = (IAIChatTtsPlayTraceService) ServiceManager.get().getService(IAIChatTtsPlayTraceService.class);
        if (r102 == null) goto L5;
        r102.a(r100);
    L5:
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().g(f289873d, r101, r100);
        FLogger.f375446a.i("TtsClientManager", "cancel: currentApplicant: " + f289882m + ", stopReason: " + r100 + ", isFromManual: " + r101);
        Lazy r103 = MediaResourceManager.f358950a;
        MediaResourceManager.a(f289882m);
        ObricTtsControlDelegate.f392839b.t();
    }

    public final synchronized boolean s(String r100, String r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (com.larus.utils.o0.d(r101) == false) goto L8;
        if (f289883n.contains(new b(r100, r101)) == false) goto L8;
        boolean r102 = true;
    L9:
        monitor-exit(this);
        return r102;
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.larus.audio.d1
    public final Object c(Map<String, String> r100, String r101, Continuation<? super Map<String, String>> r102) {
        return r(r100, r101, r102);
    }

    @Override // com.larus.audio.d1
    public final Object e(Map<String, String> r100, String r101, Continuation<? super Map<String, String>> r102) {
        return q(r100, r101, r102);
    }

    public final Object q(Map<String, String> r100, String r101, Continuation<? super Map<String, String>> r102) {
        if ((r102 instanceof TtsClientManager$appendQueryBotId$1) == false) goto L7;
        TtsClientManager$appendQueryBotId$1 r103 = (TtsClientManager$appendQueryBotId$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Map r108 = (Map) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L26:
        BotModel r109 = (BotModel) r105;
        String r110 = null;
        if (r109 == null) goto L29;
        String r111 = r109.getBotId();
    L31:
        if (com.larus.utils.o0.d(r111) == false) goto L37;
        if (r109 == null) goto L34;
        r110 = r109.getBotId();
    L34:
        if (r110 != null) goto L36;
        r110 = "";
    L36:
        r108.put("bot_id", r110);
    L37:
        return r108;
    L29:
        r111 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r108 = MapsKt.toMutableMap(r100);
        if (r101 != null) goto L17;
    L20:
        boolean r112 = true;
    L21:
        if (r112 == false) goto L23;
        return r108;
    L23:
        IBotRepoService r113 = RepoDispatcherDelegate.f307737b.b();
        r103.L$0 = r108;
        r103.label = 1;
        r105 = r113.j1(r101, false, r103);
        if (r105 != r106) goto L26;
        return r106;
    L17:
        if (StringsKt.isBlank(r101) == true) goto L20;
        r112 = false;
    L7:
        r103 = new TtsClientManager$appendQueryBotId$1(this, r102);
        goto L8
    }

    public final Object r(Map<String, String> r100, String r101, Continuation<? super Map<String, String>> r102) {
        if ((r102 instanceof TtsClientManager$appendQueryLocalMsgId$1) == false) goto L7;
        TtsClientManager$appendQueryLocalMsgId$1 r103 = (TtsClientManager$appendQueryLocalMsgId$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Map r108 = (Map) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L29:
        Message r109 = (Message) r105;
        if (r109 == null) goto L39;
        String r110 = r109.getLocalMessageId();
        String r111 = "";
        if (r110 != null) goto L34;
        r110 = "";
    L34:
        r108.put("query_local_message_id", r110);
        String r112 = r109.getSectionId();
        if (r112 == null) goto L38;
        r111 = r112;
    L38:
        r108.put("section_id", r111);
    L39:
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("[appendQueryLocalMsgId] localSendMsgId=");
        if (r109 == null) goto L42;
        String r115 = r109.getLocalMessageId();
    L43:
        r114.append(r115);
        r113.i("TtsClientManager", r114.toString());
        return r108;
    L42:
        r115 = null;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        Map r116 = MapsKt.toMutableMap(r100);
        if (r101 != null) goto L17;
        r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID);
    L17:
        if (r101 != null) goto L19;
    L22:
        boolean r117 = true;
    L23:
        if (r117 == false) goto L25;
        return r116;
    L25:
        IChatRepoService r118 = RepoDispatcherDelegate.f307737b.e();
        r103.L$0 = r116;
        r103.label = 1;
        Object r119 = r118.E1(r101, r103);
        if (r119 != r106) goto L28;
        return r106;
    L28:
        r105 = r119;
        r108 = r116;
        goto L29
    L19:
        if (r101.length() == 0) goto L22;
        r117 = false;
    L7:
        r103 = new TtsClientManager$appendQueryLocalMsgId$1(this, r102);
        goto L8
    }

    @Override // com.larus.audio.d1
    public final synchronized void d(String r210, String r211, String r310, boolean r311, Map<String, String> r312, boolean r313, p68.i r314, boolean r315, Function0<Unit> r316, Function1<? super String, Unit> r317, String r318, String r319) {
        String r110 = r210;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r316, TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Throwable -> L296
        Intrinsics.checkNotNullParameter(r317, "failed");     // Catch: Throwable -> L296
        f2a.d r100 = f289878i;     // Catch: Throwable -> L296
        f2a.c r101 = r100.b("[TTS] start by message");     // Catch: Throwable -> L296
        r101.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r102 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f.a r103 = f2a.f.f475232b;     // Catch: Throwable -> L296
        f2a.f r104 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L7;
        String r105 = "";
    L8:
        r102[0] = TuplesKt.to(r104, r105);     // Catch: Throwable -> L296
        f2a.f r106 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L11;
        String r107 = "";
    L12:
        r102[1] = TuplesKt.to(r106, r107);     // Catch: Throwable -> L296
        f2a.f r108 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L15;
        String r109 = "";
    L16:
        r102[2] = TuplesKt.to(r108, r109);     // Catch: Throwable -> L296
        r101.d(MapsKt.mapOf(r102));     // Catch: Throwable -> L296
        String r111 = null;
        f2a.c.c(r101, null, 15);     // Catch: Throwable -> L296
        if (r315 == true) goto L38;
        String r112 = f289872c;     // Catch: Throwable -> L296
        if (r112 == null) goto L38;
        if (Intrinsics.areEqual(r211, r112) == true) goto L38;
        f2a.c r113 = r100.a("[TTS][NOT_CURRENT_CONV] is not current conversation, skip tts");     // Catch: Throwable -> L296
        r113.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r114 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f r115 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L25;
        String r116 = "";
    L26:
        r114[0] = TuplesKt.to(r115, r116);     // Catch: Throwable -> L296
        f2a.f r117 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L29;
        String r118 = "";
    L30:
        r114[1] = TuplesKt.to(r117, r118);     // Catch: Throwable -> L296
        f2a.f r119 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L33;
        String r120 = "";
    L34:
        r114[2] = TuplesKt.to(r119, r120);     // Catch: Throwable -> L296
        r113.d(MapsKt.mapOf(r114));     // Catch: Throwable -> L296
        f2a.c.c(r113, null, 15);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L33:
        r120 = r318;
        goto L34
    L29:
        r118 = r310;
        goto L30
    L25:
        r116 = r211;
    L38:
        if (com.larus.audio.ainotes.a.f288325a.isRecording() == false) goto L55;
        f2a.c r121 = r100.a("[TTS][AI_NOTE_RECORDING] skip tts, ai note recording");     // Catch: Throwable -> L296
        r121.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r122 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f r123 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L42;
        String r124 = "";
    L43:
        r122[0] = TuplesKt.to(r123, r124);     // Catch: Throwable -> L296
        f2a.f r125 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L46;
        String r126 = "";
    L47:
        r122[1] = TuplesKt.to(r125, r126);     // Catch: Throwable -> L296
        f2a.f r127 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L50;
        String r128 = "";
    L51:
        r122[2] = TuplesKt.to(r127, r128);     // Catch: Throwable -> L296
        r121.d(MapsKt.mapOf(r122));     // Catch: Throwable -> L296
        f2a.c.c(r121, null, 15);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L50:
        r128 = r318;
        goto L51
    L46:
        r126 = r310;
        goto L47
    L42:
        r124 = r211;
        goto L43
    L55:
        if (f78.a.f475776a.b() == false) goto L78;
        IObricDoraService r129 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);     // Catch: Throwable -> L296
        if (r129 != null) goto L59;
    L61:
        boolean r130 = false;
    L62:
        if (r130 == true) goto L78;
        f2a.c r131 = r100.a("[TTS][DORA_IS_WAKE_UP] Dora is wake up, return");     // Catch: Throwable -> L296
        r131.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r132 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f r133 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L66;
        String r134 = "";
    L67:
        r132[0] = TuplesKt.to(r133, r134);     // Catch: Throwable -> L296
        f2a.f r135 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L70;
        String r136 = "";
    L71:
        r132[1] = TuplesKt.to(r135, r136);     // Catch: Throwable -> L296
        f2a.f r137 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L74;
        String r138 = "";
    L75:
        r132[2] = TuplesKt.to(r137, r138);     // Catch: Throwable -> L296
        r131.d(MapsKt.mapOf(r132));     // Catch: Throwable -> L296
        f2a.c.c(r131, null, 15);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L74:
        r138 = r318;
        goto L75
    L70:
        r136 = r310;
        goto L71
    L66:
        r134 = r211;
        goto L67
    L59:
        if (r129.t() != true) goto L61;
        r130 = true;
    L78:
        if (r313 == true) goto L119;
        g0.f289925a.getClass();     // Catch: Throwable -> L296
        if (g0.e(r211) == true) goto L99;
        f2a.c r139 = r100.a("[TTS][NOT_ALLOW] Tts not allow");     // Catch: Throwable -> L296
        r139.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r140 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f r141 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L84;
        String r142 = "";
    L85:
        r140[0] = TuplesKt.to(r141, r142);     // Catch: Throwable -> L296
        f2a.f r143 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L88;
        String r144 = "";
    L89:
        r140[1] = TuplesKt.to(r143, r144);     // Catch: Throwable -> L296
        f2a.f r145 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L92;
        String r146 = "";
    L93:
        r140[2] = TuplesKt.to(r145, r146);     // Catch: Throwable -> L296
        r139.d(MapsKt.mapOf(r140));     // Catch: Throwable -> L296
        f2a.c.c(r139, null, 15);     // Catch: Throwable -> L296
        x58.a r147 = m58.h.f512130a;     // Catch: Throwable -> L296
        m58.u r148 = m58.h.d();     // Catch: Throwable -> L296
        if (r148 == null) goto L96;
        m58.u.a.a(r148, r310, -1, "tts_not_allow");     // Catch: Throwable -> L296
    L96:
        monitor-exit(this);
        return;
    L92:
        r146 = r318;
        goto L93
    L88:
        r144 = r310;
        goto L89
    L84:
        r142 = r211;
        goto L85
    L99:
        if (s(r211, r310) == false) goto L119;
        f2a.c r149 = r100.b("[TTS][ALREADY_START] already start session, will start play tts");     // Catch: Throwable -> L296
        r149.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r150 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f r151 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L103;
        String r152 = "";
    L104:
        r150[0] = TuplesKt.to(r151, r152);     // Catch: Throwable -> L296
        f2a.f r153 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L107;
        String r154 = "";
    L108:
        r150[1] = TuplesKt.to(r153, r154);     // Catch: Throwable -> L296
        f2a.f r155 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L111;
        String r156 = "";
    L112:
        r150[2] = TuplesKt.to(r155, r156);     // Catch: Throwable -> L296
        r149.d(MapsKt.mapOf(r150));     // Catch: Throwable -> L296
        f2a.c.c(r149, null, 15);     // Catch: Throwable -> L296
        IFlowTtsClientService.f288300a.getClass();     // Catch: Throwable -> L296
        IFlowTtsClientService r157 = IFlowTtsClientService.a.a();     // Catch: Throwable -> L296
        if (r110 != null) goto L115;
        r110 = "";
    L115:
        r157.i(r110, r310);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L111:
        r156 = r318;
        goto L112
    L107:
        r154 = r310;
        goto L108
    L103:
        r152 = r211;
    L119:
        if (j0.a() == false) goto L299;
        f2a.c r158 = r100.a("[TTS][O_CALL PLAYING] O_CALL is playing, return");     // Catch: Throwable -> L296
        r158.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r159 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f r160 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L123;
        String r161 = "";
    L124:
        r159[0] = TuplesKt.to(r160, r161);     // Catch: Throwable -> L296
        f2a.f r162 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L127;
        String r163 = "";
    L128:
        r159[1] = TuplesKt.to(r162, r163);     // Catch: Throwable -> L296
        f2a.f r164 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L131;
        String r165 = "";
    L132:
        r159[2] = TuplesKt.to(r164, r165);     // Catch: Throwable -> L296
        r158.d(MapsKt.mapOf(r159));     // Catch: Throwable -> L296
        f2a.c.c(r158, null, 15);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L131:
        r165 = r318;
        goto L132
    L127:
        r163 = r310;
        goto L128
    L123:
        r161 = r211;
        goto L124
    L299:
        CopyOnWriteArraySet<b> r166 = f289883n;     // Catch: Exception -> L157 Throwable -> L296
        if ((r166 instanceof Collection) == true) goto L138;
    L140:
        Iterator<b> r167 = r166.iterator();     // Catch: Exception -> L157 Throwable -> L296
    L142:
        if (r167.hasNext() == false) goto L146;
        if (Intrinsics.areEqual(r167.next().a(), r211) == false) goto L142;
        boolean r168 = true;
    L147:
        if (r168 == true) goto L149;
    L162:
        ObricTtsControlDelegate r169 = ObricTtsControlDelegate.f392839b;     // Catch: Throwable -> L296
        if (r169.e() == false) goto L182;
        if (u(r310) == true) goto L182;
        f2a.c r170 = f289878i.b("[TTS][DEDUP_SKIP] same msgId within window, skip override mTaskId");     // Catch: Throwable -> L296
        r170.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r171 = new Pair[4];     // Catch: Throwable -> L296
        f2a.f.a r172 = f2a.f.f475232b;     // Catch: Throwable -> L296
        f2a.f r173 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L169;
        String r174 = "";
    L170:
        r171[0] = TuplesKt.to(r173, r174);     // Catch: Throwable -> L296
        f2a.f r175 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L173;
        String r176 = "";
    L174:
        r171[1] = TuplesKt.to(r175, r176);     // Catch: Throwable -> L296
        f2a.f r177 = f2a.f.a.c();     // Catch: Throwable -> L296
        if (r110 != null) goto L177;
        String r178 = "";
    L178:
        r171[2] = TuplesKt.to(r177, r178);     // Catch: Throwable -> L296
        r171[3] = TuplesKt.to(new f2a.f("cur_task_id"), f289873d);     // Catch: Throwable -> L296
        r170.d(MapsKt.mapOf(r171));     // Catch: Throwable -> L296
        f2a.c.c(r170, null, 15);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L177:
        r178 = r110;
        goto L178
    L173:
        r176 = r310;
        goto L174
    L169:
        r174 = r211;
    L182:
        if (r169.k() == true) goto L184;
    L189:
        IObricTtsControlService.a.a(r169, f289873d, r110);     // Catch: Throwable -> L296
        if (r110 != null) goto L192;
        String r179 = "";
    L193:
        f289873d = r179;     // Catch: Throwable -> L296
        String r180 = "";
        String r181 = "";
        String r182 = "";
        BotModel r183 = f289871b;     // Catch: Throwable -> L296
        if (r183 == null) goto L196;
        SpeakerVoice r184 = r183.getVoiceType();     // Catch: Throwable -> L296
    L197:
        if (r184 == null) goto L212;
        BotModel r185 = f289871b;     // Catch: Throwable -> L296
        if (r185 == null) goto L233;
        SpeakerVoice r186 = r185.getVoiceType();     // Catch: Throwable -> L296
        if (r186 == null) goto L233;
        r180 = r186.getStyleId();     // Catch: Throwable -> L296
        if (r180 != null) goto L205;
        r180 = "";
    L205:
        r181 = r186.getExtra();     // Catch: Throwable -> L296
        if (r181 != null) goto L208;
        r181 = "";
    L208:
        r182 = r186.getAudioMetrics();     // Catch: Throwable -> L296
        if (r182 != null) goto L233;
        r182 = "";
    L233:
        if (r314 != null) goto L235;
    L239:
        String r187 = r182;
        String r188 = r180;
    L241:
        if (r188.length() != 0) goto L243;
        boolean r189 = true;
    L244:
        if (r189 == false) goto L260;
        f2a.c r190 = f289878i.a("[TTS][NULL_SPEAKER] skip tts, speaker id is empty");     // Catch: Throwable -> L296
        r190.a(CollectionsKt.listOf("TtsPlay"));     // Catch: Throwable -> L296
        Pair[] r191 = new Pair[3];     // Catch: Throwable -> L296
        f2a.f.a r192 = f2a.f.f475232b;     // Catch: Throwable -> L296
        f2a.f r193 = f2a.f.a.a();     // Catch: Throwable -> L296
        if (r211 != null) goto L248;
        String r194 = "";
    L249:
        r191[0] = TuplesKt.to(r193, r194);     // Catch: Throwable -> L296
        f2a.f r195 = f2a.f.a.b();     // Catch: Throwable -> L296
        if (r310 != null) goto L252;
        String r196 = "";
    L253:
        r191[1] = TuplesKt.to(r195, r196);     // Catch: Throwable -> L296
        f2a.f r197 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L296
        if (r318 != null) goto L256;
        String r198 = "";
    L257:
        r191[2] = TuplesKt.to(r197, r198);     // Catch: Throwable -> L296
        r190.d(MapsKt.mapOf(r191));     // Catch: Throwable -> L296
        f2a.c.c(r190, null, 15);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L256:
        r198 = r318;
        goto L257
    L252:
        r196 = r310;
        goto L253
    L248:
        r194 = r211;
        goto L249
    L260:
        v();     // Catch: Throwable -> L296
        IObricDoraService r199 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);     // Catch: Throwable -> L296
        if (r199 != null) goto L263;
    L265:
        boolean r200 = false;
    L266:
        if (r200 == false) goto L270;
        IDoraWakeupService r201 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L296
        if (r201 == null) goto L270;
        r201.j(true);     // Catch: Throwable -> L296
    L270:
        IFlowTtsClientService.f288300a.getClass();     // Catch: Throwable -> L296
        IFlowTtsClientService r1100 = IFlowTtsClientService.a.a();     // Catch: Throwable -> L296
        String r1101 = f289873d;     // Catch: Throwable -> L296
        BotModel r202 = f289871b;     // Catch: Throwable -> L296
        if (r202 == null) goto L275;
        ModelItem r203 = r202.getModel();     // Catch: Throwable -> L296
        if (r203 == null) goto L275;
        r111 = r203.getName();     // Catch: Throwable -> L296
    L275:
        if (r111 != null) goto L277;
        String r1102 = "";
    L278:
        if (r313 == true) goto L283;
        g0.f289925a.getClass();     // Catch: Throwable -> L296
        if (g0.e(r211) == true) goto L283;
        boolean r212 = false;
    L284:
        Map r213 = o(r312, r310);     // Catch: Throwable -> L296
        String r214 = n(p(r181, r310));     // Catch: Throwable -> L296
        e r215 = new e(r211, r310, r318, r312, r316, r317, r319, r210);     // Catch: Throwable -> L296
        n78.a r204 = n78.a.f518209a;     // Catch: Throwable -> L296
        float r216 = r204.b();     // Catch: Throwable -> L296
        int r217 = r204.c();     // Catch: Throwable -> L296
        int r205 = r169.getBusinessType();     // Catch: Throwable -> L296
        x58.a r206 = m58.h.f512130a;     // Catch: Throwable -> L296
        m58.t r207 = m58.h.c();     // Catch: Throwable -> L296
        if (r207 != null) goto L287;
    L289:
        boolean r208 = false;
    L290:
        if (r208 == true) goto L292;
        boolean r218 = true;
    L293:
        r1100.u(r1101, r211, r310, r311, r188, r1102, r212, r213, r214, r215, r187, r216, r217, r315, r205, r218);     // Catch: Throwable -> L296
        com.larus.audio.tts.e.f289835a.m(f.f289897a);     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L292:
        r218 = false;
        goto L293
    L287:
        if (r207.e() != true) goto L289;
        r208 = true;
    L283:
        r212 = true;
        goto L284
    L277:
        r1102 = r111;
        goto L278
    L263:
        if (r199.t() != true) goto L265;
        r200 = true;
        goto L266
    L243:
        r189 = false;
        goto L244
    L235:
        if (com.larus.utils.o0.d(r314.c()) == false) goto L239;
        if (com.larus.utils.o0.d(r314.d()) == false) goto L239;
        String r209 = r314.c();     // Catch: Throwable -> L296
        r181 = r314.b();     // Catch: Throwable -> L296
        r188 = r209;
        r187 = r314.a();     // Catch: Throwable -> L296
        goto L241
    L212:
        if (FeatureKitDelegate.f295792b.w0().b() == false) goto L217;
        AudioUserConfig r1103 = AudioServiceDelegate.f288288a.p().getValue();     // Catch: Throwable -> L296
        if (r1103 == null) goto L222;
        List<SpeakerVoice> r1104 = r1103.getNewVoiceList();     // Catch: Throwable -> L296
    L216:
        List<SpeakerVoice> r219 = r1104;
    L223:
        if (r219 == null) goto L233;
        if ((!r219.isEmpty()) == false) goto L233;
        SpeakerVoice r220 = (SpeakerVoice) ListProtector.get(r219, 0);     // Catch: Throwable -> L296
        String r221 = r220.getStyleId();     // Catch: Throwable -> L296
        if (r221 != null) goto L229;
        r221 = "";
    L229:
        String r222 = r220.getExtra();     // Catch: Throwable -> L296
        if (r222 != null) goto L232;
        r222 = "";
    L232:
        r181 = r222;
        r180 = r221;
    L222:
        r219 = null;
        goto L223
    L217:
        com.larus.bmhome.chat.api.e0 r1105 = AuthModelDelegate.f297134b.e().getValue();     // Catch: Throwable -> L296
        if (r1105 == null) goto L222;
        LaunchInfo r1106 = r1105.b();     // Catch: Throwable -> L296
        if (r1106 == null) goto L222;
        r1104 = r1106.T0();     // Catch: Throwable -> L296
        goto L216
    L196:
        r184 = null;
        goto L197
    L192:
        r179 = r110;
        goto L193
    L184:
        if (r169.p() == false) goto L186;
        c68.b.d("TtsClientManager", "[TTS][System Call] skip intercept by ROM concurrent record optimize (startByMessage)");     // Catch: Throwable -> L296
        goto L189
    L186:
        c68.b.b("TtsClientManager", "[TTS][System Call] SystemCall Active, return");     // Catch: Throwable -> L296
        monitor-exit(this);
        return;
    L149:
        if (ObricTtsControlDelegate.f392839b.e() == false) goto L159;
        IFlowTtsClientService.f288300a.getClass();     // Catch: Exception -> L157 Throwable -> L296
        if (IFlowTtsClientService.a.a().m() == PlayStateEnum.PLAY_STATE_STOPPED) goto L162;
        if (f289874e == false) goto L162;
        c68.b.d("TtsClientManager", "[TTS][O_SKIP] current task is from startByText and playing, skip startByMessage");     // Catch: Exception -> L157 Throwable -> L296
        monitor-exit(this);
        return;
    L159:
        cancel("alreadyStartSessionSet conversationId", false);     // Catch: Exception -> L157 Throwable -> L296
    L146:
        r168 = false;
        goto L147
    L138:
        if (r166.isEmpty() == false) goto L140;
    L157:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);     // Catch: Throwable -> L296
        goto L162
    L15:
        r109 = r318;
        goto L16
    L11:
        r107 = r310;
        goto L12
    L7:
        r105 = r211;
    L296:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.d1
    public final synchronized void j(String r210, String r211, String r212, boolean r213, p68.i r214, String r215, CacheConfig r310, boolean r311, boolean r312, String r313, String r314, Map r315) {
        String r100 = r211;
        monitor-enter(this);
        List<SpeakerVoice> r101 = null;
        if (r312 == false) goto L186;
    L24:
        if (r213 == true) goto L44;
        g0.f289925a.getClass();     // Catch: Throwable -> L41
        if (g0.e(r211) == true) goto L44;
        f2a.c r102 = f289878i.a("[TTS][NOT_ALLOW] tts not allow");     // Catch: Throwable -> L41
        r102.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        Pair[] r103 = new Pair[3];     // Catch: Throwable -> L41
        f2a.f r104 = f2a.f.f475238h;     // Catch: Throwable -> L41
        if (r100 != null) goto L30;
        r100 = "";
    L30:
        r103[0] = TuplesKt.to(r104, r100);     // Catch: Throwable -> L41
        f2a.f r105 = f2a.f.f475239i;     // Catch: Throwable -> L41
        if (r215 != null) goto L33;
        String r106 = "";
    L34:
        r103[1] = TuplesKt.to(r105, r106);     // Catch: Throwable -> L41
        f2a.f r107 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L41
        if (r314 != null) goto L37;
        String r108 = "";
    L38:
        r103[2] = TuplesKt.to(r107, r108);     // Catch: Throwable -> L41
        r102.d(MapsKt.mapOf(r103));     // Catch: Throwable -> L41
        f2a.c.c(r102, null, 15);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L37:
        r108 = r314;
        goto L38
    L33:
        r106 = r215;
    L44:
        if (com.larus.audio.ainotes.a.f288325a.isRecording() == false) goto L60;
        f2a.c r109 = f289878i.a("[TTS][AI_NOTE_RECORDING] skip tts, ai note recording");     // Catch: Throwable -> L41
        r109.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        Pair[] r110 = new Pair[3];     // Catch: Throwable -> L41
        f2a.f r111 = f2a.f.f475238h;     // Catch: Throwable -> L41
        if (r100 != null) goto L48;
        r100 = "";
    L48:
        r110[0] = TuplesKt.to(r111, r100);     // Catch: Throwable -> L41
        f2a.f r112 = f2a.f.f475239i;     // Catch: Throwable -> L41
        if (r215 != null) goto L51;
        String r113 = "";
    L52:
        r110[1] = TuplesKt.to(r112, r113);     // Catch: Throwable -> L41
        f2a.f r114 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L41
        if (r314 != null) goto L55;
        String r115 = "";
    L56:
        r110[2] = TuplesKt.to(r114, r115);     // Catch: Throwable -> L41
        r109.d(MapsKt.mapOf(r110));     // Catch: Throwable -> L41
        f2a.c.c(r109, null, 15);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L55:
        r115 = r314;
        goto L56
    L51:
        r113 = r215;
        goto L52
    L60:
        if (f78.a.f475776a.b() == false) goto L85;
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L85;
        IDoraWakeupService r116 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L41
        if (r116 != null) goto L66;
    L68:
        boolean r117 = false;
    L69:
        if (r117 == false) goto L85;
        f2a.c r118 = f289878i.a("[TTS][DORA_IS_WAKE_UP] Dora is wake up, return");     // Catch: Throwable -> L41
        r118.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        Pair[] r119 = new Pair[3];     // Catch: Throwable -> L41
        f2a.f r120 = f2a.f.f475238h;     // Catch: Throwable -> L41
        if (r100 != null) goto L73;
        r100 = "";
    L73:
        r119[0] = TuplesKt.to(r120, r100);     // Catch: Throwable -> L41
        f2a.f r121 = f2a.f.f475239i;     // Catch: Throwable -> L41
        if (r215 != null) goto L76;
        String r122 = "";
    L77:
        r119[1] = TuplesKt.to(r121, r122);     // Catch: Throwable -> L41
        f2a.f r123 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L41
        if (r314 != null) goto L80;
        String r124 = "";
    L81:
        r119[2] = TuplesKt.to(r123, r124);     // Catch: Throwable -> L41
        r118.d(MapsKt.mapOf(r119));     // Catch: Throwable -> L41
        f2a.c.c(r118, null, 15);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L80:
        r124 = r314;
        goto L81
    L76:
        r122 = r215;
        goto L77
    L66:
        if (r116.g() != true) goto L68;
        r117 = true;
    L85:
        if (j0.a() == false) goto L100;
        f2a.c r125 = f289878i.a("[TTS][O_CALL PLAYING] O_CALL is playing, return");     // Catch: Throwable -> L41
        r125.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        Pair[] r126 = new Pair[3];     // Catch: Throwable -> L41
        f2a.f r127 = f2a.f.f475238h;     // Catch: Throwable -> L41
        if (r100 != null) goto L89;
        r100 = "";
    L89:
        r126[0] = TuplesKt.to(r127, r100);     // Catch: Throwable -> L41
        f2a.f r128 = f2a.f.f475239i;     // Catch: Throwable -> L41
        if (r215 != null) goto L92;
        String r129 = "";
    L93:
        r126[1] = TuplesKt.to(r128, r129);     // Catch: Throwable -> L41
        f2a.f r130 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L41
        if (r314 != null) goto L96;
        String r131 = "";
    L97:
        r126[2] = TuplesKt.to(r130, r131);     // Catch: Throwable -> L41
        r125.d(MapsKt.mapOf(r126));     // Catch: Throwable -> L41
        f2a.c.c(r125, null, 15);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L96:
        r131 = r314;
        goto L97
    L92:
        r129 = r215;
        goto L93
    L100:
        ObricTtsControlDelegate r132 = ObricTtsControlDelegate.f392839b;     // Catch: Throwable -> L41
        if (r132.e() == false) goto L117;
        IFlowTtsClientService.f288300a.getClass();     // Catch: Throwable -> L41
        PlayStateEnum r133 = IFlowTtsClientService.a.a().m();     // Catch: Throwable -> L41
        if (f289873d.length() <= 0) goto L105;
        boolean r134 = true;
    L106:
        if (r134 == false) goto L117;
        String r135 = f289873d;     // Catch: Throwable -> L41
        if (r210 != null) goto L110;
        String r136 = "";
    L112:
        if (Intrinsics.areEqual(r135, r136) == true) goto L117;
        if (r133 == PlayStateEnum.PLAY_STATE_STOPPED) goto L117;
        cancel("startByText replace", false);     // Catch: Throwable -> L41
        goto L117
    L110:
        r136 = r210;
        goto L112
    L105:
        r134 = false;
    L117:
        if (r132.k() == true) goto L119;
    L124:
        if (r210 != null) goto L126;
        String r137 = "";
    L127:
        f289873d = r137;     // Catch: Throwable -> L41
        f289874e = true;     // Catch: Throwable -> L41
        String r138 = "";
        String r139 = "";
        String r140 = "";
        BotModel r141 = f289871b;     // Catch: Throwable -> L41
        if (r141 == null) goto L130;
        SpeakerVoice r142 = r141.getVoiceType();     // Catch: Throwable -> L41
    L131:
        if (r142 == null) goto L146;
        BotModel r143 = f289871b;     // Catch: Throwable -> L41
        if (r143 == null) goto L165;
        SpeakerVoice r144 = r143.getVoiceType();     // Catch: Throwable -> L41
        if (r144 == null) goto L165;
        r138 = r144.getStyleId();     // Catch: Throwable -> L41
        if (r138 != null) goto L139;
        r138 = "";
    L139:
        r139 = r144.getExtra();     // Catch: Throwable -> L41
        if (r139 != null) goto L142;
        r139 = "";
    L142:
        r140 = r144.getAudioMetrics();     // Catch: Throwable -> L41
        if (r140 != null) goto L165;
        r140 = "";
    L165:
        if (r214 != null) goto L167;
    L171:
        String r145 = r138;
        String r146 = r140;
    L172:
        v();     // Catch: Throwable -> L41
        IFlowTtsClientService.f288300a.getClass();     // Catch: Throwable -> L41
        IFlowTtsClientService r147 = IFlowTtsClientService.a.a();     // Catch: Throwable -> L41
        String r148 = f289873d;     // Catch: Throwable -> L41
        String r149 = n(p(t(r139, r310), r215));     // Catch: Throwable -> L41
        Map<String, String> r150 = o(r315, r215);     // Catch: Throwable -> L41
        z r151 = new z(r211, r215, r314, r313, r210);     // Catch: Throwable -> L41
        n78.a r152 = n78.a.f518209a;     // Catch: Throwable -> L41
        float r153 = r152.b();     // Catch: Throwable -> L41
        int r216 = r152.c();     // Catch: Throwable -> L41
        int r217 = r132.getBusinessType();     // Catch: Throwable -> L41
        m58.t r154 = m58.h.f512142m;     // Catch: Throwable -> L41
        if (r154 != null) goto L175;
    L177:
        boolean r155 = false;
    L178:
        if (r155 == true) goto L180;
        boolean r218 = true;
    L181:
        r147.B(r148, r211, r212, r145, r215, r149, r150, r151, r146, r153, r216, r311, r217, r218);     // Catch: Throwable -> L41
        com.larus.audio.tts.e.f289835a.m(a0.f289912a);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L180:
        r218 = false;
        goto L181
    L175:
        if (r154.e() != true) goto L177;
        r155 = true;
        goto L178
    L167:
        if (com.larus.utils.o0.d(r214.f527933a) == false) goto L171;
        if (com.larus.utils.o0.d(r214.f527934b) == false) goto L171;
        String r156 = r214.f527933a;     // Catch: Throwable -> L41
        r139 = r214.f527936d;     // Catch: Throwable -> L41
        r146 = r214.f527937e;     // Catch: Throwable -> L41
        r145 = r156;
        goto L172
    L146:
        if (FeatureKitDelegate.f295792b.w0().b() == false) goto L150;
        AudioUserConfig r157 = AudioServiceDelegate.f288288a.p().getValue();     // Catch: Throwable -> L41
        if (r157 == null) goto L155;
        r101 = r157.getNewVoiceList();     // Catch: Throwable -> L41
    L155:
        if (r101 == null) goto L165;
        if ((!r101.isEmpty()) == false) goto L165;
        SpeakerVoice r158 = (SpeakerVoice) ListProtector.get(r101, 0);     // Catch: Throwable -> L41
        String r159 = r158.getStyleId();     // Catch: Throwable -> L41
        if (r159 != null) goto L161;
        r159 = "";
    L161:
        String r160 = r158.getExtra();     // Catch: Throwable -> L41
        if (r160 != null) goto L164;
        r160 = "";
    L164:
        r139 = r160;
        r138 = r159;
        goto L165
    L150:
        com.larus.bmhome.chat.api.e0 r161 = AuthModelDelegate.f297134b.e().getValue();     // Catch: Throwable -> L41
        if (r161 == null) goto L155;
        LaunchInfo r162 = r161.f297186a;     // Catch: Throwable -> L41
        if (r162 == null) goto L155;
        r101 = r162.T0();     // Catch: Throwable -> L41
        goto L155
    L130:
        r142 = null;
        goto L131
    L126:
        r137 = r210;
        goto L127
    L119:
        if (r132.p() == false) goto L121;
        c68.b.d("TtsClientManager", "[TTS][System Call] skip intercept by ROM concurrent record optimize (startByText)");     // Catch: Throwable -> L41
        goto L124
    L121:
        c68.b.b("TtsClientManager", "[TTS][System Call] SystemCall Active, return");     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L186:
        String r163 = f289872c;     // Catch: Throwable -> L41
        if (r163 == null) goto L24;
        if (Intrinsics.areEqual(r100, r163) == true) goto L24;
        f2a.c r164 = f289878i.a("[TTS][NOT_CURRENT_CONV] is not current conversation, skip tts");     // Catch: Throwable -> L41
        r164.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        Pair[] r165 = new Pair[3];     // Catch: Throwable -> L41
        f2a.f r166 = f2a.f.f475238h;     // Catch: Throwable -> L41
        if (r100 != null) goto L13;
        r100 = "";
    L13:
        r165[0] = TuplesKt.to(r166, r100);     // Catch: Throwable -> L41
        f2a.f r167 = f2a.f.f475239i;     // Catch: Throwable -> L41
        if (r215 != null) goto L16;
        String r168 = "";
    L17:
        r165[1] = TuplesKt.to(r167, r168);     // Catch: Throwable -> L41
        f2a.f r169 = new f2a.f("start_read_message_reason");     // Catch: Throwable -> L41
        if (r314 != null) goto L20;
        String r170 = "";
    L21:
        r165[2] = TuplesKt.to(r169, r170);     // Catch: Throwable -> L41
        r164.d(MapsKt.mapOf(r165));     // Catch: Throwable -> L41
        f2a.c.c(r164, null, 15);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L20:
        r170 = r314;
        goto L21
    L16:
        r168 = r215;
    L41:
        th = move-exception;
        throw th;
    }
}
