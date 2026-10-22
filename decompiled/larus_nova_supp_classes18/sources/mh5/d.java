package mh5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        tt5.a.d("DlpBannerCache", "writeToCache error " + ((Throwable) r3).getMessage());
    }
}
