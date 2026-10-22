package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p<T> f573350a = null;

    static {
        f573350a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiNodeOperationImpl", "IOperationUpdate, updateToken fail. " + ((Throwable) r100));
    }
}
