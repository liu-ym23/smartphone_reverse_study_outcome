package ngc;

import com.bytedance.bpea.basics.Cert;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Callable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cert f519090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f519091b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        return Integer.valueOf(this.f519091b.f519095b.start(this.f519090a));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() throws Exception {
        return call();
    }

    public d(f r100, Cert r101) {
        this.f519091b = r100;
        this.f519090a = r101;
    }
}
