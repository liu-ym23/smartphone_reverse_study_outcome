package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u<T> f560012a = null;

    static {
        f560012a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DocShortcutMoreInfoBehavior", "getNode err. ", (Throwable) r100, false);
    }
}
