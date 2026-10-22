package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t<T> f573353a = null;

    static {
        f573353a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiNodeShortcutOperationImpl", "IOperationShortcut, shortcutToWiki fail. " + ((Throwable) r100));
    }
}
