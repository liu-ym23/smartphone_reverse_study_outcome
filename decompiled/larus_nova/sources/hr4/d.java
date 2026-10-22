package hr4;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f486876a = null;

    static {
        f486876a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("BitableEditorContext", "editCell error", (Throwable) r100, false);
    }
}
