package s1;

import android.app.Application;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f540075t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f540076u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f540077v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f540078w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f540079x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f540080y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile c f540081z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f540082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f540083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f540084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Long> f540085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<a> f540086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f540087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f540088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f540089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f540090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f540091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f540092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f540093l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f540094m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f540095n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f540096o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f540097p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f540098q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f540099r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f540100s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f540101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f540102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f540103c;

        public a(String r100, String r101, long r102) {
            this.f540102b = r101;
            this.f540103c = r102;
            this.f540101a = r100;
        }

        public final String toString() {
            return com.apm.lite.k.b.a().format(new Date(this.f540103c)) + " : " + this.f540101a + ' ' + this.f540102b;
        }
    }

    public static JSONObject a(String r100, long r101) {
        JSONObject r102 = new JSONObject();
        r102.put("name", r100);     // Catch: JSONException -> L5
        r102.put("time", r101);     // Catch: JSONException -> L5
    L4:
        return r102;
    }

    public final JSONArray d() {
        JSONArray r100 = new JSONArray();
        List<String> r101 = this.f540082a;
        if (r101 != null) goto L5;
    L12:
        return r100;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L12;
        int r102 = 0;
    L9:
        if (r102 >= ((ArrayList) this.f540082a).size()) goto L12;
        r100.put(a((String) ListProtector.get(this.f540082a, r102), ((Long) ListProtector.get(this.f540083b, r102)).longValue()));     // Catch: Throwable -> L13
        r102 = r102 + 1;
        goto L9
    }

    public final JSONArray e() {
        JSONArray r100 = new JSONArray();
        List<String> r101 = this.f540084c;
        if (r101 != null) goto L5;
    L12:
        return r100;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L12;
        int r102 = 0;
    L9:
        if (r102 >= ((ArrayList) this.f540084c).size()) goto L12;
        r100.put(a((String) ListProtector.get(this.f540084c, r102), ((Long) ListProtector.get(this.f540085d, r102)).longValue()));     // Catch: Throwable -> L13
        r102 = r102 + 1;
        goto L9
    }

    public static c c() {
        if (f540081z != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f540081z != null) goto L9;
        f540081z = new c(com.apm.lite.e.f29910b);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f540081z;
    }

    public c(Application r100) {
        this.f540082a = new ArrayList();
        this.f540083b = new ArrayList();
        this.f540084c = new ArrayList();
        this.f540085d = new ArrayList();
        this.f540086e = new LinkedList();
        this.f540097p = false;
        this.f540098q = -1;
        this.f540099r = 50;
        if (r100 == null) goto L9;
        r100.registerActivityLifecycleCallbacks(new b(this));     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void b(c r100, String r101, long r102, String r103) {
        r100.getClass();
        if (r100.f540086e.size() < r100.f540099r) goto L8;
        a r104 = r100.f540086e.poll();     // Catch: Throwable -> L13
        if (r104 == null) goto L9;
        r100.f540086e.add(r104);     // Catch: Throwable -> L13
    L9:
        if (r104 != null) goto L11;
        r104 = new a(r101, r103, r102);     // Catch: Throwable -> L13
        r100.f540086e.add(r104);     // Catch: Throwable -> L13
    L11:
        r104.f540102b = r103;     // Catch: Throwable -> L13
        r104.f540101a = r101;     // Catch: Throwable -> L13
        r104.f540103c = r102;     // Catch: Throwable -> L13
        return;
    L8:
        r104 = null;
    }
}
