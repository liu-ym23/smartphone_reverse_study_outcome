package es3;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f473750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f473751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f473752c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f473752c.f473721d).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((com.bytedance.apm.block.a) r100.next()).e(ActivityLifeObserver.getInstance().getTopActivityClassName(), this.f473750a, this.f473751b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public i(h r100, long r101, long r102) {
        this.f473752c = r100;
        this.f473750a = r101;
        this.f473751b = r102;
    }
}
