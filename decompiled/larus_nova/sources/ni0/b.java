package ni0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f519217a;

    public b(a r100) {
        this.f519217a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f519217a.f519209e.run();
    }
}
