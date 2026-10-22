package zh5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f572191a = null;

    static {
        f572191a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.f("PermissionOfflineCache", (Throwable) r100, false);
    }
}
