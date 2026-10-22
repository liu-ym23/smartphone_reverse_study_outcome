package nd5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f518785a;

    public g(b r100) {
        this.f518785a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.d("PermissionExecutor", "queryPermission error: " + r101.getMessage());
        b r102 = this.f518785a;
        Intrinsics.checkNotNull(r101);
        r102.onError(r101);
    }
}
