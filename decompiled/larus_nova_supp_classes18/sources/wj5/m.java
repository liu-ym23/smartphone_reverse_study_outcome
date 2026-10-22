package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Consumer {
    public static final m<T> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocShortcutMoreInfoBehavior", "docPermissionFlow err. ", (Throwable) r4, false);
    }
}
