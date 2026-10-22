package com.volcengine.zeus.download;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import mqc.r;
import mqc.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f462670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f462671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f462672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f462673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CountDownLatch f462674e;

    /* JADX WARN: Multi-variable type inference failed */
    public final PluginDownloadBean c() {
        if (this.f462672c == false) goto L37;
        long r110 = System.currentTimeMillis();
    L34:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, "Request plugin config failed!!! " + this.f462671b, th);
        e(this.f462671b, "fail", 5, th.getMessage());
        return new PluginDownloadBean(this.f462671b, 5);
    L108:
        NetworkInfo r100 = ((ConnectivityManager) Zeus.getAppApplication().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L106 Throwable -> L34
        if (r100 == null) goto L11;
        if (r100.isConnected() == false) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == true) goto L14;
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins skip. Network off. " + this.f462671b);     // Catch: Throwable -> L34
        e(this.f462671b, "fail", 1, "network off");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.f462671b, 1);
    L14:
        NetworkUtils r102 = NetworkUtils.b();     // Catch: Throwable -> L34
        String r111 = GlobalParam.getInstance().getHostUrl();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r111) == false) goto L17;
        r111 = "https://zeus-api.vemarsdev.com/zeus/client/v2/query";
    L17:
        mqc.f r103 = r102.a(r111, d.a(this.f462671b), this.f462671b);     // Catch: Throwable -> L34
        T r104 = r103.f514947a;     // Catch: Throwable -> L34
        if (r104 != 0) goto L20;
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, "Request plugin failed! response is empty! pkg = " + this.f462671b + " logId = " + ((String) r103.f514948b));     // Catch: Throwable -> L34
        e(this.f462671b, "fail", 2, "response empty");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.f462671b, 2);
    L20:
        JSONObject r105 = (JSONObject) r104;     // Catch: Throwable -> L34
        String r106 = r105.optString("error_msg", "");     // Catch: Throwable -> L34
        int r107 = r105.optInt("error_no", -1);     // Catch: Throwable -> L34
        if (r107 == 0) goto L23;
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, "Request plugin failed! errorNo =[" + r107 + "] errorMsg=[" + r106 + "] logId=[" + ((String) r103.f514948b) + "] pluginPkg=[" + this.f462671b + "]");     // Catch: Throwable -> L34
        e(this.f462671b, "fail", r107, r106);     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.f462671b, r107);
    L23:
        ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "response:" + r103.f514947a + " logId:" + ((String) r103.f514948b));     // Catch: Throwable -> L34
        JSONObject r108 = r105.optJSONObject("data");     // Catch: Throwable -> L34
        if (r108 == null) goto L32;
        PluginDownloadBean r109 = d.b(r108);     // Catch: Throwable -> L34
        if (a.b(r109) == true) goto L28;
        e(this.f462671b, "fail", 6, "should not download");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.f462671b, 6);
    L28:
        if (a.a(r109) == false) goto L30;
        e(this.f462671b, "fail", 3, "intercept");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.f462671b, 3);
    L30:
        e(this.f462671b, "success", 0, "");     // Catch: Throwable -> L34
        d(this.f462671b, System.currentTimeMillis() - r110, true);     // Catch: Throwable -> L34
        return r109;
    L32:
        e(this.f462671b, "fail", 4, "no data");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.f462671b, 4);
    L11:
        r101 = false;
        goto L12
    L37:
        long r112 = System.currentTimeMillis();
        if (this.f462670a != null) goto L40;
    L105:
        return null;
    L40:
        if (this.f462674e == null) goto L105;
        ZeusPluginStateListener.postStateChange(this.f462671b, 11, new Object[0]);     // Catch: Throwable -> L95
        if (GlobalParam.getInstance().getDownloadPolicy().allowRequest(this.f462671b, this.f462673d) == false) goto L101;
        Plugin r113 = Zeus.getPlugin(this.f462671b);     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r113.response) == true) goto L49;
        JSONObject r114 = new JSONObject(r113.response);     // Catch: Throwable -> L95
        String r115 = "";
    L56:
        String r116 = r114.optString("error_msg", "");     // Catch: Throwable -> L95
        int r117 = r114.optInt("error_no", -1);     // Catch: Throwable -> L95
        if (r117 == 0) goto L59;
        String r118 = "Request plugin failed! errorNo =[" + r117 + "] errorMsg=[" + r116 + "] logId=[" + r115 + "] pluginPkg=[" + this.f462671b + "]";     // Catch: Throwable -> L95
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, r118);     // Catch: Throwable -> L95
        ZeusPluginStateListener.postStateChange(this.f462671b, 12, new Object[]{r118});     // Catch: Throwable -> L95
        e(this.f462671b, "fail", r117, r118);     // Catch: Throwable -> L95
        goto L101
    L59:
        this.f462670a.c(this.f462671b);     // Catch: Throwable -> L95
        GlobalParam.getInstance().getDownloadPolicy().updateLastRequestTime(this.f462671b);     // Catch: Throwable -> L95
        ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "response:" + r114 + " logId:" + r115);     // Catch: Throwable -> L95
        JSONObject r119 = r114.optJSONObject("data");     // Catch: Throwable -> L95
        if (r119 == null) goto L85;
        PluginDownloadBean r120 = d.b(r119);     // Catch: Throwable -> L95
        if (a.b(r120) == false) goto L85;
        t r121 = t.c();     // Catch: Throwable -> L95
        String r122 = this.f462671b;     // Catch: Throwable -> L95
        String r123 = r120.mMd5;     // Catch: Throwable -> L95
        SharedPreferences.Editor r124 = r121.f514970a.edit();     // Catch: Throwable -> L95
        r124.putString("LATEST_" + r122, r123);     // Catch: Throwable -> L95
        r124.apply();     // Catch: Throwable -> L95
        if (a.a(r120) == true) goto L84;
        r113.setApiCompatVersion(r120.mVersionCode, r120.mApiVersionMin, r120.mApiVersionMax);     // Catch: Throwable -> L95
        ZeusPluginStateListener.postStateChange(this.f462671b, 0, new Object[]{r120});     // Catch: Throwable -> L95
    L82:
        th = th;
        boolean r125 = true;
    L113:
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, "Request plugin config failed!!! " + this.f462671b, th);     // Catch: Throwable -> L102
        if (r125 == true) goto L100;
        ZeusPluginStateListener.postStateChange(this.f462671b, 12, new Object[]{th.getMessage()});     // Catch: Throwable -> L102
    L100:
        e(this.f462671b, "fail", 5, th.getMessage());     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        ((ConcurrentHashMap) this.f462670a.f462692c).remove(this.f462671b);
        throw th;
    L67:
        if (GlobalParam.getInstance().getDownloadPolicy().allowDownload(this.f462671b, r120) == false) goto L81;
        boolean r126 = GlobalParam.getInstance().getDownloadPolicy().isDownloadWifiOnly(this.f462671b, r120);     // Catch: Throwable -> L82
        if (e.f462675b == null) goto L71;
    L80:
        e.f462675b.a(r120, this, r126);     // Catch: Throwable -> L82
        this.f462674e.await();     // Catch: Throwable -> L82
        goto L81
    L71:
        monitor-enter(e.class);     // Catch: Throwable -> L82
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L73:
        if (e.f462675b != null) goto L75;
        e.f462675b = new e();     // Catch: Throwable -> L77
    L75:
        monitor-exit(e.class);     // Catch: Throwable -> L77
    L81:
        boolean r127 = true;
        r125 = true;
    L87:
        if (r127 == false) goto L110;
    L91:
        if (r125 == true) goto L93;
        ZeusPluginStateListener.postStateChange(this.f462671b, 0, new Object[]{null});     // Catch: Throwable -> L89
    L93:
        e(this.f462671b, "success", 0, "");     // Catch: Throwable -> L89
        d(this.f462671b, System.currentTimeMillis() - r112, false);     // Catch: Throwable -> L89
    L89:
        th = th;
        goto L113
    L110:
        t r128 = t.c();     // Catch: Throwable -> L89
        String r129 = this.f462671b;     // Catch: Throwable -> L89
        SharedPreferences.Editor r130 = r128.f514970a.edit();     // Catch: Throwable -> L89
        r130.putString("LATEST_" + r129, "0");     // Catch: Throwable -> L89
        r130.apply();     // Catch: Throwable -> L89
        goto L91
    L84:
        r127 = true;
    L86:
        r125 = false;
    L85:
        r127 = false;
        goto L86
    L49:
        NetworkUtils r131 = NetworkUtils.b();     // Catch: Throwable -> L95
        String r132 = GlobalParam.getInstance().getHostUrl();     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r132) == false) goto L52;
        r132 = "https://zeus-api.vemarsdev.com/zeus/client/v2/query";
    L52:
        mqc.f r133 = r131.a(r132, d.a(this.f462671b), this.f462671b);     // Catch: Throwable -> L95
        JSONObject r134 = (JSONObject) r133.f514947a;     // Catch: Throwable -> L95
        String r135 = (String) r133.f514948b;     // Catch: Throwable -> L95
        if (r134 != null) goto L55;
        String r136 = "Request plugin failed! response is empty! pkg = " + this.f462671b + " logId = " + r135;     // Catch: Throwable -> L95
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, r136);     // Catch: Throwable -> L95
        ZeusPluginStateListener.postStateChange(this.f462671b, 12, new Object[]{r136});     // Catch: Throwable -> L95
        e(this.f462671b, "fail", 2, r136);     // Catch: Throwable -> L95
        goto L101
    L55:
        r115 = r135;
        r114 = r134;
    L101:
        ((ConcurrentHashMap) this.f462670a.f462692c).remove(this.f462671b);
    L95:
        th = th;
        r125 = false;
        goto L113
    }

    public c(String r100) {
        this.f462671b = r100;
        this.f462674e = null;
        this.f462670a = null;
        this.f462672c = true;
        this.f462673d = false;
    }

    public c(j r100, boolean r101, String r102) {
        this.f462670a = r100;
        this.f462671b = r102;
        this.f462674e = new CountDownLatch(1);
        this.f462672c = false;
        this.f462673d = r101;
    }

    public static void d(String r100, long r101, boolean r110) {
        Plugin r102 = Zeus.getPlugin(r100);     // Catch: Exception -> L13
        if (r102 == null) goto L5;
        int r103 = r102.getVersion();     // Catch: Exception -> L13
    L6:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L13
        if (r110 == false) goto L10;
        r104.put("fetch_type", "only_request");     // Catch: Exception -> L13
    L11:
        r.a(r100, Integer.valueOf(r103), "fetch_plugin", r101, r104);     // Catch: Exception -> L13
        return;
    L10:
        r104.put("fetch_type", "request_and_download");     // Catch: Exception -> L13
        goto L11
    L5:
        r103 = -1;
    L13:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DOWNLOAD, "report fetch cost failed", e);
    }

    public static void e(String r100, String r101, int r102, String r110) {
        Plugin r103 = Zeus.getPlugin(r100);
        if (r103 == null) goto L5;
        int r104 = r103.getVersion();
    L6:
        r.b(r100, r104, "fetch_plugin", r101, Integer.valueOf(r102), r110);
        return;
    L5:
        r104 = -1;
        goto L6
    }
}
