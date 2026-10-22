package cr0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f465031a = null;

    static {
        f465031a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.b("PreviewMiniGameContext", "preview page switch task fail: ", (Throwable) r100);
    }
}
