package nd5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        c r4 = (c) r3;
        tt5.a.h("PermissionExecutor", "queryPermission success");
        b r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.a(r4);
    }
}
