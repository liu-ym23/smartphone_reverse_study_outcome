package osa;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.BytedCertSdkManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public String A;
    public boolean B;
    public String C;
    public String D;
    public List<Integer> E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public double f526566J;
    public double K;
    public String L;
    public int M;
    public String N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f526567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f526568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f526569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f526570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f526571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f526572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f526573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f526574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f526575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f526576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f526577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, String> f526578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f526579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f526580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f526581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f526582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f526583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f526584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f526585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, String> f526586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, String> f526587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public JSONObject f526588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f526589w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f526590x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f526591y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f526592z;

    public b() {
        this.f526584r = true;
        this.f526585s = new HashMap();
        this.f526586t = new HashMap();
        this.f526587u = new HashMap();
        this.f526577k = BytedCertSdkManager.getInstance().isUpgradeV3();
    }

    public final void a(BDResponse r100) {
        if (r100 == null) goto L18;
        JSONObject r101 = r100.jsonData;
        if (r101 != null) goto L20;
        return;
    L20:
        JSONObject r102 = new JSONObject(r101.optString("server_event_params", SliceInitService.DEFAULT_SWITCH));     // Catch: JSONException -> L19
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L19
    L9:
        if (r103.hasNext() == false) goto L33;
        String r104 = r103.next();     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r104) == true) goto L9;
        Object r105 = r102.opt(r104);     // Catch: JSONException -> L19
        if (r105 == null) goto L9;
        Map<String, String> r106 = this.f526587u;     // Catch: JSONException -> L19
        HashMap r107 = (HashMap) r106;     // Catch: JSONException -> L19
        r107.put(r104, String.valueOf(r105));     // Catch: JSONException -> L19
    L33:
        return;
    L32:
        return;
    }
}
