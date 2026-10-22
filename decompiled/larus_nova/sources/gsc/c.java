package gsc;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.ktor.http.parsing.d;
import io.ktor.http.parsing.f;
import io.ktor.http.parsing.g;
import io.ktor.http.parsing.h;
import io.ktor.http.parsing.j;
import io.ktor.http.parsing.k;
import io.ktor.http.parsing.m;
import io.ktor.http.parsing.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final a a(d r100, Map<String, List<Integer>> r101, int r102, boolean r110) {
        int r103 = 0;
        if ((r100 instanceof n) == false) goto L6;
        return new a(Regex.Companion.escape(((n) r100).f491903a), 0, 6);
    L6:
        if ((r100 instanceof k) == false) goto L9;
        return new a(((k) r100).f491901a, 0, 6);
    L9:
        if ((r100 instanceof g) == false) goto L15;
        ((g) r100).getClass();
        a r104 = b(null, r101, r102 + 1, 4);
        if (r101.containsKey(null) == true) goto L13;
        r101.put(null, new ArrayList());
    L13:
        Integer r105 = Integer.valueOf(r102);
        Object r106 = ((LinkedHashMap) r101).get(null);
        Intrinsics.checkNotNull(r106);
        ((Collection) r106).add(r105);
        return new a(r104.f482483a, r104.f482484b, true);
    L15:
        if ((r100 instanceof io.ktor.http.parsing.c) == false) goto L37;
        StringBuilder r107 = new StringBuilder();
        if (r110 == false) goto L19;
        int r108 = r102 + 1;
    L20:
        Iterator<T> r109 = ((io.ktor.http.parsing.c) r100).a().iterator();
    L22:
        if (r109.hasNext() == false) goto L32;
        Object r111 = r109.next();
        int r112 = r103 + 1;
        if (r103 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        a r113 = a((d) r111, r101, r108, true);
        if (r103 == 0) goto L31;
        if ((r100 instanceof h) == false) goto L31;
        r107.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L31:
        r107.append(r113.f482483a);
        r108 = r108 + r113.f482484b;
        r103 = r112;
        goto L22
    L32:
        int r114 = r108 - r102;
        if (r110 == false) goto L63;
        r114 = r114 - 1;
    L63:
        return new a(r107.toString(), r114, r110);
    L19:
        r108 = r102;
        goto L20
    L37:
        if ((r100 instanceof m) == false) goto L48;
        if ((r100 instanceof f) == false) goto L42;
        char r115 = '?';
    L44:
        a r116 = a(((m) r100).b(), r101, r102, true);
        return new a(r116.f482483a + r115, r116.f482484b, 4);
    L42:
        if ((r100 instanceof io.ktor.http.parsing.b) == false) goto L46;
        r115 = '+';
        goto L44
    L46:
        throw new IllegalStateException(("Unsupported simple grammar element: " + r100).toString());
    L48:
        if ((r100 instanceof io.ktor.http.parsing.a) == false) goto L51;
        StringBuilder r117 = new StringBuilder("[");
        Regex.Companion r118 = Regex.Companion;
        ((io.ktor.http.parsing.a) r100).getClass();
        r117.append(r118.escape(null));
        r117.append(']');
        return new a(r117.toString(), 0, 6);
    L51:
        if ((r100 instanceof j) == false) goto L55;
        StringBuilder r119 = new StringBuilder("[");
        j r120 = (j) r100;
        r119.append(r120.f491899a);
        r119.append('-');
        r119.append(r120.f491900b);
        r119.append(']');
        return new a(r119.toString(), 0, 6);
    L55:
        throw new IllegalStateException(("Unsupported grammar element: " + r100).toString());
    }

    public static /* synthetic */ a b(h r100, Map r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 1;
    L6:
        return a(r100, r101, r102, false);
    }
}
