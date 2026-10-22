package up9;

import kotlin.jvm.internal.Intrinsics;
import up9.j0;

/* JADX INFO: loaded from: classes31.dex */
public final class x<S extends j0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f551151a;

    public x() {
    }

    public final S a() {
        S r100 = this.f551151a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentState");
        return null;
    L6:
        return r100;
    }
}
