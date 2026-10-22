package ou6;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.hybrid.bridge.network.CommonApi;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f526755s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n56.f f526756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f526757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n56.a f526758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nu6.a f526759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nu6.b f526760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f526761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f526762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f526763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f526764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f526765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Header> f526766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f526767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Exception f526768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f526769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f526770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f f526771p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g f526772q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CommonApi f526773r;

    static {
        f526755s = i.class.getSimpleName();
    }

    public final void b() {
        n56.f r100 = this.f526756a;
        this.f526761f = r100.f518030b;
        JSONObject r101 = r100.f518032d;
        this.f526762g = r101.optString("url", "");
        this.f526763h = r101.optString(com.alipay.sdk.m.p.e.f25671s, MonitorConstants.CONNECT_TYPE_GET);
        this.f526764i = r101.optJSONObject("params");
        this.f526765j = r101.optJSONObject("data");
        String r102 = r101.optString("header");
        if (UGCMonitor.TYPE_POST.equalsIgnoreCase(this.f526763h) == true) goto L5;
    L36:
    L21:
        e = move-exception;
        com.bytedance.locallife.biz.common.utils.c.a("Life-SDK", e.getMessage());
    L24:
        if (MonitorConstants.CONNECT_TYPE_GET.equalsIgnoreCase(this.f526763h) == false) goto L27;
        com.bytedance.locallife.hybrid.bridge.network.c.b().a(this.f526757b, this.f526769n, 25);
        return;
    L27:
        if (UGCMonitor.TYPE_POST.equalsIgnoreCase(this.f526763h) == false) goto L30;
        com.bytedance.locallife.hybrid.bridge.network.c.b().a(this.f526757b, this.f526770o, 32);
        return;
    L30:
        if ("put".equalsIgnoreCase(this.f526763h) == false) goto L33;
        com.bytedance.locallife.hybrid.bridge.network.c.b().a(this.f526757b, this.f526771p, 33);
        return;
    L33:
        if ("delete".equalsIgnoreCase(this.f526763h) == false) goto L48;
        com.bytedance.locallife.hybrid.bridge.network.c.b().a(this.f526757b, this.f526772q, 34);
        return;
    L48:
        return;
    L8:
        if (r102.isEmpty() == true) goto L10;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L21
    L11:
        if (r103 == null) goto L24;
        this.f526766k = new ArrayList();     // Catch: JSONException -> L21
        Iterator<String> r104 = r103.keys();     // Catch: JSONException -> L21
    L13:
        if (r104.hasNext() == false) goto L24;
        String r105 = r104.next();     // Catch: JSONException -> L21
        String r106 = r103.optString(r105);     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r106) == true) goto L13;
        List<Header> r107 = this.f526766k;     // Catch: JSONException -> L21
        ArrayList r108 = (ArrayList) r107;     // Catch: JSONException -> L21
        r108.add(new Header(r105, r106));     // Catch: JSONException -> L21
        if (com.alipay.sdk.m.p.e.f25658f.equalsIgnoreCase(r105) == false) goto L13;
        this.f526767l = r106;     // Catch: JSONException -> L21
        goto L13
    L10:
        r103 = null;
        goto L11
    L5:
        if (this.f526765j != null) goto L36;
        this.f526765j = r101.optJSONObject("params");
        this.f526764i = new JSONObject();
        goto L36
    }

    public static String d(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Header r102 = (Header) r101.next();
        if (NetResponse.HEADER_KEY_LOG_ID.equals(r102.getName().toLowerCase()) == false) goto L4;
        return r102.getValue();
    L9:
        return "";
    }

    public final String c(String r100) throws Exception {
        if (NetworkUtils.isNetworkAvailable(HostServiceUtilsKt.E().getApplicationContext()) == false) goto L7;
        return this.f526773r.doDelete(r100, this.f526766k).execute().body();
    L7:
        throw new IOException();
    }

    public static String a(String r100, JSONObject r101) {
        k r102 = new k(r100);
        if (r101 == null) goto L8;
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();
        r102.f526774a.add(new Pair(r104, r101.optString(r104, "")));
    L8:
        ArrayList<Pair<String, String>> r105 = r102.f526774a;
        if (r105 != null) goto L11;
    L18:
        boolean r106 = false;
    L19:
        if (r106 == true) goto L21;
        r102.f526774a.add(new Pair("request_tag_from", "h5"));
    L21:
        com.bytedance.locallife.biz.common.utils.c.a(f526755s, "build url is " + r102.a());
        return r102.a();
    L11:
        if (r105.isEmpty() == true) goto L18;
        Iterator<Pair<String, String>> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        if ("request_tag_from".equalsIgnoreCase(r107.next().getFirst()) == false) goto L14;
        r106 = true;
        goto L19
    }

    public static void e(JSONObject r100, int r101, String r102, String r103) {
        r100.put("code", 0);     // Catch: JSONException -> L9
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L9
        r104.put("errCode", r101);     // Catch: JSONException -> L5
        r104.put("message", r102);     // Catch: JSONException -> L5
        r104.put("prompts", r103);     // Catch: JSONException -> L5
    L7:
        r100.put("response", r104);     // Catch: JSONException -> L9
        return;
    L5:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [ou6.d] */
    /* JADX WARN: Type inference failed for: r4v3, types: [ou6.e] */
    /* JADX WARN: Type inference failed for: r4v4, types: [ou6.f] */
    /* JADX WARN: Type inference failed for: r4v5, types: [ou6.g] */
    public i(n56.f r100, JSONObject r101, n56.a r102, com.bytedance.locallife.hybrid.bridge.f.c r103, com.bytedance.locallife.hybrid.bridge.f.b r104) {
        this.f526768m = null;
        this.f526769n = new d(this);
        this.f526770o = new e(this);
        this.f526771p = new f(this);
        this.f526772q = new g(this);
        this.f526773r = (CommonApi) HostServiceUtilsKt.S().create("https://life-service-open.scsjsd.com", CommonApi.class);
        this.f526756a = r100;
        this.f526758c = r102;
        this.f526759d = r103;
        this.f526760e = r104;
        this.f526757b = new Handler(Looper.getMainLooper(), new h(this));
    }
}
