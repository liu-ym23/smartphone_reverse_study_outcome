package com.ss.videoarch.liveplayer.model;

import android.graphics.Rect;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class LiveStreamInfo {
    public JSONObject A;
    public JSONObject B;
    public JSONObject C;
    public boolean D;
    public final String E;
    public String F;
    public String G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f459463J;
    public final JSONObject K;
    public final int L;
    public final JSONObject M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public int S;
    public String T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f459464a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f459465a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f459466b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f459467b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f459468c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f459469c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f459470d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f459471d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f459472e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f459473e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f459474f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f459475f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f459476g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final HashSet<String> f459477g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f459478h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f459479h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f459480i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f459481i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f459482j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f459483j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f459484k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public List<Long> f459485k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f459486l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, JSONObject>> f459487l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f459488m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public HashMap<String, String> f459489m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f459490n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public HashMap<String, String> f459491n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f459492o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final String f459493o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f459494p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public JSONObject f459495p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f459496q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public HashSet<String> f459497q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f459498r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final String f459499r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f459500s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final JSONObject f459501s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f459502t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final long f459503t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f459504u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f459505u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f459506v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f459507v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f459508w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f459509w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f459510x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f459511x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f459512y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f459513z;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f459514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459515b;

        public a(LiveStreamInfo r100, String r101, String r102, int r103) {
            this.f459514a = r101;
            this.f459515b = r103;
        }
    }

    public void setEnableOriginResolution(boolean r100) {
    }

    public JSONObject getAbrInfo() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L13;
        return null;
    L13:
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        if (r100.has("auto") == true) goto L8;
        return null;
    L8:
        return JSONObjectProtectorUtils.getJSONObject(this.f459466b, "auto");
    }

    public Map<String, String> getHTTPHeaders() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (r100.has("header") == false) goto L16;
        HashMap r101 = new HashMap();
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(this.f459466b, "header");     // Catch: JSONException -> L14
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L14
    L10:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();     // Catch: JSONException -> L14
        r101.put(r104, JSONObjectProtectorUtils.getString(r102, r104));     // Catch: JSONException -> L14
        goto L10
    L13:
        return r101;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public HashMap<String, String> getLineMap() {
        HashMap<String, String> r100 = this.f459489m0;
        if (r100 == null) goto L5;
        return r100;
    L5:
        this.f459489m0 = new HashMap();
        JSONObject r101 = this.f459466b;
        if (r101 == null) goto L22;
        if (r101.has(GXTemplateKey.STYLE_FONT_LINES) == false) goto L22;
        JSONObject r102 = this.f459466b.optJSONObject(GXTemplateKey.STYLE_FONT_LINES);
        if (r102 == null) goto L22;
        if (r102.has(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L17;
        if (TextUtils.isEmpty(r102.optString(PullConfiguration.PROCESS_NAME_MAIN)) == true) goto L17;
        this.f459489m0.put(PullConfiguration.PROCESS_NAME_MAIN, r102.optString(PullConfiguration.PROCESS_NAME_MAIN));
    L17:
        if (r102.has("backup") == false) goto L22;
        if (TextUtils.isEmpty(r102.optString("backup")) == true) goto L22;
        this.f459489m0.put("backup", r102.optString("backup"));
    L22:
        return this.f459489m0;
    }

    public String getQueryItems() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L5;
    L22:
        return null;
    L5:
        if (r100.has("query") == false) goto L22;
        if (TextUtils.isEmpty(this.f459465a0) == false) goto L10;
        StringBuilder r101 = new StringBuilder();
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(this.f459466b, "query");     // Catch: Throwable -> L18 JSONException -> L20
        Iterator<String> r103 = r102.keys();     // Catch: Throwable -> L18 JSONException -> L20
    L14:
        if (r103.hasNext() == false) goto L16;
        String r104 = r103.next();     // Catch: Throwable -> L18 JSONException -> L20
        String r105 = JSONObjectProtectorUtils.getString(r102, r104);     // Catch: Throwable -> L18 JSONException -> L20
        String r106 = URLEncoder.encode(r104, "UTF-8");     // Catch: Throwable -> L18 JSONException -> L20
        String r107 = URLEncoder.encode(r105, "UTF-8");     // Catch: Throwable -> L18 JSONException -> L20
        r101.append("&");     // Catch: Throwable -> L18 JSONException -> L20
        r101.append(r106);     // Catch: Throwable -> L18 JSONException -> L20
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L18 JSONException -> L20
        r101.append(r107);     // Catch: Throwable -> L18 JSONException -> L20
        goto L14
    L16:
        String r108 = r101.toString();     // Catch: Throwable -> L18 JSONException -> L20
        this.f459465a0 = r108;     // Catch: Throwable -> L18 JSONException -> L20
        return r108;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L10:
        return this.f459465a0;
    }

    public String getRuleIds() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.has("rule_ids") == true) goto L8;
        return null;
    L8:
        return this.f459466b.optString("rule_ids");
    }

    public String getSessionID() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.has("session_id") == true) goto L8;
        return null;
    L8:
        return this.f459466b.optString("session_id");
    }

    public long getSessionTimestamp() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L5;
    L9:
        return 0;
    L5:
        if (r100.has("ts") == false) goto L9;
        return cnc.c.parseLong(this.f459466b.optString("ts"), 0);
    }

    public String getStreamName() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.optString("stream_name");
    }

    public JSONArray getSupportedResolutions() {
        JSONArray r100 = new JSONArray();
        JSONObject r101 = this.f459464a;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Iterator<String> r102 = r101.keys();
    L7:
        if (r102.hasNext() == false) goto L9;
        r100.put(r102.next());
        goto L7
    L9:
        return r100;
    }

    public JSONObject getTemplateJson() {
        JSONObject r100 = this.f459495p0;
        if (r100 == null) goto L5;
        return r100;
    L5:
        this.f459495p0 = new JSONObject();
        JSONObject r101 = this.f459464a;     // Catch: JSONException -> L36
        if (r101 == null) goto L39;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L36
    L9:
        if (r102.hasNext() == false) goto L39;
        String r103 = r102.next();     // Catch: JSONException -> L36
        JSONObject r104 = new JSONObject(this.f459464a.optString(r103));     // Catch: JSONException -> L36
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L36
        if (r104.has(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L25;
        JSONObject r110 = new JSONObject(r104.optString(PullConfiguration.PROCESS_NAME_MAIN));     // Catch: JSONException -> L36
        if (r110.has("templateExtraInfo") == false) goto L19;
        String r106 = new JSONObject(JSONObjectProtectorUtils.getString(r110, "templateExtraInfo")).optString("name", null);     // Catch: JSONException -> L36
        if (r106 == null) goto L20;
        r105.put(PullConfiguration.PROCESS_NAME_MAIN, r106);     // Catch: JSONException -> L36
    L20:
        if (r106 != null) goto L25;
        if (r110.has("flv") == false) goto L25;
        r105.put(PullConfiguration.PROCESS_NAME_MAIN, cnc.c.getActualStreamSuffix(r110.optString("flv")));     // Catch: JSONException -> L36
        goto L25
    L19:
        r106 = null;
    L25:
        if (r104.has("backup") == false) goto L34;
        JSONObject r107 = new JSONObject(r104.optString("backup"));     // Catch: JSONException -> L36
        if (r107.has("templateExtraInfo") == false) goto L32;
        String r108 = new JSONObject(JSONObjectProtectorUtils.getString(r107, "templateExtraInfo")).optString("name", null);     // Catch: JSONException -> L36
        if (r108 == null) goto L32;
        r105.put("backup", r108);     // Catch: JSONException -> L36
    L32:
        if (r107.has("flv") == false) goto L34;
        r105.put("backup", cnc.c.getActualStreamSuffix(r107.optString("flv")));     // Catch: JSONException -> L36
    L34:
        this.f459495p0.put(r103, r105);     // Catch: JSONException -> L36
    L39:
        return this.f459495p0;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L39
    }

    public boolean isDrmLive() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.has("secret_key") == false) goto L10;
        this.f459513z = this.f459466b.optString("secret_key");
        return true;
    L10:
        return false;
    }

    public int isHorizontalScreen() {
        int r100 = this.f459481i0;
        if (r100 < 0) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(this.f459470d) == false) goto L39;
        return -1;
    L39:
        JSONObject r101 = getSDKParamsJson(this.f459470d, PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Exception -> L31
        if (r101 != null) goto L12;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: Exception -> L31
        return -1;
    L12:
        String[] r102 = r101.optString("resolution").split("x");     // Catch: Exception -> L31
        if (r102.length != 2) goto L34;
        int r103 = CastIntegerProtector.parseInt(r102[0]);     // Catch: NumberFormatException -> L21 Exception -> L31
        int r104 = CastIntegerProtector.parseInt(r102[1]);     // Catch: NumberFormatException -> L19 Exception -> L31
    L24:
        if (r104 <= 0) goto L27;
        if (r103 < r104) goto L27;
        this.f459481i0 = 1;     // Catch: Exception -> L31
    L27:
        if (r103 <= 0) goto L34;
        if (r104 <= r103) goto L34;
        this.f459481i0 = 0;     // Catch: Exception -> L31
    L19:
        e = e;
    L23:
        e.printStackTrace();     // Catch: Exception -> L31
        r104 = 0;
    L21:
        e = e;
        r103 = 0;
    L34:
        return this.f459481i0;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    public JSONObject getP2pParams() {
        JSONObject r100 = this.f459466b;
        if (r100 != null) goto L13;
        return null;
    L13:
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        if (r100.has("p2p_params") == true) goto L8;
        return null;
    L8:
        return JSONObjectProtectorUtils.getJSONObject(this.f459466b, "p2p_params");
    }

    public String getDefaultResolution() {
        return this.f459470d;
    }

    public String getDrmSecretKey() {
        return this.f459513z;
    }

    public String getFastFirstFrameProtocol() {
        return this.Z;
    }

    public long getMpdUrlCost() {
        return this.f459475f0;
    }

    public String getQuicPluginMinVersion() {
        return this.T;
    }

    public String getStreamId() {
        return this.f459493o0;
    }

    public String getStreamMode() {
        return this.f459499r0;
    }

    public long getStreamVersion() {
        return this.f459503t0;
    }

    public int isDisableQuicOnFreeFlow() {
        return this.S;
    }

    public boolean isEnableBMFSharpen() {
        return this.O;
    }

    public int isEnableLSSSuggestProtocol() {
        return this.Y;
    }

    public boolean isEnablePanoBMFSharpen() {
        return this.P;
    }

    public int isEnableQuicByUserSetQosConstraint() {
        return this.W;
    }

    public int isEnableQuicDegradeInFaultFormat() {
        return this.X;
    }

    public int isEnableQuicDegradeInNonPreivew() {
        return this.V;
    }

    public int isEnableQuicPluginVersionCheck() {
        return this.U;
    }

    public boolean isEnableSDR2HDR() {
        return this.f459505u0;
    }

    public LiveStreamInfo(JSONObject r210) {
        this.f459474f = -1;
        this.f459476g = -1;
        this.f459482j = "";
        this.f459484k = "";
        this.f459486l = 0;
        this.f459488m = 0;
        this.f459490n = 0;
        this.f459492o = 0;
        this.f459494p = 0;
        this.f459496q = 0;
        this.f459498r = 0;
        this.f459500s = 0;
        this.f459502t = 0;
        this.f459504u = 0;
        this.f459506v = 0;
        this.f459508w = 0;
        this.f459510x = 0;
        this.f459512y = 0;
        this.f459513z = "";
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = false;
        this.E = "none";
        this.F = "none";
        this.G = "none";
        this.H = "none";
        this.I = "none";
        this.f459463J = "none";
        this.K = null;
        this.L = -1;
        this.M = null;
        this.N = -1;
        this.O = false;
        this.P = false;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = "1.0.105.5";
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = "h2q";
        this.f459469c0 = 0;
        this.f459471d0 = 0;
        this.f459473e0 = "";
        this.f459475f0 = -1;
        this.f459477g0 = new HashSet();
        this.f459479h0 = "";
        this.f459481i0 = -1;
        this.f459483j0 = "";
        this.f459485k0 = null;
        this.f459487l0 = new ConcurrentHashMap();
        this.f459489m0 = null;
        this.f459491n0 = null;
        this.f459493o0 = "";
        this.f459495p0 = null;
        this.f459497q0 = null;
        this.f459499r0 = "";
        this.f459501s0 = null;
        this.f459503t0 = -1;
        this.f459507v0 = 0;
        this.f459509w0 = 0;
        this.f459511x0 = 0;
        if (r210 != null) goto L79;
        return;
    L79:
        this.f459464a = JSONObjectProtectorUtils.getJSONObject(r210, "data");     // Catch: JSONException -> L75
        if (r210.has("common") == false) goto L8;
        this.f459466b = JSONObjectProtectorUtils.getJSONObject(r210, "common");     // Catch: JSONException -> L75
    L8:
        JSONObject r100 = this.f459466b;     // Catch: JSONException -> L75
        if (r100 != null) goto L11;
    L17:
        JSONObject r101 = this.f459466b;     // Catch: JSONException -> L75
        if (r101 != null) goto L20;
    L22:
        JSONObject r102 = this.f459466b;     // Catch: JSONException -> L75
        if (r102 == null) goto L28;
        if (r102.has("common_trace") == false) goto L28;
        this.H = this.f459466b.optString("common_trace");     // Catch: JSONException -> L75
    L28:
        if (TextUtils.equals(this.H, "none") == true) goto L35;
        JSONObject r103 = new JSONObject(this.H);     // Catch: JSONException -> L75
        if (r103.has("BusinessType") == false) goto L33;
        this.I = r103.optString("BusinessType");     // Catch: JSONException -> L75
    L33:
        if (r103.has("SceneTags") == false) goto L35;
        this.M = r103.optJSONObject("SceneTags");     // Catch: JSONException -> L75
    L35:
        JSONObject r104 = this.f459466b;     // Catch: JSONException -> L75
        if (r104 != null) goto L38;
    L40:
        JSONObject r105 = this.f459466b;     // Catch: JSONException -> L75
        if (r105 != null) goto L43;
    L45:
        JSONObject r106 = this.f459466b;     // Catch: JSONException -> L75
        if (r106 != null) goto L48;
    L50:
        JSONObject r107 = this.f459466b;     // Catch: JSONException -> L75
        if (r107 != null) goto L53;
    L55:
        JSONObject r108 = this.f459466b;     // Catch: JSONException -> L75
        if (r108 != null) goto L58;
    L60:
        JSONObject r109 = this.f459466b;     // Catch: JSONException -> L75
        if (r109 != null) goto L63;
    L69:
        JSONObject r110 = this.f459466b;     // Catch: JSONException -> L75
        if (r110 != null) goto L72;
    L77:
        this.f459468c = 0;
        return;
    L72:
        if (r110.has("version") == false) goto L77;
        this.f459503t0 = this.f459466b.optLong("version", -1);     // Catch: JSONException -> L75
        goto L77
    L63:
        if (r109.has("is_cold_start") == false) goto L69;
        if (this.f459466b.optBoolean("is_cold_start") == false) goto L67;
        int r111 = 1;
    L68:
        this.L = r111;     // Catch: JSONException -> L75
        goto L69
    L67:
        r111 = 0;
        goto L68
    L58:
        if (r108.has("pre_node_selection") == false) goto L60;
        this.K = this.f459466b.optJSONObject("pre_node_selection");     // Catch: JSONException -> L75
        goto L60
    L53:
        if (r107.has("common_sdk_params") == false) goto L55;
        this.f459501s0 = JSONObjectProtectorUtils.getJSONObject(this.f459466b, "common_sdk_params");     // Catch: JSONException -> L75
        goto L55
    L48:
        if (r106.has("major_anchor_level") == false) goto L50;
        this.f459463J = this.f459466b.optString("major_anchor_level");     // Catch: JSONException -> L75
        goto L50
    L43:
        if (r105.has("mode") == false) goto L45;
        this.f459499r0 = this.f459466b.optString("mode");     // Catch: JSONException -> L75
        goto L45
    L38:
        if (r104.has("stream") == false) goto L40;
        this.f459493o0 = this.f459466b.optString("stream");     // Catch: JSONException -> L75
        goto L40
    L20:
        if (r101.has("app_id") == false) goto L22;
        this.E = this.f459466b.optString("app_id");     // Catch: JSONException -> L75
        goto L22
    L11:
        if (r100.has("auto") == false) goto L17;
        JSONObject r112 = JSONObjectProtectorUtils.getJSONObject(this.f459466b, "auto");     // Catch: JSONException -> L75
        if (r112 == null) goto L17;
        if (r112.has("default") == false) goto L17;
        this.f459470d = JSONObjectProtectorUtils.getString(r112, "default");     // Catch: JSONException -> L75
        com.ss.videoarch.liveplayer.log.c.i("LiveStreamInfo", "mDefaultResolution: " + this.f459470d);     // Catch: JSONException -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    }

    public static boolean allowAPIConfig(JSONObject r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.optInt("EnableAPIConfig", 1) != 1) goto L6;
        return true;
    }

    private boolean isNeedUseDefaultResolution(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100.equals("auto") == true) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(this.f459470d) == true) goto L13;
        return true;
    L13:
        return false;
    }

    private String set_url_port_scheme(String r100) {
        int r101 = r100.indexOf(".com");
        int r102 = r100.indexOf(".com:");
        StringBuilder r103 = new StringBuilder(r100);
        if (TextUtils.isEmpty(this.f459484k) == true) goto L20;
        if (r102 == (-1)) goto L15;
        int r104 = r102 + 5;
        int r105 = r104 + 1;
    L7:
        if (r105 >= r103.length()) goto L14;
        if ((r103.charAt(r105) - '0') < 0) goto L14;
        if ((r103.charAt(r105) - '0') > 9) goto L14;
        r105 = r105 + 1;
    L14:
        r103.replace(r104, r105, this.f459484k);
        goto L20
    L15:
        if (r101 == (-1)) goto L20;
        int r106 = r100.indexOf("vhost");
        if (r106 == (-1)) goto L19;
        if (r106 <= r101) goto L20;
    L19:
        r103.insert(r101 + 4, ":" + this.f459484k);
    L20:
        StringBuilder r107 = new StringBuilder(r103.toString());
        int r108 = r107.indexOf("://");
        if (TextUtils.isEmpty(this.f459482j) == true) goto L50;
        if (this.f459482j.equals("kcp") == false) goto L27;
        if (r108 == (-1)) goto L50;
        r107.replace(0, r108, "httpk");
        goto L50
    L27:
        if (this.f459482j.equals("quic") == false) goto L29;
    L47:
        if (r108 == (-1)) goto L50;
        r107.replace(0, r108, "httpq");
        goto L50
    L29:
        if (this.f459482j.equals("quicu") == true) goto L47;
        if (this.f459482j.equals("tls") == false) goto L36;
        if (r108 == (-1)) goto L50;
        r107.replace(0, r108, "https");
        goto L50
    L36:
        if (this.f459482j.equals("tcp") == false) goto L40;
        if (r108 == (-1)) goto L50;
        r107.replace(0, r108, "http");
        goto L50
    L40:
        if (this.f459482j.equals("h2") == false) goto L42;
    L45:
        if (r108 == (-1)) goto L50;
        r107.replace(0, r108, "httpx");
        goto L50
    L42:
        if (this.f459482j.equals("h2q") == true) goto L45;
        if (this.f459482j.equals("h2qu") == true) goto L45;
    L50:
        return r107.toString();
    }

    public a getABRDefaultPlayURL(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L31;
        return null;
    L31:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L28
        if (r101.has("adaptationSet") == false) goto L30;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "adaptationSet");     // Catch: JSONException -> L28
        if (r102 != null) goto L11;
        return null;
    L11:
        if (r102.has("representation") == false) goto L30;
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r102, "representation");     // Catch: JSONException -> L28
        if (r103 != null) goto L15;
        return null;
    L15:
        int r104 = 0;
    L17:
        if (r104 >= r103.length()) goto L30;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r103, r104);     // Catch: JSONException -> L28
        if (r105.has("defaultSelect") == false) goto L27;
        if (r105.has("url") == false) goto L27;
        if (r105.optInt("defaultSelect") != 1) goto L27;
        return new a(this, JSONObjectProtectorUtils.getString(r105, "url"), JSONObjectProtectorUtils.getString(r105, "qualityType"), JSONObjectProtectorUtils.getInt(r105, "bitrate"));
    L27:
        r104 = r104 + 1;
    L30:
        return null;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    }

    public JSONObject getBitrateList(String r110) {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = getSupportedResolutions();     // Catch: JSONException -> L10
        int r102 = 0;
    L5:
        if (r102 >= r101.length()) goto L12;
        String r103 = JSONArrayProtectorUtils.getString(r101, r102);     // Catch: JSONException -> L10
        long r104 = getBitrate(r103, r110);     // Catch: JSONException -> L10
        if (r104 <= 0) goto L9;
        r100.put(r103, r104);     // Catch: JSONException -> L10
    L9:
        r102 = r102 + 1;
    L12:
        return r100;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public long getLowerResBitrate(String r100) {
        long r101 = -1;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        JSONObject r102 = this.B;
        if (r102 == null) goto L8;
        long r103 = r102.optLong(r100);
    L10:
        if (r103 == (-1)) goto L21;
        List<Long> r104 = this.f459485k0;
        if (r104 == null) goto L21;
        if (r104.isEmpty() == true) goto L21;
        Collections.sort(this.f459485k0);
        int r105 = 0;
    L17:
        if (r105 >= this.f459485k0.size()) goto L21;
        long r106 = ((Long) ListProtector.get(this.f459485k0, r105)).longValue();
        if (r103 <= r106) goto L21;
        r105 = r105 + 1;
        r101 = r106;
    L21:
        return r101;
    L8:
        r103 = -1;
        goto L10
    }

    public String getNeptuneName(String r110) {
        if (this.f459491n0 != null) goto L35;
        HashMap<String, String> r100 = new AnonymousClass1(this);
        JSONObject r101 = this.f459464a;
        if (r101 != null) goto L7;
        return null;
    L7:
        Iterator<String> r102 = r101.keys();
    L9:
        if (r102.hasNext() == false) goto L33;
        String r103 = r102.next();
        if (r103 == "md") goto L9;
        if (r103 == "auto") goto L9;
        JSONObject r104 = this.f459464a.optJSONObject(r103);
        Iterator<String> r105 = r100.keySet().iterator();
    L17:
        if (r105.hasNext() == false) goto L33;
        String r106 = r105.next();
        JSONObject r107 = r104.optJSONObject(r106);
        if (r107 == null) goto L17;
        String r108 = r107.optString("flv");
        if (r108 == null) goto L17;
        String r109 = new URL(r108).getFile();     // Catch: MalformedURLException -> L28
        if (r109.indexOf(HTTP.URL_DEFAULT) >= r109.lastIndexOf(HTTP.URL_DEFAULT)) goto L30;
        String r111 = r109.substring(r109.indexOf(HTTP.URL_DEFAULT) + 1, r109.lastIndexOf(HTTP.URL_DEFAULT));     // Catch: MalformedURLException -> L28
    L31:
        if (r111 == null) goto L17;
        r100.put(r106, r111);
    L30:
        r111 = null;
    L28:
        e = move-exception;
        e.printStackTrace();
    L33:
        this.f459491n0 = r100;
    L35:
        return this.f459491n0.get(r110);
    }

    public int getPushId(String r100) {
        if (r100 == null) goto L9;
        JSONObject r101 = this.f459466b;
        if (r101 == null) goto L9;
        return r101.optInt(r100.concat("_push_id"), 0);
    L9:
        return 0;
    }

    public JSONObject getPushStreamInfo(String r100) {
        JSONObject r101 = this.A;
        if (r101 == null) goto L29;
        return r101;
    L29:
        JSONObject r102 = this.f459464a;     // Catch: JSONException -> L25
        JSONObject r103 = null;
        if (r102 == null) goto L8;
        String r104 = r102.optString(PlayerResolution.SDKKEY.ORIGIN);     // Catch: JSONException -> L25
    L9:
        if (r104 == null) goto L13;
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L25
        if (r105.has(r100) == false) goto L13;
        r103 = mergeSdkParams(r100, new JSONObject(new JSONObject(r105.optString(r100)).optString(OrderParamsKey.KEY_SDK_PARAM)));     // Catch: JSONException -> L25
    L13:
        if (r103 == null) goto L28;
        this.A = new JSONObject();     // Catch: JSONException -> L25
        if (r103.has("resolution") == false) goto L22;
        String r106 = r103.optString("resolution");     // Catch: JSONException -> L25
        if (TextUtils.isEmpty(r106) == true) goto L22;
        if (r106.contains("x") == false) goto L22;
        this.A.put("push_client_resolution", r106.replace(Permission.EXECUTE, '*'));     // Catch: JSONException -> L25
    L22:
        if (r103.has("VCodec") == false) goto L28;
        this.A.put("push_client_codec_type", r103.optString("VCodec"));     // Catch: JSONException -> L25
    L28:
        return this.A;
    L8:
        r104 = null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public JSONObject getResolutionList(String r100) {
        JSONObject r101 = new JSONObject();
        JSONArray r102 = getSupportedResolutions();     // Catch: JSONException -> L12
        int r103 = 0;
    L5:
        if (r103 >= r102.length()) goto L14;
        String r104 = JSONArrayProtectorUtils.getString(r102, r103);     // Catch: JSONException -> L12
        String r105 = new JSONObject(getSDKParams(r104, r100)).optString("resolution", null);     // Catch: JSONException -> L12
        if (r105 == null) goto L11;
        if (r105.isEmpty() == true) goto L11;
        r101.put(r104, r105);     // Catch: JSONException -> L12
    L11:
        r103 = r103 + 1;
    L14:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public int getShortEdgeForResolution(String r100) {
        String r101 = "backup";
        String r102 = this.f459464a.optString(r100);     // Catch: JSONException -> L28
        JSONObject r103 = null;
        if (TextUtils.isEmpty(r102) == true) goto L15;
        JSONObject r104 = new JSONObject(r102);     // Catch: JSONException -> L28
        if (r104.has(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L9;
        JSONObject r105 = new JSONObject(r104.optString(PullConfiguration.PROCESS_NAME_MAIN));     // Catch: JSONException -> L28
        r101 = PullConfiguration.PROCESS_NAME_MAIN;
    L12:
        if (r105 == null) goto L14;
        r103 = new JSONObject(r105.optString(OrderParamsKey.KEY_SDK_PARAM));     // Catch: JSONException -> L28
    L14:
        r103 = mergeSdkParams(r101, r103);     // Catch: JSONException -> L28
        goto L15
    L9:
        if (r104.has("backup") == false) goto L11;
        r105 = new JSONObject(r104.optString("backup"));     // Catch: JSONException -> L28
        goto L12
    L11:
        r101 = "";
        r105 = null;
    L15:
        if (r103 == null) goto L33;
        String r106 = r103.optString("resolution");     // Catch: JSONException -> L28
        if (TextUtils.isEmpty(r106) == false) goto L19;
        return -1;
    L19:
        if (r106.contains("x") == false) goto L35;
        String[] r107 = r106.split("x");     // Catch: JSONException -> L28
        if (r107 != null) goto L23;
    L27:
        return -1;
    L23:
        if (r107.length < 2) goto L27;
        return Math.min(CastIntegerProtector.parseInt(r107[0]), CastIntegerProtector.parseInt(r107[1]));
    L35:
        return -1;
    L33:
        return -1;
    L28:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public JSONObject getStartupBitrateList(String r100) {
        JSONObject r101 = new JSONObject();
        JSONArray r102 = getSupportedResolutions();     // Catch: JSONException -> L10
        int r103 = 0;
    L5:
        if (r103 >= r102.length()) goto L12;
        String r104 = JSONArrayProtectorUtils.getString(r102, r103);     // Catch: JSONException -> L10
        int r105 = getStartupBitrate(r104, r100);     // Catch: JSONException -> L10
        if (r105 <= 0) goto L9;
        r101.put(r104, r105);     // Catch: JSONException -> L10
    L9:
        r103 = r103 + 1;
    L12:
        return r101;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public JSONObject getTemplateList(String r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = getTemplateJson();
        if (r102 != null) goto L12;
    L11:
        return r101;
    L12:
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L9
    L6:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();     // Catch: JSONException -> L9
        r101.put(r104, JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r102, r104), r100));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public boolean isCodecSame(String r100) {
        JSONObject r101 = this.f459464a;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.length() > 0) goto L8;
        return false;
    L8:
        int r102 = this.f459476g;
        if (r102 < 0) goto L13;
        if (r102 != 1) goto L46;
        return true;
    L46:
        return false;
    L13:
        this.f459476g = 1;
        Iterator<String> r103 = this.f459464a.keys();
        String r104 = null;
        String r105 = null;
    L15:
        if (r103.hasNext() == false) goto L30;
        String r106 = r103.next();
        if (isEnableAdaptive(r106) == false) goto L15;
        r105 = getVCodec(r106, r100);
        if (TextUtils.isEmpty(r104) == true) goto L27;
        if (TextUtils.isEmpty(r105) == true) goto L27;
        if (r105.equals(r104) == true) goto L27;
        this.f459476g = 0;
    L27:
        if (TextUtils.isEmpty(r105) == true) goto L15;
        r104 = r105;
    L30:
        if (TextUtils.isEmpty(r105) == false) goto L35;
        if (TextUtils.isEmpty(r104) == false) goto L35;
        this.f459476g = 0;
    L35:
        if (this.f459476g != 1) goto L47;
        return true;
    L47:
        return false;
    }

    public boolean isEnableAdaptive(String r100) {
        return isEnableAdaptive(r100, null);
    }

    public boolean isFpsSupportSDR2HDR(float r100) {
        if (r100 > this.f459511x0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFpsSupportSR(float r100) {
        int r101 = this.f459500s;
        if (r101 > 0) goto L5;
    L7:
        return true;
    L5:
        if (r100 <= r101) goto L7;
        return false;
    }

    public boolean isFpsSupportSharpen(float r100) {
        int r101 = this.Q;
        if (r101 > 0) goto L5;
    L6:
        int r102 = this.R;
        if (r102 > 0) goto L9;
    L11:
        return true;
    L9:
        if (r100 > r102) goto L11;
    L10:
        return false;
    L5:
        if (r100 > r101) goto L10;
        goto L6
    }

    public boolean isInErrorSet(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        HashSet<String> r101 = this.f459497q0;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.contains(r100) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public boolean isSupport(String r100) {
        if (this.f459464a != null) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L26;
        if (this.f459469c0 == 1) goto L10;
    L14:
        JSONObject r101 = null;
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        if (r101 == null) goto L26;
        if (this.f459469c0 != 1) goto L25;
        this.f459477g0.add(r100);
    L25:
        return true;
    L16:
        if (this.f459464a.has(r100) == false) goto L21;
        r101 = JSONObjectProtectorUtils.getJSONObject(this.f459464a, r100);     // Catch: JSONException -> L19
        goto L21
    L10:
        if (this.f459477g0.isEmpty() == true) goto L14;
        if (this.f459477g0.contains(r100) == false) goto L14;
        return true;
    }

    public void removeErrorRes(HashSet<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.f459464a == null) goto L27;
        this.f459497q0 = r100;
        Iterator<String> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L28;
        String r102 = r101.next();
        if (this.f459464a.has(r102) == false) goto L14;
        this.f459464a.remove(r102);
    L14:
        JSONObject r103 = this.f459495p0;
        if (r103 == null) goto L17;
        r103.remove(r102);
    L17:
        HashSet<String> r104 = this.f459477g0;
        if (r104 == null) goto L10;
        r104.remove(r102);
        goto L10
    L28:
        return;
    }

    public void setCmafDegrade(int r100) {
        this.f459488m = r100;
    }

    public void setDefaultResolution(String r100) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L8;
        return;
    L8:
        this.f459470d = r100;
    }

    public void setEnableGetMpdUrlOpt(int r100) {
        this.f459469c0 = r100;
    }

    public void setFastOpenDuration(int r100) {
        this.N = r100;
        com.ss.videoarch.liveplayer.log.c.i("LiveStreamInfo", "setFastOpenDuration: " + r100);
    }

    public boolean setFlag(int r100) {
        this.f459468c = r100 | this.f459468c;
        return true;
    }

    public void setForceTSL(boolean r100) {
        this.D = r100;
    }

    public void setRequestParams(String r100) {
        this.f459472e = r100;
    }

    public void setRtcFallback(int r100) {
        this.f459486l = r100;
    }

    public void setStartPlayResolution(String r100) {
        this.f459483j0 = r100;
    }

    public void setStartupResListStr(String r100) {
        this.f459479h0 = r100;
    }

    private JSONObject mergeSdkParams(String r100, JSONObject r101) {
        JSONObject r102 = this.f459501s0;
        if (r102 != null) goto L5;
    L51:
        return r101;
    L5:
        if (r102.length() == 0) goto L51;
        JSONObject r103 = null;
        ConcurrentHashMap<String, JSONObject> r104 = this.f459487l0.get("common");     // Catch: Exception -> L18
        if (r104 != null) goto L11;
    L13:
        ConcurrentHashMap<String, JSONObject> r105 = new ConcurrentHashMap();     // Catch: Exception -> L18
        if (this.f459501s0.has(r100) == false) goto L16;
        r103 = new JSONObject(this.f459501s0.optString(r100));     // Catch: Exception -> L18
    L16:
        r105.put(r100, r103);     // Catch: Exception -> L18
        this.f459487l0.put("common", r105);     // Catch: Exception -> L18
        r103.length();     // Catch: Exception -> L18
    L20:
        JSONObject r106 = r103;
    L21:
        if (r106 == null) goto L51;
        if (r106.length() == 0) goto L51;
        if (r101 != null) goto L27;
    L50:
        return r106;
    L27:
        if (r101.length() == 0) goto L50;
        if (r106.has("EnablePercentType") == false) goto L34;
        boolean r107 = true;
        if (r106.optInt("EnablePercentType") != 1) goto L34;
    L35:
        r101.length();
        Iterator<String> r108 = r106.keys();     // Catch: Exception -> L46
    L37:
        if (r108.hasNext() == false) goto L48;
        String r109 = r108.next();     // Catch: Exception -> L46
        if (r107 == true) goto L44;
        if (r101.has(r109) == true) goto L37;
    L44:
        r101.put(r109, r106.get(r109));     // Catch: Exception -> L46
    L48:
        r101.length();
        return r101;
    L46:
        e = move-exception;
        e.printStackTrace();
    L34:
        r107 = false;
        goto L35
    L11:
        if (r104.get(r100) == null) goto L13;
        r106 = r104.get(r100);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    private String parseSDKParams(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L13;
        return null;
    L13:
        return JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(this.f459464a, r100), r101).optString(OrderParamsKey.KEY_SDK_PARAM);
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public JSONObject getABRTags(String r100, String r101) {
        JSONObject r102 = getSDKParamsJson(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.optJSONObject("ABRTags");
    }

    public String getAvLinesParams(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L15;
        r100 = this.f459470d;
    L15:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L12
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r102.has("AvLines") == false) goto L18;
        return r102.optString("AvLines");
    L18:
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public long getBitrate(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L9;
        return 0;
    L9:
        if (r100.equals(PlayerResolution.SDKKEY.ORIGIN) == false) goto L22;
        long r102 = this.f459474f;
        if (r102 <= 0) goto L22;
        return r102;
    L22:
        JSONObject r103 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L19
        if (r103 != null) goto L16;
        return 0;
    L16:
        if (r103.has(GearStrategyConsts.EV_VIDEO_BITRATE) == false) goto L25;
        return r103.optLong(GearStrategyConsts.EV_VIDEO_BITRATE);
    L25:
        return 0;
    L19:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public JSONObject getCMAFParams(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return null;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: JSONException -> L14
        if (r102 != null) goto L11;
    L16:
        return null;
    L11:
        if (r102.has("cmaf") == false) goto L16;
        return new JSONObject(r102.optString("cmaf"));
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public int getCheckSilenceInterval(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return -1;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
        return -1;
    L11:
        if (r102.has("CheckSilenceInterval") == false) goto L20;
        return r102.optInt("CheckSilenceInterval");
    L20:
        return -1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public String getDRType(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return null;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
        return null;
    L11:
        if (r102.has("drType") == false) goto L20;
        return r102.optString("drType");
    L20:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public long getFastOpenDuration(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L8;
        return -1;
    L8:
        int r102 = this.N;
        if (r102 != (-1)) goto L11;
        JSONObject r103 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L18
        if (r103 != null) goto L15;
        return -1;
    L15:
        if (r103.has("FastOpenDuration") == false) goto L24;
        return r103.optLong("FastOpenDuration");
    L24:
        return -1;
    L18:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L11:
        return r102;
    }

    public long getGopDuration(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return 0;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
        return 0;
    L11:
        if (r102.has("gop") == false) goto L20;
        return r102.optLong("gop");
    L20:
        return 0;
    L14:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public JSONObject getMkRenderParams(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return null;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: JSONException -> L14
        if (r102 != null) goto L11;
    L16:
        return null;
    L11:
        if (r102.has("MKRL") == false) goto L16;
        return new JSONObject(r102.optString("MKRL"));
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public String getResolutionOfTemplate(String r100, String r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        JSONObject r102 = getTemplateJson();
        if (r102 == null) goto L13;
        Iterator<String> r103 = r102.keys();
    L9:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();
        if (r101.equals(r102.optJSONObject(r104).optString(r100, null)) == false) goto L9;
        return r104;
    L13:
        return null;
    }

    public String getSDKParams(String r100, String r101) {
        JSONObject r102 = getSDKParamsJson(r100, r101);
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102.toString();
    }

    public JSONObject getSDKParamsJson(String r100, String r101) {
        JSONObject r102 = null;
        ConcurrentHashMap<String, JSONObject> r103 = this.f459487l0.get(r100);     // Catch: Exception -> L16
        if (r103 != null) goto L6;
    L8:
        String r104 = parseSDKParams(r100, r101);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r104) == true) goto L19;
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L16
        r102 = mergeSdkParams(r101, r105);     // Catch: Exception -> L14
        ConcurrentHashMap<String, JSONObject> r106 = new ConcurrentHashMap();     // Catch: Exception -> L16
        r106.put(r101, r102);     // Catch: Exception -> L16
        this.f459487l0.put(r100, r106);     // Catch: Exception -> L16
    L14:
        e = e;
        r102 = r105;
    L17:
        e.printStackTrace();
    L18:
        return r102;
    L19:
        goto L18
    L6:
        if (r103.get(r101) == null) goto L8;
        r102 = r103.get(r101);     // Catch: Exception -> L16
    L16:
        e = e;
        goto L17
    }

    public JSONObject getSDR2HDRParams(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L8;
        return null;
    L8:
        JSONObject r102 = getSDKParamsJson(r100, r101);
        if (r102 != null) goto L12;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");
        return null;
    L12:
        JSONObject r103 = r102.optJSONObject("SDR2HDR");
        if (r103 != null) goto L15;
        return null;
    L15:
        boolean r104 = true;
        if (r103.optInt("Enabled") == 1) goto L18;
    L20:
        r104 = false;
    L21:
        this.f459505u0 = r104;
        this.f459507v0 = r103.optInt("LongerSideUpperBound", Integer.MAX_VALUE);
        this.f459509w0 = r103.optInt("ShorterSideUpperBound", Integer.MAX_VALUE);
        this.f459511x0 = r103.optInt("FrameRateUpperBound", Integer.MAX_VALUE);
        return r103;
    L18:
        if (cnc.c.isSupportArm64() == false) goto L20;
        goto L20
    }

    public JSONObject getSRParams(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L32;
        return null;
    L32:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: JSONException -> L29
        if (r102 != null) goto L13;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: JSONException -> L29
        return null;
    L13:
        JSONObject r103 = new JSONObject(r102.optString("NNSR"));     // Catch: JSONException -> L29
        if (r103.optInt("EnableInArm64") == 1) goto L16;
    L18:
        this.f459490n = r103.optInt("ShorterSideUpperBound");     // Catch: JSONException -> L29
        this.f459492o = r103.optInt("LongerSideUpperBound");     // Catch: JSONException -> L29
        if (r103.has("PanoEnabled") == false) goto L22;
        this.f459494p = r103.optInt("PanoEnabled");     // Catch: JSONException -> L29
    L22:
        if (r103.has("PanoShorterSideUpperBound") == false) goto L25;
        this.f459496q = r103.optInt("PanoShorterSideUpperBound");     // Catch: JSONException -> L29
    L25:
        if (r103.has("PanoLongerSideUpperBound") == false) goto L27;
        this.f459498r = r103.optInt("PanoLongerSideUpperBound");     // Catch: JSONException -> L29
    L27:
        com.ss.videoarch.liveplayer.log.c.i("LiveStreamInfo", "PanoEnabled:" + this.f459494p + ",PanoShorterSideUpperBound:" + this.f459496q + ",PanoLongerSideUpperBound:" + this.f459498r);     // Catch: JSONException -> L29
        this.f459500s = r103.optInt("FrameRateUpperBound");     // Catch: JSONException -> L29
        return r103;
    L16:
        if (cnc.c.isSupportArm64() == true) goto L18;
        return null;
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int getStartupBitrate(String r100, String r101) {
        JSONObject r102 = this.f459464a;
        if (r102 != null) goto L5;
        return -1;
    L5:
        JSONObject r103 = r102.optJSONObject(r100);
        JSONObject r104 = null;
        if (r103 == null) goto L8;
        JSONObject r105 = r103.optJSONObject(r101);
    L9:
        if (r105 == null) goto L11;
        r104 = r105.optJSONObject("templateRealTimeInfo");
    L11:
        if (r104 == null) goto L13;
        int r106 = r104.optInt("bitrateKbps", -1);
    L14:
        if (r106 > 0) goto L16;
        return -1;
    L16:
        return r106 * 1000;
    L13:
        r106 = -1;
        goto L14
    L8:
        r105 = null;
        goto L9
    }

    public Rect getStreamResolution(String r100, String r101) {
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L16
        if (r102 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: Exception -> L16
        return null;
    L7:
        String[] r103 = r102.optString("resolution").split("x");     // Catch: Exception -> L16
        if (r103.length >= 2) goto L19;
        return null;
    L19:
        return new Rect(0, 0, CastIntegerProtector.parseInt(r103[0]), CastIntegerProtector.parseInt(r103[1]));
    L15:
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getSuggestAccessCode(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L22;
        return null;
    L22:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
    L16:
        String r103 = null;
    L17:
        if (r103 != null) goto L19;
        return null;
    L19:
        if (r103.isEmpty() == false) goto L21;
        return null;
    L21:
        return r103;
    L11:
        if (r102.has("SuggestAccessCode") == false) goto L16;
        r103 = r102.optString("SuggestAccessCode");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public String getSuggestFormat(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L23;
        return null;
    L23:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
    L16:
        String r103 = null;
    L17:
        if (r103 != null) goto L19;
        return null;
    L19:
        if (r103.isEmpty() == false) goto L22;
        return null;
    L22:
        return r103;
    L11:
        if (r102.has("SuggestFormat") == false) goto L16;
        r103 = r102.optString("SuggestFormat");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public String getSuggestProtocol(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L22;
        return null;
    L22:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L12;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: Exception -> L14
        return null;
    L12:
        String r103 = r102.optString("SuggestProtocol");     // Catch: Exception -> L14
        this.S = r102.optInt("QuicDisableOnFreeFlow", 0);     // Catch: Exception -> L14
        this.T = r102.optString("QuicPluginMinVersion", "1.0.105.5");     // Catch: Exception -> L14
        this.U = r102.optInt("EnableQuicPluginVersionCheck", 0);     // Catch: Exception -> L14
        this.V = r102.optInt("EnableQuicDegradeInNonPreivew", 0);     // Catch: Exception -> L14
        this.W = r102.optInt("EnableQuicByUserSetQosConstraint", 0);     // Catch: Exception -> L14
        this.Z = r102.optString("FastFirstFrameProtocol", "h2q");     // Catch: Exception -> L14
        this.X = r102.optInt("EnableQuicDegradeInFaultFormat", 0);     // Catch: Exception -> L14
        this.Y = r102.optInt("EnableLSSSuggestProtocol", 0);     // Catch: Exception -> L14
    L16:
        com.ss.videoarch.liveplayer.log.c.i("LiveStreamInfo", "protocol:" + r103 + ", mDisableQuicOnFreeFlow: " + this.S + ", mQuicPluginMinVersion:" + this.T + ", mEnableQuicDegradeInNonPreivew: " + this.V + ", mEnableQuicByUserSetQosConstraint: " + this.W + ", mEnableQuicDegradeInFaultFormat: " + this.X + ", mFastFirstFrameProtocol: " + this.Z + ", mEnableLSSSuggestProtocol: " + this.Y);
        if (r103 != null) goto L19;
        return null;
    L19:
        if (r103.isEmpty() == false) goto L21;
        return null;
    L21:
        return r103;
    L14:
        e = move-exception;
        e.printStackTrace();
        r103 = null;
        goto L16
    }

    public String getTemplateName(String r100, int r101) {
        JSONObject r102 = getBitrateList(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        Iterator<String> r103 = r102.keys();
    L7:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();
        if (r102.optInt(r104, -1) != r101) goto L7;
    L12:
        JSONObject r105 = getTemplateJson();
        if (r105 == null) goto L21;
        JSONObject r106 = r105.optJSONObject(r104);
        if (r106 != null) goto L17;
        return null;
    L17:
        return r106.optString(r100, null);
    L21:
        return null;
    L11:
        r104 = null;
        goto L12
    }

    public long getTemplateNominalBitrate(String r100, String r101) {
        String r102 = getResolutionOfTemplate(r100, r101);
        if (r102 != null) goto L7;
        return -1;
    L7:
        return getBitrate(r102, r100);
    }

    public String getVCodec(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return null;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
        return null;
    L11:
        if (r102.has("VCodec") == false) goto L20;
        return r102.optString("VCodec");
    L20:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int getVResolution(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L34;
        return -1;
    L34:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L24
        if (r102 != null) goto L12;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: Exception -> L24
        return -1;
    L12:
        String[] r103 = r102.optString("resolution").split("x");     // Catch: Exception -> L24
        if (r103.length >= 2) goto L32;
        return -1;
    L32:
        int r104 = CastIntegerProtector.parseInt(r103[0]);     // Catch: NumberFormatException -> L23 Exception -> L24
        int r105 = CastIntegerProtector.parseInt(r103[1]);     // Catch: Exception -> L21 NumberFormatException -> L23
    L27:
        if (r104 == (-1)) goto L36;
        if (r105 != (-1)) goto L31;
        return -1;
    L31:
        return r104 | (r105 << 16);
    L36:
        return -1;
    L21:
        e = e;
    L26:
        e.printStackTrace();
        r105 = -1;
    L23:
        return -1;
    L24:
        e = e;
        r104 = -1;
        goto L26
    }

    public String getVideoSize(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L17;
        return null;
    L17:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L14
        if (r102 != null) goto L11;
        return null;
    L11:
        if (r102.has("resolution") == false) goto L20;
        return r102.optString("resolution");
    L20:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean isEnableAdaptive(String r100, String r101) {
        return isEnableAdaptive(r100, false, r101);
    }

    public boolean isResSupportSDR2HDR(String r100, String r101) {
        if (this.f459505u0 == true) goto L5;
        return false;
    L5:
        Rect r102 = getStreamResolution(r100, r101);
        if (r102 != null) goto L8;
        return false;
    L8:
        int r103 = Math.max(r102.width(), r102.height());
        int r104 = Math.min(r102.width(), r102.height());
        if (r103 <= this.f459507v0) goto L11;
        return false;
    L11:
        if (r104 > this.f459509w0) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isResSupportSharpen(String r100, String r101) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L23;
        return false;
    L23:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L20
        if (r102 != null) goto L12;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: Exception -> L20
        return false;
    L12:
        String[] r103 = r102.optString("resolution").split("x");     // Catch: Exception -> L20
        if (r103.length >= 2) goto L24;
        return false;
    L24:
        int r104 = CastIntegerProtector.parseInt(r103[0]);     // Catch: NumberFormatException -> L19 Exception -> L20
        int r105 = CastIntegerProtector.parseInt(r103[1]);     // Catch: NumberFormatException -> L19 Exception -> L20
        return isResSupportSharpen(r104, r105, r102.has("VR"));
    L19:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void setTransportProtocol(String r100, String r101) {
        this.f459482j = r100;
        this.f459484k = r101;
    }

    public boolean compareRes(String r100, String r101, String r102) {
        if (this.f459464a != null) goto L5;
        return false;
    L5:
        if (isSupport(r100) == true) goto L7;
        return false;
    L7:
        if (isSupport(r101) == false) goto L20;
        ArrayList r103 = new ArrayList();
        r103.add(PlayerResolution.SDKKEY.LD);
        r103.add(PlayerResolution.SDKKEY.SD);
        r103.add(PlayerResolution.SDKKEY.HD);
        r103.add(PlayerResolution.SDKKEY.UHD);
        r103.add(PlayerResolution.SDKKEY.ORIGIN);
        int r104 = r103.indexOf(r100);
        int r105 = r103.indexOf(r101);
        if (r104 == (-1)) goto L17;
        if (r105 == (-1)) goto L18;
        if (r104 <= r105) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L20:
        return false;
    }

    public JSONObject getAbrBitrateMap(String r100, int r101, String r102) {
        JSONObject r103 = this.B;
        if (r103 == null) goto L5;
        return r103;
    L5:
        JSONObject r104 = this.f459464a;
        if (r104 != null) goto L9;
        return null;
    L9:
        if (r104.length() > 0) goto L11;
        return null;
    L11:
        Iterator<String> r105 = this.f459464a.keys();
        this.B = new JSONObject();
    L30:
        if (r105.hasNext() == false) goto L29;
        String r106 = r105.next();     // Catch: JSONException -> L26
        if (r101 != 21) goto L22;
        if (TextUtils.isEmpty(this.f459479h0) == true) goto L22;
        if (this.f459479h0.contains("\"" + r106 + "\"") == false) goto L30;
    L22:
        if (isEnableAdaptive(r106, r102) == false) goto L30;
        this.B.put(r106, getBitrate(r106, r100));     // Catch: JSONException -> L26
    L29:
        return this.B;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    public JSONObject getAbrResolutionMap(String r100, int r101, String r102) {
        JSONObject r103 = this.C;
        if (r103 == null) goto L5;
        return r103;
    L5:
        JSONObject r104 = this.f459464a;
        if (r104 != null) goto L9;
        return null;
    L9:
        if (r104.length() > 0) goto L11;
        return null;
    L11:
        Iterator<String> r105 = this.f459464a.keys();
        this.C = new JSONObject();
    L25:
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        return this.C;
    L13:
        if (r105.hasNext() == false) goto L24;
        String r106 = r105.next();     // Catch: JSONException -> L21
        if (isEnableAdaptive(r106, r102) == false) goto L25;
        String r107 = getVideoSize(r106, r100);     // Catch: JSONException -> L21
        if (r107 == null) goto L25;
        this.C.put(r106, r107);     // Catch: JSONException -> L21
        goto L25
    }

    public String getLabelfromBitrate(long r100, String r101, String r110) {
        JSONObject r102 = this.f459464a;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.length() > 0) goto L8;
        return null;
    L8:
        Iterator<String> r103 = this.f459464a.keys();
    L10:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();
        if (isEnableAdaptive(r104, r110) == false) goto L10;
        if (r100 != getBitrate(r104, r101)) goto L10;
        return r104;
    L17:
        return null;
    }

    public String getPortNum(String r100, String r101, String r102) {
        if (this.f459466b != null) goto L6;
        return null;
    L6:
        if (r100.equals("rtmp") == false) goto L8;
        String r103 = "rtmp_ports";
    L21:
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        String r104 = null;
    L17:
        if (TextUtils.isEmpty(r104) == false) goto L20;
        return null;
    L20:
        return r104;
    L10:
        if (this.f459466b.has(r103) == false) goto L15;
        r104 = new JSONObject(JSONObjectProtectorUtils.getJSONObject(this.f459466b, r103).optString(r101)).optString(r102);     // Catch: JSONException -> L13
        goto L17
    L8:
        r103 = "http_ports";
        goto L21
    }

    public JSONObject getSharpenParams(String r100, String r101, boolean r110) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L51;
        return null;
    L51:
        JSONObject r102 = getSDKParamsJson(r100, r101);     // Catch: JSONException -> L48
        if (r102 != null) goto L13;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: JSONException -> L48
        return null;
    L13:
        if (r102.has("ASF") == false) goto L17;
        JSONObject r103 = new JSONObject(r102.optString("ASF"));     // Catch: JSONException -> L48
    L15:
        JSONObject r104 = r103;
    L45:
        if (r103 == null) goto L47;
        this.f459502t = r103.optInt("LongerSideUpperBound");     // Catch: JSONException -> L48
        this.f459504u = r103.optInt("LongerSideLowerBound");     // Catch: JSONException -> L48
        this.f459506v = r103.optInt("ShorterSideUpperBound");     // Catch: JSONException -> L48
        this.f459508w = r103.optInt("ShorterSideLowerBound");     // Catch: JSONException -> L48
        this.R = r103.optInt("FrameRateLowerBound");     // Catch: JSONException -> L48
        this.Q = r103.optInt("FrameRateUpperBound");     // Catch: JSONException -> L48
    L47:
        return r104;
    L17:
        if (r102.has("BMFASF") == false) goto L44;
        r103 = new JSONObject(r102.optString("BMFASF"));     // Catch: JSONException -> L48
        if (r103.optInt("Enabled") != 1) goto L22;
        this.O = true;     // Catch: JSONException -> L48
    L22:
        if (this.O == false) goto L27;
        if (r103.optInt("EnableInArm64") != 1) goto L27;
        this.O = cnc.c.isSupportArm64();     // Catch: JSONException -> L48
    L27:
        if (r103.optInt("PanoEnabled") != 1) goto L30;
        this.P = true;     // Catch: JSONException -> L48
    L30:
        if (this.P == false) goto L33;
        this.f459510x = r103.optInt("PanoLongerSideUpperBound");     // Catch: JSONException -> L48
        this.f459512y = r103.optInt("PanoShorterSideUpperBound");     // Catch: JSONException -> L48
    L33:
        if (this.O == true) goto L35;
        r104 = r103;
        r103 = null;
        goto L45
    L35:
        if (r103.has("Preview") == false) goto L40;
        if (r110 == false) goto L40;
        JSONObject r105 = r103.optJSONObject("Preview");     // Catch: JSONException -> L48
    L38:
        r103 = r105;
        r104 = r103;
    L40:
        if (r103.has("NonPreview") == false) goto L15;
        if (r110 == true) goto L15;
        r105 = r103.optJSONObject("NonPreview");     // Catch: JSONException -> L48
        goto L38
    L44:
        r104 = null;
        r103 = null;
    L48:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getStreamUrlForInputFormat(String r100, String r101, String r102) {
        if (isSupport(r100) == true) goto L15;
        return null;
    L15:
        JSONObject r103 = new JSONObject(this.f459464a.optString(r100));     // Catch: JSONException -> L9
        if (r103.has(r102) == false) goto L11;
        JSONObject r104 = new JSONObject(r103.optString(r102));     // Catch: JSONException -> L9
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.optString(r101);
    L11:
        r104 = null;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String getStreamUrlForResolution(String r100, String r101, String r102) {
        String r103 = "flv";
        String r104 = null;
        if (TextUtils.isEmpty(r100) == true) goto L16;
        if (r100.equals("auto") == false) goto L16;
        if ("flv".equals(r101) == true) goto L11;
        if ("llash".equals(r101) == false) goto L16;
    L11:
        if (TextUtils.isEmpty(this.f459470d) == false) goto L14;
        return null;
    L14:
        return getMPDForFormat(r101, r102, this.f459478h, this.f459480i);
    L16:
        if (isSupport(r100) == true) goto L94;
        return null;
    L94:
        JSONObject r105 = new JSONObject(this.f459464a.optString(r100));     // Catch: JSONException -> L41
        if (r105.has(r102) == false) goto L40;
        JSONObject r106 = new JSONObject(r105.optString(r102));     // Catch: JSONException -> L41
    L38:
        e = e;
    L43:
        e.printStackTrace();
        String r107 = null;
    L45:
        if ("avph".equals(r101) == false) goto L48;
        r101 = "flv";
    L48:
        if (r107 != null) goto L50;
    L53:
        r107 = r101;
    L55:
        if ((this.f459468c & 1) <= 0) goto L59;
        if (r107.equals("cmaf") == false) goto L59;
    L60:
        r107 = r101;
    L62:
        if (this.f459486l != 1) goto L64;
    L65:
        r107 = "flv";
    L67:
        if (TextUtils.equals(r101, "tsl") == false) goto L69;
    L70:
        com.ss.videoarch.liveplayer.log.c.i("LiveStreamInfo", "set format tsl");
        r107 = "tsl";
    L71:
        if (r106 == null) goto L79;
        if (r107 != null) goto L74;
    L76:
        r103 = r107;
    L77:
        r104 = r106.optString(r103);
        goto L79
    L74:
        if (r107.equals("avph") == false) goto L76;
    L79:
        if (TextUtils.isEmpty(r104) == true) goto L96;
        String r108 = getQueryItems();
        if (r108 != null) goto L83;
        return r104;
    L83:
        if (r108.equals("") == true) goto L98;
        int r109 = r104.indexOf("?");
        if (r109 != (-1)) goto L88;
        r108 = "?" + r108.substring(1);
    L91:
        return r104 + r108;
    L88:
        if (r109 != (r104.length() - 1)) goto L91;
        r108 = r108.substring(1);
        goto L91
    L98:
        return r104;
    L96:
        return r104;
    L69:
        if (this.D == false) goto L71;
    L64:
        if ((this.f459468c & 2) <= 0) goto L67;
    L59:
        if (this.f459488m != 1) goto L62;
    L50:
        if (r107.equals("") == true) goto L53;
        if (r107.equals("avph") == false) goto L55;
    L23:
        if (this.f459471d0 == 1) goto L25;
    L27:
        JSONObject r110 = mergeSdkParams(r102, new JSONObject(r106.optString(OrderParamsKey.KEY_SDK_PARAM)));     // Catch: JSONException -> L38
        if (r110.has("SuggestFormat") == false) goto L30;
        r107 = r110.optString("SuggestFormat");     // Catch: JSONException -> L38
    L31:
        this.f459473e0 = r107;     // Catch: JSONException -> L38
    L33:
        if (TextUtils.isEmpty(this.F) == true) goto L45;
        if (this.F.equals("none") == true) goto L45;
        r107 = this.F;     // Catch: JSONException -> L38
        goto L45
    L30:
        r107 = null;
        goto L31
    L25:
        if (TextUtils.isEmpty(this.f459473e0) == true) goto L27;
        r107 = this.f459473e0;     // Catch: JSONException -> L38
        goto L33
    L40:
        r107 = null;
        r106 = null;
    L41:
        e = e;
        r106 = null;
        goto L43
    }

    public boolean isBitrateAbnormal(String r110, String r111, long r112) {
        boolean r100 = true;
        long r101 = 0;
        if (r112 <= 0) goto L8;
        if (this.f459474f <= 0) goto L8;
        return true;
    L8:
        if (isEnableAdaptive(PlayerResolution.SDKKEY.ORIGIN) == true) goto L10;
        return false;
    L10:
        long r113 = getBitrate(PlayerResolution.SDKKEY.ORIGIN, r111);
        String r114 = PlayerResolution.SDKKEY.UHD;
    L12:
        if (TextUtils.isEmpty(r114) == true) goto L64;
        if (isEnableAdaptive(r114) == true) goto L16;
    L23:
        int r115 = r114.hashCode();
        if (r115 == (-1008619738)) goto L47;
        if (r115 == 3324) goto L44;
        if (r115 == 3448) goto L41;
        if (r115 == 3665) goto L38;
        if (r115 == 115761) goto L35;
    L49:
        byte r116 = -1;
    L51:
        if (r116 == 0) goto L62;
        if (r116 == 1) goto L60;
        if (r116 != 2) goto L56;
        r114 = PlayerResolution.SDKKEY.SD;
    L63:
        r100 = true;
        r101 = 0;
        goto L12
    L56:
        if (r116 != 3) goto L62;
        r114 = PlayerResolution.SDKKEY.LD;
        goto L63
    L60:
        r114 = PlayerResolution.SDKKEY.HD;
    L62:
        r114 = null;
        goto L63
    L35:
        if (r114.equals(PlayerResolution.SDKKEY.UHD) == false) goto L49;
        r116 = 1;
        goto L51
    L38:
        if (r114.equals(PlayerResolution.SDKKEY.SD) == false) goto L49;
        r116 = 3;
        goto L51
    L41:
        if (r114.equals(PlayerResolution.SDKKEY.LD) == false) goto L49;
        r116 = 4;
        goto L51
    L44:
        if (r114.equals(PlayerResolution.SDKKEY.HD) == false) goto L49;
        r116 = 2;
        goto L51
    L47:
        if (r114.equals(PlayerResolution.SDKKEY.ORIGIN) == false) goto L49;
        r116 = 0;
        goto L51
    L16:
        if (r114.equals(PlayerResolution.SDKKEY.ORIGIN) == true) goto L23;
        long r102 = getBitrate(r114, r111);
        if (r102 <= r101) goto L64;
        if (r113 >= r102) goto L64;
        if (r112 <= 0) goto L72;
        this.f459474f = r112;
        goto L64
    L72:
        return r100;
    L64:
        return false;
    }

    public boolean isEnableAdaptive(String r100, boolean r101, String r102) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r102, "lls") == false) goto L34;
        return true;
    L34:
    L27:
        e = move-exception;
        e.printStackTrace();
    L29:
        if (r101 == true) goto L31;
        return false;
    L31:
        if (TextUtils.equals(r100, this.f459483j0) == false) goto L37;
        return true;
    L37:
        return false;
    L12:
        if (TextUtils.isEmpty(this.f459467b0) == false) goto L23;
        JSONObject r103 = getAbrInfo();     // Catch: Exception -> L27
        if (r103 != null) goto L16;
    L21:
        return false;
    L16:
        if (r103.has("list") == false) goto L21;
        JSONArray r104 = r103.optJSONArray("list");     // Catch: Exception -> L27
        if (r104 == null) goto L23;
        this.f459467b0 = r104.toString();     // Catch: Exception -> L27
    L23:
        if (TextUtils.isEmpty(this.f459467b0) == true) goto L29;
        if (this.f459467b0.contains("\"" + r100 + "\"") == false) goto L29;
        return true;
    }

    public boolean isResSupportSR(String r100, String r101, boolean r102) {
        if (isNeedUseDefaultResolution(r100) == false) goto L6;
        r100 = this.f459470d;
    L6:
        if (isSupport(r100) == true) goto L25;
        return false;
    L25:
        JSONObject r103 = getSDKParamsJson(r100, r101);     // Catch: Exception -> L20
        if (r103 != null) goto L12;
        com.ss.videoarch.liveplayer.log.c.e("LiveStreamInfo", "sdkParamsJson is null");     // Catch: Exception -> L20
        return false;
    L12:
        String[] r104 = r103.optString("resolution").split("x");     // Catch: Exception -> L20
        if (r104.length >= 2) goto L23;
        return false;
    L23:
        return isResSupportSR(CastIntegerProtector.parseInt(r104[0]), CastIntegerProtector.parseInt(r104[1]), r102);
    L19:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public boolean isResSupportSharpen(int r100, int r101, boolean r102) {
        int r103 = Math.max(r100, r101);
        int r104 = Math.min(r100, r101);
        boolean r105 = true;
        if (r103 >= this.f459504u) goto L5;
    L11:
        boolean r106 = false;
    L12:
        if (r102 == true) goto L14;
        return r106;
    L14:
        if (this.P == true) goto L16;
        return r106;
    L16:
        if (r103 <= this.f459510x) goto L18;
    L20:
        r105 = false;
    L22:
        return r105;
    L18:
        if (r104 > this.f459512y) goto L20;
    L5:
        if (r103 > this.f459502t) goto L11;
        if (r104 < this.f459508w) goto L11;
        if (r104 > this.f459506v) goto L11;
        r106 = true;
        goto L12
    }

    public void setRequestParamsWithDNSIp(String r100, String r101, String r102) {
        this.f459472e = r100;
        this.f459478h = r101;
        this.f459480i = r102;
    }

    public void setSdkParamsJson(String r100, String r101, JSONObject r102) {
        com.ss.videoarch.liveplayer.log.c.i("LiveStreamInfo", "setSdkParamsJson: " + r100 + " " + r101);
        ConcurrentHashMap<String, JSONObject> r103 = new ConcurrentHashMap();
        r103.put(r101, r102);
        this.f459487l0.put(r100, r103);
    }

    public boolean isResSupportSR(int r100, int r101, boolean r102) {
        int r103 = Math.max(r100, r101);
        int r104 = Math.min(r100, r101);
        if (this.f459494p != 1) goto L12;
        if (r102 == false) goto L12;
        if (r103 <= this.f459498r) goto L8;
        return false;
    L8:
        if (r104 > this.f459496q) goto L18;
        return true;
    L18:
        return false;
    L12:
        if (r103 <= this.f459492o) goto L14;
        return false;
    L14:
        if (r104 > this.f459490n) goto L20;
        return true;
    L20:
        return false;
    }

    public String getMPDForFormat(String r210, String r211, String r212, String r310) {
        String r100 = r210;
        long r101 = System.currentTimeMillis();
        JSONObject r102 = this.f459464a;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.length() > 0) goto L8;
        return null;
    L8:
        JSONObject r103 = new JSONObject();
        Iterator<String> r110 = this.f459464a.keys();
        ArrayList r111 = new ArrayList();     // Catch: JSONException -> L80
        JSONObject r112 = new JSONObject();     // Catch: JSONException -> L80
        if (this.B != null) goto L13;
        this.B = new JSONObject();     // Catch: JSONException -> L80
    L13:
        if (this.f459485k0 != null) goto L15;
        this.f459485k0 = new ArrayList();     // Catch: JSONException -> L80
    L15:
        boolean r113 = true;
        if (this.f459469c0 != 1) goto L18;
        this.f459471d0 = 1;     // Catch: JSONException -> L80
    L18:
        long r114 = 0;
        int r104 = 0;
        long r213 = -1;
    L19:
        if (r110.hasNext() == false) goto L69;
        String r115 = r110.next();     // Catch: JSONException -> L80
        if (isEnableAdaptive(r115, r113, "flv") == false) goto L19;
        String r116 = getStreamUrlForResolution(r115, r100, r211);     // Catch: JSONException -> L80
        if (r116 == null) goto L19;
        JSONObject r117 = new JSONObject();     // Catch: JSONException -> L80
        Iterator<String> r214 = r110;
        r117.put("id", r104);     // Catch: JSONException -> L80
        r117.put(SubInfo.KEY_FORMAT, r100);     // Catch: JSONException -> L80
        long r215 = r101;
        this.f459474f = getSDKParamsJson(r115, r211).optLong("TargetOriginBitRate", this.f459474f);     // Catch: JSONException -> L78
        if (r115.equals(PlayerResolution.SDKKEY.ORIGIN) == false) goto L36;
        JSONObject r105 = r103;
        long r106 = this.f459474f;     // Catch: JSONException -> L78
        if (r106 <= 0) goto L37;
        r117.put("bitrate", r106);     // Catch: JSONException -> L78
        this.B.put(r115, this.f459474f);     // Catch: JSONException -> L78
        this.f459485k0.add(Long.valueOf(this.f459474f));     // Catch: JSONException -> L78
    L38:
        r117.put("qualityType", r115);     // Catch: JSONException -> L78
        r117.put("hidden", 0);     // Catch: JSONException -> L78
        if (this.f459470d.equals(r115) == false) goto L41;
        int r107 = 1;
    L42:
        r117.put("defaultSelect", r107);     // Catch: JSONException -> L78
        if (TextUtils.isEmpty(this.f459472e) == true) goto L53;
        int r108 = r116.indexOf("?");     // Catch: JSONException -> L78
        if (r108 != (-1)) goto L49;
        r116 = r116 + "?" + this.f459472e;     // Catch: JSONException -> L78
        goto L53
    L49:
        if (r108 == (r116.length() - 1)) goto L53;
        r116 = r116 + "&" + this.f459472e;     // Catch: JSONException -> L78
    L53:
        if (TextUtils.isEmpty(r212) == false) goto L55;
    L60:
        r117.put("url", r116);     // Catch: JSONException -> L78
    L61:
        r111.add(r117);     // Catch: JSONException -> L78
        long r109 = r114;
        if (r109 != 0) goto L64;
        r109 = getGopDuration(r115, r211);     // Catch: JSONException -> L78
    L64:
        r114 = r109;
        long r118 = r213;
        if (r118 != (-1)) goto L67;
        r213 = getFastOpenDuration(r115, r211);     // Catch: JSONException -> L78
    L68:
        r104 = r104 + 1;     // Catch: JSONException -> L78
        r103 = r105;
        r110 = r214;
        r101 = r215;
        r113 = true;
        r100 = r210;
        goto L19
    L67:
        r213 = r118;
        goto L68
    L55:
        if (r212.equals("none") == true) goto L60;
        if (r310 == null) goto L60;
        if (ymc.a.getUrlHost(r116).equals(r310) == false) goto L60;
        r117.put("url", ymc.a.hostToIPUrl(set_url_port_scheme(r116), r212, false));     // Catch: JSONException -> L78
        goto L61
    L41:
        r107 = 0;
    L37:
        long r119 = getBitrate(r115, r211);     // Catch: JSONException -> L78
        r117.put("bitrate", r119);     // Catch: JSONException -> L78
        this.B.put(r115, r119);     // Catch: JSONException -> L78
        this.f459485k0.add(Long.valueOf(r119));     // Catch: JSONException -> L78
        goto L38
    L36:
        r105 = r103;
    L78:
        e = e;
    L82:
        e.printStackTrace();
        JSONObject r120 = null;
    L83:
        if (r120 != null) goto L85;
        return null;
    L85:
        if (r120.length() <= 0) goto L103;
        this.f459475f0 = System.currentTimeMillis() - r215;
        return r120.toString();
    L103:
        return null;
    L69:
        r215 = r101;
        JSONObject r121 = r103;
        long r122 = r114;
        long r123 = r213;
        this.f459471d0 = 0;     // Catch: JSONException -> L78
        if (r104 != 0) goto L73;
        return null;
    L73:
        r112.put("gopDuration", r122);     // Catch: JSONException -> L78
        if (r123 == (-1)) goto L76;
        r112.put("defaultAbrPts", r123);     // Catch: JSONException -> L78
    L76:
        r112.put("representation", new JSONArray(r111));     // Catch: JSONException -> L78
        r121.put("version", "1.0");     // Catch: JSONException -> L78
        r121.put("adaptationSet", r112);     // Catch: JSONException -> L78
        r120 = r121;
    L80:
        e = e;
        r215 = r101;
        goto L82
    }
}
