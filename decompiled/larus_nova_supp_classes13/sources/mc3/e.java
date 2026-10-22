package mc3;

import com.bytedance.android.shopping.commentv3.data.SortType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final Map<String, Object> a;

    public final SortType a() {
        SortType.a r0 = SortType.Companion;
        Map<String, Object> r1 = this.a;
        SortType r2 = SortType.DEFAULT;
        int r3 = nc3.a.b(r1, "sort_type", r2.getType());
        r0.getClass();
        SortType r4 = SortType.LATEST;
        if (r3 == r4.getType()) goto L5;
        return r2;
    L5:
        return r4;
    }

    public e(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
    }
}
