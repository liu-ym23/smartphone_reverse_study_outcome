package ts7;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements ThreadFactory {
    public d() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Thread r101 = new Thread(r100);
        r101.setPriority(1);
        return r101;
    }
}
