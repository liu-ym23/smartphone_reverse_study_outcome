package fe3;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.shopping.deepfeed.data.repo.h;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f476570a;

    public c(h r100) {
        this.f476570a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    L3:
        if (b.f476569d == true) goto L6;
        MessageQueue r100 = Looper.myQueue();     // Catch: Throwable -> L8
        b.a r101 = b.f476567b;     // Catch: Throwable -> L8
        r100.removeIdleHandler(r101);     // Catch: Throwable -> L8
        Looper.myQueue().addIdleHandler(r101);     // Catch: Throwable -> L8
        b.f476569d = true;     // Catch: Throwable -> L8
    L6:
        a r102 = this.f476570a;     // Catch: Throwable -> L8
        String r103 = r102.f476564a;     // Catch: Throwable -> L8
        b.f476568c.offer(r102);     // Catch: Throwable -> L8
    }
}
