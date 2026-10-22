package li5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public static final k<T> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r3) {
        tt5.a.d("DocPermissionManager", "sendNotifyRequest()...failed: " + ((Throwable) r3));
    }
}
