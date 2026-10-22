package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f573346a = null;

    static {
        f573346a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiNodeMoveOperationImpl", "IOperationMove, moveToWiki fail. " + ((Throwable) r100));
    }
}
