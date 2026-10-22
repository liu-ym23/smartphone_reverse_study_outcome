package w25;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        tt5.a.e("PreloadNextPageExecutor", "startPreload comment fail", (Throwable) r4, false);
    }
}
