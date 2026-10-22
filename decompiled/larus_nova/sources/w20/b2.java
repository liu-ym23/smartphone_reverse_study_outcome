package w20;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b2 {
    public static final List<String> a(y9 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dataEx");
        List<String> r101 = r100.getData();
        if (r101 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.toList(r101);
    }
}
