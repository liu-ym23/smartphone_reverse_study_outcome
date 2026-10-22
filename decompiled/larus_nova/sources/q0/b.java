package q0;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.l;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes28.dex */
public final class b implements Callable<l<LottieComposition>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f531155a;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public l<LottieComposition> call() throws Exception {
        return this.f531155a.b();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ l<LottieComposition> call() throws Exception {
        return call();
    }

    public b(c r100) {
        this.f531155a = r100;
    }
}
