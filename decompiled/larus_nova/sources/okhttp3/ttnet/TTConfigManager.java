package okhttp3.ttnet;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTConfigManager {
    private static volatile TTConfigManager mInstance;
    private static AtomicBoolean sIgnoreSlashEnabled;
    private final AtomicBoolean mAppResume;
    private final AtomicBoolean mEnableIpReconnectQuickTest;
    private final AtomicBoolean mEnableTls1_1;
    private final CopyOnWriteArrayList<String> mPingKeepAliveHosts;
    private final AtomicInteger mPingKeepAliveInterval;
    private final AtomicInteger mPingProbeTimeOut;
    private final AtomicInteger mReconnectTimeoutMs;
    private final a mRedirectRequestControlConfig;
    private final AtomicBoolean mRequestRetryForceHttpDns;
    private final CopyOnWriteArrayList<Integer> mRequestRetryForceHttpDnsErrList;
    private final CopyOnWriteArrayList<String> mRequestRetryForceHttpDnsHostList;
    private final List<String> mShareCookieHostList;
    private final AtomicInteger mTriplicateIpNumbers;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f523947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f523948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f523949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f523950d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f523951e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f523952f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f523953g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicBoolean f523954h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<String> f523955i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<String> f523956j;

        public a() {
            this.f523947a = new CopyOnWriteArrayList();
            this.f523948b = new CopyOnWriteArrayList();
            this.f523949c = new AtomicBoolean(false);
            this.f523950d = new CopyOnWriteArrayList();
            this.f523951e = new AtomicBoolean(false);
            this.f523952f = new AtomicBoolean(false);
            this.f523953g = new AtomicBoolean(false);
            this.f523954h = new AtomicBoolean(false);
            this.f523955i = new ArrayList();
            this.f523956j = new ArrayList();
        }
    }

    static {
        sIgnoreSlashEnabled = new AtomicBoolean(false);
    }

    public static TTConfigManager inst() {
        if (mInstance != null) goto L15;
        monitor-enter(TTConfigManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTConfigManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTConfigManager.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static boolean isIgnoreSlashEnabled() {
        return sIgnoreSlashEnabled.get();
    }

    public boolean enableTls1_1() {
        return this.mEnableTls1_1.get();
    }

    public boolean getAppResume() {
        return this.mAppResume.get();
    }

    public int getPingKeepAliveInterval() {
        return this.mPingKeepAliveInterval.get();
    }

    public int getReconnctTimeout() {
        return this.mReconnectTimeoutMs.get();
    }

    public int getTriplicateIpNumbers() {
        return this.mTriplicateIpNumbers.get();
    }

    public boolean isIpReconnQuickTestEnable() {
        return this.mEnableIpReconnectQuickTest.get();
    }

    public TTConfigManager() {
        this.mPingProbeTimeOut = new AtomicInteger(10000);
        this.mPingKeepAliveInterval = new AtomicInteger(60000);
        this.mPingKeepAliveHosts = new CopyOnWriteArrayList();
        this.mAppResume = new AtomicBoolean(true);
        this.mEnableIpReconnectQuickTest = new AtomicBoolean(false);
        this.mReconnectTimeoutMs = new AtomicInteger(320);
        this.mTriplicateIpNumbers = new AtomicInteger(0);
        this.mRequestRetryForceHttpDns = new AtomicBoolean(false);
        this.mRequestRetryForceHttpDnsErrList = new CopyOnWriteArrayList();
        this.mRequestRetryForceHttpDnsHostList = new CopyOnWriteArrayList();
        this.mRedirectRequestControlConfig = new a();
        this.mShareCookieHostList = new CopyOnWriteArrayList();
        this.mEnableTls1_1 = new AtomicBoolean(false);
    }

    public List<String> getPingKeepAliveHosts() {
        return this.mPingKeepAliveHosts;
    }

    public a getRedirectRequestControlConfig() {
        return this.mRedirectRequestControlConfig;
    }

    public static boolean inCookieHostList(String r100) {
        return inCookieHostList(r100, inst().mShareCookieHostList);
    }

    public static void setIgnoreSlashEnabledV2(boolean r100) {
        sIgnoreSlashEnabled.set(r100);
    }

    public void onServerConfigChanged(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        parseRedirectRequestControlConfig(r100);
        parseMiscConfig(r100);
    }

    public void parseMiscConfig(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.optInt("ttok_enable_tls1.1", -1);
        if (r101 < 0) goto L12;
        AtomicBoolean r102 = this.mEnableTls1_1;
        boolean r103 = true;
        if (r101 == 1) goto L10;
        r103 = false;
    L10:
        r102.set(r103);
        return;
    }

    public void parseRedirectRequestControlConfig(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = r100.optJSONObject("rect_request_control");
        if (r101 != null) goto L7;
        return;
    L7:
        parseJsonArray(r101, "scy_headers", this.mRedirectRequestControlConfig.f523947a);
        parseJsonArray(r101, "scy_rect_wl", this.mRedirectRequestControlConfig.f523948b);
        int r102 = r101.optInt("rm_inscy_out_wl", -1);
        boolean r103 = false;
        if (r102 < 0) goto L14;
        AtomicBoolean r104 = this.mRedirectRequestControlConfig.f523949c;
        if (r102 != 1) goto L12;
        boolean r105 = true;
    L13:
        r104.set(r105);
        goto L14
    L12:
        r105 = false;
    L14:
        parseJsonArray(r101, "scy_rect_bl", this.mRedirectRequestControlConfig.f523950d);
        int r106 = r101.optInt("disable_report_inscy_rect", -1);
        if (r106 < 0) goto L21;
        AtomicBoolean r107 = this.mRedirectRequestControlConfig.f523951e;
        if (r106 != 1) goto L19;
        boolean r108 = true;
    L20:
        r107.set(r108);
        goto L21
    L19:
        r108 = false;
    L21:
        int r109 = r101.optInt("only_control_webview", -1);
        if (r109 < 0) goto L28;
        AtomicBoolean r110 = this.mRedirectRequestControlConfig.f523952f;
        if (r109 != 1) goto L26;
        boolean r111 = true;
    L27:
        r110.set(r111);
        goto L28
    L26:
        r111 = false;
    L28:
        int r112 = r101.optInt("enable_report_full_url", -1);
        if (r112 < 0) goto L35;
        AtomicBoolean r113 = this.mRedirectRequestControlConfig.f523953g;
        if (r112 != 1) goto L33;
        boolean r114 = true;
    L34:
        r113.set(r114);
        goto L35
    L33:
        r114 = false;
    L35:
        int r115 = r101.optInt("v2_on", -1);
        if (r115 < 0) goto L41;
        AtomicBoolean r116 = this.mRedirectRequestControlConfig.f523954h;
        if (r115 != 1) goto L40;
        r103 = true;
    L40:
        r116.set(r103);
    L41:
        parseJsonArray(r101, "keep_headers_v2", this.mRedirectRequestControlConfig.f523955i);
        parseJsonArray(r101, "rm_std_keep_headers_v2", this.mRedirectRequestControlConfig.f523956j);
        parseShareCookieHostList(r100.optString("share_cookie_host_list"), this.mShareCookieHostList);
    }

    public void setAppResume(boolean r100) {
        this.mAppResume.set(r100);
    }

    public static boolean inCookieHostList(String r100, List<String> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (r101 == null) goto L18;
        if (r101.isEmpty() == true) goto L18;
        Iterator<String> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L10;
        if (r100.endsWith(r103) == false) goto L10;
        return true;
    L18:
        return false;
    }

    public static void parseShareCookieHostList(String r100, List<String> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        if (r101 == null) goto L19;
        String[] r102 = r100.split(",");
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L20;
        String r105 = r102[r104];
        if (TextUtils.isEmpty(r105) == true) goto L13;
        if (inCookieHostList(r105, r101) == true) goto L13;
        r101.add(r105.trim());
    L13:
        r104 = r104 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void parseJsonArray(JSONObject r100, String r101, List<String> r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        JSONArray r103 = r100.optJSONArray(r101);
        if (r103 != null) goto L9;
        return;
    L9:
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L11:
        if (r105 >= r103.length()) goto L16;
        String r106 = r103.optString(r105);
        if (TextUtils.isEmpty(r106) == true) goto L15;
        r104.add(r106);
    L15:
        r105 = r105 + 1;
        goto L11
    L16:
        r102.clear();
        r102.addAll(r104);
        return;
    }

    public boolean shouldRetryForceHttpdnsOnError(IOException r100, Request r101, int r102) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if (r101.url() == null) goto L20;
        if (this.mRequestRetryForceHttpDns.get() == true) goto L12;
        return false;
    L12:
        if (this.mRequestRetryForceHttpDnsErrList.contains(Integer.valueOf(r102)) == true) goto L14;
        return false;
    L14:
        String r103 = r101.url().host();
        if (TextUtils.isEmpty(r103) == true) goto L20;
        if (this.mRequestRetryForceHttpDnsHostList.contains(r103) == false) goto L20;
        return true;
    L20:
        return false;
    }
}
