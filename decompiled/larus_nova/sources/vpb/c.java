package vpb;

import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f556734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f556735b;

    public c(a r100, long r101) {
        this.f556734a = r100;
        this.f556735b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DecimalFormat r101 = f.f556745a;
        a r102 = this.f556734a;
        f.a("full", r102.f556718k, r102.f556708a, false, System.nanoTime() - this.f556735b, ((Throwable) r100).getMessage());
    }
}
