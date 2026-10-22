package wj5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public static final j<T> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DocMoreInfoBehavior", "ownerTypeFlow err. ", (Throwable) r4, false);
    }
}
