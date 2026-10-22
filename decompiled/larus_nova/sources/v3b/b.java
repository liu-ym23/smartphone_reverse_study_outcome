package v3b;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements d<w3b.a, i7b.a> {
    @Inject
    public b() {
    }

    @Override // v3b.d
    public final String a(w3b.d r100) {
        w3b.a r101 = (w3b.a) r100;
        Intrinsics.checkNotNullParameter(r101, "task");
        r101.getClass();
        return "ChatDataPreLoadTask_uniqueId:" + r101.f558211b;
    }
}
