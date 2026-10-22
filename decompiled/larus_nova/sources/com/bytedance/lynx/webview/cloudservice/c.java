package com.bytedance.lynx.webview.cloudservice;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.Setting;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import l17.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements com.bytedance.lynx.webview.internal.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f265086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile m17.a f265087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f265088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f265089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f265090e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f265091a = null;

        static {
            f265091a = new c();
        }
    }

    @Override // com.bytedance.lynx.webview.internal.g.b
    public final void a(JSONObject r100) {
    }

    public c() {
        this.f265086a = Setting.c().b("scc_sb_url_bloom_enable", false);
        if (this.f265086a == false) goto L5;
        c(Setting.c().g("scc_sb_url_bloom_data"), Setting.c().g("scc_sb_url_bloom_version"), Setting.c().d("scc_sb_url_bloom_mode", -1));
    L5:
        Setting.c();
        com.bytedance.lynx.webview.internal.g.e().b(this);
    }

    @Override // com.bytedance.lynx.webview.internal.g.b
    public final void b(JSONObject r100, boolean r101) {
        if (r101 == false) goto L14;
        this.f265086a = Setting.c().b("scc_sb_url_bloom_enable", false);
        if (this.f265086a == false) goto L16;
        String r102 = Setting.c().g("scc_sb_url_bloom_data");
        String r103 = Setting.c().g("scc_sb_url_bloom_version");
        int r104 = Setting.c().d("scc_sb_url_bloom_mode", -1);
        if (r102.equals(this.f265088c) == true) goto L9;
    L12:
        c(r102, r103, r104);
        return;
    L9:
        if (r103.equals(this.f265089d) == false) goto L12;
        if (r104 != this.f265090e) goto L12;
        return;
    L16:
        return;
    }

    public final void c(String r100, String r101, int r110) {
        if (this.f265086a == true) goto L28;
        return;
    L28:
    L15:
        e = move-exception;
        this.f265087b = null;
        k.b(new String[]{"SBHighConfidenceBlocklist load BloomFilter fail: " + e});
        JSONObject r102 = new JSONObject();
        r102.put("scc_high_risk_bloom_parse_result", e.toString());     // Catch: Exception -> L27
        r102.put("scc_high_risk_bloom_version", r101);     // Catch: Exception -> L27
        if (r100 == null) goto L23;
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L21 Exception -> L27
        r103.update(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L21 Exception -> L27
        String r104 = l17.g.a(r103.digest());     // Catch: NoSuchAlgorithmException -> L21 Exception -> L27
    L22:
        r102.put("scc_high_risk_bloom_data_md5", r104);     // Catch: Exception -> L27
    L21:
        r104 = "";
    L23:
        EventStatistics.f(EventType.SCC_HIGH_RISK_BLOCKLIST_LOAD.getEventCode(), r102);
    L24:
        this.f265088c = r100;
        this.f265089d = r101;
        this.f265090e = r110;
        return;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        this.f265087b = null;     // Catch: Exception -> L15
        goto L24
    L10:
        if (r100.equals(this.f265088c) == true) goto L24;
        long r105 = System.currentTimeMillis();     // Catch: Exception -> L15
        this.f265087b = m17.a.a(Base64.decode(r100, 8));     // Catch: Exception -> L15
        long r106 = System.currentTimeMillis() - r105;     // Catch: Exception -> L15
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L15
        r107.put("scc_high_risk_bloom_parse_result", "success");     // Catch: JSONException -> L26 Exception -> L15
        r107.put("scc_high_risk_bloom_version", r101);     // Catch: JSONException -> L26 Exception -> L15
        r107.put("scc_high_risk_bloom_parse_cost", r106);     // Catch: JSONException -> L26 Exception -> L15
    L13:
        EventStatistics.f(EventType.SCC_HIGH_RISK_BLOCKLIST_LOAD.getEventCode(), r107);     // Catch: Exception -> L15
        goto L24
    }
}
