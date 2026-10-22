package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public static final h<T> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        tt5.a.d("WikiNodeMakeCopyOperationImpl", "IOperationMakeCopy, makeCopyToWiki fail. " + ((Throwable) r3));
    }
}
