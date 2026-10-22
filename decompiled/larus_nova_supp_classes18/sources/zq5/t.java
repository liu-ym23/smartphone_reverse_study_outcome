package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t<T> implements Consumer {
    public static final t<T> a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final void accept(Object r3) {
        tt5.a.d("WikiNodeShortcutOperationImpl", "IOperationShortcut, shortcutToWiki fail. " + ((Throwable) r3));
    }
}
