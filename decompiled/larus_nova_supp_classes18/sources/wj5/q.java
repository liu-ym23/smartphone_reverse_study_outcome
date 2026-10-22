package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q<T> implements Consumer {
    public static final q<T> a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocShortcutMoreInfoBehavior", "metaFlow err. ", (Throwable) r4, false);
    }
}
