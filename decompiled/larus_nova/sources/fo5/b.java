package fo5;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478125a;

    public b(String r100) {
        this.f478125a = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new a(r100, this.f478125a + "_0", 10);
    }
}
