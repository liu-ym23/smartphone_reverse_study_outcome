package bqc;

import com.volcengine.zeus.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static volatile b b;
    public final List<a> a;

    public static b c() {
        if (b != null) goto L13;
        monitor-enter(b.class);
        b = new b();     // Catch: Throwable -> L9
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return b;
    }

    public b() {
        this.a = new ArrayList();
    }

    public final void a(i.b r3) {
        List<a> r0 = this.a;
        monitor-enter(r0);
        ((ArrayList) this.a).add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        List<a> r0 = this.a;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) this.a).iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        ((a) r1.next()).a(r4, r5, r6, r7);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
