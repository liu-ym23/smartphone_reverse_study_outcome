package le1;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f508911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f508912b;

    public f(g r100, b r101) {
        this.f508911a = r100;
        this.f508912b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f508911a.d(this.f508912b);
    }
}
