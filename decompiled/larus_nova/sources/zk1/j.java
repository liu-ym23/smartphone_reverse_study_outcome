package zk1;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f572601a;

    public j(h r100) {
        this.f572601a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        h.b r102 = this.f572601a.f572591l;
        if (r102 == null) goto L6;
        r102.onError();
        return;
    }
}
