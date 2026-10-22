package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n<T> f573348a = null;

    static {
        f573348a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiNodeOperationImpl", "IOperationUpdate, updateTitleAndIcon fail. " + ((Throwable) r100));
    }
}
