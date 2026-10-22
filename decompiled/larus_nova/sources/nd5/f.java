package nd5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f518784a;

    public f(b r100) {
        this.f518784a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        c r101 = (c) r100;
        tt5.a.h("PermissionExecutor", "queryPermission success");
        b r102 = this.f518784a;
        Intrinsics.checkNotNull(r101);
        r102.a(r101);
    }
}
