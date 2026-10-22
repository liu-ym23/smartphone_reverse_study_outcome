package n35;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ m a;

    public o(m r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.d(this.a.b, "docResourceDataSaveSuccess()...error = " + ((Throwable) r4));
    }
}
