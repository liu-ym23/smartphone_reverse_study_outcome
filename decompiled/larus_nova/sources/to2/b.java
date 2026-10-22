package to2;

import com.bytedance.android.livesdkapi.player.preload.model.PlayerPreloadRequest;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerPreloadRequest f546904a;

    public b(PlayerPreloadRequest r100) {
        this.f546904a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new a.CallableC7749a(this.f546904a).call();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
