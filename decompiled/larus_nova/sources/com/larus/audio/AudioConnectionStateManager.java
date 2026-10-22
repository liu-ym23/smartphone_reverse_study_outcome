package com.larus.audio;

import android.os.Build;
import androidx.lifecycle.LiveData;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow_audio.api.config.session.FlowAudioSessionRequestType;
import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.audio.audiov3.connection.ISamiConnectionPool;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import com.larus.bmhome.auth.Config;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.audio.AudioConnectionPoolConfig;
import com.larus.platform.model.audio.AudioSyncCallConfig;
import com.larus.platform.model.audio.CloseAudioConnectionAppBackgroundConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioConnectionStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AudioConnectionStateManager f288277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f288278b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f288279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f288280d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f288281e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f288282f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f288283g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f288284h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<IAudioService.a> f288285i = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            AudioConnectionStateManager.f288277a.getClass();
            if (AudioConnectionStateManager.d() == false) goto L8;
            IFlowTtsClientService.f288300a.getClass();
            PlayStateEnum r100 = IFlowTtsClientService.a.a().m();
            FLogger.f375446a.i("AudioConnectionStateManager", "onAppBackground playerState=" + r100);
            if (r100 == PlayStateEnum.PLAY_STATE_PLAYING) goto L9;
            AudioConnectionStateManager.h("onAppBackground");
            return;
        L9:
            return;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            AudioConnectionStateManager.f288277a.getClass();
            if (AudioConnectionStateManager.d() == false) goto L6;
            FLogger.f375446a.i("AudioConnectionStateManager", "onAppForeground");
            AudioConnectionStateManager.i("onAppForeground");
            return;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b implements com.larus.platform.api.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f288286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f288287b;

        @Override // com.larus.platform.api.y
        public final boolean a() {
            return false;
        }

        public b(String r100, String r101) {
            this.f288286a = r100;
            this.f288287b = r101;
        }

        @Override // com.larus.platform.api.y
        public final void onGetId(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r102, "ssid");
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("init audio again: did=");
            if (r100.length() != 0) goto L5;
            boolean r105 = true;
        L6:
            r104.append(r105);
            r103.i("AudioConnectionStateManager", r104.toString());
            AudioConnectionStateManager r106 = AudioConnectionStateManager.f288277a;
            String r107 = this.f288286a;
            String r108 = this.f288287b;
            r106.getClass();
            AudioConnectionStateManager.b(r107, r108, r100);
            if (z2.f365865a.isFixSamiRequestNoDid() == false) goto L10;
            com.larus.utils.t0.a(new p());
            return;
        L10:
            return;
        L5:
            r105 = false;
            goto L6
        }
    }

    public AudioConnectionStateManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.audio.o] */
    static {
        f288277a = new AudioConnectionStateManager();
        Lazy r100 = LazyKt.lazy(new k());
        f288280d = r100;
        Lazy r101 = LazyKt.lazy(new l());
        f288281e = r101;
        Lazy r102 = LazyKt.lazy(new m());
        f288282f = r102;
        f288283g = new AtomicBoolean(false);
        f288284h = LazyKt.lazy(new n());
        f288285i = new LinkedHashSet();
        FLogger.f375446a.i("AudioConnectionStateManager", "init appBackgroundListener isCloseAudioConnAppBackground=" + ((Boolean) r100.getValue()).booleanValue() + " isCloseAudioConnAppBackgroundOnlyForD=" + ((Boolean) r101.getValue()).booleanValue() + " closeAudioConnectionAppBackgroundConfig=" + GsonProtectorUtils.toJson(new Gson(), (CloseAudioConnectionAppBackgroundConfig) r102.getValue()));
        f288278b = new a();
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().c(new o());
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L7;
        com.larus.home.impl.sdk.s r104 = r103.s0();
        if (r104 == null) goto L7;
        r104.f(u.f289968a);
    L7:
        AccountService r105 = AccountService.f365697a;
        r105.H(new v());
        r105.E(new r());
    }

    public static boolean d() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r101 = false;
        if (r100 == null) goto L7;
        com.larus.home.impl.sdk.s r102 = r100.s0();
        if (r102 == null) goto L7;
        boolean r103 = Intrinsics.areEqual(r102.D(), Boolean.TRUE);
    L8:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("isRealCloseAudioConnAppBackground isCloseAudioConnAppBackground=");
        Lazy r106 = f288280d;
        r105.append(((Boolean) r106.getValue()).booleanValue());
        r105.append(" isCloseAudioConnAppBackgroundOnlyForD=");
        Lazy r107 = f288281e;
        r105.append(((Boolean) r107.getValue()).booleanValue());
        r105.append(" closeAudioConnectionAppBackgroundConfig=");
        Gson r108 = new Gson();
        Lazy r109 = f288282f;
        r105.append(GsonProtectorUtils.toJson(r108, (CloseAudioConnectionAppBackgroundConfig) r109.getValue()));
        r105.append(" hasDoraDevice=");
        r105.append(r103);
        r105.append(" shouldCloseOnBackground=");
        r105.append(f288279c);
        r104.i("AudioConnectionStateManager", r105.toString());
        Boolean r110 = f288279c;
        if (r110 == null) goto L12;
        return r110.booleanValue();
    L12:
        if (((Boolean) r106.getValue()).booleanValue() == false) goto L14;
    L39:
        r101 = true;
    L41:
        return r101;
    L14:
        if (((Boolean) r107.getValue()).booleanValue() == false) goto L17;
        if (r103 == true) goto L39;
    L17:
        if (((CloseAudioConnectionAppBackgroundConfig) r109.getValue()).isEnabled() == false) goto L41;
        if (r103 == false) goto L41;
        if (Build.MANUFACTURER != null) goto L22;
        boolean r111 = false;
    L38:
        if (r111 == false) goto L41;
    L22:
        List<String> r112 = ((CloseAudioConnectionAppBackgroundConfig) r109.getValue()).getDeviceManufacturerBlockList();
        if (r112 == null) goto L30;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L26:
        if (r114.hasNext() == false) goto L31;
        Object r115 = r114.next();
        if (StringsKt.equals((String) r115, Build.MANUFACTURER, true) == false) goto L26;
        r113.add(r115);
    L31:
        if (r113 != null) goto L33;
    L36:
        boolean r116 = true;
    L37:
        r111 = !r116;
        goto L38
    L33:
        if (r113.isEmpty() == true) goto L36;
        r116 = false;
        goto L37
    L30:
        r113 = null;
    L7:
        r103 = false;
        goto L8
    }

    public static void f() {
        x58.a r100 = m58.h.f512130a;
        ((ISamiConnectionPool) ServiceManager.get().getService(ISamiConnectionPool.class)).a();
        if (z2.f365865a.isThreadSleepBugFixEnable() == false) goto L5;
        com.larus.utils.t0.b(new i(), 1000);
        return;
    L5:
        Thread.sleep(1000);
        g();
    }

    public static void g() {
        z2 r100 = z2.f365865a;
        if (r100.enableKmpAsr() == false) goto L5;
    L8:
        x58.a r101 = m58.h.f512130a;
        boolean r102 = false;
        if (r101 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L17;
        FLogger.f375446a.i("AudioConnectionStateManager", "skip KMP Assistant Task pre-connect: connection pool disabled");
        return;
    L17:
        i0.f289764a.getClass();
        x58.a r104 = m58.h.f512130a;
        if (r104 != null) goto L21;
    L24:
        qw5.a r105 = null;
    L26:
        if (r105 != null) goto L41;
        FLogger.f375446a.e("AudioConnectionStateManager", "skip KMP Assistant Task pre-connect: audio config not ready");
        return;
    L41:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L35
        pd6.b r107 = pd6.c.f528682a;     // Catch: Throwable -> L35
        ww5.a r108 = (ww5.a) pd6.c.a(Reflection.getOrCreateKotlinClass(ww5.a.class));     // Catch: Throwable -> L35
        if (r108 != null) goto L32;
        FLogger.f375446a.e("AudioConnectionStateManager", "skip KMP Assistant Task pre-connect: IFlowAudioService unavailable");     // Catch: Throwable -> L35
    L33:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L43;
        FLogger.f375446a.e("AudioConnectionStateManager", "KMP Assistant Task pre-connect failed: " + r110.getMessage());
        return;
    L43:
        return;
    L32:
        r108.F2(r105);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L21:
        if (r104.f562527a.length() != 0) goto L23;
        r102 = true;
    L23:
        if (r102 == true) goto L24;
        FlowAudioAssistantScene r112 = FlowAudioAssistantScene.Im;
        r105 = new qw5.a("kmp_audio_pre_connect", "", FlowAudioSessionRequestType.Unknown, null, r112, r112.getBusiness(), "", i0.b(r104, "kmp_audio_pre_connect"), null, null, null, "", 5888);
        goto L26
    L11:
        if (r101.f562544r != true) goto L13;
        r103 = true;
        goto L14
    L5:
        if (r100.enableKmpTts() == true) goto L8;
        FLogger.f375446a.i("AudioConnectionStateManager", "skip KMP Assistant Task pre-connect: KMP ASR/TTS disabled");
    }

    public static final void a(AudioConnectionStateManager r100) {
        r100.getClass();
        IAuthModelService r101 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r101 == null) goto L9;
        LiveData<LaunchInfo> r102 = r101.x();
        if (r102 == null) goto L9;
        LaunchInfo r103 = r102.getValue();
        if (r103 == null) goto L9;
        Config r104 = r103.D();
    L11:
        if (r104 != null) goto L13;
        FLogger.f375446a.e("AudioConnectionStateManager", "init config or samiAppKey is null, " + r104);
        return;
    L13:
        AccountService r105 = AccountService.f365697a;
        String r106 = "";
        if (r105.isEnterpriseAccount() == false) goto L18;
        String r107 = r104.a();
        if (r107 != null) goto L22;
    L20:
        r107 = "";
    L22:
        if (r107.length() != 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L27;
        FLogger.f375446a.e("AudioConnectionStateManager", "init config or samiAppKey is null, " + r104 + ", isEnterpriseAccount=" + r105.isEnterpriseAccount());
        return;
    L27:
        String r109 = com.larus.platform.service.o.f365780a.getDeviceId();
        String r110 = r104.k();
        if (r110 == null) goto L31;
        r106 = r110;
    L31:
        b(r107, r106, r109);
        return;
    L24:
        r108 = false;
        goto L25
    L18:
        r107 = r104.j();
        if (r107 != null) goto L22;
    L9:
        r104 = null;
        goto L11
    }

    public static void e(boolean r100) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioConnectionStateManager$resetAudioConnection$1(r100, null), 3, null);
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i("AudioConnectionStateManager", "tryDisconnect. Reason: " + r100);
        Set<IAudioService.a> r101 = f288285i;
        if ((!r101.isEmpty()) == false) goto L12;
        Iterator<IAudioService.a> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        IAudioService.a r103 = r102.next();
        if (r103.a(r100) == true) goto L6;
        FLogger r104 = FLogger.f375446a;
        r103.name();
        r104.i("AudioConnectionStateManager", "tryDisconnect blocked by interceptor: obric-audio-monitor");
        return;
    L12:
        if (f288283g.compareAndSet(false, true) == true) goto L15;
        FLogger.f375446a.i("AudioConnectionStateManager", "No need to disconnect");
        return;
    L15:
        com.larus.utils.t0.a(new h(new g()));
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger r101 = FLogger.f375446a;
        r101.i("AudioConnectionStateManager", "tryReconnect. Reason: " + r100);
        boolean r102 = true;
        if (f288283g.compareAndSet(true, false) == true) goto L6;
        r101.i("AudioConnectionStateManager", "No need to reconnect");
        return;
    L6:
        IAuthModelService r103 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r103 == null) goto L13;
        LiveData<LaunchInfo> r104 = r103.x();
        if (r104 == null) goto L13;
        LaunchInfo r105 = r104.getValue();
        if (r105 == null) goto L13;
        Config r106 = r105.D();
    L15:
        if (r106 != null) goto L18;
        r101.e("AudioConnectionStateManager", "init config or samiAppKey is null, " + r106);
        return;
    L18:
        AccountService r107 = AccountService.f365697a;
        String r108 = "";
        if (r107.isEnterpriseAccount() == false) goto L23;
        String r109 = r106.a();
        if (r109 != null) goto L27;
    L25:
        r109 = "";
    L27:
        if (r109.length() == 0) goto L30;
        r102 = false;
    L30:
        if (r102 == false) goto L33;
        r101.e("AudioConnectionStateManager", "init config or samiAppKey is null, " + r106 + ", isEnterpriseAccount=" + r107.isEnterpriseAccount());
        return;
    L33:
        String r110 = r106.k();
        if (r110 == null) goto L37;
        r108 = r110;
    L37:
        c(r109, r108);
        return;
    L23:
        r109 = r106.j();
        if (r109 != null) goto L27;
    L13:
        r106 = null;
        goto L15
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r101, "appToken");
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        String r103 = r102.getDeviceId();
        b(r100, r101, r103);
        boolean r104 = false;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L10;
        FLogger.f375446a.i("AudioConnectionStateManager", "init audio fail, did is empty");
        r102.e(new b(r100, r101));
    L10:
        if (z2.f365865a.isFixSamiRequestNoDid() == true) goto L12;
    L15:
        com.larus.utils.t0.a(new p());
    L16:
        FLogger.f375446a.i("AudioConnectionStateManager", "initAudioConnection, connect_pool: " + ((AudioConnectionPoolConfig) f288284h.getValue()).isEnabled());
        return;
    L12:
        if (r103.length() <= 0) goto L14;
        r104 = true;
    L14:
        if (r104 == false) goto L16;
    L5:
        r105 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.audio.j] */
    public static void b(String r210, String r211, String r310) {
        boolean r100 = VoiceCallServiceDelegate.f377087a.q("connect_pool", "im", true);
        x58.a r101 = m58.h.f512130a;
        JSONObject r102 = new JSONObject();
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("initAudioConfig isMinorMode=");
        AccountService r105 = AccountService.f365697a;
        r104.append(r105.a());
        r103.i("AudioConnectionStateManager", r104.toString());
        if (r105.a() == false) goto L5;
        r102.put("minor-mode", "1");
    L5:
        Unit r106 = Unit.INSTANCE;
        String r107 = m58.h.b(true, r102, 2);
        String r110 = r105.getUserId();
        AppHost.Companion r108 = AppHost.f326268a;
        String r111 = r108.getVersionName();
        int r112 = r108.getUpdateVersionCode();
        z2 r109 = z2.f365865a;
        Integer r113 = r109.p1().getSamiBusinessId();
        String r114 = u1.f289969a.d(r210);
        lq9.e r115 = r109.V2().getData();
        if (r115 == null) goto L8;
        boolean r116 = r115.a();
    L9:
        lq9.e r117 = r109.V2().getData();
        if (r117 == null) goto L12;
        int r118 = r117.c();
    L13:
        lq9.e r119 = r109.V2().getData();
        if (r119 == null) goto L19;
        int[] r120 = r119.b();
        if (r120 == null) goto L19;
        int[] r121 = r120;
    L20:
        AudioRetransmitStrategy r122 = new AudioRetransmitStrategy(new t78.a(r116, r118, r121));
        int r123 = r109.samiConnectTimeout();
        Lazy r124 = com.larus.audio.utils.i0.f290053a;
        StringBuilder r125 = new StringBuilder("isEnableSyncAsrTts config=");
        Lazy r126 = com.larus.audio.utils.i0.f290053a;
        r125.append(((AudioSyncCallConfig) r126.getValue()).isEnableSyncAsrTts());
        r103.i("AudioSyncCallConfigUtils", r125.toString());
        boolean r127 = ((AudioSyncCallConfig) r126.getValue()).isEnableSyncAsrTts();
        boolean r212 = u1.f289973e;
        if (r109.enableAudioConnectionPoolConfig().isEnabled() == false) goto L24;
        if (r100 == true) goto L24;
        boolean r213 = true;
    L26:
        if (r109.G3() == false) goto L31;
        if (r100 == true) goto L31;
        if (r105.isEnterpriseAccount() == true) goto L31;
        boolean r214 = true;
    L32:
        boolean r215 = r109.connectionCreateBeforeUseEnable();
        boolean r216 = r109.audioConnectionPoolRecreateEnable();
        x58.a r128 = new x58.a(r210, r211, r107, r110, r310, r111, r112, null, r113, r114, r123, r122, r127, r212, new j(), null, r213, r214, r215, r216, 82048);
        Intrinsics.checkNotNullParameter(r128, "samiCommonConfig");
        m58.h.f512130a = r128;
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService.a.a().w(r128);
        AtomicBoolean r129 = x1.f290171a;
        r109.w3();
        if (x1.f290171a.compareAndSet(false, true) == false) goto L37;
        com.larus.utils.t0.a(new v1());
        return;
    L37:
        return;
    L31:
        r214 = false;
    L24:
        r213 = false;
    L19:
        r121 = new int[]{300, 600, 900, 1200, 1500};
        goto L20
    L12:
        r118 = 6000;
        goto L13
    L8:
        r116 = false;
        goto L9
    }
}
