package fo5;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ThreadFactory {
    public final String a;

    public b(String r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        return new a(r4, this.a + "_0", 10);
    }
}
