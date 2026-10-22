package na3;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r4) {
        dm.a.a("BuyNowPrefetcher").a("prefetch api on error " + ((Throwable) r4).getCause());
    }
}
