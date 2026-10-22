package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public static final h<T> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocMoreInfoBehavior", "permFlow err. ", (Throwable) r4, false);
    }
}
