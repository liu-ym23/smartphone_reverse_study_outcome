package n35;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f516964a;

    public o(m r100) {
        this.f516964a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d(this.f516964a.f516956b, "docResourceDataSaveSuccess()...error = " + ((Throwable) r100));
    }
}
