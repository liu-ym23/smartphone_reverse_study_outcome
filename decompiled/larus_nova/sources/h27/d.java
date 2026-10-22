package h27;

import com.bytedance.mira.log.MiraLogger;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f483627c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f483628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f483629b;

    public static d a() {
        if (f483627c != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f483627c != null) goto L9;
        f483627c = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f483627c;
    }

    public d() {
        this.f483628a = new ConcurrentHashMap();
        this.f483629b = new ConcurrentHashMap();
    }

    public final boolean b(String r100) {
        int r101 = -1;
        if (this.f483628a.containsKey(r100) == false) goto L9;
        Integer r102 = this.f483628a.get(r100);
        if (r102 == null) goto L9;
        r101 = r102.intValue();
    L9:
        if (this.f483629b.containsKey(r100) == false) goto L14;
        Integer r103 = this.f483629b.get(r100);
        if (r103 == null) goto L14;
        int r104 = r103.intValue();
    L15:
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("interrupted check : stat = %d , flag = %d", new Object[]{Integer.valueOf(r101), Integer.valueOf(r104)}));
        if (r101 != 2) goto L18;
    L20:
        return true;
    L18:
        if (r101 == 4) goto L20;
        if (r104 > 1) goto L20;
        return false;
    L14:
        r104 = 0;
        goto L15
    }

    public final void c(String r100) {
        this.f483629b.remove(r100);
    }
}
