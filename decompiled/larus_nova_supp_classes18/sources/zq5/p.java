package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Consumer {
    public static final p<T> a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final void accept(Object r3) {
        tt5.a.d("WikiNodeOperationImpl", "IOperationUpdate, updateToken fail. " + ((Throwable) r3));
    }
}
