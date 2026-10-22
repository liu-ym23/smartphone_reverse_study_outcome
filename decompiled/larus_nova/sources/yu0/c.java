package yu0;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f569217a;

    public c(Disposable r100) {
        this.f569217a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f569217a.dispose();
    }
}
