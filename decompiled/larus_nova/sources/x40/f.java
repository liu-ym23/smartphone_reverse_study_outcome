package x40;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, i> f562424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f562425b = null;

    static {
        f562424a = new LinkedHashMap();
        int r100 = b.f562422a;
        f562425b = CollectionsKt.listOf(new String[]{"top_right_banner", "bottom_banner", "short_touch"});
    }

    public static void b(Long r100) {
        if (h.a().booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<T> r101 = f562425b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        a((String) r101.next(), r100, "OPEN_LIVE_SCHEMA_END");
        goto L7
    }

    public static Map c(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "activityType");
        if (h.a().booleanValue() == true) goto L19;
        return null;
    L19:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        Map<String, i> r103 = f562424a;     // Catch: Throwable -> L16
        i r104 = (i) ((LinkedHashMap) r103).get(r100);     // Catch: Throwable -> L16
        if (r104 == null) goto L8;
        Long r105 = r104.f562427a;     // Catch: Throwable -> L16
    L9:
        if (r105 != null) goto L11;
    L14:
        r103.put(r100, null);     // Catch: Throwable -> L16
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        return null;
    L11:
        if (Intrinsics.areEqual(r104.f562427a, r101) == false) goto L14;
        return r104.f562428b;
    L8:
        r105 = null;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static void a(String r100, Long r101, String r102) {
        if (h.a().booleanValue() == true) goto L26;
        return;
    L26:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.longValue() <= 0) goto L28;
        Map<String, i> r104 = f562424a;     // Catch: Throwable -> L23
        i r105 = (i) ((LinkedHashMap) r104).get(r100);     // Catch: Throwable -> L23
        if (r105 == null) goto L13;
        Long r106 = r105.f562427a;     // Catch: Throwable -> L23
    L15:
        if (Intrinsics.areEqual(r106, r101) == false) goto L19;
        Map<String, Long> r107 = r105.f562428b;     // Catch: Throwable -> L23
        if (r107 == null) goto L19;
        r107.put(r102, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L23
    L20:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L19:
        r104.put(r100, new i(r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r102, Long.valueOf(System.currentTimeMillis()))})));     // Catch: Throwable -> L23
        goto L20
    L13:
        r106 = null;
        goto L15
    L28:
        return;
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
