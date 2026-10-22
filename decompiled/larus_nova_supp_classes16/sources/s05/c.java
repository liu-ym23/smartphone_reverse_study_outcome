package s05;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DComponent_BaseDocComponentImpl", "Get RouteService err resume!", (Throwable) r4, false);
    }
}
