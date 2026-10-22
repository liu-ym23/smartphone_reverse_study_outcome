package up4;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f551041a = null;

    static {
        f551041a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("LinkTableRecordPickerPresenter", "fetchLinkTableIfNeed()... fetchLinkTable failed, e = " + ((Throwable) r100));
    }
}
