package uu5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Consumer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f551753a;

    public a(d.a r100) {
        this.f551753a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) throws Exception {
        if (this.f551753a == null) goto L6;
        tt5.a.b("DebounceFlowableWrapper", "onSubscribe: " + r100);
        this.f551753a.onSubscribe(r100);
        return;
    }
}
