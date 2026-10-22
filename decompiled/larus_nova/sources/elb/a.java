package elb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageUploadTask f473035a;

    public a(ImageUploadTask r100) {
        this.f473035a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.ss.android.lark.image.uploader.utils.c.f426438a;     // Catch: Throwable -> L4
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "startUploadTask async: " + this.f473035a);     // Catch: Throwable -> L4
        ExecutorService r101 = b.f473036a;     // Catch: Throwable -> L4
        b.a(this.f473035a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
