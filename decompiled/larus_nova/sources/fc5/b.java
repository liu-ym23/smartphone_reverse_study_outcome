package fc5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Consumer<Throwable> {
    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.e("HyperLinkProcessorV2", "replace failed", r100, false);
    }
}
