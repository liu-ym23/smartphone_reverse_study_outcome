package nw3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f520947a;

    public b(Handler r100) {
        this.f520947a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (this.f520947a.getLooper() != Looper.myLooper()) goto L5;
        r100.run();
        return;
    L5:
        this.f520947a.post(r100);
    }
}
