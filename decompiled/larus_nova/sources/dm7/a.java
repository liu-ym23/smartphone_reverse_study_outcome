package dm7;

import com.bytedance.ug.sdk.luckydog.task.newTimer.b;
import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import zm7.c;
import zm7.g;
import zm7.k;
import zm7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<c> f469221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<g> f469222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f469223c;

    @Override // zm7.k
    public final m a() {
        return this.f469223c;
    }

    public a(m r100) {
        this.f469223c = r100;
        this.f469221a = new ConcurrentLinkedQueue();
        this.f469222b = new ConcurrentLinkedQueue();
    }

    @Override // zm7.k
    public final boolean b(b r100) {
        ConcurrentLinkedQueue<c> r101 = this.f469221a;
        monitor-enter(r101);
        boolean r102 = !this.f469221a.contains(r100);     // Catch: Throwable -> L9
        if (r102 == false) goto L7;
        this.f469221a.add(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public final void c(LuckyTimerStatus r100) {
        Iterator<T> r101 = this.f469221a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).a(r100);
        goto L4
    }
}
