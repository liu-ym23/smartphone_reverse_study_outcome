package exc;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements c.a, Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f474745c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<String> f474746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f474747b;

    @Override // java.lang.Runnable
    public final void run() {
    }

    public a() {
        this.f474746a = new LinkedBlockingQueue();
    }
}
