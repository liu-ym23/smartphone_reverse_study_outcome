package com.larus.audio.repo;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.audio.RtcEngineInitManager;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.audio.bean.ConversationCellIcon;
import com.larus.audio.bean.ConversationCellIconConfig;
import com.larus.audio.p0;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.network.NetworkQualityType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.k;
import com.larus.platform.model.audio.AudioFeedbackFrequencyConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import d78.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m58.h;
import m58.q;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioConfigRepo implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AudioConfigRepo f289781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f289782b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Keva f289783c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData<AudioUserConfig> f289784d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutableLiveData f289785e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MutableLiveData<ConversationCellIconConfig> f289786f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MutableLiveData f289787g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f289788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f289789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f289790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f289791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f289792l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final RtcEngineInitManager f289793m = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            AudioConfigRepo r101 = AudioConfigRepo.f289781a;
            AudioConfigRepo.g();
            AudioConfigRepo.h();
            Intrinsics.checkNotNullParameter("login", "callFrom");
            VoiceCallServiceDelegate.f377087a.w("login");
            AudioConfigRepo.j("onLogIn");
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            AudioConfigRepo r101 = AudioConfigRepo.f289781a;
            AudioConfigRepo.h();
            AudioConfigRepo.j("onLogOut");
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public b() {
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f289794a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f289795a = null;

            static {
                int[] r100 = new int[NetworkQualityType.values().length];
                r100[NetworkQualityType.NO_NET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[NetworkQualityType.WEAK_NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[NetworkQualityType.NORMAL_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f289795a = r100;
            }
        }

        public c() {
            if (NetConnectionTypeProvider.a(NetConnectionTypeProvider.f360084a) != NetworkQualityType.NO_NET) goto L5;
            boolean r100 = true;
        L6:
            this.f289794a = r100;
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // com.larus.network.k
        public final void a(NetworkQualityType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            int r101 = a.f289795a[r100.ordinal()];
            if (r101 != 1) goto L5;
            FLogger.f375446a.i("AudioConfigRepo", "[networkQualityChanged] disconnected");
            this.f289794a = true;
            return;
        L5:
            if (r101 != 2) goto L7;
            return;
        L7:
            if (r101 != 3) goto L12;
            if (this.f289794a == false) goto L16;
            FLogger.f375446a.i("AudioConfigRepo", "[networkQualityChanged] fromDisconnection");
            AudioConfigRepo.f289793m.l("network_recovered");
            this.f289794a = false;
            return;
        L16:
            return;
        L12:
            throw new NoWhenBranchMatchedException();
        }
    }

    public AudioConfigRepo() {
    }

    @Override // com.larus.audio.p0
    public final boolean i() {
        if (D(true) == false) goto L5;
        return false;
    L5:
        int r100 = z2.f365865a.getRedDotShowLimitDays();
        if (r100 > 0) goto L8;
        return true;
    L8:
        Keva r101 = f289782b;
        StringBuilder r102 = new StringBuilder("key_red_dot_expired");
        AccountService r103 = AccountService.f365697a;
        r102.append(r103.getUserId().hashCode());
        if (r101.getBoolean(r102.toString(), false) == false) goto L11;
        return false;
    L11:
        long r104 = r101.getLong("key_first_show_red_dot_time" + r103.getUserId().hashCode(), 0);
        if (r104 > 0) goto L15;
        return true;
    L15:
        if ((System.currentTimeMillis() - r104) < (((long) r100) * 86400000)) goto L18;
        r101.storeBoolean("key_red_dot_expired" + r103.getUserId().hashCode(), true);
        return false;
    L18:
        return true;
    }

    static {
        f289781a = new AudioConfigRepo();
        AccountService r100 = AccountService.f365697a;
        f289782b = Keva.getRepo("sami_asr_env_".concat(r100.getSecUserId()), 0);
        f289783c = (Keva) m78.c.f512358b.getValue();
        MutableLiveData<AudioUserConfig> r101 = new MutableLiveData();
        f289784d = r101;
        f289785e = r101;
        MutableLiveData<ConversationCellIconConfig> r102 = new MutableLiveData();
        f289786f = r102;
        f289787g = r102;
        f289792l = LazyKt.lazy(new com.larus.audio.repo.a());
        f289793m = new RtcEngineInitManager();
        c r103 = new c();
        r100.E(new a());
        t0.f375469b.post(new com.larus.audio.repo.b());
        NetConnectionTypeProvider.f360087d.addIfAbsent(r103);
    }

    public static AudioFeedbackFrequencyConfig e() {
        return (AudioFeedbackFrequencyConfig) f289792l.getValue();
    }

    public static void h() {
        boolean r100 = AppHost.f326268a.isOversea();
        boolean r101 = z2.f365865a.a1();
        if (r100 == true) goto L5;
        if (r101 == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioConfigRepo$requestAudioConfig$1(null), 3, null);
    }

    @Override // com.larus.audio.p0
    public final int A() {
        q r100 = h.f512133d;
        if (r100 == null) goto L7;
        ASRModule r101 = r100.c();
        if (r101 == null) goto L7;
        return r101.p();
    L7:
        return -1;
    }

    @Override // com.larus.audio.p0
    public final boolean a() {
        return z2.f365865a.a();
    }

    @Override // com.larus.audio.p0
    public final int b() {
        return z2.f365865a.realtimeMaxAliveDuration();
    }

    @Override // com.larus.audio.p0
    public final boolean c() {
        q r100 = h.f512133d;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = z2.f365865a.j0();
    L8:
        if (r101 == true) goto L11;
        return false;
    L11:
        q r102 = h.f512133d;
        if (r102 == null) goto L17;
        ASRModule r103 = r102.c();
        if (r103 == null) goto L17;
        return r103.q();
    L17:
        return z2.f365865a.c();
    L5:
        if (r100.c() == null) goto L7;
        r101 = com.larus.business.debug.base.audio.module.d.a();
        goto L8
    }

    @Override // com.larus.audio.p0
    public final boolean m() {
        return f289782b.getBoolean("key_realtime_called_libra_enable", false);
    }

    @Override // com.larus.audio.p0
    public final void t() {
        FLogger.f375446a.i("AudioConfigRepo", "[displayTtsFeedback] noFeedbackTimes:" + f289788h + ", displayCount:" + f289789i);
        int r100 = f289789i + 1;
        f289789i = r100;
        f289788h = f289788h + 1;
        if (r100 != e().getTtsMaxDisplayTimes()) goto L6;
        long r101 = System.currentTimeMillis();
        f289790j = r101;
        f289783c.storeLong("key_first_display_time", r101);
    L6:
        if (f289788h != e().getTtsNoFeedbackTimes()) goto L8;
        long r102 = System.currentTimeMillis();
        f289791k = r102;
        f289783c.storeLong("key_last_display_time", r102);
    L8:
        Keva r103 = f289783c;
        r103.storeInt("key_total_display_count", f289788h);
        r103.storeInt("key_tts_display_count", f289789i);
    }

    @Override // com.larus.audio.p0
    public final boolean v() {
        FLogger r100 = FLogger.f375446a;
        r100.i("AudioConfigRepo", "[isAllowShowTtsFeedback] noFeedbackTimes:" + f289788h + ", displayCount:" + f289789i);
        if (f289788h != e().getTtsNoFeedbackTimes()) goto L10;
        if (System.currentTimeMillis() >= (f289791k + ((long) ((((e().getTtsNoPopupDays() * 24) * 60) * 60) * 1000)))) goto L8;
        r100.i("AudioConfigRepo", "[isAllowShowTtsFeedback] 1. abandon");
        return false;
    L8:
        f289788h = 0;
        f289789i = 0;
        Keva r101 = f289783c;
        r101.storeInt("key_total_display_count", 0);
        r101.storeInt("key_tts_display_count", f289789i);
    L10:
        if (f289789i == e().getTtsMaxDisplayTimes()) goto L12;
        return true;
    L12:
        if (System.currentTimeMillis() >= (f289790j + ((long) ((((e().getTtsIntervalDays() * 24) * 60) * 60) * 1000)))) goto L15;
        r100.i("AudioConfigRepo", "[isAllowShowTtsFeedback] 2. abandon");
        return false;
    L15:
        f289789i = 0;
        f289783c.storeInt("key_tts_display_count", 0);
        return true;
    }

    @Override // com.larus.audio.p0
    public final void x() {
        FLogger.f375446a.i("AudioConfigRepo", "[submitFeedback] noFeedbackTimes:" + f289788h + ", displayCount:" + f289789i);
        f289788h = 0;
        f289783c.storeInt("key_total_display_count", 0);
    }

    @Override // com.larus.audio.p0
    public final void y() {
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == true) goto L5;
        return;
    L5:
        String r101 = "key_first_show_red_dot_time" + r100.getUserId().hashCode();
        Keva r102 = f289782b;
        if (r102.getLong(r101, 0) > 0) goto L9;
        r102.storeLong(r101, System.currentTimeMillis());
        return;
    }

    @Override // com.larus.audio.p0
    public final boolean z() {
        RtcEngineInitManager r100 = f289793m;
        d78.d r101 = r100.f288310f;
        if (r101 == null) goto L7;
        Boolean r102 = r101.c();
        if (r102 == null) goto L7;
    L16:
        return r102.booleanValue();
    L7:
        d78.d r103 = (d78.d) r100.f288311g.getValue();
        if (r103 == null) goto L10;
        Boolean r104 = r103.c();
    L11:
        r102 = r104;
        if (r102 != null) goto L16;
        return false;
    L10:
        r104 = null;
        goto L11
    }

    public static void g() {
        Pair<String, String> r100 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b());
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(r100.first, r100.second);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioConfigRepo$loadAudioUserSettingIfNeed$1(r101, null), 3, null);
    }

    @Override // com.larus.audio.p0
    public final String C() {
        if (HttpExtKt.e().f360168c == false) goto L6;
        String r100 = HttpExtKt.e().f360169d;
    L9:
        if (r100 != null) goto L11;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == false) goto L19;
        return "rtcAgent_stream_is_new_arch";
    L19:
        return "rtcAgent_" + r100 + "_stream_is_new_arch";
    L11:
        if (StringsKt.isBlank(r100) == true) goto L14;
        r101 = false;
        goto L15
    L6:
        if (HttpExtKt.e().f360166a == false) goto L8;
        r100 = HttpExtKt.e().f360167b;
        goto L9
    L8:
        r100 = null;
        goto L9
    }

    @Override // com.larus.audio.p0
    public final MutableLiveData p() {
        return f289785e;
    }

    @Override // com.larus.audio.p0
    public final MutableLiveData s() {
        return f289787g;
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "streamApp");
        RtcEngineInitManager r101 = f289793m;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        if (StringsKt.isBlank(r100) == true) goto L64;
        d78.d r102 = r101.f288310f;
        boolean r103 = true;
        if (r102 == null) goto L27;
        List<e> r104 = r102.b();
        if (r104 == null) goto L27;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        e r107 = (e) r106;
        if (r107 == null) goto L15;
        String r108 = r107.a();
    L17:
        if (Intrinsics.areEqual(r108, r100) == false) goto L11;
    L20:
        e r109 = (e) r106;
        if (r109 == null) goto L27;
        String r110 = r109.b();
        if (r110 == null) goto L27;
        if ((!StringsKt.isBlank(r110)) == false) goto L27;
    L28:
        if (r110 != null) goto L30;
    L33:
        if (r103 == false) goto L60;
        d78.d r111 = (d78.d) r101.f288311g.getValue();
        if (r111 == null) goto L61;
        List<e> r112 = r111.b();
        if (r112 == null) goto L62;
        Iterator<T> r113 = r112.iterator();
    L41:
        if (r113.hasNext() == false) goto L49;
        Object r114 = r113.next();
        e r115 = (e) r114;
        if (r115 == null) goto L45;
        String r116 = r115.a();
    L47:
        if (Intrinsics.areEqual(r116, r100) == false) goto L41;
    L50:
        e r117 = (e) r114;
        if (r117 != null) goto L53;
        return null;
    L53:
        return r117.b();
    L45:
        r116 = null;
        goto L47
    L49:
        r114 = null;
        goto L50
    L62:
        return null;
    L61:
        return null;
    L60:
        return r110;
    L30:
        if (StringsKt.isBlank(r110) == true) goto L33;
        r103 = false;
        goto L33
    L15:
        r108 = null;
        goto L17
    L19:
        r106 = null;
    L27:
        r110 = null;
        goto L28
    L64:
        return null;
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        if (z2.f365865a.a1() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioConfigRepo$requestPGCVoiceList$1(r100, null), 3, null);
    }

    public static void k(AudioUserConfig r100) {
        f289783c.storeString("key_audio_user_config_string", new Gson().toJson(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.e("AudioConfigRepo", "[saveConfig] error: " + e.getMessage());
    }

    @Override // com.larus.audio.p0
    public final boolean B(boolean r100) {
        Intrinsics.checkNotNullParameter("voice_call", "scene");
        Intrinsics.checkNotNullParameter(PickerReporterConstants.VALUE.CLICK.NAVIGATION_BAR, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return VoiceCallServiceDelegate.f377087a.q("voice_call", PickerReporterConstants.VALUE.CLICK.NAVIGATION_BAR, r100);
    }

    @Override // com.larus.audio.p0
    public final boolean D(boolean r100) {
        return f289782b.getBoolean("key_realtime_called", r100);
    }

    @Override // com.larus.audio.p0
    public final boolean n(BotModel r100) {
        if (r100 != null) goto L7;
        FLogger.f375446a.e("AudioConfigRepo", "[realtimeCallBotEnabled] botModel is null");
        return false;
    L7:
        if (f(r100, r100.getTagList()) == null) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.larus.audio.p0
    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        f289793m.l(r100);
    }

    @Override // com.larus.audio.p0
    public final void w(boolean r100) {
        f289782b.storeBoolean("key_realtime_called", r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.audio.p0
    public final ShowTagInfo f(BotModel r110, List<ShowTagInfo> r111) {
        Object r100 = null;
        if (r110 == null) goto L5;
        String r101 = r110.getBotId();
    L6:
        List<ShowTagInfo> r102 = r111;
        boolean r103 = true;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L62;
        if (r101 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L62;
        if (AppHost.f326268a.isOversea() == true) goto L29;
        z2 r106 = z2.f365865a;
        if (r106.a1() == true) goto L29;
        boolean r107 = r106.getHitCallDirectEnable();
    L35:
        if (r107 == true) goto L38;
        FLogger.f375446a.i("AudioConfigRepo", "[findRealtimeCallBotTagInfo_" + r101 + "] enableCallBot:false");
        return null;
    L38:
        IVoiceCallService r108 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r108 == null) goto L41;
        boolean r112 = r108.r(r110, "", false);
    L42:
        if (r112 == true) goto L45;
        FLogger.f375446a.e("AudioConfigRepo", "[findRealtimeCallBotTagInfo_" + r101 + "] realtimeCallEnable:false");
        return null;
    L45:
        Iterator<T> r113 = r111.iterator();
    L47:
        if (r113.hasNext() == false) goto L56;
        Object r114 = r113.next();
        ShowTagInfo r109 = (ShowTagInfo) r114;
        if (r109.getType() == 4) goto L51;
    L53:
        boolean r115 = false;
    L54:
        if (r115 == false) goto L47;
        r100 = r114;
        goto L56
    L51:
        if (r109.getPosition() != 2) goto L53;
        r115 = true;
    L56:
        ShowTagInfo r116 = (ShowTagInfo) r100;
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("[findRealtimeCallBotTagInfo_");
        r118.append(r101);
        r118.append("] matched=");
        if (r116 != null) goto L60;
        r103 = false;
    L60:
        r118.append(r103);
        r117.i("AudioConfigRepo", r118.toString());
        return r116;
    L41:
        r112 = false;
    L29:
        AudioUserConfig r119 = (AudioUserConfig) f289785e.getValue();
        if (r119 != null) goto L32;
    L34:
        r107 = false;
        goto L35
    L32:
        if (r119.getSupportRealtimeCallBot() != true) goto L34;
        r107 = true;
        goto L35
    L17:
        if (r101.length() == 0) goto L20;
        r105 = false;
    L62:
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("[findRealtimeCallBotTagInfo_");
        r121.append(r101);
        r121.append("] tagListEmpty=");
        if (r102 != null) goto L65;
    L68:
        boolean r122 = true;
    L69:
        r121.append(r122);
        r121.append(", botIdEmpty=");
        if (r101 != null) goto L72;
    L75:
        r121.append(r103);
        r120.i("AudioConfigRepo", r121.toString());
        return null;
    L72:
        if (r101.length() == 0) goto L75;
        r103 = false;
        goto L75
    L65:
        if (r102.isEmpty() == true) goto L68;
        r122 = false;
        goto L69
    L9:
        if (r102.isEmpty() == true) goto L12;
        r104 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.audio.p0
    public final ConversationCellIcon q(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        ConversationCellIconConfig r100 = (ConversationCellIconConfig) f289787g.getValue();
        if (r100 == null) goto L37;
        List<ConversationCellIcon> r101 = r100.getCellIconList();
        if (r101 == null) goto L38;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L27;
        Object r103 = r102.next();
        ConversationCellIcon r104 = (ConversationCellIcon) r103;
        boolean r105 = Intrinsics.areEqual(r104.getEnableBotId(), r110);
        boolean r106 = true;
        if (ArraysKt.contains(new Integer[]{1, 2}, Integer.valueOf(r111)) == true) goto L12;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r105 == false) goto L24;
        if (r108 == false) goto L24;
    L25:
        if (r106 == false) goto L8;
    L28:
        ConversationCellIcon r109 = (ConversationCellIcon) r103;
        if (r109 == null) goto L39;
        FLogger.f375446a.i("AudioConfigRepo", "[cellIconConfig] found, result=" + r109);
        return r109;
    L39:
        return null;
    L24:
        r106 = false;
        goto L25
    L17:
        if (r104.getEnabledInSubConversation() == true) goto L20;
        r108 = false;
        goto L21
    L12:
        if (r111 == 4) goto L14;
        r107 = true;
        goto L15
    L27:
        r103 = null;
        goto L28
    L38:
        return null;
    L37:
        return null;
    }

    @Override // com.larus.audio.p0
    public final Object u(String r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof AudioConfigRepo$realtimeCallBotEnabled$1) == false) goto L7;
        AudioConfigRepo$realtimeCallBotEnabled$1 r101 = (AudioConfigRepo$realtimeCallBotEnabled$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AudioConfigRepo$realtimeCallBotEnabled$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L28:
        return Boxing.boxBoolean(n((BotModel) r111));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r100 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == true) goto L23;
        IBotRepoService r107 = RepoDispatcherDelegate.f307737b.b();
        r103.label = 1;
        r111 = IBotRepoService.b.a(r107, r100, false, null, false, r103, 30);
        if (r111 != r104) goto L28;
        return r104;
    L23:
        return Boxing.boxBoolean(false);
    L17:
        if (r100.length() == 0) goto L20;
        r106 = false;
    L7:
        r101 = new AudioConfigRepo$realtimeCallBotEnabled$1(this, r110);
        goto L8
    }

    @Override // com.larus.audio.p0
    public final boolean o(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return VoiceCallServiceDelegate.f377087a.o(r100, r101, r102);
    }
}
