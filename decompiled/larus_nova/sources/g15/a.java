package g15;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Singleton
public final class a implements rw4.d {
    @Inject
    public a() {
    }

    @Override // rw4.d
    public final void Z(rw4.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    @Override // rw4.d
    public final void j1(rw4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }
}
