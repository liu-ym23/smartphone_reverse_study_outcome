package dv7;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class u implements Executor {
    public u() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        r100.run();
    }
}
