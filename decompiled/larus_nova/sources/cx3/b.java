package cx3;

import android.util.Base64;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.applog.monitor.v3.impl.c;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicInteger f465693q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f465694r = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f465697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f465698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f465699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f465700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f465701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f465702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f465703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f465704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f465705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f465706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f465707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f465708o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, Object> f465709p;

    @Override // cx3.a
    public final void b() {
        this.f465699f = true;
    }

    @Override // cx3.a
    public final boolean isEnabled() {
        return true;
    }

    static {
        f465693q = new AtomicInteger(0);
        f465694r = System.currentTimeMillis();
    }

    @Override // cx3.a
    public final void end() {
        long r110 = System.currentTimeMillis() - this.f465697d;     // Catch: Throwable -> L14
        JSONObject r100 = new JSONObject(this.f465709p);     // Catch: Throwable -> L14
        byte[] r101 = this.f465707n;     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
    L11:
        r100.put(ILoadStallMonitor.START_TIME, this.f465697d);     // Catch: Throwable -> L14
        r100.put("index_id", this.f465705l);     // Catch: Throwable -> L14
        r100.put("http_headers", this.f465708o);     // Catch: Throwable -> L14
        r100.put(LocationMonitorConst.IS_BACKGROUND, this.f465700g);     // Catch: Throwable -> L14
        r100.put("app_run_duration", System.currentTimeMillis() - f465694r);     // Catch: Throwable -> L14
        this.f465706m.d(this.f465695b, this.f465696c, this.f465698e, this.f465699f, this.f465701h, this.f465702i, this.f465703j, this.f465704k, r110, r100);     // Catch: Throwable -> L14
        this.f465707n = null;     // Catch: Throwable -> L14
        return;
    L6:
        if ("error data".equalsIgnoreCase(this.f465704k) == true) goto L15;
        if ("empty data".equalsIgnoreCase(this.f465704k) == false) goto L11;
    L15:
        r100.put("req_body_first_100bytes", Base64.encodeToString(r101, 0, Math.min(r101.length, 100), 0));     // Catch: JSONException -> L13 Throwable -> L14
    }

    @Override // cx3.a
    public final void c(byte[] r100) {
        if (r100 == null) goto L5;
        this.f465698e = r100.length;
        this.f465707n = r100;
        return;
    }

    @Override // cx3.a
    public final void d(String r100) {
        this.f465708o = r100;
    }

    @Override // cx3.a
    public final void e(String r100) {
        if (r100 == null) goto L5;
        this.f465703j = r100.length();
        return;
    }

    @Override // cx3.a
    public final void handleException(Throwable r100) {
        StringBuilder r101 = new StringBuilder();
        if ((r100 instanceof RangersHttpException) == false) goto L9;
        RangersHttpException r102 = (RangersHttpException) r100;
        this.f465702i = r102.getResponseCode();
        r101.append("rhe:");
        r101.append(r102.getMessage());
        Throwable r103 = r100.getCause();
        if (r103 != null) goto L7;
    L10:
        this.f465704k = r101.toString();
        return;
    L7:
        if (r103.getMessage() == null) goto L10;
        this.f465704k = r103.getMessage();
        r101.append(",cause:");
        r101.append(r103.getMessage());
        goto L10
    L9:
        r101.append("e:");
        r101.append(r100.getMessage());
        goto L10
    }

    @Override // cx3.a
    public final void setBackground(boolean r100) {
        this.f465700g = r100;
    }

    @Override // cx3.a
    public final void setMessage(String r100) {
        this.f465704k = r100;
    }

    @Override // cx3.a
    public final void setStatusCode(int r100) {
        this.f465701h = r100;
    }

    @Override // cx3.a
    public final void a(String r100, Object r101) {
        ((HashMap) this.f465709p).put(r100, r101);
    }

    public b(c r100, String r101, String r102) {
        this.f465709p = new HashMap();
        this.f465706m = r100;
        int r103 = f465693q.incrementAndGet();
        this.f465705l = r103;
        this.f465695b = r101 + "_" + r103;
        this.f465696c = r102;
        this.f465697d = System.currentTimeMillis();
    }
}
