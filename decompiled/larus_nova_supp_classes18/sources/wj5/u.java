package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u<T> implements Consumer {
    public static final u<T> a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocShortcutMoreInfoBehavior", "getNode err. ", (Throwable) r4, false);
    }
}
