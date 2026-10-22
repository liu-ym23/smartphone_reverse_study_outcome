package qp7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<j> f534350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f534351b;

    public b() {
        this.f534350a = new ArrayList();
        this.f534351b = new ArrayList();
    }

    public final synchronized void a(a r100, c r101) {
        monitor-enter(this);
        this.f534350a.add(r100);     // Catch: Throwable -> L6
        this.f534351b.add(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(a r100, rp7.g r101) {
        monitor-enter(this);
        int r102 = this.f534350a.indexOf(r100);     // Catch: Throwable -> L12
        if (r102 >= 0) goto L6;
    L10:
        monitor-exit(this);
        return;
    L6:
        if (r101 != ListProtector.get(this.f534351b, r102)) goto L10;
        ListProtector.remove(this.f534350a, r102);     // Catch: Throwable -> L12
        ListProtector.remove(this.f534351b, r102);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
