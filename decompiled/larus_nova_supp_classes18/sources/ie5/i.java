package ie5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public static final i<T> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r4) {
        tt5.a.e("RoutePageUtils", "open Browser fail", (Throwable) r4, false);
    }
}
