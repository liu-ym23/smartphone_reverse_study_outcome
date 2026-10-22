package nd5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ b a;

    public g(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.d("PermissionExecutor", "queryPermission error: " + r4.getMessage());
        b r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.onError(r4);
    }
}
