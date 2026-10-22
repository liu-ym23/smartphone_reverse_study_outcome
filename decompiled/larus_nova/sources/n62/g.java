package n62;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f518148a;

    public g(e r100) {
        this.f518148a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        e r100 = this.f518148a;
        r100.f518129j.removeListener(r100);
    }
}
