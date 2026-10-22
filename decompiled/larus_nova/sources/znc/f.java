package znc;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements c<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f573045a;

    public f() {
        this.f573045a = 0;
    }

    @Override // znc.c
    public final Object a(m.d r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return r100.a(this.f573045a);
    }
}
