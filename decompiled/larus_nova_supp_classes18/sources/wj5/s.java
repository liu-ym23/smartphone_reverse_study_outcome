package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s<T> implements Consumer {
    public static final s<T> a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocShortcutMoreInfoBehavior", "objInfoFlow err. ", (Throwable) r4, false);
    }
}
