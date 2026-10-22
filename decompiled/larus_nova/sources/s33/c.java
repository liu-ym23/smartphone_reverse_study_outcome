package s33;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f540458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f540459b;

    public c() {
        this(null, 3);
    }

    public c(List r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r101 & 2) == 0) goto L8;
        List<String> r102 = CollectionsKt.emptyList();
    L9:
        Intrinsics.checkNotNullParameter(r100, "head");
        Intrinsics.checkNotNullParameter(r102, "end");
        this.f540458a = r100;
        this.f540459b = r102;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
