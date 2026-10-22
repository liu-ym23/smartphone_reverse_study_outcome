package lb;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f508287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f508288b;

    public g(h r100, Object r101) {
        this.f508287a = r100;
        this.f508288b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f508287a.f508289a.remove(this.f508288b);
    }
}
