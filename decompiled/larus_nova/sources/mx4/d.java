package mx4;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f516218a;

    public d(a r100) {
        this.f516218a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        this.f516218a.f516212h.c();
    }
}
