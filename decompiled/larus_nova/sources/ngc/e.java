package ngc;

import com.bytedance.bpea.basics.Cert;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Callable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cert f519092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f519093b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        return Integer.valueOf(this.f519093b.f519095b.stop(this.f519092a));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() throws Exception {
        return call();
    }

    public e(f r100, Cert r101) {
        this.f519093b = r100;
        this.f519092a = r101;
    }
}
