package lc5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r3) {
        tt5.a.k("ListAnalysis", "reportFolderOpenClick error: " + ((Throwable) r3).getMessage());
    }
}
