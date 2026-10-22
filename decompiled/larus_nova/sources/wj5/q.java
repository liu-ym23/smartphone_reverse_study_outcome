package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<T> f560008a = null;

    static {
        f560008a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DocShortcutMoreInfoBehavior", "metaFlow err. ", (Throwable) r100, false);
    }
}
