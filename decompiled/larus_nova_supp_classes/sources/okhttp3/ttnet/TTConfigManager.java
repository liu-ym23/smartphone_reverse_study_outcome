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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

    public static boolean inCookieHostList(String r1) {
        return inCookieHostList(r1, inst().mShareCookieHostList);
    }

    public static void setIgnoreSlashEnabledV2(boolean r1) {
        sIgnoreSlashEnabled.set(r1);
    }

    public void onServerConfigChanged(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        parseRedirectRequestControlConfig(r1);
        parseMiscConfig(r1);
    }

    public void parseMiscConfig(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r4 = r3.optInt("ttok_enable_tls1.1", -1);
        if (r4 < 0) goto L12;
        AtomicBoolean r0 = this.mEnableTls1_1;
        boolean r1 = true;
        if (r4 == 1) goto L10;
        r1 = false;
    L10:
        r0.set(r1);
        return;
    }

    public void parseRedirectRequestControlConfig(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        JSONObject r0 = r7.optJSONObject("rect_request_control");
        if (r0 != null) goto L7;
        return;
    L7:
        parseJsonArray(r0, "scy_headers", this.mRedirectRequestControlConfig.a);
        parseJsonArray(r0, "scy_rect_wl", this.mRedirectRequestControlConfig.b);
        int r1 = r0.optInt("rm_inscy_out_wl", -1);
        boolean r3 = false;
        if (r1 < 0) goto L14;
        AtomicBoolean r5 = this.mRedirectRequestControlConfig.c;
        if (r1 != 1) goto L12;
        boolean r2 = true;
    L13:
        r5.set(r2);
        goto L14
    L12:
        r2 = false;
    L14:
        parseJsonArray(r0, "scy_rect_bl", this.mRedirectRequestControlConfig.d);
        int r4 = r0.optInt("disable_report_inscy_rect", -1);
        if (r4 < 0) goto L21;
        AtomicBoolean r6 = this.mRedirectRequestControlConfig.e;
        if (r4 != 1) goto L19;
        boolean r8 = true;
    L20:
        r6.set(r8);
        goto L21
    L19:
        r8 = false;
    L21:
        int r9 = r0.optInt("only_control_webview", -1);
        if (r9 < 0) goto L28;
        AtomicBoolean r10 = this.mRedirectRequestControlConfig.f;
        if (r9 != 1) goto L26;
        boolean r11 = true;
    L27:
        r10.set(r11);
        goto L28
    L26:
        r11 = false;
    L28:
        int r12 = r0.optInt("enable_report_full_url", -1);
        if (r12 < 0) goto L35;
        AtomicBoolean r13 = this.mRedirectRequestControlConfig.g;
        if (r12 != 1) goto L33;
        boolean r14 = true;
    L34:
        r13.set(r14);
        goto L35
    L33:
        r14 = false;
    L35:
        int r15 = r0.optInt("v2_on", -1);
        if (r15 < 0) goto L41;
        AtomicBoolean r16 = this.mRedirectRequestControlConfig.h;
        if (r15 != 1) goto L40;
        r3 = true;
    L40:
        r16.set(r3);
    L41:
        parseJsonArray(r0, "keep_headers_v2", this.mRedirectRequestControlConfig.i);
        parseJsonArray(r0, "rm_std_keep_headers_v2", this.mRedirectRequestControlConfig.j);
        parseShareCookieHostList(r7.optString("share_cookie_host_list"), this.mShareCookieHostList);
    }

    public void setAppResume(boolean r2) {
        this.mAppResume.set(r2);
    }

    public static boolean inCookieHostList(String r3, List<String> r4) {
        if (TextUtils.isEmpty(r3) == true) goto L18;
        if (r4 == null) goto L18;
        if (r4.isEmpty() == true) goto L18;
        Iterator<String> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        String r0 = r5.next();
        if (TextUtils.isEmpty(r0) == true) goto L10;
        if (r3.endsWith(r0) == false) goto L10;
        return true;
    L18:
        return false;
    }

    public static void parseShareCookieHostList(String r4, List<String> r5) {
        if (TextUtils.isEmpty(r4) == true) goto L14;
        if (r5 == null) goto L19;
        String[] r6 = r4.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L20;
        String r2 = r6[r1];
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (inCookieHostList(r2, r5) == true) goto L13;
        r5.add(r2.trim());
    L13:
        r1 = r1 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void parseJsonArray(JSONObject r3, String r4, List<String> r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4) == true) goto L22;
        JSONArray r6 = r3.optJSONArray(r4);
        if (r6 != null) goto L9;
        return;
    L9:
        ArrayList r7 = new ArrayList();
        int r0 = 0;
    L11:
        if (r0 >= r6.length()) goto L16;
        String r1 = r6.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L15;
        r7.add(r1);
    L15:
        r0 = r0 + 1;
        goto L11
    L16:
        r5.clear();
        r5.addAll(r7);
        return;
    }

    public boolean shouldRetryForceHttpdnsOnError(IOException r2, Request r3, int r4) {
        if (r2 == null) goto L20;
        if (r3 == null) goto L20;
        if (r3.url() == null) goto L20;
        if (this.mRequestRetryForceHttpDns.get() == true) goto L12;
        return false;
    L12:
        if (this.mRequestRetryForceHttpDnsErrList.contains(Integer.valueOf(r4)) == true) goto L14;
        return false;
    L14:
        String r5 = r3.url().host();
        if (TextUtils.isEmpty(r5) == true) goto L20;
        if (this.mRequestRetryForceHttpDnsHostList.contains(r5) == false) goto L20;
        return true;
    L20:
        return false;
    }
}
