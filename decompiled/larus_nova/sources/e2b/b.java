package e2b;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f470851a;

    public /* synthetic */ b(h r100) {
        this.f470851a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final h r100 = this.f470851a;
        r100.getClass();
        ResourcePerfMonitor.IMAGE_SEND.onStart();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r100));
    }
}
