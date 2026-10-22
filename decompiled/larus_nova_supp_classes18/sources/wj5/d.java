package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocMoreInfoBehavior", "metaFlow err. ", (Throwable) r4, false);
    }
}
