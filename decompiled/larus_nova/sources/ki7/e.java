package ki7;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f503644a;

    public e() {
        this.f503644a = VideoThumbInfo.KEY_INTERVAL;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f503644a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
