package uu5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Consumer<Throwable> {
    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.m("FlowableWrapper", r100);
    }
}
