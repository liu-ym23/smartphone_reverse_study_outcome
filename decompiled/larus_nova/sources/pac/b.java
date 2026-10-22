package pac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.videosend.checker.VideoSendChecker;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f528405a;

    public b(VideoSendChecker.d r100) {
        this.f528405a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f528405a.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
