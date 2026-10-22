package na3;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f518449a = null;

    static {
        f518449a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        dm.a.a("BuyNowPrefetcher").a("prefetch api on error " + ((Throwable) r100).getCause());
    }
}
