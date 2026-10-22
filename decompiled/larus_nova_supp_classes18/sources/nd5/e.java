package nd5;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements nc5.b {
    public final /* synthetic */ Disposable a;

    @Override // nc5.b
    public final void cancel() {
        tt5.a.h("PermissionExecutor", "queryPermission cancel");
        this.a.dispose();
    }

    public e(Disposable r1) {
        this.a = r1;
    }
}
