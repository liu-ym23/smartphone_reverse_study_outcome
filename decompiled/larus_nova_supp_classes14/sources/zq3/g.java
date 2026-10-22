package zq3;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final List<Float> a = null;
    public static final List<Float> b = null;
    public static final List<Float> c = null;

    static {
        Float r2 = Float.valueOf(16.0f);
        a = CollectionsKt.listOf(new Float[]{r2, r2, r2, r2});
        Float r3 = Float.valueOf(8.0f);
        b = CollectionsKt.listOf(new Float[]{r2, r2, r3, r3});
        c = CollectionsKt.listOf(new Float[]{r3, r3, r3, r3});
    }

    public static List a(int r1, boolean r2, Integer r3) {
        if (r1 != 210) goto L15;
        if (r2 == true) goto L16;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L11:
        if (r4 > 2) goto L14;
        return b;
    L14:
        return c;
    L9:
        r4 = 1;
        goto L11
    L16:
        return a;
    L15:
        return CollectionsKt.emptyList();
    }
}
