package ss3;

import com.bytedance.apm.util.e;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static volatile f c;
    public final CopyOnWriteArraySet<String> a;
    public final ConcurrentHashMap<String, String> b;

    public static f a() {
        if (c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public f() {
        this.a = new CopyOnWriteArraySet();
        this.b = new ConcurrentHashMap();
    }

    public final JSONObject b(boolean r5) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = this.b.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r1.next();     // Catch: JSONException -> L10
        r0.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r5 == false) goto L9;
        e r6 = e.a.a;     // Catch: JSONException -> L10
        r6.b(r0, false);     // Catch: JSONException -> L10
        r6.a(r0, false);     // Catch: JSONException -> L10
    L9:
        return r0;
    }
}
