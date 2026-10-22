package up5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        tt5.a.f("RxUtils", (Throwable) r3, false);
    }
}
