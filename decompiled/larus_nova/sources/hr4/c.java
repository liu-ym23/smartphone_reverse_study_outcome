package hr4;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f486875a = null;

    static {
        f486875a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        tt5.a.h("BitableEditorContext", "editCell success");
    }
}
