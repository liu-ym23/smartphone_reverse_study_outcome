package rt3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile d f539191f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<e> f539192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f539193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f539194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f539195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f539196e;

    static {
        f539191f = new d();
    }

    public d() {
        this.f539192a = new HashSet();
        this.f539194c = 80;
        this.f539195d = 5;
        this.f539196e = -1;
    }

    public final synchronized void a(e r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        ((HashSet) this.f539192a).add(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b(int r100, int r101, int r102) {
        if (r100 <= 0) goto L12;
        if (r101 <= 0) goto L14;
        this.f539194c = r100;
        this.f539195d = r101;
        int r103 = -1;
        if (r102 == (-1)) goto L8;
        r103 = Math.max(r102, 80);
    L8:
        this.f539196e = r103;
        if (xu3.a.a() == false) goto L13;
        List<String> r104 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "weed out config:maxSizeMB:" + r100 + " keepDays:" + r101);
        return;
    L13:
        return;
    L14:
        return;
    }
}
