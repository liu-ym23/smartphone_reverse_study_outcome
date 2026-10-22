package zq3;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Float> f573301a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Float> f573302b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Float> f573303c = null;

    static {
        Float r100 = Float.valueOf(16.0f);
        f573301a = CollectionsKt.listOf(new Float[]{r100, r100, r100, r100});
        Float r101 = Float.valueOf(8.0f);
        f573302b = CollectionsKt.listOf(new Float[]{r100, r100, r101, r101});
        f573303c = CollectionsKt.listOf(new Float[]{r101, r101, r101, r101});
    }

    public static List a(int r100, boolean r101, Integer r102) {
        if (r100 != 210) goto L15;
        if (r101 == true) goto L16;
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L11:
        if (r103 > 2) goto L14;
        return f573302b;
    L14:
        return f573303c;
    L9:
        r103 = 1;
        goto L11
    L16:
        return f573301a;
    L15:
        return CollectionsKt.emptyList();
    }
}
