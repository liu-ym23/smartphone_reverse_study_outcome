package od7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ld7.h;
import ld7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p f522853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static p f522854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, h> f522855c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, ? extends Map<String, ? extends Object>> f522856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<String, ? extends Map<String, ? extends Object>> f522857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f522858f = null;

    static {
        new String[]{"dy_search", "unknown"};
        Intrinsics.checkNotNullParameter(CollectionsKt.emptyList(), "forceDegradeCodeList");
        f522853a = new p(false, false, 7);
        f522855c = new LinkedHashMap();
        List r100 = CollectionsKt.listOf(new String[]{"1128", "2329", "8663"});
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        String r104 = (String) r103;
        r101.put(r103, 1);
        goto L4
    L6:
        f522858f = r101;
    }
}
