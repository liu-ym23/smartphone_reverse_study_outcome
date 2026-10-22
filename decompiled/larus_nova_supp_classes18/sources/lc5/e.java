package lc5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r4) {
        tt5.a.e("ListAnalysis", "reportOfflineCacheEvent ", (Throwable) r4, false);
    }
}
