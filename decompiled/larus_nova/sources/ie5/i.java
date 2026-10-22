package ie5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f489485a = null;

    static {
        f489485a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("RoutePageUtils", "open Browser fail", (Throwable) r100, false);
    }
}
