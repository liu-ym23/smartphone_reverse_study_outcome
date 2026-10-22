package am2;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t {
    public static final String[] i = null;
    public long a;
    public final Map<Long, String> b;
    public final Map<Long, String> c;
    public final Map<Long, String> d;
    public final Map<Long, String> e;
    public String f;
    public String g;
    public String h;

    public static final class a {
    }

    static {
        i = new String[]{"is_recommend", "channel_id", "is_default_search", "previous_page"};
    }

    public final Map<String, String> b() {
        String r0 = this.f;
        HashMap r1 = new HashMap();
        Iterator r2 = GsonHelper.parser().parse(r0).getAsJsonObject().entrySet().iterator();     // Catch: Throwable -> L8
    L5:
        if (r2.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Throwable -> L8
        r1.put(r3.getKey(), ((JsonElement) r3.getValue()).getAsString());     // Catch: Throwable -> L8
    L11:
        return Collections.synchronizedMap(r1);
    L8:
        th = move-exception;
        th.getMessage();
        goto L11
    }

    public t() {
        this.b = Collections.synchronizedMap(new HashMap());
        this.c = Collections.synchronizedMap(new HashMap());
        this.d = Collections.synchronizedMap(new HashMap());
        this.e = Collections.synchronizedMap(new HashMap());
    }

    public final Map<Long, String> a() {
        return this.c;
    }

    public final String c() {
        return this.f;
    }

    public final Map<Long, String> d() {
        return this.d;
    }

    public final Map<Long, String> e() {
        return this.b;
    }

    public final void f(String r1) {
        this.h = r1;
    }

    public final void g(String r1) {
        this.f = r1;
    }
}
