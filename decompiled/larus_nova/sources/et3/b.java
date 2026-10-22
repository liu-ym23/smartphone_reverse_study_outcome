package et3;

import com.bytedance.apm.util.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements bt3.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f473882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, a> f473883b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f473884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f473885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f473886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f473887d;

        public a(Map r100, float r101) {
            this.f473884a = r100;
            this.f473885b = r101;
            this.f473886c = System.currentTimeMillis();
            this.f473887d = 1;
        }
    }

    /* JADX INFO: renamed from: et3.b$b, reason: collision with other inner class name */
    public static class C5816b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f473888a = null;

        static {
            f473888a = new b();
        }
    }

    public b() {
        this.f473883b = new HashMap();
        this.f473882a = true;
        bt3.b.d.f20539a.a(this);
    }

    @Override // bt3.b.e
    public final void onTimeEvent(long r110) {
        if (this.f473883b.isEmpty() == true) goto L43;
        Iterator<Map.Entry<String, a>> r100 = this.f473883b.entrySet().iterator();
        int r101 = i.f190670b;
    L6:
        if (r100.hasNext() == false) goto L56;
        Map.Entry<String, a> r102 = r100.next();
        String r103 = r102.getKey();
        a r104 = r102.getValue();
        boolean r111 = true;
        if ((r110 - r104.f473886c) <= 120000) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r100.remove();
        int r106 = r104.f473887d;
        if (r106 <= 0) goto L15;
        float r107 = r104.f473885b / r106;
    L17:
        if (com.bytedance.apm.d.j() == false) goto L20;
        ps3.b.a(new String[]{"aggregate fps: " + r103 + " , value: " + r107});
    L20:
        if (r107 <= 0.0f) goto L6;
        float r108 = r101;
        if (r107 <= r108) goto L44;
        r107 = r108;
    L44:
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L42
        r109.put("fps", r107);     // Catch: Exception -> L42
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L42
        r112.put("scene", r103);     // Catch: Exception -> L42
        js3.e r113 = new js3.e("fps", r103, r109, r112, null);     // Catch: Exception -> L42
        JSONObject r114 = ou3.a.a().c(true);     // Catch: Exception -> L42
        r113.f500222f = r114;     // Catch: Exception -> L42
        r114.put("refresh_rate", r101);     // Catch: Exception -> L42
        if (this.f473882a == false) goto L32;
        this.f473882a = false;     // Catch: Exception -> L42
        r114.put("device_max_refresh_rate", i.f190671c);     // Catch: Exception -> L42
        if (i.f190672d == false) goto L31;
        r111 = false;
    L31:
        r114.put("refresh_rate_restricted", r111);     // Catch: Exception -> L42
    L32:
        Map<String, String> r115 = r104.f473884a;     // Catch: Exception -> L42
        if (r115 != null) goto L35;
    L40:
        is3.a.h().b(r113);     // Catch: Exception -> L42
        goto L6
    L35:
        if (r115.isEmpty() == true) goto L40;
        Iterator<Map.Entry<String, String>> r116 = r104.f473884a.entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r116.hasNext() == false) goto L40;
        Map.Entry<String, String> r117 = r116.next();     // Catch: Exception -> L42
        r113.f500222f.put(r117.getKey(), r117.getValue());     // Catch: Exception -> L42
        goto L38
    L15:
        r107 = -1.0f;
        goto L17
    L10:
        r105 = false;
        goto L11
    L56:
        return;
    }
}
