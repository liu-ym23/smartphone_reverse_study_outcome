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

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static final String a(List<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLogString");
        List<?> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if ((r104 instanceof c) == false) goto L8;
        String r105 = c((c) r104);
    L9:
        r102.add(r105);
        goto L4
    L8:
        r105 = String.valueOf(r104);
        goto L9
    L11:
        return r102.toString();
    }

    public static final String b(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLogString");
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (Intrinsics.areEqual(r105, Boolean.valueOf(r105 instanceof c)) == false) goto L8;
        String r106 = c((c) r105);
    L9:
        r101.put(r104, r106);
        goto L4
    L8:
        r106 = String.valueOf(r105);
        goto L9
    L11:
        return r101.toString();
    }

    public static final String c(c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLogString");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(l97.a.f508113a.toJson(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r102) == true) goto L10;
        return "";
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        String r103 = (String) r102;
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
