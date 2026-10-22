package iq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w<T> f495381a = null;

    static {
        f495381a = new w();
    }

    public w() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("RootSelectView", "isVisible, fetch MyLibrary ID failed", (Throwable) r100, false);
    }
}
