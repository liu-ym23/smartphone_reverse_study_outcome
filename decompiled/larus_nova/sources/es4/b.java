package es4;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f473770a = null;

    static {
        f473770a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("LinkFieldPropertyEditViewHolderV2", "asyncFilterOptions error: " + ((Throwable) r100));
    }
}
