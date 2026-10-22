package mh5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f513959a = null;

    static {
        f513959a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("DlpBannerCache", "writeToCache error " + ((Throwable) r100).getMessage());
    }
}
