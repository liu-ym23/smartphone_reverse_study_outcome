package ef2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final String a(List<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toLogString");
        List<?> r4 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r1 = r5.next();
        if ((r1 instanceof c) == false) goto L8;
        String r2 = c((c) r1);
    L9:
        r0.add(r2);
        goto L4
    L8:
        r2 = String.valueOf(r1);
        goto L9
    L11:
        return r0.toString();
    }

    public static final String b(Map<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toLogString");
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator<T> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) r5.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (Intrinsics.areEqual(r3, Boolean.valueOf(r3 instanceof c)) == false) goto L8;
        String r6 = c((c) r3);
    L9:
        r0.put(r2, r6);
        goto L4
    L8:
        r6 = String.valueOf(r3);
        goto L9
    L11:
        return r0.toString();
    }

    public static final String c(c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toLogString");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(l97.a.a.toJson(r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r3) == true) goto L10;
        return "";
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        String r4 = (String) r3;
        if (r4 != null) goto L16;
        return "";
    L16:
        return r4;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
