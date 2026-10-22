package p40;

import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l40.a f527635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DraggableComponentState.Style f527636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f527637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f527638d;

    public b(l40.a r100, DraggableComponentState.Style r101, int r102, a r103) {
        this.f527635a = r100;
        this.f527636b = r101;
        this.f527637c = r102;
        this.f527638d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f527638d.p(this.f527635a, this.f527636b, this.f527637c, UGCMonitor.TYPE_POST);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
