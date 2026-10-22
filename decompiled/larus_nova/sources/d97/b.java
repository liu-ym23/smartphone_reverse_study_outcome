package d97;

import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Long> f467623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f467624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f467625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f467626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<String[]> f467627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<long[]> f467628f;

    public b() {
        this.f467623a = new HashMap();
        this.f467624b = new HashMap();
        this.f467627e = new LinkedList();
        this.f467628f = new LinkedList();
    }

    public final void a(String r100) {
        if (r100.equals(this.f467626d) == false) goto L11;
        long r101 = System.currentTimeMillis() - this.f467625c;
        if (this.f467623a.containsKey(r100) == true) goto L7;
    L9:
        this.f467623a.put(r100, Long.valueOf(r101));
    L13:
        this.f467626d = null;
        return;
    L7:
        if (r101 >= this.f467623a.get(r100).longValue()) goto L9;
        return;
    L11:
        if (this.f467624b.isEmpty() == false) goto L13;
        this.f467624b.put("last", this.f467626d);
        this.f467624b.put("current", r100);
        goto L13
    }

    public final void b(String r100) {
        this.f467625c = System.currentTimeMillis();
        this.f467626d = r100;
    }
}
