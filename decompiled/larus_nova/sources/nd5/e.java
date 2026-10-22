package nd5;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements nc5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f518783a;

    @Override // nc5.b
    public final void cancel() {
        tt5.a.h("PermissionExecutor", "queryPermission cancel");
        this.f518783a.dispose();
    }

    public e(Disposable r100) {
        this.f518783a = r100;
    }
}
