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
import qu3.c;
import vu3.b;
import xu3.e;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f526724g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f526725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f526726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f526727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f526728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f526729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f526730f;

    public static a a() {
        if (f526724g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f526724g != null) goto L9;
        f526724g = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f526724g;
    }

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, String>> r101 = this.f526726b.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, String> r102 = r101.next();     // Catch: JSONException -> L9
        r100.put(r102.getKey(), r102.getValue());     // Catch: JSONException -> L9
    L8:
        return r100;
    }

    public final JSONObject d() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L8
        this.f526727c = Debug.getNativeHeapAllocatedSize() / 1048576;     // Catch: Exception -> L8
        Runtime r101 = Runtime.getRuntime();     // Catch: Exception -> L8
        long r102 = r101.maxMemory();     // Catch: Exception -> L8
        long r103 = r101.freeMemory();     // Catch: Exception -> L8
        long r104 = r101.totalMemory();     // Catch: Exception -> L8
        this.f526729e = r102 / 1048576;     // Catch: Exception -> L8
        long r105 = r104 - r103;     // Catch: Exception -> L8
        this.f526730f = r105 / 1048576;     // Catch: Exception -> L8
        if (r105 <= (r102 * 0.95f)) goto L5;
        boolean r106 = true;
    L6:
        this.f526728d = r106;     // Catch: Exception -> L8
        r100.put("apm_native_heap_size", this.f526727c);     // Catch: Exception -> L8
        r100.put("apm_java_heap_leak", this.f526728d);     // Catch: Exception -> L8
        r100.put("apm_java_heap_used", this.f526730f);     // Catch: Exception -> L8
        r100.put("apm_java_heap_max", this.f526729e);     // Catch: Exception -> L8
        return r100;
    L5:
        r106 = false;
    L8:
        return null;
    }

    public final String e() {
        String r100 = e.a(this.f526725a.toArray());
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        uu3.a r101 = (uu3.a) c.a(uu3.a.class);
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101.c();
    }

    public a() {
        this.f526725a = new CopyOnWriteArraySet();
        this.f526726b = new ConcurrentHashMap();
    }

    public final JSONObject c(boolean r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, String>> r102 = this.f526726b.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, String> r103 = r102.next();     // Catch: JSONException -> L11
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r101.put("RealRefreshRate", String.valueOf(i.f190674f));     // Catch: JSONException -> L11
        r101.put("RealMaxRefreshRate", String.valueOf(i.f190674f));     // Catch: JSONException -> L11
        if (r100 == false) goto L10;
        com.bytedance.apm.util.e r104 = com.bytedance.apm.util.e.a.f190668a;     // Catch: JSONException -> L11
        r104.b(r101, false);     // Catch: JSONException -> L11
        r104.a(r101, false);     // Catch: JSONException -> L11
    L10:
        return r101;
    }
}
