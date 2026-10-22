package po2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.player.utils.PlayerRequestHelper;
import com.bytedance.android.livesdk.player.LivePlayerService;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.model.PlayerDnsOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerLivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerApi;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVqosLogger;
import com.bytedance.android.livesdkapi.roomplayer.PlayerHttpResponse;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.optimizer.live.sdk.dns.strategy.PlayerParamConfig;
import ita.k;
import java.io.File;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements com.bytedance.android.live.room.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xkc.f f530039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f530040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ILivePlayerVqosLogger f530041c;

    /* JADX INFO: renamed from: po2.a$a, reason: collision with other inner class name */
    public static final class C7217a implements xkc.e {
        public C7217a() {
        }

        @Override // xkc.e
        public final <T> T getAppInfoForKey(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r101, "defaultValue");
            if (Intrinsics.areEqual(r100, "TTNet_NQE_INFO") == false) goto L11;
            String r102 = f.a().toString();
            if ((r102 instanceof Object) == true) goto L7;
            r102 = null;
        L7:
            if (r102 != null) goto L10;
            return r101;
        L10:
            return (T) r102;
        L11:
            ILivePlayerHostService r103 = LivePlayerService.INSTANCE.hostService();
            if (r103 == null) goto L19;
            T r104 = (T) r103.getSettingsValueForKey(r100, r101);
            if (r104 != null) goto L17;
            return r101;
        L17:
            return r104;
        L19:
            return r101;
        }
    }

    public static final class b extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public b() {
        }
    }

    public static final class c implements vkc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f530042a;

        public c(Map r100) {
            this.f530042a = r100;
        }

        @Override // vkc.b
        public final String executeGet(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            PlayerRequestHelper.a r101 = PlayerRequestHelper.a(r100, this.f530042a);
            if (r101 == null) goto L8;
            PlayerHttpResponse r102 = (PlayerHttpResponse) r101.execute();
            if (r102 == null) goto L8;
            byte[] r103 = r102.getBody();
            if (r103 == null) goto L8;
        L10:
            return new String(r103, Charsets.UTF_8);
        L8:
            r103 = new byte[0];
            goto L10
        }

        @Override // vkc.b
        public final String a(String r100, byte[] r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(DownloadHelper.GZIP, "contentEncoding");
            Intrinsics.checkNotNullParameter("application/json; charset=utf-8", "contentType");
            Map<String, String> r102 = this.f530042a;
            ILivePlayerApi r103 = (ILivePlayerApi) PlayerRequestHelper.f85845a.getValue();
            if (r103 == null) goto L8;
            Call<TypedInput> r104 = r103.post(r100, new TypedByteArray("application/json; charset=utf-8", r101, new String[0]), r102);
            if (r104 == null) goto L8;
            PlayerRequestHelper.a r105 = new PlayerRequestHelper.a(r104);
        L9:
            if (r105 == null) goto L14;
            PlayerHttpResponse r106 = (PlayerHttpResponse) r105.execute();
            if (r106 == null) goto L14;
            byte[] r107 = r106.getBody();
            if (r107 == null) goto L14;
        L16:
            return new String(r107, Charsets.UTF_8);
        L14:
            r107 = new byte[0];
        L8:
            r105 = null;
            goto L9
        }
    }

    public static void d() {
        com.bytedance.android.live.player.utils.b.b("start init dns optimizer");
        b r100 = new b();
        LivePlayerService r101 = LivePlayerService.INSTANCE;
        PlayerLivePlayerConfig r102 = (PlayerLivePlayerConfig) r101.getConfig(PlayerLivePlayerConfig.class);
        int r103 = r100.launchType();
        boolean r104 = Boolean.valueOf(r100.markAsNewUser()).equals(Boolean.TRUE);
        StringBuilder r105 = new StringBuilder("s=");
        r105.append(String.valueOf(r103));
        r105.append(";t=");
        int r106 = 0;
        r105.append(String.valueOf(0));
        r105.append(";n=");
        r105.append(String.valueOf(r104 ? 1 : 0));
        r105.append(";p=1");
        Map r107 = MapsKt.mapOf(new Pair(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, r105.toString()));
        vkc.c.a r108 = new vkc.c.a();
        r108.f555569a = Constants.PATHS.HOST_PSEUDO_CODE;
        ILivePlayerHostService r109 = r101.hostService();
        if (r109 == null) goto L5;
        r109.updateVersionCode();
    L5:
        r108.f555571c = r102.getTfoPreConnect();
        r108.f555572d = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_retry_interval", Integer.valueOf(r102.getDnsRequestRetryInterval())), TuplesKt.to("request_max_retry_times", Integer.valueOf(r102.getDnsRequestMaxRetryTimes()))});
        r108.f555570b = new c(r107);
        vkc.d.b().a(new vkc.c(r108));
        ILivePlayerHostService r110 = r101.hostService();
        if (r110 == null) goto L8;
        Context r111 = r110.context();
    L9:
        xkc.a r112 = new xkc.a(r111);
        r112.f564388a = new C7217a();
        if (PlayerParamConfig.f457012f == null) goto L12;
    L21:
        PlayerParamConfig.f457012f.f457013a = r112.f564388a;
        PlayerParamConfig r113 = PlayerParamConfig.a();
        xkc.e r114 = r113.f457013a;
        if (r114 == null) goto L24;
        r113.f457016d = ((Integer) r114.getAppInfoForKey("min_start_play_buffer", 600)).intValue();
        r113.f457017e = ((Integer) r113.f457013a.getAppInfoForKey("max_start_play_buffer", 1000)).intValue();
        ((Double) r113.f457013a.getAppInfoForKey("attenuation_coefficient", Double.valueOf(0.1d))).doubleValue();
        ((Integer) r113.f457013a.getAppInfoForKey("attenuation_time_offset", 1000)).intValue();
    L24:
        double r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r116 = 0.0d;
    L25:
        int[] r117 = r113.f457014b;
        if (r106 >= r117.length) goto L28;
        r116 = r116 + Math.cbrt(8 - r117[r106]);
        r106 = r106 + 1;
        goto L25
    L28:
        int r118 = r113.f457017e;
        int r119 = r113.f457016d;
        int r120 = r118 - r119;
        int r121 = 1;
    L29:
        int[] r122 = r113.f457014b;
        if (r121 >= r122.length) goto L33;
        double r123 = r115 + Math.cbrt(8 - r122[r121]);
        int r124 = (int) (((double) r113.f457016d) + ((r123 / r116) * ((double) r120)));
        r113.f457015c.put(Integer.valueOf(r113.f457014b[r121 - 1]), new android.util.Pair(Integer.valueOf(r119), Integer.valueOf(r124)));
        r121 = r121 + 1;
        r119 = r124;
        r115 = r123;
        goto L29
    L33:
        if (r121 != r122.length) goto L35;
        boolean r125 = true;
        r113.f457015c.put(Integer.valueOf(r113.f457014b[r121 - 1]), new android.util.Pair(Integer.valueOf(r119), Integer.valueOf(r113.f457017e)));
    L36:
        LivePlayerService.INSTANCE.dnsOptimizer().a(r112);
        r112.f564395h = r125;
        Context r126 = r112.f564391d;
        xkc.a.b r127 = r112.f564392e;
        IntentFilter r128 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L61:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L67;
        ReceiverRegisterCrashOptimizer.registerReceiver(r127, r128);
    L65:
        vkc.d.b().f555576c.a();
        com.bytedance.android.live.player.utils.b.b("init dns optimizer success");
        return;
    L67:
        throw e;
    L40:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L52;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r128) == false) goto L52;
        int r129 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r127, r128, 0, null, null, 2, r126).result;     // Catch: Exception -> L61
        if (r129 == 1) goto L50;
        if (r129 != 2) goto L47;
        new Intent();     // Catch: Exception -> L61
        goto L65
    L47:
        if (r129 == 3) goto L65;
        r126.registerReceiver(r127, r128);     // Catch: Exception -> L61
        goto L65
    L50:
        r126.registerReceiver(r127, r128);     // Catch: Exception -> L61
    L52:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L55;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L61
        r126.registerReceiver(r127, r128, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L61
        goto L65
    L55:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L57;
    L59:
        r126.registerReceiver(r127, r128);     // Catch: Exception -> L61
        goto L65
    L57:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r128) == false) goto L59;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L61
        ContextCompat.registerReceiver(r126, r127, r128, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L61
        goto L65
    L35:
        r125 = true;
        goto L36
    L12:
        monitor-enter(PlayerParamConfig.class);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (PlayerParamConfig.f457012f != null) goto L16;
        PlayerParamConfig.f457012f = new PlayerParamConfig();     // Catch: Throwable -> L18
    L16:
        monitor-exit(PlayerParamConfig.class);     // Catch: Throwable -> L18
        goto L21
    L8:
        r111 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.room.e
    public final void b() {
        LivePlayerService r100 = LivePlayerService.INSTANCE;
        ILivePlayerHostService r101 = r100.hostService();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.enableLiveIO() != true) goto L37;
        com.bytedance.android.live.player.utils.b.b("init liveIo");
        com.ss.videoarch.live.b r102 = com.ss.videoarch.live.b.f.f458578a;
        po2.b r103 = new po2.b(this);
        r102.getClass();
        com.ss.videoarch.live.b.f458553w = r103;
        rmc.c.f538620a = new po2.c();
        ILivePlayerHostService r104 = r100.hostService();
        if (r104 == null) goto L38;
        Context r105 = r104.context();     // Catch: Exception -> L33
        if (r105 == null) goto L15;
        File r106 = r105.getExternalCacheDir();     // Catch: Exception -> L33
        if (r106 == null) goto L15;
        String r107 = r106.getAbsolutePath();     // Catch: Exception -> L33
    L16:
        int r108 = r104.appId();
        String r109 = r104.appLogServerDeviceID();
        ILivePlayerHostService r110 = LivePlayerService.INSTANCE.hostService();
        if (r110 == null) goto L19;
        float r111 = r110.deviceScore();
    L20:
        com.ss.videoarch.live.b r112 = com.ss.videoarch.live.b.f.f458578a;
        Context r113 = r104.context();
        d r114 = new d();
        r112.getClass();
        if (r113 == null) goto L31;
        com.ss.videoarch.live.b.f458554x = r113;
        r112.f458557c = ((Integer) r114.getSettingsValueForKey("liveio_load_so_interval", 5000)).intValue();
        r112.f458559e = ((Integer) r114.getSettingsValueForKey("liveio_load_so_maxcount", 10)).intValue();
        r112.f458567m = ((Integer) r114.getSettingsValueForKey("liveio_get_sysinfo_interval", 0)).intValue();
        r112.f458568n = ((Integer) r114.getSettingsValueForKey("liveio_use_least_thread", 0)).intValue();
        r112.f458569o = ((Integer) r114.getSettingsValueForKey("check_before_load_quic_so", 0)).intValue();
        r112.f458570p = ((Integer) r114.getSettingsValueForKey("liveio_network_monitor", 1)).intValue();
        JSONObject r115 = new JSONObject();
        r115.put("app_info", "{\"device_id\":\"" + r109 + "\",\"app_id\":" + r108 + ",\"device_score\":" + r111 + i.f25855d);
        r115.put("cache_dir", r107);
        r112.f458563i = r114;
        r115.put("commom_container_conf", r114.getSettingsValueForKey("commom_container_conf", SliceInitService.DEFAULT_SWITCH));
        r115.put("http_container_conf", r114.getSettingsValueForKey("http_container_conf", SliceInitService.DEFAULT_SWITCH));
        r115.put("connect_pool_container_conf", r114.getSettingsValueForKey("connect_pool_container_conf", SliceInitService.DEFAULT_SWITCH));
        r115.put("pcdn_container_conf", r114.getSettingsValueForKey("pcdn_container_conf", SliceInitService.DEFAULT_SWITCH));
        r115.put("preconnect_container_conf", r114.getSettingsValueForKey("preconnect_container_conf", SliceInitService.DEFAULT_SWITCH));
        r115.put("ttquic_engine_config", r114.getSettingsValueForKey("ttquic_engine_config", SliceInitService.DEFAULT_SWITCH));
        r115.put("liveio_use_least_thread", r114.getSettingsValueForKey("liveio_use_least_thread", 0));
        String r116 = (String) r114.getSettingsValueForKey("io_lib_name", "avio");
        if (r116.endsWith(".so") == true) goto L25;
        r116 = String.format("lib%s.so", new Object[]{r116});
    L25:
        r115.put("io_lib_name", r116);
        r112.f458562h = r115.toString();
        if (r112.f458565k != null) goto L29;
        PthreadHandlerThreadV2 r117 = new PthreadHandlerThreadV2("startliveio");
        r112.f458565k = r117;
        ThreadMethodProxy.start(r117);
    L29:
        if (r112.f458564j != null) goto L31;
        com.ss.videoarch.live.b.h r118 = new com.ss.videoarch.live.b.h(r112, r112.f458565k.getLooper());
        r112.f458564j = r118;
        r118.sendEmptyMessage(1025);
    L31:
        com.bytedance.android.live.player.utils.b.b("start liveIo");
        return;
    L19:
        r111 = 1.0f;
    L15:
        r107 = null;
        goto L16
    L38:
        return;
    }

    @Override // com.bytedance.android.live.room.e
    public final void sync() {
        ILivePlayerHostService r100 = LivePlayerService.INSTANCE.hostService();     // Catch: Throwable -> L10
        if (r100 == null) goto L5;
        Context r101 = r100.context();     // Catch: Throwable -> L10
    L7:
        if (k.i(r101) == true) goto L12;
        com.bytedance.android.live.player.utils.b.b("init DnsOptimizer error! must init in main process!");     // Catch: Throwable -> L10
        return;
    L12:
        LivePlayerService r102 = LivePlayerService.INSTANCE;
        ILivePlayerHostService r103 = r102.hostService();
        if (r103 != null) goto L15;
        return;
    L15:
        PlayerDnsOptimizeConfig r104 = (PlayerDnsOptimizeConfig) r102.getConfig(PlayerDnsOptimizeConfig.class);
        if (r104.getEnable() == true) goto L20;
        com.bytedance.android.live.player.utils.b.b("dns optimizer disable");
        return;
    L20:
        if (r103.isFreeFlow() == false) goto L26;
        if (r104.getFreeFlowEnable() == true) goto L26;
        if (NetworkUtils.isWifi(r103.context()) == true) goto L26;
        return;
    L26:
        if (r102.dnsOptimizer().c() != null) goto L35;
        long r105 = r103.dnsDelayLoadTime("video_live_qos_v2_ipSettings");
        if (r105 == 0) goto L30;
        this.f530040b.postDelayed(new e(this), r105);
        return;
    L30:
        d();
        return;
    L35:
        return;
    L5:
        r101 = null;
    L10:
        th = move-exception;
        com.bytedance.android.live.player.utils.b.b(ArraysKt.joinToString$default(th.getStackTrace(), null, null, null, 0, null, null, 63, null));
        goto L12
    }

    public a() {
        this.f530040b = new Handler(Looper.getMainLooper());
        this.f530041c = LivePlayerService.INSTANCE.vqosLogger();
        com.bytedance.android.live.player.utils.b.b("instance DnsOptimizerImpl");
    }

    @Override // com.bytedance.android.live.room.e
    public final xkc.f c() {
        return this.f530039a;
    }

    @Override // com.bytedance.android.live.room.e
    public final void a(xkc.a r100) {
        this.f530039a = r100;
    }
}
