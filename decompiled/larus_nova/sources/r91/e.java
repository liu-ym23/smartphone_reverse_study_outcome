package r91;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements w91.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Disposable f536702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f536703b = null;

    public e() {
    }

    @Override // w91.a
    public final int a() {
        return 0;
    }

    @Override // w91.a
    public final boolean b(w91.a.InterfaceC8082a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return false;
    }

    @Override // w91.a
    public final boolean c(w91.a.InterfaceC8082a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return false;
    }

    @Override // w91.a
    public final void d() {
    }

    @Override // w91.a
    public final boolean e(w91.a.InterfaceC8082a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return false;
    }

    static {
        f536703b = new e();
        f536702a = Disposables.empty();
    }

    @Override // w91.a
    public final Disposable execute() {
        return f536702a;
    }
}
