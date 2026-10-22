package n62;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f518124a;

    public d(c r100) {
        this.f518124a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        c r100 = this.f518124a;
        r100.f518113g.removeListener(r100);
    }
}
