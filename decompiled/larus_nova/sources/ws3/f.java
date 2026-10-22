package ws3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, m> f560969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, m> f560970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f560972d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f560973a = null;

        static {
            f560973a = new f();
        }
    }

    public f() {
        this.f560971c = Math.min(3, 25);
        this.f560972d = 0;
    }

    public final synchronized void a(long r110, String r111, String r112) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.f560970b != null) goto L7;
        this.f560970b = new HashMap();     // Catch: Throwable -> L44
    L7:
        if (((HashMap) this.f560970b).containsKey(r111) == false) goto L11;
        m r113 = (m) ((HashMap) this.f560970b).get(r111);     // Catch: Throwable -> L44
        r113.f561034d++;     // Catch: Throwable -> L44
        r113.f561035e = System.currentTimeMillis();     // Catch: Throwable -> L44
        int r114 = r113.f561034d;     // Catch: Throwable -> L44
        if (r114 <= this.f560972d) goto L42;
        this.f560972d = r114;     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L11:
        Map<String, m> r100 = this.f560969a;     // Catch: Throwable -> L44
        if (r100 == null) goto L41;
        long r101 = Long.MAX_VALUE;
        String r102 = null;
        if (((HashMap) r100).containsKey(r111) == false) goto L31;
        m r115 = (m) ((HashMap) this.f560969a).get(r111);     // Catch: Throwable -> L44
        int r116 = r115.f561034d;     // Catch: Throwable -> L44
        r115.f561034d = r116 + 1;     // Catch: Throwable -> L44
        r115.f561035e = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r116 <= this.f560971c) goto L42;
        ((HashMap) this.f560969a).remove(r111);     // Catch: Throwable -> L44
        if (((HashMap) this.f560970b).size() < 20) goto L29;
        long r103 = ((System.currentTimeMillis() - 0) / 2) + 0;     // Catch: Throwable -> L44
        Iterator r117 = ((HashMap) this.f560970b).entrySet().iterator();     // Catch: Throwable -> L44
    L21:
        if (r117.hasNext() == false) goto L27;
        Map.Entry r118 = (Map.Entry) r117.next();     // Catch: Throwable -> L44
        if (((m) r118.getValue()).f561035e >= r103) goto L21;
        if (((m) r118.getValue()).f561034d >= r101) goto L21;
        r101 = ((m) r118.getValue()).f561034d;     // Catch: Throwable -> L44
        r102 = ((m) r118.getValue()).f561031a;     // Catch: Throwable -> L44
        goto L21
    L27:
        if (r102 == null) goto L29;
        ((HashMap) this.f560970b).remove(r102);     // Catch: Throwable -> L44
    L29:
        ((HashMap) this.f560970b).put(r111, r115);     // Catch: Throwable -> L44
        goto L42
    L31:
        if (((HashMap) this.f560969a).size() < 50) goto L40;
        Iterator r104 = ((HashMap) this.f560969a).entrySet().iterator();     // Catch: Throwable -> L44
    L34:
        if (r104.hasNext() == false) goto L38;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L44
        if (((m) r105.getValue()).f561035e >= r101) goto L34;
        r101 = ((m) r105.getValue()).f561035e;     // Catch: Throwable -> L44
        r102 = ((m) r105.getValue()).f561031a;     // Catch: Throwable -> L44
        goto L34
    L38:
        if (r102 == null) goto L40;
        ((HashMap) this.f560969a).remove(r102);     // Catch: Throwable -> L44
    L40:
        ((HashMap) this.f560969a).put(r111, new m(r111, r110, r112));     // Catch: Throwable -> L44
        goto L42
    L41:
        HashMap r106 = new HashMap();     // Catch: Throwable -> L44
        this.f560969a = r106;     // Catch: Throwable -> L44
        r106.put(r111, new m(r111, r110, r112));     // Catch: Throwable -> L44
        goto L42
    }
}
