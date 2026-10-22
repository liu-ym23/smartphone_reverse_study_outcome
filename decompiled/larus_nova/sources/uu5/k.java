package uu5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements Consumer<Throwable> {
    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.m("SampleFlowableWrapper", r100);
    }
}
