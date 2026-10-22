package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T> implements Consumer {
    public static final n<T> a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final void accept(Object r3) {
        tt5.a.d("WikiNodeOperationImpl", "IOperationUpdate, updateTitleAndIcon fail. " + ((Throwable) r3));
    }
}
