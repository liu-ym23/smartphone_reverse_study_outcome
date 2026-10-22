package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocMoreInfoBehavior", "manualOfflineFlow err. ", (Throwable) r4, false);
    }
}
