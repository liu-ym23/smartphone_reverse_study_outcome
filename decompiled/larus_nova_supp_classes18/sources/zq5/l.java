package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public static final l<T> a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r3) {
        tt5.a.d("WikiNodeMoveOperationImpl", "IOperationMove, moveToWiki fail. " + ((Throwable) r3));
    }
}
