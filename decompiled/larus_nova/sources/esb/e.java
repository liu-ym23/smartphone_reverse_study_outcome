package esb;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.monitor.i;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f473820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f473821b;

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(final int r100) {
        if (r100 >= 15) goto L5;
        return;
    L5:
        ExecutorService r101 = CoreThreadPool.getDefault().getCachedThreadPool();
        final i r102 = this.f473820a;
        r101.execute(new c(this, r100, r102));
    }

    public e(b r100, i r101) {
        this.f473821b = r100;
        this.f473820a = r101;
    }
}
