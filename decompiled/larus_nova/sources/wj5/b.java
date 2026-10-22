package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f559987a = null;

    static {
        f559987a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DocMoreInfoBehavior", "manualOfflineFlow err. ", (Throwable) r100, false);
    }
}
