package com.obric.assistant.zeus.plugin;

import android.app.KeyguardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.assistant.t1;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.download.DownloadPolicy;
import com.volcengine.zeus.download.PluginDownloadBean;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements DownloadPolicy, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f395036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f395037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f395038c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, Boolean> f395039d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile List<String> f395040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f395041f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f395042g = null;

    public c() {
    }

    static {
        c r100 = new c();
        f395036a = r100;
        f395038c = new ConcurrentHashMap();
        f395039d = new LruCache(16);
        f395040e = CollectionsKt.emptyList();
        f395041f = new ConcurrentHashMap();
        f395042g = new Handler(Looper.getMainLooper(), r100);
    }

    public static void b(String r100) {
        Handler r101 = f395042g;
        r101.removeMessages(1001, r100);
        Message r102 = Message.obtain();
        r102.what = 1001;
        r102.obj = r100;
        Long r103 = Long.valueOf(t1.f393353a.getObricZeusAutoFetchConfig().getAutoFetchTimeIntervalMillis());
        if (r103.longValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L11;
        long r105 = r103.longValue();
    L12:
        r101.sendMessageDelayed(r102, r105);
        return;
    L11:
        r105 = 3600000;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        List r101 = CollectionsKt.distinct(f395040e);
        if (r101.isEmpty() == false) goto L6;
        FLogger.f375446a.i("ZeusAutoFetchManager", "triggerFetchForAll skipped: no auto fetch plugin. reason=" + r100);
        return;
    L6:
        FLogger.f375446a.i("ZeusAutoFetchManager", "triggerFetchForAll: reason=" + r100 + ", plugins=" + r101);
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        a((String) r102.next(), r100);
        goto L8
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final Map<String, String> getCustomTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        AppHost.Companion r101 = AppHost.f326268a;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("version_code", String.valueOf(r101.getVersionCode())), TuplesKt.to("update_version_code", String.valueOf(r101.getUpdateVersionCode())), TuplesKt.to("short_os_version", t9a.b.b().b().b()), TuplesKt.to("os_build_date", String.valueOf(t9a.b.b().b().c())), TuplesKt.to("obric_fwk_api_version", String.valueOf(t9a.b.b().b().h())), TuplesKt.to("os_device_id", String.valueOf(t9a.b.b().b().a()))});
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 1001) goto L12;
        Object r101 = r100.obj;
        if ((r101 instanceof String) == false) goto L7;
        String r102 = (String) r101;
    L8:
        if (r102 != null) goto L10;
        return false;
    L10:
        FLogger.f375446a.d("ZeusAutoFetchManager", "handleMessage: check auto fetch triggered for ".concat(r102));
        a(r102, "auto_fetch_timer");
        b(r102);
        return true;
    L7:
        r102 = null;
        goto L8
    L12:
        return false;
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final void updateLastRequestTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        f395038c.put(r100, Long.valueOf(SystemClock.uptimeMillis()));
        long r102 = System.currentTimeMillis();
        ((Keva) e.f395044a.getValue()).storeLong("last_success_request_time_millis", r102);
        FLogger.f375446a.i("ZeusAutoFetchManager", "update last success request time: plugin=" + r100 + ", lastSuccessRequestTimeMillis=" + r102);
        if (f395040e.contains(r100) == false) goto L12;
        b(r100);
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void a(String r100, String r101) {
        FLogger.f375446a.i("ZeusAutoFetchManager", "fetchPlugin: plugin=" + r100 + ", reason=" + r101);
        Zeus.fetchPlugin(r100);
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final boolean allowDownload(String r100, PluginDownloadBean r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "bean");
        String r102 = r101.mUrl;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (Intrinsics.areEqual(f395041f.get(r102), r101.mMd5) == false) goto L10;
        FLogger.f375446a.w("ZeusAutoFetchManager", "allowDownload: reject due to same md5. plugin=" + r100 + ", bean=" + r101);
        return false;
    L10:
        if (t1.f393353a.getObricZeusAutoFetchConfig().getUseNetworkIntercept() == true) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L18;
        FLogger.f375446a.i("ZeusAutoFetchManager", "allowDownload: rejected due to network restriction. plugin=" + r100 + ", bean=" + r101);
        return false;
    L18:
        FLogger.f375446a.d("ZeusAutoFetchManager", "allowDownload: allowed. plugin=" + r100 + ", bean=" + r101);
        IObricActivenessMonitorService.f384390a.getClass();
        IObricActivenessMonitorService r104 = IObricActivenessMonitorService.a.f384392b.getValue();
        if (r104 == null) goto L21;
        r104.c(ObricActiveReason.PLUGIN_UPDATE, true, 900000);
    L21:
        return true;
    L12:
        if (hm9.j.f485966h.B == false) goto L14;
        r103 = true;
        goto L15
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final boolean allowRequest(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "pluginPkgName");
        Long r100 = null;
        if (f395037b != null) goto L5;
    L35:
        if (r111 == true) goto L65;
        if (r110 != null) goto L38;
    L41:
        boolean r112 = true;
    L42:
        if (r112 == true) goto L60;
        Long r113 = f395038c.get(r110);
        if (r113 == null) goto L47;
        long r101 = r113.longValue();
    L48:
        long r102 = SystemClock.uptimeMillis() - r101;
        Long r114 = Long.valueOf(t1.f393353a.getObricZeusAutoFetchConfig().getFetchTimeThrottleMillis());
        if (r114.longValue() <= 0) goto L51;
        boolean r103 = true;
    L52:
        if (r103 == false) goto L54;
        r100 = r114;
    L54:
        if (r100 == null) goto L56;
        long r104 = r100.longValue();
    L58:
        if (r102 < r104) goto L60;
        boolean r115 = true;
    L61:
        if (r115 == true) goto L65;
        FLogger.f375446a.i("ZeusAutoFetchManager", "allowRequest: rejected due to time interval. plugin=" + r110);
        return false;
    L56:
        r104 = 3600000;
        goto L58
    L51:
        r103 = false;
        goto L52
    L47:
        r101 = 0;
    L60:
        r115 = false;
        goto L61
    L38:
        if (r110.length() == 0) goto L41;
        r112 = false;
    L65:
        if (t1.f393353a.getObricZeusAutoFetchConfig().getUseNetworkIntercept() == true) goto L67;
    L69:
        boolean r116 = false;
    L70:
        if (r116 == false) goto L73;
        FLogger.f375446a.i("ZeusAutoFetchManager", "allowRequest: rejected due to network restriction. plugin=" + r110);
        return false;
    L73:
        FLogger.f375446a.i("ZeusAutoFetchManager", "allowRequest: allowed. plugin=" + r110);
        return true;
    L67:
        if (hm9.j.f485966h.B == false) goto L69;
        r116 = true;
        goto L70
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L35;
        Context r105 = f395037b;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r105 = null;
    L9:
        Object r106 = r105.getSystemService("connectivity");
        if ((r106 instanceof ConnectivityManager) == false) goto L12;
        ConnectivityManager r107 = (ConnectivityManager) r106;
    L13:
        FLogger r108 = FLogger.f375446a;
        r108.d("ZeusAutoFetchManager", "allowRequest: connectionManager=" + r107);
        if (r107 == null) goto L16;
        Network r109 = r107.getActiveNetwork();
    L17:
        if (r109 != null) goto L20;
        r108.i("ZeusAutoFetchManager", "allowRequest: rejected due to no active network. plugin=" + r110);
        return false;
    L20:
        Context r117 = f395037b;
        if (r117 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r117 = null;
    L23:
        Object r118 = r117.getSystemService("keyguard");
        if ((r118 instanceof KeyguardManager) == false) goto L26;
        KeyguardManager r119 = (KeyguardManager) r118;
    L27:
        if (r119 != null) goto L29;
    L31:
        boolean r120 = false;
    L32:
        if (r120 == false) goto L35;
        r108.i("ZeusAutoFetchManager", "allowRequest: rejected due to keyguard locked. plugin=" + r110);
        return false;
    L29:
        if (r119.isKeyguardLocked() != true) goto L31;
        r120 = true;
        goto L32
    L26:
        r119 = null;
        goto L27
    L16:
        r109 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final boolean isDownloadWifiOnly(String r100, PluginDownloadBean r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "bean");
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return true;
    L8:
        String r104 = r101.mCustomMsg;
        if (r104 != null) goto L11;
        r104 = SliceInitService.DEFAULT_SWITCH;
    L11:
        Boolean r105 = f395039d.get(r104);
        if (r105 != null) goto L14;
        JSONObject r106 = new JSONObject(r104);     // Catch: JSONException -> L17
    L19:
        if (r106 == null) goto L21;
        r102 = r106.optBoolean("is_wifi_only", true);
    L21:
        f395039d.put(r104, Boolean.valueOf(r102));
        return r102;
    L17:
        e = move-exception;
        FLogger.f375446a.e("ZeusAutoFetchManager", "isDownloadWifiOnly: failed to parse custom message. customMessage=".concat(r104), e);
        r106 = null;
        goto L19
    L14:
        return r105.booleanValue();
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final void onDownloadSuccess(String r100, PluginDownloadBean r101) {
        Intrinsics.checkNotNullParameter(r100, NativeDownloadModel.JsonKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r101, "pluginDownloadBean");
        Intrinsics.checkNotNullParameter(r100, NativeDownloadModel.JsonKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r101, "pluginDownloadBean");
        String r102 = r101.mUrl;
        if (r102 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, String> r103 = f395041f;
        String r104 = r101.mMd5;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.put(r102, r104);
        IObricActivenessMonitorService.f384390a.getClass();
        IObricActivenessMonitorService r105 = IObricActivenessMonitorService.a.f384392b.getValue();
        if (r105 == null) goto L12;
        r105.c(ObricActiveReason.PLUGIN_UPDATE, false, 0);
        return;
    }
}
