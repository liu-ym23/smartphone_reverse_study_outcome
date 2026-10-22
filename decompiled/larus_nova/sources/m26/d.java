package m26;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f511668a = null;

    static {
        f511668a = new d();
    }

    public d() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        r100.run();
    }
}
