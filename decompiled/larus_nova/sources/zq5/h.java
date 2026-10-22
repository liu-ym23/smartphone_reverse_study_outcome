package zq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f573342a = null;

    static {
        f573342a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiNodeMakeCopyOperationImpl", "IOperationMakeCopy, makeCopyToWiki fail. " + ((Throwable) r100));
    }
}
