package zc1;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Function<Observable<Throwable>, ObservableSource<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f571233a;

    public d() {
        this.f571233a = 1;
    }

    @Override // io.reactivex.functions.Function
    public final ObservableSource<?> apply(Observable<Throwable> r100) throws Exception {
        return r100.flatMap(new c(this));
    }
}
