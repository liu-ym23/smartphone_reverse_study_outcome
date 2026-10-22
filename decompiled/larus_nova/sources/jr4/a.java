package jr4;

import com.bytedance.ee.bear.bitable.chameleon.render.fetcher.BaseAppClientVarsFetcher;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes15.dex */
public final class a<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseAppClientVarsFetcher f500114a;

    public a(BaseAppClientVarsFetcher r100) {
        this.f500114a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.ee.bear.bitable.rust.c.a call() {
        com.bytedance.ee.bear.bitable.rust.c r100 = com.bytedance.ee.bear.bitable.rust.c.f215261a;
        String r101 = this.f500114a.f209739c;
        r100.getClass();
        return com.bytedance.ee.bear.bitable.rust.c.a(r101);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
