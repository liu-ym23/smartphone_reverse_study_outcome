package com.ss.android.lark.monitor.traffic;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class k {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f432496J;
    public String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f432497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f432498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f432499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f432500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f432501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f432502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f432503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f432504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f432505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f432506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f432507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f432508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f432509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f432510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f432511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f432512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f432513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f432514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f432515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f432516t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f432517u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f432518v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f432519w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f432520x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f432521y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f432522z;

    public k() {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L97
        r100.put("status", this.K);     // Catch: Exception -> L95
        r100.put("total_cost", this.f432497a);     // Catch: Exception -> L95
        r100.put("total_rx", this.f432500d);     // Catch: Exception -> L95
        r100.put("total_tx", this.f432501e);     // Catch: Exception -> L95
        float r101 = this.f432498b;     // Catch: Exception -> L95
        if (r101 <= 0.0f) goto L7;
        r100.put("total_mobile_cost", r101);     // Catch: Exception -> L95
    L7:
        float r102 = this.f432499c;     // Catch: Exception -> L95
        if (r102 <= 0.0f) goto L10;
        r100.put("total_wifi_cost", r102);     // Catch: Exception -> L95
    L10:
        float r103 = this.f432502f;     // Catch: Exception -> L95
        if (r103 <= 0.0f) goto L24;
        r100.put("rust_cost", r103);     // Catch: Exception -> L95
        float r104 = this.f432505i;     // Catch: Exception -> L95
        if (r104 <= 0.0f) goto L15;
        r100.put("rust_mobile_cost", r104);     // Catch: Exception -> L95
    L15:
        float r105 = this.f432506j;     // Catch: Exception -> L95
        if (r105 <= 0.0f) goto L18;
        r100.put("rust_wifi_cost", r105);     // Catch: Exception -> L95
    L18:
        float r106 = this.f432503g;     // Catch: Exception -> L95
        if (r106 <= 0.0f) goto L21;
        r100.put("rust_rx", r106);     // Catch: Exception -> L95
    L21:
        float r107 = this.f432504h;     // Catch: Exception -> L95
        if (r107 <= 0.0f) goto L24;
        r100.put("rust_tx", r107);     // Catch: Exception -> L95
    L24:
        float r108 = this.f432507k;     // Catch: Exception -> L95
        if (r108 <= 0.0f) goto L38;
        r100.put("http_cost", r108);     // Catch: Exception -> L95
        float r109 = this.f432508l;     // Catch: Exception -> L95
        if (r109 <= 0.0f) goto L29;
        r100.put("http_mobile_cost", r109);     // Catch: Exception -> L95
    L29:
        float r110 = this.f432509m;     // Catch: Exception -> L95
        if (r110 <= 0.0f) goto L32;
        r100.put("http_wifi_cost", r110);     // Catch: Exception -> L95
    L32:
        float r111 = this.f432510n;     // Catch: Exception -> L95
        if (r111 <= 0.0f) goto L35;
        r100.put("http_rx", r111);     // Catch: Exception -> L95
    L35:
        float r112 = this.f432511o;     // Catch: Exception -> L95
        if (r112 <= 0.0f) goto L38;
        r100.put("http_tx", r112);     // Catch: Exception -> L95
    L38:
        float r113 = this.f432512p;     // Catch: Exception -> L95
        if (r113 <= 0.0f) goto L52;
        r100.put("web_cost", r113);     // Catch: Exception -> L95
        float r114 = this.f432513q;     // Catch: Exception -> L95
        if (r114 <= 0.0f) goto L43;
        r100.put("web_mobile_cost", r114);     // Catch: Exception -> L95
    L43:
        float r115 = this.f432514r;     // Catch: Exception -> L95
        if (r115 <= 0.0f) goto L46;
        r100.put("web_wifi_cost", r115);     // Catch: Exception -> L95
    L46:
        float r116 = this.f432515s;     // Catch: Exception -> L95
        if (r116 <= 0.0f) goto L49;
        r100.put("web_rx", r116);     // Catch: Exception -> L95
    L49:
        float r117 = this.f432516t;     // Catch: Exception -> L95
        if (r117 <= 0.0f) goto L52;
        r100.put("web_tx", r117);     // Catch: Exception -> L95
    L52:
        float r118 = this.f432517u;     // Catch: Exception -> L95
        if (r118 <= 0.0f) goto L66;
        r100.put("rtc_cost", r118);     // Catch: Exception -> L95
        float r119 = this.f432518v;     // Catch: Exception -> L95
        if (r119 <= 0.0f) goto L57;
        r100.put("rtc_mobile_cost", r119);     // Catch: Exception -> L95
    L57:
        float r120 = this.f432519w;     // Catch: Exception -> L95
        if (r120 <= 0.0f) goto L60;
        r100.put("rtc_wifi_cost", r120);     // Catch: Exception -> L95
    L60:
        float r121 = this.f432520x;     // Catch: Exception -> L95
        if (r121 <= 0.0f) goto L63;
        r100.put("rtc_rx", r121);     // Catch: Exception -> L95
    L63:
        float r122 = this.f432521y;     // Catch: Exception -> L95
        if (r122 <= 0.0f) goto L66;
        r100.put("rtc_tx", r122);     // Catch: Exception -> L95
    L66:
        float r123 = this.f432522z;     // Catch: Exception -> L95
        if (r123 <= 0.0f) goto L80;
        r100.put("video_cost", r123);     // Catch: Exception -> L95
        float r124 = this.A;     // Catch: Exception -> L95
        if (r124 <= 0.0f) goto L71;
        r100.put("video_mobile_cost", r124);     // Catch: Exception -> L95
    L71:
        float r125 = this.B;     // Catch: Exception -> L95
        if (r125 <= 0.0f) goto L74;
        r100.put("video_wifi_cost", r125);     // Catch: Exception -> L95
    L74:
        float r126 = this.C;     // Catch: Exception -> L95
        if (r126 <= 0.0f) goto L77;
        r100.put("video_rx", r126);     // Catch: Exception -> L95
    L77:
        float r127 = this.D;     // Catch: Exception -> L95
        if (r127 <= 0.0f) goto L80;
        r100.put("video_tx", r127);     // Catch: Exception -> L95
    L80:
        float r128 = this.E;     // Catch: Exception -> L95
        if (r128 <= 0.0f) goto L100;
        r100.put("ttnet_cost", r128);     // Catch: Exception -> L95
        float r129 = this.F;     // Catch: Exception -> L95
        if (r129 <= 0.0f) goto L85;
        r100.put("ttnet_mobile_cost", r129);     // Catch: Exception -> L95
    L85:
        float r130 = this.G;     // Catch: Exception -> L95
        if (r130 <= 0.0f) goto L88;
        r100.put("ttnet_wifi_cost", r130);     // Catch: Exception -> L95
    L88:
        float r131 = this.H;     // Catch: Exception -> L95
        if (r131 <= 0.0f) goto L91;
        r100.put("ttnet_rx", r131);     // Catch: Exception -> L95
    L91:
        float r132 = this.I;     // Catch: Exception -> L95
        if (r132 <= 0.0f) goto L100;
        r100.put("ttnet_tx", r132);     // Catch: Exception -> L95
    L100:
        return r100;
    L95:
        Exception e100 = e;
    L99:
        Log.e("ScenePerfMonitor", "get traffic report json to slardar exception", e100);
    L97:
        e = move-exception;
        r100 = null;
        e100 = e;
        goto L99
    }
}
