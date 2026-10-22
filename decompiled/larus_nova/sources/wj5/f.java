package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f559991a = null;

    static {
        f559991a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DocMoreInfoBehavior", "objInfoFlow err. ", (Throwable) r100, false);
    }
}
