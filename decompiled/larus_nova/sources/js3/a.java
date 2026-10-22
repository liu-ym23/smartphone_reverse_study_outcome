package js3;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.ttvideoengine.net.DNSParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements hs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f500200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f500201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f500203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f500204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f500205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f500206h;

    @Override // hs3.c
    public final boolean b() {
        return true;
    }

    @Override // hs3.c
    public final boolean c(JSONObject r100) {
        return false;
    }

    @Override // hs3.c
    public final String d() {
        return null;
    }

    @Override // hs3.c
    public final String e() {
        return null;
    }

    @Override // hs3.c
    public final JSONObject a() {
        if (TextUtils.isEmpty(this.f500199a) == false) goto L18;
        return null;
    L18:
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L17
        r100.put(FrescoMonitorConst.LOG_TYPE, this.f500199a);     // Catch: Exception -> L17
        r100.put("duration", this.f500200b);     // Catch: Exception -> L17
        r100.put("uri", UriProtector.parse(this.f500202d));     // Catch: Exception -> L17
        long r101 = this.f500201c;     // Catch: Exception -> L17
        if (r101 <= 0) goto L8;
        r100.put("timestamp", r101);     // Catch: Exception -> L17
    L8:
        r100.put("status", this.f500205g);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(this.f500203e) == true) goto L13;
        r100.put(DNSParser.DNS_RESULT_IP, this.f500203e);     // Catch: Exception -> L17
    L13:
        if (TextUtils.isEmpty(this.f500204f) == true) goto L15;
        r100.put("trace_code", this.f500204f);     // Catch: Exception -> L17
    L16:
        return r100;
    L15:
        r100.put("trace_code", "");     // Catch: Exception -> L17
    L17:
        return null;
    }

    public a(String r100, long r101, long r102, String r103, String r104, String r105, int r106, JSONObject r110) {
        this.f500199a = r100;
        this.f500200b = r101;
        this.f500201c = r102;
        this.f500202d = r103;
        this.f500203e = r104;
        this.f500204f = r105;
        this.f500205g = r106;
        if (r110 != null) goto L5;
        this.f500206h = new JSONObject();
        return;
    L5:
        this.f500206h = r110;
    }
}
