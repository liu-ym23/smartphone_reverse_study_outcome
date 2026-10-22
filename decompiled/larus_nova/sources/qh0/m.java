package qh0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f532929a;

    public m(h r100) {
        this.f532929a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f532929a.f532921d.invoke();
    }
}
