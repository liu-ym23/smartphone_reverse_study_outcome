package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public static final f<T> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocMoreInfoBehavior", "objInfoFlow err. ", (Throwable) r4, false);
    }
}
