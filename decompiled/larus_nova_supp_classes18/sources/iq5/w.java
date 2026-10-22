package iq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w<T> implements Consumer {
    public static final w<T> a = null;

    static {
        a = new w();
    }

    public w() {
    }

    public final void accept(Object r4) {
        tt5.a.e("RootSelectView", "isVisible, fetch MyLibrary ID failed", (Throwable) r4, false);
    }
}
