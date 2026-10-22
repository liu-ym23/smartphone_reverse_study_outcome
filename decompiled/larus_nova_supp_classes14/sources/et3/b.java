package et3;

import com.bytedance.apm.util.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements bt3.b.e {
    public boolean a;
    public final HashMap<String, a> b;

    public static class a {
        public final Map<String, String> a;
        public float b;
        public final long c;
        public int d;

        public a(Map r1, float r2) {
            this.a = r1;
            this.b = r2;
            this.c = System.currentTimeMillis();
            this.d = 1;
        }
    }

    /* JADX INFO: renamed from: et3.b$b, reason: collision with other inner class name */
    public static class C0120b {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
        this.b = new HashMap();
        this.a = true;
        bt3.b.d.a.a(this);
    }

    public final void onTimeEvent(long r13) {
        if (this.b.isEmpty() == true) goto L43;
        Iterator<Map.Entry<String, a>> r0 = this.b.entrySet().iterator();
        int r1 = i.b;
    L6:
        if (r0.hasNext() == false) goto L56;
        Map.Entry<String, a> r2 = r0.next();
        String r6 = r2.getKey();
        a r3 = r2.getValue();
        boolean r10 = true;
        if ((r13 - r3.c) <= 120000) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r0.remove();
        int r5 = r3.d;
        if (r5 <= 0) goto L15;
        float r7 = r3.b / r5;
    L17:
        if (com.bytedance.apm.d.j() == false) goto L20;
        ps3.b.a(new String[]{"aggregate fps: " + r6 + " , value: " + r7});
    L20:
        if (r7 <= 0.0f) goto L6;
        float r8 = r1;
        if (r7 <= r8) goto L44;
        r7 = r8;
    L44:
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L42
        r9.put("fps", r7);     // Catch: Exception -> L42
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L42
        r11.put("scene", r6);     // Catch: Exception -> L42
        js3.e r12 = new js3.e("fps", r6, r9, r11, null);     // Catch: Exception -> L42
        JSONObject r14 = ou3.a.a().c(true);     // Catch: Exception -> L42
        r12.f = r14;     // Catch: Exception -> L42
        r14.put("refresh_rate", r1);     // Catch: Exception -> L42
        if (this.a == false) goto L32;
        this.a = false;     // Catch: Exception -> L42
        r14.put("device_max_refresh_rate", i.c);     // Catch: Exception -> L42
        if (i.d == false) goto L31;
        r10 = false;
    L31:
        r14.put("refresh_rate_restricted", r10);     // Catch: Exception -> L42
    L32:
        Map<String, String> r15 = r3.a;     // Catch: Exception -> L42
        if (r15 != null) goto L35;
    L40:
        is3.a.h().b(r12);     // Catch: Exception -> L42
        goto L6
    L35:
        if (r15.isEmpty() == true) goto L40;
        Iterator<Map.Entry<String, String>> r16 = r3.a.entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r16.hasNext() == false) goto L40;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Exception -> L42
        r12.f.put(r17.getKey(), r17.getValue());     // Catch: Exception -> L42
        goto L38
    L15:
        r7 = -1.0f;
        goto L17
    L10:
        r4 = false;
        goto L11
    L56:
        return;
    }
}
