package s05;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f540017a = null;

    static {
        f540017a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DComponent_BaseDocComponentImpl", "Get RouteService err resume!", (Throwable) r100, false);
    }
}
