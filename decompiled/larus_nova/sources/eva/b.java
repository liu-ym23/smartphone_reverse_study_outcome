package eva;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class b implements a {
    @Inject
    public b() {
    }

    @Override // eva.a
    public final void beginSection(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
    }

    @Override // eva.a
    public final void endSection() {
    }
}
