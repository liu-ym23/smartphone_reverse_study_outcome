package u82;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f549174a = null;

    static {
        f549174a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
