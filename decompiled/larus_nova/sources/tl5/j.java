package tl5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f546634a = null;

    static {
        f546634a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = h.f546630b;
        tt5.a.f("SendDataToNativeHandler", (Throwable) r100, false);
    }
}
