package tl5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public static final j<T> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r3) {
        int r0 = h.b;
        tt5.a.f("SendDataToNativeHandler", (Throwable) r3, false);
    }
}
