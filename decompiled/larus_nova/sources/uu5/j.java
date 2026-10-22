package uu5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements Consumer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.a f551762a;

    public j(m.a r100) {
        this.f551762a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) throws Exception {
        if (this.f551762a == null) goto L6;
        tt5.a.b("SampleFlowableWrapper", "onSubscribe: " + r100);
        this.f551762a.onSubscribe(r100);
        return;
    }
}
