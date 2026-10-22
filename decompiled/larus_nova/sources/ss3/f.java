package ss3;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile f f543347c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f543348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f543349b;

    public static f a() {
        if (f543347c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f543347c != null) goto L9;
        f543347c = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f543347c;
    }

    public f() {
        this.f543348a = new CopyOnWriteArraySet();
        this.f543349b = new ConcurrentHashMap();
    }

    public final JSONObject b(boolean r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, String>> r102 = this.f543349b.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, String> r103 = r102.next();     // Catch: JSONException -> L10
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r100 == false) goto L9;
        com.bytedance.apm.util.e r104 = com.bytedance.apm.util.e.a.f190668a;     // Catch: JSONException -> L10
        r104.b(r101, false);     // Catch: JSONException -> L10
        r104.a(r101, false);     // Catch: JSONException -> L10
    L9:
        return r101;
    }
}
