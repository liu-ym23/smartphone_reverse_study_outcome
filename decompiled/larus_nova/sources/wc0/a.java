package wc0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final String a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFirstUrl");
        List<String> r101 = r100.getUrls();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (String) ListProtector.get(r101, 0);
    }
}
