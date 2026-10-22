package ou3;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import qu3.c;
import vu3.b;
import xu3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements b {
    public static volatile a g;
    public final CopyOnWriteArraySet<String> a;
    public final ConcurrentHashMap<String, String> b;
    public long c;
    public boolean d;
    public long e;
    public long f;

    public static a a() {
        if (g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = this.b.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, String> r2 = r1.next();     // Catch: JSONException -> L9
        r0.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L9
    L8:
        return r0;
    }

    public final JSONObject d() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L8
        this.c = Debug.getNativeHeapAllocatedSize() / 1048576;     // Catch: Exception -> L8
        Runtime r1 = Runtime.getRuntime();     // Catch: Exception -> L8
        long r5 = r1.maxMemory();     // Catch: Exception -> L8
        long r7 = r1.freeMemory();     // Catch: Exception -> L8
        long r2 = r1.totalMemory();     // Catch: Exception -> L8
        this.e = r5 / 1048576;     // Catch: Exception -> L8
        long r3 = r2 - r7;     // Catch: Exception -> L8
        this.f = r3 / 1048576;     // Catch: Exception -> L8
        if (r3 <= (r5 * 0.95f)) goto L5;
        boolean r4 = true;
    L6:
        this.d = r4;     // Catch: Exception -> L8
        r0.put("apm_native_heap_size", this.c);     // Catch: Exception -> L8
        r0.put("apm_java_heap_leak", this.d);     // Catch: Exception -> L8
        r0.put("apm_java_heap_used", this.f);     // Catch: Exception -> L8
        r0.put("apm_java_heap_max", this.e);     // Catch: Exception -> L8
        return r0;
    L5:
        r4 = false;
    L8:
        return null;
    }

    public final String e() {
        String r0 = e.a(this.a.toArray());
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        uu3.a r1 = (uu3.a) c.a(uu3.a.class);
        if (r1 != null) goto L8;
        return XmlPullParser.NO_NAMESPACE;
    L8:
        return r1.c();
    }

    public a() {
        this.a = new CopyOnWriteArraySet();
        this.b = new ConcurrentHashMap();
    }

    public final JSONObject c(boolean r5) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = this.b.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r1.next();     // Catch: JSONException -> L11
        r0.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r0.put("RealRefreshRate", String.valueOf(i.f));     // Catch: JSONException -> L11
        r0.put("RealMaxRefreshRate", String.valueOf(i.f));     // Catch: JSONException -> L11
        if (r5 == false) goto L10;
        com.bytedance.apm.util.e r6 = com.bytedance.apm.util.e.a.a;     // Catch: JSONException -> L11
        r6.b(r0, false);     // Catch: JSONException -> L11
        r6.a(r0, false);     // Catch: JSONException -> L11
    L10:
        return r0;
    }
}
